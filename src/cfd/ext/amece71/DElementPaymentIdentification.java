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

    protected cfd.ext.amece71.DElementEntityType moEltEntityType;
    protected cfd.ext.amece71.DElementCreatorIdentification moEltCreatorIdentification;

    public DElementPaymentIdentification() {
        super("requestForPaymentIdentification");

        moEltEntityType = new DElementEntityType("");
        moEltCreatorIdentification = new DElementCreatorIdentification("");

        mvElements.add(moEltEntityType);
        mvElements.add(moEltCreatorIdentification);
    }

    public cfd.ext.amece71.DElementEntityType getEltEntityType() { return moEltEntityType; }
    public cfd.ext.amece71.DElementCreatorIdentification getEltCreatorIdentification() { return moEltCreatorIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
