/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementLineItem extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;
    protected cfd.DAttributeInteger moAttNumber;

    protected cfd.ext.grupomodelo.DElementTradeItemIdentification moEltTradeItemIdentification;
    protected cfd.ext.grupomodelo.DElementAlternateTradeItemIdentification moEltAlternateTradeItemIdentification;
    protected cfd.ext.grupomodelo.DElementTradeItemDescriptionInformation moEltTradeItemDescriptionInformation;
    protected cfd.ext.grupomodelo.DElementInvoicedQuantity moEltInvoicedQuantity;
    protected cfd.ext.grupomodelo.DElementGrossPrice moEltGrossPrice;
    protected cfd.ext.grupomodelo.DElementNetPrice moEltNetPrice;
    protected cfd.ext.grupomodelo.DElementAdditionalInformation moEltAdditionalInformation;
    protected cfd.ext.grupomodelo.DElementTradeItemTaxInformation moEltTradeItemTaxInformation;
    protected cfd.ext.grupomodelo.DElementTotalLineAmount moEltTotalLineAmount;

    public DElementLineItem() {
        super("modelo:lineItem");

        moAttType = new DAttributeString("type", true);
        moAttNumber = new DAttributeInteger("orderLineNumber", false, 1, 5);

        moEltTradeItemIdentification = new DElementTradeItemIdentification();
        moEltAlternateTradeItemIdentification = new DElementAlternateTradeItemIdentification("");
        moEltTradeItemDescriptionInformation = new DElementTradeItemDescriptionInformation();
        moEltInvoicedQuantity = new DElementInvoicedQuantity("");
        moEltGrossPrice = new DElementGrossPrice();
        moEltNetPrice = new DElementNetPrice();
        moEltAdditionalInformation = new DElementAdditionalInformation();
        moEltTradeItemTaxInformation = new DElementTradeItemTaxInformation();
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
        mvElements.add(moEltTradeItemTaxInformation);
        mvElements.add(moEltTotalLineAmount);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    public cfd.DAttributeInteger getAttNumber() { return moAttNumber; }
    
    public cfd.ext.grupomodelo.DElementTradeItemIdentification getEltTradeItemIdentification() { return moEltTradeItemIdentification; }
    public cfd.ext.grupomodelo.DElementAlternateTradeItemIdentification getEltAlternateTradeItemIdentification() { return moEltAlternateTradeItemIdentification; }
    public cfd.ext.grupomodelo.DElementTradeItemDescriptionInformation getEltTradeItemDescriptionInformation() { return moEltTradeItemDescriptionInformation; }
    public cfd.ext.grupomodelo.DElementInvoicedQuantity getEltInvoicedQuantity() { return moEltInvoicedQuantity; }
    public cfd.ext.grupomodelo.DElementGrossPrice getEltGrossPrice() { return moEltGrossPrice; }
    public cfd.ext.grupomodelo.DElementNetPrice getEltNetPrice() { return moEltNetPrice; }
    public cfd.ext.grupomodelo.DElementAdditionalInformation getEltAdditionalInformation() { return moEltAdditionalInformation; }
    public cfd.ext.grupomodelo.DElementTradeItemTaxInformation getEltTradeItemTaxInformation() { return moEltTradeItemTaxInformation; }
    public cfd.ext.grupomodelo.DElementTotalLineAmount getEltTotalLineAmount() { return moEltTotalLineAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
