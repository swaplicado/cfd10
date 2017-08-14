/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttributeDouble;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestos extends cfd.DElementParent {

    protected cfd.DAttributeDouble moAttImpuestosTrasladados;

    protected cfd.ext.elektra.DElementImpuestosTrasladados moEltImpuestosTrasladados;

    public DElementImpuestos() {
        super("ap:Impuestos");

        moAttImpuestosTrasladados = new DAttributeDouble("totalImpuestosTrasladados", true, 2);
        moAttImpuestosTrasladados.setCanBeZero(true);

        mvAttributes.add(moAttImpuestosTrasladados);

        moEltImpuestosTrasladados = new DElementImpuestosTrasladados();

        mvElements.add(moEltImpuestosTrasladados);
    }

    public cfd.DAttributeDouble getAttTotalImpuestosTrasladados() { return moAttImpuestosTrasladados; }

    public cfd.ext.elektra.DElementImpuestosTrasladados getEltImpuestosTrasladados() { return moEltImpuestosTrasladados; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
