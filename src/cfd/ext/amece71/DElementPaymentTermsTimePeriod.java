/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementPaymentTermsTimePeriod extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementPaymentTermsTime moEltTimePeriodDue;

    public DElementPaymentTermsTimePeriod() {
        super("paymentTimePeriod");

        moEltTimePeriodDue = new DElementPaymentTermsTime();

        mvElements.add(moEltTimePeriodDue);
    }

    public cfd.ext.amece71.DElementPaymentTermsTime getEltTimePeriodDue() { return moEltTimePeriodDue; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
