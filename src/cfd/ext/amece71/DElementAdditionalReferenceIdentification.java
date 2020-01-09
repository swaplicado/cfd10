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
public class DElementAdditionalReferenceIdentification extends cfd.DElement {
    
    /** Número de pedido (comprador.) */
    public static final java.lang.String TYPE_ON = "ON";
    /** Número de aprobación. */
    public static final java.lang.String TYPE_ATZ = "ATZ";

    protected cfd.DAttributeString moAttType;

    public DElementAdditionalReferenceIdentification(java.lang.String value) {
        super("referenceIdentification", value);

        moAttType = new DAttributeString("type", true);
        moAttType.setString("ON"); 

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
