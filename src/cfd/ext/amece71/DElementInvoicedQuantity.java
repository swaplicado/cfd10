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
public class DElementInvoicedQuantity extends cfd.DElement {

    protected cfd.DAttributeString moAttUnit;

    public DElementInvoicedQuantity(java.lang.String value) {
        super("invoicedQuantity", value);

        moAttUnit = new DAttributeString("unitOfMeasure", true);

        mvAttributes.add(moAttUnit);
    }

    public cfd.DAttributeString getAttUnit() { return moAttUnit; }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
