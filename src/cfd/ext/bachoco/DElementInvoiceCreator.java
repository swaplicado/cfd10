/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementInvoiceCreator extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementInvoicePartyIdentification moEltPartyIdentification;

    public DElementInvoiceCreator() {
        super("InvoiceCreator");

        moEltPartyIdentification = new DElementInvoicePartyIdentification("");

        mvElements.add(moEltPartyIdentification);
    }

    public cfd.ext.bachoco.DElementInvoicePartyIdentification getEltAlternatePartyIdentification() { return moEltPartyIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
