/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mfin.form;

import erp.data.SDataConstants;
import erp.lib.SLibUtilities;
import erp.lib.form.SFormComponentItem;
import erp.lib.form.SFormUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.AbstractAction;

/**
 *
 * @author Sergio Flores
 */
public class SChooserAccount extends javax.swing.JDialog {

    private final int CHOOSER_WIDTH = 400;

    private erp.client.SClientInterface miClient;
    private erp.mfin.form.SPanelAccount moPanelAccount;
    private int mnOptionsVisible;

    /** Creates new form SChooserAccount */
    public SChooserAccount(erp.client.SClientInterface client, erp.mfin.form.SPanelAccount panelAccount, int optionsVisible) {
        super();
        miClient = client;
        moPanelAccount = panelAccount;
        mnOptionsVisible = optionsVisible;
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

        jScrollPane = new javax.swing.JScrollPane();
        jList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);

        jList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane.setViewportView(jList);

        getContentPane().add(jScrollPane, java.awt.BorderLayout.CENTER);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-400)/2, (screenSize.height-150)/2, 400, 150);
    }// </editor-fold>//GEN-END:initComponents

    private void initComponentsExtra() {
        AbstractAction actionOk = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionOk(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionOk, "ok", KeyEvent.VK_ENTER, 0);

        AbstractAction actionCancel = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) { actionCancel(); }
        };

        SFormUtilities.putActionMap(getRootPane(), actionCancel, "cancel", KeyEvent.VK_ESCAPE, 0);
    }

    private void actionOk() {
        setVisible(false);

        if (jList.getSelectedIndex() != -1) {
            moPanelAccount.getFieldAccount().setString((String) ((Object[]) ((SFormComponentItem) jList.getSelectedValue()).getPrimaryKey())[0]);
            moPanelAccount.getFieldAccount().getComponent().requestFocus();
            moPanelAccount.refreshPanel();
        }
    }

    private void actionCancel() {
        setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables

    /**
     * Shows account chooser, using provided filter and, optionally, date filter.
     * @param x x position.
     * @param y y position.
     * @param accountFilter Account filter.
     * @param dateFilter Date filter (can be null).
     */
    @SuppressWarnings("unchecked")
    public void showChooser(int x, int y, java.lang.String accountFilter, java.util.Date dateFilter) {
        String sql = "";
        ResultSet resulSet = null;
        Vector<SFormComponentItem> items = new Vector<SFormComponentItem>();

        try {
            if (moPanelAccount.getFieldAccount().getAccountType() == SDataConstants.FIN_ACC) {
                sql = "SELECT id_acc, CONCAT(id_acc, ' - ', acc) AS f_acc " +
                        "FROM fin_acc WHERE b_act = TRUE AND b_del = FALSE AND " +
                        "id_acc LIKE '" + accountFilter + "%' " +
                        (dateFilter == null ? "" : "AND " +
                        "dt_start <= '" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(dateFilter) + "' AND " +
                        "(dt_end_n IS NULL OR dt_end_n >= '" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(dateFilter) + "') ") +
                        "ORDER BY id_acc ";
            }
            else {
                sql = "SELECT id_cc, CONCAT(id_cc, ' - ', cc) AS f_cc " +
                        "FROM fin_cc WHERE b_act = TRUE AND b_del = FALSE AND " +
                        "id_cc LIKE '" + accountFilter + "%' " +
                        (dateFilter == null ? "" : "AND " +
                        "dt_start <= '" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(dateFilter) + "' AND " +
                        "(dt_end_n IS NULL OR dt_end_n >= '" + miClient.getSessionXXX().getFormatters().getDbmsDateFormat().format(dateFilter) + "') ") +
                        "ORDER BY id_cc ";
            }

            resulSet = miClient.getSession().getStatement().executeQuery(sql);
            
            while (resulSet.next()) {
                items.add(new SFormComponentItem(new Object[] { resulSet.getObject(1) }, resulSet.getString(2)));
            }

            jList.setListData(items);

            setBounds(x, y, CHOOSER_WIDTH, jList.getFontMetrics(jList.getFont()).getHeight() * mnOptionsVisible);

            setVisible(true);
        }
        catch(SQLException e) {
            SLibUtilities.renderException(this, e);
        }
        catch(Exception e) {
            SLibUtilities.renderException(this, e);
        }
    }

    public void hideChooser() {
        actionCancel();
    }
}