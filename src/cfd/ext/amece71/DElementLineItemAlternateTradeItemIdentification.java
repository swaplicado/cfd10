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
public class DElementLineItemAlternateTradeItemIdentification extends cfd.DElement {

    protected cfd.DAttributeString moAttType;

    public DElementLineItemAlternateTradeItemIdentification(java.lang.String value) {
        super("alternateTradeItemIdentification", value);

        moAttType = new DAttributeString("type", true);
        moAttType.setString("BUYER_ASSIGNED");

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
