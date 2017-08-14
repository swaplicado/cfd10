/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementOtrosImpuestos extends cfd.DElement {

    public DElementOtrosImpuestos(java.lang.String value) {
        super("OtrosImpuestos", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
