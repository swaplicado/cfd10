/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPayableAmount extends cfd.DElementParent {

   protected cfd.ext.bachoco.DElementAmountPayable moEltAmount;

    public DElementPayableAmount() {
        super("payableAmount");

        moEltAmount = new DElementAmountPayable("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.bachoco.DElementAmountPayable getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
