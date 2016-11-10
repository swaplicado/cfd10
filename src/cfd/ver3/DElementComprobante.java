/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeOptionCondicionesPago;
import cfd.DAttributeOptionFormaPago;
import cfd.DAttributeOptionTipoComprobante;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;
import cfd.ext.addenda1.DElementAddenda1;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementComprobante extends cfd.DElement {

    protected String[] masAddendaXmlLocationNs;

    protected cfd.DAttributeString moAttVersion;
    protected cfd.DAttributeString moAttSerie;
    protected cfd.DAttributeString moAttFolio;
    protected cfd.DAttributeDatetime moAttFecha;
    protected cfd.DAttributeString moAttSello;
    protected cfd.DAttributeOptionFormaPago moAttFormaDePago;
    protected cfd.DAttributeString moAttNoCertificado;
    protected cfd.DAttributeString moAttCertificado;
    protected cfd.DAttributeOptionCondicionesPago moAttCondicionesDePago;
    protected cfd.DAttributeTypeImporte moAttSubTotal;
    protected cfd.DAttributeTypeImporte moAttDescuento;
    protected cfd.DAttributeString moAttMotivoDescuento;
    protected cfd.DAttributeTipoCambio moAttTipoCambio;
    protected cfd.DAttributeString moAttMoneda;
    protected cfd.DAttributeTypeImporte moAttTotal;
    protected cfd.DAttributeOptionTipoComprobante moAttTipoDeComprobante;
    protected cfd.DAttributeString moAttMetodoDePago;
    protected cfd.DAttributeString moAttLugarExpedicion;
    protected cfd.DAttributeString moAttNumCtaPago;
    protected cfd.DAttributeString moAttFolioFiscalOrig;
    protected cfd.DAttributeString moAttSerieFolioFiscalOrig;
    protected cfd.DAttributeString moAttFechaFolioFiscalOrig;
    protected cfd.DAttributeString moAttMontoFolioFiscalOrig;

    protected cfd.ver3.DElementEmisor moEltEmisor;
    protected cfd.ver3.DElementReceptor moEltReceptor;
    protected cfd.ver3.DElementConceptos moEltConceptos;
    protected cfd.ver3.DElementImpuestos moEltImpuestos;
    protected cfd.ver3.DElementComplemento moEltOpcComplemento;
    protected cfd.ver3.DElementAddenda moEltOpcAddenda;

    public DElementComprobante() {
        this(false);
    }
    public DElementComprobante(boolean addenda1XmlLocationNs) {
        super("cfdi:Comprobante");

        masAddendaXmlLocationNs = !addenda1XmlLocationNs ? null : DElementAddenda1.createXmlLocationNs();

        moAttVersion = new DAttributeString("version", true, 3, 3);
        moAttVersion.setString("3.2");
        moAttSerie = new DAttributeString("serie", false, 1);
        moAttFolio = new DAttributeString("folio", true, 1);
        moAttFecha = new DAttributeDatetime("fecha", true);
        moAttSello = new DAttributeString("sello", true, 1);
        moAttFormaDePago = new DAttributeOptionFormaPago("formaDePago", true);
        moAttNoCertificado = new DAttributeString("noCertificado", true, 20, 20);
        moAttCertificado = new DAttributeString("certificado", false, 1);
        moAttCondicionesDePago = new DAttributeOptionCondicionesPago("condicionesDePago", false);
        moAttSubTotal = new DAttributeTypeImporte("subTotal", true);
        moAttSubTotal.setCanBeZero(true);
        moAttDescuento = new DAttributeTypeImporte("descuento", false);
        moAttMotivoDescuento = new DAttributeString("motivoDescuento", false, 1);
        moAttTipoCambio = new DAttributeTipoCambio("TipoCambio", false);
        moAttMoneda = new DAttributeString("Moneda", false, 3, 3);
        moAttTotal = new DAttributeTypeImporte("total", true);
        moAttTotal.setCanBeZero(true);
        moAttTipoDeComprobante = new DAttributeOptionTipoComprobante("tipoDeComprobante", true);
        moAttMetodoDePago = new DAttributeString("metodoDePago", true);
        moAttLugarExpedicion = new DAttributeString("LugarExpedicion", true);
        moAttNumCtaPago = new DAttributeString("NumCtaPago", false, 4);
        moAttFolioFiscalOrig = new DAttributeString("FolioFiscalOrig", false);
        moAttSerieFolioFiscalOrig = new DAttributeString("SerieFolioFiscalOrig", false);
        moAttFechaFolioFiscalOrig = new DAttributeString("FechaFolioFiscalOrig", false);
        moAttMontoFolioFiscalOrig = new DAttributeString("MontoFolioFiscalOrig", false);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttSerie);
        mvAttributes.add(moAttFolio);
        mvAttributes.add(moAttFecha);
        mvAttributes.add(moAttSello);
        mvAttributes.add(moAttFormaDePago);
        mvAttributes.add(moAttNoCertificado);
        mvAttributes.add(moAttCertificado);
        mvAttributes.add(moAttCondicionesDePago);
        mvAttributes.add(moAttSubTotal);
        mvAttributes.add(moAttDescuento);
        mvAttributes.add(moAttMotivoDescuento);
        mvAttributes.add(moAttTipoCambio);
        mvAttributes.add(moAttMoneda);
        mvAttributes.add(moAttTotal);
        mvAttributes.add(moAttTipoDeComprobante);
        mvAttributes.add(moAttMetodoDePago);
        mvAttributes.add(moAttLugarExpedicion);
        mvAttributes.add(moAttNumCtaPago);
        mvAttributes.add(moAttFolioFiscalOrig);
        mvAttributes.add(moAttSerieFolioFiscalOrig);
        mvAttributes.add(moAttFechaFolioFiscalOrig);
        mvAttributes.add(moAttMontoFolioFiscalOrig);

        moEltEmisor = new DElementEmisor();
        moEltReceptor = new DElementReceptor();
        moEltConceptos = new DElementConceptos();
        moEltImpuestos = new DElementImpuestos();
        moEltOpcComplemento = null;
        moEltOpcAddenda = null;
    }

    public void setEltEmisor(cfd.ver3.DElementEmisor o) { moEltEmisor = o; }
    public void setEltReceptor(cfd.ver3.DElementReceptor o) { moEltReceptor = o; }
    public void setEltOpcComplemento(cfd.ver3.DElementComplemento o) { moEltOpcComplemento = o; }
    public void setEltOpcAddenda(cfd.ver3.DElementAddenda addenda) { moEltOpcAddenda = addenda; }
    public void setEltOpcAddenda(cfd.ver3.DElementAddenda addenda, String[] addendaXmlLocationNs) { moEltOpcAddenda = addenda; masAddendaXmlLocationNs = addendaXmlLocationNs; }

    public String[] getAddendaXmlLocationNs() { return masAddendaXmlLocationNs; }
    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttSerie() { return moAttSerie; }
    public cfd.DAttributeString getAttFolio() { return moAttFolio; }
    public cfd.DAttributeDatetime getAttFecha() { return moAttFecha; }
    public cfd.DAttributeString getAttSello() { return moAttSello; }
    public cfd.DAttributeOptionFormaPago getAttFormaDePago() { return moAttFormaDePago; }
    public cfd.DAttributeString getAttNoCertificado() { return moAttNoCertificado; }
    public cfd.DAttributeString getAttCertificado() { return moAttCertificado; }
    public cfd.DAttributeOptionCondicionesPago getAttCondicionesDePago() { return moAttCondicionesDePago; }
    public cfd.DAttributeTypeImporte getAttSubTotal() { return moAttSubTotal; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }
    public cfd.DAttributeString getAttMotivoDescuento() { return moAttMotivoDescuento; }
    public cfd.DAttributeTipoCambio getAttTipoCambio() { return moAttTipoCambio; }
    public cfd.DAttributeString getAttMoneda() { return moAttMoneda; }
    public cfd.DAttributeTypeImporte getAttTotal() { return moAttTotal; }
    public cfd.DAttributeOptionTipoComprobante getAttTipoDeComprobante() { return moAttTipoDeComprobante; }
    public cfd.DAttributeString getAttMetodoDePago() { return moAttMetodoDePago; }
    public cfd.DAttributeString getAttLugarExpedicion() { return moAttLugarExpedicion; }
    public cfd.DAttributeString getAttNumCtaPago() { return moAttNumCtaPago; }
    public cfd.DAttributeString getAttFolioFiscalOrig() { return moAttFolioFiscalOrig; }
    public cfd.DAttributeString getAttSerieFolioFiscalOrig() { return moAttSerieFolioFiscalOrig; }
    public cfd.DAttributeString getAttFechaFolioFiscalOrig() { return moAttFechaFolioFiscalOrig; }
    public cfd.DAttributeString getAttMontoFolioFiscalOrig() { return moAttMontoFolioFiscalOrig; }

    public cfd.ver3.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ver3.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ver3.DElementConceptos getEltConceptos() { return moEltConceptos; }
    public cfd.ver3.DElementImpuestos getEltImpuestos() { return moEltImpuestos; }
    public cfd.ver3.DElementComplemento getEltOpcComplemento() { return moEltOpcComplemento; }
    public cfd.ver3.DElementAddenda getEltOpcAddenda() { return moEltOpcAddenda; }

    @Override
    public java.lang.String getElementForXml() {
        String aux = "";
        String xml = "";

        xml = "<" + msName + " " +
                "xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv32.xsd" +
                (masAddendaXmlLocationNs == null ? "" : " " + masAddendaXmlLocationNs[0]) + "\" " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\"" +
                (masAddendaXmlLocationNs == null ? "" : " " + masAddendaXmlLocationNs[1]);

        for (DAttribute attribute : mvAttributes) {
            aux = attribute.getAttributeForXml();
            if (!aux.isEmpty()) {
                xml += " " + aux;
            }
        }

        xml += ">";

        aux = moEltEmisor.getElementForXml();
        xml += aux.length() == 0 ? "" : "\n" + aux;

        aux = moEltReceptor.getElementForXml();
        xml += aux.length() == 0 ? "" : "\n" + aux;

        aux = moEltConceptos.getElementForXml();
        xml += aux.length() == 0 ? "" : "\n" + aux;

        aux = moEltImpuestos.getElementForXml();
        xml += aux.length() == 0 ? "" : "\n" + aux;

        if (moEltOpcComplemento != null) {
            aux = moEltOpcComplemento.getElementForXml();
            xml += aux.length() == 0 ? "" : "\n" + aux;
        }

        if (moEltOpcAddenda != null) {
            aux = moEltOpcAddenda.getElementForXml();
            xml += aux.length() == 0 ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        string += moAttVersion.getAttributeForOriginalString();
        string += moAttFecha.getAttributeForOriginalString();
        string += moAttTipoDeComprobante.getAttributeForOriginalString();
        string += moAttFormaDePago.getAttributeForOriginalString();
        string += moAttCondicionesDePago.getAttributeForOriginalString();
        string += moAttSubTotal.getAttributeForOriginalString();
        string += moAttDescuento.getAttributeForOriginalString();
        string += moAttTipoCambio.getAttributeForOriginalString();
        string += moAttMoneda.getAttributeForOriginalString();
        string += moAttTotal.getAttributeForOriginalString();
        string += moAttMetodoDePago.getAttributeForOriginalString();
        string += moAttLugarExpedicion.getAttributeForOriginalString();
        string += moAttNumCtaPago.getAttributeForOriginalString();

        string += moEltEmisor.getElementForOriginalString();
        string += moEltReceptor.getElementForOriginalString();
        string += moEltConceptos.getElementForOriginalString();
        string += moEltImpuestos.getElementForOriginalString();

        if (moEltOpcComplemento != null) {
            string += moEltOpcComplemento.getElementForOriginalString();
        }

        /* NOTE:
         * Addenda is not required for CFD version 3.2 in original string.
         */

        return string;
    }
}
