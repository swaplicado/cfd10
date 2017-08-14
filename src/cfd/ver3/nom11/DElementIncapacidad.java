/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom11;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementIncapacidad extends cfd.DElement {

    protected cfd.DAttributeDouble moAttDiasIncapacidad;
    protected cfd.DAttributeInteger moAttTipoIncapacidad;
    protected cfd.DAttributeTypeImporte moAttDescuento;

    public DElementIncapacidad() {
        super("nomina:Incapacidad");

        moAttDiasIncapacidad = new DAttributeDouble("DiasIncapacidad", true, 6);
        moAttTipoIncapacidad = new DAttributeInteger("TipoIncapacidad", true, 1);
        moAttDescuento = new DAttributeTypeImporte("Descuento", true);
        moAttDescuento.setCanBeZero(true);

        mvAttributes.add(moAttDiasIncapacidad);
        mvAttributes.add(moAttTipoIncapacidad);
        mvAttributes.add(moAttDescuento);
    }

    public cfd.DAttributeDouble getAttDiasIncapacidad() { return moAttDiasIncapacidad; }
    public cfd.DAttributeInteger getAttTipoIncapacidad() { return moAttTipoIncapacidad; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }
}
