/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAdditionalInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementAdditionalInformationReferenceIdentification moEltReferenceIdentification;

    public DElementAdditionalInformation() {
        super("AdditionalInformation");

        moEltReferenceIdentification = new DElementAdditionalInformationReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.amece71.DElementAdditionalInformationReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
