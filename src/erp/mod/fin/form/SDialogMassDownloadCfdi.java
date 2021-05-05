/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.fin.form;

import erp.SClientUtils;
import erp.client.SClientInterface;
import erp.data.SDataConstantsSys;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 *
 * @author Claudio Peña
 */
public class SDialogMassDownloadCfdi extends SBeanFormDialog implements ItemListener, ActionListener {
   
   private FileOutputStream moOutput;

   private int mnOrderByType;
 
   private int mnTypesCdfi;
   private int mnStatusCfdi;
   private int mnDpsCategory;
   private int mnDpsClass;
   private int mnTypeDownload;
   
   private int mnInvoices = SDataConstantsSys.TRNS_CL_DPS_PUR_DOC[1];
   private int mnCreditNotes = SDataConstantsSys.TRNS_CL_DPS_PUR_ADJ[1];
   private int mnCfdPayrollReceipts = SDataConstantsSys.TRNS_TP_CFD_PAYROLL;
   private int mnCfdPaymentReceipts = SDataConstantsSys.TRNS_CL_DPS_SAL_DOC[1];
   
   private int mnEmitedCfdi = SDataConstantsSys.TRNS_ST_DPS_EMITED;
   private int mnAnnuledCfdi = SDataConstantsSys.TRNS_ST_DPS_ANNULED;
  
   private final int DOWNLOAD_XML = 1;
   private final int DOWNLOAD_XML_PDF = 2;

   private String msNameXML;
   private String msXml;
   private String msRoute;
   private Date mdDateSign;
   private String msTextReceiver = "RFC receptor:";
   private String msTextTransmitter = "RFC emisor:";
   
    /**
     * Creates new form SDialogMassDownloadCfdi
     */
    public SDialogMassDownloadCfdi(SGuiClient client) {
        miClient = client;
        initComponents();
        initComponentsCustom();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        moTypesCFDI = new javax.swing.ButtonGroup();
        moTypesStatus = new javax.swing.ButtonGroup();
        moTypesOrigin = new javax.swing.ButtonGroup();
        sBeanCompoundFieldCurrency1 = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();
        moTypesDownload = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        moInvoices = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel14 = new javax.swing.JPanel();
        moCreditNotes = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel15 = new javax.swing.JPanel();
        moPaymentSupplements = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel18 = new javax.swing.JPanel();
        moPayrollReceipts = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        moEmitedCfdi = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel17 = new javax.swing.JPanel();
        moAnnuledCfdi = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel6 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        cfdiIssued = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel21 = new javax.swing.JPanel();
        cfdiReceived = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel8 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel11 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        moDateEnd = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel9 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jlFoliosStart = new javax.swing.JLabel();
        moRFolios = new sa.lib.gui.bean.SBeanFieldText();
        jlFoliosEnd = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        moRSerieStart = new sa.lib.gui.bean.SBeanFieldInteger();
        jlFoliosEnd1 = new javax.swing.JLabel();
        moRSerieEnd = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel13 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jtfMode = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        moRfc = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        moXML = new sa.lib.gui.bean.SBeanFieldRadio();
        jPanel23 = new javax.swing.JPanel();
        moPdf = new sa.lib.gui.bean.SBeanFieldRadio();

        setTitle("Descarga masiva de CFDI");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de descarga:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(6, 1, 0, 5));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de CFDI:"));
        jPanel4.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesCFDI.add(moInvoices);
        moInvoices.setText("Facturas");
        moInvoices.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel12.add(moInvoices);

        jPanel4.add(jPanel12);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesCFDI.add(moCreditNotes);
        moCreditNotes.setText("Notas crédito");
        moCreditNotes.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel14.add(moCreditNotes);

        jPanel4.add(jPanel14);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesCFDI.add(moPaymentSupplements);
        moPaymentSupplements.setSelected(true);
        moPaymentSupplements.setText("Recepción pagos");
        moPaymentSupplements.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel15.add(moPaymentSupplements);

        jPanel4.add(jPanel15);

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesCFDI.add(moPayrollReceipts);
        moPayrollReceipts.setText("Recibos nómina");
        moPayrollReceipts.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel18.add(moPayrollReceipts);

        jPanel4.add(jPanel18);

        jPanel2.add(jPanel4);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Estatus:"));
        jPanel5.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesStatus.add(moEmitedCfdi);
        moEmitedCfdi.setText("Vigentes");
        moEmitedCfdi.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel16.add(moEmitedCfdi);

        jPanel5.add(jPanel16);

        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesStatus.add(moAnnuledCfdi);
        moAnnuledCfdi.setText("Cancelados");
        moAnnuledCfdi.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel17.add(moAnnuledCfdi);

        jPanel5.add(jPanel17);

        jPanel7.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Procedencia:"));
        jPanel6.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesOrigin.add(cfdiIssued);
        cfdiIssued.setText("Emitidos");
        cfdiIssued.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel20.add(cfdiIssued);

        jPanel6.add(jPanel20);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesOrigin.add(cfdiReceived);
        cfdiReceived.setText("Recibidos");
        cfdiReceived.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel21.add(cfdiReceived);

        jPanel6.add(jPanel21);

        jPanel7.add(jPanel6);

        jPanel2.add(jPanel7);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango de fechas:"));
        jPanel8.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial:");
        jlDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel25.add(jlDateStart);
        jPanel25.add(moDateStart);

        jPanel8.add(jPanel25);

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd.setText("Fecha final:");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel11.add(jlDateEnd);
        jPanel11.add(moDateEnd);

        jPanel8.add(jPanel11);

        jPanel2.add(jPanel8);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Rango de folios:"));
        jPanel9.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlFoliosStart.setText("Folio:");
        jlFoliosStart.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel26.add(jlFoliosStart);

        moRFolios.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel26.add(moRFolios);

        jlFoliosEnd.setText("Serie inicial:");
        jlFoliosEnd.setPreferredSize(new java.awt.Dimension(60, 23));
        jPanel26.add(jlFoliosEnd);

        jPanel9.add(jPanel26);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moRSerieStart.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel19.add(moRSerieStart);

        jlFoliosEnd1.setText("Serie final:");
        jlFoliosEnd1.setPreferredSize(new java.awt.Dimension(60, 23));
        jPanel19.add(jlFoliosEnd1);

        moRSerieEnd.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel19.add(moRSerieEnd);

        jPanel9.add(jPanel19);

        jPanel2.add(jPanel9);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel13.setLayout(new java.awt.GridLayout(1, 1, 0, 2));

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("RFC:"));
        jPanel24.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jtfMode.setEditable(false);
        jtfMode.setBorder(null);
        jtfMode.setFocusable(false);
        jtfMode.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel27.add(jtfMode);

        jPanel24.add(jPanel27);

        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moRfc.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel28.add(moRfc);

        jPanel24.add(jPanel28);

        jPanel13.add(jPanel24);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Descargar (si existe PDF) :"));
        jPanel10.setLayout(new java.awt.GridLayout(1, 1, 0, 3));

        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesDownload.add(moXML);
        moXML.setText("Solo XML");
        moXML.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel22.add(moXML);

        jPanel10.add(jPanel22);

        jPanel23.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTypesDownload.add(moPdf);
        moPdf.setText("XML y PDF");
        moPdf.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel23.add(moPdf);

        jPanel10.add(jPanel23);

        jPanel13.add(jPanel10);

        jPanel2.add(jPanel13);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private sa.lib.gui.bean.SBeanFieldRadio cfdiIssued;
    private sa.lib.gui.bean.SBeanFieldRadio cfdiReceived;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlFoliosEnd;
    private javax.swing.JLabel jlFoliosEnd1;
    private javax.swing.JLabel jlFoliosStart;
    private javax.swing.JTextField jtfMode;
    private sa.lib.gui.bean.SBeanFieldRadio moAnnuledCfdi;
    private sa.lib.gui.bean.SBeanFieldRadio moCreditNotes;
    private sa.lib.gui.bean.SBeanFieldDate moDateEnd;
    private sa.lib.gui.bean.SBeanFieldDate moDateStart;
    private sa.lib.gui.bean.SBeanFieldRadio moEmitedCfdi;
    private sa.lib.gui.bean.SBeanFieldRadio moInvoices;
    private sa.lib.gui.bean.SBeanFieldRadio moPaymentSupplements;
    private sa.lib.gui.bean.SBeanFieldRadio moPayrollReceipts;
    private sa.lib.gui.bean.SBeanFieldRadio moPdf;
    private sa.lib.gui.bean.SBeanFieldText moRFolios;
    private sa.lib.gui.bean.SBeanFieldInteger moRSerieEnd;
    private sa.lib.gui.bean.SBeanFieldInteger moRSerieStart;
    private javax.swing.JTextField moRfc;
    private javax.swing.ButtonGroup moTypesCFDI;
    private javax.swing.ButtonGroup moTypesDownload;
    private javax.swing.ButtonGroup moTypesOrigin;
    private javax.swing.ButtonGroup moTypesStatus;
    private sa.lib.gui.bean.SBeanFieldRadio moXML;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency sBeanCompoundFieldCurrency1;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 480, 350);

        moDateEnd.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd.getText()), true);
        jbSave.setEnabled(true);
        
        moInvoices.setBooleanSettings(SGuiUtils.getLabelName(moInvoices.getText()), true);
        moCreditNotes.setBooleanSettings(SGuiUtils.getLabelName(moInvoices.getText()), false);
        moPaymentSupplements.setBooleanSettings(SGuiUtils.getLabelName(moInvoices.getText()), false);
        moPayrollReceipts.setBooleanSettings(SGuiUtils.getLabelName(moInvoices.getText()), false);
        
        moEmitedCfdi.setBooleanSettings(SGuiUtils.getLabelName(cfdiIssued.getText()), true);
        moAnnuledCfdi.setBooleanSettings(SGuiUtils.getLabelName(cfdiIssued.getText()), false);
        
        cfdiIssued.setBooleanSettings(SGuiUtils.getLabelName(cfdiIssued.getText()), true);
        cfdiReceived.setBooleanSettings(SGuiUtils.getLabelName(cfdiIssued.getText()), false);

        moDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart.getText()), true);
        moDateEnd.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd.getText()), true);

        moRFolios.setTextSettings(SGuiUtils.getLabelName(jlFoliosStart), SGuiConsts.GUI_TYPE_TEXT, SGuiConsts.GUI_TYPE_TEXT);
        moRSerieStart.setIntegerSettings(SGuiUtils.getLabelName(jlFoliosEnd), SGuiConsts.GUI_TYPE_INT, true);

        moFields.addField(moInvoices);
        moFields.addField(moCreditNotes);
        moFields.addField(moPaymentSupplements);
        moFields.addField(moPayrollReceipts);
        
        moFields.addField(moEmitedCfdi);
        moFields.addField(moAnnuledCfdi);
        
        moFields.addField(cfdiIssued);
        moFields.addField(cfdiReceived);
        
        moFields.addField(moDateStart);
        moFields.addField(moDateEnd);
        moFields.addField(moRFolios);
        moFields.addField(moRSerieStart);
                
        moFields.setFormButton(jbSave);
        
        mnOrderByType = SLibConsts.UNDEFINED;
        moInvoices.setSelected(true);
        moEmitedCfdi.setSelected(true);
        cfdiIssued.setSelected(true);
        moXML.setSelected(true);
        
        jtfMode.setText(msTextReceiver);
        
        moPayrollReceipts.setEnabled(((SClientInterface) miClient).getSessionXXX().getCompany().getIsModuleHrs() && 
                ((SClientInterface) miClient).getSessionXXX().getUser().hasRight((SClientInterface) miClient, SDataConstantsSys.PRV_HRS_PAY).HasRight);
                
        reloadCatalogues();
        addAllListeners();

    }

    public void reloadCatalogues() {
    }

    @Override
    public SGuiValidation validateForm() {
      SGuiValidation validation = moFields.validateFields();
      validation.setValid(true);
        if (!moInvoices.isSelected() && !moCreditNotes.isSelected() && !moPaymentSupplements.isSelected() && !moPayrollReceipts.isSelected()) {
            miClient.showMsgBoxWarning("Debe seleccionar un tipo de CFDI");
            validation.setValid(false);
        }
        else if (!moEmitedCfdi.isSelected() && !moAnnuledCfdi.isSelected()) {
            miClient.showMsgBoxWarning("Debe seleccionar un origen de CFDI");
            validation.setValid(false);
        }
        else if (!cfdiIssued.isSelected() && !cfdiReceived.isSelected()) {
            miClient.showMsgBoxWarning("Debe seleccionar un status de CFDI");
            validation.setValid(false);
        }
        else if (moPaymentSupplements.isSelected() && cfdiReceived.isSelected()) {
            miClient.showMsgBoxWarning("Solo hay complementos de pago emitidos");
            validation.setValid(false);
        }
        else if (moPayrollReceipts.isSelected() && cfdiReceived.isSelected()) {
            miClient.showMsgBoxWarning("Solo hay recibos de pago emitidos");
            validation.setValid(false);
        }
        
       return validation;
    }
    
    public String routeXml() throws SQLException {
        String mySql = "";
        ResultSet resultSet = null;
        
        mySql = "SELECT xml_base_dir FROM cfg_param_co";
        Statement statementD = miClient.getSession().getStatement().getConnection().createStatement();
        resultSet = statementD.executeQuery(mySql);
            while (resultSet.next()) {
                msRoute = resultSet.getString("cfg.xml_base_dir");
            }
            
        return  msRoute;
    }
    
    public void createParamsXML() throws SQLException {
        String mySql = "";
        int countXml = 0;
        int countPdf = 0;
        ResultSet resultSet = null;
        msNameXML = "";
        msXml = "";
        mdDateSign = new Date();
        File routeSaveXML = routeSaveXML();
        SimpleDateFormat dateFileYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateFileMounth = new SimpleDateFormat("MM");
        
        try {
            
            String complementaryDbName = "";
            try {
                complementaryDbName = SClientUtils.getComplementaryDdName((SClientInterface) miClient);
            }
            catch (Exception e) {
                SLibUtils.printException(this, e);
            }
            if (typeCfdi() == mnInvoices || typeCfdi() == mnCreditNotes) {
                mySql = "SELECT cfd.id_cfd, com.doc_xml_name, com.doc_xml, cfd.xml_sign_n, cfd.fid_tp_cfd, cfd.fid_st_xml, "
                        + "CONCAT_WS(dps.num_ser, dps.num) AS _folios "
                        + "FROM trn_dps AS dps "
                        + "INNER JOIN trn_cfd AS cfd ON cfd.fid_dps_year_n = dps.id_year AND cfd.fid_dps_doc_n = dps.id_doc "
                        + "INNER JOIN " + complementaryDbName + ".trn_cfd AS com ON com.id_cfd = cfd.id_cfd "
                        + "WHERE dps.b_del = 0 AND "
                        + "dps.fid_ct_dps = " + getDpsCategory() + " AND dps.fid_cl_dps = " + getDpsClass() + " AND dps.fid_st_dps = " + statusCfdi() + " " ;
                if (moDateStart.getValue() != null) {
                    mySql += " AND cfd.xml_sign_n >= "+ "'" +  SLibUtils.DbmsDateFormatDate.format(moDateStart.getValue()) + " 00:00:00'";
                }
                if (moDateEnd.getValue() != null ) {
                    mySql += " AND cfd.xml_sign_n <= "+ "'" +  SLibUtils.DbmsDateFormatDate.format(moDateEnd.getValue()) + " 23:59:59'"; 
                }
                if (!"".equals(moRFolios.getValue())) {
                    mySql += " AND dps.num_ser = '" + moRFolios.getValue() + "' ";
                }
                if (moRSerieStart.getValue() != 0) {
                    mySql += " AND dps.num >= " + moRSerieStart.getValue() + " ";
                }
                if (moRSerieEnd.getValue() != 0) {
                    mySql += " AND dps.num <= " + moRSerieEnd.getValue() + " ";
                }
                if (!"".equals(moRfc.getText())) {
                    if(getDpsCategory() == SDataConstantsSys.TRNS_CT_DPS_SAL) {
                        mySql += " AND cfd.xml_rfc_rec = '" + moRfc.getText() + "' ";
                    }
                    else {
                        mySql += " AND cfd.xml_rfc_emi  = '" + moRfc.getText() + "' ";
                    }
                }
            }
            else if (typeCfdi() == mnCfdPayrollReceipts ) {
                mySql = "SELECT cfd.id_cfd, com.doc_xml_name, com.doc_xml, cfd.xml_sign_n, cfd.fid_tp_cfd, cfd.fid_st_xml, "
                        + "CONCAT_WS(cfd.ser, cfd.num) AS _folios "
                        + "FROM hrs_pay_rcp AS rcp "
                        + "INNER JOIN hrs_pay_rcp_iss AS iss ON iss.id_pay = rcp.id_pay AND iss.id_emp = rcp.id_emp "
                        + "INNER JOIN trn_cfd AS cfd ON cfd.fid_pay_rcp_pay_n = iss.id_pay AND cfd.fid_pay_rcp_emp_n = iss.id_emp AND cfd.fid_pay_rcp_iss_n = iss.id_iss "
                        + "INNER JOIN erp.bpsu_bp AS bp ON bp.id_bp = iss.id_emp "
                        + "INNER JOIN " + complementaryDbName + ".trn_cfd AS com ON com.id_cfd = cfd.id_cfd "
                        + "WHERE cfd.fid_st_xml = " + statusCfdi() + " " ;
                if (moDateStart.getValue() != null) {
                    mySql += " AND cfd.xml_sign_n >= "+ "'" +  SLibUtils.DbmsDateFormatDate.format(moDateStart.getValue()) + " 00:00:00'";
                }
                if (moDateEnd.getValue() != null ) {
                    mySql += " AND cfd.xml_sign_n <= "+ "'" +  SLibUtils.DbmsDateFormatDate.format(moDateEnd.getValue()) + " 23:59:59'"; 
                }
                if (!"".equals(moRFolios.getValue())) {
                    mySql += " AND dps.num_ser = '" + moRFolios.getValue() + "' ";
                }
                if (moRSerieStart.getValue() == null) {
                    mySql += " AND dps.num >= " + moRSerieStart.getValue() + " ";
                }
                if (moRSerieEnd.getValue() == null) {
                    mySql += " AND dps.num <= " + moRSerieEnd.getValue() + " ";
                }
                if (!"".equals(moRfc.getText())) {
                    if(getDpsCategory() == SDataConstantsSys.TRNS_CT_DPS_SAL) {
                        mySql += " AND cfd.xml_rfc_rec = '" + moRfc.getText() + "' ";
                    }
                    else {
                        mySql += " AND cfd.xml_rfc_emi  = '" + moRfc.getText() + "' ";
                    }
                }
            }
            else if (typeCfdi() == mnCfdPaymentReceipts ) {
                mySql = "SELECT cfd.id_cfd, com.doc_xml_name, com.doc_xml, cfd.xml_sign_n, cfd.fid_tp_cfd, cfd.fid_st_xml, "
                        + "CONCAT_WS(cfd.ser, cfd.num) AS _folios "
                        + "FROM trn_cfd AS cfd "
                        + "INNER JOIN fin_rec_ety AS ety.fid_cfd_n = cfd.id_cfd "
                        + "INNER JOIN " + complementaryDbName + ".trn_cfd AS com ON com.id_cfd = cfd.id_cfd "
                        + "WHERE cfd.fid_st_xml = " + statusCfdi() + " " ;
                if (moDateStart.getValue() != null) {
                    mySql += " AND cfd.xml_sign_n >= "+ "'" +  SLibUtils.DbmsDateFormatDate.format(moDateStart.getValue()) + " 00:00:00'";
                }
                if (moDateEnd.getValue() != null ) {
                    mySql += " AND cfd.xml_sign_n <= "+ "'" +  SLibUtils.DbmsDateFormatDate.format(moDateEnd.getValue()) + " 23:59:59'"; 
                }
                if (!"".equals(moRFolios.getValue())) {
                    mySql += " AND dps.num_ser = '" + moRFolios.getValue() + "' ";
                }
                if (moRSerieStart.getValue() == null) {
                    mySql += " AND dps.num >= " + moRSerieStart.getValue() + " ";
                }
                if (moRSerieEnd.getValue() == null) {
                    mySql += " AND dps.num <= " + moRSerieEnd.getValue() + " ";
                }
                if (!"".equals(moRfc.getText())) {
                    if(getDpsCategory() == SDataConstantsSys.TRNS_CT_DPS_SAL ) {
                        mySql += " AND cfd.xml_rfc_rec = '" + moRfc.getText() + "' ";
                    }
                    else {
                        mySql += " AND cfd.xml_rfc_emi  = '" + moRfc.getText() + "' ";
                    }
                }
            }
            Statement statement = miClient.getSession().getStatement().getConnection().createStatement();
            resultSet = statement.executeQuery(mySql);
            while (resultSet.next()) {
                countXml = countXml + 1;
                mdDateSign = resultSet.getDate("cfd.xml_sign_n");
                msNameXML = resultSet.getString("com.doc_xml_name");
                msXml = resultSet.getString("com.doc_xml");
//                msRoute = resultSet.getString("reps/img/aeth/");
//                msRoute = resultSet.getString("cfg.xml_base_dir");

                writeXml(routeSaveXML, (msNameXML.isEmpty() ?  String.valueOf(countXml) : msNameXML), msXml);
                if(routeSaveXML != null) {
                    if (getTypeDownload() == DOWNLOAD_XML_PDF) {
                        if(mdDateSign != null  ) {
                            String mnYearR = dateFileYear.format(mdDateSign);
                            String mnMounthR = dateFileMounth.format(mdDateSign);
                            String namePdf = msNameXML.substring(0,26) + "pdf";
                            String sCarpAct = System.getProperty("user.dir");
//                            File routeFindPdf = new File(sCarpAct + "/" + msRoute + mnYearR + "/" + mnMounthR + "/");
                            File routeFindPdf = new File(sCarpAct + "/" + routeXml() + mnYearR + "/" + mnMounthR + "/");

                            File archiveFindPdf = new File(routeFindPdf + "/" + namePdf );
                            if(archiveFindPdf.exists()) {
                                fileMovePdf(routeFindPdf, routeSaveXML, namePdf);
                                 countPdf = countPdf + 1;
                            }
                        }
                    }
                }
                else {
                    break;
                }
            }
            
            if (getTypeDownload() == DOWNLOAD_XML) {
                if(countXml == 1) {
                    JOptionPane.showMessageDialog(null, "Proceso finalizado. Se ha descargado: " + countXml + " xml.");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Proceso finalizado. Se han descargado: " + countXml + " xml.");
                }
            }
            else if (getTypeDownload() == DOWNLOAD_XML_PDF) {
                if(countPdf == 1 && countXml == 1) {
                    JOptionPane.showMessageDialog(null, "Proceso finalizado. Se ha descargado: " + countXml + " xml. Y se ha descargado: " + countPdf + " pdf");
                }
                else if(countPdf == 1 && countXml != 1) {
                    JOptionPane.showMessageDialog(null, "Proceso finalizado. Se han descargado: " + countXml + " xml. Y se ha descargado: " + countPdf + " pdf's");
                }
                else if(countPdf != 1 && countXml != 1) {
                    JOptionPane.showMessageDialog(null, "Proceso finalizado. Se han descargado: " + countXml + " xml. Y se han descargado: " + countPdf + " pdf's");
                }
            }
        }

        catch (Exception e) {
            SLibUtils.showException(this, e);
        }
    }
    
    public static void fileMovePdf(File sourceFile, File destinationFile, String namePdf) {
        File dataInputFile = new File (sourceFile +"/"+ namePdf);
        File fileSendPath = new File(destinationFile, namePdf);
        dataInputFile.renameTo(fileSendPath);
    
    }

    public void writeXml(File routeSave, String name, String xml) throws IOException {
        try {
            FileWriter writerFile = new FileWriter(routeSave + "/" + name , true);
            writerFile.write(xml);
            writerFile.close();
        }
        catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        }
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, en la salida");
        }
    }
    
    public File routeSaveXML() {
        JFileChooser save = new JFileChooser();
        save.setCurrentDirectory(new java.io.File("C:\\"));
        save.setDialogTitle("Guardar XML");
        save.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        save.setAcceptAllFileFilterUsed(false);

        if (save.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
          System.out.println("getCurrentDirectory(): " + save.getCurrentDirectory());
          System.out.println("getSelectedFile() : " + save.getSelectedFile());
        }
        else {
          System.out.println("No Selection ");
        }
        
        return save.getSelectedFile();
    }
       
    private int typeCfdi() {
        if (moInvoices.isSelected()) {
            mnTypesCdfi = mnInvoices; //factura
        }
        else if (moCreditNotes.isSelected()) {
            mnTypesCdfi = mnCreditNotes; //notas de crédito
        }
        else if (moPaymentSupplements.isSelected()) {
            mnTypesCdfi = mnCfdPaymentReceipts; //complementos de pago 
        }
        else if (moPayrollReceipts.isSelected()) {
            mnTypesCdfi = mnCfdPayrollReceipts ; //recibos de nomina
        }
        
        return mnTypesCdfi;
    }
    
    private int statusCfdi() {    
        if (moEmitedCfdi.isSelected()) {
            mnStatusCfdi = mnEmitedCfdi ; // emitido
        }
        else if(moAnnuledCfdi.isSelected()) {
            mnStatusCfdi = mnAnnuledCfdi ; //cancelado
        }
        
        return mnStatusCfdi;
    }
    
    private int getDpsClass() {
        if (moInvoices.isSelected()) {
            mnDpsClass = mnInvoices; //factura
        }
        else if (moCreditNotes.isSelected()) {
            mnDpsClass = mnCreditNotes; //notas de crédito
        }
        return mnDpsClass;
    }
    
    private int getDpsCategory() {    
        if (cfdiIssued.isSelected()) {
            mnDpsCategory = SDataConstantsSys.TRNS_CT_DPS_SAL; // emitido
        }
        else if(cfdiReceived.isSelected()) {
            mnDpsCategory = SDataConstantsSys.TRNS_CT_DPS_PUR; // recibido
        }
        
        return mnDpsCategory;
    }
    
    private int getTypeDownload() {
        if (moXML.isSelected()) {
            mnTypeDownload = DOWNLOAD_XML;
        }
        else if(moPdf.isSelected()) {
            mnTypeDownload = DOWNLOAD_XML_PDF;
        }
        
       return mnTypeDownload;
    }

   @Override
    public void addAllListeners() {
        moPaymentSupplements.addItemListener(this);
        moPayrollReceipts.addItemListener(this);
        cfdiIssued.addItemListener(this);
        cfdiReceived.addItemListener(this);
    }

    @Override
    public void removeAllListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRegistry(SDbRegistry sdr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (moInvoices.isSelected()) {
            jtfMode.setText(msTextReceiver);
            if (cfdiIssued.isSelected()){
                jtfMode.setText(msTextReceiver);
            }
            else {
                jtfMode.setText(msTextTransmitter);
            }
            cfdiIssued.getModel().setEnabled(true);
            cfdiReceived.getModel().setEnabled(true);
        }
        else if (moCreditNotes.isSelected()) {
            jtfMode.setText(msTextReceiver);
            if (cfdiIssued.isSelected()){
                jtfMode.setText(msTextReceiver);
            }
            else {
                jtfMode.setText(msTextTransmitter);
            }
            cfdiIssued.getModel().setEnabled(true);
            cfdiReceived.getModel().setEnabled(true);
        }
        else if (moPaymentSupplements.isSelected()) {
            cfdiIssued.setBooleanSettings(SGuiUtils.getLabelName(cfdiIssued.getText()), true);
            cfdiIssued.getModel().setEnabled(false);
            cfdiReceived.getModel().setEnabled(false);
            cfdiIssued.setSelected(true);
            cfdiReceived.setSelected(false);
            jtfMode.setText(msTextReceiver);

        }
        else if (moPayrollReceipts.isSelected()){
            cfdiIssued.setBooleanSettings(SGuiUtils.getLabelName(cfdiIssued.getText()), true);
            cfdiIssued.getModel().setEnabled(false);
            cfdiReceived.getModel().setEnabled(false);
            cfdiIssued.setSelected(true);
            cfdiReceived.setSelected(false);
            jtfMode.setText(msTextReceiver);
        } 
        else {
            cfdiIssued.getModel().setEnabled(true);
            cfdiReceived.getModel().setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JRadioButton button = (JRadioButton) e.getSource();
            if (moInvoices.isSelected()) {
            jtfMode.setText(msTextReceiver);
                if (cfdiIssued.isSelected()){
                    jtfMode.setText(msTextReceiver);
                }
                else {
                    jtfMode.setText(msTextTransmitter);
                }
            } 
            else if (moCreditNotes.isSelected()) {
                jtfMode.setText(msTextReceiver);
                 if (cfdiIssued.isSelected()){
                    jtfMode.setText(msTextReceiver);
                }
                else {
                    jtfMode.setText(msTextTransmitter);
                }
            }
            else if (moPaymentSupplements.isSelected()) {
                jtfMode.setText(msTextReceiver);
                 
            }
            else if (moPayrollReceipts.isSelected()){
                jtfMode.setText(msTextReceiver);                
            }
        }
    }
    
    @Override
    public void actionSave() {
        boolean canClose = true;
        if(moDateStart.getValue() == null && moDateEnd.getValue() == null) {
            if (JOptionPane.showConfirmDialog(this, "Al no elegir fechas, la cantidad de XML, puede ser masiva. ¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION) != JOptionPane.YES_OPTION) {
                 canClose = true;
            }
            else {
                if (jbSave.isEnabled()) {
                    try {
                        createParamsXML();
                    } catch (SQLException ex) {
                        Logger.getLogger(SDialogMassDownloadCfdi.class.getName()).log(Level.SEVERE, null, ex);
                    }
                           dispose();
                       }            
            }
        }
        else if (jbSave.isEnabled()) {
            try {
                createParamsXML();
            } catch (SQLException ex) {
                Logger.getLogger(SDialogMassDownloadCfdi.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
        } 
    }
}