/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
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
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
