/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttributeDouble;
import cfd.DAttributeString;

/**
 *
 * @author Néstor Ávalos Balcázar
 */
public class DElementTrasladado extends cfd.DElementParent {

    protected cfd.DAttributeString moAttImpuesto;
    protected cfd.DAttributeDouble moAttTasa;
    protected cfd.DAttributeDouble moAttImporte;

    public DElementTrasladado() {
        super("ap:Traslado");

        moAttImpuesto = new DAttributeString("impuesto", true);
        moAttTasa = new DAttributeDouble("tasa", true, 2);
        moAttTasa.setCanBeZero(true);
        moAttImporte = new DAttributeDouble("importe", true, 2);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttImpuesto);
        mvAttributes.add(moAttTasa);
        mvAttributes.add(moAttImporte);
    }

    public cfd.DAttributeString getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeDouble getAttTasa() { return moAttTasa; }
    public cfd.DAttributeDouble getAttImporte() { return moAttImporte; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
