/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.db;

import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibConsts;
import sa.lib.db.SDbConsts;
import sa.lib.db.SDbRegistryUser;
import sa.lib.gui.SGuiSession;

/**
 *
 * @author Sergio Flores
 */
public class SDbDepartment extends SDbRegistryUser {

    protected int mnPkDepartmentId;
    protected String msCode;
    protected String msName;
    /*
    protected boolean mbDeleted;
    protected boolean mbSystem;
    protected int mnFkUserInsertId;
    protected int mnFkUserUpdateId;
    protected Date mtTsUserInsert;
    protected Date mtTsUserUpdate;
    */

    private ArrayList<SDbAccountingEarning> createAccountingEarningConfiguration(final SGuiSession session) throws Exception {
        ResultSet resultSet = null;
        String sql = "";
        ArrayList<SDbAccountingEarning> aAccountingEarning = new ArrayList<SDbAccountingEarning>();
        SDbAccountingEarning accountingEarning = null;
        
        sql = "SELECT DISTINCT id_ear, b_del FROM " + SModConsts.TablesMap.get(SModConsts.HRS_ACC_EAR) + " " +
                "WHERE id_tp_acc = " + SModSysConsts.HRSS_TP_ACC_DEP + " ";
                    
        resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
        while (resultSet.next()) {
            accountingEarning = new SDbAccountingEarning();

            accountingEarning.setPkEarningId(resultSet.getInt("id_ear"));
            accountingEarning.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_DEP);
            accountingEarning.setPkReferenceId(mnPkDepartmentId);
            accountingEarning.setDeleted(resultSet.getBoolean("b_del"));
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
            
            aAccountingEarning.add(accountingEarning);
        }
        
        return aAccountingEarning;
    }
    
    private ArrayList<SDbAccountingDeduction> createAccountingDeductionConfiguration(final SGuiSession session) throws Exception {
        ResultSet resultSet = null;
        String sql = "";
        ArrayList<SDbAccountingDeduction> aAccountingDeduction = new ArrayList<SDbAccountingDeduction>();
        SDbAccountingDeduction accountingDeduction = null;
        
        sql = "SELECT DISTINCT id_ded, b_del FROM " + SModConsts.TablesMap.get(SModConsts.HRS_ACC_DED) + " " +
                "WHERE id_tp_acc = " + SModSysConsts.HRSS_TP_ACC_DEP + " ";
                    
        resultSet = session.getStatement().getConnection().createStatement().executeQuery(sql);
        while (resultSet.next()) {
            accountingDeduction = new SDbAccountingDeduction();

            accountingDeduction.setPkDeductionId(resultSet.getInt("id_ded"));
            accountingDeduction.setPkAccountingTypeId(SModSysConsts.HRSS_TP_ACC_DEP);
            accountingDeduction.setPkReferenceId(mnPkDepartmentId);
            accountingDeduction.setDeleted(resultSet.getBoolean("b_del"));
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

            aAccountingDeduction.add(accountingDeduction);
        }
        
        return aAccountingDeduction;
    }
    
    public SDbDepartment() {
        super(SModConsts.HRSU_DEP);
    }

    public void setPkDepartmentId(int n) { mnPkDepartmentId = n; }
    public void setCode(String s) { msCode = s; }
    public void setName(String s) { msName = s; }
    public void setDeleted(boolean b) { mbDeleted = b; }
    public void setSystem(boolean b) { mbSystem = b; }
    public void setFkUserInsertId(int n) { mnFkUserInsertId = n; }
    public void setFkUserUpdateId(int n) { mnFkUserUpdateId = n; }
    public void setTsUserInsert(Date t) { mtTsUserInsert = t; }
    public void setTsUserUpdate(Date t) { mtTsUserUpdate = t; }

    public int getPkDepartmentId() { return mnPkDepartmentId; }
    public String getCode() { return msCode; }
    public String getName() { return msName; }
    public boolean isDeleted() { return mbDeleted; }
    public boolean isSystem() { return mbSystem; }
    public int getFkUserInsertId() { return mnFkUserInsertId; }
    public int getFkUserUpdateId() { return mnFkUserUpdateId; }
    public Date getTsUserInsert() { return mtTsUserInsert; }
    public Date getTsUserUpdate() { return mtTsUserUpdate; }

    @Override
    public void setPrimaryKey(int[] pk) {
        mnPkDepartmentId = pk[0];
    }

    @Override
    public int[] getPrimaryKey() {
        return new int[] { mnPkDepartmentId };
    }

    @Override
    public void initRegistry() {
        initBaseRegistry();

        mnPkDepartmentId = 0;
        msCode = "";
        msName = "";
        mbDeleted = false;
        mbSystem = false;
        mnFkUserInsertId = 0;
        mnFkUserUpdateId = 0;
        mtTsUserInsert = null;
        mtTsUserUpdate = null;
    }

    @Override
    public String getSqlTable() {
        return SModConsts.TablesMap.get(mnRegistryType);
    }

    @Override
    public String getSqlWhere() {
        return "WHERE id_dep = " + mnPkDepartmentId + " ";
    }

    @Override
    public String getSqlWhere(int[] pk) {
        return "WHERE id_dep = " + pk[0] + " ";
    }

    @Override
    public void computePrimaryKey(SGuiSession session) throws SQLException, Exception {
        ResultSet resultSet = null;

        mnPkDepartmentId = 0;

        msSql = "SELECT COALESCE(MAX(id_dep), 0) + 1 FROM " + getSqlTable() + " ";
        resultSet = session.getStatement().executeQuery(msSql);
        if (resultSet.next()) {
            mnPkDepartmentId = resultSet.getInt(1);
        }
    }

    @Override
    public void read(SGuiSession session, int[] pk) throws SQLException, Exception {
        ResultSet resultSet = null;

        initRegistry();
        initQueryMembers();
        mnQueryResultId = SDbConsts.READ_ERROR;

        msSql = "SELECT * " + getSqlFromWhere(pk);
        resultSet = session.getStatement().executeQuery(msSql);
        if (!resultSet.next()) {
            throw new Exception(SDbConsts.ERR_MSG_REG_NOT_FOUND);
        }
        else {
            mnPkDepartmentId = resultSet.getInt("id_dep");
            msCode = resultSet.getString("code");
            msName = resultSet.getString("name");
            mbDeleted = resultSet.getBoolean("b_del");
            mbSystem = resultSet.getBoolean("b_sys");
            mnFkUserInsertId = resultSet.getInt("fk_usr_ins");
            mnFkUserUpdateId = resultSet.getInt("fk_usr_upd");
            mtTsUserInsert = resultSet.getTimestamp("ts_usr_ins");
            mtTsUserUpdate = resultSet.getTimestamp("ts_usr_upd");

            mbRegistryNew = false;
        }

        mnQueryResultId = SDbConsts.READ_OK;
    }

    @Override
    public void save(SGuiSession session) throws SQLException, Exception {
        initQueryMembers();
        mnQueryResultId = SDbConsts.SAVE_ERROR;
        ArrayList<SDbAccountingEarning> aAccountingEarning = null;
        ArrayList<SDbAccountingDeduction> aAccountingDeductions = null;

        if (mbRegistryNew) {
            computePrimaryKey(session);
            mbDeleted = false;
            mbSystem = false;
            mnFkUserInsertId = session.getUser().getPkUserId();
            mnFkUserUpdateId = SUtilConsts.USR_NA_ID;

            msSql = "INSERT INTO " + getSqlTable() + " VALUES (" +
                    mnPkDepartmentId + ", " +
                    "'" + msCode + "', " +
                    "'" + msName + "', " +
                    (mbDeleted ? 1 : 0) + ", " +
                    (mbSystem ? 1 : 0) + ", " +
                    mnFkUserInsertId + ", " +
                    mnFkUserUpdateId + ", " +
                    "NOW()" + ", " +
                    "NOW()" + " " +
                    ")";
        }
        else {
            mnFkUserUpdateId = session.getUser().getPkUserId();

            msSql = "UPDATE " + getSqlTable() + " SET " +
                    //"id_dep = " + mnPkDepartmentId + ", " +
                    "code = '" + msCode + "', " +
                    "name = '" + msName + "', " +
                    "b_del = " + (mbDeleted ? 1 : 0) + ", " +
                    "b_sys = " + (mbSystem ? 1 : 0) + ", " +
                    //"fk_usr_ins = " + mnFkUserInsertId + ", " +
                    "fk_usr_upd = " + mnFkUserUpdateId + ", " +
                    //"ts_usr_ins = " + "NOW()" + ", " +
                    "ts_usr_upd = " + "NOW()" + " " +
                    getSqlWhere();
        }

        session.getStatement().execute(msSql);
        
        if (mbRegistryNew) {
            aAccountingEarning = createAccountingEarningConfiguration(session);
            aAccountingDeductions = createAccountingDeductionConfiguration(session);
            
            for (SDbAccountingEarning accountingEarning : aAccountingEarning) {
                accountingEarning.save(session);
            }
            for (SDbAccountingDeduction accountingDeduction : aAccountingDeductions) {
                accountingDeduction.save(session);
            }
        }
        mbRegistryNew = false;
        mnQueryResultId = SDbConsts.SAVE_OK;
    }

    @Override
    public SDbDepartment clone() throws CloneNotSupportedException {
        SDbDepartment registry = new SDbDepartment();

        registry.setPkDepartmentId(this.getPkDepartmentId());
        registry.setCode(this.getCode());
        registry.setName(this.getName());
        registry.setDeleted(this.isDeleted());
        registry.setSystem(this.isSystem());
        registry.setFkUserInsertId(this.getFkUserInsertId());
        registry.setFkUserUpdateId(this.getFkUserUpdateId());
        registry.setTsUserInsert(this.getTsUserInsert());
        registry.setTsUserUpdate(this.getTsUserUpdate());

        registry.setRegistryNew(this.isRegistryNew());
        return registry;
    }
}
