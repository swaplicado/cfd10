/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementLineItemNetPrice extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementAmount moEltAmount;

    public DElementLineItemNetPrice() {
        super("netPrice");

        moEltAmount = new DElementAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.amece71.DElementAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
