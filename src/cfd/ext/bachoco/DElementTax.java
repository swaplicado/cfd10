/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementTax extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;

    protected cfd.ext.bachoco.DElementTaxPercentage moEltTaxPercentage;
    protected cfd.ext.bachoco.DElementTaxAmount moEltTaxAmount;
    protected cfd.ext.bachoco.DElementTaxCategory moEltTaxCategory;

    public DElementTax() {
        super("tax");

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
    
    public cfd.ext.bachoco.DElementTaxPercentage getEltTaxPercentage() { return moEltTaxPercentage; }
    public cfd.ext.bachoco.DElementTaxAmount getEltTaxAmount() { return moEltTaxAmount; }
    public cfd.ext.bachoco.DElementTaxCategory getEltTaxCategory() { return moEltTaxCategory; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
