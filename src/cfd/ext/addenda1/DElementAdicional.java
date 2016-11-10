/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAdicional extends cfd.DElementParent {

    protected cfd.DAttributeInteger moAttDiasDeCredito;
    protected cfd.DAttributeString moAttEmbarque;
    protected cfd.DAttributeString moAttOrdenDeEmbarque;
    protected cfd.DAttributeString moAttOrdenDeCompra;
    protected cfd.DAttributeString moAttContrato;
    protected cfd.DAttributeString moAttPedido;
    protected cfd.DAttributeString moAttFactura;
    protected cfd.DAttributeString moAttCliente;
    protected cfd.DAttributeString moAttSucursal;
    protected cfd.DAttributeString moAttAgente;
    protected cfd.DAttributeString moAttRuta;
    protected cfd.DAttributeString moAttChofer;
    protected cfd.DAttributeString moAttPlacas;
    protected cfd.DAttributeString moAttBoleto;
    protected cfd.DAttributeDouble moAttPesoBruto;
    protected cfd.DAttributeDouble moAttPesoNeto;
    protected cfd.DAttributeString moAttUnidadPesoBruto;
    protected cfd.DAttributeString moAttUnidadPesoNeto;

    protected cfd.ext.addenda1.DElementAdicionalConceptos moEltAdicionalConceptos;
    protected cfd.ext.addenda1.DElementNotas moEltOpcNotas;

    public DElementAdicional() {
        super("myadd:Adicional");

        moAttDiasDeCredito = new DAttributeInteger("diasDeCredito", false);
        moAttEmbarque = new DAttributeString("embarque", false, 1);
        moAttOrdenDeEmbarque = new DAttributeString("ordenDeEmbarque", false, 1);
        moAttOrdenDeCompra = new DAttributeString("ordenDeCompra", false, 1);
        moAttContrato = new DAttributeString("contrato", false, 1);
        moAttPedido = new DAttributeString("pedido", false, 1);
        moAttFactura = new DAttributeString("factura", false, 1);
        moAttCliente = new DAttributeString("cliente", false, 1);
        moAttSucursal = new DAttributeString("sucursal", false, 1);
        moAttAgente = new DAttributeString("agente", false, 1);
        moAttRuta = new DAttributeString("ruta", false, 1);
        moAttChofer = new DAttributeString("chofer", false, 1);
        moAttPlacas = new DAttributeString("placas", false, 1);
        moAttBoleto = new DAttributeString("boleto", false, 1);
        moAttPesoBruto = new DAttributeDouble("pesoBruto", false, 8);
        moAttPesoNeto = new DAttributeDouble("pesoNeto", false, 8);
        moAttUnidadPesoBruto = new DAttributeString("unidadPesoBruto", true, 1);
        moAttUnidadPesoNeto = new DAttributeString("unidadPesoNeto", true, 1);

        mvAttributes.add(moAttDiasDeCredito);
        mvAttributes.add(moAttEmbarque);
        mvAttributes.add(moAttOrdenDeEmbarque);
        mvAttributes.add(moAttOrdenDeCompra);
        mvAttributes.add(moAttContrato);
        mvAttributes.add(moAttPedido);
        mvAttributes.add(moAttFactura);
        mvAttributes.add(moAttCliente);
        mvAttributes.add(moAttSucursal);
        mvAttributes.add(moAttAgente);
        mvAttributes.add(moAttRuta);
        mvAttributes.add(moAttChofer);
        mvAttributes.add(moAttPlacas);
        mvAttributes.add(moAttBoleto);
        mvAttributes.add(moAttPesoBruto);
        mvAttributes.add(moAttPesoNeto);
        mvAttributes.add(moAttUnidadPesoBruto);
        mvAttributes.add(moAttUnidadPesoNeto);

        moEltAdicionalConceptos = new DElementAdicionalConceptos();
        moEltOpcNotas = null;

        mvElements.add(moEltAdicionalConceptos);
    }

    public void setEltOpcNotas(cfd.ext.addenda1.DElementNotas o) {
        if (moEltOpcNotas != null) {
            mvElements.remove(moEltOpcNotas);
        }

        moEltOpcNotas = o;
        mvElements.add(moEltOpcNotas);
    }

    public cfd.DAttributeInteger getAttDiasDeCredito() { return moAttDiasDeCredito; }
    public cfd.DAttributeString getAttEmbarque() { return moAttEmbarque; }
    public cfd.DAttributeString getAttOrdenDeEmbarque() { return moAttOrdenDeEmbarque; }
    public cfd.DAttributeString getAttOrdenDeCompra() { return moAttOrdenDeCompra; }
    public cfd.DAttributeString getAttContrato() { return moAttContrato; }
    public cfd.DAttributeString getAttPedido() { return moAttPedido; }
    public cfd.DAttributeString getAttFactura() { return moAttFactura; }
    public cfd.DAttributeString getAttCliente() { return moAttCliente; }
    public cfd.DAttributeString getAttSucursal() { return moAttSucursal; }
    public cfd.DAttributeString getAttAgente() { return moAttAgente; }
    public cfd.DAttributeString getAttRuta() { return moAttRuta; }
    public cfd.DAttributeString getAttChofer() { return moAttChofer; }
    public cfd.DAttributeString getAttPlacas() { return moAttPlacas; }
    public cfd.DAttributeString getAttBoleto() { return moAttBoleto; }
    public cfd.DAttributeDouble getAttPesoBruto() { return moAttPesoBruto; }
    public cfd.DAttributeDouble getAttPesoNeto() { return moAttPesoNeto; }
    public cfd.DAttributeString getAttUnidadPesoBruto() { return moAttUnidadPesoBruto; }
    public cfd.DAttributeString getAttUnidadPesoNeto() { return moAttUnidadPesoNeto; }

    public cfd.ext.addenda1.DElementAdicionalConceptos getEltAdicionalConceptos() { return moEltAdicionalConceptos; }
    public cfd.ext.addenda1.DElementNotas getEltOpcNotas() { return moEltOpcNotas; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
