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

    protected cfd.DAttributeString moAttAlternatePartyIdentification;

    public DElementSellerAlternatePartyIdentification(java.lang.String value) {
        super("alternatePartyIdentification", value);

        moAttAlternatePartyIdentification = new DAttributeString("type", true);
        moAttAlternatePartyIdentification.setString("SELLER_ASSIGNED_IDENTIFIER_FOR_A_PARTY");

        mvAttributes.add(moAttAlternatePartyIdentification);
    }

    public cfd.DAttributeString getAttAlternatePartyIdentification() { return moAttAlternatePartyIdentification; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
