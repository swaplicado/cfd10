/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttributeOptionImpuestoTraslado;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestoTraslado extends cfd.DElement {

    protected cfd.DAttributeOptionImpuestoTraslado moAttImpuesto;
    protected cfd.DAttributeTypeImporte moAttTasa;
    protected cfd.DAttributeTypeImporte moAttImporte;

    public DElementImpuestoTraslado() {
        super("Traslado");

        moAttImpuesto = new DAttributeOptionImpuestoTraslado("impuesto", true);
        moAttTasa = new DAttributeTypeImporte("tasa", true);
        moAttTasa.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttImpuesto);
        mvAttributes.add(moAttTasa);
        mvAttributes.add(moAttImporte);
    }

    public cfd.DAttributeOptionImpuestoTraslado getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeTypeImporte getAttTasa() { return moAttTasa; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
}
