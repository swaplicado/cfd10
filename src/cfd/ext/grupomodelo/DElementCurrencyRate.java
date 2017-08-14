/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCurrencyRate extends cfd.DElement {

    public DElementCurrencyRate(java.lang.String value) {
         super("modelo:rateOfChange", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
