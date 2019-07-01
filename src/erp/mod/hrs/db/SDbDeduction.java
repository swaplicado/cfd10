/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.db;

import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbConsts;
import sa.lib.db.SDbRegistryUser;
import sa.lib.gui.SGuiSession;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SDbDeduction extends SDbRegistryUser {

    protected int mnPkDeductionId;
    protected String msCode;
    protected String msName;
    protected String msNameAbbreviated;
    protected double mdRetPercentage;
    protected boolean mbWithholding;
    protected boolean mbPayrollTax;
    /*
    protected boolean mbDeleted;
    protected boolean mbSystem;
    */
    protected int mnFkDeductionTypeId;
    protected int mnFkDeductionComputationTypeId;
    protected int mnFkLoanTypeId;
    protected int mnFkBenefitTypeId;
    protected int mnFkAccountingConfigurationTypeId;
    protected int mnFkAccountingRecordTypeId;
    protected int mnFkAbsenceClassId_n;
    protected int mnFkAbsenceTypeId_n;
    /*
    protected int mnFkUserInsertId;
    protected int mnFkUserUpdateId;
    protected Date mtTsUserInsert;
    protected Date mtTsUserUpdate;
    */
    
    protected int mnOldAccountingConfigurationTypeId;
    
    public SDbDeduction() {
        super(SModConsts.HRS_DED);
    }

    public void setPkDeductionId(int n) { mnPkDeductionId = n; }
    public void setCode(String s) { msCode = s; }
    public void setName(String s) { msName = s; }
    public void setNameAbbreviated(String s) { msNameAbbreviated = s; }
    public void setRetPercentage(double d) { mdRetPercentage = d; }
    public void setWithholding(boolean b) { mbWithholding = b; }
    public void setPayrollTax(boolean b) { mbPayrollTax = b; }
    public void setDeleted(boolean b) { mbDeleted = b; }
    public void setSystem(boolean b) { mbSystem = b; }
    public void setFkDeductionTypeId(int n) { mnFkDeductionTypeId = n; }
    public void setFkDeductionComputationTypeId(int n) { mnFkDeductionComputationTypeId = n; }
    public void setFkLoanTypeId(int n) { mnFkLoanTypeId = n; }
    public void setFkBenefitTypeId(int n) { mnFkBenefitTypeId = n; }
    public void setFkAccountingConfigurationTypeId(int n) { mnFkAccountingConfigurationTypeId = n; }
    public void setFkAccountingRecordTypeId(int n) { mnFkAccountingRecordTypeId = n; }
    public void setFkAbsenceClassId_n(int n) { mnFkAbsenceClassId_n = n; }
    public void setFkAbsenceTypeId_n(int n) { mnFkAbsenceTypeId_n = n; }
    public void setFkUserInsertId(int n) { mnFkUserInsertId = n; }
    public void setFkUserUpdateId(int n) { mnFkUserUpdateId = n; }
    public void setTsUserInsert(Date t) { mtTsUserInsert = t; }
    public void setTsUserUpdate(Date t) { mtTsUserUpdate = t; }
    
    public int getPkDeductionId() { return mnPkDeductionId; }
    public String getCode() { return msCode; }
    public String getName() { return msName; }
    public String getNameAbbreviated() { return msNameAbbreviated; }
    public double getRetPercentage() { return mdRetPercentage; }
    /** Is deduction by law. */
    public boolean isWithholding() { return mbWithholding; }
    public boolean isPayrollTax() { return mbPayrollTax; }
    public boolean isDeleted() { return mbDeleted; }
    public boolean isSystem() { return mbSystem; }
    public int getFkDeductionTypeId() { return mnFkDeductionTypeId; }
    public int getFkDeductionComputationTypeId() { return mnFkDeductionComputationTypeId; }
    public int getFkLoanTypeId() { return mnFkLoanTypeId; }
    public int getFkBenefitTypeId() { return mnFkBenefitTypeId; }
    public int getFkAccountingConfigurationTypeId() { return mnFkAccountingConfigurationTypeId; }
    public int getFkAccountingRecordTypeId() { return mnFkAccountingRecordTypeId; }
    public int getFkAbsenceClassId_n() { return mnFkAbsenceClassId_n; }
    public int getFkAbsenceTypeId_n() { return mnFkAbsenceTypeId_n; }
    public int getFkUserInsertId() { return mnFkUserInsertId; }
    public int getFkUserUpdateId() { return mnFkUserUpdateId; }
    public Date getTsUserInsert() { return mtTsUserInsert; }
    public Date getTsUserUpdate() { return mtTsUserUpdate; }
    
    public void setOldAccountingConfigurationTypeId(int n) { mnOldAccountingConfigurationTypeId = n; }

    public int getOldAccountingConfigurationTypeId() { return mnOldAccountingConfigurationTypeId; }

    public boolean isComputedByPercentage() {
        return SLibUtils.belongsTo(mnFkDeductionComputationTypeId, new int[] { SModSysConsts.HRSS_TP_DED_COMP_PCT_INCOME } );
    }
    
    public boolean isBasedOnDaysWorked() {
        return mnFkDeductionComputationTypeId == SModSysConsts.HRSS_TP_DED_COMP_PCT_INCOME;
    }
    
    public boolean isBasedOnUnits() {
        return mnFkDeductionComputationTypeId != SModSysConsts.HRSS_TP_DED_COMP_AMT;
    }
    
    public boolean areUnitsModifiable() {
        return isBasedOnUnits() && !isAbsence();
    }

    public int[] getAbsenceTypeKey() { return new int[] { mnFkAbsenceClassId_n, mnFkAbsenceTypeId_n }; }
    
    public boolean isLoan() { return mnFkLoanTypeId != 0 && mnFkLoanTypeId != SModSysConsts.HRSS_TP_LOAN_NON; }
    public boolean isBenefit() { return mnFkBenefitTypeId != 0 && mnFkBenefitTypeId != SModSysConsts.HRSS_TP_BEN_NON; }
    public boolean isAbsence() { return mnFkAbsenceClassId_n != 0 && mnFkAbsenceTypeId_n != 0; }
    
    public boolean isMassAsignable() { return !isLoan() && !isBenefit() && !isAbsence(); }

    @Override
    public void setPrimaryKey(int[] pk) {
        mnPkDeductionId = pk[0];
    }

    @Override
    public int[] getPrimaryKey() {
        return new int[] { mnPkDeductionId };
    }

    @Override
    public void initRegistry() {
        initBaseRegistry();
        
        mnPkDeductionId = 0;
        msCode = "";
        msName = "";
        msNameAbbreviated = "";
        mdRetPercentage = 0;
        mbWithholding = false;
        mbPayrollTax = false;
        mbDeleted = false;
        mbSystem = false;
        mnFkDeductionTypeId = 0;
        mnFkDeductionComputationTypeId = 0;
        mnFkLoanTypeId = 0;
        mnFkBenefitTypeId = 0;
        mnFkAccountingConfigurationTypeId = 0;
        mnFkAccountingRecordTypeId = 0;
        mnFkAbsenceClassId_n = 0;
        mnFkAbsenceTypeId_n = 0;
        mnFkUserInsertId = 0;
        mnFkUserUpdateId = 0;
        mtTsUserInsert = null;
        mtTsUserUpdate = null;
        
        mnOldAccountingConfigurationTypeId = 0;
    }

    @Override
    public String getSqlTable() {
        return SModConsts.TablesMap.get(mnRegistryType);
    }

    @Override
    public String getSqlWhere() {
        return "WHERE id_ded = " + mnPkDeductionId + " ";
    }

    @Override
    public String getSqlWhere(int[] pk) {
        return "WHERE id_ded = " + pk[0] + " ";
    }

    @Override
    public void computePrimaryKey(SGuiSession session) throws SQLException, Exception {
        ResultSet resultSet = null;

        mnPkDeductionId = 0;

        msSql = "SELECT COALESCE(MAX(id_ded), 0) + 1 FROM " + getSqlTable();
        resultSet = session.getStatement().executeQuery(msSql);
        if (resultSet.next()) {
            mnPkDeductionId = resultSet.getInt(1);
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
            mnPkDeductionId = resultSet.getInt("id_ded");
            msCode = resultSet.getString("code");
            msName = resultSet.getString("name");
            msNameAbbreviated = resultSet.getString("name_abbr");
            mdRetPercentage = resultSet.getDouble("ret_per");
            mbWithholding = resultSet.getBoolean("b_who");
            mbPayrollTax = resultSet.getBoolean("b_pay_tax");
            mbDeleted = resultSet.getBoolean("b_del");
            mbSystem = resultSet.getBoolean("b_sys");
            mnFkDeductionTypeId = resultSet.getInt("fk_tp_ded");
            mnFkDeductionComputationTypeId = resultSet.getInt("fk_tp_ded_comp");
            mnFkLoanTypeId = resultSet.getInt("fk_tp_loan");
            mnFkBenefitTypeId = resultSet.getInt("fk_tp_ben");
            mnFkAccountingConfigurationTypeId = resultSet.getInt("fk_tp_acc_cfg");
            mnFkAccountingRecordTypeId = resultSet.getInt("fk_tp_acc_rec");
            mnFkAbsenceClassId_n = resultSet.getInt("fk_cl_abs_n");
            mnFkAbsenceTypeId_n = resultSet.getInt("fk_tp_abs_n");
            mnFkUserInsertId = resultSet.getInt("fk_usr_ins");
            mnFkUserUpdateId = resultSet.getInt("fk_usr_upd");
            mtTsUserInsert = resultSet.getTimestamp("ts_usr_ins");
            mtTsUserUpdate = resultSet.getTimestamp("ts_usr_upd");
            
            mnOldAccountingConfigurationTypeId = mnFkAccountingConfigurationTypeId;

            mbRegistryNew = false;
        }

        mnQueryResultId = SDbConsts.READ_OK;
    }

    @Override
    public void save(SGuiSession session) throws SQLException, Exception {
        initQueryMembers();
        mnQueryResultId = SDbConsts.SAVE_ERROR;

        if (mbRegistryNew) {
            verifyRegistryNew(session);
        }

        if (mbRegistryNew) {
            computePrimaryKey(session);
            mbDeleted = false;
            mnFkUserInsertId = session.getUser().getPkUserId();
            mnFkUserUpdateId = SUtilConsts.USR_NA_ID;

            msSql = "INSERT INTO " + getSqlTable() + " VALUES (" +
                    mnPkDeductionId + ", " + 
                    "'" + msCode + "', " + 
                    "'" + msName + "', " + 
                    "'" + msNameAbbreviated + "', " + 
                    mdRetPercentage + ", " + 
                    (mbWithholding ? 1 : 0) + ", " + 
                    (mbPayrollTax ? 1 : 0) + ", " + 
                    (mbDeleted ? 1 : 0) + ", " + 
                    (mbSystem ? 1 : 0) + ", " + 
                    mnFkDeductionTypeId + ", " + 
                    mnFkDeductionComputationTypeId + ", " + 
                    mnFkLoanTypeId + ", " + 
                    mnFkBenefitTypeId + ", " + 
                    mnFkAccountingConfigurationTypeId + ", " + 
                    mnFkAccountingRecordTypeId + ", " +
                    (mnFkAbsenceClassId_n == SLibConsts.UNDEFINED ? "NULL" : "" + mnFkAbsenceClassId_n) + ", " +
                    (mnFkAbsenceTypeId_n == SLibConsts.UNDEFINED ? "NULL" : "" + mnFkAbsenceTypeId_n) + ", " +
                    mnFkUserInsertId + ", " + 
                    mnFkUserUpdateId + ", " + 
                    "NOW()" + ", " + 
                    "NOW()" + " " +
                    ")";
        }
        else {
            mnFkUserUpdateId = session.getUser().getPkUserId();

            msSql = "UPDATE " + getSqlTable() + " SET " +
                    /*
                    "id_ded = " + mnPkDeductionId + ", " +
                    */
                    "code = '" + msCode + "', " +
                    "name = '" + msName + "', " +
                    "name_abbr = '" + msNameAbbreviated + "', " +
                    "ret_per = " + mdRetPercentage + ", " +
                    "b_who = " + (mbWithholding ? 1 : 0) + ", " +
                    "b_pay_tax = " + (mbPayrollTax ? 1 : 0) + ", " +
                    "b_del = " + (mbDeleted ? 1 : 0) + ", " +
                    "b_sys = " + (mbSystem ? 1 : 0) + ", " +
                    "fk_tp_ded = " + mnFkDeductionTypeId + ", " +
                    "fk_tp_ded_comp = " + mnFkDeductionComputationTypeId + ", " +
                    "fk_tp_loan = " + mnFkLoanTypeId + ", " +
                    "fk_tp_ben = " + mnFkBenefitTypeId + ", " +
                    "fk_tp_acc_cfg = " + mnFkAccountingConfigurationTypeId + ", " +
                    "fk_tp_acc_rec = " + mnFkAccountingRecordTypeId + ", " +
                    "fk_cl_abs_n = " + (mnFkAbsenceClassId_n == SLibConsts.UNDEFINED ? "NULL" : "" + mnFkAbsenceClassId_n) + ", " +
                    "fk_tp_abs_n = " + (mnFkAbsenceTypeId_n == SLibConsts.UNDEFINED ? "NULL" : "" + mnFkAbsenceTypeId_n) + ", " +
                    //"fk_usr_ins = " + mnFkUserInsertId + ", " +
                    "fk_usr_upd = " + mnFkUserUpdateId + ", " +
                    //"ts_usr_ins = " + "NOW()" + ", " +
                    "ts_usr_upd = " + "NOW()" + " " +
                    getSqlWhere();
        }

        session.getStatement().execute(msSql);
        
        SHrsUtils.createAccountingDeductionConfiguration(session, mnPkDeductionId, mnFkAccountingConfigurationTypeId, mnOldAccountingConfigurationTypeId);
        
        mbRegistryNew = false;
        mnQueryResultId = SDbConsts.SAVE_OK;
    }

    @Override
    public SDbDeduction clone() throws CloneNotSupportedException {
        SDbDeduction registry = new SDbDeduction();

        registry.setPkDeductionId(this.getPkDeductionId());
        registry.setCode(this.getCode());
        registry.setName(this.getName());
        registry.setNameAbbreviated(this.getNameAbbreviated());
        registry.setRetPercentage(this.getRetPercentage());
        registry.setWithholding(this.isWithholding());
        registry.setPayrollTax(this.isPayrollTax());
        registry.setDeleted(this.isDeleted());
        registry.setSystem(this.isSystem());
        registry.setFkDeductionTypeId(this.getFkDeductionTypeId());
        registry.setFkDeductionComputationTypeId(this.getFkDeductionComputationTypeId());
        registry.setFkLoanTypeId(this.getFkLoanTypeId());
        registry.setFkBenefitTypeId(this.getFkBenefitTypeId());
        registry.setFkAccountingConfigurationTypeId(this.getFkAccountingConfigurationTypeId());
        registry.setFkAccountingRecordTypeId(this.getFkAccountingRecordTypeId());
        registry.setFkAbsenceClassId_n(this.getFkAbsenceClassId_n());
        registry.setFkAbsenceTypeId_n(this.getFkAbsenceTypeId_n());
        registry.setFkUserInsertId(this.getFkUserInsertId());
        registry.setFkUserUpdateId(this.getFkUserUpdateId());
        registry.setTsUserInsert(this.getTsUserInsert());
        registry.setTsUserUpdate(this.getTsUserUpdate());
        
        registry.setOldAccountingConfigurationTypeId(this.getOldAccountingConfigurationTypeId());

        registry.setRegistryNew(this.isRegistryNew());
        return registry;
    }
}
