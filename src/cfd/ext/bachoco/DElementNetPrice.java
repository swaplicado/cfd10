/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
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
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
