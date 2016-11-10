/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementNetPrice extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementPriceAmount moEltAmount;

    public DElementNetPrice() {
        super("netPrice");

        moEltAmount = new DElementPriceAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.bachoco.DElementPriceAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
