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
public class DElementAditionalQuantity extends cfd.DElement {

    protected cfd.DAttributeString moAttQuantityType;

    public DElementAditionalQuantity(java.lang.String value) {
        super("aditionalQuantity", value);

        moAttQuantityType = new DAttributeString("QuantityType", true);

        mvAttributes.add(moAttQuantityType);
    }

    public cfd.DAttributeString getAttQuantityType() { return moAttQuantityType; }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
