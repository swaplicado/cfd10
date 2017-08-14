/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCostoNeto extends cfd.DElement {

    public DElementCostoNeto(java.lang.String value) {
        super("CostoNetoUnidadCompra", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
