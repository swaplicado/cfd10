/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementPaymentTermsNetPayment extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;
    protected cfd.ext.amece71.DElementPaymentTermsTimePeriod moEltTimePeriod;

    public DElementPaymentTermsNetPayment() {
        super("netPayment");

        moAttType = new DAttributeString("netPaymentTermsType", true);
        moEltTimePeriod = new DElementPaymentTermsTimePeriod();

        mvElements.add(moEltTimePeriod);

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttTimePeriod() { return moAttType; }
    public cfd.ext.amece71.DElementPaymentTermsTimePeriod getEltTimePeriod() { return moEltTimePeriod; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
