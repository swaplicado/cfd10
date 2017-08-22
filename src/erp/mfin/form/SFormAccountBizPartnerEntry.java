/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mfin.data.SDataAccount;
import erp.mfin.data.SDataAccountBizPartnerEntry;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;

/**
 *
 * @author  Sergio Flores
 */
public class SFormAccountBizPartnerEntry extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mfin.data.SDataAccountBizPartnerEntry moAccountBizPartnerEntry;
    private erp.lib.form.SFormField moFieldPercentage;
    private erp.lib.form.SFormField moFieldFkBookkeepingRegistryTypeId;
    private erp.mfin.form.SPanelAccount moPanelFkAccountId;
    private erp.mfin.form.SPanelAccount moPanelFkCostCenterId_n;

    /** Creates new form DFormAccountBizPartnerEntry */
    public SFormAccountBizPartnerEntry(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
        mnFormType = SDataConstants.FIN_ACC_BP_ETY;
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

        jpRegistry = new javax.swing.JPanel();
        jpAccounts = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlAccountBizPartner = new javax.swing.JLabel();
        jtfAccountBizPartner = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlAccountBizPartnerType = new javax.swing.JLabel();
        jtfAccountBizPartnerType = new javax.swing.JTextField();
        jpAccountsConfig = new javax.swing.JPanel();
        jpPanelAccounts = new javax.swing.JPanel();
        jlDummyAccount = new javax.swing.JLabel();
        jlDummyCostCenter_n = new javax.swing.JLabel();
        jpConfig = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlDummy = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jlFkBookkeepingRegistryTypeId = new javax.swing.JLabel();
        jcbFkBookkeepingRegistryTypeId = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel8 = new javax.swing.JPanel();
        jlPercentage = new javax.swing.JLabel();
        jtfPercentage = new javax.swing.JTextField();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle de cuentas contables para asociados de negocios"); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpRegistry.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpRegistry.setLayout(new java.awt.BorderLayout(0, 1));

        jpAccounts.setLayout(new java.awt.GridLayout(3, 1, 0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlAccountBizPartner.setText("Cuentas contables:");
        jlAccountBizPartner.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel4.add(jlAccountBizPartner);

        jtfAccountBizPartner.setEditable(false);
        jtfAccountBizPartner.setText("ACCOUNTS");
        jtfAccountBizPartner.setFocusable(false);
        jtfAccountBizPartner.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel4.add(jtfAccountBizPartner);

        jpAccounts.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlAccountBizPartnerType.setText("Tipo de cuentas contables:");
        jlAccountBizPartnerType.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel5.add(jlAccountBizPartnerType);

        jtfAccountBizPartnerType.setEditable(false);
        jtfAccountBizPartnerType.setText("ACCOUNTS TYPE");
        jtfAccountBizPartnerType.setFocusable(false);
        jtfAccountBizPartnerType.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel5.add(jtfAccountBizPartnerType);

        jpAccounts.add(jPanel5);

        jpRegistry.add(jpAccounts, java.awt.BorderLayout.NORTH);

        jpAccountsConfig.setLayout(new java.awt.BorderLayout(0, 1));

        jpPanelAccounts.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jlDummyAccount.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlDummyAccount.setText("[Panel cuenta contable]");
        jlDummyAccount.setPreferredSize(new java.awt.Dimension(100, 50));
        jpPanelAccounts.add(jlDummyAccount);

        jlDummyCostCenter_n.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlDummyCostCenter_n.setText("[Panel centro costo]");
        jlDummyCostCenter_n.setPreferredSize(new java.awt.Dimension(100, 50));
        jpPanelAccounts.add(jlDummyCostCenter_n);

        jpAccountsConfig.add(jpPanelAccounts, java.awt.BorderLayout.NORTH);

        jpConfig.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 1));
        jPanel1.add(jlDummy);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlFkBookkeepingRegistryTypeId.setText("Tipo de asiento contable: *");
        jlFkBookkeepingRegistryTypeId.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel9.add(jlFkBookkeepingRegistryTypeId);

        jcbFkBookkeepingRegistryTypeId.setEnabled(false);
        jcbFkBookkeepingRegistryTypeId.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel9.add(jcbFkBookkeepingRegistryTypeId);

        jPanel1.add(jPanel9);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlPercentage.setText("Porcentaje de asignación: *");
        jlPercentage.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel8.add(jlPercentage);

        jtfPercentage.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfPercentage.setText("0.00 %");
        jtfPercentage.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jtfPercentage);

        jPanel1.add(jPanel8);

        jpConfig.add(jPanel1, java.awt.BorderLayout.NORTH);

        jpAccountsConfig.add(jpConfig, java.awt.BorderLayout.CENTER);

        jpRegistry.add(jpAccountsConfig, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpRegistry, java.awt.BorderLayout.CENTER);

        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar"); // NOI18N
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbOk);

        jbCancel.setText("Cancelar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jpControls.add(jbCancel);

        getContentPane().add(jpControls, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-600)/2, (screenSize.height-400)/2, 600, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        try {
            moPanelFkAccountId = new SPanelAccount(miClient, SDataConstants.FIN_ACC, false, true, false);
            moPanelFkCostCenterId_n = new SPanelAccount(miClient, SDataConstants.FIN_CC, false, false, false);
        }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }

        jpPanelAccounts.remove(jlDummyAccount);
        jpPanelAccounts.remove(jlDummyCostCenter_n);
        jpPanelAccounts.add(moPanelFkAccountId);
        jpPanelAccounts.add(moPanelFkCostCenterId_n);

        moFieldPercentage = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, true, jtfPercentage, jlPercentage);
        moFieldPercentage.setIsPercent(true);
        moFieldPercentage.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat());
        moFieldFkBookkeepingRegistryTypeId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkBookkeepingRegistryTypeId, jlFkBookkeepingRegistryTypeId);

        mvFields = new Vector<SFormField>();
        mvFields.add(moFieldPercentage);
        mvFields.add(moFieldFkBookkeepingRegistryTypeId);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionCancel, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            if (moPanelFkAccountId.getFieldAccount().getComponent().isEnabled()) {
                moPanelFkAccountId.getFieldAccount().getComponent().requestFocus();
            }
            else if (jcbFkBookkeepingRegistryTypeId.isEnabled()) {
                jcbFkBookkeepingRegistryTypeId.requestFocus();
            }
            else {
                jtfPercentage.requestFocus();
            }
        }
    }

    private void actionEdit(boolean edit) {

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkBookkeepingRegistryTypeId;
    private javax.swing.JLabel jlAccountBizPartner;
    private javax.swing.JLabel jlAccountBizPartnerType;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JLabel jlDummyAccount;
    private javax.swing.JLabel jlDummyCostCenter_n;
    private javax.swing.JLabel jlFkBookkeepingRegistryTypeId;
    private javax.swing.JLabel jlPercentage;
    private javax.swing.JPanel jpAccounts;
    private javax.swing.JPanel jpAccountsConfig;
    private javax.swing.JPanel jpConfig;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpPanelAccounts;
    private javax.swing.JPanel jpRegistry;
    private javax.swing.JTextField jtfAccountBizPartner;
    private javax.swing.JTextField jtfAccountBizPartnerType;
    private javax.swing.JTextField jtfPercentage;
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

        moAccountBizPartnerEntry = null;

        for (SFormField field : mvFields) {
            field.resetField();
        }

        jtfAccountBizPartner.setText("");
        jtfAccountBizPartnerType.setText("");

        moPanelFkAccountId.resetPanel();
        moPanelFkCostCenterId_n.resetPanel();
        moFieldFkBookkeepingRegistryTypeId.setFieldValue(new int[] { SDataConstantsSys.FINS_TP_BKR_ALL });
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbFkBookkeepingRegistryTypeId, SDataConstants.FINS_TP_BKR);
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        int nSystemTypeId = SDataConstantsSys.FINS_TP_ACC_SYS_NA;
        String message = "";
        SDataAccount account = null;
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(mvFields.get(i).getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            // Validate account:

            account = moPanelFkAccountId.getCurrentInputAccount();
            message = SDataUtilities.validateAccount(miClient, account, null);

            if (message.length() > 0) {
                validation.setMessage(message);
                validation.setComponent(moPanelFkAccountId.getFieldAccount().getComponent());
            }
            else {
                // Validate account system type:

                if (account.getLevel() == 1) {
                    nSystemTypeId = account.getFkAccountSystemTypeId();
                }
                else {
                    nSystemTypeId = moPanelFkAccountId.getDataAccountMajor().getFkAccountSystemTypeId();
                }

                switch (moAccountBizPartnerEntry.getPkAccountBizPartnerTypeId()) {
                    case SDataConstantsSys.FINS_TP_ACC_BP_OP:
                        if (nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_SUP &&
                            nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_CUS) {
                            message = "'" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_SUP }) + "'";
                            message += " o '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_CUS }) + "'";
                        }
                        break;

                    case SDataConstantsSys.FINS_TP_ACC_BP_PAY:
                        if (nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_SUP &&
                            nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_CUS &&
                            nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_CDR &&
                            nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_DBR) {
                            message = "'" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_SUP }) + "'";
                            message += " o '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_CUS }) + "'";
                            message += " o '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_CDR }) + "'";
                            message += " o '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_DBR }) + "'";
                        }
                        break;

                    case SDataConstantsSys.FINS_TP_ACC_BP_ADV_BILL:
                        if (nSystemTypeId != SDataConstantsSys.FINS_TP_ACC_SYS_NA) {
                            message = "'" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_SYS, new int[] { SDataConstantsSys.FINS_TP_ACC_SYS_NA }) + "'";
                        }
                        break;

                    default:
                        message = SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION;
                }

                if (message.length() > 0) {
                    validation.setMessage("El tipo de cuenta de sistema de la cuenta contable deber ser:\n" + message + ".");
                    validation.setComponent(moPanelFkAccountId.getFieldAccount().getComponent());
                }
                else {
                    if (!moPanelFkCostCenterId_n.isEmptyAccountId()) {
                        // Cost center has been specified and must be validated:

                        message = SDataUtilities.validateCostCenter(miClient, moPanelFkCostCenterId_n.getCurrentInputCostCenter(), null);

                        if (message.length() > 0) {
                            validation.setMessage(message);
                            validation.setComponent(moPanelFkCostCenterId_n.getFieldAccount().getComponent());
                        }
                    }
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
        moAccountBizPartnerEntry = (SDataAccountBizPartnerEntry) registry;

        jtfAccountBizPartner.setText(moAccountBizPartnerEntry.getDbmsAccountBizPartner());
        jtfAccountBizPartnerType.setText(moAccountBizPartnerEntry.getDbmsAccountBizPartnerType());

        moFieldPercentage.setFieldValue(moAccountBizPartnerEntry.getPercentage());
        moFieldFkBookkeepingRegistryTypeId.setFieldValue(new int[] { moAccountBizPartnerEntry.getFkBookkeepingRegistryTypeId() });
        moPanelFkAccountId.getFieldAccount().setFieldValue(moAccountBizPartnerEntry.getFkAccountId());
        moPanelFkCostCenterId_n.getFieldAccount().setFieldValue(moAccountBizPartnerEntry.getFkCostCenterId_n().length() == 0 ? moPanelFkCostCenterId_n.getEmptyAccountId() : moAccountBizPartnerEntry.getFkCostCenterId_n());

        moPanelFkAccountId.refreshPanel();
        moPanelFkCostCenterId_n.refreshPanel();
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moAccountBizPartnerEntry == null) {
            miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_FORM_EDIT_ONLY);
        }
        else {
            moAccountBizPartnerEntry.setPercentage(moFieldPercentage.getDouble());
            moAccountBizPartnerEntry.setFkAccountId(moPanelFkAccountId.getFieldAccount().getString());
            moAccountBizPartnerEntry.setFkCostCenterId_n(moPanelFkCostCenterId_n.getFieldAccount().getString());
            moAccountBizPartnerEntry.setFkBookkeepingRegistryTypeId(moFieldFkBookkeepingRegistryTypeId.getKeyAsIntArray()[0]);

            moAccountBizPartnerEntry.setDbmsAccount(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FIN_ACC, new Object[] { moAccountBizPartnerEntry.getFkAccountId() }));
            moAccountBizPartnerEntry.setDbmsCostCenter_n(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FIN_CC, new Object[] { moAccountBizPartnerEntry.getFkCostCenterId_n() }));
            moAccountBizPartnerEntry.setDbmsBookkeepingRegistryType(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_BKR, new int[] { moAccountBizPartnerEntry.getFkBookkeepingRegistryTypeId() }));
        }

        return moAccountBizPartnerEntry;
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
            JButton button = (JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
        }
    }
}