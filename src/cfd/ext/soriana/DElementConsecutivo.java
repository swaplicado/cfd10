/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementConsecutivo extends cfd.DElement {

    public DElementConsecutivo(java.lang.String value) {
        super("Consecutivo", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
