/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttributeString;

/**
 *
 * @author Néstor Ávalos Balcázar
 */
public class DElementDetalle extends cfd.DElementParent {

    protected cfd.DAttributeString moAttFolio;

    protected cfd.ext.elektra.DElementProducto moEltProducto;

    public DElementDetalle() {
        super("ap:Detalle");

        moAttFolio = new DAttributeString("folio", true);

        mvAttributes.add(moAttFolio);

        moEltProducto = new DElementProducto();

        mvElements.add(moEltProducto);
    }

    public cfd.DAttributeString getAttFolio() { return moAttFolio; }

    public cfd.ext.elektra.DElementProducto getEltProducto() { return moEltProducto; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
