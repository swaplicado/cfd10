/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.cfd.utils;

import erp.cfd.SCfdConsts;
import erp.client.SClientInterface;
import erp.mod.SModConsts;
import erp.mod.hrs.utils.SReceiptsR;
import erp.mtrn.data.SCfdUtils;
import erp.mtrn.data.SDataCfd;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import sa.lib.SLibConsts;
import sa.lib.db.SDbRegistry;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanFormDialog;

/**
 * Verificación masiva de CFDI de nóminas.
 * @author Edwin Carmona, Sergio Flores
 */
public class SDialogVerifyCfdis extends SBeanFormDialog implements java.awt.event.ActionListener {
    
    private static final String COMMA_DELIMITER = ",";
    private static final int UUID = 0;
    
    protected String msCsvPath;
    protected String msCsvGenPath;
   
    /**
     * Creates new form SDialogVacationsFileCsv
     * @param client
     * @param title
     */
    public SDialogVerifyCfdis(SGuiClient client, String title) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT,  SModConsts.HRSR_VAC_CSV, SLibConsts.UNDEFINED, title);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jlFileGen = new javax.swing.JLabel();
        jtfFileGenPath = new javax.swing.JTextField();
        jbSelectFileGen = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jlGenerate = new javax.swing.JLabel();
        jlGenerate1 = new javax.swing.JLabel();
        jlGenerate2 = new javax.swing.JLabel();
        jBGenerateFile = new javax.swing.JButton();
        jlGenerateFileHelp = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros del reporte:"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(10, 1, 0, 5));

        jPanel14.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlFileGen.setText("Generar archivo:*");
        jlFileGen.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel14.add(jlFileGen);

        jtfFileGenPath.setPreferredSize(new java.awt.Dimension(250, 23));
        jPanel14.add(jtfFileGenPath);

        jbSelectFileGen.setText("jButton1");
        jbSelectFileGen.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel14.add(jbSelectFileGen);

        jPanel2.add(jPanel14);

        jPanel20.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlGenerate.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel20.add(jlGenerate);

        jlGenerate1.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel20.add(jlGenerate1);

        jlGenerate2.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel20.add(jlGenerate2);

        jBGenerateFile.setText("Generar Archivo");
        jBGenerateFile.setPreferredSize(new java.awt.Dimension(120, 23));
        jPanel20.add(jBGenerateFile);

        jlGenerateFileHelp.setForeground(new java.awt.Color(109, 109, 109));
        jlGenerateFileHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlGenerateFileHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_view_help.png"))); // NOI18N
        jlGenerateFileHelp.setToolTipText("Elija el directorio donde se guardará el archivo, después seleccione año y mes de las nóminas para generarlo.");
        jlGenerateFileHelp.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel20.add(jlGenerateFileHelp);

        jPanel2.add(jPanel20);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        jPanel1.getAccessibleContext().setAccessibleName("Parámetros de la generación");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBGenerateFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JButton jbSelectFileGen;
    private javax.swing.JLabel jlFileGen;
    private javax.swing.JLabel jlGenerate;
    private javax.swing.JLabel jlGenerate1;
    private javax.swing.JLabel jlGenerate2;
    private javax.swing.JLabel jlGenerateFileHelp;
    private javax.swing.JTextField jtfFileGenPath;
    // End of variables declaration//GEN-END:variables

    
    private void actionSaveFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            msCsvGenPath = chooser.getSelectedFile() + "";
            jtfFileGenPath.setText(msCsvGenPath);
        }
        else {
            System.out.println("No Selection ");
            jtfFileGenPath.setText("");
            msCsvGenPath = "";
        }
    }
    
    private void actionGenerateFile() {
        if (msCsvGenPath == null || msCsvGenPath.equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un directorio para guardar el archivo");
            return;
        }
        
        BufferedReader fileReader = null;
        
        try {
            fileReader = new BufferedReader(new FileReader(msCsvGenPath));
            
            String line = "";
            boolean needUpdate = false;
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                
                if (tokens[UUID].length() > 0) {
                    SDataCfd cfd = SReceiptsR.readCfdByUuid(miClient, tokens[UUID]);
                    if (cfd != null) {
                        System.out.print(cfd.getUuid());
                        try {
                            SGuiUtils.setCursorWait(miClient);
                            
                            needUpdate = SCfdUtils.validateCfdi((SClientInterface) miClient, cfd, SCfdConsts.CFDI_PAYROLL_VER_CUR, false);
                        }
                        catch (Exception e) {
                            Logger.getLogger(SDialogVerifyCfdis.class.getName()).log(Level.SEVERE, null, e);
                        }
                        finally {
                            SGuiUtils.setCursorDefault(miClient);
                        }
                        System.out.print(needUpdate);
                        System.out.println("");
                    }
                }
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(SDialogVerifyCfdis.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(SDialogVerifyCfdis.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (Exception ex) {
            Logger.getLogger(SDialogVerifyCfdis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 480, 300);
        jbSelectFileGen.addActionListener(this);
        jBGenerateFile.addActionListener(this);
        
        jbSave.setText("Guardar");
        moFields.setFormButton(jbSave);
        
        reloadCatalogues();
    }

    @Override
    public void addAllListeners() {
        
    }

    @Override
    public void removeAllListeners() {
        
    }
    
    @Override
    public void reloadCatalogues() {
        
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        if (validation.isValid()) {
            if (msCsvPath == null || msCsvPath.equals("")) {
                validation.setMessage("Debe seleccionar un archivo CSV para continuar");
            }
        }
        
        return validation;
    }
    
    @Override
    public void actionSave() {
        if (jbSave.isEnabled()) {
            if (SGuiUtils.computeValidation(miClient, validateForm())) {
                
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof javax.swing.JButton) {
            javax.swing.JButton button = (javax.swing.JButton) e.getSource();

            if (button == jbSelectFileGen) {
                actionSaveFile();
            }
            else if (button == jBGenerateFile) {
                actionGenerateFile();
            }
        }
    }
}
