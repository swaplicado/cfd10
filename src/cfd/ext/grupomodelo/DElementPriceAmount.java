/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementPriceAmount extends cfd.DElement {

    public DElementPriceAmount(java.lang.String value) {
        super("modelo:Amount", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
