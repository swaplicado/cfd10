/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCustoms extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementCustomsGln moEltGln;
    protected cfd.ext.amece71.DElementCustomsAlternatePartyIdentification moEltPartyIdentification;
    protected cfd.ext.amece71.DElementCustomsReferenceDate moEltReferenceDate;
    protected cfd.ext.amece71.DElementCustomsNameAndAddress moEltNameAndAddress;

    public DElementCustoms() {
        super("Customs");

        moEltGln = new DElementCustomsGln("");
        moEltPartyIdentification = new DElementCustomsAlternatePartyIdentification("");
        moEltReferenceDate = new DElementCustomsReferenceDate("");
        moEltNameAndAddress = new DElementCustomsNameAndAddress();

        mvElements.add(moEltGln);
        mvElements.add(moEltPartyIdentification);
        mvElements.add(moEltReferenceDate);
        mvElements.add(moEltNameAndAddress);
    }

    public cfd.ext.amece71.DElementCustomsGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementCustomsAlternatePartyIdentification getEltAlternatePartyIdentification() { return moEltPartyIdentification; }
    public cfd.ext.amece71.DElementCustomsReferenceDate getEltReferenceDate() { return moEltReferenceDate; }
    public cfd.ext.amece71.DElementCustomsNameAndAddress getEltNameAndAddress() { return moEltNameAndAddress; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
