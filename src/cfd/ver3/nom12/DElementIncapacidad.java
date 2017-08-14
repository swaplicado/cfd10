/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementIncapacidad extends cfd.DElement {

    protected cfd.DAttributeInteger moAttDiasIncapacidad;
    protected cfd.DAttributeString moAttTipoIncapacidad;
    protected cfd.DAttributeTypeImporte moAttImporteMonetario;

    public DElementIncapacidad() {
        super("nomina12:Incapacidad");

        moAttDiasIncapacidad = new DAttributeInteger("DiasIncapacidad", true, 1);
        moAttTipoIncapacidad = new DAttributeString("TipoIncapacidad", true, 2, 2);
        moAttImporteMonetario = new DAttributeTypeImporte("ImporteMonetario", false);
        moAttImporteMonetario.setCanBeZero(true);

        mvAttributes.add(moAttDiasIncapacidad);
        mvAttributes.add(moAttTipoIncapacidad);
        mvAttributes.add(moAttImporteMonetario);
    }

    public cfd.DAttributeInteger getAttDiasIncapacidad() { return moAttDiasIncapacidad; }
    public cfd.DAttributeString getAttTipoIncapacidad() { return moAttTipoIncapacidad; }
    public cfd.DAttributeTypeImporte getAttImporteMonetario() { return moAttImporteMonetario; }
}
