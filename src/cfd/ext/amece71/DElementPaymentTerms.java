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
    protected cfd.ext.amece71.DElementPaymentTermsDiscountPayment moEltOpcDiscountPayment;

    public DElementPaymentTerms() {
        super("paymentTerms");

        moAttPaymentTermsEvent = new DAttributeString("paymentTermsEvent", true);
        moAttPaymentTermsEvent.setString("DATE_OF_INVOICE");
        moAttPaymentTermsRelationTime = new DAttributeString("PaymentTermsRelationTime", true);
        moAttPaymentTermsRelationTime.setString("REFERENCE_AFTER");

        moEltNetPayment = new DElementPaymentTermsNetPayment();
        //moEltOpcDiscountPayment = new DElementPaymentTermsDiscountPayment(); // wait to instantiate optional element until needed

        mvAttributes.add(moAttPaymentTermsEvent);
        mvAttributes.add(moAttPaymentTermsRelationTime);

        mvElements.add(moEltNetPayment);
        //mvElements.add(moEltOpcDiscountPayment); // wait to add optional element until needed
    }
    
    protected void setEltOpcDiscountPayment(cfd.ext.amece71.DElementPaymentTermsDiscountPayment o) {
        boolean elementAlreadySet = moEltOpcDiscountPayment != null && mvElements.contains(moEltOpcDiscountPayment); // convenience variable
        
        if (o == null) {
            // "remove" element
            if (elementAlreadySet) {
                mvElements.remove(moEltOpcDiscountPayment);
            }
        }
        else {
            // set element
            if (elementAlreadySet) {
                mvElements.set(mvElements.indexOf(moEltOpcDiscountPayment), o); // reset element if already exists
            }
            else {
                mvElements.add(o); // set element
            }
        }
        
        moEltOpcDiscountPayment = o; // update member no matter if element was "removed" or set
    }

    public cfd.DAttributeString getAttPaymentTermsEvent() { return moAttPaymentTermsEvent; }
    public cfd.DAttributeString getAttPaymentTermsRelationTime() { return moAttPaymentTermsRelationTime; }
    
    public cfd.ext.amece71.DElementPaymentTermsNetPayment getEltNetPayment() { return moEltNetPayment; }
    public cfd.ext.amece71.DElementPaymentTermsDiscountPayment getEltOpcDiscountPayment() { return moEltOpcDiscountPayment; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
