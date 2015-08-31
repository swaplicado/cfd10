/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDatabaseFix.java
 *
 * Created on 9/11/2009, 05:05:51 PM
 */

package erp;

import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.data.SDataDatabase;
import erp.lib.form.SFormComponentItem;
import java.awt.Cursor;
import java.awt.event.ItemEvent;
import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.TimeZone;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio Flores
 */
public class SDatabaseFix extends javax.swing.JFrame implements java.awt.event.ItemListener {

    private boolean mbIsFirstActivation;
    private erp.lib.data.SDataDatabase moDatabase;

    /** Creates new form SDatabaseFix */
    public SDatabaseFix() {
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlDatabaseType = new javax.swing.JLabel();
        jcbDatabaseType = new javax.swing.JComboBox<SFormComponentItem>();
        jlDummy01 = new javax.swing.JLabel();
        jlDabaseHost = new javax.swing.JLabel();
        jtfDatabaseHost = new javax.swing.JTextField();
        jlDatabaseHostExample = new javax.swing.JLabel();
        jlDabasePort = new javax.swing.JLabel();
        jtfDatabasePort = new javax.swing.JTextField();
        jlDatabasePortExample = new javax.swing.JLabel();
        jlDabaseName = new javax.swing.JLabel();
        jtfDatabaseName = new javax.swing.JTextField();
        jlDatabaseNameExample = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jspOutput = new javax.swing.JScrollPane();
        jtaOutput = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jbClear = new javax.swing.JButton();
        jbFix = new javax.swing.JButton();
        jbClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ERP Server Setup");
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

        jPanel1.setLayout(new java.awt.GridLayout(4, 3, 5, 1));

        jlDatabaseType.setText("Database type: *");
        jPanel1.add(jlDatabaseType);

        jcbDatabaseType.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel1.add(jcbDatabaseType);
        jPanel1.add(jlDummy01);

        jlDabaseHost.setText("Database host: *");
        jPanel1.add(jlDabaseHost);

        jtfDatabaseHost.setText("127.0.0.1");
        jtfDatabaseHost.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel1.add(jtfDatabaseHost);

        jlDatabaseHostExample.setText("(e.g. 127.0.0.1)");
        jPanel1.add(jlDatabaseHostExample);

        jlDabasePort.setText("Database port: *");
        jPanel1.add(jlDabasePort);

        jtfDatabasePort.setText("3306");
        jtfDatabasePort.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel1.add(jtfDatabasePort);

        jlDatabasePortExample.setText("(e.g. 3306)");
        jPanel1.add(jlDatabasePortExample);

        jlDabaseName.setText("Database name: *");
        jPanel1.add(jlDabaseName);

        jtfDatabaseName.setText("co");
        jtfDatabaseName.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel1.add(jtfDatabaseName);

        jlDatabaseNameExample.setText("(e.g. co)");
        jPanel1.add(jlDatabaseNameExample);

        jPanel3.add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Script output:");
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jLabel1, java.awt.BorderLayout.NORTH);

        jtaOutput.setColumns(20);
        jtaOutput.setEditable(false);
        jtaOutput.setRows(5);
        jtaOutput.setText("Output messages...");
        jspOutput.setViewportView(jtaOutput);

        jPanel4.add(jspOutput, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

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

        jbFix.setText("Fix");
        jbFix.setPreferredSize(new java.awt.Dimension(75, 23));
        jbFix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFixActionPerformed(evt);
            }
        });
        jPanel2.add(jbFix);

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
        setBounds((screenSize.width-500)/2, (screenSize.height-375)/2, 500, 375);
    }// </editor-fold>//GEN-END:initComponents

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        actionClear();
    }//GEN-LAST:event_jbClearActionPerformed

    private void jbFixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFixActionPerformed
        actionFix();
    }//GEN-LAST:event_jbFixActionPerformed

    private void jbCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCloseActionPerformed
        actionClose();
    }//GEN-LAST:event_jbCloseActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (mbIsFirstActivation) {
            mbIsFirstActivation = false;
            jcbDatabaseType.requestFocus();
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        actionClose();
    }//GEN-LAST:event_formWindowClosing

    private void initComponentsExtra() {
        TimeZone.setDefault(SLibTimeUtilities.SysTimeZone);

        mbIsFirstActivation = true;

        jcbDatabaseType.removeAllItems();
        jcbDatabaseType.addItem(new SFormComponentItem(new int[] { SLibConstants.UNDEFINED }, "(Select database type)"));
        jcbDatabaseType.addItem(new SFormComponentItem(new int[] { SLibConstants.DBMS_MY_SQL }, "MySQL"));

        jcbDatabaseType.addItemListener(this);

        actionClear();
    }

    private void actionClear() {
        jcbDatabaseType.setSelectedIndex(0);
        jtfDatabaseHost.setText("");
        jtfDatabasePort.setText("");
        jtfDatabaseName.setText("");
        jtaOutput.setText("");
        jcbDatabaseType.requestFocus();
    }

    private void itemStateDatabaseType() {
        if (jcbDatabaseType.getSelectedItem() != null && jcbDatabaseType.getSelectedItem() instanceof SFormComponentItem) {
            if (jtfDatabasePort.getText().trim().length() == 0) {
                if (((int[]) ((SFormComponentItem) jcbDatabaseType.getSelectedItem()).getPrimaryKey())[0] == SLibConstants.DBMS_MY_SQL) {
                    jtfDatabasePort.setText("3306");
                }
            }
        }
    }

    private void fix001(java.sql.Statement statement) throws java.lang.Exception {
        int[] results = null;
        String sql = "";
        String line = "";
        File[] files = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        Vector<String> sentences = new Vector<String>();

        files = new File[1];
        files[0] = new File("C:\\Archivos de programa\\Software Aplicado\\SIIE 2.0\\scripts\\trn_dps_save.001.sql");

        for (File file : files) {
            if (!file.exists()) {
                throw new Exception("File '" + file.getPath() + "' does not exist!");
            }
        }

        // Update database structure:

        jtaOutput.append("\n\nUpdating database structure...");

        statement.clearBatch();
        statement.addBatch("ALTER TABLE trn_dps ADD COLUMN b_rec_aut BOOLEAN NOT NULL AFTER b_authorn ");
        statement.addBatch("UPDATE trn_dps SET b_rec_aut = 0 WHERE b_sys = 1 ");
        statement.addBatch("UPDATE trn_dps SET b_rec_aut = 1 WHERE b_sys = 0 ");
        results = statement.executeBatch();

        for (int result : results) {
            switch (result) {
                case Statement.SUCCESS_NO_INFO:
                    jtaOutput.append("\nStatement succeed!");
                    break;
                case Statement.EXECUTE_FAILED:
                    jtaOutput.append("\nStatement failed!");
                    break;
                default:
                    jtaOutput.append("\nStatement succeed! " + result + " rows updated!");
            }
        }

        // Update store procedures:

        jtaOutput.append("\n\nUpdating store procedures...");

        for (File file : files) {
            sql = "";
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                else {
                    if (line.indexOf("DELIMITER") == -1) {
                        sql += line + "\n";

                        if (line.indexOf("$$") != -1) {
                            sentences.add(sql.substring(0, sql.indexOf("$$")));
                            sql = "";
                        }
                    }
                }
            }

            for (String sentence : sentences) {
                statement.executeUpdate(sentence);
            }
            jtaOutput.append("\nStore procedure '" + file.getName() + "' updated!");
        }
    }

    private void fix() {
        int ver = 0;
        boolean ok = false;
        String sql = "";
        String line = "";
        Statement statement = null;
        ResultSet resultSet = null;
        Cursor cursor = null;
        Vector<String> sentences = new Vector<String>();

        try {
            cursor = getCursor();
            setCursor(new Cursor(Cursor.WAIT_CURSOR));

            jtaOutput.setText("");
            jtaOutput.append("Updating database...");

            statement = moDatabase.getConnection().createStatement();
            sql = "SELECT ver FROM erp.cfg_param_erp ";
            resultSet = statement.executeQuery(sql);
            if (!resultSet.next()) {
                throw new Exception(SLibConstants.MSG_ERR_DB_QRY);
            }
            else {
                ver = resultSet.getInt("ver");
                jtaOutput.append("\nCurrent database version: " + ver);

                for (int i = ver; i <= 2; i++) {
                    jtaOutput.append("\n\n*** Version " + i + " ***");

                    switch (i) {
                        case 1:
                            fix001(statement);
                            break;
                        default:
                    }

                    // Update fix timestamp:

                    jtaOutput.append("\n\nUpdating fix timestamp...");

                    sql = "UPDATE erp.cfg_param_erp SET ver = " + i + ", ts_ver = now(); ";
                    statement.execute(sql);

                    jtaOutput.append("\n\nDatabase version " + i + " update ready!");
                }

                jtaOutput.append("\n\nDatabase update ready!");
                ok = true;
            }
        }
        catch (Exception e) {
            System.err.println(e);
            jtaOutput.append("\nException thrown: " + e);
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            validate();
            jspOutput.getVerticalScrollBar().setValue(0);
            jspOutput.getHorizontalScrollBar().setValue(0);
            setCursor(cursor);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Database update process has been finished!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private boolean actionFix() {
        boolean save = false;
        jtfDatabaseHost.setText(SLibUtilities.textTrim(jtfDatabaseHost.getText()).toLowerCase());
        jtfDatabasePort.setText(SLibUtilities.textTrim(jtfDatabasePort.getText()));
        jtfDatabaseName.setText(SLibUtilities.textTrim(jtfDatabaseName.getText()));

        if (jcbDatabaseType.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + jlDatabaseType.getText() + "'.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jcbDatabaseType.requestFocus();
        }
        else if (jtfDatabaseHost.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + jlDabaseHost.getText() + "'.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jtfDatabaseHost.requestFocus();
        }
        else if (jtfDatabaseHost.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + jlDabaseHost.getText() + "' cannot contain blank spaces.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jtfDatabaseHost.requestFocus();
        }
        else if (jtfDatabasePort.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + jlDabasePort.getText() + "'.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jtfDatabasePort.requestFocus();
        }
        else if (jtfDatabasePort.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + jlDabasePort.getText() + "' cannot contain blank spaces.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jtfDatabasePort.requestFocus();
        }
        else if (jtfDatabaseName.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "A value must be provided for field '" + jlDabaseName.getText() + "'.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jtfDatabaseName.requestFocus();
        }
        else if (jtfDatabaseName.getText().indexOf(" ") != -1) {
            JOptionPane.showMessageDialog(this, "Field '" + jlDabaseName.getText() + "' cannot contain blank spaces.", "Warning!", JOptionPane.WARNING_MESSAGE);
            jtfDatabaseName.requestFocus();
        }
        else {
            try {
                moDatabase = null;

                switch (((int[]) ((SFormComponentItem) jcbDatabaseType.getSelectedItem()).getPrimaryKey())[0]) {
                    case SLibConstants.DBMS_MY_SQL:
                        moDatabase = new SDataDatabase(SLibConstants.DBMS_MY_SQL);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION, "Warning!", JOptionPane.WARNING_MESSAGE);
                }

                if (moDatabase != null) {
                    if (moDatabase.connect(jtfDatabaseHost.getText(), jtfDatabasePort.getText(), jtfDatabaseName.getText(), "root", "msroot") != SLibConstants.DB_CONNECTION_OK) {
                        JOptionPane.showMessageDialog(this, SLibConstants.MSG_ERR_DB_CON, "Warning!", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        fix();
                    }
                }
            }
            catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return save;
    }

    private void actionClose() {
        dispose();
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SDatabaseFix().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbFix;
    private javax.swing.JComboBox<SFormComponentItem> jcbDatabaseType;
    private javax.swing.JLabel jlDabaseHost;
    private javax.swing.JLabel jlDabaseName;
    private javax.swing.JLabel jlDabasePort;
    private javax.swing.JLabel jlDatabaseHostExample;
    private javax.swing.JLabel jlDatabaseNameExample;
    private javax.swing.JLabel jlDatabasePortExample;
    private javax.swing.JLabel jlDatabaseType;
    private javax.swing.JLabel jlDummy01;
    private javax.swing.JScrollPane jspOutput;
    private javax.swing.JTextArea jtaOutput;
    private javax.swing.JTextField jtfDatabaseHost;
    private javax.swing.JTextField jtfDatabaseName;
    private javax.swing.JTextField jtfDatabasePort;
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JComboBox) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                JComboBox comboBox = (JComboBox) e.getSource();

                if (comboBox == jcbDatabaseType) {
                    itemStateDatabaseType();
                }
            }
        }
    }
}
