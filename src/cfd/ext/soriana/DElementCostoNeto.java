/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementCostoNeto extends cfd.DElement {

    public DElementCostoNeto(java.lang.String value) {
        super("CostoNetoUnidadCompra", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
