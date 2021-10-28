package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataReadDescriptions;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormOptionPickerInterface;
import erp.lib.form.SFormValidation;
import java.awt.event.ItemEvent;
import java.util.Vector;

import erp.mtrn.data.SDataDps;
import javax.swing.JLabel;

public class SFormDpsCom extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener, java.awt.event.ItemListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private int mnSalesAgentId_n;
    private int mnSalesSupervisorId_n;
    private java.util.Vector<SFormField> mvFields;
    private erp.client.SClientInterface miClient;
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
        jlDriver = new javax.swing.JLabel();
        jtfDriver = new javax.swing.JTextField();
        jlPlate = new javax.swing.JLabel();
        jtfPlate = new javax.swing.JTextField();
        jlTicket = new javax.swing.JLabel();
        jtfTicket = new javax.swing.JTextField();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Datos Comerciallización");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.GridLayout(6, 1));

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

        jPanel3.setLayout(new java.awt.GridLayout(6, 1));

        jlDriver.setText("Chofer del vehículo:");
        jlDriver.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlDriver);

        jtfDriver.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jtfDriver);

        jlPlate.setText("Placas del vehículo:");
        jlPlate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlPlate);

        jtfPlate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jtfPlate);

        jlTicket.setText("Boleto(s) báscula:");
        jlTicket.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlTicket);

        jtfTicket.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jtfTicket);

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
        
        moFieldDriver = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfDriver, jlDriver);
        moFieldDriver.setLengthMax(50);
        
        moFieldPlate = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfPlate, jlPlate);
        moFieldPlate.setLengthMax(25);
        
        moFieldTicket = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfTicket, jlTicket);
        moFieldTicket.setLengthMax(50);

        mvFields = new Vector<>();
        mvFields.add(moFieldDriver);
        mvFields.add(moFieldPlate);
        mvFields.add(moFieldTicket);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbSalesAgent.addActionListener(this);
        jbSalesSupervisor.addActionListener(this);
        
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
        }
    }

    private void actionOk() {
        mnFormResult = SLibConstants.FORM_RESULT_OK;
        setVisible(false);
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbSalesAgent;
    private javax.swing.JButton jbSalesSupervisor;
    private javax.swing.JLabel jlDriver;
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
        moDps = (SDataDps) registry;

        moFieldDriver.setFieldValue(moDps.getDriver());
        moFieldPlate.setFieldValue(moDps.getPlate());
        moFieldTicket.setFieldValue(moDps.getTicket());
        
        renderSalesAgent(moDps.getFkSalesAgentId_n() == 0 ? null : new int[] { moDps.getFkSalesAgentId_n() });
        renderSalesSupervisor(moDps.getFkSalesSupervisorId_n() == 0 ? null : new int[] { moDps.getFkSalesSupervisorId_n() });

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

        moDps.setDriver(moFieldDriver.getString());
        moDps.setPlate(moFieldPlate.getString());
        moDps.setTicket(moFieldTicket.getString());
        moDps.setFkSalesAgentId_n(mnSalesAgentId_n);
        moDps.setFkSalesSupervisorId_n(mnSalesSupervisorId_n);

        return moDps;
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

     
/*************************************************************************************************/
    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void formRefreshCatalogues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SFormValidation formValidate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
