/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.db;

import java.util.Date;

/**
 *
 * @author Juan Barajas, Sergio Flores
 */
public final class SHrsBenefitParams {

    private final SDbEarning moEarning;
    private final SDbBenefitTable moBenefitTable;
    private final SDbBenefitTable moBenefitTableAux;
    private final SHrsPayrollReceipt moHrsPayrollReceipt;
    private final Date mtDateCutOff;

    public SHrsBenefitParams(SDbEarning earning, SDbBenefitTable benefit, SDbBenefitTable benefitAux, SHrsPayrollReceipt hrsPayrollReceipt, Date dateCutOff) {
        moEarning = earning;
        moBenefitTable = benefit;
        moBenefitTableAux = benefitAux;
        moHrsPayrollReceipt = hrsPayrollReceipt;
        mtDateCutOff = dateCutOff;
    }

    public SDbEarning getEarning() { return moEarning; }
    public SDbBenefitTable getBenefitTable() { return moBenefitTable; }
    public SDbBenefitTable getBenefitTableAux() { return moBenefitTableAux; }
    public SHrsPayrollReceipt getHrsPayrollReceipt() { return moHrsPayrollReceipt; }
    public Date getDateCutOff() { return mtDateCutOff; }
}
