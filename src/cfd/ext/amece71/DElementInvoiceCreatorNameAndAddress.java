/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementInvoiceCreatorNameAndAddress extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressName moEltName;
    protected cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressStreetAddressOne moEltStreetAddressOne;
    protected cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressCity moEltCity;
    protected cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressPostalCode moEltPostalCode;

    public DElementInvoiceCreatorNameAndAddress() {
        super("nameAndAddress");

        moEltName = new DElementInvoiceCreatorNameAndAddressName("");
        moEltStreetAddressOne = new DElementInvoiceCreatorNameAndAddressStreetAddressOne("");
        moEltCity = new DElementInvoiceCreatorNameAndAddressCity("");
        moEltPostalCode = new DElementInvoiceCreatorNameAndAddressPostalCode("");

        mvElements.add(moEltName);
        mvElements.add(moEltStreetAddressOne);
        mvElements.add(moEltCity);
        mvElements.add(moEltPostalCode);
    }
    
    public cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressName getEltName() { return moEltName; }
    public cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressStreetAddressOne getEltStreetAddressOne() { return moEltStreetAddressOne; }
    public cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressCity getEltCity() { return moEltCity; }
    public cfd.ext.amece71.DElementInvoiceCreatorNameAndAddressPostalCode getEltPostalCode() { return moEltPostalCode; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
