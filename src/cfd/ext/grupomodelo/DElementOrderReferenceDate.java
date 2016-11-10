/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementOrderReferenceDate extends cfd.DElement {

    public DElementOrderReferenceDate(java.lang.String value) {
        super("modelo:ReferenceDate", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
