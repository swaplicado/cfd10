/*
 * DFormCompany.java
 *
 * Created on 19 de agosto de 2008, 11:10 AM
 */

package erp.mtrn.form;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JLabel;

import erp.data.SDataConstants;
import erp.lib.form.SFormField;
import erp.lib.form.SFormValidation;
import erp.lib.form.SFormUtilities;
import erp.lib.SLibConstants;
import erp.mtrn.data.SDataDsmEntryNotes;

/**
 *
 * @author  Néstor Ávalos
 */
public class SFormDsmEntryNotes extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.mtrn.data.SDataDsmEntryNotes moNotes;
    private erp.lib.form.SFormField moFieldNotes;
    private erp.lib.form.SFormField moFieldIsPrintable;
    private erp.lib.form.SFormField moFieldIsDeleted;

    /** Creates new form DFormCompany */
    public SFormDsmEntryNotes(erp.client.SClientInterface client) {
        super(client.getFrame(), true);
        miClient = client;
        mnFormType = SDataConstants.TRN_DSM_ETY_NTS;

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

        jpData = new javax.swing.JPanel();
        jpNotes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaNotes = new javax.swing.JTextArea();
        jlNotes = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jckIsPrintable = new javax.swing.JCheckBox();
        jckIsDeleted = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jbOK = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notas del documento"); // NOI18N
        setModal(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpData.setLayout(new java.awt.BorderLayout());

        jpNotes.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jpNotes.setLayout(new java.awt.BorderLayout());

        jtaNotes.setColumns(20);
        jtaNotes.setRows(5);
        jScrollPane1.setViewportView(jtaNotes);

        jpNotes.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jlNotes.setText("Notas: *");
        jlNotes.setPreferredSize(new java.awt.Dimension(32, 23));
        jlNotes.setRequestFocusEnabled(false);
        jpNotes.add(jlNotes, java.awt.BorderLayout.PAGE_START);

        jpData.add(jpNotes, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jckIsPrintable.setText("Notas para impresión");
        jckIsPrintable.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel1.add(jckIsPrintable);

        jckIsDeleted.setText("Registro eliminado");
        jckIsDeleted.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel1.add(jckIsDeleted);

        jpData.add(jPanel1, java.awt.BorderLayout.SOUTH);

        getContentPane().add(jpData, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOK.setText("Aceptar"); // NOI18N
        jbOK.setToolTipText("[Ctrl + Enter]");
        jbOK.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel2.add(jbOK);

        jbCancel.setText("Cancelar"); // NOI18N
        jbCancel.setToolTipText("[Escape]");
        jPanel2.add(jbCancel);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-608)/2, (screenSize.height-334)/2, 608, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        if (mbFirstTime) {
            mbFirstTime = false;
            jtaNotes.requestFocus();
        }
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldNotes = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_STRING, true, jtaNotes, jlNotes);
        moFieldNotes.setLengthMax(255);
        moFieldIsPrintable = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsPrintable);
        moFieldIsDeleted = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckIsDeleted);

        mvFields.add(moFieldNotes);
        mvFields.add(moFieldIsPrintable);
        mvFields.add(moFieldIsDeleted);

        jbOK.addActionListener(this);
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

    private void actionEdit(boolean edit) {

    }

    private void actionOk() {
        erp.lib.form.SFormValidation validation = formValidate();

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
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOK;
    private javax.swing.JCheckBox jckIsDeleted;
    private javax.swing.JCheckBox jckIsPrintable;
    private javax.swing.JLabel jlNotes;
    private javax.swing.JPanel jpData;
    private javax.swing.JPanel jpNotes;
    private javax.swing.JTextArea jtaNotes;
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

        moNotes = null;

        for (int i = 0; i < mvFields.size(); i++) {
            ((erp.lib.form.SFormField) mvFields.get(i)).resetField();
        }

        jckIsDeleted.setEnabled(false);
    }

    @Override
    public void formRefreshCatalogues() {

    }

    @Override
    public erp.lib.form.SFormValidation formValidate() {
        erp.lib.form.SFormValidation validation = new SFormValidation();

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
        moNotes = (SDataDsmEntryNotes) registry;

        moFieldNotes.setFieldValue(moNotes.getNotes());
        moFieldIsPrintable.setBoolean(moNotes.getIsPrintable());
        moFieldIsDeleted.setBoolean(moNotes.getIsDeleted());

        jckIsDeleted.setEnabled(true);
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        if (moNotes == null) {
            moNotes = new SDataDsmEntryNotes();

            moNotes.setFkUserNewId(miClient.getSession().getUser().getPkUserId());
            moNotes.setDbmsUserNew(miClient.getSessionXXX().getUser().getUser());
            moNotes.setDbmsUserEdit("(n/a)");
            moNotes.setDbmsUserDelete("(n/a)");
            moNotes.setUserNewTs(miClient.getSessionXXX().getSystemDate());
            moNotes.setUserEditTs(miClient.getSessionXXX().getSystemDate());
            moNotes.setUserDeleteTs(miClient.getSessionXXX().getSystemDate());
        } else {
            moNotes.setDbmsUserEdit(miClient.getSessionXXX().getUser().getUser());
            moNotes.setFkUserEditId(miClient.getSession().getUser().getPkUserId());
            moNotes.setUserEditTs(miClient.getSessionXXX().getSystemDate());

            if (moFieldIsDeleted.getBoolean()) {
                moNotes.setFkUserDeleteId(miClient.getSession().getUser().getPkUserId());
                moNotes.setDbmsUserDelete(miClient.getSessionXXX().getUser().getUser());
                moNotes.setUserDeleteTs(miClient.getSessionXXX().getWorkingDate());
            }
        }

        moNotes.setNotes(moFieldNotes.getString());
        moNotes.setIsPrintable(moFieldIsPrintable.getBoolean());
        moNotes.setIsDeleted(moFieldIsDeleted.getBoolean());

        return moNotes;
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

            if (button == jbOK) {
                actionOk();
            }
            else if (button == jbCancel) {
                actionCancel();
            }
        }
    }
}
