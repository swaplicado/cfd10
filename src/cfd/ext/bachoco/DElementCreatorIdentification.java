/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementCreatorIdentification extends cfd.DElement {

    public DElementCreatorIdentification(java.lang.String value) {
        super("uniqueCreatorIdentification", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
