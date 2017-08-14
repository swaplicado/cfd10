/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom11;

import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPercepcion extends cfd.DElement {

    protected cfd.DAttributeInteger moAttTipoPercepcion;
    protected cfd.DAttributeString moAttClave;
    protected cfd.DAttributeString moAttConcepto;
    protected cfd.DAttributeTypeImporte moAttImporteGravado;
    protected cfd.DAttributeTypeImporte moAttImporteExento;

    public DElementPercepcion() {
        super("nomina:Percepcion");

        moAttTipoPercepcion = new DAttributeInteger("TipoPercepcion", true, 1, 3, 3);
        moAttClave = new DAttributeString("Clave", true, 3, 15);
        moAttConcepto = new DAttributeString("Concepto", true, 1);
        moAttImporteGravado = new DAttributeTypeImporte("ImporteGravado", true);
        moAttImporteGravado.setCanBeZero(true);
        moAttImporteExento = new DAttributeTypeImporte("ImporteExento", true);
        moAttImporteExento.setCanBeZero(true);

        mvAttributes.add(moAttTipoPercepcion);
        mvAttributes.add(moAttClave);
        mvAttributes.add(moAttConcepto);
        mvAttributes.add(moAttImporteGravado);
        mvAttributes.add(moAttImporteExento);
    }

    public cfd.DAttributeInteger getAttTipoPercepcion() { return moAttTipoPercepcion; }
    public cfd.DAttributeString getAttClave() { return moAttClave; }
    public cfd.DAttributeString getAttConcepto() { return moAttConcepto; }
    public cfd.DAttributeTypeImporte getAttImporteGravado() { return moAttImporteGravado; }
    public cfd.DAttributeTypeImporte getAttImporteExento() { return moAttImporteExento; }
}
