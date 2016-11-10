/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
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
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
