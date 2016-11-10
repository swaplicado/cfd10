/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttributeDate;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementInformacionAduanera extends cfd.DElement {

    protected cfd.DAttributeString moAttNumero;
    protected cfd.DAttributeDate moAttFecha;
    protected cfd.DAttributeString moAttAduana;

    public DElementInformacionAduanera() {
        super("InformacionAduanera");

        moAttNumero = new DAttributeString("numero", true);
        moAttFecha = new DAttributeDate("fecha", true);
        moAttAduana = new DAttributeString("aduana", false, 1);

        mvAttributes.add(moAttNumero);
        mvAttributes.add(moAttFecha);
        mvAttributes.add(moAttAduana);
    }

    public cfd.DAttributeString getAttNumero() { return moAttNumero; }
    public cfd.DAttributeDate getAttFecha() { return moAttFecha; }
    public cfd.DAttributeString getAttAduana() { return moAttAduana; }
}
