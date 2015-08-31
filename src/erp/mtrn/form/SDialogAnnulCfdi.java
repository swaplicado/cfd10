package erp.mtrn.form;

import erp.data.SDataUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import sa.lib.gui.SGuiConsts;

/**
 *
 * @author Juan Barajas
 */
public class SDialogAnnulCfdi extends javax.swing.JDialog implements erp.lib.form.SFormInterface, java.awt.event.ActionListener {

    private int mnFormType;
    private int mnFormResult;
    private int mnFormStatus;
    private boolean mbFirstTime;
    private boolean mbResetingForm;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;
    private erp.client.SClientInterface miClient;

    private erp.lib.form.SFormField moFieldDate;
    private erp.lib.form.SFormField moFieldAnnulSat;
    
    private Date mtDateDps;
    private boolean mbAnnulSatEnable;

    /** Creates new form SDialogAnnulCfdi */
    public SDialogAnnulCfdi(erp.client.SClientInterface client, boolean annulSatEnable) {
        super(client.getFrame(), true);
        miClient = client;
        mbAnnulSatEnable = annulSatEnable;

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
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        jtfDateStart = new javax.swing.JFormattedTextField();
        jlDummy = new javax.swing.JLabel();
        jbDate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jckAnnulSat = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fecha anulación"); // NOI18N
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpData.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setLayout(new java.awt.GridLayout(2, 1, 0, 1));

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setLayout(new java.awt.FlowLayout(0, 0, 0));

        jlDateStart.setText("Fecha: *");
        jlDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel4.add(jlDateStart);

        jtfDateStart.setText("dd/mm/yyyy");
        jtfDateStart.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel4.add(jtfDateStart);

        jlDummy.setPreferredSize(new java.awt.Dimension(1, 23));
        jPanel4.add(jlDummy);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setFocusable(false);
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel4.add(jbDate);

        jPanel1.add(jPanel4);

        jPanel3.setLayout(new java.awt.FlowLayout(3));

        jckAnnulSat.setSelected(true);
        jckAnnulSat.setText("Cancelar ante el SAT");
        jckAnnulSat.setFocusable(false);
        jckAnnulSat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel3.add(jckAnnulSat);

        jPanel1.add(jPanel3);

        jPanel8.add(jPanel1);

        jpData.add(jPanel8, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpData, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(2));

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
        setBounds((screenSize.width-336)/2, (screenSize.height-238)/2, 336, 238);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void initComponentsExtra() {
        mvFields = new Vector<SFormField>();

        moFieldDate = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jtfDateStart, jlDateStart);
        moFieldDate.setPickerButton(jbDate);
        moFieldAnnulSat = new erp.lib.form.SFormField(miClient, SLibConstants.DATA_TYPE_BOOLEAN, false, jckAnnulSat, jckAnnulSat);

        mvFields.add(moFieldDate);
        mvFields.add(moFieldAnnulSat);

        jbCancel.addActionListener(this);
        jbOk.addActionListener(this);
        jbDate.addActionListener(this);

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
            jtfDateStart.requestFocus();
        }
    }

    private void actionDate() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDate.getDate(), moFieldDate);
    }

    private void actionEdit(boolean edit) {

    }

    private void actionOk() {
        SFormValidation validation = formValidate();
        boolean ban = true;

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (validation.getMessage().length() > 0) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
        else {
            if (!SDataUtilities.isPeriodOpen(miClient, moFieldDate.getDate())) {
                miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_PER_CLOSE);
            }
            else if (moFieldDate.getDate().before(SLibTimeUtilities.convertToDateOnly(mtDateDps))) {
                miClient.showMsgBoxWarning("La fecha no puede ser anterior a la fecha del documento.");
                jtfDateStart.requestFocus();
            }
            else {
                if (SLibTimeUtilities.digestYear(mtDateDps)[0] != SLibTimeUtilities.digestYear(moFieldDate.getDate())[0]) {
                    miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_GUI_PER_YEAR);
                    ban = false;
                }
                else if (!SLibTimeUtilities.isBelongingToPeriod(mtDateDps, SLibTimeUtilities.digestYear(moFieldDate.getDate())[0], SLibTimeUtilities.digestYearMonth(moFieldDate.getDate())[1])) {
                    ban = miClient.showMsgBoxConfirm("La fecha no pertenece al periodo de creación del documento.\n" + SGuiConsts.MSG_CNF_CONT) == JOptionPane.YES_OPTION;
                }
            
                if (ban) {
                    mnFormResult = SLibConstants.FORM_RESULT_OK;
                    setVisible(false);
                }
                else {
                    jtfDateStart.requestFocus();
                }
            }
        }
    }

    private void actionCancel() {
        mnFormResult = SLibConstants.FORM_RESULT_CANCEL;
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgCurrency;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbOk;
    private javax.swing.JCheckBox jckAnnulSat;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JPanel jpData;
    private javax.swing.JFormattedTextField jtfDateStart;
    // End of variables declaration//GEN-END:variables

    public Date getDate() {
        return moFieldDate.getDate();
    }
    
    public boolean getAnnulSat() {
        return moFieldAnnulSat.getBoolean();
    }
    
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
        jckAnnulSat.setSelected(true);
        jckAnnulSat.setEnabled(mbAnnulSatEnable);
        mtDateDps = null;
    }

    @Override
    public void formRefreshCatalogues() {
        
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
        
        if (!validation.getIsError()) {
            if (!jckAnnulSat.isSelected()) {
                miClient.showMsgBoxWarning("El sistema no anulará el CFDI ante el SAT, debe hacerlo manualmente en el portal del mismo.");
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public erp.lib.data.SDataRegistry getRegistry() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValue(int type, java.lang.Object value) {
        switch (type) {
            case SGuiConsts.PARAM_DATE:
                mtDateDps = (Date) value;
                break;
            default:
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
            else if (button == jbDate) {
                actionDate();
            }
        }
    }

}
