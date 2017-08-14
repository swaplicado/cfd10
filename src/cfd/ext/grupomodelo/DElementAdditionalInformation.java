/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAdditionalInformation extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementAdditionalReferenceIdentification moEltReferenceIdentification;

    public DElementAdditionalInformation() {
        super("modelo:AdditionalInformation");

        moEltReferenceIdentification = new DElementAdditionalReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.grupomodelo.DElementAdditionalReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
