/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementLongText extends cfd.DElement {

    public DElementLongText(java.lang.String value) {
        super("longText", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
