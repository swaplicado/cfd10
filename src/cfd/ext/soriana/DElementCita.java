/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementCita extends cfd.DElement {

    public DElementCita(java.lang.String value) {
        super("Citas", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
