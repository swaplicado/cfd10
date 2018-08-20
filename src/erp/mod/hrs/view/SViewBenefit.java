/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.view;

import erp.gui.grid.SGridFilterPanelEmployee;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SHrsConsts;
import erp.mod.hrs.form.SDialogBenefitCardex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sa.lib.SLibConsts;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;
import sa.lib.db.SDbConsts;
import sa.lib.grid.SGridColumnView;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridFilterDate;
import sa.lib.grid.SGridFilterValue;
import sa.lib.grid.SGridPaneSettings;
import sa.lib.grid.SGridPaneView;
import sa.lib.grid.SGridRowView;
import sa.lib.grid.SGridUtils;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiDate;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SViewBenefit extends SGridPaneView implements ActionListener {

    private Date mtDateCutOff;
    private SGridFilterDate moFilterDate;
    private SGridFilterPanelEmployee moFilterEmployee;
    private JButton jbCardex;
    private SDialogBenefitCardex moDialogBenefitCardex;
    
    public SViewBenefit(SGuiClient client, int gridSubtype, String title) {
        super(client, SGridConsts.GRID_PANE_VIEW, SModConsts.HRSX_BEN_MOV, gridSubtype, title);
        initComponentsCustom();
    }

    /*
     * Private methods
     */

    private void initComponentsCustom() {
        setRowButtonsEnabled(false);
        
        mtDateCutOff = null;
        
        moFilterDate = new SGridFilterDate(miClient, this);
        if (mnGridSubtype == SModSysConsts.HRSS_TP_BEN_ANN_BON) {
            moFilterDate.initFilter(new SGuiDate(SGuiConsts.GUI_DATE_YEAR, SLibTimeUtils.getEndOfYear(miClient.getSession().getSystemDate()).getTime()));
        }
        else {
            moFilterDate.initFilter(new SGuiDate(SGuiConsts.GUI_DATE_YEAR, miClient.getSession().getSystemDate().getTime()));
        }
        
        moFilterEmployee = new SGridFilterPanelEmployee(miClient, this, SModConsts.HRSS_TP_PAY, SModConsts.HRSU_DEP);
        moFilterEmployee.initFilter(null);
        
        jbCardex = SGridUtils.createButton(new ImageIcon(getClass().getResource("/erp/img/icon_std_kardex.gif")), "Ver movimientos", this);
        
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(moFilterDate);
        getPanelCommandsCustom(SGuiConsts.PANEL_LEFT).add(moFilterEmployee);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbCardex);
        
        moDialogBenefitCardex = new SDialogBenefitCardex(miClient, mnGridSubtype, "Control de la prest");
    }

    private void actionShowCardex() {
        if (jbCardex.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else {
                    int[] key = (int[]) gridRow.getRowPrimaryKey();
                    
                    moDialogBenefitCardex.setFormParams(key[0], key[1], key[2], key[3], mtDateCutOff);
                    moDialogBenefitCardex.setVisible(true);
                }
            }
        }
    }

    /*
     * Public methods
     */

    /*
     * Overriden methods
     */

    @Override
    public void actionMouseClicked() {
        actionShowCardex();
    }
    
    @Override
    public void prepareSqlQuery() {
        String sql = "";
        String pDateCutOff = "";
        Object filter = null;

        moPaneSettings = new SGridPaneSettings(4);

        filter = (SGuiDate) moFiltersMap.get(SGridConsts.FILTER_DATE).getValue();
        if (filter != null) {
            mtDateCutOff = (SGuiDate) filter;
            pDateCutOff = "'" + SLibUtils.DbmsDateFormatDate.format(mtDateCutOff) + "'";
        }

        filter = (Boolean) moFiltersMap.get(SGridConsts.FILTER_DELETED).getValue();
        if ((Boolean) filter) {
            sql += (sql.isEmpty() ? "" : "AND ") + "NOT e.b_del ";
        }

        filter = ((SGridFilterValue) moFiltersMap.get(SModConsts.HRSS_TP_PAY)).getValue();
        if (filter != null && ((int[]) filter).length == 1) {
            sql += (sql.isEmpty() ? "" : "AND ") + "e.fk_tp_pay = " + ((int[]) filter)[0] + " ";
        }

        filter = ((SGridFilterValue) moFiltersMap.get(SModConsts.HRSU_DEP)).getValue();
        if (filter != null && ((int[]) filter).length == 1) {
            sql += (sql.isEmpty() ? "" : "AND ") + "e.fk_dep = " + ((int[]) filter)[0] + " ";
        }

        filter = ((SGridFilterValue) moFiltersMap.get(SGridFilterPanelEmployee.EMP_STATUS)).getValue();
        if (filter != null && ((int) filter) != SLibConsts.UNDEFINED) {
            if ((int)filter == SGridFilterPanelEmployee.EMP_STATUS_ACT) {
                sql += (sql.isEmpty() ? "" : "AND ") + "e.b_act ";
            }
            else if ((int)filter == SGridFilterPanelEmployee.EMP_STATUS_INA) {
                sql += (sql.isEmpty() ? "" : "AND ") + "NOT e.b_act ";
            }
            else if ((int)filter == SGridFilterPanelEmployee.EMP_STATUS_ALL) {
                // all
            }
        }
        
        int pBenefitType = mnGridSubtype;
        String pDateBoyCurr = "'" + SLibUtils.DbmsDateFormatDate.format(SLibTimeUtils.getBeginOfYear(mtDateCutOff)) + "'";
        String pDateBoyPrev = "'" + SLibUtils.DbmsDateFormatDate.format(SLibTimeUtils.getBeginOfYear(SLibTimeUtils.addDate(mtDateCutOff, -1, 0, 0))) + "'";
        
        /*
        NOTE:
        The following query shows ONLY active employees by cut off date.
        Shows also requested benefit type estimations and payments of days and amounts, 
        from current year and previous one, according as well to cut off date.
        */
        
        /*
        NOTE (due to former functionality):
        Meaning of row-view's primary key (required so for cardex dialog):
        ID_1 = employee's ID
        ID_2 = employee's anniversary (starting from 0, 1, 2 and so over)
        ID_3 = days elapsed in employee's current anniversary
        ID_4 = benefit-table's ID
        */
        
        msSql = "SELECT "
                // # employee's general info:
                + "bp.id_bp AS _emp_id, bp.bp AS _emp_name, e.num AS _emp_num, e.b_act AS _emp_act, "
                + "e.fk_tp_pay AS _pay_tp_id, tp.name AS _pay_tp_name, "
                + "e.dt_ben AS _emp_dt_ben, "
                + " "
                // # cut off date:
                + "" + pDateCutOff + " AS _p_dt_cutoff, "
                + " "
                // # employee's seniority:
                + "@sen_raw := ROUND(DATEDIFF(" + pDateCutOff + ", e.dt_ben) / " + SHrsConsts.YEAR_DAYS + ", 2) AS _sen_raw, "
                + "@sen_as_years := TIMESTAMPDIFF(YEAR, e.dt_ben, " + pDateCutOff + ") AS _sen_as_years, "
                + "@sen_as_months := TIMESTAMPDIFF(MONTH, e.dt_ben, " + pDateCutOff + ") AS _sen_as_months, "
                + " "
                // # employee's salary per day:
                + "@curr_sal_day := ROUND(IF(e.fk_tp_pay = " + SModSysConsts.HRSS_TP_PAY_WEE + ", e.sal, e.wage * " + SHrsConsts.YEAR_MONTHS + " / " + SHrsConsts.YEAR_DAYS + "), 2) AS _curr_sal_day, "
                /* subquery preserved for future usage, it retrieves employee's former salary per day (for previous year): "
                + "@prev_sal_day := IF(@sen_as_years = 0, NULL, ( "
                + "  SELECT ROUND(IF(elw.fk_tp_pay = " + SModSysConsts.HRSS_TP_PAY_WEE + ", elw.sal, elw.wage * " + SHrsConsts.YEAR_MONTHS + " / " + SHrsConsts.YEAR_DAYS + "), 2) "
                + "  FROM hrs_emp_log_wage AS elw "
                + "  WHERE elw.id_emp = bp.id_bp AND elw.dt <= ADDDATE(" + pDateCutOff + ", INTERVAL -1 YEAR) "
                + "  ORDER BY elw.dt DESC, elw.id_log LIMIT 1)) AS _prev_sal_day, "
                */
                + " "
                // # employee's anniversary and benefit's year:
                + "@curr_ben_anniv := @sen_as_years + 1 AS _curr_ben_anniv, "
                + "@curr_ben_year := YEAR(ADDDATE(e.dt_ben, INTERVAL @sen_as_years YEAR)) AS _curr_ben_year, "
                + "@prev_ben_anniv := IF(@sen_as_years = 0, NULL, @sen_as_years) AS _prev_ben_anniv, "
                + "@prev_ben_year := IF(@sen_as_years = 0, NULL, @curr_ben_year - 1) AS _prev_ben_year, "
                + " "
                // # employee's benefit's base date, elapsed days and proportional factor:
                + "@curr_dt_base := IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_ANN_BON + ", IF(e.dt_ben < " + pDateBoyCurr + ", " + pDateBoyCurr + ", e.dt_ben), ADDDATE(e.dt_ben, INTERVAL @sen_as_years YEAR)) AS _curr_dt_base, "
                + "@curr_days_elapsed := DATEDIFF(" + pDateCutOff + ", @curr_dt_base) AS _curr_days_elapsed, "
                + "@curr_prop := @curr_days_elapsed / " + SHrsConsts.YEAR_DAYS + " AS _curr_prop, "
                + "@prev_dt_base := IF(@sen_as_years = 0, NULL, IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_ANN_BON + ", IF(e.dt_ben < " + pDateBoyPrev + ", " + pDateBoyPrev + ", e.dt_ben), ADDDATE(e.dt_ben, INTERVAL @sen_as_years - 1 YEAR))) AS _prev_dt_base, "
                + "@prev_days_elapsed := IF(@sen_as_years = 0, NULL, DATEDIFF(" + pDateCutOff + ", @prev_dt_base) - @curr_days_elapsed) AS _prev_days_elapsed, "
                + "@prev_prop := IF(@sen_as_years = 0, NULL, @prev_days_elapsed / " + SHrsConsts.YEAR_DAYS + ") AS _prev_prop, "
                + " "
                // # employee's benefit table and bonus benefit table (if applicable):
                + "@id_ben_day_pay := ( "
                + "  SELECT b.id_ben FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " AS b "
                + "  WHERE NOT b.b_del AND b.fk_tp_ben = IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", " + SModSysConsts.HRSS_TP_BEN_VAC + ", " + pBenefitType + ") AND b.dt_sta <= " + pDateCutOff + " AND b.fk_tp_pay_n = e.fk_tp_pay "
                + "  ORDER BY b.dt_sta DESC, b.id_ben LIMIT 1) AS _id_ben_day_pay, "
                + "@id_ben_day_all := ( "
                + "  SELECT b.id_ben FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " AS b "
                + "  WHERE NOT b.b_del AND b.fk_tp_ben = IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", " + SModSysConsts.HRSS_TP_BEN_VAC + ", " + pBenefitType + ") AND b.dt_sta <= " + pDateCutOff + " AND b.fk_tp_pay_n IS NULL "
                + "  ORDER BY b.dt_sta DESC, b.id_ben LIMIT 1) AS _id_ben_day_all, "
                + "@id_ben_day := COALESCE(@id_ben_day_pay, @id_ben_day_all) AS _id_ben_day, "
                + "@ben_day_name := (SELECT b.name FROM hrs_ben AS b WHERE b.id_ben = @id_ben_day) AS _ben_day_name, "
                + "@id_ben_bon_pay := IF(" + pBenefitType + " <> " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", 0, ( "
                + "  SELECT b.id_ben FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " AS b "
                + "  WHERE NOT b.b_del AND b.fk_tp_ben = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + " AND b.dt_sta <= " + pDateCutOff + " AND b.fk_tp_pay_n = e.fk_tp_pay "
                + "  ORDER BY b.dt_sta DESC, b.id_ben LIMIT 1)) AS _id_ben_bon_pay, "
                + "@id_ben_bon_all := IF(" + pBenefitType + " <> " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", 0, ( "
                + "  SELECT b.id_ben FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN) + " AS b "
                + "  WHERE NOT b.b_del AND b.fk_tp_ben = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + " AND b.dt_sta <= " + pDateCutOff + " AND b.fk_tp_pay_n IS NULL "
                + "  ORDER BY b.dt_sta DESC, b.id_ben LIMIT 1)) AS _id_ben_bon_all, "
                + "@id_ben_bon := COALESCE(@id_ben_bon_pay, @id_ben_bon_all) AS _id_ben_bon, "
                + "@ben_bon_name := (SELECT b.name FROM hrs_ben AS b WHERE b.id_ben = @id_ben_bon) AS _ben_bon_name, "
                + " "
                // # estimated current-year benefit:
                + " "
                + "@curr_ben_days := IF(@sen_as_years = 0, "
                + "COALESCE((SELECT br.ben_day FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_day AND br.id_row = 1), 0), "
                + "COALESCE((SELECT br.ben_day FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_day AND mon <= @sen_as_months ORDER BY br.mon DESC, br.id_row LIMIT 1), 0)) AS _curr_ben_days, "
                + "@curr_ben_days_prop := @curr_ben_days * @curr_prop AS _curr_ben_days_prop, "
                + "@curr_ben_amt_prop := ROUND(@curr_sal_day * @curr_ben_days_prop, 2) AS _curr_ben_amt_prop, "
                + " "
                + "@curr_ben_bon_perc := IF(@sen_as_years = 0, "
                + "COALESCE((SELECT br.ben_bon_per FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_bon AND br.id_row = 1), 0), "
                + "COALESCE((SELECT br.ben_bon_per FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_bon AND mon <= @sen_as_months ORDER BY br.mon DESC, br.id_row LIMIT 1), 0)) AS _curr_ben_bon_perc, "
                + "@curr_ben_bon_amt_prop := ROUND(@curr_ben_amt_prop * @curr_ben_bon_perc, 2) AS _curr_ben_bon_amt_prop, "
                + " "
                // # estimated previous-year benefit:
                + " "
                + "@prev_ben_days := IF(@sen_as_years - 1 = 0, "
                + "COALESCE((SELECT br.ben_day FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_day AND br.id_row = 1), 0), "
                + "COALESCE((SELECT br.ben_day FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_day AND mon <= @sen_as_months - " + SHrsConsts.YEAR_MONTHS + " ORDER BY br.mon DESC, br.id_row LIMIT 1), 0)) AS _prev_ben_days, "
                + "@prev_ben_days_prop := @prev_ben_days * @prev_prop AS _prev_ben_days_prop, "
                + "@prev_ben_amt_prop := ROUND(@curr_sal_day * @prev_ben_days_prop, 2) AS _prev_ben_amt_prop, "
                + " "
                + "@prev_ben_bon_perc := IF(@sen_as_years = 0, "
                + "COALESCE((SELECT br.ben_bon_per FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_bon AND br.id_row = 1), 0), "
                + "COALESCE((SELECT br.ben_bon_per FROM " + SModConsts.TablesMap.get(SModConsts.HRS_BEN_ROW) + " AS br WHERE br.id_ben = @id_ben_bon AND mon <= @sen_as_months ORDER BY br.mon DESC, br.id_row LIMIT 1), 0)) AS _prev_ben_bon_perc, "
                + "@prev_ben_bon_amt_prop := ROUND(@prev_ben_amt_prop * @prev_ben_bon_perc, 2) AS _prev_ben_bon_amt_prop, "
                + " "
                // # payed current-year benefit:
                + "@curr_pay_days := COALESCE(tcur.ben_unt, 0.0) AS _curr_pay_days, "
                + "@curr_pay_amt := COALESCE(tcur.ben_amt, 0.0) AS _curr_pay_amt, "
                + " "
                // # payed previous-year benefit:
                + "@prev_pay_days := COALESCE(tprev.ben_unt, 0.0) AS _prev_pay_days, "
                + "@prev_pay_amt := COALESCE(tprev.ben_amt, 0.0) AS _prev_pay_amt, "
                + " "
                // # diff estimated vs. payed current-year benefit:
                + "COALESCE(@curr_ben_days_prop, 0.0) - @curr_pay_days AS _diff_curr_pay_days, "
                + "COALESCE(IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", @curr_ben_bon_amt_prop, @curr_ben_amt_prop), 0.0) - @curr_pay_amt AS _diff_curr_pay_amt, "
                + " "
                // # diff estimated vs. payed previous-year benefit:
                + "COALESCE(@prev_ben_days_prop, 0.0) - @prev_pay_days AS _diff_prev_pay_days, "
                + "COALESCE(IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", @prev_ben_bon_amt_prop, @prev_ben_amt_prop), 0.0) - @prev_pay_amt AS _diff_prev_pay_amt, "
                /********************************************************************************/
                + "bp.id_bp AS " + SDbConsts.FIELD_ID + "1, "
                + "@sen_as_years AS " + SDbConsts.FIELD_ID + "2, "
                + "@curr_days_elapsed AS " + SDbConsts.FIELD_ID + "3, "
                + "IF(" + pBenefitType + " = " + SModSysConsts.HRSS_TP_BEN_VAC_BON + ", @id_ben_bon, @id_ben_day) AS " + SDbConsts.FIELD_ID + "4, "
                + "bp.bp AS " + SDbConsts.FIELD_NAME + ", "
                + "e.num AS " + SDbConsts.FIELD_CODE + " "
                /********************************************************************************/
                // # main query's source tables:
                + "FROM " + SModConsts.TablesMap.get(SModConsts.BPSU_BP) + " AS bp "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS e ON e.id_emp = bp.id_bp "
                + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_PAY) + " AS tp ON e.fk_tp_pay = tp.id_tp_pay "
                + " "
                // # retrieve current benefit payed:
                + "LEFT OUTER JOIN ( "
                + "  SELECT t.id_emp, t.ben_year, t.ben_ann, SUM(t.ben_unt) AS ben_unt, SUM(t.ben_amt) AS ben_amt "
                + "  FROM ( "
                //     # benefit payed to employee as earning:
                + "    SELECT pre.id_emp, pre.ben_year, pre.ben_ann, SUM(pre.unt) AS ben_unt, SUM(pre.amt_r) AS ben_amt "
                + "    FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON pr.id_pay = p.id_pay "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_EAR) + " AS pre ON pre.id_pay = pr.id_pay AND pre.id_emp = pr.id_emp "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS e ON pr.id_emp = e.id_emp "
                + "    WHERE pre.fk_tp_ben = " + pBenefitType + " AND e.b_act AND NOT p.b_del AND NOT pr.b_del AND NOT pre.b_del AND pre.ben_year = YEAR(" + pDateCutOff + ") "
                + "    GROUP BY pre.id_emp, pre.ben_year, pre.ben_ann "
                + "    UNION "
                //     # benefit refund to employer as deduction:
                + "    SELECT prd.id_emp, prd.ben_year, prd.ben_ann, -SUM(prd.unt) AS ben_unt, -SUM(prd.amt_r) AS ben_amt "
                + "    FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON pr.id_pay = p.id_pay "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_DED) + " AS prd ON prd.id_pay = pr.id_pay AND prd.id_emp = pr.id_emp "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS e ON pr.id_emp = e.id_emp "
                + "    WHERE prd.fk_tp_ben = " + pBenefitType + " AND e.b_act AND NOT p.b_del AND NOT pr.b_del AND NOT prd.b_del AND prd.ben_year = YEAR(" + pDateCutOff + ") "
                + "    GROUP BY prd.id_emp, prd.ben_year, prd.ben_ann "
                + "    ORDER BY id_emp, ben_year, ben_ann) AS t "
                + "  GROUP BY id_emp, ben_year, ben_ann "
                + "  ORDER BY id_emp, ben_year, ben_ann) AS tcur ON tcur.id_emp = bp.id_bp "
                + " "
                // # retrieve previous benefit payed:
                + "LEFT OUTER JOIN ( "
                + "  SELECT t.id_emp, t.ben_year, t.ben_ann, SUM(t.ben_unt) AS ben_unt, SUM(t.ben_amt) AS ben_amt "
                + "  FROM ( "
                //     # benefit payed to employee as earning:
                + "    SELECT pre.id_emp, pre.ben_year, pre.ben_ann, SUM(pre.unt) AS ben_unt, SUM(pre.amt_r) AS ben_amt "
                + "    FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON pr.id_pay = p.id_pay "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_EAR) + " AS pre ON pre.id_pay = pr.id_pay AND pre.id_emp = pr.id_emp "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS e ON pr.id_emp = e.id_emp "
                + "    WHERE pre.fk_tp_ben = " + pBenefitType + " AND e.b_act AND NOT p.b_del AND NOT pr.b_del AND NOT pre.b_del AND pre.ben_year = YEAR(" + pDateCutOff + ") - 1 "
                + "    GROUP BY pre.id_emp, pre.ben_year, pre.ben_ann "
                + "    UNION "
                //     # benefit refund to employer as deduction:
                + "    SELECT prd.id_emp, prd.ben_year, prd.ben_ann, -SUM(prd.unt) AS ben_unt, -SUM(prd.amt_r) AS ben_amt "
                + "    FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON pr.id_pay = p.id_pay "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_DED) + " AS prd ON prd.id_pay = pr.id_pay AND prd.id_emp = pr.id_emp "
                + "    INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS e ON pr.id_emp = e.id_emp "
                + "    WHERE prd.fk_tp_ben = " + pBenefitType + " AND e.b_act AND NOT p.b_del AND NOT pr.b_del AND NOT prd.b_del AND prd.ben_year = YEAR(" + pDateCutOff + ") - 1 "
                + "    GROUP BY prd.id_emp, prd.ben_year, prd.ben_ann "
                + "    ORDER BY id_emp, ben_year, ben_ann) AS t "
                + "  GROUP BY id_emp, ben_year, ben_ann "
                + "  ORDER BY id_emp, ben_year, ben_ann) AS tprev ON tprev.id_emp = bp.id_bp "
                + " "
                + "WHERE e.b_act AND e.dt_ben <= " + pDateCutOff + " " + (sql.isEmpty() ? "" : "AND " + sql)
                + " "
                + "ORDER BY bp.bp, bp.id_bp ";
    }

    @Override
    public ArrayList<SGridColumnView> createGridColumns() {
        SGridColumnView column = null;
        ArrayList<SGridColumnView> gridColumnsViews = new ArrayList<>();

        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_CAT_M, SDbConsts.FIELD_NAME, "Empleado"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_CODE_BPR, SDbConsts.FIELD_CODE, "Clave"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_BOOL_M, "_emp_act", "Activo"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "_pay_tp_name", "Período pago"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE, "_emp_dt_ben", "Inicio beneficios"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE, "_p_dt_cutoff", "Corte"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_sen_raw", "Antigüedad", 50));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_4B, "_sen_as_years", "Años antigüedad", 50));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_4B, "_sen_as_months", "Meses antigüedad", 50));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_curr_sal_day", "Salario diario $"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "_ben_day_name", "Tabla prests"));
        
        if (mnGridSubtype == SModSysConsts.HRSS_TP_BEN_VAC_BON) {
            gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "_ben_bon_name", "Tabla prima"));
        }
        
        // benefit of current year:
        
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_CAL_YEAR, "_curr_ben_year", "Año actual prests"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_1B, "_curr_ben_anniv", "Aniv actual prests", 35));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE, "_curr_dt_base", "Base actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_4B, "_curr_days_elapsed", "Días transc actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_curr_prop", "Parte prop actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_4B, "_curr_ben_days", "Días prest actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_curr_ben_days_prop", "Días prest prop actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_curr_ben_amt_prop", "Prest prop actual $"));
        
        if (mnGridSubtype == SModSysConsts.HRSS_TP_BEN_VAC_BON) {
            gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_PER_DISC, "_curr_ben_bon_perc", "Prima actual %"));
            gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_curr_ben_bon_amt_prop", "Prima actual $"));
        }
        
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_curr_pay_days", "Días prest pag actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_curr_pay_amt", "Prest pag actual $"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_diff_curr_pay_days", "Dif días prest pag actual"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_diff_curr_pay_amt", "Dif prest pag actual $"));
        
        // benefit of previous year:
        
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_CAL_YEAR, "_prev_ben_year", "Año prev prests"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_1B, "_prev_ben_anniv", "Aniv prev prests", 35));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE, "_prev_dt_base", "Base prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_4B, "_prev_days_elapsed", "Días transc prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_prev_prop", "Parte prop prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_4B, "_prev_ben_days", "Días prest prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_prev_ben_days_prop", "Días prest prop prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_prev_ben_amt_prop", "Prest prop prev $"));
        
        if (mnGridSubtype == SModSysConsts.HRSS_TP_BEN_VAC_BON) {
            gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_PER_DISC, "_prev_ben_bon_perc", "Prima prev %"));
            gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_prev_ben_bon_amt_prop", "Prima prev $"));
        }
        
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_prev_pay_days", "Días prest pag prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_prev_pay_amt", "Prest pag prev $"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_4D, "_diff_prev_pay_days", "Dif días prest pag prev"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "_diff_prev_pay_amt", "Dif prest pag prev $"));
        
        return gridColumnsViews;
    }

    @Override
    public void defineSuscriptions() {
        moSuscriptionsSet.add(mnGridType);
        moSuscriptionsSet.add(SModConsts.HRS_EAR);
        moSuscriptionsSet.add(SModConsts.HRS_DED);
        moSuscriptionsSet.add(SModConsts.USRU_USR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbCardex) {
                actionShowCardex();
            }
        }
    }
}
