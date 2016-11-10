/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementAdditionalInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementAdditionalReferenceIdentification moEltReferenceIdentification;

    public DElementAdditionalInformation() {
        super("AdditionalInformation");

        moEltReferenceIdentification = new DElementAdditionalReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.amece71.DElementAdditionalReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
