/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTradeItemDescriptionInformation extends cfd.DElementParent {

    protected cfd.DAttributeString moAttLanguage;
    
    protected cfd.ext.amece71.DElementLongText moEltLongText;

    public DElementTradeItemDescriptionInformation() {
        super("tradeItemDescriptionInformation");

        moAttLanguage = new DAttributeString("language", true);
        moAttLanguage.setString("ES");
        
        moEltLongText = new DElementLongText("");

        mvAttributes.add(moAttLanguage);
        
        mvElements.add(moEltLongText);
    }

    public cfd.DAttributeString getAttLanguage() { return moAttLanguage; }
    
    public cfd.ext.amece71.DElementLongText getEltLongText() { return moEltLongText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
