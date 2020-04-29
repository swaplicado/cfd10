/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCustomsNameAndAddress extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementCustomsNameAndAddressName moEltName;
    protected cfd.ext.amece71.DElementCustomsNameAndAddressCity moEltCity;

    public DElementCustomsNameAndAddress() {
        super("nameAndAddress");

        moEltName = new DElementCustomsNameAndAddressName("");
        moEltCity = new DElementCustomsNameAndAddressCity("");

        mvElements.add(moEltName);
        mvElements.add(moEltCity);
    }
    
    public cfd.ext.amece71.DElementCustomsNameAndAddressName getEltName() { return moEltName; }
    public cfd.ext.amece71.DElementCustomsNameAndAddressCity getEltCity() { return moEltCity; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
