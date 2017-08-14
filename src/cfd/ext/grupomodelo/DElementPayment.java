/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPayment extends cfd.DElementParent {

    protected cfd.DAttributeString moAttType;
    protected cfd.DAttributeString moAttContentVersion;
    protected cfd.DAttributeString moAttDocStructureVersion;
    protected cfd.DAttributeString moAttDocStatus;

    protected cfd.ext.grupomodelo.DElementPaymentIdentification moEltPaymentIdentification;
    protected cfd.ext.grupomodelo.DElementSpecialInstruction moEltSpecialInstruction;
    protected cfd.ext.grupomodelo.DElementOrderIdentification moEltOrderIdentification;
    protected cfd.ext.grupomodelo.DElementBuyer moEltBuyer;
    protected cfd.ext.grupomodelo.DElementInvoiceCreator moEltInvoiceCreator;
    protected cfd.ext.grupomodelo.DElementCurrency moEltCurrency;
    protected cfd.ext.grupomodelo.DElementItems moEltItems;
    protected cfd.ext.grupomodelo.DElementTotalAmount moEltTotalAmount;
    protected cfd.ext.grupomodelo.DElementBaseAmount moEltBaseAmount;
    protected cfd.ext.grupomodelo.DElementTax moEltTax;
    protected cfd.ext.grupomodelo.DElementPayableAmount moEltPayableAmount;

    public DElementPayment() {
        super("modelo:requestForPayment");

        moAttType = new DAttributeString("type", true);
        moAttContentVersion = new DAttributeString("contentVersion", true);
        moAttDocStructureVersion = new DAttributeString("documentStructureVersion", true);
        moAttDocStatus = new DAttributeString("documentStatus", true);

        moEltPaymentIdentification = new DElementPaymentIdentification();
        moEltSpecialInstruction = new DElementSpecialInstruction();
        moEltOrderIdentification = new DElementOrderIdentification();
        moEltBuyer = new DElementBuyer();
        moEltInvoiceCreator = new DElementInvoiceCreator();
        moEltCurrency = new DElementCurrency();
        moEltItems = new DElementItems();
        moEltTotalAmount = new DElementTotalAmount();
        moEltBaseAmount = new DElementBaseAmount();
        moEltTax = new DElementTax();
        moEltPayableAmount = new DElementPayableAmount();

        mvAttributes.add(moAttType);
        mvAttributes.add(moAttContentVersion);
        mvAttributes.add(moAttDocStructureVersion);
        mvAttributes.add(moAttDocStatus);

        mvElements.add(moEltPaymentIdentification);
        mvElements.add(moEltSpecialInstruction);
        mvElements.add(moEltOrderIdentification);
        mvElements.add(moEltBuyer);
        mvElements.add(moEltInvoiceCreator);
        mvElements.add(moEltCurrency);
        mvElements.add(moEltItems);
        mvElements.add(moEltTotalAmount);
        mvElements.add(moEltBaseAmount);
        mvElements.add(moEltTax);
        mvElements.add(moEltPayableAmount);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    public cfd.DAttributeString getAttContentVersion() { return moAttContentVersion; }
    public cfd.DAttributeString getAttDocStructureVersion() { return moAttDocStructureVersion; }
    public cfd.DAttributeString getAttDocStatus() { return moAttDocStatus; }

    public cfd.ext.grupomodelo.DElementPaymentIdentification getEltPaymentIdentification() { return moEltPaymentIdentification; }
    public cfd.ext.grupomodelo.DElementSpecialInstruction getEltSpecialInstruction() { return moEltSpecialInstruction; }
    public cfd.ext.grupomodelo.DElementOrderIdentification getEltOrderIdentification() { return moEltOrderIdentification; }
    public cfd.ext.grupomodelo.DElementBuyer getEltBuyer() { return moEltBuyer; }
    public cfd.ext.grupomodelo.DElementInvoiceCreator getEltInvoiceCreator() { return moEltInvoiceCreator; }
    public cfd.ext.grupomodelo.DElementCurrency getEltCurrency() { return moEltCurrency; }
    public cfd.ext.grupomodelo.DElementItems getEltItem() { return moEltItems; }
    public cfd.ext.grupomodelo.DElementTotalAmount getEltTotalAmount() { return moEltTotalAmount; }
    public cfd.ext.grupomodelo.DElementBaseAmount getEltBaseAmount() { return moEltBaseAmount; }
    public cfd.ext.grupomodelo.DElementTax getEltTax() { return moEltTax; }
    public cfd.ext.grupomodelo.DElementPayableAmount getEltPayableAmount() { return moEltPayableAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
