/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAmountTotal extends cfd.DElement {

    public DElementAmountTotal(java.lang.String value) {
        super("Amount", value);
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
