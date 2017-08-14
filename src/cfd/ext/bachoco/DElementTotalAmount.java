/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
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
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
