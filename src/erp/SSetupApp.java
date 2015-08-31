/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SSetupApp.java
 *
 * Created on 13/05/2013, 09:00:00 AM
 */

package erp;

import javax.swing.JOptionPane;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbConsts;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiItem;
import sa.lib.gui.SGuiUtils;

/**
 *
 * @author Sergio Flores
 */
public class SSetupApp extends javax.swing.JFrame {

    private boolean mbFirstActivation;
    private SParamsApp moParamsApp;

    /** Creates new form SSetupClient */
    public SSetupApp() {
        initComponents();
        initComponentsCustom();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlErpInstance = new javax.swing.JLabel();
        jtfErpInstance = new javax.swing.JTextField();
        jlErpInstanceExample = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jlErpHost = new javax.swing.JLabel();
        jtfErpHost = new javax.swing.JTextField();
        jlErpHostExample = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jlErpRmiRegistryPort = new javax.swing.JLabel();
        jtfErpRmiRegistryPort = new javax.swing.JTextField();
        jlErpRmiRegistryPortExample = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jlDatabaseType = new javax.swing.JLabel();
        jcbDatabaseType = new javax.swing.JComboBox<SGuiItem>();
        jlDatabaseTypeExample = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jlDatabaseHostServer = new javax.swing.JLabel();
        jtfDatabaseHostServer = new javax.swing.JTextField();
        jlSeparatorServer = new javax.swing.JLabel();
        jtfDatabasePortServer = new javax.swing.JTextField();
        jlDatabaseServerExample = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jlDatabaseHostClient = new javax.swing.JLabel();
        jtfDatabaseHostClient = new javax.swing.JTextField();
        jlSeparatorClient = new javax.swing.JLabel();
        jtfDatabasePortClient = new javax.swing.JTextField();
        jlDatabaseClientExample = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jlDatabaseName = new javax.swing.JLabel();
        jtfDatabaseName = new javax.swing.JTextField();
        jlDatabaseNameExample = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jlDatabaseUser = new javax.swing.JLabel();
        jtfDatabaseUser = new javax.swing.JTextField();
        jlDatabaseUserExample = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jlDatabasePassword1 = new javax.swing.JLabel();
        jpfDatabasePassword1 = new javax.swing.JPasswordField();
        jlDatabasePassword1Example = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jlDatabasePassword2 = new javax.swing.JLabel();
        jpfDatabasePassword2 = new javax.swing.JPasswordField();
        jlDatabasePassword2Example = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jlTimestpamp = new javax.swing.JLabel();
        jtfTimestamp = new javax.swing.JTextField();
        jlTimestampExample = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbClear = new javax.swing.JButton();
        jbSave = new javax.swing.JButton();
        jbClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ERP Client Setup");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuration parameters:"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(11, 0, 0, 5));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlErpInstance.setText("ERP instance name:*");
        jlErpInstance.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel5.add(jlErpInstance);

        jtfErpInstance.setText("ERP");
        jtfErpInstance.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jtfErpInstance);

        jlErpInstanceExample.setText("(e.g. ERP)");
        jlErpInstanceExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlErpInstanceExample);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlErpHost.setText("ERP server host for client:*");
        jlErpHost.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel6.add(jlErpHost);

        jtfErpHost.setText("127.0.0.1");
        jtfErpHost.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jtfErpHost);

        jlErpHostExample.setText("(e.g. 127.0.0.1)");
        jlErpHostExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jlErpHostExample);

        jPanel4.add(jPanel6);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlErpRmiRegistryPort.setText("ERP RMI Registry port:*");
        jlErpRmiRegistryPort.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel7.add(jlErpRmiRegistryPort);

        jtfErpRmiRegistryPort.setText("50001");
        jtfErpRmiRegistryPort.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jtfErpRmiRegistryPort);

        jlErpRmiRegistryPortExample.setText("(e.g. 50001)");
        jlErpRmiRegistryPortExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jlErpRmiRegistryPortExample);

        jPanel4.add(jPanel7);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabaseType.setText("Database type:*");
        jlDatabaseType.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel9.add(jlDatabaseType);

        jcbDatabaseType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbDatabaseType.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel9.add(jcbDatabaseType);

        jlDatabaseTypeExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel9.add(jlDatabaseTypeExample);

        jPanel4.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabaseHostServer.setText("Database host for server:*");
        jlDatabaseHostServer.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel10.add(jlDatabaseHostServer);

        jtfDatabaseHostServer.setText("127.0.0.1");
        jtfDatabaseHostServer.setToolTipText("host");
        jtfDatabaseHostServer.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel10.add(jtfDatabaseHostServer);

        jlSeparatorServer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSeparatorServer.setText(":");
        jlSeparatorServer.setPreferredSize(new java.awt.Dimension(5, 23));
        jPanel10.add(jlSeparatorServer);

        jtfDatabasePortServer.setText("3306");
        jtfDatabasePortServer.setToolTipText("port");
        jtfDatabasePortServer.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel10.add(jtfDatabasePortServer);

        jlDatabaseServerExample.setText("(e.g. 127.0.0.1 : 3306)");
        jlDatabaseServerExample.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel10.add(jlDatabaseServerExample);

        jPanel4.add(jPanel10);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabaseHostClient.setText("Database host for client:*");
        jlDatabaseHostClient.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel11.add(jlDatabaseHostClient);

        jtfDatabaseHostClient.setText("127.0.0.1");
        jtfDatabaseHostClient.setToolTipText("host");
        jtfDatabaseHostClient.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jtfDatabaseHostClient);

        jlSeparatorClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSeparatorClient.setText(":");
        jlSeparatorClient.setPreferredSize(new java.awt.Dimension(5, 23));
        jPanel11.add(jlSeparatorClient);

        jtfDatabasePortClient.setText("3306");
        jtfDatabasePortClient.setToolTipText("port");
        jtfDatabasePortClient.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel11.add(jtfDatabasePortClient);

        jlDatabaseClientExample.setText("(e.g. 127.0.0.1 : 3306)");
        jlDatabaseClientExample.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel11.add(jlDatabaseClientExample);

        jPanel4.add(jPanel11);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabaseName.setText("Database name:*");
        jlDatabaseName.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel15.add(jlDatabaseName);

        jtfDatabaseName.setText("erp");
        jtfDatabaseName.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel15.add(jtfDatabaseName);

        jlDatabaseNameExample.setText("(e.g. erp)");
        jlDatabaseNameExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel15.add(jlDatabaseNameExample);

        jPanel4.add(jPanel15);

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabaseUser.setText("Database user:*");
        jlDatabaseUser.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel12.add(jlDatabaseUser);

        jtfDatabaseUser.setText("root");
        jtfDatabaseUser.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jtfDatabaseUser);

        jlDatabaseUserExample.setText("(e.g. root)");
        jlDatabaseUserExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlDatabaseUserExample);

        jPanel4.add(jPanel12);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabasePassword1.setText("Database password:*");
        jlDatabasePassword1.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel13.add(jlDatabasePassword1);

        jpfDatabasePassword1.setText("password");
        jpfDatabasePassword1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jpfDatabasePassword1);

        jlDatabasePassword1Example.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlDatabasePassword1Example);

        jPanel4.add(jPanel13);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatabasePassword2.setText("Confirm database password:*");
        jlDatabasePassword2.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel14.add(jlDatabasePassword2);

        jpfDatabasePassword2.setText("password");
        jpfDatabasePassword2.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jpfDatabasePassword2);

        jlDatabasePassword2Example.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlDatabasePassword2Example);

        jPanel4.add(jPanel14);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTimestpamp.setText("Last update:");
        jlTimestpamp.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel8.add(jlTimestpamp);

        jtfTimestamp.setEditable(false);
        jtfTimestamp.setText("01/01/2000 00:00:00 -0000");
        jtfTimestamp.setFocusable(false);
        jtfTimestamp.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel8.add(jtfTimestamp);

        jlTimestampExample.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jlTimestampExample);

        jPanel4.add(jPanel8);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbClear.setText("Clear");
        jbClear.setPreferredSize(new java.awt.Dimension(75, 23));
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });
        jPanel2.add(jbClear);

        jbSave.setText("Save");
        jbSave.setPreferredSize(new java.awt.Dimension(75, 23));
        jbSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSaveActionPerformed(evt);
            }
        });
        jPanel2.add(jbSave);

        jbClose.setText("Close");
        jbClose.setPreferredSize(new java.awt.Dimension(75, 23));
        jbClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCloseActionPerformed(evt);
            }
        });
        jPanel2.add(jbClose);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-616)/2, (screenSize.height-413)/2, 616, 413);
    }// </editor-fold>//GEN-END:initComponents

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        actionClear();
    }//GEN-LAST:event_jbClearActionPerformed

    private void jbSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSaveActionPerformed
        actionSave();
    }//GEN-LAST:event_jbSaveActionPerformed

    private void jbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCloseActionPerformed
        actionClose();
    }//GEN-LAST:event_jbCloseActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        windowClosing();
    }//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SSetupApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbSave;
    private javax.swing.JComboBox<SGuiItem> jcbDatabaseType;
    private javax.swing.JLabel jlDatabaseClientExample;
    private javax.swing.JLabel jlDatabaseHostClient;
    private javax.swing.JLabel jlDatabaseHostServer;
    private javax.swing.JLabel jlDatabaseName;
    private javax.swing.JLabel jlDatabaseNameExample;
    private javax.swing.JLabel jlDatabasePassword1;
    private javax.swing.JLabel jlDatabasePassword1Example;
    private javax.swing.JLabel jlDatabasePassword2;
    private javax.swing.JLabel jlDatabasePassword2Example;
    private javax.swing.JLabel jlDatabaseServerExample;
    private javax.swing.JLabel jlDatabaseType;
    private javax.swing.JLabel jlDatabaseTypeExample;
    private javax.swing.JLabel jlDatabaseUser;
    private javax.swing.JLabel jlDatabaseUserExample;
    private javax.swing.JLabel jlErpHost;
    private javax.swing.JLabel jlErpHostExample;
    private javax.swing.JLabel jlErpInstance;
    private javax.swing.JLabel jlErpInstanceExample;
    private javax.swing.JLabel jlErpRmiRegistryPort;
    private javax.swing.JLabel jlErpRmiRegistryPortExample;
    private javax.swing.JLabel jlSeparatorClient;
    private javax.swing.JLabel jlSeparatorServer;
    private javax.swing.JLabel jlTimestampExample;
    private javax.swing.JLabel jlTimestpamp;
    private javax.swing.JPasswordField jpfDatabasePassword1;
    private javax.swing.JPasswordField jpfDatabasePassword2;
    private javax.swing.JTextField jtfDatabaseHostClient;
    private javax.swing.JTextField jtfDatabaseHostServer;
    private javax.swing.JTextField jtfDatabaseName;
    private javax.swing.JTextField jtfDatabasePortClient;
    private javax.swing.JTextField jtfDatabasePortServer;
    private javax.swing.JTextField jtfDatabaseUser;
    private javax.swing.JTextField jtfErpHost;
    private javax.swing.JTextField jtfErpInstance;
    private javax.swing.JTextField jtfErpRmiRegistryPort;
    private javax.swing.JTextField jtfTimestamp;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        mbFirstActivation = true;
        moParamsApp = new SParamsApp();

        if (moParamsApp.read()) {
            jbClear.setText("Revert");
        }
        else {
            moParamsApp = null;
            jbClear.setText("Clear");
        }

        jcbDatabaseType.removeAllItems();
        jcbDatabaseType.addItem(new SGuiItem(new int[] { SLibConsts.UNDEFINED }, "(Select database type)"));
        jcbDatabaseType.addItem(new SGuiItem(new int[] { SDbConsts.DBMS_MYSQL }, "MySQL"));

        renderParams();
    }

    private void windowActivated() {
        if (mbFirstActivation) {
            mbFirstActivation = false;
            jtfErpInstance.requestFocus();
        }
    }

    private void windowClosing() {
        actionClose();
    }

    private void renderParams() {
        if (moParamsApp == null) {
            jtfErpInstance.setText("");
            jtfErpHost.setText("");
            jtfErpRmiRegistryPort.setText("");
            jtfDatabaseHostServer.setText("");
            jtfDatabasePortServer.setText("");
            jtfDatabaseHostClient.setText("");
            jtfDatabasePortClient.setText("");
            jtfDatabaseName.setText("");
            jtfDatabaseUser.setText("");
            jpfDatabasePassword1.setText("");
            jpfDatabasePassword2.setText("");
            jtfTimestamp.setText("");
            SGuiUtils.locateItem(jcbDatabaseType, new int[] { SLibConsts.UNDEFINED });
        }
        else {
            jtfErpInstance.setText(moParamsApp.getErpInstance());
            jtfErpHost.setText(moParamsApp.getErpHost());
            jtfErpRmiRegistryPort.setText(moParamsApp.getErpRmiRegistryPort());
            jtfDatabaseHostServer.setText(moParamsApp.getDatabaseHostSrv());
            jtfDatabasePortServer.setText(moParamsApp.getDatabasePortSrv());
            jtfDatabaseHostClient.setText(moParamsApp.getDatabaseHostClt());
            jtfDatabasePortClient.setText(moParamsApp.getDatabasePortClt());
            jtfDatabaseName.setText(moParamsApp.getDatabaseName());
            jtfDatabaseUser.setText(moParamsApp.getDatabaseUser());
            jpfDatabasePassword1.setText(moParamsApp.getDatabasePswd());
            jpfDatabasePassword2.setText(moParamsApp.getDatabasePswd());
            jtfTimestamp.setText(SLibUtils.DateFormatDatetimeTimeZone.format(moParamsApp.getTimestamp()));
            SGuiUtils.locateItem(jcbDatabaseType, new int[] { moParamsApp.getDatabaseType() });
        }
    }

    private boolean canClose() {
        boolean canClose = true;
        boolean hasChanges = false;

        if (moParamsApp == null) {
            if (jtfErpInstance.getText().length() != 0 ||
                    jtfErpHost.getText().length() != 0 ||
                    jtfErpRmiRegistryPort.getText().length() != 0 ||
                    jtfDatabaseHostServer.getText().length() != 0 ||
                    jtfDatabasePortServer.getText().length() != 0 ||
                    jtfDatabaseHostClient.getText().length() != 0 ||
                    jtfDatabasePortClient.getText().length() != 0 ||
                    jtfDatabaseName.getText().length() != 0 ||
                    jtfDatabaseUser.getText().length() != 0 ||
                    jpfDatabasePassword1.getPassword().length != 0 ||
                    jpfDatabasePassword2.getPassword().length != 0 ||
                    jcbDatabaseType.getSelectedIndex() != 0) {
                hasChanges = true;
            }
        }
        else {
            if (moParamsApp.getErpInstance().compareTo(jtfErpInstance.getText()) != 0 ||
                    moParamsApp.getErpHost().compareTo(jtfErpHost.getText()) != 0 ||
                    moParamsApp.getErpRmiRegistryPort().compareTo(jtfErpRmiRegistryPort.getText()) != 0 ||
                    moParamsApp.getDatabaseHostSrv().compareTo(jtfDatabaseHostServer.getText()) != 0 ||
                    moParamsApp.getDatabasePortSrv().compareTo(jtfDatabasePortServer.getText()) != 0 ||
                    moParamsApp.getDatabaseHostClt().compareTo(jtfDatabaseHostClient.getText()) != 0 ||
                    moParamsApp.getDatabasePortClt().compareTo(jtfDatabasePortClient.getText()) != 0 ||
                    moParamsApp.getDatabaseName().compareTo(jtfDatabaseName.getText()) != 0 ||
                    moParamsApp.getDatabaseUser().compareTo(jtfDatabaseUser.getText()) != 0 ||
                    moParamsApp.getDatabasePswd().compareTo(new String(jpfDatabasePassword1.getPassword())) != 0 ||
                    moParamsApp.getDatabasePswd().compareTo(new String(jpfDatabasePassword2.getPassword())) != 0 ||
                    moParamsApp.getDatabaseType() != ((SGuiItem) jcbDatabaseType.getSelectedItem()).getPrimaryKey()[0]) {
                hasChanges = true;
            }
        }

        if (hasChanges) {
            if (JOptionPane.showConfirmDialog(this, "Configuration parameters have changed.\n¿Do you want to keep the changes?", "Confirm", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                canClose = true;
            }
            else {
                canClose = actionSave();
            }
        }

        return canClose;
    }

    private void actionClear() {
        renderParams();
        jtfErpInstance.requestFocus();
    }

    private boolean actionSave() {
        boolean save = false;
        boolean isNew = false;
        String password1 = new String(jpfDatabasePassword1.getPassword());
        String password2 = new String(jpfDatabasePassword2.getPassword());

        jtfErpInstance.setText(SLibUtils.textTrim(jtfErpInstance.getText()).toUpperCase());
        jtfErpHost.setText(SLibUtils.textTrim(jtfErpHost.getText()).toLowerCase());
        jtfErpRmiRegistryPort.setText(SLibUtils.textTrim(jtfErpRmiRegistryPort.getText()));
        jtfDatabaseHostServer.setText(SLibUtils.textTrim(jtfDatabaseHostServer.getText()).toLowerCase());
        jtfDatabasePortServer.setText(SLibUtils.textTrim(jtfDatabasePortServer.getText()));
        jtfDatabaseHostClient.setText(SLibUtils.textTrim(jtfDatabaseHostClient.getText()).toLowerCase());
        jtfDatabasePortClient.setText(SLibUtils.textTrim(jtfDatabasePortClient.getText()));
        jtfDatabaseName.setText(SLibUtils.textTrim(jtfDatabaseName.getText()));
        jtfDatabaseUser.setText(SLibUtils.textTrim(jtfDatabaseUser.getText()));

        if (jtfErpInstance.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlErpInstance) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfErpInstance.requestFocus();
        }
        else if (jtfErpInstance.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlErpInstance) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfErpInstance.requestFocus();
        }
        else if (jtfErpHost.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlErpHost) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfErpHost.requestFocus();
        }
        else if (jtfErpHost.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlErpHost) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfErpHost.requestFocus();
        }
        else if (jtfErpRmiRegistryPort.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlErpRmiRegistryPort) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfErpRmiRegistryPort.requestFocus();
        }
        else if (jtfErpRmiRegistryPort.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlErpRmiRegistryPort) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfErpRmiRegistryPort.requestFocus();
        }
        else if (jcbDatabaseType.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseType) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jcbDatabaseType.requestFocus();
        }
        else if (jtfDatabaseHostServer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseHostServer) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseHostServer.requestFocus();
        }
        else if (jtfDatabaseHostServer.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlDatabaseHostServer) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseHostServer.requestFocus();
        }
        else if (jtfDatabasePortServer.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseHostServer) + " (" + jtfDatabasePortServer.getToolTipText() + ")'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabasePortServer.requestFocus();
        }
        else if (jtfDatabasePortServer.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlDatabaseHostServer) + " (" + jtfDatabasePortServer.getToolTipText() + ")' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabasePortServer.requestFocus();
        }
        else if (jtfDatabaseHostClient.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseHostClient) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseHostClient.requestFocus();
        }
        else if (jtfDatabaseHostClient.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlDatabaseHostClient) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseHostClient.requestFocus();
        }
        else if (jtfDatabasePortClient.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseHostClient) + " (" + jtfDatabasePortClient.getToolTipText() + ")'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabasePortClient.requestFocus();
        }
        else if (jtfDatabasePortClient.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlDatabaseHostClient) + " (" + jtfDatabasePortClient.getToolTipText() + ")' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabasePortClient.requestFocus();
        }
        else if (jtfDatabaseName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseName) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseName.requestFocus();
        }
        else if (jtfDatabaseName.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlDatabaseName) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseName.requestFocus();
        }
        else if (jtfDatabaseUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabaseUser) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseUser.requestFocus();
        }
        else if (jtfDatabaseUser.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + SGuiUtils.getLabelName(jlDatabaseUser) + "' cannot contain blank spaces.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jtfDatabaseUser.requestFocus();
        }
        else if (password1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabasePassword1) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jpfDatabasePassword1.requestFocus();
        }
        else if (password2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + SGuiUtils.getLabelName(jlDatabasePassword2) + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jpfDatabasePassword2.requestFocus();
        }
        else if (password1.compareTo(password2) != 0) {
            JOptionPane.showMessageDialog(this, "Value for fields '" + SGuiUtils.getLabelName(jlDatabasePassword1) + "' and '" + SGuiUtils.getLabelName(jlDatabasePassword2) + "' must be the same.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
            jpfDatabasePassword1.requestFocus();
        }
        else {
            try {
                if (moParamsApp == null) {
                    isNew = true;
                    moParamsApp = new SParamsApp();
                }

                moParamsApp.setErpInstance(jtfErpInstance.getText());
                moParamsApp.setErpHost(jtfErpHost.getText());
                moParamsApp.setErpRmiRegistryPort(jtfErpRmiRegistryPort.getText());
                moParamsApp.setDatabaseHostSrv(jtfDatabaseHostServer.getText());
                moParamsApp.setDatabasePortSrv(jtfDatabasePortServer.getText());
                moParamsApp.setDatabaseHostClt(jtfDatabaseHostClient.getText());
                moParamsApp.setDatabasePortClt(jtfDatabasePortClient.getText());
                moParamsApp.setDatabaseName(jtfDatabaseName.getText());
                moParamsApp.setDatabaseUser(jtfDatabaseUser.getText());
                moParamsApp.setDatabasePswd(password1);
                moParamsApp.setDatabaseType(((SGuiItem) jcbDatabaseType.getSelectedItem()).getPrimaryKey()[0]);
                if (moParamsApp.save()) {
                    save = true;
                    renderParams();
                    jbClose.requestFocus();
                }
            }
            catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            finally {
                if (isNew && !save) {
                    moParamsApp = null;
                }
            }
        }

        return save;
    }

    private void actionClose() {
        if (canClose()) {
            dispose();
        }
    }
}
