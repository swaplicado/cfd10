/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTradeItemDescriptionInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementLongText moEltLongText;

    public DElementTradeItemDescriptionInformation() {
        super("tradeItemDescriptionIdentification");

        moEltLongText = new DElementLongText("");

        mvElements.add(moEltLongText);
    }

    public cfd.ext.amece71.DElementLongText getEltLongText() { return moEltLongText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
