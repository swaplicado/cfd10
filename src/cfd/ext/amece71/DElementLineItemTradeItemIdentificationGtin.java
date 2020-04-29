/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementLineItemTradeItemIdentificationGtin extends cfd.DElement {

    public DElementLineItemTradeItemIdentificationGtin(java.lang.String value) {
        super("gtin", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
