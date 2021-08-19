/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mtrn.form.uareu;

import erp.client.SClientInterface;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.data.SDataRegistry;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import static erp.mtrn.form.uareu.SDialogUareUFingerprint.MODE_ENROLLMENT;
import static erp.mtrn.form.uareu.SDialogUareUFingerprint.MODE_VERIFICATION;
import erp.musr.data.SProcUserNameVal;
import erp.server.SServerConstants;
import erp.server.SServerRequest;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JLabel;
import sa.lib.SLibConsts;
import sa.lib.srv.SSrvCompany;
import sa.lib.srv.SSrvConsts;

/**
 *
 * @author Claudio Peña
 */
public class SDialogUareUFingerPassword extends JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener{

    public static final int VALUE_FINGERPASSWORD = 1;
    private SClientInterface miClient;
    private int mnFormResult;
    private boolean mbFirstTime;
    private int mnMode;

    /**
     * Creates new form SLogin
     */
    public SDialogUareUFingerPassword(SClientInterface client, int mode) {
        super(client.getFrame(), true);
        miClient = client;
        mnMode = mode;

        initComponents();
        initComponentsExtra();
    }
    
    /** 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpDialog = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jtfMode = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jlUserPassword = new javax.swing.JLabel();
        jpfUserPassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jlUserPasswordConfirm = new javax.swing.JLabel();
        jpfUserPasswordConfirm = new javax.swing.JPasswordField();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acceso del usuario");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jpDialog.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Crear contraseña usuario:")));
        jpDialog.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        jtfMode.setEditable(false);
        jtfMode.setFocusable(false);
        jtfMode.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel1.add(jtfMode);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlUserPassword.setText("Contraseña:");
        jlUserPassword.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel2.add(jlUserPassword);

        jpfUserPassword.setText("12345");
        jpfUserPassword.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel2.add(jpfUserPassword);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlUserPasswordConfirm.setText("Confirmar: ");
        jlUserPasswordConfirm.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlUserPasswordConfirm);

        jpfUserPasswordConfirm.setText("12345");
        jpfUserPasswordConfirm.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(jpfUserPasswordConfirm);

        jPanel1.add(jPanel3);

        jpDialog.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jpDialog, java.awt.BorderLayout.CENTER);

        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jpControls.add(jbCancel);

        getContentPane().add(jpControls, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(416, 189));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (mbFirstTime) {
            mbFirstTime = false;
            SLibUtilities.requestComponentFocus(jpfUserPassword);
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SLibUtilities.requestComponentFocus(jpfUserPassword);
    }//GEN-LAST:event_formWindowOpened

    private void initComponentsExtra() { 
        
        switch (mnMode) {
            case MODE_ENROLLMENT:
                jtfMode.setText("CREAR CONTRASEÑA");
                break;
            case MODE_VERIFICATION:
                jtfMode.setText("VERIFICAR CONTRASEÑA");
                jpfUserPasswordConfirm.setEnabled(false);
                break;
            default:
        }
        
        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        SFormUtilities.createActionMap(rootPane, this, "actionCancel", "cancel", KeyEvent.VK_ESCAPE, 0);
    }
        
    private void actionOk() {
        erp.lib.form.SFormValidation validation = formValidate();

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
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlUserPassword;
    private javax.swing.JLabel jlUserPasswordConfirm;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpDialog;
    private javax.swing.JPasswordField jpfUserPassword;
    private javax.swing.JPasswordField jpfUserPasswordConfirm;
    private javax.swing.JTextField jtfMode;
    // End of variables declaration//GEN-END:variables

    public void reset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        jpfUserPassword.setText("");
        jpfUserPasswordConfirm.setText("");
    }

    public void setCompanies(ArrayList<SSrvCompany> companies) {
        Vector<SFormComponentItem> items = new Vector<>();

        for (SSrvCompany c : companies) {
            items.add(new SFormComponentItem(new int[]{c.getCompanyId()}, c.getCompany()));
        }
    }

    public int getFormResult() {
        return mnFormResult;
    }

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        jpfUserPassword.setText("");
        jpfUserPasswordConfirm.setText("");
    }

    @Override
    public void formRefreshCatalogues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SFormValidation formValidate() {
        java.lang.String password = "";
        erp.server.SServerRequest request = null;
        erp.server.SServerResponse response = null;
        erp.musr.data.SProcUserNameVal procUserNameVal = null;
        erp.lib.form.SFormValidation validation = new SFormValidation();

        if (!validation.getIsError()) {
            procUserNameVal = new SProcUserNameVal();
            request = new SServerRequest(SServerConstants.REQ_DB_PROCEDURE, procUserNameVal);
            response = miClient.getSessionXXX().request(request);

            if (response.getResponseType() != SSrvConsts.RESP_TYPE_OK) {
                validation.setMessage(SLibConstants.MSG_ERR_DB_STP);
            }
            else {
                procUserNameVal = (erp.musr.data.SProcUserNameVal) response.getPacket();
                
                switch (mnMode) {
                    case MODE_ENROLLMENT:                 
                        if (jpfUserPassword.isEnabled()) {
                            password = new String(jpfUserPassword.getPassword());

                            if (password.length() < 4) {
                                validation.setMessage("La longitud de la contraseña no puede ser menor a 4.");
                            }
                            else if (password.length() > 4) {
                                validation.setMessage("La longitud de la contraseña no puede ser mayor a 4.");
                            }
                            else if (!password.matches("[0-9]*")) {
                                  validation.setMessage("La contraseña debe ser númerica");
                            }
                            else if (password.compareTo(new String(jpfUserPasswordConfirm.getPassword())) != 0) {
                                validation.setMessage("La confirmación de la contraseña no coincide.");
                            }

                            if (validation.getIsError()) {
                                jpfUserPassword.setText("");
                                jpfUserPasswordConfirm.setText("");
                                validation.setComponent(jpfUserPassword);
                            }
                        }
                        break;
                    case MODE_VERIFICATION:
                        jpfUserPasswordConfirm.setEnabled(false);
                                if (jpfUserPassword.isEnabled()) {
                                password = new String(jpfUserPassword.getPassword());

                                if (password.length() < 4) {
                                    validation.setMessage("La longitud de la contraseña no puede ser menor a 4.");
                                }
                                else if (password.length() > 4) {
                                    validation.setMessage("La longitud de la contraseña no puede ser mayor a 4.");
                                }
                                else if (!password.matches("[0-9]*")) {
                                      validation.setMessage("La contraseña debe ser númerica");
                                }

                                if (validation.getIsError()) {
                                    jpfUserPassword.setText("");
                                    jpfUserPasswordConfirm.setText("");
                                    validation.setComponent(jpfUserPassword);
                                }
                            }
                            break;
                    default:
                }                              
            }
        }
        return validation;
    }

    @Override
    public void setFormStatus(int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFormVisible(boolean visible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFormStatus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRegistry(SDataRegistry registry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SDataRegistry getRegistry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValue(int type, Object value) {
        switch (type) {
            case VALUE_FINGERPASSWORD:
                jpfUserPasswordConfirm.getPassword();
                break;
            default:
                miClient.showMsgBoxWarning(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
        }    
    }

    @Override
    public String getValue(int type) {
        String value = null;
        
        switch (type) {
            case VALUE_FINGERPASSWORD:
                value = String.valueOf(jpfUserPasswordConfirm.getPassword());
                break;
            default:
                miClient.showMsgBoxWarning(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
        }
        
        return value;
    }

    @Override
    public JLabel getTimeoutLabel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        }
    }
}