/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.log.form;

import erp.lib.SLibConstants;
import erp.mod.SModConsts;
import erp.mod.log.db.SDbBolPerson;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
public class SFormBolPerson extends sa.lib.gui.bean.SBeanForm implements FocusListener , ActionListener{

    private SDbBolPerson moRegistry;
    private SGuiClient moClient;
    
    /**
     * Creates new form SFormVehicle
     * @param client
     * @param title
     */
    public SFormBolPerson(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.LOG_BOL_PERSON, SLibConstants.UNDEFINED, title);
        initComponents();
        initComponentsCustom();
        moClient = client;
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
        jPanel38 = new javax.swing.JPanel();
        jlCountry = new javax.swing.JLabel();
        moKeyCountry = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel39 = new javax.swing.JPanel();
        jlZipCode = new javax.swing.JLabel();
        moTextZipCode = new sa.lib.gui.bean.SBeanFieldText();
        jbReloadZipComplements = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jlLocality = new javax.swing.JLabel();
        moTextLocality = new sa.lib.gui.bean.SBeanFieldText();
        jPanel37 = new javax.swing.JPanel();
        jlState = new javax.swing.JLabel();
        moKeyState = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel24 = new javax.swing.JPanel();
        jlName = new javax.swing.JLabel();
        moTextName = new sa.lib.gui.bean.SBeanFieldText();
        jPanel31 = new javax.swing.JPanel();
        jlPersonTp = new javax.swing.JLabel();
        moKeyPersonTp = new sa.lib.gui.bean.SBeanFieldKey();
        jPanel25 = new javax.swing.JPanel();
        jlFiscalId = new javax.swing.JLabel();
        moTextFiscalId = new sa.lib.gui.bean.SBeanFieldText();
        jPanel32 = new javax.swing.JPanel();
        jlFiscalFrgId = new javax.swing.JLabel();
        moTextFiscalFrgId = new sa.lib.gui.bean.SBeanFieldText();
        jPanel27 = new javax.swing.JPanel();
        jlDriverLic = new javax.swing.JLabel();
        moTextDriverLic = new sa.lib.gui.bean.SBeanFieldText();
        jPanel26 = new javax.swing.JPanel();
        jlTelephone = new javax.swing.JLabel();
        moTextTelephone = new sa.lib.gui.bean.SBeanFieldText();
        jPanel28 = new javax.swing.JPanel();
        jlStreet = new javax.swing.JLabel();
        moTextStreet = new sa.lib.gui.bean.SBeanFieldText();
        jPanel30 = new javax.swing.JPanel();
        jlNumberExt = new javax.swing.JLabel();
        moTextNumberExt = new sa.lib.gui.bean.SBeanFieldText();
        jPanel33 = new javax.swing.JPanel();
        jlNumberInt = new javax.swing.JLabel();
        moTextNumberInt = new sa.lib.gui.bean.SBeanFieldText();
        jPanel34 = new javax.swing.JPanel();
        jlNeighborhood = new javax.swing.JLabel();
        moTextNeighborhood = new sa.lib.gui.bean.SBeanFieldText();
        jPanel35 = new javax.swing.JPanel();
        jlReference = new javax.swing.JLabel();
        moTextReference = new sa.lib.gui.bean.SBeanFieldText();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel1.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel23.setLayout(new java.awt.GridLayout(15, 1, 0, 5));

        jPanel38.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlCountry.setText("País*:");
        jlCountry.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel38.add(jlCountry);

        moKeyCountry.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel38.add(moKeyCountry);

        jPanel23.add(jPanel38);

        jPanel39.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlZipCode.setText("Código postal*:");
        jlZipCode.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel39.add(jlZipCode);
        jPanel39.add(moTextZipCode);

        jbReloadZipComplements.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_action.gif"))); // NOI18N
        jbReloadZipComplements.setToolTipText("Importar localidad y estado");
        jbReloadZipComplements.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel39.add(jbReloadZipComplements);

        jPanel23.add(jPanel39);

        jPanel36.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlLocality.setText("Localidad:");
        jlLocality.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel36.add(jlLocality);

        moTextLocality.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel36.add(moTextLocality);

        jPanel23.add(jPanel36);

        jPanel37.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlState.setText("Estado*:");
        jlState.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel37.add(jlState);

        moKeyState.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel37.add(moKeyState);

        jPanel23.add(jPanel37);

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlName.setText("Nombre:*");
        jlName.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel24.add(jlName);

        moTextName.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel24.add(moTextName);

        jPanel23.add(jPanel24);

        jPanel31.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlPersonTp.setText("Tipo figura*:");
        jlPersonTp.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel31.add(jlPersonTp);

        moKeyPersonTp.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel31.add(moKeyPersonTp);

        jPanel23.add(jPanel31);

        jPanel25.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlFiscalId.setText("RFC*:");
        jlFiscalId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel25.add(jlFiscalId);
        jPanel25.add(moTextFiscalId);

        jPanel23.add(jPanel25);

        jPanel32.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlFiscalFrgId.setText("RFC extranjero:");
        jlFiscalFrgId.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel32.add(jlFiscalFrgId);
        jPanel32.add(moTextFiscalFrgId);

        jPanel23.add(jPanel32);

        jPanel27.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDriverLic.setText("Licencia:");
        jlDriverLic.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel27.add(jlDriverLic);
        jPanel27.add(moTextDriverLic);

        jPanel23.add(jPanel27);

        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlTelephone.setText("Teléfono:");
        jlTelephone.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel26.add(jlTelephone);
        jPanel26.add(moTextTelephone);

        jPanel23.add(jPanel26);

        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlStreet.setText("Calle:");
        jlStreet.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel28.add(jlStreet);

        moTextStreet.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel28.add(moTextStreet);

        jPanel23.add(jPanel28);

        jPanel30.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNumberExt.setText("No. exterior");
        jlNumberExt.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel30.add(jlNumberExt);
        jPanel30.add(moTextNumberExt);

        jPanel23.add(jPanel30);

        jPanel33.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNumberInt.setText("No. interior");
        jlNumberInt.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel33.add(jlNumberInt);
        jPanel33.add(moTextNumberInt);

        jPanel23.add(jPanel33);

        jPanel34.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlNeighborhood.setText("Colonia:");
        jlNeighborhood.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel34.add(jlNeighborhood);

        moTextNeighborhood.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel34.add(moTextNeighborhood);

        jPanel23.add(jPanel34);

        jPanel35.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlReference.setText("Referencia:");
        jlReference.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel35.add(jlReference);

        moTextReference.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel35.add(moTextReference);

        jPanel23.add(jPanel35);

        jPanel1.add(jPanel23, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JButton jbReloadZipComplements;
    private javax.swing.JLabel jlCountry;
    private javax.swing.JLabel jlDriverLic;
    private javax.swing.JLabel jlFiscalFrgId;
    private javax.swing.JLabel jlFiscalId;
    private javax.swing.JLabel jlLocality;
    private javax.swing.JLabel jlName;
    private javax.swing.JLabel jlNeighborhood;
    private javax.swing.JLabel jlNumberExt;
    private javax.swing.JLabel jlNumberInt;
    private javax.swing.JLabel jlPersonTp;
    private javax.swing.JLabel jlReference;
    private javax.swing.JLabel jlState;
    private javax.swing.JLabel jlStreet;
    private javax.swing.JLabel jlTelephone;
    private javax.swing.JLabel jlZipCode;
    private sa.lib.gui.bean.SBeanFieldKey moKeyCountry;
    private sa.lib.gui.bean.SBeanFieldKey moKeyPersonTp;
    private sa.lib.gui.bean.SBeanFieldKey moKeyState;
    private sa.lib.gui.bean.SBeanFieldText moTextDriverLic;
    private sa.lib.gui.bean.SBeanFieldText moTextFiscalFrgId;
    private sa.lib.gui.bean.SBeanFieldText moTextFiscalId;
    private sa.lib.gui.bean.SBeanFieldText moTextLocality;
    private sa.lib.gui.bean.SBeanFieldText moTextName;
    private sa.lib.gui.bean.SBeanFieldText moTextNeighborhood;
    private sa.lib.gui.bean.SBeanFieldText moTextNumberExt;
    private sa.lib.gui.bean.SBeanFieldText moTextNumberInt;
    private sa.lib.gui.bean.SBeanFieldText moTextReference;
    private sa.lib.gui.bean.SBeanFieldText moTextStreet;
    private sa.lib.gui.bean.SBeanFieldText moTextTelephone;
    private sa.lib.gui.bean.SBeanFieldText moTextZipCode;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 800, 500);
        
        moTextName.setTextSettings(SGuiUtils.getLabelName(jlName.getText()), 50);
        moKeyPersonTp.setKeySettings(miClient, SGuiUtils.getLabelName(jlPersonTp), true);
        moTextFiscalId.setTextSettings(SGuiUtils.getLabelName(jlFiscalId.getText()), 25, 0);
        moTextFiscalFrgId.setTextSettings(SGuiUtils.getLabelName(jlFiscalFrgId.getText()), 25, 0);
        moTextDriverLic.setTextSettings(SGuiUtils.getLabelName(jlDriverLic.getText()), 16, 0);
        moTextTelephone.setTextSettings(SGuiUtils.getLabelName(jlTelephone.getText()), 20, 0);
        moTextStreet.setTextSettings(SGuiUtils.getLabelName(jlNumberExt.getText()), 100, 0);
        moTextNumberExt.setTextSettings(SGuiUtils.getLabelName(jlNumberExt.getText()), 25, 0);
        moTextNumberInt.setTextSettings(SGuiUtils.getLabelName(jlNumberInt.getText()), 25, 0);
        moTextNeighborhood.setTextSettings(SGuiUtils.getLabelName(jlNeighborhood.getText()), 100, 0);
        moTextReference.setTextSettings(SGuiUtils.getLabelName(jlReference.getText()), 50, 0);
        moTextLocality.setTextSettings(SGuiUtils.getLabelName(jlLocality.getText()), 50, 0);
        moKeyState.setKeySettings(miClient, SGuiUtils.getLabelName(jlState), true);
        moKeyCountry.setKeySettings(miClient, SGuiUtils.getLabelName(jlCountry), true);
        moTextZipCode.setTextSettings(SGuiUtils.getLabelName(jlZipCode.getText()), 12, 1);
        
        moFields.addField(moTextName);
        moFields.addField(moKeyPersonTp);
        moFields.addField(moTextFiscalId);
        moFields.addField(moTextFiscalFrgId);
        moFields.addField(moTextDriverLic);
        moFields.addField(moTextTelephone);
        moFields.addField(moTextStreet);
        moFields.addField(moTextNumberExt);
        moFields.addField(moTextNumberInt);
        moFields.addField(moTextNeighborhood);
        moFields.addField(moTextReference);
        moFields.addField(moTextLocality);
        moFields.addField(moKeyState);
        moFields.addField(moKeyCountry);
        moFields.addField(moTextZipCode);
        
        moFields.setFormButton(jbSave);
        
        jbReloadZipComplements.addActionListener(this);
        jbReloadZipComplements.setEnabled(true);
    }

    @Override
    public void addAllListeners() {
        moTextZipCode.addFocusListener(this);
    }

    @Override
    public void removeAllListeners() {
        moTextZipCode.removeFocusListener(this);
    }

    @Override
    public void reloadCatalogues() {
        miClient.getSession().populateCatalogue(moKeyPersonTp, SModConsts.LOGS_TP_BOL_PERSON, SLibConsts.UNDEFINED, null);        
        miClient.getSession().populateCatalogue(moKeyState, SModConsts.LOCU_STA, SLibConsts.UNDEFINED, null);        
        miClient.getSession().populateCatalogue(moKeyCountry, SModConsts.LOCU_CTY, SLibConsts.UNDEFINED, null);        
        
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        moRegistry = (SDbBolPerson) registry;

        mnFormResult = SLibConsts.UNDEFINED;
        mbFirstActivation = true;

        removeAllListeners();
        reloadCatalogues();
        
        if (moRegistry.isRegistryNew()) {
            moRegistry.initPrimaryKey();
            jtfRegistryKey.setText("");
            moKeyCountry.setValue(new int [] { 251 }); // México
        }
        else {
            jtfRegistryKey.setText(SLibUtils.textKey(moRegistry.getPrimaryKey()));
            moKeyCountry.setValue(new int [] { moRegistry.getFkCountryId_n() });
        }
        
        moTextName.setValue(moRegistry.getName());
        moKeyPersonTp.setValue(new int[] { moRegistry.getFkBolPersonTypeId() });
        moTextFiscalId.setValue(moRegistry.getFiscalId());
        moTextFiscalFrgId.setValue(moRegistry.getFiscalForeginId());
        moTextDriverLic.setValue(moRegistry.getDriverLicense());
        moTextTelephone.setValue(moRegistry.getTelephone());
        moTextStreet.setValue(moRegistry.getStreet());
        moTextNumberExt.setValue(moRegistry.getStreetNumberExt());
        moTextNumberInt.setValue(moRegistry.getStreetNumberInt());
        moTextNeighborhood.setValue(moRegistry.getNeighborhood());
        moTextReference.setValue(moRegistry.getReference());
        moTextLocality.setValue(moRegistry.getLocality());
        moKeyState.setValue(new int [] { moRegistry.getFkStateId_n() });
        moTextZipCode.setValue(moRegistry.getZipCode());
        
        setFormEditable(true);
        
        if (moRegistry.isRegistryNew()) { }
        
        addAllListeners();
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        SDbBolPerson registry = moRegistry.clone();
        
        if (registry.isRegistryNew()) {}
        
        registry.setName(moTextName.getValue());
        registry.setFiscalId(moTextFiscalId.getValue());
        registry.setFiscalForeginId(moTextFiscalFrgId.getValue());
        registry.setDriverLicense(moTextDriverLic.getValue());
        registry.setTelephone(moTextTelephone.getValue());
        registry.setStreet(moTextStreet.getValue());
        registry.setStreetNumberExt(moTextNumberExt.getValue());
        registry.setStreetNumberInt(moTextNumberInt.getValue());
        registry.setNeighborhood(moTextNeighborhood.getValue());
        registry.setReference(moTextReference.getValue());
        registry.setLocality(moTextLocality.getValue());
        registry.setState(moKeyState.getSelectedItem().getItem());
        registry.setZipCode(moTextZipCode.getValue());
        registry.setFkBolPersonTypeId(moKeyPersonTp.getValue()[0]);
        registry.setFkCountryId_n(moKeyCountry.getValue()[0]);
        registry.setFkStateId_n(moKeyState.getValue()[0]);
        
        return registry;
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();
        
        if (moTextFiscalId.getValue().isEmpty() && moTextFiscalFrgId.getValue().isEmpty()) {
            validation.setMessage("La figura debe tener un RFC ya sea nacional o extranjero."); 
        }
        if (moKeyPersonTp.getValue()[0] == 1 && moTextDriverLic.getValue().isEmpty()) {
            validation.setMessage("Los choferes deben tener un número de licencia.");
        }
        
        return validation;
    }
    
    private boolean isCountryMex() {
        boolean isMex = false;
        if (moKeyCountry.getSelectedItem().getItem().equals("México")) {
            isMex = true;
        }
        return isMex;
    }

    public void getZipCodeComplements(boolean canFill) {
        try {
            String sql = "SELECT zip.id_sta_code, zip.locality_code, sta.id_sta, loc.description " +
                    "FROM erp.locs_bol_zip_code AS zip  " +
                    "INNER JOIN erp.locu_sta AS sta ON zip.id_sta_code = sta.sta_code " +
                    "LEFT OUTER JOIN erp.locs_bol_locality AS loc ON zip.locality_code = loc.id_locality_code AND zip.id_sta_code = loc.id_sta_code " +
                    "WHERE zip.id_zip_code = " + '"' + moTextZipCode.getValue() + '"' +
                    "AND NOT zip.b_del AND NOT loc.b_del";
            ResultSet resultSet = moClient.getSession().getStatement().executeQuery(sql);
            if (resultSet.next()) {
                if (canFill) {
                    moKeyState.setValue(new int [] { resultSet.getInt("id_sta") });
                    moTextLocality.setValue(resultSet.getString("description"));
                } 
                else {
                   if (moTextLocality.getValue().isEmpty()) {
                       moTextLocality.setValue(resultSet.getString("description"));
                   }
                   if (moKeyState.getValue().length == 0) {
                       moKeyState.setValue(new int [] { resultSet.getInt("id_sta") });
                   }
                }
            }
            else {
                moClient.showMsgBoxWarning("Código postal no encontrado en el sistema");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SFormBolPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (isCountryMex()) {
            getZipCodeComplements(false);           
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();
            if (button == jbReloadZipComplements) {
                if (isCountryMex()) {
                    getZipCodeComplements(true);           
                }
            }
        }
    }
}
