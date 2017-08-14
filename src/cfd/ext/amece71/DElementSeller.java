/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementSeller extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementSellerGln moEltGln;
    protected cfd.ext.amece71.DElementSellerAlternatePartyIdentification moEltAlternatePartyIdentification;

    public DElementSeller() {
        super("seller");

        moEltGln = new DElementSellerGln("");
        moEltAlternatePartyIdentification = new DElementSellerAlternatePartyIdentification("");

        mvElements.add(moEltGln);
        mvElements.add(moEltAlternatePartyIdentification);
    }
    public cfd.ext.amece71.DElementSellerGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementSellerAlternatePartyIdentification getEltAlternatePartyIdentification() { return moEltAlternatePartyIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
