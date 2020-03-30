/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.client.SClientInterface;
import erp.mbps.data.SDataBizPartner;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sa.lib.SLibConsts;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiParams;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanDialogReport;
import sa.lib.gui.bean.SBeanFieldRadio;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SDialogRepHrsAuxPayroll extends SBeanDialogReport implements ChangeListener, ItemListener {
    
    public static int EMP_STATUS_ACT = 1;
    public static int EMP_STATUS_INA = 2;
    
    private SPanelHrsDepartments moPanelHrsDepartments;
    private SPanelHrsFilterPayrollStatus moPanelHrsFilterPayrollStatus;
    
    /**
     * Creates new form SDialogRepHrsAuxPayroll
     * @param client GUI client.
     * @param title Dialog title.
     */
    public SDialogRepHrsAuxPayroll(SGuiClient client, String title) {
        setFormSettings(client, SModConsts.HRSR_PAY_AUX, SLibConsts.UNDEFINED, title);
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

        moGroupReportType = new javax.swing.ButtonGroup();
        moGroupFilterDateType = new javax.swing.ButtonGroup();
        moGroupOrderByEmployee = new javax.swing.ButtonGroup();
        moGroupOrderByDepartament = new javax.swing.ButtonGroup();
        moGroupFilterTypeEarDed = new javax.swing.ButtonGroup();
        moGroupSummary = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        moRadReportTypePayEmp = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel27 = new javax.swing.JPanel();
        moRadReportTypePayDepartamentEmp = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel23 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        moRadShowEarDed = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel15 = new javax.swing.JPanel();
        moRadShowEar = new sa.lib.gui.bean.SBeanFieldRadio();
        moKeyEarning = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel17 = new javax.swing.JPanel();
        moRadShowDed = new sa.lib.gui.bean.SBeanFieldRadio();
        moKeyDeduction = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel14 = new javax.swing.JPanel();
        jlPaymentType = new javax.swing.JLabel();
        moKeyPaymentType = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel13 = new javax.swing.JPanel();
        jlEmployee = new javax.swing.JLabel();
        moKeyEmployee = new sa.lib.gui.bean.SBeanFieldKey();
        jtbEmployeeActive = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        moRadOrderByNumEmployee = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadOrderByNameEmployee = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel19 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        moRadOrderByNumDepartament = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadOrderByNameDepartament = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel6 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        moRadFilterTypePeriod = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadFilterTypeDate = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadFilterTypeDatePay = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel35 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        moIntPeriodYear = new sa.lib.gui.bean.SBeanFieldCalendarYear();
        jPanel38 = new javax.swing.JPanel();
        jlPeriodStart = new javax.swing.JLabel();
        moIntPeriodStart = new sa.lib.gui.bean.SBeanFieldCalendarMonth();
        jPanel39 = new javax.swing.JPanel();
        jlPeriodEnd = new javax.swing.JLabel();
        moIntPeriodEnd = new sa.lib.gui.bean.SBeanFieldCalendarMonth();
        jPanel11 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moDateDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel12 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        moDateDateEnd = new sa.lib.gui.bean.SBeanFieldDate();
        jpFilterStatusPay = new javax.swing.JPanel();
        jlFilterStatusPayTemp = new javax.swing.JLabel();
        jpDepartments = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del reporte:"));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Modalidad del reporte:"));
        jPanel24.setLayout(new java.awt.BorderLayout());

        jPanel22.setLayout(new java.awt.GridLayout(2, 1, 0, 2));

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGroupReportType.add(moRadReportTypePayEmp);
        moRadReportTypePayEmp.setSelected(true);
        moRadReportTypePayEmp.setText("Nómina, empleado");
        moRadReportTypePayEmp.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel18.add(moRadReportTypePayEmp);

        jPanel22.add(jPanel18);

        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGroupReportType.add(moRadReportTypePayDepartamentEmp);
        moRadReportTypePayDepartamentEmp.setText("Nómina, departamento y empleado");
        moRadReportTypePayDepartamentEmp.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel27.add(moRadReportTypePayDepartamentEmp);

        jPanel22.add(jPanel27);

        jPanel24.add(jPanel22, java.awt.BorderLayout.NORTH);

        jPanel16.add(jPanel24, java.awt.BorderLayout.NORTH);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Contenido del reporte:"));
        jPanel23.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGroupFilterTypeEarDed.add(moRadShowEarDed);
        moRadShowEarDed.setText("Percepciones y deducciones");
        moRadShowEarDed.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel21.add(moRadShowEarDed);

        jPanel5.add(jPanel21);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGroupFilterTypeEarDed.add(moRadShowEar);
        moRadShowEar.setText("Percepciones");
        jPanel15.add(moRadShowEar);

        moKeyEarning.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel15.add(moKeyEarning);

        jPanel5.add(jPanel15);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGroupFilterTypeEarDed.add(moRadShowDed);
        moRadShowDed.setText("Deducciones");
        jPanel17.add(moRadShowDed);

        moKeyDeduction.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel17.add(moKeyDeduction);

        jPanel5.add(jPanel17);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPaymentType.setText("Período pago:");
        jlPaymentType.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlPaymentType);

        moKeyPaymentType.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel14.add(moKeyPaymentType);

        jPanel5.add(jPanel14);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlEmployee.setText("Empleado:");
        jlEmployee.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlEmployee);

        moKeyEmployee.setPreferredSize(new java.awt.Dimension(350, 23));
        jPanel13.add(moKeyEmployee);

        jtbEmployeeActive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/switch_filter_off.gif"))); // NOI18N
        jtbEmployeeActive.setSelected(true);
        jtbEmployeeActive.setToolTipText("Filtrar eliminados");
        jtbEmployeeActive.setPreferredSize(new java.awt.Dimension(23, 23));
        jtbEmployeeActive.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/switch_filter_on.gif"))); // NOI18N
        jPanel13.add(jtbEmployeeActive);

        jPanel5.add(jPanel13);

        jPanel23.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel16.add(jPanel23, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel16, java.awt.BorderLayout.WEST);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenamiento del empleado:"));
        jPanel8.setLayout(new java.awt.GridLayout(2, 1));

        moGroupOrderByEmployee.add(moRadOrderByNumEmployee);
        moRadOrderByNumEmployee.setText("Número del empleado");
        jPanel8.add(moRadOrderByNumEmployee);

        moGroupOrderByEmployee.add(moRadOrderByNameEmployee);
        moRadOrderByNameEmployee.setText("Nombre del empleado");
        jPanel8.add(moRadOrderByNameEmployee);

        jPanel9.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenamiento del departamento:"));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1));

        moGroupOrderByDepartament.add(moRadOrderByNumDepartament);
        moRadOrderByNumDepartament.setText("Código del departamento");
        jPanel10.add(moRadOrderByNumDepartament);

        moGroupOrderByDepartament.add(moRadOrderByNameDepartament);
        moRadOrderByNameDepartament.setText("Nombre del departamento");
        jPanel10.add(moRadOrderByNameDepartament);

        jPanel19.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel9.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Periodos y fechas del reporte:"));
        jPanel6.setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGroupFilterDateType.add(moRadFilterTypePeriod);
        moRadFilterTypePeriod.setText("Por periodo");
        jPanel4.add(moRadFilterTypePeriod);

        moGroupFilterDateType.add(moRadFilterTypeDate);
        moRadFilterTypeDate.setText("Por rango de fechas");
        moRadFilterTypeDate.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel4.add(moRadFilterTypeDate);

        moGroupFilterDateType.add(moRadFilterTypeDatePay);
        moRadFilterTypeDatePay.setText("Por fecha pago nómina");
        moRadFilterTypeDatePay.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel4.add(moRadFilterTypeDatePay);

        jPanel6.add(jPanel4);

        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlYear.setText("Ejercicio:*");
        jlYear.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel35.add(jlYear);
        jPanel35.add(moIntPeriodYear);

        jPanel6.add(jPanel35);

        jPanel38.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriodStart.setText("Periodo inicial:*");
        jlPeriodStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel38.add(jlPeriodStart);
        jPanel38.add(moIntPeriodStart);

        jPanel6.add(jPanel38);

        jPanel39.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriodEnd.setText("Periodo final:*");
        jlPeriodEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel39.add(jlPeriodEnd);
        jPanel39.add(moIntPeriodEnd);

        jPanel6.add(jPanel39);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial:*");
        jlDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlDateStart);
        jPanel11.add(moDateDateStart);

        jPanel6.add(jPanel11);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd.setText("Fecha final:*");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlDateEnd);
        jPanel12.add(moDateDateEnd);

        jPanel6.add(jPanel12);

        jpFilterStatusPay.setLayout(new java.awt.BorderLayout());

        jlFilterStatusPayTemp.setText("<Temporal label. Preserve if for panel to be added!>");
        jpFilterStatusPay.add(jlFilterStatusPayTemp, java.awt.BorderLayout.CENTER);

        jPanel6.add(jpFilterStatusPay);

        jPanel7.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jpDepartments.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar departamentos:"));
        jpDepartments.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jpDepartments, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlEmployee;
    private javax.swing.JLabel jlFilterStatusPayTemp;
    private javax.swing.JLabel jlPaymentType;
    private javax.swing.JLabel jlPeriodEnd;
    private javax.swing.JLabel jlPeriodStart;
    private javax.swing.JLabel jlYear;
    private javax.swing.JPanel jpDepartments;
    private javax.swing.JPanel jpFilterStatusPay;
    private javax.swing.JToggleButton jtbEmployeeActive;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateEnd;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateStart;
    private javax.swing.ButtonGroup moGroupFilterDateType;
    private javax.swing.ButtonGroup moGroupFilterTypeEarDed;
    private javax.swing.ButtonGroup moGroupOrderByDepartament;
    private javax.swing.ButtonGroup moGroupOrderByEmployee;
    private javax.swing.ButtonGroup moGroupReportType;
    private javax.swing.ButtonGroup moGroupSummary;
    private sa.lib.gui.bean.SBeanFieldCalendarMonth moIntPeriodEnd;
    private sa.lib.gui.bean.SBeanFieldCalendarMonth moIntPeriodStart;
    private sa.lib.gui.bean.SBeanFieldCalendarYear moIntPeriodYear;
    private sa.lib.gui.bean.SBeanFieldKey moKeyDeduction;
    private sa.lib.gui.bean.SBeanFieldKey moKeyEarning;
    private sa.lib.gui.bean.SBeanFieldKey moKeyEmployee;
    private sa.lib.gui.bean.SBeanFieldKey moKeyPaymentType;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeDate;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeDatePay;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypePeriod;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNameDepartament;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNameEmployee;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNumDepartament;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNumEmployee;
    private sa.lib.gui.bean.SBeanFieldRadio moRadReportTypePayDepartamentEmp;
    private sa.lib.gui.bean.SBeanFieldRadio moRadReportTypePayEmp;
    private sa.lib.gui.bean.SBeanFieldRadio moRadShowDed;
    private sa.lib.gui.bean.SBeanFieldRadio moRadShowEar;
    private sa.lib.gui.bean.SBeanFieldRadio moRadShowEarDed;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 1000, 625);
        
        moPanelHrsDepartments = new SPanelHrsDepartments(miClient);
        moPanelHrsFilterPayrollStatus = new SPanelHrsFilterPayrollStatus(miClient);

        moRadReportTypePayEmp.setBooleanSettings(SGuiUtils.getLabelName(moRadReportTypePayEmp.getText()), true);
        moRadReportTypePayDepartamentEmp.setBooleanSettings(SGuiUtils.getLabelName(moRadReportTypePayDepartamentEmp.getText()), false);
        moRadShowEarDed.setBooleanSettings(SGuiUtils.getLabelName(moRadShowEarDed.getText()), true);
        moRadShowEar.setBooleanSettings(SGuiUtils.getLabelName(moRadShowEar.getText()), false);
        moKeyEarning.setKeySettings(miClient, SGuiUtils.getLabelName(moRadShowEar.getText()), false);
        moRadShowDed.setBooleanSettings(SGuiUtils.getLabelName(moRadShowDed.getText()), false);
        moKeyDeduction.setKeySettings(miClient, SGuiUtils.getLabelName(moRadShowDed.getText()), false);
        moKeyPaymentType.setKeySettings(miClient, SGuiUtils.getLabelName(jlPaymentType.getText()), false);
        moKeyEmployee.setKeySettings(miClient, SGuiUtils.getLabelName(jlEmployee.getText()), false);
        moRadFilterTypePeriod.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypePeriod.getText()), true);
        moRadFilterTypeDate.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypeDate.getText()), false);
        moRadFilterTypeDatePay.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypeDatePay.getText()), false);
        moIntPeriodYear.setCalendarSettings(SGuiUtils.getLabelName(jlYear.getText()));
        moIntPeriodStart.setCalendarSettings(SGuiUtils.getLabelName(jlPeriodStart.getText()));
        moIntPeriodEnd.setCalendarSettings(SGuiUtils.getLabelName(jlPeriodEnd.getText()));
        moDateDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart.getText()), true);
        moDateDateEnd.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd.getText()), true);
        moRadOrderByNumEmployee.setBooleanSettings(SGuiUtils.getLabelName(moRadOrderByNumEmployee.getText()), false);
        moRadOrderByNameEmployee.setBooleanSettings(SGuiUtils.getLabelName(moRadOrderByNameEmployee.getText()), true);
        moRadOrderByNumDepartament.setBooleanSettings(SGuiUtils.getLabelName(moRadOrderByNumDepartament.getText()), false);
        moRadOrderByNameDepartament.setBooleanSettings(SGuiUtils.getLabelName(moRadOrderByNameDepartament.getText()), true);

        jpDepartments.add(moPanelHrsDepartments, BorderLayout.CENTER);
        jpFilterStatusPay.remove(jlFilterStatusPayTemp);
        jpFilterStatusPay.add(moPanelHrsFilterPayrollStatus, BorderLayout.CENTER);
        moPanelHrsFilterPayrollStatus.setSelectedAll();

        moFields.addField(moRadReportTypePayEmp);
        moFields.addField(moRadReportTypePayDepartamentEmp);
        moFields.addField(moRadShowEarDed);
        moFields.addField(moRadShowEar);
        moFields.addField(moKeyEarning);
        moFields.addField(moRadShowDed);
        moFields.addField(moKeyDeduction);
        moFields.addField(moKeyPaymentType);
        moFields.addField(moKeyEmployee);
        moFields.addField(moRadFilterTypePeriod);
        moFields.addField(moRadFilterTypeDate);
        moFields.addField(moRadFilterTypeDatePay);
        moFields.addField(moIntPeriodYear);
        moFields.addField(moIntPeriodStart);
        moFields.addField(moIntPeriodEnd);
        moFields.addField(moDateDateStart);
        moFields.addField(moDateDateEnd);
        moFields.addField(moRadOrderByNumEmployee);
        moFields.addField(moRadOrderByNameEmployee);
        moFields.addField(moRadOrderByNumDepartament);
        moFields.addField(moRadOrderByNameDepartament);

        moFields.setFormButton(jbPrint);

        moRadReportTypePayEmp.addChangeListener(this);
        moRadFilterTypePeriod.addChangeListener(this);
        moRadFilterTypeDate.addChangeListener(this);
        moRadFilterTypeDatePay.addChangeListener(this);
        
        moRadShowEarDed.addChangeListener(this);
        moRadShowEar.addChangeListener(this);
        moRadShowDed.addChangeListener(this);
        
        jtbEmployeeActive.addItemListener(this);
        
        jtbEmployeeActive.setSelected(true);
        moRadReportTypePayEmp.setSelected(true);
        moRadShowEarDed.setSelected(true);
        moRadFilterTypePeriod.setSelected(true);
        moRadOrderByNameEmployee.setSelected(true);
        moRadOrderByNameDepartament.setSelected(true);
        
        moIntPeriodYear.setValue(miClient.getSession().getCurrentYear());
        moIntPeriodStart.setValue(SLibTimeUtils.digestMonth(miClient.getSession().getCurrentDate())[1]);
        moIntPeriodEnd.setValue(SLibTimeUtils.digestMonth(miClient.getSession().getCurrentDate())[1]);
        moDateDateStart.setValue(SLibTimeUtils.getBeginOfYear(miClient.getSession().getCurrentDate()));
        moDateDateEnd.setValue(SLibTimeUtils.getEndOfYear(miClient.getSession().getCurrentDate()));
        
        reloadCatalogues();
        actionEnableFieldsDates();
        actionEnableFieldsEarDed();
    }

    private void itemStateChangedEmployeeActive() {
        populateEmployee();
    }
    
    private void actionEnableFieldsDates() {
        if (moRadFilterTypePeriod.isSelected()) {
            moIntPeriodYear.setEnabled(true);
            moIntPeriodStart.setEnabled(true);    
            moIntPeriodEnd.setEnabled(true);
            moDateDateStart.setEnabled(false);
            moDateDateEnd.setEnabled(false);
            moPanelHrsFilterPayrollStatus.setSelectedAll();
        }
        else if (moRadFilterTypeDate.isSelected() || moRadFilterTypeDatePay.isSelected()) {
            moIntPeriodYear.setEnabled(false);
            moIntPeriodStart.setEnabled(false);    
            moIntPeriodEnd.setEnabled(false);
            moDateDateStart.setEnabled(true);
            moDateDateEnd.setEnabled(true);
            
            if (moRadFilterTypeDatePay.isSelected()) {
                moPanelHrsFilterPayrollStatus.setSelectedClose();
            }
            else {
                moPanelHrsFilterPayrollStatus.setSelectedAll();
            }
        }
    }
    
    private void actionEnableFieldsEarDed() {
        moKeyEarning.setEnabled(moRadShowEarDed.isSelected() || moRadShowEar.isSelected());
        moKeyDeduction.setEnabled(moRadShowEarDed.isSelected() || moRadShowDed.isSelected());
    }
    
    private String getColumSelect(int type) {
        String columns = "";
        
        if (moRadReportTypePayEmp.isSelected()) {
            columns = " 0 AS _g0, p.id_pay AS _g1, id_bp AS _g2, " + type + " AS _g3, '' AS _g0_name, CONCAT(tp_pay.id_tp_pay, '-', UPPER(LEFT(tp_pay.name, 3)), '-', f_int_str(p.num,2), ' (', f_int_str(p.per_year,4), '-', f_int_str(p.per,2), ')') AS _g1_name, bp.bp AS _g2_name, ";
        }
        else if (moRadReportTypePayDepartamentEmp.isSelected()) {
            columns = " p.id_pay AS _g0, id_dep AS _g1, id_bp AS _g2, " + type + " AS _g3, CONCAT(tp_pay.code, '-', f_int_str(p.num,2), ' (', f_int_str(p.per_year,4), '-', f_int_str(p.per,2), ')') AS _g0_name, dep.code AS f_dep_code, dep.name AS _g1_name, bp.bp AS _g2_name, ";
        }
        
        return columns;
    }
    
    private String getOrderBy() {
        String orderBy = "ORDER BY ";
        
        if (moRadReportTypePayEmp.isSelected()) {
             orderBy += "_g1_name, _g1, ";
             
            if (moRadOrderByNumEmployee.isSelected()) {
                orderBy += "CAST(f_emp_num AS UNSIGNED INTEGER), _g2_name, _g2, ";
            }
            else if (moRadOrderByNameEmployee.isSelected()) {
                orderBy += "_g2_name, _g2, ";
            }
        }
        else if (moRadReportTypePayDepartamentEmp.isSelected()) {
             orderBy += "_g0_name, _g0, ";
             
            if (moRadOrderByNumDepartament.isSelected()) {
                orderBy += "f_dep_code, _g1_name, _g1, ";
            }
            else if (moRadOrderByNameDepartament.isSelected()) {
                orderBy += "_g1_name, f_dep_code, _g1, ";
            }
            
            if (moRadOrderByNumEmployee.isSelected()) {
                orderBy += "CAST(f_emp_num AS UNSIGNED INTEGER), _g2_name, _g2, ";
            }
            else if (moRadOrderByNameEmployee.isSelected()) {
                orderBy += "_g2_name, _g2, ";
            }
        }
        orderBy += "_g3, f_ear_ded, f_ear_ded_id; ";
        
        return orderBy;
    }
    
    private void populateEmployee() {
        miClient.getSession().populateCatalogue(moKeyEmployee, erp.mod.SModConsts.HRSU_EMP, 0, 
                new SGuiParams(jtbEmployeeActive.isSelected() ? SGuiConsts.PARAM_REGS_ACT : SGuiConsts.PARAM_REGS_ALL));
    }

    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyEarning, SModConsts.HRS_EAR, SLibConsts.UNDEFINED, null);
        miClient.getSession().populateCatalogue(moKeyDeduction, SModConsts.HRS_DED, SLibConsts.UNDEFINED, null);
        miClient.getSession().populateCatalogue(moKeyPaymentType, SModConsts.HRSS_TP_PAY, SLibConsts.UNDEFINED, null);
        populateEmployee();
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        if (validation.isValid()) {
            if (moRadFilterTypePeriod.isSelected()) {
                if (moIntPeriodStart.getValue() > moIntPeriodEnd.getValue()) {
                    validation.setMessage(SGuiConsts.ERR_MSG_FIELD_VAL_ + "'" + SGuiUtils.getLabelName(jlPeriodEnd.getText()) + "'" + SGuiConsts.ERR_MSG_FIELD_VAL_GREAT_EQUAL + "'" + SGuiUtils.getLabelName(jlPeriodStart.getText()) + "'.");
                    validation.setComponent(moIntPeriodEnd);
                }
            }
            else if (moRadFilterTypeDate.isSelected() || moRadFilterTypeDatePay.isSelected()) {
                validation = SGuiUtils.validateDateRange(moDateDateStart, moDateDateEnd);
            }
            
            if (validation.isValid()) {
                validation = moPanelHrsDepartments.validatePanel();
            }
        }

        return validation;
    }

    @Override
    public void createParamsMap() {
        SDataBizPartner bizPartnerCompany = null;
        String sSqlWhere = "";
        String sSqlInnerIssue = "";
        String sDepartamentsId = "";
        String sDepartamentsName = "";
        int payrollStatus = (int) moPanelHrsFilterPayrollStatus.getValue(SLibConsts.UNDEFINED);

        bizPartnerCompany = new SDataBizPartner();
        bizPartnerCompany.read(new int[] { ((SClientInterface) miClient).getSessionXXX().getCompany().getPkCompanyId() }, miClient.getSession().getStatement());
        
        sDepartamentsId = (String) moPanelHrsDepartments.getValue(SGuiConsts.PARAM_KEY);
        sDepartamentsName = (String) moPanelHrsDepartments.getValue(SGuiConsts.PARAM_ITEM);
        
        moParamsMap = miClient.createReportParams();
        
        sSqlWhere += moKeyEmployee.getSelectedIndex() > 0 ? " AND emp.id_emp = " + moKeyEmployee.getValue()[0] : "";
        sSqlWhere += moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " +  moKeyPaymentType.getValue()[0] : "";
        sSqlWhere += sDepartamentsId.isEmpty() ? "" : " AND dep.id_dep IN(" + sDepartamentsId + ") ";
        
        if (payrollStatus != SPanelHrsFilterPayrollStatus.STATUS_UNDEF) {
            if (payrollStatus == SPanelHrsFilterPayrollStatus.STATUS_CLOSE) {
                sSqlWhere +=  " AND p.b_clo = 1 ";                
            }
            else if (payrollStatus == SPanelHrsFilterPayrollStatus.STATUS_OPEN) {
                sSqlWhere +=  " AND p.b_clo = 0 ";
            }
        }
        
        if (moRadFilterTypeDatePay.isSelected()) {
            sSqlInnerIssue = "INNER JOIN hrs_pay_rcp_iss AS rcp_iss ON rcp_iss.id_pay = rcp.id_pay AND rcp_iss.id_emp = rcp.id_emp AND rcp_iss.dt_pay BETWEEN '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue())
                    + "' AND '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' AND rcp_iss.b_del = 0 AND rcp_iss.fk_st_rcp <> " + SModSysConsts.TRNS_ST_DPS_ANNULED;
        }
        
        moParamsMap.put("sTitle", "REPORTE DE AUXILIARES DE NÓMINAS");
        
        if (moRadFilterTypePeriod.isSelected()) {
            moParamsMap.put("bByPeriod", true);
            moParamsMap.put("nPeriodYear", moIntPeriodYear.getValue());
            moParamsMap.put("nPeriodStart", moIntPeriodStart.getValue());
            moParamsMap.put("nPeriodEnd", moIntPeriodEnd.getValue());
            sSqlWhere += " AND p.per_year = " + moIntPeriodYear.getValue() + " AND p.per BETWEEN " + moIntPeriodStart.getValue() + " AND " + moIntPeriodEnd.getValue() + " ";
        }
        else if (moRadFilterTypeDate.isSelected()) {
            moParamsMap.put("bByPeriod", false);
            moParamsMap.put("tDateStart", moDateDateStart.getValue());
            moParamsMap.put("tDateEnd", moDateDateEnd.getValue());
            sSqlWhere += " AND p.dt_sta >= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' ";
        }
        else if (moRadFilterTypeDatePay.isSelected()) {
            moParamsMap.put("bByPeriod", false);
            moParamsMap.put("tDateStart", moDateDateStart.getValue());
            moParamsMap.put("tDateEnd", moDateDateEnd.getValue());
        }
        moParamsMap.put("RegistroPatronal", ((SClientInterface) miClient).getSessionXXX().getParamsCompany().getRegistrySs());
        moParamsMap.put("sEmiRfc", bizPartnerCompany.getFiscalId());
        
        moParamsMap.put("sEmployee", moKeyEmployee.getSelectedIndex() > 0 ? moKeyEmployee.getSelectedItem() : "(TODOS)");
        moParamsMap.put("sEarning", !moKeyEarning.isEnabled() ? "(TODAS)" : moKeyEarning.getSelectedIndex() > 0 ? moKeyEarning.getSelectedItem() : "(TODAS)");
        moParamsMap.put("sDeduction", !moKeyDeduction.isEnabled() ? "(TODAS)" : moKeyDeduction.getSelectedIndex() > 0 ? moKeyDeduction.getSelectedItem() : "(TODAS)");
        moParamsMap.put("sPaymentType", moKeyPaymentType.getSelectedIndex() > 0 ? moKeyPaymentType.getSelectedItem() : "(TODOS)");
        moParamsMap.put("sDepartaments", sDepartamentsName.isEmpty() || (boolean) moPanelHrsDepartments.getValue(SGuiConsts.PARAM_ROWS) ? "(TODOS)" : sDepartamentsName + " ");
        
        moParamsMap.put("bIsEarDedOnly", moRadReportTypePayEmp.isSelected());
        moParamsMap.put("sColumnsEar", getColumSelect(1));
        moParamsMap.put("sColumnsDed", getColumSelect(2));
        moParamsMap.put("sSqlWhere", sSqlWhere);
        moParamsMap.put("sSqlInnerIssue", sSqlInnerIssue);
        
        if (moRadShowEarDed.isSelected()) {
            moParamsMap.put("sSqlWhereEarning", moKeyEarning.getSelectedIndex() > 0 ? " AND ear.id_ear = " + moKeyEarning.getValue()[0] : "");
            moParamsMap.put("sSqlWhereDeduction", moKeyDeduction.getSelectedIndex() > 0 ? " AND ded.id_ded = " + moKeyDeduction.getValue()[0] : "");
        }
        else {
            moParamsMap.put("sSqlWhereEarning", !moKeyEarning.isEnabled() ? " AND ear.id_ear = 0 " : moKeyEarning.getSelectedIndex() > 0 ? " AND ear.id_ear = " + moKeyEarning.getValue()[0] : "");
            moParamsMap.put("sSqlWhereDeduction", !moKeyDeduction.isEnabled() ? " AND ded.id_ded = 0 " : moKeyDeduction.getSelectedIndex() > 0 ? " AND ded.id_ded = " + moKeyDeduction.getValue()[0] : "");
        }
        moParamsMap.put("sSqlOrderBy", getOrderBy());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof SBeanFieldRadio) {
            if ((SBeanFieldRadio) e.getSource() == moRadFilterTypePeriod ||
                    (SBeanFieldRadio) e.getSource() == moRadFilterTypeDate ||
                    (SBeanFieldRadio) e.getSource() == moRadFilterTypeDatePay) {
                actionEnableFieldsDates();
            }
            else if ((SBeanFieldRadio) e.getSource() == moRadShowEarDed ||
                    (SBeanFieldRadio) e.getSource() == moRadShowEar ||
                    (SBeanFieldRadio) e.getSource() == moRadShowDed) {
                actionEnableFieldsEarDed();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JToggleButton) {
            JToggleButton toggleButton = (JToggleButton) e.getSource();

            if (toggleButton == jtbEmployeeActive) {
                itemStateChangedEmployeeActive();
            }
        }
    }
}
