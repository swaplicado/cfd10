/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementCustoms extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementCustomsPartyIdentification moEltPartyIdentification;

    public DElementCustoms() {
        super("Customs");

        moEltPartyIdentification = new DElementCustomsPartyIdentification("");

        mvElements.add(moEltPartyIdentification);
    }

    public cfd.ext.bachoco.DElementCustomsPartyIdentification getEltAlternatePartyIdentification() { return moEltPartyIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
