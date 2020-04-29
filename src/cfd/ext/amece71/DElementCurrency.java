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

    protected cfd.DAttributeOptionMoneda moAttCurrencyIsoCode;
    
    protected cfd.ext.amece71.DElementCurrencyFunction moEltCurrencyFunction;
    protected cfd.ext.amece71.DElementCurrencyRateOfChange moEltRateOfChange;

    public DElementCurrency() {
        super("currency");

        moAttCurrencyIsoCode = new DAttributeOptionMoneda("currencyISOCode", true);
        
        moEltCurrencyFunction = new DElementCurrencyFunction("");
        moEltRateOfChange = new DElementCurrencyRateOfChange("");

        mvAttributes.add(moAttCurrencyIsoCode);
        
        mvElements.add(moEltCurrencyFunction);
        mvElements.add(moEltRateOfChange);
    }

    public cfd.DAttributeOptionMoneda getAttCurrencyIsoCode() { return moAttCurrencyIsoCode; }
    
    public cfd.ext.amece71.DElementCurrencyFunction getEltCurrencyFunction() { return moEltCurrencyFunction; }
    public cfd.ext.amece71.DElementCurrencyRateOfChange getEltRateOfChange() { return moEltRateOfChange; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
