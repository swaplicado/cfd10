/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.trn.form;

import erp.client.SClientInterface;
import erp.data.SDataConstants;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.mitm.data.SDataItem;
import erp.mitm.data.SDataUnit;
import erp.mod.SModConsts;
import erp.mod.trn.db.SDbItemCost;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiOptionPicker;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFieldKey;

/**
 *
 * @author Isabel Servín
 * 
 */
public class SFormItemCost extends sa.lib.gui.bean.SBeanForm implements ActionListener, ItemListener {

    private SDbItemCost moRegistry;
    private SDataUnit moDataUnit;

    /**
     * Creates new form SFormItemCost
     * @param client
     * @param title
     */
    public SFormItemCost(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.TRN_ITEM_COST, SLibConstants.UNDEFINED, title);
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
        jPanel23 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jlItem = new javax.swing.JLabel();
        moKeyItem = new sa.lib.gui.bean.SBeanFieldKey();
        jbPickItem = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jlUnit = new javax.swing.JLabel();
        moUnit = new sa.lib.gui.bean.SBeanFieldText();
        jPanel21 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        moDateDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel25 = new javax.swing.JPanel();
        jlCost = new javax.swing.JLabel();
        moCurCost = new sa.lib.gui.bean.SBeanCompoundFieldCurrency();

        setPreferredSize(new java.awt.Dimension(640, 400));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 450));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel23.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlItem.setText("Ítem:*");
        jlItem.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel22.add(jlItem);

        moKeyItem.setPreferredSize(new java.awt.Dimension(450, 23));
        jPanel22.add(moKeyItem);

        jbPickItem.setText("...");
        jbPickItem.setToolTipText("Seleccionar ítem");
        jbPickItem.setFocusable(false);
        jbPickItem.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel22.add(jbPickItem);

        jPanel23.add(jPanel22);

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlUnit.setText("Unidad:");
        jlUnit.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel24.add(jlUnit);

        moUnit.setEditable(false);
        moUnit.setPreferredSize(new java.awt.Dimension(190, 23));
        jPanel24.add(moUnit);

        jPanel23.add(jPanel24);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial:*");
        jlDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel21.add(jlDateStart);
        jPanel21.add(moDateDateStart);

        jPanel23.add(jPanel21);

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCost.setText("Costo:*");
        jlCost.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel25.add(jlCost);
        jPanel25.add(moCurCost);

        jPanel23.add(jPanel25);

        jPanel1.add(jPanel23, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbPickItem;
    private javax.swing.JLabel jlCost;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlItem;
    private javax.swing.JLabel jlUnit;
    private sa.lib.gui.bean.SBeanCompoundFieldCurrency moCurCost;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateStart;
    private sa.lib.gui.bean.SBeanFieldKey moKeyItem;
    private sa.lib.gui.bean.SBeanFieldText moUnit;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 640, 400);
        
        moKeyItem.setKeySettings(miClient, SGuiUtils.getLabelName(jlItem), true);
        moDateDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart), true);
        moCurCost.setCompoundFieldSettings(miClient);
        moCurCost.getField().setDecimalSettings(SGuiUtils.getLabelName(jlCost), SGuiConsts.GUI_TYPE_DEC_AMT_UNIT, true);
        
        moFields.addField(moKeyItem);
        moFields.addField(moDateDateStart);
        moFields.addField(moCurCost.getField());

        moFields.setFormButton(jbSave);
        
        jbPickItem.addActionListener(this);
    }
    
    private SGuiValidation validateRegistryUnicity() {
        SGuiValidation validation = new SGuiValidation();
        validation.setValid(true);
        
        if (moRegistry.isRegistryNew()) {
            try {
                String sql = "SELECT b_del FROM trn_item_cost " +
                    "WHERE fk_item = " + moKeyItem.getValue()[0] + " " +
                    "AND fk_unit = " + moDataUnit.getPkUnitId() + " " +
                    "AND dt_sta = '" + SLibUtils.DbmsDateFormatDate.format(moDateDateStart.getValue()) + "';";

                ResultSet resultSet = miClient.getSession().getStatement().executeQuery(sql);
                if (resultSet.next()) {
                    validation.setMessage("Ya existe un registro para este ítem, unidad y fecha." +
                            (resultSet.getBoolean("b_del") ? "\nEl registro en cuestión está eliminado." : ""));
                }
            }
            catch (Exception e) {
                miClient.showMsgBoxError(e.getMessage());
            }
        }
        return validation;
    }

    private void actionPerformedPickItem() {
        int[] key;
        SGuiOptionPicker picker;

        picker = miClient.getSession().getModule(SModConsts.MOD_ITM_N).getOptionPicker(SModConsts.ITMU_ITEM, SLibConsts.UNDEFINED, null);
        picker.resetPicker();
        picker.setPickerVisible(true);

        if (picker.getPickerResult() == SGuiConsts.FORM_RESULT_OK) {
            key = (int[]) picker.getOption();

            if (key != null) {
                if (key[0] != SLibConsts.UNDEFINED) {
                    moKeyItem.setValue(new int[] { key[0] });
                }
            }
        }
    }
    
    private void itemStateChangedItem() {
        try {
            if(moKeyItem.getSelectedIndex() <= 0) {
                moDataUnit = null;
                
                moUnit.setValue("");
            }
            else {
                SDataItem item = (SDataItem) SDataUtilities.readRegistry((SClientInterface) miClient,
                                SDataConstants.ITMU_ITEM, moKeyItem.getValue(), SLibConstants.EXEC_MODE_SILENT);
                moDataUnit = item.getDbmsDataUnit();
                
                moUnit.setValue(moDataUnit.getUnit());
            }
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }
    }
    
    @Override
    public void addAllListeners() {
        moKeyItem.addItemListener(this);
    }

    @Override
    public void removeAllListeners() {
        moKeyItem.removeItemListener(this); 
    }

    @Override
    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyItem, SModConsts.ITMU_ITEM, SLibConsts.UNDEFINED, null);
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        moRegistry = (SDbItemCost) registry;

        mnFormResult = SLibConsts.UNDEFINED;
        mbFirstActivation = true;

        removeAllListeners();
        reloadCatalogues();

        if (moRegistry.isRegistryNew()) {
            moRegistry.initPrimaryKey();
            moRegistry.setDateStart(miClient.getSession().getCurrentDate());
            jtfRegistryKey.setText("");
        }
        else {
            jtfRegistryKey.setText(SLibUtils.textKey(moRegistry.getPrimaryKey()));
        }

        moKeyItem.setValue(new int[] { moRegistry.getFkItemId() });
        itemStateChangedItem();
        moDateDateStart.setValue(moRegistry.getDateStart());
        moCurCost.getField().setValue(moRegistry.getCost());
        
        setFormEditable(true);

        if (moRegistry.isRegistryNew()) { }

        addAllListeners();
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        SDbItemCost registry = (SDbItemCost) moRegistry.clone();

        if (registry.isRegistryNew()) {}
        
        moRegistry.setFkItemId(moKeyItem.getValue()[0]);
        moRegistry.setFkUnitId(moDataUnit.getPkUnitId());
        moRegistry.setDateStart(moDateDateStart.getValue());
        moRegistry.setCost(moCurCost.getField().getValue());

        return registry;
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();
        
        if (validation.isValid()) {
            validation = validateRegistryUnicity();
        }

        return validation;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button == jbPickItem) {
                actionPerformedPickItem();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof SBeanFieldKey) {
            SBeanFieldKey field = (SBeanFieldKey) e.getSource();
            if (field == moKeyItem) {
                itemStateChangedItem();
            }
        }
    }
}