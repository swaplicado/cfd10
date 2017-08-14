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

    protected cfd.DAttributeString moAttType;
    protected cfd.ext.amece71.DElementPaymentTermsPercentage moEltPercentage;

    public DElementPaymentTermsDiscountPayment() {
        super("discountPayment");

        moAttType = new DAttributeString("discountType", true);
        moEltPercentage = new DElementPaymentTermsPercentage("");

        mvAttributes.add(moAttType);
        mvElements.add(moEltPercentage);
    }

    public cfd.DAttributeString getAttTimePeriod() { return moAttType; }
    public cfd.ext.amece71.DElementPaymentTermsPercentage getEltPercentage() { return moEltPercentage; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
