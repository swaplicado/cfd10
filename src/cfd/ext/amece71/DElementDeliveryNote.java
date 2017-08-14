/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDeliveryNote extends cfd.DElementParent {

   protected cfd.ext.amece71.DElementDeliveryReferenceIdentification moEltReferenceIdentification;
   protected cfd.ext.amece71.DElementDeliveryReferenceDate moEltReferenceDate;

    public DElementDeliveryNote() {
        super("DeliveryNote");

        moEltReferenceIdentification = new DElementDeliveryReferenceIdentification("");
        moEltReferenceDate = new DElementDeliveryReferenceDate("");

        mvElements.add(moEltReferenceIdentification);
        mvElements.add(moEltReferenceDate);
    }

    public cfd.ext.amece71.DElementDeliveryReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }
    public cfd.ext.amece71.DElementDeliveryReferenceDate getEltReferenceDate() { return moEltReferenceDate; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
