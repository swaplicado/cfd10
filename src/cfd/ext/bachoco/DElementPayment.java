/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

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

    protected cfd.ext.bachoco.DElementPaymentIdentification moEltPaymentIdentification;
    protected cfd.ext.bachoco.DElementSpecialInstruction moEltSpecialInstruction;
    protected cfd.ext.bachoco.DElementOrderIdentification moEltOrderIdentification;
    protected cfd.ext.bachoco.DElementDeliveryNote moEltDeliveryNote;
    protected cfd.ext.bachoco.DElementBuyer moEltBuyer;
    protected cfd.ext.bachoco.DElementSeller moEltSeller;
    protected cfd.ext.bachoco.DElementShipTo moEltShipTo;
    protected cfd.ext.bachoco.DElementInvoiceCreator moEltInvoiceCreator;
    protected cfd.ext.bachoco.DElementCustoms moEltCustoms;
    protected cfd.ext.bachoco.DElementCurrency moEltCurrency;
    protected cfd.ext.bachoco.DElementItems moEltItems;
    protected cfd.ext.bachoco.DElementTotalAmount moEltTotalAmount;
    protected cfd.ext.bachoco.DElementTax moEltTax;
    protected cfd.ext.bachoco.DElementPayableAmount moEltPayableAmount;

    public DElementPayment() {
        super("requestForPayment", DElementExtAddendaType.Bachoco);

        moAttType = new DAttributeString("type", true);
        moAttContentVersion = new DAttributeString("contentVersion", true);
        moAttDocStructureVersion = new DAttributeString("documentStructureVersion", true);
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

    public cfd.ext.bachoco.DElementPaymentIdentification getEltPaymentIdentification() { return moEltPaymentIdentification; }
    public cfd.ext.bachoco.DElementSpecialInstruction getEltSpecialInstruction() { return moEltSpecialInstruction; }
    public cfd.ext.bachoco.DElementOrderIdentification getEltOrderIdentification() { return moEltOrderIdentification; }
    public cfd.ext.bachoco.DElementDeliveryNote getEltDeliveryNote() { return moEltDeliveryNote; }
    public cfd.ext.bachoco.DElementBuyer getEltBuyer() { return moEltBuyer; }
    public cfd.ext.bachoco.DElementSeller getEltSeller() { return moEltSeller; }
    public cfd.ext.bachoco.DElementShipTo getEltShipTo() { return moEltShipTo; }
    public cfd.ext.bachoco.DElementInvoiceCreator getEltInvoiceCreator() { return moEltInvoiceCreator; }
    public cfd.ext.bachoco.DElementCustoms getEltCustoms() { return moEltCustoms; }
    public cfd.ext.bachoco.DElementCurrency getEltCurrency() { return moEltCurrency; }
    public cfd.ext.bachoco.DElementItems getEltItem() { return moEltItems; }
    public cfd.ext.bachoco.DElementTotalAmount getEltTotalAmount() { return moEltTotalAmount; }
    public cfd.ext.bachoco.DElementTax getEltTax() { return moEltTax; }
    public cfd.ext.bachoco.DElementPayableAmount getEltPayableAmount() { return moEltPayableAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
