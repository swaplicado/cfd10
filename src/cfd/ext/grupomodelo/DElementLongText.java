/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementLongText extends cfd.DElement {

    public DElementLongText(java.lang.String value) {
        super("modelo:longText", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
