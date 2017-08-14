/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementOrderIdentification extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementOrderReferenceIdentification moEltReferenceIdentification;
    protected cfd.ext.grupomodelo.DElementOrderReferenceDate moEltReferenceDate;

    public DElementOrderIdentification() {
        super("modelo:orderIdentification");

        moEltReferenceIdentification = new DElementOrderReferenceIdentification("");
        moEltReferenceDate = new DElementOrderReferenceDate("");

        mvElements.add(moEltReferenceIdentification);
        mvElements.add(moEltReferenceDate);
    }

    public cfd.ext.grupomodelo.DElementOrderReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }
    public cfd.ext.grupomodelo.DElementOrderReferenceDate getEltReferenceDate() { return moEltReferenceDate; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
