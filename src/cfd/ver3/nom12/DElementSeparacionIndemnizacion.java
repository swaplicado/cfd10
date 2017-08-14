/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeInteger;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementSeparacionIndemnizacion extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalPagado;
    protected cfd.DAttributeInteger moAttNumAñosServicio;
    protected cfd.DAttributeTypeImporte moAttUltimoSueldoMensOrd;
    protected cfd.DAttributeTypeImporte moAttIngresoAcumulable;
    protected cfd.DAttributeTypeImporte moAttIngresoNoAcumulable;

    public DElementSeparacionIndemnizacion() {
        super("nomina12:SeparacionIndemnizacion");

        moAttTotalPagado = new DAttributeTypeImporte("TotalPagado", true);
        moAttTotalPagado.setCanBeZero(true);
        moAttNumAñosServicio = new DAttributeInteger("NumAñosServicio", true);
        moAttUltimoSueldoMensOrd = new DAttributeTypeImporte("UltimoSueldoMensOrd", true);
        moAttUltimoSueldoMensOrd.setCanBeZero(true);
        moAttIngresoAcumulable = new DAttributeTypeImporte("IngresoAcumulable", true);
        moAttIngresoAcumulable.setCanBeZero(true);
        moAttIngresoNoAcumulable = new DAttributeTypeImporte("IngresoNoAcumulable", true);
        moAttIngresoNoAcumulable.setCanBeZero(true);

        mvAttributes.add(moAttTotalPagado);
        mvAttributes.add(moAttNumAñosServicio);
        mvAttributes.add(moAttUltimoSueldoMensOrd);
        mvAttributes.add(moAttIngresoAcumulable);
        mvAttributes.add(moAttIngresoNoAcumulable);
    }

    public cfd.DAttributeTypeImporte getAttTotalPagado() { return moAttTotalPagado; }
    public cfd.DAttributeInteger getAttNumAñosServicio() { return moAttNumAñosServicio; }
    public cfd.DAttributeTypeImporte getAttUltimoSueldoMensOrd() { return moAttUltimoSueldoMensOrd; }
    public cfd.DAttributeTypeImporte getAttIngresoAcumulable() { return moAttIngresoAcumulable; }
    public cfd.DAttributeTypeImporte getAttIngresoNoAcumulable() { return moAttIngresoNoAcumulable; }
}
