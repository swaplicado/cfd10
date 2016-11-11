/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mitm.data.SDataItem;
import erp.mitm.data.SDataUnit;
import erp.mmfg.data.SDataProductionOrder;
import erp.mtrn.data.SDataRawMaterialsConsume;
import erp.mtrn.data.SDataStockLot;
import erp.server.SServerConstants;
import erp.server.SServerRequest;
import erp.server.SServerResponse;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import sa.lib.srv.SSrvConsts;

/**
 *
 * @author Sergio Flores
 */
public class SDialogProdOrderStockConsume extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDate;

    private double mdQuantity;
    private double mdQuantityFinished;
    private int[] manParamProdOrderKey;
    private erp.mmfg.data.SDataProductionOrder moParamProdOrder;

    /** Creates new form SDialogProdOrderStockConsume */
    public SDialogProdOrderStockConsume(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;

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

        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel111 = new javax.swing.JPanel();
        jlProdOrder = new javax.swing.JLabel();
        jtfProdOrderNumber = new javax.swing.JTextField();
        jtfProdOrderType = new javax.swing.JTextField();
        jlProdOrderDate = new javax.swing.JLabel();
        jtfProdOrderDate = new javax.swing.JTextField();
        jPanel112 = new javax.swing.JPanel();
        jlItem = new javax.swing.JLabel();
        jtfItemCode = new javax.swing.JTextField();
        jtfItem = new javax.swing.JTextField();
        jlQuantity = new javax.swing.JLabel();
        jtfQuantity = new javax.swing.JTextField();
        jtfQuantityUnit = new javax.swing.JTextField();
        jPanel113 = new javax.swing.JPanel();
        jlStockLot = new javax.swing.JLabel();
        jtfStockLot = new javax.swing.JTextField();
        jtfStockLotDateExpiration = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jftDate = new javax.swing.JFormattedTextField();
        jbDate = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jlQuantityCurrent = new javax.swing.JLabel();
        jtfQuantityCurrentRo = new javax.swing.JTextField();
        jtfQuantityCurrentUnitRo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jlQuantityFinished = new javax.swing.JLabel();
        jtfQuantityFinishedRo = new javax.swing.JTextField();
        jtfQuantityFinishedUnitRo = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jlAdvanceCurrent = new javax.swing.JLabel();
        jtfAdvanceCurrentRo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlAdvance = new javax.swing.JLabel();
        jsAdvance = new javax.swing.JSpinner();
        jlAdvancePercentage = new javax.swing.JLabel();
        jbAdvance = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de facturas de clientes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de producción:"));
        jPanel11.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        jPanel111.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlProdOrder.setText("Orden producción:");
        jlProdOrder.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel111.add(jlProdOrder);

        jtfProdOrderNumber.setEditable(false);
        jtfProdOrderNumber.setText("TEXT");
        jtfProdOrderNumber.setFocusable(false);
        jtfProdOrderNumber.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel111.add(jtfProdOrderNumber);

        jtfProdOrderType.setEditable(false);
        jtfProdOrderType.setText("TEXT");
        jtfProdOrderType.setFocusable(false);
        jtfProdOrderType.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel111.add(jtfProdOrderType);

        jlProdOrderDate.setText("Fecha:");
        jlProdOrderDate.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel111.add(jlProdOrderDate);

        jtfProdOrderDate.setEditable(false);
        jtfProdOrderDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfProdOrderDate.setText("00/00/0000");
        jtfProdOrderDate.setFocusable(false);
        jtfProdOrderDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel111.add(jtfProdOrderDate);

        jPanel11.add(jPanel111);

        jPanel112.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlItem.setText("Producto:");
        jlItem.setFocusable(false);
        jlItem.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel112.add(jlItem);

        jtfItemCode.setEditable(false);
        jtfItemCode.setText("TEXT");
        jtfItemCode.setFocusable(false);
        jtfItemCode.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel112.add(jtfItemCode);

        jtfItem.setEditable(false);
        jtfItem.setText("TEXT");
        jtfItem.setFocusable(false);
        jtfItem.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel112.add(jtfItem);

        jlQuantity.setText("Cant.:");
        jlQuantity.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel112.add(jlQuantity);

        jtfQuantity.setEditable(false);
        jtfQuantity.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfQuantity.setText("0.000");
        jtfQuantity.setFocusable(false);
        jtfQuantity.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel112.add(jtfQuantity);

        jtfQuantityUnit.setEditable(false);
        jtfQuantityUnit.setText("UNIT");
        jtfQuantityUnit.setFocusable(false);
        jtfQuantityUnit.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel112.add(jtfQuantityUnit);

        jPanel11.add(jPanel112);

        jPanel113.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlStockLot.setText("Lote / caducidad:");
        jlStockLot.setFocusable(false);
        jlStockLot.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel113.add(jlStockLot);

        jtfStockLot.setEditable(false);
        jtfStockLot.setText("TEXT");
        jtfStockLot.setFocusable(false);
        jtfStockLot.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel113.add(jtfStockLot);

        jtfStockLotDateExpiration.setEditable(false);
        jtfStockLotDateExpiration.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfStockLotDateExpiration.setText("00/00/0000");
        jtfStockLotDateExpiration.setFocusable(false);
        jtfStockLotDateExpiration.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel113.add(jtfStockLotDateExpiration);

        jPanel11.add(jPanel113);

        jPanel1.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Consumo de insumos y productos:"));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDate.setText("Fecha consumo: *");
        jlDate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlDate);

        jftDate.setText("dd/mm/yyyy");
        jftDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jftDate);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha inicial");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDate);

        jPanel3.add(jPanel4);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlQuantityCurrent.setText("Cant. orden:");
        jlQuantityCurrent.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jlQuantityCurrent);

        jtfQuantityCurrentRo.setEditable(false);
        jtfQuantityCurrentRo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfQuantityCurrentRo.setText("0.000");
        jtfQuantityCurrentRo.setFocusable(false);
        jtfQuantityCurrentRo.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jtfQuantityCurrentRo);

        jtfQuantityCurrentUnitRo.setEditable(false);
        jtfQuantityCurrentUnitRo.setText("UNIT");
        jtfQuantityCurrentUnitRo.setFocusable(false);
        jtfQuantityCurrentUnitRo.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel6.add(jtfQuantityCurrentUnitRo);

        jPanel3.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlQuantityFinished.setText("Cant. terminada:");
        jlQuantityFinished.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlQuantityFinished);

        jtfQuantityFinishedRo.setEditable(false);
        jtfQuantityFinishedRo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfQuantityFinishedRo.setText("0.000");
        jtfQuantityFinishedRo.setFocusable(false);
        jtfQuantityFinishedRo.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jtfQuantityFinishedRo);

        jtfQuantityFinishedUnitRo.setEditable(false);
        jtfQuantityFinishedUnitRo.setText("UNIT");
        jtfQuantityFinishedUnitRo.setFocusable(false);
        jtfQuantityFinishedUnitRo.setPreferredSize(new java.awt.Dimension(35, 23));
        jPanel7.add(jtfQuantityFinishedUnitRo);

        jPanel3.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAdvanceCurrent.setText("Avance producción:");
        jlAdvanceCurrent.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jlAdvanceCurrent);

        jtfAdvanceCurrentRo.setEditable(false);
        jtfAdvanceCurrentRo.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfAdvanceCurrentRo.setText("0.00%");
        jtfAdvanceCurrentRo.setFocusable(false);
        jtfAdvanceCurrentRo.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel8.add(jtfAdvanceCurrentRo);

        jPanel3.add(jPanel8);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAdvance.setText("Avance proceso: *");
        jlAdvance.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlAdvance);

        jsAdvance.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        jsAdvance.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel5.add(jsAdvance);

        jlAdvancePercentage.setText("%");
        jlAdvancePercentage.setPreferredSize(new java.awt.Dimension(20, 23));
        jPanel5.add(jlAdvancePercentage);

        jbAdvance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_wizard.gif"))); // NOI18N
        jbAdvance.setToolTipText("Copiar avance producción");
        jbAdvance.setFocusable(false);
        jbAdvance.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbAdvance);

        jPanel3.add(jPanel5);

        jPanel12.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel1.add(jPanel12, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(392, 33));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jbCancel.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jbCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-640)/2, (screenSize.height-400)/2, 640, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDate = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDate, jlDate);
        moFieldDate.setPickerButton(jbDate);

        mvFields.add(moFieldDate);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbDate.addActionListener(this);
        jbAdvance.addActionListener(this);

        SFormUtilities.createActionMap(rootPane, this, "actionOk", "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionCancel", "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jftDate.requestFocus();
        }
    }

    private double getAdvance() {
        return mdQuantity == 0d ? 0d : mdQuantityFinished >= mdQuantity ? 1d : mdQuantityFinished / mdQuantity;
    }

    private void renderProdOrder() {
        String sql = "";
        ResultSet resulSet = null;
        Vector<Vector<Object>> rows = null;
        SServerRequest request = null;
        SServerResponse response = null;
        SDataItem item = null;
        SDataUnit unit = null;
        SDataStockLot lot = null;

        mdQuantity = 0;
        mdQuantityFinished = 0;

        try {
            if (moParamProdOrder == null) {
                jtfProdOrderNumber.setText("");
                jtfProdOrderType.setText("");
                jtfProdOrderDate.setText("");
                jtfItemCode.setText("");
                jtfItem.setText("");
                jtfQuantity.setText("");
                jtfQuantityUnit.setText("");
                jtfStockLot.setText("");
                jtfStockLotDateExpiration.setText("");

                jtfQuantityCurrentRo.setText("");
                jtfQuantityCurrentUnitRo.setText("");
                jtfQuantityFinishedRo.setText("");
                jtfQuantityFinishedUnitRo.setText("");
                jtfAdvanceCurrentRo.setText("");
            }
            else {
                item = (SDataItem) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_ITEM, new int[] { moParamProdOrder.getFkItemId_r() }, SLibConstants.EXEC_MODE_VERBOSE);
                unit = (SDataUnit) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_UNIT, new int[] { moParamProdOrder.getFkUnitId_r() }, SLibConstants.EXEC_MODE_VERBOSE);
                lot = (SDataStockLot) SDataUtilities.readRegistry(miClient, SDataConstants.TRN_LOT, new int[] { moParamProdOrder.getFkLotItemId_nr(), moParamProdOrder.getFkLotUnitId_nr(), moParamProdOrder.getFkLotId_n() }, SLibConstants.EXEC_MODE_VERBOSE);
                mdQuantity = moParamProdOrder.getQuantity();

                jtfProdOrderNumber.setText(moParamProdOrder.getDbmsNumber());
                jtfProdOrderType.setText(moParamProdOrder.getDbmsProductionOrderType());
                jtfProdOrderDate.setText(miClient.getSessionXXX().getFormatters().getDateFormat().format(moParamProdOrder.getDate()));
                jtfItemCode.setText(item.getKey());
                jtfItem.setText(item.getItem());
                jtfQuantity.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(mdQuantity));
                jtfQuantityUnit.setText(unit.getSymbol());
                jtfStockLot.setText(lot.getLot());
                jtfStockLotDateExpiration.setText(lot.getDateExpiration_n() == null ? "" : miClient.getSessionXXX().getFormatters().getDateFormat().format(lot.getDateExpiration_n()));

                jtfProdOrderNumber.setCaretPosition(0);
                jtfProdOrderType.setCaretPosition(0);
                jtfProdOrderDate.setCaretPosition(0);
                jtfItemCode.setCaretPosition(0);
                jtfItem.setCaretPosition(0);
                jtfQuantity.setCaretPosition(0);
                jtfQuantityUnit.setCaretPosition(0);
                jtfStockLot.setCaretPosition(0);
                jtfStockLotDateExpiration.setCaretPosition(0);

                mdQuantityFinished = 0;

                sql = "SELECT COALESCE(SUM(ge.qty * CASE WHEN (g.fid_ct_iog = " + SDataConstantsSys.TRNS_CT_IOG_OUT + ") THEN 1 ELSE -1 END), 0) AS f_qty_fin " +
                        "FROM mfg_ord AS o " +
                        "INNER JOIN trn_diog AS g ON o.id_year = " + moParamProdOrder.getPkYearId() + " AND o.id_ord = " + moParamProdOrder.getPkOrdId() + " AND " +
                        "o.id_year = g.fid_mfg_year_n AND o.id_ord = g.fid_mfg_ord_n AND g.b_del = 0 AND (" +
                        "(g.fid_ct_iog = " + SDataConstantsSys.TRNS_TP_IOG_OUT_MFG_WP_ASD[0] + " AND g.fid_cl_iog = " + SDataConstantsSys.TRNS_TP_IOG_OUT_MFG_WP_ASD[1] + " AND g.fid_tp_iog = " + SDataConstantsSys.TRNS_TP_IOG_OUT_MFG_WP_ASD[2] + ") OR " +
                        "(g.fid_ct_iog = " + SDataConstantsSys.TRNS_TP_IOG_IN_MFG_WP_RET[0] + " AND g.fid_cl_iog = " + SDataConstantsSys.TRNS_TP_IOG_IN_MFG_WP_RET[1] + " AND g.fid_tp_iog = " + SDataConstantsSys.TRNS_TP_IOG_IN_MFG_WP_RET[2] + ") OR " +
                        "(g.fid_ct_iog = " + SDataConstantsSys.TRNS_TP_IOG_OUT_MFG_FG_ASD[0] + " AND g.fid_cl_iog = " + SDataConstantsSys.TRNS_TP_IOG_OUT_MFG_FG_ASD[1] + " AND g.fid_tp_iog = " + SDataConstantsSys.TRNS_TP_IOG_OUT_MFG_FG_ASD[2] + ") OR " +
                        "(g.fid_ct_iog = " + SDataConstantsSys.TRNS_TP_IOG_IN_MFG_FG_RET[0] + " AND g.fid_cl_iog = " + SDataConstantsSys.TRNS_TP_IOG_IN_MFG_FG_RET[1] + " AND g.fid_tp_iog = " + SDataConstantsSys.TRNS_TP_IOG_IN_MFG_FG_RET[2] + ")) " +
                        "INNER JOIN trn_diog_ety AS ge ON g.id_year = ge.id_year AND g.id_doc = ge.id_doc AND ge.b_del = 0 AND " +
                        "o.fid_item_r = ge.fid_item AND o.fid_unit_r = ge.fid_unit; ";

                resulSet = miClient.getSession().getStatement().executeQuery(sql);
                while (resulSet.next()) {
                    mdQuantityFinished = resulSet.getDouble("f_qty_fin");
                }

                jtfQuantityCurrentRo.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(mdQuantity));
                jtfQuantityCurrentUnitRo.setText(unit.getSymbol());
                jtfQuantityFinishedRo.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(mdQuantityFinished));
                jtfQuantityFinishedUnitRo.setText(unit.getSymbol());
                jtfAdvanceCurrentRo.setText(miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(getAdvance()));

                jtfQuantityCurrentRo.setCaretPosition(0);
                jtfQuantityCurrentUnitRo.setCaretPosition(0);
                jtfQuantityFinishedRo.setCaretPosition(0);
                jtfQuantityFinishedUnitRo.setCaretPosition(0);
                jtfAdvanceCurrentRo.setCaretPosition(0);
            }
        }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }
        
        actionAdvance();
    }

    private void actionAdvance() {
        try {
            jsAdvance.commitEdit();
            jsAdvance.setValue((int) (SLibUtilities.round(getAdvance() * 100d, 0)));
            jsAdvance.getComponent(0).requestFocus();
        }
        catch (Exception e) {
            SLibUtilities.printOutException(this, e);
        }
    }

    private void actionOk() {
        if (!SDataUtilities.isPeriodOpen(miClient, moFieldDate.getDate())) {
            miClient.showMsgBoxInformation(SLibConstants.MSG_ERR_GUI_PER_CLOSE + "\nFecha: " + miClient.getSessionXXX().getFormatters().getDateFormat().format(moFieldDate.getDate()) + ".");
        }
        else if ((Integer) jsAdvance.getValue() > 100) {
            miClient.showMsgBoxInformation("El valor del campo '" + jlAdvance.getText() + "' no puede ser mayor a 100%.");
        }
        else if ((Integer) jsAdvance.getValue() > (int) SLibUtilities.round(getAdvance() * 100d, 0)) {
            miClient.showMsgBoxInformation("El valor del campo '" + jlAdvance.getText() + "' no puede ser mayor a " + (int) SLibUtilities.round(getAdvance() * 100d, 0) + "%.");
        }
        else if ((Integer) jsAdvance.getValue() < 0) {
            miClient.showMsgBoxInformation("El valor del campo '" + jlAdvance.getText() + "' no puede ser menor a 0%.");
        }
        else {
            SDataRawMaterialsConsume rawMaterialsConsume = null;

            if (miClient.showMsgBoxConfirm("¿Está seguro que desea hacer el consumo de MP y P de la OP seleccionada con " + (Integer) jsAdvance.getValue() + "% de avance, con fecha " + miClient.getSessionXXX().getFormatters().getDateFormat().format(moFieldDate.getDate()) + "?") == JOptionPane.YES_OPTION) {
                try {
                    rawMaterialsConsume = new SDataRawMaterialsConsume();
                    rawMaterialsConsume.setPkYearId(moParamProdOrder.getPkYearId());
                    rawMaterialsConsume.setPkOrderId(moParamProdOrder.getPkOrdId());
                    rawMaterialsConsume.setDate(moFieldDate.getDate());
                    rawMaterialsConsume.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
                    rawMaterialsConsume.setAuxPercentage(((Integer) jsAdvance.getValue()) / 100d);
                    SDataUtilities.saveRegistry(miClient, rawMaterialsConsume);

                    miClient.showMsgBoxInformation("El consumo de MP y P de la OP ha sido realizado con " + (Integer) jsAdvance.getValue() + "% de avance.");

                    mnFormResult = SLibConstants.FORM_RESULT_OK;
                    setVisible(false);
                }
                catch (Exception e) {
                    SLibUtilities.renderException(this, e);
                }
            }
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    private void actionDate() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDate.getDate(), moFieldDate);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel111;
    private javax.swing.JPanel jPanel112;
    private javax.swing.JPanel jPanel113;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbAdvance;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbOk;
    private javax.swing.JFormattedTextField jftDate;
    private javax.swing.JLabel jlAdvance;
    private javax.swing.JLabel jlAdvanceCurrent;
    private javax.swing.JLabel jlAdvancePercentage;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlItem;
    private javax.swing.JLabel jlProdOrder;
    private javax.swing.JLabel jlProdOrderDate;
    private javax.swing.JLabel jlQuantity;
    private javax.swing.JLabel jlQuantityCurrent;
    private javax.swing.JLabel jlQuantityFinished;
    private javax.swing.JLabel jlStockLot;
    private javax.swing.JSpinner jsAdvance;
    private javax.swing.JTextField jtfAdvanceCurrentRo;
    private javax.swing.JTextField jtfItem;
    private javax.swing.JTextField jtfItemCode;
    private javax.swing.JTextField jtfProdOrderDate;
    private javax.swing.JTextField jtfProdOrderNumber;
    private javax.swing.JTextField jtfProdOrderType;
    private javax.swing.JTextField jtfQuantity;
    private javax.swing.JTextField jtfQuantityCurrentRo;
    private javax.swing.JTextField jtfQuantityCurrentUnitRo;
    private javax.swing.JTextField jtfQuantityFinishedRo;
    private javax.swing.JTextField jtfQuantityFinishedUnitRo;
    private javax.swing.JTextField jtfQuantityUnit;
    private javax.swing.JTextField jtfStockLot;
    private javax.swing.JTextField jtfStockLotDateExpiration;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        manParamProdOrderKey = null;
        moParamProdOrder = null;
        renderProdOrder();

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moFieldDate.setFieldValue(miClient.getSessionXXX().getWorkingDate());
        jsAdvance.setValue(0);
    }

    @Override
    public void formRefreshCatalogues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            if (!SDataUtilities.isPeriodOpen(miClient, moFieldDate.getDate())) {
                validation.setMessage(SLibConstants.MSG_ERR_GUI_PER_CLOSE);
                validation.setComponent(jftDate);
            }
            else if ((Integer) jsAdvance.getValue() == 0) {
                if (miClient.showMsgBoxConfirm("") != JOptionPane.YES_OPTION) {
                    validation.setMessage(SLibConstants.MSG_ERR_GUI_FIELD_VALUE_DIF + "'" + jlAdvance.getText() + "'.");
                    validation.setComponent(jsAdvance);
                }
            }
        }

        return validation;
    }

    @Override
    public void setFormStatus(int status) {
        mnFormStatus = status;
    }

    @Override
    public void setFormVisible(boolean visible) {
        setVisible(visible);
    }

    @Override
    public int getFormStatus() {
        return mnFormStatus;
    }

    @Override
    public int getFormResult() {
        return mnFormResult;
    }

    @Override
    public void setRegistry(erp.lib.data.SDataRegistry registry) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValue(int type, java.lang.Object value) {
        switch (type) {
            case SDataConstants.MFG_ORD:
                manParamProdOrderKey = (int[]) value;
                moParamProdOrder = (SDataProductionOrder) SDataUtilities.readRegistry(miClient, SDataConstants.MFG_ORD, manParamProdOrderKey, SLibConstants.EXEC_MODE_VERBOSE);
                renderProdOrder();
                break;
            default:
                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
        }
    }

    @Override
    public java.lang.Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbDate) {
                actionDate();
            }
            else if (button == jbAdvance) {
                actionAdvance();
            }
        }
    }
}