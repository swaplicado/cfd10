/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogFilterRecordType.java
 *
 * Created on 22/09/2009, 04:24:20 PM
 */

package erp.mfin.form;

import erp.data.SDataConstants;
import erp.data.SDataConstantsSys;
import erp.lib.SLibConstants;
import erp.lib.data.SDataRegistry;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Sergio Flores
 */
public class SDialogFilterRecordType extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private erp.client.SClientInterface miClient;
    private int mnFormResult;
    private boolean mbFirstTime;

    /** Creates new form SDialogFilterRecordType */
    public SDialogFilterRecordType(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient =  client;
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

        jpOptions = new javax.swing.JPanel();
        jlOptions = new javax.swing.JLabel();
        jspOptions = new javax.swing.JScrollPane();
        jltOptions = new javax.swing.JList<SFormComponentItem>();
        jpControls = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección de tipo de póliza contable");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro:"));
        jpOptions.setLayout(new java.awt.BorderLayout());

        jlOptions.setText("Seleccionar una opción:");
        jlOptions.setPreferredSize(new java.awt.Dimension(100, 23));
        jpOptions.add(jlOptions, java.awt.BorderLayout.PAGE_START);

        jltOptions.setToolTipText(SDataConstantsSys.TXT_DOUBLE_CLICK);
        jltOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jltOptionsMouseClicked(evt);
            }
        });
        jspOptions.setViewportView(jltOptions);

        jpOptions.add(jspOptions, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpOptions, java.awt.BorderLayout.CENTER);

        jpControls.setPreferredSize(new java.awt.Dimension(392, 33));
        jpControls.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jpControls.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jpControls.add(jbCancel);

        getContentPane().add(jpControls, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-488)/2, (screenSize.height-334)/2, 488, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jltOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jltOptionsMouseClicked
        if (evt.getClickCount() == 2) {
            actionOk();
        }
    }//GEN-LAST:event_jltOptionsMouseClicked

    private void initComponentsExtra() {
        jbOk.addActionListener(this);
        jbCancel.addActionListener(this);

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
            jltOptions.requestFocus();
        }
    }

    private void actionOk() {
        if (jltOptions.getSelectedIndex() == -1) {
            miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_FIELD_EMPTY + "'" + jlOptions.getText() + "'");
            jltOptions.requestFocus();
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

    public void publicActionOk() {
        actionOk();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlOptions;
    private javax.swing.JList<SFormComponentItem> jltOptions;
    private javax.swing.JPanel jpControls;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JScrollPane jspOptions;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formClearRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;
        jltOptions.setSelectedIndex(0);
        if (jspOptions.getVerticalScrollBar() != null) {
            jspOptions.getVerticalScrollBar().setValue(0);
        }
    }

    @Override
    public void setFormVisible(boolean visible) {
        setVisible(visible);
    }

    @Override
    public int getFormResult() {
        return mnFormResult;
    }

    @Override
    public void formRefreshCatalogues() {
        Vector<SFormComponentItem> items = new Vector<SFormComponentItem>();

        SFormUtilities.populateList(miClient, jltOptions, SDataConstants.FINU_TP_REC);

        items.add(new SFormComponentItem(new Object[] { "" }, "(TODOS)"));
        for (int i = 0; i < jltOptions.getModel().getSize(); i++) {
            items.add((SFormComponentItem) jltOptions.getModel().getElementAt(i));
        }

        jltOptions.setListData(items);
        jltOptions.setSelectedIndex(0);
    }

    @Override
    public SFormValidation formValidate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setFormStatus(int status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getFormStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRegistry(SDataRegistry registry) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SDataRegistry getRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValue(int type, Object value) {
        switch (type) {
            case SDataConstants.FINU_TP_REC:
                SFormUtilities.locateListItem(jltOptions, value);
                break;
            default:
        }
    }

    @Override
    public Object getValue(int value) {
        Object pk = null;

        switch (value) {
            case SDataConstants.FINU_TP_REC:
                if (jltOptions.getSelectedIndex() != 0) {
                    pk = ((SFormComponentItem) jltOptions.getSelectedValue()).getPrimaryKey();
                }
                break;
            default:
        }

        return pk;
    }

    @Override
    public JLabel getTimeoutLabel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbOk) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
        }
    }
}
