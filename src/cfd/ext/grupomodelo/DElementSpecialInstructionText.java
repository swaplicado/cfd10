/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementSpecialInstructionText extends cfd.DElement {

    public DElementSpecialInstructionText(java.lang.String value) {
         super("modelo:text", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
