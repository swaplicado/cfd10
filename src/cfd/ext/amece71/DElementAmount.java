/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementAmount extends cfd.DElement {

    public DElementAmount(java.lang.String value) {
        super("Amount", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
