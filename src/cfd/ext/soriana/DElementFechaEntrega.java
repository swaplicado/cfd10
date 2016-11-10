/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementFechaEntrega extends cfd.DElement {

    public DElementFechaEntrega(java.lang.String value) {
        super("FechaEntregaMercancia", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
