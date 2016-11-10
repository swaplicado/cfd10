/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementTradeItemIdentification extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementGtin moEltGtin;

    public DElementTradeItemIdentification() {
        super("tradeItemIdentification");

        moEltGtin = new DElementGtin("");

        mvElements.add(moEltGtin);
    }

    public cfd.ext.bachoco.DElementGtin getEltGtin() { return moEltGtin; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
