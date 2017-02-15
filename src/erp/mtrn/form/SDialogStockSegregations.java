/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormUtilities;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.lib.table.STableRowCustom;
import erp.lib.table.STableUtilities;
import erp.mitm.data.SDataItem;
import erp.mitm.data.SDataUnit;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Edwin Carmona
 */

public class SDialogStockSegregations extends javax.swing.JDialog implements java.awt.event.ActionListener {

    private static final int COL_SEG = 4;

    private int mnFormMode;
    private boolean mbFirstTime;
    private erp.client.SClientInterface miClient;
    private erp.lib.table.STablePane moPaneStockMoves;

    private int mnParamYear;
    private Date mtParamDateCutOff;
    private int[] manWarehouseKey;
    private erp.mitm.data.SDataItem moParamItem;
    private erp.mitm.data.SDataUnit moParamUnit;

    /** Creates new form SDialogAccountingDetail */
    public SDialogStockSegregations(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
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

        jpParams = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlItem = new javax.swing.JLabel();
        jtfItemKey = new javax.swing.JTextField();
        jtfItem = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jlStock = new javax.swing.JLabel();
        jtfStock = new javax.swing.JTextField();
        jtfStockUnitSymbol = new javax.swing.JTextField();
        jpStockMoves = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jtfSeek = new javax.swing.JTextField();
        jbSeek = new javax.swing.JButton();
        jbExportCsv = new javax.swing.JButton();
        jbRefresh = new javax.swing.JButton();
        jpControls = new javax.swing.JPanel();
        jbClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tarjeta auxiliar de almacén");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpParams.setLayout(new java.awt.BorderLayout(5, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ítem"));
        jPanel4.setLayout(new java.awt.GridLayout(1, 1, 0, 5));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlItem.setText("Ítem:");
        jlItem.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel7.add(jlItem);

        jtfItemKey.setEditable(false);
        jtfItemKey.setText("TEXT");
        jtfItemKey.setFocusable(false);
        jtfItemKey.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jtfItemKey);

        jtfItem.setEditable(false);
        jtfItem.setText("TEXT");
        jtfItem.setFocusable(false);
        jtfItem.setPreferredSize(new java.awt.Dimension(275, 23));
        jPanel7.add(jtfItem);

        jPanel4.add(jPanel7);

        jpParams.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Segregadas:"));
        jPanel6.setLayout(new java.awt.GridLayout(1, 1, 0, 5));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlStock.setText("Unidades segregadas");
        jlStock.setPreferredSize(new java.awt.Dimension(150, 23));
        jlStock.setRequestFocusEnabled(false);
        jPanel13.add(jlStock);

        jtfStock.setBackground(new java.awt.Color(153, 204, 255));
        jtfStock.setEditable(false);
        jtfStock.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfStock.setText("0.000");
        jtfStock.setFocusable(false);
        jtfStock.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jtfStock);

        jtfStockUnitSymbol.setBackground(new java.awt.Color(153, 204, 255));
        jtfStockUnitSymbol.setEditable(false);
        jtfStockUnitSymbol.setText("CODE");
        jtfStockUnitSymbol.setFocusable(false);
        jtfStockUnitSymbol.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel13.add(jtfStockUnitSymbol);

        jPanel6.add(jPanel13);

        jpParams.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpParams, java.awt.BorderLayout.NORTH);

        jpStockMoves.setBorder(javax.swing.BorderFactory.createTitledBorder("Segregaciones:"));
        jpStockMoves.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 0));

        jtfSeek.setText("Seek");
        jtfSeek.setToolTipText("Texto a buscar [Ctrl+B]");
        jtfSeek.setEnabled(false);
        jtfSeek.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel3.add(jtfSeek);

        jbSeek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_seek.gif"))); // NOI18N
        jbSeek.setToolTipText("Buscar");
        jbSeek.setEnabled(false);
        jbSeek.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel3.add(jbSeek);

        jbExportCsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_file_csv.gif"))); // NOI18N
        jbExportCsv.setToolTipText("Exportar CSV [Ctrl+E]");
        jbExportCsv.setEnabled(false);
        jbExportCsv.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel3.add(jbExportCsv);

        jbRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_reload.gif"))); // NOI18N
        jbRefresh.setToolTipText("Refrescar [Ctrl+R]");
        jbRefresh.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel3.add(jbRefresh);

        jpStockMoves.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jpStockMoves, java.awt.BorderLayout.CENTER);

        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbClose.setText("Cerrar");
        jbClose.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbClose);

        getContentPane().add(jpControls, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(968, 634));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int col = 0;
        STableColumnForm[] columns = null;

        columns = new STableColumnForm[11];
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_INTEGER, "#", STableConstants.WIDTH_NUM_SMALLINT);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Folio doc.", STableConstants.WIDTH_DOC_NUM);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo segregación", STableConstants.WIDTH_ITEM_2X);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Fecha", STableConstants.WIDTH_DATE);
        columns[col] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Segregado", STableConstants.WIDTH_QUANTITY_2X);
        columns[col++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Unidad", STableConstants.WIDTH_UNIT_SYMBOL);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Almacén", STableConstants.WIDTH_CODE_COB_ENT);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. creación", STableConstants.WIDTH_USER);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Creación", STableConstants.WIDTH_DATE_TIME);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. modificación", STableConstants.WIDTH_USER);
        columns[col++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Modificación", STableConstants.WIDTH_DATE_TIME);
        

        moPaneStockMoves = new STablePane(miClient);
        jpStockMoves.add(moPaneStockMoves, BorderLayout.CENTER);

        for (STableColumnForm column : columns) {
            moPaneStockMoves.addTableColumn(column);
        }

        moPaneStockMoves.createTable();
        moPaneStockMoves.getTable().getTableHeader().setReorderingAllowed(false);

        jbClose.addActionListener(this);
        jbSeek.addActionListener(this);
        jbRefresh.addActionListener(this);
        jbExportCsv.addActionListener(this);
        jtfSeek.addActionListener(this);

        SFormUtilities.createActionMap(getRootPane(), this, "actionClose", "close", KeyEvent.VK_ESCAPE, SLibConstants.UNDEFINED);
        SFormUtilities.createActionMap(getRootPane(), this, "focusSeek", "seek", KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(getRootPane(), this, "actionExportCsv", "exportCsv", KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(getRootPane(), this, "actionRefresh", "refresh", KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jbClose.requestFocus();
        }
    }

    @SuppressWarnings("unchecked")
    private void showStockMoves() {
        int row = 0;
        double segQty = 0;
        String sql = "";
        ResultSet resulSet = null;

        moPaneStockMoves.clearTableRows();
        moPaneStockMoves.createTable();
        moPaneStockMoves.getTable().getTableHeader().setReorderingAllowed(false);

        try {
            sql = "SELECT ord.id_ord, ord.id_year, ord.dt, CAST(CONCAT(ord.id_year, '-', erp.lib_fix_int(ord.num, " + SDataConstantsSys.NUM_LEN_IOG + ")) AS CHAR) AS f_mfg_num," +
                    "seg.fid_tp_stk_seg, tps.tp_stk_seg , COALESCE(SUM(swe.qty_inc - swe.qty_dec)) AS f_seg_qty, uni.symbol, whse.code, " +
                    "seg.ts_new, seg.fid_usr_new, une.usr, seg.fid_usr_edit, uup.usr, seg.ts_edit " +
                    "FROM trn_stk_seg seg " +
                    "INNER JOIN trn_stk_seg_whs swh ON (seg.id_stk_seg = swh.id_stk_seg) " +
                    "INNER JOIN trn_stk_seg_whs_ety swe ON (swh.id_stk_seg = swe.id_stk_seg AND swh.id_whs = swe.id_whs) " +
                    "INNER JOIN mfg_ord ord ON (seg.fid_ref_1 = ord.id_ord AND seg.fid_ref_2 = ord.id_year) " +
                    "INNER JOIN erp.trns_tp_stk_seg tps ON (seg.fid_tp_stk_seg = tps.id_tp_stk_seg) " +
                    "INNER JOIN erp.cfgu_cob_ent whse ON (swh.fid_cob = whse.id_cob AND swh.fid_whs = whse.id_ent) " +
                    "INNER JOIN erp.itmu_unit AS uni ON swe.fid_unit = uni.id_unit " +
                    "INNER JOIN erp.usru_usr AS une ON seg.fid_usr_new = une.id_usr " +
                    "INNER JOIN erp.usru_usr AS uup ON seg.fid_usr_edit = uup.id_usr " +
                    "WHERE swe.fid_year = " + mnParamYear + " AND swe.fid_item = " + (moParamItem != null ? moParamItem.getPkItemId() : 0) + " AND swe.fid_unit = " + (moParamItem != null ? moParamItem.getFkUnitId() : 0) + " " +
                    "GROUP BY ord.id_year, ord.id_ord, swe.id_whs, whse.ent " +
                    "HAVING f_seg_qty <> 0 " +
                    "ORDER BY ord.id_year, ord.id_ord, swe.id_whs, whse.ent;";

            resulSet = miClient.getSession().getStatement().executeQuery(sql);
            while (resulSet.next()) {
                STableRowCustom rowCustom = new STableRowCustom();

                rowCustom.getValues().add(++row);
                rowCustom.getValues().add(resulSet.getString("f_mfg_num"));
                rowCustom.getValues().add(resulSet.getString("tps.tp_stk_seg"));
                rowCustom.getValues().add(resulSet.getDate("ord.dt"));
                rowCustom.getValues().add(resulSet.getDouble("f_seg_qty"));
                rowCustom.getValues().add(resulSet.getString("uni.symbol"));
                rowCustom.getValues().add(resulSet.getString("whse.code"));
                rowCustom.getValues().add(resulSet.getString("une.usr"));
                rowCustom.getValues().add(resulSet.getTimestamp("seg.ts_new"));
                rowCustom.getValues().add(resulSet.getString("uup.usr"));
                rowCustom.getValues().add(resulSet.getTimestamp("seg.ts_edit"));
                
                segQty += resulSet.getDouble("f_seg_qty");

                moPaneStockMoves.addTableRow(rowCustom);
            }

            moPaneStockMoves.renderTableRows();
            moPaneStockMoves.setTableRowSelection(0);

            if (moPaneStockMoves.getTableGuiRowCount() == 0) {
                jtfSeek.setEnabled(false);
                jbSeek.setEnabled(false);
                jbExportCsv.setEnabled(false);
            }
            else {
                jtfSeek.setEnabled(true);
                jbSeek.setEnabled(true);
                jbExportCsv.setEnabled(true);
            }
        }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }

        jtfStock.setText((mnFormMode == SLibConstants.MODE_QTY ?
            miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat() :
            miClient.getSessionXXX().getFormatters().getDecimalsValueUnitaryFormat()).format(segQty));
    }

    public void actionClose() {
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbExportCsv;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbSeek;
    private javax.swing.JLabel jlItem;
    private javax.swing.JLabel jlStock;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpParams;
    private javax.swing.JPanel jpStockMoves;
    private javax.swing.JTextField jtfItem;
    private javax.swing.JTextField jtfItemKey;
    private javax.swing.JTextField jtfSeek;
    private javax.swing.JTextField jtfStock;
    private javax.swing.JTextField jtfStockUnitSymbol;
    // End of variables declaration//GEN-END:variables

    public void focusSeek() {
        if (jtfSeek.isEnabled()) {
            jtfSeek.requestFocus();
        }
    }

    public void actionSeek() {
        if (jbSeek.isEnabled()) {
            STableUtilities.actionSeek(miClient, moPaneStockMoves, jtfSeek.getText().trim());
        }
    }

    public void actionExportCsv() {
        if (jbExportCsv.isEnabled()) {
            STableUtilities.actionExportCsv(miClient, moPaneStockMoves, getTitle());
        }
    }

    public void actionRefresh() {
        showStockMoves();
    }

    public void setFormParams(final Date dateCutOff, final int itemId, final int unitId, final int[] warehouseKey, int mode) {
        mnParamYear = SLibTimeUtilities.digestYear(dateCutOff)[0];
        mtParamDateCutOff = dateCutOff;
        manWarehouseKey = warehouseKey;
        mnFormMode = mode;

        if (itemId == SLibConstants.UNDEFINED) {
            moParamItem = null;
            moParamUnit = null;

            jtfItem.setText("");
            jtfItemKey.setText("");
            jtfStockUnitSymbol.setText("");
        }
        else {
            moParamItem = (SDataItem) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_ITEM, new int[] { itemId }, SLibConstants.EXEC_MODE_VERBOSE);
            moParamUnit = (SDataUnit) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_UNIT, new int[] { unitId }, SLibConstants.EXEC_MODE_VERBOSE);

            jtfItem.setText(moParamItem.getItem());
            jtfItemKey.setText(moParamItem.getKey());
            jtfItem.setCaretPosition(0);
            jtfItemKey.setCaretPosition(0);

            jtfStockUnitSymbol.setText(moParamUnit.getSymbol());
            jtfStockUnitSymbol.setCaretPosition(0);
        }

        setDecimals();
        showStockMoves();
    }

    public void setDecimals() {
        DefaultTableCellRenderer tcr = mnFormMode == SLibConstants.MODE_QTY ?
            miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity() :
            miClient.getSessionXXX().getFormatters().getTableCellRendererValueUnitary();

        moPaneStockMoves.getTableColumn(COL_SEG).setCellRenderer(tcr);
        moPaneStockMoves.clearTableRows();
        moPaneStockMoves.createTable();
        moPaneStockMoves.getTable().getTableHeader().setReorderingAllowed(false);
    }

    public void formReset() {
        mbFirstTime = true;

        jtfSeek.setText("");
        jtfSeek.setEnabled(false);
        jbSeek.setEnabled(false);
        jbExportCsv.setEnabled(false);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbClose) {
                actionClose();
            }
            else if (button == jbSeek) {
                actionSeek();
            }
            else if (button == jbExportCsv) {
                actionExportCsv();
            }
            else if (button == jbRefresh) {
                actionRefresh();
            }
        }
        else if (e.getSource() instanceof javax.swing.JTextField) {
            JTextField textField = (JTextField) e.getSource();

            if (textField == jtfSeek) {
                actionSeek();
            }
        }
    }
}
