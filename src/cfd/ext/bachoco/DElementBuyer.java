/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementBuyer extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementBuyerGln moEltGln;
    protected cfd.ext.bachoco.DElementContactInformation moEltContactInformation;

    public DElementBuyer() {
        super("buyer");

        moEltGln =  new DElementBuyerGln("");
        moEltContactInformation = new DElementContactInformation();

        mvElements.add(moEltGln);
        mvElements.add(moEltContactInformation);
    }

    public cfd.ext.bachoco.DElementBuyerGln getEltGln() { return moEltGln; }
    public cfd.ext.bachoco.DElementContactInformation getEltContactInformation() { return moEltContactInformation; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
