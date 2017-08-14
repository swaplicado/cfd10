/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementGrossPrice extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementPriceAmount moEltAmount;

    public DElementGrossPrice() {
        super("modelo:grossPrice");

        moEltAmount = new DElementPriceAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.grupomodelo.DElementPriceAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
