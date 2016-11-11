/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormItemsFamilies.java
 *
 * Created on 20/08/2009, 11:04:01 AM
 */

package erp.mitm.form;

import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.data.SProcConstants;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mitm.data.SDataItemFamily;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfonso Flores, Sergio Flores
 */
public class SFormItemFamily extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mitm.data.SDataItemFamily moItemFamily;
    private erp.lib.form.SFormField moFieldItemFamily;
    private erp.lib.form.SFormField moFieldIsFreeDiscountUnitary;
    private erp.lib.form.SFormField moFieldIsFreeDiscountEntry;
    private erp.lib.form.SFormField moFieldIsFreeDiscountDoc;
    private erp.lib.form.SFormField moFieldIsFreePrice;
    private erp.lib.form.SFormField moFieldIsFreeDiscount;
    private erp.lib.form.SFormField moFieldIsFreeCommissions;
    private erp.lib.form.SFormField moFieldIsDeleted;

    /** Creates new form SFormItemsFamilies */
    public SFormItemFamily(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.ITMU_IFAM;

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
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jlItemFamily = new javax.swing.JLabel();
        jtfItemFamily = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jckIsFreeDiscountUnitary = new javax.swing.JCheckBox();
        jckIsFreePrice = new javax.swing.JCheckBox();
        jckIsFreeDiscountEntry = new javax.swing.JCheckBox();
        jckIsFreeDiscount = new javax.swing.JCheckBox();
        jckIsFreeDiscountDoc = new javax.swing.JCheckBox();
        jckIsFreeCommissions = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jckIsDeleted = new javax.swing.JCheckBox();
        jpCommand = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Familia de ítems");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpRegistry.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpRegistry.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlItemFamily.setText("Nombre: *");
        jlItemFamily.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlItemFamily);

        jtfItemFamily.setText("TEXT");
        jtfItemFamily.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel11.add(jtfItemFamily);

        jPanel1.add(jPanel11, java.awt.BorderLayout.NORTH);

        jPanel12.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        jckIsFreeDiscountUnitary.setText("Sin descuento unitario");
        jPanel12.add(jckIsFreeDiscountUnitary);

        jckIsFreePrice.setText("Sin precio");
        jPanel12.add(jckIsFreePrice);

        jckIsFreeDiscountEntry.setText("Sin descuento en partida");
        jPanel12.add(jckIsFreeDiscountEntry);

        jckIsFreeDiscount.setText("Sin descuento en listas de precios");
        jPanel12.add(jckIsFreeDiscount);

        jckIsFreeDiscountDoc.setText("Sin descuento en documento");
        jPanel12.add(jckIsFreeDiscountDoc);

        jckIsFreeCommissions.setText("Sin comisiones de venta");
        jPanel12.add(jckIsFreeCommissions);
        jPanel12.add(jLabel1);
        jPanel12.add(jLabel2);
        jPanel12.add(jLabel3);

        jckIsDeleted.setForeground(java.awt.Color.red);
        jckIsDeleted.setText("Registro eliminado");
        jPanel12.add(jckIsDeleted);

        jPanel1.add(jPanel12, java.awt.BorderLayout.CENTER);

        jpRegistry.add(jPanel1, java.awt.BorderLayout.NORTH);

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
        setBounds((screenSize.width-480)/2, (screenSize.height-300)/2, 480, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivate();
    }//GEN-LAST:event_formWindowActivated

private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldItemFamily = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfItemFamily, jlItemFamily);
        moFieldItemFamily.setLengthMax(50);
        moFieldIsFreeDiscountUnitary = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsFreeDiscountUnitary);
        moFieldIsFreeDiscountEntry = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsFreeDiscountEntry);
        moFieldIsFreeDiscountDoc = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsFreeDiscountDoc);
        moFieldIsFreePrice = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsFreePrice);
        moFieldIsFreeDiscount = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsFreeDiscount);
        moFieldIsFreeCommissions = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsFreeCommissions);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsDeleted);

        mvFields.add(moFieldItemFamily);
        mvFields.add(moFieldIsFreeDiscountUnitary);
        mvFields.add(moFieldIsFreeDiscountEntry);
        mvFields.add(moFieldIsFreeDiscountDoc);
        mvFields.add(moFieldIsFreePrice);
        mvFields.add(moFieldIsFreeDiscount);
        mvFields.add(moFieldIsFreeCommissions);
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

    private void windowActivate() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jtfItemFamily.requestFocus();
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

    private void readErpParams() {
        if(miClient.getSessionXXX().getParamsErp().getIsFreePrice()) {
            jckIsFreePrice.setEnabled(false);
        }
        else {
            jckIsFreePrice.setEnabled(true);
        }

        if(miClient.getSessionXXX().getParamsErp().getIsFreeDiscount()) {
            jckIsFreeDiscount.setEnabled(false);
        }
        else {
            jckIsFreeDiscount.setEnabled(true);
        }

        if(miClient.getSessionXXX().getParamsErp().getIsFreeDiscountUnitary()) {
            jckIsFreeDiscountUnitary.setEnabled(false);
        }
        else {
            jckIsFreeDiscountUnitary.setEnabled(true);
        }

        if(miClient.getSessionXXX().getParamsErp().getIsFreeDiscountEntry()) {
            jckIsFreeDiscountEntry.setEnabled(false);
        }
        else {
            jckIsFreeDiscountEntry.setEnabled(true);
        }

        if(miClient.getSessionXXX().getParamsErp().getIsFreeDiscountDoc()) {
            jckIsFreeDiscountDoc.setEnabled(false);
        }
        else {
            jckIsFreeDiscountDoc.setEnabled(true);
        }

        if(miClient.getSessionXXX().getParamsErp().getIsFreeCommissions()) {
            jckIsFreeCommissions.setEnabled(false);
        }
        else {
            jckIsFreeCommissions.setEnabled(true);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JCheckBox jckIsFreeCommissions;
    private javax.swing.JCheckBox jckIsFreeDiscount;
    private javax.swing.JCheckBox jckIsFreeDiscountDoc;
    private javax.swing.JCheckBox jckIsFreeDiscountEntry;
    private javax.swing.JCheckBox jckIsFreeDiscountUnitary;
    private javax.swing.JCheckBox jckIsFreePrice;
    private javax.swing.JLabel jlItemFamily;
    private javax.swing.JPanel jpCommand;
    private javax.swing.JPanel jpRegistry;
    private javax.swing.JTextField jtfItemFamily;
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

        moItemFamily = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        readErpParams();
        jckIsDeleted.setEnabled(false);
    }

    @Override
    public void formRefreshCatalogues() {
    }

    @Override
    public SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            Object[] oParamsIn = new Object[] { moItemFamily == null ? 0 : moItemFamily.getPkItemFamilyId(), moFieldItemFamily.getString() };

            if (SDataUtilities.callProcedureVal(miClient, SProcConstants.ITMU_IFAM_VAL, oParamsIn, SLibConstants.EXEC_MODE_VERBOSE) > 0) {
                if (miClient.showMsgBoxConfirm("El valor del campo '" + jlItemFamily.getText() + "' ya existe, ¿desea conservalo? ") == JOptionPane.NO_OPTION) {
                    validation.setComponent(jtfItemFamily);
                    validation.setIsError(true);
                }
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
        moItemFamily = (SDataItemFamily) registry;

        moFieldItemFamily.setFieldValue(moItemFamily.getItemFamily());
        moFieldIsFreePrice.setFieldValue(moItemFamily.getIsFreePrice());
        moFieldIsFreeDiscount.setFieldValue(moItemFamily.getIsFreeDiscount());
        moFieldIsFreeDiscountUnitary.setFieldValue(moItemFamily.getIsFreeDiscountUnitary());
        moFieldIsFreeDiscountEntry.setFieldValue(moItemFamily.getIsFreeDiscountEntry());
        moFieldIsFreeDiscountDoc.setFieldValue(moItemFamily.getIsFreeDiscountDoc());
        moFieldIsFreeCommissions.setFieldValue(moItemFamily.getIsFreeCommissions());
        moFieldIsDeleted.setFieldValue(moItemFamily.getIsDeleted());

        readErpParams();
        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moItemFamily == null) {
            moItemFamily = new SDataItemFamily();
            moItemFamily.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moItemFamily.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moItemFamily.setItemFamily(moFieldItemFamily.getString());
        moItemFamily.setIsFreePrice(moFieldIsFreePrice.getBoolean());
        moItemFamily.setIsFreeDiscount(moFieldIsFreeDiscount.getBoolean());
        moItemFamily.setIsFreeDiscountUnitary(moFieldIsFreeDiscountUnitary.getBoolean());
        moItemFamily.setIsFreeDiscountEntry(moFieldIsFreeDiscountEntry.getBoolean());
        moItemFamily.setIsFreeDiscountDoc(moFieldIsFreeDiscountDoc.getBoolean());
        moItemFamily.setIsFreeCommissions(moFieldIsFreeCommissions.getBoolean());
        moItemFamily.setIsDeleted(moFieldIsDeleted.getBoolean());

        return moItemFamily;
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