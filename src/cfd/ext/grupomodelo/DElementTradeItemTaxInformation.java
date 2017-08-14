/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTradeItemTaxInformation extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementTaxTypeDescription moEltTaxTypeDescription;
    protected cfd.ext.grupomodelo.DElementTaxCategory moEltTaxCategory;
    protected cfd.ext.grupomodelo.DElementTradeItemTaxAmount moEltItemTaxAmount;

    public DElementTradeItemTaxInformation() {
        super("modelo:tradeItemTaxInformation");

        moEltTaxTypeDescription = new DElementTaxTypeDescription("");
        moEltTaxCategory = new DElementTaxCategory("");
        moEltItemTaxAmount = new DElementTradeItemTaxAmount();

        mvElements.add(moEltTaxTypeDescription);
        mvElements.add(moEltTaxCategory);
        mvElements.add(moEltItemTaxAmount);
    }

    public cfd.ext.grupomodelo.DElementTaxTypeDescription getEltTaxTypeDescription() { return moEltTaxTypeDescription; }
    public cfd.ext.grupomodelo.DElementTaxCategory getEltTaxCategory() { return moEltTaxCategory; }
    public cfd.ext.grupomodelo.DElementTradeItemTaxAmount getEltItemTaxAmount() { return moEltItemTaxAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
