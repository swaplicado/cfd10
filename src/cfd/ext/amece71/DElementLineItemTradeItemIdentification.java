/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementLineItemTradeItemIdentification extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementLineItemTradeItemIdentificationGtin moEltGtin;

    public DElementLineItemTradeItemIdentification() {
        super("tradeItemIdentification");

        moEltGtin = new DElementLineItemTradeItemIdentificationGtin("");

        mvElements.add(moEltGtin);
    }

    public cfd.ext.amece71.DElementLineItemTradeItemIdentificationGtin getEltGtin() { return moEltGtin; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
