/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.interfactura;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementReceptor extends cfd.DElement {

    protected cfd.DAttributeString moAttRefReceptor;

    public DElementReceptor() {
        super("if:Receptor");

        moAttRefReceptor = new DAttributeString("RI", true, 1, 12);

        mvAttributes.add(moAttRefReceptor);
    }

    public cfd.DAttributeString getAttRefReceptor() { return moAttRefReceptor; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
