/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SFormOptionPicker.java
 *
 * Created on 29/09/2009, 09:43:42 AM
 */

package erp.mtrn.form;

import erp.data.SDataConstantsSys;
import erp.data.SDataReadTableRows;
import erp.lib.SLibConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormUtilities;
import erp.lib.table.STableColumnForm;
import erp.lib.table.STableConstants;
import erp.lib.table.STablePane;
import erp.lib.table.STableRow;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author Néstor Ávalos
 */
public class SFormOptionPickerDpsBalance extends javax.swing.JDialog implements erp.lib.form.SFormOptionPickerInterface {

    private erp.client.SClientInterface miClient;
    private int mnOptionType;

    private int mnFormResult;
    private boolean mbFirstTime;
    private java.lang.Object moFilterKey;
    private erp.lib.table.STablePane moOptionPane;

    private int mnParamTpSysMovId[];
    private int mnParamFkBizPartnerId;

    /**
     * Creates new form SFormOptionPicker
     */
    public SFormOptionPickerDpsBalance(erp.client.SClientInterface client, int type) {
        super(client.getFrame(), true);
        miClient = client;
        mnOptionType = type;

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

        jpOptionPane = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jlOption = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jtbFilter = new javax.swing.JToggleButton();
        jbRefresh = new javax.swing.JButton();
        jpSouth = new javax.swing.JPanel();
        jbOk = new javax.swing.JButton();
        jbCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selección");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jpOptionPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones disponibles:"));
        jpOptionPane.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jlOption.setText("Seleccionar una opción:");
        jlOption.setPreferredSize(new java.awt.Dimension(200, 23));
        jPanel1.add(jlOption, java.awt.BorderLayout.LINE_START);

        jtbFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/switch_filter_off.gif"))); // NOI18N
        jtbFilter.setSelected(true);
        jtbFilter.setToolTipText("Filtrar liquidados");
        jtbFilter.setPreferredSize(new java.awt.Dimension(23, 23));
        jtbFilter.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/switch_filter_on.gif"))); // NOI18N
        jtbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbFilterActionPerformed(evt);
            }
        });
        jPanel2.add(jtbFilter);

        jbRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/icon_reload.gif"))); // NOI18N
        jbRefresh.setToolTipText("Refrescar");
        jbRefresh.setFocusable(false);
        jbRefresh.setPreferredSize(new java.awt.Dimension(23, 23));
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });
        jPanel2.add(jbRefresh);

        jPanel1.add(jPanel2, java.awt.BorderLayout.EAST);

        jpOptionPane.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jpOptionPane, java.awt.BorderLayout.CENTER);

        jpSouth.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbOk.setText("Aceptar");
        jbOk.setToolTipText("[Ctrl + Enter]");
        jbOk.setPreferredSize(new java.awt.Dimension(75, 23));
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });
        jpSouth.add(jbOk);

        jbCancel.setText("Cancelar");
        jbCancel.setToolTipText("[Escape]");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });
        jpSouth.add(jbCancel);

        getContentPane().add(jpSouth, java.awt.BorderLayout.PAGE_END);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-467)/2, (screenSize.height-390)/2, 467, 390);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        windowActivated();
    }//GEN-LAST:event_formWindowActivated

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        actionOk();
    }//GEN-LAST:event_jbOkActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        actionCancel();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefreshActionPerformed
        formRefreshOptionPane();
    }//GEN-LAST:event_jbRefreshActionPerformed

    private void jtbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbFilterActionPerformed
        actionPerfomedFilter();
    }//GEN-LAST:event_jtbFilterActionPerformed

    private void initComponentsExtra() {
        int i = 0;
        STableColumnForm[] aoTableColumns = null;

        moOptionPane = new STablePane(miClient);
        moOptionPane.setDoubleClickAction(this, "publicActionOk");
        jpOptionPane.add(moOptionPane, BorderLayout.CENTER);

        aoTableColumns = new STableColumnForm[7];
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DATE, "Fecha doc.", STableConstants.WIDTH_DATE);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Tipo doc.", STableConstants.WIDTH_CODE_DOC);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Folio doc.", STableConstants.WIDTH_DOC_NUM);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Total neto moneda $", STableConstants.WIDTH_VALUE);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_DOUBLE, "Saldo moneda $", STableConstants.WIDTH_VALUE);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Moneda", STableConstants.WIDTH_CURRENCY_KEY);
        aoTableColumns[i++] = new STableColumnForm(SLibConstants.DATA_TYPE_STRING, "Sucursal empresa", STableConstants.WIDTH_CODE_COB);
        setTitle("Seleccionar documento de compras-ventas");

        for (i = 0; i < aoTableColumns.length; i++) {
            moOptionPane.addTableColumn(aoTableColumns[i]);
        }

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
        if (mbFirstTime) { mbFirstTime = false; moOptionPane.getTable().requestFocus(); }
    }

    private void actionPerfomedFilter() {
        if (jtbFilter.isSelected()) {
            moFilterKey = new Object[] { mnParamTpSysMovId, mnParamFkBizPartnerId, SDataConstantsSys.TRNX_DPS_BAL_PAY_PEND };
        }
        else {
            moFilterKey = new Object[] { mnParamTpSysMovId, mnParamFkBizPartnerId, SDataConstantsSys.TRNX_DPS_BAL_ALL };
        }
        formRefreshOptionPane();
    }

    private void actionOk() {
        if (moOptionPane.getSelectedTableRow() == null) {
            miClient.showMsgBoxWarning(SLibConstants.MSG_ERR_UTIL_UNKNOWN_OPTION);
            moOptionPane.getTable().requestFocus();
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JLabel jlOption;
    private javax.swing.JPanel jpOptionPane;
    private javax.swing.JPanel jpSouth;
    private javax.swing.JToggleButton jtbFilter;
    // End of variables declaration//GEN-END:variables

    @Override
    public void formReset() {
        mnFormResult = SLibConstants.UNDEFINED;
        mbFirstTime = true;
        moFilterKey = null;

        moOptionPane.setTableRowSelection(0);
    }

    @Override
    public void formRefreshOptionPane() {
        Vector<STableRow> vTableRows = SDataReadTableRows.getTableRows(miClient, mnOptionType, moFilterKey);

        moOptionPane.createTable();
        moOptionPane.clearTableRows();
        for (int i = 0; i < vTableRows.size(); i++) {
            moOptionPane.addTableRow(vTableRows.get(i));
        }
        moOptionPane.renderTableRows();
        moOptionPane.setTableRowSelection(0);
    }

    @Override
    public void setFormVisible(boolean visible) {
        setVisible(visible);
    }

    @Override
    public int getOptionType() {
        return mnOptionType;
    }

    @Override
    public int getFormResult() {
        return mnFormResult;
    }

    @Override
    public void setFilterKey(java.lang.Object filterKey) {
        moFilterKey = filterKey;

        mnParamTpSysMovId = (int [])((Object []) filterKey)[0];
        mnParamFkBizPartnerId = (Integer)((Object []) filterKey)[1];
    }

    @Override
    public void setSelectedPrimaryKey(java.lang.Object pk) {
        moOptionPane.renderTableRows();

        for (int i = 0; i < moOptionPane.getTableGuiRowCount(); i++) {
            if (SLibUtilities.compareKeys(pk, moOptionPane.getTableModel().getTableRow(i).getPrimaryKey())) {
                moOptionPane.setTableRowSelection(i);
                break;
            }
        }
    }

    @Override
    public java.lang.Object getSelectedPrimaryKey() {
        Object pk = null;

        if (moOptionPane.getSelectedTableRow() != null) {
            pk = moOptionPane.getSelectedTableRow().getPrimaryKey();
        }

        return pk;
    }

    @Override
    public erp.lib.table.STableRow getSelectedOption() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
