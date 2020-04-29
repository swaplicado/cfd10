/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementShipTo extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementShipToGln moEltGln;
    protected cfd.ext.amece71.DElementShipToNameAndAddress moEltNameAndAddress;

    public DElementShipTo() {
        super("shipTo");

        moEltGln = new DElementShipToGln("");
        moEltNameAndAddress = new DElementShipToNameAndAddress();

        mvElements.add(moEltGln);
        mvElements.add(moEltNameAndAddress);
    }

    public cfd.ext.amece71.DElementShipToGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementShipToNameAndAddress getEltNameAndAddress() { return moEltNameAndAddress; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
