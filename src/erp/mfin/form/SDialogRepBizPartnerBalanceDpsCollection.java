/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepBizPartnerBalanceDpsCollection.java
 *
 * Created on 23/04/2013, 04:10:26 PM
 */

package erp.mfin.form;

import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.mtrn.form.SDialogFilterFunctionalArea;
import erp.mtrn.data.STrnFunctionalAreaUtils;
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
 * @author Néstor Ávalos, Edwin Carmona, Sergio Flores
 */
public class SDialogRepBizPartnerBalanceDpsCollection extends javax.swing.JDialog implements java.awt.event.ActionListener {

    private erp.client.SClientInterface miClient;
    int mnBizPartnerCategoryId;
    boolean mbFirstTime;

    private erp.lib.form.SFormField moFieldDateInitial;
    private erp.lib.form.SFormField moFieldDateEnd;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;

    int mnOptionPickerId;
    int mnReportId;
    int[] manSysMoveTypeKey;
    private java.lang.String msBizPartnerCat;
    private java.lang.String msBizPartnerCatPlural;
    
    private erp.mtrn.form.SDialogFilterFunctionalArea moDialogFilterFunctionalArea;
    private int mnFunctionalAreaId;
    private String msFunctionalAreasIds;

    /** Creates new form SDialogRepBizPartnerBalanceDpsCollection
     * @param client
     * @param idBizPartnerCategory
     * @param idReport
     */
    public SDialogRepBizPartnerBalanceDpsCollection(erp.client.SClientInterface client, int idBizPartnerCategory, int idReport) {
        super(client.getFrame(), true);
        miClient = client;
        mnBizPartnerCategoryId = idBizPartnerCategory;
        mnReportId = idReport;
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
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jlDateInitial = new javax.swing.JLabel();
        jftDateInitial = new javax.swing.JFormattedTextField();
        jbDateInitial = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jftDateEnd = new javax.swing.JFormattedTextField();
        jbDateEnd = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jlBizPartner1 = new javax.swing.JLabel();
        jtfFunctionalArea = new javax.swing.JTextField();
        jbFunctionalArea = new javax.swing.JButton();
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

        jPanel6.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Período:"));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 77));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateInitial.setText("Fecha inicial: *");
        jlDateInitial.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jlDateInitial);

        jftDateInitial.setText("dd/mm/yyyy");
        jftDateInitial.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel8.add(jftDateInitial);

        jbDateInitial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateInitial.setToolTipText("Seleccionar fecha inicial");
        jbDateInitial.setFocusable(false);
        jbDateInitial.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbDateInitial);

        jPanel10.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateEnd.setText("Fecha final: *");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel9.add(jlDateEnd);

        jftDateEnd.setText("dd/mm/yyyy");
        jftDateEnd.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel9.add(jftDateEnd);

        jbDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateEnd.setToolTipText("Seleccionar fecha final");
        jbDateEnd.setFocusable(false);
        jbDateEnd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel9.add(jbDateEnd);

        jPanel10.add(jPanel9);

        jPanel6.add(jPanel10);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner1.setText("Área funcional:");
        jlBizPartner1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlBizPartner1);

        jtfFunctionalArea.setEditable(false);
        jtfFunctionalArea.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel11.add(jtfFunctionalArea);

        jbFunctionalArea.setText("...");
        jbFunctionalArea.setToolTipText("Seleccionar asociado de negocios:");
        jbFunctionalArea.setFocusable(false);
        jbFunctionalArea.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel11.add(jbFunctionalArea);

        jPanel6.add(jPanel11);

        jPanel5.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

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
        setTitle(getTitle() + (mnReportId != SDataConstantsSys.REP_FIN_BPS_BAL_COLL ? " por documento" : ""));
        
        manSysMoveTypeKey = SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS;
        msBizPartnerCat = "CLIENTE";
        msBizPartnerCatPlural = "CLIENTES";

        moFieldDateInitial = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateInitial, jlDateInitial);
        moFieldDateInitial.setPickerButton(jbDateInitial);
        moFieldDateEnd = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateEnd, jlDateEnd);
        moFieldDateEnd.setPickerButton(jbDateEnd);

        mvFields = new Vector<>();
        mvFields.add(moFieldDateInitial);

        jbDateInitial.addActionListener(this);
        jbDateEnd.addActionListener(this);
        jbFunctionalArea.addActionListener(this);

        resetForm();

        setModalityType(ModalityType.MODELESS);
        SFormUtilities.createActionMap(rootPane, this, "actionPrint", "print", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionClose", "close", KeyEvent.VK_ESCAPE, 0);
        
        // áreas funcionales:
        jbFunctionalArea.setEnabled(miClient.getSessionXXX().getParamsCompany().getIsFunctionalAreas());
        mnFunctionalAreaId = SLibConstants.UNDEFINED;
        moDialogFilterFunctionalArea = new SDialogFilterFunctionalArea(miClient);
        renderFunctionalArea();
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jftDateInitial.requestFocus();
            jftDateEnd.requestFocus();
        }
    }

    private void print() {
        int year = SLibTimeUtilities.digestYear(moFieldDateInitial.getDate())[0];
        Cursor cursor = getCursor();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        
        String areasFilter = "";
        if (miClient.getSessionXXX().getParamsCompany().getIsFunctionalAreas()) {
            if (msFunctionalAreasIds.isEmpty()) {
                areasFilter = "";
            }
            else {
                areasFilter = " AND d.fid_func IN ( " + msFunctionalAreasIds + " ) ";
            }
        }

        if (moFieldDateEnd.getDate().compareTo(moFieldDateInitial.getDate()) < 0) {
            miClient.showMsgBoxWarning("La fecha final debe ser mayor o igual a la fecha inicial.");
            jftDateEnd.requestFocus();
        }
        else {
            try {
                setCursor(new Cursor(Cursor.WAIT_CURSOR));

                map = miClient.createReportParams();
                map.put("nSysMoveCatId", manSysMoveTypeKey[0]);
                map.put("nSysMoveTypeId", manSysMoveTypeKey[1]);
                map.put("nBpCategoryId", SDataConstantsSys.BPSS_CT_BP_CUS);
                map.put("nFkStatusDpsId", SDataConstantsSys.TRNS_ST_DPS_EMITED);
                map.put("sBizPartnerCat", msBizPartnerCat);
                map.put("sBizPartnerCatPlural", msBizPartnerCatPlural);
                map.put("nLocalCurrencyId", miClient.getSessionXXX().getParamsErp().getFkCurrencyId());
                map.put("sLocalCurrencyKey", miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
                map.put("nYear", year);
                map.put("tDateInitial", moFieldDateInitial.getDate());
                map.put("tDateEnd", moFieldDateEnd.getDate());
                map.put("sFuncText", jtfFunctionalArea.getText());
                map.put("sFilterFunctionalArea", areasFilter);

                jasperPrint = SDataUtilities.fillReport(miClient, mnReportId, map);
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
    }

    private void actionDateInitial() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateInitial.getDate(), moFieldDateInitial);
    }

    private void actionDateEnd() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateEnd.getDate(), moFieldDateEnd);
    }
    
    private void actionFunctionalArea() {
        moDialogFilterFunctionalArea.formRefreshCatalogues();
        moDialogFilterFunctionalArea.formReset();
        moDialogFilterFunctionalArea.setFunctionalAreaId(mnFunctionalAreaId);
        moDialogFilterFunctionalArea.setFormVisible(true);

        if (moDialogFilterFunctionalArea.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
            mnFunctionalAreaId = moDialogFilterFunctionalArea.getFunctionalAreaId();
            renderFunctionalArea();
        }
    }
    
    private void renderFunctionalArea() {
        String texts[] = STrnFunctionalAreaUtils.getTextFilterOfFunctionalAreas(miClient, mnFunctionalAreaId);
        msFunctionalAreasIds = texts[0];
        
        jtfFunctionalArea.setText(texts[1]);
        jtfFunctionalArea.setCaretPosition(0);
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbDateEnd;
    private javax.swing.JButton jbDateInitial;
    private javax.swing.JButton jbFunctionalArea;
    private javax.swing.JFormattedTextField jftDateEnd;
    private javax.swing.JFormattedTextField jftDateInitial;
    private javax.swing.JLabel jlBizPartner1;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateInitial;
    private javax.swing.JButton jpClose;
    private javax.swing.JButton jpPrint;
    private javax.swing.JTextField jtfFunctionalArea;
    // End of variables declaration//GEN-END:variables

    public void resetForm() {
        mbFirstTime = true;
        moFieldDateInitial.setFieldValue(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setFieldValue(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbDateInitial) {
                actionDateInitial();
            }
            else if (button == jbDateEnd) {
                actionDateEnd();
            }
            else if (button == jbFunctionalArea) {
                actionFunctionalArea();
            }
        }
    }
}