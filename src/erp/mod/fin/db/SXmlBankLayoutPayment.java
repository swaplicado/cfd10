/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package erp.mod.fin.db;

import sa.lib.xml.SXmlAttribute;
import sa.lib.xml.SXmlElement;

/**
 *
 * @author Juan Barajas, Alfredo Pérez, Sergio Flores
 */
public class SXmlBankLayoutPayment extends SXmlElement {

    public static final String NAME = "Pay";
    public static final String ATT_LAY_PAY_AMT = "PayAmount";
    public static final String ATT_LAY_PAY_AMT_CY = "PayAmountCy";
    public static final String ATT_LAY_PAY_CUR = "PayCurrency";
    public static final String ATT_LAY_PAY_EXR = "PayExchangeRate";
    public static final String ATT_LAY_PAY_AGREE = "Agreement";
    public static final String ATT_LAY_PAY_AGREE_REF = "AgreementReference";
    public static final String ATT_LAY_PAY_AGREE_CON = "ConceptCie";
    public static final String ATT_LAY_PAY_REF_ALPHA = "PayReferenceAlpha";
    public static final String ATT_LAY_PAY_CON = "PayConcept";
    public static final String ATT_LAY_PAY_HSBC_FIS_VOU = "HsbcFiscalVoucher";
    public static final String ATT_LAY_PAY_HSBC_ACC_TP = "HsbcAccountType";
    public static final String ATT_LAY_PAY_HSBC_BANK_CODE = "HsbcBankCode";
    public static final String ATT_LAY_PAY_HSBC_FIS_ID_DBT = "HsbcFiscalIdDebit";
    public static final String ATT_LAY_PAY_HSBC_FIS_ID_CRD = "HsbcFiscalIdCredit";
    public static final String ATT_LAY_PAY_HSBC_DESCRIP = "HsbcDescription";
    public static final String ATT_LAY_PAY_SANT_BANK_CODE = "SantBankCode";
    public static final String ATT_LAY_PAY_BAJIO_BANK_CODE = "BajioBankCode";
    public static final String ATT_LAY_PAY_BAJIO_NICK = "BajioNick";
    public static final String ATT_LAY_PAY_BANK_KEY = "BankKey";
    public static final String ATT_LAY_PAY_APPLIED = "PayApplied";
    public static final String ATT_LAY_PAY_BP = "PayBizPartnertId";
    public static final String ATT_LAY_PAY_BANK_BPB = "PayBankBizPartnertId";
    public static final String ATT_LAY_PAY_BANK_BANK = "PayBankBankId";
    public static final String ATT_LAY_PAY_REC_YEAR = "PayRecordYearId";
    public static final String ATT_LAY_PAY_REC_PER = "PayRecordPeriodId";
    public static final String ATT_LAY_PAY_REC_BKC = "PayRecordBkcId";
    public static final String ATT_LAY_PAY_REC_REC_TP = "PayRecordRecordTypeId";
    public static final String ATT_LAY_PAY_REC_NUM = "PayRecordNumberId";
    public static final String ATT_LAY_PAY_BKK_YEAR = "PayBkkYearId";
    public static final String ATT_LAY_PAY_BKK_NUM = "PayBkkNumberId";
    public static final String ATT_LAY_ROW_REF_REC = "ReferenceRecord";

    protected SXmlAttribute moPayAmount;
    protected SXmlAttribute moPayAmountCy;
    protected SXmlAttribute moPayCurrency;
    protected SXmlAttribute moPayExchangeRate;
    protected SXmlAttribute moAgreement;
    protected SXmlAttribute moAgreementReference;
    protected SXmlAttribute moAgreementConceptCie;
    protected SXmlAttribute moPayReferenceAlpha;
    protected SXmlAttribute moPayConcept;
    protected SXmlAttribute moPayHsbcFiscalVoucher;
    protected SXmlAttribute moPayHsbcAccountType;
    protected SXmlAttribute moPayHsbcBankCode;
    protected SXmlAttribute moPayHsbcFiscalIdDebit;
    protected SXmlAttribute moPayHsbcFiscalIdCredit;
    protected SXmlAttribute moPayHsbcDescription;
    protected SXmlAttribute moPaySantBankCode;
    protected SXmlAttribute moPayBajioBankCode;
    protected SXmlAttribute moPayBajioNick;
    protected SXmlAttribute moPayBankKey;
    protected SXmlAttribute moPayApplied;
    protected SXmlAttribute moPayBizPartnertId;
    protected SXmlAttribute moPayBankBizPartnertId;
    protected SXmlAttribute moPayBankBankId;
    protected SXmlAttribute moPayRecordYearId;
    protected SXmlAttribute moPayRecordPeriodId;
    protected SXmlAttribute moPayRecordBkcId;
    protected SXmlAttribute moPayRecordRecordTypeId;
    protected SXmlAttribute moPayRecordNumberId;
    protected SXmlAttribute moPayBkkYearId;
    protected SXmlAttribute moPayBkkNumberId;
    protected SXmlAttribute moRowReferenceRecord;

    public SXmlBankLayoutPayment() {
        super(NAME);

        moPayAmount = new SXmlAttribute(ATT_LAY_PAY_AMT);
        moPayAmountCy = new SXmlAttribute(ATT_LAY_PAY_AMT_CY);
        moPayCurrency = new SXmlAttribute(ATT_LAY_PAY_CUR);
        moPayExchangeRate = new SXmlAttribute(ATT_LAY_PAY_EXR);
        moAgreement = new SXmlAttribute(ATT_LAY_PAY_AGREE);
        moAgreementReference = new SXmlAttribute(ATT_LAY_PAY_AGREE_REF);
        moAgreementConceptCie = new SXmlAttribute(ATT_LAY_PAY_AGREE_CON);
        moPayReferenceAlpha = new SXmlAttribute(ATT_LAY_PAY_REF_ALPHA);
        moPayConcept = new SXmlAttribute(ATT_LAY_PAY_CON);
        moPayHsbcFiscalVoucher = new SXmlAttribute(ATT_LAY_PAY_HSBC_FIS_VOU);
        moPayHsbcAccountType = new SXmlAttribute(ATT_LAY_PAY_HSBC_ACC_TP);
        moPayHsbcBankCode = new SXmlAttribute(ATT_LAY_PAY_HSBC_BANK_CODE);
        moPayHsbcFiscalIdDebit = new SXmlAttribute(ATT_LAY_PAY_HSBC_FIS_ID_DBT);
        moPayHsbcFiscalIdCredit = new SXmlAttribute(ATT_LAY_PAY_HSBC_FIS_ID_CRD);
        moPayHsbcDescription = new SXmlAttribute(ATT_LAY_PAY_HSBC_DESCRIP);
        moPaySantBankCode = new SXmlAttribute(ATT_LAY_PAY_SANT_BANK_CODE);
        moPayBajioBankCode = new SXmlAttribute(ATT_LAY_PAY_BAJIO_BANK_CODE);
        moPayBajioNick = new SXmlAttribute(ATT_LAY_PAY_BAJIO_NICK);
        moPayBankKey = new SXmlAttribute(ATT_LAY_PAY_BANK_KEY);
        moPayApplied = new SXmlAttribute(ATT_LAY_PAY_APPLIED);
        moPayBizPartnertId = new SXmlAttribute(ATT_LAY_PAY_BP);
        moPayBankBizPartnertId = new SXmlAttribute(ATT_LAY_PAY_BANK_BPB);
        moPayBankBankId = new SXmlAttribute(ATT_LAY_PAY_BANK_BANK);
        moPayRecordYearId = new SXmlAttribute(ATT_LAY_PAY_REC_YEAR);
        moPayRecordPeriodId = new SXmlAttribute(ATT_LAY_PAY_REC_PER);
        moPayRecordBkcId = new SXmlAttribute(ATT_LAY_PAY_REC_BKC);
        moPayRecordRecordTypeId = new SXmlAttribute(ATT_LAY_PAY_REC_REC_TP);
        moPayRecordNumberId = new SXmlAttribute(ATT_LAY_PAY_REC_NUM);
        moPayBkkYearId = new SXmlAttribute(ATT_LAY_PAY_BKK_YEAR);
        moPayBkkNumberId = new SXmlAttribute(ATT_LAY_PAY_BKK_NUM);
        moRowReferenceRecord = new SXmlAttribute(ATT_LAY_ROW_REF_REC);

        mvXmlAttributes.add(moPayReferenceAlpha);
        mvXmlAttributes.add(moPayConcept);
        mvXmlAttributes.add(moPayAmount);
        mvXmlAttributes.add(moPayAmountCy);
        mvXmlAttributes.add(moPayCurrency);
        mvXmlAttributes.add(moAgreement);
        mvXmlAttributes.add(moAgreementReference);
        mvXmlAttributes.add(moAgreementConceptCie);
        mvXmlAttributes.add(moPayExchangeRate);
        mvXmlAttributes.add(moPayHsbcFiscalVoucher);
        mvXmlAttributes.add(moPayHsbcAccountType);
        mvXmlAttributes.add(moPayHsbcBankCode);
        mvXmlAttributes.add(moPayHsbcFiscalIdDebit);
        mvXmlAttributes.add(moPayHsbcFiscalIdCredit);
        mvXmlAttributes.add(moPayHsbcDescription);
        mvXmlAttributes.add(moPaySantBankCode);
        mvXmlAttributes.add(moPayBajioBankCode);
        mvXmlAttributes.add(moPayBajioNick);
        mvXmlAttributes.add(moPayBankKey);
        mvXmlAttributes.add(moPayApplied);
        mvXmlAttributes.add(moPayBizPartnertId);
        mvXmlAttributes.add(moPayBankBizPartnertId);
        mvXmlAttributes.add(moPayBankBankId);
        mvXmlAttributes.add(moPayRecordYearId);
        mvXmlAttributes.add(moPayRecordPeriodId);
        mvXmlAttributes.add(moPayRecordBkcId);
        mvXmlAttributes.add(moPayRecordRecordTypeId);
        mvXmlAttributes.add(moPayRecordNumberId);
        mvXmlAttributes.add(moPayBkkYearId);
        mvXmlAttributes.add(moPayBkkNumberId);
        mvXmlAttributes.add(moRowReferenceRecord);
    }
}
