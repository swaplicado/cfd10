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

public class DElementRemision extends cfd.DElementParent {

    protected cfd.DAttributeString moAttId;
    protected cfd.DAttributeString moAttRowOrder;

    protected cfd.ext.soriana.DElementProveedor moEltProveedor;
    protected cfd.ext.soriana.DElementRemRemision moEltRemision;
    protected cfd.ext.soriana.DElementConsecutivo moEltConsecutivo;
    protected cfd.ext.soriana.DElementFechaRemision moEltFechaRemision;
    protected cfd.ext.soriana.DElementTienda moEltTienda;
    protected cfd.ext.soriana.DElementTipoMoneda moEltTipoMoneda;
    protected cfd.ext.soriana.DElementTipoBulto moEltTipoBulto;
    protected cfd.ext.soriana.DElementEntregaMercancia moEltEntregaMercancia;
    protected cfd.ext.soriana.DElementCumpleReqFiscales moEltCumpleFiscal;
    protected cfd.ext.soriana.DElementCantidadBultos moEltCantidadBultos;
    protected cfd.ext.soriana.DElementSubTotal moEltSubTotal;
    protected cfd.ext.soriana.DElementDescuentos moEltDescuentos;
    protected cfd.ext.soriana.DElementIeps moEltIeps;
    protected cfd.ext.soriana.DElementIva moEltIva;
    protected cfd.ext.soriana.DElementOtrosImpuestos moEltOtrosImpuestos;
    protected cfd.ext.soriana.DElementTotal moEltTotal;
    protected cfd.ext.soriana.DElementCantidaPedidos moEltCantidadPedidos;
    protected cfd.ext.soriana.DElementFechaEntrega moEltFechaEntregaMercancia;
    protected cfd.ext.soriana.DElementEmpaqueCajas moEltEmpqCajas;
    protected cfd.ext.soriana.DElementEmpaqueTarimas moEltEmpqTarimas;
    protected cfd.ext.soriana.DElementCatidadCajas moEltCantCajasTarimas;
    protected cfd.ext.soriana.DElementCita moEltCita;
    protected cfd.ext.soriana.DElementFolioNotaEntrada moEltOpcFolioNotaEntrada;

    public DElementRemision() {
        super("Remision");

        moAttId = new DAttributeString("Id", false);
        moAttRowOrder = new DAttributeString("RowOrder", false);
        moAttRowOrder.setString("0");

        moEltProveedor = new DElementProveedor("");
        moEltRemision = new DElementRemRemision("");
        moEltConsecutivo = new DElementConsecutivo("");
        moEltFechaRemision = new DElementFechaRemision("");
        moEltTienda = new DElementTienda("");
        moEltTipoMoneda = new DElementTipoMoneda("");
        moEltTipoBulto = new DElementTipoBulto("");
        moEltEntregaMercancia = new DElementEntregaMercancia("");
        moEltCumpleFiscal = new DElementCumpleReqFiscales("");
        moEltCantidadBultos = new DElementCantidadBultos("");
        moEltSubTotal = new DElementSubTotal("");
        moEltDescuentos = new DElementDescuentos("");
        moEltIeps = new DElementIeps("");
        moEltIva = new DElementIva("");
        moEltOtrosImpuestos = new DElementOtrosImpuestos("");
        moEltTotal = new DElementTotal("");
        moEltCantidadPedidos = new DElementCantidaPedidos("");
        moEltFechaEntregaMercancia = new DElementFechaEntrega("");
        moEltEmpqCajas = new DElementEmpaqueCajas("");
        moEltEmpqTarimas = new DElementEmpaqueTarimas("");
        moEltCantCajasTarimas = new DElementCatidadCajas("");
        moEltCita = new DElementCita("");
        moEltOpcFolioNotaEntrada = null;

        //mvAttributes.add(moAttId);
        //mvAttributes.add(moAttRowOrder);

        mvElements.add(moEltProveedor);
        mvElements.add(moEltRemision);
        mvElements.add(moEltConsecutivo);
        mvElements.add(moEltFechaRemision);
        mvElements.add(moEltTienda);
        mvElements.add(moEltTipoMoneda);
        mvElements.add(moEltTipoBulto);
        mvElements.add(moEltEntregaMercancia);
        mvElements.add(moEltCumpleFiscal);
        mvElements.add(moEltCantidadBultos);
        mvElements.add(moEltSubTotal);
        mvElements.add(moEltDescuentos);
        mvElements.add(moEltIeps);
        mvElements.add(moEltIva);
        mvElements.add(moEltOtrosImpuestos);
        mvElements.add(moEltTotal);
        mvElements.add(moEltCantidadPedidos);
        mvElements.add(moEltFechaEntregaMercancia);
        //mvElements.add(moEltEmpqCajas);
        //mvElements.add(moEltEmpqTarimas);
        //mvElements.add(moEltCantCajasTarimas);
        //mvElements.add(moEltCita);
        //mvElements.add(moEltOpcFolioNotaEntrada);
    }
    
    public void setEltOpcFolioNotaEntrada(cfd.ext.soriana.DElementFolioNotaEntrada o) {
        moEltOpcFolioNotaEntrada = o;
        mvElements.add(moEltOpcFolioNotaEntrada);
    }

    public cfd.DAttributeString getAttId() { return moAttId; }
    public cfd.DAttributeString getAttRowOrder() { return moAttRowOrder; }

    public cfd.ext.soriana.DElementProveedor getEltProveedor() { return moEltProveedor; }
    public cfd.ext.soriana.DElementRemRemision getEltRemision() { return moEltRemision; }
    public cfd.ext.soriana.DElementConsecutivo getEltConsecutivo() { return moEltConsecutivo; }
    public cfd.ext.soriana.DElementFechaRemision getEltFechaRemision() { return moEltFechaRemision; }
    public cfd.ext.soriana.DElementTienda getEltTienda() { return moEltTienda; }
    public cfd.ext.soriana.DElementTipoMoneda getEltTipoMoneda() { return moEltTipoMoneda; }
    public cfd.ext.soriana.DElementTipoBulto getEltTipoBulto() { return moEltTipoBulto; }
    public cfd.ext.soriana.DElementEntregaMercancia getEltEntregaMercancia() { return moEltEntregaMercancia; }
    public cfd.ext.soriana.DElementCumpleReqFiscales getEltCumpleFiscal() { return moEltCumpleFiscal; }
    public cfd.ext.soriana.DElementCantidadBultos getEltCantidadBultos() { return moEltCantidadBultos; }
    public cfd.ext.soriana.DElementSubTotal getEltSubTotal() { return moEltSubTotal; }
    public cfd.ext.soriana.DElementDescuentos getEltDescuentos() { return moEltDescuentos; }
    public cfd.ext.soriana.DElementIeps getEltIeps() { return moEltIeps; }
    public cfd.ext.soriana.DElementIva getEltIva() { return moEltIva; }
    public cfd.ext.soriana.DElementOtrosImpuestos getEltOtrosImpuestos() { return moEltOtrosImpuestos; }
    public cfd.ext.soriana.DElementTotal getEltTotal() { return moEltTotal; }
    public cfd.ext.soriana.DElementCantidaPedidos getEltCantidadPedidos() { return moEltCantidadPedidos; }
    public cfd.ext.soriana.DElementFechaEntrega getEltFechaEntrega() { return moEltFechaEntregaMercancia; }
    public cfd.ext.soriana.DElementEmpaqueCajas getEltEmpaqueCajas() { return moEltEmpqCajas; }
    public cfd.ext.soriana.DElementEmpaqueTarimas getEltEmpaqueTarimas() { return moEltEmpqTarimas; }
    public cfd.ext.soriana.DElementCatidadCajas getEltCantCajasTarimas() { return moEltCantCajasTarimas; }
    public cfd.ext.soriana.DElementCita getEltCita() { return moEltCita; }
    public cfd.ext.soriana.DElementFolioNotaEntrada getEltOpcFolioNotaEntrada() { return moEltOpcFolioNotaEntrada; }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
