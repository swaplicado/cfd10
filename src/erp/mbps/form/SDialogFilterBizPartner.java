/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogFilterBizPartner.java
 *
 * Created on 11/03/2010, 08:20:22 AM
 */

package erp.mbps.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import java.awt.event.KeyEvent;
import java.util.Vector;

/**
 *
 * @author Alfonso Flores, Sergio Flores
 */
public class SDialogFilterBizPartner extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldBizPartnerId;

    private int mnBizPartnerCategoryId;
    private int mnBizPartnerId;
    private int mnOptionPickerType;

    /** Creates new form SDialogFilterBizPartner */
    public SDialogFilterBizPartner(erp.client.SClientInterface client, int bprCategory) {
        super(client.getFrame(), true);
        miClient = client;
        mnBizPartnerCategoryId = bprCategory;

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

        jPanel1 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jckSelectAll = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jlBizPartner = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jbBizPartner = new javax.swing.JButton();
        jcbBizPartner = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asociados de negocios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(492, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Cancelar]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones disponibles:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        jckSelectAll.setText("Todos los asociados de negocios");
        jckSelectAll.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jckSelectAllItemStateChanged(evt);
            }
        });
        jPanel3.add(jckSelectAll);

        jPanel4.setLayout(new java.awt.BorderLayout(5, 0));

        jlBizPartner.setText("Asociado de negocios: *");
        jlBizPartner.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel4.add(jlBizPartner, java.awt.BorderLayout.LINE_START);

        jPanel5.setLayout(new java.awt.BorderLayout(5, 0));

        jbBizPartner.setText("jButton1");
        jbBizPartner.setToolTipText("Seleccionar asociado de negocios");
        jbBizPartner.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbBizPartner, java.awt.BorderLayout.EAST);

        jcbBizPartner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(jcbBizPartner, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-488)/2, (screenSize.height-334)/2, 488, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void jckSelectAllItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jckSelectAllItemStateChanged
        if (!mbResetingForm) {
            itemStateChangedSelectAll();
        }
    }//GEN-LAST:event_jckSelectAllItemStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldBizPartnerId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbBizPartner, jlBizPartner);
        moFieldBizPartnerId.setPickerButton(jbBizPartner);

        mvFields.add(moFieldBizPartnerId);

        switch (mnBizPartnerCategoryId) {
            case SDataConstantsSys.BPSS_CT_BP_CO:
                mnOptionPickerType = SDataConstants.BPSX_BP_CO;
                jlBizPartner.setText("Empresa: *");
                jbBizPartner.setToolTipText("Seleccionar empresa");
                jckSelectAll.setText("Todas las empresas");
                setTitle("Empresas");
                break;
            case SDataConstantsSys.BPSS_CT_BP_CUS:
                mnOptionPickerType = SDataConstants.BPSX_BP_CUS;
                jlBizPartner.setText("Cliente: *");
                jbBizPartner.setToolTipText("Seleccionar cliente");
                jckSelectAll.setText("Todos los clientes");
                setTitle("Clientes");
                break;
            case SDataConstantsSys.BPSS_CT_BP_SUP:
                mnOptionPickerType = SDataConstants.BPSX_BP_SUP;
                jlBizPartner.setText("Proveedor: *");
                jbBizPartner.setToolTipText("Seleccionar proveedor");
                jckSelectAll.setText("Todos los proveedores");
                setTitle("Proveedores");
                break;
            case SDataConstantsSys.BPSS_CT_BP_DBR:
                mnOptionPickerType = SDataConstants.BPSX_BP_DBR;
                jlBizPartner.setText("Deudor diverso: *");
                jbBizPartner.setToolTipText("Seleccionar deudor diverso");
                jckSelectAll.setText("Todos los deudores diversos");
                setTitle("Deudores diversos");
                break;
            case SDataConstantsSys.BPSS_CT_BP_CDR:
                mnOptionPickerType = SDataConstants.BPSX_BP_CDR;
                jlBizPartner.setText("Acreedor diverso: *");
                jbBizPartner.setToolTipText("Seleccionar acreedor diverso");
                jckSelectAll.setText("Todos los acreedores diversos");
                setTitle("Acreedores diversos");
                break;
            case SDataConstants.BPSX_BP_EMP:
                mnOptionPickerType = SDataConstants.BPSX_BP_EMP;
                jlBizPartner.setText("Empleado: *");
                jbBizPartner.setToolTipText("Seleccionar empleado");
                jckSelectAll.setText("Todos los empleados");
                setTitle("Empleado");
                break;
            default:
                mnOptionPickerType = SDataConstants.BPSU_BP;
        }

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbBizPartner.addActionListener(this);

        SFormUtilities.createActionMap(getRootPane(), this, "actionOk", "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(getRootPane(), this, "actionCancel", "cancel", KeyEvent.VK_ESCAPE, SLibConstants.UNDEFINED);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;

            if (jcbBizPartner.isEnabled()) {
                jcbBizPartner.requestFocus();
            }
            else {
                jckSelectAll.requestFocus();
            }
        }
    }

    private void itemStateChangedSelectAll() {
        if (jckSelectAll.isSelected()) {
            jcbBizPartner.setEnabled(false);
            jbBizPartner.setEnabled(false);
            moFieldBizPartnerId.resetField();
        }
        else {
            jcbBizPartner.setEnabled(true);
            jbBizPartner.setEnabled(true);
        }
    }

    private void actionBizPartner() {
        miClient.pickOption(mnOptionPickerType, moFieldBizPartnerId, null);
    }

    public void actionOk() {
        if (!jckSelectAll.isSelected() && jcbBizPartner.getSelectedIndex() <= 0) {
            miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_FIELD_EMPTY + "'" + jlBizPartner.getText() + "'.");
            jcbBizPartner.requestFocus();
        }
        else {
            mnBizPartnerId = jckSelectAll.isSelected() ? SLibConstants.UNDEFINED : moFieldBizPartnerId.getKeyAsIntArray()[0];

            mnFormResult = SLibConstants.FORM_RESULT_OK;
            setVisible(false);
        }
    }

    public void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbBizPartner;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JComboBox jcbBizPartner;
    private javax.swing.JCheckBox jckSelectAll;
    private javax.swing.JLabel jlBizPartner;
    // End of variables declaration//GEN-END:variables

    public void setBizPartnerId(int id) {
        mbResetingForm = true;

        mnBizPartnerId = id;
        jckSelectAll.setSelected(mnBizPartnerId == SLibConstants.UNDEFINED);
        moFieldBizPartnerId.setKey(mnBizPartnerId == SLibConstants.UNDEFINED ? null : new int[] { mnBizPartnerId });
        itemStateChangedSelectAll();

        mbResetingForm = false;
    }

    public int getBizPartnerId() {
        return mnBizPartnerId;
    }

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

        mnBizPartnerId = 0;
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbBizPartner, mnOptionPickerType);
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        throw new UnsupportedOperationException("Not supported yet.");
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

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbBizPartner) {
                actionBizPartner();
            }
        }
    }
}