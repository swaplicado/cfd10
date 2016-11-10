/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementAdditionalReferenceIdentification extends cfd.DElement {

    protected cfd.DAttributeString moAttType;

    public DElementAdditionalReferenceIdentification(java.lang.String value) {
        super("modelo:referenceIdentification", value);

        moAttType = new DAttributeString("type", true);

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
