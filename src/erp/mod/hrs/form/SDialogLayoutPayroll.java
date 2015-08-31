/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.mbps.data.SDataBizPartnerBranchBankAccount;
import erp.mfin.data.SDataAccountCash;
import erp.mod.SModConsts;
import erp.mod.bps.db.SDbBizPartner;
import erp.mod.fin.db.SFinConsts;
import erp.mod.fin.db.SFinUtils;
import erp.mod.hrs.db.SHrsConsts;
import erp.mod.hrs.db.SHrsUtils;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTextField;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiItem;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 *
 * @author Juan Barajas
 */
public class SDialogLayoutPayroll extends SBeanFormDialog implements FocusListener {

    public static Date moDateValueApplication;
    private erp.mfin.data.SDataAccountCash moDataAccountCash;
    private erp.mbps.data.SDataBizPartnerBranchBankAccount moDataBizPartnerBranchBankAccount;
    
    private int mnFkLayoutBankId;
    private String msAccountDebit;
    private int mnPayrollId;

    /**
     * Creates new form SDialogLayoutPayroll
     */

    public SDialogLayoutPayroll(SGuiClient client, int payrollId, String title) {
        setFormSettings(client, SModConsts.HRSX_PAY_LAY, SLibConsts.UNDEFINED, SLibConsts.UNDEFINED, title);
        mnPayrollId = payrollId;
        initComponents();
        initComponentsCustom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jlDateEmission = new javax.swing.JLabel();
        moDateEmission = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel7 = new javax.swing.JPanel();
        jlPkLayouId = new javax.swing.JLabel();
        moKeyLayoutId = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel13 = new javax.swing.JPanel();
        jlAccountDebit = new javax.swing.JLabel();
        moKeyAccountDebit = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel4 = new javax.swing.JPanel();
        jlAccountCurrencyId = new javax.swing.JLabel();
        jtfAccountCurrencyKey = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jlConsecutiveDay = new javax.swing.JLabel();
        moIntConsecutiveDay = new sa.lib.gui.bean.SBeanFieldInteger();

        setTitle("Layout para pagos de nóminas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(6, 1, 0, 5));

        jPanel11.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlDateEmission.setText("Fecha aplicación:*");
        jlDateEmission.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlDateEmission);
        jPanel11.add(moDateEmission);

        jPanel2.add(jPanel11);

        jPanel7.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlPkLayouId.setText("Layout: *");
        jlPkLayouId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlPkLayouId);

        moKeyLayoutId.setPreferredSize(new java.awt.Dimension(320, 23));
        jPanel7.add(moKeyLayoutId);

        jPanel2.add(jPanel7);

        jPanel13.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlAccountDebit.setText("Cuenta cargo: *");
        jlAccountDebit.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlAccountDebit);

        moKeyAccountDebit.setPreferredSize(new java.awt.Dimension(320, 23));
        moKeyAccountDebit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                moKeyAccountDebitItemStateChanged(evt);
            }
        });
        jPanel13.add(moKeyAccountDebit);

        jPanel2.add(jPanel13);

        jPanel4.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlAccountCurrencyId.setText("Moneda:");
        jlAccountCurrencyId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlAccountCurrencyId);

        jtfAccountCurrencyKey.setEditable(false);
        jtfAccountCurrencyKey.setText("CUR");
        jtfAccountCurrencyKey.setToolTipText("Moneda");
        jtfAccountCurrencyKey.setFocusable(false);
        jtfAccountCurrencyKey.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel4.add(jtfAccountCurrencyKey);

        jPanel2.add(jPanel4);

        jPanel14.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlConsecutiveDay.setText("Consecutivo día: *");
        jlConsecutiveDay.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlConsecutiveDay);
        jPanel14.add(moIntConsecutiveDay);

        jPanel2.add(jPanel14);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void moKeyAccountDebitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_moKeyAccountDebitItemStateChanged
       itemStateChangedAccountDebit();
    }//GEN-LAST:event_moKeyAccountDebitItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jlAccountCurrencyId;
    private javax.swing.JLabel jlAccountDebit;
    private javax.swing.JLabel jlConsecutiveDay;
    private javax.swing.JLabel jlDateEmission;
    private javax.swing.JLabel jlPkLayouId;
    private javax.swing.JTextField jtfAccountCurrencyKey;
    private sa.lib.gui.bean.SBeanFieldDate moDateEmission;
    private sa.lib.gui.bean.SBeanFieldInteger moIntConsecutiveDay;
    private sa.lib.gui.bean.SBeanFieldKey moKeyAccountDebit;
    private sa.lib.gui.bean.SBeanFieldKey moKeyLayoutId;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 480, 300);

        moDateValueApplication = miClient.getSession().getCurrentDate();

        jbSave.setText("Aceptar");

        moDateEmission.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEmission.getText()), true);
        moKeyLayoutId.setKeySettings(miClient, SGuiUtils.getLabelName(jlPkLayouId.getText()), true);
        moKeyAccountDebit.setKeySettings(miClient, SGuiUtils.getLabelName(jlAccountDebit.getText()), true);

        moFields.addField(moDateEmission);
        moFields.addField(moKeyLayoutId);
        moFields.addField(moKeyAccountDebit);

        moFields.setFormButton(jbSave);

        moDateEmission.setValue(miClient.getSession().getCurrentDate());

        removeAllListeners();
        reloadCatalogues();
        addAllListeners();
    }

    private void renderAccountSettings() {
        if (moKeyAccountDebit.getSelectedIndex() > 0) {
            if (moKeyAccountDebit.getValue()[0] > 0) {
                moDataAccountCash = (SDataAccountCash) SDataUtilities.readRegistry((SClientInterface) miClient, SDataConstants.FIN_ACC_CASH, moKeyAccountDebit.getValue(), SLibConstants.EXEC_MODE_SILENT);

                moDataBizPartnerBranchBankAccount = (SDataBizPartnerBranchBankAccount) SDataUtilities.readRegistry((SClientInterface) miClient, SDataConstants.BPSU_BANK_ACC, new int[] { moDataAccountCash.getFkBizPartnerBranchId_n(), moDataAccountCash.getFkBankAccountId_n() }, SLibConstants.EXEC_MODE_SILENT);
                jtfAccountCurrencyKey.setText(SDataReadDescriptions.getCatalogueDescription((SClientInterface) miClient, SDataConstants.CFGU_CUR, new int[] { moDataBizPartnerBranchBankAccount.getFkCurrencyId() }, SLibConstants.DESCRIPTION_CODE));
                msAccountDebit = moDataBizPartnerBranchBankAccount.getBankAccountNumber();
            }
            else {
                moDataBizPartnerBranchBankAccount = null;
                jtfAccountCurrencyKey.setText("");
            }
        }
    }
    
    private void populateLayoutBank() {
        Vector<SGuiItem> items = new Vector<SGuiItem>();

        items.add(new SGuiItem(new int[] { 0 }, "(" + SUtilConsts.TXT_SELECT + " layout)"));
        items.add(new SGuiItem(new int[] { SHrsConsts.LAY_BANK_BANBAJIO }, SHrsConsts.TXT_LAY_BANK_BANBAJIO));
        
        moKeyLayoutId.removeAllItems();
        for (SGuiItem item : items) {
            moKeyLayoutId.addItem(item);
        }
    }

    private void itemStateChangedAccountDebit() {
        renderAccountSettings();
    }

    public Date getDateEmission() { return moDateValueApplication; }

    public void setFormReset() {
        moDateEmission.setValue(miClient.getSession().getCurrentDate());
    }

    @Override
    public void reloadCatalogues() {
        populateLayoutBank();
        miClient.getSession().populateCatalogue(moKeyAccountDebit, SModConsts.FIN_ACC_CASH, SModConsts.FINX_ACC_CASH_BANK, null);
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        return validation;
    }
    
    @Override
    public void actionSave() {
        SDbBizPartner bizPartner = null;
        if (jbSave.isEnabled()) {
            if (SGuiUtils.computeValidation(miClient, validateForm())) {
                bizPartner = new SDbBizPartner();
                mnFkLayoutBankId = SFinUtils.getLayoutBankId(miClient.getSession(), moKeyLayoutId.getValue()[0]);
                
                if (mnFkLayoutBankId != moDataBizPartnerBranchBankAccount.getFkBankId()) {
                    try {
                        miClient.showMsgBoxWarning("El valor para el campo '" + jlAccountDebit.getText() + "', debe pertenecer al banco '" +
                                bizPartner.readField(miClient.getSession().getStatement(), new int[] { mnFkLayoutBankId }, SDbBizPartner.FIELD_NAME) + "'.");
                        moKeyAccountDebit.requestFocus();
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
                else {
                    switch (moKeyLayoutId.getValue()[0]) {
                       case SFinConsts.LAY_BANK_BANBAJIO:
                            SHrsUtils.createLayoutBanBajioPayroll(miClient, mnPayrollId, moKeyLayoutId.getSelectedItem().getItem(), moDateEmission.getValue(), msAccountDebit, moIntConsecutiveDay.getValue());
                           break;
                        default :
                            break;
                    }
                    mnFormResult = SGuiConsts.FORM_RESULT_OK;
                    dispose();
                }
            }
        }
    }

    @Override
    public void addAllListeners() {
        moDateEmission.getComponent().addFocusListener(this);
    }

    @Override
    public void removeAllListeners() {
        moDateEmission.getComponent().removeFocusListener(this);
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {

    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof javax.swing.JTextField) {
            JTextField textField = (JTextField) e.getSource();

            if (textField == moDateEmission.getComponent()) {
                moDateValueApplication = moDateEmission.getValue();
            }
        }
    }
}
