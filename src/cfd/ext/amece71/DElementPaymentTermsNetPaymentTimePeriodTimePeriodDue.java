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
public class DElementPaymentTermsNetPaymentTimePeriodTimePeriodDue extends cfd.DElementParent {

    protected cfd.DAttributeString moAttTimePeriod;
    
    protected cfd.ext.amece71.DElementPaymentTermsNetPaymentTimePeriodTimePeriodDueValue moEltValue;

    public DElementPaymentTermsNetPaymentTimePeriodTimePeriodDue() {
        super("timePeriodDue");

        moAttTimePeriod = new DAttributeString("timePeriod", true);
        moAttTimePeriod.setString("DAYS");
        
        moEltValue = new DElementPaymentTermsNetPaymentTimePeriodTimePeriodDueValue("");

        mvAttributes.add(moAttTimePeriod);
        
        mvElements.add(moEltValue);
    }

    public cfd.DAttributeString getAttTimePeriod() { return moAttTimePeriod; }
    public cfd.ext.amece71.DElementPaymentTermsNetPaymentTimePeriodTimePeriodDueValue getEltValue() { return moEltValue; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
