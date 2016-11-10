/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementPersonOrText extends cfd.DElement {

    public DElementPersonOrText(java.lang.String value) {
         super("text", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
