/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.interfactura;

import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementCuerpo extends cfd.DElementParent {

    protected cfd.DAttributeInteger moAttPartida;
    protected cfd.DAttributeString moAttCodigo;
    protected cfd.DAttributeDouble moAttCantidad;
    protected cfd.DAttributeString moAttConcepto;
    protected cfd.DAttributeDouble moAttPUnitario;
    protected cfd.DAttributeDouble moAttImporte;
    protected cfd.DAttributeString moAttUnidadMedida;
    protected cfd.DAttributeDouble moAttIva;
    protected cfd.DAttributeDouble moAttIVAPCT;

    public DElementCuerpo() {
        super("if:Cuerpo");

        moAttPartida = new DAttributeInteger("Partida", true, 1, 5);
        moAttCodigo = new DAttributeString("Codigo", false);
        moAttCantidad = new DAttributeDouble("Cantidad", true, 2);
        moAttConcepto = new DAttributeString("Concepto", true, 1, 40);
        moAttPUnitario = new DAttributeDouble("PUnitario", true, 2);
        moAttImporte = new DAttributeDouble("Importe", true, 2);
        moAttUnidadMedida = new DAttributeString("UnidadMedida", true, 1, 3);
        moAttIva = new DAttributeDouble("Iva", false, 2);
        moAttIVAPCT = new DAttributeDouble("IVAPCT", false, 0);

        mvAttributes.add(moAttPartida);
        mvAttributes.add(moAttCodigo);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttConcepto);
        mvAttributes.add(moAttPUnitario);
        mvAttributes.add(moAttImporte);
        mvAttributes.add(moAttUnidadMedida);
        mvAttributes.add(moAttIva);
        mvAttributes.add(moAttIVAPCT);
    }

    public cfd.DAttributeInteger getAttPartida() { return moAttPartida; }
    public cfd.DAttributeString getAttCodigo() { return moAttCodigo; }
    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttConcepto() { return moAttConcepto; }
    public cfd.DAttributeDouble getAttPUnitario() { return moAttPUnitario; }
    public cfd.DAttributeDouble getAttImporte() { return moAttImporte; }
    public cfd.DAttributeString getAttUnidadMedida() { return moAttUnidadMedida; }
    public cfd.DAttributeDouble getAttIva() { return moAttIva; }
    public cfd.DAttributeDouble getAttIVAPCT() { return moAttIVAPCT; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
