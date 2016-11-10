/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementTax extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;

    protected cfd.ext.grupomodelo.DElementTaxPercentage moEltTaxPercentage;
    protected cfd.ext.grupomodelo.DElementTaxAmount moEltTaxAmount;
    protected cfd.ext.grupomodelo.DElementTaxCategory moEltTaxCategory;

    public DElementTax() {
        super("modelo:tax");

        moAttType = new DAttributeString("type", true);

        moEltTaxPercentage = new DElementTaxPercentage("");
        moEltTaxAmount = new DElementTaxAmount("");
        moEltTaxCategory = new DElementTaxCategory("");

        mvAttributes.add(moAttType);

        mvElements.add(moEltTaxPercentage);
        mvElements.add(moEltTaxAmount);
        mvElements.add(moEltTaxCategory);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    
    public cfd.ext.grupomodelo.DElementTaxPercentage getEltTaxPercentage() { return moEltTaxPercentage; }
    public cfd.ext.grupomodelo.DElementTaxAmount getEltTaxAmount() { return moEltTaxAmount; }
    public cfd.ext.grupomodelo.DElementTaxCategory getEltTaxCategory() { return moEltTaxCategory; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
