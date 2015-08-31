/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogDpsFinder.java
 *
 * Created on 22/09/2009, 04:24:20 PM
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author Sergio Flores
 */
public class SDialogDpsFinder extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private erp.client.SClientInterface miClient;
    private int mnFinderType;

    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private java.util.Vector<SFormField> mvFields;

    private erp.lib.form.SFormField moFieldAdjustmentSubtypeId;
    private erp.mtrn.form.SPanelDpsFinder moPanelDpsFinder;
    private int[] manParamDpsClassKey;

    /** Creates new form SDialogDpsFinder
     * @param client ERP Client interface.
     * @param finderType Finder type can be:
     * a) SDataConstants.TRNX_DPS_PAY_PEND
     * b) SDataConstants.TRNX_DPS_PEND_LINK
     * c) SDataConstants.TRNX_DPS_PEND_ADJ
     */
    public SDialogDpsFinder(erp.client.SClientInterface client, int finderType) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFinderType = finderType;
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
        jlPanelDpsFinder = new javax.swing.JLabel();
        jpOptions = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jlAdjustmentSubtypeId = new javax.swing.JLabel();
        jcbAdjustmentSubtypeId = new javax.swing.JComboBox();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de documento de compras-ventas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpDps.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpDps.setLayout(new java.awt.BorderLayout());

        jlPanelDpsFinder.setFont(new java.awt.Font("Tahoma", 1, 14));
        jlPanelDpsFinder.setText("[Panel de búsqueda de documento de compras-ventas]");
        jlPanelDpsFinder.setPreferredSize(new java.awt.Dimension(100, 300));
        jpDps.add(jlPanelDpsFinder, java.awt.BorderLayout.NORTH);

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones adicinales:"));
        jpOptions.setLayout(new java.awt.BorderLayout());

        jPanel18.setLayout(new java.awt.GridLayout(1, 1));

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlAdjustmentSubtypeId.setText("Tipo de ajuste: ");
        jlAdjustmentSubtypeId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel19.add(jlAdjustmentSubtypeId);

        jcbAdjustmentSubtypeId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbAdjustmentSubtypeId.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel19.add(jcbAdjustmentSubtypeId);

        jPanel18.add(jPanel19);

        jpOptions.add(jPanel18, java.awt.BorderLayout.NORTH);

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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-504)/2, 800, 504);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        moFieldAdjustmentSubtypeId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbAdjustmentSubtypeId, jlAdjustmentSubtypeId);

        mvFields = new Vector<SFormField>();
        mvFields.add(moFieldAdjustmentSubtypeId);

        moPanelDpsFinder = new SPanelDpsFinder(miClient, mnFinderType);
        jpDps.remove(jlPanelDpsFinder);
        jpDps.add(moPanelDpsFinder, BorderLayout.NORTH);

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

            if (miClient.getSessionXXX().getCurrentCompanyBranchId() == 0) {
                // A company branch must be selected:

                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_SESSION_BRANCH);
                actionCancel();
            }
            else {
                moPanelDpsFinder.windowActivated();
            }
        }
    }

    private void updateFormAdjustmentSubtype(boolean enable) {
        if (!enable) {
            jlAdjustmentSubtypeId.setEnabled(false);
            jcbAdjustmentSubtypeId.setEnabled(false);
            jcbAdjustmentSubtypeId.removeAllItems();
        }
        else {
            jlAdjustmentSubtypeId.setEnabled(true);
            jcbAdjustmentSubtypeId.setEnabled(true);
            SFormUtilities.populateComboBox(miClient, jcbAdjustmentSubtypeId, SDataConstants.TRNS_STP_DPS_ADJ);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JComboBox jcbAdjustmentSubtypeId;
    private javax.swing.JLabel jlAdjustmentSubtypeId;
    private javax.swing.JLabel jlPanelDpsFinder;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpDps;
    private javax.swing.JPanel jpOptions;
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

        moPanelDpsFinder.resetPanel();
        manParamDpsClassKey = null;
        updateFormAdjustmentSubtype(false);

        for (SFormField field : mvFields) {
            field.resetField();
        }
    }

    @Override
    public void formRefreshCatalogues() {

    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(mvFields.get(i).getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            validation = moPanelDpsFinder.validatePanel();
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
            case SLibConstants.VALUE_FILTER_KEY:
                manParamDpsClassKey = (int[]) value;

                moPanelDpsFinder.setDpsClassKey(manParamDpsClassKey);

                if (SLibUtilities.compareKeys(manParamDpsClassKey, SDataConstantsSys.TRNS_CL_DPS_PUR_DOC) ||
                    SLibUtilities.compareKeys(manParamDpsClassKey, SDataConstantsSys.TRNS_CL_DPS_SAL_DOC)) {
                    updateFormAdjustmentSubtype(true);
                }
                break;

            default:
        }
    }

    @Override
    public java.lang.Object getValue(int type) {
        Object value = null;

        switch (type) {
            case SDataConstants.TRN_DPS:
                value = moPanelDpsFinder.getDps();
                break;

            case SDataConstants.TRNS_STP_DPS_ADJ:
                value = moFieldAdjustmentSubtypeId.getKeyAsIntArray();
                break;

            case SLibConstants.VALUE_CURRENCY_LOCAL:
                value = moPanelDpsFinder.getIsLocalCurrency();
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
        }
    }
}
