/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mtrn.form;

import erp.lib.SLibConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormValidation;
import java.awt.event.FocusEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTextField;
import sa.lib.SLibUtils;

/**
 *
 * @author Isabel Servín
 */
public class SDialogDpsTime extends javax.swing.JDialog implements java.awt.event.ActionListener, java.awt.event.FocusListener {

    private final erp.client.SClientInterface miClient;

    private java.util.Vector<erp.lib.form.SFormField> mvFields;

    private erp.lib.form.SFormField moFieldHour;    
    private erp.lib.form.SFormField moFieldMinute;    
    private erp.lib.form.SFormField moFieldSecond;    

    private int mnFormResult;
    
    /**
     * 
     * @param client
     * @throws java.lang.Exception
     */
    
    public SDialogDpsTime(erp.client.SClientInterface client) throws java.lang.Exception {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jlTimeText = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jlHour = new javax.swing.JLabel();
        jlPoints1 = new javax.swing.JLabel();
        jlMinute = new javax.swing.JLabel();
        jlPoints2 = new javax.swing.JLabel();
        jlSecond = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jtfHour = new javax.swing.JTextField();
        jlPoints3 = new javax.swing.JLabel();
        jtfMinute = new javax.swing.JTextField();
        jlPoints4 = new javax.swing.JLabel();
        jtfSecond = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fijar hora del documento");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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

        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 1));

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTimeText.setText("Hora (24 Hrs.):");
        jlTimeText.setPreferredSize(new java.awt.Dimension(105, 23));
        jPanel8.add(jlTimeText);

        jPanel1.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlHour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlHour.setText("hh");
        jlHour.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel9.add(jlHour);

        jlPoints1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlPoints1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPoints1.setText(":");
        jlPoints1.setPreferredSize(new java.awt.Dimension(10, 23));
        jPanel9.add(jlPoints1);

        jlMinute.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMinute.setText("mm");
        jlMinute.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel9.add(jlMinute);

        jlPoints2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlPoints2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPoints2.setText(":");
        jlPoints2.setPreferredSize(new java.awt.Dimension(10, 23));
        jPanel9.add(jlPoints2);

        jlSecond.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSecond.setText("ss");
        jlSecond.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel9.add(jlSecond);

        jPanel1.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfHour.setText("00");
        jtfHour.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel10.add(jtfHour);

        jlPoints3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlPoints3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPoints3.setText(":");
        jlPoints3.setPreferredSize(new java.awt.Dimension(10, 23));
        jPanel10.add(jlPoints3);

        jtfMinute.setText("00");
        jtfMinute.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel10.add(jtfMinute);

        jlPoints4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jlPoints4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPoints4.setText(":");
        jlPoints4.setPreferredSize(new java.awt.Dimension(10, 23));
        jPanel10.add(jlPoints4);

        jtfSecond.setText("00");
        jtfSecond.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel10.add(jtfSecond);

        jPanel1.add(jPanel10);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(336, 239));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void windowActivated() {
        
    }
    
    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldHour = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfHour, jlHour);
        moFieldMinute = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfMinute, jlMinute);
        moFieldSecond = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfSecond, jlSecond);

        mvFields.add(moFieldHour);
        mvFields.add(moFieldMinute);
        mvFields.add(moFieldSecond);
        
        addListeners();
    }
    
    private void addListeners() {
        jtfHour.addFocusListener(this);
        jtfMinute.addFocusListener(this);
        jtfSecond.addFocusListener(this);
        
        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
    }
    
    private void focusLostHour() {
        if (jtfHour.getText().length() > 2) {
            jtfHour.setText(SLibUtils.textLeft(jtfHour.getText(), 2));
        }
        if (SLibUtils.parseInt(jtfHour.getText()) > 23) {
            jtfHour.setText("23");
        }
    }
    
    private void focusLostMinute() {
        if (jtfMinute.getText().length() > 2) {
            jtfMinute.setText(SLibUtils.textLeft(jtfMinute.getText(), 2));
        }
        if (SLibUtils.parseInt(jtfMinute.getText()) > 59) {
            jtfMinute.setText("59");
        }
    }
    
    private void focusLostSecond() {
        if (jtfSecond.getText().length() > 2) {
            jtfSecond.setText(SLibUtils.textLeft(jtfSecond.getText(), 2));
        }
        if (SLibUtils.parseInt(jtfSecond.getText()) > 59) {
            jtfSecond.setText("59");
        }
    }
    
    private void actionOk() {
        SFormValidation validation = formValidate();
        
        if (!validation.getIsError()) {
            mnFormResult = SLibConstants.FORM_RESULT_OK;
            setVisible(false);
        }
        else {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
    }
    
    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        resetDialog();
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlHour;
    private javax.swing.JLabel jlMinute;
    private javax.swing.JLabel jlPoints1;
    private javax.swing.JLabel jlPoints2;
    private javax.swing.JLabel jlPoints3;
    private javax.swing.JLabel jlPoints4;
    private javax.swing.JLabel jlSecond;
    private javax.swing.JLabel jlTimeText;
    private javax.swing.JPanel jpControls;
    private javax.swing.JTextField jtfHour;
    private javax.swing.JTextField jtfMinute;
    private javax.swing.JTextField jtfSecond;
    // End of variables declaration//GEN-END:variables

    public void setFormVisible(boolean visible) {
        setVisible(visible);
    }
    
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();
        
        for (SFormField mvField : mvFields) {
            if (!((erp.lib.form.SFormField) mvField).validateField()) {
                validation.setIsError(true);
                validation.setComponent(mvField.getComponent());
                break;
            }
        }
        
        return validation;
    }
    
    public void resetDialog() {
        for (SFormField mvField : mvFields) {
            ((erp.lib.form.SFormField) mvField).resetField();
        }
    }

    public void setValue (int type, java.lang.Object value) {
        
    }
    
    public int[] getValue() {
        return new int[] {SLibUtils.parseInt(jtfHour.getText()), SLibUtils.parseInt(jtfMinute.getText()), SLibUtils.parseInt(jtfSecond.getText())};
    }
    
    public int getFormResult() {
        return mnFormResult;
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
        }        
    }

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof javax.swing.JTextField) {
            JTextField textField = (JTextField) e.getSource();
            if (textField == jtfHour) {
                focusLostHour();
            }
            else if (textField == jtfMinute) {
                focusLostMinute();
            }
            else if (textField == jtfSecond) {
                focusLostSecond();
            }
        }
    }
}
