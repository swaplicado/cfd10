/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.mod.SModConsts;
import erp.mod.hrs.db.SDbEmployee;
import erp.mod.hrs.db.SDbLoan;
import erp.mod.hrs.db.SRowLoanPaymentCardex;
import java.awt.BorderLayout;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.db.SDbRegistryUser;
import sa.lib.grid.SGridColumnForm;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridPaneForm;
import sa.lib.grid.SGridRow;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 *
 * @author Juan Barajas
 */
public class SDialogLoanPaymentsCardex extends SBeanFormDialog {
    
    protected SDbLoan moLoan;
    private SGridPaneForm moGridPaymentMoves;
    private Date mtDateCut;

    /**
     * Creates new form SDialogLoanPaymentsCardex
     * @param client
     * @param title
     */
    public SDialogLoanPaymentsCardex(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.HRSX_LOAN_PAY, SLibConsts.UNDEFINED, title);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlEmployeeName = new javax.swing.JLabel();
        moTextEmployeeName = new sa.lib.gui.bean.SBeanFieldText();
        jPanel2 = new javax.swing.JPanel();
        jlLoanType = new javax.swing.JLabel();
        moTextLoanType = new sa.lib.gui.bean.SBeanFieldText();
        jlLoanPaymentType = new javax.swing.JLabel();
        moTextLoanPaymentType = new sa.lib.gui.bean.SBeanFieldText();
        jPanel10 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moTextDateStart = new sa.lib.gui.bean.SBeanFieldText();
        jlDummy = new javax.swing.JLabel();
        jlDateEnd_n = new javax.swing.JLabel();
        moTextDateEnd_n = new sa.lib.gui.bean.SBeanFieldText();
        jPanel6 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jlTotalAmount = new javax.swing.JLabel();
        moCurTotalAmount = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();
        jPanel11 = new javax.swing.JPanel();
        jlTotalEarning = new javax.swing.JLabel();
        moCurTotalEarning = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();
        jPanel13 = new javax.swing.JPanel();
        jlTotalDeductions = new javax.swing.JLabel();
        moCurTotalDeductions = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();
        jPanel14 = new javax.swing.JPanel();
        jlTotalBalance = new javax.swing.JLabel();
        moCurTotalBalance = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();
        jpPayments = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Préstamo:"));
        jPanel4.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlEmployeeName.setText("Empleado:");
        jlEmployeeName.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel7.add(jlEmployeeName);

        moTextEmployeeName.setText("sBeanFieldText2");
        moTextEmployeeName.setPreferredSize(new java.awt.Dimension(375, 23));
        jPanel7.add(moTextEmployeeName);

        jPanel4.add(jPanel7);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlLoanType.setText("Tipo crédito/préstamo:");
        jlLoanType.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel2.add(jlLoanType);

        moTextLoanType.setText("sBeanFieldText1");
        moTextLoanType.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel2.add(moTextLoanType);

        jlLoanPaymentType.setText("Tipo pago:");
        jlLoanPaymentType.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jlLoanPaymentType);

        moTextLoanPaymentType.setText("sBeanFieldText1");
        moTextLoanPaymentType.setPreferredSize(new java.awt.Dimension(140, 23));
        jPanel2.add(moTextLoanPaymentType);

        jPanel4.add(jPanel2);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial:");
        jlDateStart.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel10.add(jlDateStart);

        moTextDateStart.setText("sBeanFieldText7");
        moTextDateStart.setPreferredSize(new java.awt.Dimension(65, 23));
        jPanel10.add(moTextDateStart);

        jlDummy.setPreferredSize(new java.awt.Dimension(80, 23));
        jPanel10.add(jlDummy);

        jlDateEnd_n.setText("Fecha final:");
        jlDateEnd_n.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel10.add(jlDateEnd_n);

        moTextDateEnd_n.setText("sBeanFieldText7");
        moTextDateEnd_n.setPreferredSize(new java.awt.Dimension(65, 23));
        jPanel10.add(moTextDateEnd_n);

        jPanel4.add(jPanel10);

        jPanel12.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Saldo:"));
        jPanel6.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTotalAmount.setText("Total a pagar:");
        jlTotalAmount.setPreferredSize(new java.awt.Dimension(100, 23));
        jlTotalAmount.setRequestFocusEnabled(false);
        jPanel15.add(jlTotalAmount);
        jPanel15.add(moCurTotalAmount);

        jPanel6.add(jPanel15);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTotalEarning.setText("Percepciones:");
        jlTotalEarning.setPreferredSize(new java.awt.Dimension(100, 23));
        jlTotalEarning.setRequestFocusEnabled(false);
        jPanel11.add(jlTotalEarning);
        jPanel11.add(moCurTotalEarning);

        jPanel6.add(jPanel11);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTotalDeductions.setText("Deducciones:");
        jlTotalDeductions.setPreferredSize(new java.awt.Dimension(100, 23));
        jlTotalDeductions.setRequestFocusEnabled(false);
        jPanel13.add(jlTotalDeductions);
        jPanel13.add(moCurTotalDeductions);

        jPanel6.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTotalBalance.setText("Saldo:");
        jlTotalBalance.setPreferredSize(new java.awt.Dimension(100, 23));
        jlTotalBalance.setRequestFocusEnabled(false);
        jPanel14.add(jlTotalBalance);
        jPanel14.add(moCurTotalBalance);

        jPanel6.add(jPanel14);

        jPanel12.add(jPanel6, java.awt.BorderLayout.EAST);

        jPanel1.add(jPanel12, java.awt.BorderLayout.NORTH);

        jpPayments.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos:"));
        jpPayments.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jpPayments, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
       actionSave();
    }//GEN-LAST:event_closeDialog
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel jlDateEnd_n;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JLabel jlEmployeeName;
    private javax.swing.JLabel jlLoanPaymentType;
    private javax.swing.JLabel jlLoanType;
    private javax.swing.JLabel jlTotalAmount;
    private javax.swing.JLabel jlTotalBalance;
    private javax.swing.JLabel jlTotalDeductions;
    private javax.swing.JLabel jlTotalEarning;
    private javax.swing.JPanel jpPayments;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency moCurTotalAmount;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency moCurTotalBalance;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency moCurTotalDeductions;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency moCurTotalEarning;
    private sa.lib.gui.bean.SBeanFieldText moTextDateEnd_n;
    private sa.lib.gui.bean.SBeanFieldText moTextDateStart;
    private sa.lib.gui.bean.SBeanFieldText moTextEmployeeName;
    private sa.lib.gui.bean.SBeanFieldText moTextLoanPaymentType;
    private sa.lib.gui.bean.SBeanFieldText moTextLoanType;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 800, 500);
        mtDateCut = null;
        
        jbSave.setText("Cerrar");
        jbCancel.setEnabled(false);

        moTextEmployeeName.setTextSettings(SGuiUtils.getLabelName(jlEmployeeName), 150);
        moTextLoanType.setTextSettings(SGuiUtils.getLabelName(jlLoanType), 150);
        moTextLoanPaymentType.setTextSettings(SGuiUtils.getLabelName(jlLoanPaymentType), 150);
        moTextDateStart.setTextSettings(SGuiUtils.getLabelName(jlDateStart.getText()), 25);
        moTextDateEnd_n.setTextSettings(SGuiUtils.getLabelName(jlDateEnd_n.getText()), 25);
        moCurTotalAmount.setCompoundFieldSettings(miClient);
        moCurTotalAmount.getField().setDecimalSettings(SGuiUtils.getLabelName(jlTotalAmount), SGuiConsts.GUI_TYPE_DEC_AMT, false);
        moCurTotalEarning.setCompoundFieldSettings(miClient);
        moCurTotalEarning.getField().setDecimalSettings(SGuiUtils.getLabelName(jlTotalEarning), SGuiConsts.GUI_TYPE_DEC_AMT, false);
        moCurTotalDeductions.setCompoundFieldSettings(miClient);
        moCurTotalDeductions.getField().setDecimalSettings(SGuiUtils.getLabelName(jlTotalDeductions), SGuiConsts.GUI_TYPE_DEC_AMT, false);
        moCurTotalBalance.setCompoundFieldSettings(miClient);
        moCurTotalBalance.getField().setDecimalSettings(SGuiUtils.getLabelName(jlTotalBalance), SGuiConsts.GUI_TYPE_DEC_AMT, false);
        
        /*
        moFields.addField(moTextEmployeeName);
        moFields.addField(moTextLoanType);
        moFields.addField(moTextLoanPaymentType);
        moFields.addField(moTextDateStart);
        moFields.addField(moTextDateEnd_n);
        moFields.addField(moDateDateCutOff);
        moFields.addField(moCurTotalAmount.getField());
        moFields.addField(moCurTotalPayments.getField());
        moFields.addField(moCurTotalBalance.getField());
        */

        moGridPaymentMoves = new SGridPaneForm(miClient, SModConsts.HRSX_LOAN_PAY, SLibConsts.UNDEFINED, "Pagos del préstamo") {
            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                ArrayList<SGridColumnForm> gridColumnsForm = new ArrayList<SGridColumnForm>();

                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Fecha"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_INT_CAL_YEAR, "Ejercicio", 50));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_INT_CAL_MONTH, "Período", 50));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_M, "Tipo nómina", 75));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "No. nómina", 50));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Fecha inicial"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Fecha final"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Percepciones $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Deducciones $"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_USR, "Usr nvo"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE_DATETIME, "Usr TS nvo"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_USR, "Usr mod"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE_DATETIME, "Usr TS mod"));

                return gridColumnsForm;
            }
        };

        jpPayments.add(moGridPaymentMoves, BorderLayout.CENTER);
        
        moTextEmployeeName.setEditable(false);
        moTextLoanType.setEditable(false);
        moTextLoanPaymentType.setEditable(false);
        moTextDateStart.setEditable(false);
        moTextDateEnd_n.setEditable(false);
        moCurTotalAmount.getField().setEditable(false);
        moCurTotalEarning.getField().setEditable(false);
        moCurTotalDeductions.getField().setEditable(false);
        moCurTotalBalance.getField().setEditable(false);
        
        reloadCatalogues();
        addAllListeners();
    }

    @SuppressWarnings("unchecked")
    private void showPaymentsMoves() {
        double in = 0;
        double out = 0;
        double totalEarnings = 0;
        double totalDeductions = 0;
        Vector<SGridRow> rows = new Vector<>();
        String sql = "";
        ResultSet resultSet = null;

        try {
            sql = "SELECT IF(p.id_pay = 0,rcp_ear_cmp.dt, p.dt_end) AS f_dt, p.per_year, p.per AS f_period, IF(p.id_pay = 0,'', tp_pay.name) AS f_tp_pay, p.num AS f_num, IF(p.id_pay = 0,NULL, p.dt_sta) AS f_dt_sta, IF(p.id_pay = 0,NULL, p.dt_end) AS f_dt_end, 1 AS f_ord, rcp_ear.id_pay, rcp_ear.id_emp, rcp_ear.id_mov, bp.id_bp, bp.bp, rcp_ear.amt_r AS f_in, 0 AS f_out, " +
                    "rcp_ear.ts_usr_ins AS ts_usr_ins, rcp_ear.ts_usr_upd AS ts_usr_upd, ui.usr AS f_usr_ins, uu.usr AS f_usr_upd " +
                    "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS rcp ON rcp.id_pay = p.id_pay " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_EAR) + " AS rcp_ear ON rcp_ear.id_pay = rcp.id_pay AND rcp_ear.id_emp = rcp.id_emp " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_PAY) + " AS tp_pay ON tp_pay.id_tp_pay = p.fk_tp_pay " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS emp ON emp.id_emp = rcp.id_emp " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.BPSU_BP) + " AS bp ON bp.id_bp = emp.id_emp " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS ui ON rcp_ear.fk_usr_ins = ui.id_usr " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS uu ON rcp_ear.fk_usr_upd = uu.id_usr " +
                    "LEFT OUTER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_EAR_CMP) + " AS rcp_ear_cmp ON rcp_ear_cmp.id_pay = rcp_ear.id_pay AND rcp_ear_cmp.id_emp = rcp_ear.id_emp AND rcp_ear_cmp.id_mov = rcp_ear.id_mov " +
                    "WHERE (p.id_pay = 0 OR p.b_del = 0) AND rcp.b_del = 0 AND rcp_ear.b_del = 0 AND rcp_ear.fk_loan_emp_n = " + moLoan.getPkEmployeeId() + " AND rcp_ear.fk_loan_loan_n = " + moLoan.getPkLoanId() + " " + (mtDateCut == null ? "" : " AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(mtDateCut) + "' ") + " " +

                    "UNION " +

                    "SELECT IF(p.id_pay = 0,rcp_ded_cmp.dt, p.dt_end) AS f_dt, p.per_year, p.per AS f_period, IF(p.id_pay = 0,'', tp_pay.name) AS f_tp_pay, p.num AS f_num, IF(p.id_pay = 0,NULL, p.dt_sta) AS f_dt_sta, IF(p.id_pay = 0,NULL, p.dt_end) AS f_dt_end, 2 AS f_ord, rcp_ded.id_pay, rcp_ded.id_emp, rcp_ded.id_mov, bp.id_bp, bp.bp, 0 AS f_in, rcp_ded.amt_r AS f_out, " +
                    "rcp_ded.ts_usr_ins AS ts_usr_ins, rcp_ded.ts_usr_upd AS ts_usr_upd, ui.usr AS f_usr_ins, uu.usr AS f_usr_upd " +
                    "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_PAY) + " AS p " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP) + " AS rcp ON rcp.id_pay = p.id_pay " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_DED) + " AS rcp_ded ON rcp_ded.id_pay = rcp.id_pay AND rcp_ded.id_emp = rcp.id_emp " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSS_TP_PAY) + " AS tp_pay ON tp_pay.id_tp_pay = p.fk_tp_pay " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.HRSU_EMP) + " AS emp ON emp.id_emp = rcp.id_emp " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.BPSU_BP) + " AS bp ON bp.id_bp = emp.id_emp " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS ui ON rcp_ded.fk_usr_ins = ui.id_usr " +
                    "INNER JOIN " + SModConsts.TablesMap.get(SModConsts.USRU_USR) + " AS uu ON rcp_ded.fk_usr_upd = uu.id_usr " +
                    "LEFT OUTER JOIN " + SModConsts.TablesMap.get(SModConsts.HRS_PAY_RCP_DED_CMP) + " AS rcp_ded_cmp ON rcp_ded_cmp.id_pay = rcp_ded.id_pay AND rcp_ded_cmp.id_emp = rcp_ded.id_emp AND rcp_ded_cmp.id_mov = rcp_ded.id_mov " +
                    "WHERE (p.id_pay = 0 OR p.b_del = 0) AND rcp.b_del = 0 AND rcp_ded.b_del = 0 AND rcp_ded.fk_loan_emp_n = " + moLoan.getPkEmployeeId() + " AND rcp_ded.fk_loan_loan_n = " + moLoan.getPkLoanId() + " " + (mtDateCut == null ? "" : " AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(mtDateCut) + "' ") + " " +
                    "ORDER BY f_dt, per_year, f_period, f_tp_pay, f_num, f_dt_sta, f_dt_end, f_ord, id_pay, id_emp, id_mov ";

            resultSet = miClient.getSession().getStatement().executeQuery(sql);

            while (resultSet.next()) {
                SRowLoanPaymentCardex row = new SRowLoanPaymentCardex();
                row.setDate(resultSet.getDate("f_dt"));
                row.setYear(resultSet.getInt("per_year"));
                row.setPeriod(resultSet.getInt("f_period"));
                row.setPayrollType(resultSet.getString("f_tp_pay"));
                row.setNumber(resultSet.getString("f_num"));
                row.setDateStart(resultSet.getDate("f_dt_sta"));
                row.setDateEnd(resultSet.getDate("f_dt_end"));

                totalEarnings += in = resultSet.getDouble("f_in");
                totalDeductions += out = resultSet.getDouble("f_out");

                row.setAmount(in);
                row.setPayment(out);
                row.setUserInsert(resultSet.getString("f_usr_ins"));
                row.setDateUserInsert(resultSet.getTimestamp("ts_usr_ins"));
                row.setUserUpdate(resultSet.getString("f_usr_upd"));
                row.setDateUserUpdate(resultSet.getTimestamp("ts_usr_upd"));

                rows.add(row);
            }
            
            moCurTotalAmount.getField().setValue(moLoan.getTotalAmount());
            moCurTotalEarning.getField().setValue(totalEarnings);
            moCurTotalDeductions.getField().setValue(totalDeductions);
            moCurTotalBalance.getField().setValue((moLoan.getTotalAmount() + totalEarnings) - totalDeductions);

            moGridPaymentMoves.populateGrid(rows);
            moGridPaymentMoves.clearSortKeys();
            moGridPaymentMoves.setSelectedGridRow(0);
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }
    }
    
    private void initLoan() {
        SDbEmployee employee = null;
        
        employee = (SDbEmployee) miClient.getSession().readRegistry(SModConsts.HRSU_EMP, new int[] { moLoan.getPkEmployeeId() });
        
        moTextEmployeeName.setValue(employee.getAuxEmployee());
        moTextLoanType.setValue(miClient.getSession().readField(SModConsts.HRSS_TP_LOAN, new int[] { moLoan.getFkLoanTypeId() }, SDbRegistryUser.FIELD_NAME));
        moTextLoanPaymentType.setValue(miClient.getSession().readField(SModConsts.HRSS_TP_LOAN_PAY, new int[] { moLoan.getFkLoanPaymentTypeId() }, SDbRegistryUser.FIELD_NAME));
        moTextDateStart.setValue(SLibUtils.DateFormatDate.format(moLoan.getDateStart()));
        moTextDateEnd_n.setValue(moLoan.getDateEnd_n() == null ? "" : SLibUtils.DateFormatDate.format(moLoan.getDateEnd_n()));
        
        showPaymentsMoves();
    }
    
    @Override
    public void addAllListeners() {
    }

    @Override
    public void removeAllListeners() {
    }

    @Override
    public void reloadCatalogues() {
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
        
        return validation;
    }

    @Override
    public void setValue(final int type, final Object value) {
        switch (type) {
            case SModConsts.HRS_LOAN:
                moLoan = (SDbLoan) value;
                initLoan();
                break;
            case SGuiConsts.PARAM_DATE_END:
                mtDateCut = (Date) value;
                break;
            default:
                break;
        }
    }

    @Override
    public Object getValue(final int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
