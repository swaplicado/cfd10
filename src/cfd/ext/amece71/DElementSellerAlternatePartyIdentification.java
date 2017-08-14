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
public class DElementSellerAlternatePartyIdentification extends cfd.DElement {

    protected cfd.DAttributeString moAttType;

    public DElementSellerAlternatePartyIdentification(java.lang.String value) {
        super("alternatePartyIdentification", value);

        moAttType = new DAttributeString("type", true);

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
