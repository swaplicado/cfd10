/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementFechaPedimento extends cfd.DElement {

    public DElementFechaPedimento(java.lang.String value) {
        super("FechaPedimento", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
