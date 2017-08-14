/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementSpecialInstruction extends cfd.DElementParent {

    protected cfd.DAttributeString moAttCode;
    protected cfd.ext.bachoco.DElementSpecialInstructionText moEltText;

    public DElementSpecialInstruction() {
        super("specialInstruction");

        moAttCode = new DAttributeString("code", true);
        moEltText = new DElementSpecialInstructionText("");

        mvAttributes.add(moAttCode);
        mvElements.add(moEltText);
    }

    public cfd.DAttributeString getAttCode() { return moAttCode; }
    public cfd.ext.bachoco.DElementSpecialInstructionText getEltText() { return moEltText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
