/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SPanelFilterItemGeneric.java
 *
 * Created on 26/09/2011, 12:15:00 PM
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.table.STableConstants;
import erp.lib.table.STableSetting;
import erp.mfin.data.SDataAccount;

/**
 *
 * @author Juan Barajas
 */
public class SPanelFilterAccount extends javax.swing.JPanel {

    private erp.client.SClientInterface miClient;
    private erp.lib.form.SFormOptionPickerInterface picker;
    private erp.lib.table.STableTab moTableTab;
    private erp.mfin.data.SDataAccount moAcc;



    /** Creates new form SPanelFilterItemGeneric */
    public SPanelFilterAccount(erp.client.SClientInterface client, erp.lib.table.STableTab tableTab) {
        miClient = client;
        moTableTab = tableTab;

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

        jtfAccount = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 0));

        jtfAccount.setEditable(false);
        jtfAccount.setText("CUENTA CONTABLE");
        jtfAccount.setToolTipText("Cuenta Contable");
        jtfAccount.setFocusable(false);
        jtfAccount.setPreferredSize(new java.awt.Dimension(150, 23));
        add(jtfAccount);

        jButton1.setText("...");
        jButton1.setToolTipText("Seleccionar cuenta");
        jButton1.setPreferredSize(new java.awt.Dimension(23, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        actionItem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void initComponentsExtra() {
        picker = miClient.getOptionPicker(SDataConstants.FIN_ACC);
        picker.formReset();
        picker.formRefreshOptionPane();
        jtfAccount.setText("");
    }

    private void actionItem() {
        String nIdAcc = "";
        picker.setFormVisible(true);

        if (picker.getFormResult() == SLibConstants.FORM_RESULT_OK) {
           moAcc = (SDataAccount) SDataUtilities.readRegistry(miClient, SDataConstants.FIN_ACC, picker.getSelectedPrimaryKey(), SLibConstants.EXEC_MODE_VERBOSE);
           nIdAcc = moAcc.getPkAccountIdXXX();
           jtfAccount.setText(nIdAcc);
           moTableTab.updateSetting(new STableSetting(STableConstants.SETTING_FILTER_ACCOUNT, moAcc ));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jtfAccount;
    // End of variables declaration//GEN-END:variables

}
