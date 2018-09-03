/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp;

import erp.lib.SLibConstants;
import erp.lib.data.SDataDatabase;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import sa.lib.gui.SGuiConsts;

/**
 *
 * @author Antonio Ortega
 */
public class SUtilMigrateXml extends javax.swing.JFrame {

    private erp.lib.data.SDataDatabase moDbMySqlSiie;
    private final ArrayList<JTextField> maTextFields = new ArrayList<>();

    /**
     * Creates new form SUtilMigrateXml
     */
    public SUtilMigrateXml() {
        initComponents();
        initComponentsCustom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlDatabaseHost = new javax.swing.JLabel();
        jtfDatabaseHost = new javax.swing.JTextField();
        jlDatabasePort = new javax.swing.JLabel();
        jtfDatabasePort = new javax.swing.JTextField();
        jlDatabaseServerExample = new javax.swing.JLabel();
        jlDatabaseName = new javax.swing.JLabel();
        jtfDatabaseName = new javax.swing.JTextField();
        jlDatabaseUser = new javax.swing.JLabel();
        jtfDatabaseUser = new javax.swing.JTextField();
        jlDatabasePswd = new javax.swing.JLabel();
        jtfDatabasePswd = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jbMigrate = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Migrate XML files to BaseX");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Company Database Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jlDatabaseHost.setText("Host:");

        jtfDatabaseHost.setToolTipText("Database Host");

        jlDatabasePort.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatabasePort.setText("Port:");
        jlDatabasePort.setPreferredSize(new java.awt.Dimension(5, 23));

        jtfDatabasePort.setText("3306");
        jtfDatabasePort.setToolTipText("Database Port");
        jtfDatabasePort.setPreferredSize(new java.awt.Dimension(50, 23));

        jlDatabaseServerExample.setText("(e.g. 127.0.0.1 : 3306)");
        jlDatabaseServerExample.setPreferredSize(new java.awt.Dimension(150, 23));

        jlDatabaseName.setText("Name:");

        jtfDatabaseName.setToolTipText("Database Name");

        jlDatabaseUser.setText("User:");

        jtfDatabaseUser.setToolTipText("Database User");

        jlDatabasePswd.setText("Password:");

        jtfDatabasePswd.setToolTipText("Database Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDatabaseHost)
                            .addComponent(jlDatabaseName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfDatabaseName, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jtfDatabaseHost, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlDatabasePort, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDatabasePort, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlDatabaseServerExample, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlDatabaseUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfDatabaseUser, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlDatabasePswd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfDatabasePswd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlDatabaseServerExample, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlDatabaseHost)
                            .addComponent(jtfDatabaseHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlDatabasePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfDatabasePort, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatabaseName)
                    .addComponent(jtfDatabaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatabaseUser)
                    .addComponent(jtfDatabaseUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDatabasePswd)
                    .addComponent(jtfDatabasePswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbMigrate.setText("Migrate");
        jbMigrate.setPreferredSize(new java.awt.Dimension(100, 23));
        jbMigrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMigrateActionPerformed(evt);
            }
        });

        jbCancel.setText("Cancel");
        jbCancel.setPreferredSize(new java.awt.Dimension(100, 23));
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbMigrate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMigrate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMigrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMigrateActionPerformed
        actionMigrate();
    }//GEN-LAST:event_jbMigrateActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        actionCancel();
    }//GEN-LAST:event_jbCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SUtilMigrateXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SUtilMigrateXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SUtilMigrateXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SUtilMigrateXml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SUtilMigrateXml().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbMigrate;
    private javax.swing.JLabel jlDatabaseHost;
    private javax.swing.JLabel jlDatabaseName;
    private javax.swing.JLabel jlDatabasePort;
    private javax.swing.JLabel jlDatabasePswd;
    private javax.swing.JLabel jlDatabaseServerExample;
    private javax.swing.JLabel jlDatabaseUser;
    private javax.swing.JTextField jtfDatabaseHost;
    private javax.swing.JTextField jtfDatabaseName;
    private javax.swing.JTextField jtfDatabasePort;
    private javax.swing.JPasswordField jtfDatabasePswd;
    private javax.swing.JTextField jtfDatabaseUser;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        moDbMySqlSiie = new SDataDatabase(SLibConstants.DBMS_MY_SQL);

        maTextFields.add(jtfDatabaseHost);
        maTextFields.add(jtfDatabasePort);
        maTextFields.add(jtfDatabaseName);
        maTextFields.add(jtfDatabaseUser);
        maTextFields.add(jtfDatabasePswd);
    }

    private boolean validateFields() {
        boolean isValid = true;

        for (JTextField textField : maTextFields) {
            textField.setText(textField.getText().trim());
            if (textField.getText().isEmpty()) {
                isValid = false;
                JOptionPane.showMessageDialog(this, "Falta un valor para el campo '" + textField.getToolTipText() + "'.", SGuiConsts.MSG_BOX_WARNING, JOptionPane.WARNING_MESSAGE);
                textField.requestFocus();
                break;
            }
        }

        return isValid;
    }

    private void actionMigrate() {
        if (validateFields()) {
            ArrayList<String> badFilesIDs = new ArrayList<>();
            ArrayList<String> emptyEntriesIDs = new ArrayList<>();

            long totalFiles = 0;

            try {
                final String databaseHost = jtfDatabaseHost.getText();
                final String databasePort = jtfDatabasePort.getText();
                final String databaseName = jtfDatabaseName.getText();
                final String databaseUser = jtfDatabaseUser.getText();
                final String databasePswd = new String(jtfDatabasePswd.getPassword());

                // Company MySQL database connection:
                moDbMySqlSiie.connect(databaseHost, databasePort, databaseName, databaseUser, databasePswd);

                // Company BaseX database connection:
                SBaseXClient baseXSession = SBaseXUtils.getBaseXSessionInstance(databaseHost, 1984, "admin", "admin");

                // Create BaseX database if needed:
                final String createBaseXDBQuery
                        = "if(not(db:exists(\"" + databaseName + "\")))\n"
                        + "  then\n"
                        + "      db:create(\"" + databaseName + "\")\n"
                        + "  else ()";
                SBaseXUtils.executeBaseXQuery(baseXSession, createBaseXDBQuery);

                // Select relevant document data from MySQL database:  
                final String cfdQuery = "SELECT id_cfd, doc_xml FROM trn_cfd WHERE doc_xml_uuid = '' ORDER BY id_cfd;";

                Statement statement = moDbMySqlSiie.getConnection().createStatement();
                ResultSet resultSet = moDbMySqlSiie.getConnection().createStatement().executeQuery(cfdQuery);

                while (resultSet.next()) {
                    totalFiles++;

                    System.out.println("Processing file " + totalFiles);

                    String cfdId = resultSet.getString("id_cfd");
                    String xmlDocBody = resultSet.getString("doc_xml");
                    String xmlUuid = SBaseXUtils.generateUniqueXmlId(moDbMySqlSiie.getConnection());

                    if (!xmlDocBody.isEmpty()) {
                        // check body for illegal XML unicode characters, if found skip document.
                        if (StringUtils.containsAny(xmlDocBody, "\u009D\u001F\u0019\u0016\u001C\u0007\u0018\u0012\u001B\u0015\uFFFD")) {
                            badFilesIDs.add(cfdId);
                            continue;
                        }

                        // escape XML special characters.
                        xmlDocBody = SBaseXUtils.escapeSpecialCharacters(xmlDocBody);

                        // Parse the xml body and add it to the BaseX database.
                        String addXmlToDBQuery
                                = "db:replace(\"" + databaseName + "\", \"/" + xmlUuid + ".xml" + "\", fn:parse-xml(\"" + xmlDocBody + "\"))";
                        try {
                            SBaseXUtils.executeBaseXQuery(baseXSession, addXmlToDBQuery);
                        } catch (IOException e) {
                            // File could not be parsed, add it to malformed files array and continue with the next.
                            badFilesIDs.add(cfdId);
                            SBaseXUtils.logError("MIGRATION ERROR - " + e.toString());
                            continue;
                        }

                        String updateNodeIdQuery = "UPDATE trn_cfd SET doc_xml_uuid = '" + xmlUuid + "' WHERE id_cfd = " + cfdId + ";";
                        statement.executeUpdate(updateNodeIdQuery);
                    }
                    else {
                        // Register empty document entry.
                        emptyEntriesIDs.add(cfdId);
                    }
                }

                System.out.println("\nMigration output data: \n"
                        + "Total entries processed: " + totalFiles + "\n"
                        + "Entries with malformed XML files: " + badFilesIDs.size() + " Files, with database IDs: " + badFilesIDs.toString() + "\n"
                        + "Entries with empty XML files: " + emptyEntriesIDs.size() + " Entries, with database IDs: " + emptyEntriesIDs.toString() + "\n");

                boolean hadErrors = badFilesIDs.size() > 0 | emptyEntriesIDs.size() > 0;
                String message = hadErrors ? "Migration ended with warnings, check console output" : "Migration completed successfully";

                JOptionPane.showMessageDialog(this, message, "Info", hadErrors ? JOptionPane.WARNING_MESSAGE : JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                SBaseXUtils.logError("Export ERROR - " + ExceptionUtils.getStackTrace(e));
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void actionCancel() {
        dispose();
    }
}
