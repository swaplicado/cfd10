/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

import cfd.DAttributeDate;
import cfd.DAttributeString;
import cfd.DElementExtAddendaType;

/**
 *
 * @author Juan Barajas
 */
public class DElementPayment extends cfd.DElementExtAddenda {

    protected cfd.DAttributeString moAttType;
    protected cfd.DAttributeString moAttContentVersion;
    protected cfd.DAttributeString moAttDocStructureVersion;
    protected cfd.DAttributeString moAttDocStatus;
    protected cfd.DAttributeDate moAttDeliveryDate;

    protected cfd.ext.amece71.DElementPaymentIdentification moEltPaymentIdentification;
    protected cfd.ext.amece71.DElementSpecialInstruction moEltSpecialInstruction;
    protected cfd.ext.amece71.DElementOrderIdentification moEltOrderIdentification;
    protected cfd.ext.amece71.DElementAdditionalInformation moEltAdditionalInformation;
    protected cfd.ext.amece71.DElementDeliveryNote moEltDeliveryNote;
    protected cfd.ext.amece71.DElementBuyer moEltBuyer;
    protected cfd.ext.amece71.DElementSeller moEltSeller;
    protected cfd.ext.amece71.DElementShipTo moEltShipTo;
    protected cfd.ext.amece71.DElementInvoiceCreator moEltInvoiceCreator;
    protected cfd.ext.amece71.DElementCustoms moEltCustoms;
    protected cfd.ext.amece71.DElementCurrency moEltCurrency;
    protected cfd.ext.amece71.DElementPaymentTerms moEltPaymentTerms;
    protected cfd.ext.amece71.DElementItems moEltItems;
    protected cfd.ext.amece71.DElementTotalAmount moEltTotalAmount;
    protected cfd.ext.amece71.DElementTax moEltTax;
    protected cfd.ext.amece71.DElementPayableAmount moEltPayableAmount;

    public DElementPayment() {
        super("requestForPayment", DElementExtAddendaType.Amece71);

        moAttType = new DAttributeString("type", true);
        moAttType.setString("SimpleInvoiceType");
        moAttContentVersion = new DAttributeString("contentVersion", true);
        moAttContentVersion.setString("1.3.1");
        moAttDocStructureVersion = new DAttributeString("documentStructureVersion", true);
        moAttDocStructureVersion.setString("AMC7.1");
        moAttDocStatus = new DAttributeString("documentStatus", true);
        moAttDeliveryDate = new DAttributeDate("DeliveryDate", true);

        moEltPaymentIdentification = new DElementPaymentIdentification();
        moEltSpecialInstruction = new DElementSpecialInstruction();
        moEltOrderIdentification = new DElementOrderIdentification();
        moEltDeliveryNote = new DElementDeliveryNote();
        moEltBuyer = new DElementBuyer();
        moEltSeller = new DElementSeller();
        moEltShipTo = new DElementShipTo();
        moEltInvoiceCreator = new DElementInvoiceCreator();
        moEltCustoms = new DElementCustoms();
        moEltCurrency = new DElementCurrency();
        moEltPaymentTerms = new DElementPaymentTerms();
        moEltItems = new DElementItems();
        moEltTotalAmount = new DElementTotalAmount();
        moEltTax = new DElementTax();
        moEltPayableAmount = new DElementPayableAmount();

        mvAttributes.add(moAttType);
        mvAttributes.add(moAttContentVersion);
        mvAttributes.add(moAttDocStructureVersion);
        mvAttributes.add(moAttDocStatus);
        mvAttributes.add(moAttDeliveryDate);

        mvElements.add(moEltPaymentIdentification);
        mvElements.add(moEltSpecialInstruction);
        mvElements.add(moEltOrderIdentification);
        mvElements.add(moEltDeliveryNote);
        mvElements.add(moEltBuyer);
        mvElements.add(moEltSeller);
        mvElements.add(moEltShipTo);
        mvElements.add(moEltInvoiceCreator);
        mvElements.add(moEltCustoms);
        mvElements.add(moEltCurrency);
        mvElements.add(moEltPaymentTerms);
        mvElements.add(moEltItems);
        mvElements.add(moEltTotalAmount);
        mvElements.add(moEltTax);
        mvElements.add(moEltPayableAmount);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }
    public cfd.DAttributeString getAttContentVersion() { return moAttContentVersion; }
    public cfd.DAttributeString getAttDocStructureVersion() { return moAttDocStructureVersion; }
    public cfd.DAttributeString getAttDocStatus() { return moAttDocStatus; }
    public cfd.DAttributeDate getAttDeliveryDate() { return moAttDeliveryDate; }

    public cfd.ext.amece71.DElementPaymentIdentification getEltPaymentIdentification() { return moEltPaymentIdentification; }
    public cfd.ext.amece71.DElementSpecialInstruction getEltSpecialInstruction() { return moEltSpecialInstruction; }
    public cfd.ext.amece71.DElementOrderIdentification getEltOrderIdentification() { return moEltOrderIdentification; }
    public cfd.ext.amece71.DElementDeliveryNote getEltDeliveryNote() { return moEltDeliveryNote; }
    public cfd.ext.amece71.DElementBuyer getEltBuyer() { return moEltBuyer; }
    public cfd.ext.amece71.DElementSeller getEltSeller() { return moEltSeller; }
    public cfd.ext.amece71.DElementShipTo getEltShipTo() { return moEltShipTo; }
    public cfd.ext.amece71.DElementInvoiceCreator getEltInvoiceCreator() { return moEltInvoiceCreator; }
    public cfd.ext.amece71.DElementCustoms getEltCustoms() { return moEltCustoms; }
    public cfd.ext.amece71.DElementCurrency getEltCurrency() { return moEltCurrency; }
    public cfd.ext.amece71.DElementPaymentTerms getEltPaymentTerms() { return moEltPaymentTerms; }
    public cfd.ext.amece71.DElementItems getEltItem() { return moEltItems; }
    public cfd.ext.amece71.DElementTotalAmount getEltTotalAmount() { return moEltTotalAmount; }
    public cfd.ext.amece71.DElementTax getEltTax() { return moEltTax; }
    public cfd.ext.amece71.DElementPayableAmount getEltPayableAmount() { return moEltPayableAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
