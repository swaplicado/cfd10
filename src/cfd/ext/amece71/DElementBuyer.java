/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementBuyer extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementBuyerGln moEltGln;
    protected cfd.ext.amece71.DElementContactInformation moEltContactInformation;

    public DElementBuyer() {
        super("buyer");

        moEltGln =  new DElementBuyerGln("");
        moEltContactInformation = new DElementContactInformation();

        mvElements.add(moEltGln);
        mvElements.add(moEltContactInformation);
    }

    public cfd.ext.amece71.DElementBuyerGln getEltGln() { return moEltGln; }
    public cfd.ext.amece71.DElementContactInformation getEltContactInformation() { return moEltContactInformation; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
