/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
 */
public class DElementTaxTypeDescription extends cfd.DElement {

    public DElementTaxTypeDescription(java.lang.String value) {
        super("modelo:taxTypeDescription", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
