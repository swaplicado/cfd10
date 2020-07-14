/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogDpsLink.java
 *
 * Created on 27/05/2020, 02:58:00 PM
 */

package erp.mtrn.form;

import cfd.ver33.DElementConcepto;
import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mtrn.data.SDataDps;
import erp.mtrn.data.SDataDpsDpsLink;
import erp.mtrn.data.SDataDpsEntry;
import erp.mtrn.data.SDataEntryDpsDpsLink;
import erp.mtrn.data.SGuiDpsLink;
import erp.mtrn.data.STrnDpsUtilities;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractAction;
import sa.lib.SLibUtils;

/**
 *
 * @author Isabel Servín
 */
public class SDialogCfdiPurchaseOrder extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    public static final int VALUE_TYPE_CFDI_CONCEPTO = 1;
    public static final int VALUE_TYPE_FACTOR_CONV = 2;
    
    private static final int COL_QTY_TO_BE_LINKED = 7;
    private static final int COL_QTY_TO_LINK = 8;

    private erp.client.SClientInterface miClient;
    private int mnOptionType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean isOrder;
    private erp.lib.table.STablePane moTablePane;

    private int[] manParamDpsDestinyPk;
    private erp.mtrn.data.SDataDps moParamDpsSource;
    private erp.mtrn.form.SPanelDps moPanelDps;
    
    private SGuiDpsLink moGuiDpsLink;
    private DElementConcepto moConcepto;

    /** Creates new form SDialogDpsLink */
    public SDialogCfdiPurchaseOrder(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnOptionType = SDataConstants.TRNX_DPS_LINKS;
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

        jpDps = new javax.swing.JPanel();
        jpDocument = new javax.swing.JPanel();
        jlPanelDps = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jpOptions = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jbSetEverything = new javax.swing.JButton();
        jbSetNothing = new javax.swing.JButton();
        jpOrder = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlNoIdentificacion = new javax.swing.JLabel();
        jlDescripcion = new javax.swing.JLabel();
        jlProdServ = new javax.swing.JLabel();
        jlUnidad = new javax.swing.JLabel();
        jlUnitSat = new javax.swing.JLabel();
        jlCantidad = new javax.swing.JLabel();
        jlConvertionFactor = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jtfNoIdentificacion = new javax.swing.JTextField();
        jtfDescripcion = new javax.swing.JTextField();
        jtfProdServ = new javax.swing.JTextField();
        jtfUnidad = new javax.swing.JTextField();
        jtfUnidadSat = new javax.swing.JTextField();
        jtfCantidad = new javax.swing.JTextField();
        jtfConvertionFactor = new javax.swing.JTextField();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vinculación de documento de compras-ventas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpDps.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpDps.setLayout(new java.awt.BorderLayout());

        jpDocument.setLayout(new java.awt.BorderLayout());

        jlPanelDps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlPanelDps.setText("[Panel de documento de compras-ventas]");
        jlPanelDps.setPreferredSize(new java.awt.Dimension(100, 200));
        jpDocument.add(jlPanelDps, java.awt.BorderLayout.NORTH);

        jpDps.add(jpDocument, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Partidas del documento disponibles para vinculación:"));
        jpOptions.setPreferredSize(new java.awt.Dimension(865, 90));
        jpOptions.setLayout(new java.awt.BorderLayout(0, 2));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbSetEverything.setText("Todo");
        jbSetEverything.setToolTipText("Surtir todo");
        jbSetEverything.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel13.add(jbSetEverything);

        jbSetNothing.setText("Limpiar");
        jbSetNothing.setToolTipText("Limpiar captura");
        jbSetNothing.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel13.add(jbSetNothing);

        jpOptions.add(jPanel13, java.awt.BorderLayout.NORTH);

        jPanel1.add(jpOptions, java.awt.BorderLayout.CENTER);

        jpOrder.setBorder(javax.swing.BorderFactory.createTitledBorder("Concepto:"));
        jpOrder.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNoIdentificacion.setText("No. identificación:");
        jlNoIdentificacion.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlNoIdentificacion);

        jlDescripcion.setText("Descripción:");
        jlDescripcion.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel4.add(jlDescripcion);

        jlProdServ.setText("ProdServ SAT:");
        jlProdServ.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel4.add(jlProdServ);

        jlUnidad.setText("Unidad:");
        jlUnidad.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel4.add(jlUnidad);

        jlUnitSat.setText("Unidad SAT:");
        jlUnitSat.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel4.add(jlUnitSat);

        jlCantidad.setText("Cantidad:");
        jlCantidad.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlCantidad);

        jlConvertionFactor.setText("Fact. conversión:*");
        jlConvertionFactor.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlConvertionFactor);

        jpOrder.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfNoIdentificacion.setEditable(false);
        jtfNoIdentificacion.setFocusable(false);
        jtfNoIdentificacion.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jtfNoIdentificacion);

        jtfDescripcion.setEditable(false);
        jtfDescripcion.setFocusable(false);
        jtfDescripcion.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel5.add(jtfDescripcion);

        jtfProdServ.setEnabled(false);
        jtfProdServ.setFocusable(false);
        jtfProdServ.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel5.add(jtfProdServ);

        jtfUnidad.setEnabled(false);
        jtfUnidad.setFocusable(false);
        jtfUnidad.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel5.add(jtfUnidad);

        jtfUnidadSat.setEnabled(false);
        jtfUnidadSat.setFocusable(false);
        jtfUnidadSat.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel5.add(jtfUnidadSat);

        jtfCantidad.setEnabled(false);
        jtfCantidad.setFocusable(false);
        jtfCantidad.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jtfCantidad);

        jtfConvertionFactor.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jtfConvertionFactor);

        jpOrder.add(jPanel5);

        jPanel1.add(jpOrder, java.awt.BorderLayout.NORTH);

        jpDps.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpDps, java.awt.BorderLayout.CENTER);

        jpControls.setPreferredSize(new java.awt.Dimension(392, 33));
        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jbCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbCancel);

        getContentPane().add(jpControls, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(900, 678));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int i = 0;
        STableColumnForm[] columns = null;

        moTablePane = new STablePane(miClient);
        jpOptions.add(moTablePane, BorderLayout.CENTER);

        columns = new STableColumnForm[11];
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_INTEGER, "#", STableConstants.WIDTH_NUM_TINYINT);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Clave", STableConstants.WIDTH_ITEM_KEY);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Concepto", 250);
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Cant.", STableConstants.WIDTH_QUANTITY);
        columns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Unidad", STableConstants.WIDTH_UNIT_SYMBOL);
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Cant. vinc.", STableConstants.WIDTH_QUANTITY);
        columns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Vinc. actual", STableConstants.WIDTH_QUANTITY);
        columns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Por vincular", STableConstants.WIDTH_QUANTITY);
        columns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "A vincular", STableConstants.WIDTH_QUANTITY);
        columns[i].setEditable(true);
        columns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererQuantity());
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Unidad", STableConstants.WIDTH_UNIT_SYMBOL);
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "% excedente", STableConstants.WIDTH_PERCENTAGE);
        columns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererPercentage());

        for (i = 0; i < columns.length; i++) {
            moTablePane.addTableColumn(columns[i]);
        }

        moPanelDps = new SPanelDps(miClient, "de origen");
        jpDps.remove(jlPanelDps);
        jpDps.add(moPanelDps, BorderLayout.NORTH);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbSetEverything.addActionListener(this);
        jbSetNothing.addActionListener(this);
        

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionCancel, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            moTablePane.getTable().requestFocus();

            if (!validateQuantitiesToLink()) {
                actionCancel();
            }
        }
    }

    private void renderDpsSourceEntries() {
        double linked;
        double linkedActual;

        moTablePane.createTable();
        moTablePane.clearTableRows();

        if (moParamDpsSource != null) {
            for (SDataDpsEntry entry : moParamDpsSource.getDbmsDpsEntries()) {
                if (!entry.getIsDeleted()) {
                    SDataEntryDpsDpsLink entryLink;

                    linked = 0;
                    linkedActual = 0;

                    for (SDataDpsDpsLink link : entry.getDbmsDpsLinksAsSource()) {
                        if (SLibUtilities.compareKeys(manParamDpsDestinyPk, link.getDbmsDestinyDpsKey())) {
                            // Current link movements:
                            linkedActual += link.getOriginalQuantity();
                        }
                        else {
                            // Previously saved link movements:

                            if (!link.getDbmsIsDestinyDeleted() && !link.getDbmsIsDestinyEntryDeleted() &&
                                link.getDbmsFkDestinyStatusId() == SDataConstantsSys.TRNS_ST_DPS_EMITED) {

                                linked += link.getOriginalQuantity();
                            }
                        }
                    }

                    entryLink = new SDataEntryDpsDpsLink();
                    entryLink.setPkYearId(entry.getPkYearId());
                    entryLink.setPkDocId(entry.getPkDocId());
                    entryLink.setPkEntryId(entry.getPkEntryId());
                    entryLink.setSortingPosition(entry.getSortingPosition());
                    entryLink.setConceptKey(entry.getConceptKey());
                    entryLink.setConcept(entry.getConcept());
                    entryLink.setQuantity(entry.getOriginalQuantity());
                    entryLink.setUnitSymbol(entry.getDbmsOriginalUnitSymbol());
                    entryLink.setQuantityLinked(linked);
                    entryLink.setQuantityLinkedActual(linkedActual);
                    entryLink.setQuantityToLink(0);
                    entryLink.setSurplusPercentage(entry.getSurplusPercentage());
                    entryLink.prepareTableRow();
                    entryLink.setAuxIsEntryPriceNeeded(!entry.getDbmsEntryPrices().isEmpty());

                    moTablePane.addTableRow(entryLink);
                }
            }

            moTablePane.renderTableRows();
            moTablePane.setTableRowSelection(0);               
        }
    }
    
    private void updateLink() {
        SDataEntryDpsDpsLink entry = null;

        for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
            entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
            entry.setQuantityToLink(((Number) entry.getValues().get(COL_QTY_TO_LINK)).doubleValue());
        }
    }

    private boolean validateQuantitiesToLink() {
        boolean error = false;
        boolean isDataAvailable = false;
        boolean isDataLinkable = false;
        SDataEntryDpsDpsLink entry = null;

        for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
            isDataAvailable = true;

            entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
            if (entry.getQuantityToBeLinked() > 0) {
                isDataLinkable = true;
                break;
            }
        }

        if (!isDataAvailable) {
            error = true;
            miClient.showMsgBoxWarning("No existen partidas para vincular.");
        }
        else if (!isDataLinkable) {
            error = true;
            miClient.showMsgBoxWarning("No existen partidas con cantidades para vincular.");
        }

        return !error;
    }
    
    private void actionSetEverything() {
        int index = moTablePane.getTable().getSelectedRow();
        SDataEntryDpsDpsLink entry = null;

        for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
            entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
            entry.setQuantityToLink(entry.getQuantityToBeLinked());
            entry.prepareTableRow();
        }

        moTablePane.renderTableRows();
        moTablePane.getTable().setRowSelectionInterval(index, index);
    }

    private void actionSetNothing() {
        int index = moTablePane.getTable().getSelectedRow();
        SDataEntryDpsDpsLink entry = null;

        for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
            entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
            entry.setQuantityToLink(0d);
            entry.prepareTableRow();
            entry.setAuxSGuiDpsEntryPrice(null);
        }

        moTablePane.renderTableRows();
        moTablePane.getTable().setRowSelectionInterval(index, index);
    }

    private void actionOk() {
        SFormValidation validation = formValidate();

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
        else {
            mnFormResult = SLibConstants.FORM_RESULT_OK;
            setVisible(false);
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbSetEverything;
    private javax.swing.JButton jbSetNothing;
    private javax.swing.JLabel jlCantidad;
    private javax.swing.JLabel jlConvertionFactor;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlNoIdentificacion;
    private javax.swing.JLabel jlPanelDps;
    private javax.swing.JLabel jlProdServ;
    private javax.swing.JLabel jlUnidad;
    private javax.swing.JLabel jlUnitSat;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpDocument;
    private javax.swing.JPanel jpDps;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JPanel jpOrder;
    private javax.swing.JTextField jtfCantidad;
    private javax.swing.JTextField jtfConvertionFactor;
    private javax.swing.JTextField jtfDescripcion;
    private javax.swing.JTextField jtfNoIdentificacion;
    private javax.swing.JTextField jtfProdServ;
    private javax.swing.JTextField jtfUnidad;
    private javax.swing.JTextField jtfUnidadSat;
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

        manParamDpsDestinyPk = null;
        moParamDpsSource = null;
        moGuiDpsLink = null;
        moPanelDps.setDps(null, null);

        renderDpsSourceEntries();
    }

    @Override
    public void formRefreshCatalogues() {

    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        int rows = 0;
        double totalSurplus;
        double totalLinked;
        SFormValidation validation = new SFormValidation();

        updateLink();

        for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
            SDataEntryDpsDpsLink entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
            
            if (entry.getQuantityToLink() > 0) {
                // Validate that quantity to link does not exceed limit:

                rows++;
                
                if (!validation.getIsError()) {
                    try {
                        if (moParamDpsSource.getElementsConcepto().get(i).getValorUnitario() != moConcepto.getAttValorUnitario().getDouble()){
                            validation.setMessage("El los precios de los conceptos del CFDI y del SIIE no coinciden!");
                            break;
                        }
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
                
                // The source is order and has supplied quantities
                
                if (!validation.getIsError() && moParamDpsSource.isOrder()){
                    try {
                        double totalsupplied = STrnDpsUtilities.obtainEntryTotalQuantitySupplied(miClient, (int[]) entry.getDpsEntryKey());
                        if (totalsupplied > entry.getQuantityToLink()) {
                            validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                    "la cantidad minima a vincular debe ser " + (totalsupplied < entry.getQuantityToBeLinked() ? "mayor o " : "") + "igual a " + 
                                    miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(totalsupplied) + " ya que tiene sutidos previos.");
                            break;
                        }
                    }
                    catch (Exception e) {
                        SLibUtils.showException(this, e);
                    }
                }
                
                // Need monthly delivery:

                if (!validation.getIsError() && isOrder) {
                    if (moGuiDpsLink.pickGuiDpsSourceEntry((int[]) moParamDpsSource.getPrimaryKey(), (int[]) entry.getDpsEntryKey()).getGuiDpsSourceEntryPrices().size() > 0) {
                        if (entry.getAuxSGuiDpsEntryPrice() == null) {
                            validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                    "se debe seleccionar una entrega mensual.");
                            break;
                        }
                    }
                    else {
                        validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' la partida # " + entry.getSortingPosition() + "\n" +
                                "no tiene entregas mensuales programadas.");
                        break;
                    }
                }
                
                if (!validation.getIsError() && entry.getAuxIsEntryPriceNeeded() && entry.getAuxSGuiDpsEntryPrice().getDataDpsEntryPrice().getOriginalPriceUnitaryCy() <= 0) {
                    validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                            "el precio  de la entrega mensual seleccionada debe ser diferente de 0.");
                    break;
                }

                if (entry.getSurplusPercentage() == 0) {
                    // No surplus allowed:
                    
                    if (!validation.getIsError()) {
                        if (entry.getAuxIsEntryPriceNeeded()) {
                            // Need monthly delivery validation:
                            
                            if (entry.getQuantityToLink() > entry.getAuxSGuiDpsEntryPrice().obtainQtyAvailable()) {
                                validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                        "la cantidad de la columna '" + moTablePane.getTableColumn(COL_QTY_TO_LINK).getColumnTitle() + "' (" +
                                        miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entry.getQuantityToLink()) + " " + entry.getUnitSymbol() + "), " +
                                        "no puede ser mayor a la cantidad pendiente de la entrega mensual seleccionada (" +
                                        miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entry.getAuxSGuiDpsEntryPrice().obtainQtyAvailable()) + " " + entry.getUnitSymbol() + ").");
                                break;
                            }
                        }
                        else {
                            // Need total quantity validation:
                            
                            if (entry.getQuantityToLink() > entry.getQuantityToBeLinked()) {
                                validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                        "la cantidad de la columna '" + moTablePane.getTableColumn(COL_QTY_TO_LINK).getColumnTitle() + "', " +
                                        miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entry.getQuantityToLink()) + " " + entry.getUnitSymbol() + ", " +
                                        "no puede ser mayor a la cantidad de la columna '" + moTablePane.getTableColumn(COL_QTY_TO_BE_LINKED).getColumnTitle() + "', " +
                                        miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entry.getQuantityToBeLinked()) + " " + entry.getUnitSymbol() + ".");
                                break;
                            }
                        }
                    }
                }
                else {
                    // Surplus allowed:

                    if (!validation.getIsError()) {
                        if (entry.getAuxIsEntryPriceNeeded()) {
                            // Need monthly delivery validation:
                            
                            Date datePrice = null;
                            Date dateSourceDocLapsing = null;
                            datePrice = SLibTimeUtilities.createDate(entry.getAuxSGuiDpsEntryPrice().getDataDpsEntryPrice().getContractPriceYear(), entry.getAuxSGuiDpsEntryPrice().getDataDpsEntryPrice().getContractPriceMonth());
                            dateSourceDocLapsing = SLibTimeUtilities.createDate(SLibTimeUtilities.digestYearMonth(moParamDpsSource.getDateDocLapsing_n())[0], SLibTimeUtilities.digestYearMonth(moParamDpsSource.getDateDocLapsing_n())[1]);
                            if (datePrice.compareTo(dateSourceDocLapsing) == 0) {
                                
                                // Only validate surplus when is the last delivery
                                
                                totalSurplus = entry.getAuxSGuiDpsEntryPrice().obtainQtyAvailable() + (entry.getQuantity() * entry.getSurplusPercentage());
                                totalLinked = entry.getQuantityToLink();
                                
                                if (totalLinked > totalSurplus) {
                                    validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                        "la cantidad total vinculada, " + miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(totalLinked) + " " + entry.getUnitSymbol() + ", " +
                                        "no puede ser mayor a " + miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(totalSurplus) + " " + entry.getUnitSymbol() + ".");
                                    break;
                                }
                            }
                            else {
                                
                                // For other deliveries, apply normal validation:
                                
                                if (entry.getQuantityToLink() > entry.getAuxSGuiDpsEntryPrice().obtainQtyAvailable()) {
                                    validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                            "la cantidad de la columna '" + moTablePane.getTableColumn(COL_QTY_TO_LINK).getColumnTitle() + "' (" +
                                            miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entry.getQuantityToLink()) + " " + entry.getUnitSymbol() + "), " +
                                            "no puede ser mayor a la cantidad pendiente de la entrega mensual seleccionada (" +
                                            miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entry.getAuxSGuiDpsEntryPrice().obtainQtyAvailable()) + " " + entry.getUnitSymbol() + ").");
                                    break;
                                }
                                
                            }
                        }
                        else {
                            // Need total quantity validation:
                            
                            totalSurplus = entry.getQuantity() * (1d + entry.getSurplusPercentage());
                            totalLinked = entry.getQuantityLinked() + entry.getQuantityLinkedActual() + entry.getQuantityToLink();

                            if (totalLinked > totalSurplus) {
                                validation.setMessage("Para el ítem '" + entry.getConcept() + " (" + entry.getConceptKey() + ")' en la partida # " + entry.getSortingPosition() + "\n" +
                                    "la cantidad total vinculada, " + miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(totalLinked) + " " + entry.getUnitSymbol() + ", " +
                                    "no puede ser mayor a " + miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(totalSurplus) + " " + entry.getUnitSymbol() + ".");
                                break;
                            }
                        }
                    }
                }
            }
        }

        if (!validation.getIsError()) {
            if (rows == 0) {
                validation.setMessage("Se debe especificar al menos una partida para vinculación.");
                validation.setComponent(moTablePane.getTable());
            }
            else if (rows > 1) {
                validation.setMessage("Se debe especificar solo una partida para vinculación.");
                validation.setComponent(moTablePane.getTable());
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

    /**
     * @param type Options accepted: SDataConstants.TRN_DPS or SDialogCfdiPurchaseOrder.VALUE_TYPE_CFDI_CONCEPTO.
     * @param value The supplied value.
     */
    @Override
    public void setValue(int type, Object value) {
        switch (type) {
            case SDataConstants.TRN_DPS:
                moParamDpsSource = (SDataDps) value;
                moPanelDps.setDps(moParamDpsSource, null);
                
                renderDpsSourceEntries();
                break;

            case VALUE_TYPE_CFDI_CONCEPTO:
                moConcepto = (cfd.ver33.DElementConcepto) value;
 
                jtfNoIdentificacion.setText(moConcepto.getAttNoIdentificacion().getString());
                jtfNoIdentificacion.setCaretPosition(0);
                jtfDescripcion.setText(moConcepto.getAttDescripcion().getString());
                jtfDescripcion.setCaretPosition(0);
                jtfProdServ.setText(moConcepto.getAttClaveProdServ().getString());
                jtfProdServ.setCaretPosition(0);
                jtfUnidad.setText(moConcepto.getAttUnidad().getString());
                jtfUnidad.setCaretPosition(0);
                jtfUnidadSat.setText(moConcepto.getAttClaveUnidad().getString());
                jtfUnidadSat.setCaretPosition(0);
                jtfCantidad.setText(moConcepto.getAttCantidad().getDouble() + "");
                jtfCantidad.setCaretPosition(0);
                break;
                
            default:
        }
    }
    
    /**
     * @param type Options accepted: SDataConstants.TRN_DPS_ETY or SDialogCfdiPurchaseOrder.VALUE_TYPE_FACTOR_CONV.
     * @return 
     */
    @Override
    public java.lang.Object getValue(int type) {
        Object value = null;

        switch (type) {
            case SDataConstants.TRN_DPS_ETY:
                Vector<SDataEntryDpsDpsLink> entries = new Vector<SDataEntryDpsDpsLink>();
                for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
                    SDataEntryDpsDpsLink entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
                    if (entry.getQuantityToLink() > 0) {
                        entries.add(entry);
                    }
                }
                value = entries.get(0); // objeto de tipo SDataDpsEntry
                break;

            case VALUE_TYPE_FACTOR_CONV:
                value = Double.parseDouble(jtfConvertionFactor.getText().equals("") ? "1.0" : jtfConvertionFactor.getText()); // double
                break;
                
            default:
        }

        return value;
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        return null;
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
            else if (button == jbSetEverything) {
                actionSetEverything();
            }
            else if (button == jbSetNothing) {
                actionSetNothing();
            }
        }
    }
}
