/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementOrderIdentification extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementOrderReferenceIdentification moEltReferenceIdentification;

    public DElementOrderIdentification() {
        super("orderIdentification");

        moEltReferenceIdentification = new DElementOrderReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.bachoco.DElementOrderReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
