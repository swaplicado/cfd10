/*
 *
 *
 * Created on 18 de agosto de 2009, 01:42 AM
 */

package erp.mmfg.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.mmfg.data.SDataExplotionMaterials;
import erp.mmfg.data.SDataProductionOrder;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author  Néstor Ávalos
 */
public class SDialogExplotionMaterials extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private boolean mbIsForecast;
    private boolean mbIsExplode;

    private erp.mmfg.data.SDataExplotionMaterials moExplotionMaterials;
    private erp.lib.form.SFormField moFieldFkCobId;
    private erp.lib.form.SFormField moFieldFkEntityId;
    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldProdOrdStart;
    private erp.lib.form.SFormField moFieldProdOrdEnd;

    private java.util.Vector<erp.lib.form.SFormComponentItem> mvItemsEntities = null;

    private boolean mbIsUniversalCompany;

    /** Creates new form DFormCompany */
    public SDialogExplotionMaterials(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
        mnFormType = SDataConstants.MFG_EXP;

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

        bgSelect = new javax.swing.ButtonGroup();
        jpHead = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlFkCobId = new javax.swing.JLabel();
        jcbFkCobId = new javax.swing.JComboBox<SFormComponentItem>();
        jlDummy3 = new javax.swing.JLabel();
        jbFkCobId = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlFkEntityId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jliFkEntityId = new javax.swing.JList<SFormComponentItem>();
        jPanel21 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jckIsComplete = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jlDate = new javax.swing.JLabel();
        jtfDate = new javax.swing.JFormattedTextField();
        jlDummy14 = new javax.swing.JLabel();
        jbDate = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jlProdOrdStart = new javax.swing.JLabel();
        jcbProdOrdStart = new javax.swing.JComboBox<SFormComponentItem>();
        jlDummy1 = new javax.swing.JLabel();
        jbProdOrdStart = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jlProdOrdEnd = new javax.swing.JLabel();
        jcbProdOrdEnd = new javax.swing.JComboBox<SFormComponentItem>();
        jlDummy2 = new javax.swing.JLabel();
        jbProdOrdEnd = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jbExplotionMaterials = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Explosión de materiales"); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jpHead.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpHead.setLayout(new java.awt.BorderLayout(0, 3));

        jPanel4.setLayout(new java.awt.GridLayout(1, 1));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlFkCobId.setText("Sucursal de la empresa: *");
        jlFkCobId.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel3.add(jlFkCobId);

        jcbFkCobId.setPreferredSize(new java.awt.Dimension(250, 23));
        jcbFkCobId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbFkCobIdItemStateChanged(evt);
            }
        });
        jPanel3.add(jcbFkCobId);

        jlDummy3.setPreferredSize(new java.awt.Dimension(2, 23));
        jPanel3.add(jlDummy3);

        jbFkCobId.setText("...");
        jbFkCobId.setToolTipText("Seleccionar orden de producción");
        jbFkCobId.setFocusable(false);
        jbFkCobId.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel3.add(jbFkCobId);

        jPanel4.add(jPanel3);

        jpHead.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jlFkEntityId.setText("Almacen:");
        jlFkEntityId.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel1.add(jlFkEntityId, java.awt.BorderLayout.WEST);

        jliFkEntityId.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jliFkEntityId);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jpHead.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel21.setLayout(new java.awt.BorderLayout(0, 3));

        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 3));

        jckIsComplete.setText("Explosionar fórmulas completas [MP, ME, concentrados]  (recomendable para pronósticos)");
        jPanel7.add(jckIsComplete);

        jPanel21.add(jPanel7, java.awt.BorderLayout.SOUTH);

        jPanel8.setLayout(new java.awt.GridLayout(3, 0, 0, 3));

        jPanel30.setPreferredSize(new java.awt.Dimension(230, 23));
        jPanel30.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlDate.setText("Fecha de evaluación: *");
        jlDate.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel30.add(jlDate);

        jtfDate.setText("DATE");
        jtfDate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel30.add(jtfDate);

        jlDummy14.setPreferredSize(new java.awt.Dimension(2, 23));
        jPanel30.add(jlDummy14);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel30.add(jbDate);

        jPanel8.add(jPanel30);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlProdOrdStart.setText("Orden de producción inicial: *");
        jlProdOrdStart.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel5.add(jlProdOrdStart);

        jcbProdOrdStart.setPreferredSize(new java.awt.Dimension(450, 23));
        jcbProdOrdStart.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbProdOrdStartItemStateChanged(evt);
            }
        });
        jPanel5.add(jcbProdOrdStart);

        jlDummy1.setPreferredSize(new java.awt.Dimension(2, 23));
        jPanel5.add(jlDummy1);

        jbProdOrdStart.setText("...");
        jbProdOrdStart.setToolTipText("Seleccionar orden de producción");
        jbProdOrdStart.setFocusable(false);
        jbProdOrdStart.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbProdOrdStart);

        jPanel8.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jlProdOrdEnd.setText("Orden de producción final: *");
        jlProdOrdEnd.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel6.add(jlProdOrdEnd);

        jcbProdOrdEnd.setPreferredSize(new java.awt.Dimension(450, 23));
        jPanel6.add(jcbProdOrdEnd);

        jlDummy2.setPreferredSize(new java.awt.Dimension(2, 23));
        jPanel6.add(jlDummy2);

        jbProdOrdEnd.setText("...");
        jbProdOrdEnd.setToolTipText("Seleccionar orden de producción");
        jbProdOrdEnd.setFocusable(false);
        jbProdOrdEnd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel6.add(jbProdOrdEnd);

        jPanel8.add(jPanel6);

        jPanel21.add(jPanel8, java.awt.BorderLayout.NORTH);

        jpHead.add(jPanel21, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jpHead, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbExplotionMaterials.setText("Explosionar"); // NOI18N
        jbExplotionMaterials.setToolTipText("[Ctrl + Enter]");
        jbExplotionMaterials.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel2.add(jbExplotionMaterials);

        jbCancel.setText("Cerrar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jbCancel.setPreferredSize(new java.awt.Dimension(90, 23));
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        setSize(new java.awt.Dimension(667, 314));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jcbFkCobIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbFkCobIdItemStateChanged
        itemStateChangedFkCobId();
    }//GEN-LAST:event_jcbFkCobIdItemStateChanged

    private void jcbProdOrdStartItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbProdOrdStartItemStateChanged
        itemStateChangedProdOrdStart();
    }//GEN-LAST:event_jcbProdOrdStartItemStateChanged

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        mbIsUniversalCompany = miClient.getSessionXXX().getIsUniversal() || miClient.getSessionXXX().getIsUniversalCompany(miClient.getSessionXXX().getCompany().getPkCompanyId());

        moFieldFkCobId = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbFkCobId, jlFkCobId);
        moFieldFkCobId.setPickerButton(jbFkCobId);
        moFieldFkEntityId = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, false, jliFkEntityId, jlFkEntityId);
        moFieldDate = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jtfDate, jlDate);
        moFieldDate.setPickerButton(jbDate);
        moFieldProdOrdStart = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbProdOrdStart, jlProdOrdStart);
        moFieldProdOrdStart.setPickerButton(jbProdOrdStart);
        moFieldProdOrdEnd = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_KEY, true, jcbProdOrdEnd, jlProdOrdEnd);
        moFieldProdOrdEnd.setPickerButton(jbProdOrdEnd);

        mvFields.add(moFieldFkCobId);
        //mvFields.add(moFieldFkEntityId);
        mvFields.add(moFieldDate);
        mvFields.add(moFieldProdOrdStart);
        mvFields.add(moFieldProdOrdEnd);

        jbExplotionMaterials.addActionListener(this);
        jbCancel.addActionListener(this);
        jbFkCobId.addActionListener(this);
        jbDate.addActionListener(this);
        jbProdOrdStart.addActionListener(this);
        jbProdOrdEnd.addActionListener(this);

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
            jcbFkCobId.requestFocus();
        }
    }

    private void actionFkCobId() {
        miClient.pickOption(SDataConstants.BPSU_BPB, moFieldFkCobId, new int[] { miClient.getSessionXXX().getParamsCompany().getPkConfigCoId() });
    }

    private void actionFkEntityId() {
        miClient.pickOption(SDataConstants.CFGU_COB_ENT, moFieldFkEntityId, new int[] { moFieldFkEntityId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_WH });
    }

    private void actionDate() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDate.getDate(), moFieldDate);
    }

    private void actionProdOrdStart() {
        miClient.pickOption(SDataConstants.MFG_ORD, moFieldProdOrdStart, new Object[] { "" + SDataConstantsSys.MFGS_ST_ORD_NEW, SDataConstants.MFGX_ORD_MAIN_NA, mbIsForecast });
    }

    private void actionProdOrdEnd() {
        miClient.pickOption(SDataConstants.MFG_ORD, moFieldProdOrdEnd, new Object[] { "" + SDataConstantsSys.MFGS_ST_ORD_NEW, SDataConstants.MFGX_ORD_MAIN_NA, mbIsForecast });
    }

    private void itemStateChangedProdOrdStart() {
        if (jcbProdOrdStart.getSelectedIndex() > 0) {
            jcbProdOrdEnd.setSelectedIndex(jcbProdOrdStart.getSelectedIndex());
        }
    }

    private void itemStateChangedFkCobId() {

        if (jcbFkCobId.getSelectedIndex() <= 0) {
            mvItemsEntities = new Vector<SFormComponentItem>();
        }
        else {
            if (isUniversalCompanyBranch()) {
                mvItemsEntities = miClient.getSessionXXX().getAllCompanyBranchEntitiesAsComponentItems(moFieldFkCobId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_WH, false);
            }
            else {
                mvItemsEntities = miClient.getSessionXXX().getUserCompanyBranchEntitiesAsComponentItems(moFieldFkCobId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_WH, false);
            }
        }
     
        jliFkEntityId.removeAll();
        jliFkEntityId.setListData(mvItemsEntities);

        if (jliFkEntityId.getModel().getSize() > 1) {
            jliFkEntityId.setEnabled(true);
        }
        else {
            jliFkEntityId.setEnabled(false);
        }
    }

    private int validateProductionOrders() {
        int nRes = 0;
        String sMove = "";

        SDataProductionOrder oProductionOrder = null;

        if (moFieldProdOrdStart.getKeyAsIntArray()[0] != moFieldProdOrdEnd.getKeyAsIntArray()[0]) {
            miClient.showMsgBoxWarning("El rango de las órdenes de producción deben ser del mismo año.");
            nRes = 1;
        }
        else {
            if (!mbIsForecast) {
                for (int nPkOrderId=moFieldProdOrdStart.getKeyAsIntArray()[1]; nPkOrderId<=moFieldProdOrdEnd.getKeyAsIntArray()[1]; nPkOrderId++) {
                    try {

                        sMove = SDataUtilities.checkProductionOrderExternalRelations(miClient, moFieldProdOrdStart.getKeyAsIntArray()[0], nPkOrderId);
                        if (sMove.length()>0) {
                            oProductionOrder = (SDataProductionOrder) SDataUtilities.readRegistry(miClient, SDataConstants.MFG_ORD, new int[] { moFieldProdOrdStart.getKeyAsIntArray()[0], nPkOrderId }, SLibConstants.EXEC_MODE_VERBOSE);
                            miClient.showMsgBoxWarning("No se puede explosionar la orden de producción '" + oProductionOrder.getDbmsNumber() + "', porque tiene movimientos de '" + sMove + "'");
                            nRes=1;
                            break;
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        }

        return nRes;
    }

    private void actionExplotionMaterials() {
        SFormValidation validation = new SFormValidation();
        SDialogExplotionMaterialsRawMaterial oExplotionMaterials = new SDialogExplotionMaterialsRawMaterial(miClient);

        validation = formValidate();
        if (!validation.getIsError()) {
            if (validateProductionOrders() == 0) {
                oExplotionMaterials.formReset();
                oExplotionMaterials.setValue(1, moFieldFkCobId.getKey());

                ArrayList<int[]> fkEntityId = new ArrayList<>();
                for(SFormComponentItem item : jliFkEntityId.getSelectedValuesList()){
                    fkEntityId.add((int[]) item.getPrimaryKey());
                }

                oExplotionMaterials.setValue(2, jliFkEntityId.getSelectedIndex() >= 0 ? fkEntityId : null);
                oExplotionMaterials.setValue(3, moFieldDate.getDate());
                oExplotionMaterials.setValue(4, mbIsForecast);
                oExplotionMaterials.setValue(5, jckIsComplete.isSelected());
                oExplotionMaterials.setValue(6, jcbProdOrdStart.getSelectedItem().toString());
                oExplotionMaterials.setValue(7, jcbProdOrdEnd.getSelectedItem().toString());
                oExplotionMaterials.setValue(8, new int[] {moFieldProdOrdStart.getKeyAsIntArray()[0], moFieldProdOrdStart.getKeyAsIntArray()[1], moFieldProdOrdEnd.getKeyAsIntArray()[0], moFieldProdOrdEnd.getKeyAsIntArray()[1]});
                oExplotionMaterials.setTitle("Explosión de órdenes de producción");
                oExplotionMaterials.setVisible(true);

                if (oExplotionMaterials.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
                    moExplotionMaterials = (SDataExplotionMaterials) oExplotionMaterials.getRegistry();
                    mbIsExplode = true;
                }
            }
        }
    }

    private boolean isUniversalCompany() {
        return mbIsUniversalCompany;
    }

    private boolean isUniversalCompanyBranch() {
        return isUniversalCompany() ||
                miClient.getSessionXXX().getIsUniversalCompanyBranch(moFieldFkCobId.getKeyAsIntArray()[0]) ||
                miClient.getSessionXXX().getIsUniversalCompanyBranchEntities(moFieldFkCobId.getKeyAsIntArray()[0], SDataConstantsSys.CFGS_CT_ENT_PLANT);
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
            actionExplotionMaterials();
        }

        if (mbIsExplode) {
            miClient.getGuiModule(SDataConstants.MOD_MFG).refreshCatalogues(SDataConstants.MFG_EXP);
            miClient.getGuiModule(SDataConstants.MOD_MFG).refreshCatalogues(SDataConstants.MFG_ORD);
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;

        if (mbIsExplode) {
            miClient.getGuiModule(SDataConstants.MOD_MFG).refreshCatalogues(SDataConstants.MFG_EXP);
            miClient.getGuiModule(SDataConstants.MOD_MFG).refreshCatalogues(SDataConstants.MFG_ORD);
        }

        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSelect;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbExplotionMaterials;
    private javax.swing.JButton jbFkCobId;
    private javax.swing.JButton jbProdOrdEnd;
    private javax.swing.JButton jbProdOrdStart;
    private javax.swing.JComboBox<SFormComponentItem> jcbFkCobId;
    private javax.swing.JComboBox<SFormComponentItem> jcbProdOrdEnd;
    private javax.swing.JComboBox<SFormComponentItem> jcbProdOrdStart;
    private javax.swing.JCheckBox jckIsComplete;
    private javax.swing.JLabel jlDate;
    private javax.swing.JLabel jlDummy1;
    private javax.swing.JLabel jlDummy14;
    private javax.swing.JLabel jlDummy2;
    private javax.swing.JLabel jlDummy3;
    private javax.swing.JLabel jlFkCobId;
    private javax.swing.JLabel jlFkEntityId;
    private javax.swing.JLabel jlProdOrdEnd;
    private javax.swing.JLabel jlProdOrdStart;
    private javax.swing.JList<SFormComponentItem> jliFkEntityId;
    private javax.swing.JPanel jpHead;
    private javax.swing.JFormattedTextField jtfDate;
    // End of variables declaration//GEN-END:variables

    public void setIsForecast(boolean b) { mbIsForecast = b; }

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mnFormStatus = SLibConstants.UNDEFINED;
        mbFirstTime = true;
        mbIsExplode = false;

        moExplotionMaterials = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        jliFkEntityId.setEnabled(false);
        jliFkEntityId.setFocusable(false);

        moFieldDate.setDate(miClient.getSessionXXX().getWorkingDate());
        moFieldFkCobId.setKey(new int[] { miClient.getSessionXXX().getCurrentCompanyBranchId() });
    }

    @Override
    public void formRefreshCatalogues() {
        Vector<SFormComponentItem> items = null;

        if (isUniversalCompany()) {
            items = miClient.getSessionXXX().getAllCompanyBranchesAsComponentItems(true);
        }
        else {
            items = miClient.getSessionXXX().getUserCompanyBranchesAsComponentItems(true);
        }

        jcbFkCobId.removeAllItems();
        for (SFormComponentItem item : items) {
            jcbFkCobId.addItem(item);
        }

        SFormUtilities.populateComboBox(miClient, jcbProdOrdStart, SDataConstants.MFG_ORD, new Object[] { "" + SDataConstantsSys.MFGS_ST_ORD_NEW, SDataConstants.MFGX_ORD_MAIN_NA, mbIsForecast });
        SFormUtilities.populateComboBox(miClient, jcbProdOrdEnd, SDataConstants.MFG_ORD, new Object[] { "" + SDataConstantsSys.MFGS_ST_ORD_NEW, SDataConstants.MFGX_ORD_MAIN_NA, mbIsForecast });
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

    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        return moExplotionMaterials;
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

            if (button == jbExplotionMaterials) {
                actionExplotionMaterials();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
            else if (button == jbProdOrdStart){
                actionProdOrdStart();
            }
            else if (button == jbProdOrdEnd){
                actionProdOrdEnd();
            }
            else if (button == jbFkCobId){
                actionFkCobId();
            }
            else if (button == jbDate) {
                actionDate();
            }
        }
    }
}
