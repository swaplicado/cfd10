/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPayableAmount extends cfd.DElementParent {

   protected cfd.ext.amece71.DElementAmountPayable moEltAmount;

    public DElementPayableAmount() {
        super("payableAmount");

        moEltAmount = new DElementAmountPayable("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.amece71.DElementAmountPayable getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
