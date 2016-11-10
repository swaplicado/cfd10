/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementShiptoName extends cfd.DElement {

    public DElementShiptoName(java.lang.String value) {
        super("name", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
