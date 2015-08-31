/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogDpsLink.java
 *
 * Created on 22/09/2009, 04:24:20 PM
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mtrn.data.SDataDps;
import erp.mtrn.data.SDataDpsDpsLink;
import erp.mtrn.data.SDataDpsEntry;
import erp.mtrn.data.SDataEntryDpsDpsLink;
import erp.mtrn.data.SGuiDpsEntryPrice;
import erp.mtrn.data.SGuiDpsLink;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Sergio Flores
 */
public class SDialogDpsLink extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener, javax.swing.event.ListSelectionListener, java.awt.event.ItemListener {

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

    /** Creates new form SDialogDpsLink */
    public SDialogDpsLink(erp.client.SClientInterface client) {
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
        jlPanelDps = new javax.swing.JLabel();
        jpOptions = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jbSetEverything = new javax.swing.JButton();
        jbSetNothing = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlEntryPrice = new javax.swing.JLabel();
        jcbDpsEntryPrices = new javax.swing.JComboBox<SFormComponentItem>();
        jlOriginalQuantity = new javax.swing.JLabel();
        jtfOriginalQuantity = new javax.swing.JTextField();
        jlOriginalQuantityProcessed = new javax.swing.JLabel();
        jtfOriginalQuantityProcessed = new javax.swing.JTextField();
        jlOriginalQuantityToProcess = new javax.swing.JLabel();
        jtfOriginalQuantityAvailable = new javax.swing.JTextField();
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

        jlPanelDps.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlPanelDps.setText("[Panel de documento de compras-ventas]");
        jlPanelDps.setPreferredSize(new java.awt.Dimension(100, 200));
        jpDps.add(jlPanelDps, java.awt.BorderLayout.NORTH);

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Partidas del documento disponibles para vinculación:"));
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar entrega mensual:"));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        jlEntryPrice.setText("Entrega mensual:");
        jlEntryPrice.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel1.add(jlEntryPrice);

        jcbDpsEntryPrices.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015-01; base: 1.12; futuro: 0.87" }));
        jcbDpsEntryPrices.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel1.add(jcbDpsEntryPrices);

        jlOriginalQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlOriginalQuantity.setText("Cant.:");
        jlOriginalQuantity.setEnabled(false);
        jlOriginalQuantity.setFocusable(false);
        jlOriginalQuantity.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jlOriginalQuantity);

        jtfOriginalQuantity.setEditable(false);
        jtfOriginalQuantity.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfOriginalQuantity.setText("0.0000");
        jtfOriginalQuantity.setEnabled(false);
        jtfOriginalQuantity.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jtfOriginalQuantity);

        jlOriginalQuantityProcessed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlOriginalQuantityProcessed.setText("Cant. proc.:");
        jlOriginalQuantityProcessed.setEnabled(false);
        jlOriginalQuantityProcessed.setFocusable(false);
        jlOriginalQuantityProcessed.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jlOriginalQuantityProcessed);

        jtfOriginalQuantityProcessed.setEditable(false);
        jtfOriginalQuantityProcessed.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfOriginalQuantityProcessed.setText("0.0000");
        jtfOriginalQuantityProcessed.setEnabled(false);
        jtfOriginalQuantityProcessed.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jtfOriginalQuantityProcessed);

        jlOriginalQuantityToProcess.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlOriginalQuantityToProcess.setText("Cant. pen.:");
        jlOriginalQuantityToProcess.setEnabled(false);
        jlOriginalQuantityToProcess.setFocusable(false);
        jlOriginalQuantityToProcess.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jlOriginalQuantityToProcess);

        jtfOriginalQuantityAvailable.setEditable(false);
        jtfOriginalQuantityAvailable.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfOriginalQuantityAvailable.setText("0.0000");
        jtfOriginalQuantityAvailable.setEnabled(false);
        jtfOriginalQuantityAvailable.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jtfOriginalQuantityAvailable);

        jpOptions.add(jPanel1, java.awt.BorderLayout.SOUTH);

        jpDps.add(jpOptions, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpDps, java.awt.BorderLayout.CENTER);

        jpControls.setPreferredSize(new java.awt.Dimension(392, 33));
        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jpControls.add(jbCancel);

        getContentPane().add(jpControls, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(900, 600));
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
        jcbDpsEntryPrices.addItemListener(this);

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
        double linked = 0;
        double linkedActual = 0;

        moTablePane.createTable();
        moTablePane.clearTableRows();

        if (moParamDpsSource != null) {
            for (SDataDpsEntry entry : moParamDpsSource.getDbmsDpsEntries()) {
                if (!entry.getIsDeleted()) {
                    SDataEntryDpsDpsLink entryLink = null;

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
            renderDpsPriceList();
                    
            ListSelectionModel selectionModel = moTablePane.getTable().getSelectionModel();
            selectionModel.addListSelectionListener(this);
            moTablePane.getTable().setSelectionModel(selectionModel);
        }
    }
    
    private void renderDpsPriceList() {
        ArrayList<SFormComponentItem> items = null;
        jcbDpsEntryPrices.removeAllItems();
        jcbDpsEntryPrices.addItem(new SFormComponentItem(null, "(Seleccionar precio)"));
        
        SDataEntryDpsDpsLink selectedRow = (SDataEntryDpsDpsLink) moTablePane.getSelectedTableRow();
        if (selectedRow == null) {
            return;
        }
        
        if (moGuiDpsLink != null) {
            items = moGuiDpsLink.pickGuiDpsSourceEntry((int[]) moParamDpsSource.getPrimaryKey(), (int[]) selectedRow.getDpsEntryKey()).createFormComponentEntryPrices();
        }
        
        if (items != null) {
            for(SFormComponentItem componentItem : items) {
                jcbDpsEntryPrices.addItem(componentItem);
                
                if (selectedRow.getAuxSGuiDpsEntryPrice() != null) {
                    if (SLibUtilities.compareKeys(selectedRow.getAuxSGuiDpsEntryPrice().getDataDpsEntryPrice().getPrimaryKey(), ((SGuiDpsEntryPrice) componentItem.getComplement()).getDataDpsEntryPrice().getPrimaryKey())) {
                        jcbDpsEntryPrices.setSelectedItem(componentItem);
                    }
                }
                else {
                    if (jcbDpsEntryPrices.getSelectedIndex() == SLibConstants.UNDEFINED) {
                        if (jcbDpsEntryPrices.getModel().getSize() > 1) {
                            jcbDpsEntryPrices.setSelectedIndex(1);
                        }
                    }
                }
                renderEntryPriceSatus((SFormComponentItem) jcbDpsEntryPrices.getSelectedItem());
            }                
        }
        else {
            jlEntryPrice.setEnabled(false);
            jcbDpsEntryPrices.setEnabled(false);
            jcbDpsEntryPrices.setFocusable(false);
            renderEntryPriceSatus(null);
        }                
    }
    
     private void renderEntryPriceSatus(SFormComponentItem item){
        jtfOriginalQuantity.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(0));
        jtfOriginalQuantityProcessed.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(0));
        jtfOriginalQuantityAvailable.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(0));  
        
        if (item != null && item.getPrimaryKey() != null) {
           SGuiDpsEntryPrice entryPrice = (SGuiDpsEntryPrice) item.getComplement();
           jtfOriginalQuantity.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entryPrice.getDataDpsEntryPrice().getOriginalQuantity()));
           jtfOriginalQuantityProcessed.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entryPrice.getDataDpsEntryPrice().getOriginalQuantity() - entryPrice.obtainQtyAvailable()));
           jtfOriginalQuantityAvailable.setText(miClient.getSessionXXX().getFormatters().getDecimalsQuantityFormat().format(entryPrice.obtainQtyAvailable()));
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
    private void actionEntryPriceSelected(SFormComponentItem item) {
        SDataEntryDpsDpsLink selectedRow = (SDataEntryDpsDpsLink) moTablePane.getSelectedTableRow();
        if (selectedRow != null) {
            selectedRow.setAuxSGuiDpsEntryPrice(null);
            if (item != null) {
                if (item.getPrimaryKey() != null) {
                   selectedRow.setAuxSGuiDpsEntryPrice((SGuiDpsEntryPrice) item.getComplement());
                }
            }
        }
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
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbSetEverything;
    private javax.swing.JButton jbSetNothing;
    private javax.swing.JComboBox<SFormComponentItem> jcbDpsEntryPrices;
    private javax.swing.JLabel jlEntryPrice;
    private javax.swing.JLabel jlOriginalQuantity;
    private javax.swing.JLabel jlOriginalQuantityProcessed;
    private javax.swing.JLabel jlOriginalQuantityToProcess;
    private javax.swing.JLabel jlPanelDps;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpDps;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JTextField jtfOriginalQuantity;
    private javax.swing.JTextField jtfOriginalQuantityAvailable;
    private javax.swing.JTextField jtfOriginalQuantityProcessed;
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
        double totalSurplus = 0;
        double totalLinked = 0;
        SFormValidation validation = new SFormValidation();

        updateLink();

        for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
            SDataEntryDpsDpsLink entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
            if (entry.getQuantityToLink() > 0) {
                // Validate that quantity to link does not exceed limit:

                rows++;

                //Need monthly delivery

                if (!validation.getIsError() && isOrder) {
                    if (moGuiDpsLink.pickGuiDpsSourceEntry((int[]) moParamDpsSource.getPrimaryKey(), (int[]) entry.getDpsEntryKey()).getGuiDpsSourceEntryPrices().size() > 0){
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
                            
                            //Need monthly delivery validation:
                            
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
                            
                            //Need total qty validation:
                            
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
                            
                            //Need monthly delivery validation:
                            
                            Date datePrice = null;
                            Date dateSourceDocLapsing = null;
                            datePrice = SLibTimeUtilities.createDate(entry.getAuxSGuiDpsEntryPrice().getDataDpsEntryPrice().getContractPriceYear(), entry.getAuxSGuiDpsEntryPrice().getDataDpsEntryPrice().getContractPriceMonth());
                            dateSourceDocLapsing = SLibTimeUtilities.createDate(SLibTimeUtilities.digestYearMonth(moParamDpsSource.getDateDocLapsing_n())[0], SLibTimeUtilities.digestYearMonth(moParamDpsSource.getDateDocLapsing_n())[1]);
                            if (datePrice.compareTo(dateSourceDocLapsing) == 0) {
                                
                                //Only validate surplus when is the last delivery
                                
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
                                
                                //For other deliveries, apply normal validation
                                
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
                            
                            //Need total qty validation:
                            
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
            case SDataConstants.TRNX_DPS_SRC:
                moParamDpsSource = (SDataDps) value;
                moPanelDps.setDps(moParamDpsSource, null);
                break;

            case SDataConstants.TRNX_DPS_DES:
                manParamDpsDestinyPk = (int[]) value;
                renderDpsSourceEntries();
                break;
                
            case SDataConstants.TRN_DPS_ETY_PRC:
                moGuiDpsLink = (SGuiDpsLink) value;
                break;
            case SDataConstants.TRNS_CL_DPS:
                isOrder = (Boolean) value;
                
                if (isOrder) {
                    jlEntryPrice.setEnabled(true);
                    jcbDpsEntryPrices.setEnabled(true);
                    jcbDpsEntryPrices.setFocusable(true);
                }
                else {
                    jlEntryPrice.setEnabled(false);
                    jcbDpsEntryPrices.setEnabled(false);
                    jcbDpsEntryPrices.setFocusable(false);
                }
                break;
                
            default:
            
        }
    }

    @Override
    public java.lang.Object getValue(int type) {
        Object value = null;

        switch (type) {
            case SDataConstants.TRNX_DPS_DES:
                Vector<SDataEntryDpsDpsLink> entries = new Vector<SDataEntryDpsDpsLink>();
                for (int i = 0; i < moTablePane.getTableGuiRowCount(); i++) {
                    SDataEntryDpsDpsLink entry = (SDataEntryDpsDpsLink) moTablePane.getTableRow(i);
                    if (entry.getQuantityToLink() > 0) {
                        entries.add(entry);
                    }
                }
                value = entries;
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

    @Override
    public void valueChanged(ListSelectionEvent e) {
        renderDpsPriceList();        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof javax.swing.JComboBox) {
                JComboBox comboBox = (JComboBox)  e.getSource();
                if (comboBox.isEnabled() && comboBox == jcbDpsEntryPrices && e.getStateChange() == ItemEvent.SELECTED) {
                    actionEntryPriceSelected((SFormComponentItem) comboBox.getSelectedItem());
                    renderEntryPriceSatus((SFormComponentItem) comboBox.getSelectedItem());
                }
        }
    }
}
