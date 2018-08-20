/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.lib.table;

import erp.lib.SLibConstants;
import erp.lib.SLibTimeUtilities;
import erp.lib.gui.SGuiDate;
import java.util.Date;
import sa.lib.SLibTimeUtils;

/**
 *
 * @author Sergio Flores
 */
public class STabFilterDatePeriod extends javax.swing.JPanel {

    private erp.client.SClientInterface miClient;
    private erp.lib.table.STableTabInterface miTableTab;
    private int mnGuiDateType;

    private erp.lib.gui.SGuiDate moGuiDate;
    private erp.lib.table.STableSetting moSetting;

    /**
     * Creates new form STabFilterDatePeriod
     * @param client Client interface.
     * @param tableTab Table tab.
     * @param guiDateType GUI date type. Constants defined in erp.lib.SLibConstants.
     */
    public STabFilterDatePeriod(erp.client.SClientInterface client, erp.lib.table.STableTabInterface tableTab, int guiDateType) {
        miClient = client;
        miTableTab = tableTab;
        mnGuiDateType = guiDateType;
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

        jtfDate = new javax.swing.JTextField();
        jbDate = new javax.swing.JButton();
        jbSystemDate = new javax.swing.JButton();
        jbSystemYearMonth = new javax.swing.JButton();
        jbSystemYear = new javax.swing.JButton();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 0));

        jtfDate.setEditable(false);
        jtfDate.setText("01/01/2000");
        jtfDate.setToolTipText("Período");
        jtfDate.setFocusable(false);
        jtfDate.setPreferredSize(new java.awt.Dimension(65, 20));
        add(jtfDate);

        jbDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_cal.gif"))); // NOI18N
        jbDate.setToolTipText("Seleccionar fecha");
        jbDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDateActionPerformed(evt);
            }
        });
        add(jbDate);

        jbSystemDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_day.gif"))); // NOI18N
        jbSystemDate.setToolTipText("Hoy");
        jbSystemDate.setPreferredSize(new java.awt.Dimension(23, 23));
        jbSystemDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSystemDateActionPerformed(evt);
            }
        });
        add(jbSystemDate);

        jbSystemYearMonth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_month.gif"))); // NOI18N
        jbSystemYearMonth.setToolTipText("Mes actual");
        jbSystemYearMonth.setPreferredSize(new java.awt.Dimension(23, 23));
        jbSystemYearMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSystemYearMonthActionPerformed(evt);
            }
        });
        add(jbSystemYearMonth);

        jbSystemYear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/erp/img/cal_date_year.gif"))); // NOI18N
        jbSystemYear.setToolTipText("Año actual");
        jbSystemYear.setPreferredSize(new java.awt.Dimension(23, 23));
        jbSystemYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSystemYearActionPerformed(evt);
            }
        });
        add(jbSystemYear);
    }// </editor-fold>//GEN-END:initComponents

    private void jbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDateActionPerformed
        actionDate();
    }//GEN-LAST:event_jbDateActionPerformed

    private void jbSystemDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSystemDateActionPerformed
        moGuiDate = new SGuiDate(miClient.getSessionXXX().getWorkingDate().getTime(), SLibConstants.GUI_DATE_AS_DATE);
        moSetting.setSetting(SLibTimeUtilities.digestDate(moGuiDate));
        miTableTab.updateSetting(moSetting);
        renderDate();
}//GEN-LAST:event_jbSystemDateActionPerformed

    private void jbSystemYearMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSystemYearMonthActionPerformed
        moGuiDate = new SGuiDate(SLibTimeUtils.getEndOfMonth(miClient.getSessionXXX().getWorkingDate()).getTime(), SLibConstants.GUI_DATE_AS_YEAR_MONTH);
        moSetting.setSetting(SLibTimeUtilities.digestYearMonth(moGuiDate));
        miTableTab.updateSetting(moSetting);
        renderDate();
}//GEN-LAST:event_jbSystemYearMonthActionPerformed

    private void jbSystemYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSystemYearActionPerformed
        moGuiDate = new SGuiDate(SLibTimeUtils.getEndOfYear(miClient.getSessionXXX().getWorkingDate()).getTime(), SLibConstants.GUI_DATE_AS_YEAR);
        moSetting.setSetting(SLibTimeUtilities.digestYear(moGuiDate));
        miTableTab.updateSetting(moSetting);
        renderDate();
}//GEN-LAST:event_jbSystemYearActionPerformed

    private void initComponentsExtra() {
        moSetting = null;

        moGuiDate = new SGuiDate(miClient.getSessionXXX().getWorkingDate().getTime(), mnGuiDateType);

        switch (mnGuiDateType) {
            case SLibConstants.GUI_DATE_AS_DATE:
                moSetting = new STableSetting(STableConstants.SETTING_FILTER_PERIOD, SLibTimeUtilities.digestDate(moGuiDate));
                break;
            case SLibConstants.GUI_DATE_AS_YEAR_MONTH:
                moSetting = new STableSetting(STableConstants.SETTING_FILTER_PERIOD, SLibTimeUtilities.digestYearMonth(moGuiDate));
                break;
            case SLibConstants.GUI_DATE_AS_YEAR:
                moSetting = new STableSetting(STableConstants.SETTING_FILTER_PERIOD, SLibTimeUtilities.digestYear(moGuiDate));
                break;
            default:
                mnGuiDateType = SLibConstants.GUI_DATE_AS_DATE;
                moSetting = new STableSetting(STableConstants.SETTING_FILTER_PERIOD, SLibTimeUtilities.digestDate(moGuiDate));
                break;
        }

        miTableTab.addSetting(moSetting);
        renderDate();
    }

    private void renderDate() {
        switch (moGuiDate.getDataType()) {
            case SLibConstants.GUI_DATE_AS_DATE:
                jtfDate.setText(miClient.getSessionXXX().getFormatters().getDateFormat().format(moGuiDate));
                break;
            case SLibConstants.GUI_DATE_AS_YEAR_MONTH:
                jtfDate.setText(miClient.getSessionXXX().getFormatters().getDateYearMonthFormat().format(moGuiDate));
                break;
            case SLibConstants.GUI_DATE_AS_YEAR:
                jtfDate.setText(miClient.getSessionXXX().getFormatters().getDateYearFormat().format(moGuiDate));
                break;
            default:
                jtfDate.setText("?");
                break;
        }
    }

    private void actionDate() {
        int[] date = null;

        miClient.getGuiDatePeriodPickerXXX().formReset();
        miClient.getGuiDatePeriodPickerXXX().setDate(moGuiDate);
        miClient.getGuiDatePeriodPickerXXX().setVisible(true);

        if (miClient.getGuiDatePeriodPickerXXX().getFormResult() == SLibConstants.FORM_RESULT_OK) {
            moGuiDate = miClient.getGuiDatePeriodPickerXXX().getGuiDate();

            switch (moGuiDate.getDataType()) {
                case SLibConstants.GUI_DATE_AS_DATE:
                    date = SLibTimeUtilities.digestDate(moGuiDate);
                    break;
                case SLibConstants.GUI_DATE_AS_YEAR_MONTH:
                    date = SLibTimeUtilities.digestYearMonth(moGuiDate);
                    break;
                case SLibConstants.GUI_DATE_AS_YEAR:
                    date = SLibTimeUtilities.digestYear(moGuiDate);
                    break;
                default:
                    break;
            }

            if (date != null) {
                moSetting.setSetting(date);
                miTableTab.updateSetting(moSetting);
                renderDate();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbDate;
    private javax.swing.JButton jbSystemDate;
    private javax.swing.JButton jbSystemYear;
    private javax.swing.JButton jbSystemYearMonth;
    private javax.swing.JTextField jtfDate;
    // End of variables declaration//GEN-END:variables

    /*
     * Public methods
     */
    
    public Date getDate() {
        return moGuiDate;
    }
}
