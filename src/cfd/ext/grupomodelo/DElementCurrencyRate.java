/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementCurrencyRate extends cfd.DElement {

    public DElementCurrencyRate(java.lang.String value) {
         super("modelo:rateOfChange", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
