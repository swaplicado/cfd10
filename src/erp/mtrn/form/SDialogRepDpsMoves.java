/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepDpsMoves.java
 *
 * Created on 24/01/2012
 */

package erp.mtrn.form;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Vector;
import javax.swing.AbstractAction;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;

/**
 *
 * @author Juan Barajas
 */
public class SDialogRepDpsMoves extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;

     private boolean mbParamIsSupplier;

    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDateInitial;
    private erp.lib.form.SFormField moFieldDateEnd;

    /** Creates new form SDialogRepDpsMoves */
    public SDialogRepDpsMoves(erp.client.SClientInterface client) {
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

        jPanel1 = new javax.swing.JPanel();
        jbPrint = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDateInitial = new javax.swing.JLabel();
        jftDateInitial = new javax.swing.JFormattedTextField();
        jbDateInitial = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jftDateEnd = new javax.swing.JFormattedTextField();
        jbDateEnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de documentos e ingresos por cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(392, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbPrint.setText("Imprimir");
        jbPrint.setToolTipText("[Ctrl + Enter]");
        jbPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbPrint);

        jbExit.setText("Cerrar");
        jbExit.setToolTipText("[Escape]");
        jbExit.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbExit);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración del reporte:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Período:"));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 77));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateInitial.setText("Fecha inicial: *");
        jlDateInitial.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlDateInitial);

        jftDateInitial.setText("dd/mm/yyyy");
        jftDateInitial.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jftDateInitial);

        jbDateInitial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateInitial.setToolTipText("Seleccionar fecha inicial");
        jbDateInitial.setFocusable(false);
        jbDateInitial.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDateInitial);

        jPanel10.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd.setText("Fecha final: *");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlDateEnd);

        jftDateEnd.setText("dd/mm/yyyy");
        jftDateEnd.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel5.add(jftDateEnd);

        jbDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateEnd.setToolTipText("Seleccionar fecha final");
        jbDateEnd.setFocusable(false);
        jbDateEnd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbDateEnd);

        jPanel10.add(jPanel5);

        jPanel2.add(jPanel10, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-249)/2, 400, 249);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDateInitial = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateInitial, jlDateInitial);
        moFieldDateInitial.setPickerButton(jbDateInitial);
        moFieldDateEnd = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateEnd, jlDateEnd);
        moFieldDateEnd.setPickerButton(jbDateEnd);

        mvFields.add(moFieldDateInitial);
        mvFields.add(moFieldDateEnd);

        jbPrint.addActionListener(this);
        jbExit.addActionListener(this);
        jbDateInitial.addActionListener(this);
        jbDateEnd.addActionListener(this);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionPrint(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "print", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionClose(); }
        };

        SFormUtilities.putActionMap(getRootPane(), action, "exit", KeyEvent.VK_ESCAPE, 0);

        setModalityType(ModalityType.MODELESS);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            if (mbParamIsSupplier) {
                setTitle("Reporte de documentos y egresos del ejercicio");
            }
            else {
                setTitle("Reporte de documentos e ingresos del ejercicio");
            }
            jftDateInitial.requestFocus();
        }
    }

    private void actionPrint() {
        Cursor cursor = getCursor();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        SFormValidation validation = formValidate();
        int[] year = SLibTimeUtilities.digestYear(moFieldDateInitial.getDate());

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
        else {
            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));

                map = miClient.createReportParams();
                map.put("tDtInitial", moFieldDateInitial.getDate());
                map.put("tDtEnd", moFieldDateEnd.getDate());
                map.put("nYear", year[0]);
                map.put("sTitle", mbParamIsSupplier ? "EGRESOS" : "INGRESOS");
                map.put("sDocType", mbParamIsSupplier ? "Compra" : "Venta");
                map.put("nFidCtDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[0] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[0]);
                map.put("nFidClDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[1] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[1]);
                map.put("nFidTpDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[2] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[2]);
                map.put("nFidCtDpsAdj", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_CN[0] : SDataConstantsSys.TRNU_TP_DPS_SAL_CN[0]);
                map.put("nFidClDpsAdj", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_CN[1] : SDataConstantsSys.TRNU_TP_DPS_SAL_CN[1]);
                map.put("nFidTpDpsAdj", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_CN[2] : SDataConstantsSys.TRNU_TP_DPS_SAL_CN[2]);
                map.put("nFidTpAccMov", mbParamIsSupplier ? SDataConstantsSys.FINS_CLS_ACC_MOV_PUR[0] : SDataConstantsSys.FINS_CLS_ACC_MOV_SAL[0]);
                map.put("nFidClAccMov", mbParamIsSupplier ? SDataConstantsSys.FINS_CLS_ACC_MOV_PUR[1] : SDataConstantsSys.FINS_CLS_ACC_MOV_SAL[1]);
                map.put("nFidClsAccMov", mbParamIsSupplier ? SDataConstantsSys.FINS_CLS_ACC_MOV_PUR[2] : SDataConstantsSys.FINS_CLS_ACC_MOV_SAL[2]);
                map.put("nFidCtSysMov",  mbParamIsSupplier ? SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP[0] : SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[0]);
                map.put("nFidTpSysMov",  mbParamIsSupplier ? SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP[1] : SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[1]);

                jasperPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_TRN_DPS_MOV, map);
                jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle("Integración " + (mbParamIsSupplier ? "de egresos" : "de ingresos"));
                jasperViewer.setVisible(true);
            }
            catch(Exception e) {
                SLibUtilities.renderException(this, e);
            }
            finally {
                setCursor(cursor);
            }
        }
    }

    private void actionDateInitial() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateInitial.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateInitial.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDateInitial.requestFocus();
        }
    }

    private void actionDateEnd() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateEnd.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateEnd.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDateEnd.requestFocus();
        }
    }

    private void actionClose() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbDateEnd;
    private javax.swing.JButton jbDateInitial;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbPrint;
    private javax.swing.JFormattedTextField jftDateEnd;
    private javax.swing.JFormattedTextField jftDateInitial;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateInitial;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        moFieldDateInitial.setFieldValue(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setFieldValue(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
    }

    @Override
    public void formRefreshCatalogues() {
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        SFormValidation validation = new SFormValidation();

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            if (moFieldDateEnd.getDate().compareTo(moFieldDateInitial.getDate()) < 0) {
                validation.setMessage("La fecha final debe ser mayor o igual a la fecha inicial.");
                validation.setComponent(jftDateEnd);
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public java.lang.Object getValue(int type) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public javax.swing.JLabel getTimeoutLabel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbPrint) {
                actionPrint();
            }
            else if (button == jbExit) {
                actionClose();
            }
            else if (button == jbDateInitial) {
                actionDateInitial();
            }
            else if (button == jbDateEnd) {
                actionDateEnd();
            }
        }
    }

    public void setParamIsSupplier(boolean b) { mbParamIsSupplier = b; }
}
