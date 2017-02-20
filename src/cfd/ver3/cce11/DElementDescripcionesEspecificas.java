/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementDescripcionesEspecificas extends cfd.DElement {

    protected cfd.DAttributeString moAttMarca;
    protected cfd.DAttributeString moAttModelo;
    protected cfd.DAttributeString moAttSubModelo;
    protected cfd.DAttributeString moAttNumeroSerie;

    public DElementDescripcionesEspecificas() {
        super("cfdi:DescripcionesEspecificas");

        moAttMarca = new DAttributeString("Marca", true);
        moAttModelo = new DAttributeString("Modelo", false);
        moAttSubModelo = new DAttributeString("SubModelo", false);
        moAttNumeroSerie = new DAttributeString("NumeroSerie", false);

        mvAttributes.add(moAttMarca);
        mvAttributes.add(moAttModelo);
        mvAttributes.add(moAttSubModelo);
        mvAttributes.add(moAttNumeroSerie);
    }

    public cfd.DAttributeString getAttMarca() { return moAttMarca; }
    public cfd.DAttributeString getAttModelo() { return moAttModelo; }
    public cfd.DAttributeString getAttSubModelo() { return moAttSubModelo; }
    public cfd.DAttributeString getAttNumeroSerie() { return moAttNumeroSerie; }
}
