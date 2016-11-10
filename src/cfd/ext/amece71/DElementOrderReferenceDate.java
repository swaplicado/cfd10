/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementOrderReferenceDate extends cfd.DElement {

    public DElementOrderReferenceDate(java.lang.String value) {
        super("ReferenceDate", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
