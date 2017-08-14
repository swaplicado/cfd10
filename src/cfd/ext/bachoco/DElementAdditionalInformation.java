/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
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
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
