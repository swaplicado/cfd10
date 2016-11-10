/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementCustoms extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementCustomsPartyIdentification moEltPartyIdentification;

    public DElementCustoms() {
        super("Customs");

        moEltPartyIdentification = new DElementCustomsPartyIdentification("");

        mvElements.add(moEltPartyIdentification);
    }

    public cfd.ext.grupomodelo.DElementCustomsPartyIdentification getEltAlternatePartyIdentification() { return moEltPartyIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
