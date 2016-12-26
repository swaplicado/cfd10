/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeInteger;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementCompensacionSaldosFavor extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttSaldoFavor;
    protected cfd.DAttributeInteger moAttAño;
    protected cfd.DAttributeTypeImporte moAttRemanenteSalFav;

    public DElementCompensacionSaldosFavor() {
        super("nomina:CompensacionSaldosAFavor");

        moAttSaldoFavor = new DAttributeTypeImporte("SaldoAFavor", true);
        moAttAño = new DAttributeInteger("Año", true, 4);
        moAttRemanenteSalFav = new DAttributeTypeImporte("RemanenteSalFav", true);
        moAttRemanenteSalFav.setCanBeZero(true);

        mvAttributes.add(moAttSaldoFavor);
        mvAttributes.add(moAttAño);
        mvAttributes.add(moAttRemanenteSalFav);
    }

    public cfd.DAttributeTypeImporte getAttSaldoFavor() { return moAttSaldoFavor; }
    public cfd.DAttributeInteger getAttAño() { return moAttAño; }
    public cfd.DAttributeTypeImporte getAttRemanenteSalFav() { return moAttRemanenteSalFav; }
}
