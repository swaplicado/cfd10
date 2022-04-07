/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.log.form;

import erp.cfd.SCfdXmlCatalogs;
import erp.data.SDataConstantsSys;
import erp.gui.session.SSessionCustom;
import erp.lib.SLibConstants;
import erp.mod.SModConsts;
import erp.mod.log.db.SDbTrailer;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;

/**
 *
 * @author Isabel Servín
 */
public class SFormTrailer extends sa.lib.gui.bean.SBeanForm {

    private SDbTrailer moRegistry;

    /**
     * Creates new form SFormVehicleType
     * @param client
     * @param title
     */
    public SFormTrailer(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.LOG_TRAILER, SLibConstants.UNDEFINED, title);
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
        jPanel24 = new javax.swing.JPanel();
        jlName = new javax.swing.JLabel();
        moTextName = new sa.lib.gui.bean.SBeanFieldText();
        jPanel25 = new javax.swing.JPanel();
        jlPlate = new javax.swing.JLabel();
        moTextPlate = new sa.lib.gui.bean.SBeanFieldText();
        jPanel26 = new javax.swing.JPanel();
        jlTrailerStp = new javax.swing.JLabel();
        moKeyTrailerStp = new sa.lib.gui.bean.SBeanFieldKey();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel23.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlName.setText("Nombre:*");
        jlName.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel24.add(jlName);

        moTextName.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel24.add(moTextName);

        jPanel23.add(jPanel24);

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPlate.setText("Placa:*");
        jlPlate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel25.add(jlPlate);
        jPanel25.add(moTextPlate);

        jPanel23.add(jPanel25);

        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTrailerStp.setText("Subtipo remolque:*");
        jlTrailerStp.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel26.add(jlTrailerStp);

        moKeyTrailerStp.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel26.add(moKeyTrailerStp);

        jPanel23.add(jPanel26);

        jPanel1.add(jPanel23, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlPlate;
    private javax.swing.JLabel jlTrailerStp;
    private sa.lib.gui.bean.SBeanFieldKey moKeyTrailerStp;
    private sa.lib.gui.bean.SBeanFieldText moTextName;
    private sa.lib.gui.bean.SBeanFieldText moTextPlate;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 480, 300);

        moTextName.setTextSettings(SGuiUtils.getLabelName(jlName.getText()), 50);
        moTextPlate.setTextSettings(SGuiUtils.getLabelName(jlPlate.getText()), 50);
        moKeyTrailerStp.setKeySettings(miClient, SGuiUtils.getLabelName(jlTrailerStp), true);
        
        moFields.addField(moTextName);
        moFields.addField(moTextPlate);
        moFields.addField(moKeyTrailerStp);
        
        moFields.setFormButton(jbSave);
    }

    @Override
    public void addAllListeners() {

    }

    @Override
    public void removeAllListeners() {

    }

    @Override
    public void reloadCatalogues() {
        SCfdXmlCatalogs catalogs = ((SSessionCustom) miClient.getSession().getSessionCustom()).getCfdXmlCatalogs();
        catalogs.populateComboBox(moKeyTrailerStp, SDataConstantsSys.TRNS_CFD_CAT_BOL_TRAILER_STP, miClient.getSession().getSystemDate());
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        moRegistry = (SDbTrailer) registry;

        mnFormResult = SLibConsts.UNDEFINED;
        mbFirstActivation = true;

        removeAllListeners();
        reloadCatalogues();

        if (moRegistry.isRegistryNew()) {
            moRegistry.initPrimaryKey();
            jtfRegistryKey.setText("");
        }
        else {
            jtfRegistryKey.setText(SLibUtils.textKey(moRegistry.getPrimaryKey()));
        }

        moTextName.setValue(moRegistry.getName());
        moTextPlate.setValue(moRegistry.getPlate());
        SGuiUtils.locateItemByCode(moKeyTrailerStp, moRegistry.getTrailerSubtype());
        
        setFormEditable(true);

        if (moRegistry.isRegistryNew()) { }

        addAllListeners();
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        SDbTrailer registry = moRegistry.clone();

        if (registry.isRegistryNew()) {}

        registry.setName(moTextName.getValue());
        registry.setPlate(moTextPlate.getValue());
        registry.setTrailerSubtype(moKeyTrailerStp.getSelectedItem().getCode());
        
        return registry;
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        return validation;
    }
}