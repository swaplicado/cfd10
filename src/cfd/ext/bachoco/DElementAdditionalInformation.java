/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementAdditionalInformation extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementAdditionalReferenceIdentification moEltReferenceIdentification;

    public DElementAdditionalInformation() {
        super("AdditionalInformation");

        moEltReferenceIdentification = new DElementAdditionalReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.bachoco.DElementAdditionalReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
