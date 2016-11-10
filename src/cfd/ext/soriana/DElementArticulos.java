/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */

public class DElementArticulos extends cfd.DElementParent {

    protected cfd.DAttributeString moAttId;
    protected cfd.DAttributeString moAttRowOrder;

    protected cfd.ext.soriana.DElementProveedor moEltProveedor;
    protected cfd.ext.soriana.DElementRemRemision moEltRemision;
    protected cfd.ext.soriana.DElementFolioPedido moEltFolio;
    protected cfd.ext.soriana.DElementTienda moEltTienda;
    protected cfd.ext.soriana.DElementCodigo moEltCodigoBarras;
    protected cfd.ext.soriana.DElementCantidadUnidad moEltCantCompra;
    protected cfd.ext.soriana.DElementCostoNeto moEltCostoNeto;
    protected cfd.ext.soriana.DElementPorcentajeIeps moEltIeps;
    protected cfd.ext.soriana.DElementPorcentajeIva moEltIva;

    public DElementArticulos() {
        super("Articulos");

        moAttId = new DAttributeString("Id", true);
        moAttRowOrder = new DAttributeString("RowOrder", true);
        moAttRowOrder.setString("0");

        moEltProveedor = new DElementProveedor("");
        moEltRemision = new DElementRemRemision("");
        moEltFolio = new DElementFolioPedido("");
        moEltTienda = new DElementTienda("");
        moEltCodigoBarras = new DElementCodigo("");
        moEltCantCompra = new DElementCantidadUnidad("");
        moEltCostoNeto = new DElementCostoNeto("");
        moEltIeps = new DElementPorcentajeIeps("");
        moEltIva = new DElementPorcentajeIva("");

        //mvAttributes.add(moAttId);
        //mvAttributes.add(moAttRowOrder);

        mvElements.add(moEltProveedor);
        mvElements.add(moEltRemision);
        mvElements.add(moEltFolio);
        mvElements.add(moEltTienda);
        mvElements.add(moEltCodigoBarras);
        mvElements.add(moEltCantCompra);
        mvElements.add(moEltCostoNeto);
        mvElements.add(moEltIeps);
        mvElements.add(moEltIva);
    }

    public cfd.DAttributeString getAttId() { return moAttId; }
    public cfd.DAttributeString getAttRowOrder() { return moAttRowOrder; }

    public cfd.ext.soriana.DElementProveedor getEltProveedor() { return moEltProveedor; }
    public cfd.ext.soriana.DElementRemRemision getEltRemision() { return moEltRemision; }
    public cfd.ext.soriana.DElementFolioPedido getEltFolio() { return moEltFolio; }
    public cfd.ext.soriana.DElementTienda getEltTienda() { return moEltTienda; }
    public cfd.ext.soriana.DElementCodigo getEltCodigoBarras() { return moEltCodigoBarras; }
    public cfd.ext.soriana.DElementCantidadUnidad getEltCantCompra() { return moEltCantCompra; }
    public cfd.ext.soriana.DElementCostoNeto getEltCostoNeto() { return moEltCostoNeto; }
    public cfd.ext.soriana.DElementPorcentajeIeps getEltIeps() { return moEltIeps; }
    public cfd.ext.soriana.DElementPorcentajeIva getEltIva() { return moEltIva; }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
