/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepDpsWithBalance.java
 *
 * Created on 18/05/2010, 01:26:40 PM
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
import erp.lib.form.SFormValidation;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Vector;
import javax.swing.AbstractAction;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Alfonso Flores
 */
public class SDialogRepDpsWithBalance extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldBizArea;
    private erp.lib.form.SFormField moFieldCompanyBranch;
    private erp.lib.form.SFormField moFieldBizPartner;
    private erp.lib.form.SFormField moFieldAgent;
    private erp.lib.form.SFormField moFieldRoute;

    private boolean mbParamIsSupplier;

    /** Creates new form SDialogRepDpsWithBalance */
    public SDialogRepDpsWithBalance(erp.client.SClientInterface client) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jbPrint = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jftDate = new javax.swing.JFormattedTextField();
        jbDate = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jlCompanyBranch = new javax.swing.JLabel();
        jcbCompanyBranch = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel5 = new javax.swing.JPanel();
        jlBizArea = new javax.swing.JLabel();
        jcbBizArea = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel7 = new javax.swing.JPanel();
        jlBizPartner = new javax.swing.JLabel();
        jcbBizPartner = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel8 = new javax.swing.JPanel();
        jlAgent = new javax.swing.JLabel();
        jcbAgent = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel9 = new javax.swing.JPanel();
        jlRoute = new javax.swing.JLabel();
        jcbRoute = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel10 = new javax.swing.JPanel();
        jrbByLocalCurrency = new javax.swing.JRadioButton();
        jrbByDpsCurrency = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte de facturas con saldo de clientes");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros del reporte:"));
        jPanel3.setLayout(new java.awt.GridLayout(6, 1, 5, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDate.setText("Fecha de corte: *");
        jlDate.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel4.add(jlDate);

        jftDate.setText("dd/mm/yyyyy");
        jftDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jftDate);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDate);

        jPanel3.add(jPanel4);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCompanyBranch.setText("Sucursal de la empresa:");
        jlCompanyBranch.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel6.add(jlCompanyBranch);

        jcbCompanyBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCompanyBranch.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel6.add(jcbCompanyBranch);

        jPanel3.add(jPanel6);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizArea.setText("Área de negocios:");
        jlBizArea.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel5.add(jlBizArea);

        jcbBizArea.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbBizArea.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel5.add(jcbBizArea);

        jPanel3.add(jPanel5);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner.setText("Cliente:");
        jlBizPartner.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel7.add(jlBizPartner);

        jcbBizPartner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbBizPartner.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel7.add(jcbBizPartner);

        jPanel3.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlAgent.setText("Agente:");
        jlAgent.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel8.add(jlAgent);

        jcbAgent.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbAgent.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel8.add(jcbAgent);

        jPanel3.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlRoute.setText("Ruta:");
        jlRoute.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel9.add(jlRoute);

        jcbRoute.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbRoute.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel9.add(jcbRoute);

        jPanel3.add(jPanel9);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Moneda del reporte:"));
        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        buttonGroup1.add(jrbByLocalCurrency);
        jrbByLocalCurrency.setText("Moneda local");
        jPanel10.add(jrbByLocalCurrency);

        buttonGroup1.add(jrbByDpsCurrency);
        jrbByDpsCurrency.setText("Moneda documento");
        jPanel10.add(jrbByDpsCurrency);

        jPanel2.add(jPanel10, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(450, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDate = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDate, jlDate);
        moFieldDate.setPickerButton(jbDate);
        moFieldBizArea = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbBizArea, jlBizArea);
        moFieldCompanyBranch = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbCompanyBranch, jlCompanyBranch);
        moFieldBizPartner = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbBizPartner, jlBizPartner);
        moFieldAgent = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbAgent, jlAgent);
        moFieldRoute = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbRoute, jlRoute);

        mvFields.add(moFieldDate);
        mvFields.add(moFieldBizArea);
        mvFields.add(moFieldCompanyBranch);
        mvFields.add(moFieldBizPartner);
        mvFields.add(moFieldAgent);
        mvFields.add(moFieldRoute);

        jbPrint.addActionListener(this);
        jbExit.addActionListener(this);
        jbDate.addActionListener(this);

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
                setTitle("Reporte de facturas con saldo de proveedores");
                jlBizPartner.setText("Proveedor:");
            }
            else {
                setTitle("Reporte de facturas con saldo de clientes");
                jlBizPartner.setText("Cliente:");
            }
            jftDate.requestFocus();
        }
    }

    private void actionPrint() {
        Cursor cursor = getCursor();
        SFormValidation validation = formValidate();
        Map<String, Object> map = null;
        JasperPrint jasperPrint = null;
        JasperViewer jasperViewer = null;

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
                map.put("tDate", moFieldDate.getDate());
                map.put("sBizArea", moFieldBizArea.getKeyAsIntArray()[0] == 0 ? "(TODAS)" : jcbBizArea.getSelectedItem().toString());
                map.put("sCompanyBranch", moFieldCompanyBranch.getKeyAsIntArray()[0] == 0 ? "(TODAS)" : jcbCompanyBranch.getSelectedItem().toString());
                map.put("sSalesAgent", moFieldAgent.getKeyAsIntArray()[0] == 0 ? "(TODOS)" : jcbAgent.getSelectedItem().toString());
                map.put("sSalesRoute", moFieldRoute.getKeyAsIntArray()[0] == 0 ? "(TODAS)" : jcbRoute.getSelectedItem().toString());
                map.put("nFidCtRef", mbParamIsSupplier ? SDataConstantsSys.BPSS_CT_BP_SUP : SDataConstantsSys.BPSS_CT_BP_CUS);
                map.put("nFidCtDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[0] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[0]);
                map.put("nFidClDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[1] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[1]);
                map.put("nFidTpDps", mbParamIsSupplier ? SDataConstantsSys.TRNU_TP_DPS_PUR_INV[2] : SDataConstantsSys.TRNU_TP_DPS_SAL_INV[2]);
                map.put("sSqlWhereBizArea", moFieldBizArea.getKeyAsIntArray()[0] == 0 ? "" : " AND b.fid_ba = " + moFieldBizArea.getKeyAsIntArray()[0]);
                map.put("sSqlWhereCompanyBranch", moFieldCompanyBranch.getKeyAsIntArray()[0] == 0 ? "" : " AND r.fid_cob = " + moFieldCompanyBranch.getKeyAsIntArray()[0]);
                map.put("sSqlWhereBizPartner", moFieldBizPartner.getKeyAsIntArray()[0] == 0 ? "" : " AND re.fid_bp_nr = " + moFieldBizPartner.getKeyAsIntArray()[0]);
                map.put("sSqlWhereSalesAgent", moFieldAgent.getKeyAsIntArray()[0] == 0 ? "" : " AND d.fid_sal_agt_n = " + moFieldAgent.getKeyAsIntArray()[0]);
                map.put("sSqlWhereSalesRoute", moFieldRoute.getKeyAsIntArray()[0] == 0 ? "" : " AND rou.fid_sal_route = " + moFieldRoute.getKeyAsIntArray()[0]);
                map.put("sTitle", mbParamIsSupplier ? " DE PROVEEDORES" : " DE CLIENTES");
                map.put("sLocalCurrency", miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getCurrency());
                map.put("sBizPartner", moFieldBizPartner.getKeyAsIntArray()[0] == 0 ? "(TODOS)" : jcbBizPartner.getSelectedItem().toString());
                map.put("nFidStDps", SDataConstantsSys.TRNS_ST_DPS_EMITED);
                map.put("nFidStDpsVal", SDataConstantsSys.TRNS_ST_DPS_VAL_EFF);
                map.put("nFidAccSysCat", mbParamIsSupplier ? SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP[0] : SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[0]);
                map.put("nFidAccSysTp", mbParamIsSupplier ? SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP[1] : SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[1]);

                jasperPrint = SDataUtilities.fillReport(miClient, jrbByDpsCurrency.isSelected() ? SDataConstantsSys.REP_TRN_DPS_UNP_CY : SDataConstantsSys.REP_TRN_DPS_UNP, map);
                jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle("Reporte de facturas con saldo " + (mbParamIsSupplier ? "de proveedores" : "de clientes"));
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

    private void actionClose() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    private void actionDate() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDate.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDate.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDate.requestFocus();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbPrint;
    private javax.swing.JComboBox<SFormComponentItem> jcbAgent;
    private javax.swing.JComboBox<SFormComponentItem> jcbBizArea;
    private javax.swing.JComboBox<SFormComponentItem> jcbBizPartner;
    private javax.swing.JComboBox<SFormComponentItem> jcbCompanyBranch;
    private javax.swing.JComboBox<SFormComponentItem> jcbRoute;
    private javax.swing.JFormattedTextField jftDate;
    private javax.swing.JLabel jlAgent;
    private javax.swing.JLabel jlBizArea;
    private javax.swing.JLabel jlBizPartner;
    private javax.swing.JLabel jlCompanyBranch;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlRoute;
    private javax.swing.JRadioButton jrbByDpsCurrency;
    private javax.swing.JRadioButton jrbByLocalCurrency;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moFieldDate.setFieldValue(miClient.getSessionXXX().getWorkingDate());
        jrbByLocalCurrency.setSelected(true);
    }

    @Override
    public void formRefreshCatalogues() {
        SFormUtilities.populateComboBox(miClient, jcbBizArea, SDataConstants.BPSU_BA);
        SFormUtilities.populateComboBox(miClient, jcbCompanyBranch, SDataConstants.BPSU_BPB, new int[] { miClient.getSessionXXX().getCurrentCompany().getPkCompanyId() });
        SFormUtilities.populateComboBox(miClient, jcbBizPartner, mbParamIsSupplier ? SDataConstants.BPSX_BP_SUP : SDataConstants.BPSX_BP_CUS);
        SFormUtilities.populateComboBox(miClient, jcbAgent, SDataConstants.BPSX_BP_ATT_SAL_AGT);
        SFormUtilities.populateComboBox(miClient, jcbRoute, SDataConstants.MKTU_SAL_ROUTE);
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
            else if (button == jbDate) {
                actionDate();
            }
        }
    }

    public void setParamIsSupplier(boolean b) { mbParamIsSupplier = b; }
}
