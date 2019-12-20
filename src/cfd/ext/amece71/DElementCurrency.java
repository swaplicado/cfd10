/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttributeOptionMoneda;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCurrency extends cfd.DElementParent {

    protected cfd.DAttributeOptionMoneda moAttcurrencyISOCode;
    
    protected cfd.ext.amece71.DElementCurrencyFunction moEltCurrencyFunction;
    protected cfd.ext.amece71.DElementCurrencyRate moEltRateOfChange;

    public DElementCurrency() {
        super("currency");

        moAttcurrencyISOCode = new DAttributeOptionMoneda("currencyISOCode", true);
        
        moEltCurrencyFunction = new DElementCurrencyFunction("");
        moEltRateOfChange = new DElementCurrencyRate("");

        mvAttributes.add(moAttcurrencyISOCode);
        
        mvElements.add(moEltCurrencyFunction);
        mvElements.add(moEltRateOfChange);
    }

    public cfd.DAttributeOptionMoneda getAttCurrencyISOCode() { return moAttcurrencyISOCode; }
    
    public cfd.ext.amece71.DElementCurrencyFunction getEltCurrencyFunction() { return moEltCurrencyFunction; }
    public cfd.ext.amece71.DElementCurrencyRate getEltRateOfChange() { return moEltRateOfChange; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
