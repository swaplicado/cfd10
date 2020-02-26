/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.mbps.data.SDataBizPartnerBranchBankAccount;
import erp.mfin.data.SDataAccountCash;
import erp.mod.SModConsts;
import erp.mod.bps.db.SDbBizPartner;
import erp.mod.fin.db.SFinConsts;
import erp.mod.fin.db.SFinUtils;
import erp.mod.hrs.db.SHrsConsts;
import erp.mod.hrs.db.SHrsPayrollUtils;
import erp.mod.hrs.db.SHrsUtils;
import erp.mod.hrs.db.SRowPayrollEmployee;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;
import javax.swing.JButton;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.grid.SGridColumnForm;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridPaneForm;
import sa.lib.grid.SGridRow;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiItem;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFieldKey;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SDialogLayoutPayroll extends SBeanFormDialog implements ActionListener, ItemListener {

    private erp.mbps.data.SDataBizPartnerBranchBankAccount moDataBizPartnerBranchBankAccount;
    
    private final int mnPayrollId;
    private SGridPaneForm moGridPaneEmployeesAvailable;
    private SGridPaneForm moGridPaneEmployeesSelected;

    /**
     * Creates new form SDialogLayoutPayroll
     * @param client GUI client.
     * @param payrollId Payroll ID.
     * @param title Title.
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
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jlDateEmission = new javax.swing.JLabel();
        moDateEmission = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel7 = new javax.swing.JPanel();
        jlPkLayout = new javax.swing.JLabel();
        moKeyLayout = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel13 = new javax.swing.JPanel();
        jlAccountDebit = new javax.swing.JLabel();
        moKeyAccountDebit = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel14 = new javax.swing.JPanel();
        jlConsecutiveDay = new javax.swing.JLabel();
        moIntConsecutiveDay = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel8 = new javax.swing.JPanel();
        jlBankFilter = new javax.swing.JLabel();
        moKeyBankFilter = new sa.lib.gui.bean.SBeanFieldKey();
        jlBankFilterHint = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jpEmployeesAvailable = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlAvailableCount = new javax.swing.JLabel();
        jlAvailableTotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jlDummy01 = new javax.swing.JLabel();
        jbAdd = new javax.swing.JButton();
        jbAddAll = new javax.swing.JButton();
        jbRemove = new javax.swing.JButton();
        jbRemoveAll = new javax.swing.JButton();
        jpReceiptSelect = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlSelectedCount = new javax.swing.JLabel();
        jlSelectedTotal = new javax.swing.JLabel();

        setTitle("Layout para pagos de nóminas");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos layout:"));
        jPanel15.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel16.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEmission.setText("Fecha aplicación:*");
        jlDateEmission.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlDateEmission);
        jPanel11.add(moDateEmission);

        jPanel16.add(jPanel11);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPkLayout.setText("Layout: *");
        jlPkLayout.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlPkLayout);

        moKeyLayout.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel7.add(moKeyLayout);

        jPanel16.add(jPanel7);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAccountDebit.setText("Cuenta cargo: *");
        jlAccountDebit.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlAccountDebit);

        moKeyAccountDebit.setPreferredSize(new java.awt.Dimension(400, 23));
        jPanel13.add(moKeyAccountDebit);

        jPanel16.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlConsecutiveDay.setText("Consecutivo día: *");
        jlConsecutiveDay.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlConsecutiveDay);
        jPanel14.add(moIntConsecutiveDay);

        jPanel16.add(jPanel14);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBankFilter.setText("Filtro banco:");
        jlBankFilter.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jlBankFilter);

        moKeyBankFilter.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel8.add(moKeyBankFilter);

        jlBankFilterHint.setForeground(java.awt.SystemColor.textInactiveText);
        jlBankFilterHint.setText("(al seleccionar empleados)");
        jlBankFilterHint.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel8.add(jlBankFilterHint);

        jPanel16.add(jPanel8);

        jPanel15.add(jPanel16, java.awt.BorderLayout.NORTH);

        jPanel9.setLayout(new java.awt.BorderLayout(5, 0));

        jpEmployeesAvailable.setBorder(javax.swing.BorderFactory.createTitledBorder("Recibos disponibles"));
        jpEmployeesAvailable.setPreferredSize(new java.awt.Dimension(450, 100));
        jpEmployeesAvailable.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jlAvailableCount.setText("n");
        jlAvailableCount.setPreferredSize(new java.awt.Dimension(350, 20));
        jlAvailableCount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jlAvailableCount);

        jlAvailableTotal.setText("$");
        jlAvailableTotal.setPreferredSize(new java.awt.Dimension(350, 20));
        jlAvailableTotal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jlAvailableTotal);

        jpEmployeesAvailable.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jPanel9.add(jpEmployeesAvailable, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.GridLayout(5, 1, 0, 5));
        jPanel12.add(jlDummy01);

        jbAdd.setText(">");
        jbAdd.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel12.add(jbAdd);

        jbAddAll.setText(">>");
        jbAddAll.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel12.add(jbAddAll);

        jbRemove.setText("<");
        jbRemove.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel12.add(jbRemove);

        jbRemoveAll.setText("<<");
        jbRemoveAll.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel12.add(jbRemoveAll);

        jPanel2.add(jPanel12, java.awt.BorderLayout.NORTH);

        jPanel9.add(jPanel2, java.awt.BorderLayout.CENTER);

        jpReceiptSelect.setBorder(javax.swing.BorderFactory.createTitledBorder("Recibos seleccionados"));
        jpReceiptSelect.setPreferredSize(new java.awt.Dimension(475, 100));
        jpReceiptSelect.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jlSelectedCount.setText("n");
        jlSelectedCount.setPreferredSize(new java.awt.Dimension(350, 20));
        jlSelectedCount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jlSelectedCount);

        jlSelectedTotal.setText("$");
        jlSelectedTotal.setPreferredSize(new java.awt.Dimension(350, 20));
        jlSelectedTotal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel4.add(jlSelectedTotal);

        jpReceiptSelect.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel9.add(jpReceiptSelect, java.awt.BorderLayout.EAST);

        jPanel15.add(jPanel9, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel15, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbAddAll;
    private javax.swing.JButton jbRemove;
    private javax.swing.JButton jbRemoveAll;
    private javax.swing.JLabel jlAccountDebit;
    private javax.swing.JLabel jlAvailableCount;
    private javax.swing.JLabel jlAvailableTotal;
    private javax.swing.JLabel jlBankFilter;
    private javax.swing.JLabel jlBankFilterHint;
    private javax.swing.JLabel jlConsecutiveDay;
    private javax.swing.JLabel jlDateEmission;
    private javax.swing.JLabel jlDummy01;
    private javax.swing.JLabel jlPkLayout;
    private javax.swing.JLabel jlSelectedCount;
    private javax.swing.JLabel jlSelectedTotal;
    private javax.swing.JPanel jpEmployeesAvailable;
    private javax.swing.JPanel jpReceiptSelect;
    private sa.lib.gui.bean.SBeanFieldDate moDateEmission;
    private sa.lib.gui.bean.SBeanFieldInteger moIntConsecutiveDay;
    private sa.lib.gui.bean.SBeanFieldKey moKeyAccountDebit;
    private sa.lib.gui.bean.SBeanFieldKey moKeyBankFilter;
    private sa.lib.gui.bean.SBeanFieldKey moKeyLayout;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 1040, 650);

        jbSave.setText("Aceptar");

        moDateEmission.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEmission), true);
        moKeyLayout.setKeySettings(miClient, SGuiUtils.getLabelName(jlPkLayout), true);
        moKeyAccountDebit.setKeySettings(miClient, SGuiUtils.getLabelName(jlAccountDebit), true);
        moIntConsecutiveDay.setIntegerSettings(SGuiUtils.getLabelName(jlConsecutiveDay), SGuiConsts.GUI_TYPE_INT, true);
        moKeyBankFilter.setKeySettings(miClient, SGuiUtils.getLabelName(jlBankFilter), false);

        moFields.addField(moDateEmission);
        moFields.addField(moKeyLayout);
        moFields.addField(moKeyAccountDebit);
        moFields.addField(moIntConsecutiveDay);
        moFields.addField(moKeyBankFilter);

        moFields.setFormButton(jbSave);

        moDateEmission.setValue(miClient.getSession().getCurrentDate());
        
        moGridPaneEmployeesAvailable = new SGridPaneForm(miClient, SModConsts.HRSX_PAY_REC_EMP, SLibConsts.UNDEFINED, "Empleados disponibles", null) {
            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                int col = 0;
                ArrayList<SGridColumnForm> gridColumnsForm = new ArrayList<>();
                SGridColumnForm[] columns = new SGridColumnForm[7];

                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_BPR_S, "Empleado", 200);
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_BPR, "Clave");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Percepciones $");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Deducciones $");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Alcance neto $");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "Banco");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "Cuenta bancaria");

                gridColumnsForm.addAll(Arrays.asList((SGridColumnForm[]) columns));

                return gridColumnsForm;
            }
        };

        moGridPaneEmployeesAvailable.setForm(null);
        moGridPaneEmployeesAvailable.setPaneFormOwner(null);
        jpEmployeesAvailable.add(moGridPaneEmployeesAvailable, BorderLayout.CENTER);

        moGridPaneEmployeesSelected = new SGridPaneForm(miClient, SModConsts.HRSX_PAY_LAY, SLibConsts.UNDEFINED, "Recibos de nómina", null) {
            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                int col = 0;
                ArrayList<SGridColumnForm> gridColumnsForm = new ArrayList<>();
                SGridColumnForm[] columns = new SGridColumnForm[7];

                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_BPR_S, "Empleado", 200);
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_BPR, "Clave");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Percepciones $");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Deducciones $");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Alcance neto $");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "Banco");
                columns[col++] = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "Cuenta bancaria");

                gridColumnsForm.addAll(Arrays.asList((SGridColumnForm[]) columns));

                return gridColumnsForm;
            }
        };

        moGridPaneEmployeesSelected.setForm(null);
        moGridPaneEmployeesSelected.setPaneFormOwner(null);
        jpReceiptSelect.add(moGridPaneEmployeesSelected, BorderLayout.CENTER);
        
        /* 2019-05-29, Sergio Flores: Prevent from preserving user preferences of grids in this dialog.
        mvFormGrids.add(moGridPaneEmployeesAvailable);
        mvFormGrids.add(moGridPaneEmployeesSelected);
        */
        
        populateEmployees();

        removeAllListeners();
        reloadCatalogues();
        addAllListeners();
        
        itemStateChangedLayout();
    }

    @SuppressWarnings("unchecked")
    private void populateLayoutBank() {
        Vector<SGuiItem> items = new Vector<>();

        items.add(new SGuiItem(new int[] { SLibConsts.UNDEFINED }, "- " + SUtilConsts.TXT_SELECT + " layout -"));
        items.add(new SGuiItem(new int[] { SFinConsts.LAY_BANK_BBAJ }, SFinConsts.TXT_LAY_BANK_BBAJ));
        items.add(new SGuiItem(new int[] { SFinConsts.LAY_BANK_BBVA }, SFinConsts.TXT_LAY_BANK_BBVA));
        items.add(new SGuiItem(new int[] { SFinConsts.LAY_BANK_CITI }, SFinConsts.TXT_LAY_BANK_CITI));
        items.add(new SGuiItem(new int[] { SFinConsts.LAY_BANK_HSBC }, SFinConsts.TXT_LAY_BANK_HSBC));
        items.add(new SGuiItem(new int[] { SFinConsts.LAY_BANK_SANT }, SFinConsts.TXT_LAY_BANK_SANT));

        moKeyLayout.removeAllItems();
        for (SGuiItem item : items) {
            moKeyLayout.addItem(item);
        }
    }

    @SuppressWarnings("unchecked")
    private void populateEmployees() {
        ArrayList<SRowPayrollEmployee> rowPayrollEmployees = null;
        
        try {
            rowPayrollEmployees = SHrsPayrollUtils.obtainRowPayrollEmployees(miClient.getSession(), mnPayrollId);
            
            // prepare bank filter:
            
            ArrayList<SGuiItem> banks = new ArrayList<>();
            boolean isEmptyBankAdded = false;
            
            // process bank filter:
            
            for (SRowPayrollEmployee row : rowPayrollEmployees) {
                if (row.getBank().isEmpty()) {
                    if (!isEmptyBankAdded) {
                        isEmptyBankAdded = true;
                        banks.add(0, new SGuiItem(new int[] { 0 }, SHrsConsts.EMPTY_BANK)); // add empty bank just after label item
                    }
                }
                else {
                    boolean add = true;
                    
                    for (SGuiItem bank : banks) {
                        if (bank.getPrimaryKey()[0] == row.getBankId()) {
                            add = false;
                            break;
                        }
                    }
                    
                    if (add) {
                        banks.add(new SGuiItem(new int[] { row.getBankId() }, row.getBank()));
                    }
                }
            }
            
            // set bank filter:
            
            banks.add(0, new SGuiItem("- " + SUtilConsts.TXT_SELECT + " " + SGuiUtils.getLabelName(jlBankFilter) + " -"));
            
            moKeyBankFilter.removeAllItems();
            for (SGuiItem bank : banks) {
                moKeyBankFilter.addItem(bank);
            }
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }

        moGridPaneEmployeesAvailable.populateGrid(new Vector<>(rowPayrollEmployees));
        moGridPaneEmployeesSelected.populateGrid(new Vector<>());
        
        computeTotals();
    }
    
    private void computeTotals() {
        int availableWithoutBank = 0;
        int availableWithoutBankAccount = 0;
        int availableWithPaymentZero = 0;
        double availableTotal = 0;
        
        for (SGridRow row : moGridPaneEmployeesAvailable.getModel().getGridRows()) {
            availableTotal = SLibUtils.roundAmount(availableTotal + ((SRowPayrollEmployee) row).getTotalNet());
            
            if (((SRowPayrollEmployee) row).getBank().isEmpty()) {
                availableWithoutBank++;
            }
            if (((SRowPayrollEmployee) row).getBankAccount().isEmpty()) {
                availableWithoutBankAccount++;
            }
            if (((SRowPayrollEmployee) row).getTotalNet() <= 0) {
                availableWithPaymentZero++;
            }
        }
        
        int selectedWithoutBank = 0;
        int selectedWithoutBankAccount = 0;
        int selectedWithPaymentZero = 0;
        double selectedTotal = 0;
        
        for (SGridRow row : moGridPaneEmployeesSelected.getModel().getGridRows()) {
            selectedTotal = SLibUtils.roundAmount(selectedTotal + ((SRowPayrollEmployee) row).getTotalNet());
            
            if (((SRowPayrollEmployee) row).getBank().isEmpty()) {
                selectedWithoutBank++;
            }
            if (((SRowPayrollEmployee) row).getBankAccount().isEmpty()) {
                selectedWithoutBankAccount++;
            }
            if (((SRowPayrollEmployee) row).getTotalNet() <= 0) {
                selectedWithPaymentZero++;
            }
        }
        
        jlAvailableTotal.setText("Total recibos disponibles: $ " + SLibUtils.getDecimalFormatAmount().format(availableTotal));
        jlAvailableCount.setText("Recibos disponibles: " + moGridPaneEmployeesAvailable.getModel().getRowCount() + "; "
                + "sin banco: " + availableWithoutBank + "; sin cuenta bancaria: " + availableWithoutBankAccount + "; "
                + "en cero: " + availableWithPaymentZero);
        
        jlSelectedTotal.setText("Total recibos seleccionados: $ " + SLibUtils.getDecimalFormatAmount().format(selectedTotal));
        jlSelectedCount.setText("Recibos seleccionados: " + moGridPaneEmployeesSelected.getModel().getRowCount() + "; "
                + "sin banco: " + selectedWithoutBank + "; sin cuenta bancaria: " + selectedWithoutBankAccount + "; "
                + "en cero: " + selectedWithPaymentZero);
    }

    private boolean actionPerformedAdd() {
        boolean added = true;

        if (moGridPaneEmployeesAvailable.getSelectedGridRow() == null) {
            miClient.showMsgBoxWarning(SGridConsts.MSG_SELECT_ROW);
            moGridPaneEmployeesAvailable.getTable().requestFocusInWindow();
        }
        else {
            try {
                int index = moGridPaneEmployeesAvailable.getTable().getSelectedRow();
                SRowPayrollEmployee rowAvailable = (SRowPayrollEmployee) moGridPaneEmployeesAvailable.getSelectedGridRow();
                
                moGridPaneEmployeesAvailable.removeGridRow(moGridPaneEmployeesAvailable.getTable().getSelectedRow());
                moGridPaneEmployeesAvailable.renderGridRows();
                moGridPaneEmployeesAvailable.setSelectedGridRow(index < moGridPaneEmployeesAvailable.getModel().getRowCount() ? index : moGridPaneEmployeesAvailable.getModel().getRowCount() - 1);

                SRowPayrollEmployee rowSelected = new SRowPayrollEmployee(rowAvailable);
                
                moGridPaneEmployeesSelected.addGridRow(rowSelected);
                moGridPaneEmployeesSelected.renderGridRows();
                moGridPaneEmployeesSelected.setSelectedGridRow(moGridPaneEmployeesSelected.getModel().getRowCount() - 1);
                
                computeTotals();
            }
            catch (Exception e) {
                added = false;
                SLibUtils.showException(this, e);
            }
        }

        return added;

    }

    private void actionPerformedAddAll() {
        String bank = "";
        
        if (moKeyBankFilter.getSelectedIndex() > 0) {
            bank = moKeyBankFilter.getSelectedItem().toString();

            if (bank.equals(SHrsConsts.EMPTY_BANK)) {
                bank = "";
            }
        }

        int from = 0;
        int rows = moGridPaneEmployeesAvailable.getTable().getRowCount();

        for (int row = 0; row < rows; row++) {
            moGridPaneEmployeesAvailable.setSelectedGridRow(from);
            
            if (moKeyBankFilter.getSelectedIndex() > 0) {
                if (!((SRowPayrollEmployee) moGridPaneEmployeesAvailable.getSelectedGridRow()).getBank().equals(bank)) {
                    from++;
                    continue;
                }
            }

            if (!actionPerformedAdd()) {
                from++;
            }
        }
    }

    private boolean actionPerformedRemove() {
        boolean removed = true;
        
        if (moGridPaneEmployeesSelected.getSelectedGridRow() == null) {
            miClient.showMsgBoxWarning("Se debe seleccionar un registro.");
            moGridPaneEmployeesSelected.getTable().requestFocusInWindow();
        }
        else {
            try {
                int index = moGridPaneEmployeesSelected.getTable().getSelectedRow();
                SRowPayrollEmployee rowSelected = (SRowPayrollEmployee) moGridPaneEmployeesSelected.getSelectedGridRow();

                moGridPaneEmployeesSelected.removeGridRow(moGridPaneEmployeesSelected.getTable().getSelectedRow());
                moGridPaneEmployeesSelected.renderGridRows();
                moGridPaneEmployeesSelected.setSelectedGridRow(index < moGridPaneEmployeesSelected.getModel().getRowCount() ? index : moGridPaneEmployeesSelected.getModel().getRowCount() - 1);

                SRowPayrollEmployee rowAvailable = new SRowPayrollEmployee(rowSelected);
                
                moGridPaneEmployeesAvailable.addGridRow(rowAvailable);
                moGridPaneEmployeesAvailable.renderGridRows();
                moGridPaneEmployeesAvailable.setSelectedGridRow(moGridPaneEmployeesAvailable.getModel().getRowCount() - 1);
                
                computeTotals();
            }
            catch (Exception e) {
                removed = false;
                SLibUtils.showException(this, e);
            }
        }

        return removed;
    }

    private void actionPerformedRemoveAll() {
        moGridPaneEmployeesSelected.setSelectedGridRow(0);

        while (moGridPaneEmployeesSelected.getSelectedGridRow() != null) {
            if (!actionPerformedRemove()) {
                break;
            }
            moGridPaneEmployeesSelected.setSelectedGridRow(0);
        }
    }
    
    private void itemStateChangedLayout() {
        moIntConsecutiveDay.resetField();
        moIntConsecutiveDay.setEditable(false);
        moKeyBankFilter.resetField();
        moKeyBankFilter.setEditable(false);
        
        if (moKeyLayout.getSelectedIndex() > 0) {
            switch (moKeyLayout.getValue()[0]) {
                case SFinConsts.LAY_BANK_BBAJ:
                case SFinConsts.LAY_BANK_CITI:
                    moIntConsecutiveDay.setEditable(true);
                    break;
                case SFinConsts.LAY_BANK_BBVA:
                case SFinConsts.LAY_BANK_HSBC:
                case SFinConsts.LAY_BANK_SANT:
                    break;
                default:
                    miClient.showMsgBoxError(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
            }
            
            int bank = SHrsConsts.BanksFinToHrs.get(moKeyLayout.getSelectedItem().getPrimaryKey()[0]);
            SGuiUtils.locateItem(moKeyBankFilter, new int[] { bank });
            moKeyBankFilter.setEnabled(true);
        }
    }

    @Override
    public void reloadCatalogues() {
        populateLayoutBank();
        miClient.getSession().populateCatalogue(moKeyAccountDebit, SModConsts.FIN_ACC_CASH, SModConsts.FINX_ACC_CASH_BANK, null);
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();
        
        if (validation.isValid()) {
            int layoutBankId = SFinUtils.getLayoutBankId(miClient.getSession(), moKeyLayout.getValue()[0]);
            SDataAccountCash accountCash = (SDataAccountCash) SDataUtilities.readRegistry((SClientInterface) miClient, SDataConstants.FIN_ACC_CASH, moKeyAccountDebit.getValue(), SLibConstants.EXEC_MODE_VERBOSE);
            moDataBizPartnerBranchBankAccount = (SDataBizPartnerBranchBankAccount) SDataUtilities.readRegistry((SClientInterface) miClient, SDataConstants.BPSU_BANK_ACC, accountCash.getBizPartnerBranchBankAccountKey(), SLibConstants.EXEC_MODE_VERBOSE);
            
            if (layoutBankId != moDataBizPartnerBranchBankAccount.getFkBankId()) {
                try {
                    validation.setMessage("El valor del campo '" + jlAccountDebit.getText() + "', debe pertenecer al banco "
                            + "'" + miClient.getSession().readField(SModConsts.BPSU_BP, new int[] { layoutBankId }, SDbBizPartner.FIELD_NAME) + "'.");
                    validation.setComponent(moKeyAccountDebit);
                }
                catch (Exception e) {
                    SLibUtils.showException(this, e);
                }
            }
            
            if (validation.isValid()) {
                if (moGridPaneEmployeesSelected.getModel().getRowCount() == 0) {
                    validation.setMessage("Debe seleccionar al menos un recibo para generar el layout.");
                    validation.setComponent(moGridPaneEmployeesAvailable.getTable());
                }
                else {
                    int withoutBank = 0;
                    int withoutBankAccount = 0;
                    int withPaymentZero = 0;
                    HashSet<String> banksSet = new HashSet<>();
                    
                    for (SGridRow gridRow : moGridPaneEmployeesSelected.getModel().getGridRows()) {
                        SRowPayrollEmployee row = (SRowPayrollEmployee) gridRow;
                        
                        if (row.getBank().isEmpty()) {
                            withoutBank++;
                        }
                        else {
                            banksSet.add(row.getBank());
                        }
                        
                        if (row.getBankAccount().isEmpty()) {
                            withoutBankAccount++;
                        }
                        
                        if (row.getTotalNet() <= 0) {
                            withPaymentZero++;
                        }
                    }
                    
                    if (banksSet.size() > 1) {
                        validation.setMessage("Todas las cuentas bancarias de los empleados seleccionados deben ser del mismo banco.");
                        validation.setComponent(moGridPaneEmployeesSelected.getTable());
                    }
                    else if (withoutBank > 0) {
                        validation.setMessage("Hay " + withoutBank + " " + (withoutBank == 1 ? "empleado selecionado" : "empleados seleccionados") + " sin banco.");
                        validation.setComponent(moGridPaneEmployeesSelected.getTable());
                    }
                    else if (withoutBankAccount > 0) {
                        validation.setMessage("Hay " + withoutBankAccount + " " + (withoutBankAccount == 1 ? "empleado selecionado" : "empleados seleccionados") + " sin cuenta bancaria.");
                        validation.setComponent(moGridPaneEmployeesSelected.getTable());
                    }
                    else if (withPaymentZero > 0) {
                        validation.setMessage("Hay " + withPaymentZero + " " + (withPaymentZero == 1 ? "empleado selecionado" : "empleados seleccionados") + " con pago en cero.");
                        validation.setComponent(moGridPaneEmployeesSelected.getTable());
                    }
                }
            }
        }
        
        return validation;
    }
    
    @Override
    public void actionSave() {
        if (jbSave.isEnabled()) {
            if (SGuiUtils.computeValidation(miClient, validateForm())) {
                ArrayList<Integer> employeesSelected = new ArrayList<>();
                
                for (SGridRow gridRow : moGridPaneEmployeesSelected.getModel().getGridRows()) {
                    SRowPayrollEmployee row = (SRowPayrollEmployee) gridRow;
                    
                    if (row.getTotalNet() > 0) {
                        employeesSelected.add(row.getPkEmployeeId());
                    }
                }
                
                if (employeesSelected.isEmpty()) {
                    SGuiValidation validation = new SGuiValidation();
                    validation.setMessage("No hay empleados seleccionados con alcance neto mayor a cero.");
                    validation.setComponent(moGridPaneEmployeesSelected.getTable());
                    SGuiUtils.computeValidation(miClient, validation);
                }
                else {
                    String[] employeeIds = new String[employeesSelected.size()];
                    for (int index = 0; index < employeesSelected.size(); index++) {
                        employeeIds[index] = employeesSelected.get(index).toString();
                    }

                    switch (moKeyLayout.getValue()[0]) {
                        case SFinConsts.LAY_BANK_BBAJ:
                            SHrsUtils.createPayrollLayoutBanBajio(miClient, mnPayrollId, moKeyLayout.getSelectedItem().getItem(), moDateEmission.getValue(), moDataBizPartnerBranchBankAccount.getBankAccountNumber(), moIntConsecutiveDay.getValue(), employeeIds);
                            break;
                        case SFinConsts.LAY_BANK_BBVA:
                            SHrsUtils.createPayrollLayoutBbva(miClient, mnPayrollId, miClient.getSession().getCurrentDate(), employeeIds);
                            break;
                        case SFinConsts.LAY_BANK_CITI:
                            SHrsUtils.createPayrollLayoutCitibanamex(miClient, mnPayrollId, moKeyLayout.getSelectedItem().getItem(), moDateEmission.getValue(), moDataBizPartnerBranchBankAccount.getBankAccountNumber(), moIntConsecutiveDay.getValue(), employeeIds, moDataBizPartnerBranchBankAccount.getFkBankId());
                            break;
                        case SFinConsts.LAY_BANK_HSBC:
                            SHrsUtils.createPayrollLayoutHsbc(miClient, mnPayrollId, miClient.getSession().getCurrentDate(), employeeIds, moDataBizPartnerBranchBankAccount.getBankAccountNumber());
                            break;
                        case SFinConsts.LAY_BANK_SANT:
                            SHrsUtils.createPayrollLayoutSantander(miClient, mnPayrollId, moDateEmission.getValue(), employeeIds, moDataBizPartnerBranchBankAccount.getBankAccountNumber());
                            break;
                        default:
                            miClient.showMsgBoxError(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
                    }

                    mnFormResult = SGuiConsts.FORM_RESULT_OK;
                    dispose();
                }
            }
        }
    }

    @Override
    public void addAllListeners() {
        jbAdd.addActionListener(this);
        jbAddAll.addActionListener(this);
        jbRemove.addActionListener(this);
        jbRemoveAll.addActionListener(this);
        moKeyLayout.addItemListener(this);
    }

    @Override
    public void removeAllListeners() {
        jbAdd.removeActionListener(this);
        jbAddAll.removeActionListener(this);
        jbRemove.removeActionListener(this);
        jbRemoveAll.removeActionListener(this);
        moKeyLayout.removeItemListener(this);
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            
            if (button == jbAdd) {
                actionPerformedAdd();
            }
            else if (button == jbAddAll) {
                actionPerformedAddAll();
            }
            else if (button == jbRemove) {
                actionPerformedRemove();
            }
            else if (button == jbRemoveAll) {
                actionPerformedRemoveAll();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof SBeanFieldKey) {
            SBeanFieldKey field = (SBeanFieldKey) e.getSource();
            
            if (field == moKeyLayout) {
                itemStateChangedLayout();
            }
        }
    }
}
