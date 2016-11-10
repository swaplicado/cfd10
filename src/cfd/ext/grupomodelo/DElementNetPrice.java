/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementNetPrice extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementPriceAmount moEltAmount;

    public DElementNetPrice() {
        super("modelo:netPrice");

        moEltAmount = new DElementPriceAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.grupomodelo.DElementPriceAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
