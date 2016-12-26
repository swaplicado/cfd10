/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementJubilacionPensionRetiro extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalExhibicion;
    protected cfd.DAttributeTypeImporte moAttTotalParcialidad;
    protected cfd.DAttributeTypeImporte moAttMontoDiario;
    protected cfd.DAttributeTypeImporte moAttIngresoAcumulable;
    protected cfd.DAttributeTypeImporte moAttIngresoNoAcumulable;

    public DElementJubilacionPensionRetiro() {
        super("nomina:JubilacionPensionRetiro");

        moAttTotalExhibicion = new DAttributeTypeImporte("TotalUnaExhibicion", false);
        moAttTotalExhibicion.setCanBeZero(true);
        moAttTotalParcialidad = new DAttributeTypeImporte("TotalParcialidad", false);
        moAttTotalParcialidad.setCanBeZero(true);
        moAttMontoDiario = new DAttributeTypeImporte("MontoDiario", false);
        moAttMontoDiario.setCanBeZero(true);
        moAttIngresoAcumulable = new DAttributeTypeImporte("IngresoAcumulable", true);
        moAttIngresoAcumulable.setCanBeZero(true);
        moAttIngresoNoAcumulable = new DAttributeTypeImporte("IngresoNoAcumulable", true);
        moAttIngresoNoAcumulable.setCanBeZero(true);

        mvAttributes.add(moAttTotalExhibicion);
        mvAttributes.add(moAttTotalParcialidad);
        mvAttributes.add(moAttMontoDiario);
        mvAttributes.add(moAttIngresoAcumulable);
        mvAttributes.add(moAttIngresoNoAcumulable);
    }

    public cfd.DAttributeTypeImporte getAttTotalExhibicion() { return moAttTotalExhibicion; }
    public cfd.DAttributeTypeImporte getAttTotalParcialidad() { return moAttTotalParcialidad; }
    public cfd.DAttributeTypeImporte getAttMontoDiario() { return moAttMontoDiario; }
    public cfd.DAttributeTypeImporte getAttIngresoAcumulable() { return moAttIngresoAcumulable; }
    public cfd.DAttributeTypeImporte getAttIngresoNoAcumulable() { return moAttIngresoNoAcumulable; }
}
