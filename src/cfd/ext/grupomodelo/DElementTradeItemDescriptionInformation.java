/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementTradeItemDescriptionInformation extends cfd.DElementParent {

    protected cfd.DAttributeString moAttLanguage;
    protected cfd.ext.grupomodelo.DElementLongText moEltLongText;

    public DElementTradeItemDescriptionInformation() {
        super("modelo:tradeItemDescriptionInformation");

        moAttLanguage = new DAttributeString("language", true);
        moEltLongText = new DElementLongText("");

        mvAttributes.add(moAttLanguage);
        mvElements.add(moEltLongText);
    }

    public cfd.DAttributeString getAttLanguage() { return moAttLanguage; }
    public cfd.ext.grupomodelo.DElementLongText getEltLongText() { return moEltLongText; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
