/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.fin.db;

import erp.data.SDataConstantsSys;
import erp.mfin.data.SFinBalanceTax;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sa.lib.SLibConsts;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;
import sa.lib.db.SDbConsts;
import sa.lib.gui.SGuiSession;

/**
 *
 * @author Sergio Flores
 */
public abstract class SFinUtils {

    public static String getAccountFormerIdXXX(final SGuiSession session, final int idAccount) {
        String sql = "";
        String idFormer = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT id_acc FROM " + SModConsts.TablesMap.get(SModConsts.FIN_ACC) + " "
                    + "WHERE pk_acc = " + idAccount + " ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                idFormer = resultSet.getString(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return idFormer;
    }

    public static String getCostCenterFormerIdXXX(final SGuiSession session, final int idCostCenter) {
        String sql = "";
        String idFormer = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT id_cc FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CC) + " "
                    + "WHERE pk_cc = " + idCostCenter + " ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                idFormer = resultSet.getString(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return idFormer;
    }

    public static int getAccountId(final SGuiSession session, final String idFormerAccount) {
        int id = SLibConsts.UNDEFINED;
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT pk_acc FROM " + SModConsts.TablesMap.get(SModConsts.FIN_ACC) + " "
                    + "WHERE id_acc = '" + idFormerAccount + "' ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return id;
    }

    public static int getCostCenterId(final SGuiSession session, final String idFormerCostCenter) {
        int id = SLibConsts.UNDEFINED;
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT pk_cc FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CC) + " "
                    + "WHERE id_cc = '" + idFormerCostCenter + "' ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return id;
    }

    public static int getCashCurrencyId(SGuiSession session, int[] keyCash) {
        int idCurrency = SLibConsts.UNDEFINED;
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT fid_cur FROM " + SModConsts.TablesMap.get(SModConsts.FIN_ACC_CASH) + " "
                    + "WHERE id_cob = " + keyCash[0] + " AND id_acc_cash = " + keyCash[1] + " ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                idCurrency = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return idCurrency;
    }

    public static int getCashCategoryId(SGuiSession session, int[] keyCash) {
        int idCategory = SLibConsts.UNDEFINED;
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT fid_ct_acc_cash FROM " + SModConsts.TablesMap.get(SModConsts.FIN_ACC_CASH) + " "
                    + "WHERE id_cob = " + keyCash[0] + " AND id_acc_cash = " + keyCash[1] + " ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                idCategory = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return idCategory;
    }

    public static int getLayoutBankId(final SGuiSession session, final int layouBank) {
        int id = SLibConsts.UNDEFINED;
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT DISTINCT fid_bank FROM " + SModConsts.TablesMap.get(SModConsts.FINU_TP_LAY_BANK) + " "
                    + "WHERE lay_bank = '" + layouBank + "' ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return id;
    }

    public static SFinBalance getCashBalance(SGuiSession session, int[] keyCash, Date date, Object keyRecordToExclude_n) {
        int idCurrency = getCashCurrencyId(session, keyCash);
        SFinBalance balance = null;
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT SUM(re.debit - re.credit), SUM(IF(re.fid_cur <> " + idCurrency + ", 0, re.debit_cur - re.credit_cur)) "
                    + "FROM " + SModConsts.TablesMap.get(SModConsts.FIN_REC) + " AS r "
                    + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.FIN_REC_ETY) + " AS re ON "
                    + "r.id_year = re.id_year AND r.id_per = re.id_per AND r.id_bkc = re.id_bkc AND r.id_tp_rec = re.id_tp_rec AND r.id_num = re.id_num AND "
                    + "r.b_del = 0 AND re.b_del = 0 AND r.id_year = " + SLibTimeUtils.digestYear(date)[0] + " AND r.dt <= '" + SLibUtils.DbmsDateFormatDate.format(date) + "' AND "
                    + "re.fid_cl_sys_acc = " + SModSysConsts.FINS_CL_SYS_ACC_ENT_CSH + " AND re.fid_cob_n = " + keyCash[0] + " AND re.fid_ent_n = " + keyCash[1] + " "
                    + (keyRecordToExclude_n == null ? "" : "AND NOT ("
                    + "r.id_year = " + ((Object[]) keyRecordToExclude_n)[0] + " AND "
                    + "r.id_per = " + ((Object[]) keyRecordToExclude_n)[1] + " AND "
                    + "r.id_bkc = " + ((Object[]) keyRecordToExclude_n)[2] + " AND "
                    + "r.id_tp_rec = '" + ((Object[]) keyRecordToExclude_n)[3] + "' AND "
                    + "r.id_num = " + ((Object[]) keyRecordToExclude_n)[4] + ") ");
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                balance = new SFinBalance(resultSet.getDouble(1), resultSet.getDouble(2), idCurrency);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return balance;
    }

    public static SDbCheckWallet readCheckWallet(final SGuiSession session, final int[] keyCash) throws SQLException, Exception {
        return readCheckWallet(session, keyCash, 0);
    }

    public static SDbCheckWallet readCheckWallet(final SGuiSession session, final int[] keyCash, final int checkNumber) throws SQLException, Exception {
        int count = 0;
        String sql = "";
        ResultSet resultSet = null;
        SDbCheckWallet checkWallet = null;

        if (checkNumber != 0) {
            sql = "SELECT c.id_check_wal "
                    + "FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CHECK) + " AS c "
                    + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.FIN_CHECK_WAL) + " AS cw ON c.id_check_wal = cw.id_check_wal AND "
                    + "c.b_del = 0 AND cw.fid_cob = " + keyCash[0] + " AND cw.fid_acc_cash = " + keyCash[1] + " AND c.num = " + checkNumber + " ";
        }
        else {
            sql = "SELECT COUNT(*) FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CHECK_WAL) + " "
                    + "WHERE b_act = 1 AND b_del = 0 AND fid_cob = " + keyCash[0] + " AND fid_acc_cash = " + keyCash[1] + " ";
            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }

            if (count == 0) {
                throw new Exception("La cuenta bancaria no tiene chequeras definidas.");
            }
            else if (count > 1) {
                throw new Exception("La cuenta bancaria sólo debe tener una chequera definida.");
            }
            else {
                sql = "SELECT id_check_wal FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CHECK_WAL) + " "
                        + "WHERE b_del = 0 AND fid_cob = " + keyCash[0] + " AND fid_acc_cash = " + keyCash[1] + " ";
            }
        }

        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            checkWallet = (SDbCheckWallet) session.readRegistry(SModConsts.FIN_CHECK_WAL, new int[] { resultSet.getInt(1) });
        }
        else {
            throw new Exception("No se pudo leer la chequera:\n" + SDbConsts.ERR_MSG_REG_NOT_FOUND);
        }

        return checkWallet;
    }

    public static int getCheckNextNumber(final SGuiSession session, final int idCheckWallet) throws SQLException, Exception {
        int numNext = 0;
        int numStart = 0;
        String sql = "";
        ResultSet resultSet = null;

        sql = "SELECT COALESCE(MAX(num), 0) + 1 FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CHECK) + " "
                + "WHERE b_del = 0 AND id_check_wal = " + idCheckWallet + " ";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            numNext = resultSet.getInt(1);
        }

        sql = "SELECT num_start FROM " + SModConsts.TablesMap.get(SModConsts.FIN_CHECK_WAL) + " "
                + "WHERE id_check_wal = " + idCheckWallet + " ";
        resultSet = session.getStatement().executeQuery(sql);
        if (resultSet.next()) {
            numStart = resultSet.getInt(1);
        }

        return numNext >= numStart ? numNext : numStart;
    }

    public static SFinBalance getDpsBalance(final SGuiSession session, final int[] keyDps, final Date dateCutOff, final Object[] keyRecordToExclude_n) {
        String sql = "";
        ResultSet resultSet = null;
        SFinBalance balance = null;

        try {
            sql = "SELECT d.fid_ct_dps, d.fid_cur, "
                    + "SUM(re.debit - re.credit) AS f_bal, "
                    + "SUM(IF(re.fid_cur <> d.fid_cur, 0, re.debit_cur - re.credit_cur)) AS f_bal_cur "
                    + "FROM " + SModConsts.TablesMap.get(SModConsts.FIN_REC) + " AS r "
                    + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.FIN_REC_ETY) + " AS re ON "
                    + "r.id_year = re.id_year AND r.id_per = re.id_per AND r.id_bkc = re.id_bkc AND r.id_tp_rec = re.id_tp_rec AND r.id_num = re.id_num AND "
                    + "r.b_del = 0 AND re.b_del = 0 AND r.id_year = " + SLibTimeUtils.digestYear(dateCutOff)[0] + " AND r.dt <= '" + SLibUtils.DbmsDateFormatDate.format(dateCutOff) + "' AND "
                    + "re.fid_ct_sys_mov_xxx = " + SDataConstantsSys.FINS_CT_SYS_MOV_BPS + " AND re.fid_dps_year_n = " + keyDps[0] + " AND re.fid_dps_doc_n = " + keyDps[1] + " "
                    + (keyRecordToExclude_n == null ? "" : "AND NOT ("
                    + "r.id_year = " + ((Object[]) keyRecordToExclude_n)[0] + " AND "
                    + "r.id_per = " + ((Object[]) keyRecordToExclude_n)[1] + " AND "
                    + "r.id_bkc = " + ((Object[]) keyRecordToExclude_n)[2] + " AND "
                    + "r.id_tp_rec = '" + ((Object[]) keyRecordToExclude_n)[3] + "' AND "
                    + "r.id_num = " + ((Object[]) keyRecordToExclude_n)[4] + ") ")
                    + "INNER JOIN trn_dps AS d ON "
                    + "re.fid_dps_year_n = d.id_year AND re.fid_dps_doc_n = d.id_doc "
                    + "GROUP BY d.fid_ct_dps, d.fid_cur ";

            resultSet = session.getStatement().executeQuery(sql);
            if (resultSet.next()) {
                if (resultSet.getInt(1) == SDataConstantsSys.TRNS_CT_DPS_SAL) {
                    balance = new SFinBalance(resultSet.getDouble(3), resultSet.getDouble(4), resultSet.getInt(2));
                }
                else {
                    balance = new SFinBalance(-resultSet.getDouble(3), -resultSet.getDouble(4), resultSet.getInt(2));
                }
            }
        }
        catch (Exception e) {
            SLibUtils.showException(SFinUtils.class.getName(), e);
        }

        return balance;
    }

    public static boolean isSysMoveTypeForTransfer(final int[] keySysMoveType) {
        return SLibUtils.belongsTo(keySysMoveType, new int[][] { SModSysConsts.FINS_TP_SYS_MOV_MI_TRA, SModSysConsts.FINS_TP_SYS_MOV_MO_TRA });
    }

    public static boolean isSysMoveTypeForExchangeRateDiff(final int[] keySysMoveType) {
        return SLibUtils.belongsTo(keySysMoveType, new int[][] { SModSysConsts.FINS_TP_SYS_MOV_MI_EXR, SModSysConsts.FINS_TP_SYS_MOV_MO_EXR });
    }

    public static int getBizPartnerCategoryId(final int[] keySysMoveType) {
        int idCategory = SLibConsts.UNDEFINED;

        if (SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_PAY, SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_PAY, SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_ADV })) {
            idCategory = SModSysConsts.BPSS_CT_BP_CUS;
        }
        else if (SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_PAY, SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_PAY, SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_ADV })) {
            idCategory = SModSysConsts.BPSS_CT_BP_SUP;
        }
        else if (SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_DBR_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_DBR_PAY })) {
            idCategory = SModSysConsts.BPSS_CT_BP_DBR;
        }
        else if (SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_CDR_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CDR_PAY })) {
            idCategory = SModSysConsts.BPSS_CT_BP_CDR;
        }

        return idCategory;
    }

    public static int getDpsCategoryId(final int[] keySysMoveType) {
        int idCategory = SLibConsts.UNDEFINED;

        if (SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_PAY, SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_PAY, SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_ADV })) {
            idCategory = SModSysConsts.TRNS_CT_DPS_SAL;
        }
        else if (SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_PAY, SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_PAY, SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_ADV })) {
            idCategory = SModSysConsts.TRNS_CT_DPS_PUR;
        }

        return idCategory;
    }

    public static boolean isSysMoveTypeForBizPartnerPayment(final int[] keySysMoveType) {
        return SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_PAY
        });
    }

    public static boolean isSysMoveTypeForBizPartnerPaymentAdvance(final int[] keySysMoveType) {
        return SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_ADV,
            SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_ADV
        });
    }

    public static boolean isSysMoveTypeForBizPartnerBalance(final int[] keySysMoveType) {
        return SLibUtils.belongsTo(keySysMoveType, new int[][] {
            SModSysConsts.FINS_TP_SYS_MOV_MI_CUS_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CUS_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MI_SUP_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_SUP_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MI_DBR_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_DBR_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MI_CDR_PAY,
            SModSysConsts.FINS_TP_SYS_MOV_MO_CDR_PAY
        });
    }

    /**
     * Obtiene el saldo de un documento agrupado por impuesto
     *
     * @param connection
     * @param idDoc
     * @param idYear
     * @param recYear
     * @param dt
     * @param cat
     * @param tp
     *
     * @return ArrayList
     */
    public static ArrayList<SFinBalanceTax> getBalanceByTax(Connection connection, int idDoc, int idYear, int cat, int tp) {
        /* Query 1. Moves without document: */
        String sql = "" + "SELECT " + "    b.id_bp," + "    b.bp," + "    d.id_year," + "    d.id_doc," + "    d.dt," + "    dt.code AS f_doc_code," + "    CONCAT(d.num_ser," + "            IF(LENGTH(d.num_ser) = 0, '', '-')," + "            d.num) AS f_num," + "    d.tot_r," + "    d.exc_rate," + "    d.tot_cur_r," + "    c.id_cur," + "    c.cur_key," + "    cob.code AS f_cob_code," + "    SUM(re.debit - re.credit) AS f_bal," + "    SUM(IF(d.fid_cur IS NULL" + "            OR d.fid_cur <> re.fid_cur," + "        0," + "        re.debit_cur - re.credit_cur)) AS f_bal_cur," + "    btp.id_tp_bp," + "    btp.tp_bp," + "    re.fid_tax_bas_n," + "    re.fid_tax_n " + "FROM " + "    fin_rec AS r" + "        INNER JOIN" + "    fin_rec_ety AS re ON r.id_year = re.id_year" + "        AND r.id_per = re.id_per" + "        AND r.id_bkc = re.id_bkc" + "        AND r.id_tp_rec = re.id_tp_rec" + "        AND r.id_num = re.id_num" + "        AND NOT r.b_del" + "        AND NOT re.b_del" + "        AND re.fid_ct_sys_mov_xxx = " + cat + "        AND re.fid_tp_sys_mov_xxx = " + tp + "        INNER JOIN" + "    erp.bpsu_bp AS b ON re.fid_bp_nr = b.id_bp" + "        INNER JOIN" + "    erp.bpsu_bp_ct AS bct ON re.fid_bp_nr = bct.id_bp" + "        AND bct.id_ct_bp = re.fid_tp_sys_mov_xxx" + "        INNER JOIN" + "    erp.bpsu_tp_bp AS btp ON bct.fid_tp_bp = btp.id_tp_bp" + "        AND btp.id_ct_bp = re.fid_tp_sys_mov_xxx" + "        INNER JOIN" + "    trn_dps AS d ON re.fid_dps_year_n = d.id_year" + "        AND re.fid_dps_doc_n = d.id_doc" + "        AND d.b_del = 0" + "        AND d.fid_st_dps = " + SDataConstantsSys.TRNS_ST_DPS_EMITED + "        AND re.fid_dps_year_n = " + idYear + " " + "        AND re.fid_dps_doc_n = " + idDoc + " " + "        INNER JOIN" + "    erp.trnu_tp_dps AS dt ON d.fid_ct_dps = dt.id_ct_dps" + "        AND d.fid_cl_dps = dt.id_cl_dps" + "        AND d.fid_tp_dps = dt.id_tp_dps" + "        INNER JOIN" + "    erp.cfgu_cur AS c ON d.fid_cur = c.id_cur" + "        INNER JOIN" + "    erp.bpsu_bpb AS cob ON d.fid_cob = cob.id_bpb " + "GROUP BY btp.id_tp_bp , b.id_bp , b.bp , d.id_year , d.id_doc , " + "  d.dt , dt.code , d.num_ser , d.num , d.tot_r , d.exc_rate , " + "  d.tot_cur_r , c.id_cur , c.cur_key , cob.code , re.fid_tax_bas_n , re.fid_tax_n " + "HAVING f_bal <> 0 OR f_bal_cur <> 0 " + "ORDER BY tp_bp , id_tp_bp , bp , id_bp , f_num , dt , id_year , id_doc , id_cur;";
        ResultSet resultSet;
        try {
            resultSet = connection.createStatement().executeQuery(sql);
            ArrayList<SFinBalanceTax> taxBalances = new ArrayList<>();
            SFinBalanceTax tax;
            while (resultSet.next()) {
                tax = new SFinBalanceTax();
                tax.setTaxBasId(resultSet.getInt("fid_tax_bas_n"));
                tax.setTaxId(resultSet.getInt("fid_tax_n"));
                if (tp == SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[1]) {
                    tax.setBalance(resultSet.getDouble("f_bal"));
                    tax.setBalanceCurrency(resultSet.getDouble("f_bal_cur"));
                } else {
                    tax.setBalance(resultSet.getDouble("f_bal") * -1);
                    tax.setBalanceCurrency(resultSet.getDouble("f_bal_cur") * -1);
                }
                taxBalances.add(tax);
            }
            
            return taxBalances;
        }
        catch (SQLException ex) { 
            Logger.getLogger(SFinUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new ArrayList<>();
    }
}
