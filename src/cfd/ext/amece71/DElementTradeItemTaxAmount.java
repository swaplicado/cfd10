/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTradeItemTaxAmount extends cfd.DElementParent {

   protected cfd.ext.amece71.DElementTaxPercentage moEltTaxPercentage;
   protected cfd.ext.amece71.DElementTaxAmount moEltTaxAmount;

    public DElementTradeItemTaxAmount() {
        super("tradeItemTaxAmount");

        moEltTaxPercentage = new DElementTaxPercentage("");
        moEltTaxAmount = new DElementTaxAmount("");

        mvElements.add(moEltTaxPercentage);
        mvElements.add(moEltTaxAmount);
    }

    public cfd.ext.amece71.DElementTaxPercentage getEltTaxPercentage() { return moEltTaxPercentage; }
    public cfd.ext.amece71.DElementTaxAmount getEltTaxAmount() { return moEltTaxAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
