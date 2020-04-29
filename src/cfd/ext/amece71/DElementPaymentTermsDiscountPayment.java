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
public class DElementPaymentTermsDiscountPayment extends cfd.DElementParent {

    protected cfd.DAttributeString moAttDiscountType;
    
    protected cfd.ext.amece71.DElementPaymentTermsPercentage moEltPercentage;

    public DElementPaymentTermsDiscountPayment() {
        super("discountPayment");

        moAttDiscountType = new DAttributeString("discountType", true);
        
        moEltPercentage = new DElementPaymentTermsPercentage("");

        mvAttributes.add(moAttDiscountType);
        
        mvElements.add(moEltPercentage);
    }

    public cfd.DAttributeString getAttDiscountType() { return moAttDiscountType; }
    public cfd.ext.amece71.DElementPaymentTermsPercentage getEltPercentage() { return moEltPercentage; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
