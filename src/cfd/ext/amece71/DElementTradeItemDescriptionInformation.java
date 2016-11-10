/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementTradeItemDescriptionInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementLongText moEltLongText;

    public DElementTradeItemDescriptionInformation() {
        super("tradeItemIdentification");

        moEltLongText = new DElementLongText("");

        mvElements.add(moEltLongText);
    }

    public cfd.ext.amece71.DElementLongText getEltLongText() { return moEltLongText; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
