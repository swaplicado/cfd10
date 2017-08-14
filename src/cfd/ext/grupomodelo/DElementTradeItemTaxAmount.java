/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTradeItemTaxAmount extends cfd.DElementParent {

   protected cfd.ext.grupomodelo.DElementTaxPercentage moEltTaxPercentage;
   protected cfd.ext.grupomodelo.DElementTaxAmount moEltTaxAmount;

    public DElementTradeItemTaxAmount() {
        super("modelo:tradeItemTaxAmount");

        moEltTaxPercentage = new DElementTaxPercentage("");
        moEltTaxAmount = new DElementTaxAmount("");

        mvElements.add(moEltTaxPercentage);
        mvElements.add(moEltTaxAmount);
    }

    public cfd.ext.grupomodelo.DElementTaxPercentage getEltTaxPercentage() { return moEltTaxPercentage; }
    public cfd.ext.grupomodelo.DElementTaxAmount getEltTaxAmount() { return moEltTaxAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
