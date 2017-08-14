/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementInvoiceCreator extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementInvoiceGln moEltGln;
    protected cfd.ext.amece71.DElementInvoicePartyIdentification moEltPartyIdentification;
    protected cfd.ext.amece71.DElementInvoiceNameAddress moEltNameAndAddress;

    public DElementInvoiceCreator() {
        super("InvoiceCreator");

        moEltGln = new DElementInvoiceGln("");
        moEltPartyIdentification = new DElementInvoicePartyIdentification("");
        moEltNameAndAddress = new DElementInvoiceNameAddress();

        mvElements.add(moEltGln);
        mvElements.add(moEltPartyIdentification);
        mvElements.add(moEltNameAndAddress);
    }

    public cfd.ext.amece71.DElementInvoiceGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementInvoicePartyIdentification getEltAlternatePartyIdentification() { return moEltPartyIdentification; }
    public cfd.ext.amece71.DElementInvoiceNameAddress getEltNameAddress() { return moEltNameAndAddress; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
