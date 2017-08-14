/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConsecutivo extends cfd.DElement {

    public DElementConsecutivo(java.lang.String value) {
        super("Consecutivo", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
