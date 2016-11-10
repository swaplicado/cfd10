/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Juan Barajas
 */
public class DElementLineItem extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;
    protected cfd.DAttributeString moAttNumber;

    protected cfd.ext.amece71.DElementTradeItemIdentification moEltTradeItemIdentification;
    protected cfd.ext.amece71.DElementAditionalQuantity moEltAditionalQuantity;
    protected cfd.ext.amece71.DElementNetPrice moEltNetPrice;
    protected cfd.ext.amece71.DElementAdditionalInformation moEltAdditionalInformation;

    public DElementLineItem() {
        super("lineItem");

        moAttType = new DAttributeString("type", true);
        moAttNumber = new DAttributeString("number", true);

        moEltTradeItemIdentification = new DElementTradeItemIdentification();
        moEltAditionalQuantity = new DElementAditionalQuantity("");
        moEltNetPrice = new DElementNetPrice();
        moEltAdditionalInformation = new DElementAdditionalInformation();

        mvAttributes.add(moAttType);
        mvAttributes.add(moAttNumber);

        mvElements.add(moEltTradeItemIdentification);
        mvElements.add(moEltAditionalQuantity);
        mvElements.add(moEltNetPrice);
        mvElements.add(moEltAdditionalInformation);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    public cfd.DAttributeString getAttNumber() { return moAttNumber; }
    
    public cfd.ext.amece71.DElementTradeItemIdentification getEltTradeItemIdentification() { return moEltTradeItemIdentification; }
    public cfd.ext.amece71.DElementAditionalQuantity getEltAditionalQuantity() { return moEltAditionalQuantity; }
    public cfd.ext.amece71.DElementNetPrice getEltNetPrice() { return moEltNetPrice; }
    public cfd.ext.amece71.DElementAdditionalInformation getEltAdditionalInformation() { return moEltAdditionalInformation; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
