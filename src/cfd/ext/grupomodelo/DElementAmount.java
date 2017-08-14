/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAmount extends cfd.DElement {

    public DElementAmount(java.lang.String value) {
        super("modelo:Amount", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
