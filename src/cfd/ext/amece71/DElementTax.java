/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTax extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;

    protected cfd.ext.amece71.DElementTaxPercentage moEltTaxPercentage;
    protected cfd.ext.amece71.DElementTaxAmount moEltTaxAmount;
    protected cfd.ext.amece71.DElementTaxCategory moEltTaxCategory;

    public DElementTax() {
        super("tax");

        moAttType = new DAttributeString("type", true);
        moAttType.setString("VAT");

        moEltTaxPercentage = new DElementTaxPercentage("");
        moEltTaxAmount = new DElementTaxAmount("");
        moEltTaxCategory = new DElementTaxCategory("TRANSFERIDO");

        mvAttributes.add(moAttType);

        mvElements.add(moEltTaxPercentage);
        mvElements.add(moEltTaxAmount);
        mvElements.add(moEltTaxCategory);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    
    public cfd.ext.amece71.DElementTaxPercentage getEltTaxPercentage() { return moEltTaxPercentage; }
    public cfd.ext.amece71.DElementTaxAmount getEltTaxAmount() { return moEltTaxAmount; }
    public cfd.ext.amece71.DElementTaxCategory getEltTaxCategory() { return moEltTaxCategory; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
