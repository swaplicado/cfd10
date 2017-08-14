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
public class DElementPaymentTermsTime extends cfd.DElementParent {

    protected cfd.DAttributeString moAttTimePeriod;
    protected cfd.ext.amece71.DElementPaymentTermsValue moEltValue;

    public DElementPaymentTermsTime() {
        super("timePeriodDue");

        moAttTimePeriod = new DAttributeString("timePeriod", true);
        moEltValue = new DElementPaymentTermsValue("");

        mvAttributes.add(moAttTimePeriod);
        mvElements.add(moEltValue);
    }

    public cfd.DAttributeString getAttTimePeriod() { return moAttTimePeriod; }
    public cfd.ext.amece71.DElementPaymentTermsValue getEltValue() { return moEltValue; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
