/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTradeItemTaxInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementTaxTypeDescription moEltTaxTypeDescription;
    protected cfd.ext.amece71.DElementTaxCategory moEltTaxCategory;
    protected cfd.ext.amece71.DElementTradeItemTaxAmount moEltItemTaxAmount;

    public DElementTradeItemTaxInformation() {
        super("tradeItemTaxInformation");

        moEltTaxTypeDescription = new DElementTaxTypeDescription("");
        moEltTaxCategory = new DElementTaxCategory("");
        moEltItemTaxAmount = new DElementTradeItemTaxAmount();

        mvElements.add(moEltTaxTypeDescription);
        mvElements.add(moEltTaxCategory);
        mvElements.add(moEltItemTaxAmount);
    }

    public cfd.ext.amece71.DElementTaxTypeDescription getEltTaxTypeDescription() { return moEltTaxTypeDescription; }
    public cfd.ext.amece71.DElementTaxCategory getEltTaxCategory() { return moEltTaxCategory; }
    public cfd.ext.amece71.DElementTradeItemTaxAmount getEltItemTaxAmount() { return moEltItemTaxAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
