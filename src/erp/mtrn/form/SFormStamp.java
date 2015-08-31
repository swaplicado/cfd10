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
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mtrn.data.SDataSign;
import erp.mtrn.data.STrnUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import sa.lib.SLibUtils;

/**
 *
 * @author  Juan Barajas
 */
public class SFormStamp extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mtrn.data.SDataSign moDpsSign;
    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldPacId;
    private erp.lib.form.SFormField moFieldStampQty;
    private erp.lib.form.SFormField moFieldCode;
    private erp.lib.form.SFormField moFieldIsDeleted;

    public SFormStamp(erp.client.SClientInterface client) {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlPkPacId = new javax.swing.JLabel();
        jcbPkPacId = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jlPkDateId = new javax.swing.JLabel();
        jftDate = new javax.swing.JFormattedTextField();
        jbPkDateId = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlStampQty = new javax.swing.JLabel();
        jtfStampQty = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jlCode = new javax.swing.JLabel();
        jtfCode = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlDummy = new javax.swing.JLabel();
        jckIsDeleted = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adquisición de timbres"); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel3.setLayout(new java.awt.GridLayout(7, 0));

        jPanel6.setLayout(new java.awt.FlowLayout(3, 5, 0));

        jlPkPacId.setForeground(new java.awt.Color(0, 0, 255));
        jlPkPacId.setText("PAC:*");
        jlPkPacId.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel6.add(jlPkPacId);

        jcbPkPacId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbPkPacId.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel6.add(jcbPkPacId);

        jPanel3.add(jPanel6);

        jPanel1.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlPkDateId.setText("Fecha:*");
        jlPkDateId.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel1.add(jlPkDateId);

        jftDate.setText("yyyy/mm/dd");
        jftDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jftDate);

        jbPkDateId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbPkDateId.setToolTipText("Seleccionar fecha");
        jbPkDateId.setFocusable(false);
        jbPkDateId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel1.add(jbPkDateId);

        jPanel3.add(jPanel1);

        jPanel4.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlStampQty.setText("Cantidad de timbres:*");
        jlStampQty.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel4.add(jlStampQty);

        jtfStampQty.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfStampQty.setText("1");
        jtfStampQty.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jtfStampQty);

        jPanel3.add(jPanel4);

        jPanel7.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlCode.setText("Código activación:*");
        jlCode.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel7.add(jlCode);

        jtfCode.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtfCode.setText("CODE");
        jtfCode.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jtfCode);

        jPanel3.add(jPanel7);

        jPanel5.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlDummy.setPreferredSize(new java.awt.Dimension(243, 0));
        jPanel5.add(jlDummy);

        jckIsDeleted.setText("Registro eliminado");
        jPanel5.add(jckIsDeleted);

        jPanel3.add(jPanel5);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(2));

        jbOk.setText("Aceptar"); // NOI18N
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbOk);

        jbCancel.setText("Cancelar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDate = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDate, jlPkDateId);
        moFieldDate.setPickerButton(jbPkDateId);
        moFieldPacId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbPkPacId, jlPkPacId);
        moFieldStampQty = new SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfStampQty, jlStampQty);
        moFieldCode = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfCode, jlCode);
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, true, jckIsDeleted);

        mvFields.add(moFieldPacId);
        mvFields.add(moFieldDate);
        mvFields.add(moFieldStampQty);
        mvFields.add(moFieldCode);
        mvFields.add(moFieldIsDeleted);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbPkDateId.addActionListener(this);

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
            if (jcbPkPacId.isEnabled()) {
                jcbPkPacId.requestFocus();
            }
            else {
                jftDate.requestFocus();
            }
        }
    }

    private void actionPkDateId() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDate.getDate(), moFieldDate);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbPkDateId;
    private javax.swing.JComboBox jcbPkPacId;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JFormattedTextField jftDate;
    private javax.swing.JLabel jlCode;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JLabel jlPkDateId;
    private javax.swing.JLabel jlPkPacId;
    private javax.swing.JLabel jlStampQty;
    private javax.swing.JTextField jtfCode;
    private javax.swing.JTextField jtfStampQty;
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

        moDpsSign = null;

        for (int i = 0; i < mvFields.size(); i++) {
            mvFields.get(i).resetField();
        }

        moFieldDate.setFieldValue(miClient.getSessionXXX().getWorkingDate());

        jcbPkPacId.setEnabled(true);
        jftDate.setEnabled(true);
        jbPkDateId.setEnabled(true);

        jckIsDeleted.setEnabled(false);
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbPkPacId, SDataConstants.TRN_PAC);
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
            if (!SDataUtilities.isPeriodOpen(miClient, moFieldDate.getDate())) {
                validation.setMessage(SLibConstants.MSG_ERR_GUI_PER_CLOSE);
            }
            else if (moDpsSign != null) {
                    if (moDpsSign.getPkYearId() != SLibTimeUtilities.digestYear(moFieldDate.getDate())[0]) {
                        validation.setMessage(SLibConstants.MSG_ERR_GUI_PER_YEAR);
                        validation.setComponent(jftDate);
                    }
            }
        }
        
        if (!validation.getIsError()) {
            try {
                if (moFieldCode.getString().compareTo(STrnUtilities.getCodeActivationStamp(moFieldPacId.getKeyAsIntArray()[0], SLibUtils.DateFormatDate.parse(moFieldDate.getString()), moFieldStampQty.getInteger())) != 0) {
                    validation.setMessage("El código de activación es incorrecto.");
                    validation.setComponent(jtfCode);
                }
                else if (moDpsSign == null && STrnUtilities.validateExistsAcquisitionStamp(miClient, moFieldPacId.getKeyAsIntArray()[0], moFieldDate.getDate())) {
                    validation.setMessage("Ya existe un registro de adquisición de timbres para el PAC '" + ((SFormComponentItem) jcbPkPacId.getSelectedItem()).getItem() + "' en la fecha '" + SLibUtils.DateFormatDate.format(moFieldDate.getDate()) + "'.");
                    validation.setComponent(jftDate);
                }
            }
            catch (Exception e) {
                SLibUtilities.renderException(this, e);
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
        moDpsSign = (SDataSign) registry;

        moFieldDate.setFieldValue(moDpsSign.getDate());
        moFieldPacId.setFieldValue(new int[] { moDpsSign.getPkPacId() });
        moFieldStampQty.setFieldValue(moDpsSign.getMoveIn());
        moFieldIsDeleted.setFieldValue(moDpsSign.getIsDeleted());

        jcbPkPacId.setEnabled(false);

        jftDate.setEnabled(true);
        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moDpsSign == null) {
            moDpsSign = new SDataSign();
            moDpsSign.setPkYearId(SLibTimeUtilities.digestYear(moFieldDate.getDate())[0]);
        }

        moDpsSign.setDate(moFieldDate.getDate());
        moDpsSign.setMoveIn(moFieldStampQty.getInteger());
        moDpsSign.setMoveOut(0);
        moDpsSign.setIsDeleted(moFieldIsDeleted.getBoolean());
        moDpsSign.setFkSignCategoryId(SDataConstantsSys.TRNS_TP_SIGN_IN_ACQUIRED[0]);
        moDpsSign.setFkSignTypeId(SDataConstantsSys.TRNS_TP_SIGN_IN_ACQUIRED[1]);
        moDpsSign.setPkPacId(moFieldPacId.getKeyAsIntArray()[0]);
        
        return moDpsSign;
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
            else if (button == jbPkDateId) {
                actionPkDateId();
            }
        }
    }
}
