/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * STabFilterBizPartner.java
 *
 * Created on 5/02/2010, 06:36:11 PM
 */

package erp.table;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.table.*;
import erp.mbps.data.SDataBizPartner;
import erp.mbps.form.SDialogFilterBizPartner;

/**
 *
 * @author Alfonso Flores, Sergio Flores
 */
public class STabFilterBizPartner extends javax.swing.JPanel {

    private erp.client.SClientInterface miClient;
    private erp.lib.table.STableTab moTab;
    private int mnBizPartnerCategoryId;
    private int mnBizPartnerId;
    private java.lang.String msCategory;
    private erp.lib.table.STableSetting moSetting;
    private erp.mbps.form.SDialogFilterBizPartner moDialogFilterBizPartner;

    /** Creates new form STabFilterBizPartner */
    public STabFilterBizPartner(erp.client.SClientInterface client, erp.lib.table.STableTab tableTab, int bprCategory) {
        miClient = client;
        moTab = tableTab;
        mnBizPartnerCategoryId = bprCategory;

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

        jtfBizPartner = new javax.swing.JTextField();
        jbBizPartner = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jtfBizPartner.setEditable(false);
        jtfBizPartner.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jtfBizPartner.setText("NAME");
        jtfBizPartner.setToolTipText("Asociado de negocios");
        jtfBizPartner.setFocusable(false);
        jtfBizPartner.setPreferredSize(new java.awt.Dimension(150, 23));
        add(jtfBizPartner);

        jbBizPartner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_filter_bp.gif"))); // NOI18N
        jbBizPartner.setToolTipText("Seleccionar asociado de negocios");
        jbBizPartner.setPreferredSize(new java.awt.Dimension(23, 23));
        jbBizPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBizPartnerActionPerformed(evt);
            }
        });
        add(jbBizPartner);
    }// </editor-fold>//GEN-END:initComponents

    private void jbBizPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBizPartnerActionPerformed
        actionBizPartner();
    }//GEN-LAST:event_jbBizPartnerActionPerformed

    private void initComponentsExtra() {
        mnBizPartnerId = SLibConstants.UNDEFINED;
        moSetting = new STableSetting(SFilterConstants.SETTING_FILTER_BP, mnBizPartnerId);
        moDialogFilterBizPartner = new SDialogFilterBizPartner(miClient, mnBizPartnerCategoryId);

        switch (mnBizPartnerCategoryId) {
            case SDataConstants.BPSU_BP:
                msCategory = "Asociado de negocios";
                break;
            case SDataConstantsSys.BPSS_CT_BP_CO:
                msCategory = "Empresa";
                break;
            case SDataConstantsSys.BPSS_CT_BP_CUS:
                msCategory = "Cliente";
                break;
            case SDataConstantsSys.BPSS_CT_BP_SUP:
                msCategory = "Proveedor";
                break;
            case SDataConstantsSys.BPSS_CT_BP_DBR:
                msCategory = "Deudor diverso";
                break;
            case SDataConstantsSys.BPSS_CT_BP_CDR:
                msCategory = "Acreedor diverso";
                break;
            case SDataConstants.BPSX_BP_EMP:
                msCategory = "Empleado";
                break;
            default:
                msCategory = "";
                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
        }

        jbBizPartner.setToolTipText("Seleccionar " + msCategory.toLowerCase());
        
        renderText();
    }

    private void actionBizPartner() {
        moDialogFilterBizPartner.formRefreshCatalogues();
        moDialogFilterBizPartner.formReset();
        moDialogFilterBizPartner.setBizPartnerId(mnBizPartnerId);
        moDialogFilterBizPartner.setFormVisible(true);

        if (moDialogFilterBizPartner.getFormResult() == erp.lib.SLibConstants.FORM_RESULT_OK) {
            mnBizPartnerId = moDialogFilterBizPartner.getBizPartnerId();
            moSetting.setSetting(mnBizPartnerId);
            moTab.updateSetting(moSetting);
            renderText();
        }
    }

    private void renderText() {
        SDataBizPartner bizPartner = new SDataBizPartner();

        if (mnBizPartnerId > SLibConstants.UNDEFINED) {
            bizPartner = (SDataBizPartner) SDataUtilities.readRegistry(miClient, SDataConstants.BPSU_BP, new int[] { mnBizPartnerId }, SLibConstants.EXEC_MODE_SILENT);

            jtfBizPartner.setText(bizPartner.getBizPartner());
        }
        else {
            jtfBizPartner.setText(SLibConstants.TXT_ALL);
        }

        jtfBizPartner.setToolTipText(msCategory + ": " + jtfBizPartner.getText());
        jtfBizPartner.setCaretPosition(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbBizPartner;
    private javax.swing.JTextField jtfBizPartner;
    // End of variables declaration//GEN-END:variables
}
