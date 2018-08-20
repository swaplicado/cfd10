/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mod.hrs.db;

import cfd.DCfdUtils;
import erp.cfd.SCfdConsts;
import erp.client.SClientInterface;
import erp.data.SDataConstantsSys;
import erp.gui.session.SSessionCustom;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.mhrs.data.SHrsPayrollEmployeeReceipt;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mtrn.data.SCfdPacket;
import erp.mtrn.data.SCfdUtils;
import erp.mtrn.data.SDataCfd;
import erp.server.SServerConstants;
import erp.server.SServerRequest;
import erp.server.SServerResponse;
import java.sql.ResultSet;
import java.util.ArrayList;
import sa.lib.SLibConsts;
import sa.lib.gui.SGuiSession;
import sa.lib.srv.SSrvConsts;

/**
 *
 * @author Irving Sánchez, Juan Barajas, Sergio Flores
 * 
 * Maintenance Log:
 * 2018-01-02, Sergio Flores:
 *  Implementation of payroll into CFDI 3.3.
 */
public abstract class SHrsCfdUtils {
    
    public static boolean canGenetareCfdReceipts(final SGuiSession session,  final int payrollId) throws Exception {
        String sql  = "";
        ResultSet resultSet = null;
        
        sql = "SELECT b_clo, b_del FROM hrs_pay WHERE id_pay = " + payrollId + "; ";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            if(!resultSet.getBoolean("b_clo")) {
                throw new Exception("No se pueden generar CFDI, la nómina no está cerrada.");
            }
            else if (resultSet.getBoolean("b_del")) {
                throw new Exception("No se pueden generar CFDI, la nómina no está eliminada.");
            }
        }
        validateReceiptsPendingCfdi(session, payrollId);
        return true;
    }
    
    public static ArrayList<SHrsPayrollEmployeeReceipt> getReceiptsPendig(final SGuiSession session,  final int payrollId) throws Exception {
        String sql  = "";
        SHrsPayrollEmployeeReceipt receipt;
        ArrayList<SHrsPayrollEmployeeReceipt> receipts = new ArrayList<SHrsPayrollEmployeeReceipt>();
        ResultSet resultSet = null;
        
        sql = "SELECT p.id_pay, p.per_year, p.per, p.num, p.dt_sta, p.dt_end, p.nts, p.fk_tp_pay, pr.id_emp, bp.bp, emp.num AS f_emp_num, "
                + "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = pr.id_emp) AS f_ear, "
                + "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = pr.id_emp) AS f_ded, "
                + "pei.id_iss, pei.num_ser, "
                + "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = pr.id_emp) - " 
                + "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = pr.id_emp) as f_tot, "
                + "pei.fk_tp_pay_sys, pei.dt_iss, pei.dt_pay " 
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON p.id_pay = pr.id_pay "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_ISS) + " AS pei ON "
                + "pr.id_pay = pei.id_pay AND pr.id_emp = pei.id_emp AND pei.b_del = 0 AND pei.fk_st_rcp = " + SModSysConsts.TRNS_ST_DPS_EMITED + " AND pei.id_iss = (SELECT pei1.id_iss FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_ISS) + " AS pei1 WHERE pei1.id_pay = pei.id_pay AND pei1.id_emp = pei.id_emp AND pei1.b_del = 0 ORDER BY pei1.id_iss DESC LIMIT 1) "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS emp ON emp.id_emp = pr.id_emp "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.BPSU_BP) + " AS bp ON bp.id_bp = emp.id_emp "
                + "WHERE p.id_pay = " + payrollId + " AND p.b_del = 0 AND pr.b_del = 0 AND pr.b_cfd_req = 1 AND "
                + "NOT EXISTS (SELECT * FROM " + SModConsts.TablesMap.get(SModConsts.TRN_CFD) + " WHERE fid_pay_rcp_pay_n = pei.id_pay AND fid_pay_rcp_emp_n = pei.id_emp AND fid_pay_rcp_iss_n = pei.id_iss ) "
                + "UNION "
                + "SELECT p.id_pay, p.per_year, p.per, p.num, p.dt_sta, p.dt_end, p.nts, p.fk_tp_pay, pr.id_emp, bp.bp, emp.num AS f_emp_num, "
                + "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = pr.id_emp) AS f_ear, "
                + "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = pr.id_emp) AS f_ded, "
                + "pei.id_iss, pei.num_ser, "
                + "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = pr.id_emp) - " 
                + "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) "
                + "FROM hrs_pay_rcp AS r "
                + "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp "
                + "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = pr.id_emp) as f_tot, "
                + "pei.fk_tp_pay_sys, pei.dt_iss, pei.dt_pay "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON p.id_pay = pr.id_pay "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_ISS) + " AS pei ON "
                + "pr.id_pay = pei.id_pay AND pr.id_emp = pei.id_emp AND pei.b_del = 0 " + /*AND pei.fk_st_rcp = " + SModSysConsts.TRNS_ST_DPS_ANNULED + "*/ " AND pei.id_iss = (SELECT pei1.id_iss FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_ISS) + " AS pei1 WHERE pei1.id_pay = pei.id_pay AND pei1.id_emp = pei.id_emp AND pei1.b_del = 0 ORDER BY pei1.id_iss DESC LIMIT 1) "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS emp ON emp.id_emp = pr.id_emp "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.BPSU_BP) + " AS bp ON bp.id_bp = emp.id_emp "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.TRN_CFD) + " AS c ON pei.id_pay = c.fid_pay_rcp_pay_n AND pei.id_emp = c.fid_pay_rcp_emp_n AND pei.id_iss = c.fid_pay_rcp_iss_n AND (c.fid_st_xml IN (" + SDataConstantsSys.TRNS_ST_DPS_NEW + " , " + SDataConstantsSys.TRNS_ST_DPS_ANNULED + ") OR LENGTH(c.uuid) = 0 ) "
                + "WHERE p.id_pay = " + payrollId + " AND p.b_del = 0 AND pr.b_del = 0 "
                + "ORDER BY id_pay, per_year, per, num, dt_sta, dt_end, nts, fk_tp_pay, bp, id_emp, f_emp_num, f_ear, f_ded, id_iss, num_ser, f_tot, fk_tp_pay_sys, dt_iss, dt_pay ";
        
        resultSet = session.getStatement().executeQuery(sql);
        
        while (resultSet.next()) {
            receipt = new SHrsPayrollEmployeeReceipt();
            
            receipt.setPkPayrollId(resultSet.getInt("id_pay"));
            receipt.setPkEmployeeId(resultSet.getInt("id_emp"));
            receipt.setPkIssueId(resultSet.getInt("id_iss"));
            receipt.setPeriodYear(resultSet.getInt("per_year"));
            receipt.setPeriod(resultSet.getInt("per"));
            receipt.setPayrollNumber(resultSet.getInt("num"));
            receipt.setDateStart(resultSet.getDate("dt_sta"));
            receipt.setDateEnd(resultSet.getDate("dt_end"));
            receipt.setNotes(resultSet.getString("nts"));
            receipt.setFkPaymentTypeId(resultSet.getInt("fk_tp_pay"));
            receipt.setNumberSeries(resultSet.getString("num_ser"));
            receipt.setDateIssue(resultSet.getDate("dt_iss"));
            receipt.setDatePayment(resultSet.getDate("dt_pay"));
            receipt.setPaymentTypeSysId(resultSet.getInt("fk_tp_pay_sys"));
            receipt.setEmployeeNumber(resultSet.getString("num"));
            receipt.setEmployeeName(resultSet.getString("bp"));
            receipt.setTotalEarnings(resultSet.getDouble("f_ear"));
            receipt.setTotalDeductions(resultSet.getDouble("f_ded"));
            receipt.setTotalNet(resultSet.getDouble("f_tot"));
            
            receipts.add(receipt);
            
        }
        
        return receipts;
    }
    
    public static boolean validateReceiptsPendingCfdi( final SGuiSession session,  final int payrollId) throws Exception {
        ArrayList<SDataCfd> cfds = null;
        
        cfds = SCfdUtils.getPayrollCfds((SClientInterface) session.getClient(), SCfdConsts.CFDI_PAYROLL_VER_CUR, new int[] { payrollId });
        SCfdUtils.existsCfdiPending((SClientInterface) session.getClient(), cfds);
        
        return true;
    }
    
    public static SDataCfd computeCfdi(final SGuiSession session, final SHrsFormerPayrollReceipt receipt, final int receiptIssue, final boolean cfdiPendingSigned) throws Exception {
        boolean add = true;
        int cfdId = SLibConsts.UNDEFINED;
        
        String sql = "SELECT id_cfd, fid_st_xml " 
                + "FROM " + SModConsts.TablesMap.get(SModConsts.TRN_CFD) + " "
                + "WHERE fid_pay_rcp_pay_n = " + receipt.getPayroll().getPkNominaId() + " AND fid_pay_rcp_emp_n = " + receipt.getPkEmpleadoId() + " AND fid_pay_rcp_iss_n = " + receiptIssue + " "
                + "ORDER BY id_cfd ";

        ResultSet resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            if (resultSet.getInt("fid_st_xml") != SDataConstantsSys.TRNS_ST_DPS_ANNULED) {
                if (resultSet.getInt("fid_st_xml") == SDataConstantsSys.TRNS_ST_DPS_EMITED) {
                    add = !cfdiPendingSigned;
                }
                else {
                    cfdId = resultSet.getInt("id_cfd");
                }
            }
        }
                            
        if (add) {
            // generate CFDI:

            cfd.ver32.DElementComprobante comprobanteCfdi32 = null;
            cfd.ver33.DElementComprobante comprobanteCfdi33 = null;
            
            SCfdPacket packet = new SCfdPacket();
            packet.setCfdId(cfdId);
            //packet.setIsCfdConsistent(cfdId == SLibConstants.UNDEFINED);
        
            int xmlType = ((SSessionCustom) session.getSessionCustom()).getCfdTypeXmlTypes().get(SDataConstantsSys.TRNS_TP_CFD_PAYROLL);
            float cfdVersion = SLibConsts.UNDEFINED;
            
            switch (xmlType) {
                case SDataConstantsSys.TRNS_TP_XML_CFDI_32:
                        comprobanteCfdi32 = (cfd.ver32.DElementComprobante) SCfdUtils.createCfdi32RootElement((SClientInterface) session.getClient(), receipt);
                        cfdVersion = comprobanteCfdi32.getVersion();
                        
                        packet.setCfdStringSigned(DCfdUtils.generateOriginalString(comprobanteCfdi32));
                        packet.setFkXmlStatusId(SDataConstantsSys.TRNS_ST_DPS_NEW); // after stamping changes to emitted
                    break;
                case SDataConstantsSys.TRNS_TP_XML_CFDI_33:
                        comprobanteCfdi33 = (cfd.ver33.DElementComprobante) SCfdUtils.createCfdi33RootElement((SClientInterface) session.getClient(), receipt);
                        cfdVersion = comprobanteCfdi33.getVersion();
                        
                        packet.setCfdStringSigned(DCfdUtils.generateOriginalString(comprobanteCfdi33));
                        packet.setFkXmlStatusId(SDataConstantsSys.TRNS_ST_DPS_NEW); // after stamping changes to emitted
                    break;
                default:
                    throw new Exception(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
            }
            
            packet.setFkCfdTypeId(SDataConstantsSys.TRNS_TP_CFD_PAYROLL);
            packet.setFkXmlTypeId(xmlType);
            packet.setFkXmlDeliveryTypeId(SModSysConsts.TRNS_TP_XML_DVY_NA);
            packet.setFkXmlDeliveryStatusId(SModSysConsts.TRNS_ST_XML_DVY_PENDING);
            packet.setFkUserDeliveryId(session.getUser().getPkUserId());
            packet.setPayrollReceiptPayrollId(receipt.getPayroll().getPkNominaId());
            packet.setPayrollReceiptEmployeeId(receipt.getAuxEmpleadoId());
            packet.setPayrollReceiptIssueId(receiptIssue);
            
            packet.setCfdCertNumber(((SClientInterface) session.getClient()).getCfdSignature(cfdVersion).getCertNumber());
            packet.setCfdSignature(((SClientInterface) session.getClient()).getCfdSignature(cfdVersion).sign(packet.getCfdStringSigned(), SLibTimeUtilities.digestYear(receipt.getPayroll().getFecha())[0]));
            
            switch (xmlType) {
                case SDataConstantsSys.TRNS_TP_XML_CFDI_32:
                    comprobanteCfdi32.getAttSello().setString(packet.getCfdSignature());
                    packet.setAuxCfdRootElement(comprobanteCfdi32);
                    break;
                case SDataConstantsSys.TRNS_TP_XML_CFDI_33:
                    comprobanteCfdi33.getAttSello().setString(packet.getCfdSignature());
                    packet.setAuxCfdRootElement(comprobanteCfdi33);
                    break;
                default:
                    throw new Exception(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
            }

            ArrayList<SCfdPacket> cfdPackets = new ArrayList<>();
            cfdPackets.add(packet);

            // end of Generate CFDI
            
            SDbFormerPayrollImport payrollImport = new SDbFormerPayrollImport();
            payrollImport.setPayrollId(receipt.getPayroll().getPkNominaId());
            payrollImport.setRegenerateOnlyNonStampedCfdi(cfdiPendingSigned);
            payrollImport.getCfdPackets().addAll(cfdPackets);
            
            SServerRequest request = new SServerRequest(SServerConstants.REQ_DB_ACTION_SAVE);
            request.setPacket(payrollImport);
            SServerResponse response = ((SClientInterface)session.getClient()).getSessionXXX().request(request);

            if (response.getResponseType() != SSrvConsts.RESP_TYPE_OK) {
                throw new Exception(response.getMessage());
            }
            else {
                if (response.getResultType() != SLibConstants.DB_ACTION_SAVE_OK) {
                    throw new Exception("Código de error al emitir el CFD: " + SLibConstants.MSG_ERR_DB_REG_SAVE + ".");
                }
            }
        }
        
        return SCfdUtils.getPayrollReceiptLastCfd((SClientInterface)session.getClient(), SCfdConsts.CFDI_PAYROLL_VER_CUR, new int[] { receipt.getPayroll().getPkNominaId(), receipt.getPkEmpleadoId(), receiptIssue });
    }
        
    public static void computeSignCfdi(final SGuiSession session, int[] keyReceipt) throws Exception {
        SDataCfd cfd = null;
        SHrsFormerPayroll payroll = null;
        SHrsFormerPayrollReceipt payrollReceipt = null;
        
        payroll = SHrsUtils.readPayroll((SClientInterface) session.getClient(), keyReceipt);
        payrollReceipt = payroll.getChildPayrollReceipts().get(0);
        payrollReceipt.setPayroll(payroll);
        payrollReceipt.setFechaEdicion(session.getCurrentDate());
        payrollReceipt.setMoneda(session.getSessionCustom().getLocalCurrencyCode()); 
        payrollReceipt.setLugarExpedicion(((SClientInterface) session.getClient()).getSessionXXX().getCurrentCompanyBranch().getDbmsBizPartnerBranchAddressOfficial().getZipCode());
        payrollReceipt.setConfirmacion("");
        payrollReceipt.setRegimenFiscal(((SClientInterface) session.getClient()).getSessionXXX().getParamsCompany().getDbmsDataCfgCfd().getCfdRegimenFiscal());
        payrollReceipt.setCfdiRelacionadosTipoRelacion("");
        
        cfd = computeCfdi(session, payrollReceipt, keyReceipt[2], false);
        if (cfd == null) {
            throw new Exception("Error al leer el CFD, no se encontró el registro.");
        }

        if (((SClientInterface) session.getClient()).getSessionXXX().getParamsCompany().getIsCfdiSendingAutomaticHrs()) {
            SCfdUtils.signAndSendCfdi((SClientInterface) session.getClient(), cfd, SCfdConsts.CFDI_PAYROLL_VER_CUR, false, false);
        }
        else {
            SCfdUtils.signCfdi((SClientInterface) session.getClient(), cfd, SCfdConsts.CFDI_PAYROLL_VER_CUR, false, false);
        }
    }
}
