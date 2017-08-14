/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementOrderIdentification extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementOrderReferenceIdentification moEltReferenceIdentification;
    protected cfd.ext.amece71.DElementOrderReferenceDate moEltReferenceDate;

    public DElementOrderIdentification() {
        super("orderIdentification");

        moEltReferenceIdentification = new DElementOrderReferenceIdentification("");
        moEltReferenceDate = new DElementOrderReferenceDate("");

        mvElements.add(moEltReferenceIdentification);
        mvElements.add(moEltReferenceDate);
    }

    public cfd.ext.amece71.DElementOrderReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }
    public cfd.ext.amece71.DElementOrderReferenceDate getEltReferenceDate() { return moEltReferenceDate; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
