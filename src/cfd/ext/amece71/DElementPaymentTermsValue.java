/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementPaymentTermsValue extends cfd.DElement {

    public DElementPaymentTermsValue(java.lang.String value) {
        super("value", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
