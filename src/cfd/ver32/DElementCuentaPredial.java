/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCuentaPredial extends cfd.DElement {

    protected cfd.DAttributeString moAttNumero;

    public DElementCuentaPredial() {
        super("cfdi:CuentaPredial");

        moAttNumero = new DAttributeString("numero", true, 1);

        mvAttributes.add(moAttNumero);
    }

    public cfd.DAttributeString getAttNumero() { return moAttNumero; }
}
