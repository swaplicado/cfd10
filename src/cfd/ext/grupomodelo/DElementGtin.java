/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementGtin extends cfd.DElement {

    public DElementGtin(java.lang.String value) {
        super("modelo:gtin", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
