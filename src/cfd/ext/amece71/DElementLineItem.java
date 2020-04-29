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

    protected cfd.ext.amece71.DElementLineItemTradeItemIdentification moEltTradeItemIdentification;
    protected cfd.ext.amece71.DElementLineItemAlternateTradeItemIdentification moEltAlternateTradeItemIdentification;
    protected cfd.ext.amece71.DElementLineItemTradeItemDescriptionInformation moEltTradeItemDescriptionInformation;
    protected cfd.ext.amece71.DElementLineItemInvoicedQuantity moEltInvoicedQuantity;
    protected cfd.ext.amece71.DElementLineItemGrossPrice moEltGrossPrice;
    protected cfd.ext.amece71.DElementLineItemNetPrice moEltNetPrice;
    protected cfd.ext.amece71.DElementAdditionalInformation moEltAdditionalInformation;
    protected cfd.ext.amece71.DElementLineItemTotalLineAmount moEltTotalLineAmount;

    public DElementLineItem() {
        super("lineItem");

        moAttType = new DAttributeString("type", true);
        moAttType.setString("SimpleInvoiceLineItemType");
        moAttNumber = new DAttributeString("number", true);

        moEltTradeItemIdentification = new DElementLineItemTradeItemIdentification();
        moEltAlternateTradeItemIdentification = new DElementLineItemAlternateTradeItemIdentification("");
        moEltTradeItemDescriptionInformation = new DElementLineItemTradeItemDescriptionInformation();
        moEltInvoicedQuantity = new DElementLineItemInvoicedQuantity("");
        moEltGrossPrice = new DElementLineItemGrossPrice();
        moEltNetPrice = new DElementLineItemNetPrice();
        moEltAdditionalInformation = new DElementAdditionalInformation();
        moEltTotalLineAmount = new DElementLineItemTotalLineAmount();

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
    
    public cfd.ext.amece71.DElementLineItemTradeItemIdentification getEltTradeItemIdentification() { return moEltTradeItemIdentification; }
    public cfd.ext.amece71.DElementLineItemAlternateTradeItemIdentification getEltAlternateTradeItemIdentification() { return moEltAlternateTradeItemIdentification; }
    public cfd.ext.amece71.DElementLineItemTradeItemDescriptionInformation getEltTradeItemDescriptionInformation() { return moEltTradeItemDescriptionInformation; }
    public cfd.ext.amece71.DElementLineItemInvoicedQuantity getEltInvoicedQuantity() { return moEltInvoicedQuantity; }
    public cfd.ext.amece71.DElementLineItemGrossPrice getEltGrossPrice() { return moEltGrossPrice; }
    public cfd.ext.amece71.DElementLineItemNetPrice getEltNetPrice() { return moEltNetPrice; }
    public cfd.ext.amece71.DElementAdditionalInformation getEltAdditionalInformation() { return moEltAdditionalInformation; }
    public cfd.ext.amece71.DElementLineItemTotalLineAmount getEltTotalLineAmount() { return moEltTotalLineAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
