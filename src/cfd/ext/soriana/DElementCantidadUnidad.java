/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementCantidadUnidad extends cfd.DElement {

    public DElementCantidadUnidad(java.lang.String value) {
        super("CantidadUnidadCompra", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
