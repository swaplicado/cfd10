/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DAttributeOptionMoneda;

/**
 *
 * @author Juan Barajas
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
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
