/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.view;

import erp.cfd.SCfdConsts;
import erp.cfd.SDialogResult;
import erp.client.SClientInterface;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.mhrs.data.SDataPayrollReceiptIssue;
import erp.mhrs.form.SDialogPayrollImport;
import erp.mhrs.form.SDialogPayrollReceiptCfdi;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SDbPayroll;
import erp.mod.hrs.db.SHrsCfdUtils;
import erp.mod.hrs.db.SHrsFinUtils;
import erp.mod.hrs.db.SHrsPayrollAnnul;
import erp.mod.hrs.db.SHrsPayrollRowEmployeeAvailable;
import erp.mod.hrs.db.SHrsUtils;
import erp.mod.hrs.form.SDialogLayoutPayroll;
import erp.mod.hrs.form.SDialogPrintOrderPayroll;
import erp.mod.hrs.form.SDialogRepHrsReportsPayroll;
import erp.mtrn.data.SCfdUtils;
import erp.mtrn.data.SDataCfd;
import erp.mtrn.form.SDialogAnnulCfdi;
import erp.print.SDataConstantsPrint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import sa.lib.SLibConsts;
import sa.lib.SLibRpnArgument;
import sa.lib.SLibRpnArgumentType;
import sa.lib.SLibRpnOperator;
import sa.lib.SLibUtils;
import sa.lib.db.SDbConsts;
import sa.lib.grid.SGridColumnView;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridFilterDatePeriod;
import sa.lib.grid.SGridPaneSettings;
import sa.lib.grid.SGridPaneView;
import sa.lib.grid.SGridRowView;
import sa.lib.grid.SGridUtils;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiDate;

/**
 *
 * @author Néstor Ávalos, Juan Barajas, Alfredo Perez, Sergio Flores, Claudio Peña
 */
public class SViewPayroll extends SGridPaneView implements ActionListener {

    private SGridFilterDatePeriod moFilterDatePeriod;
    
    private JButton jbImport;
    private JButton jbAnnul;
    private JButton jbGetXml;
    private JButton jbGetAcknowledgmentCancellation;
    private JButton jbPrint;
    private JButton jbPrintAcknowledgmentCancellation;
    private JButton jbSend;
    private JButton jbSendPayrollReceipts;
    private JButton jbClosePayroll;
    private JButton jbPrintReportsPayroll;
    private JButton jbLayout;

    private SDialogAnnulCfdi moDialogAnnulCfdi;
    private SDialogPayrollImport moDialogFormerPayrollImport;
    private SDialogLayoutPayroll moDialogLayoutPayroll;

    public SViewPayroll(SGuiClient client, String title, int subtype) {
        super(client, SGridConsts.GRID_PANE_VIEW, SModConsts.HRS_PAY, subtype, title);
        initComponentCustom();
    }
    
    /*
     * Private methods
     */

    private void initComponentCustom() {
        setRowButtonsEnabled(true, false, true, false, true);
        
        moFilterDatePeriod = new SGridFilterDatePeriod(miClient, this, SGuiConsts.DATE_PICKER_DATE_PERIOD);
        moFilterDatePeriod.initFilter(new SGuiDate(SGuiConsts.GUI_DATE_MONTH, miClient.getSession().getCurrentDate().getTime()));
        jbImport = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_DOC_IMPORT), "Generar y timbrar CFDI", this);
        jbAnnul = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_ANNUL), "Anular nómina", this);
        jbGetXml = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_DOC_XML), "Obtener XML del comprobante", this);
        jbGetAcknowledgmentCancellation = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_DOC_XML_CANCEL), "Obtener XML del acuse de cancelación del CFDI", this);
        jbPrint = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_PRINT), "Imprimir nómina", this);
        jbPrintAcknowledgmentCancellation = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_PRINT_ACK_CAN), "Imprimir acuse de cancelación", this);
        jbSend = SGridUtils.createButton(new ImageIcon(getClass().getResource("/erp/img/icon_std_mail.gif")), "Enviar nómina", this);
        jbSendPayrollReceipts = SGridUtils.createButton(new ImageIcon(getClass().getResource("/erp/img/icon_std_mail.gif")), "Enviar recibos de nómina", this);
        jbClosePayroll = SGridUtils.createButton(new ImageIcon(getClass().getResource("/erp/img/icon_std_lock.gif")), "Cerrar/abrir nómina", this);
        jbPrintReportsPayroll = SGridUtils.createButton(miClient.getImageIcon(SLibConstants.ICON_PRINT), "Reportes de nómina", this);
        jbLayout = SGridUtils.createButton(new ImageIcon(getClass().getResource("/erp/img/icon_std_save.gif")), "Layout pago de nóminas", this);
        
        moDialogAnnulCfdi = new SDialogAnnulCfdi((SClientInterface) miClient);
        
        jbImport.setEnabled(true);
        /* XXX (jbarajas, 2016-08-16) slowly open payroll
        jbAnnul.setEnabled(true);
        //jbGetXml.setEnabled(true);
        //jbGetAcknowledgmentCancellation.setEnabled(true);
        jbPrint.setEnabled(true);
        jbPrintAcknowledgmentCancellation.setEnabled(true);
        jbSend.setEnabled(true);
        */
        
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(moFilterDatePeriod);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbImport);
        /* XXX (jbarajas, 2016-08-16) slowly open payroll
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbAnnul);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbGetXml);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbGetAcknowledgmentCancellation);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbPrint);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbPrintAcknowledgmentCancellation);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbSend);
        */
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbClosePayroll);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbPrintReportsPayroll);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbLayout);
        getPanelCommandsSys(SGuiConsts.PANEL_CENTER).add(jbSendPayrollReceipts);
    }

    @Override
    public void actionRowDelete() {
        if (jbRowDelete.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();
                
                if (miClient.showMsgBoxConfirm("Se eliminará la nómina '" + gridRow.getRowCode()+ "', y no es posible reactivar nóminas eliminadas. \n" + SGuiConsts.MSG_CNF_CONT) == JOptionPane.YES_OPTION) {
                    super.actionRowDelete();
                }
            }
        }
    }
    
    private void actionImportPayroll() {
        SDbPayroll payroll = null;
        SDialogPayrollReceiptCfdi receiptCfdi = null;
        SDialogResult dialogResult = null;
        
        if (jbImport.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                try {
                    SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                    payroll = (SDbPayroll) miClient.getSession().readRegistry(SModConsts.HRS_PAY, gridRow.getRowPrimaryKey());
                    
                    if (SHrsCfdUtils.canGenetareCfdReceipts(miClient.getSession(), payroll.getPkPayrollId())) {
                        receiptCfdi = new SDialogPayrollReceiptCfdi((SClientInterface) miClient, SHrsCfdUtils.getReceiptsPendig(miClient.getSession(), payroll.getPkPayrollId()));
                        receiptCfdi.resetForm();
                        receiptCfdi.setVisible(true);

                        if (receiptCfdi.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                                int stampsAvailable = SCfdUtils.getStampsAvailable((SClientInterface) miClient, SDataConstantsSys.TRNS_TP_CFD_PAYROLL, miClient.getSession().getCurrentDate(), SLibConsts.UNDEFINED);
                                dialogResult = new SDialogResult(miClient, "Resultados de timbrado y envío", SCfdConsts.PROC_REQ_STAMP);
                                dialogResult.setFormParams((SClientInterface) miClient, null, receiptCfdi.manPayrollEmployeeReceipts, stampsAvailable, null, false, SCfdConsts.CFDI_PAYROLL_VER_CUR, SModSysConsts.TRNU_TP_DPS_ANN_NA);
                                dialogResult.setVisible(true);
                        }
                    }
                }
                catch (Exception e) {
                    SLibUtils.showException(this, e);
                }
            }
        }
    }

    private void actionAnnulPayroll() {
        boolean needUpdate = false;
        ArrayList<SDataCfd> cfds = null;
        ArrayList<SDataPayrollReceiptIssue> receiptIssues = null;
        SHrsPayrollAnnul payrollAnnul = null;
        SDbPayroll payroll = null;

        if (jbAnnul.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        payroll = (SDbPayroll) miClient.getSession().readRegistry(SModConsts.HRS_PAY, gridRow.getRowPrimaryKey());
                        
                        if (payroll.isClosed()) {
                            miClient.showMsgBoxWarning("La nómina debe estar abierta.");
                        }
                        else {
                            cfds = SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey());
                            receiptIssues = SHrsUtils.getPayrollReceiptIssues(miClient.getSession(), gridRow.getRowPrimaryKey());
                                                    
                            moDialogAnnulCfdi.formReset();
                            moDialogAnnulCfdi.formRefreshCatalogues();
                            moDialogAnnulCfdi.setValue(SGuiConsts.PARAM_DATE, (cfds == null || cfds.isEmpty() ? miClient.getSession().getCurrentDate() : cfds.get(0).getTimestamp()));
                            moDialogAnnulCfdi.setValue(SModConsts.TRNS_TP_CFD, (cfds == null || cfds.isEmpty() ? SLibConstants.UNDEFINED : cfds.get(0).getFkCfdTypeId()));
                            moDialogAnnulCfdi.setVisible(true);

                            if (moDialogAnnulCfdi.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                                payrollAnnul = new SHrsPayrollAnnul((SClientInterface) miClient, cfds, receiptIssues, SCfdConsts.CFDI_PAYROLL_VER_CUR, true, moDialogAnnulCfdi.getDate(), moDialogAnnulCfdi.getAnnulSat(), moDialogAnnulCfdi.getDpsAnnulationType());
                                needUpdate = payrollAnnul.annulPayroll();
                            }

                            if (needUpdate) {
                                miClient.getSession().notifySuscriptors(mnGridType);
                            }

                            /*
                            if (cfds == null || cfds.isEmpty()) {
                                throw new Exception(SLibConstants.MSG_ERR_DB_REG_READ + "\nNo se encontró el archivo XML del documento.");
                            }
                            else {
                                moDialogAnnulCfdi.formReset();
                                moDialogAnnulCfdi.formRefreshCatalogues();
                                moDialogAnnulCfdi.setValue(SGuiConsts.PARAM_DATE, cfds.get(0).getTimestamp());
                                moDialogAnnulCfdi.setVisible(true);

                                if (moDialogAnnulCfdi.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                                    needUpdate = SCfdUtils.cancelCfdi((SClientInterface) miClient, SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey()), SCfdConsts.CFDI_PAYROLL_VER_CUR, moDialogAnnulCfdi.getDate(), moDialogAnnulCfdi.getAnnulSat());
                                }

                                if (needUpdate) {
                                    miClient.getSession().notifySuscriptors(mnGridType);
                                }
                            }
                            */
                        }
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    private void actionGetXml() {
        if (jbGetXml.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        SCfdUtils.getXmlCfds((SClientInterface) miClient, SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey()));
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    private void actionGetAcknowledgmentCancellation() {
        if (jbGetAcknowledgmentCancellation.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        SCfdUtils.getAcknowledgmentCancellationCfds((SClientInterface) miClient, SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey()));
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    private void actionPrint() {
        if (jbPrint.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        SDialogPrintOrderPayroll dialogPrintOrderPayroll = new SDialogPrintOrderPayroll(miClient, gridRow.getRowPrimaryKey() , "Ordenamiento de impresión");
                        dialogPrintOrderPayroll.setVisible(true);

                        if (dialogPrintOrderPayroll.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                            int orderBy = (int) dialogPrintOrderPayroll.getValue(SGuiConsts.PARAM_KEY);
                            String typeDepPayroll = (String) dialogPrintOrderPayroll.getString(SLibConstants.TXT_OK);
                            int numberCopies = (int) dialogPrintOrderPayroll.getValue(SLibConsts.UNDEFINED); // XXX 2018-01-12 (Sergio Flores): Fix this! WTF!

                            SCfdUtils.printCfds((SClientInterface) miClient, SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey(), typeDepPayroll, orderBy), numberCopies, SCfdConsts.CFDI_PAYROLL_VER_CUR);
                        }
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    private void actionPrintAcknowledgmentCancellation() {
        ArrayList<SDataCfd> cfdAux = null;
        ArrayList<SDataCfd> cfds = null;

        if (jbPrintAcknowledgmentCancellation.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        cfdAux = new ArrayList<SDataCfd>();
                        cfds = new ArrayList<SDataCfd>();

                        cfdAux = SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey());

                        for(SDataCfd cfd : cfdAux) {
                            if (cfd.getFkXmlStatusId() == SDataConstantsSys.TRNS_ST_DPS_ANNULED) {
                                cfds.add(cfd);
                            }
                        }

                        SCfdUtils.printAcknowledgmentCancellationCfd((SClientInterface) miClient, cfds, SCfdConsts.CFDI_PAYROLL_VER_CUR);
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    private void actionSendMail() {
        if (jbSend.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        SCfdUtils.sendCfd((SClientInterface) miClient, SCfdUtils.getPayrollCfds((SClientInterface) miClient, SCfdConsts.CFDI_PAYROLL_VER_CUR, gridRow.getRowPrimaryKey()), SCfdConsts.CFDI_PAYROLL_VER_CUR);
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }
    
    private void actionClosePayroll() {
        boolean canClose = false;
        boolean close = false;
        SDbPayroll payroll = null;
        
        if (jbClosePayroll.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                try {
                    SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                    payroll = (SDbPayroll) miClient.getSession().readRegistry(SModConsts.HRS_PAY, gridRow.getRowPrimaryKey());
                    if (miClient.showMsgBoxConfirm("Está por " + (!payroll.isClosed() ? "cerrar" : "abrir") + " la nómina '" + payroll.getAuxPaymentType() + " - " + payroll.getNumber() + "'.\n" + SGuiConsts.MSG_CNF_CONT) == JOptionPane.YES_OPTION) {
                        if (payroll.isClosed() && SHrsFinUtils.canOpenPayRoll(miClient.getSession(), payroll.getPkPayrollId())) {
                            SHrsFinUtils.deletePayRollRecords(miClient.getSession(), payroll.getPkPayrollId());
                            close = false; // Open payroll
                            canClose = true;
                        }
                        else {
                            if (miClient.showMsgBoxConfirm("¿Desea contabilizar la nómina?") == JOptionPane.YES_OPTION) {
                                moDialogFormerPayrollImport = new SDialogPayrollImport((SClientInterface) miClient, payroll);
                                moDialogFormerPayrollImport.resetForm();
                                moDialogFormerPayrollImport.setVisible(true);

                                if (moDialogFormerPayrollImport.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                                    close = true; // Close payroll
                                    canClose = true;
                                }
                            }
                            else {
                                close = true; // Close payroll
                                canClose = true;
                            }
                        }
                        
                        if (close) {
                            SHrsUtils.createPayrollReceiptIssues(miClient.getSession(), payroll);
                            canClose = true;
                        }
                        else {
                            SHrsUtils.updateToNewStatusPayrollReceiptIssues(miClient.getSession(), payroll);
                            canClose = true;
                        }
                        
                        if (canClose) {
                            payroll.saveField(miClient.getSession().getStatement(), gridRow.getRowPrimaryKey(), SDbPayroll.FIELD_CLOSE, close); // Close payroll
                        }

                        miClient.getSession().notifySuscriptors(mnGridType);
                    }
                }
                catch (Exception e) {
                    SLibUtils.showException(this, e);
                }
            }
        }
    }

    private void actionPrintPrePayroll() {
        SDialogRepHrsReportsPayroll hrsReportsPayroll = null;
        if (jbPrintReportsPayroll.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        //SHrsUtils.printPrePayroll(miClient, gridRow.getRowPrimaryKey()[0]);
                        
                        hrsReportsPayroll = new SDialogRepHrsReportsPayroll(miClient, "Reportes nómina");
                        
                        hrsReportsPayroll.setReportsParams(gridRow.getRowPrimaryKey()[0]);
                        
                        hrsReportsPayroll.setVisible(true);
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }
    
    private void actionSendPayrollReceipts() {
        if (jbSendPayrollReceipts.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else {
                    try {
                        SHrsUtils.sendPayrollReceipts(miClient, SDataConstantsPrint.PRINT_MODE_PDF_FILE, gridRow.getRowPrimaryKey());
                    } 
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }
 
    private void actionLayout() {
        SHrsPayrollRowEmployeeAvailable receipt = null;
        
        if (jbLayout.isEnabled()) {
            if (jtTable.getSelectedRowCount() != 1) {
                miClient.showMsgBoxInformation(SGridConsts.MSG_SELECT_ROW);
            }
            else {
                SGridRowView gridRow = (SGridRowView) getSelectedGridRow();

                if (gridRow.getRowType() != SGridConsts.ROW_TYPE_DATA) {
                    miClient.showMsgBoxWarning(SGridConsts.ERR_MSG_ROW_TYPE_DATA);
                }
                else if (gridRow.isRowSystem()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_IS_SYSTEM);
                }
                else if (!gridRow.isUpdatable()) {
                    miClient.showMsgBoxWarning(SDbConsts.MSG_REG_ + gridRow.getRowName() + SDbConsts.MSG_REG_NON_UPDATABLE);
                }
                else {
                    try {
                        receipt = new SHrsPayrollRowEmployeeAvailable();
                        receipt.obtainEmployeesAvailableByPayroll(miClient.getSession(), gridRow.getRowPrimaryKey()[0]);
                        moDialogLayoutPayroll = new SDialogLayoutPayroll(miClient, gridRow.getRowPrimaryKey()[0], "Layout para pagos de nóminas", receipt.getHrsPayrollEmployeesAvailable());
                        moDialogLayoutPayroll.resetForm();
                        moDialogLayoutPayroll.setVisible(true);

                        if (moDialogLayoutPayroll.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                        
                        }
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    /*
     * Public methods
     */

    @Override
    public void prepareSqlQuery() {
        String sql = "v.fk_tp_pay = " + mnGridSubtype + " ";
        Object filter = null;

        moPaneSettings = new SGridPaneSettings(1);
        moPaneSettings.setUserInsertApplying(true);
        moPaneSettings.setUserUpdateApplying(true);

        filter = (Boolean) moFiltersMap.get(SGridConsts.FILTER_DELETED).getValue();
        if ((Boolean) filter) {
            sql += (sql.isEmpty() ? "" : "AND ") + "v.b_del = 0 ";
        }
        
        filter = (SGuiDate) moFiltersMap.get(SGridConsts.FILTER_DATE_PERIOD).getValue();
        sql += (sql.isEmpty() ? "" : "AND ") + SGridUtils.getSqlFilterDate("v.dt_end", (SGuiDate) filter);

        msSql = "SELECT "
            + "v.id_pay AS " + SDbConsts.FIELD_ID + "1, "
            + "v.num AS " + SDbConsts.FIELD_CODE + ", "
            + "'' AS " + SDbConsts.FIELD_NAME + ", "
            + "v.per_year, "
            + "v.per, "
            + "v.dt_sta, "
            + "v.dt_end, "
            + "v.rcp_day, "
            + "v.wrk_day, "
            + "v.mwz_wage, "
            + "v.mwz_ref_wage, "
            + "v.nts, "
            + "(SELECT name FROM " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_PAY_SHT) + " WHERE id_tp_pay_sht = v.fk_tp_pay_sht) AS tp_pay_sht, "
            + "v.b_ssc, "
            + "v.b_clo, "
            + "v.b_del AS " + SDbConsts.FIELD_IS_DEL + ", "
            + "v.fk_tp_pay, "
            + "v.fk_tp_mwz, "
            + "v.fk_tp_mwz_ref, "
            + "v.fk_tp_tax_comp, "
            + "v.fk_tax, "
            + "v.fk_tax_sub, "
            + "v.fk_ssc, "
            + "v.fk_usr_clo, "
            + "v.ts_usr_clo, "
            + "(SELECT t.code FROM " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_PAY) + " AS t WHERE v.fk_tp_pay = t.id_tp_pay) AS f_pay_code, "
            + "(SELECT tm.code FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_TP_MWZ) + " AS tm WHERE v.fk_tp_mwz_ref = tm.id_tp_mwz) AS f_mwz_code, "
            + "(SELECT tr.code FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_TP_MWZ) + " AS tr WHERE v.fk_tp_mwz_ref = tr.id_tp_mwz) AS f_mwz_ref_code, "
            + "(SELECT tc.code FROM " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_TAX_COMP) + " AS tc WHERE v.fk_tp_tax_comp = tc.id_tp_tax_comp) AS f_tax_comp, "
            + "(SELECT COUNT(DISTINCT r.id_year, r.id_per, r.id_bkc, r.id_tp_rec, r.id_num) "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.FIN_REC) + " AS r "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.FIN_REC_ETY) + " AS re ON r.id_year = re.id_year AND r.id_per = re.id_per AND r.id_bkc = re.id_bkc AND r.id_tp_rec = re.id_tp_rec AND r.id_num = re.id_num "
            + "WHERE re.fid_pay_n = v.id_pay AND r.b_del = 0 AND re.b_del = 0) AS f_is_record, "
            + "uc.usr AS f_usr_close, "
            + "v.fk_usr_ins AS " + SDbConsts.FIELD_USER_INS_ID + ", "
            + "v.fk_usr_upd AS " + SDbConsts.FIELD_USER_UPD_ID + ", "
            + "v.ts_usr_ins AS " + SDbConsts.FIELD_USER_INS_TS + ", "
            + "v.ts_usr_upd AS " + SDbConsts.FIELD_USER_UPD_TS + ", "
            + "ui.usr AS " + SDbConsts.FIELD_USER_INS_NAME + ", "
            + "uu.usr AS " + SDbConsts.FIELD_USER_UPD_NAME + ", "
            + "COALESCE((SELECT SUM(pe.amt_r) "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON "
            + "p.id_pay = pr.id_pay AND pr.b_del = 0 "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_EAR) + " AS pe ON "
            + "pr.id_pay = pe.id_pay AND pr.id_emp = pe.id_emp AND pe.b_del = 0 "
            + "WHERE p.id_pay = v.id_pay "
            + "GROUP BY p.id_pay), 0) AS f_debit, "
            + "COALESCE((SELECT SUM(pd.amt_r) "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON "
            + "p.id_pay = pr.id_pay AND pr.b_del = 0 "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_DED) + " AS pd ON "
            + "pr.id_pay = pd.id_pay AND pr.id_emp = pd.id_emp AND pd.b_del = 0 "
            + "WHERE p.id_pay = v.id_pay "
            + "GROUP BY p.id_pay), 0) AS f_credit, "
            + "(SELECT COUNT(*) FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " WHERE b_del = 0 AND id_pay = v.id_pay GROUP BY id_pay) AS f_tot "
            + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS v "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS uc ON "
            + "v.fk_usr_clo = uc.id_usr "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS ui ON "
            + "v.fk_usr_ins = ui.id_usr "
            + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS uu ON "
            + "v.fk_usr_upd = uu.id_usr "
            + (sql.isEmpty() ? "" : "WHERE " + sql)
            + "GROUP BY v.num, v.id_pay "
            + "ORDER BY v.num, v.id_pay ";
    }

    @Override
    public ArrayList<SGridColumnView> createGridColumns() {
        SGridColumnView column = null;
        ArrayList<SGridColumnView> gridColumnsViews = new ArrayList<>();

        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_INT_RAW, SDbConsts.FIELD_CODE, "Número"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE, "v.dt_sta", "F inicial"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE, "v.dt_end", "F final"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "f_debit", "Percepciones $"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "f_credit", "Deducciones $"));
        
        column = new SGridColumnView(SGridConsts.COL_TYPE_DEC_AMT, "", "Alcance neto $");
        column.getRpnArguments().add(new SLibRpnArgument("f_debit", SLibRpnArgumentType.OPERAND));
        column.getRpnArguments().add(new SLibRpnArgument("f_credit", SLibRpnArgumentType.OPERAND));
        column.getRpnArguments().add(new SLibRpnArgument(SLibRpnOperator.SUBTRACTION, SLibRpnArgumentType.OPERATOR));
        gridColumnsViews.add(column);
        
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT, "tp_pay_sht", "Tipo nómina"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_BOOL_M, "v.b_clo", "Cerrada"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_BOOL_M, "f_is_record", "Contabilizada"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT, "v.nts", "Notas"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DEC_0D, "f_tot", "Recibos totales", 100));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_BOOL_S, SDbConsts.FIELD_IS_DEL, SGridConsts.COL_TITLE_IS_DEL));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_USR, "f_usr_close", "Usr cierre"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE_DATETIME, "v.ts_usr_clo", "Usr TS cierre"));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_USR, SDbConsts.FIELD_USER_INS_NAME, SGridConsts.COL_TITLE_USER_INS_NAME));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE_DATETIME, SDbConsts.FIELD_USER_INS_TS, SGridConsts.COL_TITLE_USER_INS_TS));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_TEXT_NAME_USR, SDbConsts.FIELD_USER_UPD_NAME, SGridConsts.COL_TITLE_USER_UPD_NAME));
        gridColumnsViews.add(new SGridColumnView(SGridConsts.COL_TYPE_DATE_DATETIME, SDbConsts.FIELD_USER_UPD_TS, SGridConsts.COL_TITLE_USER_UPD_TS));

        return gridColumnsViews;
    }

    @Override
    public void defineSuscriptions() {
        moSuscriptionsSet.add(mnGridType);
        moSuscriptionsSet.add(SModConsts.HRS_PAY_RCP);
        moSuscriptionsSet.add(SModConsts.HRS_PAY_RCP_ISS);
        moSuscriptionsSet.add(SModConsts.HRS_SIE_PAY);
        moSuscriptionsSet.add(SModConsts.TRN_CFD);
        moSuscriptionsSet.add(SModConsts.USRU_USR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbImport) {
                actionImportPayroll();
            }
            else if (button == jbAnnul) {
                actionAnnulPayroll();
            }
            else if (button == jbGetXml) {
                actionGetXml();
            }
            else if (button == jbGetAcknowledgmentCancellation) {
                actionGetAcknowledgmentCancellation();
            }
            else if (button == jbPrint) {
                actionPrint();
            }
            else if (button == jbPrintAcknowledgmentCancellation) {
                actionPrintAcknowledgmentCancellation();
            }
            else if (button == jbSend) {
                actionSendMail();
            }
            else if (button == jbClosePayroll) {
                actionClosePayroll();
            }
            else if (button == jbPrintReportsPayroll) {
                actionPrintPrePayroll();
            }
            else if (button == jbLayout) {
                actionLayout();
            }
            else if (button == jbSendPayrollReceipts) {
                actionSendPayrollReceipts();
            }
        }
    }
}
