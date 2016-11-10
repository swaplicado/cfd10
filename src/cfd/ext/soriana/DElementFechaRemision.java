/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementFechaRemision extends cfd.DElement {

    public DElementFechaRemision(java.lang.String value) {
        super("FechaRemision", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
