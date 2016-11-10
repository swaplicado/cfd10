/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementShiptoPostalCode extends cfd.DElement {

    public DElementShiptoPostalCode(java.lang.String value) {
        super("postalCode", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
