/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementShipToNameAndAddress extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementShipToNameAndAddressName moEltName;
    protected cfd.ext.amece71.DElementShipToNameAndAddressStreetAddressOne moEltStreetAddressOne;
    protected cfd.ext.amece71.DElementShipToNameAndAddressCity moEltCity;
    protected cfd.ext.amece71.DElementShipToNameAndAddressPostalCode moEltPostalCode;

    public DElementShipToNameAndAddress() {
        super("nameAndAddress");

        moEltName = new DElementShipToNameAndAddressName("");
        moEltStreetAddressOne = new DElementShipToNameAndAddressStreetAddressOne("");
        moEltCity = new DElementShipToNameAndAddressCity("");
        moEltPostalCode = new DElementShipToNameAndAddressPostalCode("");

        mvElements.add(moEltName);
        mvElements.add(moEltStreetAddressOne);
        mvElements.add(moEltCity);
        mvElements.add(moEltPostalCode);
    }
    
    public cfd.ext.amece71.DElementShipToNameAndAddressName getEltName() { return moEltName; }
    public cfd.ext.amece71.DElementShipToNameAndAddressStreetAddressOne getEltStreetAddressOne() { return moEltStreetAddressOne; }
    public cfd.ext.amece71.DElementShipToNameAndAddressCity getEltCity() { return moEltCity; }
    public cfd.ext.amece71.DElementShipToNameAndAddressPostalCode getEltPostalCode() { return moEltPostalCode; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
