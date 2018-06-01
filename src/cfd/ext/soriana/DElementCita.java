/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCita extends cfd.DElement {

    public DElementCita(java.lang.String value) {
        super("Cita", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
