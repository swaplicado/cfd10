/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import java.util.Vector;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DAttributeTypeImporteUnitario;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementParte extends cfd.DElement {

    protected cfd.DAttributeDouble moAttCantidad;
    protected cfd.DAttributeString moAttUnidad;
    protected cfd.DAttributeString moAttNoIdentificacion;
    protected cfd.DAttributeString moAttDescripcion;
    protected cfd.DAttributeTypeImporteUnitario moAttValorUnitario;
    protected cfd.DAttributeTypeImporte moAttImporte;

    protected java.util.Vector<cfd.ver32.DElementInformacionAduanera> mvEltHijosInformacionAduanera;

    public DElementParte() {
        super("cfdi:Parte");

        moAttCantidad = new DAttributeDouble("cantidad", true, 6);
        moAttUnidad = new DAttributeString("unidad", false, 1);
        moAttNoIdentificacion = new DAttributeString("noIdentificacion", false, 1);
        moAttDescripcion = new DAttributeString("descripcion", true, 1);
        moAttValorUnitario = new DAttributeTypeImporteUnitario("valorUnitario", false);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("importe", false);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);

        mvEltHijosInformacionAduanera = new Vector<DElementInformacionAduanera>();
    }

    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttUnidad() { return moAttUnidad; }
    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporteUnitario getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }

    public java.util.Vector<cfd.ver32.DElementInformacionAduanera> getEltHijosInformacionAduanera() { return mvEltHijosInformacionAduanera; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        for (DElementInformacionAduanera infoAduanera : mvEltHijosInformacionAduanera) {
            xml = infoAduanera.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes

        for (DElementInformacionAduanera infoAduanera : mvEltHijosInformacionAduanera) {
            string += infoAduanera.getElementForOriginalString();
        }

        return string;
    }
}
