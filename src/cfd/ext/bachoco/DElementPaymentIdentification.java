/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */

public class DElementPaymentIdentification extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementEntityType moEltEntityType;
    protected cfd.ext.bachoco.DElementCreatorIdentification moEltCreatorIdentification;

    public DElementPaymentIdentification() {
        super("requestForPaymentIdentification");

        moEltEntityType = new DElementEntityType("");
        moEltCreatorIdentification = new DElementCreatorIdentification("");

        mvElements.add(moEltEntityType);
        mvElements.add(moEltCreatorIdentification);
    }

    public cfd.ext.bachoco.DElementEntityType getEltEntityType() { return moEltEntityType; }
    public cfd.ext.bachoco.DElementCreatorIdentification getEltCreatorIdentification() { return moEltCreatorIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
