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

public class DElementPedimento extends cfd.DElementParent {

    protected cfd.DAttributeString moAttId;
    protected cfd.DAttributeString moAttRowOrder;

    protected cfd.ext.soriana.DElementProveedor moEltProveedor;
    protected cfd.ext.soriana.DElementRemRemision moEltRemision;
    protected cfd.ext.soriana.DElementPedPedimento moEltPedimento;
    protected cfd.ext.soriana.DElementAduana moEltAduana;
    protected cfd.ext.soriana.DElementAgenteAduanal moEltAgtAduanal;
    protected cfd.ext.soriana.DElementTipoPedimento moEltTipoPedimento;
    protected cfd.ext.soriana.DElementFechaPedimento moEltFechaPedimento;
    protected cfd.ext.soriana.DElementFechaReiboLaredo moEltFechaReibo;
    protected cfd.ext.soriana.DElementFechaBillOfLading moEltFechaBill;

    public DElementPedimento() {
        super("Pedimento");

        moAttId = new DAttributeString("Id", true);
        moAttRowOrder = new DAttributeString("RowOrder", true);
        moAttRowOrder.setString("0");

        moEltProveedor = new DElementProveedor("");
        moEltRemision = new DElementRemRemision("");
        moEltPedimento = new DElementPedPedimento("");
        moEltAduana = new DElementAduana("");
        moEltAgtAduanal = new DElementAgenteAduanal("");
        moEltTipoPedimento = new DElementTipoPedimento("");
        moEltFechaPedimento = new DElementFechaPedimento("");
        moEltFechaReibo = new DElementFechaReiboLaredo("");
        moEltFechaBill = new DElementFechaBillOfLading("");

        mvAttributes.add(moAttId);
        mvAttributes.add(moAttRowOrder);

        mvElements.add(moEltProveedor);
        mvElements.add(moEltRemision);
        mvElements.add(moEltPedimento);
        mvElements.add(moEltAduana);
        mvElements.add(moEltAgtAduanal);
        mvElements.add(moEltTipoPedimento);
        mvElements.add(moEltFechaPedimento);
        mvElements.add(moEltFechaReibo);
        mvElements.add(moEltFechaBill);
    }

    public cfd.DAttributeString getAttId() { return moAttId; }
    public cfd.DAttributeString getAttRowOrder() { return moAttRowOrder; }

    public cfd.ext.soriana.DElementProveedor getEltProveedor() { return moEltProveedor; }
    public cfd.ext.soriana.DElementRemRemision getEltRemision() { return moEltRemision; }
    public cfd.ext.soriana.DElementPedPedimento getEltPedimento() { return moEltPedimento; }
    public cfd.ext.soriana.DElementAduana getEltAduana() { return moEltAduana; }
    public cfd.ext.soriana.DElementAgenteAduanal getEltAgtAduanal() { return moEltAgtAduanal; }
    public cfd.ext.soriana.DElementTipoPedimento getEltTipoPedimento() { return moEltTipoPedimento; }
    public cfd.ext.soriana.DElementFechaPedimento getEltFechaPedimento() { return moEltFechaPedimento; }
    public cfd.ext.soriana.DElementFechaReiboLaredo getEltFechaReibo() { return moEltFechaReibo; }
    public cfd.ext.soriana.DElementFechaBillOfLading getEltFechaBill() { return moEltFechaBill; }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
