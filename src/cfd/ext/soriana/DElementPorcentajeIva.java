/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementPorcentajeIva extends cfd.DElement {

    public DElementPorcentajeIva(java.lang.String value) {
        super("PorcentajeIVA", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
