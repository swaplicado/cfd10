/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DAttributeOptionMoneda;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCurrency extends cfd.DElementParent {

    protected cfd.DAttributeOptionMoneda moAttcurrencyISOCode;
    protected cfd.ext.bachoco.DElementCurrencyFunction moEltCurrencyFunction;

    public DElementCurrency() {
        super("currency");

        moAttcurrencyISOCode = new DAttributeOptionMoneda("currencyISOCode", true);
        moEltCurrencyFunction = new DElementCurrencyFunction("");

        mvAttributes.add(moAttcurrencyISOCode);
        mvElements.add(moEltCurrencyFunction);
    }

    public cfd.DAttributeOptionMoneda getAttCurrencyISOCode() { return moAttcurrencyISOCode; }
    public cfd.ext.bachoco.DElementCurrencyFunction getEltCurrencyFunction() { return moEltCurrencyFunction; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
