/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementGtin extends cfd.DElement {

    public DElementGtin(java.lang.String value) {
        super("gtin", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
