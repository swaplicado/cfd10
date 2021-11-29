/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.fin.form;

import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.mfin.data.SDataRecord;
import erp.mfin.form.SDialogRecordPicker;
import erp.mod.SModConsts;
import erp.mod.fin.db.SFinConsts;
import erp.mod.fin.db.SValuationBalances;
import erp.redis.SRedisLockUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sa.lib.SLibConsts;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFormDialog;
import sa.lib.srv.SSrvLock;
import sa.lib.srv.SSrvUtils;
import sa.lib.srv.redis.SRedisLock;

/**
 *
 * @author Gerardo Hernández, Uriel Castañeda, Isabel Servín
 */
public class SDialogValuationBalances extends SBeanFormDialog implements ActionListener, ItemListener, ChangeListener {

    private erp.mfin.form.SDialogRecordPicker moDialogRecordPicker;
    private erp.mfin.data.SDataRecord moRecord;
    private Date mtEndOfMonth;
    
    /**
     * Creates new form SDialogValuationBalances
     * @param client
     * @param title
     */
    public SDialogValuationBalances(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SLibConsts.UNDEFINED, SLibConsts.UNDEFINED, title);
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
        jPanel10 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        moCalYear = new sa.lib.gui.bean.SBeanFieldCalendarYear();
        jPanel12 = new javax.swing.JPanel();
        jlPeriod = new javax.swing.JLabel();
        moCalPeriod = new sa.lib.gui.bean.SBeanFieldCalendarMonth();
        jPanel13 = new javax.swing.JPanel();
        jlCurrency = new javax.swing.JLabel();
        moKeyCurrency = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel14 = new javax.swing.JPanel();
        jlExchangeRate = new javax.swing.JLabel();
        moCurExchangeRate = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlRecord = new javax.swing.JLabel();
        moTextRecordDate = new sa.lib.gui.bean.SBeanFieldText();
        moTextRecordBkc = new sa.lib.gui.bean.SBeanFieldText();
        moTextRecordNumber = new sa.lib.gui.bean.SBeanFieldText();
        jbPickRecord = new javax.swing.JButton();
        moTextRecordBranch = new sa.lib.gui.bean.SBeanFieldText();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros para revaluar saldos:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(211, 130));
        jPanel2.setName(""); // NOI18N
        jPanel2.setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jPanel10.setMinimumSize(new java.awt.Dimension(211, 20));
        jPanel10.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlYear.setText("Año:*");
        jlYear.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel10.add(jlYear);
        jPanel10.add(moCalYear);

        jPanel2.add(jPanel10);

        jPanel12.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel12.setRequestFocusEnabled(false);
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriod.setText("Mes de corte:*");
        jlPeriod.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlPeriod);
        jPanel12.add(moCalPeriod);

        jPanel2.add(jPanel12);

        jPanel13.setMinimumSize(new java.awt.Dimension(211, 25));
        jPanel13.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCurrency.setText("Moneda:*");
        jlCurrency.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlCurrency);

        moKeyCurrency.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel13.add(moKeyCurrency);

        jPanel2.add(jPanel13);

        jPanel14.setMinimumSize(new java.awt.Dimension(211, 25));
        jPanel14.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlExchangeRate.setText("Tipo cambio:*");
        jlExchangeRate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlExchangeRate);

        moCurExchangeRate.setCompoundText("MXN");
        jPanel14.add(moCurExchangeRate);

        jLabel2.setForeground(java.awt.SystemColor.textInactiveText);
        jLabel2.setText("(Al último día del mes de corte.)");
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel14.add(jLabel2);

        jPanel2.add(jPanel14);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlRecord.setText("Póliza contable:*");
        jlRecord.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlRecord);

        moTextRecordDate.setEditable(false);
        moTextRecordDate.setText("01/01/2000");
        moTextRecordDate.setToolTipText("Fecha de la póliza contable");
        moTextRecordDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel11.add(moTextRecordDate);

        moTextRecordBkc.setEditable(false);
        moTextRecordBkc.setText("BKC");
        moTextRecordBkc.setToolTipText("Centro contable de la póliza contable");
        moTextRecordBkc.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel11.add(moTextRecordBkc);

        moTextRecordNumber.setEditable(false);
        moTextRecordNumber.setText("TP-000001");
        moTextRecordNumber.setToolTipText("Número de la póliza contable");
        jPanel11.add(moTextRecordNumber);

        jbPickRecord.setText("...");
        jbPickRecord.setToolTipText("Seleccionar póliza contable");
        jbPickRecord.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel11.add(jbPickRecord);

        moTextRecordBranch.setEditable(false);
        moTextRecordBranch.setText("BRA");
        moTextRecordBranch.setToolTipText("Sucursal de la empresa");
        moTextRecordBranch.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel11.add(moTextRecordBranch);

        jPanel2.add(jPanel11);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel1.setForeground(java.awt.SystemColor.textInactiveText);
        jLabel1.setText("NOTA: se ajustarán todas las cuentas con saldo hasta la fecha de corte.");
        jLabel1.setPreferredSize(new java.awt.Dimension(450, 23));
        jPanel3.add(jLabel1);

        jPanel2.add(jPanel3);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel3.setForeground(java.awt.SystemColor.textInactiveText);
        jLabel3.setText("NOTA 2: se afectarán cuentas de dinero y cuentas de asociados de negocios.");
        jLabel3.setPreferredSize(new java.awt.Dimension(450, 23));
        jPanel15.add(jLabel3);

        jPanel2.add(jPanel15);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleName("Parámetros de valuación de saldos:");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbPickRecord;
    private javax.swing.JLabel jlCurrency;
    private javax.swing.JLabel jlExchangeRate;
    private javax.swing.JLabel jlPeriod;
    private javax.swing.JLabel jlRecord;
    private javax.swing.JLabel jlYear;
    private sa.lib.gui.bean.SBeanFieldCalendarMonth moCalPeriod;
    private sa.lib.gui.bean.SBeanFieldCalendarYear moCalYear;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency moCurExchangeRate;
    private sa.lib.gui.bean.SBeanFieldKey moKeyCurrency;
    private sa.lib.gui.bean.SBeanFieldText moTextRecordBkc;
    private sa.lib.gui.bean.SBeanFieldText moTextRecordBranch;
    private sa.lib.gui.bean.SBeanFieldText moTextRecordDate;
    private sa.lib.gui.bean.SBeanFieldText moTextRecordNumber;
    // End of variables declaration//GEN-END:variables

    /*
     * Private methods
     */
    
    private void initComponentsCustom() {
        int[] period = SLibTimeUtils.digestMonth(miClient.getSession().getCurrentDate());
        
        SGuiUtils.setWindowBounds(this, 480, 300);
        
        try {
            validateCompanyConfig();
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
            actionCancel();
        }
        
        moDialogRecordPicker = new SDialogRecordPicker((SClientInterface) miClient, SDataConstants.FINX_REC_USER);
        
        moCalYear.setCalendarSettings(SGuiUtils.getLabelName(jlYear));
        moCalPeriod.setCalendarSettings(SGuiUtils.getLabelName(jlPeriod));
        moKeyCurrency.setKeySettings(miClient, SGuiUtils.getLabelName(jlCurrency.getText()), true);
        moCurExchangeRate.setCompoundFieldSettings(miClient);
        moCurExchangeRate.getField().setDecimalSettings(SGuiUtils.getLabelName(jlExchangeRate.getText()), SGuiConsts.GUI_TYPE_DEC_EXC_RATE, true);
        moCurExchangeRate.getField().setValue(0d);
        
        moFields.addField(moCalYear);
        moFields.addField(moCalPeriod);
        moFields.addField(moKeyCurrency);
        moFields.addField(moCurExchangeRate.getField());
        moFields.setFormButton(jbSave);
        
        moCalYear.setValue(period[0]);
        moCalPeriod.setValue(period[1]);
        defineDate();
        
        reloadCatalogues();
        
        renderRecord();
        
        addAllListeners();
    }
    
    private void validateCompanyConfig() throws Exception {
        if (!SDataUtilities.validateAccountSyntax(((SClientInterface) miClient).getSessionXXX().getParamsCompany().getFkAccountDifferenceIncomeId_n())) {
            throw new Exception(SFinConsts.MSG_ERR_GUI_CFG_DIFF_ACC);
        }
        else if (!SDataUtilities.validateAccountSyntax(((SClientInterface) miClient).getSessionXXX().getParamsCompany().getFkCostCenterDifferenceIncomeId_n())) {
            throw new Exception(SFinConsts.MSG_ERR_GUI_CFG_DIFF_CC);
        }
    }
    
    private void defineDate() {
        mtEndOfMonth = SLibTimeUtils.getEndOfMonth(SLibTimeUtils.createDate(moCalYear.getValue(), moCalPeriod.getValue()));
    }
    
    private void renderRecord() {
        if (moRecord == null) {
            moTextRecordDate.setValue("");
            moTextRecordBkc.setValue("");
            moTextRecordNumber.setValue("");
            moTextRecordBranch.setValue("");
          }
        else {
            moTextRecordDate.setValue(SLibUtils.DateFormatDate.format(moRecord.getDate()));
            moTextRecordBkc.setValue(SDataReadDescriptions.getCatalogueDescription(
                    (SClientInterface) miClient, SDataConstants.FIN_BKC, new int[] { moRecord.getPkBookkeepingCenterId() }, SLibConstants.DESCRIPTION_CODE));
            moTextRecordNumber.setValue(moRecord.getRecordNumber());
            moTextRecordBranch.setValue(SDataReadDescriptions.getCatalogueDescription(
                    (SClientInterface) miClient, SDataConstants.BPSU_BPB, new int[] { moRecord.getFkCompanyBranchId() }, SLibConstants.DESCRIPTION_CODE));
        }
    }

    private void actionPerformedPickRecord() {
        String message = "";
        
        moDialogRecordPicker.formReset();
        moDialogRecordPicker.setFilterKey(mtEndOfMonth);
        moDialogRecordPicker.formRefreshOptionPane();
        if (moRecord != null) {
            moDialogRecordPicker.setSelectedPrimaryKey(moRecord.getPrimaryKey());
        }
        moDialogRecordPicker.setFormVisible(true);
        
        if (moDialogRecordPicker.getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moRecord = (SDataRecord) SDataUtilities.readRegistry(
                    (SClientInterface) miClient, SDataConstants.FIN_REC, moDialogRecordPicker.getSelectedPrimaryKey(), SLibConstants.EXEC_MODE_VERBOSE);
                    
            if (moRecord != null) {
                if (moRecord.getIsSystem()) {
                    message = "No puede seleccionarse esta póliza contable porque es de sistema.";
                }
                else if (moRecord.getIsAudited()) {
                    message = "No puede seleccionarse esta póliza contable porque está auditada.";
                }
                else if (moRecord.getIsAuthorized()) {
                    message = "No puede seleccionarse esta póliza contable porque está autorizada.";
                }
                else if (!SDataUtilities.isPeriodOpen((SClientInterface) miClient, moRecord.getDate())) {
                    message = "No puede seleccionarse esta póliza contable porque su período contable correspondiente está cerrado.";
                }

                if (!message.isEmpty()) {
                    miClient.showMsgBoxWarning(message);
                    moRecord = null;
                }
                else {
                    renderRecord();
                }
            }
        }
    }

    private void itemStateChangedCurrency() {
        double exchangeRate = 0;

        if (moKeyCurrency.getSelectedIndex() > 0) {
            try {
                exchangeRate = SDataUtilities.obtainExchangeRate((SClientInterface) miClient, moKeyCurrency.getValue()[0], mtEndOfMonth);
            }
            catch (Exception e) {
                SLibUtils.showException(this, e);
            }
        }
        
        moCurExchangeRate.getField().setValue(exchangeRate);
    }
    
    private void stateChangedYear() {
        defineDate();
    }
    
    private void stateChangedPeriod() {
        defineDate();
    }
    
    /*
     * Public methods
     */
    
    /*
     * Implemented and overriden methods
     */
    
    @Override
    public void addAllListeners() {
        jbPickRecord.addActionListener(this);
        moKeyCurrency.addItemListener(this);
        moCalYear.addChangeListener(this);
        moCalPeriod.addChangeListener(this);
    }

    @Override
    public void removeAllListeners() {
        jbPickRecord.removeActionListener(this);
        moKeyCurrency.removeItemListener(this);
        moCalYear.getModel().removeChangeListener(null);
        moCalPeriod.getModel().removeChangeListener(null);
    }

    @Override
    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyCurrency, SModConsts.CFGU_CUR, SLibConsts.UNDEFINED, null);
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        if (validation.isValid()) {
            if (miClient.getSession().getSessionCustom().isLocalCurrency(moKeyCurrency.getValue())) {
                validation.setMessage(SGuiConsts.ERR_MSG_FIELD_DIF + "'" + SGuiUtils.getLabelName(jlCurrency) + "'.");
                validation.setComponent(moKeyCurrency);
            }
            else if (moRecord == null) {
                validation.setMessage(SGuiConsts.ERR_MSG_FIELD_REQ + "'" + SGuiUtils.getLabelName(jlRecord) + "'.");
                validation.setComponent(jbPickRecord);
            }
            else if (moRecord.getPkYearId() != moCalYear.getValue()){
                validation.setMessage(SGuiConsts.ERR_MSG_FIELD_DATE_ + "'" + SGuiUtils.getLabelName(jlRecord) + "' " + 
                        SGuiConsts.ERR_MSG_FIELD_DATE_EQUAL + " " + SLibUtils.DecimalFormatCalendarYear.format(moCalYear.getValue()) + ".");
                validation.setComponent(jbPickRecord);
            }
            else if (moRecord.getPkPeriodId() != moCalPeriod.getValue()){
                validation.setMessage(SGuiConsts.ERR_MSG_FIELD_DATE_ + "'" + SGuiUtils.getLabelName(jlRecord) + "' " + 
                        SGuiConsts.ERR_MSG_FIELD_DATE_EQUAL + " " + SLibUtils.DecimalFormatCalendarMonth.format(moCalPeriod.getValue()) + ".");
                validation.setComponent(jbPickRecord);
            }
        }
        
        return validation;
    }

    @Override
    public void actionSave() {
        String msg;
        SSrvLock lock = null;
        SRedisLock rlock = null;
        
        SValuationBalances sbe;
        
        if (SGuiUtils.computeValidation(miClient, validateForm())) {
            msg = "Se realizará la revaluación de saldos con los siguientes parámetros:\n"
                    + "- fecha de corte: " + SLibUtils.DateFormatDate.format(mtEndOfMonth) + "\n"
                    + "- " + SGuiUtils.getLabelName(jlCurrency) + ": " + moKeyCurrency.getSelectedItem().getItem() + "\n"
                    + "- " + SGuiUtils.getLabelName(jlExchangeRate) + ": " +  SLibUtils.getDecimalFormatExchangeRate().format(moCurExchangeRate.getField().getValue()) + "\n" +
                    SGuiConsts.MSG_CNF_CONT;
            
            if (miClient.showMsgBoxConfirm(msg) == JOptionPane.YES_OPTION) {
                try {
                    lock = SSrvUtils.gainLock(miClient.getSession(), ((SClientInterface) miClient).getSessionXXX().getCompany().getPkCompanyId(), SDataConstants.FIN_REC, moRecord.getPrimaryKey(), moRecord.getRegistryTimeout());
                    rlock = SRedisLockUtils.gainLock((SClientInterface) miClient, SDataConstants.FIN_REC, moRecord.getPrimaryKey(), moRecord.getRegistryTimeout() / 1000);
                    
                    sbe = new SValuationBalances(miClient);
                    sbe.setRecYear(moCalYear.getValue());
                    sbe.setRecPeriod(moCalPeriod.getValue());
                    sbe.setEndOfMonth(mtEndOfMonth);
                    sbe.setCurrencyId(moKeyCurrency.getValue()[0]);
                    sbe.setExchangeRate(moCurExchangeRate.getField().getValue());
                    sbe.setRecord(moRecord);
                    sbe.save();
                    
                    miClient.showMsgBoxInformation(SLibConsts.MSG_PROCESS_FINISHED);
                    
                    mnFormResult = SGuiConsts.FORM_RESULT_OK;
                    dispose();
                }
                catch (Exception e) {
                    SLibUtils.showException(this, e);
                }
                finally {
                    try {
                        if (lock != null) {
                            SSrvUtils.releaseLock(miClient.getSession(), lock);
                        }
                        if (rlock != null) {
                            SRedisLockUtils.releaseLock((SClientInterface) miClient, rlock);
                        }
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            
            if (button == jbPickRecord) {
                actionPerformedPickRecord();
            }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JComboBox) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JComboBox comboBox = (JComboBox) e.getSource();
                
                if (comboBox == moKeyCurrency) {
                    itemStateChangedCurrency();
                }
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof sa.lib.gui.bean.SBeanFieldCalendarMonth) {
            sa.lib.gui.bean.SBeanFieldCalendarMonth sBeanCalMonth = (sa.lib.gui.bean.SBeanFieldCalendarMonth) e.getSource();
            
            if (sBeanCalMonth == moCalPeriod) {
                stateChangedPeriod();
            }
        }
        
        if (e.getSource() instanceof sa.lib.gui.bean.SBeanFieldCalendarYear) {
            sa.lib.gui.bean.SBeanFieldCalendarYear sBeanCalYear = (sa.lib.gui.bean.SBeanFieldCalendarYear) e.getSource();
            
            if (sBeanCalYear == moCalYear) {
                stateChangedYear();
            }
        }    
    }
}
