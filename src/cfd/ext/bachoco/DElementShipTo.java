/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementShipTo extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementShipToGln moEltGln;

    public DElementShipTo() {
        super("shipTo");

        moEltGln = new DElementShipToGln("");

        mvElements.add(moEltGln);
    }

    public cfd.ext.bachoco.DElementShipToGln getEltGln() { return moEltGln; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
