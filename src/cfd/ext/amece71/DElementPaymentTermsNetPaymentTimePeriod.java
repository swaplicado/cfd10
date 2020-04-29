/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPaymentTermsNetPaymentTimePeriod extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementPaymentTermsNetPaymentTimePeriodTimePeriodDue moEltTimePeriodDue;

    public DElementPaymentTermsNetPaymentTimePeriod() {
        super("paymentTimePeriod");

        moEltTimePeriodDue = new DElementPaymentTermsNetPaymentTimePeriodTimePeriodDue();

        mvElements.add(moEltTimePeriodDue);
    }

    public cfd.ext.amece71.DElementPaymentTermsNetPaymentTimePeriodTimePeriodDue getEltTimePeriodDue() { return moEltTimePeriodDue; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
