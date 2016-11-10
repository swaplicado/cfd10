/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementOtrosImpuestos extends cfd.DElement {

    public DElementOtrosImpuestos(java.lang.String value) {
        super("OtrosImpuestos", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
