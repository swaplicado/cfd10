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
public class DElementHorasExtra extends cfd.DElement {

    protected cfd.DAttributeInteger moAttDias;
    protected cfd.DAttributeString moAttTipoHoras;
    protected cfd.DAttributeInteger moAttHorasExtra;
    protected cfd.DAttributeTypeImporte moAttImportePagado;

    public DElementHorasExtra() {
        super("nomina12:HorasExtra");

        moAttDias = new DAttributeInteger("Dias", true);
        moAttTipoHoras = new DAttributeString("TipoHoras", true);
        moAttHorasExtra = new DAttributeInteger("HorasExtra", true);
        moAttImportePagado = new DAttributeTypeImporte("ImportePagado", true);

        mvAttributes.add(moAttDias);
        mvAttributes.add(moAttTipoHoras);
        mvAttributes.add(moAttHorasExtra);
        mvAttributes.add(moAttImportePagado);
    }

    public cfd.DAttributeInteger getAttDias() { return moAttDias; }
    public cfd.DAttributeString getAttTipoHoras() { return moAttTipoHoras; }
    public cfd.DAttributeInteger getAttHorasExtra() { return moAttHorasExtra; }
    public cfd.DAttributeTypeImporte getAttImportePagado() { return moAttImportePagado; }
}
