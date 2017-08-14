/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDeliveryNote extends cfd.DElementParent {

   protected cfd.ext.grupomodelo.DElementDeliveryReferenceIdentification moEltReferenceIdentification;

    public DElementDeliveryNote() {
        super("DeliveryNote");

        moEltReferenceIdentification = new DElementDeliveryReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.grupomodelo.DElementDeliveryReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
