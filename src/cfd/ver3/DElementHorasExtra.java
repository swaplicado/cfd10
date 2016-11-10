/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttribute;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementHorasExtra extends cfd.DElement {

    protected cfd.DAttributeInteger moAttDias;
    protected cfd.DAttributeString moAttTipoHoras;
    protected cfd.DAttributeInteger moAttHorasExtra;
    protected cfd.DAttributeTypeImporte moAttImportePagado;

    public DElementHorasExtra() {
        super("nomina:HorasExtra");

        moAttDias = new DAttributeInteger("Dias", true);
        moAttDias.setCanBeZero(true);
        moAttTipoHoras = new DAttributeString("TipoHoras", true, 1);
        moAttHorasExtra = new DAttributeInteger("HorasExtra", true);
        moAttHorasExtra.setCanBeZero(true);
        moAttImportePagado = new DAttributeTypeImporte("ImportePagado", true);
        moAttImportePagado.setCanBeZero(true);

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
