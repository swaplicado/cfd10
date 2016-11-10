/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeOptionMoneda;

/**
 *
 * @author Juan Barajas
 */
public class DElementCurrency extends cfd.DElementParent {

    protected cfd.DAttributeOptionMoneda moAttcurrencyISOCode;
    protected cfd.ext.grupomodelo.DElementCurrencyFunction moEltCurrencyFunction;
    protected cfd.ext.grupomodelo.DElementCurrencyRate moEltCurrencyRate;

    public DElementCurrency() {
        super("modelo:currency");

        moAttcurrencyISOCode = new DAttributeOptionMoneda("currencyISOCode", true);
        moEltCurrencyFunction = new DElementCurrencyFunction("");
        moEltCurrencyRate = new DElementCurrencyRate("");

        mvAttributes.add(moAttcurrencyISOCode);
        mvElements.add(moEltCurrencyFunction);
        mvElements.add(moEltCurrencyRate);
    }

    public cfd.DAttributeOptionMoneda getAttCurrencyISOCode() { return moAttcurrencyISOCode; }
    public cfd.ext.grupomodelo.DElementCurrencyFunction getEltCurrencyFunction() { return moEltCurrencyFunction; }
    public cfd.ext.grupomodelo.DElementCurrencyRate getEltCurrencyRate() { return moEltCurrencyRate; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
