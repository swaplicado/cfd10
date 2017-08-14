/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementNetPrice extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementPriceAmount moEltAmount;

    public DElementNetPrice() {
        super("netPrice");

        moEltAmount = new DElementPriceAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.amece71.DElementPriceAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
