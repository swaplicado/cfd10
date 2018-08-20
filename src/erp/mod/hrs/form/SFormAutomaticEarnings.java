/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.form;

import erp.mod.SModConsts;
import erp.mod.SModSysConsts;
import erp.mod.hrs.db.SDbAutomaticEarning;
import erp.mod.hrs.db.SDbAutomaticEarningsAux;
import erp.mod.hrs.db.SDbEarning;
import erp.mod.hrs.db.SDbLoan;
import erp.mod.hrs.db.SHrsUtils;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import sa.lib.SLibConsts;
import sa.lib.SLibUtils;
import sa.lib.db.SDbRegistry;
import sa.lib.grid.SGridColumnForm;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridPaneForm;
import sa.lib.grid.SGridPaneFormOwner;
import sa.lib.grid.SGridRow;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiParams;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.SGuiValidation;
import sa.lib.gui.bean.SBeanForm;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public class SFormAutomaticEarnings extends SBeanForm implements SGridPaneFormOwner, ActionListener, ItemListener {

    private SDbAutomaticEarningsAux moRegistry;
    private ArrayList<SDbAutomaticEarning> maAutomaticEarnings;
    private SDbEarning moEarning;
    private SGridPaneForm moGridAutomaticRow;

    /**
     * Creates new form SFormAutomaticEarnings
     */
    public SFormAutomaticEarnings(SGuiClient client, String title, int formSubType) {
        setFormSettings(client, SGuiConsts.BEAN_FORM_EDIT, SModConsts.HRSX_AUT_EAR, formSubType, title);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel9 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jlEmployee = new javax.swing.JLabel();
        moKeyEmployee = new sa.lib.gui.bean.SBeanFieldKey();
        jpRow = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        moTextCodeFind = new sa.lib.gui.bean.SBeanFieldText();
        jbCodeFind = new javax.swing.JButton();
        jlDummy = new javax.swing.JLabel();
        jlLoan_n = new javax.swing.JLabel();
        jlValue = new javax.swing.JLabel();
        jlDateStart = new javax.swing.JLabel();
        jlDateEnd_n = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        moTextName = new sa.lib.gui.bean.SBeanFieldText();
        moKeyLoan_n = new sa.lib.gui.bean.SBeanFieldKey();
        moComValue = new sa.lib.gui.bean.SBeanCompoundField();
        moDateDateStart = new sa.lib.gui.bean.SBeanFieldDate();
        moDateDateEnd_n = new sa.lib.gui.bean.SBeanFieldDate();
        jPanel26 = new javax.swing.JPanel();
        moRadNormal = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadSpecial = new sa.lib.gui.bean.SBeanFieldRadio();
        moRadExOrd = new sa.lib.gui.bean.SBeanFieldRadio();
        jbAdd = new javax.swing.JButton();
        jpRows = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del registro:"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        jlEmployee.setText("Empleado:*");
        jlEmployee.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel13.add(jlEmployee);

        moKeyEmployee.setPreferredSize(new java.awt.Dimension(300, 23));
        jPanel13.add(moKeyEmployee);

        jPanel2.add(jPanel13);

        jPanel7.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel9.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel9, java.awt.BorderLayout.NORTH);

        jpRow.setBorder(javax.swing.BorderFactory.createTitledBorder("Percepciones:"));
        jpRow.setLayout(new java.awt.BorderLayout());

        jPanel25.setLayout(new java.awt.GridLayout(3, 1));

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        moTextCodeFind.setText("sBeanFieldText1");
        moTextCodeFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                moTextCodeFindKeyPressed(evt);
            }
        });
        jPanel5.add(moTextCodeFind);

        jbCodeFind.setText("...");
        jbCodeFind.setFocusable(false);
        jbCodeFind.setPreferredSize(new java.awt.Dimension(23, 23));
        jPanel5.add(jbCodeFind);

        jlDummy.setPreferredSize(new java.awt.Dimension(75, 23));
        jPanel5.add(jlDummy);

        jlLoan_n.setText("Crédito/Préstamo:*");
        jlLoan_n.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel5.add(jlLoan_n);

        jlValue.setText("Valor:");
        jlValue.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel5.add(jlValue);

        jlDateStart.setText("Fecha inicial:*");
        jlDateStart.setPreferredSize(new java.awt.Dimension(102, 23));
        jPanel5.add(jlDateStart);

        jlDateEnd_n.setText("Fecha final:");
        jlDateEnd_n.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel5.add(jlDateEnd_n);

        jPanel25.add(jPanel5);

        jPanel24.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        moTextName.setEditable(false);
        moTextName.setText("sBeanFieldText1");
        moTextName.setToolTipText("Nombre");
        moTextName.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel24.add(moTextName);

        moKeyLoan_n.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel24.add(moKeyLoan_n);

        moComValue.setPreferredSize(new java.awt.Dimension(125, 23));
        jPanel24.add(moComValue);

        moDateDateStart.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel24.add(moDateDateStart);

        moDateDateEnd_n.setPreferredSize(new java.awt.Dimension(100, 23));
        jPanel24.add(moDateDateEnd_n);

        jPanel25.add(jPanel24);

        jPanel26.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING));

        buttonGroup1.add(moRadNormal);
        moRadNormal.setText("Es nómina normal");
        moRadNormal.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel26.add(moRadNormal);

        buttonGroup1.add(moRadSpecial);
        moRadSpecial.setText("Es nómina especial");
        moRadSpecial.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel26.add(moRadSpecial);

        buttonGroup1.add(moRadExOrd);
        moRadExOrd.setText("Es nómina extraordinaria");
        moRadExOrd.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel26.add(moRadExOrd);

        jbAdd.setText("Agregar");
        jPanel26.add(jbAdd);

        jPanel25.add(jPanel26);

        jpRow.add(jPanel25, java.awt.BorderLayout.NORTH);

        jpRows.setLayout(new java.awt.BorderLayout());
        jpRow.add(jpRows, java.awt.BorderLayout.CENTER);

        getContentPane().add(jpRow, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        super.windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void moTextCodeFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_moTextCodeFindKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F5) {
            jbCodeFind.doClick();
        }
    }//GEN-LAST:event_moTextCodeFindKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbCodeFind;
    private javax.swing.JLabel jlDateEnd_n;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlDummy;
    private javax.swing.JLabel jlEmployee;
    private javax.swing.JLabel jlLoan_n;
    private javax.swing.JLabel jlValue;
    private javax.swing.JPanel jpRow;
    private javax.swing.JPanel jpRows;
    private sa.lib.gui.bean.SBeanCompoundField moComValue;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateEnd_n;
    private sa.lib.gui.bean.SBeanFieldDate moDateDateStart;
    private sa.lib.gui.bean.SBeanFieldKey moKeyEmployee;
    private sa.lib.gui.bean.SBeanFieldKey moKeyLoan_n;
    private sa.lib.gui.bean.SBeanFieldRadio moRadExOrd;
    private sa.lib.gui.bean.SBeanFieldRadio moRadNormal;
    private sa.lib.gui.bean.SBeanFieldRadio moRadSpecial;
    private sa.lib.gui.bean.SBeanFieldText moTextCodeFind;
    private sa.lib.gui.bean.SBeanFieldText moTextName;
    // End of variables declaration//GEN-END:variables

    private void initComponentsCustom() {
        SGuiUtils.setWindowBounds(this, 1024, 640);

        moKeyEmployee.setKeySettings(miClient, SGuiUtils.getLabelName(jlEmployee.getText()), true);
        moTextCodeFind.setTextSettings(SGuiUtils.getLabelName(""), 10, 0);
        moTextName.setTextSettings(SGuiUtils.getLabelName(""), 100, 0);
        moComValue.setCompoundFieldSettings(miClient);
        moComValue.getField().setDecimalSettings(SGuiUtils.getLabelName(jlValue), SGuiConsts.GUI_TYPE_DEC_AMT_UNIT, false);
        moDateDateStart.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateStart), false);
        moDateDateEnd_n.setDateSettings(miClient, SGuiUtils.getLabelName(jlDateEnd_n), false);
        moKeyLoan_n.setKeySettings(miClient, SGuiUtils.getLabelName(jlLoan_n), false);
        moRadNormal.setBooleanSettings(SGuiUtils.getLabelName(moRadNormal.getText()), false);
        moRadSpecial.setBooleanSettings(SGuiUtils.getLabelName(moRadSpecial.getText()), false);
        moRadExOrd.setBooleanSettings(SGuiUtils.getLabelName(moRadExOrd.getText()), false);

        moFields.addField(moKeyEmployee);
        moFields.addField(moTextCodeFind);
        //moFields.addField(moTextName);
        moFields.addField(moKeyLoan_n);
        moFields.addField(moComValue.getField());
        moFields.addField(moDateDateStart);
        moFields.addField(moDateDateEnd_n);
        moFields.addField(moRadNormal);
        moFields.addField(moRadSpecial);
        moFields.addField(moRadExOrd);

        moFields.setFormButton(jbAdd);

        moGridAutomaticRow = new SGridPaneForm(miClient, SModConsts.HRS_AUT_EAR, SLibConsts.UNDEFINED, "Percepciones") {
            @Override
            public void initGrid() {
                setRowButtonsEnabled(false, false, true);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                ArrayList<SGridColumnForm> gridColumnsForm = new ArrayList<SGridColumnForm>();

                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_CAT, "Código percepción"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_L, "Percepción"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DEC_QTY, "Valor"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_UNT, "Unidad", 50));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Fecha inicial"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_DATE, "Fecha final"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_CAT_M, "Crédito/Préstamo"));
                gridColumnsForm.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT, "Tipo nómina"));

                return gridColumnsForm;
            }
        };

        moGridAutomaticRow.setForm(null);
        moGridAutomaticRow.setPaneFormOwner(this);
        //mvFormGrids.add(moGridAutomaticRow);

        jpRow.add(moGridAutomaticRow, BorderLayout.CENTER);
    }

    private void itemStateEmployee() {
        resetLoan();
    }

    private void resetLoan() {
        if (moEarning != null) {
            if (moEarning.getFkLoanTypeId() != SModSysConsts.HRSS_TP_LOAN_NON && mnFormSubtype == SModSysConsts.HRS_AUT_EMP) {
                if (moKeyEmployee.getValue().length > 0) {
                    miClient.getSession().populateCatalogue(moKeyLoan_n, SModConsts.HRS_LOAN, SLibConsts.UNDEFINED, new SGuiParams(new int[] { moKeyEmployee.getValue()[0], moEarning.getFkLoanTypeId()}));
                    moKeyLoan_n.setEnabled(true);
                    moComValue.getField().setEnabled(false);
                }
            }
            else {
                moComValue.getField().setEnabled(true);
                moKeyLoan_n.setSelectedIndex(0);
                moKeyLoan_n.setEnabled(false);
            }
        }
        else {
            moComValue.getField().setEnabled(true);
            moKeyLoan_n.setSelectedIndex(0);
            moKeyLoan_n.setEnabled(false);
        }
    }

    private void updateRows() {
        boolean applyUnits = SLibUtils.belongsTo(moEarning.getFkEarningComputationTypeId(), new int[] { SModSysConsts.HRSS_TP_EAR_COMP_DAYS, SModSysConsts.HRSS_TP_EAR_COMP_HRS });
        boolean applyAmount = moEarning.getFkEarningComputationTypeId() == SModSysConsts.HRSS_TP_EAR_COMP_AMT;
        
        SDbAutomaticEarning automaticRow = new SDbAutomaticEarning();
        automaticRow.setPkEarningId(moEarning.getPkEarningId());
        automaticRow.setUnits(!applyUnits ? 1 : moComValue.getField().getValue());
        automaticRow.setAmountUnitary(!applyAmount ? 1 : moComValue.getField().getValue());
        automaticRow.setAmount_r(SLibUtils.roundAmount(automaticRow.getUnits() * automaticRow.getAmountUnitary()));
        automaticRow.setDateStart(moDateDateStart.getValue());
        automaticRow.setDateEnd_n(moDateDateEnd_n.getValue());
        automaticRow.setFkPaysheetTypeId(getPaysheetTypeId());
        automaticRow.setFkEarningTypeId(moEarning.getFkEarningTypeId());
        automaticRow.setFkEmployeeId_n(mnFormSubtype != SModSysConsts.HRS_AUT_EMP ? SLibConsts.UNDEFINED : moKeyEmployee.getValue()[0]);
        
        if (moKeyLoan_n.isEnabled() && moKeyLoan_n.getValue().length > 0) {
            automaticRow.setFkLoanEmployeeId_n(moKeyLoan_n.getValue()[0]);
            automaticRow.setFkLoanLoanId_n(moKeyLoan_n.getValue()[1]);
        }

        automaticRow.setXtaEarningCode((String) miClient.getSession().readField(SModConsts.HRS_EAR, new int[] { moEarning.getPkEarningId() }, SDbRegistry.FIELD_CODE));
        automaticRow.setXtaEarning((String) miClient.getSession().readField(SModConsts.HRS_EAR, new int[] { moEarning.getPkEarningId() }, SDbRegistry.FIELD_NAME));
        automaticRow.setXtaUnit((String) miClient.getSession().readField(SModConsts.HRSS_TP_EAR_COMP, new int[] { moEarning.getFkEarningComputationTypeId() }, SDbRegistry.FIELD_CODE));
        automaticRow.setXtaPaysheetType((String) miClient.getSession().readField(SModConsts.HRSS_TP_PAY_SHT, new int[] { getPaysheetTypeId() }, SDbRegistry.FIELD_NAME));
        
        if (moKeyLoan_n.isEnabled() && moKeyLoan_n.getValue().length > 0) {
            SDbLoan loan = (SDbLoan) miClient.getSession().readRegistry(SModConsts.HRS_LOAN, new int[] { moKeyLoan_n.getValue()[0], moKeyLoan_n.getValue()[1] });
            automaticRow.setXtaLoan(loan.getLoanIdentificator());
        }

        SGridRow gridRow = (SGridRow) automaticRow;
        moGridAutomaticRow.getModel().getGridRows().add(gridRow);
        moGridAutomaticRow.getModel().renderGridRows();

        int row = moGridAutomaticRow.getModel().getRowCount() - 1;
        moGridAutomaticRow.setSelectedGridRow(row);
    }

    private void populateAutomaticRow() throws Exception {
        Vector<SGridRow> rows = new Vector<>();

        for (SDbAutomaticEarning row : moRegistry.getAutomaticEarnings()) {
            SDbEarning earning = (SDbEarning) miClient.getSession().readRegistry(SModConsts.HRS_EAR, new int[] { row.getPkEarningId() });

            row.setXtaEarningCode((String) miClient.getSession().readField(SModConsts.HRS_EAR, new int[] { row.getPkEarningId() }, SDbRegistry.FIELD_CODE));
            row.setXtaEarning((String) miClient.getSession().readField(SModConsts.HRS_EAR, new int[] { row.getPkEarningId() }, SDbRegistry.FIELD_NAME));
            row.setXtaUnit((String) miClient.getSession().readField(SModConsts.HRSS_TP_EAR_COMP, new int[] { earning.getFkEarningComputationTypeId() }, SDbRegistry.FIELD_CODE));
            row.setXtaPaysheetType((String) miClient.getSession().readField(SModConsts.HRSS_TP_PAY_SHT, new int[] { row.getFkPaysheetTypeId() }, SDbRegistry.FIELD_NAME));
            if (row.getFkLoanEmployeeId_n() != SLibConsts.UNDEFINED) {
                SDbLoan loan = (SDbLoan) miClient.getSession().readRegistry(SModConsts.HRS_LOAN, new int[] { row.getFkLoanEmployeeId_n(), row.getFkLoanLoanId_n() });
                row.setXtaLoan(loan.getLoanIdentificator());
            }

            if (!row.isDeleted()) {
                rows.add(row);
            }
        }

        moGridAutomaticRow.populateGrid(rows);
        moGridAutomaticRow.clearSortKeys();
        moGridAutomaticRow.setSelectedGridRow(0);
    }

    private void enableFields() {
        if (mnFormSubtype == SModSysConsts.HRS_AUT_EMP && moGridAutomaticRow.getModel().getRowCount() == 0) {
            moKeyEmployee.setEnabled(true);
        }
        else {
            moKeyEmployee.setEnabled(false);
        }
    }
    
    private void resetFields() {
        moTextCodeFind.setText("");
        moTextName.setText("");
        moComValue.getField().setValue(0d);
        moComValue.getField().setEnabled(false);
        moComValue.setCompoundText("");
        moDateDateStart.setValue(miClient.getSession().getCurrentDate());
        moDateDateEnd_n.setValue(null);
        moKeyLoan_n.setSelectedIndex(0);
        moKeyLoan_n.setEnabled(false);
        moRadNormal.setSelected(true);

        moTextCodeFind.requestFocus();
    }
    
    private int getPaysheetTypeId() {
        int type = SLibConsts.UNDEFINED;
        
        if (moRadNormal.isSelected()) {
            type = SModSysConsts.HRSS_TP_PAY_SHT_NOR;
        }
        else if (moRadSpecial.isSelected()) {
            type = SModSysConsts.HRSS_TP_PAY_SHT_SPE;
        }
        else if (moRadExOrd.isSelected()) {
            type = SModSysConsts.HRSS_TP_PAY_SHT_EXT;
        }
        
        return type;
    }

    private void actionAdd() {
        boolean add = true;

        if (moTextName.getValue().length() > 0) {
            if (mnFormSubtype == SModSysConsts.HRS_AUT_EMP && moKeyEmployee.getSelectedIndex() <= 0) {
                miClient.showMsgBoxWarning(SGuiConsts.ERR_MSG_FIELD_REQ + "'" + SGuiUtils.getLabelName(jlEmployee.getText()) + "'. ");
                add = false;
                moKeyEmployee.requestFocus();
            }
            
            if (moDateDateEnd_n.getValue() != null) {
                if (moDateDateEnd_n.getValue().before(moDateDateStart.getValue())) {
                    miClient.showMsgBoxWarning(SGuiConsts.ERR_MSG_FIELD_DATE_ + "'" + SGuiUtils.getLabelName(jlDateEnd_n.getText()) + "' " +
                            SGuiConsts.ERR_MSG_FIELD_DATE_GREAT_EQUAL + SGuiConsts.ERR_MSG_FIELD_DATE_.toLowerCase() + " '" + SGuiUtils.getLabelName(jlDateStart.getText()) + "'.");
                    add = false;
                    moDateDateEnd_n.requestFocus();
                }
            }

            if (moDateDateStart.getValue() == null) {
                miClient.showMsgBoxWarning(SGuiConsts.ERR_MSG_FIELD_REQ + "'" + SGuiUtils.getLabelName(jlDateStart.getText()) + "'. ");
                add = false;
                moDateDateStart.requestFocus();
            }

            if (moEarning.getFkLoanTypeId() != SModSysConsts.HRSS_TP_LOAN_NON) {
                if (moKeyLoan_n.getSelectedIndex() <= 0) {
                    miClient.showMsgBoxWarning(SGuiConsts.ERR_MSG_FIELD_REQ + "'" + SGuiUtils.getLabelName(jlLoan_n.getText()) + "'. ");
                    add = false;
                    moKeyLoan_n.requestFocus();
                }
            }

            if (add) {
                updateRows();
                resetFields();
                enableFields();
            }
        }
    }
    
    private void actionPickEarning() {
        miClient.getSession().showOptionPicker(SModConsts.HRS_EAR, SLibConsts.UNDEFINED, null, moTextCodeFind);
        actionLoadEarning();
    }

    private void actionLoadEarning() {
        boolean load = true;

        try {
            moEarning = SHrsUtils.getEarning(miClient, SLibUtils.textTrim(moTextCodeFind.getText()));
        }
        catch (Exception e) {
            SLibUtils.printException(this, e);
        }

        if (moEarning == null) {
            miClient.showMsgBoxWarning("No se encontró ninguna percepción con código '" + moTextCodeFind.getText() + "'.");
            moTextCodeFind.requestFocus();
        }
        else {
            if ((moEarning.getFkAbsenceClassId_n() != SLibConsts.UNDEFINED && moEarning.getFkAbsenceTypeId_n() != SLibConsts.UNDEFINED) || moEarning.getFkBenefitTypeId() != SModSysConsts.HRSS_TP_BEN_NON) {
                miClient.showMsgBoxWarning("No se pueden agregar percepciones de tipo incidencia ni prestación.");
                load = false;
                moTextCodeFind.requestFocus();
            }
            
            if (moEarning.getFkLoanTypeId() != SModSysConsts.HRSS_TP_LOAN_NON) {
                if (mnFormSubtype == SModSysConsts.HRS_AUT_GBL) {
                    miClient.showMsgBoxWarning("No se pueden agregar percepciones de tipo crédito/préstamo.");
                    load = false;
                    moTextCodeFind.requestFocus();
                }
            }

            if (load) {
                moTextName.setValue(moEarning.getName());
                moComValue.getField().setEditable(!moEarning.isDaysWorkedBasedOn());
                moComValue.setCompoundText((String) miClient.getSession().readField(SModConsts.HRSS_TP_EAR_COMP, new int[] { moEarning.getFkEarningComputationTypeId() }, SDbRegistry.FIELD_CODE));
                moComValue.getField().getComponent().requestFocus();

                resetLoan();
            }
        }
    }

    @Override
    public void addAllListeners() {
        moKeyEmployee.addItemListener(this);
        moTextCodeFind.addActionListener(this);
        jbCodeFind.addActionListener(this);
        jbAdd.addActionListener(this);
    }

    @Override
    public void removeAllListeners() {
        moKeyEmployee.removeItemListener(this);
        moTextCodeFind.removeActionListener(this);
        jbCodeFind.removeActionListener(this);
        jbAdd.removeActionListener(this);
    }

    @Override
    public void reloadCatalogues() {
        try {
            populateAutomaticRow();
            miClient.getSession().populateCatalogue(moKeyEmployee, SModConsts.HRSU_EMP, SLibConsts.UNDEFINED, null);
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }
    }

    @Override
    public void setRegistry(SDbRegistry registry) throws Exception {
        moRegistry = (SDbAutomaticEarningsAux) registry;

        moEarning = null;
        maAutomaticEarnings = new ArrayList<SDbAutomaticEarning>();

        mnFormResult = SLibConsts.UNDEFINED;
        mbFirstActivation = true;
        removeAllListeners();
        reloadCatalogues();

        jtfRegistryKey.setText("");

        resetFields();

        setFormEditable(true);

        moKeyLoan_n.setEnabled(false);
        moKeyEmployee.setEnabled(false);

        if (mnFormSubtype == SModSysConsts.HRS_AUT_EMP) {
            enableFields();

            if (!moRegistry.getAutomaticEarnings().isEmpty()) {
                moKeyEmployee.setValue(new int[] { moRegistry.getAutomaticEarnings().get(0).getFkEmployeeId_n() });
            }
        }

        addAllListeners();
    }

    @Override
    public SDbRegistry getRegistry() throws Exception {
        SDbAutomaticEarningsAux registry = moRegistry.clone();

        if (registry.isRegistryNew()) {}

        for (SGridRow row : moGridAutomaticRow.getModel().getGridRows()) {
            registry.getAutomaticEarnings().add((SDbAutomaticEarning) row);
        }

        for (SGridRow row : maAutomaticEarnings) {
             registry.getAutomaticEarnings().add((SDbAutomaticEarning) row);
         }

        return registry;
    }

    @Override
    public SGuiValidation validateForm() {
        SGuiValidation validation = moFields.validateFields();

        return validation;
    }

    @Override
    public void notifyRowNew(int gridType, int gridSubtype, int row, SGridRow gridRow) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notifyRowEdit(int gridType, int gridSubtype, int row, SGridRow gridRow) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void notifyRowDelete(int gridType, int gridSubtype, int row, SGridRow gridRow) {
        SDbAutomaticEarning automaticEarning = null;

        automaticEarning = (SDbAutomaticEarning) gridRow;

        if (!automaticEarning.isRegistryNew()) {
            automaticEarning.setDeleted(true);
            maAutomaticEarnings.add(automaticEarning);
        }
        enableFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == jbAdd) {
                actionAdd();
            }
            else if (button == jbCodeFind) {
                actionPickEarning();
            }
        }
        else if (e.getSource() instanceof JTextField) {
            JTextField textField = (JTextField) e.getSource();

            if (textField == moTextCodeFind) {
                actionLoadEarning();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JComboBox && e.getStateChange() == ItemEvent.SELECTED) {
            JComboBox comboBox = (JComboBox)  e.getSource();

            if (comboBox == moKeyEmployee) {
                itemStateEmployee();
            }
        }
    }
}
