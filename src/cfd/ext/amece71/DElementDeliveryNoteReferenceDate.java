/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDeliveryNoteReferenceDate extends cfd.DElement {

    public DElementDeliveryNoteReferenceDate(java.lang.String value) {
        super("ReferenceDate", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
