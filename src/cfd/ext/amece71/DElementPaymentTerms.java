/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPaymentTerms extends cfd.DElementParent {

    protected cfd.DAttributeString moAttPaymentTermsRelationTime;
    protected cfd.DAttributeString moAttPaymentTermsEvent;

    protected cfd.ext.amece71.DElementPaymentTermsNetPayment moEltNetPayment;
    protected cfd.ext.amece71.DElementPaymentTermsDiscountPayment moEltDiscountPayment;

    public DElementPaymentTerms() {
        super("paymentTerms");

        moAttPaymentTermsRelationTime = new DAttributeString("PaymentTermsRelationTime", true);
        moAttPaymentTermsRelationTime.setString("REFERENCE_AFTER");
        moAttPaymentTermsEvent = new DAttributeString("paymentTermsEvent", true);
        moAttPaymentTermsEvent.setString("DATE_OF_INVOICE");

        moEltNetPayment = new DElementPaymentTermsNetPayment();
        moEltDiscountPayment = new DElementPaymentTermsDiscountPayment();

        mvAttributes.add(moAttPaymentTermsRelationTime);
        mvAttributes.add(moAttPaymentTermsEvent);

        mvElements.add(moEltNetPayment);
        //mvElements.add(moEltDiscountPayment);
    }

    public cfd.DAttributeString getAttPaymentTermsRelationTime() { return moAttPaymentTermsRelationTime; }
    public cfd.DAttributeString getAttPaymentTermsEvent() { return moAttPaymentTermsEvent; }
    
    public cfd.ext.amece71.DElementPaymentTermsNetPayment getEltNetPayment() { return moEltNetPayment; }
    public cfd.ext.amece71.DElementPaymentTermsDiscountPayment getEltDiscountPayment() { return moEltDiscountPayment; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
