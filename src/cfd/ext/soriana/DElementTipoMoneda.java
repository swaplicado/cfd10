/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementTipoMoneda extends cfd.DElement {

    public DElementTipoMoneda(java.lang.String value) {
        super("TipoMoneda", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
