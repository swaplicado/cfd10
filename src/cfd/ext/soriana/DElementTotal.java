/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTotal extends cfd.DElement {

    public DElementTotal(java.lang.String value) {
        super("Total", value);
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
