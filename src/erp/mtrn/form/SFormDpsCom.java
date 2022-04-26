package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataReadDescriptions;
import erp.lib.SLibConstants;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormOptionPickerInterface;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mtrn.data.SDataDps;
import java.awt.event.ItemEvent;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * Modificación de información de comercialización.
 * @author Adrián Avilés
 */
public class SFormDpsCom extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener, java.awt.event.ItemListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean  mbResetingForm;
    private int mnSalesAgentId_n;
    private int mnSalesSupervisorId_n;
    private java.util.Vector<SFormField> mvFields;
    private erp.client.SClientInterface miClient;
    private erp.lib.form.SFormField moFieldFkCarrierTypeId;
    private erp.lib.form.SFormField moFieldFkCarrierId_n;
    private erp.lib.form.SFormField moFieldFkVehicleTypeId_n;
    private erp.lib.form.SFormField moFieldFkVehicleId_n;
    private erp.lib.form.SFormField moFieldDriver;
    private erp.lib.form.SFormField moFieldPlate;
    private erp.lib.form.SFormField moFieldTicket;
    private erp.mtrn.data.SDataDps moDps;

    
    public SFormDpsCom(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
        mnFormType = SDataConstants.TRN_DPS_NTS;

        initComponents();
        initComponentsExtra();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlSalesAgent1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtfSalesAgentRo = new javax.swing.JTextField();
        jbSalesAgent = new javax.swing.JButton();
        jlSalesSupervisor = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfSalesSupervisorRo = new javax.swing.JTextField();
        jbSalesSupervisor = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlFkCarrierTypeId = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jcbFkCarrierTypeId = new javax.swing.JComboBox<SFormComponentItem>();
        jlFkCarrierId_n = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jcbFkCarrierId_n = new javax.swing.JComboBox<SFormComponentItem>();
        jLabel1 = new javax.swing.JLabel();
        jbFkCarrierId_n = new javax.swing.JButton();
        jlFkVehicleTypeId_n = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jcbFkVehicleTypeId_n = new javax.swing.JComboBox<SFormComponentItem>();
        jlFkVehicleId_n = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jcbFkVehicleId_n = new javax.swing.JComboBox<SFormComponentItem>();
        jLabel2 = new javax.swing.JLabel();
        jbFkVehicleId_n = new javax.swing.JButton();
        jlDriver = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jtfDriver = new javax.swing.JTextField();
        jlPlate = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jtfPlate = new javax.swing.JTextField();
        jlTicket = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jtfTicket = new javax.swing.JTextField();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comerciallización");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.GridLayout(14, 1));

        jlSalesAgent1.setText("Agente de ventas del documento:");
        jlSalesAgent1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel2.add(jlSalesAgent1);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfSalesAgentRo.setEditable(false);
        jtfSalesAgentRo.setText("BUSINESS PARTNER");
        jtfSalesAgentRo.setFocusable(false);
        jtfSalesAgentRo.setPreferredSize(new java.awt.Dimension(265, 23));
        jPanel4.add(jtfSalesAgentRo);

        jbSalesAgent.setText("...");
        jbSalesAgent.setToolTipText("Seleccionar agente de ventas");
        jbSalesAgent.setFocusable(false);
        jbSalesAgent.setPreferredSize(new java.awt.Dimension(23, 23));
        jbSalesAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalesAgentActionPerformed(evt);
            }
        });
        jPanel4.add(jbSalesAgent);

        jPanel2.add(jPanel4);

        jlSalesSupervisor.setText("Supervisor de ventas del documento:");
        jlSalesSupervisor.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel2.add(jlSalesSupervisor);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfSalesSupervisorRo.setEditable(false);
        jtfSalesSupervisorRo.setText("BUSINESS PARTNER");
        jtfSalesSupervisorRo.setFocusable(false);
        jtfSalesSupervisorRo.setPreferredSize(new java.awt.Dimension(265, 23));
        jPanel5.add(jtfSalesSupervisorRo);

        jbSalesSupervisor.setText("...");
        jbSalesSupervisor.setToolTipText("Seleccionar supervisor de ventas");
        jbSalesSupervisor.setFocusable(false);
        jbSalesSupervisor.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbSalesSupervisor);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(14, 1));

        jlFkCarrierTypeId.setText("Tipo transportista: *");
        jlFkCarrierTypeId.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel3.add(jlFkCarrierTypeId);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jcbFkCarrierTypeId.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel8.add(jcbFkCarrierTypeId);

        jPanel3.add(jPanel8);

        jlFkCarrierId_n.setText("Transportista:");
        jlFkCarrierId_n.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel3.add(jlFkCarrierId_n);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jcbFkCarrierId_n.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel6.add(jcbFkCarrierId_n);

        jLabel1.setPreferredSize(new java.awt.Dimension(5, 23));
        jPanel6.add(jLabel1);

        jbFkCarrierId_n.setText("...");
        jbFkCarrierId_n.setToolTipText("Seleccionar transportista");
        jbFkCarrierId_n.setFocusable(false);
        jbFkCarrierId_n.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbFkCarrierId_n);

        jPanel3.add(jPanel6);

        jlFkVehicleTypeId_n.setText("Tipo vehículo:");
        jlFkVehicleTypeId_n.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel3.add(jlFkVehicleTypeId_n);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jcbFkVehicleTypeId_n.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel10.add(jcbFkVehicleTypeId_n);

        jPanel3.add(jPanel10);

        jlFkVehicleId_n.setText("Vehículo empresa:");
        jlFkVehicleId_n.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel3.add(jlFkVehicleId_n);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jcbFkVehicleId_n.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel7.add(jcbFkVehicleId_n);

        jLabel2.setPreferredSize(new java.awt.Dimension(5, 23));
        jPanel7.add(jLabel2);

        jbFkVehicleId_n.setText("...");
        jbFkVehicleId_n.setToolTipText("Seleccionar vehículo de la empresa");
        jbFkVehicleId_n.setFocusable(false);
        jbFkVehicleId_n.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel7.add(jbFkVehicleId_n);

        jPanel3.add(jPanel7);

        jlDriver.setText("Chofer del vehículo:");
        jlDriver.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlDriver);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jtfDriver.setText("TEXT");
        jtfDriver.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel12.add(jtfDriver);

        jPanel3.add(jPanel12);

        jlPlate.setText("Placas del vehículo:");
        jlPlate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlPlate);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jtfPlate.setText("TEXT");
        jtfPlate.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel13.add(jtfPlate);

        jPanel3.add(jPanel13);

        jlTicket.setText("Boleto(s) de báscula:");
        jlTicket.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlTicket);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jtfTicket.setText("TEXT");
        jtfTicket.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel11.add(jtfTicket);

        jPanel3.add(jPanel11);

        jPanel1.add(jPanel3);

        jPanel9.add(jPanel1, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        jpControls.setPreferredSize(new java.awt.Dimension(392, 33));
        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        jpControls.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jpControls.add(jbCancel);

        getContentPane().add(jpControls, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(656, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jbSalesAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalesAgentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSalesAgentActionPerformed

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbOkActionPerformed

    private void initComponentsExtra() {
        moFieldFkCarrierTypeId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkCarrierTypeId, jlFkCarrierTypeId);
        moFieldFkCarrierId_n = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbFkCarrierId_n, jlFkCarrierId_n);
        moFieldFkCarrierId_n.setPickerButton(jbFkCarrierId_n);
        moFieldFkVehicleTypeId_n = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbFkVehicleTypeId_n, jlFkVehicleTypeId_n);
        moFieldFkVehicleId_n = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbFkVehicleId_n, jlFkVehicleId_n);
        moFieldFkVehicleId_n.setPickerButton(jbFkVehicleId_n);
        moFieldDriver = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfDriver, jlDriver);
        moFieldDriver.setLengthMax(50);
        moFieldPlate = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfPlate, jlPlate);
        moFieldPlate.setLengthMax(25);
        moFieldTicket = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfTicket, jlTicket);
        moFieldTicket.setLengthMax(50);

        mvFields = new Vector<>();
        mvFields.add(moFieldFkCarrierTypeId);
        mvFields.add(moFieldFkCarrierId_n);
        mvFields.add(moFieldFkVehicleTypeId_n);
        mvFields.add(moFieldFkVehicleId_n);
        mvFields.add(moFieldDriver);
        mvFields.add(moFieldPlate);
        mvFields.add(moFieldTicket);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbSalesAgent.addActionListener(this);
        jbSalesSupervisor.addActionListener(this);
        
        jcbFkCarrierTypeId.addItemListener(this);
        jcbFkVehicleTypeId_n.addItemListener(this);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jcbFkCarrierTypeId.requestFocusInWindow();
        }
    }

    private void renderSalesAgent(int[] pk) {
        if (pk == null) {
            mnSalesAgentId_n = 0;
            jtfSalesAgentRo.setText("");
            jtfSalesAgentRo.setToolTipText(null);
        }
        else {
            mnSalesAgentId_n = pk[0];
            jtfSalesAgentRo.setText(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.BPSU_BP, pk));
            jtfSalesAgentRo.setToolTipText(jtfSalesAgentRo.getText());
            jtfSalesAgentRo.setCaretPosition(0);
        }
    }
     
    private void renderSalesSupervisor(int[] pk) {
        if (pk == null) {
            mnSalesSupervisorId_n = 0;
            jtfSalesSupervisorRo.setText("");
            jtfSalesSupervisorRo.setToolTipText(null);
        }
        else {
            mnSalesSupervisorId_n = pk[0];
            jtfSalesSupervisorRo.setText(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.BPSU_BP, pk));
            jtfSalesSupervisorRo.setToolTipText(jtfSalesSupervisorRo.getText());
            jtfSalesSupervisorRo.setCaretPosition(0);
        }
    }

    private void actionSalesAgent() {
        SFormOptionPickerInterface picker = miClient.getOptionPicker(SDataConstants.BPSX_BP_ATT_SAL_AGT);

        picker.formReset();
        picker.formRefreshOptionPane();
        picker.setFormVisible(true);

        if (picker.getFormResult() == SLibConstants.FORM_RESULT_OK) {
            mnSalesAgentId_n = ((int[]) picker.getSelectedPrimaryKey())[0];
            renderSalesAgent(new int[] { mnSalesAgentId_n });
        }
    }
     
    private void actionSalesSupervisor() {
        SFormOptionPickerInterface picker = miClient.getOptionPicker(SDataConstants.BPSX_BP_ATT_SAL_AGT);

        picker.formReset();
        picker.formRefreshOptionPane();
        picker.setFormVisible(true);

        if (picker.getFormResult() == SLibConstants.FORM_RESULT_OK) {
            mnSalesSupervisorId_n = ((int[]) picker.getSelectedPrimaryKey())[0];
            renderSalesSupervisor(new int[] { mnSalesSupervisorId_n });
        }
    }
     
    private void actionOk() {
        if (jbOk.isEnabled()) {
            SFormValidation validation = formValidate();

            if (validation.getIsError()) {
                if (validation.getComponent() != null) {
                    validation.getComponent().requestFocus();
                }
                if (validation.getMessage().length() > 0) {
                    miClient.showMsgBoxWarning(validation.getMessage());
                }
            }
            else {
                 mnFormResult = SLibConstants.FORM_RESULT_OK;
                 setVisible(false);
            }
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    private void itemStateChangedFkCarrierTypeId() {
        boolean enableCarrier = moFieldFkCarrierTypeId.getKeyAsIntArray()[0] == SModSysConsts.LOGS_TP_CAR_CAR;
        boolean enableTypeVehicle = moFieldFkCarrierTypeId.getKeyAsIntArray()[0] > SModSysConsts.LOGS_TP_CAR_NA;

        jcbFkCarrierId_n.setEnabled(enableCarrier);
        jbFkCarrierId_n.setEnabled(enableCarrier);
        
        jcbFkVehicleTypeId_n.setEnabled(enableTypeVehicle);
        jtfDriver.setEditable(enableTypeVehicle);
        jtfDriver.setFocusable(enableTypeVehicle);
        jtfPlate.setEditable(enableTypeVehicle);
        jtfPlate.setFocusable(enableTypeVehicle);
        jtfTicket.setEditable(enableTypeVehicle);
        jtfTicket.setFocusable(enableTypeVehicle);
        
        if (!enableCarrier) {
            moFieldFkCarrierId_n.setFieldValue(null);
        }

        if (!enableTypeVehicle) {
            moFieldFkVehicleTypeId_n.setFieldValue(null);
            moFieldDriver.setFieldValue("");
            moFieldPlate.setFieldValue("");
            moFieldTicket.setFieldValue("");
        }
        
        itemStateChangedFkVehicleTypeId_n();
    }
    
    private void itemStateChangedFkVehicleTypeId_n() {
	boolean enableVehicle = jcbFkVehicleTypeId_n.getSelectedIndex() > 0 && moFieldFkCarrierTypeId.getKeyAsIntArray()[0] == SModSysConsts.LOGS_TP_CAR_OWN;
        
        SFormUtilities.populateComboBox(miClient, jcbFkVehicleId_n, SModConsts.LOG_VEH, new int[] { moFieldFkVehicleTypeId_n.getKeyAsIntArray()[0] });
        
        jcbFkVehicleId_n.setEnabled(enableVehicle);
        jbFkVehicleId_n.setEnabled(enableVehicle);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbFkCarrierId_n;
    private javax.swing.JButton jbFkVehicleId_n;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbSalesAgent;
    private javax.swing.JButton jbSalesSupervisor;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkCarrierId_n;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkCarrierTypeId;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkVehicleId_n;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkVehicleTypeId_n;
    private javax.swing.JLabel jlDriver;
    private javax.swing.JLabel jlFkCarrierId_n;
    private javax.swing.JLabel jlFkCarrierTypeId;
    private javax.swing.JLabel jlFkVehicleId_n;
    private javax.swing.JLabel jlFkVehicleTypeId_n;
    private javax.swing.JLabel jlPlate;
    private javax.swing.JLabel jlSalesAgent1;
    private javax.swing.JLabel jlSalesSupervisor;
    private javax.swing.JLabel jlTicket;
    private javax.swing.JPanel jpControls;
    private javax.swing.JTextField jtfDriver;
    private javax.swing.JTextField jtfPlate;
    private javax.swing.JTextField jtfSalesAgentRo;
    private javax.swing.JTextField jtfSalesSupervisorRo;
    private javax.swing.JTextField jtfTicket;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        moDps = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }
    }

    @Override
    public void formRefreshCatalogues() {
        mbResetingForm = true;

        SFormUtilities.populateComboBox(miClient, jcbFkCarrierTypeId, SModConsts.LOGS_TP_CAR);
        SFormUtilities.populateComboBox(miClient, jcbFkCarrierId_n, SDataConstants.BPSX_BP_ATT_CARR);
        SFormUtilities.populateComboBox(miClient, jcbFkVehicleTypeId_n, SModConsts.LOGU_TP_VEH);
        
        mbResetingForm = false;
    }

    @Override
    public SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(mvFields.get(i).getComponent());
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
        mbResetingForm = true;
        
        moDps = (SDataDps) registry;
        
        renderSalesAgent(moDps.getFkSalesAgentId_n() == 0 ? null : new int[] { moDps.getFkSalesAgentId_n() });
        renderSalesSupervisor(moDps.getFkSalesSupervisorId_n() == 0 ? null : new int[] { moDps.getFkSalesSupervisorId_n() });

        moFieldFkCarrierTypeId.setFieldValue(new int[] { moDps.getFkCarrierTypeId() });
        itemStateChangedFkCarrierTypeId();
        moFieldFkCarrierId_n.setFieldValue(new int[] { moDps.getFkCarrierId_n() });
        moFieldFkVehicleTypeId_n.setFieldValue(new int[] { moDps.getFkVehicleTypeId_n() });
        itemStateChangedFkVehicleTypeId_n();
        moFieldFkVehicleId_n.setFieldValue(new int[] { moDps.getFkVehicleId_n() });
        
        moFieldDriver.setFieldValue(moDps.getDriver());
        moFieldPlate.setFieldValue(moDps.getPlate());
        moFieldTicket.setFieldValue(moDps.getTicket());
        
        mbResetingForm = false;
    }
    
    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moDps == null) {
            moDps = new SDataDps();
            moDps.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moDps.setIsRegistryEdited(true);
            moDps.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moDps.setDriver(!jtfDriver.isEditable() ? "" : moFieldDriver.getString());
        moDps.setPlate(!jtfPlate.isEditable() ? "" : moFieldPlate.getString());
        moDps.setTicket(!jtfTicket.isEditable() ? "" : moFieldTicket.getString());
        
        moDps.setFkSalesAgentId_n(mnSalesAgentId_n);
        moDps.setFkSalesSupervisorId_n(mnSalesSupervisorId_n);
        
        moDps.setFkCarrierTypeId(moFieldFkCarrierTypeId.getKeyAsIntArray()[0]);
        moDps.setFkCarrierId_n(moFieldFkCarrierId_n.getKeyAsIntArray()[0]);
        moDps.setFkVehicleTypeId_n(moFieldFkVehicleTypeId_n.getKeyAsIntArray()[0]);
        moDps.setFkVehicleId_n(moFieldFkVehicleId_n.getKeyAsIntArray()[0]);

        return moDps;
    }

    @Override
    public void setValue(int type, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JLabel getTimeoutLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbSalesAgent) {
                actionSalesAgent();
            }
            else if (button == jbSalesSupervisor) {
                actionSalesSupervisor();
            }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (!mbResetingForm) {
            if (e.getSource() instanceof JComboBox && e.getStateChange() == ItemEvent.SELECTED) {
                JComboBox comboBox = (JComboBox) e.getSource();
                
                if (comboBox == jcbFkCarrierTypeId) {
                    itemStateChangedFkCarrierTypeId();
                }
                else if (comboBox == jcbFkVehicleTypeId_n) {
                    itemStateChangedFkVehicleTypeId_n();
                }
            }
        }
    }
}
