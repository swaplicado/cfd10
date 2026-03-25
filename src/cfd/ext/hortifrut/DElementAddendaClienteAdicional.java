/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.hortifrut;

import cfd.DSubelementAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAddendaClienteAdicional extends cfd.DSubelementAddenda {

    public static final String NAME = "ClienteAdicional";
    
    protected DElementOrdenCompra moEltOrdenCompra;

    public DElementAddendaClienteAdicional() {
        super(NAME, DSubelementAddendaType.Hortifrut);
        
        moEltOrdenCompra = new DElementOrdenCompra();
        
        mvElements.add(moEltOrdenCompra);
    }

    public DElementOrdenCompra getEltOrdenCompra() { return moEltOrdenCompra; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        return super.getElementForXml();
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
