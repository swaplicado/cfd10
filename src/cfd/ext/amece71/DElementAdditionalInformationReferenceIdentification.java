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
public class DElementAdditionalInformationReferenceIdentification extends cfd.DElement {
    
    /** Número de aprobación. */
    public static final java.lang.String TYPE_ATZ = "ATZ";
    /** Número de pedido (comprador). */
    public static final java.lang.String TYPE_ON = "ON";

    protected cfd.DAttributeString moAttType;

    public DElementAdditionalInformationReferenceIdentification(java.lang.String value) {
        super("referenceIdentification", value);

        moAttType = new DAttributeString("type", true);
        moAttType.setString(TYPE_ON); 

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
