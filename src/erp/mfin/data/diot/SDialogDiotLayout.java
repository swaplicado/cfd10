/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SDialogDiotLayout.java
 *
 * Created on 29/06/2010, 05:02:26 PM
 */

package erp.mfin.data.diot;

import erp.gui.SGuiUtilities;
import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormField;
import erp.lib.form.SFormUtilities;
import erp.lib.form.SFormValidation;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Flores, Isabel Servín
 */
public class SDialogDiotLayout extends javax.swing.JDialog implements java.awt.event.ActionListener {

    private final erp.client.SClientInterface miClient;
    private erp.lib.form.SFormField moFieldDateStart;
    private erp.lib.form.SFormField moFieldDateEnd;
    private java.util.Vector<erp.lib.form.SFormField> mvFields;

    /** Creates new form SDialogDiotLayout
     * @param client GUI client.
     */
    public SDialogDiotLayout(erp.client.SClientInterface client) {
        super(client.getFrame(), false);
        miClient = client;
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

        bgFormat = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlDateStart = new javax.swing.JLabel();
        jftDateStart = new javax.swing.JFormattedTextField();
        jbPickDateStart = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jlDateEnd = new javax.swing.JLabel();
        jftDateEnd = new javax.swing.JFormattedTextField();
        jbPickDateEnd = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jckExcludeTotallyZero = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jrbFormatCsv = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jrbFormatPipe = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jbSave = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Layout DIOT");
        setResizable(false);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del layout DIOT:"));
        jPanel6.setLayout(new java.awt.GridLayout(6, 1, 0, 5));

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateStart.setText("Fecha inicial: *");
        jlDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel3.add(jlDateStart);

        jftDateStart.setText("dd/mm/yyyy");
        jftDateStart.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel3.add(jftDateStart);

        jbPickDateStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbPickDateStart.setToolTipText("Seleccionar fecha");
        jbPickDateStart.setFocusable(false);
        jbPickDateStart.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel3.add(jbPickDateStart);

        jPanel6.add(jPanel3);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlDateEnd.setText("Fecha final: *");
        jlDateEnd.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel8.add(jlDateEnd);

        jftDateEnd.setText("dd/mm/yyyy");
        jftDateEnd.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel8.add(jftDateEnd);

        jbPickDateEnd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbPickDateEnd.setToolTipText("Seleccionar fecha");
        jbPickDateEnd.setFocusable(false);
        jbPickDateEnd.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel8.add(jbPickDateEnd);

        jPanel6.add(jPanel8);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jckExcludeTotallyZero.setText("Excluir terceros totalmente en cero");
        jckExcludeTotallyZero.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel15.add(jckExcludeTotallyZero);

        jPanel6.add(jPanel15);

        jLabel1.setText("Formato del archivo:");
        jPanel6.add(jLabel1);

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        bgFormat.add(jrbFormatCsv);
        jrbFormatCsv.setText("Valores sin redondear, separados por coma (CSV), incluye resumen informativo y lista de excepciones");
        jrbFormatCsv.setPreferredSize(new java.awt.Dimension(600, 23));
        jPanel14.add(jrbFormatCsv);

        jPanel6.add(jPanel14);

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        bgFormat.add(jrbFormatPipe);
        jrbFormatPipe.setText("Valores redondeados, separados por barra vertical, el caracter \"pipe\" |");
        jrbFormatPipe.setPreferredSize(new java.awt.Dimension(600, 23));
        jPanel13.add(jrbFormatPipe);

        jPanel6.add(jPanel13);

        jPanel2.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("ADVERTENCIAS:"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(java.awt.SystemColor.control);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("1) Los importes de pagos realizados a operaciones de IVA tasa 0 o exento que en su momento fueron provisionadas equivocadamente a otras tasas de IVA, p. ej., a tasa general, pero deliberadamente manipuladas para que el monto del IVA fuera igual a cero, serán por defecto clasificados como operaciones de IVA tasa 0 en el archivo del layout DIOT.\n\n2) Los importes de pagos realizados a operaciones de IVA tasa 0 o exento que en su momento fueron provisionadas simultáneamente en el mismo asiento contable con operaciones a otras tasas de IVA, p. ej., a tasa general, serán por defecto clasificados como operaciones de IVA exento en el archivo del layout DIOT.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbSave.setText("Generar");
        jbSave.setToolTipText("[Ctrl + Enter]");
        jbSave.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel1.add(jbSave);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(656, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initComponentsExtra() {
        moFieldDateStart = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateStart, jlDateStart);
        moFieldDateStart.setPickerButton(jbPickDateStart);
        moFieldDateEnd = new SFormField(miClient, SLibConstants.DATA_TYPE_DATE, true, jftDateEnd, jlDateEnd);
        moFieldDateEnd.setPickerButton(jbPickDateEnd);

        mvFields = new Vector<>();
        mvFields.add(moFieldDateStart);
        mvFields.add(moFieldDateEnd);

        jbPickDateStart.addActionListener(this);
        jbPickDateEnd.addActionListener(this);
        jbSave.addActionListener(this);
        jbCancel.addActionListener(this);

        moFieldDateStart.setFieldValue(SLibTimeUtilities.getBeginOfMonth(miClient.getSessionXXX().getWorkingDate()));
        moFieldDateEnd.setFieldValue(SLibTimeUtilities.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()));
        jckExcludeTotallyZero.setSelected(true);
        jrbFormatCsv.setSelected(true);
                
        SFormUtilities.createActionMap(rootPane, this, "actionPerformedPrint", "print", KeyEvent.VK_ENTER, KeyEvent.CTRL_DOWN_MASK);
        SFormUtilities.createActionMap(rootPane, this, "actionPerformedCancel", "cancel", KeyEvent.VK_ESCAPE, 0);
    }
    
    private void computeLayout() {
        Cursor cursor = getCursor();
        
        try {
            setCursor(new Cursor(Cursor.WAIT_CURSOR));
            
            String layout = new SDiotLayout(miClient, 
                    moFieldDateStart.getDate(), 
                    moFieldDateEnd.getDate()).getLayout(jrbFormatPipe.isSelected() ? SDiotLayout.FORMAT_PIPE : SDiotLayout.FORMAT_CSV,
                    jckExcludeTotallyZero.isSelected());
            
            String fileExt = jrbFormatPipe.isSelected() ? ".txt" : ".csv";
            SimpleDateFormat periodFormat = new SimpleDateFormat("yyyy-MM");

            miClient.getFileChooser().setSelectedFile(
                    new File("DIOT " +
                            miClient.getSessionXXX().getCompany().getDbmsDataCompany().getFiscalId() + " " +
                            periodFormat.format(moFieldDateEnd.getDate()) + " " +
                            SLibUtils.FileDateFormatDatetime.format(new Date()) +
                            fileExt));

            if (miClient.getFileChooser().showSaveDialog(miClient.getFrame()) == JFileChooser.APPROVE_OPTION) {
                String fileName = miClient.getFileChooser().getSelectedFile().getAbsolutePath();

                File file = new File(fileName.endsWith(fileExt) ? fileName : fileName + fileExt);

                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "ASCII"))) {
                    bw.write(layout);
                }
                
                if (miClient.showMsgBoxConfirm(SLibConstants.MSG_INF_FILE_CREATE + file.getPath() + "\n" + SLibConstants.MSG_CNF_FILE_OPEN) == JOptionPane.YES_OPTION) {
                    SLibUtilities.launchFile(file.getPath());
                }
            }
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }
        finally {
            setCursor(cursor);
        }
    }

    private void actionPerformedDateBegin() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateStart.getDate(), moFieldDateStart);
    }

    private void actionPerformedDateEnd() {
        miClient.getGuiDatePickerXXX().pickDate(moFieldDateEnd.getDate(), moFieldDateEnd);
    }

    public void actionPerformedSave() {
        SFormValidation validation = validateDialog();

        if (validation.getIsError()) {
            if (validation.getComponent() != null) {
                validation.getComponent().requestFocus();
            }
            if (!validation.getMessage().isEmpty()) {
                miClient.showMsgBoxWarning(validation.getMessage());
            }
        }
        else {
            computeLayout();
            setVisible(false);
        }
    }

    public void actionPerformedCancel() {
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFormat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbPickDateEnd;
    private javax.swing.JButton jbPickDateStart;
    private javax.swing.JButton jbSave;
    private javax.swing.JCheckBox jckExcludeTotallyZero;
    private javax.swing.JFormattedTextField jftDateEnd;
    private javax.swing.JFormattedTextField jftDateStart;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JRadioButton jrbFormatCsv;
    private javax.swing.JRadioButton jrbFormatPipe;
    // End of variables declaration//GEN-END:variables


    public SFormValidation validateDialog() {
        SFormValidation validation = new SFormValidation();
        
        for (SFormField field : mvFields) {
            if (!field.validateField()) {
                validation.setIsError(true);
                validation.setComponent(field.getComponent());
                break;
            }
        }

        if (!validation.getIsError()) {
            String message = SGuiUtilities.validateDateRange(moFieldDateStart.getDate(), moFieldDateEnd.getDate());
            
            if (!message.isEmpty()) {
                validation.setMessage(message);
                validation.setComponent(jftDateEnd);
            }
        }
        
        return validation;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbPickDateStart) {
                actionPerformedDateBegin();
            }
            else if (button == jbPickDateEnd) {
                actionPerformedDateEnd();
            }
            else if (button == jbSave) {
                actionPerformedSave();
            }
            else if (button == jbCancel) {
                actionPerformedCancel();
            }
        }
    }
}