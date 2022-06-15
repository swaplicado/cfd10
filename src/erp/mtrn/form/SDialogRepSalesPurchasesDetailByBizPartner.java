/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepSalesPurchasesDetailByBizPartner.java
 *
 * Created on 23/01/2012
 */

package erp.mtrn.form;

import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mbps.data.SDataBizPartner;
import erp.mitm.data.SDataUnitType;
import erp.mtrn.data.STrnFunctionalAreaUtils;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Vector;
import javax.swing.AbstractAction;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Juan Barajas, Edwin Carmona, Sergio Flores
 */
public class SDialogRepSalesPurchasesDetailByBizPartner extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDateInitial;
    private erp.lib.form.SFormField moFieldDateEnd;
    private erp.lib.form.SFormField moFieldBizPartner;
    private erp.lib.form.SFormField moFieldUnitType;

    private boolean mbParamIsSupplier;
    
    private erp.mtrn.form.SDialogFilterFunctionalArea moDialogFilterFunctionalArea;
    private int mnFunctionalAreaId;
    private String msFunctionalAreasIds;

    /** Creates new form SDialogRepSalesPurchasesDetailByBizPartner
     * @param client GUI client.
     */
    public SDialogRepSalesPurchasesDetailByBizPartner(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;

        initComponents();
        initComponentsExtra();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupCurrency = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDateInitial = new javax.swing.JLabel();
        jftDateInitial = new javax.swing.JFormattedTextField();
        jbDateInitial = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jftDateEnd = new javax.swing.JFormattedTextField();
        jbDateEnd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlBizPartner = new javax.swing.JLabel();
        jcbBizPartner = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        jlUnitType = new javax.swing.JLabel();
        jcbUnitType = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        jlBizPartner1 = new javax.swing.JLabel();
        jtfFunctionalArea = new javax.swing.JTextField();
        jbFunctionalArea = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jrbCurrencyLoc = new javax.swing.JRadioButton();
        jrbCurrencyDoc = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jckWithoutRelatedParty = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jbPrint = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de ventas por cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración del reporte:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Período:"));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 77));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateInitial.setText("Fecha inicial: *");
        jlDateInitial.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlDateInitial);

        jftDateInitial.setText("dd/mm/yyyy");
        jftDateInitial.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jftDateInitial);

        jbDateInitial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateInitial.setToolTipText("Seleccionar fecha inicial");
        jbDateInitial.setFocusable(false);
        jbDateInitial.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDateInitial);

        jPanel10.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd.setText("Fecha final: *");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlDateEnd);

        jftDateEnd.setText("dd/mm/yyyy");
        jftDateEnd.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel5.add(jftDateEnd);

        jbDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateEnd.setToolTipText("Seleccionar fecha final");
        jbDateEnd.setFocusable(false);
        jbDateEnd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbDateEnd);

        jPanel10.add(jPanel5);

        jPanel2.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros del reporte:"));
        jPanel3.setLayout(new java.awt.GridLayout(5, 1, 0, 1));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner.setText("Cliente: *");
        jlBizPartner.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jlBizPartner);

        jcbBizPartner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbBizPartner.setPreferredSize(new java.awt.Dimension(250, 23));
        jcbBizPartner.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbBizPartnerItemStateChanged(evt);
            }
        });
        jPanel6.add(jcbBizPartner);

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlUnitType.setText("Tipo de unidad:");
        jlUnitType.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlUnitType);

        jcbUnitType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccionar tipo de unidad)", "LONGITUD", "SUPERFICIE", "VOLUMEN", "MASA" }));
        jcbUnitType.setPreferredSize(new java.awt.Dimension(250, 23));
        jcbUnitType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbUnitTypeItemStateChanged(evt);
            }
        });
        jPanel7.add(jcbUnitType);

        jPanel3.add(jPanel7);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner1.setText("Área funcional:");
        jlBizPartner1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlBizPartner1);

        jtfFunctionalArea.setEditable(false);
        jtfFunctionalArea.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel14.add(jtfFunctionalArea);

        jbFunctionalArea.setText("...");
        jbFunctionalArea.setToolTipText("Seleccionar asociado de negocios:");
        jbFunctionalArea.setFocusable(false);
        jbFunctionalArea.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel14.add(jbFunctionalArea);

        jPanel3.add(jPanel14);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jLabel2.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jLabel2);

        jrbCurrencyLoc.setText("Moneda local");
        jPanel13.add(jrbCurrencyLoc);

        jrbCurrencyDoc.setText("Moneda del documento");
        jPanel13.add(jrbCurrencyDoc);

        jPanel3.add(jPanel13);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jLabel1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jLabel1);

        jckWithoutRelatedParty.setText("Sin partes relacionadas");
        jPanel12.add(jckWithoutRelatedParty);

        jPanel3.add(jPanel12);

        jPanel2.add(jPanel3, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(392, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbPrint.setText("Imprimir");
        jbPrint.setToolTipText("[Ctrl + Enter]");
        jbPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbPrint);

        jbExit.setText("Cerrar");
        jbExit.setToolTipText("[Escape]");
        jbExit.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbExit);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(496, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbBizPartnerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbBizPartnerItemStateChanged
        if (!mbResetingForm) {
        }
    }//GEN-LAST:event_jcbBizPartnerItemStateChanged

    private void jcbUnitTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbUnitTypeItemStateChanged
        if (!mbResetingForm) {
        }
    }//GEN-LAST:event_jcbUnitTypeItemStateChanged

    private void initComponentsExtra() {
        mvFields = new Vector<>();

        moFieldDateInitial = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateInitial, jlDateInitial);
        moFieldDateInitial.setPickerButton(jbDateInitial);
        moFieldDateEnd = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateEnd, jlDateEnd);
        moFieldDateEnd.setPickerButton(jbDateEnd);
        moFieldBizPartner = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbBizPartner, jlBizPartner);
        moFieldUnitType = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbUnitType, jlUnitType);
        
        
        mvFields.add(moFieldDateInitial);
        mvFields.add(moFieldDateEnd);
        mvFields.add(moFieldBizPartner);
        mvFields.add(moFieldUnitType);

        jbPrint.addActionListener(this);
        jbExit.addActionListener(this);
        jbDateInitial.addActionListener(this);
        jbDateEnd.addActionListener(this);
        jbFunctionalArea.addActionListener(this);

        AbstractAction actionPrint = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionPrint(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionPrint, "print", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction actionExit = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionClose(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionExit, "exit", KeyEvent.VK_ESCAPE, 0);

        setModalityType(ModalityType.MODELESS);
        
        // áreas funcionales:
        jbFunctionalArea.setEnabled(miClient.getSessionXXX().getParamsCompany().getIsFunctionalAreas());
        mnFunctionalAreaId = SLibConstants.UNDEFINED;
        moDialogFilterFunctionalArea = new SDialogFilterFunctionalArea((SClientInterface) miClient);
        renderFunctionalArea();
    }

    @SuppressWarnings("unchecked")
    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;

            if (mbParamIsSupplier) {
                setTitle("Reporte detallado de compras por proveedor");
                jlBizPartner.setText("Proveedor:*");
                SFormUtilities.populateComboBox(miClient, jcbBizPartner, SDataConstants.BPSX_BP_SUP);
            }
            else {
                setTitle("Reporte detallado de ventas por cliente");
                jlBizPartner.setText("Cliente:*");
                SFormUtilities.populateComboBox(miClient, jcbBizPartner, SDataConstants.BPSX_BP_CUS);
            }
            jftDateInitial.requestFocus();
            jrbCurrencyLoc.setSelected(true);
        }
    }

    private void actionPrint() {
        Cursor cursor = getCursor();
        String field = "";
        SDataUnitType unitType = null;
        String sUnit = "";
        String sCurrency = "";
        String sPrice = "";
        String sSTot = "";
        String sTaxCharged = "";
        String sTaxRetained = "";
        String sTot = "";
        SDataBizPartner bizPartner = null;
        SFormValidation validation = formValidate();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        
        String areasFilter = "";
        if (miClient.getSessionXXX().getParamsCompany().getIsFunctionalAreas()) {
            if (msFunctionalAreasIds.isEmpty()) {
                areasFilter = "";
            }
            else {
                areasFilter = " AND d.fid_func IN ( " + msFunctionalAreasIds + " ) ";
            }
        }

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
        else {
            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));
                switch (jcbUnitType.getSelectedIndex()) {
                    case 1:
                        field = "de.len";
                        sUnit = "LNG.";
                        unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT, new int[] { SDataConstantsSys.ITMU_TP_UNIT_LEN }, SLibConstants.EXEC_MODE_VERBOSE);
                        break;
                    case 2:
                        field = "de.surf";
                        sUnit = "SUP.";
                        unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT, new int[] { SDataConstantsSys.ITMU_TP_UNIT_SURF }, SLibConstants.EXEC_MODE_VERBOSE);
                        break;
                    case 3:
                        field = "de.vol";
                        sUnit = "VOL.";
                        unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT, new int[] { SDataConstantsSys.ITMU_TP_UNIT_VOL }, SLibConstants.EXEC_MODE_VERBOSE);
                        break;
                    case 4:
                        field = "de.mass";
                        sUnit = "MAS.";
                        unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT, new int[] { SDataConstantsSys.ITMU_TP_UNIT_MASS }, SLibConstants.EXEC_MODE_VERBOSE);
                        break;
                    default:
                        field = "0";
                        sUnit = "N/A";
                        unitType = null;
                }
                
                if (jrbCurrencyLoc.isSelected()) {
                    sPrice = "de.price_u";
                    sSTot = "de.stot_r";
                    sTaxCharged = "de.tax_charged_r";
                    sTaxRetained = "de.tax_retained_r";
                    sTot = "de.tot_r";
                    sCurrency = miClient.getSession().getSessionCustom().getLocalCurrencyCode();
                }
                else {
                    sPrice = "de.price_u_cur";
                    sSTot = "de.stot_cur_r";
                    sTaxCharged = "de.tax_charged_cur_r";
                    sTaxRetained = "de.tax_retained_cur_r";
                    sTot = "de.tot_cur_r";
                    sCurrency = "";
                }
                    
                
                bizPartner = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, moFieldBizPartner.getKeyAsIntArray(), SLibConstants.EXEC_MODE_VERBOSE);

                map = miClient.createReportParams();
                map.put("tDtInitial", moFieldDateInitial.getDate());
                map.put("tDtEnd", moFieldDateEnd.getDate());
                map.put("nFidCtDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[0] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[0]);
                map.put("nFidClDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[1] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[1]);
                map.put("nFidTpDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[2] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[2]);
                map.put("nFidStDps", SDataConstantsSys.TRNS_ST_DPS_EMITED);
                map.put("nFidStDpsVal", SDataConstantsSys.TRNS_ST_DPS_VAL_EFF);
                map.put("nBizPartnerId", bizPartner.getPkBizPartnerId());
                map.put("sBizPartner", bizPartner.getBizPartner());
                map.put("sBizPartnerKey", mbParamIsSupplier ? bizPartner.getDbmsCategorySettingsSup().getKey() : bizPartner.getDbmsCategorySettingsCus().getKey());
                map.put("nBizPartnerCat", mbParamIsSupplier ? SDataConstantsSys.BPSS_CT_BP_SUP : SDataConstantsSys.BPSS_CT_BP_CUS);
                map.put("sBizPartnerCat", mbParamIsSupplier ? "PROVEEDOR" : "CLIENTE");
                map.put("sFieldUnit", field);
                map.put("sUnit", sUnit);
                map.put("sUnitBase", unitType == null ? "" : unitType.getUnitBase());
                map.put("sPriceSql", sPrice);
                map.put("sSStotSql", sSTot);
                map.put("sTaxChargedql", sTaxCharged);
                map.put("sTaxRetainedSql", sTaxRetained);
                map.put("sTotSql", sTot);
                map.put("sCurrency", sCurrency);
                map.put("sTitle", mbParamIsSupplier ? "DETALLADO DE COMPRAS POR " : "DETALLADO DE VENTAS POR ");
                map.put("sMark", mbParamIsSupplier ? "" : SDataConstantsSys.TXT_UNSIGNED);
                map.put("sFuncText", jtfFunctionalArea.getText());
                map.put("sFilterFunctionalArea", areasFilter);
                map.put("sSqlWhereWithoutRelatedParty", jckWithoutRelatedParty.isSelected() ? " AND bp.b_att_rel_pty = 0 " : "");

                jasperPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_TRN_DPS_BPS_DETAIL, map);
                jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle("Reporte detallado de " + (mbParamIsSupplier ? "compras por proveedor" : "ventas por cliente"));
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

    private void actionClose() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    private void actionDateInitial() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateInitial.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateInitial.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDateInitial.requestFocus();
        }
    }

    private void actionDateEnd() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateEnd.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateEnd.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDateEnd.requestFocus();
        }
    }
    
    private void actionFunctionalArea() {
        moDialogFilterFunctionalArea.formRefreshCatalogues();
        moDialogFilterFunctionalArea.formReset();
        moDialogFilterFunctionalArea.setFunctionalAreaId(mnFunctionalAreaId);
        moDialogFilterFunctionalArea.setFormVisible(true);

        if (moDialogFilterFunctionalArea.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
            mnFunctionalAreaId = moDialogFilterFunctionalArea.getFunctionalAreaId();
            renderFunctionalArea();
        }
    }
    
    private void renderFunctionalArea() {
        String texts[] = STrnFunctionalAreaUtils.getTextFilterOfFunctionalAreas((SClientInterface) miClient, mnFunctionalAreaId);
        msFunctionalAreasIds = texts[0];
        
        jtfFunctionalArea.setText(texts[1]);
        jtfFunctionalArea.setCaretPosition(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupCurrency;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton jbDateEnd;
    private javax.swing.JButton jbDateInitial;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbFunctionalArea;
    private javax.swing.JButton jbPrint;
    private javax.swing.JComboBox jcbBizPartner;
    private javax.swing.JComboBox jcbUnitType;
    private javax.swing.JCheckBox jckWithoutRelatedParty;
    private javax.swing.JFormattedTextField jftDateEnd;
    private javax.swing.JFormattedTextField jftDateInitial;
    private javax.swing.JLabel jlBizPartner;
    private javax.swing.JLabel jlBizPartner1;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateInitial;
    private javax.swing.JLabel jlUnitType;
    private javax.swing.JRadioButton jrbCurrencyDoc;
    private javax.swing.JRadioButton jrbCurrencyLoc;
    private javax.swing.JTextField jtfFunctionalArea;
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

        moFieldDateInitial.setFieldValue(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setFieldValue(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
        
        jckWithoutRelatedParty.setSelected(false);
        
        mbResetingForm = false;
    }

    @Override
    public void formRefreshCatalogues() {
        mbResetingForm = true;
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

        if (!validation.getIsError()) {
            if (moFieldDateEnd.getDate().compareTo(moFieldDateInitial.getDate()) < 0) {
                validation.setMessage("La fecha final debe ser mayor o igual a la fecha inicial.");
                validation.setComponent(jftDateEnd);
            }
        }

        if (!validation.getIsError()) {
            if (moFieldBizPartner.getKeyAsIntArray()[0] == 0) {
                validation.setMessage("Se debe seleccionar una opción para el campo " + (mbParamIsSupplier ? "'Proveedor:*'" : "'Cliente:*'" )+ ".");
                validation.setComponent(jcbBizPartner);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValue(int type, java.lang.Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public java.lang.Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbPrint) {
                actionPrint();
            }
            else if (button == jbExit) {
                actionClose();
            }
            else if (button == jbDateInitial) {
                actionDateInitial();
            }
            else if (button == jbDateEnd) {
                actionDateEnd();
            }
            else if (button == jbFunctionalArea) {
                actionFunctionalArea();
            }
        }
    }

    public void setParamIsSupplier(boolean b) { mbParamIsSupplier = b; }
}
