/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
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
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
