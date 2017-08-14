/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DAttributeDouble;
import cfd.DAttributeOptionMoneda;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementMoneda extends cfd.DElement {

    protected cfd.DAttributeOptionMoneda moAttClaveMoneda;
    protected cfd.DAttributeDouble moAttTipoDeCambio;

    public DElementMoneda() {
        super("myadd:Moneda");

        moAttClaveMoneda = new DAttributeOptionMoneda("claveMoneda", true);
        moAttTipoDeCambio = new DAttributeDouble("tipoDeCambio", true, 8);

        mvAttributes.add(moAttClaveMoneda);
        mvAttributes.add(moAttTipoDeCambio);
    }

    public cfd.DAttributeOptionMoneda getAttClaveMoneda() { return moAttClaveMoneda; }
    public cfd.DAttributeDouble getAttTipoDeCambio() { return moAttTipoDeCambio; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
