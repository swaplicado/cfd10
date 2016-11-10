/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementDeliveryReferenceDate extends cfd.DElement {

    public DElementDeliveryReferenceDate(java.lang.String value) {
        super("ReferenceDate", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
