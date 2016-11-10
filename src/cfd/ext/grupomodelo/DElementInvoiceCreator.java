/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementInvoiceCreator extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementInvoiceGln moEltGln;
    protected cfd.ext.grupomodelo.DElementInvoicePartyIdentification moEltPartyIdentification;
    protected cfd.ext.grupomodelo.DElementInvoiceNameAddress moEltNameAddress;

    public DElementInvoiceCreator() {
        super("modelo:InvoiceCreator");

        moEltGln = new DElementInvoiceGln("");
        moEltPartyIdentification = new DElementInvoicePartyIdentification("");
        moEltNameAddress = new DElementInvoiceNameAddress();

        mvElements.add(moEltGln);
        mvElements.add(moEltPartyIdentification);
        mvElements.add(moEltNameAddress);
    }

    public cfd.ext.grupomodelo.DElementInvoiceGln getEltGln() { return moEltGln; }
    public cfd.ext.grupomodelo.DElementInvoicePartyIdentification getEltAlternatePartyIdentification() { return moEltPartyIdentification; }
    public cfd.ext.grupomodelo.DElementInvoiceNameAddress getEltNameAddress() { return moEltNameAddress; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
