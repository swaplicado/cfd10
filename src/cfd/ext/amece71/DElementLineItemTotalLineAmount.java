/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementLineItemTotalLineAmount extends cfd.DElementParent {

   protected cfd.ext.amece71.DElementLineItemTotalLineAmountGrossAmount moEltGrossAmount;
   protected cfd.ext.amece71.DElementLineItemTotalLineAmountNetAmount moEltNetAmount;

    public DElementLineItemTotalLineAmount() {
        super("totalLineAmount");

        moEltGrossAmount = new DElementLineItemTotalLineAmountGrossAmount();
        moEltNetAmount = new DElementLineItemTotalLineAmountNetAmount();

        mvElements.add(moEltGrossAmount);
        mvElements.add(moEltNetAmount);
    }

    public cfd.ext.amece71.DElementLineItemTotalLineAmountGrossAmount getEltGrossAmount() { return moEltGrossAmount; }
    public cfd.ext.amece71.DElementLineItemTotalLineAmountNetAmount getEltNetAmount() { return moEltNetAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
