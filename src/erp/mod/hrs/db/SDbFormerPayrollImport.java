/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mod.hrs.db;

import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.data.SDataRegistry;
import erp.mod.SModConsts;
import erp.mtrn.data.SCfdPacket;
import erp.mtrn.data.SDataCfd;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import sa.gui.util.SUtilConsts;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SDbFormerPayrollImport extends SDataRegistry implements Serializable {

    protected int mnPayrollId;
    protected boolean mbImportingFromFormerSiie;
    protected boolean mbRegenerateNonStampedCfdi;
    protected ArrayList<SCfdPacket> maCfdPackets;

    public SDbFormerPayrollImport() {
        super(SModConsts.HRS_SIE_PAY);
        reset();
    }

    public void setPayrollId(int n) { mnPayrollId = n; }
    public void setImportingFromFormerSiie(boolean b) { mbImportingFromFormerSiie = b; }
    public void setRegenerateNonStampedCfdi(boolean b) { mbRegenerateNonStampedCfdi = b; }

    public int getPayrollId() { return mnPayrollId; }
    public boolean isImportingFromFormerSiie() { return mbImportingFromFormerSiie; }
    public boolean isRegenerateNonStampedCfdi() { return mbRegenerateNonStampedCfdi; }
    public ArrayList<SCfdPacket> getCfdPackets() { return maCfdPackets; }

    public void setIsDeleted(boolean b) { }
    public void setFkUserNewId(int n) { }
    public void setFkUserEditId(int n) { }
    public void setFkUserDeleteId(int n) { }

    public boolean getIsDeleted() { return false; }
    public int getFkUserNewId() { return SUtilConsts.USR_NA_ID; }
    public int getFkUserEditId() { return SUtilConsts.USR_NA_ID; }
    public int getFkUserDeleteId() { return SUtilConsts.USR_NA_ID; }
    
    @Override
    public int[] getPrimaryKey() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPrimaryKey(Object pk) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void reset() {
        super.resetRegistry();

        mnPayrollId = 0;
        mbImportingFromFormerSiie = false;
        mbRegenerateNonStampedCfdi = false;
        maCfdPackets = new ArrayList<>();
    }

    @Override
    public int read(Object pk, Statement statement) {
        mnLastDbActionResult = SLibConstants.UNDEFINED;
        reset();

        return mnLastDbActionResult;
    }

    @Override
    public int save(Connection connection) {
        mnLastDbActionResult = SLibConstants.UNDEFINED;

        try {
            Statement statement = null;
            
            if (mbImportingFromFormerSiie) {
                statement = connection.createStatement();

                String sql = "UPDATE trn_cfd SET b_con = 0 "
                        + "WHERE fid_pay_pay_n = " + mnPayrollId + " AND "
                        + "fid_st_xml <> " + SDataConstantsSys.TRNS_ST_DPS_ANNULED + ";";
                statement.execute(sql);
            }

            for (SCfdPacket packet: maCfdPackets) {
                if (packet.getCfdId() != SLibConstants.UNDEFINED && packet.getIsCfdConsistent()) {
                    SDataCfd dataCfd = new SDataCfd();
                    dataCfd.read(new int[] { packet.getCfdId() }, statement);
                    dataCfd.saveField(connection, SDataCfd.FIELD_PRC_CON, true);
                }
                else {
                    SDataCfd dataCfd = packet.createDataCfd();
                    dataCfd.setIsConsistent(true);
                    if (dataCfd.save(connection) != SLibConstants.DB_ACTION_SAVE_OK) {
                        throw new Exception(SLibConstants.MSG_ERR_DB_REG_SAVE_DEP);
                    }
                }
            }
            
            if (mbImportingFromFormerSiie && mbRegenerateNonStampedCfdi) {
                String sql = "UPDATE trn_cfd AS c "
                        + "INNER JOIN hrs_sie_pay_emp AS pe ON c.fid_pay_pay_n = pe.id_pay AND c.fid_pay_emp_n = pe.id_emp AND c.fid_pay_bpr_n = pe.fid_bpr_n AND pe.b_del = 0 SET c.b_con = 1 "
                        + "WHERE c.fid_pay_pay_n = " + mnPayrollId + " AND c.fid_st_xml = " + SDataConstantsSys.TRNS_ST_DPS_EMITED + " ";
                statement.execute(sql);
            }

            mbIsRegistryNew = false;
            mnLastDbActionResult = SLibConstants.DB_ACTION_SAVE_OK;
        }
        catch (java.lang.Exception e) {
            mnLastDbActionResult = SLibConstants.DB_ACTION_SAVE_ERROR;
            SLibUtilities.printOutException(this, e);
        }

        return mnLastDbActionResult;
    }

    @Override
    public Date getLastDbUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
