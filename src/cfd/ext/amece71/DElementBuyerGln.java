/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementBuyerGln extends cfd.DElement {

    public DElementBuyerGln(java.lang.String value) {
        super("gln", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
