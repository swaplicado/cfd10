/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */

public class DElementPaymentIdentification extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementPaymentEntityType moEltEntityType;
    protected cfd.ext.amece71.DElementPaymentUniqueCreatorIdentification moEltUniqueCreatorIdentification;

    public DElementPaymentIdentification() {
        super("requestForPaymentIdentification");

        moEltEntityType = new DElementPaymentEntityType("");
        moEltUniqueCreatorIdentification = new DElementPaymentUniqueCreatorIdentification("");

        mvElements.add(moEltEntityType);
        mvElements.add(moEltUniqueCreatorIdentification);
    }

    public cfd.ext.amece71.DElementPaymentEntityType getEltEntityType() { return moEltEntityType; }
    public cfd.ext.amece71.DElementPaymentUniqueCreatorIdentification getEltUniqueCreatorIdentification() { return moEltUniqueCreatorIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
