/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementPaymentTermsPercentage extends cfd.DElement {

    public DElementPaymentTermsPercentage(java.lang.String value) {
        super("percentage", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
