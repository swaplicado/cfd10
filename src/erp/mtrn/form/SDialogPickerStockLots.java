/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogStockLots.java
 *
 * Created on 8/02/2012, 08:38:22 AM
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mbps.data.SDataBizPartnerBranch;
import erp.mcfg.data.SDataCompanyBranchEntity;
import erp.mitm.data.SDataItem;
import erp.mitm.data.SDataUnit;
import erp.mtrn.data.STrnStockLotRow;
import erp.mtrn.data.STrnStockMove;
import erp.mtrn.data.STrnUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JButton;

/**
 *
 * @author Sergio Flores
 */
public class SDialogPickerStockLots extends javax.swing.JDialog implements ActionListener {

    private int mnFormResult;
    private boolean mbFirstTime;
    private erp.client.SClientInterface miClient;
    private erp.lib.table.STablePane moPaneLots;

    private int mnParamYear;
    private int[] manParamWarehouseKey;
    private int[] manParamIogKey_n;
    private boolean mbPickerMode;
    private erp.mitm.data.SDataItem moParamItem;
    private erp.mitm.data.SDataUnit moParamUnit;
    private erp.mbps.data.SDataBizPartnerBranch moParamCompanyBranch;
    private erp.mcfg.data.SDataCompanyBranchEntity moParamWarehouse;

    /** Creates new form SDialogStockLots
     * @param client GUI client interface.
     * @param pickerMode Flag that indicates if dialog is an option picker or if is used only for display.
     */
    public SDialogPickerStockLots(erp.client.SClientInterface client, boolean pickerMode) {
        super(client.getFrame(), true);

        miClient = client;
        mbPickerMode = pickerMode;

        initComponents();
        initComponentsExtra();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpItem = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlItem = new javax.swing.JLabel();
        jtfItemKey = new javax.swing.JTextField();
        jtfItem = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlWarehouse = new javax.swing.JLabel();
        jtfCompanyBranch = new javax.swing.JTextField();
        jtfCompanyBranchCode = new javax.swing.JTextField();
        jtfWarehouse = new javax.swing.JTextField();
        jtfWarehouseCode = new javax.swing.JTextField();
        jpLots = new javax.swing.JPanel();
        jpControls = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlStock = new javax.swing.JLabel();
        jtfStock = new javax.swing.JTextField();
        jtfStockUnitSymbol = new javax.swing.JTextField();
        jlYear = new javax.swing.JLabel();
        jtfYear = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lotes disponibles");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpItem.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de los lotes:"));
        jpItem.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlItem.setText("Ítem:");
        jlItem.setPreferredSize(new java.awt.Dimension(65, 23));
        jPanel4.add(jlItem);

        jtfItemKey.setEditable(false);
        jtfItemKey.setText("TEXT");
        jtfItemKey.setFocusable(false);
        jtfItemKey.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jtfItemKey);

        jtfItem.setEditable(false);
        jtfItem.setText("TEXT");
        jtfItem.setFocusable(false);
        jtfItem.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel4.add(jtfItem);

        jpItem.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlWarehouse.setText("Almacén:");
        jlWarehouse.setPreferredSize(new java.awt.Dimension(65, 23));
        jPanel5.add(jlWarehouse);

        jtfCompanyBranch.setBackground(java.awt.Color.lightGray);
        jtfCompanyBranch.setEditable(false);
        jtfCompanyBranch.setText("TEXT");
        jtfCompanyBranch.setFocusable(false);
        jtfCompanyBranch.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jtfCompanyBranch);

        jtfCompanyBranchCode.setBackground(java.awt.Color.lightGray);
        jtfCompanyBranchCode.setEditable(false);
        jtfCompanyBranchCode.setText("CODE");
        jtfCompanyBranchCode.setFocusable(false);
        jtfCompanyBranchCode.setPreferredSize(new java.awt.Dimension(55, 23));
        jPanel5.add(jtfCompanyBranchCode);

        jtfWarehouse.setBackground(java.awt.Color.lightGray);
        jtfWarehouse.setEditable(false);
        jtfWarehouse.setText("TEXT");
        jtfWarehouse.setFocusable(false);
        jtfWarehouse.setPreferredSize(new java.awt.Dimension(155, 23));
        jPanel5.add(jtfWarehouse);

        jtfWarehouseCode.setBackground(java.awt.Color.lightGray);
        jtfWarehouseCode.setEditable(false);
        jtfWarehouseCode.setText("CODE");
        jtfWarehouseCode.setFocusable(false);
        jtfWarehouseCode.setPreferredSize(new java.awt.Dimension(55, 23));
        jPanel5.add(jtfWarehouseCode);

        jpItem.add(jPanel5);

        getContentPane().add(jpItem, java.awt.BorderLayout.NORTH);

        jpLots.setBorder(javax.swing.BorderFactory.createTitledBorder("Lotes:"));
        jpLots.setLayout(new java.awt.BorderLayout(0, 5));
        getContentPane().add(jpLots, java.awt.BorderLayout.CENTER);

        jpControls.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        jpControls.add(jPanel1, java.awt.BorderLayout.EAST);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jlStock.setText("Existencias:");
        jlStock.setPreferredSize(new java.awt.Dimension(65, 23));
        jPanel2.add(jlStock);

        jtfStock.setBackground(new java.awt.Color(153, 204, 255));
        jtfStock.setEditable(false);
        jtfStock.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfStock.setText("0.00");
        jtfStock.setFocusable(false);
        jtfStock.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel2.add(jtfStock);

        jtfStockUnitSymbol.setBackground(new java.awt.Color(153, 204, 255));
        jtfStockUnitSymbol.setEditable(false);
        jtfStockUnitSymbol.setText("UNIT");
        jtfStockUnitSymbol.setFocusable(false);
        jtfStockUnitSymbol.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel2.add(jtfStockUnitSymbol);

        jlYear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlYear.setText("Año:");
        jlYear.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel2.add(jlYear);

        jtfYear.setBackground(new java.awt.Color(153, 204, 255));
        jtfYear.setEditable(false);
        jtfYear.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfYear.setText("2000");
        jtfYear.setFocusable(false);
        jtfYear.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel2.add(jtfYear);

        jpControls.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpControls, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-528)/2, (screenSize.height-359)/2, 528, 359);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int col = 0;
        STableColumnForm[] columns = null;

        col = 0;
        columns = new STableColumnForm[6];
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_INTEGER, "#", STableConstants.WIDTH_NUM_TINYINT);
        columns[col] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Cantidad", STableConstants.WIDTH_QUANTITY_2X);
        columns[col++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Lote", 150);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Caducidad", STableConstants.WIDTH_DATE);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Bloqueado", STableConstants.WIDTH_BOOLEAN);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Valor $", STableConstants.WIDTH_VALUE_2X);

        moPaneLots = new STablePane(miClient);
        jpLots.add(moPaneLots, BorderLayout.CENTER);

        for (STableColumnForm column : columns) {
            moPaneLots.addTableColumn(column);
        }

        moPaneLots.createTable();
        moPaneLots.getTable().getTableHeader().setReorderingAllowed(false);
        moPaneLots.getTable().getTableHeader().setResizingAllowed(false);

        if (mbPickerMode) {
            moPaneLots.setDoubleClickAction(this, "actionOk");
        }
        else {
            jbOk.setEnabled(false);
            jbCancel.setText(SLibConstants.TXT_CLOSE);
        }

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

        SFormUtilities.createActionMap(rootPane, this, "actionOk", "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionCancel", "cancel", KeyEvent.VK_ESCAPE, SLibConstants.UNDEFINED);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;

            if (mbPickerMode) {
                moPaneLots.getTable().requestFocus();
            }
            else {
                jbCancel.requestFocus();
            }
        }
    }

    public void actionOk() {
        SFormValidation validation = formValidate();

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            miClient.showMsgBoxWarning(validation.getMessage());
        }
        else {
            mnFormResult = SLibConstants.FORM_RESULT_OK;
            setVisible(false);
        }
    }

    public void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlItem;
    private javax.swing.JLabel jlStock;
    private javax.swing.JLabel jlWarehouse;
    private javax.swing.JLabel jlYear;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpItem;
    private javax.swing.JPanel jpLots;
    private javax.swing.JTextField jtfCompanyBranch;
    private javax.swing.JTextField jtfCompanyBranchCode;
    private javax.swing.JTextField jtfItem;
    private javax.swing.JTextField jtfItemKey;
    private javax.swing.JTextField jtfStock;
    private javax.swing.JTextField jtfStockUnitSymbol;
    private javax.swing.JTextField jtfWarehouse;
    private javax.swing.JTextField jtfWarehouseCode;
    private javax.swing.JTextField jtfYear;
    // End of variables declaration//GEN-END:variables

    public void setFormParams(final int year, final int itemId, final int unitId, final int[] warehouseKey, final int[] iogKey_n) {
        int row = 0;
        double stock = 0;
        Vector<STrnStockMove> stockMoves = null;

        mnParamYear = year;
        manParamWarehouseKey = warehouseKey;
        manParamIogKey_n = iogKey_n;

        moPaneLots.clearTableRows();

        if (itemId == SLibConstants.UNDEFINED) {
            moParamItem = null;
            moParamUnit = null;
            moParamCompanyBranch = null;
            moParamWarehouse = null;

            jtfItem.setText("");
            jtfItemKey.setText("");
            jtfCompanyBranch.setText("");
            jtfCompanyBranchCode.setText("");
            jtfWarehouse.setText("");
            jtfWarehouseCode.setText("");

            jtfStock.setText("");
            jtfStockUnitSymbol.setText("");
            jtfYear.setText("");
        }
        else {
            moParamItem = (SDataItem) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_ITEM, new int[] { itemId }, SLibConstants.EXEC_MODE_VERBOSE);
            moParamUnit = (SDataUnit) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_UNIT, new int[] { unitId }, SLibConstants.EXEC_MODE_VERBOSE);
            moParamCompanyBranch = (SDataBizPartnerBranch) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BPB, new int[] { manParamWarehouseKey[0] }, SLibConstants.EXEC_MODE_VERBOSE);
            moParamWarehouse = (SDataCompanyBranchEntity) SDataUtilities.readRegistry(miClient, SDataConstants.CFGU_COB_ENT, manParamWarehouseKey, SLibConstants.EXEC_MODE_VERBOSE);

            jtfItem.setText(moParamItem.getItem());
            jtfItem.setToolTipText(moParamItem.getItem());
            jtfItemKey.setText(moParamItem.getKey());
            jtfItemKey.setToolTipText(moParamItem.getKey());
            jtfCompanyBranch.setText(moParamCompanyBranch.getBizPartnerBranch());
            jtfCompanyBranchCode.setText(moParamCompanyBranch.getCode());
            jtfWarehouse.setText(moParamWarehouse.getEntity());
            jtfWarehouseCode.setText(moParamWarehouse.getCode());

            jtfItem.setCaretPosition(0);
            jtfItemKey.setCaretPosition(0);
            jtfCompanyBranch.setCaretPosition(0);
            jtfCompanyBranchCode.setCaretPosition(0);
            jtfWarehouse.setCaretPosition(0);
            jtfWarehouseCode.setCaretPosition(0);

            try {
                stockMoves = STrnUtilities.obtainAvailableLots(miClient, mnParamYear, manParamWarehouseKey, false, moParamItem.getPkItemId(), moParamUnit.getPkUnitId(), manParamIogKey_n);

                for (STrnStockMove stockMove : stockMoves) {
                    stock += stockMove.getQuantity();
                    stockMove.setAuxRowNumber(++row);
                    moPaneLots.addTableRow(new STrnStockLotRow(stockMove, STrnStockLotRow.TYPE_QTY_VAL));
                }

                moPaneLots.renderTableRows();
                moPaneLots.setTableRowSelection(0);
            }
            catch (Exception e) {
                SLibUtilities.renderException(this, e);
            }

            jtfStock.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(stock));
            jtfStockUnitSymbol.setText(moParamUnit.getSymbol());
            jtfYear.setText(miClient.getSessionXXX().getFormatters().getYearFormat().format(mnParamYear));

            jtfStock.setCaretPosition(0);
            jtfStockUnitSymbol.setCaretPosition(0);
            jtfYear.setCaretPosition(0);
        }
    }

    public int getFormResult() {
        return mnFormResult;
    }

    public STrnStockMove getSelectecStockMove() {
        return (STrnStockMove) moPaneLots.getSelectedTableRow().getData();
    }

    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;
    }

    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        if (moPaneLots.getSelectedTableRow() == null) {
            validation.setMessage(SLibConstants.MSG_ERR_GUI_ROW_UNDEF);
            validation.setComponent(moPaneLots.getTable());
        }

        return validation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
        }
    }
}