/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SDbLoan;
import erp.mod.hrs.db.SHrsConsts;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFieldRadio;
import sa.lib.gui.bean.SBeanForm;

/**
 *
 * @author Juan Barajas
 */
public class SFormLoan extends SBeanForm implements ItemListener, ChangeListener {
    
    private SDbLoan moRegistry;

    /**
     * Creates new form SFormLoan
     * @param client
     * @param title
     */
    public SFormLoan(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.HRS_LOAN, SLibConsts.UNDEFINED, title);
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

        moRadGroupSalaryType = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jlEmployee = new javax.swing.JLabel();
        moKeyEmployee = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel7 = new javax.swing.JPanel();
        jlLoanType = new javax.swing.JLabel();
        moKeyLoanType = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel12 = new javax.swing.JPanel();
        jlLoanPaymentType = new javax.swing.JLabel();
        moKeyLoanPaymentType = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel6 = new javax.swing.JPanel();
        jlNumber = new javax.swing.JLabel();
        moTextNumber = new sa.lib.gui.bean.SBeanFieldText();
        jPanel4 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moDateDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel5 = new javax.swing.JPanel();
        jlDateEnd_n = new javax.swing.JLabel();
        moDateDateEnd_n = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel3 = new javax.swing.JPanel();
        jlCapital = new javax.swing.JLabel();
        moDecCapital = new sa.lib.gui.bean.SBeanFieldDecimal();
        jPanel8 = new javax.swing.JPanel();
        jlTotalAmount = new javax.swing.JLabel();
        moDecTotalAmount = new sa.lib.gui.bean.SBeanFieldDecimal();
        jPanel9 = new javax.swing.JPanel();
        jlPaymentAmount = new javax.swing.JLabel();
        moDecPaymentAmount = new sa.lib.gui.bean.SBeanFieldDecimal();
        jlExemptionSalaryEqualsMwzPercentageHelp = new javax.swing.JLabel();
        jlHelp = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jlPaymentFixed = new javax.swing.JLabel();
        moDecPaymentFixed = new sa.lib.gui.bean.SBeanFieldDecimal();
        jlExemptionSalaryEqualsMwzPercentageHelp1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlPaymentPercentage = new javax.swing.JLabel();
        moDecPaymentPercentage = new sa.lib.gui.bean.SBeanFieldDecimal();
        jlExemptionSalaryEqualsMwzPercentageHelp2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        moRadSd = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadSbc = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadOther = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel15 = new javax.swing.JPanel();
        jlSalaryOther = new javax.swing.JLabel();
        moDecSalaryOther = new sa.lib.gui.bean.SBeanFieldDecimal();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(13, 1, 0, 5));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlEmployee.setForeground(new java.awt.Color(0, 0, 255));
        jlEmployee.setText("Empleado:*");
        jlEmployee.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel13.add(jlEmployee);

        moKeyEmployee.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel13.add(moKeyEmployee);

        jPanel2.add(jPanel13);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlLoanType.setText("Tipo crédito/préstamo:*");
        jlLoanType.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel7.add(jlLoanType);

        moKeyLoanType.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel7.add(moKeyLoanType);

        jPanel2.add(jPanel7);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlLoanPaymentType.setText("Tipo pago:*");
        jlLoanPaymentType.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel12.add(jlLoanPaymentType);

        moKeyLoanPaymentType.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel12.add(moKeyLoanPaymentType);

        jPanel2.add(jPanel12);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNumber.setText("Número o folio:*");
        jlNumber.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel6.add(jlNumber);

        moTextNumber.setText("sBeanFieldText2");
        jPanel6.add(moTextNumber);

        jPanel2.add(jPanel6);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial:*");
        jlDateStart.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel4.add(jlDateStart);

        moDateDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(moDateDateStart);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd_n.setText("Fecha final:");
        jlDateEnd_n.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel5.add(jlDateEnd_n);

        moDateDateEnd_n.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(moDateDateEnd_n);

        jPanel2.add(jPanel5);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCapital.setText("Capital:*");
        jlCapital.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel3.add(jlCapital);
        jPanel3.add(moDecCapital);

        jPanel2.add(jPanel3);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTotalAmount.setText("Total a pagar:*");
        jlTotalAmount.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel8.add(jlTotalAmount);
        jPanel8.add(moDecTotalAmount);

        jPanel2.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPaymentAmount.setText("Monto:");
        jlPaymentAmount.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel9.add(jlPaymentAmount);
        jPanel9.add(moDecPaymentAmount);

        jlExemptionSalaryEqualsMwzPercentageHelp.setForeground(new java.awt.Color(109, 109, 109));
        jlExemptionSalaryEqualsMwzPercentageHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlExemptionSalaryEqualsMwzPercentageHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_view_help.png"))); // NOI18N
        jlExemptionSalaryEqualsMwzPercentageHelp.setToolTipText("Monto a pagar");
        jlExemptionSalaryEqualsMwzPercentageHelp.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel9.add(jlExemptionSalaryEqualsMwzPercentageHelp);

        jlHelp.setForeground(java.awt.Color.lightGray);
        jlHelp.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel9.add(jlHelp);

        jPanel2.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPaymentFixed.setText("Salarios mínimos:");
        jlPaymentFixed.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel10.add(jlPaymentFixed);
        jPanel10.add(moDecPaymentFixed);

        jlExemptionSalaryEqualsMwzPercentageHelp1.setForeground(new java.awt.Color(109, 109, 109));
        jlExemptionSalaryEqualsMwzPercentageHelp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlExemptionSalaryEqualsMwzPercentageHelp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_view_help.png"))); // NOI18N
        jlExemptionSalaryEqualsMwzPercentageHelp1.setToolTipText("Monto a pagar expresado en número de salarios mínimos del área geográfica de referencia");
        jlExemptionSalaryEqualsMwzPercentageHelp1.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel10.add(jlExemptionSalaryEqualsMwzPercentageHelp1);

        jPanel2.add(jPanel10);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPaymentPercentage.setText("Porcentaje salario base:");
        jlPaymentPercentage.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel11.add(jlPaymentPercentage);
        jPanel11.add(moDecPaymentPercentage);

        jlExemptionSalaryEqualsMwzPercentageHelp2.setForeground(new java.awt.Color(109, 109, 109));
        jlExemptionSalaryEqualsMwzPercentageHelp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlExemptionSalaryEqualsMwzPercentageHelp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_view_help.png"))); // NOI18N
        jlExemptionSalaryEqualsMwzPercentageHelp2.setToolTipText("Monto a pagar expresado en porcentaje del salario base de cotización a pagar");
        jlExemptionSalaryEqualsMwzPercentageHelp2.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel11.add(jlExemptionSalaryEqualsMwzPercentageHelp2);

        jPanel2.add(jPanel11);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moRadGroupSalaryType.add(moRadSd);
        moRadSd.setText("SD");
        jPanel14.add(moRadSd);

        moRadGroupSalaryType.add(moRadSbc);
        moRadSbc.setText("SBC");
        jPanel14.add(moRadSbc);

        moRadGroupSalaryType.add(moRadOther);
        moRadOther.setText("Otro");
        jPanel14.add(moRadOther);

        jPanel2.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlSalaryOther.setText("Salario referencia:");
        jlSalaryOther.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel15.add(jlSalaryOther);
        jPanel15.add(moDecSalaryOther);

        jPanel2.add(jPanel15);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jlCapital;
    private javax.swing.JLabel jlDateEnd_n;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlEmployee;
    private javax.swing.JLabel jlExemptionSalaryEqualsMwzPercentageHelp;
    private javax.swing.JLabel jlExemptionSalaryEqualsMwzPercentageHelp1;
    private javax.swing.JLabel jlExemptionSalaryEqualsMwzPercentageHelp2;
    private javax.swing.JLabel jlHelp;
    private javax.swing.JLabel jlLoanPaymentType;
    private javax.swing.JLabel jlLoanType;
    private javax.swing.JLabel jlNumber;
    private javax.swing.JLabel jlPaymentAmount;
    private javax.swing.JLabel jlPaymentFixed;
    private javax.swing.JLabel jlPaymentPercentage;
    private javax.swing.JLabel jlSalaryOther;
    private javax.swing.JLabel jlTotalAmount;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateEnd_n;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateStart;
    private sa.lib.gui.bean.SBeanFieldDecimal moDecCapital;
    private sa.lib.gui.bean.SBeanFieldDecimal moDecPaymentAmount;
    private sa.lib.gui.bean.SBeanFieldDecimal moDecPaymentFixed;
    private sa.lib.gui.bean.SBeanFieldDecimal moDecPaymentPercentage;
    private sa.lib.gui.bean.SBeanFieldDecimal moDecSalaryOther;
    private sa.lib.gui.bean.SBeanFieldDecimal moDecTotalAmount;
    private sa.lib.gui.bean.SBeanFieldKey moKeyEmployee;
    private sa.lib.gui.bean.SBeanFieldKey moKeyLoanPaymentType;
    private sa.lib.gui.bean.SBeanFieldKey moKeyLoanType;
    private javax.swing.ButtonGroup moRadGroupSalaryType;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOther;
    private sa.lib.gui.bean.SBeanFieldRadio moRadSbc;
    private sa.lib.gui.bean.SBeanFieldRadio moRadSd;
    private sa.lib.gui.bean.SBeanFieldText moTextNumber;
    // End of variables declaration//GEN-END:variables

    public void actionEnableFields() {
        moDecSalaryOther.setEditable(false);
        moDecSalaryOther.setValue(0d);
        
        if (moRadOther.isEnabled() && moRadOther.isSelected()) {
            moDecSalaryOther.setEditable(true);
        }
    }
    
    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 720, 450);

        moKeyEmployee.setKeySettings(miClient, SGuiUtils.getLabelName(jlEmployee.getText()), true);
        moKeyLoanType.setKeySettings(miClient, SGuiUtils.getLabelName(jlLoanType.getText()), true);
        moKeyLoanPaymentType.setKeySettings(miClient, SGuiUtils.getLabelName(jlLoanPaymentType.getText()), true);
        moTextNumber.setTextSettings(SGuiUtils.getLabelName(jlNumber.getText()), 25);
        moDateDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart.getText()), true);
        moDateDateEnd_n.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd_n.getText()), false);
        moDecCapital.setDecimalSettings(SGuiUtils.getLabelName(jlCapital.getText()), SGuiConsts.GUI_TYPE_DEC_QTY, true);
        moDecTotalAmount.setDecimalSettings(SGuiUtils.getLabelName(jlTotalAmount.getText()), SGuiConsts.GUI_TYPE_DEC_QTY, true);
        moDecPaymentAmount.setDecimalSettings(SGuiUtils.getLabelName(jlPaymentAmount.getText()), SGuiConsts.GUI_TYPE_DEC_QTY, false);
        moDecPaymentFixed.setDecimalSettings(SGuiUtils.getLabelName(jlPaymentFixed.getText()), SGuiConsts.GUI_TYPE_DEC_AMT_UNIT, false);
        moDecPaymentPercentage.setDecimalSettings(SGuiUtils.getLabelName(jlPaymentPercentage.getText()), SGuiConsts.GUI_TYPE_DEC_PER_DISC, false);
        moRadSd.setBooleanSettings(SGuiUtils.getLabelName(moRadSd.getText()), true);
        moRadSbc.setBooleanSettings(SGuiUtils.getLabelName(moRadSbc.getText()), false);
        moRadOther.setBooleanSettings(SGuiUtils.getLabelName(moRadOther.getText()), false);
        moDecSalaryOther.setDecimalSettings(SGuiUtils.getLabelName(jlSalaryOther.getText()), SGuiConsts.GUI_TYPE_DEC_AMT_UNIT, true);

        moFields.addField(moKeyEmployee);
        moFields.addField(moKeyLoanType);
        moFields.addField(moKeyLoanPaymentType);
        moFields.addField(moTextNumber);
        moFields.addField(moDateDateStart);
        moFields.addField(moDateDateEnd_n);
        moFields.addField(moDecCapital);
        moFields.addField(moDecTotalAmount);
        moFields.addField(moDecPaymentAmount);
        moFields.addField(moDecPaymentFixed);
        moFields.addField(moDecPaymentPercentage);
        moFields.addField(moRadSd);
        moFields.addField(moRadSbc);
        moFields.addField(moRadOther);
        moFields.addField(moDecSalaryOther);

        moFields.setFormButton(jbSave);

        moRadSd.addChangeListener(this);
        moRadSbc.addChangeListener(this);
        moRadOther.addChangeListener(this);
    }

    private void itemStateKeyLoanType() {
        jlHelp.setText("");
        moDecCapital.setEditable(false);
        moDecTotalAmount.setEditable(false);
        if (moKeyLoanType.getSelectedIndex() > SLibConsts.UNDEFINED) {
            switch (moKeyLoanType.getValue()[0]) {
                case SModSysConsts.HRSS_TP_LOAN_LOA_COM:
                case SModSysConsts.HRSS_TP_LOAN_LOA_UNI:
                case SModSysConsts.HRSS_TP_LOAN_LOA_TPS:
                    jlHelp.setText("(por periodo de pago)");
                    moDecCapital.setEditable(true);
                    moDecTotalAmount.setEditable(true);
                    break;
                case SModSysConsts.HRSS_TP_LOAN_HOM:
                case SModSysConsts.HRSS_TP_LOAN_CON:
                    jlHelp.setText("(por mes)");
                    moDecCapital.setEditable(false);
                    moDecTotalAmount.setEditable(false);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void itemStateKeyLoanPaymentType() {
        if (moKeyLoanPaymentType.getValue().length == 0) {
            moDecPaymentAmount.setEditable(false);
            moDecPaymentFixed.setEditable(false);
            moDecPaymentPercentage.setEditable(false);
            moDecPaymentAmount.setValue(0d);
            moDecPaymentFixed.setValue(0d);
            moDecPaymentPercentage.setValue(0d);
            moRadSd.setEnabled(false);
            moRadSbc.setEnabled(false);
            moRadOther.setEnabled(false);
        }
        else {
            switch (moKeyLoanPaymentType.getValue()[0]) {
                case SModSysConsts.HRSS_TP_LOAN_PAY_AMT:
                    moDecPaymentAmount.setEditable(true);
                    moDecPaymentFixed.setEditable(false);
                    moDecPaymentPercentage.setEditable(false);
                    moDecPaymentAmount.setValue(0d);
                    moDecPaymentFixed.setValue(0d);
                    moDecPaymentPercentage.setValue(0d);
                    moRadSd.setEnabled(false);
                    moRadSbc.setEnabled(false);
                    moRadOther.setEnabled(false);
                    break;
                case SModSysConsts.HRSS_TP_LOAN_PAY_FIX:
                    moDecPaymentAmount.setEditable(false);
                    moDecPaymentFixed.setEditable(true);
                    moDecPaymentPercentage.setEditable(false);
                    moDecPaymentAmount.setValue(0d);
                    moDecPaymentFixed.setValue(0d);
                    moDecPaymentPercentage.setValue(0d);
                    moRadSd.setEnabled(false);
                    moRadSbc.setEnabled(false);
                    moRadOther.setEnabled(false);
                    break;
                case SModSysConsts.HRSS_TP_LOAN_PAY_PER:
                    moDecPaymentAmount.setEditable(false);
                    moDecPaymentFixed.setEditable(false);
                    moDecPaymentPercentage.setEditable(true);
                    moDecPaymentAmount.setValue(0d);
                    moDecPaymentFixed.setValue(0d);
                    moDecPaymentPercentage.setValue(0d);
                    
                    moRadSd.setEnabled(true);
                    moRadSbc.setEnabled(true);
                    moRadOther.setEnabled(true);
                    break;
                default:
                    break;
            }
        }
        actionEnableFields();
    }
    
    @Override
    public void addAllListeners() {
        moKeyLoanType.addItemListener(this);
        moKeyLoanPaymentType.addItemListener(this);
    }

    @Override
    public void removeAllListeners() {
        moKeyLoanType.removeItemListener(this);
        moKeyLoanPaymentType.removeItemListener(this);
    }

    @Override
    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyEmployee, SModConsts.HRSU_EMP, SLibConsts.UNDEFINED, null);
        miClient.getSession().populateCatalogue(moKeyLoanType, SModConsts.HRSS_TP_LOAN, SModConsts.HRS_LOAN, null);
        miClient.getSession().populateCatalogue(moKeyLoanPaymentType, SModConsts.HRSS_TP_LOAN_PAY, SLibConsts.UNDEFINED, null);
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        int idEmployee = SLibConsts.UNDEFINED;
        moRegistry = (SDbLoan) registry;

        mnFormResult = SLibConsts.UNDEFINED;
        mbFirstActivation = true;

        removeAllListeners();
        reloadCatalogues();

        idEmployee = moRegistry.getPkEmployeeId();

        if (moRegistry.isRegistryNew()) {
            moRegistry.initPrimaryKey();
            moRegistry.setDateStart(miClient.getSession().getCurrentDate());
            jtfRegistryKey.setText("");
        }
        else {
            jtfRegistryKey.setText(SLibUtils.textKey(moRegistry.getPrimaryKey()));
        }

        moKeyEmployee.setValue(new int[] { idEmployee });
        moTextNumber.setValue(moRegistry.getNumber());
        moDateDateStart.setValue(moRegistry.getDateStart());
        moDateDateEnd_n.setValue(moRegistry.getDateEnd_n());
        moDecCapital.setValue(moRegistry.getCapital());
        moDecTotalAmount.setValue(moRegistry.getTotalAmount());
        moKeyLoanType.setValue(new int[] { moRegistry.getFkLoanTypeId() });
        moKeyLoanPaymentType.setValue(new int[] { moRegistry.getFkLoanPaymentTypeId() });
        
        moRadSd.setSelected(moRegistry.getPaymentPercentageReference() == SHrsConsts.SAL_REF_SAL || moRegistry.getPaymentPercentageReference() == SLibConsts.UNDEFINED);
        moRadSbc.setSelected(moRegistry.getPaymentPercentageReference() == SHrsConsts.SAL_REF_SAL_SS);
        moRadOther.setSelected(moRegistry.getPaymentPercentageReference() == SHrsConsts.SAL_REF_SAL_FIX);

        setFormEditable(true);
        
        if (moRegistry.isRegistryNew()) {
            moRadSbc.setSelected(true);
        }
        else {
            moKeyEmployee.setEnabled(false);
        }
        
        moDecCapital.setEditable(false);
        moDecTotalAmount.setEditable(false);
        moDecPaymentAmount.setEditable(false);
        moDecPaymentFixed.setEditable(false);
        moDecPaymentPercentage.setEditable(false);
        
        itemStateKeyLoanPaymentType();
        itemStateKeyLoanType();
        actionEnableFields();
        
        moDecPaymentAmount.setValue(moRegistry.getPaymentAmount());
        moDecPaymentFixed.setValue(moRegistry.getPaymentFixed());
        moDecPaymentPercentage.setValue(moRegistry.getPaymentPercentage());
        
        moDecSalaryOther.setValue(moRegistry.getPaymentPercentageAmount());

        addAllListeners();
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        SDbLoan registry = moRegistry.clone();

        if (registry.isRegistryNew()) {}

        registry.setPkEmployeeId(moKeyEmployee.getValue()[0]);
        registry.setNumber(moTextNumber.getValue());
        registry.setDateStart(moDateDateStart.getValue());
        registry.setDateEnd_n(moDateDateEnd_n.getValue());
        registry.setCapital(moDecCapital.getValue());
        registry.setTotalAmount(moDecTotalAmount.getValue());
        registry.setPaymentAmount(moDecPaymentAmount.getValue());
        registry.setPaymentFixed(moDecPaymentFixed.getValue());
        registry.setPaymentPercentage(moDecPaymentPercentage.getValue());
        registry.setFkLoanTypeId(moKeyLoanType.getValue()[0]);
        registry.setFkLoanPaymentTypeId(moKeyLoanPaymentType.getValue()[0]);
        
        registry.setPaymentPercentageReference(moRadSd.isSelected() ? SHrsConsts.SAL_REF_SAL : moRadSbc.isSelected() ? SHrsConsts.SAL_REF_SAL_SS : SHrsConsts.SAL_REF_SAL_FIX);
        registry.setPaymentPercentageAmount(moDecSalaryOther.getValue());

        return registry;
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        if (validation.isValid()) {
            if (moDateDateEnd_n.getValue() != null) {
                if (moDateDateEnd_n.getValue().before(moDateDateStart.getValue())) {
                    validation.setMessage(SGuiConsts.ERR_MSG_FIELD_DATE_ + "'" + SGuiUtils.getLabelName(jlDateEnd_n.getText()) + "' " +
                            SGuiConsts.ERR_MSG_FIELD_DATE_GREAT_EQUAL + SGuiConsts.ERR_MSG_FIELD_DATE_.toLowerCase() + " '" + SGuiUtils.getLabelName(jlDateStart.getText()) + "'.");
                    validation.setComponent(moDateDateEnd_n);
                }
            }
            
            if (validation.isValid()) {
                if (moDecPaymentAmount.isEditable()&& moDecPaymentAmount.getValue() == 0) {
                    validation.setMessage("Se debe especificar un valor decimal para el campo '" + SGuiUtils.getLabelName(jlPaymentAmount.getText()) + "'.");
                    validation.setComponent(moDecPaymentAmount);
                }
                else if (moDecPaymentFixed.isEditable() && moDecPaymentFixed.getValue() == 0) {
                    validation.setMessage("Se debe especificar un valor decimal para el campo '" + SGuiUtils.getLabelName(jlPaymentFixed.getText()) + "'.");
                    validation.setComponent(moDecPaymentFixed);
                }
                else if (moDecPaymentPercentage.isEditable() && moDecPaymentPercentage.getValue() == 0) {
                    validation.setMessage("Se debe especificar un valor decimal para el campo '" + SGuiUtils.getLabelName(jlPaymentPercentage.getText()) + "'.");
                    validation.setComponent(moDecPaymentPercentage);
                }
            }
        }
        
        return validation;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JComboBox && e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox comboBox = (JComboBox)  e.getSource();

            if (comboBox == moKeyLoanPaymentType) {
                itemStateKeyLoanPaymentType();
            }
            else if (comboBox == moKeyLoanType) {
                itemStateKeyLoanType();
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof SBeanFieldRadio) {
            if ((SBeanFieldRadio) e.getSource() == moRadOther) {
                actionEnableFields();
            }
            
        }
    }
}
