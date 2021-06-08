/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * STabFilterFunctionalArea.java
 */

package erp.table;

import erp.lib.SLibConstants;
import erp.mtrn.form.SDialogFilterFunctionalArea;
import erp.mtrn.utils.STrnFunAreasUtils;

/**
 *
 * @author Juan Barajas, Edwin Carmona
 */
public class STabFilterFunctionalArea extends javax.swing.JPanel {

    private erp.client.SClientInterface miClient;
    private erp.lib.table.STableTab moTab;
    private erp.lib.table.STableSetting moSetting;
    private erp.mtrn.form.SDialogFilterFunctionalArea moDialogFilterFunctionalArea;

    private int mnDataType;
    private int[] manDataFilter;
    private int mnFunctionalAreaId;
    private String msFunctionalAreasIds;

    /** Creates new form STabFilterFunctionalArea */
    public STabFilterFunctionalArea(erp.client.SClientInterface client, erp.lib.table.STableTab tableTab, int dataType) {
        this(client, tableTab, dataType, null);
    }

    /** Creates new form STabFilterFunctionalArea */
    public STabFilterFunctionalArea(erp.client.SClientInterface client, erp.lib.table.STableTab tableTab, int dataType, int[] dataFilter) {
        miClient = client;
        moTab = tableTab;
        mnDataType = dataType;
        manDataFilter = dataFilter;

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

        jtfFunctionalArea = new javax.swing.JTextField();
        jbFunctionalArea = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jtfFunctionalArea.setEditable(false);
        jtfFunctionalArea.setText("CODE");
        jtfFunctionalArea.setToolTipText("Área funcional de documento");
        jtfFunctionalArea.setPreferredSize(new java.awt.Dimension(65, 23));
        add(jtfFunctionalArea);
        jtfFunctionalArea.getAccessibleContext().setAccessibleDescription("Área funcional");

        jbFunctionalArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_filter_doc.gif"))); // NOI18N
        jbFunctionalArea.setToolTipText("Seleccionar área funcional");
        jbFunctionalArea.setPreferredSize(new java.awt.Dimension(23, 23));
        jbFunctionalArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFunctionalAreaActionPerformed(evt);
            }
        });
        add(jbFunctionalArea);
        jbFunctionalArea.getAccessibleContext().setAccessibleDescription("Área funcional");
    }// </editor-fold>//GEN-END:initComponents

    private void jbFunctionalAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFunctionalAreaActionPerformed
        actionFunctionalArea();
    }//GEN-LAST:event_jbFunctionalAreaActionPerformed

    private void initComponentsExtra() {
        mnFunctionalAreaId = SLibConstants.UNDEFINED;
        moDialogFilterFunctionalArea = new SDialogFilterFunctionalArea(miClient, mnDataType, manDataFilter);
        renderText();
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
        
        moSetting.setSetting(msFunctionalAreasIds);
        moTab.updateSetting(moSetting);
    }

    private void renderText() {
        String texts[] = STrnFunAreasUtils.getFunAreasTextFilter(miClient, mnFunctionalAreaId);
        msFunctionalAreasIds = texts[0];
        
        jtfFunctionalArea.setText(texts[1]);
        jtfFunctionalArea.setCaretPosition(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbFunctionalArea;
    private javax.swing.JTextField jtfFunctionalArea;
    // End of variables declaration//GEN-END:variables

    public void setDataFilter(final int[] filter) {
        manDataFilter = filter;
        moDialogFilterFunctionalArea.setDataFilterKey(manDataFilter);
    }
}
