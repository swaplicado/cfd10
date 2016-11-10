/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DAttribute;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Juan Barajas
 */
public class DElementLineItem extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;
    protected cfd.DAttributeInteger moAttNumber;

    protected cfd.ext.bachoco.DElementTradeItemIdentification moEltTradeItemIdentification;
    protected cfd.ext.bachoco.DElementAditionalQuantity moEltAditionalQuantity;
    protected cfd.ext.bachoco.DElementNetPrice moEltNetPrice;
    protected cfd.ext.bachoco.DElementAdditionalInformation moEltAdditionalInformation;

    public DElementLineItem() {
        super("lineItem");

        moAttType = new DAttributeString("type", true);
        moAttNumber = new DAttributeInteger("number", true, 1, 5);

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
    public cfd.DAttributeInteger getAttNumber() { return moAttNumber; }
    
    public cfd.ext.bachoco.DElementTradeItemIdentification getEltTradeItemIdentification() { return moEltTradeItemIdentification; }
    public cfd.ext.bachoco.DElementAditionalQuantity getEltAditionalQuantity() { return moEltAditionalQuantity; }
    public cfd.ext.bachoco.DElementNetPrice getEltNetPrice() { return moEltNetPrice; }
    public cfd.ext.bachoco.DElementAdditionalInformation getEltAdditionalInformation() { return moEltAdditionalInformation; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
