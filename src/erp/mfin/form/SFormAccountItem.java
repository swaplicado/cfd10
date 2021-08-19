/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.form.SFormComponentItemPicker;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mfin.data.SDataAccountItem;
import erp.mfin.data.SDataAccountItemEntry;
import erp.mfin.data.SDataAccountItemEntryRow;
import erp.mfin.data.SDataAccountItemItem;
import erp.mfin.data.SDataAccountItemItemRow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author  Sergio Flores
 */
public class SFormAccountItem extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private static final int ALL = 0;
    private static final int DBT = 1;
    private static final int CDT = 2;

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mfin.data.SDataAccountItem moAccountItem;
    private erp.lib.form.SFormField moFieldAccountItem;
    private erp.lib.form.SFormField moFieldIsDeleted;
    private erp.lib.table.STablePane moPaneEntries;
    private erp.lib.table.STablePane moPaneItems;
    private erp.mfin.form.SFormAccountItemEntry moFormEntry;
    private erp.mfin.form.SFormAccountItemItem moFormItem;
    private erp.form.SFormComponentItemPicker moComponentItemPicker;

    private int[] manAccountTypes;
    private java.lang.String msEmptyAccountId;
    private java.lang.String msEmptyCostCenterId;
    private java.lang.String msTextAll;
    private java.lang.String msTextDbt;
    private java.lang.String msTextCdt;

    /** Creates new form SFormAccountItem */
    public SFormAccountItem(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
        mnFormType = SDataConstants.FIN_ACC_ITEM;
        initComponents();
        initComponentsExtra();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpTabbedPane = new javax.swing.JTabbedPane();
        jpAccountItem = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlAccountItem = new javax.swing.JLabel();
        jtfAccountItem = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlDummy01 = new javax.swing.JLabel();
        jckIsDeleted = new javax.swing.JCheckBox();
        jpEntries = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jbEntryNew = new javax.swing.JButton();
        jbEntryEdit = new javax.swing.JButton();
        jbEntryDelete = new javax.swing.JButton();
        jpItems = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jbItemNew = new javax.swing.JButton();
        jbItemEdit = new javax.swing.JButton();
        jbItemDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Paquete de configuración de cuentas contables para ítems"); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpAccountItem.setLayout(new java.awt.BorderLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel13.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        jPanel1.setLayout(new java.awt.GridLayout(2, 2, 5, 5));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jlAccountItem.setText("Paquete de configuración: *");
        jlAccountItem.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel4.add(jlAccountItem, java.awt.BorderLayout.LINE_START);

        jtfAccountItem.setText("ACCOUNT");
        jPanel4.add(jtfAccountItem, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jlDummy01.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel5.add(jlDummy01, java.awt.BorderLayout.LINE_START);

        jckIsDeleted.setText("Registro eliminado");
        jPanel5.add(jckIsDeleted, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);

        jPanel13.add(jPanel1);

        jpAccountItem.add(jPanel13, java.awt.BorderLayout.NORTH);

        jpEntries.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración de cuentas contables:"));
        jpEntries.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 0));

        jbEntryNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_new.gif"))); // NOI18N
        jbEntryNew.setToolTipText("Crear");
        jbEntryNew.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbEntryNew);

        jbEntryEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_edit.gif"))); // NOI18N
        jbEntryEdit.setToolTipText("Modificar");
        jbEntryEdit.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbEntryEdit);

        jbEntryDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_delete.gif"))); // NOI18N
        jbEntryDelete.setToolTipText("Eliminar");
        jbEntryDelete.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbEntryDelete);

        jpEntries.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jpAccountItem.add(jpEntries, java.awt.BorderLayout.CENTER);

        jtpTabbedPane.addTab("Cuentas contables", jpAccountItem);

        jpItems.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignación de cuentas contables:"));
        jpItems.setLayout(new java.awt.BorderLayout());

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 0));

        jbItemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_new.gif"))); // NOI18N
        jbItemNew.setToolTipText("Crear");
        jbItemNew.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel10.add(jbItemNew);

        jbItemEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_edit.gif"))); // NOI18N
        jbItemEdit.setToolTipText("Modificar");
        jbItemEdit.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel10.add(jbItemEdit);

        jbItemDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_delete.gif"))); // NOI18N
        jbItemDelete.setToolTipText("Eliminar");
        jbItemDelete.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel10.add(jbItemDelete);

        jpItems.add(jPanel10, java.awt.BorderLayout.PAGE_START);

        jtpTabbedPane.addTab("Ítems", jpItems);

        getContentPane().add(jtpTabbedPane, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar"); // NOI18N
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbOk);

        jbCancel.setText("Cancelar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-900)/2, (screenSize.height-600)/2, 900, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int i = 0;
        STableColumnForm[] columns = null;
        mvFields = new Vector<SFormField>();

        moFieldAccountItem = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfAccountItem, jlAccountItem);
        moFieldAccountItem.setLengthMax(50);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, true, jckIsDeleted);

        mvFields.add(moFieldAccountItem);
        mvFields.add(moFieldIsDeleted);

        moFormEntry = new SFormAccountItemEntry(miClient);
        moFormItem = new SFormAccountItemItem(miClient);
        moComponentItemPicker = new SFormComponentItemPicker(miClient, SDataConstants.FINS_TP_ACC_ITEM);

        moPaneEntries = new STablePane(miClient);
        moPaneEntries.setDoubleClickAction(this, "publicActionEntryEdit");
        jpEntries.add(moPaneEntries, BorderLayout.CENTER);
        i = 0;
        columns = new STableColumnForm[7];
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo cuentas contables", 150);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "No. cuenta contable", STableConstants.WIDTH_ACCOUNT_ID);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Cuenta contable", STableConstants.WIDTH_ACCOUNT);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "No. centro costo", 100);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Centro costo", 150);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo asiento contable", 75);
        columns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Porcentaje", STableConstants.WIDTH_PERCENTAGE);
        columns[i].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererPercentage());

        for (i = 0; i < columns.length; i++) {
            moPaneEntries.addTableColumn(columns[i]);
        }

        moPaneItems = new STablePane(miClient);
        moPaneItems.setDoubleClickAction(this, "publicActionItemEdit");
        jpItems.add(moPaneItems, BorderLayout.CENTER);
        i = 0;
        columns = new STableColumnForm[5];
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Centro contable", 150);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo referencia", 150);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Referencia", 225);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Ini. vigencia", STableConstants.WIDTH_DATE);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Eliminado", STableConstants.WIDTH_BOOLEAN);

        for (i = 0; i < columns.length; i++) {
            moPaneItems.addTableColumn(columns[i]);
        }

        msEmptyAccountId = SDataUtilities.createNewFormattedAccountId(miClient, miClient.getSessionXXX().getParamsErp().getDeepAccounts());
        msEmptyCostCenterId = SDataUtilities.createNewFormattedCostCenterId(miClient, miClient.getSessionXXX().getParamsErp().getDeepCostCenters());
        manAccountTypes = new int[] {
            SDataConstantsSys.FINS_TP_ACC_ITEM_ASSET,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_MFG_CO,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_MFG_BP,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_WAR_PUR,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_WAR_SAL,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_CONSIG_PUR,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_CONSIG_SAL,
            SDataConstantsSys.FINS_TP_ACC_ITEM_COGS,
            SDataConstantsSys.FINS_TP_ACC_ITEM_PUR,
            SDataConstantsSys.FINS_TP_ACC_ITEM_PUR_ADJ_DEV,
            SDataConstantsSys.FINS_TP_ACC_ITEM_PUR_ADJ_DISC,
            SDataConstantsSys.FINS_TP_ACC_ITEM_SAL,
            SDataConstantsSys.FINS_TP_ACC_ITEM_SAL_ADJ_DEV,
            SDataConstantsSys.FINS_TP_ACC_ITEM_SAL_ADJ_DISC,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_OPEN,
            SDataConstantsSys.FINS_TP_ACC_ITEM_INV_END,
            SDataConstantsSys.FINS_TP_ACC_ITEM_ADJ_INC,
            SDataConstantsSys.FINS_TP_ACC_ITEM_ADJ_DEC,
            SDataConstantsSys.FINS_TP_ACC_ITEM_CHG_PUR,
            SDataConstantsSys.FINS_TP_ACC_ITEM_CHG_SAL,
            SDataConstantsSys.FINS_TP_ACC_ITEM_MFG_CO,
            SDataConstantsSys.FINS_TP_ACC_ITEM_MFG_BP,
            SDataConstantsSys.FINS_TP_ACC_ITEM_WAR_PUR,
            SDataConstantsSys.FINS_TP_ACC_ITEM_WAR_SAL,
            SDataConstantsSys.FINS_TP_ACC_ITEM_CONSIG_PUR,
            SDataConstantsSys.FINS_TP_ACC_ITEM_CONSIG_SAL,
            SDataConstantsSys.FINS_TP_ACC_ITEM_DEPREC,
            SDataConstantsSys.FINS_TP_ACC_ITEM_DEPREC_REC,
            SDataConstantsSys.FINS_TP_ACC_ITEM_DEPREC_EXP
        };

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbEntryNew.addActionListener(this);
        jbEntryEdit.addActionListener(this);
        jbEntryDelete.addActionListener(this);
        jbItemNew.addActionListener(this);
        jbItemEdit.addActionListener(this);
        jbItemDelete.addActionListener(this);

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
            jtfAccountItem.requestFocus();
        }
    }

    private erp.mfin.data.SDataAccountItemEntry createEntry(int type, double percentage) {
        SDataAccountItemEntry entry = new SDataAccountItemEntry();

        entry.setPkAccountItemTypeId(type);
        entry.setDbmsAccountItemType(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { type }));
        entry.setPercentage(percentage);
        entry.setFkAccountId_n(msEmptyAccountId);
        entry.setFkCostCenterId_n(msEmptyCostCenterId);
        entry.setFkBookkeepingRegistryTypeId(SDataConstantsSys.FINS_TP_BKR_ALL);
        entry.setDbmsBookkeepingRegistryType(msTextAll);

        return entry;
    }

    private void actionEntryNew() {
        int index = -1;
        SDataAccountItemEntry entry = null;
        SDataAccountItemEntry entryAux = null;

        moComponentItemPicker.formReset();
        moComponentItemPicker.setFormVisible(true);

        if (moComponentItemPicker.getFormResult() == SLibConstants.FORM_RESULT_OK) {
            entry = createEntry(((int[]) moComponentItemPicker.getValue(SLibConstants.VALUE_PRIMARY_KEY))[0], 0d);

            moFormEntry.formReset();
            moFormEntry.setRegistry(entry);
            moFormEntry.setVisible(true);

            if (moFormEntry.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                entry = (SDataAccountItemEntry) moFormEntry.getRegistry();

                for (int i = 0; i < moPaneEntries.getTableGuiRowCount(); i++) {
                    entryAux = (SDataAccountItemEntry) moPaneEntries.getTableRow(i).getData();

                    if (entry.getPkAccountItemTypeId() <= entryAux.getPkAccountItemTypeId()) {
                        index = i;
                        if (entry.getFkAccountId_n().compareTo(entryAux.getFkAccountId_n()) <= 0) {
                            break;
                        }
                    }
                }

                if (index == -1) {
                    index = moPaneEntries.getTableGuiRowCount();
                    moPaneEntries.addTableRow(new SDataAccountItemEntryRow(entry));
                }
                else {
                    moPaneEntries.insertTableRow(new SDataAccountItemEntryRow(entry), index);
                }

                moPaneEntries.renderTableRows();
                moPaneEntries.setTableRowSelection(index);
            }
        }
    }

    private void actionEntryEdit() {
        int index = moPaneEntries.getTable().getSelectedRow();

        if (index != -1) {
            ((SDataAccountItemEntry) moPaneEntries.getSelectedTableRow().getData()).setDbmsAccountItem(moFieldAccountItem.getString());

            moFormEntry.formReset();
            moFormEntry.setRegistry((SDataAccountItemEntry) moPaneEntries.getSelectedTableRow().getData());
            moFormEntry.setVisible(true);

            if (moFormEntry.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                moPaneEntries.setTableRow(new SDataAccountItemEntryRow((SDataAccountItemEntry) moFormEntry.getRegistry()), index);

                moPaneEntries.renderTableRows();
                moPaneEntries.setTableRowSelection(index);
            }
        }
    }

    private void actionEntryDelete() {
        int index = moPaneEntries.getTable().getSelectedRow();

        if (index != -1 && miClient.showMsgBoxConfirm(SLibConstants.MSG_CNF_REG_DELETE) == JOptionPane.YES_OPTION) {
            moPaneEntries.removeTableRow(index);
            moPaneEntries.renderTableRows();

            if (moPaneEntries.getTableGuiRowCount() > 0) {
                moPaneEntries.setTableRowSelection(index < moPaneEntries.getTableGuiRowCount() ? index : moPaneEntries.getTableGuiRowCount() - 1);
            }
        }
    }

    private void actionItem(boolean isNew) {
        int index = -1;
        SDataAccountItemItem item = null;

        if (isNew) {
            item = new SDataAccountItemItem();
            item.setPkAccountItemId(moAccountItem == null ? 0 : moAccountItem.getPkAccountItemId());
            item.setPkDateStartId(SLibTimeUtilities.getBeginOfYear(miClient.getSessionXXX().getWorkingDate()));
        }
        else if (moPaneItems.getSelectedTableRow() != null) {
            item = (SDataAccountItemItem) moPaneItems.getSelectedTableRow().getData();
        }

        if (item != null) {
            moFormItem.formRefreshCatalogues();
            moFormItem.formReset();
            moFormItem.setRegistry(item);
            moFormItem.setVisible(true);

            if (moFormItem.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                if (isNew) {
                    moPaneItems.addTableRow(new SDataAccountItemItemRow(moFormItem.getRegistry()));
                }
                else {
                    moPaneItems.setTableRow(new SDataAccountItemItemRow(moFormItem.getRegistry()), moPaneItems.getTable().getSelectedRow());
                }

                index = moPaneItems.getTable().getSelectedRow();
                moPaneItems.renderTableRows();
                moPaneItems.setTableRowSelection(index);
            }
        }
    }

    private void actionItemDelete() {
        int index = -1;

        if (moPaneItems.getSelectedTableRow() != null) {
            SDataAccountItemItem item = (SDataAccountItemItem) ((SDataAccountItemItemRow) moPaneItems.getSelectedTableRow()).getData();

            item.setIsDeleted(true);
            moPaneItems.setTableRow(new SDataAccountItemItemRow(item), moPaneItems.getTable().getSelectedRow());

            index = moPaneItems.getTable().getSelectedRow();
            moPaneItems.renderTableRows();
            moPaneItems.setTableRowSelection(index);
        }
    }

    private void actionEdit(boolean edit) {

    }

    private void actionOk() {
        SFormValidation validation = formValidate();

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                jtpTabbedPane.setSelectedIndex(validation.getTabbedPaneIndex());
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

    public void publicActionEntryEdit() {
        actionEntryEdit();
    }

    public void publicActionItemEdit() {
        actionItem(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbEntryDelete;
    private javax.swing.JButton jbEntryEdit;
    private javax.swing.JButton jbEntryNew;
    private javax.swing.JButton jbItemDelete;
    private javax.swing.JButton jbItemEdit;
    private javax.swing.JButton jbItemNew;
    private javax.swing.JButton jbOk;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JLabel jlAccountItem;
    private javax.swing.JLabel jlDummy01;
    private javax.swing.JPanel jpAccountItem;
    private javax.swing.JPanel jpEntries;
    private javax.swing.JPanel jpItems;
    private javax.swing.JTextField jtfAccountItem;
    private javax.swing.JTabbedPane jtpTabbedPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        moAccountItem = null;
    }

    @Override
    public void formReset() {
        mbResetingForm = true;

        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        moAccountItem = null;
        moPaneEntries.createTable();
        moPaneEntries.clearTableRows();
        moPaneItems.createTable();
        moPaneItems.clearTableRows();
        msTextAll = SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_BKR, new int[] { SDataConstantsSys.FINS_TP_BKR_ALL });
        msTextDbt = SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_BKR, new int[] { SDataConstantsSys.FINS_TP_BKR_DBT });
        msTextCdt = SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_BKR, new int[] { SDataConstantsSys.FINS_TP_BKR_CDT });

        for (int i = 0; i < mvFields.size(); i++) {
            mvFields.get(i).resetField();
        }

        jckIsDeleted.setEnabled(false);

        jtpTabbedPane.setSelectedIndex(0);
        //jtpTabbedPane.setEnabledAt(1, false);

        // Initialize business partner account entries:

        for (int type : manAccountTypes) {
            moPaneEntries.addTableRow(new SDataAccountItemEntryRow(createEntry(type, 1d)));
        }

        moPaneEntries.renderTableRows();
        moPaneEntries.setTableRowSelection(0);

        mbResetingForm = false;
    }

    @Override
    public void formRefreshCatalogues() {
        moFormEntry.formRefreshCatalogues();
        moComponentItemPicker.formRefreshCatalogues();
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        int i;
        double[][] percentages = new double[manAccountTypes.length][3]; // secundary index for bookkeeping registry type: 0 = ALL; 1 = DBT; 2 = CDT
        SFormValidation validation = new SFormValidation();
        SDataAccountItemEntry entry = null;

        for (i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(mvFields.get(i).getComponent());
                validation.setTabbedPaneIndex(0);
                break;
            }
        }

        if (!validation.getIsError()) {
            // Validate account type percentages:

            for (i = 0; i < moPaneEntries.getTableGuiRowCount() && !validation.getIsError(); i++) {
                entry = (SDataAccountItemEntry) ((SDataAccountItemEntryRow) moPaneEntries.getTableRow(i)).getData();
                switch (entry.getFkBookkeepingRegistryTypeId()) {
                    case SDataConstantsSys.FINS_TP_BKR_ALL:
                        percentages[entry.getPkAccountItemTypeId() - 1][ALL] += entry.getPercentage();
                        break;
                    case SDataConstantsSys.FINS_TP_BKR_DBT:
                        percentages[entry.getPkAccountItemTypeId() - 1][DBT] += entry.getPercentage();
                        break;
                    case SDataConstantsSys.FINS_TP_BKR_CDT:
                        percentages[entry.getPkAccountItemTypeId() - 1][CDT] += entry.getPercentage();
                        break;
                    default:
                        validation.setMessage("El tipo de asiento contable del tipo de cuenta '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { i + 1 }) + "'\n" +
                                "es inválido en la posición " + (i + 1) + ".");
                        validation.setComponent(moPaneEntries.getTable());
                        validation.setTabbedPaneIndex(0);
                }
            }

            if (!validation.getIsError()) {
                for (i = 0; i < percentages.length; i++) {
                    if (percentages[i][ALL] != 0d) {
                        // Only bookkeeping registry type "ALL" must be provided:

                        if (percentages[i][ALL] != 1d) {
                            validation.setMessage("La suma total de los porcentajes del tipo de asiento contable '" + msTextAll + "'\n" +
                                    "para el tipo de cuenta '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { i + 1 }) + "' " +
                                    "(" + miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(percentages[i][ALL]) + ")\n" +
                                    "debe ser igual a " + miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(1d) + ".");
                            validation.setComponent(moPaneEntries.getTable());
                            validation.setTabbedPaneIndex(0);
                            break;
                        }
                        else if (percentages[i][DBT] != 0d || percentages[i][CDT] != 0d) {
                            validation.setMessage("Si se configuran asientos contables del tipo '" + msTextAll + "'\n" +
                                    "para el tipo de cuenta '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { i + 1 }) + "'\n" +
                                    "no se pueden configurar asientos contables del tipo '" + msTextDbt + "' o '" + msTextCdt + "'.");
                            validation.setComponent(moPaneEntries.getTable());
                            validation.setTabbedPaneIndex(0);
                            break;
                        }
                    }
                    else {
                        // Both bookkeeping registry types "DEBIT" and "CREDIT" must be provided:

                        if (percentages[i][DBT] != 1d) {
                            validation.setMessage("La suma total de los porcentajes del tipo de asiento contable '" + msTextDbt + "'\n" +
                                    "para el tipo de cuenta '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { i + 1 }) + "' " +
                                    "(" + miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(percentages[i][DBT]) + ")\n" +
                                    "debe ser igual a " + miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(1d) + ".");
                            validation.setComponent(moPaneEntries.getTable());
                            validation.setTabbedPaneIndex(0);
                            break;
                        }
                        else if (percentages[i][CDT] != 1d) {
                            validation.setMessage("La suma total de los porcentajes del tipo de asiento contable '" + msTextCdt + "'\n" +
                                    "para el tipo de cuenta '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { i + 1 }) + "' " +
                                    "(" + miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(percentages[i][CDT]) + ")\n" +
                                    "debe ser igual a " + miClient.getSessionXXX().getFormatters().getDecimalsPercentageFormat().format(1d) + ".");
                            validation.setComponent(moPaneEntries.getTable());
                            validation.setTabbedPaneIndex(0);
                            break;
                        }
                        else if (percentages[i][ALL] != 0d) {
                            validation.setMessage("Si se configuran asientos contables de los tipos '" + msTextDbt + "' y '" + msTextCdt + "'\n" +
                                    "para el tipo de cuenta '" + SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.FINS_TP_ACC_ITEM, new int[] { i + 1 }) + "'\n" +
                                    "no se pueden configurar asientos contables del tipo '" + msTextAll + "'.");
                            validation.setComponent(moPaneEntries.getTable());
                            validation.setTabbedPaneIndex(0);
                            break;
                        }
                    }
                }
            }

            if (!validation.getIsError()) {
                if (moPaneItems.getTableGuiRowCount() == 0) {
                    if (miClient.showMsgBoxConfirm("No se han definido registros a los que les aplique este paquete de configuración.\nDe cualquier forma, ¿está seguro que desea salir?") != JOptionPane.YES_OPTION) {
                        validation.setMessage("Se deben definir registros a los que les aplique este paquete de configuración.");
                    }
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
        int i = 0;
        SDataAccountItemEntry entry = null;

        moAccountItem = (SDataAccountItem) registry;

        moFieldAccountItem.setFieldValue(moAccountItem.getAccountItem());
        moFieldIsDeleted.setFieldValue(moAccountItem.getIsDeleted());

        moPaneEntries.clearTableRows();
        for (i = 0; i < moAccountItem.getDbmsEntries().size(); i++) {
            entry = moAccountItem.getDbmsEntries().get(i);

            if (entry.getFkAccountId_n().length() == 0) {
                entry.setFkAccountId_n(msEmptyAccountId);
            }
            if (entry.getFkCostCenterId_n().length() == 0) {
                entry.setFkCostCenterId_n(msEmptyCostCenterId);
            }

            moPaneEntries.addTableRow(new SDataAccountItemEntryRow(entry));
        }
        moPaneEntries.renderTableRows();
        moPaneEntries.setTableRowSelection(0);

        moPaneItems.clearTableRows();
        for (i = 0; i < moAccountItem.getDbmsItems().size(); i++) {
            moPaneItems.addTableRow(new SDataAccountItemItemRow(moAccountItem.getDbmsItems().get(i)));
        }
        moPaneItems.renderTableRows();
        moPaneItems.setTableRowSelection(0);

        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        int i = 0;
        SDataAccountItemEntry entry = null;

        if (moAccountItem == null) {
            moAccountItem = new SDataAccountItem();
            moAccountItem.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moAccountItem.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moAccountItem.setAccountItem(moFieldAccountItem.getString());
        moAccountItem.setIsDeleted(moFieldIsDeleted.getBoolean());

        moAccountItem.getDbmsEntries().clear();
        for (i = 0; i < moPaneEntries.getTableGuiRowCount(); i++) {
            entry = ((SDataAccountItemEntry) ((SDataAccountItemEntryRow) moPaneEntries.getTableRow(i)).getData());

            if (entry.getFkAccountId_n().compareTo(msEmptyAccountId) == 0) {
                entry.setFkAccountId_n("");
            }
            if (entry.getFkCostCenterId_n().compareTo(msEmptyCostCenterId) == 0) {
                entry.setFkCostCenterId_n("");
            }

            moAccountItem.getDbmsEntries().add(entry);
        }

        moAccountItem.getDbmsItems().clear();
        for (i = 0; i < moPaneItems.getTableGuiRowCount(); i++) {
            moAccountItem.getDbmsItems().add(((SDataAccountItemItem) ((SDataAccountItemItemRow) moPaneItems.getTableRow(i)).getData()));
        }

        return moAccountItem;
    }

    @Override
    public void setValue(int type, java.lang.Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public java.lang.Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        return null;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbEntryNew) {
                actionEntryNew();
            }
            else if (button == jbEntryEdit) {
                actionEntryEdit();
            }
            else if (button == jbEntryDelete) {
                actionEntryDelete();
            }
            else if (button == jbItemNew) {
                actionItem(true);
            }
            else if (button == jbItemEdit) {
                actionItem(false);
            }
            else if (button == jbItemDelete) {
                actionItemDelete();
            }
        }
    }
}