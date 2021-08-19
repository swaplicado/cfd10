/*
 * DFormCompany.java
 *
 * Created on 19 de agosto de 2008, 11:10 AM
 */

package erp.mfin.form;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.Long;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.AbstractAction;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormOptionPickerInterface;
import erp.lib.form.SFormValidation;
import erp.lib.form.SFormUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.SLibTimeUtilities;
import erp.mbps.data.SDataBizPartner;
import erp.mtrn.data.SDataDps;
import erp.SClient;
import erp.server.SServerRequest;
import erp.server.SServerResponse;
import erp.server.SServerConstants;

import javax.swing.JDialog;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author  Néstor Ávalos
 */
public class SDialogRepFinMovBankCon extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldFkCobId;
    private erp.lib.form.SFormField moFieldFkEntityId;
    private erp.lib.form.SFormField moFieldDateStart;
    private erp.lib.form.SFormField moFieldDateEnd;

    private erp.mbps.data.SDataBizPartner moBizPartner;

    private int mnParamPkYearId;
    private int mnParamPkDocId;
    private int mnParamFkEntityId;
    private int mnParamReportTypePerDay;
    private int mnParamTypeAccSys;

    /** Creates new form DFormCompany */
    public SDialogRepFinMovBankCon(erp.client.SClientInterface client, java.lang.Object oType) {
        super(client.getFrame(), true);
        miClient = client;

        initComponents();
        initComponentsExtra();

        formRefreshCatalogues();
        formReset();
        setValue(1, oType);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCurrency = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jpData = new javax.swing.JPanel();
        jpReg = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jtfDateStart = new javax.swing.JFormattedTextField();
        jpStartDate = new javax.swing.JPanel();
        jbDateStart = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jtfDateEnd = new javax.swing.JFormattedTextField();
        jPanel43 = new javax.swing.JPanel();
        jbDateEnd = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jlFkCobId = new javax.swing.JLabel();
        jPanel99 = new javax.swing.JPanel();
        jcbFkCobId = new javax.swing.JComboBox();
        jPanel9 = new javax.swing.JPanel();
        jbFkCobId = new javax.swing.JButton();
        jPanel98 = new javax.swing.JPanel();
        jlFkEntityId = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jbFkEntityId = new javax.swing.JButton();
        jcbFkEntityId = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbReport = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimientos de "); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpData.setLayout(new java.awt.BorderLayout());

        jpReg.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración del reporte:"));
        jpReg.setLayout(new java.awt.BorderLayout(5, 5));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Período:"));
        jPanel8.setLayout(new java.awt.GridLayout(2, 1, 5, 2));

        jPanel4.setLayout(new java.awt.BorderLayout(0, 2));

        jlDateStart.setText("Fecha inicial: *");
        jlDateStart.setPreferredSize(new java.awt.Dimension(125, 14));
        jPanel4.add(jlDateStart, java.awt.BorderLayout.WEST);

        jPanel38.setLayout(new java.awt.BorderLayout(2, 0));

        jtfDateStart.setText("dd/mm/yyyy");
        jtfDateStart.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel38.add(jtfDateStart, java.awt.BorderLayout.WEST);

        jpStartDate.setLayout(new java.awt.BorderLayout(2, 0));

        jbDateStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDateStart.setToolTipText("Seleccionar fecha inicial vigencia");
        jbDateStart.setPreferredSize(new java.awt.Dimension(23, 23));
        jpStartDate.add(jbDateStart, java.awt.BorderLayout.WEST);

        jPanel38.add(jpStartDate, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel38, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jlDateEnd.setText("Fecha final: *");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(125, 14));
        jPanel5.add(jlDateEnd, java.awt.BorderLayout.WEST);

        jPanel42.setLayout(new java.awt.BorderLayout(2, 0));

        jtfDateEnd.setText("dd/mm/yyyy");
        jtfDateEnd.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel42.add(jtfDateEnd, java.awt.BorderLayout.WEST);

        jPanel43.setLayout(new java.awt.BorderLayout());

        jbDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDateEnd.setToolTipText("Seleccionar fecha inicial vigencia");
        jbDateEnd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel43.add(jbDateEnd, java.awt.BorderLayout.WEST);

        jPanel42.add(jPanel43, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel42, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel5);

        jpReg.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro:"));
        jPanel7.setLayout(new java.awt.BorderLayout(2, 0));

        jPanel15.setLayout(new java.awt.BorderLayout());

        jlFkCobId.setText("Sucursal de la empresa:");
        jlFkCobId.setPreferredSize(new java.awt.Dimension(125, 14));
        jPanel15.add(jlFkCobId, java.awt.BorderLayout.WEST);

        jPanel99.setLayout(new java.awt.BorderLayout(2, 5));

        jcbFkCobId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccionar sucursal)" }));
        jcbFkCobId.setPreferredSize(new java.awt.Dimension(325, 23));
        jcbFkCobId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFkCobIdItemStateChanged(evt);
            }
        });
        jPanel99.add(jcbFkCobId, java.awt.BorderLayout.WEST);

        jPanel9.setLayout(new java.awt.BorderLayout(5, 5));

        jbFkCobId.setText("...");
        jbFkCobId.setToolTipText("Seleccionar proveedor");
        jbFkCobId.setFocusable(false);
        jbFkCobId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel9.add(jbFkCobId, java.awt.BorderLayout.WEST);

        jPanel99.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel99, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jPanel98.setLayout(new java.awt.BorderLayout(0, 5));

        jlFkEntityId.setText("[Asoc. de neg.:]");
        jlFkEntityId.setPreferredSize(new java.awt.Dimension(125, 14));
        jPanel98.add(jlFkEntityId, java.awt.BorderLayout.WEST);

        jPanel10.setLayout(new java.awt.BorderLayout(2, 0));

        jPanel6.setLayout(new java.awt.BorderLayout(5, 5));

        jbFkEntityId.setText("...");
        jbFkEntityId.setToolTipText("Seleccionar proveedor");
        jbFkEntityId.setFocusable(false);
        jbFkEntityId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbFkEntityId, java.awt.BorderLayout.WEST);

        jPanel10.add(jPanel6, java.awt.BorderLayout.CENTER);

        jcbFkEntityId.setPreferredSize(new java.awt.Dimension(325, 23));
        jPanel10.add(jcbFkEntityId, java.awt.BorderLayout.WEST);

        jPanel98.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel98, java.awt.BorderLayout.CENTER);

        jpReg.add(jPanel7, java.awt.BorderLayout.CENTER);

        jpData.add(jpReg, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jpData.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jpData, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbReport.setText("Imprimir");
        jbReport.setToolTipText("[Ctrl + Enter]");
        jbReport.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbReport);

        jbCancel.setText("Cerrar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-522)/2, (screenSize.height-259)/2, 522, 259);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbFkCobIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFkCobIdItemStateChanged
        itemStateChangedFkCobId();
    }//GEN-LAST:event_jcbFkCobIdItemStateChanged

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldFkEntityId = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbFkEntityId, jlFkEntityId);
        moFieldFkCobId = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbFkCobId, jlFkCobId);
        moFieldDateStart = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jtfDateStart, jlDateStart);
        moFieldDateEnd = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jtfDateEnd, jlDateEnd);

        mvFields.add(moFieldFkCobId);
        mvFields.add(moFieldFkEntityId);
        mvFields.add(moFieldDateStart);
        mvFields.add(moFieldDateEnd);

        jbCancel.addActionListener(this);
        jbDateStart.addActionListener(this);
        jbDateEnd.addActionListener(this);
        jbFkEntityId.addActionListener(this);
        jbFkCobId.addActionListener(this);
        jbReport.addActionListener(this);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionReport(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionCancel, "cancel", KeyEvent.VK_ESCAPE, 0);

        setModalityType(ModalityType.MODELESS);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jcbFkEntityId.requestFocus();
        }
    }

    private void itemStateChangedFkCobId() {
        if (jcbFkCobId.getSelectedIndex() > 0) {
            switch (mnParamTypeAccSys) {
                case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                    SFormUtilities.populateComboBox(miClient, jcbFkEntityId, SDataConstants.FINX_ACC_CASH_CASH, new int[] { moFieldFkCobId.getKeyAsIntArray()[0] });
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                    SFormUtilities.populateComboBox(miClient, jcbFkEntityId, SDataConstants.FINX_ACC_CASH_BANK, new int[] { moFieldFkCobId.getKeyAsIntArray()[0] });
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                    populateComboBoxEntity();
                    break;
            }
        }
    }

    private void actionFkEntityId() {
        SFormOptionPickerInterface picker = null;

        switch (mnParamTypeAccSys) {
            case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                //picker = miClient.getOptionPicker(SDataConstants.BPSX_BP_SUP);
                break;
            case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                //picker = miClient.getOptionPicker(SDataConstants.BPSX_BP_SUP);
                break;
            case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                //picker = miClient.getOptionPicker(SDataConstants.BPSX_BP_SUP);
                break;
        }

        if (picker != null) {
            picker.formRefreshOptionPane();
            picker.formReset();
            picker.setSelectedPrimaryKey(new int[] { mnParamFkEntityId });
            picker.setFormVisible(true);

            if (picker.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                moFieldFkEntityId.setKey(picker.getSelectedPrimaryKey());
                mnParamFkEntityId = ((int [])picker.getSelectedPrimaryKey())[0];

                //if (moBizPartner != null) {
                //    moBizPartner = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, new int[] { mnParamFkEntityId }, SLibConstants.EXEC_MODE_VERBOSE);
                //}

                jcbFkEntityId.requestFocus();
            }
        }
    }

    private void actionFkCobId() {
        miClient.pickOption(SDataConstants.BPSU_BPB, moFieldFkCobId, new int[] { miClient.getSessionXXX().getCompany().getPkCompanyId() });
    }

    private void actionDateStart() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateStart.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateStart.setDate(miClient.getGuiDatePickerXXX().getGuiDate());
            jtfDateStart.requestFocus();
        }
    }

    private void actionDateEnd() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateEnd.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateEnd.setDate(miClient.getGuiDatePickerXXX().getGuiDate());
            jtfDateEnd.requestFocus();
        }
    }

    private void actionReport() {
        String sSqlItem = " CONCAT(e.ent) AS f_item, CONCAT(re.fid_cob_n) AS f_id_1, CONCAT(re.fid_ent_n) AS f_id_2 ";
        String sSqlCob = "";
        // String sSqlEntity = "";
        String sSqlInner1 = "";
        String sSqlInner2 = "";
        String sSqlAnd1 = "";
        String sSqlAnd2 = "";
        String sSqlId1 = "";
        String sSqlId2 = "";
        String sCob = "";
        String sEntity = "";
        String sPeriod = "";
        String sReportTitle = "MOVIMIENTOS DE ";

        SFormValidation validation = new SFormValidation();

        validation = formValidate();

        if (!validation.getIsError()) {

            // By company branch (cob) or to all companies branches:

            if (jcbFkCobId.getSelectedIndex() > 0) {
                sSqlCob = " AND r.fid_cob = " + moFieldFkCobId.getKeyAsIntArray()[0] + " ";
                sCob = jcbFkCobId.getSelectedItem().toString();
            }
            else {
                sCob = "(TODAS)";
            }

            // By account cash/bank or to all account cash/bank:

            switch (mnParamTypeAccSys) {
                case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                    sEntity = "CAJA: ";
                    sReportTitle += "CAJAS ";
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                    sEntity = "CUENTA BANCARIA: ";
                    sReportTitle += "BANCOS ";
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                    sEntity = "ALMACEN: ";
                    sReportTitle += "INVENTARIOS ";
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                    sEntity = "IMPUESTO: ";
                    sReportTitle += (mnParamTypeAccSys == SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT ? "IMPUESTOS A CARGO " : "IMPUESTOS A FAVOR ");
                    sSqlItem = " CONCAT(t.tax) AS f_item, CONCAT(re.fid_tax_bas_n) AS f_id_1, CONCAT(re.fid_tax_n) AS f_id_2 ";
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS:
                    sEntity = "EJERCICIO: ";
                    sReportTitle += "PÉRDIDAS Y GANANCIAS ";
                    sSqlItem = " CONCAT(r.id_year) AS f_item, CONCAT(re.fid_cob_n) AS f_id_1, CONCAT(re.fid_ent_n) AS f_id_2 ";
                    break;
            }

            // Render sentences Inner Joins:

            switch (mnParamTypeAccSys) {
                case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                    sSqlInner1 = "INNER JOIN erp.cfgu_cob_ent AS e ON re.fid_cob_n = e.id_cob AND re.fid_ent_n = e.id_ent ";
                    sSqlInner2 = "INNER JOIN erp.bpsu_bpb AS bb ON e.id_cob = bb.id_bpb ";
                    sSqlAnd1 = "AND re.fid_cob_n = ";
                    sSqlAnd2 = "AND re.fid_ent_n = ";
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                    sSqlInner1 = "INNER JOIN erp.finu_tax AS t ON re.fid_tax_bas_n = t.id_tax_bas AND re.fid_tax_n = t.id_tax ";
                    sSqlInner2 = "INNER JOIN erp.finu_tax_bas AS tb ON t.id_tax_bas = tb.id_tax_bas ";
                    sSqlAnd1 = "AND t.id_tax_bas = ";
                    sSqlAnd2 = "AND t.id_tax = ";
                    break;
                case SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS:
                    sSqlInner1 = "INNER JOIN fin_year AS y ON re.fid_year_n = y.id_year ";
                    break;
            }

            // Check if is for entity or all entities:

            if (jcbFkEntityId.getSelectedIndex() > 0) {
                switch (mnParamTypeAccSys) {
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                        sSqlId1 = "" + moFieldFkEntityId.getKeyAsIntArray()[0];
                        sSqlId2 = "" + moFieldFkEntityId.getKeyAsIntArray()[1];
                        // sSqlEntity += " AND re.fid_cob_n = " + moFieldFkEntityId.getKeyAsIntArray()[0] + " AND re.fid_ent_n = " + moFieldFkEntityId.getKeyAsIntArray()[1] + " ";
                        sEntity += SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.CFGU_COB_ENT, moFieldFkEntityId.getKey());
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                        sSqlId1 = "" + moFieldFkEntityId.getKeyAsIntArray()[0];
                        sSqlId2 = "" + moFieldFkEntityId.getKeyAsIntArray()[1];
                        // sSqlEntity += " AND t.id_tax_bas = " + moFieldFkEntityId.getKeyAsIntArray()[0] + " AND t.id_tax = " + moFieldFkEntityId.getKeyAsIntArray()[1] + " ";
                        sEntity += SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINU_TAX, moFieldFkEntityId.getKey());
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS:
                        sEntity += moFieldFkEntityId.getKeyAsIntArray()[0];
                        break;
                }
            }
            else {
                switch (mnParamTypeAccSys) {
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                        sEntity += "(TODAS)";
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS:
                        sEntity += "(TODOS)";
                        break;
                }
            }

            // Period by date start to date end or per day:

            switch (mnParamReportTypePerDay) {
                case SDataConstants.TRNR_ACCOUNT_CASH_PDAY:
                case SDataConstants.TRNR_ACCOUNT_BANK_PDAY:
                    moFieldDateEnd.setDate(moFieldDateStart.getDate());
                    sReportTitle += "POR DÍA";
                    sPeriod = "PERÍODO: DEL " + miClient.getSessionXXX().getFormatters().getDateFormat().format(moFieldDateStart.getDate());
                    break;
                default:
                    sPeriod = "PERÍODO: DEL " + miClient.getSessionXXX().getFormatters().getDateFormat().format(moFieldDateStart.getDate()) + " AL " + miClient.getSessionXXX().getFormatters().getDateFormat().format(moFieldDateEnd.getDate());
            }

            renderReport(sReportTitle, sSqlItem, sSqlCob, sSqlInner1, sSqlInner2, sSqlAnd1, sSqlAnd2, sSqlId1, sSqlId2, "src\\erp\\rep\\mtrnMoves.jrxml",
                    moFieldDateStart.getDate(), moFieldDateEnd.getDate(), sCob, SLibTimeUtilities.digestYear(moFieldDateStart.getDate())[0],
                    sEntity, miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getCurrency(), mnParamTypeAccSys, sPeriod);
        }
        else {
            miClient.showMsgBoxWarning(validation.getMessage());
            validation.getComponent().requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    private void renderReport(java.lang.String sReportTitle, java.lang.String sSqlItem, java.lang.String sSqlCob, java.lang.String sSqlInner1,
            java.lang.String sSqlInner2, java.lang.String sSqlAnd1, java.lang.String sSqlAnd2, java.lang.String sSqlId1, java.lang.String sSqlId2,
            java.lang.String sFile, java.util.Date tDateStart, java.util.Date tDateEnd, java.lang.String sCob, int nYearId,
            java.lang.String sEntity, java.lang.String sCurrency, int nFkTypeAccSysId, java.lang.String sPeriod) {
        Cursor oCursor = getCursor();
        JasperPrint oPrint = null;
        JasperViewer oViewer = null;
        Map<String, Object> oMap = null;

        try {

            // Report params:

            oMap = miClient.createReportParams();
            oMap.put("sReportTitle", sReportTitle);
            oMap.put("tDateBalOp", (mnParamTypeAccSys == SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS ?
                    SLibTimeUtilities.addDate(SLibTimeUtilities.getBeginOfYear(moFieldDateStart.getDate()), 0, 0, -1) :
                    SLibTimeUtilities.addDate(SLibTimeUtilities.getBeginOfMonth(moFieldDateStart.getDate()), 0, 0, -1)));
            oMap.put("tDateStart", tDateStart);
            oMap.put("tDateEnd", tDateEnd);
            oMap.put("sPeriod", sPeriod);
            oMap.put("sCob", sCob);
            oMap.put("sCurrency", sCurrency);
            oMap.put("sEntity", sEntity);
            oMap.put("nYearId", nYearId);
            oMap.put("sSqlItem", sSqlItem);
            oMap.put("sSqlCob", sSqlCob);
            oMap.put("sSqlInner1", sSqlInner1);
            oMap.put("sSqlInner2", sSqlInner2);
            oMap.put("sSqlAnd1", (mnParamTypeAccSys == SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS ?
                    "" : sSqlId1.length() == 0 ? "" : sSqlAnd1));
            oMap.put("sSqlAnd2", (mnParamTypeAccSys == SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS ?
                    "" : sSqlId2.length() == 0 ? "" : sSqlAnd2));
            oMap.put("sSqlSubRepAnd1", (mnParamTypeAccSys == SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS ?
                    "" : sSqlAnd1));
            oMap.put("sSqlSubRepAnd2", (mnParamTypeAccSys == SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS ?
                    "" : sSqlAnd2));
            oMap.put("sSqlId1", sSqlId1);
            oMap.put("sSqlId2", sSqlId2);
            oMap.put("nFkTpAccSysId", nFkTypeAccSysId);
            oMap.put("sTotalEntity", "TOTAL " + sEntity.substring(0, sEntity.lastIndexOf(":", sEntity.length())));

            // Report view:

            oPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_FIN_CASH_MOV_CON, oMap);
            oViewer = new JasperViewer(oPrint, false);
            oViewer.setTitle("Reporte de " + this.getTitle().toLowerCase());
            oViewer.setVisible(true);
        }
        catch(Exception e) {
            SLibUtilities.renderException(this, e);
        }
        finally {
            setCursor(oCursor);
        }
    }

    private void getBizPartner(int nBizPartnerId) {
        moBizPartner = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, new int[] { nBizPartnerId }, SLibConstants.EXEC_MODE_SILENT);
    }

    private void populateComboBoxEntity() {
        int i = 0;
        int j = 0;

        if (moFieldFkCobId.getKeyAsIntArray()[0] > 0) {
            if (miClient.getSessionXXX().getUser().getIsUniversal()) {
                SFormUtilities.populateComboBox(miClient, jcbFkEntityId, SDataConstants.CFGU_COB_ENT, new int[] { moFieldFkCobId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_WH });
            }
            else {
                for (i = 0; i < miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranches().size(); i++) {
                    if (miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranches().get(i).getPkCompanyBranchId() == moFieldFkCobId.getKeyAsIntArray()[0]) {
                        if (miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranches().get(i).getIsUniversal() || isUniversalAccessEntity()) {
                            SFormUtilities.populateComboBox(miClient, jcbFkEntityId, SDataConstants.CFGU_COB_ENT, new int[] { moFieldFkCobId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_WH });
                        }
                        else {
                            jcbFkEntityId.removeAllItems();
                            jcbFkEntityId.addItem(new SFormComponentItem(new int[] { 0 }, "(Seleccionar almacén)"));
                            for (j = 0; j < miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntities().size(); j++) {
                                if (miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntities().get(j).getDbmsCompanyBranchEntity().getFkEntityCategoryId() == SDataConstantsSys.CFGS_CT_ENT_WH) {
                                    jcbFkEntityId.addItem(new SFormComponentItem(new int[] { miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntities().get(j).getPkCompanyBranchId(),
                                        miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntities().get(j).getPkEntityId() }, miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntities().get(j).getDbmsCompanyBranchEntity().getEntity()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean isUniversalAccessEntity() {
        int i = 0;
        boolean isUniv = false;

        for (i = 0; i < miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntitiesUniversal().size(); i++) {
            if (miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntitiesUniversal().get(i).getPkCompanyBranchId() == moFieldFkCobId.getKeyAsIntArray()[0]) {
                if (miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranchEntitiesUniversal().get(i).getPkEntityCategoryId() == SDataConstantsSys.CFGS_CT_ENT_CASH ||
                        (miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranches().get(i).getPkCompanyBranchId() == moFieldFkCobId.getKeyAsIntArray()[0] && miClient.getSessionXXX().getUser().getDbmsAccessCompanyBranches().get(i).getIsUniversal())) {
                    isUniv = true;
                    break;
                }
            }
        }

        return isUniv;
    }

    private void actionEdit(boolean edit) {

    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCurrency;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JPanel jPanel99;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDateEnd;
    private javax.swing.JButton jbDateStart;
    private javax.swing.JButton jbFkCobId;
    private javax.swing.JButton jbFkEntityId;
    private javax.swing.JButton jbReport;
    private javax.swing.JComboBox jcbFkCobId;
    private javax.swing.JComboBox jcbFkEntityId;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlFkCobId;
    private javax.swing.JLabel jlFkEntityId;
    private javax.swing.JPanel jpData;
    private javax.swing.JPanel jpReg;
    private javax.swing.JPanel jpStartDate;
    private javax.swing.JFormattedTextField jtfDateEnd;
    private javax.swing.JFormattedTextField jtfDateStart;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moFieldDateStart.setDate(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setDate(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbFkCobId, SDataConstants.BPSU_BPB, new int[] { miClient.getSessionXXX().getCompany().getPkCompanyId() });
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
            }
        }

        return validation;
    }

    @Override
    public void setFormStatus(int status) {
        mnFormStatus = status;
    }

    @Override
    public void setFormVisible(boolean visible) {
        setVisible(visible);
    }

    @Override
    public int getFormStatus() {
        return mnFormStatus;
    }

    @Override
    public int getFormResult() {
        return mnFormResult;
    }

    @Override
    public void setRegistry(erp.lib.data.SDataRegistry registry) {

    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {

        return null;
    }

    @Override
    public void setValue(int type, java.lang.Object value) {
        switch (type) {
            case 1:
                mnParamTypeAccSys = ((int []) value)[0];
                mnParamReportTypePerDay = ((int []) value)[1];
                switch (mnParamTypeAccSys) {
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                        jlFkEntityId.setText("Caja:");
                        this.setTitle(this.getTitle() + "concentrado cajas ");
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                        jlFkEntityId.setText("Cuenta bancaria:");
                        this.setTitle(this.getTitle() + "concentrado cuentas bancarias ");
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                        jlFkEntityId.setText("Almacen:");
                        this.setTitle(this.getTitle() + "concentrado almacenes ");
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                        jlFkEntityId.setText("Impuesto a cargo:");
                        this.setTitle(this.getTitle() + "concentrado impuestos a cargo ");
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                        jlFkEntityId.setText("Impuesto a favor:");
                        this.setTitle(this.getTitle() + "concentrado impuestos a favor ");
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS:
                        jlFkEntityId.setText("Ejercicio:");
                        this.setTitle(this.getTitle() + "concentrado pérdidas y ganancias ");
                        break;
                }

                switch (mnParamTypeAccSys) {
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                        SFormUtilities.populateComboBox(miClient, jcbFkEntityId, SDataConstants.FINX_TAX_BAS_TAX);
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_PROF_LOSS:
                        SFormUtilities.populateComboBox(miClient, jcbFkEntityId, SDataConstants.FIN_YEAR);
                        break;
                }

                if (mnParamReportTypePerDay != SDataConstants.UNDEFINED) {
                    jlDateStart.setText("Fecha del: *");
                    jlDateEnd.setEnabled(false);
                    jtfDateEnd.setEnabled(false);
                    jbDateEnd.setEnabled(false);
                    this.setTitle(this.getTitle() + "por día");
                }

                if (miClient.getSessionXXX().getCurrentCompanyBranch() != null)
                    moFieldFkCobId.setKey(miClient.getSessionXXX().getCurrentCompanyBranch().getPrimaryKey());

                break;
            case 2:
                mnParamPkYearId = ((int []) value)[0];
                mnParamPkDocId = ((int []) value)[1];
                break;
            case 3:
                mnParamFkEntityId = (Integer) value;
                switch (mnParamTypeAccSys) {
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_CASH:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_CASH_BANK:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_INV:
                        moFieldFkEntityId.setKey(new int[] { (Integer) value });
                        getBizPartner(mnParamFkEntityId);
                        break;
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_DBT:
                    case SDataConstantsSys.FINS_TP_ACC_SYS_TAX_CDT:
                        break;
                }
                break;
            case 4:
                moFieldDateStart.setDate(SLibTimeUtilities.getBeginOfMonth((Date) value));
                break;
            case 5:
                moFieldDateEnd.setDate(SLibTimeUtilities.getEndOfMonth((Date) value));
                break;
        }
    }

    @Override
    public java.lang.Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        return null;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbDateStart) {
                actionDateStart();
            }
            else if (button == jbDateEnd) {
                actionDateEnd();
            }
            else if (button == jbReport) {
                actionReport();
            }
            else if (button == jbFkEntityId) {
                actionFkEntityId();
            }
            else if (button == jbFkCobId) {
                actionFkCobId();
            }
        }
    }
}