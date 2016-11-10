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

public class DElementArticulosPorCajaTarima extends cfd.DElementParent {

    protected cfd.DAttributeString moAttId;
    protected cfd.DAttributeString moAttRowOrder;

    protected cfd.ext.soriana.DElementProveedor moEltProveedor;
    protected cfd.ext.soriana.DElementRemRemision moEltRemision;
    protected cfd.ext.soriana.DElementFolioPedido moEltFolio;
    protected cfd.ext.soriana.DElementNumeroCaja moEltNumCaja;
    protected cfd.ext.soriana.DElementSucursal moEltSucursal;
    protected cfd.ext.soriana.DElementCodigoCaja moEltCodigoCaja;
    protected cfd.ext.soriana.DElementCantidadArticulos moEltCantArticulos;

    public DElementArticulosPorCajaTarima() {
        super("CajasTarimas");

        moAttId = new DAttributeString("Id", true);
        moAttRowOrder = new DAttributeString("RowOrder", true);
        moAttRowOrder.setString("0");

        moEltProveedor = new DElementProveedor("");
        moEltRemision = new DElementRemRemision("");
        moEltFolio = new DElementFolioPedido("");
        moEltNumCaja = new DElementNumeroCaja("");
        moEltSucursal = new DElementSucursal("");
        moEltCodigoCaja = new DElementCodigoCaja("");
        moEltCantArticulos = new DElementCantidadArticulos("");

        mvAttributes.add(moAttId);
        mvAttributes.add(moAttRowOrder);

        mvElements.add(moEltProveedor);
        mvElements.add(moEltRemision);
        mvElements.add(moEltFolio);
        mvElements.add(moEltNumCaja);
        mvElements.add(moEltSucursal);
        mvElements.add(moEltCodigoCaja);
        mvElements.add(moEltCantArticulos);
    }

    public cfd.DAttributeString getAttId() { return moAttId; }
    public cfd.DAttributeString getAttRowOrder() { return moAttRowOrder; }

    public cfd.ext.soriana.DElementProveedor getEltProveedor() { return moEltProveedor; }
    public cfd.ext.soriana.DElementRemRemision getEltRemision() { return moEltRemision; }
    public cfd.ext.soriana.DElementFolioPedido getEltFolio() { return moEltFolio; }
    public cfd.ext.soriana.DElementNumeroCaja getEltNumeroCaja() { return moEltNumCaja; }
    public cfd.ext.soriana.DElementSucursal getEltSucursal() { return moEltSucursal; }
    public cfd.ext.soriana.DElementCodigoCaja getEltCodigoBarrasCaja() { return moEltCodigoCaja; }
    public cfd.ext.soriana.DElementCantidadArticulos getEltCantArticulos() { return moEltCantArticulos; }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
