/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementSeller extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementSellerGln moEltGln;

    public DElementSeller() {
        super("seller");

        moEltGln = new DElementSellerGln("");

        mvElements.add(moEltGln);
    }
    public cfd.ext.grupomodelo.DElementSellerGln getEltGln() { return moEltGln; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
