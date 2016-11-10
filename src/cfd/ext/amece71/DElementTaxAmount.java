/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementTaxAmount extends cfd.DElement {

    public DElementTaxAmount(java.lang.String value) {
        super("taxAmount", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
