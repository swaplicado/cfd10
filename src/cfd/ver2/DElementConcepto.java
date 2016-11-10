/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

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
public class DElementConcepto extends cfd.DElement {

    protected cfd.DAttributeDouble moAttCantidad;
    protected cfd.DAttributeString moAttUnidad;
    protected cfd.DAttributeString moAttNoIdentificacion;
    protected cfd.DAttributeString moAttDescripcion;
    protected cfd.DAttributeTypeImporteUnitario moAttValorUnitario;
    protected cfd.DAttributeTypeImporte moAttImporte;

    protected java.util.Vector<cfd.ver2.DElementInformacionAduanera> mvEltHijosInformacionAduanera;
    protected cfd.ver2.DElementCuentaPredial moEltOpcCuentaPredial;
    protected cfd.ver2.DElementComplementoConcepto moEltOpcComplementoConcepto;
    protected java.util.Vector<cfd.ver2.DElementParte> mvEltHijosParte;

    public DElementConcepto() {
        super("Concepto");

        moAttCantidad = new DAttributeDouble("cantidad", true, 4);
        moAttUnidad = new DAttributeString("unidad", true, 1);
        moAttNoIdentificacion = new DAttributeString("noIdentificacion", false, 1);
        moAttDescripcion = new DAttributeString("descripcion", true, 1);
        moAttValorUnitario = new DAttributeTypeImporteUnitario("valorUnitario", true);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);

        mvEltHijosInformacionAduanera = new Vector<DElementInformacionAduanera>();
        moEltOpcCuentaPredial = null;
        moEltOpcComplementoConcepto = null;
        mvEltHijosParte = new Vector<DElementParte>();
    }

    public void setEltOpcCuentaPredial(cfd.ver2.DElementCuentaPredial o) { moEltOpcCuentaPredial = o; }
    public void setEltOpcComplementoConcepto(cfd.ver2.DElementComplementoConcepto o) { moEltOpcComplementoConcepto = o; }

    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttUnidad() { return moAttUnidad; }
    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporteUnitario getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }

    public java.util.Vector<cfd.ver2.DElementInformacionAduanera> getEltHijosInformacionAduanera() { return mvEltHijosInformacionAduanera; }
    public cfd.ver2.DElementCuentaPredial getEltOpcCuentaPredial() { return moEltOpcCuentaPredial; }
    public cfd.ver2.DElementComplementoConcepto getEltOpcComplementoConcepto() { return moEltOpcComplementoConcepto; }
    public java.util.Vector<cfd.ver2.DElementParte> getEltHijosParte() { return mvEltHijosParte; }

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

        if (moEltOpcCuentaPredial != null) {
            xml = moEltOpcCuentaPredial.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcComplementoConcepto != null) {
            xml = moEltOpcComplementoConcepto.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        for (DElementParte parte : mvEltHijosParte) {
            xml = parte.getElementForXml();
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

        if (moEltOpcCuentaPredial != null) {
            string += moEltOpcCuentaPredial.getElementForOriginalString();
        }

        if (moEltOpcComplementoConcepto != null) {
            string += moEltOpcComplementoConcepto.getElementForOriginalString();
        }

        /* NOTE: Not required for CFD version 2.0 in original string.
        for (DElementParte parte : mvEltHijosParte) {
            string += parte.getElementForOriginalString();
        }
        */

        return string;
    }
}
