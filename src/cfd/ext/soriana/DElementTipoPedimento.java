/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementTipoPedimento extends cfd.DElement {

    public DElementTipoPedimento(java.lang.String value) {
        super("TipoPedimento", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
