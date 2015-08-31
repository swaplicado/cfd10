/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormCtr.java
 *
 * Created on 22/03/2011, 11:22:20 AM
 */

package erp.mtrn.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataReadDescriptions;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.mbps.data.SDataBizPartner;
import erp.mtrn.data.SDataCtr;
import erp.mtrn.data.SDataCtrEntry;
import erp.mtrn.data.SDataCtrEntryRow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 *
 * @author Alfonso Flores
 */
public class SFormCtr extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mtrn.data.SDataCtr moCtr;
    private erp.lib.form.SFormField moFieldFkBizPartnerId;
    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldDatePayment;
    private erp.lib.form.SFormField moFieldNumber;
    private erp.lib.form.SFormField moFieldTotal_r;
    private erp.lib.form.SFormField moFieldIsDeleted;

    private erp.lib.table.STablePane moEntryPane;

    private erp.mtrn.form.SFormCtrEntry moFormCtrEntry;

    /** Creates new form SFormCtr */
    public SFormCtr(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.TRN_CTR;

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
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlFkBizPartnerId = new javax.swing.JLabel();
        jcbFkBizPartnerId = new javax.swing.JComboBox();
        jbFkBizPartnerId = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jlDaysOfCredit = new javax.swing.JLabel();
        jtfDaysOfCredit = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jlNumber = new javax.swing.JLabel();
        jtfNumber = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jftDate = new javax.swing.JFormattedTextField();
        jbDate = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jlDatePayment = new javax.swing.JLabel();
        jftDatePayment = new javax.swing.JFormattedTextField();
        jbDatePayment = new javax.swing.JButton();
        JlDaysPayment = new javax.swing.JLabel();
        jtfDaysPayment = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jlFkDpsStatusId = new javax.swing.JLabel();
        jtfFkDpsStatusId = new javax.swing.JTextField();
        jlTotal_r = new javax.swing.JLabel();
        jtfTotal_r = new javax.swing.JTextField();
        jtfCurrency = new javax.swing.JTextField();
        jckIsDeleted = new javax.swing.JCheckBox();
        jpEntries = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jbAdd = new javax.swing.JButton();
        jbModify = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contrarrecibo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(692, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del contrarrecibo:"));
        jPanel3.setLayout(new java.awt.GridLayout(7, 1, 0, 1));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlFkBizPartnerId.setText("Asociado de negocios: *");
        jlFkBizPartnerId.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel6.add(jlFkBizPartnerId);

        jcbFkBizPartnerId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbFkBizPartnerId.setPreferredSize(new java.awt.Dimension(442, 23));
        jcbFkBizPartnerId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFkBizPartnerIdItemStateChanged(evt);
            }
        });
        jPanel6.add(jcbFkBizPartnerId);

        jbFkBizPartnerId.setText("jButton1");
        jbFkBizPartnerId.setToolTipText("Seleccionar asociado de negocios");
        jbFkBizPartnerId.setFocusable(false);
        jbFkBizPartnerId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbFkBizPartnerId);

        jPanel3.add(jPanel6);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDaysOfCredit.setText("Días de crédito:");
        jlDaysOfCredit.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel10.add(jlDaysOfCredit);

        jtfDaysOfCredit.setEditable(false);
        jtfDaysOfCredit.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfDaysOfCredit.setText("DAYS OF CREDIT");
        jtfDaysOfCredit.setFocusable(false);
        jtfDaysOfCredit.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel10.add(jtfDaysOfCredit);

        jPanel3.add(jPanel10);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNumber.setText("No. de contrarrecibo: *");
        jlNumber.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel9.add(jlNumber);

        jtfNumber.setText("NUMBER");
        jtfNumber.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel9.add(jtfNumber);

        jPanel3.add(jPanel9);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDate.setText("Fecha: *");
        jlDate.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel5.add(jlDate);

        jftDate.setText("dd/mm/yyyy");
        jftDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel5.add(jftDate);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbDate);

        jPanel3.add(jPanel5);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDatePayment.setText("Fecha de pago: *");
        jlDatePayment.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel4.add(jlDatePayment);

        jftDatePayment.setText("dd/mm/yyyy");
        jftDatePayment.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jftDatePayment);

        jbDatePayment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDatePayment.setToolTipText("Seleccionar fecha de pago");
        jbDatePayment.setFocusable(false);
        jbDatePayment.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDatePayment);

        JlDaysPayment.setText("Días de pago:");
        JlDaysPayment.setPreferredSize(new java.awt.Dimension(80, 23));
        jPanel4.add(JlDaysPayment);

        jtfDaysPayment.setEditable(false);
        jtfDaysPayment.setText("DAYS FOR PAYMENT");
        jtfDaysPayment.setFocusable(false);
        jtfDaysPayment.setPreferredSize(new java.awt.Dimension(277, 23));
        jPanel4.add(jtfDaysPayment);

        jPanel3.add(jPanel4);

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlFkDpsStatusId.setText("Estatus:");
        jlFkDpsStatusId.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel7.add(jlFkDpsStatusId);

        jtfFkDpsStatusId.setEditable(false);
        jtfFkDpsStatusId.setText("CTR STATUS");
        jtfFkDpsStatusId.setFocusable(false);
        jtfFkDpsStatusId.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel7.add(jtfFkDpsStatusId);

        jlTotal_r.setText("Total:");
        jlTotal_r.setPreferredSize(new java.awt.Dimension(108, 23));
        jPanel7.add(jlTotal_r);

        jtfTotal_r.setEditable(false);
        jtfTotal_r.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfTotal_r.setText("1,000,000,000.00");
        jtfTotal_r.setFocusable(false);
        jtfTotal_r.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel7.add(jtfTotal_r);

        jtfCurrency.setEditable(false);
        jtfCurrency.setText("CUR");
        jtfCurrency.setFocusable(false);
        jtfCurrency.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel7.add(jtfCurrency);

        jPanel3.add(jPanel7);

        jckIsDeleted.setText("Registro eliminado");
        jPanel3.add(jckIsDeleted);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jpEntries.setBorder(javax.swing.BorderFactory.createTitledBorder("Partidas del contrarrecibo:"));
        jpEntries.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(760, 23));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 0));

        jbAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_new.gif"))); // NOI18N
        jbAdd.setToolTipText("Crear");
        jbAdd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbAdd);

        jbModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_edit.gif"))); // NOI18N
        jbModify.setToolTipText("Modificar");
        jbModify.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbModify);

        jbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_delete.gif"))); // NOI18N
        jbDelete.setToolTipText("Eliminar");
        jbDelete.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbDelete);

        jpEntries.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel2.add(jpEntries, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-650)/2, (screenSize.height-485)/2, 650, 485);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbFkBizPartnerIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFkBizPartnerIdItemStateChanged
        if (!mbResetingForm) {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                itemStateChangedFkBizPartnerId();
            }
        }
    }//GEN-LAST:event_jcbFkBizPartnerIdItemStateChanged

    private void initComponentsExtra() {
        int i = 0;
        erp.lib.table.STableColumnForm tableColumnsEntry[];

        mvFields = new Vector<SFormField>();

        moEntryPane = new STablePane(miClient);
        moEntryPane.setDoubleClickAction(this, "publicActionModify");
        jpEntries.add(moEntryPane, BorderLayout.CENTER);

        moFieldFkBizPartnerId = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkBizPartnerId, jlFkBizPartnerId);
        moFieldFkBizPartnerId.setPickerButton(jbFkBizPartnerId);
        moFieldDate = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDate, jlDate);
        moFieldDate.setPickerButton(jbDate);
        moFieldDatePayment = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDatePayment, jlDatePayment);
        moFieldDatePayment.setPickerButton(jbDatePayment);
        moFieldNumber = new SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfNumber, jlNumber);
        moFieldNumber.setLengthMax(15);
        moFieldTotal_r = new SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfTotal_r, jlTotal_r);
        moFieldTotal_r.setDecimalFormat(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat());
        moFieldIsDeleted = new SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, true, jckIsDeleted);

        mvFields.add(moFieldFkBizPartnerId);
        mvFields.add(moFieldDate);
        mvFields.add(moFieldDatePayment);
        mvFields.add(moFieldNumber);
        mvFields.add(moFieldTotal_r);
        mvFields.add(moFieldIsDeleted);

        moFormCtrEntry = new SFormCtrEntry(miClient);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);
        jbDate.addActionListener(this);
        jbDatePayment.addActionListener(this);
        jbAdd.addActionListener(this);
        jbModify.addActionListener(this);
        jbDelete.addActionListener(this);
        jbFkBizPartnerId.addActionListener(this);

        i = 0;
        tableColumnsEntry = new STableColumnForm[15];
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Fecha doc.", STableConstants.WIDTH_DATE);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo doc.", STableConstants.WIDTH_CODE_DOC);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Folio doc.", STableConstants.WIDTH_DOC_NUM);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Moneda", STableConstants.WIDTH_CURRENCY_KEY);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Total moneda $", STableConstants.WIDTH_VALUE_2X);
        tableColumnsEntry[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "T. cambio", STableConstants.WIDTH_EXCHANGE_RATE);
        tableColumnsEntry[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererExchangeRate());
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Total $", STableConstants.WIDTH_EXCHANGE_RATE);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Folio doc. afect.", STableConstants.WIDTH_DOC_NUM);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Eliminado", STableConstants.WIDTH_BOOLEAN);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. creación", STableConstants.WIDTH_USER);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Creación", STableConstants.WIDTH_DATE_TIME);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. modificación", STableConstants.WIDTH_USER);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Modificación", STableConstants.WIDTH_DATE_TIME);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. eliminación", STableConstants.WIDTH_USER);
        tableColumnsEntry[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Eliminación", STableConstants.WIDTH_DATE_TIME);

        for (i = 0; i < tableColumnsEntry.length; i++) {
            moEntryPane.addTableColumn(tableColumnsEntry[i]);
        }

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), action, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jcbFkBizPartnerId.requestFocus();
            if (moCtr == null) {
                jtfFkDpsStatusId.setText(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.TRNS_ST_DPS, new int[] { SDataConstantsSys.TRNS_ST_DPS_EMITED }));
                getNextNumber();
            }
            else {
                jtfFkDpsStatusId.setText(SDataReadDescriptions.getCatalogueDescription(miClient, SDataConstants.TRNS_ST_DPS, new int[] { moCtr.getFkDpsStatusId() }));
            }

            jtfCurrency.setText(miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
            readDaysForPayment();
        }
    }

    private void actionOk() {
        SFormValidation validation = formValidate();

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
        else {
            mnFormResult = SLibConstants.FORM_RESULT_OK;
            setVisible(false);
        }
    }

    private void actionCancel() {
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

    private void actionDatePayment() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDatePayment.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDatePayment.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDatePayment.requestFocus();
        }
    }

    private void actionAddEntry() {
        SDataCtrEntry entry = null;

        if (jbAdd.isEnabled()) {
            moFormCtrEntry.formRefreshCatalogues();
            moFormCtrEntry.formReset();
            moFormCtrEntry.setVisible(true);

            if (moFormCtrEntry.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
                entry = (SDataCtrEntry) moFormCtrEntry.getRegistry();
                entry.setDbmsUserNew(miClient.getSessionXXX().getUser().getUser());
                entry.setDbmsUserEdit("n/a");
                entry.setDbmsUserDelete("n/a");
                entry.setUserNewTs(miClient.getSessionXXX().getSystemDate());
                entry.setUserEditTs(miClient.getSessionXXX().getSystemDate());
                entry.setUserDeleteTs(miClient.getSessionXXX().getSystemDate());

                moEntryPane.addTableRow(new SDataCtrEntryRow(entry));
                moEntryPane.renderTableRows();
                moEntryPane.setTableRowSelection(moEntryPane.getTableGuiRowCount() - 1);

                actionCalcutaleTotal();
            }
        }
    }

    private void actionModifyEntry() {
        int index = moEntryPane.getTable().getSelectedRow();
        SDataCtrEntry entry = null;

        if (jbModify.isEnabled()) {
            if (index != -1) {
                moFormCtrEntry.formRefreshCatalogues();
                moFormCtrEntry.formReset();
                moFormCtrEntry.setRegistry((SDataCtrEntry) moEntryPane.getTableRow(index).getData());
                moFormCtrEntry.setVisible(true);

                if (moFormCtrEntry.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
                    entry = (SDataCtrEntry) moFormCtrEntry.getRegistry();
                    entry.setDbmsUserEdit(miClient.getSessionXXX().getUser().getUser());
                    entry.setUserEditTs(miClient.getSessionXXX().getWorkingDate());

                    moEntryPane.setTableRow(new SDataCtrEntryRow(entry), index);
                    moEntryPane.renderTableRows();
                    moEntryPane.setTableRowSelection(index);

                    actionCalcutaleTotal();
                }
            }
        }
    }

    private void actionDeleteEntry() {
        int index = moEntryPane.getTable().getSelectedRow();
        SDataCtrEntry entry = null;

        if (jbDelete.isEnabled()) {
            if (index != -1) {
                if (miClient.showMsgBoxConfirm(SLibConstants.MSG_CNF_REG_DELETE) == JOptionPane.YES_OPTION) {
                    entry = (SDataCtrEntry) moEntryPane.getTableRow(index).getData();
                    entry.setIsDeleted(true);
                    entry.setFkUserDeleteId(miClient.getSession().getUser().getPkUserId());
                    entry.setIsRegistryEdited(true);
                    entry.setFkUserEditId(miClient.getSession().getUser().getPkUserId());

                    moEntryPane.setTableRow(new SDataCtrEntryRow(entry), index);
                    moEntryPane.renderTableRows();

                    actionCalcutaleTotal();

                    if (moEntryPane.getTableGuiRowCount() > 0) {
                        moEntryPane.setTableRowSelection(index < moEntryPane.getTableGuiRowCount() ? index : moEntryPane.getTableGuiRowCount() - 1);
                    }
                }
            }
        }
    }

    private void actionCalcutaleTotal() {
        double total = 0;
        SDataCtrEntry entry = null;

        for (int i = 0; i < moEntryPane.getTableGuiRowCount(); i++) {
            entry = (SDataCtrEntry) moEntryPane.getTableRow(i).getData();
            total += entry.getIsDeleted() ? 0 : entry.getTotal_r();
        }

        moFieldTotal_r.setFieldValue(total);
    }

    private void actionFkBizPartnerId() {
        miClient.pickOption(SDataConstants.BPSX_BP_SUP, moFieldFkBizPartnerId, null);
    }

    private void getNextNumber() {
        try {
            moFieldNumber.setFieldValue("" + SDataUtilities.obtainNextNumberForCtr(miClient));
        }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }
    }

    private void itemStateChangedFkBizPartnerId() {
        readDaysOfCreditFromBizPartner();
    }

    private void readDaysForPayment() {
        String days = "";

        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentMonday() ? "LUNES" : "");
        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentTuesday() ? (days.length() > 0 ? "; " : "") + "MARTES" : "");
        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentWednesday() ? (days.length() > 0 ? "; " : "") + "MIÉRCOLES" : "");
        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentThursday() ? (days.length() > 0 ? "; " : "") + "JUEVES" : "");
        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentFriday() ? (days.length() > 0 ? "; " : "") + "VIERNES" : "");
        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentSaturday() ? (days.length() > 0 ? "; " : "") + "SÁBADO" : "");
        days += (miClient.getSessionXXX().getParamsCompany().getIsPaymentSunday() ? (days.length() > 0 ? "; " : "") + "DOMINGO" : "");

        jtfDaysPayment.setText(days);
    }

    private void readDaysOfCreditFromBizPartner() {
        int days = 0;
        SDataBizPartner oBizPartner = null;

        if (moFieldFkBizPartnerId.getKeyAsIntArray()[0] > 0) {
            oBizPartner = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, moFieldFkBizPartnerId.getKeyAsIntArray(), SLibConstants.EXEC_MODE_SILENT);

            days = oBizPartner.getDbmsCategorySettingsSup().getEffectiveDaysOfCredit();
            jtfDaysOfCredit.setText(""+ days);

            moFieldDatePayment.setFieldValue(SLibTimeUtilities.addDate(moFieldDate.getDate(), 0, 0, days == 0 ? 7 : days));
        }
        else {
            moFieldDatePayment.setFieldValue(SLibTimeUtilities.addDate(moFieldDate.getDate(), 0, 0, 7));
        }
    }

    private boolean isDateOfPaymentValid() {
        int n = 0;
        boolean valid = false;
        Calendar c = Calendar.getInstance();

        c.setTime(moFieldDatePayment.getDate());

        n = c.get(Calendar.DAY_OF_WEEK);

        if (n == 1 && miClient.getSessionXXX().getParamsCompany().getIsPaymentSunday()) {
            valid = true;
        }
        else if (n == 2 && miClient.getSessionXXX().getParamsCompany().getIsPaymentMonday()) {
            valid = true;
        }
        else if (n == 3 && miClient.getSessionXXX().getParamsCompany().getIsPaymentTuesday()) {
            valid = true;
        }
        else if (n == 4 && miClient.getSessionXXX().getParamsCompany().getIsPaymentWednesday()) {
            valid = true;
        }
        else if (n == 5 && miClient.getSessionXXX().getParamsCompany().getIsPaymentThursday()) {
            valid = true;
        }
        else if (n == 6 && miClient.getSessionXXX().getParamsCompany().getIsPaymentFriday()) {
            valid = true;
        }
        else if (n == 7 && miClient.getSessionXXX().getParamsCompany().getIsPaymentSaturday()) {
            valid = true;
        }

        return valid;
    }

    public void publicActionModify() {
            actionModifyEntry();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlDaysPayment;
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
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbDatePayment;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbFkBizPartnerId;
    private javax.swing.JButton jbModify;
    private javax.swing.JButton jbOk;
    private javax.swing.JComboBox jcbFkBizPartnerId;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JFormattedTextField jftDate;
    private javax.swing.JFormattedTextField jftDatePayment;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlDatePayment;
    private javax.swing.JLabel jlDaysOfCredit;
    private javax.swing.JLabel jlFkBizPartnerId;
    private javax.swing.JLabel jlFkDpsStatusId;
    private javax.swing.JLabel jlNumber;
    private javax.swing.JLabel jlTotal_r;
    private javax.swing.JPanel jpEntries;
    private javax.swing.JTextField jtfCurrency;
    private javax.swing.JTextField jtfDaysOfCredit;
    private javax.swing.JTextField jtfDaysPayment;
    private javax.swing.JTextField jtfFkDpsStatusId;
    private javax.swing.JTextField jtfNumber;
    private javax.swing.JTextField jtfTotal_r;
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

        moCtr = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moEntryPane.createTable(null);
        moEntryPane.clearTableRows();
        moFieldDate.setFieldValue(miClient.getSessionXXX().getWorkingDate());
        moFieldDatePayment.setFieldValue(miClient.getSessionXXX().getWorkingDate());
        jtfDaysOfCredit.setText("");
        jtfDaysPayment.setText("");
        jtfFkDpsStatusId.setText("");
        moFieldTotal_r.setFieldValue(0d);
        jckIsDeleted.setEnabled(false);
        mbResetingForm = false;
    }

    @Override
    public void formRefreshCatalogues() {
        mbResetingForm = true;
        SFormUtilities.populateComboBox(miClient, jcbFkBizPartnerId, SDataConstants.BPSX_BP_SUP);
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
            if (moFieldDatePayment.getDate().compareTo(moFieldDate.getDate()) < 0) {
                validation.setMessage("La fecha de pago debe ser mayor o igual a la fecha del documento.");
                validation.setComponent(jftDatePayment);
            }
            else if (jtfDaysPayment.getText().length() == 0) {
                validation.setMessage("No hay días de pago definidos.");
            }
            else if (!isDateOfPaymentValid()) {
                validation.setMessage("La fecha de pago ingresada no corresponde con ninguno de los días de pago definidos.");
                validation.setComponent(jftDatePayment);
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
        int i = 0;
        moCtr = (SDataCtr) registry;
        SDataCtrEntryRow entryRow = null;

        moFieldFkBizPartnerId.setFieldValue(new int[] { moCtr.getFkBizPartnerId() });
        moFieldDate.setFieldValue(moCtr.getDate());
        moFieldDatePayment.setFieldValue(moCtr.getDatePayment());
        moFieldNumber.setFieldValue(moCtr.getNumber());
        moFieldTotal_r.setFieldValue(moCtr.getTotal_r());
        moFieldIsDeleted.setFieldValue(moCtr.getIsDeleted());

        for (i = 0; i < moCtr.getDbmsEntries().size(); i++) {
            entryRow = new SDataCtrEntryRow(moCtr.getDbmsEntries().get(i));
            moEntryPane.addTableRow(entryRow);
        }
        moEntryPane.setTableRowSelection(0);

        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        int i = 0;
        SDataCtrEntry entry = null;

        if (moCtr == null) {
            moCtr = new SDataCtr();
            moCtr.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
        }
        else {
            moCtr.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        moCtr.setPkYearId(SLibTimeUtilities.digestYear(moFieldDate.getDate())[0]);
        moCtr.setFkBizPartnerId(moFieldFkBizPartnerId.getKeyAsIntArray()[0]);
        moCtr.setDate(moFieldDate.getDate());
        moCtr.setDatePayment(moFieldDatePayment.getDate());
        moCtr.setNumber(moFieldNumber.getString());
        moCtr.setTotal_r(moFieldTotal_r.getDouble());
        moCtr.setIsDeleted(moFieldIsDeleted.getBoolean());
        moCtr.setFkDpsStatusId(SDataConstantsSys.TRNS_ST_DPS_EMITED);

        moCtr.getDbmsEntries().clear();

        for (i = 0; i < moEntryPane.getTableGuiRowCount(); i++) {
            entry = (SDataCtrEntry) moEntryPane.getTableRow(i).getData();
            moCtr.getDbmsEntries().add(entry);
        }

        return moCtr;
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
        return null;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbDate) {
                actionDate();
            }
            else if (button == jbDatePayment) {
                actionDatePayment();
            }
            else if (button == jbAdd) {
                actionAddEntry();
            }
            else if (button == jbModify) {
                actionModifyEntry();
            }
            else if (button == jbDelete) {
                actionDeleteEntry();
            }
            else if (button == jbFkBizPartnerId) {
                actionFkBizPartnerId();
            }
        }
    }
}
