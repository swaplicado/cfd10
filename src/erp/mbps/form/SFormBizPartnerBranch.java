/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormBizPartnerBranch.java
 *
 * Created on 28/09/2009, 02:56:31 PM
 */

package erp.mbps.form;

import erp.data.SDataConstants;
import erp.lib.SLibConstants;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Alfonso Flores, Sergio Flores
 */
public class SFormBizPartnerBranch extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mbps.form.SPanelBizPartnerBranch moPanelBizPartnerBranch;
    private erp.lib.table.STablePane moBizPartnerBranchPane;

    private java.lang.String msParamBizPartnerDescription;

    /** Creates new form SFormBizPartnerBranch */
    public SFormBizPartnerBranch(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
        mnFormType = SDataConstants.BPSU_BPB;

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

        jpBizPartnerBranch = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sucursal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpBizPartnerBranch.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jpBizPartnerBranch, java.awt.BorderLayout.CENTER);

        jPanel.setPreferredSize(new java.awt.Dimension(792, 33));
        jPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel.add(jbCancel);

        getContentPane().add(jPanel, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-976)/2, (screenSize.height-638)/2, 976, 638);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        int i;

        erp.lib.table.STableColumnForm tableColumnsBizPartnerBranch[];

        moPanelBizPartnerBranch = new SPanelBizPartnerBranch(miClient);
        moBizPartnerBranchPane = new STablePane(miClient);
        jpBizPartnerBranch.add(moPanelBizPartnerBranch, BorderLayout.CENTER);

        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

        i = 0;
        tableColumnsBizPartnerBranch = new STableColumnForm[11];
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Sucursal", 100);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo de sucursal", 100);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Localidad", 100);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Región de impuestos", 100);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_BOOLEAN, "Eliminado", STableConstants.WIDTH_BOOLEAN);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. creación", STableConstants.WIDTH_USER);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Creación", STableConstants.WIDTH_DATE_TIME);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. modificación", STableConstants.WIDTH_USER);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Modificación", STableConstants.WIDTH_DATE_TIME);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Usr. eliminación", STableConstants.WIDTH_USER);
        tableColumnsBizPartnerBranch[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE_TIME, "Eliminación", STableConstants.WIDTH_DATE_TIME);

        for (i = 0; i < tableColumnsBizPartnerBranch.length; i++) {
            moBizPartnerBranchPane.addTableColumn(tableColumnsBizPartnerBranch[i]);
        }

        moBizPartnerBranchPane.createTable(null);

        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);

        AbstractAction action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), action, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void windowActivated() {
        if (mbFirstTime) {
            mbFirstTime = false;
            moPanelBizPartnerBranch.requestFocusFirstTime();
        }
    }

    private void actionOk() {
        SFormValidation validationBranch = formValidate();

        if (validationBranch.getIsError()) {
            if (validationBranch.getComponent() != null) {
                validationBranch.getComponent().requestFocus();
            }
            if (validationBranch.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validationBranch.getMessage());
            }
        }
        else {
            mnFormResult = SLibConstants.FORM_RESULT_OK;
            setVisible(false);
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JPanel jpBizPartnerBranch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mbFirstTime = true;
        mbResetingForm = false;
        moPanelBizPartnerBranch.formReset();
        moPanelBizPartnerBranch.setParamBizPartnerDescription(msParamBizPartnerDescription);
    }

    @Override
    public void formRefreshCatalogues() {
        moPanelBizPartnerBranch.formRefreshCatalogues();
    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        return moPanelBizPartnerBranch.formValidate();
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
        moPanelBizPartnerBranch.setRegistry(registry);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        return moPanelBizPartnerBranch.getRegistry();
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

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
        }
    }

    public void setParamBizPartnerDescription(java.lang.String s) { msParamBizPartnerDescription = s; }
}
