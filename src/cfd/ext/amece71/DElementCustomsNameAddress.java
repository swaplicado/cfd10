/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Juan Barajas
 */
public class DElementCustomsNameAddress extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementCustomsName moEltName;
    //protected cfd.ext.soriana.DElementCustomsStreetAddressOne moEltStreetAddressOne;
    protected cfd.ext.amece71.DElementCustomsCity moEltCity;
    //protected cfd.ext.soriana.DElementCustomsPostalCode moEltPostalCode;

    public DElementCustomsNameAddress() {
        super("nameAndAddress");

        moEltName = new DElementCustomsName("");
        //moEltStreetAddressOne = new DElementCustomsStreetAddressOne("");
        moEltCity = new DElementCustomsCity("");
        //moEltPostalCode = new DElementCustomsPostalCode("");

        mvElements.add(moEltName);
        //mvElements.add(moEltStreetAddressOne);
        mvElements.add(moEltCity);
        //mvElements.add(moEltPostalCode);
    }
    
    public cfd.ext.amece71.DElementCustomsName getEltName() { return moEltName; }
    //public cfd.ext.soriana.DElementCustomsStreetAddressOne getEltStreetAddressOne() { return moEltStreetAddressOne; }
    public cfd.ext.amece71.DElementCustomsCity getEltCity() { return moEltCity; }
    //public cfd.ext.soriana.DElementCustomsPostalCode getEltPostalCode() { return moEltPostalCode; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
