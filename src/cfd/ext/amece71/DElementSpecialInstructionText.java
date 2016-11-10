/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementSpecialInstructionText extends cfd.DElement {

    public DElementSpecialInstructionText(java.lang.String value) {
         super("text", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
