/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.gui.account;

import erp.gui.session.SSessionCustom;
import erp.mcfg.data.SDataParamsCompany;
import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JTable;
import sa.gui.util.SUtilConsts;
import sa.lib.SLibConsts;
import sa.lib.grid.SGridColumnForm;
import sa.lib.grid.SGridConsts;
import sa.lib.grid.SGridPaneForm;
import sa.lib.grid.SGridRow;
import sa.lib.gui.SGuiClient;
import sa.lib.gui.SGuiConsts;
import sa.lib.gui.SGuiUtils;
import sa.lib.gui.bean.SBeanFieldText;

/**
 *
 * @author Sergio Flores
 */
public final class SPickerAccount extends JDialog implements MouseListener, KeyListener {

    private SGuiClient miClient;
    private int mnPickerType;
    private int mnPickerResult;
    private boolean mbFirstActivation;
    private String msCurrentTextToFind;
    private SGridPaneForm moPane;
    private SGridPaneForm moPaneByNumber;
    private SGridPaneForm moPaneByName;
    private ArrayList<SRowAccountByNumber> maRowsByNumber;
    private ArrayList<SRowAccountByName> maRowsByName;

    /**
     * Creates new form SPickerAccount
     * @param client GUI Client.
     * @param pickerType Constants defined in <code>SAccountConsts</code>.
     */
    public SPickerAccount(SGuiClient client, int pickerType) {
        super(client.getFrame(), true);
        miClient = client;
        mnPickerType = pickerType;
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

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jrbFindByNumber = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jrbFindByName = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        moTextToFind = new sa.lib.gui.bean.SBeanFieldText();
        jbClear = new javax.swing.JButton();
        jpGrid = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar cuenta");
        setModal(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros de búsqueda:"));
        jPanel2.setLayout(new java.awt.BorderLayout(0, 5));

        jPanel3.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        buttonGroup.add(jrbFindByNumber);
        jrbFindByNumber.setSelected(true);
        jrbFindByNumber.setText("Por número");
        jrbFindByNumber.setPreferredSize(new java.awt.Dimension(100, 23));
        jrbFindByNumber.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbFindByNumberItemStateChanged(evt);
            }
        });
        jPanel4.add(jrbFindByNumber);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        buttonGroup.add(jrbFindByName);
        jrbFindByName.setText("Por nombre");
        jrbFindByName.setPreferredSize(new java.awt.Dimension(100, 23));
        jrbFindByName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jrbFindByNameItemStateChanged(evt);
            }
        });
        jPanel5.add(jrbFindByName);

        jPanel3.add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        moTextToFind.setText("sBeanFieldText1");
        moTextToFind.setPreferredSize(new java.awt.Dimension(300, 23));
        moTextToFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moTextToFindActionPerformed(evt);
            }
        });
        jPanel6.add(moTextToFind);

        jbClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_std_delete.gif"))); // NOI18N
        jbClear.setPreferredSize(new java.awt.Dimension(23, 23));
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });
        jPanel6.add(jbClear);

        jPanel3.add(jPanel6);

        jPanel2.add(jPanel3, java.awt.BorderLayout.NORTH);

        jpGrid.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jpGrid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        jPanel1.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jbCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-496)/2, (screenSize.height-338)/2, 496, 338);
    }// </editor-fold>//GEN-END:initComponents

    private void jrbFindByNumberItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbFindByNumberItemStateChanged
        itemStateChangedByNumber(evt);
    }//GEN-LAST:event_jrbFindByNumberItemStateChanged

    private void jrbFindByNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jrbFindByNameItemStateChanged
        itemStateChangedByName(evt);
    }//GEN-LAST:event_jrbFindByNameItemStateChanged

    private void moTextToFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moTextToFindActionPerformed
        actionText();
    }//GEN-LAST:event_moTextToFindActionPerformed

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        actionOk();
    }//GEN-LAST:event_jbOkActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        actionCancel();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        actionClear();
    }//GEN-LAST:event_jbClearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbOk;
    private javax.swing.JPanel jpGrid;
    private javax.swing.JRadioButton jrbFindByName;
    private javax.swing.JRadioButton jrbFindByNumber;
    private sa.lib.gui.bean.SBeanFieldText moTextToFind;
    // End of variables declaration//GEN-END:variables

    /*
     * Private methods
     */

    private void initComponentsCustom() {

        moPane = null;

        moPaneByNumber = new SGridPaneForm(miClient, mnPickerType, mnPickerType, null) {

            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                ArrayList<SGridColumnForm> columns = new ArrayList<SGridColumnForm>();

                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_ACC, SGuiConsts.TXT_LBL_NUM, 100));
                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_ACC, SGuiConsts.TXT_LBL_NAME, 300));
                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_BOOL_S, SGridConsts.COL_TITLE_IS_DEL));

                return columns;
            }
        };

        moPaneByName = new SGridPaneForm(miClient, mnPickerType, mnPickerType, null) {

            @Override
            public void initGrid() {
                setRowButtonsEnabled(false);
            }

            @Override
            public ArrayList<SGridColumnForm> createGridColumns() {
                ArrayList<SGridColumnForm> columns = new ArrayList<SGridColumnForm>();

                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_NAME_ACC, SGuiConsts.TXT_LBL_NAME, 300));
                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_TEXT_CODE_ACC, SGuiConsts.TXT_LBL_NUM, 100));
                columns.add(new SGridColumnForm(SGridConsts.COL_TYPE_BOOL_S, SGridConsts.COL_TITLE_IS_DEL));

                return columns;
            }
        };

        moTextToFind.addKeyListener(this);

        jrbFindByNumber.setSelected(true);
        resetPicker("", "");    // required on picker creation!

        SGuiUtils.createActionMap(getRootPane(), this, "actionCancel", "cancel", KeyEvent.VK_ESCAPE);
    }

    private void windowActivated() {
        if (mbFirstActivation) {
            mbFirstActivation = false;
            moTextToFind.requestFocus();
        }
    }

    private void addAccountsByNumber(final int mask, final SAccount account) {
        maRowsByNumber.add(new SRowAccountByNumber(mask, account));
        for (SAccount child : account.getChildren()) {
            addAccountsByNumber(mask, child);
        }
    }

    private void addAccountsByName(final int mask, final SAccount account) {
        maRowsByName.add(new SRowAccountByName(mask, account));
        for (SAccount child : account.getChildren()) {
            addAccountsByName(mask, child);
        }
    }

    private void updateAccounts() {
        int mask = 0;
        ArrayList<SAccountLedger> ledgers = new ArrayList<SAccountLedger>();

        switch (mnPickerType) {
            case SAccountConsts.TYPE_ACCOUNT:
                setTitle(SUtilConsts.TXT_SELECT + " " + SAccountConsts.NAME_ACCOUNT.toLowerCase());
                ledgers = ((SSessionCustom) miClient.getSession().getSessionCustom()).getAccountLedgers();
                mask = ((SDataParamsCompany) miClient.getSession().getConfigCompany()).getMaskAccount();
                break;
            case SAccountConsts.TYPE_COST_CENTER:
                setTitle(SUtilConsts.TXT_SELECT + " " + SAccountConsts.NAME_COST_CENTER.toLowerCase());
                ledgers = ((SSessionCustom) miClient.getSession().getSessionCustom()).getCostCenterLedgers();
                mask = ((SDataParamsCompany) miClient.getSession().getConfigCompany()).getMaskCostCenter();
                break;
            default:
                miClient.showMsgBoxError(SLibConsts.ERR_MSG_OPTION_UNKNOWN);
        }

        maRowsByNumber = new ArrayList<SRowAccountByNumber>();
        maRowsByName = new ArrayList<SRowAccountByName>();

        for (SAccount ledger : ledgers) {
            addAccountsByNumber(mask, ledger);
            addAccountsByName(mask, ledger);
        }
    }

    private void renderGrid() {
        if (jrbFindByNumber.isSelected()) {
            moPane = moPaneByNumber;
        }
        else {
            moPane = moPaneByName;
        }

        jpGrid.removeAll();
        jpGrid.add(moPane, BorderLayout.CENTER);
        jpGrid.validate();
        jpGrid.repaint();

        actionClear();
    }

    private void renderGridRows() {
        Vector<SGridRow> rows = new Vector<SGridRow>();

        if (mbFirstActivation || msCurrentTextToFind.compareTo(moTextToFind.getValue()) != 0) {
            msCurrentTextToFind = moTextToFind.getValue();

            if (jrbFindByNumber.isSelected()) {
                if (msCurrentTextToFind.isEmpty()) {
                    rows.addAll(maRowsByNumber);
                }
                else {
                    for (SRowAccountByNumber row : maRowsByNumber) {
                        if (row.getRowCode().startsWith(msCurrentTextToFind)) {
                            rows.add(row);
                        }
                    }
                }
            }
            else {
                if (msCurrentTextToFind.isEmpty()) {
                    rows.addAll(maRowsByName);
                }
                else {
                    for (SRowAccountByName row : maRowsByName) {
                        if (row.getRowName().startsWith(msCurrentTextToFind)) {
                            rows.add(row);
                        }
                    }
                }
            }

            moPane.populateGrid(rows);
            moPane.getTable().addMouseListener(this);
            moPane.getTable().addKeyListener(this);
        }
    }

    private void itemStateChangedByNumber(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            renderGrid();
        }
    }

    private void itemStateChangedByName(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            renderGrid();
        }
    }

    /*
     * Public methods
     */


    /**
     * Resets picker.
     */

    public void resetPicker(final String numberToFind, final String nameToFind) {
        mbFirstActivation = true;
        msCurrentTextToFind = "";

        moTextToFind.setValue(jrbFindByNumber.isSelected() ? numberToFind : nameToFind);

        updateAccounts();   // updates system's current available accounts

        if (moTextToFind.getValue().isEmpty()) {
            renderGrid();
        }
        else {
            renderGridRows();
        }
    }

    public int getPickerResult() {
        return mnPickerResult;
    }

    public SAccount getSelectedAccount() {
        return moPane.getTable().getSelectedRow() == -1 ? null : ((SRowAccount) moPane.getSelectedGridRow()).getAccount();
    }

    public void actionText() {
        if (moPane.getTable().getRowCount() > 0) {
            moPane.setSelectedGridRow(0);
            moPane.getTable().requestFocus();
        }
    }

    public void actionClear() {
        moTextToFind.setValue("");
        moTextToFind.requestFocus();
        renderGridRows();
    }

    public void actionOk() {
        if (moPane.getTable().getSelectedRow() == -1) {
            miClient.showMsgBoxWarning(SGridConsts.MSG_SELECT_ROW);
        }
        else {
            mnPickerResult = SGuiConsts.FORM_RESULT_OK;
            dispose();
        }
    }

    public void actionCancel() {
        mnPickerResult = SGuiConsts.FORM_RESULT_CANCEL;
        dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            if (e.getClickCount() == 2) {
                actionOk();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() instanceof JTable) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                e.consume();
                actionOk();
            }
        }
        else if (e.getSource() instanceof SBeanFieldText) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                actionText();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() instanceof SBeanFieldText) {
            renderGridRows();
        }
    }
}
