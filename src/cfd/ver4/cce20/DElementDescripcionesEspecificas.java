/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver4.cce20;

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
        super("cce20:DescripcionesEspecificas");

        moAttMarca = new DAttributeString("Marca", true, 1, 35);
        moAttModelo = new DAttributeString("Modelo", false, 1, 80);
        moAttSubModelo = new DAttributeString("SubModelo", false, 1, 50);
        moAttNumeroSerie = new DAttributeString("NumeroSerie", false, 1, 40);

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
