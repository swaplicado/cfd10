/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementNota extends cfd.DElement {

    protected cfd.DAttributeString moAttTexto;

    public DElementNota() {
        super("myadd:Nota");

        moAttTexto = new DAttributeString("texto", true, 1);

        mvAttributes.add(moAttTexto);
    }

    public cfd.DAttributeString getAttTexto() { return moAttTexto; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
