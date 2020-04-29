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

    protected cfd.DAttributeString moAttPaymentTermsEvent;
    protected cfd.DAttributeString moAttPaymentTermsRelationTime;

    protected cfd.ext.amece71.DElementPaymentTermsNetPayment moEltNetPayment;
    protected cfd.ext.amece71.DElementPaymentTermsDiscountPayment moEltDiscountPayment;

    public DElementPaymentTerms() {
        super("paymentTerms");

        moAttPaymentTermsEvent = new DAttributeString("paymentTermsEvent", true);
        moAttPaymentTermsEvent.setString("DATE_OF_INVOICE");
        moAttPaymentTermsRelationTime = new DAttributeString("PaymentTermsRelationTime", true);
        moAttPaymentTermsRelationTime.setString("REFERENCE_AFTER");

        moEltNetPayment = new DElementPaymentTermsNetPayment();
        moEltDiscountPayment = new DElementPaymentTermsDiscountPayment();

        mvAttributes.add(moAttPaymentTermsEvent);
        mvAttributes.add(moAttPaymentTermsRelationTime);

        mvElements.add(moEltNetPayment);
        mvElements.add(moEltDiscountPayment);
    }

    public cfd.DAttributeString getAttPaymentTermsEvent() { return moAttPaymentTermsEvent; }
    public cfd.DAttributeString getAttPaymentTermsRelationTime() { return moAttPaymentTermsRelationTime; }
    
    public cfd.ext.amece71.DElementPaymentTermsNetPayment getEltNetPayment() { return moEltNetPayment; }
    public cfd.ext.amece71.DElementPaymentTermsDiscountPayment getEltDiscountPayment() { return moEltDiscountPayment; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
