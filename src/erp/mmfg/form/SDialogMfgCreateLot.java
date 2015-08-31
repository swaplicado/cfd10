/*
 * DFormCompany.java
 *
 * Created on 19 de agosto de 2008, 11:10 AM
 */

package erp.mmfg.form;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormValidation;
import erp.lib.form.SFormUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.mitm.data.SDataItem;
import erp.mmfg.data.SDataProductionOrder;
import erp.mtrn.data.SDataStockLot;
import erp.mtrn.data.STrnUtilities;

/**
 *
 * @author  Néstor Ávalos
 */
public class SDialogMfgCreateLot extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mmfg.data.SDataProductionOrder moProductionOrder;
    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldDateLotExpired;
    private erp.lib.form.SFormField moFieldLot;
    private erp.lib.form.SFormField moFieldQuantity;

    private erp.mitm.data.SDataItem moItem;

    /** Creates new form DFormCompany */
    public SDialogMfgCreateLot(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
        mnFormType = SDataConstants.MFG_ORD;

        initComponents();
        initComponentsExtra();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgCurrency = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jpData = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlCompanyBranch = new javax.swing.JLabel();
        jtfCompanyBranch = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jlEntity = new javax.swing.JLabel();
        jtfEntity = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jlType = new javax.swing.JLabel();
        jtfType = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jlFinishedGood = new javax.swing.JLabel();
        jtfFinishedGood = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jlFormula = new javax.swing.JLabel();
        jtfFormula = new javax.swing.JTextField();
        jPanel36 = new javax.swing.JPanel();
        jlQuantity = new javax.swing.JLabel();
        jtfQuantity = new javax.swing.JTextField();
        jlDummy = new javax.swing.JLabel();
        jtfUnit = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jtfDate = new javax.swing.JFormattedTextField();
        jPanel39 = new javax.swing.JPanel();
        jlNumber = new javax.swing.JLabel();
        jtfNumber = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jlLot = new javax.swing.JLabel();
        jtfLot = new javax.swing.JTextField();
        jlDummy3 = new javax.swing.JLabel();
        jtfLotDateExpired = new javax.swing.JFormattedTextField();
        jlDummy5 = new javax.swing.JLabel();
        jbDateLotExpired = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jlDummy6 = new javax.swing.JLabel();
        jbGenerateLot = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignación de lote de producto terminado (PT)"); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpData.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel8.setLayout(new java.awt.GridLayout(11, 1, 0, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlCompanyBranch.setText("Sucursal:");
        jlCompanyBranch.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel4.add(jlCompanyBranch);

        jtfCompanyBranch.setEditable(false);
        jtfCompanyBranch.setText("COMPANY BRANCH");
        jtfCompanyBranch.setCaretPosition(1);
        jtfCompanyBranch.setFocusable(false);
        jtfCompanyBranch.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel4.add(jtfCompanyBranch);

        jPanel8.add(jPanel4);

        jPanel32.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlEntity.setText("Planta:");
        jlEntity.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel32.add(jlEntity);

        jtfEntity.setEditable(false);
        jtfEntity.setText("ENTITY");
        jtfEntity.setCaretPosition(1);
        jtfEntity.setFocusable(false);
        jtfEntity.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel32.add(jtfEntity);

        jPanel8.add(jPanel32);

        jPanel33.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlType.setText("Tipo ord. prod.:");
        jlType.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel33.add(jlType);

        jtfType.setEditable(false);
        jtfType.setText("TYPE");
        jtfType.setCaretPosition(1);
        jtfType.setFocusable(false);
        jtfType.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel33.add(jtfType);

        jPanel8.add(jPanel33);

        jPanel34.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlFinishedGood.setText("Producto:");
        jlFinishedGood.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel34.add(jlFinishedGood);

        jtfFinishedGood.setEditable(false);
        jtfFinishedGood.setText("FINISHED GOOD");
        jtfFinishedGood.setCaretPosition(1);
        jtfFinishedGood.setFocusable(false);
        jtfFinishedGood.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel34.add(jtfFinishedGood);

        jPanel8.add(jPanel34);

        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlFormula.setText("Fórmula:");
        jlFormula.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel35.add(jlFormula);

        jtfFormula.setEditable(false);
        jtfFormula.setText("FORMULA");
        jtfFormula.setCaretPosition(1);
        jtfFormula.setFocusable(false);
        jtfFormula.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel35.add(jtfFormula);

        jPanel8.add(jPanel35);

        jPanel36.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlQuantity.setText("Cantidad:");
        jlQuantity.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel36.add(jlQuantity);

        jtfQuantity.setEditable(false);
        jtfQuantity.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtfQuantity.setText("QUANTITY");
        jtfQuantity.setFocusable(false);
        jtfQuantity.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel36.add(jtfQuantity);

        jlDummy.setPreferredSize(new java.awt.Dimension(1, 23));
        jPanel36.add(jlDummy);

        jtfUnit.setEditable(false);
        jtfUnit.setText("UNIT");
        jtfUnit.setFocusable(false);
        jtfUnit.setPreferredSize(new java.awt.Dimension(40, 23));
        jPanel36.add(jtfUnit);

        jPanel8.add(jPanel36);

        jPanel37.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlDate.setText("Fecha ord. prod.:");
        jlDate.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel37.add(jlDate);

        jtfDate.setEditable(false);
        jtfDate.setText("DATE");
        jtfDate.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel37.add(jtfDate);

        jPanel8.add(jPanel37);

        jPanel39.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlNumber.setText("Folio:");
        jlNumber.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel39.add(jlNumber);

        jtfNumber.setEditable(false);
        jtfNumber.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtfNumber.setText("NUMBER");
        jtfNumber.setFocusable(false);
        jtfNumber.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel39.add(jtfNumber);

        jPanel8.add(jPanel39);

        jPanel38.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlLot.setText("Lote/fecha caducidad: *");
        jlLot.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel38.add(jlLot);

        jtfLot.setText("LOT");
        jtfLot.setPreferredSize(new java.awt.Dimension(130, 23));
        jPanel38.add(jtfLot);

        jlDummy3.setPreferredSize(new java.awt.Dimension(1, 23));
        jPanel38.add(jlDummy3);

        jtfLotDateExpired.setText("DATE EXPIRED");
        jtfLotDateExpired.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel38.add(jtfLotDateExpired);

        jlDummy5.setPreferredSize(new java.awt.Dimension(1, 23));
        jPanel38.add(jlDummy5);

        jbDateLotExpired.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDateLotExpired.setToolTipText("Seleccionar fecha de caducidad");
        jbDateLotExpired.setFocusable(false);
        jbDateLotExpired.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel38.add(jbDateLotExpired);

        jPanel8.add(jPanel38);

        jPanel41.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlDummy6.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel41.add(jlDummy6);

        jbGenerateLot.setText("Generar Lote");
        jbGenerateLot.setToolTipText("Generar Lote");
        jPanel41.add(jbGenerateLot);

        jPanel8.add(jPanel41);

        jpData.add(jPanel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpData, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbOk);

        jbCancel.setText("Cerrar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jbCancel.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-458)/2, (screenSize.height-372)/2, 458, 372);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDate = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DATE, false, jtfDate, jlDate);
        moFieldLot = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtfLot, jlLot);
        moFieldDateLotExpired = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jtfLotDateExpired, jlDate);
        moFieldDateLotExpired.setPickerButton(jbDateLotExpired);
        moFieldQuantity = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DOUBLE, false, jtfQuantity, jlQuantity);

        mvFields.add(moFieldDate);
        mvFields.add(moFieldLot);
        mvFields.add(moFieldDateLotExpired);
        mvFields.add(moFieldQuantity);

        jbCancel.addActionListener(this);
        jbOk.addActionListener(this);
        jbGenerateLot.addActionListener(this);
        jbDateLotExpired.addActionListener(this);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionCancel, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            jtfLot.requestFocus();
        }
    }

    private void actionGenerateLot() {
        try {
            int nLotId = SDataUtilities.obtainLotByItem(miClient, moProductionOrder.getFkItemId_r(), moProductionOrder.getFkUnitId_r());

            if (miClient.getSessionXXX().getParamsErp().getLotModel() == SDataConstantsSys.CFGS_LOT_MODEL_CONS) {
                moFieldLot.setFieldValue("" + nLotId);
            }
            else if (miClient.getSessionXXX().getParamsErp().getLotModel() == SDataConstantsSys.CFGS_LOT_MODEL_CONS_DATE) {
                moFieldLot.setFieldValue("" + moProductionOrder.getPkOrdId() + "-" + miClient.getSessionXXX().getFormatters().getDateFormat().format(miClient.getSessionXXX().getWorkingDate()));
            }
        }
        catch (Exception e) {
            SLibUtilities.printOutException(this,  e);
        }
    }

    private void renderRecord() {
        jtfCompanyBranch.setText(moProductionOrder.getDbmsCompanyBranch());
        jtfEntity.setText(moProductionOrder.getDbmsEntity());
        jtfType.setText(moProductionOrder.getDbmsProductionOrderType());
        jtfFinishedGood.setText(moProductionOrder.getDbmsFinishedGood());
        jtfFinishedGood.setToolTipText(moProductionOrder.getDbmsFinishedGood());
        jtfFormula.setText(moProductionOrder.getDbmsBom());
        jtfFormula.setText(moProductionOrder.getDbmsBom());
        moFieldQuantity.setFieldValue(moProductionOrder.getQuantity());
        jtfUnit.setText(moProductionOrder.getDbmsBomUnitSymbol());
        moFieldDate.setFieldValue(moProductionOrder.getDate());
        jtfNumber.setText(moProductionOrder.getDbmsNumber());
        moFieldLot.setFieldValue(moProductionOrder.getDbmsLot());
        moFieldDateLotExpired.setFieldValue(moProductionOrder.getDbmsLotDateExpired() != null ? moProductionOrder.getDbmsLotDateExpired() : miClient.getSessionXXX().getWorkingDate());
    }

    private void renderLot() {
        moItem = (SDataItem) SDataUtilities.readRegistry(miClient, SDataConstants.ITMU_ITEM, new int[] { moProductionOrder.getFkItemId_r() }, SLibConstants.EXEC_MODE_VERBOSE);

        if (moProductionOrder.getDbmsLot().length()<=0) {
            if (moItem.getDbmsDataItemGeneric().getDaysForExpiration() > 0) {
                moFieldDateLotExpired.setDate(SLibTimeUtilities.addDate(moFieldDateLotExpired.getDate(), 0, 0, moItem.getDbmsDataItemGeneric().getDaysForExpiration()));
                moFieldDateLotExpired.setIsMandatory(true);
            }
            else {
                moFieldDateLotExpired.setIsMandatory(false);
                moFieldDateLotExpired.setDate(null);
            }
        }
    }

    private void actionSetDateLotExpired() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateLotExpired.getDate(), moFieldDateLotExpired);
    }

    private void actionEdit(boolean edit) {

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
        miClient.getGuiModule(SDataConstants.MOD_MFG).refreshCatalogues(SDataConstants.MFG_ORD);
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        miClient.getGuiModule(SDataConstants.MOD_MFG).refreshCatalogues(SDataConstants.MFG_ORD);
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCurrency;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDateLotExpired;
    private javax.swing.JButton jbGenerateLot;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlCompanyBranch;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JLabel jlDummy3;
    private javax.swing.JLabel jlDummy5;
    private javax.swing.JLabel jlDummy6;
    private javax.swing.JLabel jlEntity;
    private javax.swing.JLabel jlFinishedGood;
    private javax.swing.JLabel jlFormula;
    private javax.swing.JLabel jlLot;
    private javax.swing.JLabel jlNumber;
    private javax.swing.JLabel jlQuantity;
    private javax.swing.JLabel jlType;
    private javax.swing.JPanel jpData;
    private javax.swing.JTextField jtfCompanyBranch;
    private javax.swing.JFormattedTextField jtfDate;
    private javax.swing.JTextField jtfEntity;
    private javax.swing.JTextField jtfFinishedGood;
    private javax.swing.JTextField jtfFormula;
    private javax.swing.JTextField jtfLot;
    private javax.swing.JFormattedTextField jtfLotDateExpired;
    private javax.swing.JTextField jtfNumber;
    private javax.swing.JTextField jtfQuantity;
    private javax.swing.JTextField jtfType;
    private javax.swing.JTextField jtfUnit;
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

        moFieldDate.setDate(miClient.getSessionXXX().getWorkingDate());
        moFieldDateLotExpired.setDate(miClient.getSessionXXX().getWorkingDate());
        moFieldDateLotExpired.setIsMandatory(true);
    }

    @Override
    public void formRefreshCatalogues() {

    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        String message = "";

        SFormValidation validation = new SFormValidation();
        SDataStockLot oLot = null;

        for (int i = 0; i < mvFields.size(); i++) {
            if (!((erp.lib.form.SFormField) mvFields.get(i)).validateField()) {
                validation.setIsError(true);
                validation.setComponent(((erp.lib.form.SFormField) mvFields.get(i)).getComponent());
                break;
            }
        }

        try {
            if (!validation.getIsError()) {
                oLot = STrnUtilities.readLot(miClient, moProductionOrder.getFkItemId_r(), moProductionOrder.getFkUnitId_r(), moFieldLot.getString());

                if (oLot != null) {
                    if (oLot.getIsDeleted()) {
                        message = "El lote está eliminado";
                    }
                    else if (oLot.getIsBlocked()) {
                        message = "El lote está bloqueado";
                    }
                    else {
                        if (miClient.showMsgBoxConfirm("El lote ya existe. ¿Deseas utilizarlo?") != JOptionPane.YES_OPTION) {
                            validation.setIsError(true);
                            validation.setComponent(jtfLot);
                        }
                        else {
                            moProductionOrder.setFkLotItemId_nr(oLot.getPkItemId());
                            moProductionOrder.setFkLotUnitId_nr(oLot.getPkUnitId());
                            moProductionOrder.setFkLotId_n(oLot.getPkLotId());
                        }
                    }

                    if (message.length() > 0) {
                        validation.setMessage(message);
                        validation.setComponent(jtfLot);
                    }
                }
                else {

                    // New lot:

                    moProductionOrder.setFkLotId_n(0);
                }
            }
        }
        catch (Exception e) {
            validation.setMessage(e.toString());
            SLibUtilities.printOutException(this, e);
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

        if (moFieldLot.getString().length()>0) {
            moProductionOrder.setDbmsIsLot(true);
            moProductionOrder.setFkLotItemId_nr(moProductionOrder.getFkItemId_r());
            moProductionOrder.setFkLotUnitId_nr(moProductionOrder.getFkUnitId_r());
            moProductionOrder.setDbmsLot(moFieldLot.getString());
            moProductionOrder.setDbmsLotDateExpired(moFieldDateLotExpired.getDate());
            moProductionOrder.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
        }

        return moProductionOrder;
    }

    @Override
    public void setValue(int type, java.lang.Object value) {
        switch (type) {
            case 1:
                moProductionOrder = (SDataProductionOrder) SDataUtilities.readRegistry(miClient, SDataConstants.MFG_ORD, (int[]) value, SLibConstants.EXEC_MODE_VERBOSE);
                renderRecord();
                renderLot();
                break;
        }
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
            else if (button == jbDateLotExpired) {
                actionSetDateLotExpired();
            }
            else if (button == jbGenerateLot) {
                actionGenerateLot();
            }
        }
    }

}
