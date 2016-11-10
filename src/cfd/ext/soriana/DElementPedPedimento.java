/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementPedPedimento extends cfd.DElement {

    public DElementPedPedimento(java.lang.String value) {
        super("Pedimento", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
