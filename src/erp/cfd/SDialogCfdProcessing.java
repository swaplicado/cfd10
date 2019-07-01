/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.cfd;

import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.mbps.data.SDataBizPartner;
import erp.mhrs.data.SDataFormerPayrollEmp;
import erp.mod.SModConsts;
import erp.mod.fin.util.STreasuryBankLayoutRequest;
import erp.mod.hrs.db.SDbPayrollReceipt;
import erp.mod.hrs.db.SDbPayrollReceiptIssue;
import erp.mod.hrs.db.SHrsCfdUtils;
import erp.mod.hrs.db.SHrsUtils;
import erp.mtrn.data.SCfdPrintThread;
import erp.mtrn.data.SCfdUtils;
import erp.mtrn.data.SDataCfd;
import erp.mtrn.data.SDataDps;
import erp.print.SDataConstantsPrint;
import java.awt.Cursor;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;

/**
 *
 * @author Juan Barajas, Alfredo Pérez, Sergio Flores
 */
public class SDialogCfdProcessing extends sa.lib.gui.bean.SBeanFormDialog {
    
    protected SClientInterface miClient;
    
    protected ArrayList<SDataCfd> maCfds;
    protected ArrayList<int[]> maPayrollReceiptKeys;
    protected ArrayList<SDbPayrollReceipt> maPayrollReceipts;
    protected int mnStampsAvailable;
    protected Date mtAnnulmentDate;
    protected boolean mbValidateStamp;
    
    protected boolean mbFirstTime;
    protected int mnSubtypeCfd;
    protected int mnNumberCopies;
    protected int mnDpsAnnulmentType;
    
    /**
     * Creates new form SDialogResult
     * @param client
     * @param title
     * @param subtype
     */
    public SDialogCfdProcessing(SGuiClient client, String title, int subtype) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.TRN_CFD, subtype, title);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpInformation = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jlCfdToProcess = new javax.swing.JLabel();
        moIntCfdToProcess = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel21 = new javax.swing.JPanel();
        jlCfdProcessedOk = new javax.swing.JLabel();
        moIntCfdProcessedOk = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel22 = new javax.swing.JPanel();
        jlCfdProcessedWrong = new javax.swing.JLabel();
        moIntCfdProcessedWrong = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel4 = new javax.swing.JPanel();
        jlCfdProcessed = new javax.swing.JLabel();
        moIntCfdProcessed = new sa.lib.gui.bean.SBeanFieldInteger();
        jpStampInfo = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jlStampsAvailable = new javax.swing.JLabel();
        moIntStampsAvailable = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel24 = new javax.swing.JPanel();
        jlStampsConsumed = new javax.swing.JLabel();
        moIntStampsConsumed = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel25 = new javax.swing.JPanel();
        jlStampsRemaining = new javax.swing.JLabel();
        moIntStampsRemaining = new sa.lib.gui.bean.SBeanFieldInteger();
        jPanel8 = new javax.swing.JPanel();
        jtfWarningMessage = new javax.swing.JTextField();
        jpDetail = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jspMessages = new javax.swing.JScrollPane();
        jtaMessages = new javax.swing.JTextArea();

        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jpInformation.setBorder(javax.swing.BorderFactory.createTitledBorder("Resumen:"));
        jpInformation.setLayout(new java.awt.GridLayout(1, 2, 0, 5));

        jPanel5.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCfdToProcess.setText("CFDI a procesar:");
        jlCfdToProcess.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel6.add(jlCfdToProcess);

        moIntCfdToProcess.setEditable(false);
        jPanel6.add(moIntCfdToProcess);

        jPanel5.add(jPanel6);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCfdProcessedOk.setText("Procesados correctamente:");
        jlCfdProcessedOk.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel21.add(jlCfdProcessedOk);

        moIntCfdProcessedOk.setEditable(false);
        jPanel21.add(moIntCfdProcessedOk);

        jPanel5.add(jPanel21);

        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCfdProcessedWrong.setText("Procesados incorrectamente:");
        jlCfdProcessedWrong.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel22.add(jlCfdProcessedWrong);

        moIntCfdProcessedWrong.setEditable(false);
        jPanel22.add(moIntCfdProcessedWrong);

        jPanel5.add(jPanel22);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCfdProcessed.setText("CFDI procesados:");
        jlCfdProcessed.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel4.add(jlCfdProcessed);

        moIntCfdProcessed.setEditable(false);
        jPanel4.add(moIntCfdProcessed);

        jPanel5.add(jPanel4);

        jpInformation.add(jPanel5);

        jpStampInfo.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlStampsAvailable.setText("Timbres disponibles:");
        jlStampsAvailable.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel7.add(jlStampsAvailable);

        moIntStampsAvailable.setEditable(false);
        jPanel7.add(moIntStampsAvailable);

        jpStampInfo.add(jPanel7);

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlStampsConsumed.setText("Timbres consumidos:");
        jlStampsConsumed.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel24.add(jlStampsConsumed);

        moIntStampsConsumed.setEditable(false);
        jPanel24.add(moIntStampsConsumed);

        jpStampInfo.add(jPanel24);

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlStampsRemaining.setText("Timbres restantes:");
        jlStampsRemaining.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel25.add(jlStampsRemaining);

        moIntStampsRemaining.setEditable(false);
        jPanel25.add(moIntStampsRemaining);

        jpStampInfo.add(jPanel25);

        jPanel8.setLayout(new java.awt.GridLayout(1, 0));

        jtfWarningMessage.setEditable(false);
        jtfWarningMessage.setFocusable(false);
        jPanel8.add(jtfWarningMessage);

        jpStampInfo.add(jPanel8);

        jpInformation.add(jpStampInfo);

        jPanel1.add(jpInformation, java.awt.BorderLayout.NORTH);

        jpDetail.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle:"));
        jpDetail.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jspMessages.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jspMessages.setAutoscrolls(true);

        jtaMessages.setEditable(false);
        jtaMessages.setColumns(20);
        jtaMessages.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jtaMessages.setRows(5);
        jtaMessages.setFocusable(false);
        jtaMessages.setOpaque(false);
        jspMessages.setViewportView(jtaMessages);

        jPanel2.add(jspMessages, java.awt.BorderLayout.CENTER);

        jpDetail.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jpDetail, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowsActivated();
    }//GEN-LAST:event_formWindowActivated

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel jlCfdProcessed;
    private javax.swing.JLabel jlCfdProcessedOk;
    private javax.swing.JLabel jlCfdProcessedWrong;
    private javax.swing.JLabel jlCfdToProcess;
    private javax.swing.JLabel jlStampsAvailable;
    private javax.swing.JLabel jlStampsConsumed;
    private javax.swing.JLabel jlStampsRemaining;
    private javax.swing.JPanel jpDetail;
    private javax.swing.JPanel jpInformation;
    private javax.swing.JPanel jpStampInfo;
    private javax.swing.JScrollPane jspMessages;
    private javax.swing.JTextArea jtaMessages;
    private javax.swing.JTextField jtfWarningMessage;
    private sa.lib.gui.bean.SBeanFieldInteger moIntCfdProcessed;
    private sa.lib.gui.bean.SBeanFieldInteger moIntCfdProcessedOk;
    private sa.lib.gui.bean.SBeanFieldInteger moIntCfdProcessedWrong;
    private sa.lib.gui.bean.SBeanFieldInteger moIntCfdToProcess;
    private sa.lib.gui.bean.SBeanFieldInteger moIntStampsAvailable;
    private sa.lib.gui.bean.SBeanFieldInteger moIntStampsConsumed;
    private sa.lib.gui.bean.SBeanFieldInteger moIntStampsRemaining;
    // End of variables declaration//GEN-END:variables

    /*
     * Private methods:
     */
    
    private void windowsActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            
            try {
                miClient.getFrame().setCursor(new Cursor(Cursor.WAIT_CURSOR));
                process();
            }
            catch (Exception e) {
                SLibUtils.printException(this, e);
            }
            finally {
                miClient.getFrame().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    
    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 720, 450);

        jbSave.setEnabled(false);
        jbCancel.setText("Aceptar");
        
        moIntCfdToProcess.setIntegerSettings(SGuiUtils.getLabelName(jlCfdToProcess), SGuiConsts.GUI_TYPE_INT, true);
        moIntCfdProcessedOk.setIntegerSettings(SGuiUtils.getLabelName(jlCfdProcessedOk), SGuiConsts.GUI_TYPE_INT, true);
        moIntCfdProcessedWrong.setIntegerSettings(SGuiUtils.getLabelName(jlCfdProcessedWrong), SGuiConsts.GUI_TYPE_INT, true);
        moIntCfdProcessed.setIntegerSettings(SGuiUtils.getLabelName(jlCfdProcessed), SGuiConsts.GUI_TYPE_INT, true);
        moIntStampsAvailable.setIntegerSettings(SGuiUtils.getLabelName(jlStampsAvailable), SGuiConsts.GUI_TYPE_INT, true);
        moIntStampsConsumed.setIntegerSettings(SGuiUtils.getLabelName(jlStampsConsumed), SGuiConsts.GUI_TYPE_INT, true);
        moIntStampsRemaining.setIntegerSettings(SGuiUtils.getLabelName(jlStampsRemaining), SGuiConsts.GUI_TYPE_INT, true);

        moFields.addField(moIntCfdToProcess);
        moFields.addField(moIntCfdProcessedOk);
        moFields.addField(moIntCfdProcessedWrong);
        moFields.addField(moIntCfdProcessed);
        moFields.addField(moIntStampsAvailable);
        moFields.addField(moIntStampsConsumed);
        moFields.addField(moIntStampsRemaining);

        moFields.setFormButton(jbSave);
    }
    
    private void process() throws Exception {
        jtfWarningMessage.setText("");
        
        if (mnFormSubtype == SCfdConsts.PROC_REQ_SEND_CFD_PAYROLL) {
            sendPayrollReceipts();
        }
        else { 
            if (maPayrollReceiptKeys != null) {
                processPayrollReceipts();
            }
            else if (maCfds != null) {
                processCfd();            
            }
        }
    }
    
    private void sendPayrollReceipts() throws Exception {
        boolean isSent = false;
        int cfdProcessed = 0;
        int cfdProcessedOk = 0;
        int cfdProcessedWrong = 0;
        String detailMessage = "";
        String mail = "";
        
        STreasuryBankLayoutRequest layoutRequest = null;
        SDataBizPartner bizPartner  = null;
        HashMap<String, Object> map = new HashMap<>();
        File pdf = null;
        
        moIntCfdToProcess.setValue(maPayrollReceipts.size());
        
        for (SDbPayrollReceipt payrollReceipt : maPayrollReceipts) {
            bizPartner  = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, new int[] { payrollReceipt.getPkEmployeeId() }, SLibConstants.EXEC_MODE_SILENT);
            mail = bizPartner.getDbmsHqBranch().getDbmsBizPartnerBranchContacts().get(0).getEmail01();
            
            map = SHrsUtils.createPayrollReceiptMap((SGuiClient) miClient, payrollReceipt.getPrimaryKey(), SDataConstantsPrint.PRINT_MODE_PDF_FILE);
            pdf = SHrsUtils.createPayrollReceipt((SGuiClient) miClient, map);
            cfdProcessed++;
        
            if (pdf != null) {
                layoutRequest = new STreasuryBankLayoutRequest((SGuiClient) miClient, null);
                isSent = layoutRequest.sendMail(null, "", pdf, STreasuryBankLayoutRequest.SND_TP_PAY_RCP, mail);
                    
                if (isSent) {
                    cfdProcessedOk++;
                    detailMessage += "Recibo enviado.\n";
                }
                else {
                    cfdProcessedWrong++;
                    detailMessage += "No se ha enviado.\n";
                }
            }
            else {
                cfdProcessedWrong++;
                detailMessage += "No se creó el archivo PDF.\n";
            }
            
            updateForm(cfdProcessed, cfdProcessedOk, cfdProcessedWrong, detailMessage);
        }
    }
    
    private void processPayrollReceipts() {
        int cfdProcessed = 0;
        int cfdProcessedOk = 0;
        int cfdProcessedWrong = 0;
        String detailMessage = "";
        String warningMessage = "";
        
        if (maPayrollReceiptKeys != null) {
            moIntCfdToProcess.setValue(maPayrollReceiptKeys.size());
        
            for (int[] key : maPayrollReceiptKeys) {
                int number = 0;
                cfdProcessed++;
                
                try {
                    switch (mnFormSubtype) {
                        case SCfdConsts.PROC_REQ_STAMP:
                            SDbPayrollReceiptIssue receiptIssue = (SDbPayrollReceiptIssue) miClient.getSession().readRegistry(SModConsts.HRS_PAY_RCP_ISS, key);

                            if (receiptIssue.getNumber() != 0) {
                                number = receiptIssue.getNumber();
                            }
                            else {
                                number = SHrsUtils.getPayrollReceiptNextNumber(miClient.getSession(), receiptIssue.getNumberSeries());
                                receiptIssue.setNumber(number); // update memory
                                receiptIssue.saveField(miClient.getSession().getStatement(), key, SDbPayrollReceiptIssue.FIELD_NUMBER, number); // update persistent storage as well
                            }

                            SHrsCfdUtils.computeSignCfdi(miClient.getSession(), key);
                            detailMessage += receiptIssue.getPayrollReceiptIssueNumber() + ": Timbrado" + (miClient.getSessionXXX().getParamsCompany().getIsCfdiSendingAutomaticHrs() ? " y enviado.\n" : ".\n");
                            cfdProcessedOk++;
                            break;
                            
                        default:
                    }
                }
                catch(Exception e) {
                    detailMessage += "" + number + ": " + e.getMessage() + "\n";
                    cfdProcessedWrong++;
                }
                
                updateForm(cfdProcessed, cfdProcessedOk, cfdProcessedWrong, detailMessage);
            }
            
            warningMessage = SCfdUtils.verifyCertificateExpiration(miClient);
            jtfWarningMessage.setText(warningMessage);
            
            if (cfdProcessedOk > 0) {
                miClient.getSession().notifySuscriptors(SModConsts.HRS_PAY);
            }
        }
    }
    
    private void processCfd() throws Exception {
        int cfdProcessed = 0;
        int cfdProcessedOk = 0;
        int cfdProcessedWrong = 0;
        int registryType = SLibConsts.UNDEFINED;
        SDataDps dps = null;
        SDataFormerPayrollEmp formerPayrollEmp = null;
        SDbPayrollReceiptIssue payrollReceiptIssue = null;
        String series = "";
        String number = "";
        String detailMessage = "";
        String warningMessage = "";
        
        moIntCfdToProcess.setValue(maCfds.size());
        
        if (maCfds != null) {
            for (SDataCfd cfd : maCfds) {
                cfdProcessed++;

                switch (cfd.getFkCfdTypeId()) {
                    case SDataConstantsSys.TRNS_TP_CFD_INV:
                        dps = (SDataDps) SDataUtilities.readRegistry(miClient, SDataConstants.TRN_DPS, new int[] { cfd.getFkDpsYearId_n(), cfd.getFkDpsDocId_n() }, SLibConstants.EXEC_MODE_SILENT);
                        series = dps.getNumberSeries();
                        number = dps.getNumber();
                        
                        registryType = SModConsts.TRN_DPS;
                        break;
                        
                    case SDataConstantsSys.TRNS_TP_CFD_PAY_REC:
                        throw new Exception("Not supported yet!");
                        
                    case SDataConstantsSys.TRNS_TP_CFD_PAYROLL:
                        switch (mnSubtypeCfd) {
                            case SCfdConsts.CFDI_PAYROLL_VER_OLD:
                                formerPayrollEmp = (SDataFormerPayrollEmp) SDataUtilities.readRegistry(miClient, SDataConstants.HRS_SIE_PAY_EMP, new int[] { cfd.getFkPayrollPayrollId_n(), cfd.getFkPayrollEmployeeId_n() }, SLibConstants.EXEC_MODE_SILENT);
                                series = formerPayrollEmp.getNumberSeries();
                                number = "" + formerPayrollEmp.getNumber();
                                break;
                                
                            case SCfdConsts.CFDI_PAYROLL_VER_CUR:
                                payrollReceiptIssue = (SDbPayrollReceiptIssue) miClient.getSession().readRegistry(SModConsts.HRS_PAY_RCP_ISS, new int[] { cfd.getFkPayrollReceiptPayrollId_n(), cfd.getFkPayrollReceiptEmployeeId_n(), cfd.getFkPayrollReceiptIssueId_n() });
                                series = payrollReceiptIssue.getNumberSeries();
                                number = "" + payrollReceiptIssue.getNumber();
                                break;
                                
                            default:
                                throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
                        }
                        
                        registryType = SModConsts.HRS_PAY;
                        break;
                        
                    default:
                        throw new Exception(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
                }

                try {
                    switch (mnFormSubtype) {
                        case SCfdConsts.PROC_REQ_STAMP:
                            SCfdUtils.signCfdi(miClient, cfd, mnSubtypeCfd, false, false);
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Timbrado.\n";
                            break;
                            
                        case SCfdConsts.PROC_REQ_ANNUL:
                            SCfdUtils.cancelCfdi(miClient, cfd, mnSubtypeCfd, mtAnnulmentDate, mbValidateStamp, false, mnDpsAnnulmentType);
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Anulado.\n";
                            break;
                            
                        case SCfdConsts.PROC_PRT_DOC:
                            SCfdPrintThread thread = new SCfdPrintThread(miClient, cfd, mnSubtypeCfd, SDataConstantsPrint.PRINT_MODE_PRINT, mnNumberCopies, this);
                            thread.startThread();
                            thread.join();
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Impreso.\n";
                            break;
                            
                        case SCfdConsts.PROC_PRT_DOCS:
                            SCfdUtils.printCfd(miClient, cfd, mnSubtypeCfd, SDataConstantsPrint.PRINT_MODE_PRINT, mnNumberCopies, false);
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Impreso.\n";
                            break;
                            
                        case SCfdConsts.PROC_PRT_ACK_ANNUL:
                            SCfdUtils.printCfdCancelAck(miClient, cfd, SDataConstantsPrint.PRINT_MODE_PRINT, mnSubtypeCfd);
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Impreso.\n";
                            break;
                            
                        case SCfdConsts.PROC_SND_DOC:
                            SCfdUtils.sendCfd(miClient, cfd.getFkCfdTypeId(), cfd, mnSubtypeCfd, false, false, true);
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Enviado.\n";
                            break;
                            
                        case SCfdConsts.PROC_REQ_STAMP_AND_SND:
                            if (miClient.getSessionXXX().getParamsCompany().getIsCfdiSendingAutomaticHrs()) {
                                SCfdUtils.signAndSendCfdi(miClient, cfd, mnSubtypeCfd, false, false);
                            }
                            else {
                                SCfdUtils.signCfdi(miClient, cfd, mnSubtypeCfd, false, false);
                            }
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Timbrado" + (miClient.getSessionXXX().getParamsCompany().getIsCfdiSendingAutomaticHrs() ? " y enviado.\n" : ".\n");
                            break;
                            
                        case SCfdConsts.PROC_REQ_ANNUL_AND_SND:
                            if (miClient.getSessionXXX().getParamsCompany().getIsCfdiSendingAutomaticHrs()) {
                                SCfdUtils.cancelAndSendCfdi(miClient, cfd, mnSubtypeCfd, mtAnnulmentDate, mbValidateStamp, false, mnDpsAnnulmentType);
                            }
                            else {
                                SCfdUtils.cancelCfdi(miClient, cfd, mnSubtypeCfd, mtAnnulmentDate, mbValidateStamp, false, mnDpsAnnulmentType);
                            }
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Anulado" + (miClient.getSessionXXX().getParamsCompany().getIsCfdiSendingAutomaticHrs() ? " y enviado.\n" : ".\n");
                            break;
                            
                        case SCfdConsts.PROC_REQ_VERIFY:
                            SCfdUtils.validateCfdi(miClient, cfd, mnSubtypeCfd, false);
                            detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": Verificado.\n";
                            break;
                            
                        default:
                    }
                    
                    cfdProcessedOk++;
                }
                catch (Exception e) {
                    detailMessage += (series.isEmpty() ? "" : series + "-") + number + ": " + e.getMessage() + "\n";
                    cfdProcessedWrong++;
                }

                updateForm(cfdProcessed, cfdProcessedOk, cfdProcessedWrong, detailMessage);
            }
            
            if (maCfds.isEmpty()) {
                detailMessage += "No se encontraron CFD para ser procesados.\n";
                updateForm(cfdProcessed, cfdProcessedOk, cfdProcessedWrong, detailMessage);
            }
            
            warningMessage = SCfdUtils.verifyCertificateExpiration(miClient);
            jtfWarningMessage.setText(warningMessage);
            
            if (cfdProcessedOk > 0 && registryType != SLibConsts.UNDEFINED) {
                miClient.getSession().notifySuscriptors(registryType);
            }
        }
    }

    private void updateForm(final int cfdProcessed, final int cfdProcessedOk, final int cfdProcessedWrong, final String messages) {
        moIntCfdProcessed.setValue(cfdProcessed);
        moIntCfdProcessedOk.setValue(cfdProcessedOk);
        moIntCfdProcessedWrong.setValue(cfdProcessedWrong);
        
        if (mnStampsAvailable == 0) {
            moIntStampsAvailable.setValue(0);
            moIntStampsConsumed.setValue(0);
            moIntStampsRemaining.setValue(0);
        }
        else {
            moIntStampsAvailable.setValue(mnStampsAvailable);
            moIntStampsConsumed.setValue(cfdProcessedOk);
            moIntStampsRemaining.setValue(mnStampsAvailable - cfdProcessedOk);
        }
        
        jtaMessages.setText(messages);
        
        update(getGraphics());
        jspMessages.getVerticalScrollBar().setValue(jspMessages.getVerticalScrollBar().getMaximum());
    }
    
    /*
     * Public methods:
     */
    
    public void setFormParams(final SClientInterface client, final ArrayList<SDataCfd> cfds, final ArrayList<int[]> payrollReceiptKeys, final int stampsAvailable, Date annulmentDate, final boolean validateStamp, final int cfdSubtype, final int dpsAnnulmentType) {
        mbFirstTime = true;
        
        miClient = client;
        maCfds = cfds;
        maPayrollReceiptKeys = payrollReceiptKeys;
        mnStampsAvailable = stampsAvailable;
        mtAnnulmentDate = annulmentDate;
        mbValidateStamp = validateStamp;
        mnSubtypeCfd = cfdSubtype;
        mnDpsAnnulmentType = dpsAnnulmentType;
    }
    
    public void setPayrollReceipts(final ArrayList<SDbPayrollReceipt> payrollReceipts) {
       maPayrollReceipts = payrollReceipts;
    }
    
    public void setNumberCopies(final int numberCopies) {
        mnNumberCopies = numberCopies;
    }

    @Override
    public void addAllListeners() {

    }

    @Override
    public void removeAllListeners() {

    }

    @Override
    public void reloadCatalogues() {
        
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        return validation;
    }
}
