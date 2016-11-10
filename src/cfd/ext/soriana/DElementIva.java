/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementIva extends cfd.DElement {

    public DElementIva(java.lang.String value) {
        super("IVA", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
