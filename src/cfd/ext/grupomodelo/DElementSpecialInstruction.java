/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementSpecialInstruction extends cfd.DElementParent {

    protected cfd.DAttributeString moAttCode;
    protected cfd.ext.grupomodelo.DElementSpecialInstructionText moEltText;

    public DElementSpecialInstruction() {
        super("modelo:specialInstruction");

        moAttCode = new DAttributeString("code", true);
        moEltText = new DElementSpecialInstructionText("");

        mvAttributes.add(moAttCode);
        mvElements.add(moEltText);
    }

    public cfd.DAttributeString getAttCode() { return moAttCode; }
    public cfd.ext.grupomodelo.DElementSpecialInstructionText getEltText() { return moEltText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
