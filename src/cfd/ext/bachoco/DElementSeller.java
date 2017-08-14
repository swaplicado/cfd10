/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementSeller extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementSellerGln moEltGln;

    public DElementSeller() {
        super("seller");

        moEltGln = new DElementSellerGln("");

        mvElements.add(moEltGln);
    }
    public cfd.ext.bachoco.DElementSellerGln getEltGln() { return moEltGln; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
