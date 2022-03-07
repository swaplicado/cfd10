/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepAdv.java
 *
 * Created on 02/03/2022, 04:37:26 PM
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComponent;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Isabel Servín
 */
public final class SDialogRepAdv extends javax.swing.JDialog implements java.awt.event.ActionListener {

    private erp.client.SClientInterface miClient;
    boolean mbFirstTime;

    
    private java.util.Vector<erp.lib.form.SFormField> mvFields;

    private erp.lib.form.SFormField moFieldCurrency;
    
    
    /** Creates new form SDialogRepBizPartnerBalanceDpsCollection
     * @param client
     
     */
    public SDialogRepAdv(erp.client.SClientInterface client) {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel98 = new javax.swing.JPanel();
        jlCurrency = new javax.swing.JLabel();
        jcbCurrency = new javax.swing.JComboBox<SFormComponentItem>();
        jbPickCurrency = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpPrint = new javax.swing.JButton();
        jpClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de cobranza");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del reporte:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setLayout(new java.awt.BorderLayout(0, 5));
        jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel98.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCurrency.setText("Moneda: *");
        jlCurrency.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel98.add(jlCurrency);

        jcbCurrency.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel98.add(jcbCurrency);

        jbPickCurrency.setText("...");
        jbPickCurrency.setToolTipText("Seleccionar moneda");
        jbPickCurrency.setFocusable(false);
        jbPickCurrency.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel98.add(jbPickCurrency);

        jPanel2.add(jPanel98, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jpPrint.setText("Imprimir");
        jpPrint.setToolTipText("[Ctrl + Enter]");
        jpPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        jpPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpPrintActionPerformed(evt);
            }
        });
        jPanel1.add(jpPrint);

        jpClose.setText("Cerrar");
        jpClose.setToolTipText("[Escape]");
        jpClose.setPreferredSize(new java.awt.Dimension(75, 23));
        jpClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpCloseActionPerformed(evt);
            }
        });
        jPanel1.add(jpClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(500, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jpPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpPrintActionPerformed
        actionPrint();
    }//GEN-LAST:event_jpPrintActionPerformed

    private void jpCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpCloseActionPerformed
        actionClose();
    }//GEN-LAST:event_jpCloseActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        moFieldCurrency = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbCurrency, jlCurrency);
        moFieldCurrency.setPickerButton(jbPickCurrency);

        mvFields = new Vector<>();
        mvFields.add(moFieldCurrency);

        resetForm();

        setModalityType(ModalityType.MODELESS);
        SFormUtilities.createActionMap(rootPane, this, "actionPrint", "print", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionClose", "close", KeyEvent.VK_ESCAPE, 0);
        
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jcbCurrency.requestFocus();
        }
    }

    private void print() {
        Cursor cursor = getCursor();
        Map<String, Object> map;
        JasperPrint jasperPrint;
        JasperViewer jasperViewer;
        
        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));

            map = miClient.createReportParams();
            
            map.put("nCurrencyId", moFieldCurrency.getKeyAsIntArray()[0]);
            map.put("sCurrencyKey", jcbCurrency.getSelectedItem().toString());
            map.put("tDate", miClient.getSession().getCurrentDate());

            jasperPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_TRN_ADV, map);
            jasperViewer = new JasperViewer(jasperPrint, false);
            jasperViewer.setTitle(getTitle());
            jasperViewer.setVisible(true);
        }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }
        finally {
            setCursor(cursor);
        }
    }

    public void actionPrint() {
        boolean error = false;
        JComponent component = null;

        for (SFormField field : mvFields) {
            if (!field.validateField()) {
                error = true;
                component = field.getComponent();
            }
        }

        if (error) {
            if (component != null) {
                component.requestFocus();
            }
        }
        else {
            print();
        }
    }

    public void actionClose() {
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel98;
    private javax.swing.JButton jbPickCurrency;
    private javax.swing.JComboBox<SFormComponentItem> jcbCurrency;
    private javax.swing.JLabel jlCurrency;
    private javax.swing.JButton jpClose;
    private javax.swing.JButton jpPrint;
    // End of variables declaration//GEN-END:variables

    public void resetForm() {
        mbFirstTime = true;
        SFormUtilities.populateComboBox(miClient, jcbCurrency, SDataConstants.CFGU_CUR);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
     
        }
    }
}
