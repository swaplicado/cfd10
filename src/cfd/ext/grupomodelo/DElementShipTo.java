/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementShipTo extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementShipToGln moEltGln;

    public DElementShipTo() {
        super("shipTo");

        moEltGln = new DElementShipToGln("");

        mvElements.add(moEltGln);
    }

    public cfd.ext.grupomodelo.DElementShipToGln getEltGln() { return moEltGln; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
