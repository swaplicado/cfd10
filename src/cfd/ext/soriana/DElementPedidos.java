/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */

public class DElementPedidos extends cfd.DElementParent {

    protected cfd.DAttributeString moAttId;
    protected cfd.DAttributeString moAttRowOrder;

    protected cfd.ext.soriana.DElementProveedor moEltProveedor;
    protected cfd.ext.soriana.DElementRemRemision moEltRemision;
    protected cfd.ext.soriana.DElementFolioPedido moEltFolio;
    protected cfd.ext.soriana.DElementTienda moEltTienda;
    protected cfd.ext.soriana.DElementCantidadArticulos moEltCantArticulos;
    protected cfd.ext.soriana.DElementPedidoEmitidoProveedor moEltOpcPedidoEmitidoProveedor;

    public DElementPedidos() {
        super("Pedidos");

        moAttId = new DAttributeString("Id", true);
        moAttRowOrder = new DAttributeString("RowOrder", true);
        moAttRowOrder.setString("0");

        moEltProveedor = new DElementProveedor("");
        moEltRemision = new DElementRemRemision("");
        moEltFolio = new DElementFolioPedido("");
        moEltTienda = new DElementTienda("");
        moEltCantArticulos = new DElementCantidadArticulos("");
        moEltOpcPedidoEmitidoProveedor = null;

        //mvAttributes.add(moAttId);
        //mvAttributes.add(moAttRowOrder);

        mvElements.add(moEltProveedor);
        mvElements.add(moEltRemision);
        mvElements.add(moEltFolio);
        mvElements.add(moEltTienda);
        mvElements.add(moEltCantArticulos);
        //mvElements.add(moEltOpcPedidoEmitidoProveedor);
    }
    
    public void setEltOpcPedidoEmitidoProveedor(cfd.ext.soriana.DElementPedidoEmitidoProveedor o) {
        moEltOpcPedidoEmitidoProveedor = o;
        mvElements.add(moEltOpcPedidoEmitidoProveedor);
    }

    public cfd.DAttributeString getAttId() { return moAttId; }
    public cfd.DAttributeString getAttRowOrder() { return moAttRowOrder; }

    public cfd.ext.soriana.DElementProveedor getEltProveedor() { return moEltProveedor; }
    public cfd.ext.soriana.DElementRemRemision getEltRemision() { return moEltRemision; }
    public cfd.ext.soriana.DElementFolioPedido getEltFolio() { return moEltFolio; }
    public cfd.ext.soriana.DElementTienda getEltTienda() { return moEltTienda; }
    public cfd.ext.soriana.DElementCantidadArticulos getEltCantArticulos() { return moEltCantArticulos; }
    public cfd.ext.soriana.DElementPedidoEmitidoProveedor getEltOpcPedidoEmitidoProveedor() { return moEltOpcPedidoEmitidoProveedor; }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
