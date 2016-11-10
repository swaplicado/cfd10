/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementTotalAmount extends cfd.DElementParent {

   protected cfd.ext.bachoco.DElementAmountTotal moEltAmount;

    public DElementTotalAmount() {
        super("totalAmount");

        moEltAmount = new DElementAmountTotal("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.bachoco.DElementAmountTotal getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
