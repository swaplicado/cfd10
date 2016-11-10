/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementBaseAmount extends cfd.DElementParent {

   protected cfd.ext.grupomodelo.DElementAmount moEltAmount;

    public DElementBaseAmount() {
        super("modelo:baseAmount");

        moEltAmount = new DElementAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.grupomodelo.DElementAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
