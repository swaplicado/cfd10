/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementGrossAmount extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementAmount moEltAmount;

    public DElementGrossAmount() {
        super("modelo:grossAmount");

        moEltAmount = new DElementAmount("");

        mvElements.add(moEltAmount);
    }

    public cfd.ext.grupomodelo.DElementAmount getEltAmount() { return moEltAmount; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
