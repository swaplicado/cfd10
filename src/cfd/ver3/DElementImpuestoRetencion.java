/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttributeOptionImpuestoRetencion;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestoRetencion extends cfd.DElement {

    protected cfd.DAttributeOptionImpuestoRetencion moAttImpuesto;
    protected cfd.DAttributeTypeImporte moAttImporte;

    public DElementImpuestoRetencion() {
        super("cfdi:Retencion");

        moAttImpuesto = new DAttributeOptionImpuestoRetencion("impuesto", true);
        moAttImporte = new DAttributeTypeImporte("importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttImpuesto);
        mvAttributes.add(moAttImporte);
    }

    public cfd.DAttributeOptionImpuestoRetencion getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
}
