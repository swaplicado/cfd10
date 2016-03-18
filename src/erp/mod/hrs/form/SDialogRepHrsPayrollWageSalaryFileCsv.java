/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.client.SClientInterface;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.mod.SModConsts;
import erp.mod.hrs.db.SDbEarning;
import erp.mod.hrs.db.SHrsConsts;
import java.awt.Cursor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
 * @author Juan Barajas
 */
public class SDialogRepHrsPayrollWageSalaryFileCsv extends SBeanFormDialog implements ChangeListener {
   
    /**
     * Creates new form SDialogRepHrsPayrollWageSalaryFileCsv
     * @param client
     * @param title
     */
    public SDialogRepHrsPayrollWageSalaryFileCsv(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT,  SModConsts.HRSR_WAGE_SAL, SLibConsts.UNDEFINED, title);
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
        jbGrpOrderBy = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        moRadFilterTypePeriod = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadFilterTypeDate = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel35 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        moIntPeriodYear = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel36 = new javax.swing.JPanel();
        jlPeriodStart = new javax.swing.JLabel();
        moIntPeriodStart = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel37 = new javax.swing.JPanel();
        jlPeriodEnd = new javax.swing.JLabel();
        moIntPeriodEnd = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel11 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moDateDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel12 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        moDateDateEnd = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel14 = new javax.swing.JPanel();
        jlPaymentType = new javax.swing.JLabel();
        moKeyPaymentType = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jrbOrderByNumEmployee = new javax.swing.JRadioButton();
        jrbOrderByNameEmployee = new javax.swing.JRadioButton();
        jrbOrderByNumDepartament = new javax.swing.JRadioButton();
        jrbOrderByNameDepartament = new javax.swing.JRadioButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del reporte:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jPanel3.setLayout(new java.awt.BorderLayout());

        moRadGroupFilterType.add(moRadFilterTypePeriod);
        moRadFilterTypePeriod.setText("Por periodo");
        jPanel3.add(moRadFilterTypePeriod, java.awt.BorderLayout.WEST);

        moRadGroupFilterType.add(moRadFilterTypeDate);
        moRadFilterTypeDate.setText("Por rango de fechas");
        jPanel3.add(moRadFilterTypeDate, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlYear.setText("Ejercicio:*");
        jlYear.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel35.add(jlYear);

        moIntPeriodYear.setPreferredSize(new java.awt.Dimension(103, 23));
        jPanel35.add(moIntPeriodYear);

        jPanel2.add(jPanel35);

        jPanel36.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriodStart.setText("Período inicial:*");
        jlPeriodStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel36.add(jlPeriodStart);

        moIntPeriodStart.setPreferredSize(new java.awt.Dimension(103, 23));
        jPanel36.add(moIntPeriodStart);

        jPanel2.add(jPanel36);

        jPanel37.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPeriodEnd.setText("Período final:*");
        jlPeriodEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel37.add(jlPeriodEnd);

        moIntPeriodEnd.setPreferredSize(new java.awt.Dimension(103, 23));
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

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenamiento:"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.GridLayout(4, 1, 0, 2));

        jbGrpOrderBy.add(jrbOrderByNumEmployee);
        jrbOrderByNumEmployee.setText("Número del empleado");
        jPanel5.add(jrbOrderByNumEmployee);

        jbGrpOrderBy.add(jrbOrderByNameEmployee);
        jrbOrderByNameEmployee.setText("Nombre del empleado");
        jPanel5.add(jrbOrderByNameEmployee);

        jbGrpOrderBy.add(jrbOrderByNumDepartament);
        jrbOrderByNumDepartament.setText("Código del departamento y número del empleado");
        jPanel5.add(jrbOrderByNumDepartament);

        jbGrpOrderBy.add(jrbOrderByNameDepartament);
        jrbOrderByNameDepartament.setSelected(true);
        jrbOrderByNameDepartament.setText("Código del departamento y nombre del empleado");
        jPanel5.add(jrbOrderByNameDepartament);

        jPanel4.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.ButtonGroup jbGrpOrderBy;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlPaymentType;
    private javax.swing.JLabel jlPeriodEnd;
    private javax.swing.JLabel jlPeriodStart;
    private javax.swing.JLabel jlYear;
    private javax.swing.JRadioButton jrbOrderByNameDepartament;
    private javax.swing.JRadioButton jrbOrderByNameEmployee;
    private javax.swing.JRadioButton jrbOrderByNumDepartament;
    private javax.swing.JRadioButton jrbOrderByNumEmployee;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateEnd;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateStart;
    private sa.lib.gui.bean.SBeanFieldInteger moIntPeriodEnd;
    private sa.lib.gui.bean.SBeanFieldInteger moIntPeriodStart;
    private sa.lib.gui.bean.SBeanFieldInteger moIntPeriodYear;
    private sa.lib.gui.bean.SBeanFieldKey moKeyPaymentType;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypeDate;
    private sa.lib.gui.bean.SBeanFieldRadio moRadFilterTypePeriod;
    private javax.swing.ButtonGroup moRadGroupFilterType;
    // End of variables declaration//GEN-END:variables

    private void actionEnableFields() {
        if (moRadFilterTypePeriod.isSelected()) {
            moIntPeriodYear.setEnabled(true);
            moIntPeriodStart.setEnabled(true);    
            moIntPeriodEnd.setEnabled(true);
            moDateDateStart.setEnabled(false);
            moDateDateEnd.setEnabled(false);
        }
        else if (moRadFilterTypeDate.isSelected()) {
            moIntPeriodYear.setEnabled(false);
            moIntPeriodStart.setEnabled(false);    
            moIntPeriodEnd.setEnabled(false);
            moDateDateStart.setEnabled(true);
            moDateDateEnd.setEnabled(true);
        }
    }
    
    private String getOrderBy() {
        String orderBy = "";
        
        if (jrbOrderByNumEmployee.isSelected()) {
            orderBy = "ORDER BY e.num, b.id_bp, d.code, d.name, d.id_dep; ";
        }
        else if (jrbOrderByNameEmployee.isSelected()) {
            orderBy = "ORDER BY b.bp, b.id_bp, d.code, d.name, d.id_dep; ";
        }
        else if (jrbOrderByNumDepartament.isSelected()) {
            orderBy = "ORDER BY d.name, d.code, d.id_dep, e.num, b.id_bp; ";
        }
        else if (jrbOrderByNameDepartament.isSelected()) {
            orderBy = "ORDER BY d.name, d.code, d.id_dep, b.bp, b.id_bp; ";
        }
        
        return orderBy;
    }

    private ArrayList<SDbEarning> getEarnings() throws Exception {
        String sql = "";
        SDbEarning earning = null;
        ArrayList<SDbEarning> aEarnings = new ArrayList<SDbEarning>();
        ResultSet resultSet = null;
        Statement statement = miClient.getSession().getDatabase().getConnection().createStatement();

        sql = "SELECT * "
                + "FROM " + SModConsts.TablesMap.get(SModConsts.HRS_EAR) + " "
                + "WHERE b_del = 0 "
                + "ORDER BY CONCAT(code, ' - ', name), id_ear ";

        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            earning = new SDbEarning();
            earning.read(miClient.getSession(), new int[] { resultSet.getInt("id_ear") });
            aEarnings.add(earning);
        }

        return aEarnings;
    }
    
    private double[] getAmountDeductions(final int year, final int periodStart, final int periodEnd, final int employeeId) throws Exception {
        double amtDeduction[] = null;
        String sql = "";
        ResultSet resultSet = null;
        Statement statement = miClient.getSession().getDatabase().getConnection().createStatement();

        sql = "SELECT SUM(IF(d.b_who = 1, prd.amt_r, 0)) AS f_ded, SUM(prd.amt_r) AS f_ded_all " +
                "FROM hrs_pay AS p " +
                "INNER JOIN hrs_pay_rcp AS pr ON pr.id_pay = p.id_pay " +
                "INNER JOIN hrs_pay_rcp_ded AS prd ON prd.id_pay = pr.id_pay AND prd.id_emp = pr.id_emp " +
                "INNER JOIN hrs_ded AS d ON d.id_ded = prd.fk_ded " +
                "WHERE p.b_del = 0 AND pr.b_del = 0 AND prd.b_del = 0 AND p.per_year = " + year + " AND p.per BETWEEN " + periodStart + " AND " + periodEnd + " AND prd.id_emp = " + employeeId + " " +
                (moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " + moKeyPaymentType.getValue()[0] : "");

        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            amtDeduction = new double[2];
            
            amtDeduction[0] = resultSet.getDouble("f_ded");
            amtDeduction[1] = resultSet.getDouble("f_ded_all");
        }

        return amtDeduction;
    }
    
    private void computeReport() {
        String sql = "";
        ResultSet resulSetEmployee = null;
        ResultSet resulSet = null;
        String buffer = "";
        String sTaxExentHeader = "";
        String sEarningHeader = "";
        int nEmployeeId = 0;
        double dAmountTax = 0;
        double dAmountExem = 0;
        double dTotalAmountTax = 0;
        double dTotalAmountExem = 0;
        double dTotalAmountDelivered = 0;
        double dPayrollTax = 0;
        double dTotalCost = 0;
        double dEmployersImss = 0;
        double dDeduction = 0;
        double dDeductionAll = 0;
        double dTotalAmountGross = 0;
        double dTotalAmountNet = 0;
        double adAmountDeductions[];
        Cursor cursor = getCursor();
        ArrayList<SDbEarning> aEarnings = new ArrayList<SDbEarning>();

        try {
            miClient.getFileChooser().setSelectedFile(new File(getTitle() + " " + ((SClientInterface) miClient).getSessionXXX().getFormatters().getFileNameDatetimeFormat().format(new java.util.Date()) + ".csv"));
            if (miClient.getFileChooser().showSaveDialog(miClient.getFrame()) == JFileChooser.APPROVE_OPTION) {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));

                File file = new File(miClient.getFileChooser().getSelectedFile().getAbsolutePath());
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

                aEarnings = getEarnings();
                
                // Construir gravado y exento:
                
                sEarningHeader += ", , , ,";
                
                for (SDbEarning earning : aEarnings) {
                    sEarningHeader += "\"" + (earning.getCode() + " " + earning.getName()) + "\", ,";
                    sTaxExentHeader += "\"GRAVADO\",\"EXCENTO\",";
                }
                
                buffer = ((SClientInterface)miClient).getSessionXXX().getCompany().getCompany() + "\n";
                buffer += "REPORTE PARA DECLARACIÓN INFORMATIVA DE SUELDOS Y SALARIOS\n";
                buffer += "EJERCICIO: " + moIntPeriodYear.getValue() + " PERÍODO DEL " + moIntPeriodStart.getValue() + " AL " + moIntPeriodEnd.getValue() + "\n" ;
                buffer += "PERÍODO DE PAGO: " + (moKeyPaymentType.getSelectedIndex() > 0 ? moKeyPaymentType.getSelectedItem() : "(TODOS)") + "\n\n";
                buffer += "Usuario: " + ((SClientInterface)miClient).getSessionXXX().getUser().getUser() + "\n";
                buffer += "Emisión: " + ((SClientInterface) miClient).getSessionXXX().getFormatters().getDatetimeFormat().format(new java.util.Date()) + "\n";
                
                bw.write(SLibUtilities.textToAscii(buffer));
                bw.write("\n\n");
                
                buffer = sEarningHeader;
                bw.write(SLibUtilities.textToAscii(buffer));
                
                bw.write("\n");
                buffer = "EMPLEADO_ID\",\"EMPLEADO\",\"DEPARTAMENTO_ID\",\"DEPARTAMENTO\"," + sTaxExentHeader + ""
                        + "\"SUBTOTAL GRAVADO\",\"SUBTOTAL EXCENTO\",\"TOTAL ENTREGADO\",\"DEDUCCIONES DE LEY\",\"TODAS LAS DEDUCCIONES\",\"SALDO BRUTO\",\"SALDO NETO\"";

                bw.write(SLibUtilities.textToAscii(buffer));
                
                //moParamsMap.put("sDepartaments", sDepartamentsName.isEmpty() || (boolean) moPanelHrsDepartaments.getValue(SGuiConsts.PARAM_ROWS) ? "(TODOS)" : sDepartamentsName + " ");
                
                sql = "SELECT DISTINCT pre.id_emp, e.num, b.bp, d.code, d.name " +
                        "FROM hrs_pay AS p " +
                        "INNER JOIN hrs_pay_rcp AS pr ON pr.id_pay = p.id_pay " +
                        "INNER JOIN hrs_pay_rcp_ear AS pre ON pre.id_pay = pr.id_pay AND pre.id_emp = pr.id_emp " +
                        "INNER JOIN erp.hrsu_emp AS e ON e.id_emp = pre.id_emp " +
                        "INNER JOIN erp.bpsu_bp AS b ON b.id_bp = pre.id_emp " +
                        "INNER JOIN erp.hrsu_dep AS d ON d.id_dep = e.fk_dep " +
                        "WHERE p.b_del = 0 AND pr.b_del = 0 AND pre.b_del = 0 AND p.per_year = " + moIntPeriodYear.getValue() + " " +
                        "AND p.per BETWEEN " + moIntPeriodStart.getValue() + " AND " + moIntPeriodEnd.getValue() + " " +
                        (moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " + moKeyPaymentType.getValue()[0] : "") + " " +
                        getOrderBy();

                resulSetEmployee = miClient.getSession().getStatement().getConnection().createStatement().executeQuery(sql);
                while (resulSetEmployee.next()) {
                    dTotalAmountTax = 0;
                    dTotalAmountExem = 0;
                    dTotalAmountDelivered = 0;
                    dPayrollTax = 0;
                    dEmployersImss = 0;
                    dTotalCost = 0;
                    dDeduction = 0;
                    dDeductionAll = 0;
                    dTotalAmountGross = 0;
                    dTotalAmountNet = 0;
                    buffer = "";
                    
                    nEmployeeId = resulSetEmployee.getInt("pre.id_emp");
                    
                    buffer += "\"" + resulSetEmployee.getString("e.num").replace("\"", "'") + "\",";
                    buffer += "\"" + resulSetEmployee.getString("b.bp").replace("\"", "'") + "\",";
                    buffer += "\"" + resulSetEmployee.getString("d.code").replace("\"", "'") + "\",";
                    buffer += "\"" + resulSetEmployee.getString("d.name").replace("\"", "'") + "\",";
                    
                    for (SDbEarning earning : aEarnings) {
                        sql = "SELECT SUM(pre.amt_exem) AS f_exem, SUM(pre.amt_taxa) AS f_tax " +
                                "FROM hrs_pay AS p " +
                                "INNER JOIN hrs_pay_rcp AS pr ON pr.id_pay = p.id_pay " +
                                "INNER JOIN hrs_pay_rcp_ear AS pre ON pre.id_pay = pr.id_pay AND pre.id_emp = pr.id_emp " +
                                "WHERE p.b_del = 0 AND pr.b_del = 0 AND pre.b_del = 0 AND p.per_year = " + moIntPeriodYear.getValue() + " " +
                                "AND p.per BETWEEN " + moIntPeriodStart.getValue() + " AND " + moIntPeriodEnd.getValue() + " AND pre.id_emp = " + nEmployeeId + " " +
                                (moKeyPaymentType.getSelectedIndex() > 0 ? " AND p.fk_tp_pay = " + moKeyPaymentType.getValue()[0] : "") + " " +
                                "AND pre.fk_ear = " + earning.getPkEarningId() + " ";

                        resulSet = miClient.getSession().getStatement().executeQuery(sql);
                        while (resulSet.next()) {
                            
                            dAmountTax = resulSet.getDouble("f_tax");
                            dAmountExem = resulSet.getDouble("f_exem");

                            buffer += SLibUtils.round(dAmountTax, SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits()) + ",";
                            buffer += SLibUtils.round(dAmountExem, SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits()) + ",";
                            
                            dTotalAmountTax += dAmountTax;
                            dTotalAmountExem += dAmountExem;
                        }
                    }
                    dTotalAmountDelivered = SLibUtils.round(dTotalAmountTax + dTotalAmountExem, SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits());
                    dTotalCost = SLibUtils.round(dTotalAmountDelivered + dPayrollTax + dEmployersImss, SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits());
                    adAmountDeductions = getAmountDeductions(moIntPeriodYear.getValue(), moIntPeriodStart.getValue(), moIntPeriodEnd.getValue(), nEmployeeId);
                    if (adAmountDeductions != null) {
                        dDeduction = SLibUtils.round(adAmountDeductions[0], SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits());
                        dDeductionAll = SLibUtils.round(adAmountDeductions[1], SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits());
                    }
                    dTotalAmountGross = SLibUtils.round(dTotalAmountDelivered - dDeductionAll, SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits());
                    dTotalAmountNet = SLibUtils.round(dTotalAmountDelivered - dDeduction, SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits());
                    
                    buffer += (dTotalAmountTax) + ",";
                    buffer += (dTotalAmountExem) + ",";
                    buffer += (dTotalAmountDelivered) + ",";
                    /*
                    buffer += (dPayrollTax) + ",";
                    buffer += (dEmployersImss) + ",";
                    buffer += (dTotalCost) + ",";
                    */
                    buffer += (dDeduction) + ",";
                    buffer += (dDeductionAll) + ",";
                    buffer += (dTotalAmountGross) + ",";
                    buffer += (dTotalAmountNet) + ",";
                    
                    bw.write("\n");
                    bw.write(SLibUtilities.textToAscii(buffer));
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
        
        jbSave.setText("Guardar");

        moRadFilterTypePeriod.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypePeriod.getText()), true);
        moRadFilterTypeDate.setBooleanSettings(SGuiUtils.getLabelName(moRadFilterTypeDate.getText()), false);
        moIntPeriodYear.setIntegerSettings(SGuiUtils.getLabelName(jlYear.getText()), SGuiConsts.GUI_TYPE_INT_CAL_YEAR, true);
        moIntPeriodYear.setMinInteger(2000);
        moIntPeriodYear.setMaxInteger(2100);
        moIntPeriodStart.setIntegerSettings(SGuiUtils.getLabelName(jlPeriodStart.getText()), SGuiConsts.GUI_TYPE_INT_CAL_MONTH, true);
        moIntPeriodStart.setMaxInteger(SHrsConsts.YEAR_MONTHS);
        moIntPeriodEnd.setIntegerSettings(SGuiUtils.getLabelName(jlPeriodEnd.getText()), SGuiConsts.GUI_TYPE_INT_CAL_MONTH, true);
        moIntPeriodEnd.setMaxInteger(SHrsConsts.YEAR_MONTHS);
        moDateDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart.getText()), true);
        moDateDateEnd.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd.getText()), true);
        moKeyPaymentType.setKeySettings(miClient, SGuiUtils.getLabelName(jlPaymentType.getText()), false);
        
        moFields.addField(moRadFilterTypePeriod);
        moFields.addField(moRadFilterTypeDate);
        
        moFields.addField(moIntPeriodYear);
        moFields.addField(moIntPeriodStart);
        moFields.addField(moIntPeriodEnd);
        moFields.addField(moDateDateStart);
        moFields.addField(moDateDateEnd);
        moFields.addField(moKeyPaymentType);
        
        moFields.setFormButton(jbSave);
        
        moRadFilterTypePeriod.addChangeListener(this);
        moRadFilterTypeDate.addChangeListener(this);
        
        moRadFilterTypePeriod.setSelected(true);
        moDateDateStart.setValue(SLibTimeUtils.getBeginOfYear(miClient.getSession().getCurrentDate()));
        moDateDateEnd.setValue(SLibTimeUtils.getEndOfYear(miClient.getSession().getCurrentDate()));
        jrbOrderByNameDepartament.setSelected(true);
        
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
            else if (moRadFilterTypeDate.isSelected()) {
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
                    (SBeanFieldRadio) e.getSource() == moRadFilterTypeDate) {
                actionEnableFields();
            }
            
        }
    }
}
