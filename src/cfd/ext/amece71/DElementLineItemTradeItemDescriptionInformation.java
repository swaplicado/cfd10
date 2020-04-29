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
public class DElementLineItemTradeItemDescriptionInformation extends cfd.DElementParent {

    protected cfd.DAttributeString moAttLanguage;
    
    protected cfd.ext.amece71.DElementLineItemTradeItemDescriptionInformationLongText moEltLongText;

    public DElementLineItemTradeItemDescriptionInformation() {
        super("tradeItemDescriptionInformation");

        moAttLanguage = new DAttributeString("language", true);
        moAttLanguage.setString("ES");
        
        moEltLongText = new DElementLineItemTradeItemDescriptionInformationLongText("");

        mvAttributes.add(moAttLanguage);
        
        mvElements.add(moEltLongText);
    }

    public cfd.DAttributeString getAttLanguage() { return moAttLanguage; }
    
    public cfd.ext.amece71.DElementLineItemTradeItemDescriptionInformationLongText getEltLongText() { return moEltLongText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
