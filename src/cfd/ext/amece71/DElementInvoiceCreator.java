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

    protected cfd.ext.amece71.DElementInvoiceCreatorGln moEltGln;
    protected cfd.ext.amece71.DElementInvoiceCreatorAlternatePartyIdentification moEltAlternatePartyIdentification;
    protected cfd.ext.amece71.DElementInvoiceCreatorNameAndAddress moEltNameAndAddress;

    public DElementInvoiceCreator() {
        super("InvoiceCreator");

        moEltGln = new DElementInvoiceCreatorGln("");
        moEltAlternatePartyIdentification = new DElementInvoiceCreatorAlternatePartyIdentification("");
        moEltNameAndAddress = new DElementInvoiceCreatorNameAndAddress();

        mvElements.add(moEltGln);
        mvElements.add(moEltAlternatePartyIdentification);
        mvElements.add(moEltNameAndAddress);
    }

    public cfd.ext.amece71.DElementInvoiceCreatorGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementInvoiceCreatorAlternatePartyIdentification getEltAlternatePartyIdentification() { return moEltAlternatePartyIdentification; }
    public cfd.ext.amece71.DElementInvoiceCreatorNameAndAddress getEltNameAndAddress() { return moEltNameAndAddress; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
