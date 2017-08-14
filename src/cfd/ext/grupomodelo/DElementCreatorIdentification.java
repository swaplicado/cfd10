/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCreatorIdentification extends cfd.DElement {

    public DElementCreatorIdentification(java.lang.String value) {
        super("modelo:uniqueCreatorIdentification", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
