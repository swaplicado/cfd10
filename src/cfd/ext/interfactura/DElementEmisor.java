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
public class DElementEmisor extends cfd.DElement {

    protected cfd.DAttributeString moAttRefEmisor;
    protected cfd.DAttributeString moAttNumProveedor;

    public DElementEmisor() {
        super("if:Emisor");

        moAttRefEmisor = new DAttributeString("RI", true, 1, 12);
        moAttNumProveedor = new DAttributeString("NumProveedor", false, 1, 10);

        mvAttributes.add(moAttRefEmisor);
        mvAttributes.add(moAttNumProveedor);
    }

    public cfd.DAttributeString getAttRefEmisor() { return moAttRefEmisor; }
    public cfd.DAttributeString getAttNumProveedor() { return moAttNumProveedor; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
