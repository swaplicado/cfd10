/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDeliveryNote extends cfd.DElementParent {

   protected cfd.ext.bachoco.DElementDeliveryReferenceIdentification moEltReferenceIdentification;

    public DElementDeliveryNote() {
        super("DeliveryNote");

        moEltReferenceIdentification = new DElementDeliveryReferenceIdentification("");

        mvElements.add(moEltReferenceIdentification);
    }

    public cfd.ext.bachoco.DElementDeliveryReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
