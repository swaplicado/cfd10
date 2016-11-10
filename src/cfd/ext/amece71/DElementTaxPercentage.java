/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementTaxPercentage extends cfd.DElement {

    public DElementTaxPercentage(java.lang.String value) {
        super("taxPercentage", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
