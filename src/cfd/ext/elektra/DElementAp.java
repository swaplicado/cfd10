/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttributeString;
import cfd.DElementExtAddendaType;

/**
 *
 * @author Néstor Ávalos Balcázar
 */
public class DElementAp extends cfd.DElementExtAddenda {

    protected cfd.DAttributeString moAttXmlns;
    protected cfd.DAttributeString moAttSchemaLocation;
    protected cfd.DAttributeString moAttTipoComprobante;
    protected cfd.DAttributeString moAttPlazoPago;
    protected cfd.DAttributeString moAttObservaciones;

    protected cfd.ext.elektra.DElementDetailItems moEltDetalleProductos;

    public DElementAp() {
        super("ap:ap", DElementExtAddendaType.Elektra);

        moAttXmlns = new DAttributeString("xmlns:ap", true);
        moAttSchemaLocation = new DAttributeString("schemaLocation", true);
        moAttTipoComprobante = new DAttributeString("tipoComprobante", true);
        moAttPlazoPago = new DAttributeString("plazoPago", true);
        moAttObservaciones = new DAttributeString("observaciones", true);

        mvAttributes.add(moAttXmlns);
        mvAttributes.add(moAttSchemaLocation);
        mvAttributes.add(moAttTipoComprobante);
        mvAttributes.add(moAttPlazoPago);
        mvAttributes.add(moAttObservaciones);

        moEltDetalleProductos = new DElementDetailItems();

        mvElements.add(moEltDetalleProductos);
    }

    public cfd.DAttributeString getAttXmlns() { return moAttXmlns; }
    public cfd.DAttributeString getAttSchemaLocation() { return moAttSchemaLocation; }
    public cfd.DAttributeString getAttTipoComprobante() { return moAttTipoComprobante; }
    public cfd.DAttributeString getAttPlazoPago() { return moAttPlazoPago; }
    public cfd.DAttributeString getAttObservaciones() { return moAttObservaciones; }

    public cfd.ext.elektra.DElementDetailItems getEltDetalleProductos() { return moEltDetalleProductos; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
