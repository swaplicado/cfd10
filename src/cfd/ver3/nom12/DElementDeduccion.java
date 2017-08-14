/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDeduccion extends cfd.DElement {

    protected cfd.DAttributeString moAttTipoDeduccion;
    protected cfd.DAttributeString moAttClave;
    protected cfd.DAttributeString moAttConcepto;
    protected cfd.DAttributeTypeImporte moAttImporte;

    public DElementDeduccion() {
        super("nomina12:Deduccion");

        moAttTipoDeduccion = new DAttributeString("TipoDeduccion", true, 3, 3);
        moAttClave = new DAttributeString("Clave", true, 3, 15);
        moAttConcepto = new DAttributeString("Concepto", true, 1);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttTipoDeduccion);
        mvAttributes.add(moAttClave);
        mvAttributes.add(moAttConcepto);
        mvAttributes.add(moAttImporte);
    }

    public cfd.DAttributeString getAttTipoDeduccion() { return moAttTipoDeduccion; }
    public cfd.DAttributeString getAttClave() { return moAttClave; }
    public cfd.DAttributeString getAttConcepto() { return moAttConcepto; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
}
