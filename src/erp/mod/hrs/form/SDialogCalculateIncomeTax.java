/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SDbTaxSubsidyTable;
import erp.mod.hrs.db.SDbTaxTable;
import erp.mod.hrs.db.SHrsAmountEarning;
import erp.mod.hrs.db.SHrsConsts;
import erp.mod.hrs.db.SHrsUtils;
import erp.mod.hrs.db.SRowCalculateIncomeTax;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import sa.lib.SLibConsts;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.grid.SGridColumnForm;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridPaneForm;
import sa.lib.grid.SGridRow;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFieldCalendarYear;
import sa.lib.gui.bean.SBeanFieldRadio;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SDialogCalculateIncomeTax extends SBeanFormDialog implements ActionListener, ChangeListener  {

    protected SGridPaneForm moGridEmployeesRow;
    protected int mnDaysPeriod;
    
    /**
     * Creates new form SDialogCalculateEstimateIncomeTax
     * @param client
     * @param title
     */
    public SDialogCalculateIncomeTax(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.HRSX_SSC_UPD, SLibConsts.UNDEFINED, title);
        initComponents();
        initComponentsCustom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moGrpTypeDate = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jlPaymentType = new javax.swing.JLabel();
        moKeyPaymentType = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel25 = new javax.swing.JPanel();
        jlTax = new javax.swing.JLabel();
        moKeyTax = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel9 = new javax.swing.JPanel();
        moRadFilterTypeYear = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadFilterTypeDateCut = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel26 = new javax.swing.JPanel();
        jlTaxSubsidy = new javax.swing.JLabel();
        moKeyTaxSubsidy = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel27 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        moCalYear = new sa.lib.gui.bean.SBeanFieldCalendarYear();
        jlDateCutoff = new javax.swing.JLabel();
        moDateDateCutoff = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel28 = new javax.swing.JPanel();
        jbCalculate = new javax.swing.JButton();
        jbClean = new javax.swing.JButton();
        jpEmployee = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.GridLayout(3, 2, 0, 5));

        jPanel29.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPaymentType.setText("Periodo pago nómina:");
        jlPaymentType.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel29.add(jlPaymentType);

        moKeyPaymentType.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel29.add(moKeyPaymentType);

        jPanel13.add(jPanel29);

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTax.setText("Tabla impuesto:*");
        jlTax.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel25.add(jlTax);

        moKeyTax.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel25.add(moKeyTax);

        jPanel13.add(jPanel25);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moGrpTypeDate.add(moRadFilterTypeYear);
        moRadFilterTypeYear.setSelected(true);
        moRadFilterTypeYear.setText("Por ejercicio");
        moRadFilterTypeYear.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel9.add(moRadFilterTypeYear);

        moGrpTypeDate.add(moRadFilterTypeDateCut);
        moRadFilterTypeDateCut.setText("Por fecha de corte");
        moRadFilterTypeDateCut.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel9.add(moRadFilterTypeDateCut);

        jPanel13.add(jPanel9);

        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTaxSubsidy.setText("Tabla subsidio empleo:*");
        jlTaxSubsidy.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel26.add(jlTaxSubsidy);

        moKeyTaxSubsidy.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel26.add(moKeyTaxSubsidy);

        jPanel13.add(jPanel26);

        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlYear.setText("Ejercicio:");
        jlYear.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel27.add(jlYear);
        jPanel27.add(moCalYear);

        jlDateCutoff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDateCutoff.setText("Fecha corte:");
        jlDateCutoff.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel27.add(jlDateCutoff);
        jPanel27.add(moDateDateCutoff);

        jPanel13.add(jPanel27);

        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jbCalculate.setText("Calcular");
        jbCalculate.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jbCalculate.setPreferredSize(new java.awt.Dimension(115, 23));
        jPanel28.add(jbCalculate);

        jbClean.setText("Limpiar");
        jbClean.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jbClean.setPreferredSize(new java.awt.Dimension(115, 23));
        jPanel28.add(jbClean);

        jPanel13.add(jPanel28);

        jPanel7.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel7, java.awt.BorderLayout.NORTH);

        jpEmployee.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados:"));
        jpEmployee.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jpEmployee, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCalculate;
    private javax.swing.JButton jbClean;
    private javax.swing.JLabel jlDateCutoff;
    private javax.swing.JLabel jlPaymentType;
    private javax.swing.JLabel jlTax;
    private javax.swing.JLabel jlTaxSubsidy;
    private javax.swing.JLabel jlYear;
    private javax.swing.JPanel jpEmployee;
    private sa.lib.gui.bean.SBeanFieldCalendarYear moCalYear;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateCutoff;
    private javax.swing.ButtonGroup moGrpTypeDate;
    private sa.lib.gui.bean.SBeanFieldKey moKeyPaymentType;
    private sa.lib.gui.bean.SBeanFieldKey moKeyTax;
    private sa.lib.gui.bean.SBeanFieldKey moKeyTaxSubsidy;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeDateCut;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeYear;
    // End of variables declaration//GEN-END:variables

    private void enableFields(boolean enable) {
        moKeyPaymentType.setEnabled(enable);
        moRadFilterTypeDateCut.setEnabled(enable);
        moRadFilterTypeYear.setEnabled(enable);
        moDateDateCutoff.setEditable(enable);
        moDateDateCutoff.setFocusable(enable);
        moCalYear.setEditable(enable);
        moCalYear.setFocusable(enable);
        jbCalculate.setEnabled(enable);
        jbClean.setEnabled(!enable);
    }
    
    private void actionEnableFieldsTypeCal() {
        if (moRadFilterTypeDateCut.isSelected()) {
            moDateDateCutoff.setEditable(true);
            moDateDateCutoff.setFocusable(true);
            moCalYear.setEditable(true);
            moCalYear.setFocusable(true);
        }
        else if (moRadFilterTypeYear.isSelected()) {
            moDateDateCutoff.setEditable(false);
            moDateDateCutoff.setFocusable(false);
            moCalYear.setEditable(true);
            moCalYear.setFocusable(true);
            actionStateChangeYear();
        }
    }
    
    private void actionStateChangeYear() {
        moDateDateCutoff.setValue(SLibTimeUtils.createDate(moCalYear.getValue(), 12, 31));
    }
    
    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 960, 600);
        
        jbCancel.setText(SGuiConsts.TXT_BTN_CLOSE);
        jbSave.setText(SGuiConsts.TXT_BTN_OK);
        jbSave.setEnabled(false);   // button not needed
        
        moDateDateCutoff.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateCutoff.getText()), true);
        moKeyPaymentType.setKeySettings(miClient, SGuiUtils.getLabelName(jlPaymentType.getText()), false);
        
        moFields.addField(moDateDateCutoff);
        moFields.addField(moKeyPaymentType);
        
        moFields.setFormButton(jbSave);
        
        moGridEmployeesRow = new SGridPaneForm(miClient, SModConsts.HRSU_EMP, SLibConsts.UNDEFINED, "Empleados") {
            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                ArrayList<SGridColumnForm> gridColumnsForm = new ArrayList<>();

                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_BPR_L, "Empleado"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_BPR, "Clave"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_CAT, "Período pago actual"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Percepciones $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Parte gravada $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_INT_1B, "Días activo"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_INT_1B, "Días incapacidad"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_INT_1B, "Días gravados"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_8D, "Factor", 75));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "ISR causado $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "ISR retenido $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "ISR diferencia $: (+) a cargo, (-) a favor"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Subsidio causado $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Subsidio pagado $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Subsidio diferencia $: (+) a cargo, (-) a favor"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Diferencia neta $: (+) a cargo, (-) a favor"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_BOOL_S, "Activo"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Última alta"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Última baja"));
                
                return gridColumnsForm;
            }
        };

        jpEmployee.add(moGridEmployeesRow, BorderLayout.CENTER);
        //mvFormGrids.add(moGridEmployeesRow);
        
        reloadCatalogues();
        addAllListeners();
        
        moGridEmployeesRow.populateGrid(new Vector<SGridRow>());
        moGridEmployeesRow.resetSortKeys();
        moGridEmployeesRow.setSelectedGridRow(0);
        
        moCalYear.setValue(SLibTimeUtils.digestYear(miClient.getSession().getCurrentDate())[0]);
        moDateDateCutoff.setValue(miClient.getSession().getCurrentDate());
        moRadFilterTypeYear.setSelected(true);
        
        moKeyTax.setEnabled(false);
        moKeyTaxSubsidy.setEnabled(false);
        
        enableFields(true);
        actionEnableFieldsTypeCal();
    }
    
    private void setTablesTax() throws Exception {
        moKeyTax.setValue(new int[] { SHrsUtils.getRecentTaxTable(miClient.getSession(), moDateDateCutoff.getValue()) });
        moKeyTaxSubsidy.setValue(new int[] { SHrsUtils.getRecentTaxSubsidyTable(miClient.getSession(), moDateDateCutoff.getValue()) });
    }
    
    private void actionCalculate() {
        SGuiValidation validation = validateForm();
        
        if (validation.isValid()) {
            enableFields(false);
            try {
                setTablesTax();
                populateEmployees();
            }
            catch (Exception e) {
                SLibUtils.showException(this, e);
            }
        }
        else {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
    }
    
    private void actionClean() {
        enableFields(true);
        actionEnableFieldsTypeCal();
    }
    
    private void populateEmployees() {
        int employeeId = 0;
        int periodYear = 0;
        double dDaysHired = 0;
        double dDaysIncapacityNotPay = 0;
        double dDaysTaxable = 0;
        double dTableFactor = 0;
        SDbTaxTable dbTaxTable = null;
        SDbTaxSubsidyTable dbSubsidyTable = null;
        Date mtDateStart = null;
        Date mtDateEnd = null;
        String sql = "";
        Vector<SGridRow> rows = new Vector<SGridRow>();
        SHrsAmountEarning amountEarningSubsidy = null;
        SHrsAmountEarning amountEarnings = null;
        ResultSet resultSet = null;
        Statement statement = null;
        Statement statementAux = null;
        
        try {
            statement = miClient.getSession().getDatabase().getConnection().createStatement();
            statementAux = miClient.getSession().getDatabase().getConnection().createStatement();
            
            mtDateStart = SLibTimeUtils.createDate(moCalYear.getValue(), 1, 1);
            mtDateEnd = moDateDateCutoff.getValue();
            periodYear = moCalYear.getValue();
            
            dbTaxTable = (SDbTaxTable) miClient.getSession().readRegistry(SModConsts.HRS_TAX, new int[] { SHrsUtils.getRecentTaxTable(miClient.getSession(), mtDateEnd) });
            dbSubsidyTable = (SDbTaxSubsidyTable) miClient.getSession().readRegistry(SModConsts.HRS_TAX_SUB, new int[] { SHrsUtils.getRecentTaxSubsidyTable(miClient.getSession(), mtDateEnd) });
            
            sql = "SELECT b.bp, e.id_emp, e.num, e.b_act, e.dt_hire, e.dt_dis_n, UPPER(LEFT(tp.name, 3)) AS _tp_name "
                    + "FROM " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS e "
                    + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.BPSU_BP) + " AS b ON b.id_bp = e.id_emp "
                    + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_PAY) + " AS tp ON e.fk_tp_pay = tp.id_tp_pay "
                    + "WHERE e.id_emp IN ("
                    + "SELECT DISTINCT id_emp "
                    + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p "
                    + "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS pr ON pr.id_pay = p.id_pay "
                    + "WHERE p.fis_year = " + moCalYear.getValue() + " " + (!moRadFilterTypeDateCut.isSelected() ? "" : "AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateCutoff.getValue()) + "'") + " "
                    + (moKeyPaymentType.getSelectedIndex() <= 0 ? "" : "AND p.fk_tp_pay = " +  moKeyPaymentType.getValue()[0]) + " "
                    + "ORDER BY id_emp)"
                    + "ORDER BY b.bp, b.id_bp ";

            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SRowCalculateIncomeTax row = new SRowCalculateIncomeTax();
                employeeId = resultSet.getInt("e.id_emp");
                
                dDaysHired = SHrsUtils.getEmployeeHireDays(SHrsUtils.getEmployeeHireLogs(miClient.getSession(), statementAux, employeeId, mtDateStart, mtDateEnd), mtDateStart, mtDateEnd);
                dDaysIncapacityNotPay = SHrsUtils.getEmployeeIncapacityNotPayed(SHrsUtils.getEmployeeAbsencesConsumptions(miClient.getSession(), SHrsUtils.getEmployeeAbsences(miClient.getSession(), employeeId), 0), mtDateStart, mtDateEnd);
                dDaysTaxable = dDaysHired - dDaysIncapacityNotPay;
                
                amountEarnings = SHrsUtils.getAmountEarningsByEmployee(miClient.getSession(), employeeId, periodYear, mtDateEnd);
                amountEarningSubsidy = SHrsUtils.getAmountEarningByEmployee(miClient.getSession(), employeeId, SModSysConsts.HRSS_TP_EAR_TAX_SUB, periodYear, mtDateEnd);
                dTableFactor = ((double) SHrsConsts.YEAR_MONTHS / (SHrsConsts.YEAR_DAYS + (SLibTimeUtils.isLeapYear(periodYear) ? 1d : 0d))) * dDaysTaxable;

                row.setEmployeeId(employeeId);
                row.setNameEmployee(resultSet.getString("b.bp"));
                row.setCodeEmployee(resultSet.getString("e.num"));
                row.setCodePaymentType(resultSet.getString("_tp_name"));
                row.setAmountTaxable(amountEarnings.getAmountTaxable());
                row.setAmountIncome(amountEarnings.getAmount());
                row.setDaysHire(dDaysHired);
                row.setDaysIncapacity(dDaysIncapacityNotPay);
                row.setDaysTaxable(dDaysTaxable);
                row.setFactor(dTableFactor);
                row.setCalculatedTax(SHrsUtils.computeAmountTax(dbTaxTable, amountEarnings.getAmountTaxable(), dTableFactor));
                row.setRetainedTax(SHrsUtils.getAmountDeductionByEmployee(miClient.getSession(), employeeId, SModSysConsts.HRSS_TP_DED_TAX, periodYear, mtDateEnd));
                row.setCalculatedSubsidy(SHrsUtils.computeAmountTaxSubsidy(dbSubsidyTable, amountEarnings.getAmountTaxable(), dTableFactor));
                row.setGivenSubsidy(amountEarningSubsidy.getAmount());
                row.setIsStatus(resultSet.getBoolean("e.b_act"));
                row.setDateHire(resultSet.getDate("e.dt_hire"));
                row.setDateDismisss_n(resultSet.getDate("e.dt_dis_n"));
                
                rows.add(row);
            }
        }
        catch (Exception e) {
           SLibUtils.showException(this, e);
        }
        
        moGridEmployeesRow.populateGrid(rows);
        moGridEmployeesRow.resetSortKeys();
        moGridEmployeesRow.setSelectedGridRow(0);
    }
    
    @Override
    public void addAllListeners() {
        moRadFilterTypeDateCut.addChangeListener(this);
        moRadFilterTypeYear.addChangeListener(this);
        moCalYear.addChangeListener(this);
        jbCalculate.addActionListener(this);
        jbClean.addActionListener(this);
    }

    @Override
    public void removeAllListeners() {
        moRadFilterTypeDateCut.removeChangeListener(this);
        moRadFilterTypeYear.removeChangeListener(this);
        moCalYear.removeChangeListener(this);
        jbCalculate.removeActionListener(this);
        jbClean.removeActionListener(this);
    }

    @Override
    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyTax, SModConsts.HRS_TAX, SLibConsts.UNDEFINED, null);
        miClient.getSession().populateCatalogue(moKeyTaxSubsidy, SModConsts.HRS_TAX_SUB, SLibConsts.UNDEFINED, null);
        miClient.getSession().populateCatalogue(moKeyPaymentType, SModConsts.HRSS_TP_PAY, SLibConsts.UNDEFINED, null);
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();
        
        if (validation.isValid()) {
            if (SLibTimeUtils.digestYear(moDateDateCutoff.getValue())[0] < moCalYear.getValue()) {
                validation.setMessage("El año del campo '" + SGuiUtils.getLabelName(jlDateCutoff) + "' debe ser mayor o igual al campo '" + SGuiUtils.getLabelName(jlYear) + "'.");
                validation.setComponent(moDateDateCutoff);
            }
            else if (SLibTimeUtils.digestYear(moDateDateCutoff.getValue())[0] - moCalYear.getValue() > 1) {
                validation.setMessage("La diferencia entre el año del campo '" + SGuiUtils.getLabelName(jlDateCutoff) + "' y el campo '" + SGuiUtils.getLabelName(jlYear) + "' no puede ser mayor a 1.");
                validation.setComponent(moDateDateCutoff);
            }
            
            if (validation.isValid() && moRadFilterTypeDateCut.isSelected()) {
                int diffDays = (int) SLibTimeUtils.getDaysDiff(moDateDateCutoff.getValue(), SLibTimeUtils.createDate(moCalYear.getValue(), 12, 31));
                
                if (diffDays > 6) {
                    validation.setMessage(SGuiConsts.ERR_MSG_FIELD_DIF + "'" + SGuiUtils.getLabelName(jlDateCutoff) + "'.");
                    validation.setComponent(moDateDateCutoff);
                }
                
                if (validation.isValid() && SLibTimeUtils.digestYear(moDateDateCutoff.getValue())[0] != moCalYear.getValue()) {
                    if (miClient.showMsgBoxConfirm("Los días gravables de acuerdo a la fecha de corte son mayores a " + (SLibTimeUtils.isLeapYear(moCalYear.getValue()) ? SHrsConsts.YEAR_DAYS + 1 : SHrsConsts.YEAR_DAYS) + " que tiene el ejercicio especificado, el calculo se verá afectado.\n " + SGuiConsts.MSG_CNF_CONT) != JOptionPane.YES_OPTION) {
                        validation.setMessage(SGuiConsts.ERR_MSG_FIELD_DIF + "'" + SGuiUtils.getLabelName(jlDateCutoff) + "'.");
                        validation.setComponent(moDateDateCutoff);
                    }
                }
            }
        }
        
        return validation;
    }

    @Override
    public void setValue(final int type, final Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValue(final int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            
            if (button == jbCalculate) {
                actionCalculate();
            }
            else if (button == jbClean) {
                actionClean();
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof SBeanFieldRadio) {
            if ((SBeanFieldRadio) e.getSource() == moRadFilterTypeDateCut || (SBeanFieldRadio) e.getSource() == moRadFilterTypeYear) {
                actionEnableFieldsTypeCal();
            }
        }
        else if (e.getSource() instanceof JSpinner) {
            SBeanFieldCalendarYear spinner = (SBeanFieldCalendarYear) e.getSource();

            if (spinner == moCalYear) {
                actionStateChangeYear();
            }
        }
    }
}
