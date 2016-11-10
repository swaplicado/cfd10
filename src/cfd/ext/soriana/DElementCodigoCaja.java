/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementCodigoCaja extends cfd.DElement {

    public DElementCodigoCaja(java.lang.String value) {
        super("CodigoBarraCajaTarima", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
