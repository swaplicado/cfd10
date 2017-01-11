/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeDouble;

/**
 *
 * @author Juan Barajas
 */
public class DElementAccionesTitulos extends cfd.DElement {

    protected cfd.DAttributeDouble moAttValorMercado;
    protected cfd.DAttributeDouble moAttPrecioOtrogarse;

    public DElementAccionesTitulos() {
        super("nomina12:AccionesOTitulos");

        moAttValorMercado = new DAttributeDouble("ValorMercado", true, 6);
        moAttPrecioOtrogarse = new DAttributeDouble("PrecioAlOtrogarse", true, 6);

        mvAttributes.add(moAttValorMercado);
        mvAttributes.add(moAttPrecioOtrogarse);
    }

    public cfd.DAttributeDouble getAttValorMercado() { return moAttValorMercado; }
    public cfd.DAttributeDouble getAttPrecioOtrogarse() { return moAttPrecioOtrogarse; }
}
