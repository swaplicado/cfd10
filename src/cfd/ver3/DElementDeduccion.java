/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementDeduccion extends cfd.DElement {

    protected cfd.DAttributeInteger moAttTipoDeduccion;
    protected cfd.DAttributeString moAttClave;
    protected cfd.DAttributeString moAttConcepto;
    protected cfd.DAttributeTypeImporte moAttImporteGravado;
    protected cfd.DAttributeTypeImporte moAttImporteExento;

    public DElementDeduccion() {
        super("nomina:Deduccion");

        moAttTipoDeduccion = new DAttributeInteger("TipoDeduccion", true, 1, 3, 3);
        moAttClave = new DAttributeString("Clave", true, 3, 15);
        moAttConcepto = new DAttributeString("Concepto", true, 1);
        moAttImporteGravado = new DAttributeTypeImporte("ImporteGravado", true);
        moAttImporteGravado.setCanBeZero(true);
        moAttImporteExento = new DAttributeTypeImporte("ImporteExento", true);
        moAttImporteExento.setCanBeZero(true);

        mvAttributes.add(moAttTipoDeduccion);
        mvAttributes.add(moAttClave);
        mvAttributes.add(moAttConcepto);
        mvAttributes.add(moAttImporteGravado);
        mvAttributes.add(moAttImporteExento);
    }

    public cfd.DAttributeInteger getAttTipoDeduccion() { return moAttTipoDeduccion; }
    public cfd.DAttributeString getAttClave() { return moAttClave; }
    public cfd.DAttributeString getAttConcepto() { return moAttConcepto; }
    public cfd.DAttributeTypeImporte getAttImporteGravado() { return moAttImporteGravado; }
    public cfd.DAttributeTypeImporte getAttImporteExento() { return moAttImporteExento; }
}
