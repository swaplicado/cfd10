/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mtrn.form;

import erp.client.SClientInterface;
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
import erp.mitm.data.SDataUnitType;
import erp.mod.SModConsts;
import erp.mtrn.utils.STrnFunAreasUtils;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Flores, Edwin Carmona
 */
public class SDialogRepSalesPurchasesFileCsv extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private int mnCategoryId;
    private int mnOptionPickerId;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.lang.String msFileName;
    private java.lang.String msBizPartner;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDateBegin;
    private erp.lib.form.SFormField moFieldDateEnd;
    private erp.lib.form.SFormField moFieldUnitType;
    private erp.lib.form.SFormField moFieldDocClass;
    private erp.lib.form.SFormField moFieldBizPartner;
    
    private erp.mtrn.form.SDialogFilterFunctionalArea moDialogFilterFunctionalArea;
    private int mnFunctionalAreaId;
    private int[] manDataFilter;
    private String msFunctionalAreasIds;

    /** Creates new form SDialogRepSalesPurchasesComparative
     * @param client ERP Client interface.
     * @param formType Constants defined in SDataConstantsSys (TRNS_CT_DPS_PUR or TRNS_CT_DPS_SAL).
     */
    public SDialogRepSalesPurchasesFileCsv(erp.client.SClientInterface client, int formType) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = formType;

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
        jbClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDateBegin = new javax.swing.JLabel();
        jftDateBegin = new javax.swing.JFormattedTextField();
        jbDateBegin = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jftDateEnd = new javax.swing.JFormattedTextField();
        jbDateEnd = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlUnitType = new javax.swing.JLabel();
        jcbUnitType = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jlDocClass = new javax.swing.JLabel();
        jcbDocClass = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jlBizPartner = new javax.swing.JLabel();
        jcbBizPartner = new javax.swing.JComboBox<>();
        jbBizPartner = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jlBizPartner1 = new javax.swing.JLabel();
        jtfFunctionalArea = new javax.swing.JTextField();
        jbFunctionalArea = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jckWithoutRelatedParty = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Archivo CSV de compras/ventas netas por período");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(392, 33));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbPrint.setText("Guardar");
        jbPrint.setToolTipText("[Ctrl + Enter]");
        jbPrint.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jbPrint.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbPrint);

        jbClose.setText("Cerrar");
        jbClose.setToolTipText("[Escape]");
        jbClose.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jbClose.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Configuración del reporte:"));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Período actual:"));
        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateBegin.setText("Fecha inicial: *");
        jlDateBegin.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel4.add(jlDateBegin);

        jftDateBegin.setText("dd/mm/yyyy");
        jftDateBegin.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel4.add(jftDateBegin);

        jbDateBegin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbDateBegin.setToolTipText("Seleccionar fecha inicial");
        jbDateBegin.setFocusable(false);
        jbDateBegin.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDateBegin);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 0));

        jlDateEnd.setText("Fecha final: *");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(125, 23));
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

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones del reporte:"));
        jPanel9.setLayout(new java.awt.BorderLayout(0, 1));

        jPanel6.setLayout(new java.awt.GridLayout(5, 1, 0, 2));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlUnitType.setText("Tipo de unidad: *");
        jlUnitType.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel7.add(jlUnitType);

        jcbUnitType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccionar tipo de unidad)", "LONGITUD", "SUPERFICIE", "VOLUMEN", "MASA" }));
        jcbUnitType.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel7.add(jcbUnitType);

        jPanel6.add(jPanel7);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDocClass.setText("Tipo de documento: *");
        jlDocClass.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel8.add(jlDocClass);

        jcbDocClass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "(Seleccionar tipo de documento)", "FACTURAS", "PEDIDOS", "CONTRATOS" }));
        jcbDocClass.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel8.add(jcbDocClass);

        jPanel6.add(jPanel8);

        jPanel10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner.setText("Asociado negocios:");
        jlBizPartner.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel10.add(jlBizPartner);

        jcbBizPartner.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel10.add(jcbBizPartner);

        jbBizPartner.setText("jButton1");
        jbBizPartner.setToolTipText("Seleccionar asociado de negocios");
        jbBizPartner.setFocusable(false);
        jbBizPartner.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel10.add(jbBizPartner);

        jPanel6.add(jPanel10);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlBizPartner1.setText("Área funcional:");
        jlBizPartner1.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel14.add(jlBizPartner1);

        jtfFunctionalArea.setEditable(false);
        jtfFunctionalArea.setPreferredSize(new java.awt.Dimension(266, 23));
        jPanel14.add(jtfFunctionalArea);

        jbFunctionalArea.setText("...");
        jbFunctionalArea.setToolTipText("Seleccionar asociado de negocios:");
        jbFunctionalArea.setFocusable(false);
        jbFunctionalArea.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel14.add(jbFunctionalArea);

        jPanel6.add(jPanel14);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jLabel1.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel11.add(jLabel1);

        jckWithoutRelatedParty.setText("Sin partes relacionadas");
        jPanel11.add(jckWithoutRelatedParty);

        jPanel6.add(jPanel11);

        jPanel9.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel9, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(524, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDateBegin = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateBegin, jlDateBegin);
        moFieldDateBegin.setPickerButton(jbDateBegin);
        moFieldDateEnd = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateEnd, jlDateEnd);
        moFieldDateEnd.setPickerButton(jbDateEnd);
        moFieldUnitType = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbUnitType, jlUnitType);
        moFieldDocClass = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbDocClass, jlDocClass);
        moFieldBizPartner = new SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jcbBizPartner, jlBizPartner);
        moFieldBizPartner.setPickerButton(jbBizPartner);

        mvFields.add(moFieldDateBegin);
        mvFields.add(moFieldDateEnd);
        mvFields.add(moFieldUnitType);
        mvFields.add(moFieldDocClass);
        mvFields.add(moFieldBizPartner);

        jbPrint.addActionListener(this);
        jbClose.addActionListener(this);
        jbDateBegin.addActionListener(this);
        jbDateEnd.addActionListener(this);
        jbBizPartner.addActionListener(this);
        jbFunctionalArea.addActionListener(this);

        switch (mnFormType) {
            case SDataConstantsSys.TRNS_CT_DPS_PUR:
                mnCategoryId = SDataConstantsSys.BPSS_CT_BP_SUP;
                mnOptionPickerId = SDataConstants.BPSX_BP_SUP;
                msFileName = "Compras";
                msBizPartner = "PROVEEDOR";
                setTitle("Archivo de exportación de compras netas por período");
                jlBizPartner.setText("Proveedor:");
                break;
            case SDataConstantsSys.TRNS_CT_DPS_SAL:
                mnCategoryId = SDataConstantsSys.BPSS_CT_BP_CUS;
                mnOptionPickerId = SDataConstants.BPSX_BP_CUS;
                msFileName = "Ventas";
                msBizPartner = "CLIENTE";
                setTitle("Archivo de exportación de ventas netas por período");
                jlBizPartner.setText("Cliente:");
                break;
            default:
                SLibUtilities.renderException(this, new Exception(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION));
        }

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
        
        //Áreas funcionales
        mnFunctionalAreaId = SLibConstants.UNDEFINED;
        manDataFilter = new int[] { miClient.getSession().getUser().getPkUserId() };
        moDialogFilterFunctionalArea = new SDialogFilterFunctionalArea((SClientInterface) miClient, SModConsts.CFGU_FUNC, manDataFilter);
        
        renderText();
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jftDateBegin.requestFocus();
        }
    }
    
    private String replaceQuotes(final String string) {
        return string.replace("\"", "'");
    }
    
    private void actionFunctionalArea() {
        moDialogFilterFunctionalArea.formRefreshCatalogues();
        moDialogFilterFunctionalArea.formReset();
        moDialogFilterFunctionalArea.setFunctionalAreaId(mnFunctionalAreaId);
        moDialogFilterFunctionalArea.setFormVisible(true);

        if (moDialogFilterFunctionalArea.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
            mnFunctionalAreaId = moDialogFilterFunctionalArea.getFunctionalAreaId();
            renderText();
        }
    }
    
    private void renderText() {
        String texts[] = STrnFunAreasUtils.getFunAreasTextFilter((SClientInterface) miClient, mnFunctionalAreaId);
        msFunctionalAreasIds = texts[0];
        
        jtfFunctionalArea.setText(texts[1]);
        jtfFunctionalArea.setCaretPosition(0);
    }

    @SuppressWarnings("unchecked")
    private void actionPrint() {
        String sql = "";
        ResultSet resulSet = null;
        String field = "";
        String buffer = "";
        String address = "";
        String docClass = "";
        SDataUnitType unitType = null;
        Cursor cursor = getCursor();
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
            try {
                miClient.getFileChooser().setSelectedFile(new File(msFileName + " netas " + miClient.getSessionXXX().getFormatters().getFileNameDatetimeFormat().format(new java.util.Date()) + ".csv"));
                if (miClient.getFileChooser().showSaveDialog(miClient.getFrame()) == JFileChooser.APPROVE_OPTION) {
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));

                    File file = new File(miClient.getFileChooser().getSelectedFile().getAbsolutePath());
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));

                    switch (jcbUnitType.getSelectedIndex()) {
                        case 1:
                            field = "len";
                            unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT,
                                    new int[] { SDataConstantsSys.ITMU_TP_UNIT_LEN }, SLibConstants.EXEC_MODE_VERBOSE);
                            break;
                        case 2:
                            field = "surf";
                            unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT,
                                    new int[] { SDataConstantsSys.ITMU_TP_UNIT_SURF }, SLibConstants.EXEC_MODE_VERBOSE);
                            break;
                        case 3:
                            field = "vol";
                            unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT,
                                    new int[] { SDataConstantsSys.ITMU_TP_UNIT_VOL }, SLibConstants.EXEC_MODE_VERBOSE);
                            break;
                        case 4:
                            field = "mass";
                            unitType = (SDataUnitType) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_TP_UNIT,
                                    new int[] { SDataConstantsSys.ITMU_TP_UNIT_MASS }, SLibConstants.EXEC_MODE_VERBOSE);
                            break;
                    }

                    if (jcbDocClass.getSelectedIndex() == 1) {
                        docClass = "" + SDataConstantsSys.TRNS_CL_DPS_PUR_DOC[1] + ", 4, " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + "";
                    }
                    else if (jcbDocClass.getSelectedIndex() == 2) {
                        docClass = "" + SDataConstantsSys.TRNS_CL_DPS_PUR_ORD[1] + "";
                    }
                    else if (jcbDocClass.getSelectedIndex() == 3) {
                        docClass = "" + SDataConstantsSys.TRNS_CL_DPS_PUR_EST[1] + "";
                    }

                    buffer = "\"EJERCICIO\",\"PERÍODO\",\"CLAVE " + msBizPartner + "\",\"" + msBizPartner + "\",\"PARTE REL.\",\"SUCURSAL " + msBizPartner + "\","
                            + "\"DOMICILIO OPERACIONES\","
                            + "\"ID CANAL\",\"CANAL\",\"ID SEGMENTO\",\"SEGMENTO\",\"ID SUBSEGMENTO\",\"SUBSEGMENTO\","
                            + "\"FECHA\",\"ENTREGA PROGRAMADA\",\"FOLIO DOC.\",\"REFERENCIA DOC.\",\"DOC. AFECTADO\",\"PARTIDA\","
                            + "\"CÓDIGO ÍTEM GENÉRICO\",\"ÍTEM GENÉRICO\",\"CLAVE ÍTEM\",\"ÍTEM\",\"TIPO ÍTEM\","
                            + "\"CANTIDAD NETA\","
                            + "\"UNIDAD CANTIDAD\",\"PRECIO UNITARIO\","
                            + "\"IMPORTE NETO\",\"" + jcbUnitType.getSelectedItem() + " NETO(A)\","
                            + "\"UNIDAD " + jcbUnitType.getSelectedItem() + "\","
                            + "\"ID AGENTE\",\"AGENTE\",\"ID RUTA\",\"RUTA\","
                            + "\"ID PAÍS\",\"PAÍS\",\"PAÍS ABR\","
                            + "\"ESTADO\",\"MUNICIPIO\",\"LOCALIDAD\"";

                    bw.write(SLibUtilities.textToAscii(buffer));

                    sql = "SELECT YEAR(d.dt) AS f_year, MONTH(d.dt) AS f_month, cb.bp_key, b.bp, b.b_att_rel_pty, bb.bpb, "
                            + "bba.street, bba.street_num_ext, bba.street_num_int, bba.neighborhood, bba.reference, "
                            + "bba.locality, bba.county, bba.state, bba.zip_code, "
                            + "ds.id_dist_chan, ds.dist_chan, ms.id_mkt_segm, ms.mkt_segm, mss.id_mkt_sub, mss.mkt_segm_sub, "
                            + "d.dt, d.dt_doc_delivery_n, CONCAT(d.num_ser, IF(length(d.num_ser) = 0, '', '-'), d.num) AS f_num, d.num_ref, "
                            + "IF(d.fid_cl_dps = " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", CONCAT(dd.num_ser, IF(length(dd.num_ser) = 0, '', '-'), dd.num), '') AS f_num_afec, "
                            + "de.sort_pos, ig.code, ig.igen, i.item_key, i.item, it.code, "
                            + "SUM(IF(d.fid_cl_dps = " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, de.qty)) AS f_qty, "
                            + "SUM(IF(d.fid_cl_dps <> " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, "
                            + "IF(de.fid_tp_dps_adj <> " + SDataConstantsSys.TRNS_TP_DPS_ADJ_RET + ", 0, de.qty))) AS f_qty_ret, "
                            + "u.symbol, de.price_u, "
                            + "SUM(IF(d.fid_cl_dps = " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, de.stot_r)) AS f_amt, "
                            + "SUM(IF(d.fid_cl_dps <> " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, "
                            + "IF(de.fid_tp_dps_adj <> " + SDataConstantsSys.TRNS_TP_DPS_ADJ_RET + ", 0, de.stot_r))) AS f_amt_ret, "
                            + "SUM(IF(d.fid_cl_dps <> " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, "
                            + "IF(de.fid_tp_dps_adj <> " + SDataConstantsSys.TRNS_TP_DPS_ADJ_DISC + ", 0, de.stot_r))) AS f_amt_disc, "
                            + "SUM(IF(d.fid_cl_dps = " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, de." + field + ")) AS f_unt, "
                            + "SUM(IF(d.fid_cl_dps <> " + SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1] + ", 0, "
                            + "IF(de.fid_tp_dps_adj <> " + SDataConstantsSys.TRNS_TP_DPS_ADJ_RET + ", 0, de." + field + "))) AS f_unt_ret, "
                            + "'" + unitType.getUnitBase() + "' AS f_unt_symbol, "
                            + "sa.id_bp AS f_sa_id, sa.bp AS f_sa, sr.id_sal_route, sr.sal_route, "
                            + "COALESCE(cty.id_cty, " + miClient.getSession().getSessionCustom().getLocalCountryKey()[0] + ") AS f_id_cty, "
                            + "COALESCE(cty.cty, '" + miClient.getSession().getSessionCustom().getLocalCountry() + "') AS f_cty, "
                            + "COALESCE(cty.cty_abbr, '" + miClient.getSession().getSessionCustom().getLocalCountryCode() + "') AS f_cty_abbr " +
                            "FROM trn_dps AS d " +
                            "INNER JOIN trn_dps_ety AS de ON d.id_year = de.id_year AND d.id_doc = de.id_doc AND d.b_del = 0 AND de.b_del = 0 AND " +
                            "d.fid_st_dps = " + SDataConstantsSys.TRNS_ST_DPS_EMITED + " AND " +
                            "d.fid_st_dps_val = " + SDataConstantsSys.TRNS_ST_DPS_VAL_EFF + " AND " +
                            "d.fid_ct_dps = " + mnFormType + " AND d.fid_cl_dps IN (" + docClass + ") AND " +
                            "d.dt BETWEEN '" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(moFieldDateBegin.getDate()) + "' AND " +
                            "'" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(moFieldDateEnd.getDate()) + "' AND " +
                            "d.fid_func IN ( " + msFunctionalAreasIds + " ) " + 
                            "INNER JOIN erp.bpsu_bp AS b ON d.fid_bp_r = b.id_bp " + ( moFieldBizPartner.getKeyAsIntArray()[0] == 0 ? "" : " AND d.fid_bp_r = " + moFieldBizPartner.getKeyAsIntArray()[0]) + " " + (jckWithoutRelatedParty.isSelected() ? " AND b.b_att_rel_pty = 0 " : "") +
                            "INNER JOIN erp.bpsu_bpb AS bb ON d.fid_bpb = bb.id_bpb " +
                            "INNER JOIN erp.bpsu_bpb_add AS bba ON d.fid_bpb = bba.id_bpb AND d.fid_add = bba.id_add " +
                            "INNER JOIN erp.bpsu_bp_ct AS cb ON d.fid_bp_r = cb.id_bp AND cb.id_ct_bp = " + mnCategoryId + " " +
                            "INNER JOIN erp.itmu_item AS i ON de.fid_item = i.id_item " +
                            "INNER JOIN erp.itmu_unit AS u ON de.fid_unit = u.id_unit " +
                            "INNER JOIN erp.itmu_igen AS ig ON i.fid_igen = ig.id_igen " +
                            "INNER JOIN erp.itms_tp_item AS it ON ig.fid_ct_item = it.id_ct_item AND ig.fid_cl_item = it.id_cl_item AND ig.fid_tp_item = it.id_tp_item " +
                            "LEFT OUTER JOIN erp.locu_cty AS cty ON bba.fid_cty_n = cty.id_cty " +
                            "LEFT OUTER JOIN mkt_cfg_cus AS cc ON b.id_bp = cc.id_cus " +
                            "LEFT OUTER JOIN mkt_cfg_cusb AS ccb ON bb.id_bpb = ccb.id_cusb " +
                            "LEFT OUTER JOIN mktu_tp_cus AS tc ON cc.fid_tp_cus = tc.id_tp_cus " +
                            "LEFT OUTER JOIN mktu_mkt_segm AS ms ON cc.fid_mkt_segm = ms.id_mkt_segm " +
                            "LEFT OUTER JOIN mktu_mkt_segm_sub AS mss ON cc.fid_mkt_segm = mss.id_mkt_segm AND cc.fid_mkt_sub = mss.id_mkt_sub " +
                            "LEFT OUTER JOIN mktu_dist_chan AS ds ON cc.fid_dist_chan = ds.id_dist_chan " +
                            "LEFT OUTER JOIN mktu_sal_route AS sr ON ccb.fid_sal_route = sr.id_sal_route " +
                            "LEFT OUTER JOIN erp.bpsu_bp AS sa ON d.fid_sal_agt_n = sa.id_bp " +
                            "LEFT OUTER JOIN trn_dps_dps_adj AS adj ON de.id_year = adj.id_adj_year AND de.id_doc = adj.id_adj_doc AND de.id_ety = adj.id_adj_ety " +
                            "LEFT OUTER JOIN trn_dps AS dd ON adj.id_dps_year = dd.id_year AND adj.id_dps_doc = dd.id_doc " +
                            "GROUP BY YEAR(d.dt), MONTH(d.dt), cb.bp_key, b.bp, b.b_att_rel_pty, bb.bpb, "
                            + "bba.street, bba.street_num_ext, bba.street_num_int, bba.neighborhood, bba.reference, "
                            + "bba.locality, bba.county, bba.state, bba.zip_code, "
                            + "ds.id_dist_chan, ds.dist_chan, ms.id_mkt_segm, ms.mkt_segm, mss.id_mkt_sub, mss.mkt_segm_sub, "
                            + "d.dt, d.dt_doc_delivery_n, d.num_ser, d.num, d.num_ref, "
                            + "d.fid_cl_dps, dd.num_ser, dd.num, "
                            + "de.sort_pos, ig.code, ig.igen, i.item_key, i.item, it.code, "
                            + "u.symbol, de.price_u, "
                            + "sa.id_bp, sa.bp, sr.id_sal_route, sr.sal_route, "
                            + "cty.id_cty, "
                            + "cty.cty, "
                            + "cty.cty_abbr " +
                            "ORDER BY YEAR(d.dt), MONTH(d.dt), cb.bp_key, b.bp, bb.bpb, i.item_key, i.item, u.symbol, d.num_ser, d.num, d.num_ref, de.sort_pos ";

                    resulSet = miClient.getSession().getStatement().executeQuery(sql);
                    while (resulSet.next()) {
                        buffer = "";

                        buffer += resulSet.getString("f_year") + ",";
                        buffer += resulSet.getString("f_month") + ",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("cb.bp_key")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("b.bp")) + "\",";
                        buffer += resulSet.getString("b.b_att_rel_pty") + ",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("bb.bpb")) + "\",";
                        
                        address = resulSet.getString("bba.street") + 
                                (resulSet.getString("bba.street_num_ext").isEmpty() ? "" : " " + resulSet.getString("bba.street_num_ext")) +
                                (resulSet.getString("bba.street_num_int").isEmpty() ? "" : " " + resulSet.getString("bba.street_num_int")) +
                                (resulSet.getString("bba.neighborhood").isEmpty() ? "" : " " + resulSet.getString("bba.neighborhood")) +
                                (resulSet.getString("bba.reference").isEmpty() ? "" : " " + resulSet.getString("bba.reference")) +
                                (resulSet.getString("bba.zip_code").isEmpty() ? "" : " " + resulSet.getString("bba.zip_code"));
                        buffer += "\"" + replaceQuotes(address) + "\",";
                        
                        buffer += resulSet.getString("ds.id_dist_chan") == null ? ",," : resulSet.getString("ds.id_dist_chan") + ",\"" + replaceQuotes(resulSet.getString("ds.dist_chan")) + "\",";
                        buffer += resulSet.getString("ms.id_mkt_segm") == null ? ",," : resulSet.getString("ms.id_mkt_segm") + ",\"" + replaceQuotes(resulSet.getString("ms.mkt_segm")) + "\",";
                        buffer += resulSet.getString("mss.id_mkt_sub") == null ? ",," : resulSet.getString("mss.id_mkt_sub") + ",\"" + replaceQuotes(resulSet.getString("mss.mkt_segm_sub")) + "\",";
                        buffer += "\"" + SLibUtils.DateFormatDate.format(resulSet.getDate("d.dt")) + "\",";
                        buffer += resulSet.getDate("d.dt_doc_delivery_n") == null ? "," : "\"" + SLibUtils.DateFormatDate.format(resulSet.getDate("d.dt_doc_delivery_n")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("f_num")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("d.num_ref")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("f_num_afec")) + "\",";
                        buffer += "\"" + resulSet.getString("de.sort_pos") + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("ig.code")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("ig.igen")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("i.item_key")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("i.item")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("it.code")) + "\",";
                        buffer += (resulSet.getDouble("f_qty") - resulSet.getDouble("f_qty_ret")) + ",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("u.symbol")) + "\",";
                        buffer += resulSet.getDouble("de.price_u") + ",";
                        buffer += (resulSet.getDouble("f_amt") - resulSet.getDouble("f_amt_ret") - resulSet.getDouble("f_amt_disc")) + ",";
                        buffer += resulSet.getDouble("f_unt") - resulSet.getDouble("f_unt_ret") + ",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("f_unt_symbol")) + "\",";
                        buffer += resulSet.getString("f_sa_id") == null ? ",," : resulSet.getString("f_sa_id") + ",\"" + replaceQuotes(resulSet.getString("f_sa")) + "\",";
                        buffer += resulSet.getString("sr.id_sal_route") == null ? ",," : resulSet.getString("sr.id_sal_route") + ",\"" + replaceQuotes(resulSet.getString("sr.sal_route")) + "\",";
                        buffer += resulSet.getString("f_id_cty") + ",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("f_cty")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("f_cty_abbr")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("bba.state")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("bba.county")) + "\",";
                        buffer += "\"" + replaceQuotes(resulSet.getString("bba.locality")) + "\"";

                        bw.write("\n");
                        bw.write(SLibUtilities.textToAscii(buffer));
                    }

                    bw.flush();
                    bw.close();

                    if (miClient.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                        SLibUtilities.launchFile(file.getPath());
                    }
                }
            }
            catch(HeadlessException | IOException | SQLException e) {
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

    private void actionDateBegin() {
        miClient.getGuiDatePickerXXX().formReset();
        miClient.getGuiDatePickerXXX().setDate(moFieldDateBegin.getDate());
        miClient.getGuiDatePickerXXX().setVisible(true);

        if (miClient.getGuiDatePickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moFieldDateBegin.setFieldValue(miClient.getGuiDatePickerXXX().getGuiDate());
            jftDateBegin.requestFocus();
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

    private void actionBizPartner() {
        miClient.pickOption(mnOptionPickerId, moFieldBizPartner, null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbBizPartner;
    private javax.swing.JButton jbClose;
    private javax.swing.JButton jbDateBegin;
    private javax.swing.JButton jbDateEnd;
    private javax.swing.JButton jbFunctionalArea;
    private javax.swing.JButton jbPrint;
    private javax.swing.JComboBox<SFormComponentItem> jcbBizPartner;
    private javax.swing.JComboBox jcbDocClass;
    private javax.swing.JComboBox jcbUnitType;
    private javax.swing.JCheckBox jckWithoutRelatedParty;
    private javax.swing.JFormattedTextField jftDateBegin;
    private javax.swing.JFormattedTextField jftDateEnd;
    private javax.swing.JLabel jlBizPartner;
    private javax.swing.JLabel jlBizPartner1;
    private javax.swing.JLabel jlDateBegin;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDocClass;
    private javax.swing.JLabel jlUnitType;
    private javax.swing.JTextField jtfFunctionalArea;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mbResetingForm = true;

        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        moFieldDateBegin.setFieldValue(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setFieldValue(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
        jcbUnitType.setSelectedIndex(jcbUnitType.getItemCount() - 1);
        jcbDocClass.setSelectedIndex(1);
        SFormUtilities.populateComboBox(miClient, jcbBizPartner, mnFormType == SDataConstantsSys.TRNS_CT_DPS_PUR ? SDataConstants.BPSX_BP_SUP : SDataConstants.BPSX_BP_CUS);
        jckWithoutRelatedParty.setSelected(false);
        
        mbResetingForm = false;
    }

    @Override
    public void formRefreshCatalogues() {
        throw new UnsupportedOperationException("Not supported yet.");
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
            if (moFieldDateEnd.getDate().compareTo(moFieldDateBegin.getDate()) < 0) {
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
            else if (button == jbClose) {
                actionClose();
            }
            else if (button == jbDateBegin) {
                actionDateBegin();
            }
            else if (button == jbDateEnd) {
                actionDateEnd();
            }
            else if (button == jbBizPartner) {
                actionBizPartner();
            }
            else if (button == jbFunctionalArea) {
                actionFunctionalArea();
            }
        }
    }
}
