/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCustomsPostalCode extends cfd.DElement {

    public DElementCustomsPostalCode(java.lang.String value) {
        super("postalCode", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
