/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementInvoicePartyIdentification extends cfd.DElement {

    protected cfd.DAttributeString moAttType;

    public DElementInvoicePartyIdentification(java.lang.String value) {
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
