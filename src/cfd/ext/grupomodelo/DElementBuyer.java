/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementBuyer extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementBuyerGln moEltGln;
    protected cfd.ext.grupomodelo.DElementContactInformation moEltContactInformation;

    public DElementBuyer() {
        super("modelo:buyer");

        moEltGln =  new DElementBuyerGln("");
        moEltContactInformation = new DElementContactInformation();

        mvElements.add(moEltGln);
        mvElements.add(moEltContactInformation);
    }

    public cfd.ext.grupomodelo.DElementBuyerGln getEltGln() { return moEltGln; }
    public cfd.ext.grupomodelo.DElementContactInformation getEltContactInformation() { return moEltContactInformation; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
