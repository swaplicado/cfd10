/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Created on 11/11/2009
 */

package erp.mmfg.form;

import erp.data.SDataConstants;
import erp.lib.SLibConstants;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mmfg.data.SDataGang;
import erp.mmfg.data.SDataGangEntry;
import erp.mmfg.data.SDataGangEntryRow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author Néstor Ávalos
 */
public class SFormGang extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mmfg.data.SDataGang moGang;

    private erp.lib.form.SFormField moFieldNumber;
    private erp.lib.form.SFormField moFieldDescription;
    private erp.lib.form.SFormField moFieldFkTurnId;
    private erp.lib.form.SFormField moFieldIsDeleted;

    private erp.lib.table.STablePane moEntriesPane;

    private java.util.Vector<erp.mmfg.data.SDataGangEntry> mvGangEntries;

    /** Creates new form SFormElement */
    public SFormGang(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.MFGU_GANG;

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

        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlNumber = new javax.swing.JLabel();
        jtfNumber = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jlDescription = new javax.swing.JLabel();
        jtfDescription = new javax.swing.JFormattedTextField();
        jPanel8 = new javax.swing.JPanel();
        jlFkTurnId = new javax.swing.JLabel();
        jcbFkTurnId = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel4 = new javax.swing.JPanel();
        jckIsDeleted = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jpFilter = new javax.swing.JPanel();
        jbNew = new javax.swing.JButton();
        jbEdit = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuadrilla");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlNumber.setText("Folio:");
        jlNumber.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlNumber);

        jtfNumber.setText("NUMBER");
        jtfNumber.setEnabled(false);
        jtfNumber.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel7.add(jtfNumber);

        jPanel2.add(jPanel7);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlDescription.setText("Descripción: *");
        jlDescription.setPreferredSize(new java.awt.Dimension(100, 14));
        jPanel3.add(jlDescription);

        jtfDescription.setText("DESCRIPTION");
        jtfDescription.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel3.add(jtfDescription);

        jPanel2.add(jPanel3);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlFkTurnId.setText("Turno: *");
        jlFkTurnId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jlFkTurnId);

        jcbFkTurnId.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel8.add(jcbFkTurnId);

        jPanel2.add(jPanel8);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jckIsDeleted.setText("Registro eliminado");
        jPanel4.add(jckIsDeleted);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados:"));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 53));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jpFilter.setPreferredSize(new java.awt.Dimension(779, 23));
        jpFilter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jbNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_new.gif"))); // NOI18N
        jbNew.setToolTipText("Crear [Ctrl + N]");
        jbNew.setPreferredSize(new java.awt.Dimension(23, 23));
        jpFilter.add(jbNew);

        jbEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_edit.gif"))); // NOI18N
        jbEdit.setToolTipText("Modificar [Ctrl + M]");
        jbEdit.setPreferredSize(new java.awt.Dimension(23, 23));
        jpFilter.add(jbEdit);

        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_delete.gif"))); // NOI18N
        jbDelete.setToolTipText("Eliminar [Ctrl + D]");
        jbDelete.setPreferredSize(new java.awt.Dimension(23, 23));
        jpFilter.add(jbDelete);

        jPanel6.add(jpFilter, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-608)/2, (screenSize.height-434)/2, 608, 434);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int i;
        STableColumnForm oColumnsEntries[];

        mvGangEntries = new Vector<SDataGangEntry>();
        mvFields = new Vector<SFormField>();
        moEntriesPane = new STablePane(miClient);
        moEntriesPane.setDoubleClickAction(this, "publicActionModify");
        jPanel6.add(moEntriesPane, BorderLayout.CENTER);

        moFieldNumber = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, false, jtfNumber, jlNumber);
        moFieldDescription = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfDescription, jlDescription);
        moFieldFkTurnId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkTurnId, jlFkTurnId);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsDeleted);

        mvFields.add(moFieldNumber);
        mvFields.add(moFieldDescription);
        mvFields.add(moFieldFkTurnId);
        mvFields.add(moFieldIsDeleted);

        jbNew.addActionListener(this);
        jbEdit.addActionListener(this);
        jbDelete.addActionListener(this);
        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

        i = 0;
        oColumnsEntries = new STableColumnForm[8];
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Empleado", 200);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Eliminado", STableConstants.WIDTH_BOOLEAN);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. creación", STableConstants.WIDTH_USER);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Creación", STableConstants.WIDTH_DATE_TIME);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. modificación", STableConstants.WIDTH_USER);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Modificación", STableConstants.WIDTH_DATE_TIME);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. eliminación", STableConstants.WIDTH_USER);
        oColumnsEntries[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Eliminación", STableConstants.WIDTH_DATE_TIME);
        for (i = 0; i < oColumnsEntries.length; i++) {
            moEntriesPane.addTableColumn(oColumnsEntries[i]);
        }
        moEntriesPane.createTable(null);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.createActionMap(rootPane, this, "publicActionAdd", "add", KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "publicActionModify", "modify", KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "publicActionDelete", "delete", KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.putActionMap(getRootPane(), actionCancel, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jtfDescription.requestFocus();
        }
    }

    private void actionGangEntryNew() {
        boolean b=false;
        int index=0;

        SFormGangEntry oGangEntryForm = new SFormGangEntry(miClient);
        SDataGangEntry oGangEntry = null;
        SDataGangEntry oGangEntryAux = null;
        SDataGangEntryRow oGangEntryRow = null;

        oGangEntryForm.formReset();
        oGangEntryForm.formRefreshCatalogues();
        oGangEntryForm.setVisible(true);
        if (oGangEntryForm.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
            oGangEntry = (SDataGangEntry) oGangEntryForm.getRegistry();

            // Validate if gang entry isn´t in grid:

            for (int i=0; i<moEntriesPane.getTableGuiRowCount(); i++) {
                oGangEntryAux = (SDataGangEntry) moEntriesPane.getTableRow(i).getData();

                if (oGangEntry.getFkBizPartnerId() == oGangEntryAux.getFkBizPartnerId()) {
                    miClient.showMsgBoxWarning("El empleado '" + oGangEntry.getDbmsBizPartner() + "' ya existe en la lista.");
                    b=true;
                    break;
                }
            }

            if (!b) {
                moEntriesPane.addTableRow(oGangEntryRow = new SDataGangEntryRow(oGangEntry));
                moEntriesPane.renderTableRows();
                index = moEntriesPane.getTableGuiRowCount() - 1;
                moEntriesPane.getTable().setRowSelectionInterval(index, index);
                moEntriesPane.getVerticalScrollBar().setValue((index + 1) * moEntriesPane.getTable().getRowHeight());
            }
        }
    }

    private void actionGangEntryModify() {
        int index = moEntriesPane.getTable().getSelectedRow();
        SFormGangEntry oGangEntryForm = new SFormGangEntry(miClient);
        SDataGangEntry oGangEntry = null;
        SDataGangEntryRow oGangEntryRow = null;

        oGangEntryForm.formReset();
        oGangEntryForm.formRefreshCatalogues();
        if (index != -1) {
            oGangEntry = (SDataGangEntry) moEntriesPane.getTableRow(index).getData();
            oGangEntryForm.setRegistry(oGangEntry);
            oGangEntryForm.setVisible(true);
            if (oGangEntryForm.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
                oGangEntry = (SDataGangEntry) oGangEntryForm.getRegistry();

                moEntriesPane.setTableRow(oGangEntryRow = new SDataGangEntryRow(oGangEntry), index);
                moEntriesPane.renderTableRows();
            }
        }
    }

    private void actionGangEntryDelete() {
        int index = moEntriesPane.getTable().getSelectedRow();

        if (index != -1) {
            if (miClient.showMsgBoxConfirm(SLibConstants.MSG_CNF_REG_DELETE) == JOptionPane.YES_OPTION) {
                moEntriesPane.removeTableRow(index);
                moEntriesPane.renderTableRows();

                if (moEntriesPane.getTableGuiRowCount() > 0) {
                    moEntriesPane.setTableRowSelection(index < moEntriesPane.getTableGuiRowCount() ? index : moEntriesPane.getTableGuiRowCount() - 1);
                }
            }
        }
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

    public void publicActionAdd() {
        actionGangEntryNew();
    }

    public void publicActionModify() {
        actionGangEntryModify();
    }

    public void publicActionDelete() {
        actionGangEntryDelete();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbEdit;
    private javax.swing.JButton jbNew;
    private javax.swing.JButton jbOk;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkTurnId;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JLabel jlDescription;
    private javax.swing.JLabel jlFkTurnId;
    private javax.swing.JLabel jlNumber;
    private javax.swing.JPanel jpFilter;
    private javax.swing.JFormattedTextField jtfDescription;
    private javax.swing.JFormattedTextField jtfNumber;
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

        moGang = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moEntriesPane.createTable(null);
        moEntriesPane.clearTableRows();

        mvGangEntries.clear();

        jckIsDeleted.setEnabled(false);
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbFkTurnId, SDataConstants.MFGU_TURN);
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()){
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
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
        SDataGangEntryRow oGangEntryRow = null;

        moGang = (SDataGang) registry;

        moFieldNumber.setFieldValue(moGang.getNumber());
        moFieldDescription.setFieldValue(moGang.getDescription());
        moFieldFkTurnId.setFieldValue(new int[] { moGang.getFkTurnId() });
        moFieldIsDeleted.setFieldValue(moGang.getIsDeleted());

        for (i = 0; i < moGang.getDbmsGangEntries().size(); i++) {
            oGangEntryRow = new SDataGangEntryRow(moGang.getDbmsGangEntries().get(i));
            moEntriesPane.addTableRow(oGangEntryRow);
        }
        mvGangEntries = moGang.getDbmsGangEntries();

        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moGang == null) {
            moGang = new SDataGang();
            moGang.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moGang.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moGang.setNumber(moFieldNumber.getString());
        moGang.setDescription(moFieldDescription.getString());
        moGang.setFkTurnId(moFieldFkTurnId.getKeyAsIntArray()[0]);
        moGang.setIsDeleted(moFieldIsDeleted.getBoolean());

        moGang.getDbmsGangEntries().removeAllElements();
        for (int i = 0; i < moEntriesPane.getTableGuiRowCount(); i++) {
            moGang.getDbmsGangEntries().add((SDataGangEntry) moEntriesPane.getTableRow(i).getData());
        }

        return moGang;
    }

    @Override
    public void setValue(int type, Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbNew) {
                actionGangEntryNew();
            }
            else if (button == jbEdit) {
                actionGangEntryModify();
            }
            else if (button == jbDelete) {
                actionGangEntryDelete();
            }
        }
    }
}
