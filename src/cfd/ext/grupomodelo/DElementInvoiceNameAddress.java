/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementInvoiceNameAddress extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementInvoiceName moEltName;
    protected cfd.ext.grupomodelo.DElementInvoiceStreetAddressOne moEltStreetAddressOne;
    protected cfd.ext.grupomodelo.DElementInvoiceCity moEltCity;
    protected cfd.ext.grupomodelo.DElementInvoicePostalCode moEltPostalCode;

    public DElementInvoiceNameAddress() {
        super("modelo:nameAndAddress");

        moEltName = new DElementInvoiceName("");
        moEltStreetAddressOne = new DElementInvoiceStreetAddressOne("");
        moEltCity = new DElementInvoiceCity("");
        moEltPostalCode = new DElementInvoicePostalCode("");

        mvElements.add(moEltName);
        mvElements.add(moEltStreetAddressOne);
        mvElements.add(moEltCity);
        mvElements.add(moEltPostalCode);
    }
    
    public cfd.ext.grupomodelo.DElementInvoiceName getEltName() { return moEltName; }
    public cfd.ext.grupomodelo.DElementInvoiceStreetAddressOne getEltStreetAddressOne() { return moEltStreetAddressOne; }
    public cfd.ext.grupomodelo.DElementInvoiceCity getEltCity() { return moEltCity; }
    public cfd.ext.grupomodelo.DElementInvoicePostalCode getEltPostalCode() { return moEltPostalCode; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
