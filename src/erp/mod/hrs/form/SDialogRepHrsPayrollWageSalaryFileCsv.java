/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.client.SClientInterface;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SDbEarning;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFileChooser;
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
import sa.lib.gui.bean.SBeanFieldRadio;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SDialogRepHrsPayrollWageSalaryFileCsv extends SBeanFormDialog implements ChangeListener {
   
    private SPanelHrsFilterPayrollStatus moPanelHrsFilterPayrollStatus;
    
    /**
     * Creates new form SDialogRepHrsPayrollWageSalaryFileCsv
     * @param client
     * @param title
     */
    public SDialogRepHrsPayrollWageSalaryFileCsv(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT,  SModConsts.HRSR_WAGE_SAL_CSV, SLibConsts.UNDEFINED, title);
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

        moRadGroupFilterType = new javax.swing.ButtonGroup();
        moGroupOrderByEmployee = new javax.swing.ButtonGroup();
        moGroupOrderByDepartament = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        moRadFilterTypePeriod = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadFilterTypeDate = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadFilterTypeDatePay = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel35 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        moIntPeriodYear = new sa.lib.gui.bean.SBeanFieldCalendarYear();
        jPanel36 = new javax.swing.JPanel();
        jlPeriodStart = new javax.swing.JLabel();
        moIntPeriodStart = new sa.lib.gui.bean.SBeanFieldCalendarMonth();
        jPanel37 = new javax.swing.JPanel();
        jlPeriodEnd = new javax.swing.JLabel();
        moIntPeriodEnd = new sa.lib.gui.bean.SBeanFieldCalendarMonth();
        jPanel11 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moDateDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel12 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        moDateDateEnd = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel14 = new javax.swing.JPanel();
        jlPaymentType = new javax.swing.JLabel();
        moKeyPaymentType = new sa.lib.gui.bean.SBeanFieldKey();
        jpFilterStatusPay = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        moRadOrderByNumEmployee = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadOrderByNameEmployee = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel19 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        moRadOrderByNumDepartament = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadOrderByNameDepartament = new sa.lib.gui.bean.SBeanFieldRadio();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del reporte:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(8, 1, 0, 5));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moRadGroupFilterType.add(moRadFilterTypePeriod);
        moRadFilterTypePeriod.setText("Por periodo");
        jPanel3.add(moRadFilterTypePeriod);

        moRadGroupFilterType.add(moRadFilterTypeDate);
        moRadFilterTypeDate.setText("Por rango de fechas");
        moRadFilterTypeDate.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(moRadFilterTypeDate);

        moRadGroupFilterType.add(moRadFilterTypeDatePay);
        moRadFilterTypeDatePay.setText("Por fecha pago nómina");
        moRadFilterTypeDatePay.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(moRadFilterTypeDatePay);

        jPanel2.add(jPanel3);

        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlYear.setText("Ejercicio:*");
        jlYear.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel35.add(jlYear);
        jPanel35.add(moIntPeriodYear);

        jPanel2.add(jPanel35);

        jPanel36.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriodStart.setText("Período inicial:*");
        jlPeriodStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel36.add(jlPeriodStart);
        jPanel36.add(moIntPeriodStart);

        jPanel2.add(jPanel36);

        jPanel37.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriodEnd.setText("Período final:*");
        jlPeriodEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel37.add(jlPeriodEnd);
        jPanel37.add(moIntPeriodEnd);

        jPanel2.add(jPanel37);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial:*");
        jlDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlDateStart);
        jPanel11.add(moDateDateStart);

        jPanel2.add(jPanel11);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd.setText("Fecha final:*");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlDateEnd);
        jPanel12.add(moDateDateEnd);

        jPanel2.add(jPanel12);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPaymentType.setText("Periodo pago:");
        jlPaymentType.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlPaymentType);

        moKeyPaymentType.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel14.add(moKeyPaymentType);

        jPanel2.add(jPanel14);

        jpFilterStatusPay.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jpFilterStatusPay);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenamiento empleado:"));
        jPanel8.setLayout(new java.awt.GridLayout(2, 1));

        moGroupOrderByEmployee.add(moRadOrderByNumEmployee);
        moRadOrderByNumEmployee.setText("Número del empleado");
        jPanel8.add(moRadOrderByNumEmployee);

        moGroupOrderByEmployee.add(moRadOrderByNameEmployee);
        moRadOrderByNameEmployee.setText("Nombre del empleado");
        jPanel8.add(moRadOrderByNameEmployee);

        jPanel4.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel19.setLayout(new java.awt.BorderLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenamiento departamento:"));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1));

        moGroupOrderByDepartament.add(moRadOrderByNumDepartament);
        moRadOrderByNumDepartament.setText("Número del departamento");
        jPanel10.add(moRadOrderByNumDepartament);

        moGroupOrderByDepartament.add(moRadOrderByNameDepartament);
        moRadOrderByNameDepartament.setText("Nombre del departamento");
        jPanel10.add(moRadOrderByNameDepartament);

        jPanel19.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel4.add(jPanel19, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlPaymentType;
    private javax.swing.JLabel jlPeriodEnd;
    private javax.swing.JLabel jlPeriodStart;
    private javax.swing.JLabel jlYear;
    private javax.swing.JPanel jpFilterStatusPay;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateEnd;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateStart;
    private javax.swing.ButtonGroup moGroupOrderByDepartament;
    private javax.swing.ButtonGroup moGroupOrderByEmployee;
    private sa.lib.gui.bean.SBeanFieldCalendarMonth moIntPeriodEnd;
    private sa.lib.gui.bean.SBeanFieldCalendarMonth moIntPeriodStart;
    private sa.lib.gui.bean.SBeanFieldCalendarYear moIntPeriodYear;
    private sa.lib.gui.bean.SBeanFieldKey moKeyPaymentType;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeDate;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeDatePay;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypePeriod;
    private javax.swing.ButtonGroup moRadGroupFilterType;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNameDepartament;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNameEmployee;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNumDepartament;
    private sa.lib.gui.bean.SBeanFieldRadio moRadOrderByNumEmployee;
    // End of variables declaration//GEN-END:variables

    private void actionEnableFields() {
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
    
    private String getOrderBy() {
        String orderBy = "";
        
        if (moRadOrderByNumEmployee.isSelected()) {
            orderBy = "ORDER BY CAST(e.num AS UNSIGNED INTEGER), b.id_bp, ";
        }
        else if (moRadOrderByNameEmployee.isSelected()) {
            orderBy = "ORDER BY b.bp, b.id_bp, ";
        }
        
        if (moRadOrderByNumDepartament.isSelected()) {
            orderBy += "d.code, d.id_dep ";
        }
        else if (moRadOrderByNameDepartament.isSelected()) {
            orderBy += "d.name, d.id_dep ";
        }
        
        return orderBy;
    }

    private ArrayList<SDbEarning> getEarnings() throws Exception {
        ArrayList<SDbEarning> earnings = new ArrayList<>();

        String sql = "SELECT * "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EAR) + " "
                + "WHERE b_del = 0 "
                + "ORDER BY CONCAT(code, ' - ', name), id_ear ";

        Statement statement = miClient.getSession().getDatabase().getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            SDbEarning earning = new SDbEarning();
            earning.read(miClient.getSession(), new int[] { resultSet.getInt("id_ear") });
            earnings.add(earning);
        }

        return earnings;
    }
    
    /**
     * Get deductions array.
     * @param employeeId
     * @param sqlStatusPay
     * @return Deductios array. At index 0, whitholdings; at index 1, tax; at index 2, all deductions.
     * @throws Exception 
     */
    private double[] getDeductions(final int employeeId, final String sqlStatusPay) throws Exception {
        double deductions[] = null;

        String sql = "SELECT "
                + "SUM(IF(d.b_who = 1, prd.amt_r, 0.0)) AS f_ded_who, "
                + "SUM(IF(prd.fk_tp_ded = " + SModSysConsts.HRSS_TP_DED_TAX + ", prd.amt_r, 0.0)) AS f_ded_tax, "
                + "SUM(prd.amt_r) AS f_ded_all "
                + "FROM hrs_pay AS p "
                + "INNER JOIN hrs_pay_rcp AS pr ON pr.id_pay = p.id_pay "
                + (!moRadFilterTypeDatePay.isSelected() ?  "" : "INNER JOIN hrs_pay_rcp_iss AS rcp_iss ON rcp_iss.id_pay = pr.id_pay AND rcp_iss.id_emp = pr.id_emp "
                + "AND rcp_iss.dt_pay BETWEEN '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' "
                + "AND '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' AND rcp_iss.b_del = 0 AND rcp_iss.fk_st_rcp <> " + SModSysConsts.TRNS_ST_DPS_ANNULED + " ")
                + "INNER JOIN hrs_pay_rcp_ded AS prd ON prd.id_pay = pr.id_pay AND prd.id_emp = pr.id_emp "
                + "INNER JOIN hrs_ded AS d ON d.id_ded = prd.fk_ded "
                + "WHERE p.b_del = 0 AND pr.b_del = 0 AND prd.b_del = 0 " + sqlStatusPay
                + (moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " + moKeyPaymentType.getValue()[0] : "");
                
                if (moRadFilterTypePeriod.isSelected()) {
                    sql += " AND p.per_year = " + moIntPeriodYear.getValue() + " "
                            + "AND p.per BETWEEN " + moIntPeriodStart.getValue() + " AND " + moIntPeriodEnd.getValue() + " ";
                }
                else if (moRadFilterTypeDate.isSelected()) {
                    sql += " AND p.dt_sta >= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' ";
                }
                
                sql += " AND prd.id_emp = " + employeeId + " ";

        try (Statement statement = miClient.getSession().getDatabase().getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                deductions = new double[] {
                    SLibUtils.roundAmount(resultSet.getDouble("f_ded_who")),
                    SLibUtils.roundAmount(resultSet.getDouble("f_ded_tax")),
                    SLibUtils.roundAmount(resultSet.getDouble("f_ded_all"))
                };
            }
        }

        return deductions;
    }
    
    private void computeReport() {
        Cursor cursor = getCursor();
        int payrollStatus = (int) moPanelHrsFilterPayrollStatus.getValue(SLibConsts.UNDEFINED);

        try {
            miClient.getFileChooser().setSelectedFile(new File(getTitle() + " " + ((SClientInterface) miClient).getSessionXXX().getFormatters().getFileNameDatetimeFormat().format(new java.util.Date()) + ".csv"));
            if (miClient.getFileChooser().showSaveDialog(miClient.getFrame()) == JFileChooser.APPROVE_OPTION) {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));

                File file = new File(miClient.getFileChooser().getSelectedFile().getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

                ArrayList<SDbEarning> earnings = getEarnings();
                
                // Construir gravado y exento:
                
                String headerTaxExempt = "";
                String headerEarnings = ", , , ,"; // to shift headers left and keep space for employee number and name and department code and name
                
                for (SDbEarning earning : earnings) {
                    headerTaxExempt += "\"GRAVADO\",\"EXCENTO\",";
                    headerEarnings += "\"" + (earning.getCode() + " " + earning.getName()) + "\", ,";
                }
                
                String buffer = ((SClientInterface)miClient).getSessionXXX().getCompany().getCompany() + "\n";
                buffer += "REPORTE PARA DECLARACIÓN INFORMATIVA DE SUELDOS Y SALARIOS\n";
                if (moRadFilterTypeDate.isSelected() || moRadFilterTypeDatePay.isSelected()) {
                    buffer += "PERIODO: DEL " + SLibUtils.DateFormatDate.format(moDateDateStart.getValue()) + " AL " + SLibUtils.DateFormatDate.format(moDateDateEnd.getValue()) + "\n" ;
                }
                else {
                    buffer += "EJERCICIO: " + moIntPeriodYear.getValue() + " PERÍODO DEL " + moIntPeriodStart.getValue() + " AL " + moIntPeriodEnd.getValue() + "\n" ;
                }
                buffer += "PERÍODO DE PAGO: " + (moKeyPaymentType.getSelectedIndex() > 0 ? moKeyPaymentType.getSelectedItem() : "(TODOS)") + "\n\n";
                buffer += "Usuario: " + ((SClientInterface)miClient).getSessionXXX().getUser().getUser() + "\n";
                buffer += "Emisión: " + ((SClientInterface) miClient).getSessionXXX().getFormatters().getDatetimeFormat().format(new java.util.Date()) + "\n";
                
                bw.write(SLibUtilities.textToAscii(buffer));
                bw.write("\n\n");
                
                buffer = headerEarnings;
                bw.write(SLibUtilities.textToAscii(buffer));
                
                bw.write("\n");
                buffer = "\"CLAVE EMPLEADO\",\"EMPLEADO\",\"CÓDIGO DEPARTAMENTO\",\"DEPARTAMENTO\"," + headerTaxExempt + ""
                        + "\"SUBTOTAL GRAVADO\",\"SUBTOTAL EXCENTO\",\"PERCEPCIONES TODAS\","
                        + "\"DEDUCCIONES DE LEY\",\"ISR RET. SALARIOS\",\"DEDUCCIONES TODAS\","
                        + "\"PAGO TOTAL BRUTO\",\"PAGO TOTAL NETO\"";

                bw.write(SLibUtilities.textToAscii(buffer));
                
                String sql = "SELECT DISTINCT pre.id_emp, e.num, b.bp, d.code, d.name " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS pr ON pr.id_pay = p.id_pay " +
                        "INNER JOIN hrs_pay_rcp_ear AS pre ON pre.id_pay = pr.id_pay AND pre.id_emp = pr.id_emp " +
                        (!moRadFilterTypeDatePay.isSelected() ?  "" : " INNER JOIN hrs_pay_rcp_iss AS rcp_iss ON rcp_iss.id_pay = pr.id_pay AND rcp_iss.id_emp = pr.id_emp "
                        + "AND rcp_iss.dt_pay BETWEEN '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' "
                        + "AND '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' AND rcp_iss.b_del = 0 AND rcp_iss.fk_st_rcp <> " + SModSysConsts.TRNS_ST_DPS_ANNULED + " ") +
                        "INNER JOIN erp.hrsu_emp AS e ON e.id_emp = pre.id_emp " +
                        "INNER JOIN erp.bpsu_bp AS b ON b.id_bp = pre.id_emp " +
                        "INNER JOIN erp.hrsu_dep AS d ON d.id_dep = e.fk_dep " +
                        "WHERE p.b_del = 0 AND pr.b_del = 0 AND pre.b_del = 0 " +
                        (moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " + moKeyPaymentType.getValue()[0] : "") + " ";
                        
                if (moRadFilterTypePeriod.isSelected()) {
                    sql += " AND p.per_year = " + moIntPeriodYear.getValue() + " " +
                            "AND p.per BETWEEN " + moIntPeriodStart.getValue() + " AND " + moIntPeriodEnd.getValue() + " " + getOrderBy();
                }
                else if (moRadFilterTypeDate.isSelected()) {
                    sql += " AND p.dt_sta >= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' " + getOrderBy();
                }

                String sqlStatusPay = "";
                
                if (payrollStatus != SPanelHrsFilterPayrollStatus.STATUS_UNDEF) {
                    if (payrollStatus == SPanelHrsFilterPayrollStatus.STATUS_CLOSE) {
                        sql += sqlStatusPay = " AND p.b_clo = 1 ";                
                    }
                    else if (payrollStatus == SPanelHrsFilterPayrollStatus.STATUS_OPEN) {
                        sql += sqlStatusPay = " AND p.b_clo = 0 ";
                    }
                }

                try (Statement stEmployee = miClient.getSession().getStatement().getConnection().createStatement()) {
                    ResultSet rsEmployee = stEmployee.executeQuery(sql);
                    while (rsEmployee.next()) {
                        buffer = "";
                        
                        double totalTaxable = 0;
                        double totalExempt = 0;

                        int employeeId = rsEmployee.getInt("pre.id_emp");

                        buffer += "\"" + rsEmployee.getString("e.num").replace("\"", "'") + "\",";
                        buffer += "\"" + rsEmployee.getString("b.bp").replace("\"", "'") + "\",";
                        buffer += "\"" + rsEmployee.getString("d.code").replace("\"", "'") + "\",";
                        buffer += "\"" + rsEmployee.getString("d.name").replace("\"", "'") + "\",";

                        for (SDbEarning earning : earnings) {
                            sql = "SELECT SUM(pre.amt_taxa) AS f_taxable, SUM(pre.amt_exem) AS f_exempt " +
                                    "FROM hrs_pay AS p " +
                                    "INNER JOIN hrs_pay_rcp AS pr ON pr.id_pay = p.id_pay " +
                                    (!moRadFilterTypeDatePay.isSelected() ?  "" : " INNER JOIN hrs_pay_rcp_iss AS rcp_iss ON rcp_iss.id_pay = pr.id_pay AND rcp_iss.id_emp = pr.id_emp "
                                    + "AND rcp_iss.dt_pay BETWEEN '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' "
                                    + "AND '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' AND rcp_iss.b_del = 0 AND rcp_iss.fk_st_rcp <> " + SModSysConsts.TRNS_ST_DPS_ANNULED + " ") +
                                    "INNER JOIN hrs_pay_rcp_ear AS pre ON pre.id_pay = pr.id_pay AND pre.id_emp = pr.id_emp " +
                                    "WHERE p.b_del = 0 AND pr.b_del = 0 AND pre.b_del = 0 " + sqlStatusPay +
                                    (moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " + moKeyPaymentType.getValue()[0] : "") + " AND pre.id_emp = " + employeeId + " " +
                                    "AND pre.fk_ear = " + earning.getPkEarningId();

                                    if (moRadFilterTypePeriod.isSelected()) {
                                        sql += " AND p.per_year = " + moIntPeriodYear.getValue() + " " +
                                                "AND p.per BETWEEN " + moIntPeriodStart.getValue() + " AND " + moIntPeriodEnd.getValue() + " ";
                                    }
                                    else if (moRadFilterTypeDate.isSelected()) {
                                        sql += " AND p.dt_sta >= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "' AND p.dt_end <= '" + SLibUtils.DbmsDateFormatDate.format(moDateDateEnd.getValue()) + "' ";
                                    }

                            try (ResultSet resulSet = miClient.getSession().getStatement().executeQuery(sql)) {
                                while (resulSet.next()) {
                                    double taxable = SLibUtils.roundAmount(resulSet.getDouble("f_taxable"));
                                    double exempt = SLibUtils.roundAmount(resulSet.getDouble("f_exempt"));

                                    buffer += taxable + ",";
                                    buffer += exempt + ",";

                                    totalTaxable = SLibUtils.roundAmount(totalTaxable + taxable);
                                    totalExempt = SLibUtils.roundAmount(totalExempt + exempt);
                                }
                            }
                        }

                        double deductionWho = 0;
                        double deductionTax = 0;
                        double deductionAll = 0;
                        double totalPayed = SLibUtils.roundAmount(totalTaxable + totalExempt);
                        double[] deductions = getDeductions(employeeId, sqlStatusPay);
                        
                        if (deductions != null) {
                            deductionWho = SLibUtils.roundAmount(deductions[0]);
                            deductionTax = SLibUtils.roundAmount(deductions[1]);
                            deductionAll = SLibUtils.roundAmount(deductions[2]);
                        }

                        buffer += (totalTaxable) + ",";
                        buffer += (totalExempt) + ",";
                        buffer += (totalPayed) + ",";
                        
                        buffer += (deductionWho) + ",";
                        buffer += (deductionTax) + ",";
                        buffer += (deductionAll) + ",";

                        double paymentGross = SLibUtils.roundAmount(totalPayed - deductionWho);
                        double paymentNet = SLibUtils.roundAmount(totalPayed - deductionAll);

                        buffer += (paymentGross) + ",";
                        buffer += (paymentNet) + ",";

                        bw.write("\n");
                        bw.write(SLibUtilities.textToAscii(buffer));
                    }
                }
                
                bw.flush();
                bw.close();
                
                if (miClient.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
        }
        catch(Exception e) {
            SLibUtilities.renderException(this, e);
        }
        finally {
            setCursor(cursor);
        }
    }
    
    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 720, 450);
        
        moPanelHrsFilterPayrollStatus = new SPanelHrsFilterPayrollStatus(miClient);
        jpFilterStatusPay.add(moPanelHrsFilterPayrollStatus, BorderLayout.CENTER);
        moPanelHrsFilterPayrollStatus.setSelectedAll();
        
        jbSave.setText("Guardar");

        moRadFilterTypePeriod.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypePeriod.getText()), true);
        moRadFilterTypeDate.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypeDate.getText()), false);
        moRadFilterTypeDatePay.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypeDatePay.getText()), false);
        moIntPeriodYear.setCalendarSettings(SGuiUtils.getLabelName(jlYear.getText()));
        moIntPeriodStart.setCalendarSettings(SGuiUtils.getLabelName(jlPeriodStart.getText()));
        moIntPeriodEnd.setCalendarSettings(SGuiUtils.getLabelName(jlPeriodEnd.getText()));
        moDateDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart.getText()), true);
        moDateDateEnd.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd.getText()), true);
        moKeyPaymentType.setKeySettings(miClient, SGuiUtils.getLabelName(jlPaymentType.getText()), false);
        
        moFields.addField(moRadFilterTypePeriod);
        moFields.addField(moRadFilterTypeDate);
        moFields.addField(moRadFilterTypeDatePay);
        
        moFields.addField(moIntPeriodYear);
        moFields.addField(moIntPeriodStart);
        moFields.addField(moIntPeriodEnd);
        moFields.addField(moDateDateStart);
        moFields.addField(moDateDateEnd);
        moFields.addField(moKeyPaymentType);
        moFields.addField(moRadOrderByNumEmployee);
        moFields.addField(moRadOrderByNameEmployee);
        moFields.addField(moRadOrderByNumDepartament);
        moFields.addField(moRadOrderByNameDepartament);
        
        moFields.setFormButton(jbSave);
        
        moRadFilterTypePeriod.addChangeListener(this);
        moRadFilterTypeDate.addChangeListener(this);
        moRadFilterTypeDatePay.addChangeListener(this);
        
        Date start = SLibTimeUtils.getBeginOfYear(miClient.getSession().getCurrentDate());
        Date end = SLibTimeUtils.getEndOfYear(miClient.getSession().getCurrentDate());
        
        moRadFilterTypePeriod.setSelected(true);
        moIntPeriodYear.setValue(miClient.getSession().getCurrentYear());
        moIntPeriodStart.setValue(SLibTimeUtils.digestMonth(start)[1]);
        moIntPeriodEnd.setValue(SLibTimeUtils.digestMonth(end)[1]);
        moDateDateStart.setValue(start);
        moDateDateEnd.setValue(end);
        moRadOrderByNameEmployee.setSelected(true);
        moRadOrderByNameDepartament.setSelected(true);
        
        reloadCatalogues();
        actionEnableFields();
    }

    @Override
    public void addAllListeners() {
    }

    @Override
    public void removeAllListeners() {
    }
    
    @Override
    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyPaymentType, SModConsts.HRSS_TP_PAY, SLibConsts.UNDEFINED, null);
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        }
        
        return validation;
    }
    
    @Override
    public void actionSave() {
        if (jbSave.isEnabled()) {
            if (SGuiUtils.computeValidation(miClient, validateForm())) {
                computeReport();
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof SBeanFieldRadio) {
            if ((SBeanFieldRadio) e.getSource() == moRadFilterTypePeriod ||
                    (SBeanFieldRadio) e.getSource() == moRadFilterTypeDate ||
                    (SBeanFieldRadio) e.getSource() == moRadFilterTypeDatePay) {
                actionEnableFields();
            }
        }
    }
}
