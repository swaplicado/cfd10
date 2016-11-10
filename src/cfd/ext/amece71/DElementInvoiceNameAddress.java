/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementInvoiceNameAddress extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementInvoiceName moEltName;
    protected cfd.ext.amece71.DElementInvoiceStreetAddressOne moEltStreetAddressOne;
    protected cfd.ext.amece71.DElementInvoiceCity moEltCity;
    protected cfd.ext.amece71.DElementInvoicePostalCode moEltPostalCode;

    public DElementInvoiceNameAddress() {
        super("nameAndAddress");

        moEltName = new DElementInvoiceName("");
        moEltStreetAddressOne = new DElementInvoiceStreetAddressOne("");
        moEltCity = new DElementInvoiceCity("");
        moEltPostalCode = new DElementInvoicePostalCode("");

        mvElements.add(moEltName);
        mvElements.add(moEltStreetAddressOne);
        mvElements.add(moEltCity);
        mvElements.add(moEltPostalCode);
    }
    
    public cfd.ext.amece71.DElementInvoiceName getEltName() { return moEltName; }
    public cfd.ext.amece71.DElementInvoiceStreetAddressOne getEltStreetAddressOne() { return moEltStreetAddressOne; }
    public cfd.ext.amece71.DElementInvoiceCity getEltCity() { return moEltCity; }
    public cfd.ext.amece71.DElementInvoicePostalCode getEltPostalCode() { return moEltPostalCode; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
