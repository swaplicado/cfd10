/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementShipTo extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementShipToGln moEltGln;
    protected cfd.ext.amece71.DElementShiptoNameAddress moEltNameAndAddress;

    public DElementShipTo() {
        super("shipTo");

        moEltGln = new DElementShipToGln("");
        moEltNameAndAddress = new DElementShiptoNameAddress();

        mvElements.add(moEltGln);
        mvElements.add(moEltNameAndAddress);
    }

    public cfd.ext.amece71.DElementShipToGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementShiptoNameAddress getEltNameAddress() { return moEltNameAndAddress; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
