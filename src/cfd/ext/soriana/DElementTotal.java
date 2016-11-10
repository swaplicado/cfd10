/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Juan Barajas
 */
public class DElementTotal extends cfd.DElement {

    public DElementTotal(java.lang.String value) {
        super("Total", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
