/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTotalLineAmount extends cfd.DElementParent {

   protected cfd.ext.amece71.DElementGrossAmount moEltGrossAmount;
   protected cfd.ext.amece71.DElementNetAmount moEltNetAmount;

    public DElementTotalLineAmount() {
        super("totalLineAmount");

        moEltGrossAmount = new DElementGrossAmount();
        moEltNetAmount = new DElementNetAmount();

        mvElements.add(moEltGrossAmount);
    }

    public cfd.ext.amece71.DElementGrossAmount getEltGrossAmount() { return moEltGrossAmount; }
    public cfd.ext.amece71.DElementNetAmount getEltNetAmount() { return moEltNetAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
