/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SDbEmployee;
import erp.mod.hrs.db.SDbPayroll;
import erp.mod.hrs.db.SDbPayrollReceipt;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JButton;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.grid.SGridColumnForm;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridPaneForm;
import sa.lib.grid.SGridRow;
import sa.lib.grid.SGridRowCustom;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiItem;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFieldKey;

/**
 *
 * @author Sergio Flores
 */
public class SDialogLayoutGroceryService extends sa.lib.gui.bean.SBeanFormDialog implements java.awt.event.ActionListener, java.awt.event.ItemListener {
    
    private final int NAME_MAX_LEN_SI_VALE = 26;
    
    private SDbPayroll moPayroll;
    private SGridPaneForm moReceiptsGrid;
    private HashMap<Integer, SDbEmployee> moEmployeesMap;

    /**
     * Creates new form SDialogLayoutGroceryService
     * @param client GUI client.
     * @param payrollId Payroll ID.
     */
    public SDialogLayoutGroceryService(SGuiClient client, int payrollId) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT_READ, 0, 0, "Layout proveedor despensa");
        moPayroll = (SDbPayroll) miClient.getSession().readRegistry(SModConsts.HRS_PAY, new int[] { payrollId });
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

        moButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlPayroll = new javax.swing.JLabel();
        jtfPayrollPeriod = new javax.swing.JTextField();
        jtfPayrollNumber = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlPayrollDates = new javax.swing.JLabel();
        jtfPayrollDates = new javax.swing.JTextField();
        jlPayrollNet = new javax.swing.JLabel();
        jtfPayrollNet = new javax.swing.JTextField();
        jtfPayrollNetCur = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jlPayrollNotes = new javax.swing.JLabel();
        jtfPayrollNotes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlGroceryService = new javax.swing.JLabel();
        moKeyGroceryService = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel11 = new javax.swing.JPanel();
        jlReceiptsTotal = new javax.swing.JLabel();
        jtfReceiptsTotal = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jlReceiptsWithoutAccount = new javax.swing.JLabel();
        jtfReceiptsWithoutAccount = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jlReceiptsWithAccount = new javax.swing.JLabel();
        jtfReceiptsWithAccount = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jlAmountTotal = new javax.swing.JLabel();
        jtfAmountTotal = new javax.swing.JTextField();
        jtfAmountTotalCur = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jlAmountWithoutAccount = new javax.swing.JLabel();
        jtfAmountWithoutAccount = new javax.swing.JTextField();
        jtfAmountWithoutAccountCur = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jlAmountWithAccount = new javax.swing.JLabel();
        jtfAmountWithAccount = new javax.swing.JTextField();
        jtfAmountWithAccountCur = new javax.swing.JTextField();
        jpReceipts = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        moRadCopyWithAccount = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadCopyAll = new sa.lib.gui.bean.SBeanFieldRadio();
        jbCopyToClipboard = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la nómina:"));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPayroll.setText("Nómina:");
        jlPayroll.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlPayroll);

        jtfPayrollPeriod.setEditable(false);
        jtfPayrollPeriod.setText("2001-01");
        jtfPayrollPeriod.setFocusable(false);
        jtfPayrollPeriod.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel3.add(jtfPayrollPeriod);

        jtfPayrollNumber.setEditable(false);
        jtfPayrollNumber.setText("QNA. 1");
        jtfPayrollNumber.setFocusable(false);
        jtfPayrollNumber.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jtfPayrollNumber);

        jPanel1.add(jPanel3);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPayrollDates.setText("Período nómina:");
        jlPayrollDates.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlPayrollDates);

        jtfPayrollDates.setEditable(false);
        jtfPayrollDates.setText("01/01/2001 - 01/01/2001");
        jtfPayrollDates.setFocusable(false);
        jtfPayrollDates.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel5.add(jtfPayrollDates);

        jlPayrollNet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPayrollNet.setText("Alcance neto:");
        jlPayrollNet.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlPayrollNet);

        jtfPayrollNet.setEditable(false);
        jtfPayrollNet.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfPayrollNet.setText("9,999,999.99");
        jtfPayrollNet.setFocusable(false);
        jtfPayrollNet.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jtfPayrollNet);

        jtfPayrollNetCur.setEditable(false);
        jtfPayrollNetCur.setText("MXN");
        jtfPayrollNetCur.setFocusable(false);
        jtfPayrollNetCur.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel5.add(jtfPayrollNetCur);

        jPanel1.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPayrollNotes.setText("Comentarios:");
        jlPayrollNotes.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jlPayrollNotes);

        jtfPayrollNotes.setEditable(false);
        jtfPayrollNotes.setText("PAYROLL NOTES");
        jtfPayrollNotes.setFocusable(false);
        jtfPayrollNotes.setPreferredSize(new java.awt.Dimension(500, 23));
        jPanel6.add(jtfPayrollNotes);

        jPanel1.add(jPanel6);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Procesamiento de los recibos de la nómina:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(7, 1, 0, 5));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlGroceryService.setText("Prov. despensa:");
        jlGroceryService.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlGroceryService);

        moKeyGroceryService.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel7.add(moKeyGroceryService);

        jPanel4.add(jPanel7);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlReceiptsTotal.setText("Total recibos:");
        jlReceiptsTotal.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlReceiptsTotal);

        jtfReceiptsTotal.setEditable(false);
        jtfReceiptsTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfReceiptsTotal.setText("0");
        jtfReceiptsTotal.setFocusable(false);
        jtfReceiptsTotal.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel11.add(jtfReceiptsTotal);

        jPanel4.add(jPanel11);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlReceiptsWithoutAccount.setText("Recibos s/cuenta:");
        jlReceiptsWithoutAccount.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel9.add(jlReceiptsWithoutAccount);

        jtfReceiptsWithoutAccount.setEditable(false);
        jtfReceiptsWithoutAccount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfReceiptsWithoutAccount.setText("0");
        jtfReceiptsWithoutAccount.setFocusable(false);
        jtfReceiptsWithoutAccount.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel9.add(jtfReceiptsWithoutAccount);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlReceiptsWithAccount.setText("Recibos c/cuenta:");
        jlReceiptsWithAccount.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel10.add(jlReceiptsWithAccount);

        jtfReceiptsWithAccount.setEditable(false);
        jtfReceiptsWithAccount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfReceiptsWithAccount.setText("0");
        jtfReceiptsWithAccount.setFocusable(false);
        jtfReceiptsWithAccount.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel10.add(jtfReceiptsWithAccount);

        jPanel4.add(jPanel10);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAmountTotal.setText("Total monto:");
        jlAmountTotal.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlAmountTotal);

        jtfAmountTotal.setEditable(false);
        jtfAmountTotal.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfAmountTotal.setText("9,999,999.99");
        jtfAmountTotal.setFocusable(false);
        jtfAmountTotal.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jtfAmountTotal);

        jtfAmountTotalCur.setEditable(false);
        jtfAmountTotalCur.setText("MXN");
        jtfAmountTotalCur.setFocusable(false);
        jtfAmountTotalCur.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel14.add(jtfAmountTotalCur);

        jPanel4.add(jPanel14);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAmountWithoutAccount.setText("Monto s/cuenta:");
        jlAmountWithoutAccount.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlAmountWithoutAccount);

        jtfAmountWithoutAccount.setEditable(false);
        jtfAmountWithoutAccount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfAmountWithoutAccount.setText("9,999,999.99");
        jtfAmountWithoutAccount.setFocusable(false);
        jtfAmountWithoutAccount.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jtfAmountWithoutAccount);

        jtfAmountWithoutAccountCur.setEditable(false);
        jtfAmountWithoutAccountCur.setText("MXN");
        jtfAmountWithoutAccountCur.setFocusable(false);
        jtfAmountWithoutAccountCur.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel12.add(jtfAmountWithoutAccountCur);

        jPanel4.add(jPanel12);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAmountWithAccount.setText("Monto c/cuenta:");
        jlAmountWithAccount.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlAmountWithAccount);

        jtfAmountWithAccount.setEditable(false);
        jtfAmountWithAccount.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfAmountWithAccount.setText("9,999,999.99");
        jtfAmountWithAccount.setFocusable(false);
        jtfAmountWithAccount.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jtfAmountWithAccount);

        jtfAmountWithAccountCur.setEditable(false);
        jtfAmountWithAccountCur.setText("MXN");
        jtfAmountWithAccountCur.setFocusable(false);
        jtfAmountWithAccountCur.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel13.add(jtfAmountWithAccountCur);

        jPanel4.add(jPanel13);

        jPanel8.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel8, java.awt.BorderLayout.WEST);

        jpReceipts.setLayout(new java.awt.BorderLayout());

        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        moButtonGroup.add(moRadCopyWithAccount);
        moRadCopyWithAccount.setText("Copiar recibos c/cuenta");
        moRadCopyWithAccount.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel16.add(moRadCopyWithAccount);

        moButtonGroup.add(moRadCopyAll);
        moRadCopyAll.setText("Copiar todos los recibos");
        moRadCopyAll.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel16.add(moRadCopyAll);

        jbCopyToClipboard.setText("Copiar al portapapeles");
        jbCopyToClipboard.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel16.add(jbCopyToClipboard);

        jpReceipts.add(jPanel16, java.awt.BorderLayout.SOUTH);

        jPanel2.add(jpReceipts, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCopyToClipboard;
    private javax.swing.JLabel jlAmountTotal;
    private javax.swing.JLabel jlAmountWithAccount;
    private javax.swing.JLabel jlAmountWithoutAccount;
    private javax.swing.JLabel jlGroceryService;
    private javax.swing.JLabel jlPayroll;
    private javax.swing.JLabel jlPayrollDates;
    private javax.swing.JLabel jlPayrollNet;
    private javax.swing.JLabel jlPayrollNotes;
    private javax.swing.JLabel jlReceiptsTotal;
    private javax.swing.JLabel jlReceiptsWithAccount;
    private javax.swing.JLabel jlReceiptsWithoutAccount;
    private javax.swing.JPanel jpReceipts;
    private javax.swing.JTextField jtfAmountTotal;
    private javax.swing.JTextField jtfAmountTotalCur;
    private javax.swing.JTextField jtfAmountWithAccount;
    private javax.swing.JTextField jtfAmountWithAccountCur;
    private javax.swing.JTextField jtfAmountWithoutAccount;
    private javax.swing.JTextField jtfAmountWithoutAccountCur;
    private javax.swing.JTextField jtfPayrollDates;
    private javax.swing.JTextField jtfPayrollNet;
    private javax.swing.JTextField jtfPayrollNetCur;
    private javax.swing.JTextField jtfPayrollNotes;
    private javax.swing.JTextField jtfPayrollNumber;
    private javax.swing.JTextField jtfPayrollPeriod;
    private javax.swing.JTextField jtfReceiptsTotal;
    private javax.swing.JTextField jtfReceiptsWithAccount;
    private javax.swing.JTextField jtfReceiptsWithoutAccount;
    private javax.swing.ButtonGroup moButtonGroup;
    private sa.lib.gui.bean.SBeanFieldKey moKeyGroceryService;
    private sa.lib.gui.bean.SBeanFieldRadio moRadCopyAll;
    private sa.lib.gui.bean.SBeanFieldRadio moRadCopyWithAccount;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 800, 500);
        
        removeAllListeners();
        
        jbSave.setEnabled(false);
        jbCancel.setText(SUtilConsts.TXT_CLOSE);
        
        moFields.addField(moKeyGroceryService);
        moFields.addField(moRadCopyWithAccount);
        moFields.addField(moRadCopyAll);
        moFields.setFormButton(jbCopyToClipboard);
        
        jtfPayrollPeriod.setText(moPayroll.composePayrollPeriod());
        jtfPayrollNumber.setText(moPayroll.composePayrollNumber());
        jtfPayrollDates.setText(SLibUtils.DateFormatDate.format(moPayroll.getDateStart()) + " - " + SLibUtils.DateFormatDate.format(moPayroll.getDateEnd()));
        jtfPayrollNotes.setText(moPayroll.getNotes());
        jtfPayrollNet.setText(SLibUtils.getDecimalFormatAmount().format(moPayroll.getAuxTotalNet()));
        jtfPayrollNetCur.setText(miClient.getSession().getSessionCustom().getLocalCurrencyCode());
        jtfAmountTotalCur.setText(miClient.getSession().getSessionCustom().getLocalCurrencyCode());
        jtfAmountWithAccountCur.setText(miClient.getSession().getSessionCustom().getLocalCurrencyCode());
        jtfAmountWithoutAccountCur.setText(miClient.getSession().getSessionCustom().getLocalCurrencyCode());
        
        jtfPayrollPeriod.setCaretPosition(0);
        jtfPayrollNumber.setCaretPosition(0);
        jtfPayrollDates.setCaretPosition(0);
        jtfPayrollNotes.setCaretPosition(0);
        jtfPayrollNet.setCaretPosition(0);
        jtfPayrollNetCur.setCaretPosition(0);
        jtfAmountTotalCur.setCaretPosition(0);
        jtfAmountWithAccountCur.setCaretPosition(0);
        jtfAmountWithoutAccountCur.setCaretPosition(0);
        
        moRadCopyWithAccount.setSelected(true);
        
        moReceiptsGrid = new SGridPaneForm(miClient, 0, 0, "Recibos") {
            
            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }
            
            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                ArrayList<SGridColumnForm> columns = new ArrayList<>();

                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_BPR_L, "Empleado", 250));
                SGridColumnForm column = new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_S, "Cuenta despensa", 125);
                column.setApostropheOnCsvRequired(true);
                columns.add(column);
                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_AMT, "Monto $"));
                
                return columns;
            }
        };
        
        jpReceipts.add(moReceiptsGrid, BorderLayout.CENTER);
        
        computeReceipts();
        
        addAllListeners();
    }
    
    @SuppressWarnings("unchecked")
    private void computeReceipts() {
        moEmployeesMap = new HashMap<>();
        
        HashMap<Integer, GroceryService> groceryServicesMap = new HashMap<>();
        GroceryService groceryServiceGlobal = new GroceryService(0, "");
        
        for (SDbPayrollReceipt payrollReceipt : moPayroll.getChildPayrollReceipts()) {
            SDbEmployee employee = (SDbEmployee) miClient.getSession().readRegistry(SModConsts.HRSU_EMP, new int[] { payrollReceipt.getPkEmployeeId() });
            
            // get current grocery service:
            
            GroceryService groceryService = groceryServicesMap.get(employee.getFkGroceryServiceId());
            
            if (groceryService == null) {
                groceryService = new GroceryService(employee.getFkGroceryServiceId(), (String) miClient.getSession().readField(SModConsts.HRSS_GROCERY_SRV, new int[] { employee.getFkGroceryServiceId() }, SDbRegistry.FIELD_NAME));
                groceryServicesMap.put(employee.getFkGroceryServiceId(), groceryService);
            }
            
            // compute current grocery service:
            groceryService.addReceipt(employee.getGroceryServiceAccount(), payrollReceipt.getPayment_r());
            
            // compute global grocery service:
            groceryServiceGlobal.addReceipt(employee.getGroceryServiceAccount(), payrollReceipt.getPayment_r());
            
            // preserve employees:
            
            moEmployeesMap.put(employee.getPkEmployeeId(), employee);
        }
        
        // populate combo box of grocery services:
        
        moKeyGroceryService.removeAllItems();
        
        moKeyGroceryService.addItem(new SGuiItem(new int[] {}, "- " + SUtilConsts.TXT_SELECT + " proveedor despensa -", groceryServiceGlobal));
        
        for (Integer id : groceryServicesMap.keySet()) {
            GroceryService groceryService = groceryServicesMap.get(id);
            
            moKeyGroceryService.addItem(new SGuiItem(new int[] { groceryService.getId() }, groceryService.getName(), groceryService));
        }
        
        itemStateChangedGroceryService();
    }
    
    private void actionPerformedCopyToClipboard() {
        GroceryService groceryService = (GroceryService) moKeyGroceryService.getSelectedItem().getComplement();
        
        if (groceryService != null) {
            int count = 0;
            double total = 0;
            String string = "";
            DecimalFormat amountFormat = new DecimalFormat("#0.00");

            for (SGridRow row : moReceiptsGrid.getModel().getGridRows()) {
                Receipt receipt = (Receipt) row;
                if (moRadCopyAll.isSelected() || !receipt.getAccount().isEmpty()) {
                    count++;
                    total = SLibUtils.roundAmount(total + receipt.getAmount());

                    String name = "";

                    switch (groceryService.getId()) {
                        case SModSysConsts.HRSS_GROCERY_SRV_SI_VALE:
                            name = SLibUtils.textLeft(SLibUtils.textToAscii(receipt.getRowName().replaceAll(",", "")), NAME_MAX_LEN_SI_VALE);
                            break;
                        default:
                            name = receipt.getRowName();
                    }

                    string += (string.isEmpty() ? "" : "\n") + 
                            name + "\t'" + 
                            receipt.getAccount() + "\t" + 
                            amountFormat.format(receipt.getAmount());
                }
            }

            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(string);
            clipboard.setContents(stringSelection, stringSelection);

            miClient.showMsgBoxInformation("Información copiada al portapapeles:\n"
                    + "número de recibos: " + count + "\n"
                    + "monto total: $" + SLibUtils.getDecimalFormatAmount().format(total) + " " + miClient.getSession().getSessionCustom().getLocalCurrencyCode());
        }
    }
    
    private void itemStateChangedGroceryService() {
        Vector<SGridRow> rows = new Vector<>();
        GroceryService groceryService = (GroceryService) moKeyGroceryService.getSelectedItem().getComplement();
        
        if (groceryService == null) {
            jtfReceiptsTotal.setText("");
            jtfReceiptsWithAccount.setText("");
            jtfReceiptsWithoutAccount.setText("");
            jtfAmountTotal.setText("");
            jtfAmountWithAccount.setText("");
            jtfAmountWithoutAccount.setText("");
        }
        else {
            jtfReceiptsTotal.setText(SLibUtils.DecimalFormatInteger.format(groceryService.getReceiptsTotal()));
            jtfReceiptsWithAccount.setText(SLibUtils.DecimalFormatInteger.format(groceryService.getReceiptsWithAccount()));
            jtfReceiptsWithoutAccount.setText(SLibUtils.DecimalFormatInteger.format(groceryService.getReceiptsWithoutAccount()));
            jtfAmountTotal.setText(SLibUtils.getDecimalFormatAmount().format(groceryService.getAmountTotal()));
            jtfAmountWithAccount.setText(SLibUtils.getDecimalFormatAmount().format(groceryService.getAmountWithAccount()));
            jtfAmountWithoutAccount.setText(SLibUtils.getDecimalFormatAmount().format(groceryService.getAmountWithoutAccount()));
            
            if (groceryService.getId() != SModSysConsts.HRSS_GROCERY_SRV_NON) {
                for (SDbPayrollReceipt payrollReceipt : moPayroll.getChildPayrollReceipts()) {
                    SDbEmployee employee = moEmployeesMap.get(payrollReceipt.getPkEmployeeId());
                    if (employee.getFkGroceryServiceId() == groceryService.getId()) {
                        Receipt receipt = new Receipt(new int[] { employee.getPkEmployeeId() }, employee.getNumber(), employee.getXtaEmployeeName());
                        receipt.setAccount(employee.getGroceryServiceAccount());
                        receipt.setAmount(payrollReceipt.getPayment_r());
                        rows.add(receipt);
                    }
                }
            }
            
            if (moKeyGroceryService.getSelectedIndex() <= 0 || groceryService.getId() == SModSysConsts.HRSS_GROCERY_SRV_NON) {
                moRadCopyWithAccount.setEnabled(false);
                moRadCopyAll.setEnabled(false);
                jbCopyToClipboard.setEnabled(false);
            }
            else {
                moRadCopyWithAccount.setEnabled(true);
                moRadCopyAll.setEnabled(true);
                jbCopyToClipboard.setEnabled(true);
            }
        }
        
        moReceiptsGrid.populateGrid(rows);
    }
    
    @Override
    public void addAllListeners() {
        jbCopyToClipboard.addActionListener(this);
        moKeyGroceryService.addItemListener(this);
    }

    @Override
    public void removeAllListeners() {
        jbCopyToClipboard.removeActionListener(this);
        moKeyGroceryService.removeItemListener(this);
    }

    @Override
    public void reloadCatalogues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SGuiValidation validateForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            
            if (button == jbCopyToClipboard) {
                actionPerformedCopyToClipboard();
            }
        }
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof SBeanFieldKey && e.getStateChange() == ItemEvent.SELECTED) {
            SBeanFieldKey field = (SBeanFieldKey) e.getSource();
            
            if (field == moKeyGroceryService) {
                itemStateChangedGroceryService();
            }
        }
    }

    private class GroceryService {
        
        protected int mnId;
        protected String msName;
        protected int mnReceiptsTotal;
        protected int mnReceiptsWithAccount;
        protected double mdAmountTotal;
        protected double mdAmountWithAccount;
        
        public GroceryService(int id, String name) {
            mnId = id;
            msName = name;
            reset();
        }
        
        public int getId() {
            return mnId;
        }
        
        public String getName() {
            return msName;
        }
        
        public int getReceiptsTotal() {
            return mnReceiptsTotal;
        }
        
        public int getReceiptsWithAccount() {
            return mnReceiptsWithAccount;
        }
        
        public int getReceiptsWithoutAccount() {
            return mnReceiptsTotal - mnReceiptsWithAccount;
        }
        
        public double getAmountTotal() {
            return mdAmountTotal;
        }
        
        public double getAmountWithAccount() {
            return mdAmountWithAccount;
        }
        
        public double getAmountWithoutAccount() {
            return SLibUtils.roundAmount(mdAmountTotal - mdAmountWithAccount);
        }
        
        public void reset() {
            mnReceiptsTotal = 0;
            mnReceiptsWithAccount = 0;
            mdAmountTotal = 0;
            mdAmountWithAccount = 0;
        }
        
        public void addReceipt(String account, double amount) {
            mnReceiptsTotal++;
            mdAmountTotal = SLibUtils.roundAmount(mdAmountTotal + amount);
            
            if (!account.isEmpty()) {
                mnReceiptsWithAccount++;
                mdAmountWithAccount = SLibUtils.roundAmount(mdAmountWithAccount + amount);
            }
        }
    }
    
    private class Receipt extends SGridRowCustom {
        
        protected String msAccount;
        protected double mdAmount;
        
        public Receipt(int[] pk, String code, String name) {
            super(pk, code, name);
        }
        
        public void setAccount(String account) {
            msAccount = account;
        }
        
        public void setAmount(double amount) {
            mdAmount = amount;
        }
        
        public String getAccount() {
            return msAccount;
        }
        
        public double getAmount() {
            return mdAmount;
        }
        
        @Override
        public Object getRowValueAt(int col) {
            Object value = null;
            
            switch (col) {
                case 0:
                    value = msRowName;
                    break;
                case 1:
                    value = msAccount;
                    break;
                case 2:
                    value = mdAmount;
                    break;
                default:
            }
            
            return value;
        }

        @Override
        public void setRowValueAt(Object value, int col) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
