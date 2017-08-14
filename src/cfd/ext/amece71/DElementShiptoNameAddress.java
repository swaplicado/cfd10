/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementShiptoNameAddress extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementShiptoName moEltName;
    protected cfd.ext.amece71.DElementShiptoStreetAddressOne moEltStreetAddressOne;
    protected cfd.ext.amece71.DElementShiptoCity moEltCity;
    protected cfd.ext.amece71.DElementShiptoPostalCode moEltPostalCode;

    public DElementShiptoNameAddress() {
        super("nameAndAddress");

        moEltName = new DElementShiptoName("");
        moEltStreetAddressOne = new DElementShiptoStreetAddressOne("");
        moEltCity = new DElementShiptoCity("");
        moEltPostalCode = new DElementShiptoPostalCode("");

        mvElements.add(moEltName);
        mvElements.add(moEltStreetAddressOne);
        mvElements.add(moEltCity);
        mvElements.add(moEltPostalCode);
    }
    
    public cfd.ext.amece71.DElementShiptoName getEltName() { return moEltName; }
    public cfd.ext.amece71.DElementShiptoStreetAddressOne getEltStreetAddressOne() { return moEltStreetAddressOne; }
    public cfd.ext.amece71.DElementShiptoCity getEltCity() { return moEltCity; }
    public cfd.ext.amece71.DElementShiptoPostalCode getEltPostalCode() { return moEltPostalCode; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
