/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.SClientUtils;
import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.bps.db.SDbBizPartner;
import erp.mod.hrs.db.SDbEmployee;
import erp.mod.hrs.db.SHrsEmployeeHireLog;
import erp.mod.hrs.db.SHrsEmployeeUtils;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author Juan Barajas, Sergio Flores
 */
public class SDialogEmployerSubstitution extends SBeanFormDialog {
    
    private static final String ERR_EMP_ACT = "¡El empleado debe estar inactivo para ser exportado a otra(s) empresa(s)!";

    protected SDbEmployee moEmployee;

    /**
     * Creates new form SDialogEmployeeEmployerSubstitution
     */
    public SDialogEmployerSubstitution(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.HRS_EMP_LOG_HIRE, SLibConsts.UNDEFINED, title);
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
        jPanel3 = new javax.swing.JPanel();
        jlEmployee = new javax.swing.JLabel();
        jtfEmployee = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jlNewEmployer = new javax.swing.JLabel();
        moKeyNewEmployer = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel11 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        moDateDate = new sa.lib.gui.bean.SBeanFieldDate();
        jlDateHint = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jlWarning = new javax.swing.JLabel();
        jtfWarning = new javax.swing.JTextField();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del movimiento:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlEmployee.setText("Empleado:");
        jlEmployee.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlEmployee);

        jtfEmployee.setEditable(false);
        jtfEmployee.setFocusable(false);
        jtfEmployee.setPreferredSize(new java.awt.Dimension(400, 23));
        jPanel3.add(jtfEmployee);

        jPanel2.add(jPanel3);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNewEmployer.setText("Patrón sustituto:*");
        jlNewEmployer.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlNewEmployer);

        moKeyNewEmployer.setPreferredSize(new java.awt.Dimension(400, 23));
        jPanel12.add(moKeyNewEmployer);

        jPanel2.add(jPanel12);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDate.setText("Fecha alta:*");
        jlDate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlDate);
        jPanel11.add(moDateDate);

        jlDateHint.setForeground(java.awt.SystemColor.textInactiveText);
        jlDateHint.setText("(con el patrón o los patrones sustitutos)");
        jlDateHint.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel11.add(jlDateHint);

        jPanel2.add(jPanel11);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlWarning.setText("Advertencia:");
        jlWarning.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlWarning);

        jtfWarning.setEditable(false);
        jtfWarning.setFocusable(false);
        jtfWarning.setPreferredSize(new java.awt.Dimension(400, 23));
        jPanel4.add(jtfWarning);

        jPanel2.add(jPanel4);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlDateHint;
    private javax.swing.JLabel jlEmployee;
    private javax.swing.JLabel jlNewEmployer;
    private javax.swing.JLabel jlWarning;
    private javax.swing.JTextField jtfEmployee;
    private javax.swing.JTextField jtfWarning;
    private sa.lib.gui.bean.SBeanFieldDate moDateDate;
    private sa.lib.gui.bean.SBeanFieldKey moKeyNewEmployer;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 560, 350);
        
        moEmployee = null;

        moDateDate.setDateSettings(miClient, SGuiUtils.getLabelName(jlDate.getText()), true);
        moKeyNewEmployer.setKeySettings(miClient, SGuiUtils.getLabelName(jlNewEmployer.getText()), true);

        moFields.addField(moDateDate);
        moFields.addField(moKeyNewEmployer);

        moFields.setFormButton(jbSave);

        jbSave.setText("Aceptar");
    }
    
    private void renderEmployee(final int[] employeePk) {
        try {
            moEmployee = (SDbEmployee) miClient.getSession().readRegistry(SModConsts.HRSU_EMP, employeePk);
            jtfEmployee.setText(moEmployee.getXtaEmployeeName());
            jtfEmployee.setCaretPosition(0);
            
            if (moEmployee.isActive()) {
                jtfWarning.setText(ERR_EMP_ACT);
            }
            else {
                jtfWarning.setText("¡Esta operación no puede ser revertida!");
            }
            jtfWarning.setCaretPosition(0);
        }
        catch (Exception e) {
            SLibUtils.printException(this, e);
        }
    }

    @Override
    public void initForm() {
        // Method to be overrided when needed
    }

    @Override
    public void resetForm() {
        removeAllListeners();
        reloadCatalogues();
        
        moKeyNewEmployer.resetField();
        moDateDate.setValue(miClient.getSession().getCurrentDate());
        
        addAllListeners();
    }
    
    @Override
    public void reloadCatalogues() {
        try {
            // get list of ID's of companies to wich the employee is already a member:
            ArrayList<Integer> membershipCompanyIds = SHrsEmployeeUtils.getMembershipCompanyIds(miClient.getSession().getStatement(), moEmployee.getPkEmployeeId());
            
            // get map of non sibling-company schemas (database names) with SIIE module of Human Resources enabled:
            HashMap<Integer, String> nonSiblingCompanySchemasMap = SHrsEmployeeUtils.getNonSiblingCompanySchemas(miClient.getSession().getStatement());
            
            // prepare GUI items of elegible companies to export current employee:
            
            SDbBizPartner company = new SDbBizPartner();
            ArrayList<SGuiItem> items = new ArrayList<>();
            items.add(new SGuiItem("- " + SUtilConsts.TXT_SELECT + " " + SGuiUtils.getLabelName(jlNewEmployer) + " -"));
            
            for (Integer nonSiblingCompanyId : nonSiblingCompanySchemasMap.keySet()) {
                if (!membershipCompanyIds.contains(nonSiblingCompanyId)) {
                    String name = (String) company.readField(miClient.getSession().getStatement(), new int[] { nonSiblingCompanyId }, SDbRegistry.FIELD_NAME);
                    items.add(new SGuiItem(new int[] { nonSiblingCompanyId }, name, nonSiblingCompanySchemasMap.get(nonSiblingCompanyId)));
                }
            }
            
            moKeyNewEmployer.removeAllItems();
            for (SGuiItem item : items) {
                moKeyNewEmployer.addItem(item);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();
        
        if (validation.isValid()) {
            if (moEmployee.isActive()) {
                validation.setMessage(ERR_EMP_ACT);
            }
        }
        
        return validation;
    }

    @Override
    public void addAllListeners() {
        
    }

    @Override
    public void removeAllListeners() {
        
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Set provided value.
     * @param type SModConsts.HRSU_EMP.
     * @param value  
     */
    @Override
    public void setValue(final int type, final Object value) {
        switch (type) {
            case SModConsts.HRSU_EMP:
                renderEmployee((int[]) value);
                break;
            default:
        }
    }

    /**
     * Get requested value.
     * @param type SModConsts.HRS_EMP_LOG_HIRE.
     * @return Requested value.
     */
    @Override
    public Object getValue(final int type) {
        Object value = null;
        
        try {
            switch (type) {
                case SModConsts.HRSU_EMP:
                    // new employer connection:
                    Connection connection = SClientUtils.createConnection((String) moKeyNewEmployer.getSelectedItem().getComplement()); // convenience variable
                    
                    /*
                    NOTE ON THE FOLLOWING SHrsEmployeeHireLog INSTANTIATION:
                    The purpouse of this object is to set a seldom way of creating and using a database connection when saving moEmployee,
                    in order to accomplish the task of exporting the employee to a new set of friend companies within ERP.
                    */
                    
                    SHrsEmployeeHireLog hrsEmployeeHireLog = new SHrsEmployeeHireLog(connection); // a Connection instance is needed for first-hiring movements
                    //hrsEmployeeHireLog.setPkEmployeeHireLogId(...);
                    hrsEmployeeHireLog.setPkEmployeeId(moEmployee.getPkEmployeeId());
                    //hrsEmployeeHireLog.setLastHireDate(...);
                    //hrsEmployeeHireLog.setLastHireNotes(...); 
                    //hrsEmployeeHireLog.setLastDismissalDate_n(...);
                    //hrsEmployeeHireLog.setLastDismissalNotes(...);
                    //hrsEmployeeHireLog.setIsHire(...);
                    //hrsEmployeeHireLog.setDeleted(...);
                    //hrsEmployeeHireLog.setFkDismissalType(...);
                    //hrsEmployeeHireLog.setFkUserInsertId(...);
                    //hrsEmployeeHireLog.setFkUserUpdateId(...);
                    
                    hrsEmployeeHireLog.setIsAuxFirstHiring(false); // employee has been hired at least once!
                    hrsEmployeeHireLog.setIsAuxForceFirstHiring(true); // to emulate a first-higing movement
                    hrsEmployeeHireLog.setIsAuxModification(false);
                    hrsEmployeeHireLog.setIsAuxCorrection(false);
                    hrsEmployeeHireLog.setAuxFormerEmployerConnection(miClient.getSession().getStatement().getConnection()); // former employer connection (in current user session)
                    
                    moEmployee.setActive(true); // re-active this inactive employee
                    moEmployee.setDateLastHire(moDateDate.getValue());
                    moEmployee.setFkSourceCompanyId(moKeyNewEmployer.getValue()[0]);
                    
                    moEmployee.setAuxHireLogDate(moDateDate.getValue());
                    moEmployee.setAuxHireLogNotes(SGuiUtils.getLabelName(jlNewEmployer).toUpperCase());
                    moEmployee.setAuxEmployeeDismissalTypeId(SModSysConsts.HRSU_TP_EMP_DIS_NON);
                    moEmployee.setAuxHrsEmployeeHireLog(hrsEmployeeHireLog);

                    value = moEmployee;
                    break;

                default:
            }
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }

        return value;
    }
}
