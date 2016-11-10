/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementTradeItemIdentification extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementGtin moEltGtin;

    public DElementTradeItemIdentification() {
        super("modelo:tradeItemIdentification");

        moEltGtin = new DElementGtin("");

        mvElements.add(moEltGtin);
    }

    public cfd.ext.grupomodelo.DElementGtin getEltGtin() { return moEltGtin; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
