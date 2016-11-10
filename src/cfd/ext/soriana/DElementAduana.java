/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementAduana extends cfd.DElement {

    public DElementAduana(java.lang.String value) {
        super("Aduana", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
