/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogRepStockMoves.java
 *
 * Created on 1/06/2010, 04:33:36 PM
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
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
public class SDialogRepStockMoves extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDateInitial;
    private erp.lib.form.SFormField moFieldDateEnd;
    private erp.lib.form.SFormField moFieldCompanyBranch;
    private erp.lib.form.SFormField moFieldWarehouse;
    private erp.lib.form.SFormField moFieldItemGeneric;

    /** Creates new form SDialogRepStockMoves */
    public SDialogRepStockMoves(erp.client.SClientInterface client) {
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDateInitial = new javax.swing.JLabel();
        jftDateInitial = new javax.swing.JFormattedTextField();
        jbDateInitial = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jftDateEnd = new javax.swing.JFormattedTextField();
        jbDateEnd = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jlCompanyBranch = new javax.swing.JLabel();
        jcbCompanyBranch = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel9 = new javax.swing.JPanel();
        jlWarehouse = new javax.swing.JLabel();
        jcbWarehouse = new javax.swing.JComboBox<SFormComponentItem>();
        jPanel10 = new javax.swing.JPanel();
        jlItemGeneric = new javax.swing.JLabel();
        jcbItemGeneric = new javax.swing.JComboBox<SFormComponentItem>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de movimientos de inventarios");
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Período:"));
        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

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

        jPanel3.add(jPanel4);

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

        jPanel3.add(jPanel5);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros del reporte:"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel7.setLayout(new java.awt.GridLayout(3, 1, 0, 1));

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCompanyBranch.setText("Sucursal de la empresa:");
        jlCompanyBranch.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel8.add(jlCompanyBranch);

        jcbCompanyBranch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCompanyBranch.setPreferredSize(new java.awt.Dimension(250, 23));
        jcbCompanyBranch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCompanyBranchItemStateChanged(evt);
            }
        });
        jPanel8.add(jcbCompanyBranch);

        jPanel7.add(jPanel8);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlWarehouse.setText("Almacén:");
        jlWarehouse.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel9.add(jlWarehouse);

        jcbWarehouse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbWarehouse.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel9.add(jcbWarehouse);

        jPanel7.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlItemGeneric.setText("Ítem genérico:");
        jlItemGeneric.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel10.add(jlItemGeneric);

        jcbItemGeneric.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbItemGeneric.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel10.add(jcbItemGeneric);

        jPanel7.add(jPanel10);

        jPanel6.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(430, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbCompanyBranchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCompanyBranchItemStateChanged
        itemStateChangedCompanyBranch();
    }//GEN-LAST:event_jcbCompanyBranchItemStateChanged

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDateInitial = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateInitial, jlDateInitial);
        moFieldDateInitial.setPickerButton(jbDateInitial);
        moFieldDateEnd = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateEnd, jlDateEnd);
        moFieldDateEnd.setPickerButton(jbDateEnd);
        moFieldCompanyBranch = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbCompanyBranch, jlCompanyBranch);
        moFieldWarehouse = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbWarehouse, jlWarehouse);
        moFieldItemGeneric = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbItemGeneric, jlItemGeneric);

        mvFields.add(moFieldDateInitial);
        mvFields.add(moFieldDateEnd);
        mvFields.add(moFieldCompanyBranch);
        mvFields.add(moFieldWarehouse);
        mvFields.add(moFieldItemGeneric);

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
            jftDateInitial.requestFocus();
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
                map.put("tDtInitial", moFieldDateInitial.getDate());
                map.put("tDtEnd", moFieldDateEnd.getDate());
                map.put("nWorkingYear", SLibTimeUtilities.digestYear(moFieldDateEnd.getDate())[0]);
                map.put("sCompanyBranch", moFieldCompanyBranch.getKeyAsIntArray()[0] == 0 ? "(TODAS)" : jcbCompanyBranch.getSelectedItem().toString());
                map.put("sWarehouse", jcbWarehouse.isEnabled() ? (moFieldWarehouse.getKeyAsIntArray()[0] == 0 ? "(TODOS)" : jcbWarehouse.getSelectedItem().toString().substring(jcbWarehouse.getSelectedItem().toString().indexOf("-") + 1)) : "(TODOS)");
                map.put("sItemGeneric", moFieldItemGeneric.getKeyAsIntArray()[0] == 0 ? "(TODOS)" : jcbItemGeneric.getSelectedItem().toString().substring(0, jcbItemGeneric.getSelectedItem().toString().indexOf("(") - 1));
                map.put("sSqlWhereCompanyBranch", moFieldCompanyBranch.getKeyAsIntArray()[0] == 0 ? "" : " AND stk.id_cob = " + moFieldCompanyBranch.getKeyAsIntArray()[0]);
                map.put("sSqlWhereWarehouse", jcbWarehouse.isEnabled() ? moFieldWarehouse.getKeyAsIntArray()[0] == 0 ? "" : " AND stk.id_wh = " + moFieldWarehouse.getKeyAsIntArray()[1] : "");
                map.put("sSqlWhereItemGeneric", moFieldItemGeneric.getKeyAsIntArray()[0] == 0 ? "" : " AND i.fid_igen = " + moFieldItemGeneric.getKeyAsIntArray()[0]);
                map.put("sSqlWhere", " WHERE stk.b_del = FALSE AND stk.dt BETWEEN '" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(moFieldDateInitial.getDate()) + "' AND '" +
                        miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format( moFieldDateEnd.getDate()) + "' ");
                map.put("nFidCtEnt", SDataConstantsSys.CFGS_CT_ENT_WH);
                map.put("bSortItemByKey", miClient.getSessionXXX().getParamsErp().getFkSortingItemTypeId() == SDataConstantsSys.CFGS_TP_SORT_KEY_NAME ? true : false);

                jasperPrint = SDataUtilities.fillReport(miClient, SDataConstantsSys.REP_TRN_STK_MOV, map);
                jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle("Listado de movimientos de inventarios");
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

    private void renderComboBoxWarehouse() {
        if (moFieldCompanyBranch.getKeyAsIntArray()[0] <= 0) {
            jcbWarehouse.setEnabled(false);
        }
        else {
            jcbWarehouse.setEnabled(true);
        }
    }

    private void populateComboBoxWarehouse() {
        jcbWarehouse.removeAllItems();

        if (moFieldCompanyBranch.getKeyAsIntArray()[0] > 0) {
            SFormUtilities.populateComboBox(miClient, jcbWarehouse, SDataConstants.CFGX_COB_ENT_WH, new int[] { moFieldCompanyBranch.getKeyAsIntArray()[0] });
        }

        renderComboBoxWarehouse();
    }

    private void itemStateChangedCompanyBranch() {
        if (!mbResetingForm) {
            populateComboBoxWarehouse();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton jbDateEnd;
    private javax.swing.JButton jbDateInitial;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbPrint;
    private javax.swing.JComboBox<SFormComponentItem> jcbCompanyBranch;
    private javax.swing.JComboBox<SFormComponentItem> jcbItemGeneric;
    private javax.swing.JComboBox<SFormComponentItem> jcbWarehouse;
    private javax.swing.JFormattedTextField jftDateEnd;
    private javax.swing.JFormattedTextField jftDateInitial;
    private javax.swing.JLabel jlCompanyBranch;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateInitial;
    private javax.swing.JLabel jlItemGeneric;
    private javax.swing.JLabel jlWarehouse;
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

        moFieldDateInitial.setFieldValue(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setFieldValue(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
        jcbWarehouse.removeAllItems();
        renderComboBoxWarehouse();
        mbResetingForm = false;
    }

    @Override
    public void formRefreshCatalogues() {
        mbResetingForm = true;
        SFormUtilities.populateComboBox(miClient, jcbCompanyBranch, SDataConstants.BPSU_BPB, new int[] { miClient.getSessionXXX().getCurrentCompany().getPkCompanyId() });
        SFormUtilities.populateComboBox(miClient, jcbItemGeneric, SDataConstants.ITMU_IGEN);
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
}
