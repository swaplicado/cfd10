/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementBuyer extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementBuyerGln moEltGln;
    protected cfd.ext.amece71.DElementBuyerContactInformation moEltContactInformation;

    public DElementBuyer() {
        super("buyer");

        moEltGln =  new DElementBuyerGln("");
        moEltContactInformation = new DElementBuyerContactInformation();

        mvElements.add(moEltGln);
        mvElements.add(moEltContactInformation);
    }

    public cfd.ext.amece71.DElementBuyerGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementBuyerContactInformation getEltContactInformation() { return moEltContactInformation; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
