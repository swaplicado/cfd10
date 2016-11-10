/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementCodigo extends cfd.DElement {

    public DElementCodigo(java.lang.String value) {
        super("Codigo", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
