/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormUnitType.java
 *
 * Created on 24/08/2009, 01:37:16 PM
 */

package erp.mitm.form;

import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.data.SProcConstants;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mitm.data.SDataUnitType;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author Alfonso Flores
 */
public class SFormUnitType extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mitm.data.SDataUnitType moUnitType;
    private erp.lib.form.SFormField moFieldUnitType;
    private erp.lib.form.SFormField moFieldUnitBase;
    private erp.lib.form.SFormField moFieldIsDeleted;

    /** Creates new form SFormUnitType */
    public SFormUnitType(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.ITMU_TP_UNIT;

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

        jpRegistry = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlUnitType = new javax.swing.JLabel();
        jtfUnitType = new javax.swing.JTextField();
        jlUnitBase = new javax.swing.JLabel();
        jtfUnitBase = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jckIsDeleted = new javax.swing.JCheckBox();
        jpCommand = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tipo de unidad");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpRegistry.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpRegistry.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(4, 2, 5, 5));

        jlUnitType.setText("Nombre de tipo de unidad: *");
        jPanel3.add(jlUnitType);

        jtfUnitType.setText("TEXT");
        jPanel3.add(jtfUnitType);

        jlUnitBase.setText("Unidad base: *");
        jPanel3.add(jlUnitBase);

        jtfUnitBase.setText("TEXT");
        jPanel3.add(jtfUnitBase);
        jPanel3.add(jLabel1);
        jPanel3.add(jLabel2);
        jPanel3.add(jLabel3);

        jckIsDeleted.setForeground(java.awt.Color.red);
        jckIsDeleted.setText("Registro eliminado");
        jPanel3.add(jckIsDeleted);

        jpRegistry.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(jpRegistry, java.awt.BorderLayout.CENTER);

        jpCommand.setPreferredSize(new java.awt.Dimension(392, 33));
        jpCommand.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jpCommand.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jpCommand.add(jbCancel);

        getContentPane().add(jpCommand, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-250)/2, 400, 250);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldUnitType = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfUnitType, jlUnitType);
        moFieldUnitType.setLengthMax(50);
        moFieldUnitBase = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfUnitBase, jlUnitBase);
        moFieldUnitBase.setLengthMax(10);
        moFieldUnitBase.setAutoCaseType(SLibConstants.UNDEFINED);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsDeleted);

        mvFields.add(moFieldUnitType);
        mvFields.add(moFieldUnitBase);
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
            jtfUnitType.requestFocus();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JLabel jlUnitBase;
    private javax.swing.JLabel jlUnitType;
    private javax.swing.JPanel jpCommand;
    private javax.swing.JPanel jpRegistry;
    private javax.swing.JTextField jtfUnitBase;
    private javax.swing.JTextField jtfUnitType;
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

        moUnitType = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        jckIsDeleted.setEnabled(false);
    }

    @Override
    public void formRefreshCatalogues() {

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
            Object[] oParamsIn = new Object[] { moUnitType == null ? 0 : moUnitType.getPkUnitTypeId(), moFieldUnitType.getString() };

            if (SDataUtilities.callProcedureVal(miClient, SProcConstants.ITMU_TP_UNIT_VAL, oParamsIn, SLibConstants.EXEC_MODE_VERBOSE) > 0) {
                validation.setMessage("El valor del campo '" + jlUnitType.getText() + "' ya existe.");
                validation.setComponent(jtfUnitType);
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
        moUnitType = (SDataUnitType) registry;

        moFieldUnitType.setFieldValue(moUnitType.getUnitType());
        moFieldUnitBase.setFieldValue(moUnitType.getUnitBase());
        moFieldIsDeleted.setFieldValue(moUnitType.getIsDeleted());

        if (moUnitType.getIsCanDelete()) {
            jckIsDeleted.setEnabled(true);
        }
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moUnitType == null) {
            moUnitType = new SDataUnitType();
            moUnitType.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moUnitType.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moUnitType.setUnitType(moFieldUnitType.getString());
        moUnitType.setUnitBase(moFieldUnitBase.getString());
        moUnitType.setIsCanEdit(true);
        moUnitType.setIsCanDelete(true);
        moUnitType.setIsDeleted(moFieldIsDeleted.getBoolean());

        return moUnitType;
    }

    @Override
    public void setValue(int type, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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