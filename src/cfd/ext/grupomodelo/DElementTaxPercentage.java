/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementTaxPercentage extends cfd.DElement {

    public DElementTaxPercentage(java.lang.String value) {
        super("modelo:taxPercentage", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
