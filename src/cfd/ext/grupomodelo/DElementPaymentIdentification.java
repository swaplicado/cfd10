/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */

public class DElementPaymentIdentification extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementEntityType moEltEntityType;
    protected cfd.ext.grupomodelo.DElementCreatorIdentification moEltCreatorIdentification;

    public DElementPaymentIdentification() {
        super("modelo:requestForPaymentIdentification");

        moEltEntityType = new DElementEntityType("");
        moEltCreatorIdentification = new DElementCreatorIdentification("");

        mvElements.add(moEltEntityType);
        mvElements.add(moEltCreatorIdentification);
    }

    public cfd.ext.grupomodelo.DElementEntityType getEltEntityType() { return moEltEntityType; }
    public cfd.ext.grupomodelo.DElementCreatorIdentification getEltCreatorIdentification() { return moEltCreatorIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
