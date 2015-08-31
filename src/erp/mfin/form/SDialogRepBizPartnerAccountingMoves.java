/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepBizPartnerAccountingMoves.java
 *
 * Created on 29/06/2010, 05:02:26 PM
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.mbps.data.SDataBizPartner;
import erp.mbps.data.SDataBizPartnerCategory;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Sergio Flores
 */
public class SDialogRepBizPartnerAccountingMoves extends javax.swing.JDialog implements java.awt.event.ActionListener, java.awt.event.FocusListener {

    public static final int DOC_DAYS_NO = 1;
    public static final int DOC_DAYS_YES = 2;

    private erp.client.SClientInterface miClient;
    int mnBizPartnerCategoryId;
    int mnBizPartnerId;
    boolean mbShowPaymentDays;
    boolean mbFirstTime;

    private erp.lib.form.SFormField moFieldYear;
    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldBizPartner;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;

    int mnOptionPickerId;
    int[] manSysMoveTypeKey;
    private java.lang.String msBizPartnerCat;
    private java.lang.String msBizPartnerCatPlural;

    /** Creates new form SDialogRepBizPartnerAccountingMoves */
    public SDialogRepBizPartnerAccountingMoves(erp.client.SClientInterface client, int idBizPartnerCategory) {
        this(client, idBizPartnerCategory, false);
    }

    /** Creates new form SDialogRepBizPartnerAccountingMoves */
    public SDialogRepBizPartnerAccountingMoves(erp.client.SClientInterface client, int idBizPartnerCategory, boolean showPaymentDays) {
        super(client.getFrame(), true);
        miClient = client;
        mnBizPartnerCategoryId = idBizPartnerCategory;
        mbShowPaymentDays = showPaymentDays;
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
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        jtfYear = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jftDate = new javax.swing.JFormattedTextField();
        jbDate = new javax.swing.JButton();
        jlDateTip = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlBizPartner = new javax.swing.JLabel();
        jcbBizPartner = new javax.swing.JComboBox();
        jbBizPartner = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jpPrint = new javax.swing.JButton();
        jpClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimientos contables");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del reporte:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlYear.setText("Ejercicio: *");
        jlYear.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel8.add(jlYear);

        jtfYear.setText("2000");
        jtfYear.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel8.add(jtfYear);

        jPanel6.add(jPanel8);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDate.setText("Fecha de valuación: *");
        jlDate.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel3.add(jlDate);

        jftDate.setText("dd/mm/yyyy");
        jftDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel3.add(jftDate);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel3.add(jbDate);

        jlDateTip.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jlDateTip.setText("(para días de pago o mora)");
        jlDateTip.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(jlDateTip);

        jPanel6.add(jPanel3);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jPanel6.add(jPanel7);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner.setText("Asociado negocios: *");
        jlBizPartner.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel4.add(jlBizPartner);

        jcbBizPartner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbBizPartner.setPreferredSize(new java.awt.Dimension(325, 23));
        jPanel4.add(jcbBizPartner);

        jbBizPartner.setText("...");
        jbBizPartner.setFocusable(false);
        jbBizPartner.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbBizPartner);

        jPanel6.add(jPanel4);

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

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

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-576)/2, (screenSize.height-388)/2, 576, 388);
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
        switch (mnBizPartnerCategoryId) {
            case SDataConstantsSys.BPSS_CT_BP_SUP:
                setTitle(getTitle() + " de proveedores" + (!mbShowPaymentDays ? "" : " con días de pago"));
                manSysMoveTypeKey = SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP;
                msBizPartnerCat = "PROVEEDOR";
                msBizPartnerCatPlural = "PROVEEDORES";
                jlBizPartner.setText("Proveedor: *");
                jbBizPartner.setToolTipText("Seleccionar proveedor");
                SFormUtilities.populateComboBox(miClient, jcbBizPartner, mnOptionPickerId = SDataConstants.BPSX_BP_SUP);
                break;
            case SDataConstantsSys.BPSS_CT_BP_CUS:
                setTitle(getTitle() + " de clientes" + (!mbShowPaymentDays ? "" : " con días de pago"));
                manSysMoveTypeKey = SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS;
                msBizPartnerCat = "CLIENTE";
                msBizPartnerCatPlural = "CLIENTES";
                jlBizPartner.setText("Cliente: *");
                jbBizPartner.setToolTipText("Seleccionar cliente");
                SFormUtilities.populateComboBox(miClient, jcbBizPartner, mnOptionPickerId = SDataConstants.BPSX_BP_CUS);
                break;
            default:
                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
        }

        mnBizPartnerId = 0;

        moFieldYear = new SFormField(miClient, SLibConstants.DATA_TYPE_INTEGER, true, jtfYear, jlYear);
        moFieldYear.setIntegerMin(2000);
        moFieldYear.setIntegerMax(2100);
        moFieldYear.setMinInclusive(true);
        moFieldYear.setMaxInclusive(true);
        moFieldYear.setDecimalFormat(miClient.getSessionXXX().getFormatters().getYearFormat());
        moFieldDate = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDate, jlDate);
        moFieldDate.setPickerButton(jbDate);
        moFieldBizPartner = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbBizPartner, jlBizPartner);
        moFieldBizPartner.setPickerButton(jbBizPartner);

        mvFields = new Vector<SFormField>();
        mvFields.add(moFieldYear);
        mvFields.add(moFieldDate);
        mvFields.add(moFieldBizPartner);

        jbDate.addActionListener(this);
        jbBizPartner.addActionListener(this);
        jtfYear.addFocusListener(this);
        jftDate.addFocusListener(this);

        if (mbShowPaymentDays) {
            jftDate.setEnabled(true);
            jbDate.setEnabled(true);
            jlDate.setEnabled(true);
            jlDateTip.setEnabled(true);
            jtfYear.setEnabled(false);
            jlYear.setEnabled(false);
        }
        else {
            jftDate.setEnabled(false);
            jbDate.setEnabled(false);
            jlDate.setEnabled(false);
            jlDateTip.setEnabled(false);
            jtfYear.setEnabled(true);
            jlYear.setEnabled(true);
        }

        resetForm();

        setModalityType(ModalityType.MODELESS);
        SFormUtilities.createActionMap(rootPane, this, "actionPrint", "print", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionClose", "close", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;

            if (jtfYear.isEnabled()) {
                jtfYear.requestFocus();
            }
            else {
                jftDate.requestFocus();
            }
        }
    }

    private void print() {
        int year = mbShowPaymentDays ? SLibTimeUtilities.digestYear(moFieldDate.getDate())[0] : moFieldYear.getInteger();
        Cursor cursor = getCursor();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;
        SDataBizPartner bizPartner = null;
        SDataBizPartnerCategory bizPartnerCategory = null;

        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));

            bizPartner = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, moFieldBizPartner.getKeyAsIntArray(), SLibConstants.EXEC_MODE_VERBOSE);

            map = miClient.createReportParams();
            map.put("nSysMoveCatId", manSysMoveTypeKey[0]);
            map.put("nSysMoveTypeId", manSysMoveTypeKey[1]);
            map.put("sBizPartnerCat", msBizPartnerCat);
            map.put("sBizPartnerCatPlural", msBizPartnerCatPlural);
            map.put("nLocalCurrencyId", miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getPkCurrencyId());
            map.put("sLocalCurrency", miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getCurrency());
            map.put("nYear", year);
            map.put("tDate", mbShowPaymentDays ? moFieldDate.getDate() : SLibTimeUtilities.createDate(year, 12, 31));
            map.put("nBizPartnerId", bizPartner.getPkBizPartnerId());
            map.put("sBizPartner", bizPartner.getBizPartner());

            switch (mnBizPartnerCategoryId) {
                case SDataConstantsSys.BPSS_CT_BP_SUP:
                    bizPartnerCategory = bizPartner.getDbmsCategorySettingsSup();
                    break;
                case SDataConstantsSys.BPSS_CT_BP_CUS:
                    bizPartnerCategory = bizPartner.getDbmsCategorySettingsCus();
                    break;
                default:
            }

            map.put("dCreditLimit", bizPartnerCategory.getEffectiveCreditLimit());
            map.put("nDaysCredit", bizPartnerCategory.getEffectiveDaysOfCredit());
            map.put("nDaysGrace", bizPartnerCategory.getEffectiveDaysOfGrace());
            map.put("sCreditType", SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.BPSS_TP_CRED, new int[] { bizPartnerCategory.getEffectiveCreditTypeId() }));

            jasperPrint = SDataUtilities.fillReport(miClient, mbShowPaymentDays ? SDataConstantsSys.REP_FIN_BPS_ACC_MOV_DAY : SDataConstantsSys.REP_FIN_BPS_ACC_MOV, map);
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

    private void actionDate() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDate.getDate(), moFieldDate);
    }

    private void actionBizPartner() {
        miClient.pickOption(mnOptionPickerId, moFieldBizPartner, null);
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

    public void focusLostYear() {
        moFieldDate.setFieldValue(SLibTimeUtilities.createDate(moFieldYear.getInteger(), 12, 31));
    }

    public void focusLostDate() {
        moFieldYear.setFieldValue(SLibTimeUtilities.digestYear(moFieldDate.getDate())[0]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbBizPartner;
    private javax.swing.JButton jbDate;
    private javax.swing.JComboBox jcbBizPartner;
    private javax.swing.JFormattedTextField jftDate;
    private javax.swing.JLabel jlBizPartner;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlDateTip;
    private javax.swing.JLabel jlYear;
    private javax.swing.JButton jpClose;
    private javax.swing.JButton jpPrint;
    private javax.swing.JTextField jtfYear;
    // End of variables declaration//GEN-END:variables

    public void resetForm() {
        mbFirstTime = true;
        moFieldYear.setFieldValue(miClient.getSessionXXX().getWorkingYear());
        moFieldDate.setFieldValue(mbShowPaymentDays ? miClient.getSessionXXX().getWorkingDate() : SLibTimeUtilities.getEndOfYear(miClient.getSessionXXX().getWorkingDate()));

        if (mnBizPartnerId != 0) {
            SFormUtilities.locateComboBoxItem(jcbBizPartner, new int[] { mnBizPartnerId });
        }
    }

    public void setBizPartnerId(int id) {
        mnBizPartnerId = id;
    }

    public int getBizPartnerId() {
        return mnBizPartnerId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbDate) {
                actionDate();
            }
            else if (button == jbBizPartner) {
                actionBizPartner();
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JFormattedTextField) {
            JFormattedTextField formattedTextField = (JFormattedTextField) e.getSource();

            if (formattedTextField == jftDate) {
                focusLostDate();
            }
        }
        else if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();

            if (textField == jtfYear) {
                focusLostYear();
            }
        }
    }
}
