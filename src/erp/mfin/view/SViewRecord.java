/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mfin.view;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.data.SDataSqlUtilities;
import erp.lib.form.SFormUtilities;
import erp.lib.table.STabFilterDatePeriod;
import erp.lib.table.STabFilterDeleted;
import erp.lib.table.STableColumn;
import erp.lib.table.STableConstants;
import erp.lib.table.STableField;
import erp.lib.table.STableSetting;
import erp.mfin.data.SDataRecord;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import sa.gui.util.SUtilConsts;

/**
 *
 * @author Sergio Flores, Edwin Carmona
 */
public class SViewRecord extends erp.lib.table.STableTab implements java.awt.event.ActionListener {

    private javax.swing.JButton mjbCopy;
    private javax.swing.JButton mjbPrintRecord;
    private javax.swing.JButton mjbPrintRecordCy;
    private javax.swing.JButton mjbAudit;
    private javax.swing.JButton mjbAuditRevoke;
    private erp.lib.table.STabFilterDeleted moTabFilterDeleted;
    private erp.lib.table.STabFilterDatePeriod moTabFilterDatePeriod;
    private erp.mfin.view.SPanelFilterRecordType moPanelFilterRecordType;
    private int mnViewType;

    /**
     * @param cliente GUI client.
     * @param tabTitle View's tab title.
     * @param viewType View's tipe. Constants allowed: SLibConsts.UNDEFINED = standard view, all accounting records; SUtilConsts.AUD = audited records; SUtilConsts.AUD_PEND = audit pending records.
     */
    public SViewRecord(erp.client.SClientInterface client, java.lang.String tabTitle, int viewType) {
        super(client, tabTitle, SDataConstants.FIN_REC);
        mnViewType = viewType;
        initComponents();
    }

    private void initComponents() {
        int col = 0;
        int levelRightEdit = SDataConstantsSys.UNDEFINED;

        mjbCopy = new JButton(miClient.getImageIcon(SLibConstants.ICON_COPY));
        mjbCopy.setPreferredSize(new Dimension(23, 23));
        mjbCopy.setToolTipText("Copiar");
        mjbCopy.addActionListener(this);
        
        mjbPrintRecord = new JButton(miClient.getImageIcon(SLibConstants.ICON_PRINT));
        mjbPrintRecordCy = new JButton(miClient.getImageIcon(SLibConstants.ICON_PRINT));
        mjbPrintRecord.setPreferredSize(new Dimension(23, 23));
        mjbPrintRecordCy.setPreferredSize(new Dimension(23, 23));
        mjbPrintRecord.setToolTipText("Imprimir póliza, moneda local");
        mjbPrintRecordCy.setToolTipText("Imprimir póliza, moneda póliza");
        mjbPrintRecord.addActionListener(this);
        mjbPrintRecordCy.addActionListener(this);
        
        mjbAudit = new JButton(miClient.getImageIcon(SLibConstants.ICON_APPROVE));
        mjbAuditRevoke = new JButton(miClient.getImageIcon(SLibConstants.ICON_APPROVE_NO));
        mjbAudit.setPreferredSize(new Dimension(23, 23));
        mjbAuditRevoke.setPreferredSize(new Dimension(23, 23));
        mjbAudit.setToolTipText("Marcar como auditado");
        mjbAuditRevoke.setToolTipText("Desmarcar como auditado");
        mjbAudit.addActionListener(this);
        mjbAuditRevoke.addActionListener(this);

        moTabFilterDeleted = new STabFilterDeleted(this);
        moTabFilterDatePeriod = new STabFilterDatePeriod(miClient, this, SLibConstants.GUI_DATE_AS_YEAR_MONTH);
        moPanelFilterRecordType = new SPanelFilterRecordType(miClient, this);

        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(mjbCopy);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(moTabFilterDeleted);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(moTabFilterDatePeriod);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(moPanelFilterRecordType);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(mjbPrintRecord);
        addTaskBarUpperComponent(mjbPrintRecordCy);
        addTaskBarUpperSeparator();
        addTaskBarUpperComponent(mjbAudit);
        addTaskBarUpperComponent(mjbAuditRevoke);

        STableField[] aoKeyFields = new STableField[5];
        STableColumn[] aoTableColumns = new STableColumn[26];

        col = 0;
        aoKeyFields[col++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_year");
        aoKeyFields[col++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_per");
        aoKeyFields[col++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_bkc");
        aoKeyFields[col++] = new STableField(SLibConstants.DATA_TYPE_STRING, "r.id_tp_rec");
        aoKeyFields[col++] = new STableField(SLibConstants.DATA_TYPE_INTEGER, "r.id_num");
        for (int i = 0; i < aoKeyFields.length; i++) {
            moTablePane.getPrimaryKeyFields().add(aoKeyFields[i]);
        }

        col = 0;
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "f_per", "Período póliza", STableConstants.WIDTH_YEAR_PERIOD);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "bkc.code", "Centro contable", STableConstants.WIDTH_CODE_COB);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "cob.code", "Sucursal empresa", STableConstants.WIDTH_CODE_COB);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "f_num", "Folio póliza", STableConstants.WIDTH_RECORD_NUM);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_DATE, "r.dt", "Fecha póliza", STableConstants.WIDTH_DATE);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "r.concept", "Concepto", 200);
        aoTableColumns[col] = new STableColumn(SLibConstants.DATA_TYPE_DOUBLE, "f_debit", "Cargos $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[col++].setSumApplying(true);
        aoTableColumns[col] = new STableColumn(SLibConstants.DATA_TYPE_DOUBLE, "f_credit", "Abonos $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[col++].setSumApplying(true);
        aoTableColumns[col] = new STableColumn(SLibConstants.DATA_TYPE_DOUBLE, "f_balance", "Saldo $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[col++].setSumApplying(true);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_sys", "Sistema", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "e.ent", "Cuenta efectivo", 100);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_adj_year", "Cierre", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_adj_audit", "Auditoría", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_audit", "Auditada", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "uaud.usr", "Usr. auditoría", STableConstants.WIDTH_USER);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_audit", "Auditoría", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_authorn", "Autorizada", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "uaut.usr", "Usr. autorización", STableConstants.WIDTH_USER);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_authorn", "Autorización", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_BOOLEAN, "r.b_del", "Eliminado", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "un.usr", "Usr. creación", STableConstants.WIDTH_USER);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_new", "Creación", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "ue.usr", "Usr. modificación", STableConstants.WIDTH_USER);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_edit", "Modificación", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_STRING, "ud.usr", "Usr. eliminación", STableConstants.WIDTH_USER);
        aoTableColumns[col++] = new STableColumn(SLibConstants.DATA_TYPE_DATE_TIME, "r.ts_del", "Eliminación", STableConstants.WIDTH_DATE_TIME);
        for (int i = 0; i < aoTableColumns.length; i++) {
            moTablePane.addTableColumn(aoTableColumns[i]);
        }

        SFormUtilities.createActionMap(this, this, "publicActionPrint", "print", KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        levelRightEdit = miClient.getSessionXXX().getUser().hasRight(miClient, SDataConstantsSys.PRV_FIN_REG).Level;

        jbNew.setEnabled(levelRightEdit >= SUtilConsts.LEV_AUTHOR);
        jbEdit.setEnabled(levelRightEdit >= SUtilConsts.LEV_AUTHOR);
        mjbCopy.setEnabled(levelRightEdit >= SUtilConsts.LEV_AUTHOR);
        jbDelete.setEnabled(false);
        mjbPrintRecord.setEnabled(true);
        mjbPrintRecordCy.setEnabled(true);
        mjbAudit.setEnabled(mnViewType == SUtilConsts.AUD_PEND);
        mjbAuditRevoke.setEnabled(mnViewType == SUtilConsts.AUD);

        setIsSummaryApplying(true);

        mvSuscriptors.add(mnTabType);
        mvSuscriptors.add(SDataConstants.FINX_REC_HEADER);
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
        mvSuscriptors.add(SDataConstants.USRU_USR);

        populateTable();
    }

    @Override
    public void actionNew() {
        if (jbNew.isEnabled()) {
            if (miClient.getGuiModule(SDataConstants.MOD_FIN).showForm(SDataConstants.FINX_REC_HEADER, null) == SLibConstants.DB_ACTION_SAVE_OK) {
                miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(SDataConstants.FINX_REC_HEADER);

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

    public void actionCopy() {
        SDataRecord oRecord = null;

        if (mjbCopy.isEnabled()) {
            if (moTablePane.getSelectedTableRow() != null && !moTablePane.getSelectedTableRow().getIsSummary()) {
                oRecord = (SDataRecord) SDataUtilities.readRegistry(miClient, SDataConstants.FIN_REC, moTablePane.getSelectedTableRow().getPrimaryKey(), SLibConstants.EXEC_MODE_SILENT);

                if (!oRecord.getIsSystem()) {
                    if (miClient.getGuiModule(SDataConstants.MOD_FIN).showFormForCopy(SDataConstants.FINX_REC_HEADER, moTablePane.getSelectedTableRow().getPrimaryKey()) == SLibConstants.DB_ACTION_SAVE_OK) {
                        miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(SDataConstants.FINX_REC_HEADER);

                        if (miClient.getGuiModule(SDataConstants.MOD_FIN).showFormForCopy(mnTabType, miClient.getGuiModule(SDataConstants.MOD_FIN).getLastSavedPrimaryKey()) == SLibConstants.DB_ACTION_SAVE_OK) {
                            miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(mnTabType);
                        }
                    }
                }
                else {
                    miClient.showMsgBoxInformation(SLibConstants.MSG_ERR_REG_SYSTEM);
                }
            }
        }
    }

    private void actionPrint() {
        Cursor cursor = getCursor();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        SDataRecord oRecord = null;

        if (moTablePane.getSelectedTableRow() != null) {
            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));

                map = miClient.createReportParams();
                map.put("bShowDetailBackground", true);

                oRecord = (SDataRecord) SDataUtilities.readRegistry(miClient, SDataConstants.FIN_REC, moTablePane.getSelectedTableRow().getPrimaryKey(), SLibConstants.EXEC_MODE_SILENT);

                map.put("nIdYear", oRecord.getPkYearId());
                map.put("nIdPer", oRecord.getPkPeriodId());
                map.put("nIdBkc", oRecord.getPkBookkeepingCenterId());
                map.put("sIdTpRec", oRecord.getPkRecordTypeId());
                map.put("nIdNum", oRecord.getPkNumberId());
                map.put("tRecordDate", oRecord.getDate());
                map.put("sRecordConcept", oRecord.getConcept());
                map.put("nNumRecordLength", SDataConstantsSys.NUM_LEN_FIN_REC);
                map.put("sCompanyBranch", SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.BPSU_BPB, new int[] { oRecord.getFkCompanyBranchId() }));
                map.put("sBkcDescrip", SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FIN_BKC, new int[] { oRecord.getPkBookkeepingCenterId() }));

                jasperPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_FIN_REC, map);
                jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle("Póliza contable");
                jasperViewer.setVisible(true);
            }
            catch(Exception e) {
                SLibUtilities.renderException(this, e);
            }
            finally {
                setCursor(cursor);
            }
        }
    }

    private void actionPrintCy() {
        Cursor cursor = getCursor();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        SDataRecord oRecord = null;

        if (moTablePane.getSelectedTableRow() != null) {
            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));

                map = miClient.createReportParams();
                map.put("bShowDetailBackground", true);

                oRecord = (SDataRecord) SDataUtilities.readRegistry(miClient, SDataConstants.FIN_REC, moTablePane.getSelectedTableRow().getPrimaryKey(), SLibConstants.EXEC_MODE_SILENT);

                map.put("nIdYear", oRecord.getPkYearId());
                map.put("nIdPer", oRecord.getPkPeriodId());
                map.put("nIdBkc", oRecord.getPkBookkeepingCenterId());
                map.put("sIdTpRec", oRecord.getPkRecordTypeId());
                map.put("nIdNum", oRecord.getPkNumberId());
                map.put("tRecordDate", oRecord.getDate());
                map.put("sRecordConcept", oRecord.getConcept());
                map.put("nNumRecordLength", SDataConstantsSys.NUM_LEN_FIN_REC);
                map.put("sCompanyBranch", SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.BPSU_BPB, new int[] { oRecord.getFkCompanyBranchId() }));
                map.put("sBkcDescrip", SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FIN_BKC, new int[] { oRecord.getPkBookkeepingCenterId() }));

                jasperPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_FIN_REC_CY, map);
                jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle("Póliza contable");
                jasperViewer.setVisible(true);
            }
            catch(Exception e) {
                SLibUtilities.renderException(this, e);
            }
            finally {
                setCursor(cursor);
            }
        }
    }
    
    private void actionAudit(boolean audit) {
        SDataRecord record;
        String msg = audit ? SLibConstants.MSG_CNF_DOC_AUDIT_YES : SLibConstants.MSG_CNF_DOC_AUDIT_NO;
        
        if (miClient.showMsgBoxConfirm(msg) == JOptionPane.YES_OPTION) {
            record = (SDataRecord) SDataUtilities.readRegistry(miClient, SDataConstants.FIN_REC, moTablePane.getSelectedTableRow().getPrimaryKey(), SLibConstants.EXEC_MODE_SILENT);
            record.setPrimaryKey(moTablePane.getSelectedTableRow().getPrimaryKey());
            
            try {
                record.saveField(miClient.getSession().getDatabase().getConnection(), SDataRecord.FIELD_AUDIT, audit);
                populateTable();
            }
            catch (Exception e) {
                SLibUtilities.renderException(this, e);
            }
        }
    }

    @Override
    public void createSqlQuery() {
        String sqlWhere = "";
        STableSetting setting = null;

        for (int i = 0; i < mvTableSettings.size(); i++) {
            setting = (erp.lib.table.STableSetting) mvTableSettings.get(i);
            if (setting.getType() == STableConstants.SETTING_FILTER_DELETED && setting.getStatus() == STableConstants.STATUS_ON) {
                sqlWhere += (sqlWhere.isEmpty() ? "" : "AND ") + "r.b_del = FALSE ";
            }
            else if (setting.getType() == STableConstants.SETTING_FILTER_PERIOD) {
                sqlWhere += (sqlWhere.isEmpty() ? "" : "AND ") + SDataSqlUtilities.composePeriodFilter((int[]) setting.getSetting(), "r.dt");
            }
            else if (setting.getType() == STableConstants.SETTING_FILTER_FIN_REC_TYPE) {
                if (!((String) setting.getSetting()).isEmpty()) {
                    sqlWhere += (sqlWhere.isEmpty() ? "" : "AND ") + "r.id_tp_rec = '" + (String) setting.getSetting() + "' ";
                }
            }
        }
        
        switch (mnViewType) {
            case SUtilConsts.AUD:
                sqlWhere += (sqlWhere.isEmpty() ? "" : "AND ") + "r.b_audit = 1 ";
                break;
            case SUtilConsts.AUD_PEND:
                sqlWhere += (sqlWhere.isEmpty() ? "" : "AND ") + "r.b_audit = 0 ";
                break;
            default:
        }
        
        msSql = "SELECT r.id_year, r.id_per, r.id_bkc, r.id_tp_rec, r.id_num, r.dt, r.concept, r.b_adj_year, r.b_adj_audit, r.b_audit, r.b_authorn, r.b_sys, r.b_del, " +
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
                "LEFT OUTER JOIN erp.cfgu_cob_ent AS e ON " +
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

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == mjbCopy) {
                actionCopy();
            }
            else if (button == mjbPrintRecord) {
                actionPrint();
            }
            else if (button == mjbPrintRecordCy) {
                actionPrintCy();
            }
            else if (button == mjbAudit) {
                actionAudit(true);
            }
            else if (button == mjbAuditRevoke) {
                actionAudit(false);
            }
        }
    }

    public void publicActionPrint() {
        actionPrint();
    }
}
