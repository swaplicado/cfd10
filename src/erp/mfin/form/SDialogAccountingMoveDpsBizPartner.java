/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.lib.table.STableUtilities;
import erp.mcfg.data.SDataParamsCompany;
import erp.mfin.data.SDialogAccountingDetailDpsBizPartnerRow;
import erp.mtrn.data.SDataDps;
import erp.server.SServerConstants;
import erp.server.SServerRequest;
import erp.server.SServerResponse;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTextField;
import sa.lib.srv.SSrvConsts;

/**
 *
 * @author Alfonso Flores
 */
public class SDialogAccountingMoveDpsBizPartner extends javax.swing.JDialog implements java.awt.event.ActionListener {

    private erp.client.SClientInterface miClient;
    private int mnParamDpsCategory;
    private String msParamBizPartnerName;
    private String msParamDpsNumber;

    private java.lang.Object moParamPrimaryKey;
    private int mnParamYear;
    private java.util.Date mtParamDate;
    private int[] manParamCurrencyKey;
    private int[] manParamDpsKey;
    private int[] manParamBizPartnerKey;
    private double[] madDpsBalance;
    private erp.lib.table.STablePane moPaneDetails;
    private java.util.Vector<Integer> mvAccountLevels;

    private erp.lib.form.SFormField moFieldDate;

    /** Creates new form SDialogAccountingMoveDpsBizPartner */
    public SDialogAccountingMoveDpsBizPartner(erp.client.SClientInterface client, int dpsCategory) {
        super(client.getFrame(), true);
        miClient = client;
        mnParamDpsCategory = dpsCategory;
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
        jbClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jlYear = new javax.swing.JLabel();
        jtfYear = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jftDate = new javax.swing.JFormattedTextField();
        jbDate = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jlBalanceCy = new javax.swing.JLabel();
        jtfBalanceCy = new javax.swing.JTextField();
        jtfBalanceCyCurKey = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jlBalance = new javax.swing.JLabel();
        jtfBalance = new javax.swing.JTextField();
        jtfBalanceCurKey = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jlBizPartner = new javax.swing.JLabel();
        jtfBizPartner = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jlDpsNumber = new javax.swing.JLabel();
        jtfDpsNumber = new javax.swing.JTextField();
        jpDetail = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jtfSeek = new javax.swing.JTextField();
        jbSeek = new javax.swing.JButton();
        jbExportCsv = new javax.swing.JButton();
        jbRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movimientos contables");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(792, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbClose.setText("Cerrar");
        jbClose.setToolTipText("[Escape]");
        jbClose.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Período:"));
        jPanel4.setPreferredSize(new java.awt.Dimension(220, 78));
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlYear.setText("Ejercicio contable:");
        jlYear.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlYear);

        jtfYear.setEditable(false);
        jtfYear.setText("YEAR");
        jtfYear.setFocusable(false);
        jtfYear.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel5.add(jtfYear);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDate.setText("Fecha de corte:");
        jlDate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel6.add(jlDate);

        jftDate.setText("dd/mm/yyyy");
        jftDate.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel6.add(jftDate);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbDate);

        jPanel4.add(jPanel6);

        jPanel3.add(jPanel4, java.awt.BorderLayout.WEST);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder("Saldo a la fecha de corte:"));
        jPanel11.setPreferredSize(new java.awt.Dimension(300, 78));
        jPanel11.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlBalanceCy.setText("Saldo actual:");
        jlBalanceCy.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel12.add(jlBalanceCy);

        jtfBalanceCy.setEditable(false);
        jtfBalanceCy.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfBalanceCy.setText("0,000,000,000.00");
        jtfBalanceCy.setFocusable(false);
        jtfBalanceCy.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel12.add(jtfBalanceCy);

        jtfBalanceCyCurKey.setEditable(false);
        jtfBalanceCyCurKey.setText("CUR");
        jtfBalanceCyCurKey.setFocusable(false);
        jtfBalanceCyCurKey.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel12.add(jtfBalanceCyCurKey);

        jPanel11.add(jPanel12);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlBalance.setText("Saldo actual (ML):");
        jlBalance.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlBalance);

        jtfBalance.setEditable(false);
        jtfBalance.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jtfBalance.setText("0,000,000,000.00");
        jtfBalance.setFocusable(false);
        jtfBalance.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel13.add(jtfBalance);

        jtfBalanceCurKey.setEditable(false);
        jtfBalanceCurKey.setText("CUR");
        jtfBalanceCurKey.setFocusable(false);
        jtfBalanceCurKey.setPreferredSize(new java.awt.Dimension(50, 23));
        jPanel13.add(jtfBalanceCurKey);

        jPanel11.add(jPanel13);

        jPanel3.add(jPanel11, java.awt.BorderLayout.EAST);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Asociado de negocios:"));
        jPanel7.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner.setText("Asociado de negocios:");
        jlBizPartner.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel9.add(jlBizPartner);

        jtfBizPartner.setEditable(false);
        jtfBizPartner.setText("BIZ PARTNER");
        jtfBizPartner.setFocusable(false);
        jtfBizPartner.setPreferredSize(new java.awt.Dimension(325, 23));
        jPanel9.add(jtfBizPartner);

        jPanel7.add(jPanel9);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDpsNumber.setText("Serie y folio:");
        jlDpsNumber.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel10.add(jlDpsNumber);

        jtfDpsNumber.setEditable(false);
        jtfDpsNumber.setText("NUMBER");
        jtfDpsNumber.setFocusable(false);
        jtfDpsNumber.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel10.add(jtfDpsNumber);

        jPanel7.add(jPanel10);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jpDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos contables:"));
        jpDetail.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 0));

        jtfSeek.setText("SEEK");
        jtfSeek.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel8.add(jtfSeek);

        jbSeek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_seek.gif"))); // NOI18N
        jbSeek.setToolTipText("Buscar");
        jbSeek.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbSeek);

        jbExportCsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_file_csv.gif"))); // NOI18N
        jbExportCsv.setToolTipText("Exportar CSV [Ctrl+E]");
        jbExportCsv.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbExportCsv);

        jbRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_reload.gif"))); // NOI18N
        jbRefresh.setToolTipText("Refrescar [Ctrl+R]");
        jbRefresh.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbRefresh);

        jpDetail.add(jPanel8, java.awt.BorderLayout.NORTH);

        jPanel2.add(jpDetail, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-1000)/2, (screenSize.height-600)/2, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int i = 0;
        STableColumnForm[] aoTableColumns = null;

        moPaneDetails = new STablePane(miClient);
        mvAccountLevels = null;

        madDpsBalance = null;

        moFieldDate = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDate, jlDate);
        moFieldDate.setPickerButton(jbDate);

        jpDetail.add(moPaneDetails, BorderLayout.CENTER);

        aoTableColumns = new STableColumnForm[27];
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Fecha", STableConstants.WIDTH_DATE);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "No. cuenta contable", STableConstants.WIDTH_ACCOUNT_ID);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Cuenta contable", STableConstants.WIDTH_ACCOUNT);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Concepto", 200);
        aoTableColumns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Cargos $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++].setSumApplying(true);
        aoTableColumns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Abonos $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++].setSumApplying(true);
        aoTableColumns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Saldo $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++].setSumApplying(true);
        aoTableColumns[i] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "T. cambio", STableConstants.WIDTH_EXCHANGE_RATE);
        aoTableColumns[i++].setCellRenderer(miClient.getSessionXXX().getFormatters().getTableCellRendererExchangeRate());
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Cargos mon. $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Abonos mon. $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Saldo mon. $", STableConstants.WIDTH_VALUE_2X);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Moneda", STableConstants.WIDTH_CURRENCY_KEY);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Subclase movimiento", 200);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Período póliza", STableConstants.WIDTH_YEAR_PERIOD);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Centro contable", STableConstants.WIDTH_CODE_COB);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Sucursal empresa", STableConstants.WIDTH_CODE_COB);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Folio póliza", STableConstants.WIDTH_RECORD_NUM);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_INTEGER, "#", STableConstants.WIDTH_NUM_TINYINT);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Sistema", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Diferencia cambiaria", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Eliminado", STableConstants.WIDTH_BOOLEAN);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. creación", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Creación", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. modificación", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Modificación", STableConstants.WIDTH_DATE_TIME);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. eliminación", STableConstants.WIDTH_USER);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Eliminación", STableConstants.WIDTH_DATE_TIME);

        for (i = 0; i < aoTableColumns.length; i++) {
            moPaneDetails.addTableColumn(aoTableColumns[i]);
        }

        jbClose.addActionListener(this);
        jbDate.addActionListener(this);
        jbSeek.addActionListener(this);
        jbRefresh.addActionListener(this);
        jbExportCsv.addActionListener(this);
        jtfSeek.addActionListener(this);

        SFormUtilities.createActionMap(this.getRootPane(), this, "focusSeek", "seek", KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this.getRootPane(), this, "actionExportCsv", "exportCsv", KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(this.getRootPane(), this, "actionRefresh", "refresh", KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionClose(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionCancel, "close", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        jtfBizPartner.setText(msParamBizPartnerName);
        jtfBizPartner.setToolTipText(msParamBizPartnerName);
        jtfDpsNumber.setText(msParamDpsNumber);
        renderTextDpsNumber();
        jbClose.requestFocus();
    }

    private void actionClose() {
        setVisible(false);
    }

    private void actionSetDate() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDate.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDate.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDate.requestFocus();
        }
    }

    private void renderTextDpsNumber() {
        if (isDpsMovements()) {
            jlDpsNumber.setEnabled(true);
            jtfDpsNumber.setEnabled(true);
        }
        else {
            jlDpsNumber.setEnabled(false);
            jtfDpsNumber.setEnabled(false);
        }
    }

    private void readDpsBalance(java.util.Date ptDate) {
        SDataDps oDps = (SDataDps) SDataUtilities.readRegistry(miClient, SDataConstants.TRN_DPS, manParamDpsKey, SLibConstants.EXEC_MODE_SILENT);

        try {
                madDpsBalance = SDataUtilities.obtainDpsBalance(miClient, manParamDpsKey, miClient.getSessionXXX().getWorkingYear(), ptDate);
            }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }

        jlBalanceCy.setEnabled(true);
        jlBalance.setEnabled(true);

        jtfBalanceCy.setText(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat().format(madDpsBalance[1]));
        jtfBalanceCyCurKey.setText(oDps.getDbmsCurrencyKey());

        if (oDps.getFkCurrencyId() == miClient.getSessionXXX().getParamsErp().getFkCurrencyId()) {
            jtfBalance.setText("");
            jtfBalanceCurKey.setText("");
        }
        else {
            jtfBalance.setText(miClient.getSessionXXX().getFormatters().getDecimalsValueFormat().format(madDpsBalance[0]));
            jtfBalanceCurKey.setText(miClient.getSessionXXX().getParamsErp().getDbmsDataCurrency().getKey());
        }
    }

    private boolean isDpsMovements() {
        boolean bIsDps = false;

        if (manParamDpsKey != null) {
            bIsDps = true;
        }

        return bIsDps;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbExportCsv;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbSeek;
    private javax.swing.JFormattedTextField jftDate;
    private javax.swing.JLabel jlBalance;
    private javax.swing.JLabel jlBalanceCy;
    private javax.swing.JLabel jlBizPartner;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlDpsNumber;
    private javax.swing.JLabel jlYear;
    private javax.swing.JPanel jpDetail;
    private javax.swing.JTextField jtfBalance;
    private javax.swing.JTextField jtfBalanceCurKey;
    private javax.swing.JTextField jtfBalanceCy;
    private javax.swing.JTextField jtfBalanceCyCurKey;
    private javax.swing.JTextField jtfBizPartner;
    private javax.swing.JTextField jtfDpsNumber;
    private javax.swing.JTextField jtfSeek;
    private javax.swing.JTextField jtfYear;
    // End of variables declaration//GEN-END:variables

    public void focusSeek() {
        if (jtfSeek.isEnabled()) {
            jtfSeek.requestFocus();
        }
    }

    public void actionSeek() {
        if (jbSeek.isEnabled()) {
            STableUtilities.actionSeek(miClient, moPaneDetails, jtfSeek.getText().trim());
        }
    }

    public void actionExportCsv() {
        if (jbExportCsv.isEnabled()) {
            STableUtilities.actionExportCsv(miClient, moPaneDetails, getTitle());
        }
    }

    public void actionRefresh() {
        showAccountingDetail(SLibTimeUtilities.digestYear(moFieldDate.getDate())[0], moFieldDate.getDate());
    }

    public void refreshAccountingDetail() {
        moParamPrimaryKey = null;
        mnParamYear = 0;
        mtParamDate = null;
        manParamCurrencyKey = null;

        jtfSeek.setText("");
        jtfSeek.setEnabled(false);
        jbSeek.setEnabled(false);
        jbExportCsv.setEnabled(false);

        jlBalanceCy.setEnabled(false);
        jlBalance.setEnabled(false);

        jtfBalanceCy.setText("");
        jtfBalanceCyCurKey.setText("");

        jtfBalance.setText("");
        jtfBalanceCurKey.setText("");
    }

    @SuppressWarnings("unchecked")
    public void showAccountingDetail(int pnYear, java.util.Date ptDate) {
        int nYearDpsPrevious = 0;
        int nDocDpsPrevious = 0;
        int nYearDps = 0;
        int nDocDps = 0;
        double dDebit = 0;
        double dCredit = 0;
        double dBalance = 0;
        double dBalanceCurrency = 0;
        double dDebitCurrency = 0;
        double dCreditCurrency = 0;
        double dBalanceDps = 0;
        double dBalanceDpsCurrency = 0;
        double dDebitTotal = 0;
        double dCreditTotal = 0;
        double dBalanceTotal = 0;
        double dBalanceCurrencyTotal = 0;
        double dDebitCurrencyTotal = 0;
        double dCreditCurrencyTotal = 0;
        String sCur = "";
        String sSql = "";
        String sSqlConcept = "";
        String sSqlFromPrevious = "";
        String sSqlFromCurrent = "";
        String sConcept = "";
        String sTemp = "";
        java.util.Date tPrevious = SLibTimeUtilities.addDate(SLibTimeUtilities.getBeginOfYear(ptDate), 0, 0, -1);
        Vector<Vector<Object>> vQueryRows = null;
        SDataDps oDps = null;
        SDialogAccountingDetailDpsBizPartnerRow oRow = null;
        SServerRequest oRequest = null;
        SServerResponse oResponse = null;

        mnParamYear = pnYear;
        mtParamDate = ptDate;

        jtfYear.setText("" + mnParamYear);
        moFieldDate.setFieldValue(mtParamDate);

        moPaneDetails.createTable();
        moPaneDetails.clearTableRows();

        try {
            sTemp = "FROM fin_rec AS r INNER JOIN fin_rec_ety AS re ON " +
                    "r.id_year = " + mnParamYear + " AND r.b_del = FALSE AND ";
            sSqlFromPrevious += sTemp;
            sSqlFromCurrent = sSqlFromPrevious;
            sSqlFromPrevious += "r.dt < " +
                    "'" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(SLibTimeUtilities.getBeginOfYear(mtParamDate)) + "' AND ";
            sSqlFromCurrent += "r.dt <= " +
                    "'" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(mtParamDate) + "' AND ";
            sTemp = "r.id_year = re.id_year AND r.id_per = re.id_per AND r.id_bkc = re.id_bkc AND " +
                    "r.id_tp_rec = re.id_tp_rec AND r.id_num = re.id_num AND re.b_del = FALSE ";

            switch (mnParamDpsCategory) {
                case SDataConstantsSys.TRNS_CT_DPS_PUR:
                    sTemp += "AND re.fid_ct_sys_mov_xxx = " + SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP[0] + " AND re.fid_tp_sys_mov_xxx = " +
                            SDataConstantsSys.FINS_TP_SYS_MOV_BPS_SUP[1] + " ";
                    break;
                case SDataConstantsSys.TRNS_CT_DPS_SAL:
                    sTemp += "AND re.fid_ct_sys_mov_xxx = " + SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[0] + " AND re.fid_tp_sys_mov_xxx = " +
                            SDataConstantsSys.FINS_TP_SYS_MOV_BPS_CUS[1] + " ";
                    break;
            }

            sSqlFromPrevious += sTemp;
            sSqlFromCurrent += sTemp;

            sSql = "SELECT r.id_year, r.id_per, r.id_bkc, r.id_tp_rec, r.id_num, r.dt, re.concept, r.b_sys, r.b_del, " +
                    "f_acc_usr(" + ((SDataParamsCompany) miClient.getSession().getConfigCompany()).getMaskAccount() + ", a.code) AS f_acc, a.acc, bkc.code, cob.code, mtp.tp_acc_mov, mcl.cl_acc_mov, mcls.cls_acc_mov, un.usr, ue.usr, ud.usr, " +
                    "c.id_cur AS f_id_cur, c.cur_key AS f_cur_key, " +
                    "re.sort_pos, re.debit, re.credit, re.exc_rate, re.ts_new, re.ts_edit, re.ts_del, i.item, " +
                    "xe.ent, xb.bp, re.fid_dps_year_n, re.fid_dps_doc_n, re.debit_cur, re.credit_cur, re.b_exc_diff " +
                    sSqlFromCurrent +
                    "INNER JOIN fin_bkc AS bkc ON r.id_bkc = bkc.id_bkc " +
                    "INNER JOIN erp.bpsu_bpb AS cob ON r.fid_cob = cob.id_bpb " +
                    "INNER JOIN fin_acc AS a ON re.fid_acc = a.id_acc " +
                    "INNER JOIN erp.cfgu_cur AS c ON re.fid_cur = c.id_cur " +
                    "INNER JOIN erp.fins_tp_acc_mov AS mtp ON re.fid_tp_acc_mov = mtp.id_tp_acc_mov " +
                    "INNER JOIN erp.fins_cl_acc_mov AS mcl ON re.fid_tp_acc_mov = mcl.id_tp_acc_mov AND re.fid_cl_acc_mov = mcl.id_cl_acc_mov " +
                    "INNER JOIN erp.fins_cls_acc_mov AS mcls ON re.fid_tp_acc_mov = mcls.id_tp_acc_mov AND re.fid_cl_acc_mov = mcls.id_cl_acc_mov AND re.fid_cls_acc_mov = mcls.id_cls_acc_mov " +
                    "INNER JOIN erp.usru_usr AS un ON re.fid_usr_new = un.id_usr " +
                    "INNER JOIN erp.usru_usr AS ue ON re.fid_usr_edit = ue.id_usr " +
                    "INNER JOIN erp.usru_usr AS ud ON re.fid_usr_del = ud.id_usr " +
                    "LEFT OUTER JOIN erp.itmu_item AS i ON re.fid_item_n = i.id_item " +
                    "LEFT OUTER JOIN erp.cfgu_cob_ent AS xe ON re.fid_cob_n = xe.id_cob AND re.fid_ent_n = xe.id_ent " +
                    "LEFT OUTER JOIN erp.bpsu_bp AS xb ON re.fid_bp_nr = xb.id_bp " +
                    "WHERE " + (isDpsMovements() ?
                        "re.fid_dps_year_n = " + (manParamDpsKey)[0] + " AND re.fid_dps_doc_n = " + manParamDpsKey[1] :
                        "re.fid_bp_nr = " + manParamBizPartnerKey[0]) + " " +
                    "ORDER BY re.fid_dps_year_n, re.fid_dps_doc_n, r.dt, r.id_year, r.id_per, bkc.code, r.id_bkc, r.id_tp_rec, r.id_num ";

            oRequest = new SServerRequest(SServerConstants.REQ_DB_QUERY_SIMPLE, sSql);
            oResponse = miClient.getSessionXXX().request(oRequest);

            if (oResponse.getResponseType() != SSrvConsts.RESP_TYPE_OK) {
                throw new Exception(oResponse.getMessage());
            }
            else {
                vQueryRows = (Vector<Vector<Object>>) oResponse.getPacket();
                for (int i = 0 ; i < vQueryRows.size(); i++) {
                    dDebit = ((Number) vQueryRows.get(i).get(22)).doubleValue();
                    dCredit = ((Number) vQueryRows.get(i).get(23)).doubleValue();
                    dDebitTotal += dDebit;
                    dCreditTotal += dCredit;
                    dDebitCurrency = ((Number) vQueryRows.get(i).get(33)).doubleValue();
                    dCreditCurrency = ((Number) vQueryRows.get(i).get(34)).doubleValue();
                    dDebitCurrencyTotal += dDebitCurrency;
                    dCreditCurrencyTotal += dCreditCurrency;
                    dBalance += (dDebit - dCredit);
                    dBalanceTotal += dBalance;
                    dBalanceCurrency += (dDebitCurrency - dCreditCurrency);
                    dBalanceCurrencyTotal += dBalanceCurrency;
                    dBalanceDps += (dDebit - dCredit);
                    dBalanceDpsCurrency += (dDebitCurrency - dCreditCurrency);
                    nYearDpsPrevious = vQueryRows.get(i).get(31) == null ? 0 :((Number) vQueryRows.get(i).get(31)).intValue();
                    nDocDpsPrevious = vQueryRows.get(i).get(32) == null ? 0 : ((Number) vQueryRows.get(i).get(32)).intValue();

                    sConcept = (String) vQueryRows.get(i).get(10);

                    if (vQueryRows.get(i).get(29) != null) {
                        sConcept += "; " + (String) vQueryRows.get(i).get(29);
                    }
                    if (vQueryRows.get(i).get(30) != null) {
                        sConcept += "; " + (String) vQueryRows.get(i).get(30);
                    }

                    if (vQueryRows.get(i).get(28) != null) {
                        sConcept += "; " + (String) vQueryRows.get(i).get(28);
                    }

                    oRow = new SDialogAccountingDetailDpsBizPartnerRow(miClient);
                    oRow.setDate((java.util.Date) vQueryRows.get(i).get(5));
                    oRow.setConcept((String) vQueryRows.get(i).get(6));
                    oRow.setFkAccountId((String) vQueryRows.get(i).get(9));
                    oRow.setDbmsAccount(sConcept);
                    oRow.setDebit(dDebit);
                    oRow.setCredit(dCredit);
                    oRow.setBalance(!isDpsMovements() ? dBalanceDps : dBalance);
                    oRow.setExchangeRate(((Number) vQueryRows.get(i).get(24)).doubleValue());
                    oRow.setDebitCurrency(dDebitCurrency);
                    oRow.setCreditCurrency(dCreditCurrency);
                    oRow.setBalanceCurrency(!isDpsMovements() ? dBalanceDpsCurrency : dBalanceCurrency);
                    oRow.setDbmsCurrencyKey((String) vQueryRows.get(i).get(20));
                    oRow.setDbmsAccountingMoveSubclass((String) vQueryRows.get(i).get(15));
                    oRow.setPkYearId((Integer) vQueryRows.get(i).get(0));
                    oRow.setPkPeriodId((Integer) vQueryRows.get(i).get(1));
                    oRow.setDbmsBookkeepingCenterCode((String) vQueryRows.get(i).get(11));
                    oRow.setDbmsCompanyBranchCode((String) vQueryRows.get(i).get(12));
                    oRow.setPkRecordTypeId((String) vQueryRows.get(i).get(3));
                    oRow.setPkNumberId(((Number) vQueryRows.get(i).get(4)).intValue());
                    oRow.setSortingPosition(((Number) vQueryRows.get(i).get(21)).intValue());
                    oRow.setIsSystem((Boolean) vQueryRows.get(i).get(7));
                    oRow.setIsExchangeDifference((Boolean) vQueryRows.get(i).get(35));
                    oRow.setIsDeleted((Boolean) vQueryRows.get(i).get(8));
                    oRow.setDbmsUserNew((String) vQueryRows.get(i).get(16));
                    oRow.setUserNewTs((java.util.Date) vQueryRows.get(i).get(25));
                    oRow.setDbmsUserEdit((String) vQueryRows.get(i).get(17));
                    oRow.setUserEditTs((java.util.Date) vQueryRows.get(i).get(26));
                    oRow.setDbmsUserDelete((String) vQueryRows.get(i).get(18));
                    oRow.setUserDeleteTs((java.util.Date) vQueryRows.get(i).get(27));
                    oRow.prepareTableRow();
                    moPaneDetails.addTableRow(oRow);

                    if (!isDpsMovements()) {
                        if (i + 1 < vQueryRows.size()) {
                            nYearDps = vQueryRows.get(i + 1).get(31) == null ? 0 :((Number) vQueryRows.get(i + 1).get(31)).intValue();
                            nDocDps = vQueryRows.get(i + 1).get(32) == null ? 0 : ((Number) vQueryRows.get(i + 1).get(32)).intValue();
                            if ((nYearDpsPrevious != nYearDps && nDocDpsPrevious != nDocDps) || (nYearDpsPrevious == nYearDps && nDocDpsPrevious != nDocDps)) {
                                if (nYearDpsPrevious > 0 && nDocDpsPrevious > 0) {
                                    oDps = (SDataDps) SDataUtilities.readRegistry(miClient, SDataConstants.TRN_DPS, new int[] { ((Number) vQueryRows.get(i).get(31)).intValue(),
                                    ((Number) vQueryRows.get(i).get(32)).intValue() }, SLibConstants.EXEC_MODE_SILENT);
                                }
                                oRow = new SDialogAccountingDetailDpsBizPartnerRow(miClient);
                                oRow.setConcept("SALDO " + (oDps != null ? "DOC. " + oDps.getNumberSeries() + (oDps.getNumberSeries().length() == 0 ? "" : "-") + oDps.getNumber() : "SIN DOC."));
                                oRow.setBalance(dBalanceDps);
                                oRow.setBalanceCurrency(dBalanceDpsCurrency);
                                oRow.prepareTableRow();
                                moPaneDetails.addTableRow(oRow);
                                dBalanceDps = 0;
                                dBalanceDpsCurrency = 0;
                            }
                        }
                        else if (i == vQueryRows.size() -1 && vQueryRows.get(i).get(31) != null && vQueryRows.get(i).get(32) != null) {
                            nYearDps = vQueryRows.get(i).get(31) == null ? 0 :((Number) vQueryRows.get(i).get(31)).intValue();
                            nDocDps = vQueryRows.get(i).get(32) == null ? 0 : ((Number) vQueryRows.get(i).get(32)).intValue();
                            oDps = (SDataDps) SDataUtilities.readRegistry(miClient, SDataConstants.TRN_DPS, new int[] { ((Number) vQueryRows.get(i).get(31)).intValue(),
                                    ((Number) vQueryRows.get(i).get(32)).intValue() }, SLibConstants.EXEC_MODE_SILENT);
                            oRow = new SDialogAccountingDetailDpsBizPartnerRow(miClient);
                            oRow.setConcept("SALDO " + (oDps != null ? "DOC. " + oDps.getNumberSeries() + (oDps.getNumberSeries().length() == 0 ? "" : "-") + oDps.getNumber() : "SIN DOC."));
                            oRow.setBalance(dBalanceDps);
                            oRow.setBalanceCurrency(dBalanceDpsCurrency);
                            oRow.prepareTableRow();
                            moPaneDetails.addTableRow(oRow);
                            dBalanceDps = 0;
                            dBalanceDpsCurrency = 0;
                        }
                    }
                }

                oRow = new SDialogAccountingDetailDpsBizPartnerRow(miClient);
                oRow.setConcept("TOTALES");
                oRow.setDebit(dDebitTotal);
                oRow.setCredit(dCreditTotal);
                oRow.setBalance(dDebitTotal - dCreditTotal);

                oRow.prepareTableRow();
                moPaneDetails.addTableRow(oRow);
            }

            moPaneDetails.renderTableRows();
            moPaneDetails.setTableRowSelection(0);

            if (moPaneDetails.getTableGuiRowCount() > 0) {
                jtfSeek.setEnabled(true);
                jbSeek.setEnabled(true);
                jbExportCsv.setEnabled(true);
            }

            if (isDpsMovements()) {
                readDpsBalance(ptDate);
            }

            if (!isVisible()) {
                setVisible(true);
            }
        }
        catch (Exception e) {
            SLibUtilities.renderException(this, e);
        }
    }

    public void setParamDpsCategory(int dpsCategory) { mnParamDpsCategory = dpsCategory; }
    public void setParamBizPartnerName(String name) { msParamBizPartnerName = name; }
    public void setParamDpsNumber(String number) { msParamDpsNumber = number; }
    public void setParamDpsKey(java.lang.Object o) { manParamDpsKey = (int[]) o; }
    public void setParamBizPartnerKey(java.lang.Object o) { manParamBizPartnerKey = (int[]) o; }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbClose) {
                actionClose();
            }
            else if (button == jbSeek) {
                actionSeek();
            }
            else if (button == jbExportCsv) {
                actionExportCsv();
            }
            else if (button == jbRefresh) {
                actionRefresh();
            }
            else if (button == jbDate) {
                actionSetDate();
            }
        }
        else if (e.getSource() instanceof javax.swing.JTextField) {
            JTextField textField = (JTextField) e.getSource();

            if (textField == jtfSeek) {
                actionSeek();
            }
        }
    }
}
