/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.db;

import erp.SClient;
import erp.cfd.SCfdConsts;
import erp.cfd.SDialogResult;
import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.table.STableUtilities;
import erp.mbps.data.SDataBizPartner;
import erp.mfin.data.SFinUtilities;
import erp.mhrs.data.SDataPayrollReceiptIssue;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.fin.util.STreasuryBankLayoutFile;
import erp.mod.fin.util.STreasuryBankLayoutRequest;
import erp.print.SDataConstantsPrint;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.joda.time.DateTime;
import org.joda.time.Period;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibConsts;
import sa.lib.SLibTimeConsts;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;
import sa.lib.db.SDbConsts;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiSession;

/**
 *
 * @author Juan Barajas, Alfredo Perez, Claudio Peña, Sergio Flores
 */
public abstract class SHrsUtils {
    
    /**
     * Creates layout to payroll with Banamex
     * @param client
     * @param payrollId
     * @param title
     * @param dateApplication
     * @param accountDebit
     * @param consecutiveDay
     * @param bankId ID the bank to payment
     * @param employees employees ids
     */
    public static void createLayoutBanamexPayroll(SGuiClient client, int payrollId, java.lang.String title, Date dateApplication, String accountDebit, int consecutiveDay, int bankId, String[] employees) {
        ResultSet resultSetHeader = null;
        ResultSet resultSetDetail = null;
        BufferedWriter bw = null;
        DecimalFormat formatDescTotal = new DecimalFormat("0000000000000000.00");
        SimpleDateFormat formatDateData = new SimpleDateFormat("yyMMdd");
        SimpleDateFormat formatDateTitle = new SimpleDateFormat("yyMMdd HHmm");
        SDbConfig moConfig;
        SDataBizPartner oBizPartner = null;
        SDbPayroll moPayroll = null;
        String sql = "";
        String fileName = "";
        String buffer = "";
        String sAccountDebit = "";
        String sAccountCredit = "";
        String sBizPartner = "";
        String sDescription = "";
        String sCompany = "";
        String employeesId = "";
        double mdBalance = 0;
        double mdBalanceTotal = 0;
        int nBankKey = 0;
        int n = 0;
        int nMoveNumTotal = 0;
        int nEmployeeBankId = 0;
        int nEmployeeBankAuxId = 0;
        
        moConfig = (SDbConfig) client.getSession().readRegistry(SModConsts.HRS_CFG, new int[] { SUtilConsts.BPR_CO_ID });
        oBizPartner = (SDataBizPartner) SDataUtilities.readRegistry((SClientInterface) client, SDataConstants.BPSU_BP, new int[] { bankId }, SLibConstants.EXEC_MODE_SILENT);
        moPayroll = (SDbPayroll)  client.getSession().readRegistry(SModConsts.HRS_PAY, new int[] { payrollId }, SDbConsts.MODE_STEALTH);
        sDescription = (moPayroll.getFkPaymentTypeId() == SModSysConsts.HRSS_TP_PAY_WEE ? SHrsFormerConsts.PAY_WEE_ABB : SHrsFormerConsts.PAY_BIW_ABB ) + moPayroll.getNumber() + " " + formatDateData.format(dateApplication);
        sCompany = SLibUtilities.textToAlphanumeric(((SClientInterface) client).getSessionXXX().getCompany().getDbmsDataCompany().getBizPartner());
        employeesId = SLibUtils.textImplode(employees, ",");
        
        fileName = formatDateTitle.format(new Date()).concat(" bmx nom.txt");

        client.getFileChooser().setSelectedFile(new File(fileName));
        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"));
                
                sAccountDebit = SLibUtilities.textTrim(accountDebit).replace("-", "");
                
                // control registry (type 1)
                buffer += "1"; //type of registry
                buffer += SLibUtilities.textRepeat("0", 12 - oBizPartner.getDbmsCategorySettingsSup().getCompanyKey().length()).concat(oBizPartner.getDbmsCategorySettingsSup().getCompanyKey()); //client
                buffer += formatDateData.format(dateApplication); //payment date
                buffer += SLibUtilities.textRepeat("0", 4 - ("" + consecutiveDay).length()).concat("" + consecutiveDay); //sequential number
                buffer += sCompany.length() > 36 ? sCompany.substring(0,35) : sCompany.concat(SLibUtilities.textRepeat(" ", 36 - sCompany.length())); //company's name
                buffer += sDescription.concat(SLibUtilities.textRepeat(" ", (sDescription.length() >= 20 ? 0 : 20 - sDescription.length()))); //description
                buffer += "15"; //nature of file
                buffer += "D"; //layout version
                buffer += "01"; //type of debit
                
                bw.write(buffer);
                bw.newLine();
                
                // global registry (Type 2)
                sql = "SELECT rcp.id_emp, emp.bank_acc, " +
                        "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) - " +
                        "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS pay_net " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                        "INNER JOIN erp.hrsu_emp AS emp ON emp.id_emp = rcp.id_emp " +
                        "WHERE p.b_del = 0 AND rcp.b_del = 0 AND LENGTH(emp.bank_acc) > 0 AND rcp.id_pay = " + payrollId + " AND rcp.pay_r > 0 " +
                        "AND rcp.id_emp IN (" + employeesId + ")";
                
                resultSetHeader = client.getSession().getStatement().executeQuery(sql);
                while (resultSetHeader.next()) {
                    mdBalanceTotal += resultSetHeader.getDouble("pay_net");
                    nMoveNumTotal++;
                }
                
                buffer = "";
                buffer += "2"; //type of registry
                buffer += "1"; //type of operation
                buffer += "001"; //currency key
                buffer += formatDescTotal.format(mdBalanceTotal).replace(".", ""); //amount to be debit
                buffer += "01"; //account type
                buffer += SLibUtilities.textRepeat("0", 20 - sAccountDebit.length()).concat(sAccountDebit); //account number
                buffer += SLibUtilities.textRepeat("0", 6 - ("" + nMoveNumTotal).length()).concat("" + nMoveNumTotal); //total credits
                
                bw.write(buffer);
                bw.newLine();
                
                // detail registry (type 3)
                sql = "SELECT rcp.id_emp, emp.bank_acc, COALESCE(emp.fk_bank_n, 0) AS _bank_id, " +
                        "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) - " +
                        "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS pay_net " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                        "INNER JOIN erp.hrsu_emp AS emp ON emp.id_emp = rcp.id_emp " +
                        "INNER JOIN erp.bpsu_bp bp ON (emp.id_emp = bp.id_bp) " +
                        "WHERE p.b_del = 0 AND rcp.b_del = 0 AND LENGTH(emp.bank_acc) > 0 AND rcp.id_pay = " + payrollId + " AND rcp.pay_r > 0 " +
                        "AND rcp.id_emp IN (" + employeesId + ") " +
                        "ORDER BY bp.bp, emp.num;";
                
                resultSetDetail = client.getSession().getStatement().executeQuery(sql);
                while (resultSetDetail.next()) {
                    buffer = "";
                    
                    sAccountCredit = SLibUtilities.textTrim(resultSetDetail.getString("emp.bank_acc"));
                    mdBalance = resultSetDetail.getDouble("pay_net");
                    sBizPartner = SFinUtilities.getBizPartnerForBanamex(client.getSession(), resultSetDetail.getInt("rcp.id_emp"));
                    nEmployeeBankAuxId = resultSetDetail.getInt("_bank_id");
                    nEmployeeBankId = nEmployeeBankAuxId == SLibConsts.UNDEFINED ? moConfig.getFkBankId() : nEmployeeBankAuxId;
                    
                    if (nEmployeeBankId != oBizPartner.getFkFiscalBankId()) {
                        nBankKey = SLibUtilities.parseInt((sAccountCredit.length() > 10 ? sAccountCredit.substring(0, 3) : "000"));
                        
                        n = (int) (Math.floor(Math.log10(nBankKey)) + 1);
                    }
                    
                    buffer += "3"; //type of registry
                    buffer += "0"; //type of operation
                    buffer += (nEmployeeBankId != oBizPartner.getFkFiscalBankId() ? "002" : "001"); //payment method
                    buffer += "01"; //payment type
                    buffer += "001"; //currency key
                    buffer += formatDescTotal.format(mdBalance).replace(".", ""); //amount
                    buffer += (nEmployeeBankId != oBizPartner.getFkFiscalBankId() ? "40" : "03"); //type of account credit
                    buffer += SLibUtilities.textRepeat("0", (sAccountCredit.length() >= 20 ? 0 : 20 - sAccountCredit.length())).concat(sAccountCredit); //Credit account
                    buffer += (nEmployeeBankId != oBizPartner.getFkFiscalBankId() ? formatDateData.format(dateApplication).concat((SLibUtilities.textRepeat(" ", (formatDateData.format(dateApplication).length() == 16 ? 0 : 16 - formatDateData.format(dateApplication).length())))) : sDescription.concat(sDescription.length() > 16 ? sDescription.substring(0,15) : (SLibUtilities.textRepeat(" ", (sDescription.length() == 16 ? 0 : 16 - sDescription.length()))))); //payment reference
                    buffer += sBizPartner.concat(sBizPartner.length() > 55 ? sBizPartner.substring(0,54) : (SLibUtilities.textRepeat(" ", (sBizPartner.length() == 55 ? 0 : 55 - sBizPartner.length())))); //beneficiary
                    buffer += SLibUtilities.textRepeat(" ", 35); //reference 1
                    buffer += SLibUtilities.textRepeat(" ", 35); //reference 2
                    buffer += SLibUtilities.textRepeat(" ", 35); //reference 3
                    buffer += SLibUtilities.textRepeat(" ", 35); //reference 4
                    buffer += (nEmployeeBankId != oBizPartner.getFkFiscalBankId() ? SLibUtilities.textRepeat("0", 4 - n).concat(nBankKey + "") : SLibUtilities.textRepeat("0", 4)); //key bank
                    buffer += "00"; //term
                    buffer += SLibUtilities.textRepeat(" ", 14); //RFC
                    buffer += SLibUtilities.textRepeat("0", 8); //IVA
                    buffer += SLibUtilities.textRepeat(" ", 80); //future use
                    buffer += SLibUtilities.textRepeat(" ", 50); //future use
                    
                    bw.write(buffer);
                    bw.newLine();
                }
                
                // Summary:
                
                buffer = "";
                buffer += "4";//type of registry
                buffer += "001";//currency key
                buffer += SLibUtilities.textRepeat("0", 6 - (nMoveNumTotal + "").length()).concat(nMoveNumTotal + ""); //number of credits
                buffer += formatDescTotal.format(mdBalanceTotal).replace(".", ""); //total amount of credits
                buffer += SLibUtilities.textRepeat("0", 5).concat("1"); //number of debit
                buffer += formatDescTotal.format(mdBalanceTotal).replace(".", ""); //total amount of debit

                bw.write(buffer);
                bw.newLine();
                bw.flush();
                bw.close();

                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (java.lang.Exception e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }

    /**
     * Creates layout to payroll with BanBajio
     * @param client
     * @param payrollId
     * @param title
     * @param dateApplication
     * @param accountDebit
     * @param consecutiveDay
     * @param employees employees ids
     */
    public static void createLayoutBanBajioPayroll(SGuiClient client, int payrollId, java.lang.String title, Date dateApplication, String accountDebit, int consecutiveDay, String[] employees) {
        ResultSet resultSet = null;
        String sql = "";
        String fileName = "";
        int nMoveNum = 2;
        int nMoveNumTotal = 0;
        int n = 0;
        int m = 0;
        int employeeId = 0;
        int dayFileName = 0;
        int monthFileName = 0;
        String employeesId = "";
        java.lang.String sAccountDebit = "";
        java.lang.String sAccountCredit = "";
        java.lang.String leyend = "";
        java.lang.String buffer = "";
        DecimalFormat formatDesc = new DecimalFormat("0000000000000.00");
        DecimalFormat formatDescTotal = new DecimalFormat("0000000000000000.00");
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
        double mdBalance = 0;
        double mdBalanceTotal = 0;
        SDbConfig config = null;
        
        config = (SDbConfig) client.getSession().readRegistry(SModConsts.HRS_CFG, new int[] { SUtilConsts.BPR_CO_ID });
        dayFileName = SLibTimeUtils.digestDate(dateApplication)[2];
        monthFileName = SLibTimeUtils.digestDate(dateApplication)[1];
        n = (int) (Math.floor(Math.log10(consecutiveDay)) + 1);
        m = (int) (Math.floor(Math.log10(dayFileName)) + 1);
        employeesId = SLibUtils.textImplode(employees, ",");
        
        fileName = "D" + config.getBajioAffinityGroup() + SLibUtilities.textRepeat("0", 2 - n).concat(consecutiveDay + "") + (monthFileName < 10 ? "0." + monthFileName : "1." + (monthFileName - 10)) + SLibUtilities.textRepeat("0", 2 - m).concat(dayFileName + "")+ "";

        client.getFileChooser().setSelectedFile(new File(fileName));
        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"));
                
                sAccountDebit = SLibUtilities.textTrim(accountDebit);
                
                buffer += "01";
                buffer += "0000001";
                buffer += "030";
                buffer += "S";
                buffer += "90";
                buffer += "0";
                buffer += SLibUtilities.textRepeat("0", (config.getBajioAffinityGroup().length() >= 7 ? 0 : 7 - config.getBajioAffinityGroup().length())).concat(SLibUtilities.textLeft(config.getBajioAffinityGroup(), 7));
                buffer += formatDate.format(dateApplication);
                buffer += SLibUtilities.textRepeat("0", (sAccountDebit.length() >= 20 ? 0 : 20 - sAccountDebit.length())).concat(SLibUtilities.textLeft(sAccountDebit, 20)); // Debit acccount
                buffer += SLibUtilities.textRepeat(" ", 130); // FILLER USE FUTURE BANK

                bw.write(buffer);
                bw.newLine();
                
                sql = "SELECT rcp.id_emp, emp.bank_acc, " +
                        "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) - " +
                        "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS _pay_net " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                        "INNER JOIN erp.hrsu_emp AS emp ON emp.id_emp = rcp.id_emp " +
                        "WHERE p.b_del = 0 AND rcp.b_del = 0 AND LENGTH(emp.bank_acc) > 0 AND rcp.id_pay = " + payrollId + " AND rcp.pay_r > 0 " +
                        "AND rcp.id_emp IN (" + employeesId + ")";
                
                resultSet = client.getSession().getStatement().executeQuery(sql);
                while (resultSet.next()) {
                    buffer = "";

                    sAccountCredit = SLibUtilities.textTrim(resultSet.getString("emp.bank_acc"));
                    leyend = "DEPOSITO DE NOMINA";
                    employeeId = resultSet.getInt("rcp.id_emp");
                    mdBalance = resultSet.getDouble("_pay_net");
                    mdBalanceTotal += mdBalance;

                    n = (int) (Math.floor(Math.log10(nMoveNum)) + 1);
                    m = (int) (Math.floor(Math.log10(employeeId)) + 1);
                    
                    buffer += "02";
                    buffer += SLibUtilities.textRepeat("0", 7 - n).concat(nMoveNum++ + "");
                    buffer += "90";
                    buffer += formatDate.format(dateApplication);
                    buffer += SLibUtilities.textRepeat("0", 3); // FILLER
                    buffer += "030";
                    buffer += formatDesc.format(mdBalance).replace(".", "");
                    buffer += formatDate.format(dateApplication);
                    buffer += SLibUtilities.textRepeat("0", 2); // FILLER
                    buffer += SLibUtilities.textRepeat("0", (sAccountDebit.length() >= 20 ? 0 : 20 - sAccountDebit.length())).concat(SLibUtilities.textLeft(sAccountDebit, 20)); // Debit acccount
                    buffer += " ";
                    buffer += SLibUtilities.textRepeat("0", 2); // FILLER
                    buffer += SLibUtilities.textRepeat("0", (sAccountCredit.length() >= 20 ? 0 : 20 - sAccountCredit.length())).concat(SLibUtilities.textLeft(sAccountCredit, 20)); // Credit account
                    buffer += " ";
                    buffer += SLibUtilities.textRepeat("0", 7 - m).concat(employeeId + "");
                    buffer += leyend.concat(SLibUtilities.textRepeat(" ", (40 - leyend.length()))); // Leyend
                    buffer += SLibUtilities.textRepeat("0", 30); // NUMBER TARJETA
                    buffer += SLibUtilities.textRepeat("0", 10); // FILLER
                    
                    bw.write(buffer);
                    bw.newLine();
                    
                    nMoveNumTotal++;
                }

                // Summary:
                
                buffer = "";
                n = (int) (Math.floor(Math.log10(nMoveNum)) + 1);
                m = (int) (Math.floor(Math.log10(nMoveNumTotal)) + 1);

                buffer += "09";
                buffer += SLibUtilities.textRepeat("0", 7 - n).concat(nMoveNum + "");
                buffer += "90";
                buffer += SLibUtilities.textRepeat("0", 7 - m).concat(nMoveNumTotal + "");
                buffer += formatDescTotal.format(mdBalanceTotal).replace(".", "");
                buffer += SLibUtilities.textRepeat(" ", 145); // FILLER USE FUTURE BANK

                bw.write(buffer);
                bw.newLine();
                bw.flush();
                bw.close();

                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (java.lang.Exception e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }
    
    /**
    * Creates layout to payroll with BBVA 
    *@param client
    *@param payrollId
    *@param dateApplication
    *@param consecutiveDay
    *@param employees employees ids
    */
     public static void createLayoutBancomerPayroll(SGuiClient client, int payrollId, Date dateApplication, int consecutiveDay, String[] employees) {
        ResultSet resulSet = null;
        Statement statement = null;
        String sql = "";
        String fileName = "";
        String sBizPartner = "";
        String employeesId = "";
        int nMoveNum = 1;
        int n = 0;
        java.lang.String sAccountCredit = "";
        java.lang.String buffer = "";
        DecimalFormat formatDesc = new DecimalFormat("0000000000000.00");
        SimpleDateFormat formatDateTitle = new SimpleDateFormat("yyMMdd HHmm");
        double mdBalance = 0;
        
        fileName = formatDateTitle.format(new Date()).concat(" bbva nom.txt");
        
        employeesId = SLibUtils.textImplode(employees, ",");
        
        client.getFileChooser().setSelectedFile(new File(fileName));
        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                statement = client.getSession().getStatement();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"));
                
                sql = "SELECT rcp.id_emp, emp.bank_acc, b.bp, " +
                        "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) - " +
                        "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS _pay_net " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                        "INNER JOIN erp.hrsu_emp AS emp ON emp.id_emp = rcp.id_emp " +
                        "INNER JOIN erp.bpsu_bp AS b ON emp.id_emp = b.id_bp " +
                        "WHERE p.b_del = 0 AND rcp.b_del = 0 AND LENGTH(emp.bank_acc) > 0 AND rcp.id_pay = " + payrollId + " AND rcp.pay_r > 0 " +
                        "AND rcp.id_emp IN (" + employeesId + ") " +
                        "ORDER BY rcp.id_emp, emp.bank_acc, b.bp";
                
                resulSet = statement.executeQuery(sql);
                while (resulSet.next()) {
                    buffer = "";
                    
                    sAccountCredit = SLibUtilities.textTrim(resulSet.getString("emp.bank_acc"));
                    mdBalance = resulSet.getDouble("_pay_net");
                    sBizPartner = SLibUtilities.textToAlphanumeric(SLibUtilities.textTrim(resulSet.getString("b.bp")));
                  
                    n = (int) (Math.floor(Math.log10(nMoveNum)) + 1);
                     
                    buffer += SLibUtilities.textRepeat("0", 9 - n).concat(nMoveNum++ + "");
                    buffer += SLibUtilities.textRepeat(" ", 16); // Blank
                    buffer += "99";
                    buffer += sAccountCredit.concat(sAccountCredit.length() > 20 ? sAccountCredit.substring(0,20) : (SLibUtilities.textRepeat(" ", (sAccountCredit.length() == 20 ? 0 : 20 - sAccountCredit.length())))); 
                    buffer += formatDesc.format(mdBalance).replace(".", "");
                    buffer += sBizPartner.concat(sBizPartner.length() > 40 ? sBizPartner.substring(0,40) : (SLibUtilities.textRepeat(" ", (sBizPartner.length() == 40 ? 0 : 40 - sBizPartner.length())))); //beneficiary
                    buffer += "001";
                    buffer += "001";
                    
                    bw.write(buffer);
                    bw.newLine();
                }

                bw.flush();
                bw.close();

                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (java.lang.Exception e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }
    
    /**
    * Creates layout CSV of payroll with HSBC.
    * @param client
    * @param payrollId
    * @param dateApplication
    * @param consecutiveDay
    * @param employees employees ids
    * @param accountDebit
    */
     public static void createLayoutHsbcPayroll(SGuiClient client, int payrollId, Date dateApplication, int consecutiveDay, String[] employees, String accountDebit) {
        ResultSet resulSet = null;
        Statement statement = null;
        String sql = "";
        String fileName = "";
        String employeesId = "";
        SimpleDateFormat formatDateTitle = new SimpleDateFormat("yyMMdd HHmm");
        String sNameEmploy = "";
        String sAccountCredit = "";
        StringBuilder headerLayout = new StringBuilder();
        StringBuilder bodyLayout = new StringBuilder();
        int nCont = 0;
        int type = 0;
        double mdBalanceTot = 0.0;
        double dTotalBalance = 0.0;
        
        sAccountCredit = SLibUtilities.textTrim(accountDebit);

        SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyyy");

        fileName = formatDateTitle.format(new Date()).concat(" HSBC nom.csv");

        employeesId = SLibUtils.textImplode(employees, ",");

        client.getFileChooser().setSelectedFile(new File(fileName));

        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                statement = client.getSession().getStatement();

                sql = "SELECT rcp.id_emp, emp.bank_acc, b.bp, p.fk_tp_pay, " +
                        "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) - " +
                        "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                        "FROM hrs_pay_rcp AS r " +
                        "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                        "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS _pay_net " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                        "INNER JOIN erp.hrsu_emp AS emp ON emp.id_emp = rcp.id_emp " +
                        "INNER JOIN erp.bpsu_bp AS b ON emp.id_emp = b.id_bp " +
                        "WHERE p.b_del = 0 AND rcp.b_del = 0 AND LENGTH(emp.bank_acc) > 0 AND rcp.id_pay = " + payrollId + " AND rcp.pay_r > 0 " +
                        "AND rcp.id_emp IN (" + employeesId + ") " +
                        "ORDER BY rcp.id_emp, emp.bank_acc, b.bp;";

                resulSet = statement.executeQuery(sql);
                while (resulSet.next()) {
                    nCont++;
                    type = resulSet.getInt("fk_tp_pay");
                    sNameEmploy = resulSet.getString("bp");
                    String[] parts = sNameEmploy.split(",");
                    sNameEmploy = parts[1] + " " + parts[0];
                    mdBalanceTot = resulSet.getDouble("_pay_net");
                    dTotalBalance = SLibUtils.roundAmount(dTotalBalance + mdBalanceTot);
                    sNameEmploy = removeSpecialChar(sNameEmploy);
                    bodyLayout.append(SLibUtilities.textTrim(resulSet.getString("emp.bank_acc"))).append(',');
                    bodyLayout.append(mdBalanceTot).append(',');
                    bodyLayout.append("PAGO NOMINA").append(',');
                    bodyLayout.append(sNameEmploy.substring(1,sNameEmploy.length() <= 35 ? sNameEmploy.length() : 35)).append(",,,,");
                    bodyLayout.append("\r\n");
                }
                
                headerLayout.append("MXPRLF").append(',');
                headerLayout.append("F").append(",");
                headerLayout.append(sAccountCredit).append(',');
                headerLayout.append(dTotalBalance).append(',');
                headerLayout.append(nCont).append(',');
                headerLayout.append(formatDate.format(new Date())).append(',');
                headerLayout.append("").append(',');
                headerLayout.append("PAGO NOMINA ").append( type == SModSysConsts.HRSS_TP_PAY_WEE ? "SEMANAL" : "QUINCENAL");
                headerLayout.append("\r\n");
                headerLayout.append(bodyLayout.toString());

                String path = file.toString();
                try {
                    OutputStream outputStream = new FileOutputStream(path.endsWith(".csv") ? path : path + ".csv");
                    Writer outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
                    outputStreamWriter.write(headerLayout.toString());
                    outputStreamWriter.close();
                }
                catch (FileNotFoundException ex) {
                    Logger.getLogger(SHrsUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (SQLException | IOException e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }
	
    /**
     * Replace special characters
     * @param input original text
     * @return output text without characters
     */
    public static String removeSpecialChar(String input) {
        String specialCharacters = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
        String replaceCharacters = "aaaeeeiiiooouuu#AAAEEEIIIOOOUUU#cC";
        String output = input;
        for (int i = 0; i < specialCharacters.length(); i++) {
            output = output.replace(specialCharacters.charAt(i), replaceCharacters.charAt(i));
        }
        return output;
    }        

    /**
     * 
     * @param client
     * @param dateApplicationIni
     * @param dateApplicationEnd
     * @return
     * @throws SQLException 
     */
    public static ArrayList prepareSqlQueryHigh(SGuiClient client, Date dateApplicationIni, Date dateApplicationEnd) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateIni = formatter.format(dateApplicationIni);
        String dateEnd = formatter.format(dateApplicationEnd);
        String sqlId = "";
        ResultSet resultSet = null;
        int[] employeeId = null;

        sqlId = "SELECT id_emp FROM HRS_EMP_LOG_HIRE " 
                + "WHERE dt_hire >= '" + dateIni + "' AND dt_hire <= '" + dateEnd + "' "
                + "AND NOT b_del AND b_hire = " + SModConsts.HRSX_HIRE_ACTIVE ;

        resultSet = client.getSession().getStatement().executeQuery(sqlId);
        ArrayList <Integer> resultsId = new ArrayList();

        while (resultSet.next()) {
          resultsId.add(resultSet.getInt("id_emp"));                  
        }
        return resultsId;
    }
    
      /**
     * 
     * @param client
     * @param dateApplicationIni
     * @param dateApplicationEnd
     * @return
     * @throws SQLException 
     */
    public static ArrayList prepareSqlQueryMod(SGuiClient client, Date dateApplicationIni, Date dateApplicationEnd) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateIni = formatter.format(dateApplicationIni);
        String dateEnd = formatter.format(dateApplicationEnd);
        String sqlId = "";
        ResultSet resultSet = null;
        int[] employeeId = null;

        sqlId = "SELECT id_emp FROM hrs_emp_log_sal_ssc " 
                + "WHERE dt >= '" + dateIni + "' AND dt <= '" + dateEnd + "' " 
                + "AND sal_ssc != " + SModConsts.HRSX_HIRE_DISMISSED + " AND NOT b_del ";        

        resultSet = client.getSession().getStatement().executeQuery(sqlId);
        ArrayList <Integer> resultsId = new ArrayList();

        while (resultSet.next()) {
          resultsId.add(resultSet.getInt("id_emp"));                  
        }
        return resultsId;
    }
    
    /**
     * 
     * @param client
     * @param dateApplicationIni
     * @param dateApplicationEnd
     * @return
     * @throws SQLException 
     */
    public static ArrayList prepareSqlQueryLow(SGuiClient client, Date dateApplicationIni, Date dateApplicationEnd) throws SQLException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateIni = formatter.format(dateApplicationIni);
        String dateEnd = formatter.format(dateApplicationEnd);
        String sqlId = "";
        ResultSet resultSet = null;
        int[] employeeId = null;

        sqlId = "SELECT id_emp FROM hrs_emp_log_hire "
                + "WHERE dt_dis_n >= '" + dateIni + "' AND dt_dis_n <= '" + dateEnd + "' "
                + "AND NOT b_del AND b_hire = " + SModConsts.HRSX_HIRE_DISMISSED + " "; 

        resultSet = client.getSession().getStatement().executeQuery(sqlId);
        ArrayList <Integer> resultsId = new ArrayList();

        while (resultSet.next()) {
          resultsId.add(resultSet.getInt("id_emp"));                  
        }
        return resultsId;
    }
     
    
    /**
     * 
     * @param client
     * @param layoutSuaType Type Layout
     * @param dateLayoutStart Date start layout
     * @param dateLayoutEnd  Date final layout
     */
    public static void createLayoutEmployeeRegister(SGuiClient client, int layoutSuaType, Date dateLayoutStart, Date dateLayoutEnd) {
        ResultSet resultSetHeader = null;
        BufferedWriter bw = null;
        Statement statement = null;
        SimpleDateFormat formatDateData = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat formatDateTitle = new SimpleDateFormat("yyyyMMdd HHmm");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateIni = formatter.format(dateLayoutStart);
        String dateEnd = formatter.format(dateLayoutEnd);        
        java.lang.String buffer = "";
        String sql = "";
        String fileName = "";
        String param = "";
        String ssn = "";
        String name = "";
        String fatherName = "";
        String motherName = "";
        String curp = "";
        String salaryType = "";
        String workerKey = "";
        String guia = "";
        double baseSalary = 0;
        Date dateApplication = null;

        fileName = formatDateTitle.format(new Date()).concat(" Altas.txt");
        
        client.getFileChooser().setSelectedFile(new File(fileName));
        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                statement = client.getSession().getStatement();
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"));
                ArrayList <Integer> pkPrimaryK = prepareSqlQueryHigh(client, dateLayoutStart, dateLayoutEnd);
    
                for (int i = 0; i <= pkPrimaryK.size()-1; i++){
                int pkUser = pkPrimaryK.get(i);
                    
                    sql = "SELECT bp.firstname AS Nombre, bp.alt_id AS CURP, emp.lastname1 AS ApellidoP, emp.lastname2 AS ApellidoM, "
                            + "emp.num AS ClaveTrab, emp.ssn AS SSN, emp.sal_ssc AS Salario, e.id_tp_emp AS TpTrabajador, "
                            + "sal.id_tp_sal AS TpSalario, wrktp.id_tp_work_day AS Jornada, cfg.ss_subbra AS Guia, hire.dt_hire AS DateApplication, par.reg_ss AS Param "
                            + "FROM erp.HRSU_EMP AS emp "
                            + "INNER JOIN erp.BPSU_BP AS bp ON bp.id_bp = emp.id_emp "
                            + "INNER JOIN erp.HRSU_TP_EMP AS e ON e.id_tp_emp = emp.fk_tp_emp "
                            + "INNER JOIN erp.hrss_tp_sal AS sal ON sal.id_tp_sal = emp.fk_tp_sal "
                            + "INNER JOIN erp.hrss_tp_work_day AS wrktp ON emp.fk_tp_work_day = wrktp.id_tp_work_day "
                            + "INNER JOIN hrs_emp_log_hire AS hire ON hire.id_emp = emp.id_emp "
                            + "INNER JOIN cfg_param_co AS par "
                            + "INNER JOIN hrs_cfg AS cfg "
                            + "WHERE hire.b_hire = " + (layoutSuaType == SModConsts.HRSX_HIRE_ACTIVE ? SModConsts.HRSX_HIRE_ACTIVE : SModConsts.HRSX_HIRE_DISMISSED) + " AND not hire.b_del "
                            + "AND hire.dt_hire >= '" + dateIni + "' AND hire.dt_hire <= '" + dateEnd + "' "
                            + "AND emp.id_emp = " + pkUser;

                    resultSetHeader = client.getSession().getStatement().executeQuery(sql);

                    while (resultSetHeader.next()) {
                        param = resultSetHeader.getString("Param");
                        dateApplication = resultSetHeader.getDate("DateApplication");
                        ssn = resultSetHeader.getString("SSN");
                        baseSalary = resultSetHeader.getDouble("Salario");
                        salaryType = resultSetHeader.getString("TpSalario");
                        workerKey = resultSetHeader.getString("ClaveTrab");
                        name = resultSetHeader.getString("Nombre");
                        fatherName = resultSetHeader.getString("ApellidoP");
                        motherName = resultSetHeader.getString("ApellidoM");
                        curp = resultSetHeader.getString("CURP");
                        guia = resultSetHeader.getString("Guia");
                    }

                    buffer += param.substring(0, 9); // (Employer registration)
                    buffer += param.substring(9); // (Digit verifier of R.P)
                    buffer += (ssn.length() > 10 ? ssn.substring(0, 9) : ssn.concat((SLibUtilities.textRepeat(" ", (ssn.length() == 10 ? 0 : 10 - ssn.length()))))); // (Social Security number)
                    buffer += (ssn.length() > 10 ? ssn.substring(9) : " " ); // (Check digit of the NSS)
                    buffer += removeSpecialChar(fatherName).concat(fatherName.length() > 27 ? fatherName.substring(0, 27) : (SLibUtilities.textRepeat(" ", (fatherName.length() == 27 ? 0 : 27 - fatherName.length())))); // (Last name)
                    buffer += removeSpecialChar(motherName).concat(motherName.length() > 27 ? motherName.substring(0, 27) : (SLibUtilities.textRepeat(" ", (motherName.length() == 27 ? 0 : 27 - motherName.length())))); // (Mother's last name)
                    buffer += removeSpecialChar(name).concat(name.length() > 27 ? name.substring(0, 27) : (SLibUtilities.textRepeat(" ", (name.length() == 27 ? 0 : 27 - name.length())))); // (name)
                    String.format("%.2f", baseSalary);
                    String baseSalaryS = String.valueOf(baseSalary);
                    baseSalaryS = baseSalaryS.replaceAll("\\.","");
                    buffer += (baseSalaryS.length() > 6 ? baseSalaryS.substring(0, 6) : (SLibUtilities.textRepeat("0", (baseSalaryS.length() == 6 ? 0 : 6 - baseSalaryS.length())))).concat(baseSalaryS); // (Salary base quote)
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 6));
                    buffer += "1"; // (Type of worker)
                    buffer += (salaryType.equals(1) ? "0" : salaryType.equals(2) ? "1" : "2"); //(Type of salary)
                    buffer += "0"; //(Week or reduced working day)
                    buffer += formatDateData.format(dateApplication); // (Movement date)
                    buffer += "000"; //(Family medicine unit)
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 2));
                    buffer += "08"; // (Movement type)
                    buffer += (guia + "400"); // (Guide)
                    buffer += (workerKey.length() > 10 ? workerKey.substring(0, 10) : (SLibUtilities.textRepeat("0", (workerKey.length() == 10 ? 0 : 10 - workerKey.length())))).concat(workerKey); // (Worker's code)
                    buffer += SLibUtilities.textRepeat(" ", 1);
                    buffer += curp; // CURP
                    buffer += "9"; // (Format Identifier)
                    buffer += "\n";
                }
                    
                bw.write(buffer);
                bw.flush();
                bw.close();

                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (java.lang.Exception e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }

    /**
     * 
     * @param client
     * @param layoutSuaType Type Layout
     * @param dateLayoutStart Date start layout
     * @param dateLayoutEnd  Date final layout
     */
    public static void createLayoutEmployeeModification(SGuiClient client, int layoutSuaType, Date dateLayoutStart, Date dateLayoutEnd) {
        ResultSet resultSetHeader = null;
        BufferedWriter bw = null;
        Statement statement = null;
        SimpleDateFormat formatDateData = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat formatDateTitle = new SimpleDateFormat("yyyyMMdd HHmm");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateIni = formatter.format(dateLayoutStart);
        String dateEnd = formatter.format(dateLayoutEnd); 
        java.lang.String buffer = "";
        String sql = "";
        String param = "";
        String fileName = "";
        String ssn = "";
        String name = "";
        String fatherName = "";
        String motherName = "";
        String curp = "";
        String salaryType = "";
        String workerKey = "";
        String guia = "";
        double baseSalary = 0;
        Date dateApplication = null;
        
        fileName = formatDateTitle.format(new Date()).concat(" SBC.txt");
        
        client.getFileChooser().setSelectedFile(new File(fileName));
        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                statement = client.getSession().getStatement();
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"));
                ArrayList <Integer> pkPrimaryK = prepareSqlQueryMod(client, dateLayoutStart, dateLayoutEnd);
    
                for (int i = 0; i <= pkPrimaryK.size()-1; i++){
                    int pkUser = pkPrimaryK.get(i);

                    sql = "SELECT bp.firstname AS Nombre, bp.alt_id AS CURP, emp.lastname1 AS ApellidoP, emp.lastname2 AS ApellidoM, "
                            + "emp.num AS ClaveTrab, emp.ssn AS SSN, emp.sal_ssc AS Salario, e.id_tp_emp AS TpTrabajador, " 
                            + "sal.id_tp_sal AS TpSalario, wrktp.id_tp_work_day AS Jornada, cfg.ss_subbra AS Guia, ssc.dt AS DateApplication, par.reg_ss AS Param "
                            + "FROM erp.HRSU_EMP AS emp "
                            + "INNER JOIN erp.BPSU_BP AS bp ON bp.id_bp = emp.id_emp "
                            + "INNER JOIN erp.HRSU_TP_EMP AS e ON e.id_tp_emp = emp.fk_tp_emp "
                            + "INNER JOIN erp.hrss_tp_sal AS sal ON sal.id_tp_sal = emp.fk_tp_sal "
                            + "INNER JOIN erp.hrss_tp_work_day AS wrktp ON emp.fk_tp_work_day = wrktp.id_tp_work_day "
                            + "INNER JOIN HRS_EMP_LOG_SAL_SSC AS ssc ON ssc.id_emp = emp.id_emp "
                            + "INNER JOIN cfg_param_co AS par "
                            + "INNER JOIN hrs_cfg AS cfg "
                            + "WHERE ssc.dt >= '" + dateIni + "' AND ssc.dt <= '" + dateEnd + "' AND NOT ssc.b_del "
                            + "AND emp.id_emp = " + pkUser ; 

                    resultSetHeader = client.getSession().getStatement().executeQuery(sql);

                    while (resultSetHeader.next()) {
                        param = resultSetHeader.getString("Param");
                        ssn = resultSetHeader.getString("SSN");
                        dateApplication = resultSetHeader.getDate("DateApplication");
                        baseSalary = resultSetHeader.getDouble("Salario");
                        salaryType = resultSetHeader.getString("TpSalario");
                        workerKey = resultSetHeader.getString("ClaveTrab");
                        name = resultSetHeader.getString("Nombre");
                        fatherName = resultSetHeader.getString("ApellidoP");
                        motherName = resultSetHeader.getString("ApellidoM");
                        curp = resultSetHeader.getString("CURP");
                        guia = resultSetHeader.getString("Guia");
                    }             

                    buffer += param.substring(0, 9); // (Employer registration)
                    buffer += param.substring(9); // (Digit verifier of R.P)
                    buffer += (ssn.length() > 10 ? ssn.substring(0, 9) : ssn.concat((SLibUtilities.textRepeat(" ", (ssn.length() == 10 ? 0 : 10 - ssn.length()))))); // (Social Security number)
                    buffer += (ssn.length() > 10 ? ssn.substring(9) : " " ); // (Check digit of the NSS)
                    buffer += removeSpecialChar(fatherName).concat(fatherName.length() > 27 ? fatherName.substring(0, 27) : (SLibUtilities.textRepeat(" ", (fatherName.length() == 27 ? 0 : 27 - fatherName.length())))); // (Last name)
                    buffer += removeSpecialChar(motherName).concat(motherName.length() > 27 ? motherName.substring(0, 27) : (SLibUtilities.textRepeat(" ", (motherName.length() == 27 ? 0 : 27 - motherName.length())))); // (Mother's last name)
                    buffer += removeSpecialChar(name).concat(name.length() > 27 ? name.substring(0, 27) : (SLibUtilities.textRepeat(" ", (name.length() == 27 ? 0 : 27 - name.length())))); // (name)
                    String.format("%.2f", baseSalary);
                    String baseSalaryS = String.valueOf(baseSalary);
                    baseSalaryS = baseSalaryS.replaceAll("\\.","");
                    buffer += (baseSalaryS.length() > 6 ? baseSalaryS.substring(0, 6) : (SLibUtilities.textRepeat("0", (baseSalaryS.length() == 6 ? 0 : 6 - baseSalaryS.length())))).concat(baseSalaryS); // (Salary base quote)
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 6));
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 1));
                    buffer += (salaryType.equals(1) ? "0" : salaryType.equals(2) ? "1" : "2"); //(Type of salary)
                    buffer += "0"; //(Week or reduced working day)
                    buffer += formatDateData.format(dateApplication); // (Movement date)
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 5));
                    buffer += "07"; // (Movement type)
                    buffer += (guia + "400"); // (Guide)
                    buffer += (workerKey.length() > 10 ? workerKey.substring(0, 10) : (SLibUtilities.textRepeat("0", (workerKey.length() == 10 ? 0 : 10 - workerKey.length())))).concat(workerKey); // (Worker's code)
                    buffer += SLibUtilities.textRepeat(" ", 1);
                    buffer += curp; // CURP
                    buffer += "9"; // (Format Identifier)
                    buffer += "\n";                                  
                }
                
                bw.write(buffer);
                bw.flush();
                bw.close();

                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (java.lang.Exception e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }    
    
    /**
     * 
     * @param client
     * @param layoutSuaType Type Layout
     * @param dateLayoutStart Date start layout
     * @param dateLayoutEnd  Date final layout
     */
    public static void createLayoutEmployeeDelete(SGuiClient client, int layoutSuaType, Date dateLayoutStart, Date dateLayoutEnd) {
        ResultSet resultSetHeader = null;
        BufferedWriter bw = null;
        Statement statement = null;
        SimpleDateFormat formatDateData = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat formatDateTitle = new SimpleDateFormat("yyyyMMdd HHmm");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateIni = formatter.format(dateLayoutStart);
        String dateEnd = formatter.format(dateLayoutEnd);  
        java.lang.String buffer = "";
        String sql = "";
        String param = "";
        String fileName = "";
        String ssn = "";
        String name = "";
        String fatherName = "";
        String motherName = "";
        String workerKey = "";
        String guia = "";
        String type = "";
        Date dateApplication = null;
        
        fileName = formatDateTitle.format(new Date()).concat(" Bajas.txt");
        
        client.getFileChooser().setSelectedFile(new File(fileName));
        if (client.getFileChooser().showSaveDialog(client.getFrame()) == JFileChooser.APPROVE_OPTION) {
            File file = new File(client.getFileChooser().getSelectedFile().getAbsolutePath());

            try {
                statement = client.getSession().getStatement();
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"));
                ArrayList <Integer> pkPrimaryK = prepareSqlQueryLow(client, dateLayoutStart, dateLayoutEnd);
    
                for (int i = 0; i <= pkPrimaryK.size()-1; i++){
                int pkUser = pkPrimaryK.get(i);
                
                    sql = "SELECT bp.firstname AS Nombre, bp.alt_id AS CURP, emp.lastname1 AS ApellidoP, emp.lastname2 AS ApellidoM,"
                          + "emp.num AS ClaveTrab, emp.ssn AS SSN, emp.sal_ssc AS Salario, e.id_tp_emp AS TpTrabajador, sal.id_tp_sal AS TpSalario, "
                          + "wrktp.id_tp_work_day AS Jornada, cfg.ss_subbra AS Guia, hire.b_hire AS Motivo, hire.fk_tp_emp_dis AS Tipe, hire.dt_dis_n AS DateApplication, par.reg_ss AS Param "
                          + "FROM erp.HRSU_EMP AS emp "
                          + "INNER JOIN erp.BPSU_BP AS bp ON bp.id_bp = emp.id_emp "
                          + "INNER JOIN erp.HRSU_TP_EMP AS e ON e.id_tp_emp = emp.fk_tp_emp "
                          + "INNER JOIN erp.hrss_tp_sal AS sal ON sal.id_tp_sal = emp.fk_tp_sal "
                          + "INNER JOIN erp.hrss_tp_work_day AS wrktp ON emp.fk_tp_work_day = wrktp.id_tp_work_day "
                          + "INNER JOIN HRS_EMP_LOG_HIRE AS hire ON hire.id_emp = emp.id_emp "
                          + "INNER JOIN cfg_param_co AS par "
                          + "INNER JOIN hrs_cfg AS cfg "
                          + "WHERE hire.b_hire = " + SModConsts.HRSX_HIRE_DISMISSED + " AND not hire.b_del "
                          + "AND hire.dt_dis_n >= '" + dateIni + "' AND hire.dt_dis_n <= '" + dateEnd + "' "
                          + "AND emp.id_emp = " + pkUser;

                    resultSetHeader = client.getSession().getStatement().executeQuery(sql);
                        while (resultSetHeader.next()) {
                            dateApplication = resultSetHeader.getDate("DateApplication");
                            param = resultSetHeader.getString("Param");
                            ssn = resultSetHeader.getString("SSN");
                            workerKey = resultSetHeader.getString("ClaveTrab");
                            name = resultSetHeader.getString("Nombre");
                            fatherName = resultSetHeader.getString("ApellidoP");
                            motherName = resultSetHeader.getString("ApellidoM");
                            guia = resultSetHeader.getString("Guia");
                            type = resultSetHeader.getString("Tipe");
                        }


                    buffer += param.substring(0, 9); // (Employer registration)
                    buffer += param.substring(9); // (Digit verifier of R.P)
                    buffer += (ssn.length() > 10 ? ssn.substring(0, 9) : ssn.concat((SLibUtilities.textRepeat(" ", (ssn.length() == 10 ? 0 : 10 - ssn.length()))))); // (Social Security number)
                    buffer += (ssn.length() > 10 ? ssn.substring(9) : " " ); // (Check digit of the NSS)
                    buffer += removeSpecialChar(fatherName).concat(fatherName.length() > 27 ? fatherName.substring(0, 27) : (SLibUtilities.textRepeat(" ", (fatherName.length() == 27 ? 0 : 27 - fatherName.length())))); // (Last name)
                    buffer += removeSpecialChar(motherName).concat(motherName.length() > 27 ? motherName.substring(0, 27) : (SLibUtilities.textRepeat(" ", (motherName.length() == 27 ? 0 : 27 - motherName.length())))); // (Mother's last name)
                    buffer += removeSpecialChar(name).concat(name.length() > 27 ? name.substring(0, 27) : (SLibUtilities.textRepeat(" ", (name.length() == 27 ? 0 : 27 - name.length())))); // (name)
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 15));
                    buffer += formatDateData.format(dateApplication); // (Movement date)
                    buffer += String.valueOf(SLibUtilities.textRepeat(" ", 5));
                    buffer += "02"; // (Movement type)
                    buffer += (guia + "400"); // (Guide)
                    buffer += (workerKey.length() > 10 ? workerKey.substring(0, 10) : (SLibUtilities.textRepeat("0", (workerKey.length() == 10 ? 0 : 10 - workerKey.length())))).concat(workerKey); // (Worker's code)
                    buffer += (type.equals(1) ? "6" : type.equals(2) ? "2" : type.equals(3) ? "1" : type.equals(4) ? "3" : "6" );
                    buffer += SLibUtilities.textRepeat(" ", 18);
                    buffer += "9"; // (Format Identifier)
                    buffer += "\n";
                }
                
                bw.write(buffer);
                bw.flush();
                bw.close();

                if (client.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
            catch (java.lang.Exception e) {
                SLibUtilities.renderException(STableUtilities.class.getName(), e);
            }
        }
    }
    
    /**
     * Checks if period is anniversary of provided date.
     * @param anniversary
     * @param periodStart
     * @param periodEnd
     * @return 
     */
    public static boolean isAnniversaryBelongingToPeriod(final Date anniversary, final Date periodStart, final Date periodEnd) throws Exception {
        SLibTimeUtils.validatePeriod(periodStart, periodEnd);
        int[] elementsDate = SLibTimeUtils.digestDate(anniversary);
        int[] elementsPeriodEnd = SLibTimeUtils.digestDate(periodEnd);
        elementsDate[0] = elementsPeriodEnd[0];
        Date newDate = SLibTimeUtils.createDate(elementsDate[0], elementsDate[1], elementsDate[2]);
        return SLibTimeUtils.isBelongingToPeriod(newDate, periodStart, periodEnd);
    }
    
    /**
     * @param session User GUI session.
     * @param year Payroll year.
     * @return First day of year set by user on module configuration, otherwise January 1st of desired year.
     */
    public static Date getFirstDayYear(final SGuiSession session, final int year) {
        SDbFirstDayYear firstDayYear = (SDbFirstDayYear) session.readRegistry(SModConsts.HRS_FDY, new int[] { year }, SDbConsts.MODE_STEALTH);
        return firstDayYear == null || firstDayYear.isRegistryNew() ? SLibTimeUtils.createDate(year, 1, 1) : firstDayYear.getFirstDayYear();
    }

    /**
     * @param session User GUI session.
     * @param year Payroll year.
     * @param paymentType Payroll payment type (constants defined in class <code>SModSysConsts</code>, HRSS_TP_PAY).
     * @param tpPaySht Type of paysheet
     * @return Payroll next number of provided payment type.
     */
    public static int getPayrollNextNumber(final SGuiSession session, final int year, final int paymentType, final int tpPaySht) throws Exception {
        int nextNumber = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT COALESCE(MAX(num), 0) + 1 "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " "
                + "WHERE per_year = " + year + " AND fk_tp_pay = " + paymentType + " AND b_del = 0 "
                + (tpPaySht != SModSysConsts.HRSS_TP_PAY_SHT_EXT ? "AND fk_tp_pay_sht = " + tpPaySht : "");

        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            nextNumber = resultSet.getInt(1);
        }

        return validatePayrollNumber(session, year, nextNumber, paymentType);
    }
    
    public static int getPayrollReceiptNextNumber(final SGuiSession session, final String series) throws Exception {
        int number = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT MAX(CONVERT(num, UNSIGNED INTEGER)) + 1 AS f_num "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_ISS) + " "
                + "WHERE num_ser = '" + series + "' AND b_del = 0 ";

        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            if (resultSet.getObject("f_num") != null) {
                number = resultSet.getInt("f_num");
            }
            else {
                number = 1;
            }
        }

        return number;
    }

    public static ArrayList<SDataPayrollReceiptIssue> getPayrollReceiptIssues(final SGuiSession session, final int[] payrollKey) throws Exception {
        String sql = "";
        ResultSet resultSet = null;
        ArrayList<SDataPayrollReceiptIssue> receiptIssues = null;
        SDataPayrollReceiptIssue receiptIssue = null;

        receiptIssues = new ArrayList<SDataPayrollReceiptIssue>();

        sql = "SELECT id_pay, id_emp, id_iss " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_ISS) + " " + 
                "WHERE id_pay = " + payrollKey[0] + " AND b_del = 0 AND fk_st_rcp = "  + SModSysConsts.TRNS_ST_DPS_EMITED + " ORDER BY id_iss ";
        
        resultSet = session.getStatement().executeQuery(sql);
        while (resultSet.next()) {
            receiptIssue = new SDataPayrollReceiptIssue();
            
            if (receiptIssue.read(new int[] { resultSet.getInt("id_pay"), resultSet.getInt("id_emp"), resultSet.getInt("id_iss") }, session.getStatement().getConnection().createStatement()) != SLibConstants.DB_ACTION_READ_OK) {
                throw new Exception(SLibConstants.MSG_ERR_DB_REG_READ_DEP);
            }
            receiptIssues.add(receiptIssue);
        }

        return receiptIssues;
    }

    /**
     * @param session User GUI session.
     * @param year Payroll year.
     * @param number Payroll number to validate.
     * @param paymentType Payroll payment type (constants defined in class <code>SModSysConsts</code>, HRSS_TP_PAY).
     * @return Valid payroll number, that is, same provided payroll number if valid or maximum valid payroll number of provided payment type.
     */
    public static int validatePayrollNumber(final SGuiSession session, final int year, final int number, final int paymentType) throws Exception {
        int validNumber = 0;
        Date lastPeriod[] = null;

        if (number <= 1) {
            validNumber = 1;        // payroll number equal or less than 1 is set to 1, regardless of payment type
        }
        else {
            validNumber = number;   // assume by instance that number is correct

            switch(paymentType) {
                case SModSysConsts.HRSS_TP_PAY_WEE:
                    if (number >= SHrsConsts.YEAR_WEEKS_EXTENDED) {
                        if (!SLibTimeUtils.isLeapYear(year)) {
                            // maximum number of weekly payrolls must be 53 on ordinary years:
                            validNumber = SHrsConsts.YEAR_WEEKS_EXTENDED - 1;
                        }
                        else {
                            // maximum number of weekly payrolls must be 54 on leap years:
                            validNumber = SHrsConsts.YEAR_WEEKS_EXTENDED;
                        }
                    }
                    break;

                case SModSysConsts.HRSS_TP_PAY_FOR:
                    if (number > SHrsConsts.YEAR_FORNIGHTS) {
                        // maximum number of fortnightly payrolls must be 24:
                        validNumber = SHrsConsts.YEAR_FORNIGHTS;
                    }
                    break;

                default:
                    throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
            }
        }

        return validNumber;
    }
    
    /**
     * Validate date start and date end of payroll versus start operations date of company. 
     * @param config Object with information of configuration the module resource human
     * @param dateStart Date start of payroll
     * @param dateEnd Date end of payroll
     * @return true if is valid
     * @throws Exception 
     */
    public static boolean validatePayrollDate(final SDbConfig config, final Date dateStart, final Date dateEnd) throws Exception {
        
        if (config == null) {
            throw new Exception(SDbConsts.ERR_MSG_REG_NOT_FOUND + " (Configuración del módulo)");
        }
        else if (dateStart.compareTo(config.getDateOperations()) < 0) {
            throw new Exception("La fecha inicial de la nómina '" + SLibUtils.DateFormatDate.format(dateStart) + "', debe ser posterior o igual a la fecha de inicio de operaciones de la empresa '" + SLibUtils.DateFormatDate.format(config.getDateOperations()) + "'.");
        }
        else if (dateEnd.compareTo(config.getDateOperations()) < 0) {
            throw new Exception("La fecha final de la nómina '" + SLibUtils.DateFormatDate.format(dateEnd) + "', debe ser posterior o igual a la fecha de inicio de operaciones de la empresa '" + SLibUtils.DateFormatDate.format(config.getDateOperations()) + "'.");
        }
        return true;
    }
    
    /**
     * Validate information necesary basic for capture payroll.
     * @param session User GUI session.
     * @param config Object with information of configuration the module resource human
     * @param workingDaySettings Configuration of days working
     * @return true if is valid
     * @throws Exception 
     */
    public static boolean validatePayroll(final SGuiSession session, final SDbConfig config, final SDbWorkingDaySettings workingDaySettings) throws Exception {
        SDbDeduction deduction = null;
        String sql = "";
        Statement statement = null;
        ResultSet resultSet = null;
        
        if (config == null) {
            throw new Exception(SDbConsts.ERR_MSG_REG_NOT_FOUND + " (Configuración del módulo)");
        }
        else if (workingDaySettings == null) {
            throw new Exception(SDbConsts.ERR_MSG_REG_NOT_FOUND + " (Configuración de días laborables)");
        }
        else if (config.getFkEarningEarningId_n() == SLibConsts.UNDEFINED) {
            throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN + " (Configuración percepción normal)");
        }
        else if (config.getFkEarningVacationsId_n() == SLibConsts.UNDEFINED) {
            throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN + " (Configuración vacaciones)");
        }
        else if (config.getFkEarningTaxSubsidyId_n() == SLibConsts.UNDEFINED) {
            throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN + " (Configuración subsidio impuesto)");
        }
        else if (config.getFkDeductionTaxId_n() == SLibConsts.UNDEFINED) {
            throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN + " (Configuración impuesto)");
        }
        else if (config.getFkDeductionSsContributionId_n() == SLibConsts.UNDEFINED) {
            throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN + " (Configuración SS)");
        }
        
        statement = session.getStatement().getConnection().createStatement();
        sql = "SELECT * "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_DED) + " "
                + "WHERE b_del = 0 AND fk_tp_loan <> " + SModSysConsts.HRSS_TP_LOAN_NON + " "
                + "ORDER BY CONCAT(code, ' - ', name), id_ded ";

        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            deduction = new SDbDeduction();
            deduction.read(session, new int[] { resultSet.getInt("id_ded") });;
        }
        
        sql = "SELECT id_emp, id_loan " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_LOAN) + " " +
            "WHERE b_del = 0 AND b_clo = 0;";
        
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            if (deduction == null) {
                throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN + " (Deducción tipo crédito/préstamo)");
            }
        }
        
        return true;
    }
    
    public static boolean validateHireDismissedEmployee(final SGuiSession session, final int employeeId, final boolean isHire) throws Exception {
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT COUNT(id_log) AS f_count " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EMP_LOG_HIRE) + " " +
            "WHERE b_del = 0 AND id_emp = " + employeeId + " AND dt_dis_n IS NULL ";
        
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            if (isHire && resultSet.getInt("f_count") > 0) {
                throw new Exception("Inconsistencia en la secuencia cronológica de movimientos en la bitácora de altas/bajas,\n existe al menos un movimiento de alta sin su baja correspondiente.");
            }
            else if (!isHire) {
                if (resultSet.getInt("f_count") > 1) {
                    throw new Exception("Inconsistencia en la secuencia cronológica de movimientos en la bitácora de altas/bajas,\n existe más de un movimiento de alta sin su baja correspondiente.");
                }
                else if (resultSet.getInt("f_count") == 0) {
                    throw new Exception("No existe ningún movimiento de alta previo.");
                }
            }
        }
        
        return true;
    }

    /**
     * @param session User GUI session.
     * @param year Payroll year.
     * @param number Payroll number.
     * @param paymentType Payroll payment type (constants defined in class <code>SModSysConsts</code>, HRSS_TP_PAY).
     * @return Default payroll period as an <code>java.util.Date</code> array.
     */
    public static Date[] getPayrollPeriod(final SGuiSession session, final int year, final int number, final int paymentType) throws SQLException, Exception {
        int month = 0;
        Date fdy = null;
        Date start = null;
        Date end = null;

        switch (paymentType) {
            case SModSysConsts.HRSS_TP_PAY_WEE:
                fdy = getFirstDayYear(session, year);
                start = SLibTimeUtils.addDate(fdy, 0, 0, (number - 1) * SHrsConsts.WEEK_DAYS);
                end = SLibTimeUtils.addDate(fdy, 0, 0, number * SHrsConsts.WEEK_DAYS - 1);
                break;

            case SModSysConsts.HRSS_TP_PAY_FOR:
                month = (int) SLibUtils.round(number / 2d, 0);
                if (number % 2 == 1) {
                    start = SLibTimeUtils.createDate(year, month, 1);
                    end = SLibTimeUtils.createDate(year, month, 15);
                }
                else {
                    start = SLibTimeUtils.createDate(year, month, 16);
                    end = SLibTimeUtils.getEndOfMonth(start);
                }
                break;

            default:
        }

        return new Date[] { start, end };
    }
    
    /**
     * 
     * @param session
     * @param paymentType
     * @return
     * @throws Exception 
     */
    public static SDbWorkingDaySettings getPayrollWorkingDaySettings(final SGuiSession session, final int paymentType) throws Exception {
        SDbWorkingDaySettings workingDaySettings = null;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_wds "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_WDS) + " "
                + "WHERE b_del = 0 AND fk_tp_pay = " + paymentType + " ";

        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            workingDaySettings = (SDbWorkingDaySettings) session.readRegistry(SModConsts.HRS_WDS, new int[] { resultSet.getInt(1) });
        }

        return workingDaySettings;
    }
    
    /**
     * 
     * @param dateStart
     * @param dateEnd
     * @param aHolidays
     * @param workingDaySettings
     * @return
     * @throws Exception 
     */
    public static int getEmployeeBusinessDays(final Date dateStart, final Date dateEnd, final ArrayList<SDbHoliday> aHolidays, final  SDbWorkingDaySettings workingDaySettings) throws Exception {
        int businessDays = 0;
        int difDays = 0;
        boolean dayWorked = false;
        Date dateReference = null;
        Calendar calendar = Calendar.getInstance();
        
        difDays = (int) SLibTimeUtils.getDaysDiff(dateEnd, dateStart);
            
        for (int i = 0; i <= difDays; i++) {
            dateReference = SLibTimeUtils.addDate(dateStart, 0, 0, i);
            dayWorked = true;

            // Is working day:

            calendar.setTime(dateReference);

            switch (calendar.get(Calendar.DAY_OF_WEEK)) {
                case 1:
                    dayWorked = workingDaySettings.isWeekdaySettingSunday();
                    break;
                case 2:
                    dayWorked = workingDaySettings.isWeekdaySettingMonday();
                    break;
                case 3:
                    dayWorked = workingDaySettings.isWeekdaySettingTuesday();
                    break;
                case 4:
                    dayWorked = workingDaySettings.isWeekdaySettingWednesday();
                    break;
                case 5:
                    dayWorked = workingDaySettings.isWeekdaySettingThursday();
                    break;
                case 6:
                    dayWorked = workingDaySettings.isWeekdaySettingFriday();
                    break;
                case 7:
                    dayWorked = workingDaySettings.isWeekdaySettingSaturday();
                    break;
                default:
            }

            // Is holiday:

            if (dayWorked) {
                for (SDbHoliday holiday : aHolidays) {
                    if (holiday.getDate().compareTo(dateReference) == 0) {
                        dayWorked = false;
                        break;
                    }
                }
            }

            if (dayWorked) {
                businessDays ++;
            }
        }
            
        return businessDays;
    }

    /**
     * Get earning by provided code
     * @param client SGuiClient
     * @param codeToFind Code of desired earning
     * @return Object Earning
     * @throws Exception
     */
    public static SDbEarning getEarning(final SGuiClient client, final String codeToFind) throws Exception {
        SDbEarning earning = null;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_ear " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EAR) + " " +
                "WHERE code = '" + codeToFind + "' ORDER BY code, id_ear LIMIT 1 ";
        resultSet = client.getSession().getStatement().executeQuery(sql);
        if (resultSet.next()) {
            earning = new SDbEarning();
            earning.read(client.getSession(), new int[] { resultSet.getInt("id_ear") });
        }

        return earning;
    }

    /**
     * Get deduction by provided code
     * @param client SGuiClient
     * @param codeToFind Code of desired deduction
     * @return Object Deduction
     * @throws Exception
     */
    public static SDbDeduction getDeduction(final SGuiClient client, final String codeToFind) throws Exception {
        SDbDeduction deduction = null;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_ded " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_DED) + " " +
                "WHERE code = '" + codeToFind + "' ORDER BY code, id_ded LIMIT 1 ";
        resultSet = client.getSession().getStatement().executeQuery(sql);
        if (resultSet.next()) {
            deduction = new SDbDeduction();
            deduction.read(client.getSession(), new int[] { resultSet.getInt("id_ded") });
        }

        return deduction;
    }
    
    /**
     * Get earning by provided type ID.
     * @param client SGuiClient
     * @param type type filter options: SModConsts.HRSS_TP_BEN or SModConsts.HRSS_TP_LOAN
     * @param typeId ID the type indicated.
     * @return Object Earning
     * @throws Exception
     */
    public static SDbEarning getEarningByType(final SGuiClient client, final int type, final int typeId) throws Exception {
        SDbEarning earning = null;
        String sql = "";
        String sqlType = "";
        ResultSet resultSet = null;
        
        switch (type) {
            case SModConsts.HRSS_TP_BEN:
                sqlType = "fk_tp_ben = " + typeId;
                break;
            case SModConsts.HRSS_TP_LOAN:
                sqlType = "fk_tp_loan = " + typeId;
                break;
            default:
                throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
        }

        sql = "SELECT id_ear " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EAR) + " " +
                "WHERE " + sqlType + " ORDER BY code, name, id_ear LIMIT 1 ";
        resultSet = client.getSession().getStatement().executeQuery(sql);
        if (resultSet.next()) {
            earning = new SDbEarning();
            earning.read(client.getSession(), new int[] { resultSet.getInt("id_ear") });
        }

        return earning;
    }

    /**
     * Get deduction by provided type ID.
     * @param client SGuiClient
     * @param type type filter options: SModConsts.HRSS_TP_BEN or SModConsts.HRSS_TP_LOAN
     * @param typeId ID the type indicated.
     * @return Object Deduction
     * @throws Exception
     */
    public static SDbDeduction getDeductionByType(final SGuiClient client, final int type, final int typeId) throws Exception {
        SDbDeduction deduction = null;
        String sql = "";
        String sqlType = "";
        ResultSet resultSet = null;
        
        switch (type) {
            case SModConsts.HRSS_TP_BEN:
                sqlType = "fk_tp_ben = " + typeId;
                break;
            case SModConsts.HRSS_TP_LOAN:
                sqlType = "fk_tp_loan = " + typeId;
                break;
            default:
                throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
        }

        sql = "SELECT id_ded " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_DED) + " " +
                "WHERE " + sqlType + " ORDER BY code, name, id_ded LIMIT 1 ";
        resultSet = client.getSession().getStatement().executeQuery(sql);
        if (resultSet.next()) {
            deduction = new SDbDeduction();
            deduction.read(client.getSession(), new int[] { resultSet.getInt("id_ded") });
        }

        return deduction;
    }

    /**
     * Gets benefits table by earning.
     * @param session
     * @param earningId
     * @param paymentType
     * @param dateCutOff
     * @return
     * @throws Exception if benefit table is not found or on SQL exception as well.
     */
    public static SDbBenefitTable getBenefitTableByEarning(final SGuiSession session, final int earningId, final int paymentType, final Date dateCutOff) throws Exception {
        SDbBenefitTable benefitTable = null;

        String sql = "SELECT id_ben "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " "
                + "WHERE b_del = 0 AND fk_ear = " + earningId + " AND "
                + "dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(dateCutOff) + "' AND "
                + "(fk_tp_pay_n IS NULL" + (paymentType == 0 ? "" : " OR fk_tp_pay_n = " + paymentType) + ") "
                + "ORDER BY fk_tp_pay_n DESC, dt_sta DESC, id_ben " // priority to requested payment type, if any, and then the most recent starting date
                + "LIMIT 1;";
        ResultSet resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            benefitTable = new SDbBenefitTable();
            benefitTable.read(session, new int[] { resultSet.getInt("id_ben") });
        }
        
        if (benefitTable == null) {
            throw new Exception(SDbConsts.ERR_MSG_REG_NOT_FOUND + "\nTabla de prestaciones adecuada para la fecha de corte '" + SLibUtils.DateFormatDate.format(dateCutOff) + "'.");
        }

        return benefitTable;
    }
    
    public static SDbBenefitTable getBenefitTableByDeduction(final SGuiSession session, final int deductionId, final Date dateCutOff) throws Exception {
        SDbBenefitTable benefitTable = null;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_ben "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " "
            + "WHERE b_del = 0 AND fk_ded_n = " + deductionId + " AND dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(dateCutOff) + "' "
            + "ORDER BY dt_sta DESC, id_ben "
            + "LIMIT 1;";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            benefitTable = new SDbBenefitTable();
            benefitTable.read(session, new int[] { resultSet.getInt("id_ben") });
        }

        return benefitTable;
    }
    
    public static String getDisabilityName(final SGuiClient client, final String codeToFind) throws Exception {
        String disabilityName = null;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT name " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_DIS) + " " +
                "WHERE code = '" + codeToFind + "' ORDER BY code, id_tp_dis LIMIT 1 ";
        resultSet = client.getSession().getStatement().executeQuery(sql);
        if (resultSet.next()) {
            disabilityName = resultSet.getString("name");
        }

        return disabilityName;
    }
    
    /**
     * Create anniversary entries from 1 to 99 for each given table of benefits.
     * @param benefitTables
     * @return Array of anniversaries (from 1 to 100) for each given table of benefits.
     */
    public static ArrayList<SHrsBenefitTableAnniversary> createBenefitTablesAnniversarys(ArrayList<SDbBenefitTable> benefitTables) {
        ArrayList<SHrsBenefitTableAnniversary> benefitTableAnniversarys = new ArrayList<>();
        
        benefitTables.stream().filter((table) -> (!table.getChildRows().isEmpty())).forEach((table) -> {
            int currIndex = 0;      // current index of rows of current benefit table
            double currValue = 0;   // current value, it can be days or bonus percentage
            SDbBenefitTableRow currTableRow = null;     // current benefit-table row
            SDbBenefitTableRow nextTableRow = null;     // next benefit-table row, when available
            
            for (int ann = 1; ann <= 100; ann++) {
                if (currTableRow == null || (nextTableRow != null && (ann * SLibTimeConsts.MONTHS >= nextTableRow.getMonths()))) {
                    if (currTableRow != null) {
                        currIndex++;
                    }
                    
                    currTableRow = table.getChildRows().get(currIndex);
                    nextTableRow = table.getChildRows().size() == currIndex + 1 ? null : table.getChildRows().get(currIndex + 1);
                    currValue = table.getFkBenefitTypeId() == SModSysConsts.HRSS_TP_BEN_VAC_BON ? currTableRow.getBenefitBonusPercentage() : currTableRow.getBenefitDays();
                }
                
                benefitTableAnniversarys.add(new SHrsBenefitTableAnniversary(table.getPkBenefitId(), ann, currValue));
            }
        });

        return benefitTableAnniversarys;
    }

    /**
     * Get recent tax table
     * @param session SGuiSession
     * @param start Date start date
     * @return id_tax int
     * @throws Exception
     */
    public static int getRecentTaxTable(final  SGuiSession session, final Date start) throws SQLException, Exception {
        int id_tax = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_tax "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_TAX) + " "
            + "WHERE b_del = 0 AND dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(start) + "' "
            + "ORDER BY dt_sta DESC, id_tax "
            + "LIMIT 1;";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            id_tax = resultSet.getInt(1);
        }

        return id_tax;
    }

    /**
     * Get recent tax subsidy table
     * @param session SGuiSession
     * @param start Date start date
     * @return id_tax_sub int
     * @throws Exception
     */
    public static int getRecentTaxSubsidyTable(final  SGuiSession session, final Date start) throws SQLException, Exception {
        int id_tax_sub = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_tax_sub "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_TAX_SUB) + " "
            + "WHERE b_del = 0 AND dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(start) + "' "
            + "ORDER BY dt_sta DESC, id_tax_sub "
            + "LIMIT 1;";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            id_tax_sub = resultSet.getInt(1);
        }

        return id_tax_sub;
    }

    /**
     * Get recent SS contribution table
     * @param session SGuiSession
     * @param start Date start date
     * @return id_ss int
     * @throws Exception
     */
    public static int getRecentSsContributionTable(final  SGuiSession session, final Date start) throws SQLException, Exception {
        int id_ss = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_ssc "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_SSC) + " "
            + "WHERE b_del = 0 AND dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(start) + "' "
            + "ORDER BY dt_sta DESC, id_ssc "
            + "LIMIT 1;";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            id_ss = resultSet.getInt(1);
        }

        return id_ss;
    }
    
    public static int getRecentBenefitTable(final SGuiSession session, final int benefitType, final int paymentType, final Date dateCutOff) throws Exception {
        int id_ben = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT id_ben "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " "
            + "WHERE b_del = 0 AND fk_tp_ben = " + benefitType + " AND dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(dateCutOff) + "' "
            + (paymentType == SLibConsts.UNDEFINED ? "AND fk_tp_pay_n IS NULL" : "AND (fk_tp_pay_n IS NULL OR fk_tp_pay_n = " + paymentType + ")") + " "
            + "ORDER BY dt_sta DESC, id_ben "
            + "LIMIT 1;";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            id_ben = resultSet.getInt(1);
        }

        return id_ben;
    }

    /**
     * Get recent minimum wage zone
     * @param session SGuiSession
     * @param idMwzType Minimum wage zone
     * @param start Date start date
     * @return wage double
     * @throws Exception
     */
    public static double getRecentMwz(final  SGuiSession session, final int idMwzType, final Date start) throws SQLException, Exception {
        double wage = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT wage "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_MWZ_WAGE) + " "
            + "WHERE b_del = 0 AND id_tp_mwz = " + idMwzType + " AND dt_sta <= '" + SLibUtils.DbmsDateFormatDate.format(start) + "' "
            + "ORDER BY dt_sta DESC, id_tp_mwz, id_wage "
            + "LIMIT 1;";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            wage = resultSet.getDouble(1);
        }

        return wage;
    }

    public static HashMap<String, Object> getMapPayrollReceipt(final SGuiClient client, final int pnPrintMode, final int[] payrollKey) throws java.lang.Exception {
        double dTotalPercepciones = 0;
        double dTotalDeducciones = 0;
        SDbLoan loan = null;
        SDataBizPartner bizPartnerCompany = null;
        SDataBizPartner bizPartnerEmployee = null;
        SDbPayrollReceipt payrollReceipt = null;
        SDbPayroll payroll = null;
        HashMap<String, Object> map = null;
        ArrayList aPercepciones = null;
        ArrayList aDeducciones = null;
        DecimalFormat oFixedFormatAux = null;

        payroll = new SDbPayroll();
        payroll.read(client.getSession(), new int[] { payrollKey[0] });
        
        for (SDbPayrollReceipt receipt : payroll.getChildPayrollReceipts()) {
            if (SLibUtils.compareKeys(receipt.getPrimaryKey(), new int[] { payrollKey[0], payrollKey[1] })) {
                payrollReceipt = receipt;
            }
        }

        bizPartnerCompany = new SDataBizPartner();
        bizPartnerCompany.read(new int[] { ((SClientInterface) client).getSessionXXX().getCompany().getPkCompanyId() }, client.getSession().getStatement());

        bizPartnerEmployee = new SDataBizPartner();
        bizPartnerEmployee.read(new int[] { payrollReceipt.getPkEmployeeId() }, client.getSession().getStatement());

        oFixedFormatAux = new DecimalFormat(SLibUtils.textRepeat("0", 2));

        map = client.createReportParams();

        map.put("bIsReceipt", true);

        map.put("sEmiRfc", bizPartnerCompany.getFiscalId());
        map.put("sRecRfc", bizPartnerEmployee.getFiscalId());
        map.put("ReceptorNombre", bizPartnerEmployee.getBizPartner());
        map.put("nPayrrollId", payrollReceipt.getPkPayrollId());
        map.put("nEmployeeId", payrollReceipt.getPkEmployeeId());
        map.put("NominaNumTipo", payroll.getNumber() + "  " + (String) client.getSession().readField(SModConsts.HRSS_TP_PAY, new int[] { payroll.getFkPaymentTypeId() }, SDbRegistry.FIELD_NAME));
        map.put("NominaFolio", "");

        SimpleDateFormat oSimpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        map.put("RegistroPatronal", ((SClientInterface) client).getSessionXXX().getParamsCompany().getRegistrySs());
        map.put("CURP", bizPartnerEmployee.getAlternativeId());
        map.put("NumEmpleado", bizPartnerEmployee.getDbmsDataEmployee().getNumber());
        map.put("NumSeguridadSocial", bizPartnerEmployee.getDbmsDataEmployee().getSocialSecurityNumber());
        map.put("FechaInicialPago", oSimpleDateFormat.format(payroll.getDateStart()));
        map.put("FechaFinalPago", oSimpleDateFormat.format(payroll.getDateEnd()));
        map.put("NumDiasNoLaborados", payrollReceipt.getDaysNotWorkedPaid() + payrollReceipt.getDaysNotWorkedNotPaid());
        map.put("NumDiasLaborados", payrollReceipt.getDaysWorked());
        map.put("NumDiasPagados", payrollReceipt.getDaysPaid());
        map.put("Departamento", (String) client.getSession().readField(SModConsts.HRSU_DEP, new int[] { bizPartnerEmployee.getDbmsDataEmployee().getFkDepartmentId() }, SDbRegistry.FIELD_NAME));
        map.put("Puesto", (String) client.getSession().readField(SModConsts.HRSU_POS, new int[] { bizPartnerEmployee.getDbmsDataEmployee().getFkPositionId() }, SDbRegistry.FIELD_NAME));
        map.put("PeriodicidadPago", (String) client.getSession().readField(SModConsts.HRSS_TP_PAY, new int[] { bizPartnerEmployee.getDbmsDataEmployee().getFkPaymentTypeId() }, SDbRegistry.FIELD_NAME));
        //map.put("Sueldo", bizPartnerEmployee.getDbmsDataEmployee().getSalary());
        map.put("Sueldo", payrollReceipt.getFkPaymentTypeId() == SModSysConsts.HRSS_TP_PAY_WEE ? payrollReceipt.getSalary() : ((payrollReceipt.getWage() * SHrsConsts.YEAR_MONTHS) / SHrsConsts.YEAR_DAYS));
        //map.put("SalarioBaseCotApor", bizPartnerEmployee.getDbmsDataEmployee().getSalarySscBase());
        //map.put("SalarioDiarioIntegrado", bizPartnerEmployee.getDbmsDataEmployee().getSalarySscBase());
        map.put("SalarioBaseCotApor", payrollReceipt.getSalarySscBase());
        map.put("SalarioDiarioIntegrado", payrollReceipt.getSalarySscBase());

        map.put("FechaInicioRelLaboral", oSimpleDateFormat.format(bizPartnerEmployee.getDbmsDataEmployee().getDateLastHire()));
        map.put("TipoJornada", bizPartnerEmployee.getDbmsDataEmployee().getWorkingHoursDay() + " hr");

        map.put("TipoEmpleado", (String) client.getSession().readField(SModConsts.HRSU_TP_EMP, new int[] { bizPartnerEmployee.getDbmsDataEmployee().getFkEmployeeTypeId() }, SDbRegistry.FIELD_NAME));
        map.put("TipoSalario", (String) client.getSession().readField(SModConsts.HRSS_TP_SAL, new int[] { bizPartnerEmployee.getDbmsDataEmployee().getFkSalaryTypeId() }, SDbRegistry.FIELD_NAME));

        map.put("Ejercicio", payroll.getPeriodYear() + "-" + oFixedFormatAux.format(payroll.getPeriod()));

        aPercepciones = new ArrayList();
        aDeducciones = new ArrayList();

        dTotalPercepciones = 0;
        dTotalDeducciones = 0;

        // Earnings:

        for (SDbPayrollReceiptEarning receiptEarning : payrollReceipt.getChildPayrollReceiptEarnings()) {
            SDbEarning earning = new SDbEarning();
            loan = null;

            earning.read(client.getSession(),  new int[] { receiptEarning.getFkEarningId() });

            if (receiptEarning.getFkLoanEmployeeId_n() != SLibConsts.UNDEFINED) {
                loan = new SDbLoan();

                loan.read(client.getSession(), new int[] { receiptEarning.getFkLoanEmployeeId_n(), receiptEarning.getFkLoanLoanId_n() });
            }

            aPercepciones.add(earning.getCode());
            aPercepciones.add(earning.getCode());
            aPercepciones.add(earning.getName() + (loan == null ? "" : " (" + loan.getLoanIdentificator() + ") "));
            aPercepciones.add(earning.getFkEarningComputationTypeId() == SModSysConsts.HRSS_TP_EAR_COMP_AMT ? null : receiptEarning.getUnits());
            aPercepciones.add(earning.getFkEarningComputationTypeId() == SModSysConsts.HRSS_TP_EAR_COMP_AMT ? null : (String) client.getSession().readField(SModConsts.HRSS_TP_EAR_COMP, new int[] { earning.getFkEarningComputationTypeId() }, SDbRegistry.FIELD_CODE));
            aPercepciones.add(receiptEarning.getAmount_r());
            aPercepciones.add(null);

            dTotalPercepciones += receiptEarning.getAmount_r();
        }

        for (int j = payrollReceipt.getChildPayrollReceiptEarnings().size(); j < 10; j++) {
            aPercepciones.add(null);
            aPercepciones.add(null);
            aPercepciones.add(null);
            aPercepciones.add(null);
            aPercepciones.add(null);
            aPercepciones.add(null);
            aPercepciones.add(null);
        }

        // Deductions:

        for (SDbPayrollReceiptDeduction receiptDeduction : payrollReceipt.getChildPayrollReceiptDeductions()) {
            SDbDeduction deduction = new SDbDeduction();
            loan = null;

            deduction.read(client.getSession(),  new int[] { receiptDeduction.getFkDeductionId() });

            if (receiptDeduction.getFkLoanEmployeeId_n() != SLibConsts.UNDEFINED) {
                loan = new SDbLoan();

                loan.read(client.getSession(), new int[] { receiptDeduction.getFkLoanEmployeeId_n(), receiptDeduction.getFkLoanLoanId_n() });
            }

            aDeducciones.add(deduction.getCode());
            aDeducciones.add(deduction.getCode());
            aDeducciones.add(deduction.getName() + (loan == null ? "" : " (" + loan.getLoanIdentificator() + ") "));
            aDeducciones.add(receiptDeduction.getAmount_r());
            aDeducciones.add(null);

            dTotalDeducciones += receiptDeduction.getAmount_r();
        }

        for (int j = payrollReceipt.getChildPayrollReceiptDeductions().size(); j < 10; j++) {
            aDeducciones.add(null);
            aDeducciones.add(null);
            aDeducciones.add(null);
            aDeducciones.add(null);
            aDeducciones.add(null);
        }

        map.put("oPerceptions", aPercepciones);
        map.put("oDeductions", aDeducciones);
        map.put("TotalPercepcionesGravado", dTotalPercepciones);
        map.put("TotalDeduccionesGravado", dTotalDeducciones);
        map.put("TotalNeto", dTotalPercepciones - dTotalDeducciones);
        
        return map;
    }
    
    /**
     * Print payrroll receipt
     * @param client Interface Client
     * @param pnPrintMode print mode (e.g. SDataConstantsPrint.PRINT_MODE_)
     * @param payrollKey payrroll key
     * @throws java.lang.Exception
     */
    public static void printPayrollReceipt(final SGuiClient client, final int pnPrintMode, final int[] payrollKey) throws java.lang.Exception {
        HashMap<String, Object> map = new HashMap<>();
        map = getMapPayrollReceipt(client,pnPrintMode,payrollKey);
        
        switch (pnPrintMode) {
            case SDataConstantsPrint.PRINT_MODE_VIEWER:
                client.getSession().printReport(SModConsts.HRSR_PAY_RCP, SLibConsts.UNDEFINED, null, map);
                break;
            case SDataConstantsPrint.PRINT_MODE_PDF_FILE:
                break;
            case SDataConstantsPrint.PRINT_MODE_PRINT:
                break;
            default:
                throw new Exception(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
        }
    }
    
    public static void sendPayrollReceipt(final SGuiClient client, final int pnPrintMode, final int[] payrollKey) throws java.lang.Exception {
        boolean isSent = false;
        HashMap<String, Object> map = new HashMap<>();
        File pdf = null;
        STreasuryBankLayoutRequest layoutRequest = new STreasuryBankLayoutRequest(client, null);
        
        map = getMapPayrollReceipt(client, pnPrintMode, payrollKey);
        pdf = createPayrollReceipt(map, client);
        
        SDataBizPartner bizPartner  = (SDataBizPartner) SDataUtilities.readRegistry((SClientInterface) client, SDataConstants.BPSU_BP, new int[] { (Integer)map.get("nEmployeeId") }, SLibConstants.EXEC_MODE_SILENT);
        String mail = bizPartner.getDbmsHqBranch().getDbmsBizPartnerBranchContacts().get(0).getEmail01();
            
        if (pdf != null) {
            isSent = layoutRequest.sendMail(null, "", pdf, STreasuryBankLayoutRequest.SND_TP_PAY_RCP, mail);
            if (isSent) {
                client.showMsgBoxInformation("El recibo de nómina ha sido enviado correctamente.\n");
            }
            else {
                client.showMsgBoxInformation("El recibo de nómina no ha sido enviado.\n");
            }
        }
    }
    
    public static void sendPayrollReceipts(final SGuiClient client, final int pnPrintMode, final int[] payrollKey) throws java.lang.Exception {
        ArrayList<SDbPayrollReceipt> actives = new ArrayList<SDbPayrollReceipt>();
        SDbPayroll payroll = new SDbPayroll();
        payroll.read(client.getSession(), new int[] { payrollKey[0] });
        
        for (SDbPayrollReceipt receipt : payroll.getChildPayrollReceipts()) {
            if (!receipt.isDeleted()) {
                actives.add(receipt);
            }
        }
        
        SDialogResult dialogResult = new SDialogResult((SClient) client, "Resultados de envío", SCfdConsts.PROC_REQ_SND_RCP);
        dialogResult.setFormParams((SClientInterface) client, null, null, 0, null, true, SLibConsts.UNDEFINED, SModSysConsts.TRNU_TP_DPS_ANN_NA);
        dialogResult.setReceipts(actives);
        dialogResult.setVisible(true);
    }
    
    /**
     * Create a object File in PDF format payroll receipt
     * @param map Obj HashMap with all information about payroll receipt
     * @param client interface Client
     * @return Object file payroll receipt
     */
    public static File createPayrollReceipt(HashMap<String, Object> map, SGuiClient client) {
        JasperPrint jasperPrint = null;
        byte[] reportBytes = null;
        File file = null;
        File fileTemporal = null;
        FileOutputStream fos = null;
        JasperReport reporte = null;
        
        try {
            fileTemporal = new File("reps/hrs_pay_rcp.jasper");
            reporte = (JasperReport) JRLoader.loadObject(fileTemporal);
            
            jasperPrint = JasperFillManager.fillReport(reporte, map,client.getSession().getDatabase().getConnection());
            reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
            fileTemporal = File.createTempFile("document", ".pdf");
            fos = new FileOutputStream(fileTemporal);
            fos.write(reportBytes);
            fos.close();

            file = new File(fileTemporal.getParentFile() + "\\"+ "Recibo de nomina.pdf");
            fos = new FileOutputStream(file);
            fos.write(reportBytes);
            fos.close();
        }
        catch (Exception e) {
            SLibUtils.showException(STreasuryBankLayoutFile.class, e);
        }
        
        return file;  
    }
    
    public static void printPrePayroll(final SGuiClient client, final int payrollKey) throws java.lang.Exception {
        HashMap<String, Object> map = null;
        SDataBizPartner bizPartnerCompany = null;

        bizPartnerCompany = new SDataBizPartner();
        bizPartnerCompany.read(new int[] { ((SClientInterface) client).getSessionXXX().getCompany().getPkCompanyId() }, client.getSession().getStatement());
        
        map = client.createReportParams();
        
        map.put("nPayrollId", payrollKey);
        map.put("RegistroPatronal", ((SClientInterface) client).getSessionXXX().getParamsCompany().getRegistrySs());
        map.put("sEmiRfc", bizPartnerCompany.getFiscalId());
        
        client.getSession().printReport(SModConsts.HRSR_PRE_PAY, SLibConsts.UNDEFINED, null, map);
    }
    
    /**
     * Obtain consumption days in payrolls previous
     * @param absence Absence registry consumption
     * @param hrsEmployee Object the employee
     * @return int; consumption days in payrolls previous
     */
    public static int getConsumptionPreviousDays(final SDbAbsence absence, final SHrsEmployee hrsEmployee) {
        int consumptionPreviousDays = 0;
        
        for (SDbAbsenceConsumption absenceConsumptionAux : hrsEmployee.getAbsencesConsumptions()) {
            if (absence.getPkAbsenceId() == absenceConsumptionAux.getPkAbsenceId() &&
                    absence.getPkEmployeeId() == absenceConsumptionAux.getPkEmployeeId()) {
                consumptionPreviousDays += absenceConsumptionAux.getEffectiveDays();
            }
        }
        
        for (SDbAbsenceConsumption absenceConsumptionAux : hrsEmployee.getHrsPayrollReceipt().getAbsenceConsumptions()) {
            if (absence.getPkAbsenceId() == absenceConsumptionAux.getPkAbsenceId() &&
                    absence.getPkEmployeeId() == absenceConsumptionAux.getPkEmployeeId()) {
                consumptionPreviousDays += absenceConsumptionAux.getEffectiveDays();
            }
        }
        
        return consumptionPreviousDays;
    }
    
    /**
     * Obtain last date consumption
     * @param absence Absence registry consumption
     * @param hrsEmployee Object the employee
     * @return Date; last date consumption
     */
    public static Date getConsumptionDateLast(final SDbAbsence absence, final SHrsEmployee hrsEmployee) {
        Date dateConsumptionLast = null;
        
        for (SDbAbsenceConsumption absenceConsumptionAux : hrsEmployee.getHrsPayrollReceipt().getAbsenceConsumptions()) {
            if (absence.getPkAbsenceId() == absenceConsumptionAux.getPkAbsenceId() &&
                    absence.getPkEmployeeId() == absenceConsumptionAux.getPkEmployeeId()) {
                dateConsumptionLast = absenceConsumptionAux.getDateEnd();
            }
        }
        
        if (dateConsumptionLast == null) {
            for (SDbAbsenceConsumption absenceConsumptionAux : hrsEmployee.getAbsencesConsumptions()) {
                if (absence.getPkAbsenceId() == absenceConsumptionAux.getPkAbsenceId() &&
                        absence.getPkEmployeeId() == absenceConsumptionAux.getPkEmployeeId()) {
                    dateConsumptionLast = absenceConsumptionAux.getDateEnd();
                }
            }
        }
        
        return dateConsumptionLast;
    }
    
    /**
     * Obtain ID next of consumption
     * @param absence Absence registry consumption
     * @param hrsEmployee Object the employee
     * @return int; ID next of consumption
     */
    public static int getConsumptionNextId(final SDbAbsence absence, final SHrsEmployee hrsEmployee) {
        int consumptionLast = 0;
        
        for (SDbAbsenceConsumption absenceConsumptionAux : hrsEmployee.getHrsPayrollReceipt().getAbsenceConsumptions()) {
            if (absence.getPkAbsenceId() == absenceConsumptionAux.getPkAbsenceId() &&
                    absence.getPkEmployeeId() == absenceConsumptionAux.getPkEmployeeId()) {
                consumptionLast = absenceConsumptionAux.getPkConsumptionId();
            }
        }
        
        return consumptionLast + 1;
    }
    
    /**
     * Obtain balance loan
     * @param loan Registry loan
     * @param hrsEmployee SHrsEmployee registry the employee
     * @return double; balance loan
     * @throws Exception 
     */
    public static double getBalanceLoan(final SDbLoan loan, final SHrsEmployee hrsEmployee) throws Exception {
        double balance = 0;
        
        balance = loan.getTotalAmount();
        
        if (hrsEmployee.getLoanPayment(loan.getPkLoanId()) != null) {
            balance += hrsEmployee.getLoanPayment(loan.getPkLoanId()).getTotalEarnings();
        }
        
        if (hrsEmployee.getLoanPayment(loan.getPkLoanId()) != null) {
            balance -= hrsEmployee.getLoanPayment(loan.getPkLoanId()).getTotalPayment();
        }
        
        for (SHrsPayrollReceiptEarning earning : hrsEmployee.getHrsPayrollReceipt().getHrsEarnings()) {
            if (SLibUtils.compareKeys(new int[] { earning.getReceiptEarning().getFkLoanEmployeeId_n(), earning.getReceiptEarning().getFkLoanLoanId_n()}, 
                    loan.getPrimaryKey()) && earning.getReceiptEarning().isUserEdited()) {
                balance += earning.getReceiptEarning().getAmount_r();
            }
        }
        
        for (SHrsPayrollReceiptDeduction deduction : hrsEmployee.getHrsPayrollReceipt().getHrsDeductions()) {
            if (SLibUtils.compareKeys(new int[] { deduction.getReceiptDeduction().getFkLoanEmployeeId_n(), deduction.getReceiptDeduction().getFkLoanLoanId_n()}, 
                    loan.getPrimaryKey()) && deduction.getReceiptDeduction().isUserEdited()) {
                balance -= deduction.getReceiptDeduction().getAmount_r();
            }
        }
        
        return balance;
    }
    
    public static double getIntegrationFactorSbc(final SGuiSession session, final Date dateBenefits, final Date dateCutOff) throws Exception {
        int seniority = 0;
        int daysTableVacation = 0;
        int daysTableAnnualBonus = 0;
        double percentageTableVacationBonus = 0;
        double salaryUnit = 1;
        double integrationFactorSbc = 0;
        SHrsBenefitTableAnniversary benefitTableAnniversary = null;
        ArrayList<SDbBenefitTable> benefitTableVacation = new ArrayList<>();
        ArrayList<SDbBenefitTable> benefitTableAnnualBonus = new ArrayList<>();
        ArrayList<SDbBenefitTable> benefitTableVacationBonus = new ArrayList<>();
        
        benefitTableVacation.add((SDbBenefitTable) session.readRegistry(SModConsts.HRS_BEN, new int[] { getRecentBenefitTable(session, SModSysConsts.HRSS_TP_BEN_VAC, SLibConsts.UNDEFINED, dateCutOff) }));
        benefitTableAnnualBonus.add((SDbBenefitTable) session.readRegistry(SModConsts.HRS_BEN, new int[] { getRecentBenefitTable(session, SModSysConsts.HRSS_TP_BEN_ANN_BON, SLibConsts.UNDEFINED, dateCutOff) }));
        benefitTableVacationBonus.add((SDbBenefitTable) session.readRegistry(SModConsts.HRS_BEN, new int[] { getRecentBenefitTable(session, SModSysConsts.HRSS_TP_BEN_VAC_BON, SLibConsts.UNDEFINED, dateCutOff) }));
        
        if (dateBenefits != null) {
            seniority = getSeniorityEmployee(dateBenefits, dateCutOff);
        }
        else {
            seniority = 1;
        }
        
        ArrayList<SHrsBenefitTableAnniversary> benefitTableVacationAnniversarys = createBenefitTablesAnniversarys(benefitTableVacation);
        ArrayList<SHrsBenefitTableAnniversary> benefitTableAnnualBonusAnniversarys = createBenefitTablesAnniversarys(benefitTableAnnualBonus);
        ArrayList<SHrsBenefitTableAnniversary> benefitTableVacationBonusAnniversarys = createBenefitTablesAnniversarys(benefitTableVacationBonus);
        
        for (SHrsBenefitTableAnniversary anniversary : benefitTableVacationAnniversarys) {
            if (anniversary.getBenefitAnn() <= seniority) {
                benefitTableAnniversary = anniversary;
            }
        }
        daysTableVacation = benefitTableAnniversary == null ? 0 : (int) benefitTableAnniversary.getValue();
        
        for (SHrsBenefitTableAnniversary anniversary : benefitTableAnnualBonusAnniversarys) {
            if (anniversary.getBenefitAnn() <= seniority) {
                benefitTableAnniversary = anniversary;
            }
        }
        daysTableAnnualBonus = benefitTableAnniversary == null ? 0 : (int) benefitTableAnniversary.getValue();
        
        for (SHrsBenefitTableAnniversary anniversary : benefitTableVacationBonusAnniversarys) {
            if (anniversary.getBenefitAnn() <= seniority) {
                benefitTableAnniversary = anniversary;
            }
        }
        percentageTableVacationBonus = benefitTableAnniversary == null ? 0 : (double) benefitTableAnniversary.getValue();
        
        integrationFactorSbc = salaryUnit + ((double) daysTableAnnualBonus / SHrsConsts.YEAR_DAYS) + (double) (daysTableVacation * percentageTableVacationBonus / SHrsConsts.YEAR_DAYS);
        
        return integrationFactorSbc;
    }
    
    public static String getEmployeeNextNumber(Connection connection) throws Exception {
        String nextNumber = "";
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT COALESCE(MAX(CAST(num AS UNSIGNED INTEGER)), 0) + 1 "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + "; ";

        resultSet = connection.createStatement().executeQuery(sql);
        if (resultSet.next()) {
            nextNumber = resultSet.getInt(1) + "";
        }

        return nextNumber;
    }
    
    public static int getSeniorityEmployee(final Date dateBenefits, final Date dateCutOff) {
        DateTime start = new DateTime(dateBenefits);
        DateTime end = new DateTime(dateCutOff);
        Period period = new Period(start, end);
        
        return period.getYears();
    }
    
    public static int getPaymentVacationsByEmployee(final SGuiSession session, final int employeeId, final int benefitAnn, final int benefitYear) throws Exception {
        int seniority = 0;
        String sql = "";
        ResultSet resultSet = null;
        
        sql = "SELECT COALESCE(SUM(ear.unt_all), 0) AS f_payed_unt " +
                "FROM hrs_pay_rcp AS rcp " +
                "INNER JOIN hrs_pay_rcp_ear AS ear ON ear.id_pay = rcp.id_pay AND ear.id_emp = rcp.id_emp " +
                "WHERE rcp.id_emp = " + employeeId + " AND rcp.b_del = 0 AND ear.b_del = 0 AND ear.fk_tp_ben = 21 AND ear.ben_ann = " + benefitAnn + 
                " AND ear.ben_year = " + benefitYear + " ";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            seniority = resultSet.getInt(1);
        }
        
        return seniority;
    }
    
    public static int getDaysVacationsAll(final SGuiSession session, final int benefitAnn, final Date dateCutOff) throws Exception {
        int daysTableVacation = 0;
        ArrayList<SDbBenefitTable> aTableVacation = new ArrayList<SDbBenefitTable>();
        ArrayList<SHrsBenefitTableAnniversary> aTableVacationByAnniversary = new ArrayList<SHrsBenefitTableAnniversary>();
        
        aTableVacation.add((SDbBenefitTable) session.readRegistry(SModConsts.HRS_BEN, new int[] { getRecentBenefitTable(session, SModSysConsts.HRSS_TP_BEN_VAC, SLibConsts.UNDEFINED, dateCutOff) }));
        
        aTableVacationByAnniversary = createBenefitTablesAnniversarys(aTableVacation);
        
        for (SHrsBenefitTableAnniversary anniversary : aTableVacationByAnniversary) {
            if (anniversary.getBenefitAnn() <= benefitAnn) {
                daysTableVacation += (int) anniversary.getValue();
            }
        }
        
        return daysTableVacation;
    }

    public static ArrayList<SDbEmployeeHireLog> getEmployeeHireLogs(final SGuiSession session, final int employeeId, final Date dateStart, final Date dateEnd) throws Exception {
        ArrayList<SDbEmployeeHireLog> aEmployeeHireLogs = new ArrayList<SDbEmployeeHireLog>();
        SDbEmployeeHireLog employeeHireLog = null;
        String sql = "";

        ResultSet resultSet = null;
        Statement statement = session.getDatabase().getConnection().createStatement();

        sql = "SELECT id_emp, id_log " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EMP_LOG_HIRE) + " " +
            "WHERE b_del = 0 AND id_emp = " + employeeId + " AND (dt_hire <= '" + SLibUtils.DbmsDateFormatDate.format(dateEnd) + "' AND " +
            "(dt_dis_n IS NULL OR dt_dis_n >= '" + SLibUtils.DbmsDateFormatDate.format(dateStart) + "')) ";
        
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            employeeHireLog = new SDbEmployeeHireLog();
            employeeHireLog.read(session, new int[] { resultSet.getInt("id_emp"), resultSet.getInt("id_log") });
            aEmployeeHireLogs.add(employeeHireLog);
        }

        return aEmployeeHireLogs;
    }
    
    public static SDbEmployeeHireLog getEmployeeLastHired(final SGuiSession session, final int employeeId, final int logId, final String table) throws Exception {
        String sql = "";
        ResultSet resultSet = null;
        SDbEmployeeHireLog employeeHireLog = null;
        
        sql = "SELECT id_emp, id_log " +
            "FROM " + (table.isEmpty() ? "" : (table + ".")) + SModConsts.TablesMap.get(SModConsts.HRS_EMP_LOG_HIRE) + " " +
            "WHERE b_del = 0 AND id_emp = " + employeeId + " AND dt_dis_n IS NULL AND id_log <> " + logId + " " +
            "ORDER BY dt_hire DESC, id_emp, id_log " +
            "LIMIT 1 ";
        
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            employeeHireLog = new SDbEmployeeHireLog();
            employeeHireLog.read(session, new int[] { resultSet.getInt("id_emp"), resultSet.getInt("id_log") });
        }
        
        return employeeHireLog;
    }
    
    public static SDbEmployeeHireLog getEmployeeLastDismiss(final SGuiSession session, final int employeeId, final int logId, final String table) throws Exception {
        String sql = "";
        ResultSet resultSet = null;
        SDbEmployeeHireLog employeeHireLog = null;
        
        sql = "SELECT id_emp, id_log " +
            "FROM " + (table.isEmpty() ? "" : (table + ".")) + SModConsts.TablesMap.get(SModConsts.HRS_EMP_LOG_HIRE) + " " +
            "WHERE b_del = 0 AND id_emp = " + employeeId + " AND dt_dis_n IS NOT NULL AND id_log <> " + logId + " " +
            "ORDER BY dt_dis_n DESC, id_emp, id_log " +
            "LIMIT 1 ";
        
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            employeeHireLog = new SDbEmployeeHireLog();
            employeeHireLog.read(session, new int[] { resultSet.getInt("id_emp"), resultSet.getInt("id_log") });
        }
        
        return employeeHireLog;
    }
    
    public static int getEmployeeHireDays(final ArrayList<SDbEmployeeHireLog> aEmployeeHireLogs, final Date dateStart, final Date dateEnd) throws Exception {
        int daysHired = 0;
        
        for (SDbEmployeeHireLog hireLog : aEmployeeHireLogs) {
            if (hireLog.getDateHire().compareTo(dateStart) <= 0) {
                daysHired += SLibTimeUtils.getDaysDiff(hireLog.getDateDismissed_n() == null ? dateEnd : hireLog.getDateDismissed_n().compareTo(dateEnd) >= 0 ? dateEnd : hireLog.getDateDismissed_n(), dateStart) + 1;
            }
            else if (hireLog.getDateHire().compareTo(dateStart) >= 0) {
                daysHired += SLibTimeUtils.getDaysDiff(hireLog.getDateDismissed_n() == null ? dateEnd : hireLog.getDateDismissed_n().compareTo(dateEnd) >= 0 ? dateEnd : hireLog.getDateDismissed_n(), hireLog.getDateHire()) + 1;
            }
        }
        
        return daysHired;
    }
    
    public static int getEmployeeIncapacityNotPayed(final ArrayList<SDbAbsenceConsumption> aAbsenceConsumptions, final Date dateStart, final Date dateEnd) {
        int daysIncapacityNotPaidAnnual = 0;
        
        for (SDbAbsenceConsumption absenceConsumption : aAbsenceConsumptions) {
            if (SLibTimeUtils.isBelongingToPeriod(absenceConsumption.getDateStart(), dateStart, dateEnd) && 
                    absenceConsumption.getAbsence().getFkAbsenceClassId() == SModSysConsts.HRSU_CL_ABS_DIS && !absenceConsumption.getAbsence().IsAuxAbsencePayable()) {
                daysIncapacityNotPaidAnnual += absenceConsumption.getEffectiveDays();
            }
        }
        
        return daysIncapacityNotPaidAnnual;
    }
    
    public static ArrayList<SDbAbsenceConsumption> getEmployeeAbsencesConsumption(final SGuiSession session, final ArrayList<SDbAbsence> aAbsences, final int payrollId) throws Exception {
        ArrayList<SDbAbsenceConsumption> aAbsencesConsumptions = new ArrayList<SDbAbsenceConsumption>();
        SDbAbsenceConsumption absenceConsumption = null;
        String sql = "";
        ResultSet resultSet = null;
        Statement statement = session.getDatabase().getConnection().createStatement();

        for (SDbAbsence absence : aAbsences) {
            sql = "SELECT id_cns " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_ABS_CNS) + " " +
            "WHERE b_del = 0 AND id_emp = " + absence.getPkEmployeeId() + " AND id_abs = " + absence.getPkAbsenceId() + " AND fk_rcp_pay <> " + payrollId + " " +
            "ORDER BY id_emp, id_abs, id_cns ";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                absenceConsumption = new SDbAbsenceConsumption();
                absenceConsumption.read(session, new int[] { absence.getPkEmployeeId(), absence.getPkAbsenceId(), resultSet.getInt("id_cns") });
                aAbsencesConsumptions.add(absenceConsumption);
            }
        }
        
        return aAbsencesConsumptions;
    }
    
    public static ArrayList<SDbAbsence> getEmployeeAbsences(final SGuiSession session, final int employeeId) throws Exception {
        ArrayList<SDbAbsence> aAbsences = new ArrayList<SDbAbsence>();
        SDbAbsence absence = null;
        String sql = "";
        ResultSet resultSet = null;
        Statement statement = session.getDatabase().getConnection().createStatement();

        sql = "SELECT id_emp, id_abs, eff_day " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_ABS) + " " +
            "WHERE b_del = 0 AND b_clo = 0 AND id_emp = " + employeeId + " " +
            "ORDER BY dt_sta, id_emp, id_abs ";

        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            absence = new SDbAbsence();
            absence.read(session, new int[] { resultSet.getInt("id_emp"), resultSet.getInt("id_abs") });
            aAbsences.add(absence);
        }
        
        return aAbsences;
    }
    
    public static boolean isFirtsHire(final SGuiSession session, final int employeeId, final int logId, final String table) throws Exception {
        String sql = "";
        ResultSet resultSet = null;
        boolean isFirts = false;
        SDbEmployeeHireLog employeeHireLog = null;
        
        sql = "SELECT COUNT(*) AS f_count, id_log " +
            "FROM " + (table.isEmpty() ? "" : (table + ".")) + SModConsts.TablesMap.get(SModConsts.HRS_EMP_LOG_HIRE) + " " +
            "WHERE b_del = 0 AND id_emp = " + employeeId + " ";
        
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next() && resultSet.getInt("f_count") == 1) {
            employeeHireLog = new SDbEmployeeHireLog();
            employeeHireLog.read(session, new int[] { employeeId, resultSet.getInt("id_log") });
            isFirts = employeeHireLog.getDateDismissed_n() == null;
        }
        
        return isFirts;
    }
    
    public static boolean deleteHireLog(final SGuiSession session, final int employeeId) throws Exception {
        SDbEmployee employee = null;
        SDbEmployeeHireLog employeeHireLog;
        SHrsEmployeeHireLog hrsEmployeeHireLog;
        
        employee = new SDbEmployee();
        employeeHireLog = new SDbEmployeeHireLog();
        hrsEmployeeHireLog = new SHrsEmployeeHireLog(null,session);
                
        employee.read(session, new int[] { employeeId });

        if (SHrsUtils.isFirtsHire(session, employee.getPkEmployeeId(), SLibConsts.UNDEFINED, "")) {
            throw new Exception("El registro no se puede eliminar, es el único registro en la bitácora de alts/bajas.");
        }
        else {
            if (employee.isActive()) {
                employeeHireLog = SHrsUtils.getEmployeeLastHired(session, employee.getPkEmployeeId(), SLibConsts.UNDEFINED, "");
            }
            else {
                employeeHireLog = SHrsUtils.getEmployeeLastDismiss(session, employee.getPkEmployeeId(), SLibConsts.UNDEFINED, "");
            }

            hrsEmployeeHireLog.setPkEmployeeId(employeeHireLog.getPkEmployeeId());
            hrsEmployeeHireLog.setDateLastHire(employeeHireLog.getDateHire());
            hrsEmployeeHireLog.setIsHire(!employee.isActive());
            hrsEmployeeHireLog.setDeleted(employeeHireLog.isDeleted());
            hrsEmployeeHireLog.setDateLastHire(employeeHireLog.getDateHire());
            hrsEmployeeHireLog.setNotesHire(employeeHireLog.getNotesHire());
            hrsEmployeeHireLog.setDateLastDismiss_n(employeeHireLog.getDateDismissed_n());
            hrsEmployeeHireLog.setNotesDismissed(employeeHireLog.getNotesDismissed());
            hrsEmployeeHireLog.setFkDismissedType(employeeHireLog.getFkEmployeeDismissTypeId());
            hrsEmployeeHireLog.setFkUserInsertId(employeeHireLog.getFkUserInsertId());
            hrsEmployeeHireLog.setFkUserUpdateId(employeeHireLog.getFkUserUpdateId());

            hrsEmployeeHireLog.setIsFirtsHire(false);
            hrsEmployeeHireLog.setIsCorrection(true);

            if (employee.isActive()) {
                hrsEmployeeHireLog.setDeleted(true);
            }
            else {
                hrsEmployeeHireLog.setDateLastDismiss_n(null);
                hrsEmployeeHireLog.setNotesDismissed("");
                hrsEmployeeHireLog.setFkDismissedType(SModSysConsts.HRSU_TP_EMP_DIS_NON); 
            }
            hrsEmployeeHireLog.save();
        }
        
        return true;
    }
    
    public static boolean editHireLog(final SGuiSession session, final SDbEmployeeHireLog employeeHireLog) throws Exception {
        SHrsEmployeeHireLog hrsEmployeeHireLog;
        
        hrsEmployeeHireLog = new SHrsEmployeeHireLog(null,session);

        hrsEmployeeHireLog.setPkEmployeeId(employeeHireLog.getPkEmployeeId());
        hrsEmployeeHireLog.setDateLastHire(employeeHireLog.getDateHire());
        hrsEmployeeHireLog.setIsHire(employeeHireLog.isHired());
        hrsEmployeeHireLog.setDeleted(employeeHireLog.isDeleted());
        hrsEmployeeHireLog.setDateLastHire(employeeHireLog.getDateHire());
        hrsEmployeeHireLog.setNotesHire(employeeHireLog.getNotesHire());
        hrsEmployeeHireLog.setDateLastDismiss_n(employeeHireLog.getDateDismissed_n());
        hrsEmployeeHireLog.setNotesDismissed(employeeHireLog.getNotesDismissed());
        hrsEmployeeHireLog.setFkDismissedType(employeeHireLog.getFkEmployeeDismissTypeId());
        hrsEmployeeHireLog.setFkUserInsertId(employeeHireLog.getFkUserInsertId());
        hrsEmployeeHireLog.setFkUserUpdateId(employeeHireLog.getFkUserUpdateId());

        hrsEmployeeHireLog.setIsFirtsHire(false);
        hrsEmployeeHireLog.setIsCorrection(false);
        hrsEmployeeHireLog.setIsEdit(true);
        
        hrsEmployeeHireLog.save();
        
        return true;
    }
    
    public static ArrayList<SHrsBenefit> readHrsBenefits(final SGuiSession session, final SDbEmployee employee, final int benefitType, final int anniversaryLimit, final int benefitYear, final int payrrollId, final ArrayList<SHrsBenefitTableAnniversary> benefitTableAnniversarys, final ArrayList<SHrsBenefitTableAnniversary> benefitTableAnniversarysAux, final double paymentDaily) throws Exception {
        ArrayList<SHrsBenefit> hrsBenefits = new ArrayList<>();
        boolean foundAnniversary = false;
        SHrsBenefit hrsBenefit = null;
        SHrsBenefitTableAnniversary benefitTableAnniversary = null;
        SHrsBenefitTableAnniversary benefitTableAnniversaryAux = null;
        String sql = "";
        ResultSet resultSet = null;
        
        sql = "SELECT fk_tp_ben, ben_ann, ben_year, SUM(unt_all) AS f_val_payed, SUM(amt_r) AS f_amt_payed " +
                "FROM hrs_pay_rcp_ear " +
                "WHERE b_del = 0 AND id_emp = " + employee.getPkEmployeeId() + " AND id_pay <> " + payrrollId + " AND fk_tp_ben = " + benefitType + " AND ben_ann <= " + anniversaryLimit + " " +
                "GROUP BY fk_tp_ben, ben_ann, ben_year ";
        resultSet = session.getStatement().executeQuery(sql);
        while (resultSet.next()) {
            hrsBenefit = new SHrsBenefit(benefitType, resultSet.getInt("ben_ann"), resultSet.getInt("ben_year"));
            
            hrsBenefit.setValuePayed(resultSet.getDouble("f_val_payed"));
            hrsBenefit.setAmountPayed(resultSet.getDouble("f_amt_payed"));
            
            hrsBenefits.add(hrsBenefit);
        }
        
        for (SHrsBenefit benefit : hrsBenefits) {
            if (SLibUtils.compareKeys(benefit.getBenefitKey(), new int[] { benefitType, anniversaryLimit, benefitYear })) {
                foundAnniversary = true;
            }
        }
        
        if (!foundAnniversary) {
            hrsBenefit = new SHrsBenefit(benefitType, anniversaryLimit, benefitYear);
            hrsBenefits.add(hrsBenefit);
        }
        
        // To complete benefits registries accumulated by benefit type:
        
        for (SHrsBenefit benefit : hrsBenefits) {
            for (SHrsBenefitTableAnniversary anniversary : benefitTableAnniversarys) {
                if (anniversary.getBenefitAnn() <= benefit.getBenefitAnn()) {
                    benefitTableAnniversary = anniversary;
                }
            }

            if (benefitType == SModSysConsts.HRSS_TP_BEN_VAC_BON) {
                for (SHrsBenefitTableAnniversary anniversary : benefitTableAnniversarysAux) {
                    if (anniversary.getBenefitAnn() <= benefit.getBenefitAnn()) {
                        benefitTableAnniversaryAux = anniversary;
                    }
                }
            }

            if (benefitType == SModSysConsts.HRSS_TP_BEN_VAC_BON) {
                benefit.setValue(benefitTableAnniversary == null || benefitTableAnniversaryAux == null ? 0d : benefitTableAnniversaryAux.getValue());
                benefit.setAmount(benefitTableAnniversary == null || benefitTableAnniversaryAux == null ? 0d : SLibUtils.roundAmount(benefitTableAnniversaryAux.getValue() * paymentDaily * benefitTableAnniversary.getValue()));
            }
            else {
                benefit.setValue(benefitTableAnniversary == null ? 0d : benefitTableAnniversary.getValue());
                benefit.setAmount(benefitTableAnniversary == null ? 0d : benefitTableAnniversary.getValue() * SLibUtils.roundAmount(paymentDaily));
            }
        }

        return hrsBenefits;
    }
    
    public static int getScheduledDays(final SGuiSession session, final SDbEmployee employee, final int benefitAnn, final int benefitYear, final int absenceId) throws Exception {
        int scheduledDays = 0;
        String sql = "";
        ResultSet resultSet = null;

         sql = "SELECT SUM(a.eff_day) " +
                 "FROM hrs_abs AS a " +
                 "WHERE NOT a.b_del AND a.id_emp = " + employee.getPkEmployeeId() + " AND " +
                 "a.ben_ann = " + benefitAnn + " AND a.ben_year = " + benefitYear + " AND a.id_abs <> " + absenceId + " ";
         
         resultSet = session.getStatement().executeQuery(sql);
         if (resultSet.next()) {
             scheduledDays = resultSet.getInt(1);
         }
         
        return scheduledDays;
    }
    
    public static SHrsFormerPayroll readPayroll(final SClientInterface client, final int[] keyPayroll) throws SQLException, Exception {
        int f_emp_map_bp = 0;
        int f_emp_id = 0;
        int claveOficial = 0;
        int nPaymentType = 0;
        boolean bBankAccountUse = false;
        String sql = "";
        String deductionsTaxRetained = "";
        String cia_reg_imss = "";
        double dAmountEarTax = 0;
        double dAmountEarExe = 0;
        double dAmountDedTax = 0;
        double dAmountDedExe = 0;
        double dTotalEar = 0;
        double dTotalDed = 0;
        double dTotalDedRet = 0;
        double dAmountMonth = 0;

        SHrsFormerPayroll payroll = null;
        SHrsFormerPayrollReceipt payrollReceipt = null;
        SHrsFormerPayrollConcept payrollConcept = null;
        SHrsFormerPayrollExtraTime payrollExtraTime = null;
        SHrsFormerPayrollIncident payrollIncident = null;

        Statement statement = client.getSession().getStatement().getConnection().createStatement();
        Statement statementAux = client.getSession().getStatement().getConnection().createStatement();
        Statement statementAuxInc = client.getSession().getStatement().getConnection().createStatement();
        Statement statementClient = client.getSession().getStatement().getConnection().createStatement();

        ResultSet resultSet = null;
        ResultSet resultSetAux = null;
        ResultSet resultSetAuxInc = null;
        ResultSet resultSetClient = null;

        // Settings module human resource:

        sql = "SELECT b_bank_acc_use FROM hrs_cfg WHERE id_cfg = " + SUtilConsts.BPR_CO_ID + "";
        
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            bBankAccountUse = resultSet.getBoolean("b_bank_acc_use");
        }
        
        // Obtain deductions for tax retained:
        
        sql = "SELECT id_ded FROM hrs_ded WHERE fk_tp_ded = " + SModSysConsts.HRSS_TP_DED_TAX + "";
        
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            deductionsTaxRetained += (deductionsTaxRetained.length() == 0 ? "" : ", ") + resultSet.getInt("id_ded");
        }

        // Obtain payroll header:

        sql = "SELECT p.per_year, p.id_pay, tp.code, p.num, p.id_pay, NOW() AS f_date, p.dt_sta, p.dt_end, p.fk_tp_pay_sht, " +
                "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) AS f_ear, " +
                "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS f_ded, " +
                "pei.dt_iss, " +
                "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.fk_ded IN (" + deductionsTaxRetained + ")) AS f_rent_ret, " +
                "'" + SHrsConsts.TXT_CON_DESC + "' AS f_descrip, p.fk_tp_pay " +
                "FROM hrs_pay AS p " +
                "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                "INNER JOIN hrs_pay_rcp_iss AS pei ON " +
                "rcp.id_pay = pei.id_pay AND rcp.id_emp = pei.id_emp AND pei.b_del = 0 AND pei.id_iss = " + keyPayroll[2] + " " +
                "INNER JOIN erp.hrss_tp_pay AS tp ON p.fk_tp_pay = tp.id_tp_pay " +
                "WHERE rcp.id_pay = " + keyPayroll[0] + " AND rcp.b_del = 0 AND rcp.id_emp = " + keyPayroll[1] + " " + 
                "GROUP BY p.per_year, p.per, tp.code, p.num, p.id_pay, f_date, p.dt_sta, p.dt_end " +
                "ORDER BY p.per_year DESC, p.per DESC, tp.code, p.num, p.id_pay, f_date, p.dt_sta, p.dt_end; ";
        
        resultSet = statement.executeQuery(sql);
        if (!resultSet.next()) {
            throw new Exception("No se encontró la nómina.");
        }
        else {
            payroll = new SHrsFormerPayroll(client);
            payroll.setPkNominaId(resultSet.getInt("id_pay"));
            payroll.setFecha(resultSet.getDate("pei.dt_iss"));
            payroll.setFechaInicial(resultSet.getDate("dt_sta"));
            payroll.setFechaFinal(resultSet.getDate("dt_end"));
            payroll.setTotalPercepciones(resultSet.getDouble("f_ear"));
            payroll.setTotalDeducciones(resultSet.getDouble("f_ded"));
            payroll.setTotalRetenciones(resultSet.getDouble("f_rent_ret"));
            payroll.setDescripcion(SLibUtilities.textLeft(SLibUtilities.textTrim(resultSet.getString("f_descrip")), 100)); // 100 = pay_note column width
            payroll.setEmpresaId(client.getSession().getConfigCompany().getCompanyId());
            payroll.setSucursalEmpresaId(client.getSessionXXX().getCompany().getDbmsDataCompany().getDbmsHqBranch().getPkBizPartnerBranchId());
            payroll.setRegimenFiscal(new String[] { client.getSessionXXX().getParamsCompany().getDbmsDataCfgCfd().getCfdRegimenFiscal() });
            payroll.setFkNominaTipoId(resultSet.getInt("p.fk_tp_pay_sht"));
            
            nPaymentType = resultSet.getInt("p.fk_tp_pay");
        }

        // Obtain employer registry:

        cia_reg_imss = client.getSessionXXX().getParamsCompany().getRegistrySs();

        // Obtain employee payroll:

        sql = "SELECT bp.bp, bp.id_bp AS f_emp_map_bp, emp.id_emp AS f_emp_id, emp.num AS f_emp_num, bp.alt_id AS f_emp_curp, emp.ssn AS f_emp_nss, " +
                "sch.code AS f_emp_reg_tp, rcp.day_pad AS f_emp_dias_pag, d.name AS f_emp_dep, d.code AS f_emp_dep_cve, " +
                (bBankAccountUse ? "emp.bank_acc" : "''") + " AS f_emp_bank_clabe, " +
                "pei.dt_pay, pei.num_ser, pei.num, pei.fk_tp_pay_sys, " +
                "CASE WHEN emp.fk_bank_n IS NOT NULL THEN emp.fk_bank_n ELSE (SELECT fk_bank FROM hrs_cfg WHERE id_cfg = " + SUtilConsts.BPR_CO_ID + ") END AS f_emp_bank, " +
                "rcp.dt_hire AS f_emp_alta, p.dt_sta AS f_nom_date_start, p.dt_end AS f_nom_date_end, " +
                "TIMESTAMPDIFF(DAY, emp.dt_hire, p.dt_end) / " + SHrsConsts.WEEK_DAYS + " AS f_emp_sen, pos.name AS f_emp_pos, " +
                "con.code AS f_emp_cont_tp, wrktp.code AS f_emp_jorn_tp, tp.code AS f_emp_pay, rcp.sal_ssc AS f_emp_sal_bc, rcp.sal, rcp.wage, ris.code AS f_emp_risk, " +
                "IF(emp.b_uni, '" + SHrsConsts.TXT_UNI_YES + "', '" + SHrsConsts.TXT_UNI_NO + "') AS f_emp_union, " +
                "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) AS f_ear, " +
                "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS f_ded, " +
                "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp AND rcp_ded.fk_ded IN (" + deductionsTaxRetained + ")) AS f_emp_tot_rent_ret, " +
                "(SELECT COALESCE(SUM(rcp_ear.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = r.id_pay AND rcp_ear.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.id_emp = rcp.id_emp) -" +
                "(SELECT COALESCE(SUM(rcp_ded.amt_r), 0) " +
                "FROM hrs_pay_rcp AS r " +
                "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = r.id_pay AND rcp_ded.id_emp = r.id_emp " +
                "WHERE r.id_pay = p.id_pay AND r.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.id_emp = rcp.id_emp) AS f_emp_tot_net, " +
                "NOW() AS f_emp_date_edit " +
                "FROM hrs_pay AS p " +
                "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                "INNER JOIN hrs_pay_rcp_iss AS pei ON " +
                "rcp.id_pay = pei.id_pay AND rcp.id_emp = pei.id_emp AND pei.b_del = 0 AND pei.id_iss = " + keyPayroll[2] + " " +
                "INNER JOIN erp.hrsu_emp AS emp ON emp.id_emp = rcp.id_emp " +
                "INNER JOIN erp.bpsu_bp AS bp ON bp.id_bp = emp.id_emp " +
                "INNER JOIN erp.hrsu_dep AS d ON d.id_dep = rcp.fk_dep " +
                "INNER JOIN erp.hrsu_pos AS pos ON pos.id_pos = rcp.fk_pos " +
                "INNER JOIN erp.hrss_tp_sal AS st ON st.id_tp_sal = rcp.fk_tp_sal " +
                "INNER JOIN erp.hrsu_tp_emp AS et ON et.id_tp_emp = rcp.fk_tp_emp " +
                "INNER JOIN erp.hrss_tp_con AS con ON con.id_tp_con = rcp.fk_tp_con " +
                "INNER JOIN erp.hrss_tp_rec_sche AS sch ON sch.id_tp_rec_sche = rcp.fk_tp_rec_sche " +
                "INNER JOIN erp.hrss_tp_pos_risk AS ris ON ris.id_tp_pos_risk = rcp.fk_tp_pos_risk " +
                "INNER JOIN erp.hrss_tp_work_day AS wrktp ON rcp.fk_tp_work_day = wrktp.id_tp_work_day " +
                "INNER JOIN erp.hrss_tp_pay AS tp ON p.fk_tp_pay = tp.id_tp_pay " +
                "WHERE rcp.id_pay = " + keyPayroll[0] + " AND rcp.b_del = 0 AND rcp.id_emp = " + keyPayroll[1] + " " +
                "GROUP BY bp.bp, f_emp_map_bp, f_emp_num, f_emp_curp, f_emp_nss, f_emp_reg_tp, f_emp_dias_pag, f_emp_dep, f_emp_dep_cve, d.id_dep, f_emp_bank, f_emp_alta, f_nom_date_start, f_nom_date_end, " +
                "f_emp_sen, f_emp_pos, f_emp_pay, f_emp_sal_bc, f_emp_risk " +
                "ORDER BY bp.bp, f_emp_map_bp, f_emp_num, f_emp_curp, f_emp_nss, f_emp_reg_tp, f_emp_dias_pag, f_emp_dep, f_emp_dep_cve, d.id_dep, f_emp_bank, f_emp_alta, f_nom_date_start, f_nom_date_end, " +
                "f_emp_sen, f_emp_pos, f_emp_pay, f_emp_sal_bc, f_emp_risk; ";
        resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            dAmountEarTax = 0;
            dAmountEarExe = 0;
            dAmountDedTax = 0;
            dAmountDedExe = 0;
            dTotalEar = 0;
            dTotalDed = 0;
            dTotalDedRet = 0;
            dAmountMonth = 0;
            payrollReceipt = new SHrsFormerPayrollReceipt(payroll, client);

            // Obtain employee company branch:

            f_emp_map_bp = resultSet.getInt("f_emp_map_bp");

            sql = "SELECT bpb.id_bpb, sta.sta_code AS _sta " +
                "FROM erp.bpsu_bpb AS bpb " +
                "INNER JOIN erp.bpsu_bpb_add AS bpb_add ON bpb.id_bpb = bpb_add.id_bpb AND bpb_add.fid_tp_add = " + SDataConstantsSys.BPSS_TP_ADD_OFF + " " +
                "LEFT OUTER JOIN erp.locu_sta AS sta ON bpb_add.fid_sta_n = sta.id_sta " +
                "WHERE bpb.b_del = 0 AND bpb.fid_tp_bpb = " + SDataConstantsSys.BPSS_TP_BPB_HQ + " AND bpb.fid_bp = " + f_emp_map_bp + " ";
            resultSetClient = statementClient.executeQuery(sql);

            if (!resultSetClient.next()) {
                throw new Exception("No se encontró la sucursal del empleado '" + f_emp_map_bp + "'.");
            }

            payrollReceipt.setPkEmpleadoId(f_emp_map_bp);
            f_emp_id = resultSet.getInt("f_emp_id");
            payrollReceipt.setAuxEmpleadoId(f_emp_id);
            payrollReceipt.setPkSucursalEmpleadoId(resultSetClient.getInt("bpb.id_bpb"));
            payrollReceipt.setRegistroPatronal(cia_reg_imss);
            payrollReceipt.setNumEmpleado(SLibUtilities.textTrim(resultSet.getString("f_emp_num")));
            payrollReceipt.setCurp(SLibUtilities.textTrim(resultSet.getString("f_emp_curp")));
            payrollReceipt.setNumSeguridadSocial(SLibUtilities.textTrim(resultSet.getString("f_emp_nss")));
            payrollReceipt.setTipoRegimen(resultSet.getInt("f_emp_reg_tp"));
            payrollReceipt.setNumDiasPagados(resultSet.getDouble("f_emp_dias_pag"));
            payrollReceipt.setDepartamento(SLibUtilities.textTrim(resultSet.getString("f_emp_dep")));
            payrollReceipt.setClabe(SLibUtilities.textTrim(resultSet.getString("f_emp_bank_clabe")));
            payrollReceipt.setBanco(resultSet.getInt("f_emp_bank"));
            payrollReceipt.setFechaPago(resultSet.getDate("pei.dt_pay"));
            payrollReceipt.setFechaInicioRelLaboral(resultSet.getDate("f_emp_alta"));
            payrollReceipt.setFechaInicialPago(resultSet.getDate("f_nom_date_start"));
            payrollReceipt.setFechaFinalPago(resultSet.getDate("f_nom_date_end"));
            payrollReceipt.setAntiguedad(resultSet.getInt("f_emp_sen"));
            payrollReceipt.setPuesto(SLibUtilities.textTrim(resultSet.getString("f_emp_pos")));
            payrollReceipt.setTipoContrato(SLibUtilities.textTrim(resultSet.getString("f_emp_cont_tp")));
            payrollReceipt.setTipoJornada(SLibUtilities.textTrim(resultSet.getString("f_emp_jorn_tp")));
            payrollReceipt.setPeriodicidadPago(SLibUtilities.textTrim(resultSet.getString("f_emp_pay")));
            payrollReceipt.setSalarioBaseCotApor(resultSet.getDouble("f_emp_sal_bc"));
            payrollReceipt.setRiesgoPuesto(resultSet.getInt("f_emp_risk"));
            payrollReceipt.setSindicalizado(SLibUtilities.textTrim(resultSet.getString("f_emp_union")));
            payrollReceipt.setSalarioDiarioIntegrado(payrollReceipt.getSalarioBaseCotApor());
            /* XXX (2016-08-31) jbarajas It're obtained detail of earnings and deductions.
            hrsPayrollReceipt.setTotalPercepciones(resultSet.getDouble("f_ear"));
            hrsPayrollReceipt.setTotalDeducciones(resultSet.getDouble("f_ded"));
            hrsPayrollReceipt.setTotalRetenciones(resultSet.getDouble("f_emp_tot_rent_ret"));
            hrsPayrollReceipt.setTotalNeto(resultSet.getDouble("f_emp_tot_net"));
            */
            payrollReceipt.setClaveEstado(SLibUtilities.textTrim(resultSetClient.getString("_sta")));
            payrollReceipt.setFechaEdicion(resultSet.getDate("f_emp_date_edit"));
            payrollReceipt.setSerie(SLibUtilities.textTrim(resultSet.getString("pei.num_ser")));
            payrollReceipt.setFolio(resultSet.getInt("pei.num"));
            payrollReceipt.setMetodoPago(resultSet.getInt("pei.fk_tp_pay_sys"));
            
            dAmountMonth = nPaymentType == SModSysConsts.HRSS_TP_PAY_WEE ? (resultSet.getDouble("rcp.sal") * SHrsConsts.MONTH_DAYS_FIXED) : resultSet.getDouble("rcp.wage");
            payrollReceipt.setAuxSueldoMensual(dAmountMonth);

            // Obtain currency key from ERP parameters:

            sql = "SELECT c.cur_key " +
                "FROM erp.cfg_param_erp AS p " +
                "INNER JOIN erp.cfgu_cur AS c ON " +
                "p.fid_cur = c.id_cur " +
                "WHERE p.b_del = 0 ";
            resultSetClient = statementClient.executeQuery(sql);

            if (!resultSetClient.next()) {
                throw new Exception("No se encontró la configuración del ERP.");
            }
            else {
                payrollReceipt.setMoneda(SLibUtilities.textTrim(resultSetClient.getString("c.cur_key")));
            }

            payrollReceipt.setLugarExpedicion(client.getSessionXXX().getCurrentCompanyBranch().getDbmsBizPartnerBranchAddressOfficial().getZipCode());
            payrollReceipt.setConfirmacion("");
            payrollReceipt.setRegimenFiscal(client.getSessionXXX().getParamsCompany().getDbmsDataCfgCfd().getCfdRegimenFiscal());
            payrollReceipt.setCfdiRelacionadosTipoRelacion("");
            
            payroll.getChildPayrollReceipts().add(payrollReceipt);

            if (payrollReceipt != null) {

                // Obtain perceptions:

                sql = "SELECT ear.code AS f_conc_cve, ear.name_abbr AS f_conc, ear.fk_tp_ear AS f_conc_cfdi, ear.unt_fac, rcp_ear.fk_ear, " +
                        "CASE WHEN ear.fk_tp_ear = " + SModSysConsts.HRSS_TP_EAR_OVR_TME + " THEN CASE WHEN rcp_ear.unt >= 0 AND rcp_ear.unt < " + SHrsConsts.OVER_TIME_2X_MAX_DAY + " THEN 1 ELSE rcp_ear.unt / " + SHrsConsts.OVER_TIME_2X_MAX_DAY + " END ELSE " +
                        "CASE WHEN rcp_ear.unt >= 0 AND rcp_ear.unt <= 1 THEN 1 ELSE rcp_ear.unt END END AS f_conc_qty, " +
                        "CASE WHEN ear.fk_tp_ear = " + SModSysConsts.HRSS_TP_EAR_OVR_TME + " THEN " +
                        "CASE WHEN rcp_ear.unt >= 0 AND rcp_ear.unt <= 1 THEN 1 ELSE rcp_ear.unt END ELSE 0 END AS f_conc_hrs, comp.code AS f_conc_unid, " +
                        "rcp_ear.amt_taxa AS f_conc_mont_grav, rcp_ear.amt_exem AS f_conc_mont_ext, " +
                        "1 AS f_conc_tp, " +
                        "CASE WHEN ear.fk_tp_ear = " + SModSysConsts.HRSS_TP_EAR_OVR_TME + " AND ear.unt_fac = " + SHrsConsts.OVER_TIME_2X + " THEN " + SCfdConsts.CFDI_PAYROLL_PERCEPTION_EXTRA_TIME_DOUBLE[1] + " ELSE " +
                        "CASE WHEN ear.fk_tp_ear = " + SModSysConsts.HRSS_TP_EAR_OVR_TME + " AND ear.unt_fac = " + SHrsConsts.OVER_TIME_3X + " THEN " + SCfdConsts.CFDI_PAYROLL_PERCEPTION_EXTRA_TIME_TRIPLE[1] + " ELSE " + 
                        "" + SCfdConsts.CFDI_PAYROLL_PERCEPTION_PERCEPTION[1] + " END END AS f_conc_stp " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay AND rcp.b_del = 0 " +
                        "INNER JOIN hrs_pay_rcp_ear AS rcp_ear ON rcp_ear.id_pay = rcp.id_pay AND rcp_ear.id_emp = rcp.id_emp AND rcp_ear.b_del = 0 " +
                        "INNER JOIN hrs_ear AS ear ON ear.id_ear = rcp_ear.fk_ear " +
                        "INNER JOIN erp.hrss_tp_ear_comp AS comp ON comp.id_tp_ear_comp = ear.fk_tp_ear_comp " +
                        "WHERE p.id_pay = " + keyPayroll[0] + " AND rcp.id_emp = " + f_emp_id + "; ";

                resultSetAux = statementAux.executeQuery(sql);
                while (resultSetAux.next()) {
                    payrollConcept = new SHrsFormerPayrollConcept();
                    dAmountEarTax = resultSetAux.getDouble("f_conc_mont_grav");
                    dAmountEarExe = resultSetAux.getDouble("f_conc_mont_ext");
                    dTotalEar = SLibUtils.round((dTotalEar + dAmountEarTax + dAmountEarExe), SLibUtils.DecimalFormatPercentage2D.getMaximumFractionDigits());

                    payrollConcept.setClaveEmpresa(SLibUtilities.textTrim(resultSetAux.getString("f_conc_cve")));
                    payrollConcept.setConcepto(SLibUtilities.textTrim(resultSetAux.getString("f_conc")));
                    payrollConcept.setClaveOficial(resultSetAux.getInt("f_conc_cfdi"));
                    claveOficial = payrollConcept.getClaveOficial();
                    payrollConcept.setCantidad(claveOficial == SModSysConsts.HRSS_TP_EAR_OVR_TME ? Math.ceil(resultSetAux.getDouble("f_conc_qty")) : resultSetAux.getDouble("f_conc_qty"));
                    payrollConcept.setHoras_r(resultSetAux.getInt("f_conc_hrs"));
                    payrollConcept.setTotalGravado(dAmountEarTax);
                    payrollConcept.setTotalExento(dAmountEarExe);
                    payrollConcept.setPkTipoConcepto(resultSetAux.getInt("f_conc_tp"));
                    payrollConcept.setPkSubtipoConcepto(resultSetAux.getInt("f_conc_stp"));

                    if (claveOficial == SModSysConsts.HRSS_TP_EAR_OVR_TME) {
                        payrollExtraTime = new SHrsFormerPayrollExtraTime();
                        payrollExtraTime.setTipoHoras(resultSetAux.getInt("unt_fac") == SHrsConsts.OVER_TIME_2X ?
                            SCfdConsts.CFDI_PAYROLL_EXTRA_TIME_TYPE_DOUBLE : SCfdConsts.CFDI_PAYROLL_EXTRA_TIME_TYPE_TRIPLE);
                        payrollExtraTime.setDias(payrollConcept.getCantidad());
                        payrollExtraTime.setHorasExtra(payrollConcept.getHoras_r());
                        payrollExtraTime.setImportePagado(payrollConcept.getTotalGravado() + payrollConcept.getTotalExento());

                        payrollConcept.setChildPayrollExtraTimes(payrollExtraTime);
                    }
                    else if (claveOficial == SModSysConsts.HRSS_TP_EAR_DIS) {
                        sql = "SELECT tpd.code " +
                                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EAR) + " AS ear " +
                                "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_TP_ABS) + " AS tpa ON ear.fk_cl_abs_n = tpa.id_cl_abs AND ear.fk_tp_abs_n = tpa.id_tp_abs " +
                                "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_DIS) + " AS tpd ON tpa.fk_tp_dis_n = tpd.id_tp_dis " +
                                "WHERE ear.id_ear = " + resultSetAux.getInt("rcp_ear.fk_ear") + " ";

                        resultSetAuxInc = statementAuxInc.executeQuery(sql);
                        if (resultSetAuxInc.next()) {
                            payrollConcept.setClaveIncapacidad(resultSetAuxInc.getString("tpd.code"));
                        }
                    }

                    payrollReceipt.getChildPayrollConcept().add(payrollConcept);
                }

                // Obtain deductions:
                
                sql = "SELECT ded.code AS f_conc_cve, ded.fk_tp_ded AS f_conc_cfdi, ded.fk_tp_ded, " +
                        "(CASE WHEN rcp_ded.fk_loan_emp_n IS NULL AND rcp_ded.fk_loan_loan_n IS NULL THEN ded.name ELSE " +
                        "CAST(CONCAT(ded.name,'; ', ltp.name, '; no. ', l.num, '; ini.: ', l.dt_sta) AS CHAR CHARACTER SET latin1) END) AS f_conc, " +
                        "rcp_ded.unt AS f_conc_qty, 0 AS f_conc_hrs, '' AS f_conc_unid, rcp_ded.amt_r AS f_conc_mont_grav, 0 AS f_conc_mont_ext, " +
                        "" + SCfdConsts.CFDI_PAYROLL_DEDUCTION_DEDUCTION[0] + " AS f_conc_tp, " +
                        "" + SCfdConsts.CFDI_PAYROLL_DEDUCTION_DEDUCTION[1] + " AS f_conc_stp " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS rcp ON rcp.id_pay = p.id_pay " +
                        "INNER JOIN hrs_pay_rcp_ded AS rcp_ded ON rcp_ded.id_pay = rcp.id_pay AND rcp_ded.id_emp = rcp.id_emp " +
                        "INNER JOIN hrs_ded AS ded ON ded.id_ded = rcp_ded.fk_ded " +
                        "LEFT OUTER JOIN hrs_loan AS l ON l.id_emp = rcp_ded.fk_loan_emp_n AND l.id_loan = rcp_ded.fk_loan_loan_n " +
                        "LEFT OUTER JOIN erp.hrss_tp_loan AS ltp ON ltp.id_tp_loan = rcp_ded.fk_tp_loan_n " +
                        "WHERE p.id_pay = " + keyPayroll[0] + " AND rcp.b_del = 0 AND rcp_ded.b_del = 0 AND rcp.id_emp = " + f_emp_id + "; ";

                resultSetAux = statementAux.executeQuery(sql);
                while (resultSetAux.next()) {
                    payrollConcept = new SHrsFormerPayrollConcept();
                    dAmountDedTax = resultSetAux.getDouble("f_conc_mont_grav");
                    dAmountDedExe = resultSetAux.getDouble("f_conc_mont_ext");
                    dTotalDed = SLibUtils.round((dTotalDed + dAmountDedTax + dAmountDedExe), SLibUtils.DecimalFormatPercentage2D.getMaximumFractionDigits());
                    
                    if (resultSetAux.getInt("ded.fk_tp_ded") == SModSysConsts.HRSS_TP_DED_TAX) {
                        dTotalDedRet = SLibUtils.round((dTotalDedRet + dAmountDedTax + dAmountDedExe), SLibUtils.DecimalFormatPercentage2D.getMaximumFractionDigits());
                    }

                    payrollConcept.setClaveEmpresa(SLibUtilities.textTrim(resultSetAux.getString("f_conc_cve")));
                    payrollConcept.setClaveOficial(resultSetAux.getInt("f_conc_cfdi"));
                    payrollConcept.setConcepto(SLibUtilities.textTrim(resultSetAux.getString("f_conc")));
                    payrollConcept.setCantidad(SLibUtils.round(resultSetAux.getDouble("f_conc_qty"), SLibUtils.DecimalFormatPercentage2D.getMaximumFractionDigits()));
                    payrollConcept.setHoras_r(resultSetAux.getInt("f_conc_hrs"));
                    payrollConcept.setTotalGravado(dAmountDedTax);
                    payrollConcept.setTotalExento(dAmountDedExe);
                    payrollConcept.setPkTipoConcepto(resultSetAux.getInt("f_conc_tp"));
                    payrollConcept.setPkSubtipoConcepto(resultSetAux.getInt("f_conc_stp"));

                    payrollReceipt.getChildPayrollConcept().add(payrollConcept);
                }
                payrollReceipt.setTotalPercepciones(dTotalEar);
                payrollReceipt.setTotalDeducciones(dTotalDed);
                payrollReceipt.setTotalRetenciones(dTotalDedRet);
                payrollReceipt.setTotalNeto(dTotalEar - dTotalDed);
            }
        }

        return payroll;
    }
    
    public static void createPayrollReceiptIssues(final SGuiSession session, final SDbPayroll payroll) throws Exception {
        for (SDbPayrollReceipt receipt : payroll.getChildPayrollReceipts()) {
            receipt.setAuxDateIssue(payroll.getDateEnd());
            receipt.createIssues(session);
        }
    }
    
    public static void updateToNewStatusPayrollReceiptIssues(final SGuiSession session, final SDbPayroll payroll) throws Exception {
        for (SDbPayrollReceipt receipt : payroll.getChildPayrollReceipts()) {
            receipt.updateToNewStatusIssues(session);
        }
    }
    
    public static double computeAmoutLoan(final SHrsPayrollReceipt hrsReceipt, final SDbLoan loan) throws Exception {
        double amoutAdjustment = 0;
        double amoutAux = 0;
        double amoutMonth = 0;
        double amout = 0;
        double adjustmentAux = 0;
        double salaryReference = 0;
        double balanceLoan = 0;
        SHrsDaysByPeriod hrsDaysPrev = hrsReceipt.getHrsEmployee().getHrsDaysPrev();
        SHrsDaysByPeriod hrsDaysCurr = hrsReceipt.getHrsEmployee().getHrsDaysCurr();
        SHrsDaysByPeriod hrsDaysNext = hrsReceipt.getHrsEmployee().getHrsDaysNext();
        
        amoutAdjustment = hrsReceipt.getHrsPayroll().getLoanTypeAdjustment(hrsReceipt.getHrsPayroll().getPayroll().getDateEnd(), loan.getFkLoanTypeId());
        switch (loan.getFkLoanPaymentTypeId()) {
            case SModSysConsts.HRSS_TP_LOAN_PAY_AMT:
                amoutMonth = loan.getPaymentAmount() + amoutAdjustment;
                
                if (SLibUtils.belongsTo(loan.getFkLoanTypeId(), new int[] { SModSysConsts.HRSS_TP_LOAN_LOA_COM, SModSysConsts.HRSS_TP_LOAN_LOA_UNI, SModSysConsts.HRSS_TP_LOAN_LOA_TPS })) {
                    amoutAux = amoutMonth;
                
                    balanceLoan = SHrsUtils.getBalanceLoan(loan, hrsReceipt.getHrsEmployee());

                    amoutAux = (amoutAux > balanceLoan ? balanceLoan : amoutAux);
                }
                else {
                    amoutAux += hrsDaysPrev == null ? 0 : ((amoutMonth / hrsDaysPrev.getPeriodDays()) * (hrsDaysPrev.getPeriodPayrollDays() - hrsDaysPrev.getDaysNotWorkedNotPaid()));
                    amoutAux += (amoutMonth / hrsDaysCurr.getPeriodDays()) * (hrsDaysCurr.getPeriodPayrollDays() - hrsDaysCurr.getDaysNotWorkedNotPaid());
                    amoutAux += hrsDaysNext == null ? 0 : ((amoutMonth / hrsDaysNext.getPeriodDays()) * (hrsDaysNext.getPeriodPayrollDays() - hrsDaysNext.getDaysNotWorkedNotPaid()));
                }
                break;
                
            case SModSysConsts.HRSS_TP_LOAN_PAY_FIX:
                amoutMonth = loan.getPaymentFixed() * hrsReceipt.getHrsPayroll().getPayroll().getMwzReferenceWage() + amoutAdjustment;
                
                amoutAux += hrsDaysPrev == null ? 0 : ((amoutMonth / hrsDaysPrev.getPeriodDays()) * (hrsDaysPrev.getPeriodPayrollDays() - hrsDaysPrev.getDaysNotWorkedNotPaid()));
                amoutAux += (amoutMonth / hrsDaysCurr.getPeriodDays()) * (hrsDaysCurr.getPeriodPayrollDays() - hrsDaysCurr.getDaysNotWorkedNotPaid());
                amoutAux += hrsDaysNext == null ? 0 : ((amoutMonth / hrsDaysNext.getPeriodDays()) * (hrsDaysNext.getPeriodPayrollDays() - hrsDaysNext.getDaysNotWorkedNotPaid()));
                break;
                
            case SModSysConsts.HRSS_TP_LOAN_PAY_UMA:
                amoutMonth = (loan.getPaymentUma() * hrsReceipt.getHrsPayroll().getUma(hrsReceipt.getHrsPayroll().getPayroll().getDateEnd())) + amoutAdjustment;
                
                amoutAux += hrsDaysPrev == null ? 0 : ((amoutMonth / hrsDaysPrev.getPeriodDays()) * (hrsDaysPrev.getPeriodPayrollDays() - hrsDaysPrev.getDaysNotWorkedNotPaid()));
                amoutAux += (amoutMonth / hrsDaysCurr.getPeriodDays()) * (hrsDaysCurr.getPeriodPayrollDays() - hrsDaysCurr.getDaysNotWorkedNotPaid());
                amoutAux += hrsDaysNext == null ? 0 : ((amoutMonth / hrsDaysNext.getPeriodDays()) * (hrsDaysNext.getPeriodPayrollDays() - hrsDaysNext.getDaysNotWorkedNotPaid()));
                break;
                
            case SModSysConsts.HRSS_TP_LOAN_PAY_PER:
                adjustmentAux += hrsDaysPrev == null ? 0 : (((double) hrsDaysPrev.getPeriodPayrollDays() - hrsDaysPrev.getDaysNotWorkedNotPaid()) / hrsDaysPrev.getPeriodDays()) * amoutAdjustment;
                adjustmentAux += (double) (hrsDaysCurr.getPeriodPayrollDays() - hrsDaysCurr.getDaysNotWorkedNotPaid()) / hrsDaysCurr.getPeriodDays() * amoutAdjustment;
                adjustmentAux += hrsDaysNext == null ? 0 : (((double) hrsDaysNext.getPeriodPayrollDays() - hrsDaysNext.getDaysNotWorkedNotPaid()) / hrsDaysNext.getPeriodDays() * amoutAdjustment);
                
                if (loan.getPaymentPercentageReference() == SHrsConsts.SAL_REF_SAL) {
                    salaryReference = hrsReceipt.getReceipt().getPaymentDaily();
                }
                else if (loan.getPaymentPercentageReference() == SHrsConsts.SAL_REF_SAL_SS) {
                    salaryReference = hrsReceipt.getReceipt().getSalarySscBase();
                }
                else if (loan.getPaymentPercentageReference() == SHrsConsts.SAL_REF_SAL_FIX) {
                    salaryReference = loan.getPaymentPercentageAmount();
                }
                
                amoutAux = (hrsReceipt.getReceipt().getDaysHiredPayroll() - hrsReceipt.getReceipt().getDaysNotWorkedNotPaid()) * salaryReference * loan.getPaymentPercentage() + adjustmentAux;
                break;
                
            default:
                break;
        }
        
        amout = SLibUtils.roundAmount(amoutAux);
        
        return amout;
    }
    
    /**
     * Function for calculed tax.
     * @param dbTaxTable table of tax for use in calculation.
     * @param dTaxableAmount amount taxable the earnings.
     * @param fTableFactor adjustment factor for adjust the tax table.
     * @return double amount calculated of tax.
     * @throws Exception 
     */
    public static double computeAmoutTax(final SDbTaxTable dbTaxTable, final double dTaxableAmount, final double fTableFactor) throws Exception {
        double dTaxComputed = 0;
        SDbTaxTableRow dbTaxTableRow = null;
        
        for (int i = 0; i < dbTaxTable.getChildRows().size(); i++) {
            dbTaxTableRow = dbTaxTable.getChildRows().get(i);
            if (dTaxableAmount >= SLibUtils.round(dbTaxTableRow.getLowerLimit() * fTableFactor, SUtilConsts.DECS_AMT) &&
                    (i + 1 == dbTaxTable.getChildRows().size() || dTaxableAmount < SLibUtils.round(dbTaxTable.getChildRows().get(i + 1).getLowerLimit() * fTableFactor, SUtilConsts.DECS_AMT))) {
                dTaxComputed = SLibUtils.round((dTaxableAmount - SLibUtils.round(dbTaxTableRow.getLowerLimit() * fTableFactor, SUtilConsts.DECS_AMT)) * dbTaxTableRow.getTaxRate() + dbTaxTableRow.getFixedFee() * fTableFactor, SUtilConsts.DECS_AMT);
            }
        }
        
        return dTaxComputed;
    }
    
    /**
     * Function for calculed tax subsidy.
     * @param dbSubsidyTable table of tax subsidy for use in calculation.
     * @param dTaxableAmount amount taxable the earnings.
     * @param fTableFactor adjustment factor for adjust the tax subsidy table.
     * @return double amount calculated of tax subsidy.
     * @throws Exception 
     */
    public static double computeAmoutTaxSubsidy(final SDbTaxSubsidyTable dbSubsidyTable, final double dTaxableAmount, final double fTableFactor) throws Exception {
        double dSubsidyComputed = 0;
        SDbTaxSubsidyTableRow dbSubsidyTableRow = null;
        
        for (int i = 0; i < dbSubsidyTable.getChildRows().size(); i++) {
            dbSubsidyTableRow = dbSubsidyTable.getChildRows().get(i);
            if (dTaxableAmount >= dbSubsidyTableRow.getLowerLimit() * fTableFactor &&
                    (i + 1 == dbSubsidyTable.getChildRows().size() || dTaxableAmount < dbSubsidyTable.getChildRows().get(i + 1).getLowerLimit() * fTableFactor)) {
                dSubsidyComputed = SLibUtils.round(dbSubsidyTableRow.getTaxSubsidy() * fTableFactor, SUtilConsts.DECS_AMT);
            }
        }
        
        return dSubsidyComputed;
    }
    
    /**
     * Function for calculed security social contribution.
     * @param dbSscTable table of ss contribution for use in calculation.
     * @param dSalarySsc base salary contribution of employee.
     * @param dMwzReferenceWage salary reference area.
     * @param hrsDaysPrev quantity of days hired employee in previous period the payroll.
     * @param hrsDaysCurr quantity of days hired employee in current period the payroll.
     * @param hrsDaysNext quantity of days hired employee in next period the payroll.
     * @return double amount calculated of security social contribution.
     * @throws Exception 
     */
    public static double computeSSContribution(final SDbSsContributionTable dbSscTable, final double dSalarySsc, final double dMwzReferenceWage, final SHrsDaysByPeriod hrsDaysPrev,
                                                    final SHrsDaysByPeriod hrsDaysCurr, final SHrsDaysByPeriod hrsDaysNext) throws Exception {
        SDbSsContributionTableRow dbSscTableRow = null;
        double dSscComputed = 0;
        double dEarningSsc = 0;
        
        for (int i = 0; i < dbSscTable.getChildRows().size(); i++) {
            dbSscTableRow = dbSscTable.getChildRows().get(i);
            switch(dbSscTableRow.getPkRowId()) {
                case SHrsConsts.SS_INC_MON:
                case SHrsConsts.SS_INC_PEN:
                    //dEarningSsc = SLibUtils.round((moReceipt.getDaysHiredPayroll() - moReceipt.getDaysIncapacityNotPaidPayroll()) * moReceipt.getSalarySscBase(), SUtilConsts.DECS_AMT);
                    dEarningSsc = SLibUtils.round((hrsDaysPrev.getPeriodPayrollDays() + hrsDaysCurr.getPeriodPayrollDays() + hrsDaysNext.getPeriodPayrollDays() - hrsDaysPrev.getDaysIncapacityNotPaid() - hrsDaysCurr.getDaysIncapacityNotPaid() - hrsDaysNext.getDaysIncapacityNotPaid()) * dSalarySsc, SUtilConsts.DECS_AMT);
                    break;
                case SHrsConsts.SS_INC_KND_SSC_LET:
                    //dEarningSsc = SLibUtils.round((moReceipt.getDaysHiredPayroll() - moReceipt.getDaysIncapacityNotPaidPayroll()) * moHrsPayroll.getPayroll().getMwzReferenceWage(), SUtilConsts.DECS_AMT);
                    dEarningSsc = SLibUtils.round((hrsDaysPrev.getPeriodPayrollDays() + hrsDaysCurr.getPeriodPayrollDays() + hrsDaysNext.getPeriodPayrollDays() - hrsDaysPrev.getDaysIncapacityNotPaid() - hrsDaysCurr.getDaysIncapacityNotPaid() - hrsDaysNext.getDaysIncapacityNotPaid()) * dMwzReferenceWage, SUtilConsts.DECS_AMT);
                    break;
                case SHrsConsts.SS_INC_KND_SSC_GT:
                    //dEarningSsc = SLibUtils.round(moReceipt.getSalarySscBase() <= (dbSscTableRow.getLowerLimitMwzReference() * moHrsPayroll.getPayroll().getMwzReferenceWage()) ? 0 :
                    //       ((moReceipt.getDaysHiredPayroll() - moReceipt.getDaysIncapacityNotPaidPayroll()) * (moReceipt.getSalarySscBase() - (dbSscTableRow.getLowerLimitMwzReference() * moHrsPayroll.getPayroll().getMwzReferenceWage()))), SUtilConsts.DECS_AMT);
                    dEarningSsc = SLibUtils.round(dSalarySsc <= (dbSscTableRow.getLowerLimitMwzReference() * dMwzReferenceWage) ? 0 :
                           ((hrsDaysPrev.getPeriodPayrollDays() + hrsDaysCurr.getPeriodPayrollDays() + hrsDaysNext.getPeriodPayrollDays() - hrsDaysPrev.getDaysIncapacityNotPaid() - hrsDaysCurr.getDaysIncapacityNotPaid() - hrsDaysNext.getDaysIncapacityNotPaid()) * (dSalarySsc - (dbSscTableRow.getLowerLimitMwzReference() * dMwzReferenceWage))), SUtilConsts.DECS_AMT);
                    break;
                case SHrsConsts.SS_DIS_LIF:
                case SHrsConsts.SS_CRE:
                case SHrsConsts.SS_RSK:
                case SHrsConsts.SS_RET:
                case SHrsConsts.SS_SEV:
                case SHrsConsts.SS_HOM:
                    //dEarningSsc = SLibUtils.round((moReceipt.getDaysHiredPayroll() - moReceipt.getDaysNotWorkedNotPaid()) * moReceipt.getSalarySscBase(), SUtilConsts.DECS_AMT);
                    dEarningSsc = SLibUtils.round((hrsDaysPrev.getPeriodPayrollDays() + hrsDaysCurr.getPeriodPayrollDays() + hrsDaysNext.getPeriodPayrollDays() - hrsDaysPrev.getDaysNotWorkedNotPaid() - hrsDaysCurr.getDaysNotWorkedNotPaid() - hrsDaysNext.getDaysNotWorkedNotPaid()) * dSalarySsc, SUtilConsts.DECS_AMT);
                    break;
                default:
                    throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
            }
            dSscComputed += SLibUtils.round(dEarningSsc * dbSscTableRow.getWorkerPercentage(), SUtilConsts.DECS_AMT);
        }
        
        return dSscComputed;
    }
    
    /**
     * Function for calculed tax in base of articule 174 of RLISR.
     * @param dbTaxTable table of tax for use in calculation.
     * @param dTaxableAmount amount taxable the earnings configurated con articule 174 the RLISR.
     * @param dAmountMonth amount for earnings normal in month in question.
     * @param fTableFactor adjustment factor for adjust the tax table.
     * @return double amount calculated of tax.
     * @throws Exception 
     */
    public static double computeAmoutTaxAlt(final SDbTaxTable dbTaxTable, final double dTaxableAmount, final double dAmountMonth, final double fTableFactor) throws Exception {
        double amountFractionI = 0;
        double amountFractionII = 0;
        double amountFractionIII = 0;
        double amountFractionAuxIII = 0;
        double amountFractionIV = 0;
        double amountFractionV = 0;
        
        // Fraction I:
        
        amountFractionI = dTaxableAmount / SHrsConsts.YEAR_DAYS * SHrsConsts.MONTH_DAYS_FIXED;
        
        // Fraction II:
        
        amountFractionII = computeAmoutTax(dbTaxTable, (dAmountMonth + amountFractionI), fTableFactor);
        
        // Fraction III:
        
        amountFractionAuxIII = computeAmoutTax(dbTaxTable, dAmountMonth, fTableFactor);
        amountFractionIII = amountFractionAuxIII > 0 ? (amountFractionII - amountFractionAuxIII) : 0;
        
        // Fraction V:
        
        amountFractionV = amountFractionI == 0 ? 0 : (amountFractionIII / amountFractionI);
        
        // Fraction IV:
        amountFractionIV = amountFractionAuxIII > 0 ? (dTaxableAmount * amountFractionV) : 0;
        
        
        return amountFractionIV;
    }
    
    /**
     * Function for calculed tax subsidy in base of articule 174 of RLISR.
     * @param dbSubsidyTable table of tax subsidy for use in calculation.
     * @param dTaxableAmount amount taxable the earnings configurated con articule 174 the RLISR.
     * @param dAmountMonth amount for earnings normal in month in question.
     * @param fTableFactor adjustment factor for adjust the tax subsidy table.
     * @return double amount calculated of tax subsidy.
     * @throws Exception 
     */
    public static double computeAmoutTaxSubsidyAlt(final SDbTaxSubsidyTable dbSubsidyTable, final double dTaxableAmount, final double dAmountMonth, final double fTableFactor) throws Exception {
        double amountFractionI = 0;
        double amountFractionII = 0;
        double amountFractionIII = 0;
        double amountFractionAuxIII = 0;
        double amountFractionIV = 0;
        double amountFractionV = 0;
        
        // Fraction I:
        
        amountFractionI = dTaxableAmount / SHrsConsts.YEAR_DAYS * SHrsConsts.MONTH_DAYS_FIXED;
        
        // Fraction II:
        
        amountFractionII = computeAmoutTaxSubsidy(dbSubsidyTable, (dAmountMonth + amountFractionI), fTableFactor);
        
        // Fraction III:
        
        amountFractionAuxIII = computeAmoutTaxSubsidy(dbSubsidyTable, dAmountMonth, fTableFactor);
        amountFractionIII = amountFractionAuxIII > 0 ? (amountFractionII - amountFractionAuxIII) : 0;
        
        // Fraction V:
        
        amountFractionV = amountFractionI == 0 ? 0 : (amountFractionIII / amountFractionI);
        
        // Fraction IV:
        amountFractionIV = amountFractionAuxIII > 0 ? (dTaxableAmount * amountFractionV) : 0;
        
        
        return amountFractionIV;
    }
    
    /**
     * Function for calculated amount net.
     * @param session User GUI session.
     * @param grossAmount amount gross.
     * @param dateCutOff date of cut.
     * @param dateBenefit
     * @return
     * @throws Exception 
     */
    public static SHrsCalculatedNetGrossAmount computeNetAmountPayment(final SGuiSession session, final double grossAmount, final Date dateCutOff, final Date dateBenefit) throws Exception {
        SHrsCalculatedNetGrossAmount netGrossAmount = null;
        SDbTaxTable dbTaxTable = null;
        SDbTaxSubsidyTable dbSubsidyTable = null;
        SDbSsContributionTable dbSscTable = null;
        SDbConfig config = null;
        double dSalaryDiary = 0;
        double dSalarySsc = 0;
        double dMwzReference = 0;
        double dNetAmount = 0;
        double dTaxAmount = 0;
        double dTaxSubsidyAmount = 0;
        double dSsContributionAmount = 0;
        double dTableFactor = 0;
        int year = SLibTimeUtils.digestYear(dateCutOff)[0];
        int days = SLibTimeUtils.getMaxDayOfMonth(dateCutOff);
        SHrsDaysByPeriod hrsDaysPrev = new SHrsDaysByPeriod(0, 0, 0, 0);
        SHrsDaysByPeriod hrsDaysCurr = new SHrsDaysByPeriod(year, 0, days, days);
        SHrsDaysByPeriod hrsDaysNext = new SHrsDaysByPeriod(0, 0, 0, 0);
        
        dSalaryDiary = grossAmount * SHrsConsts.YEAR_MONTHS / SHrsConsts.YEAR_DAYS;
        dSalarySsc = dSalaryDiary * getIntegrationFactorSbc(session, dateBenefit, dateCutOff);
        
        config = (SDbConfig) session.readRegistry(SModConsts.HRS_CFG, new int[] { SUtilConsts.BPR_CO_ID });
        dbTaxTable = (SDbTaxTable) session.readRegistry(SModConsts.HRS_TAX, new int[] { getRecentTaxTable(session, dateCutOff) });
        dbSubsidyTable = (SDbTaxSubsidyTable) session.readRegistry(SModConsts.HRS_TAX_SUB, new int[] { getRecentTaxSubsidyTable(session, dateCutOff) });
        dbSscTable = (SDbSsContributionTable) session.readRegistry(SModConsts.HRS_SSC, new int[] { getRecentSsContributionTable(session, dateCutOff) });
        dMwzReference = getRecentMwz(session, config.getFkMwzReferenceTypeId(), dateCutOff);
        
        dTableFactor = ((double) SHrsConsts.YEAR_MONTHS / SHrsConsts.YEAR_DAYS) * days;
        
        dTaxAmount = SHrsUtils.computeAmoutTax(dbTaxTable, grossAmount, dTableFactor);
        dTaxSubsidyAmount = SHrsUtils.computeAmoutTaxSubsidy(dbSubsidyTable, grossAmount, dTableFactor);
        dSsContributionAmount = SHrsUtils.computeSSContribution(dbSscTable, dSalarySsc, dMwzReference, hrsDaysPrev, hrsDaysCurr, hrsDaysNext);
        
        dNetAmount = grossAmount - dTaxAmount - dSsContributionAmount;
        
        netGrossAmount = new SHrsCalculatedNetGrossAmount(dNetAmount, grossAmount, dTaxAmount, dTaxSubsidyAmount, dSsContributionAmount);
        netGrossAmount.setCalculatedAmountType(SHrsConsts.CAL_NET_AMT_TYPE);
        netGrossAmount.setSalary(dSalaryDiary);
        netGrossAmount.setSalarySs(dSalarySsc);
        
        return netGrossAmount;
    }
    
    /**
     * Function for calculated amount gross.
     * @param session User GUI session.
     * @param netAmount amount net.
     * @param dateCutOff date of cut.
     * @param tolerance
     * @param dateBenefit
     * @return
     * @throws Exception 
     */
    public static SHrsCalculatedNetGrossAmount computeGrossAmountPayment(final SGuiSession session, final double netAmount, final Date dateCutOff, final double tolerance, final Date dateBenefit) throws Exception {
        SHrsCalculatedNetGrossAmount netGrossAmount = null;
        SDbTaxTable dbTaxTable = null;
        SDbTaxTableRow dbTaxTableRow = null;
        int days = SLibTimeUtils.getMaxDayOfMonth(dateCutOff);
        double dSalaryDiary = 0;
        double dSalarySsc = 0;
        double dTableFactor = 0;
        double average = 0;
        double dGrossAmount = 0;
        double limitInf = 0;
        double limitSup = 0;
        double dToleranceAux = 0;
        boolean bCalculate = true;
        
        dbTaxTable = (SDbTaxTable) session.readRegistry(SModConsts.HRS_TAX, new int[] { getRecentTaxTable(session, dateCutOff) });
        
        dTableFactor = ((double) SHrsConsts.YEAR_MONTHS / SHrsConsts.YEAR_DAYS) * days;
        
        if (dbTaxTable != null) {
            for (int i = 0; i < dbTaxTable.getChildRows().size(); i++) {
                dbTaxTableRow = dbTaxTable.getChildRows().get(i);
                if (i == 0) {
                    limitInf = SLibUtils.round(dbTaxTableRow.getLowerLimit() * dTableFactor, SUtilConsts.DECS_AMT);
                }
                if (netAmount <= SLibUtils.round(dbTaxTableRow.getLowerLimit() * dTableFactor, SUtilConsts.DECS_AMT)) {
                    limitSup = SLibUtils.round(dbTaxTableRow.getLowerLimit() * dTableFactor, SUtilConsts.DECS_AMT);
                }
                
                average = (limitInf + limitSup) / 2;
                
                dSalaryDiary = limitSup * SHrsConsts.YEAR_MONTHS / SHrsConsts.YEAR_DAYS;
                dSalarySsc = dSalaryDiary * getIntegrationFactorSbc(session, dateBenefit, dateCutOff);

                netGrossAmount = computeNetAmountPayment(session, average, dateCutOff, dateBenefit);
                
                if (netGrossAmount.getNetAmount() > netAmount) {
                    break;
                }
            }
        }
        average = 0;

        while (bCalculate) {
            average = (limitInf + limitSup) / 2;
            
            dSalaryDiary = limitSup * SHrsConsts.YEAR_MONTHS / SHrsConsts.YEAR_DAYS;
            dSalarySsc = dSalaryDiary * getIntegrationFactorSbc(session, dateBenefit, dateCutOff);

            netGrossAmount = computeNetAmountPayment(session, average, dateCutOff, dateBenefit);

            if (netGrossAmount.getNetAmount() > netAmount) {
                limitSup = average;
            }
            else {
                limitInf = average;
            }
            dToleranceAux = SLibUtils.round(netAmount - netGrossAmount.getNetAmount(), SUtilConsts.DECS_AMT);
            
            bCalculate = SLibUtils.round(limitInf, SUtilConsts.DECS_AMT) != SLibUtils.round(limitSup, SUtilConsts.DECS_AMT) && Math.abs(dToleranceAux) > tolerance;
        }
        dGrossAmount = average;
        
        netGrossAmount.setSalary(dSalaryDiary);
        netGrossAmount.setSalarySs(dSalarySsc);
        netGrossAmount.setGrossAmount(dGrossAmount);
        netGrossAmount.setCalculatedAmountType(SHrsConsts.CAL_GROSS_AMT_TYPE);
        
        return netGrossAmount;
    }
    
    public static SHrsAmountEarning getAmountEarningByEmployee(final SGuiSession session, final int employeeId, final int earningTypeId, final int periodYear, final Date dateCutOff) throws Exception {
        SHrsAmountEarning amountEarning = null;
        String sql = "";
        ResultSet resultSet = null;
        Statement statement = session.getDatabase().getConnection().createStatement();

        sql = "SELECT SUM(pre.amt_r) AS f_amount, SUM(pre.amt_exem) AS f_exem, SUM(pre.amt_taxa) AS f_taxa " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p " +
            "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON " +
            "p.id_pay = pr.id_pay " +
            "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_EAR) + " AS pre ON " +
            "pr.id_pay = pre.id_pay AND pr.id_emp = pre.id_emp " +
            "WHERE p.b_del = 0 AND pr.b_del = 0 AND pre.b_del = 0 AND pr.id_emp = " + employeeId + 
            (earningTypeId == SLibConsts.UNDEFINED ? "" : " AND pre.fk_tp_ear = " + earningTypeId) + " AND " +
            "p.per_year = " + periodYear + " AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(dateCutOff) + "'";
        
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            amountEarning = new SHrsAmountEarning(earningTypeId);
            
            amountEarning.setAmount(resultSet.getDouble("f_amount"));
            amountEarning.setAmountExempt(resultSet.getDouble("f_exem"));
            amountEarning.setAmountTaxable(resultSet.getDouble("f_taxa"));
        }
        
        return amountEarning;
    }
    
    public static double getAmountDeductionByEmployee(final SGuiSession session, final int employeeId, final int deductionTypeId, final int periodYear, final Date dateCutOff) throws Exception {
        double amountDeduction = 0;
        String sql = "";
        ResultSet resultSet = null;
        Statement statement = session.getDatabase().getConnection().createStatement();

        sql = "SELECT SUM(prd.amt_r) AS f_amount " +
            "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p " +
            "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON " +
            "p.id_pay = pr.id_pay " +
            "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_DED) + " AS prd ON " +
            "pr.id_pay = prd.id_pay AND pr.id_emp = prd.id_emp " +
            "WHERE p.b_del = 0 AND pr.b_del = 0 AND prd.b_del = 0 AND pr.id_emp = " + employeeId + 
            (deductionTypeId == SLibConsts.UNDEFINED ? "" : " AND prd.fk_tp_ded = " + deductionTypeId) + " AND " +
            "p.per_year = " + periodYear + " AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(dateCutOff) + "'";
        
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            amountDeduction = resultSet.getDouble("f_amount");
        }
        
        return amountDeduction;
    }
    
    public static SHrsAmountEarning getAmountEarningsByEmployee(final SGuiSession session, final int employeeId, final int periodYear, final Date dateCutOff) throws Exception {
        return getAmountEarningByEmployee(session, employeeId, SLibConsts.UNDEFINED, periodYear, dateCutOff);
    }
    
    /**
     * Gets the accounting setup for a earning and a type of accounting specific configuration.
     * @param session User GUI session.
     * @param nEarningId earning Id.
     * @param nAuxAccountingConfigurationTypeId accounting settings type.
     * @return Object of type SDbAccountingEarning
     * @throws Exception 
     */
    private static ArrayList<SDbAccountingEarning> getAccountingEarning(final SGuiSession session, final int nEarningId, final int nAuxAccountingConfigurationTypeId) throws Exception {
        String sql = "";
        ResultSet resultSet = null;
        SDbAccountingEarning accountingEarning = null;
        ArrayList<SDbAccountingEarning> aAccountingEarning = new ArrayList<SDbAccountingEarning>();
        
        sql = "SELECT id_ref " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_ACC_EAR) + " " +
                "WHERE b_del = 0 AND id_ear = " + nEarningId + " AND id_tp_acc = " + nAuxAccountingConfigurationTypeId + " ";
        resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
        while (resultSet.next()) {

            accountingEarning = new SDbAccountingEarning();
            accountingEarning.read(session, new int[] { nEarningId, nAuxAccountingConfigurationTypeId, resultSet.getInt(1) });
            aAccountingEarning.add(accountingEarning);
        }
        
        return aAccountingEarning;
    }
    
    /**
     * Gets the accounting setup for a deducction and a type of accounting specific configuration.
     * @param session User GUI session.
     * @param nDeductionId deducction Id.
     * @param nAuxAccountingConfigurationTypeId accounting settings type.
     * @return Object of type SDbAccountingDeduction
     * @throws Exception 
     */
    public static ArrayList<SDbAccountingDeduction> getAccountingDeduction(final SGuiSession session, final int nDeductionId, final int nAuxAccountingConfigurationTypeId) throws Exception {
        String sql = "";
        ResultSet resultSet = null;
        SDbAccountingDeduction accountingDeduction = null;
        ArrayList<SDbAccountingDeduction> aAccountingDeduction = new ArrayList<SDbAccountingDeduction>();
        
        sql = "SELECT id_ref " +
                "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_ACC_DED) + " " +
                "WHERE b_del = 0 AND id_ded = " + nDeductionId + " AND id_tp_acc = " + nAuxAccountingConfigurationTypeId + " ";
        resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
        while (resultSet.next()) {

            accountingDeduction = new SDbAccountingDeduction();
            accountingDeduction.read(session, new int[] { nDeductionId, nAuxAccountingConfigurationTypeId, resultSet.getInt(1) });
            aAccountingDeduction.add(accountingDeduction);
        }
        
        return aAccountingDeduction;
    }
    
    /**
     * Create accounting settings by default for earning.
     * @return 
     */
    private static SDbAccountingEarning createAccountingEarning() {
        SDbAccountingEarning accountingEarning = null;
        
        accountingEarning = new SDbAccountingEarning();
            
        accountingEarning.setFkAccountId(SModSysConsts.FIN_ACC_NA);
        accountingEarning.setFkCostCenterId_n(SLibConsts.UNDEFINED);
        accountingEarning.setFkItemId_n(SLibConsts.UNDEFINED);
        accountingEarning.setFkBizPartnerId_n(SLibConsts.UNDEFINED);
        accountingEarning.setFkTaxBasicId_n(SLibConsts.UNDEFINED);
        accountingEarning.setFkTaxTaxId_n(SLibConsts.UNDEFINED);
        /*
        accountingEarning.setFkUserInsertId();
        accountingEarning.setFkUserUpdateId();
        accountingEarning.setTsUserInsert();
        accountingEarning.setTsUserUpdate();
        */
        
        
        return accountingEarning;
    }
    
    /**
     * Create accounting settings by default for deduction.
     * @return 
     */
    private static SDbAccountingDeduction createAccountingDeduction() {
        SDbAccountingDeduction accountingDeduction = null;
        
        accountingDeduction = new SDbAccountingDeduction();
            
        accountingDeduction.setFkAccountId(SModSysConsts.FIN_ACC_NA);
        accountingDeduction.setFkCostCenterId_n(SLibConsts.UNDEFINED);
        accountingDeduction.setFkItemId_n(SLibConsts.UNDEFINED);
        accountingDeduction.setFkBizPartnerId_n(SLibConsts.UNDEFINED);
        accountingDeduction.setFkTaxBasicId_n(SLibConsts.UNDEFINED);
        accountingDeduction.setFkTaxTaxId_n(SLibConsts.UNDEFINED);
        /*
        accountingDeduction.setFkUserInsertId();
        accountingDeduction.setFkUserUpdateId();
        accountingDeduction.setTsUserInsert();
        accountingDeduction.setTsUserUpdate();
        */
        
        return accountingDeduction;
    }
    
    /**
     * Obtain accounting settings earning type for one departament.
     * @param maAccountingEarning Array objects of SDbAccountingEarning type.
     * @param departamentId departament Id.
     * @return
     * @throws Exception 
     */
    private static SDbAccountingEarning getAccountingEarningConfigurationDepartament(final ArrayList<SDbAccountingEarning> maAccountingEarning, final int departamentId) throws Exception {
        SDbAccountingEarning accountingEarning = null;
        
        for (SDbAccountingEarning dbAccountingEarning : maAccountingEarning) {
            if (dbAccountingEarning.getPkReferenceId() == departamentId) {
                accountingEarning = dbAccountingEarning.clone();
                break;
            }
        }
        
        if (accountingEarning == null) {
            accountingEarning = createAccountingEarning();
        }
        
        return accountingEarning;
    }
    
    /**
     * Obtain accounting settings deduction type for one departament.
     * @param maAccountingDeduction Array objects of SDbAccountingDeduction type.
     * @param departamentId departament Id.
     * @return
     * @throws Exception 
     */
    private static SDbAccountingDeduction getAccountingDeductionConfigurationDepartament(final ArrayList<SDbAccountingDeduction> maAccountingDeduction, final int departamentId) throws Exception {
        SDbAccountingDeduction accountingDeduction = null;
        
        for (SDbAccountingDeduction dbAccountingDeduction : maAccountingDeduction) {
            if (dbAccountingDeduction.getPkReferenceId() == departamentId) {
                accountingDeduction = dbAccountingDeduction.clone();
                break;
            }
        }
        
        if (accountingDeduction == null) {
            accountingDeduction = createAccountingDeduction();
        }
        
        return accountingDeduction;
    }
    
    /**
     * Create accounting settings for earning.
     * @param session User GUI session.
     * @param nEarningId earning Id.
     * @param nAccountingConfigurationTypeNewId accounting settings type new.
     * @param nAccountingConfigurationTypeOldId accounting settings type old.
     * @param bIsRegistryNew is registry new?.
     * @throws Exception 
     */
    public static void createAccountingEarningConfiguration(final SGuiSession session, final int nEarningId, final int nAccountingConfigurationTypeNewId, final int nAccountingConfigurationTypeOldId, final boolean bIsRegistryNew) throws Exception {
        ResultSet resultSet = null;
        String sql = "";
        ArrayList<SDbAccountingEarning> aAccountingEarning = new ArrayList<SDbAccountingEarning>();
        ArrayList<SDbDepartment> departments = new ArrayList<SDbDepartment>();
        ArrayList<SDbEmployee> employees = new ArrayList<SDbEmployee>();
        SDbAccountingEarning accountingEarning = null;
        SDbDepartment department = null;
        SDbEmployee employee = null;
        ArrayList<SDbAccountingEarning> maAccountingEarning = getAccountingEarning(session, nEarningId, nAccountingConfigurationTypeOldId);
        
        if (bIsRegistryNew || (nAccountingConfigurationTypeOldId != SLibConsts.UNDEFINED &&
                nAccountingConfigurationTypeOldId != nAccountingConfigurationTypeNewId)) {
            for (SDbAccountingEarning dbAccountingEarning : maAccountingEarning) {
                if (SLibUtils.compareKeys(new int[] { dbAccountingEarning.getPkEarningId() }, new int[] { nEarningId })) {
                    dbAccountingEarning.setDeleted(true);
                    dbAccountingEarning.save(session);
                }
            }
        }
        
        if (nAccountingConfigurationTypeNewId != nAccountingConfigurationTypeOldId) {
            switch (nAccountingConfigurationTypeNewId) {
                case SModSysConsts.HRSS_TP_ACC_GBL:
                    accountingEarning = createAccountingEarning();
            
                    accountingEarning.setPkEarningId(nEarningId);
                    accountingEarning.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_GBL);
                    accountingEarning.setPkReferenceId(SLibConsts.UNDEFINED);
                    accountingEarning.setDeleted(false);

                    aAccountingEarning.add(accountingEarning);
                    break;
                case SModSysConsts.HRSS_TP_ACC_DEP:
                    sql = "SELECT id_dep FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_DEP) + " ";
                    
                    resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
                    while (resultSet.next()) {
                        department = (SDbDepartment) session.readRegistry(SModConsts.HRSU_DEP, new int[] { resultSet.getInt(1) });
                        departments.add(department);
                    }
                    
                    for (SDbDepartment dbDepartment : departments) {
                        if (nAccountingConfigurationTypeNewId != SLibConsts.UNDEFINED &&
                                nAccountingConfigurationTypeNewId < nAccountingConfigurationTypeOldId && !maAccountingEarning.isEmpty()) {
                            accountingEarning = maAccountingEarning.get(0).clone();
                        }
                        else {
                            accountingEarning = createAccountingEarning();
                        }
                        accountingEarning.setDeleted(false);
                        accountingEarning.setPkEarningId(nEarningId);
                        accountingEarning.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_DEP);
                        accountingEarning.setPkReferenceId(dbDepartment.getPkDepartmentId());

                        aAccountingEarning.add(accountingEarning);
                    }
                    
                    break;
                case SModSysConsts.HRSS_TP_ACC_EMP:
                    sql = "SELECT id_emp FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " ";
                    
                    resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
                    while (resultSet.next()) {
                        employee = (SDbEmployee) session.readRegistry(SModConsts.HRSU_EMP, new int[] { resultSet.getInt(1) });
                        employees.add(employee);
                    }
                    
                    for (SDbEmployee dbEmployee : employees) {
                        if (nAccountingConfigurationTypeNewId != SLibConsts.UNDEFINED &&
                                nAccountingConfigurationTypeNewId < nAccountingConfigurationTypeOldId) {
                            if (nAccountingConfigurationTypeNewId == SModSysConsts.HRSS_TP_ACC_GBL && !maAccountingEarning.isEmpty()) {
                                accountingEarning = maAccountingEarning.get(0).clone();
                            }
                            else {
                                accountingEarning = getAccountingEarningConfigurationDepartament(maAccountingEarning, dbEmployee.getFkDepartmentId());
                            }
                        }
                        else {
                            accountingEarning = createAccountingEarning();
                        }
                        accountingEarning.setDeleted(false);
                        accountingEarning.setPkEarningId(nEarningId);
                        accountingEarning.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_EMP);
                        accountingEarning.setPkReferenceId(dbEmployee.getPkEmployeeId());

                        aAccountingEarning.add(accountingEarning);
                    }
                    break;
                default:
                    break;
            }
        }
        
        if (!aAccountingEarning.isEmpty()) {
            maAccountingEarning.clear();
            maAccountingEarning.addAll(aAccountingEarning);
        }
        
        for (SDbAccountingEarning dbAccountingEarning : maAccountingEarning) {
            dbAccountingEarning.save(session);
        }
    }
    
    /**
     * Create accounting settings for deduction.
     * @param session User GUI session.
     * @param nDeductionId deduction Id.
     * @param nAccountingConfigurationTypeNewId accounting settings type new.
     * @param nAccountingConfigurationTypeOldId accounting settings type old.
     * @param bIsRegistryNew is registry new?.
     * @throws Exception 
     */
    public static void createAccountingDeductionConfiguration(final SGuiSession session, final int nDeductionId, final int nAccountingConfigurationTypeNewId, final int nAccountingConfigurationTypeOldId, final boolean bIsRegistryNew) throws Exception {
        ResultSet resultSet = null;
        String sql = "";
        ArrayList<SDbAccountingDeduction> aAccountingDeduction = new ArrayList<SDbAccountingDeduction>();
        ArrayList<SDbDepartment> departments = new ArrayList<SDbDepartment>();
        ArrayList<SDbEmployee> employees = new ArrayList<SDbEmployee>();
        SDbAccountingDeduction accountingDeduction = null;
        SDbDepartment department = null;
        SDbEmployee employee = null;
        ArrayList<SDbAccountingDeduction> maAccountingDeduction = getAccountingDeduction(session, nDeductionId, nAccountingConfigurationTypeOldId);
        
        if (bIsRegistryNew || (nAccountingConfigurationTypeOldId != SLibConsts.UNDEFINED &&
                nAccountingConfigurationTypeOldId != nAccountingConfigurationTypeNewId)) {
            for (SDbAccountingDeduction dbAccountingDeduction : maAccountingDeduction) {
                dbAccountingDeduction.setDeleted(true);
                dbAccountingDeduction.save(session);
            }
        }
        
        if (nAccountingConfigurationTypeNewId != nAccountingConfigurationTypeOldId) {
            switch (nAccountingConfigurationTypeNewId) {
                case SModSysConsts.HRSS_TP_ACC_GBL:
                    accountingDeduction = createAccountingDeduction();
            
                    accountingDeduction.setPkDeductionId(nDeductionId);
                    accountingDeduction.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_GBL);
                    accountingDeduction.setPkReferenceId(SLibConsts.UNDEFINED);
                    accountingDeduction.setDeleted(false);
                    
                    aAccountingDeduction.add(accountingDeduction);
                    break;
                case SModSysConsts.HRSS_TP_ACC_DEP:
                    sql = "SELECT id_dep FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_DEP) + " ";
                    
                    resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
                    while (resultSet.next()) {
                        department = (SDbDepartment) session.readRegistry(SModConsts.HRSU_DEP, new int[] { resultSet.getInt(1) });
                        departments.add(department);
                    }
                    
                    for (SDbDepartment dbDepartment : departments) {
                        if (nAccountingConfigurationTypeNewId != SLibConsts.UNDEFINED &&
                                nAccountingConfigurationTypeNewId < nAccountingConfigurationTypeOldId && !maAccountingDeduction.isEmpty()) {
                            accountingDeduction = maAccountingDeduction.get(0).clone();
                        }
                        else {
                            accountingDeduction = createAccountingDeduction();
                        }
                        accountingDeduction.setDeleted(false);
                        accountingDeduction.setPkDeductionId(nDeductionId);
                        accountingDeduction.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_DEP);
                        accountingDeduction.setPkReferenceId(dbDepartment.getPkDepartmentId());

                        aAccountingDeduction.add(accountingDeduction);
                    }
                    
                    break;
                case SModSysConsts.HRSS_TP_ACC_EMP:
                    sql = "SELECT id_emp FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " ";
                    
                    resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
                    while (resultSet.next()) {
                        employee = (SDbEmployee) session.readRegistry(SModConsts.HRSU_EMP, new int[] { resultSet.getInt(1) });
                        employees.add(employee);
                    }
                    
                    for (SDbEmployee dbEmployee : employees) {
                        if (nAccountingConfigurationTypeNewId != SLibConsts.UNDEFINED &&
                                nAccountingConfigurationTypeNewId < nAccountingConfigurationTypeOldId) {
                            if (nAccountingConfigurationTypeNewId == SModSysConsts.HRSS_TP_ACC_GBL && !maAccountingDeduction.isEmpty()) {
                                accountingDeduction = maAccountingDeduction.get(0).clone();
                            }
                            else {
                                accountingDeduction = getAccountingDeductionConfigurationDepartament(maAccountingDeduction, dbEmployee.getFkDepartmentId());
                            }
                        }
                        else {
                            accountingDeduction = createAccountingDeduction();
                        }
                        accountingDeduction.setDeleted(false);
                        accountingDeduction.setPkDeductionId(nDeductionId);
                        accountingDeduction.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_EMP);
                        accountingDeduction.setPkReferenceId(dbEmployee.getPkEmployeeId());

                        aAccountingDeduction.add(accountingDeduction);
                    }
                    break;
                default:
                    break;
            }
        }
        
        if (!aAccountingDeduction.isEmpty()) {
            maAccountingDeduction.clear();
            maAccountingDeduction.addAll(aAccountingDeduction);
        }
        
        for (SDbAccountingDeduction dbAccountingDeduction : maAccountingDeduction) {
            dbAccountingDeduction.save(session);
        }
    }
}
