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

   protected cfd.ext.amece71.DElementDeliveryNoteReferenceIdentification moEltReferenceIdentification;
   protected cfd.ext.amece71.DElementDeliveryNoteReferenceDate moEltReferenceDate;

    public DElementDeliveryNote() {
        super("DeliveryNote");

        moEltReferenceIdentification = new DElementDeliveryNoteReferenceIdentification("");
        moEltReferenceDate = new DElementDeliveryNoteReferenceDate("");

        mvElements.add(moEltReferenceIdentification);
        mvElements.add(moEltReferenceDate);
    }

    public cfd.ext.amece71.DElementDeliveryNoteReferenceIdentification getEltReferenceIdentification() { return moEltReferenceIdentification; }
    public cfd.ext.amece71.DElementDeliveryNoteReferenceDate getEltReferenceDate() { return moEltReferenceDate; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
