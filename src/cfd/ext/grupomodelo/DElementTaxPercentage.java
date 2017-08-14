/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTaxPercentage extends cfd.DElement {

    public DElementTaxPercentage(java.lang.String value) {
        super("modelo:taxPercentage", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
