/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

import cfd.DSubelementAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDSCargaRemisionProv extends cfd.DSubelementAddenda {

    protected cfd.ext.soriana.DElementRemision moEltRemision;
    protected cfd.ext.soriana.DElementPedimento moEltPedimento;
    protected cfd.ext.soriana.DElementPedidos moEltPedido;
    protected cfd.ext.soriana.DElementItems moEltArticulos;
    protected cfd.ext.soriana.DElementCajasTarimas moEltCajasTarimas;
    protected cfd.ext.soriana.DElementArticulosPorCajaTarima moEltArticuloCajas;

    public DElementDSCargaRemisionProv() {
        super("DSCargaRemisionProv", DSubelementAddendaType.Soriana);

        moEltRemision = new DElementRemision();
        moEltPedimento = new DElementPedimento();
        moEltPedido = new DElementPedidos();
        moEltArticulos = new DElementItems();
        moEltCajasTarimas = new DElementCajasTarimas();
        moEltArticuloCajas = new DElementArticulosPorCajaTarima();

        mvElements.add(moEltRemision);
        //mvElements.add(moEltPedimento);
        mvElements.add(moEltPedido);
        mvElements.add(moEltArticulos);
        //mvElements.add(moEltCajasTarimas);
        //mvElements.add(moEltArticuloCajas);
    }

    public cfd.ext.soriana.DElementRemision getEltRemision() { return moEltRemision; }
    public cfd.ext.soriana.DElementPedimento getEltPedimento() { return moEltPedimento; }
    public cfd.ext.soriana.DElementPedidos getEltPedido() { return moEltPedido; }
    public cfd.ext.soriana.DElementItems getEltArticulos() { return moEltArticulos; }
    public cfd.ext.soriana.DElementCajasTarimas getEltCajas() { return moEltCajasTarimas; }
    public cfd.ext.soriana.DElementArticulosPorCajaTarima getEltArticulosCajas() { return moEltArticuloCajas; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
