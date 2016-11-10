/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementTotalLineAmount extends cfd.DElementParent {

   protected cfd.ext.grupomodelo.DElementGrossAmount moEltGrossAmount;
   protected cfd.ext.grupomodelo.DElementNetAmount moEltNetAmount;

    public DElementTotalLineAmount() {
        super("modelo:totalLineAmount");

        moEltGrossAmount = new DElementGrossAmount();
        moEltNetAmount = new DElementNetAmount();

        mvElements.add(moEltGrossAmount);
        mvElements.add(moEltNetAmount);
    }

    public cfd.ext.grupomodelo.DElementGrossAmount getEltGrossAmount() { return moEltGrossAmount; }
    public cfd.ext.grupomodelo.DElementNetAmount getEltNetAmount() { return moEltNetAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
