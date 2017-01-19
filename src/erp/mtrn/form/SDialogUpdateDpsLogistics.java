/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogUpdateDpsLogistics.java
 *
 * Created on 22/09/2009, 04:24:20 PM
 */

package erp.mtrn.form;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.data.SProcConstants;
import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mtrn.data.SDataDps;

/**
 *
 * @author Sergio Flores
 */
public class SDialogUpdateDpsLogistics extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener, java.awt.event.FocusListener, java.awt.event.ItemListener {

    private erp.client.SClientInterface miClient;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;

    private erp.lib.form.SFormField moFieldDateDelivery;
    private erp.lib.form.SFormField moFieldDateStartCredit;
    private erp.lib.form.SFormField moFieldDateStartCreditRo;
    private erp.mtrn.data.SDataDps moDps;
    private erp.mtrn.form.SPanelDps moPanelDps;

    /** Creates new form SDialogDpsLink */
    public SDialogUpdateDpsLogistics(erp.client.SClientInterface client) {
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

        jpDps = new javax.swing.JPanel();
        jlPanelDps = new javax.swing.JLabel();
        jpDpsLogistics = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jlDateDelivery = new javax.swing.JLabel();
        jftDateDelivery = new javax.swing.JFormattedTextField();
        jbDateDelivery = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlPaymentTypeRo = new javax.swing.JLabel();
        jtfPaymentTypeRo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jckChangeDateStartCredit = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jlDateStartCreditRo = new javax.swing.JLabel();
        jftDateStartCreditRo = new javax.swing.JFormattedTextField();
        jPanel14 = new javax.swing.JPanel();
        jlDateStartCredit = new javax.swing.JLabel();
        jftDateStartCredit = new javax.swing.JFormattedTextField();
        jbDateStartCredit = new javax.swing.JButton();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualización de fechas de entrega del documento");
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

        jpDpsLogistics.setBorder(javax.swing.BorderFactory.createTitledBorder("Fechas de entrega del documento:"));
        jpDpsLogistics.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(6, 1, 0, 1));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateDelivery.setText("Fecha real de entrega: *");
        jlDateDelivery.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel11.add(jlDateDelivery);

        jftDateDelivery.setText("yyyy/mm/dd");
        jftDateDelivery.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel11.add(jftDateDelivery);

        jbDateDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDateDelivery.setToolTipText("Seleccionar fecha");
        jbDateDelivery.setFocusable(false);
        jbDateDelivery.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel11.add(jbDateDelivery);

        jPanel1.add(jPanel11);
        jPanel1.add(jPanel12);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlPaymentTypeRo.setText("Tipo de pago del documento:");
        jlPaymentTypeRo.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(jlPaymentTypeRo);

        jtfPaymentTypeRo.setEditable(false);
        jtfPaymentTypeRo.setText("PAYMENT TYPE");
        jtfPaymentTypeRo.setFocusable(false);
        jtfPaymentTypeRo.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(jtfPaymentTypeRo);

        jPanel1.add(jPanel3);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jckChangeDateStartCredit.setText("Cambiar fecha base de crédito");
        jckChangeDateStartCredit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jckChangeDateStartCredit.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel2.add(jckChangeDateStartCredit);

        jPanel1.add(jPanel2);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateStartCreditRo.setText("Fecha base crédito original:");
        jlDateStartCreditRo.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel13.add(jlDateStartCreditRo);

        jftDateStartCreditRo.setEditable(false);
        jftDateStartCreditRo.setText("yyyy/mm/dd");
        jftDateStartCreditRo.setFocusable(false);
        jftDateStartCreditRo.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel13.add(jftDateStartCreditRo);

        jPanel1.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateStartCredit.setText("Fecha base crédito nueva: *");
        jlDateStartCredit.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel14.add(jlDateStartCredit);

        jftDateStartCredit.setText("yyyy/mm/dd");
        jftDateStartCredit.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel14.add(jftDateStartCredit);

        jbDateStartCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDateStartCredit.setToolTipText("Seleccionar fecha");
        jbDateStartCredit.setFocusable(false);
        jbDateStartCredit.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel14.add(jbDateStartCredit);

        jPanel1.add(jPanel14);

        jpDpsLogistics.add(jPanel1, java.awt.BorderLayout.NORTH);

        jpDps.add(jpDpsLogistics, java.awt.BorderLayout.CENTER);

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

        setSize(new java.awt.Dimension(900, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        moFieldDateDelivery = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateDelivery, jlDateDelivery);
        moFieldDateDelivery.setPickerButton(jbDateDelivery);

        moFieldDateStartCredit = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateStartCredit, jlDateStartCredit);
        moFieldDateStartCredit.setPickerButton(jbDateStartCredit);
        
        moFieldDateStartCreditRo = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateStartCreditRo, jlDateStartCreditRo);
        
        mvFields = new java.util.Vector<erp.lib.form.SFormField>();
        mvFields.add(moFieldDateDelivery);
        mvFields.add(moFieldDateStartCredit);

        moPanelDps = new SPanelDps(miClient, "entregado");
        jpDps.remove(jlPanelDps);
        jpDps.add(moPanelDps, BorderLayout.NORTH);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbDateDelivery.addActionListener(this);
        jbDateStartCredit.addActionListener(this);

        jftDateDelivery.addFocusListener(this);
        jckChangeDateStartCredit.addItemListener(this);

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
            jftDateDelivery.requestFocus();
        }
    }

    private void renderDpsLogistics() {
        moFieldDateDelivery.setFieldValue(moDps.getDateDelivery_n() != null ? moDps.getDateDelivery_n() : miClient.getSessionXXX().getWorkingDate());
        moFieldDateStartCredit.setFieldValue(moDps.getDateStartCredit());

        jtfPaymentTypeRo.setText(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.TRNS_TP_PAY, new int[] { moDps.getFkPaymentTypeId() }));
        jftDateStartCreditRo.setText(miClient.getSessionXXX().getFormatters().getDateFormat().format(moDps.getDateStartCredit()));

        if (moDps.getFkPaymentTypeId() == SDataConstantsSys.TRNS_TP_PAY_CASH) {
            jckChangeDateStartCredit.setEnabled(false);
            jlDateStartCredit.setEnabled(false);
            jlDateStartCreditRo.setEnabled(false);
            jftDateStartCredit.setEnabled(false);
            jftDateStartCreditRo.setEnabled(false);

            jckChangeDateStartCredit.setSelected(false);
        }
        else {
            jckChangeDateStartCredit.setEnabled(true);
            jlDateStartCredit.setEnabled(true);
            jlDateStartCreditRo.setEnabled(true);
            jftDateStartCredit.setEnabled(true);
            jftDateStartCreditRo.setEnabled(true);

            jckChangeDateStartCredit.setSelected(true);
        }

        itemStateDifferentDate();
    }

    private boolean updateDpsLogistics() {
        boolean updated = false;
        Vector<Object> in = new Vector<Object>();
        Vector<Object> out = new Vector<Object>();

        in.add(moDps.getPkYearId());
        in.add(moDps.getPkDocId());
        in.add((moDps.getFkPaymentTypeId() == SDataConstantsSys.TRNS_TP_PAY_CASH || !jckChangeDateStartCredit.isSelected()) ? new java.util.Date(0) : moFieldDateStartCredit.getDate()); // new start credit date
        in.add(new java.util.Date(0)); // omit real shipment date
        in.add(moFieldDateDelivery.getDate()); // new real delivery date

        out = SDataUtilities.callProcedure(miClient, SProcConstants.TRN_DPS_LOG_UPD, in, SLibConstants.EXEC_MODE_VERBOSE);

        if ((Integer) out.get(0) == 0) {
            updated = true;
        }
        else {
            miClient.showMsgBoxWarning((String) out.get(1));
        }

        return updated;
    }

    private void copyDateDelivery() {
        if (!jckChangeDateStartCredit.isSelected() && moFieldDateDelivery.getDate() != null &&
                moDps != null && moDps.getFkPaymentTypeId() == SDataConstantsSys.TRNS_TP_PAY_CREDIT) {
            moFieldDateStartCredit.setFieldValue(moFieldDateStartCreditRo.getDate());
        }
        else {
            moFieldDateStartCredit.setFieldValue(moFieldDateDelivery.getDate());
        }
    }

    private void itemStateDifferentDate() {
        if (jckChangeDateStartCredit.isSelected() &&
                moDps != null && moDps.getFkPaymentTypeId() == SDataConstantsSys.TRNS_TP_PAY_CREDIT) {
            jftDateStartCredit.setEditable(true);
            jftDateStartCredit.setFocusable(true);
            jbDateStartCredit.setEnabled(true);

            jftDateStartCredit.requestFocus();
        }
        else {
            jftDateStartCredit.setEditable(false);
            jftDateStartCredit.setFocusable(false);
            jbDateStartCredit.setEnabled(false);
        }

        copyDateDelivery();
    }

    private void actionDateDelivery() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateDelivery.getDate(), moFieldDateDelivery);
        copyDateDelivery();
    }

    private void actionDateStartCredit() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateStartCredit.getDate(), moFieldDateStartCredit);
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
            if (updateDpsLogistics()) {
                mnFormResult = SLibConstants.FORM_RESULT_OK;
                setVisible(false);
            }
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDateDelivery;
    private javax.swing.JButton jbDateStartCredit;
    private javax.swing.JButton jbOk;
    private javax.swing.JCheckBox jckChangeDateStartCredit;
    private javax.swing.JFormattedTextField jftDateDelivery;
    private javax.swing.JFormattedTextField jftDateStartCredit;
    private javax.swing.JFormattedTextField jftDateStartCreditRo;
    private javax.swing.JLabel jlDateDelivery;
    private javax.swing.JLabel jlDateStartCredit;
    private javax.swing.JLabel jlDateStartCreditRo;
    private javax.swing.JLabel jlPanelDps;
    private javax.swing.JLabel jlPaymentTypeRo;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpDps;
    private javax.swing.JPanel jpDpsLogistics;
    private javax.swing.JTextField jtfPaymentTypeRo;
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

        moDps = null;
        moPanelDps.setDps(null, null);

        for (SFormField field : mvFields) {
            field.resetField();
        }

        jtfPaymentTypeRo.setText("");
        jckChangeDateStartCredit.setSelected(false);

        itemStateDifferentDate();
    }

    @Override
    public void formRefreshCatalogues() {

    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (SFormField field : mvFields) {
            if (!field.validateField()) {
                validation.setIsError(true);
                validation.setComponent(field.getComponent());
            }
        }

        if (!validation.getIsError()) {
            if (moDps.getDate().after(moFieldDateDelivery.getDate())) {
                validation.setMessage("La fecha del campo '" + jlDateDelivery.getText()+ "' no puede ser anterior a la fecha de este documento.");
                validation.setComponent(jftDateDelivery);
            }
            else if (moDps.getDate().after(moFieldDateStartCredit.getDate())) {
                validation.setMessage("La fecha del campo '" + jlDateStartCredit.getText()+ "' no puede ser anterior a la fecha de este documento.");
                validation.setComponent(jftDateStartCredit);
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
            case SDataConstants.TRN_DPS:
                moDps = (SDataDps) SDataUtilities.readRegistry(miClient, SDataConstants.TRN_DPS, value, SLibConstants.EXEC_MODE_VERBOSE);
                moPanelDps.setDps(moDps, null);
                renderDpsLogistics();
                break;

            default:
        }
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
            else if (button == jbDateDelivery) {
                actionDateDelivery();
            }
            else if (button == jbDateStartCredit) {
                actionDateStartCredit();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof javax.swing.JFormattedTextField) {
            JFormattedTextField formattedTextField = (JFormattedTextField) e.getSource();

            if (formattedTextField == jftDateDelivery) {
                copyDateDelivery();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof javax.swing.JCheckBox) {
            JCheckBox checkBox = (JCheckBox) e.getSource();

            if (checkBox == jckChangeDateStartCredit) {
                itemStateDifferentDate();
            }
        }
    }
}