/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPersonOrText extends cfd.DElement {

    public DElementPersonOrText(java.lang.String value) {
         super("text", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
