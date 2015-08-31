/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mtrn.data.SDataStockConfigDns;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author Néstor Ávalos
 */
public class SFormStockConfigDns extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mtrn.data.SDataStockConfigDns moStockConfigDns;
    private erp.lib.form.SFormField moFieldPkCompanyBranchId;
    private erp.lib.form.SFormField moFieldPkWarehouseId;
    private erp.lib.form.SFormField moFieldPkDocNumberSeriesId;
    private erp.lib.form.SFormField moFieldIsDeleted;

    /** Creates new form SFormStockConfigDns */
    public SFormStockConfigDns(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.TRN_STK_CFG_DNS;

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
        jPanel5 = new javax.swing.JPanel();
        jlPkCompanyBranchId = new javax.swing.JLabel();
        jcbPkCompanyBranchId = new javax.swing.JComboBox();
        jbPkCompanyBranchId = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jlPkWarehouseId = new javax.swing.JLabel();
        jcbPkWarehouseId = new javax.swing.JComboBox();
        jbPkWarehouseId = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jlPkDocNumberSeriesId = new javax.swing.JLabel();
        jcbPkDocNumberSeriesId = new javax.swing.JComboBox();
        jbPkDocNumberSeriesId = new javax.swing.JButton();
        jckIsDeleted = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jbOK = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración de serie docto. de ventas por almacén");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel2.setLayout(new java.awt.GridLayout(5, 1));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPkCompanyBranchId.setForeground(new java.awt.Color(0, 0, 255));
        jlPkCompanyBranchId.setText("Sucursal de la empresa: *");
        jlPkCompanyBranchId.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel5.add(jlPkCompanyBranchId);

        jcbPkCompanyBranchId.setToolTipText("");
        jcbPkCompanyBranchId.setPreferredSize(new java.awt.Dimension(250, 23));
        jcbPkCompanyBranchId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPkCompanyBranchIdItemStateChanged(evt);
            }
        });
        jPanel5.add(jcbPkCompanyBranchId);

        jbPkCompanyBranchId.setText("...");
        jbPkCompanyBranchId.setToolTipText("Seleccionar sucursal");
        jbPkCompanyBranchId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbPkCompanyBranchId);

        jPanel2.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPkWarehouseId.setForeground(new java.awt.Color(0, 0, 255));
        jlPkWarehouseId.setText("Almacén: *");
        jlPkWarehouseId.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel6.add(jlPkWarehouseId);

        jcbPkWarehouseId.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel6.add(jcbPkWarehouseId);

        jbPkWarehouseId.setText("...");
        jbPkWarehouseId.setToolTipText("Seleccionar almacén");
        jbPkWarehouseId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbPkWarehouseId);

        jPanel2.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPkDocNumberSeriesId.setForeground(new java.awt.Color(0, 0, 255));
        jlPkDocNumberSeriesId.setText("Serie docto. ventas: *");
        jlPkDocNumberSeriesId.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel7.add(jlPkDocNumberSeriesId);

        jcbPkDocNumberSeriesId.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel7.add(jcbPkDocNumberSeriesId);

        jbPkDocNumberSeriesId.setText("...");
        jbPkDocNumberSeriesId.setToolTipText("Seleccionar serie docto. ventas");
        jbPkDocNumberSeriesId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel7.add(jbPkDocNumberSeriesId);

        jPanel2.add(jPanel7);

        jckIsDeleted.setText("Registro eliminado");
        jPanel2.add(jckIsDeleted);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOK.setText("Aceptar");
        jbOK.setToolTipText("[Ctrl + Enter]");
        jbOK.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOK);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-445)/2, (screenSize.height-230)/2, 445, 230);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbPkCompanyBranchIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPkCompanyBranchIdItemStateChanged
        itemStateChangedCompanyBranch();
    }//GEN-LAST:event_jcbPkCompanyBranchIdItemStateChanged

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldPkCompanyBranchId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbPkCompanyBranchId, jlPkCompanyBranchId);
        moFieldPkCompanyBranchId.setPickerButton(jbPkCompanyBranchId);
        moFieldPkWarehouseId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbPkWarehouseId, jlPkWarehouseId);
        moFieldPkWarehouseId.setPickerButton(jbPkWarehouseId);
        moFieldPkDocNumberSeriesId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbPkDocNumberSeriesId, jlPkDocNumberSeriesId);
        moFieldPkDocNumberSeriesId.setPickerButton(jbPkDocNumberSeriesId);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsDeleted);

        mvFields.add(moFieldPkCompanyBranchId);
        mvFields.add(moFieldPkWarehouseId);
        mvFields.add(moFieldPkDocNumberSeriesId);
        mvFields.add(moFieldIsDeleted);

        jbOK.addActionListener(this);
        jbCancel.addActionListener(this);
        jbPkCompanyBranchId.addActionListener(this);
        jbPkWarehouseId.addActionListener(this);
        jbPkDocNumberSeriesId.addActionListener(this);

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
        }
    }

    private void actionPkCompanyBranchId() {
        miClient.pickOption(SDataConstants.BPSU_BPB, moFieldPkCompanyBranchId, new int[] { miClient.getSessionXXX().getParamsCompany().getPkConfigCoId() });
    }

    private void actionPkWarehouseId() {
        miClient.pickOption(SDataConstants.CFGU_COB_ENT, moFieldPkWarehouseId, new int[] { moFieldPkCompanyBranchId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_WH });
    }

    private void actionPkDocNumberSeriesId() {
        miClient.pickOption(SDataConstants.TRN_DNS_DPS, moFieldPkDocNumberSeriesId, new int[] { SDataConstantsSys.TRNS_CT_DPS_SAL });
    }

    private void renderComboBoxWarehouse() {
        if (jcbPkCompanyBranchId.getSelectedIndex() <= 0) {
            jcbPkWarehouseId.setEnabled(false);
            jbPkWarehouseId.setEnabled(false);
        }
        else {
            jcbPkWarehouseId.setEnabled(true);
            jbPkWarehouseId.setEnabled(true);
        }
    }

    private void populateComboBoxWarehouse() {
        jcbPkWarehouseId.removeAllItems();

        if (jcbPkCompanyBranchId.getSelectedIndex()>0) {
            SFormUtilities.populateComboBox(miClient, jcbPkWarehouseId, SDataConstants.CFGX_COB_ENT_WH, new int[] { moFieldPkCompanyBranchId.getKeyAsIntArray()[0] });
        }

        renderComboBoxWarehouse();
    }

    private void itemStateChangedCompanyBranch() {
        if (!mbResetingForm) {
            populateComboBoxWarehouse();
        }
    }

    private void renderFields(boolean b) {
        jcbPkCompanyBranchId.setEnabled(b);
        jbPkCompanyBranchId.setEnabled(b);
        jcbPkWarehouseId.setEnabled(b);
        jbPkWarehouseId.setEnabled(b);
        jcbPkDocNumberSeriesId.setEnabled(b);
        jbPkDocNumberSeriesId.setEnabled(b);
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOK;
    private javax.swing.JButton jbPkCompanyBranchId;
    private javax.swing.JButton jbPkDocNumberSeriesId;
    private javax.swing.JButton jbPkWarehouseId;
    private javax.swing.JComboBox jcbPkCompanyBranchId;
    private javax.swing.JComboBox jcbPkDocNumberSeriesId;
    private javax.swing.JComboBox jcbPkWarehouseId;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JLabel jlPkCompanyBranchId;
    private javax.swing.JLabel jlPkDocNumberSeriesId;
    private javax.swing.JLabel jlPkWarehouseId;
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

        moStockConfigDns = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        renderFields(true);

        jcbPkWarehouseId.setEnabled(false);
        jbPkWarehouseId.setEnabled(false);

        jckIsDeleted.setEnabled(false);
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbPkCompanyBranchId, SDataConstants.BPSU_BPB, new int[] { miClient.getSessionXXX().getCurrentCompany().getPkCompanyId() });
        SFormUtilities.populateComboBox(miClient, jcbPkDocNumberSeriesId, SDataConstants.TRN_DNS_DPS, new int[] { SDataConstantsSys.TRNS_CT_DPS_SAL });
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

        if (!validation.getIsError()) {
            try {
                if (moStockConfigDns == null && SDataUtilities.checkStockConfigDns(miClient, moFieldPkWarehouseId.getKeyAsIntArray()[0], moFieldPkWarehouseId.getKeyAsIntArray()[1], moFieldPkDocNumberSeriesId.getKeyAsIntArray()[0])>0) {
                    validation.setMessage("Ya existe una configuración para está sucursal, almacén, serie doc. c/v");
                    validation.setComponent(moFieldPkDocNumberSeriesId.getComponent());
                }
            }
            catch (Exception e) {
                System.out.println(e);
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
        moStockConfigDns = (SDataStockConfigDns) registry;

        moFieldPkCompanyBranchId.setKey(new int[] { moStockConfigDns.getPkCompanyBranchId() });
        moFieldPkWarehouseId.setKey(new int[] { moStockConfigDns.getPkCompanyBranchId(), moStockConfigDns.getPkWarehouseId() });
        moFieldPkDocNumberSeriesId.setKey(new int[] { moStockConfigDns.getPkDocNumberSeriesId() });
        moFieldIsDeleted.setFieldValue(moStockConfigDns.getIsDeleted());

        renderFields(false);

        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moStockConfigDns == null) {
            moStockConfigDns = new SDataStockConfigDns();
            moStockConfigDns.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moStockConfigDns.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moStockConfigDns.setPkCompanyBranchId(moFieldPkCompanyBranchId.getKeyAsIntArray()[0]);
        moStockConfigDns.setPkWarehouseId(moFieldPkWarehouseId.getKeyAsIntArray()[1]);
        moStockConfigDns.setPkDocNumberSeriesId(moFieldPkDocNumberSeriesId.getKeyAsIntArray()[0]);
        moStockConfigDns.setIsDeleted(moFieldIsDeleted.getBoolean());

        return moStockConfigDns;
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

            if (button == jbOK) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbPkCompanyBranchId) {
                actionPkCompanyBranchId();
            }
            else if (button == jbPkWarehouseId) {
                actionPkWarehouseId();
            }
            else if (button == jbPkDocNumberSeriesId) {
                actionPkDocNumberSeriesId();
            }
        }
    }
}
