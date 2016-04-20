/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormUserConfigurationTransaction.java
 *
 * Created on 24/09/2010, 03:32:08 PM
 */

package erp.mtrn.form;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.data.SProcConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormValidation;
import erp.lib.form.SFormUtilities;
import erp.lib.SLibConstants;
import erp.mtrn.data.SDataUserConfigurationTransaction;

/**
 *
 * @author Alfonso Flores
 */
public class SFormUserConfigurationTransaction extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mtrn.data.SDataUserConfigurationTransaction moUserConfigurationTransaction;
    private erp.lib.form.SFormField moFieldIsPurchasesItemAllApplying;
    private erp.lib.form.SFormField moFieldPurchasesOrderLimit_n;
    private erp.lib.form.SFormField moFieldPurchasesDocLimit_n;
    private erp.lib.form.SFormField moFieldIsSalesItemAllApplying;
    private erp.lib.form.SFormField moFieldSalesOrderLimit_n;
    private erp.lib.form.SFormField moFieldSalesDocLimit_n;
    private erp.lib.form.SFormField moFieldCapacityVolumeMinPercentage;
    private erp.lib.form.SFormField moFieldCapacityMassMinPercentage;

    /** Creates new form SFormUserConfigurationTransaction */
    public SFormUserConfigurationTransaction(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.TRN_USR_CFG;

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
        jlUser = new javax.swing.JLabel();
        jtfUser = new javax.swing.JTextField();
        jckIsPurchasesItemAllApplying = new javax.swing.JCheckBox();
        Dummy01 = new javax.swing.JLabel();
        jlPurchasesOrderLimit_n = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtfPurchasesOrderLimit_n = new javax.swing.JTextField();
        jtfCurrencyKeyPurchasesOrder = new javax.swing.JTextField();
        jlPurchasesDocLimit_n = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfPurchasesDocLimit_n = new javax.swing.JTextField();
        jtfCurrencyKeyPurchasesDoc = new javax.swing.JTextField();
        jckIsSalesItemAllApplying = new javax.swing.JCheckBox();
        Dummy02 = new javax.swing.JLabel();
        jlSalesOrderLimit_n = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jtfSalesOrderLimit_n = new javax.swing.JTextField();
        jtfCurrencyKeySalesOrder = new javax.swing.JTextField();
        jlSalesDocLimit_n = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jtfSalesDocLimit_n = new javax.swing.JTextField();
        jtfCurrencyKeySalesDoc = new javax.swing.JTextField();
        jlCapacityVolumeMinPer = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jtfCapacityVolumeMinPer = new javax.swing.JTextField();
        jlDummy = new javax.swing.JLabel();
        jlCapacityMassMinPer = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jtfCapacityMassMinPer = new javax.swing.JTextField();
        jlDummy1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración de usuario para transacciones");
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

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(9, 2, 0, 1));

        jlUser.setText("Usuario:");
        jPanel3.add(jlUser);

        jtfUser.setEditable(false);
        jtfUser.setText("USER");
        jtfUser.setFocusable(false);
        jPanel3.add(jtfUser);

        jckIsPurchasesItemAllApplying.setText("Puede comprar todos los ítem");
        jPanel3.add(jckIsPurchasesItemAllApplying);
        jPanel3.add(Dummy01);

        jlPurchasesOrderLimit_n.setText("Límite para pedidos de compra:");
        jPanel3.add(jlPurchasesOrderLimit_n);

        jPanel4.setLayout(new java.awt.BorderLayout(2, 0));

        jtfPurchasesOrderLimit_n.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfPurchasesOrderLimit_n.setText("LIMIT PURCHASES ORDER");
        jPanel4.add(jtfPurchasesOrderLimit_n, java.awt.BorderLayout.CENTER);

        jtfCurrencyKeyPurchasesOrder.setEditable(false);
        jtfCurrencyKeyPurchasesOrder.setText("CUR");
        jtfCurrencyKeyPurchasesOrder.setFocusable(false);
        jtfCurrencyKeyPurchasesOrder.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel4.add(jtfCurrencyKeyPurchasesOrder, java.awt.BorderLayout.EAST);

        jPanel3.add(jPanel4);

        jlPurchasesDocLimit_n.setText("Límite para facturas de compra:");
        jPanel3.add(jlPurchasesDocLimit_n);

        jPanel5.setLayout(new java.awt.BorderLayout(2, 0));

        jtfPurchasesDocLimit_n.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfPurchasesDocLimit_n.setText("LIMIT PURCHASES DOC");
        jPanel5.add(jtfPurchasesDocLimit_n, java.awt.BorderLayout.CENTER);

        jtfCurrencyKeyPurchasesDoc.setEditable(false);
        jtfCurrencyKeyPurchasesDoc.setText("CUR");
        jtfCurrencyKeyPurchasesDoc.setFocusable(false);
        jtfCurrencyKeyPurchasesDoc.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel5.add(jtfCurrencyKeyPurchasesDoc, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel5);

        jckIsSalesItemAllApplying.setText("Puede vender todos los ítem");
        jPanel3.add(jckIsSalesItemAllApplying);
        jPanel3.add(Dummy02);

        jlSalesOrderLimit_n.setText("Límite para pedidos de venta:");
        jPanel3.add(jlSalesOrderLimit_n);

        jPanel6.setLayout(new java.awt.BorderLayout(2, 0));

        jtfSalesOrderLimit_n.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfSalesOrderLimit_n.setText("LIMIT SALES ORDER");
        jPanel6.add(jtfSalesOrderLimit_n, java.awt.BorderLayout.CENTER);

        jtfCurrencyKeySalesOrder.setEditable(false);
        jtfCurrencyKeySalesOrder.setText("CUR");
        jtfCurrencyKeySalesOrder.setFocusable(false);
        jtfCurrencyKeySalesOrder.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel6.add(jtfCurrencyKeySalesOrder, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel6);

        jlSalesDocLimit_n.setText("Límite para facturas de venta:");
        jPanel3.add(jlSalesDocLimit_n);

        jPanel7.setLayout(new java.awt.BorderLayout(2, 0));

        jtfSalesDocLimit_n.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfSalesDocLimit_n.setText("LIMIT SALES DOC");
        jPanel7.add(jtfSalesDocLimit_n, java.awt.BorderLayout.CENTER);

        jtfCurrencyKeySalesDoc.setEditable(false);
        jtfCurrencyKeySalesDoc.setText("CUR");
        jtfCurrencyKeySalesDoc.setFocusable(false);
        jtfCurrencyKeySalesDoc.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel7.add(jtfCurrencyKeySalesDoc, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel7);

        jlCapacityVolumeMinPer.setText("Capacidad mínima de volumen:");
        jlCapacityVolumeMinPer.setPreferredSize(new java.awt.Dimension(125, 14));
        jPanel3.add(jlCapacityVolumeMinPer);

        jPanel8.setLayout(new java.awt.BorderLayout(2, 0));

        jtfCapacityVolumeMinPer.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfCapacityVolumeMinPer.setText("LIMIT VOLUME");
        jPanel8.add(jtfCapacityVolumeMinPer, java.awt.BorderLayout.CENTER);

        jlDummy.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel8.add(jlDummy, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel8);

        jlCapacityMassMinPer.setText("Capacidad mínima de masa:");
        jPanel3.add(jlCapacityMassMinPer);

        jPanel9.setLayout(new java.awt.BorderLayout(2, 0));

        jtfCapacityMassMinPer.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfCapacityMassMinPer.setText("LIMIT MASS");
        jPanel9.add(jtfCapacityMassMinPer, java.awt.BorderLayout.CENTER);

        jlDummy1.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel9.add(jlDummy1, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel9);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-496)/2, (screenSize.height-338)/2, 496, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldIsPurchasesItemAllApplying = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsPurchasesItemAllApplying);
        moFieldPurchasesOrderLimit_n = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfPurchasesOrderLimit_n, jlPurchasesOrderLimit_n);
        moFieldPurchasesOrderLimit_n.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat());
        moFieldPurchasesDocLimit_n = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfPurchasesDocLimit_n, jlPurchasesDocLimit_n);
        moFieldPurchasesDocLimit_n.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat());
        moFieldIsSalesItemAllApplying = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsSalesItemAllApplying);
        moFieldSalesOrderLimit_n = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfSalesOrderLimit_n, jlSalesOrderLimit_n);
        moFieldSalesOrderLimit_n.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat());
        moFieldSalesDocLimit_n = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfSalesDocLimit_n, jlSalesDocLimit_n);
        moFieldSalesDocLimit_n.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat());
        moFieldCapacityVolumeMinPercentage = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfCapacityVolumeMinPer, jlCapacityVolumeMinPer);
        moFieldCapacityVolumeMinPercentage.setIsPercent(true);
        moFieldCapacityVolumeMinPercentage.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat());
        moFieldCapacityMassMinPercentage = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfCapacityMassMinPer, jlCapacityMassMinPer);
        moFieldCapacityMassMinPercentage.setIsPercent(true);
        moFieldCapacityMassMinPercentage.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat());

        mvFields.add(moFieldIsPurchasesItemAllApplying);
        mvFields.add(moFieldPurchasesOrderLimit_n);
        mvFields.add(moFieldPurchasesDocLimit_n);
        mvFields.add(moFieldIsSalesItemAllApplying);
        mvFields.add(moFieldSalesOrderLimit_n);
        mvFields.add(moFieldSalesDocLimit_n);
        mvFields.add(moFieldCapacityVolumeMinPercentage);
        mvFields.add(moFieldCapacityMassMinPercentage);

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
            jckIsPurchasesItemAllApplying.requestFocus();
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
    private javax.swing.JLabel Dummy01;
    private javax.swing.JLabel Dummy02;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JCheckBox jckIsPurchasesItemAllApplying;
    private javax.swing.JCheckBox jckIsSalesItemAllApplying;
    private javax.swing.JLabel jlCapacityMassMinPer;
    private javax.swing.JLabel jlCapacityVolumeMinPer;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JLabel jlDummy1;
    private javax.swing.JLabel jlPurchasesDocLimit_n;
    private javax.swing.JLabel jlPurchasesOrderLimit_n;
    private javax.swing.JLabel jlSalesDocLimit_n;
    private javax.swing.JLabel jlSalesOrderLimit_n;
    private javax.swing.JLabel jlUser;
    private javax.swing.JTextField jtfCapacityMassMinPer;
    private javax.swing.JTextField jtfCapacityVolumeMinPer;
    private javax.swing.JTextField jtfCurrencyKeyPurchasesDoc;
    private javax.swing.JTextField jtfCurrencyKeyPurchasesOrder;
    private javax.swing.JTextField jtfCurrencyKeySalesDoc;
    private javax.swing.JTextField jtfCurrencyKeySalesOrder;
    private javax.swing.JTextField jtfPurchasesDocLimit_n;
    private javax.swing.JTextField jtfPurchasesOrderLimit_n;
    private javax.swing.JTextField jtfSalesDocLimit_n;
    private javax.swing.JTextField jtfSalesOrderLimit_n;
    private javax.swing.JTextField jtfUser;
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

        moUserConfigurationTransaction = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        jtfCurrencyKeyPurchasesOrder.setText(miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
        jtfCurrencyKeyPurchasesDoc.setText(miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
        jtfCurrencyKeySalesOrder.setText(miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
        jtfCurrencyKeySalesDoc.setText(miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
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
        moUserConfigurationTransaction = (SDataUserConfigurationTransaction) registry;

        jtfUser.setText(moUserConfigurationTransaction.getDbmsUser());
        moFieldIsPurchasesItemAllApplying.setFieldValue(moUserConfigurationTransaction.getIsPurchasesItemAllApplying());
        moFieldPurchasesOrderLimit_n.setFieldValue(moUserConfigurationTransaction.getPurchasesOrderLimit_n());
        moFieldPurchasesDocLimit_n.setFieldValue(moUserConfigurationTransaction.getPurchasesDocLimit_n());
        moFieldIsSalesItemAllApplying.setFieldValue(moUserConfigurationTransaction.getIsSalesItemAllApplying());
        moFieldSalesOrderLimit_n.setFieldValue(moUserConfigurationTransaction.getSalesOrderLimit_n());
        moFieldSalesDocLimit_n.setFieldValue(moUserConfigurationTransaction.getSalesDocLimit_n());
        moFieldCapacityVolumeMinPercentage.setFieldValue(moUserConfigurationTransaction.getCapacityVolumeMinPercentage());
        moFieldCapacityMassMinPercentage.setFieldValue(moUserConfigurationTransaction.getCapacityMassMinPercentage());
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moUserConfigurationTransaction == null) {
            moUserConfigurationTransaction = new SDataUserConfigurationTransaction();
            moUserConfigurationTransaction.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moUserConfigurationTransaction.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moUserConfigurationTransaction.setIsPurchasesItemAllApplying(moFieldIsPurchasesItemAllApplying.getBoolean());
        moUserConfigurationTransaction.setPurchasesOrderLimit_n(moFieldPurchasesOrderLimit_n.getDouble() == 0 ? -1 : moFieldPurchasesOrderLimit_n.getDouble());
        moUserConfigurationTransaction.setPurchasesDocLimit_n(moFieldPurchasesDocLimit_n.getDouble() == 0 ? -1 : moFieldPurchasesDocLimit_n.getDouble());
        moUserConfigurationTransaction.setIsSalesItemAllApplying(moFieldIsSalesItemAllApplying.getBoolean());
        moUserConfigurationTransaction.setSalesOrderLimit_n(moFieldSalesOrderLimit_n.getDouble() == 0 ? -1 : moFieldSalesOrderLimit_n.getDouble());
        moUserConfigurationTransaction.setSalesDocLimit_n(moFieldSalesDocLimit_n.getDouble() == 0 ? -1 : moFieldSalesDocLimit_n.getDouble());
        moUserConfigurationTransaction.setCapacityVolumeMinPercentage(moFieldCapacityVolumeMinPercentage.getDouble());
        moUserConfigurationTransaction.setCapacityMassMinPercentage(moFieldCapacityMassMinPercentage.getDouble());

        return moUserConfigurationTransaction;
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
