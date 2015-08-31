/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormCheckWallet.java
 *
 * Created on 12/07/2010, 05:33:13 PM
 */

package erp.mfin.form;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.data.SProcConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormValidation;
import erp.lib.form.SFormUtilities;
import erp.lib.SLibConstants;
import erp.mfin.data.SDataCheckWallet;

/**
 *
 * @author Alfonso Flores
 */
public class SFormCheckWallet extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mfin.data.SDataCheckWallet moCheckWallet;
    private erp.lib.form.SFormField moFieldFkCompanyBranchId;
    private erp.lib.form.SFormField moFieldFkAccountCashId;
    private erp.lib.form.SFormField moFieldNumberStart;
    private erp.lib.form.SFormField moFieldNumberEnd_n;
    private erp.lib.form.SFormField moFieldIsActive;
    private erp.lib.form.SFormField moFieldIsDeleted;

    /** Creates new form SFormCheckWallet */
    public SFormCheckWallet(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.FIN_CHECK_WAL;

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
        jlFkCompanyBranchId = new javax.swing.JLabel();
        jcbFkCompanyBranchId = new javax.swing.JComboBox();
        jlFkAccountCashId = new javax.swing.JLabel();
        jcbFkAccountCashId = new javax.swing.JComboBox();
        jlNumberStart = new javax.swing.JLabel();
        jtfNumberStart = new javax.swing.JTextField();
        jlNumberEnd_n = new javax.swing.JLabel();
        jtfNumberEnd_n = new javax.swing.JTextField();
        jckIsActive = new javax.swing.JCheckBox();
        Dummy = new javax.swing.JLabel();
        jckIsDeleted = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chequera");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(392, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(6, 2, 0, 1));

        jlFkCompanyBranchId.setText("Sucursal de la empresa: *");
        jPanel3.add(jlFkCompanyBranchId);

        jcbFkCompanyBranchId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFkCompanyBranchId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFkCompanyBranchIdItemStateChanged(evt);
            }
        });
        jPanel3.add(jcbFkCompanyBranchId);

        jlFkAccountCashId.setText("Cuenta de efectivo: *");
        jPanel3.add(jlFkAccountCashId);

        jcbFkAccountCashId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jcbFkAccountCashId);

        jlNumberStart.setText("Folio inicial: *");
        jPanel3.add(jlNumberStart);

        jtfNumberStart.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfNumberStart.setText("NUM INITIAL");
        jPanel3.add(jtfNumberStart);

        jlNumberEnd_n.setText("Folio final:");
        jPanel3.add(jlNumberEnd_n);

        jtfNumberEnd_n.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfNumberEnd_n.setText("NUM END");
        jPanel3.add(jtfNumberEnd_n);

        jckIsActive.setText("Es activa");
        jPanel3.add(jckIsActive);
        jPanel3.add(Dummy);

        jckIsDeleted.setText("Registro eliminado");
        jPanel3.add(jckIsDeleted);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbFkCompanyBranchIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFkCompanyBranchIdItemStateChanged
        if (!mbResetingForm) {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                itemStateChangedCompanyBranch();
            }
        }
    }//GEN-LAST:event_jcbFkCompanyBranchIdItemStateChanged

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldFkCompanyBranchId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkCompanyBranchId, jlFkCompanyBranchId);
        moFieldFkAccountCashId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkAccountCashId, jlFkAccountCashId);
        moFieldNumberStart = new SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfNumberStart, jlNumberStart);
        moFieldNumberEnd_n = new SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, false, jtfNumberEnd_n, jlNumberEnd_n);
        moFieldIsActive = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsActive);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsDeleted);

        mvFields.add(moFieldFkCompanyBranchId);
        mvFields.add(moFieldFkAccountCashId);
        mvFields.add(moFieldNumberStart);
        mvFields.add(moFieldNumberEnd_n);
        mvFields.add(moFieldIsActive);
        mvFields.add(moFieldIsDeleted);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), action, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jcbFkCompanyBranchId.requestFocus();
        }
    }

    private void actionOk() {
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

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    private void populateComboBoxAccountCash() {
        jcbFkAccountCashId.removeAllItems();
        renderComboBoxAccountCash(false);

        if (moFieldFkCompanyBranchId.getKeyAsIntArray()[0] > 0) {
            SFormUtilities.populateComboBox(miClient, jcbFkAccountCashId, SDataConstants.FINX_ACC_CASH_BANK_CHECK, new int[] { moFieldFkCompanyBranchId.getKeyAsIntArray()[0] });
            renderComboBoxAccountCash(true);
        }
    }

    private void itemStateChangedCompanyBranch() {
        populateComboBoxAccountCash();
    }

    private void renderComboBoxAccountCash(boolean b) {
        jcbFkAccountCashId.setEnabled(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dummy;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JComboBox jcbFkAccountCashId;
    private javax.swing.JComboBox jcbFkCompanyBranchId;
    private javax.swing.JCheckBox jckIsActive;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JLabel jlFkAccountCashId;
    private javax.swing.JLabel jlFkCompanyBranchId;
    private javax.swing.JLabel jlNumberEnd_n;
    private javax.swing.JLabel jlNumberStart;
    private javax.swing.JTextField jtfNumberEnd_n;
    private javax.swing.JTextField jtfNumberStart;
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

        moCheckWallet = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        jcbFkAccountCashId.removeAllItems();
        jckIsActive.setSelected(true);
        jckIsActive.setEnabled(false);
        jckIsDeleted.setEnabled(false);
        renderComboBoxAccountCash(false);
        mbResetingForm = false;
    }

    @Override
    public void formRefreshCatalogues() {
        mbResetingForm = true;
        SFormUtilities.populateComboBox(miClient, jcbFkCompanyBranchId, SDataConstants.BPSU_BPB, new int[] { miClient.getSessionXXX().getCompany().getPkCompanyId() });
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();
        int error = 0;

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()){
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            Object[] oParamsIn = new Object[] { moCheckWallet == null ? 0 : moCheckWallet.getPkCheckWalletId(), moFieldNumberStart.getInteger(),
            moFieldNumberEnd_n.getInteger(), moFieldFkCompanyBranchId.getKeyAsIntArray()[0], moFieldFkAccountCashId.getKeyAsIntArray()[1] };
            error = SDataUtilities.callProcedureVal(miClient, SProcConstants.FIN_CHECK_WAL_VAL, oParamsIn, SLibConstants.EXEC_MODE_VERBOSE);

            if ( error > 0 ) {
                if (error == 1) {
                    validation.setMessage("No se puede cambiar el folio inicial. Ya existen cheques en el folio asignado.");
                    validation.setComponent(jtfNumberStart);
                }
                else if (error == 2) {
                    validation.setMessage("No se puede cambiar el folio final. Ya existen cheques mas alla del folio asignado.");
                    validation.setComponent(jtfNumberEnd_n);
                }
                else if (error == 3) {
                    validation.setMessage("No se puede cambiar valor del campo '" + jlFkAccountCashId.getText() + "', ya tiene cheques emitidos.");
                    validation.setComponent(jcbFkAccountCashId);
                }
                else if (error == 4) {
                    validation.setMessage("No se puede cambiar valor del campo '" + jlFkCompanyBranchId.getText() + "', ya tiene cheques emitidos.");
                    validation.setComponent(jcbFkCompanyBranchId);
                }
            }
            else if (moFieldNumberEnd_n.getInteger() > 0 && moFieldNumberStart.getInteger() >= moFieldNumberEnd_n.getInteger()) {
                validation.setMessage("El folio final debe ser mayor que el folio inicial.");
                validation.setComponent(jtfNumberEnd_n);
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
        moCheckWallet = (SDataCheckWallet) registry;

        moFieldFkCompanyBranchId.setFieldValue(new int[] { moCheckWallet.getFkCompanyBranchId() });
        populateComboBoxAccountCash();
        moFieldFkAccountCashId.setFieldValue(new int[] { moCheckWallet.getFkCompanyBranchId(), moCheckWallet.getFkAccountCashId() });
        moFieldNumberStart.setFieldValue(moCheckWallet.getNumberStart());
        moFieldNumberEnd_n.setFieldValue(moCheckWallet.getNumberEnd_n() < 0 ? 0 : moCheckWallet.getNumberEnd_n());
        moFieldIsActive.setFieldValue(moCheckWallet.getIsActive());
        moFieldIsDeleted.setFieldValue(moCheckWallet.getIsDeleted());

        jckIsActive.setEnabled(true);
        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moCheckWallet == null) {
            moCheckWallet = new SDataCheckWallet();
            moCheckWallet.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moCheckWallet.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moCheckWallet.setFkCompanyBranchId(moFieldFkCompanyBranchId.getKeyAsIntArray()[0]);
        moCheckWallet.setFkAccountCashId(moFieldFkAccountCashId.getKeyAsIntArray()[1]);
        moCheckWallet.setNumberStart(moFieldNumberStart.getInteger());
        moCheckWallet.setNumberEnd_n(moFieldNumberEnd_n.getInteger() == 0 ? -1 : moFieldNumberEnd_n.getInteger());
        moCheckWallet.setIsActive(moFieldIsActive.getBoolean());
        moCheckWallet.setIsDeleted(moFieldIsDeleted.getBoolean());

        return moCheckWallet;
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
        return null;
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
        }
    }
}
