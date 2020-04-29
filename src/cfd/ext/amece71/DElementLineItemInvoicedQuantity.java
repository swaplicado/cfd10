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
public class DElementLineItemInvoicedQuantity extends cfd.DElement {

    protected cfd.DAttributeString moAttUnit;

    public DElementLineItemInvoicedQuantity(java.lang.String value) {
        super("invoicedQuantity", value);

        moAttUnit = new DAttributeString("unitOfMeasure", true);

        mvAttributes.add(moAttUnit);
    }

    public cfd.DAttributeString getAttUnitOfMeasure() { return moAttUnit; }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
