/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementSucursal extends cfd.DElement {

    public DElementSucursal(java.lang.String value) {
        super("SucursalDistribuir", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
