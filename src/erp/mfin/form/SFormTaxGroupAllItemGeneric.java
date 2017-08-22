/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormTaxGroupAllItemGeneric.java
 *
 * Created on 15/10/2009, 11:46:37 AM
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.data.SProcConstants;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mfin.data.SDataTaxGroupAllItemGeneric;
import erp.mfin.data.SDataTaxGroupItemGeneric;
import erp.mfin.data.SDataTaxGroupItemGenericRow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author Sergio Flores
 */
public class SFormTaxGroupAllItemGeneric extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mfin.data.SDataTaxGroupAllItemGeneric moTaxGroupAllItemGeneric;
    private erp.lib.form.SFormField moFieldPkItemGeneric;
    private erp.lib.table.STablePane moPaneAllItemGeneric;
    private erp.mfin.form.SFormTaxGroupItemGeneric moFormTaxGroupItemGeneric;

    /** Creates new form SFormTaxRegion */
    public SFormTaxGroupAllItemGeneric(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.FINX_TAX_GRP_ALL_IGEN;

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
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlPkItemGenericId = new javax.swing.JLabel();
        jcbPkItemGenericId = new javax.swing.JComboBox();
        jbPkItemGenericId = new javax.swing.JButton();
        jpAllItemGeneric = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jbNewTaxRegion = new javax.swing.JButton();
        jbEditTaxRegion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Grupos de impuestos para ítem genérico");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(392, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ítem genérico:"));
        jPanel3.setLayout(new java.awt.GridLayout(1, 1, 0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlPkItemGenericId.setText("Ítem genérico: *");
        jlPkItemGenericId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlPkItemGenericId);

        jcbPkItemGenericId.setMaximumRowCount(24);
        jcbPkItemGenericId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPkItemGenericId.setPreferredSize(new java.awt.Dimension(400, 23));
        jPanel4.add(jcbPkItemGenericId);

        jbPkItemGenericId.setText("...");
        jbPkItemGenericId.setToolTipText("Seleccionar ítem genérico");
        jbPkItemGenericId.setFocusable(false);
        jbPkItemGenericId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbPkItemGenericId);

        jPanel3.add(jPanel4);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jpAllItemGeneric.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración de regiones de impuestos y grupos de impuestos:"));
        jpAllItemGeneric.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jbNewTaxRegion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_new.gif"))); // NOI18N
        jbNewTaxRegion.setToolTipText("Crear región de impuestos");
        jbNewTaxRegion.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbNewTaxRegion);

        jbEditTaxRegion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_edit.gif"))); // NOI18N
        jbEditTaxRegion.setToolTipText("Modificar región de impuestos");
        jbEditTaxRegion.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbEditTaxRegion);

        jpAllItemGeneric.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jpAllItemGeneric, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int i = 0;
        STableColumnForm columns[] = null;

        moFieldPkItemGeneric = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbPkItemGenericId, jlPkItemGenericId);
        moFieldPkItemGeneric.setPickerButton(jbPkItemGenericId);

        mvFields = new Vector<SFormField>();
        mvFields.add(moFieldPkItemGeneric);

        moPaneAllItemGeneric = new STablePane(miClient);
        jpAllItemGeneric.add(moPaneAllItemGeneric, BorderLayout.CENTER);

        columns = new STableColumnForm[4];
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Región de impuestos", 300);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Ini. vigencia", STableConstants.WIDTH_DATE);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Grupo de impuestos", 300);
        columns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Eliminado", STableConstants.WIDTH_BOOLEAN);

        for (i = 0; i < columns.length; i++) {
            moPaneAllItemGeneric.addTableColumn(columns[i]);
        }

        moPaneAllItemGeneric.setDoubleClickAction(this, "linkActionEditTaxRegion");

        moFormTaxGroupItemGeneric = new SFormTaxGroupItemGeneric(miClient);

        jbPkItemGenericId.addActionListener(this);
        jbNewTaxRegion.addActionListener(this);
        jbEditTaxRegion.addActionListener(this);
        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

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
            if (jcbPkItemGenericId.isEnabled()) jcbPkItemGenericId.requestFocus(); else jbCancel.requestFocus();
        }
    }

    private void actionPkItemGenericId() {
        miClient.pickOption(SDataConstants.ITMU_IGEN, moFieldPkItemGeneric, null);
    }

    private void actionNewTaxRegion() {
        moFormTaxGroupItemGeneric.formReset();
        moFormTaxGroupItemGeneric.setValue(SDataConstants.ITMU_IGEN, moFieldPkItemGeneric.getKeyAsIntArray());
        moFormTaxGroupItemGeneric.setFormVisible(true);

        if (moFormTaxGroupItemGeneric.getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moPaneAllItemGeneric.addTableRow(new SDataTaxGroupItemGenericRow((SDataTaxGroupItemGeneric) moFormTaxGroupItemGeneric.getRegistry()));
            moPaneAllItemGeneric.renderTableRows();
            moPaneAllItemGeneric.setTableRowSelection(moPaneAllItemGeneric.getTableGuiRowCount() - 1);
        }
    }

    private void actionEditTaxRegion() {
        int index = moPaneAllItemGeneric.getTable().getSelectedRow();

        if (index != -1) {
            moFormTaxGroupItemGeneric.formReset();
            moFormTaxGroupItemGeneric.setValue(SDataConstants.ITMU_IGEN, moFieldPkItemGeneric.getKeyAsIntArray());
            moFormTaxGroupItemGeneric.setRegistry((SDataTaxGroupItemGeneric) ((SDataTaxGroupItemGenericRow) moPaneAllItemGeneric.getSelectedTableRow()).getData());
            moFormTaxGroupItemGeneric.setFormVisible(true);

            if (moFormTaxGroupItemGeneric.getFormResult() == SLibConstants.FORM_RESULT_OK) {
                moPaneAllItemGeneric.setTableRow(new SDataTaxGroupItemGenericRow((SDataTaxGroupItemGeneric) moFormTaxGroupItemGeneric.getRegistry()), index);
                moPaneAllItemGeneric.renderTableRows();
                moPaneAllItemGeneric.setTableRowSelection(index);
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

    public void linkActionEditTaxRegion() {
        actionEditTaxRegion();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbEditTaxRegion;
    private javax.swing.JButton jbNewTaxRegion;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbPkItemGenericId;
    private javax.swing.JComboBox jcbPkItemGenericId;
    private javax.swing.JLabel jlPkItemGenericId;
    private javax.swing.JPanel jpAllItemGeneric;
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

        moTaxGroupAllItemGeneric = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moPaneAllItemGeneric.createTable();
        moPaneAllItemGeneric.clearTableRows();

        jcbPkItemGenericId.setEnabled(true);
        jbPkItemGenericId.setEnabled(true);
    }

    @Override
    public void formRefreshCatalogues() {
        moFormTaxGroupItemGeneric.formRefreshCatalogues();
        SFormUtilities.populateComboBox(miClient, jcbPkItemGenericId, SDataConstants.ITMU_IGEN);
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
            if (moTaxGroupAllItemGeneric == null && SDataUtilities.callProcedureVal(miClient, SProcConstants.FIN_TAX_GRP_IGEN_VAL, moFieldPkItemGeneric.getKeyAsIntArray(), SLibConstants.EXEC_MODE_VERBOSE) > 0 ) {
                validation.setMessage("Ya existe una configuración para el ítem genérico especificado.");
                validation.setComponent(jcbPkItemGenericId);
            }
            else if (moPaneAllItemGeneric.getTableGuiRowCount() == 0) {
                validation.setMessage("Se debe especificar la configuración de regiones de impuestos y grupos de impuestos del ítem genérico.");
                validation.setComponent(jbNewTaxRegion);
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
        moTaxGroupAllItemGeneric = (SDataTaxGroupAllItemGeneric) registry;

        moFieldPkItemGeneric.setFieldValue(new int[] { moTaxGroupAllItemGeneric.getPkItemGenericId() });

        for (int i = 0; i < moTaxGroupAllItemGeneric.getDbmsTaxGroupItemGenerics().size(); i++) {
            moPaneAllItemGeneric.addTableRow(new SDataTaxGroupItemGenericRow(moTaxGroupAllItemGeneric.getDbmsTaxGroupItemGenerics().get(i)));
        }
        moPaneAllItemGeneric.renderTableRows();
        moPaneAllItemGeneric.setTableRowSelection(0);

        jcbPkItemGenericId.setEnabled(false);
        jbPkItemGenericId.setEnabled(false);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moTaxGroupAllItemGeneric == null) {
            moTaxGroupAllItemGeneric = new SDataTaxGroupAllItemGeneric();
            moTaxGroupAllItemGeneric.setPkItemGenericId(moFieldPkItemGeneric.getKeyAsIntArray()[0]);
            moTaxGroupAllItemGeneric.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moTaxGroupAllItemGeneric.setFkUserNewId(miClient.getSession().getUser().getPkUserId());     // new tax regions and tax groups will need this
            moTaxGroupAllItemGeneric.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moTaxGroupAllItemGeneric.getDbmsTaxGroupItemGenerics().clear();
        for (int i = 0; i < moPaneAllItemGeneric.getTableGuiRowCount(); i++) {
            moTaxGroupAllItemGeneric.getDbmsTaxGroupItemGenerics().add((SDataTaxGroupItemGeneric) ((SDataTaxGroupItemGenericRow) moPaneAllItemGeneric.getTableRow(i)).getData());
        }

        return moTaxGroupAllItemGeneric;
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
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbPkItemGenericId) {
                actionPkItemGenericId();
            }
            else if (button == jbNewTaxRegion) {
                actionNewTaxRegion();
            }
            else if (button == jbEditTaxRegion) {
                actionEditTaxRegion();
            }
            else if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
        }
    }
}