/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
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
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
