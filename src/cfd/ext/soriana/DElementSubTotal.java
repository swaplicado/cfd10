/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementSubTotal extends cfd.DElement {

    public DElementSubTotal(java.lang.String value) {
        super("Subtotal", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
