/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDescripcionesEspecificas extends cfd.DElement {

    private final DAttributeString moAttMarca;
    private final DAttributeString moAttModelo;
    private final DAttributeString moAttSubModelo;
    private final DAttributeString moAttNumeroSerie;

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

    public DAttributeString getAttMarca() { return moAttMarca; }
    public DAttributeString getAttModelo() { return moAttModelo; }
    public DAttributeString getAttSubModelo() { return moAttSubModelo; }
    public DAttributeString getAttNumeroSerie() { return moAttNumeroSerie; }
}
