/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mfin.view;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.data.SDataSqlUtilities;
import erp.lib.table.STabFilterDatePeriod;
import erp.lib.table.STabFilterDeleted;
import erp.lib.table.STableColumn;
import erp.lib.table.STableConstants;
import erp.lib.table.STableField;
import erp.lib.table.STableSetting;
import javax.swing.JButton;

/**
 *
 * @author Sergio Flores
 */
public class SViewRecordHeader extends erp.lib.table.STableTab implements java.awt.event.ActionListener {

    private erp.lib.table.STabFilterDeleted moTabFilterDeleted;
    private erp.lib.table.STabFilterDatePeriod moTabFilterDatePeriod;
    private erp.mfin.view.SPanelFilterRecordType moPanelFilterRecordType;

    public SViewRecordHeader(erp.client.SClientInterface client, java.lang.String tabTitle) {
        super(client, tabTitle, SDataConstants.FINX_REC_HEADER);
        initComponents();
    }

    private void initComponents() {
        int i;

        moTabFilterDeleted = new STabFilterDeleted(this);
        moTabFilterDatePeriod = new STabFilterDatePeriod(miClient, this, SLibConstants.GUI_DATE_AS_YEAR_MONTH);
        moPanelFilterRecordType = new SPanelFilterRecordType(miClient, this);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(moPanelFilterRecordType);

        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(moTabFilterDeleted);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(moTabFilterDatePeriod);

        jbNew.setEnabled(true);
        jbEdit.setEnabled(true);
        //jbDelete.setEnabled(false);

        STableField[] aoKeyFields = new STableField[5];
        STableColumn[] aoTableColumns = new STableColumn[24];

        i = 0;
        aoKeyFields[i++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_year");
        aoKeyFields[i++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_per");
        aoKeyFields[i++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_bkc");
        aoKeyFields[i++] = new STableField(SLibConstants.DATA_TYPE_STRING, "r.id_tp_rec");
        aoKeyFields[i++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_num");
        for (i = 0; i < aoKeyFields.length; i++) {
            moTablePane.getPrimaryKeyFields().add(aoKeyFields[i]);
        }

        i = 0;
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "f_per", "Período póliza", STableConstants.WIDTH_YEAR_PERIOD);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "bkc.code", "Centro contable", STableConstants.WIDTH_CODE_COB);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "cob.code", "Sucursal empresa", STableConstants.WIDTH_CODE_COB);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "f_num", "Folio póliza", STableConstants.WIDTH_RECORD_NUM);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_DATE, "r.dt", "Fecha póliza", STableConstants.WIDTH_DATE);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "r.concept", "Concepto", 200);
        aoTableColumns[i] = new STableColumn(SLibConstants.DATA_TYPE_DOUBLE, "f_debit", "Cargos $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++].setSumApplying(true);
        aoTableColumns[i] = new STableColumn(SLibConstants.DATA_TYPE_DOUBLE, "f_credit", "Abonos $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++].setSumApplying(true);
        aoTableColumns[i] = new STableColumn(SLibConstants.DATA_TYPE_DOUBLE, "f_balance", "Saldo $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++].setSumApplying(true);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_sys", "Sistema", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "e.ent", "Cuenta efectivo", 100);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_audit", "Auditada", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "uaud.usr", "Usr. auditoría", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_audit", "Auditoría", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_authorn", "Autorizada", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "uaut.usr", "Usr. autorización", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_authorn", "Autorización", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_del", "Eliminado", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "un.usr", "Usr. creación", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_new", "Creación", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "ue.usr", "Usr. modificación", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_edit", "Modificación", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "ud.usr", "Usr. eliminación", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_del", "Eliminación", STableConstants.WIDTH_DATE_TIME);
        for (i = 0; i < aoTableColumns.length; i++) {
            moTablePane.addTableColumn(aoTableColumns[i]);
        }

        setIsSummaryApplying(true);

        mvSuscriptors.add(mnTabType);
        mvSuscriptors.add(SDataConstants.FIN_REC);
        mvSuscriptors.add(SDataConstants.CFGU_COB_ENT);
        mvSuscriptors.add(SDataConstants.FIN_BKC);
        mvSuscriptors.add(SDataConstants.TRN_DPS);
        mvSuscriptors.add(SDataConstants.TRN_DPS_IOG_CHG);
        mvSuscriptors.add(SDataConstants.TRN_DPS_IOG_WAR);
        mvSuscriptors.add(SDataConstants.TRN_DIOG);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_LINKS);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_PEND_LINK);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_FILL);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_SUPPLY_PEND);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_SUPPLIED);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_PAYED);
        mvSuscriptors.add(SDataConstants.TRNX_DPS_PAY_PEND);
        mvSuscriptors.add(SDataConstants.TRNX_CFD_PAY_REC);
        mvSuscriptors.add(SDataConstants.USRU_USR);

        populateTable();
    }

    @Override
    public void actionNew() {
        if (jbNew.isEnabled()) {
            if (miClient.getGuiModule(SDataConstants.MOD_FIN).showForm(mnTabType, null) == SLibConstants.DB_ACTION_SAVE_OK) {
                miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(mnTabType);

                if (miClient.getGuiModule(SDataConstants.MOD_FIN).showForm(mnTabType, miClient.getGuiModule(SDataConstants.MOD_FIN).getLastSavedPrimaryKey()) == SLibConstants.DB_ACTION_SAVE_OK) {
                    miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(mnTabType);
                }
            }
        }
    }

    @Override
    public void actionEdit() {
        if (jbEdit.isEnabled()) {
            if (moTablePane.getSelectedTableRow() != null && !moTablePane.getSelectedTableRow().getIsSummary()) {
                if (miClient.getGuiModule(SDataConstants.MOD_FIN).showForm(mnTabType, moTablePane.getSelectedTableRow().getPrimaryKey()) == SLibConstants.DB_ACTION_SAVE_OK) {
                    miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(mnTabType);
                }
            }
        }
    }

    @Override
    public void actionDelete() {
        if (jbDelete.isEnabled()) {

        }
    }

    @Override
    public void createSqlQuery() {
        String sqlWhere = "";
        STableSetting setting = null;

        for (int i = 0; i < mvTableSettings.size(); i++) {
            setting = (erp.lib.table.STableSetting) mvTableSettings.get(i);
            if (setting.getType() == STableConstants.SETTING_FILTER_DELETED && setting.getStatus() == STableConstants.STATUS_ON) {
                sqlWhere += (sqlWhere.length() == 0 ? "" : "AND ") + "r.b_del = FALSE ";
            }
            else if (setting.getType() == STableConstants.SETTING_FILTER_PERIOD) {
                sqlWhere += (sqlWhere.length() == 0 ? "" : "AND ") + SDataSqlUtilities.composePeriodFilter((int[]) setting.getSetting(), "r.dt");
            }
            else if (setting.getType() == STableConstants.SETTING_FILTER_FIN_REC_TYPE) {
                if (((String) setting.getSetting()).length() > 0) {
                    sqlWhere += (sqlWhere.length() == 0 ? "" : "AND ") + "r.id_tp_rec = '" + (String) setting.getSetting() + "' ";
                }
            }
        }

        msSql = "SELECT r.id_year, r.id_per, r.id_bkc, r.id_tp_rec, r.id_num, r.dt, r.concept, r.b_audit, r.b_authorn, r.b_sys, r.b_del, " +
                "r.ts_audit, r.ts_authorn, r.ts_new, r.ts_edit, r.ts_del, " +
                "bkc.code, cob.code, e.ent, uaud.usr, uaut.usr, un.usr, ue.usr, ud.usr, " +
                "CONCAT(r.id_year, '-', erp.lib_fix_int(r.id_per, 2)) as f_per, " +
                "CONCAT(r.id_tp_rec, '-', erp.lib_fix_int(r.id_num, " + SDataConstantsSys.NUM_LEN_FIN_REC + ")) as f_num, " +
                "SUM(re.debit) AS f_debit, SUM(re.credit) AS f_credit, SUM(re.debit) - SUM(re.credit) AS f_balance " +
                "FROM fin_rec AS r " +
                "INNER JOIN fin_bkc AS bkc ON " +
                "r.id_bkc = bkc.id_bkc " +
                "INNER JOIN erp.bpsu_bpb AS cob ON " +
                "r.fid_cob = cob.id_bpb " +
                "INNER JOIN erp.usru_usr AS uaud ON " +
                "r.fid_usr_audit = uaud.id_usr " +
                "INNER JOIN erp.usru_usr AS uaut ON " +
                "r.fid_usr_authorn = uaut.id_usr " +
                "INNER JOIN erp.usru_usr AS un ON " +
                "r.fid_usr_new = un.id_usr " +
                "INNER JOIN erp.usru_usr AS ue ON " +
                "r.fid_usr_edit = ue.id_usr " +
                "INNER JOIN erp.usru_usr AS ud ON " +
                "r.fid_usr_del = ud.id_usr " +
                "LEFT OUTER JOIN fin_acc_cash AS ac ON " +
                "r.fid_cob_n = ac.id_cob AND r.fid_acc_cash_n = ac.id_acc_cash " +
                "LEFT OUTER JOIN erp.cfgs_cob_ent AS e ON " +
                "ac.id_cob = e.id_cob AND ac.id_acc_cash = e.id_ent " +
                "LEFT OUTER JOIN fin_rec_ety AS re ON " +
                "r.id_year = re.id_year AND r.id_per = re.id_per AND r.id_bkc = re.id_bkc AND r.id_tp_rec = re.id_tp_rec AND r.id_num = re.id_num AND re.b_del = FALSE " +
                (sqlWhere.length() == 0 ? "" : "WHERE " + sqlWhere) +
                "GROUP BY r.id_year, r.id_per, r.id_bkc, r.id_tp_rec, r.id_num, r.dt, r.concept, r.b_audit, r.b_authorn, r.b_sys, r.b_del, " +
                "r.ts_audit, r.ts_authorn, r.ts_new, r.ts_edit, r.ts_del, " +
                "bkc.code, cob.code, e.ent, uaud.usr, uaut.usr, un.usr, ue.usr, ud.usr " +
                "ORDER BY r.id_year, r.id_per, bkc.code, r.id_bkc, r.id_tp_rec, r.id_num, r.dt ";
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        super.actionPerformed(e);

        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();
        }
    }
}
