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
public class DElementLineItem extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;
    protected cfd.DAttributeString moAttNumber;

    protected cfd.ext.amece71.DElementTradeItemIdentification moEltTradeItemIdentification;
    protected cfd.ext.amece71.DElementAlternateTradeItemIdentification moEltAlternateTradeItemIdentification;
    protected cfd.ext.amece71.DElementTradeItemDescriptionInformation moEltTradeItemDescriptionInformation;
    protected cfd.ext.amece71.DElementInvoicedQuantity moEltInvoicedQuantity;
    protected cfd.ext.amece71.DElementGrossPrice moEltGrossPrice;
    protected cfd.ext.amece71.DElementNetPrice moEltNetPrice;
    protected cfd.ext.amece71.DElementAdditionalInformation moEltAdditionalInformation;
    protected cfd.ext.amece71.DElementTotalLineAmount moEltTotalLineAmount;

    public DElementLineItem() {
        super("lineItem");

        moAttType = new DAttributeString("type", true);
        moAttType.setString("SimpleInvoiceLineItemType");
        moAttNumber = new DAttributeString("number", true);

        moEltTradeItemIdentification = new DElementTradeItemIdentification();
        moEltAlternateTradeItemIdentification = new DElementAlternateTradeItemIdentification("");
        moEltTradeItemDescriptionInformation = new DElementTradeItemDescriptionInformation();
        moEltInvoicedQuantity = new DElementInvoicedQuantity("");
        moEltGrossPrice = new DElementGrossPrice();
        moEltNetPrice = new DElementNetPrice();
        moEltAdditionalInformation = new DElementAdditionalInformation();
        moEltTotalLineAmount = new DElementTotalLineAmount();

        mvAttributes.add(moAttType);
        mvAttributes.add(moAttNumber);

        mvElements.add(moEltTradeItemIdentification);
        mvElements.add(moEltAlternateTradeItemIdentification);
        mvElements.add(moEltTradeItemDescriptionInformation);
        mvElements.add(moEltInvoicedQuantity);
        mvElements.add(moEltGrossPrice);
        mvElements.add(moEltNetPrice);
        mvElements.add(moEltAdditionalInformation);
        mvElements.add(moEltTotalLineAmount);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    public cfd.DAttributeString getAttNumber() { return moAttNumber; }
    
    public cfd.ext.amece71.DElementTradeItemIdentification getEltTradeItemIdentification() { return moEltTradeItemIdentification; }
    public cfd.ext.amece71.DElementAlternateTradeItemIdentification getEltAlternateTradeItemIdentification() { return moEltAlternateTradeItemIdentification; }
    public cfd.ext.amece71.DElementTradeItemDescriptionInformation getEltTradeItemDescriptionInformation() { return moEltTradeItemDescriptionInformation; }
    public cfd.ext.amece71.DElementInvoicedQuantity getEltInvoicedQuantity() { return moEltInvoicedQuantity; }
    public cfd.ext.amece71.DElementGrossPrice getEltGrossPrice() { return moEltGrossPrice; }
    public cfd.ext.amece71.DElementNetPrice getEltNetPrice() { return moEltNetPrice; }
    public cfd.ext.amece71.DElementAdditionalInformation getEltAdditionalInformation() { return moEltAdditionalInformation; }
    public cfd.ext.amece71.DElementTotalLineAmount getEltTotalLineAmount() { return moEltTotalLineAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
