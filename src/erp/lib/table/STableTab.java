/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.lib.table;

import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormUtilities;
import erp.server.SQueryRequest;
import erp.server.SServerConstants;
import erp.server.SServerRequest;
import erp.server.SServerResponse;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import sa.lib.SLibConsts;
import sa.lib.SLibRpnArgument;
import sa.lib.SLibRpnArgumentType;
import sa.lib.SLibRpnUtils;
import sa.lib.SLibUtils;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.xml.SXmlColumnView;
import sa.lib.grid.xml.SXmlGridXml;
import sa.lib.grid.xml.SXmlRpnArgument;
import sa.lib.grid.xml.SXmlSortKey;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUserGui;
import sa.lib.srv.SSrvConsts;
import sa.lib.xml.SXmlElement;

/**
 *
 * @author Sergio Flores
 */
public abstract class STableTab extends javax.swing.JPanel implements erp.lib.table.STableTabInterface, java.awt.event.ActionListener, javax.swing.event.ListSelectionListener {

    private javax.swing.ImageIcon moIconReset = new ImageIcon(getClass().getResource("/erp/img/icon_reset.gif"));
    private javax.swing.ImageIcon moIconResetUpd = new ImageIcon(getClass().getResource("/erp/img/icon_reset_upd.gif"));
    private javax.swing.ImageIcon moIconReload = new ImageIcon(getClass().getResource("/erp/img/icon_reload.gif"));
    private javax.swing.ImageIcon moIconReloadUpd = new ImageIcon(getClass().getResource("/erp/img/icon_reload_upd.gif"));

    protected erp.client.SClientInterface miClient;
    protected java.lang.String msTabTitle;
    protected int mnTabType;
    protected int mnTabTypeAux01;
    protected int mnTabTypeAux02;

    protected boolean mbFirstTime;
    protected java.lang.String msSql;
    protected boolean mbIsSummaryApplying;
    protected java.text.DecimalFormat moIntegerFormat;

    protected erp.lib.table.STablePane moTablePane;
    protected java.util.Vector<java.lang.Integer> mvSuscriptors;
    protected java.util.Vector<erp.lib.table.STableSetting> mvTableSettings;
    protected java.util.List<javax.swing.RowSorter.SortKey> miSortKeysList;
    protected java.util.ArrayList<erp.lib.table.STableColumn> maDefaultTableColumns;

    protected boolean mbClearSettingsNeeded;
    protected boolean mbReloadNeeded;
    protected boolean mbForceReload;
    protected int[] manUserGuiKey;
    protected SGuiUserGui miUserGui;

    /** Creates new form STableTab */
    public STableTab(erp.client.SClientInterface client, java.lang.String tabTitle, int tabType) {
        this(client, tabTitle, tabType, 0, 0);
    }

    /** Creates new form STableTab */
    public STableTab(erp.client.SClientInterface client, java.lang.String tabTitle, int tabType, int auxType01) {
        this(client, tabTitle, tabType, auxType01, 0);
    }

    /** Creates new form STableTab */
    public STableTab(erp.client.SClientInterface client, java.lang.String tabTitle, int tabType, int auxType01, int auxType02) {
        miClient = client;
        msTabTitle = tabTitle;
        mnTabType = tabType;
        mnTabTypeAux01 = auxType01;
        mnTabTypeAux02 = auxType02;

        initComponents();
        initComponentsCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpNorth = new javax.swing.JPanel();
        jpNorthWest = new javax.swing.JPanel();
        jbNew = new javax.swing.JButton();
        jbEdit = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jpNorthEast = new javax.swing.JPanel();
        jtfSeek = new javax.swing.JTextField();
        jbSeek = new javax.swing.JButton();
        jbExportCsv = new javax.swing.JButton();
        jbClearSettings = new javax.swing.JButton();
        jbReload = new javax.swing.JButton();
        jpNorthSouth = new javax.swing.JPanel();
        jpSouth = new javax.swing.JPanel();
        jpSouth1 = new javax.swing.JPanel();
        jtfRows = new javax.swing.JTextField();
        jpSouth2 = new javax.swing.JPanel();
        jtbAutoReload = new javax.swing.JToggleButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jpNorth.setLayout(new java.awt.BorderLayout());

        jpNorthWest.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jbNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_new.gif"))); // NOI18N
        jbNew.setToolTipText("Crear [Ctrl+N]");
        jbNew.setEnabled(false);
        jbNew.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthWest.add(jbNew);

        jbEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_edit.gif"))); // NOI18N
        jbEdit.setToolTipText("Modificar [Ctrl+M]");
        jbEdit.setEnabled(false);
        jbEdit.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthWest.add(jbEdit);

        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_delete.gif"))); // NOI18N
        jbDelete.setToolTipText("Eliminar [Ctrl+D]");
        jbDelete.setEnabled(false);
        jbDelete.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthWest.add(jbDelete);

        jpNorth.add(jpNorthWest, java.awt.BorderLayout.WEST);

        jpNorthEast.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 3, 0));

        jtfSeek.setText("Seek");
        jtfSeek.setToolTipText("Texto a buscar [Ctrl+B]");
        jtfSeek.setEnabled(false);
        jtfSeek.setPreferredSize(new java.awt.Dimension(100, 20));
        jpNorthEast.add(jtfSeek);

        jbSeek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_seek.gif"))); // NOI18N
        jbSeek.setToolTipText("Buscar");
        jbSeek.setEnabled(false);
        jbSeek.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthEast.add(jbSeek);

        jbExportCsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_file_csv.gif"))); // NOI18N
        jbExportCsv.setToolTipText("Exportar CSV [Ctrl+E]");
        jbExportCsv.setEnabled(false);
        jbExportCsv.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthEast.add(jbExportCsv);

        jbClearSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_reset.gif"))); // NOI18N
        jbClearSettings.setToolTipText("Limpiar preferencias (Ctrl+L)");
        jbClearSettings.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthEast.add(jbClearSettings);

        jbReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_reload.gif"))); // NOI18N
        jbReload.setToolTipText("Refrescar [Ctrl+R]");
        jbReload.setPreferredSize(new java.awt.Dimension(23, 23));
        jpNorthEast.add(jbReload);

        jpNorth.add(jpNorthEast, java.awt.BorderLayout.EAST);

        jpNorthSouth.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));
        jpNorth.add(jpNorthSouth, java.awt.BorderLayout.SOUTH);

        add(jpNorth, java.awt.BorderLayout.NORTH);

        jpSouth.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 0, 0));
        jpSouth.setLayout(new java.awt.GridLayout(1, 0));

        jpSouth1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jtfRows.setEditable(false);
        jtfRows.setText("000,000/000,000");
        jtfRows.setToolTipText("Renglón actual");
        jtfRows.setFocusable(false);
        jtfRows.setPreferredSize(new java.awt.Dimension(100, 23));
        jpSouth1.add(jtfRows);

        jpSouth.add(jpSouth1);

        jpSouth2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 0));

        jtbAutoReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sa/lib/img/swi_action_off.gif"))); // NOI18N
        jtbAutoReload.setToolTipText("Refrescar automáticamente");
        jtbAutoReload.setPreferredSize(new java.awt.Dimension(23, 23));
        jtbAutoReload.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/sa/lib/img/swi_action_on.gif"))); // NOI18N
        jpSouth2.add(jtbAutoReload);

        jpSouth.add(jpSouth2);

        add(jpSouth, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        focusTab();
    }//GEN-LAST:event_formComponentShown

    private void initComponentsCustom() {
        mbFirstTime = true;
        msSql = "";
        mbIsSummaryApplying = false;
        moIntegerFormat = new DecimalFormat("#,##0;-#,##0");

        moTablePane = new STablePane(miClient);
        mvSuscriptors = new Vector<Integer>();
        mvTableSettings = new Vector<STableSetting>();
        miSortKeysList = new ArrayList<RowSorter.SortKey>();
        maDefaultTableColumns = new ArrayList<STableColumn>();

        mbClearSettingsNeeded = false;
        mbReloadNeeded = false;
        mbForceReload = false;
        manUserGuiKey = new int[] { miClient.getSession().getUser().getPkUserId(), SGuiConsts.GUI_COMP_VIEW_TAB, mnTabType, mnTabTypeAux01, mnTabTypeAux02, SLibConsts.UNDEFINED };
        miUserGui = ((SGuiClient) miClient).readUserGui(manUserGuiKey);

        jtfSeek.setText("");

        jbNew.addActionListener(this);
        jbEdit.addActionListener(this);
        jbDelete.addActionListener(this);
        jbSeek.addActionListener(this);
        jbExportCsv.addActionListener(this);
        jbClearSettings.addActionListener(this);
        jbReload.addActionListener(this);
        jtfSeek.addActionListener(this);

        jtbAutoReload.setSelected(true);

        SFormUtilities.createActionMap(this, this, "actionNew", "new", KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this, this, "actionEdit", "edit", KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this, this, "actionDelete", "delete", KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this, this, "focusSeek", "seek", KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this, this, "actionExportCsv", "exportCsv", KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this, this, "actionClearSettings", "clearSettings", KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this, this, "actionReload", "reload", KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);

        moTablePane.setDoubleClickAction(this, "actionEdit");
        add(moTablePane, BorderLayout.CENTER);
    }

    /*
     * Private methods
     */

    private void focusTab() {
        if (mbFirstTime) {
            mbFirstTime = false;

            if (jbNew.isEnabled()) {
                jbNew.requestFocus();
            }
            else if (jbEdit.isEnabled()) {
                jbEdit.requestFocus();
            }
            else if (jbDelete.isEnabled()) {
                jbDelete.requestFocus();
            }
            else {
                moTablePane.requestFocus();
            }
        }
    }

    private void adecuateNorthPanel() {
        ((BorderLayout) jpNorth.getLayout()).setVgap(jpNorthSouth.getComponentCount() == 0 ? 0 : 3);
    }

    /*
     * Protected methods
     */

    protected void computeUserGui() {
        boolean found = false;
        SXmlGridXml gridXml = new SXmlGridXml(SGridConsts.GRID_PANE_VIEW);

        miSortKeysList.clear();
        mbClearSettingsNeeded = false;

        try {
            gridXml.processXml(miUserGui.getGui());

            jtbAutoReload.setSelected((Boolean) gridXml.getAttribute(SXmlGridXml.ATT_AUTO_RELOAD).getValue());

            for (SXmlElement element : gridXml.getXmlElements()) {
                if (element instanceof SXmlColumnView) {
                    // Columns:

                    SXmlColumnView xmlColumn = (SXmlColumnView) element;
                    STableColumn tableColumn = new STableColumn(
                            (Integer) xmlColumn.getAttribute(SXmlColumnView.ATT_COLUMN_TYPE).getValue(),
                            (String) xmlColumn.getAttribute(SXmlColumnView.ATT_FIELD_NAME).getValue(),
                            (String) xmlColumn.getAttribute(SXmlColumnView.ATT_COLUMN_TITLE).getValue(),
                            (Integer) xmlColumn.getAttribute(SXmlColumnView.ATT_COLUMN_WIDTH).getValue());
                    tableColumn.setSumApplying((Boolean) xmlColumn.getAttribute(SXmlColumnView.ATT_IS_SUM_APPLYING).getValue());
                    tableColumn.setCellRenderer(miClient.getSessionXXX().getFormatters().getCellRenderer((Integer) xmlColumn.getAttribute(SXmlColumnView.ATT_CELL_RENDERER).getValue()));

                    if (!xmlColumn.getXmlElements().isEmpty()) {
                        for (SXmlElement child : xmlColumn.getXmlElements()) {
                            if (child.getName().compareTo(SXmlRpnArgument.NAME) == 0) {
                                SXmlRpnArgument xmlRpnArgument = (SXmlRpnArgument) child;
                                SLibRpnArgument rpnArgument = null;
                                switch (SLibRpnUtils.getArgumentType((String) xmlRpnArgument.getAttribute(SXmlRpnArgument.ATT_ARGUMENT_TYPE).getValue())) {
                                    case OPERAND:
                                        rpnArgument = new SLibRpnArgument(
                                                (String) xmlRpnArgument.getAttribute(SXmlRpnArgument.ATT_ARGUMENT).getValue(),
                                                SLibRpnArgumentType.OPERAND);
                                        break;
                                    case OPERATOR:
                                        rpnArgument = new SLibRpnArgument(
                                                SLibRpnUtils.getOperator((String) xmlRpnArgument.getAttribute(SXmlRpnArgument.ATT_ARGUMENT).getValue()),
                                                SLibRpnArgumentType.OPERATOR);
                                        break;
                                    default:
                                }
                                if (rpnArgument != null) {
                                    tableColumn.getRpnArguments().add(rpnArgument);
                                }
                            }
                        }
                    }
  
                    moTablePane.addTableColumn(tableColumn);
                }
                else if (element instanceof SXmlSortKey) {
                    // Sort keys:

                    SXmlSortKey xmlSortKey = (SXmlSortKey) element;
                    RowSorter.SortKey sortKey = null;
                    SortOrder sortOrder = null;
                    String sortOrderValue = (String) xmlSortKey.getAttribute(SXmlSortKey.ATT_SORT_ORDER).getValue();

                    if (sortOrderValue.compareTo(SortOrder.ASCENDING.toString()) == 0) {
                        sortOrder = SortOrder.ASCENDING;
                    }
                    else if (sortOrderValue.compareTo(SortOrder.DESCENDING.toString()) == 0) {
                        sortOrder = SortOrder.DESCENDING;
                    }
                    else {
                        sortOrder = SortOrder.UNSORTED;
                    }

                    sortKey = new RowSorter.SortKey(
                            (Integer) xmlSortKey.getAttribute(SXmlSortKey.ATT_COLUMN).getValue(),
                            sortOrder);

                    miSortKeysList.add(sortKey);
                }
            }
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }

        // Check if customized columns are equivalent to default columns:

        if (maDefaultTableColumns.size() != moTablePane.getTableModelColumnCount()) {
            mbClearSettingsNeeded = true;
        }
        else {
            for (int i = 0; i < maDefaultTableColumns.size(); i++) {
                found = false;
                for (int j = 0; j < moTablePane.getTableModelColumnCount(); j++) {
                    if (maDefaultTableColumns.get(i).getFieldName().compareTo(moTablePane.getTableColumn(j).getFieldName()) == 0 &&
                            maDefaultTableColumns.get(i).getColumnType() == moTablePane.getTableColumn(j).getColumnType() &&
                            maDefaultTableColumns.get(i).getColumnTitle().compareTo(moTablePane.getTableColumn(j).getColumnTitle()) == 0 &&
                            maDefaultTableColumns.get(i).isSumApplying() == moTablePane.getTableColumn(j).isSumApplying()) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    mbClearSettingsNeeded = true;
                    break;
                }
            }
        }

        if (mbClearSettingsNeeded) {
            jbClearSettings.setIcon(moIconResetUpd);
        }
    }

    protected void preserveUserGui() {
        if (moTablePane.getTable() != null && moTablePane.getTable().getRowSorter() != null) {
            String xml = "";
            SXmlGridXml gridXml = new SXmlGridXml(SGridConsts.GRID_PANE_VIEW);
            @SuppressWarnings("unchecked")
            List<RowSorter.SortKey> sortKeys = (List<RowSorter.SortKey>) moTablePane.getTable().getRowSorter().getSortKeys();

            // Grid attributes:

            gridXml.getAttribute(SXmlGridXml.ATT_AUTO_RELOAD).setValue(jtbAutoReload.isSelected());

            // Columns:

            for (int i = 0; i < moTablePane.getTableGuiColumnCount(); i++) {
                SXmlColumnView xmlColumn = new SXmlColumnView();
                STableColumn tableColumn = moTablePane.getTableColumn(i);
                //STableColumn tableColumn = moTablePane.getTableColumn(moTablePane.getTable().convertColumnIndexToModel(i));

                xmlColumn.getAttribute(SXmlColumnView.ATT_COLUMN_TYPE).setValue(tableColumn.getColumnType());
                xmlColumn.getAttribute(SXmlColumnView.ATT_FIELD_NAME).setValue(tableColumn.getFieldName());
                xmlColumn.getAttribute(SXmlColumnView.ATT_COLUMN_TITLE).setValue(tableColumn.getColumnTitle());
                xmlColumn.getAttribute(SXmlColumnView.ATT_COLUMN_WIDTH).setValue(moTablePane.getTable().getColumnModel().getColumn(i).getWidth());
                xmlColumn.getAttribute(SXmlColumnView.ATT_IS_SUM_APPLYING).setValue(tableColumn.isSumApplying());
                xmlColumn.getAttribute(SXmlColumnView.ATT_CELL_RENDERER).setValue(miClient.getSessionXXX().getFormatters().getCellRendererType(tableColumn.getCellRenderer()));

                for (SLibRpnArgument argument : tableColumn.getRpnArguments()) {
                    SXmlRpnArgument xmlArgument = new SXmlRpnArgument();
                    xmlArgument.getAttribute(SXmlRpnArgument.ATT_ARGUMENT_TYPE).setValue(argument.getArgumentType());
                    xmlArgument.getAttribute(SXmlRpnArgument.ATT_ARGUMENT).setValue(argument.getArgument());
                    xmlColumn.getXmlElements().add(xmlArgument);
                }

                gridXml.getXmlElements().add(xmlColumn);
            }

            // Sort keys:

            if (sortKeys.isEmpty()) {
                sortKeys = new ArrayList<RowSorter.SortKey>();
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));    // just in case there are not sort keys
            }
            else {
                for (RowSorter.SortKey sortKey : sortKeys) {
                    SXmlSortKey xmlSortKey = new SXmlSortKey();
                    xmlSortKey.getAttribute(SXmlSortKey.ATT_COLUMN).setValue(moTablePane.getTable().convertColumnIndexToView(sortKey.getColumn()));
                    xmlSortKey.getAttribute(SXmlSortKey.ATT_SORT_ORDER).setValue(sortKey.getSortOrder().toString());
                    gridXml.getXmlElements().add(xmlSortKey);
                }
            }

            xml = gridXml.getXmlString();
            miUserGui = ((SGuiClient) miClient).saveUserGui(manUserGuiKey, xml);
        }
    }

    @SuppressWarnings("unchecked")
    protected void populateTable(int refreshMode) {
        int i = 0;
        int col = 0;
        int row = 0;
        int nViewCols = 0;
        boolean bIsDataAvailable = false;
        boolean bIsSummaryApplying = false;
        double[] adSummaryValues = null;
        boolean[] abSummaryApplies = null;
        Vector<STableRow> vTableRows = null;
        ArrayList<SLibRpnArgument>[] aaRpnArguments = null;
        SQueryRequest oQueryRequest = null;
        SServerRequest oRequest = null;
        SServerResponse oResponse = null;
        Cursor cursor = getCursor();

        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));

            if (maDefaultTableColumns.isEmpty()) {
                maDefaultTableColumns.addAll(moTablePane.getTableModel().getTableColumns());    // preserve default columns
            }

            moTablePane.clearTable();

            if (miUserGui == null || refreshMode == STableConstants.REFRESH_MODE_RESET) {
                miSortKeysList.clear();
                miSortKeysList.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                moTablePane.getTableModel().getTableColumns().addAll(maDefaultTableColumns);
            }
            else {
                computeUserGui();       // customized columns added into moModel and sort keys into miSortKeysList
            }

            jtfRows.setText("0/0");
            moTablePane.createTable(this);

            jtfSeek.setEnabled(false);
            jbSeek.setEnabled(false);
            jbExportCsv.setEnabled(false);

            createSqlQuery();

            if (msSql.length() == 0) {
                throw new Exception(STableConstants.MSG_ERR_TABLE_TAB_SQL_QUERY_EMPTY);
            }

            nViewCols = moTablePane.getTableModel().getColumnCount();
            aaRpnArguments = new ArrayList[nViewCols];
            for (i = 0; i < nViewCols; i++) {
                if (moTablePane.getTableColumn(i).getRpnArguments().size() > 0) {
                    aaRpnArguments[i] = new ArrayList<SLibRpnArgument>((Vector<SLibRpnArgument>) moTablePane.getTableColumn(i).getRpnArguments().clone());
                }
            }

            oQueryRequest = new SQueryRequest(
                    new ArrayList<STableField>(moTablePane.getPrimaryKeyFields()),
                    new ArrayList<STableField>(moTablePane.getTableModel().getTableColumns()),
                    new ArrayList<STableField>(moTablePane.getAditionalFields()),
                    aaRpnArguments,
                    new String[] { msSql });
            oRequest = new SServerRequest(SServerConstants.REQ_DB_QUERY, oQueryRequest);
            oResponse = miClient.getSessionXXX().request(oRequest);

            if (oResponse.getResponseType() != SSrvConsts.RESP_TYPE_OK) {
                throw new Exception(oResponse.getMessage());
            }
            else {
                vTableRows = (Vector<STableRow>) oResponse.getPacket();

                // Prepare summary calculations:

                if (mbIsSummaryApplying) {
                    adSummaryValues = new double[nViewCols];
                    abSummaryApplies = new boolean[nViewCols];

                    for (i = 0; i < nViewCols; i++) {
                        if (((erp.lib.table.STableColumn) moTablePane.getTableColumn(i)).isSumApplying()) {
                            bIsSummaryApplying = true;
                            abSummaryApplies[i] = true;
                        }
                        else {
                            abSummaryApplies[i] = false;
                        }
                    }
                }

                // Load table data:

                for (row = 0; row < vTableRows.size(); row++) {
                    STableRow tableRow = (STableRow) vTableRows.get(row);

                    if (mbIsSummaryApplying) {
                        for (col = 0; col < nViewCols; col++) {
                            if (abSummaryApplies[col]) {
                                switch (moTablePane.getTableColumn(col).getColumnType()) {
                                    case SLibConstants.DATA_TYPE_INTEGER:
                                    case SLibConstants.DATA_TYPE_LONG:
                                    case SLibConstants.DATA_TYPE_FLOAT:
                                    case SLibConstants.DATA_TYPE_DOUBLE:
                                        adSummaryValues[col] += ((java.lang.Number) tableRow.getValues().get(col)).doubleValue();
                                        break;
                                    default:
                                }
                            }
                        }
                    }

                    bIsDataAvailable = true;
                    moTablePane.addTableRow(tableRow);
                }

                if (bIsDataAvailable && bIsSummaryApplying) {
                    STableRowCustom tableRowCustom = new STableRowCustom();

                    tableRowCustom.setPrimaryKey(new int[moTablePane.getPrimaryKeyFields().size()]);
                    tableRowCustom.setIsSummary(true);

                    for (col = 0; col < nViewCols; col++) {
                        if (!abSummaryApplies[col]) {
                            if (col == 0 && ((erp.lib.table.STableColumn) moTablePane.getTableColumn(col)).getColumnType() == SLibConstants.DATA_TYPE_STRING) {
                                tableRowCustom.getValues().add("[TOTALES]");
                            }
                            else {
                                tableRowCustom.getValues().add(null);
                            }
                        }
                        else {
                            switch (((erp.lib.table.STableColumn) moTablePane.getTableColumn(col)).getColumnType()) {
                                case SLibConstants.DATA_TYPE_INTEGER:
                                    tableRowCustom.getValues().add((int) adSummaryValues[col]);
                                    break;
                                case SLibConstants.DATA_TYPE_LONG:
                                    tableRowCustom.getValues().add((long) adSummaryValues[col]);
                                    break;
                                case SLibConstants.DATA_TYPE_FLOAT:
                                    tableRowCustom.getValues().add((float) adSummaryValues[col]);
                                    break;
                                case SLibConstants.DATA_TYPE_DOUBLE:
                                    tableRowCustom.getValues().add(adSummaryValues[col]);
                                    break;
                                default:
                                    tableRowCustom.getValues().add(null);
                            }
                        }
                    }

                    moTablePane.addTableRow(tableRowCustom);
                }
            }
        }
        catch(java.sql.SQLException e) {
            SLibUtilities.renderException(this, e);
        }
        catch(java.lang.Exception e) {
            SLibUtilities.renderException(this, e);
        }
        finally {
            moTablePane.getTable().getRowSorter().setSortKeys(miSortKeysList);

            if (bIsDataAvailable) {
                moTablePane.setTableRowSelection(0);
                jtfSeek.setEnabled(true);
                jbSeek.setEnabled(true);
                jbExportCsv.setEnabled(true);
            }

            if (mbReloadNeeded) {
                mbReloadNeeded = false;
                jbReload.setIcon(moIconReload);
            }

            setCursor(cursor);
        }
    }

    /*
     * Public methods
     */

    public void setSql(java.lang.String s) { msSql = s; }
    public void setIsSummaryApplying(boolean b) { mbIsSummaryApplying = b; }
    public void setIntegerFormat(java.text.DecimalFormat o) { moIntegerFormat = o; }
    public void setTablePane(erp.lib.table.STablePane o) { moTablePane = o; }

    public java.lang.String getSql() { return msSql; }
    public boolean getIsSummaryApplying() { return mbIsSummaryApplying; }
    public java.text.DecimalFormat getIntegerFormat() { return moIntegerFormat; }
    public erp.lib.table.STablePane getTablePane() { return moTablePane; }

    @Override
    public int getTabType() { return mnTabType; }
    @Override
    public int getTabTypeAux01() { return mnTabTypeAux01; }
    @Override
    public int getTabTypeAux02() { return mnTabTypeAux02; }
    @Override
    public java.util.Vector<java.lang.Integer> getSuscriptors() { return mvSuscriptors; }
    @Override
    public java.util.Vector<erp.lib.table.STableSetting> getTableSettings() { return mvTableSettings; }

    public void addTaskBarUpperComponent(javax.swing.JComponent component) {
        jpNorthWest.add(component);
    }

    public void addTaskBarUpperSeparator() {
        javax.swing.JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new java.awt.Dimension(3, 23));
        jpNorthWest.add(separator);
    }

    public void removeTaskBarUpperComponent(javax.swing.JComponent component) {
        jpNorthWest.remove(component);
    }

    public void addTaskBarLowerComponent(javax.swing.JComponent component) {
        jpNorthSouth.add(component);
        adecuateNorthPanel();
    }

    public void addTaskBarLowerSeparator() {
        javax.swing.JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new java.awt.Dimension(3, 23));
        jpNorthSouth.add(separator);
        adecuateNorthPanel();
    }

    public void removeTaskBarLowerComponent(javax.swing.JComponent component) {
        jpNorthSouth.remove(component);
        adecuateNorthPanel();
    }

    @Override
    public void addSetting(erp.lib.table.STableSetting setting) {
        boolean add = true;
        erp.lib.table.STableSetting settingAux;

        for (int i = 0; i < mvTableSettings.size(); i++) {
            settingAux = (erp.lib.table.STableSetting) mvTableSettings.get(i);
            if (settingAux.getType() == setting.getType()) {
                add = false;
                mvTableSettings.set(i, setting);
                break;
            }
        }

        if (add) {
            mvTableSettings.add(setting);
        }
    }

    @Override
    public void updateSetting(erp.lib.table.STableSetting setting) {
        addSetting(setting);
        populateTable(STableConstants.REFRESH_MODE_RELOAD);
    }

    public void populateTable() {
        populateTable(STableConstants.REFRESH_MODE_RELOAD);
    }

    public void focusSeek() {
        if (jtfSeek.isEnabled()) {
            jtfSeek.requestFocus();
        }
    }

    public abstract void createSqlQuery();
    public abstract void actionNew();
    public abstract void actionEdit();
    public abstract void actionDelete();

    public void tableTabClosed() {
        preserveUserGui();
    }

    public void actionSeek() {
        if (jbSeek.isEnabled()) {
            STableUtilities.actionSeek(miClient, moTablePane, jtfSeek.getText().trim());
        }
    }

    public void actionExportCsv() {
        if (jbExportCsv.isEnabled()) {
            STableUtilities.actionExportCsv(miClient, moTablePane, msTabTitle);
        }
    }

    public void actionClearSettings() {
        if (jbClearSettings.isEnabled()) {
            if (miClient.showMsgBoxConfirm(SGridConsts.MSG_CONFIRM_RESET_SETTINGS) == JOptionPane.YES_OPTION) {
                actionRefresh(STableConstants.REFRESH_MODE_RESET);

                if (mbClearSettingsNeeded) {
                    mbClearSettingsNeeded = false;
                    jbClearSettings.setIcon(moIconReset);
                }
            }
        }
    }

    public void actionReload() {
        if (jbReload.isEnabled()) {
            mbForceReload = true;
            actionRefresh(STableConstants.REFRESH_MODE_RELOAD);
        }
    }

    /**
     * @param refreshMode Constants defined in STableConstants.
     */
    @Override
    public void actionRefresh(int refreshMode) {
        int index = -1;
        int valueV = 0;
        int valueH = 0;

        if (refreshMode == STableConstants.REFRESH_MODE_RELOAD && !jtbAutoReload.isSelected() && !mbForceReload) {
            mbReloadNeeded = true;
            jbReload.setIcon(moIconReloadUpd);
        }
        else {
            if (refreshMode == STableConstants.REFRESH_MODE_RELOAD) {
                mbForceReload = false;
                preserveUserGui();
                index = moTablePane.getTable().getSelectedRow();
                valueV = moTablePane.getVerticalScrollBar().getValue();
                valueH = moTablePane.getHorizontalScrollBar().getValue();
            }

            populateTable(refreshMode);

            mbFirstTime = true;
            focusTab();

            moTablePane.validate();
            if (refreshMode == STableConstants.REFRESH_MODE_RELOAD) {
                moTablePane.getVerticalScrollBar().setValue(valueV < moTablePane.getVerticalScrollBar().getMaximum() ? valueV : moTablePane.getVerticalScrollBar().getMaximum());
                moTablePane.getHorizontalScrollBar().setValue(valueH < moTablePane.getHorizontalScrollBar().getMaximum() ? valueH : moTablePane.getHorizontalScrollBar().getMaximum());

                if (index != -1) {
                    if (index > moTablePane.getTableGuiRowCount()) {
                        index = moTablePane.getTableGuiRowCount() - 1;
                    }

                    if (index != -1 && index < moTablePane.getTableGuiRowCount()) {
                        moTablePane.getTable().setRowSelectionInterval(index, index);
                    }
                }
            }
            else {
                preserveUserGui();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbClearSettings;
    protected javax.swing.JButton jbDelete;
    protected javax.swing.JButton jbEdit;
    private javax.swing.JButton jbExportCsv;
    protected javax.swing.JButton jbNew;
    private javax.swing.JButton jbReload;
    private javax.swing.JButton jbSeek;
    private javax.swing.JPanel jpNorth;
    private javax.swing.JPanel jpNorthEast;
    private javax.swing.JPanel jpNorthSouth;
    private javax.swing.JPanel jpNorthWest;
    private javax.swing.JPanel jpSouth;
    private javax.swing.JPanel jpSouth1;
    private javax.swing.JPanel jpSouth2;
    protected javax.swing.JToggleButton jtbAutoReload;
    private javax.swing.JTextField jtfRows;
    private javax.swing.JTextField jtfSeek;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbNew) {
                actionNew();
            }
            else if (button == jbEdit) {
                actionEdit();
            }
            else if (button == jbDelete) {
                actionDelete();
            }
            else if (button == jbSeek) {
                actionSeek();
            }
            else if (button == jbExportCsv) {
                actionExportCsv();
            }
            else if (button == jbClearSettings) {
                actionClearSettings();
            }
            else if (button == jbReload) {
                actionReload();
            }
        }
        else if (e.getSource() instanceof javax.swing.JTextField) {
            JTextField textField = (JTextField) e.getSource();

            if (textField == jtfSeek) {
                actionSeek();
            }
        }
    }

    @Override
    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            jtfRows.setText(moIntegerFormat.format(moTablePane.getTable().getSelectedRow() + 1) + "/" + moIntegerFormat.format(moTablePane.getTableGuiRowCount()));
        }
    }
}