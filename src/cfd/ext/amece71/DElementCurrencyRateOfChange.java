/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCurrencyRateOfChange extends cfd.DElement {

    public DElementCurrencyRateOfChange(java.lang.String value) {
         super("rateOfChange", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
