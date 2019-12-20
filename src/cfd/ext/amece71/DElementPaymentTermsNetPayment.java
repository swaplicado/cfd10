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
public class DElementPaymentTermsNetPayment extends cfd.DElementParent {

    protected cfd.DAttributeString moAttNetPaymentTermsType;
    protected cfd.ext.amece71.DElementPaymentTermsTimePeriod moEltTimePeriod;

    public DElementPaymentTermsNetPayment() {
        super("netPayment");

        moAttNetPaymentTermsType = new DAttributeString("netPaymentTermsType", true);
        moAttNetPaymentTermsType.setString("BASIC_NET");
        moEltTimePeriod = new DElementPaymentTermsTimePeriod();

        mvElements.add(moEltTimePeriod);

        mvAttributes.add(moAttNetPaymentTermsType);
    }

    public cfd.DAttributeString getAttNetPaymentTermsType() { return moAttNetPaymentTermsType; }
    public cfd.ext.amece71.DElementPaymentTermsTimePeriod getEltTimePeriod() { return moEltTimePeriod; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
