/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogUtilFiscalYearOpening.java
 *
 * Created on 7/12/2010, 04:30:30 PM
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.mfin.data.SDataFiscalYearOpening;
import java.awt.Cursor;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sergio Flores
 */
public class SDialogUtilFiscalYearOpening extends javax.swing.JDialog {

    private int mnFormResult;
    private boolean mbFirstTime;

    private erp.client.SClientInterface miClient;
    private erp.lib.form.SFormField moFieldYear;

    /** Creates new form SDialogUtilFiscalYearOpening */
    public SDialogUtilFiscalYearOpening(erp.client.SClientInterface client) {
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        jtfYear = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generación de saldos iniciales");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de generación de saldos iniciales:"));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(6, 1, 0, 1));

        jPanel1.setLayout(new java.awt.FlowLayout(0, 5, 0));

        jlYear.setText("Ejercicio para el que se generan saldos iniciales: *");
        jlYear.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel1.add(jlYear);

        jtfYear.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfYear.setText("0000");
        jtfYear.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel1.add(jtfYear);

        jPanel4.add(jPanel1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jPanel4.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel2.setText("Nota:");
        jPanel4.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel3.setText("Si el ejercicio que se cierra es el 2000, el valor que se debe especificar para");
        jPanel4.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel4.setText("el campo 'Ejercicio para el que se generan saldos iniciales' debe ser 2001.");
        jPanel4.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel5.setText("El proceso puede demorar varios segundos.");
        jPanel4.add(jLabel5);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(2));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        jPanel2.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-300)/2, 400, 300);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        actionOk();
    }//GEN-LAST:event_jbOkActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        actionCancel();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void initComponentsExtra() {
        moFieldYear = new SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfYear, jlYear);
        moFieldYear.setIntegerMin(2000);
        moFieldYear.setIntegerMax(2100);
        moFieldYear.setMinInclusive(true);
        moFieldYear.setMaxInclusive(true);
        moFieldYear.setDecimalFormat(miClient.getSessionXXX().getFormatters().getYearFormat());

        SFormUtilities.createActionMap(rootPane, this, "actionOk", "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionCancel", "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;

            if (miClient.getSessionXXX().getCurrentCompanyBranchId() == 0) {
                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_SESSION_BRANCH);
                actionCancel();
            }
            else {
                jtfYear.requestFocus();
            }
        }
    }

    public void actionOk() {
        Cursor cursor = null;
        SDataFiscalYearOpening fyc = null;

        if (moFieldYear.validateField()) {

            if (!SDataUtilities.isPeriodOpen(miClient, new int[] { moFieldYear.getInteger(), 1 })) {
                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_PER_CLOSE + "\nPeríodo cerrado: " + moFieldYear.getInteger() + "-01.");
            }
            else {
                try {
                    cursor = getCursor();
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));

                    fyc = new SDataFiscalYearOpening();
                    fyc.setPkYearId(moFieldYear.getInteger());
                    fyc.setPkPeriodId(1);
                    fyc.setPkBookkeepingCenterId(miClient.getSessionXXX().getCurrentCompanyBranch().getDbmsDataCompanyBranchBkc().getPkBookkepingCenterId());
                    fyc.setPkRecordTypeId(SDataConstantsSys.FINU_TP_REC_FY_OPEN);
                    fyc.setPkNumberId(1);
                    fyc.setFkCompanyBranchId(miClient.getSessionXXX().getCurrentCompanyBranchId());
                    fyc.setFkUserId(miClient.getSession().getUser().getPkUserId());
                    fyc.setAuxSimpleDateFormat(miClient.getSessionXXX().getFormatters().getDbmsDateFormat());

                    SDataUtilities.saveRegistry(miClient, fyc);
                    miClient.getGuiModule(SDataConstants.MOD_FIN).refreshCatalogues(SDataConstants.FIN_REC);
                    miClient.showMsgBoxInformation(SLibConstants.MSG_INF_PROC_FINISH);
                    actionCancel();
                }
                catch (Exception e) {
                    SLibUtilities.renderException(this, e);
                }
                finally {
                    setCursor(cursor);
                }
            }
        }
    }

    public void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlYear;
    private javax.swing.JTextField jtfYear;
    // End of variables declaration//GEN-END:variables

    public void resetForm() {
        int[] date = SLibTimeUtilities.digestDate(miClient.getSessionXXX().getWorkingDate());

        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        moFieldYear.setFieldValue(date[0]);
    }

    public int getFormResult() {
        return mnFormResult;
    }
}
