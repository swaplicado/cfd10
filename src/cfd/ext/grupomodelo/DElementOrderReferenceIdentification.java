/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementOrderReferenceIdentification extends cfd.DElement {

    protected cfd.DAttributeString moAttType;

    public DElementOrderReferenceIdentification(java.lang.String value) {
        super("modelo:referenceIdentification", value);

        moAttType = new DAttributeString("type", true);

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
