/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementNumeroCaja extends cfd.DElement {

    public DElementNumeroCaja(java.lang.String value) {
        super("NumeroCajaTarima", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
