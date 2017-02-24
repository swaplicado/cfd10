package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeOptionCondicionesPago;
import cfd.DAttributeOptionMetodoPago;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;
import cfd.ext.addenda1.DElementAddenda1;

/**
 *
 * @author Juan Barajas
 */
public class DElementComprobante extends cfd.DElement {

    protected String[] masAddendaXmlLocationNs;

    protected cfd.DAttributeString moAttVersion;
    protected cfd.DAttributeString moAttSerie;
    protected cfd.DAttributeString moAttFolio;
    protected cfd.DAttributeDatetime moAttFecha;
    protected cfd.DAttributeString moAttSello;
    protected cfd.DAttributeString moAttFormaPago;
    protected cfd.DAttributeString moAttNoCertificado;
    protected cfd.DAttributeString moAttCertificado;
    protected cfd.DAttributeOptionCondicionesPago moAttCondicionesDePago;
    protected cfd.DAttributeTypeImporte moAttSubTotal;
    protected cfd.DAttributeTypeImporte moAttDescuento;
    protected cfd.DAttributeString moAttMoneda;
    protected cfd.DAttributeTipoCambio moAttTipoCambio;
    protected cfd.DAttributeTypeImporte moAttTotal;
    protected cfd.ver33.DAttributeOptionTipoComprobante moAttTipoDeComprobante;
    protected cfd.DAttributeOptionMetodoPago moAttMetodoPago;
    protected cfd.DAttributeString moAttLugarExpedicion;
    protected cfd.DAttributeString moAttConfirmacion;

    protected cfd.ver33.DElementCfdiRelacionados moEltOpcCfdiRelacionados;
    protected cfd.ver33.DElementEmisor moEltEmisor;
    protected cfd.ver33.DElementReceptor moEltReceptor;
    protected cfd.ver33.DElementConceptos moEltConceptos;
    protected cfd.ver33.DElementImpuestos moEltImpuestos;
    protected cfd.ver32.DElementComplemento moEltOpcComplemento;
    protected cfd.ver32.DElementAddenda moEltOpcAddenda;

    public DElementComprobante() {
        this(false);
    }
    public DElementComprobante(boolean addenda1XmlLocationNs) {
        super("cfdi:Comprobante");

        masAddendaXmlLocationNs = !addenda1XmlLocationNs ? null : DElementAddenda1.createXmlLocationNs();

        moAttVersion = new DAttributeString("Version", true, 3, 3);
        moAttVersion.setString("3.3");
        moAttSerie = new DAttributeString("Serie", false, 1);
        moAttFolio = new DAttributeString("Folio", false, 1);
        moAttFecha = new DAttributeDatetime("Fecha", true);
        moAttSello = new DAttributeString("Sello", true, 1);
        moAttFormaPago = new DAttributeString("FormaPago", false);
        moAttNoCertificado = new DAttributeString("NoCertificado", true, 20, 20);
        moAttCertificado = new DAttributeString("Certificado", true, 1);
        moAttCondicionesDePago = new DAttributeOptionCondicionesPago("CondicionesDePago", false);
        moAttSubTotal = new DAttributeTypeImporte("SubTotal", true);
        moAttSubTotal.setCanBeZero(true);
        moAttDescuento = new DAttributeTypeImporte("Descuento", false);
        moAttMoneda = new DAttributeString("Moneda", true, 3, 3);
        moAttTipoCambio = new DAttributeTipoCambio("TipoCambio", false);
        moAttTotal = new DAttributeTypeImporte("Total", true);
        moAttTotal.setCanBeZero(true);
        moAttTipoDeComprobante = new cfd.ver33.DAttributeOptionTipoComprobante("TipoDeComprobante", true);
        moAttMetodoPago = new DAttributeOptionMetodoPago("MetodoPago", false);
        moAttLugarExpedicion = new DAttributeString("LugarExpedicion", true);
        moAttConfirmacion = new DAttributeString("Confirmacion", false);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttSerie);
        mvAttributes.add(moAttFolio);
        mvAttributes.add(moAttFecha);
        mvAttributes.add(moAttSello);
        mvAttributes.add(moAttFormaPago);
        mvAttributes.add(moAttNoCertificado);
        mvAttributes.add(moAttCertificado);
        mvAttributes.add(moAttCondicionesDePago);
        mvAttributes.add(moAttSubTotal);
        mvAttributes.add(moAttDescuento);
        mvAttributes.add(moAttMoneda);
        mvAttributes.add(moAttTipoCambio);
        mvAttributes.add(moAttTotal);
        mvAttributes.add(moAttTipoDeComprobante);
        mvAttributes.add(moAttMetodoPago);
        mvAttributes.add(moAttLugarExpedicion);
        mvAttributes.add(moAttConfirmacion);

        moEltEmisor = null;
        moEltEmisor = new DElementEmisor();
        moEltReceptor = new DElementReceptor();
        moEltConceptos = new DElementConceptos();
        moEltImpuestos = new DElementImpuestos();
        moEltOpcComplemento = null;
        moEltOpcAddenda = null;
    }

    public void setEltOpcCfdiRelacionados(cfd.ver33.DElementCfdiRelacionados o) { moEltOpcCfdiRelacionados = o; }
    public void setEltEmisor(cfd.ver33.DElementEmisor o) { moEltEmisor = o; }
    public void setEltReceptor(cfd.ver33.DElementReceptor o) { moEltReceptor = o; }
    public void setEltOpcComplemento(cfd.ver32.DElementComplemento o) { moEltOpcComplemento = o; }
    public void setEltOpcAddenda(cfd.ver32.DElementAddenda addenda) { moEltOpcAddenda = addenda; }
    public void setEltOpcAddenda(cfd.ver32.DElementAddenda addenda, String[] addendaXmlLocationNs) { moEltOpcAddenda = addenda; masAddendaXmlLocationNs = addendaXmlLocationNs; }

    public String[] getAddendaXmlLocationNs() { return masAddendaXmlLocationNs; }
    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttSerie() { return moAttSerie; }
    public cfd.DAttributeString getAttFolio() { return moAttFolio; }
    public cfd.DAttributeDatetime getAttFecha() { return moAttFecha; }
    public cfd.DAttributeString getAttSello() { return moAttSello; }
    public cfd.DAttributeString getAttFormaPago() { return moAttFormaPago; }
    public cfd.DAttributeString getAttNoCertificado() { return moAttNoCertificado; }
    public cfd.DAttributeString getAttCertificado() { return moAttCertificado; }
    public cfd.DAttributeOptionCondicionesPago getAttCondicionesDePago() { return moAttCondicionesDePago; }
    public cfd.DAttributeTypeImporte getAttSubTotal() { return moAttSubTotal; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }
    public cfd.DAttributeTipoCambio getAttTipoCambio() { return moAttTipoCambio; }
    public cfd.DAttributeString getAttMoneda() { return moAttMoneda; }
    public cfd.DAttributeTypeImporte getAttTotal() { return moAttTotal; }
    public cfd.ver33.DAttributeOptionTipoComprobante getAttTipoDeComprobante() { return moAttTipoDeComprobante; }
    public cfd.DAttributeOptionMetodoPago getAttMetodoPago() { return moAttMetodoPago; }
    public cfd.DAttributeString getAttLugarExpedicion() { return moAttLugarExpedicion; }
    public cfd.DAttributeString getAttConfirmacion() { return moAttConfirmacion; }

    public cfd.ver33.DElementCfdiRelacionados getEltOpcCfdiRelacionados() { return moEltOpcCfdiRelacionados; }
    public cfd.ver33.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ver33.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ver33.DElementConceptos getEltConceptos() { return moEltConceptos; }
    public cfd.ver33.DElementImpuestos getEltImpuestos() { return moEltImpuestos; }
    public cfd.ver32.DElementComplemento getEltOpcComplemento() { return moEltOpcComplemento; }
    public cfd.ver32.DElementAddenda getEltOpcAddenda() { return moEltOpcAddenda; }

    @Override
    public java.lang.String getElementForXml() {
        String aux = "";
        String xml = "";

        xml = "<" + msName + " " +
                "xsi:schemaLocation=\"http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd" +
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

        if (moEltOpcCfdiRelacionados != null) {
            aux = moEltOpcCfdiRelacionados.getElementForXml();
            xml += aux.length() == 0 ? "" : "\n" + aux;
        }
        
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
        string += moAttSerie.getAttributeForOriginalString();
        string += moAttFolio.getAttributeForOriginalString();
        string += moAttFecha.getAttributeForOriginalString();
        string += moAttFormaPago.getAttributeForOriginalString();
        string += moAttNoCertificado.getAttributeForOriginalString();
        string += moAttCondicionesDePago.getAttributeForOriginalString();
        string += moAttSubTotal.getAttributeForOriginalString();
        string += moAttDescuento.getAttributeForOriginalString();
        string += moAttMoneda.getAttributeForOriginalString();
        string += moAttTipoCambio.getAttributeForOriginalString();
        string += moAttTotal.getAttributeForOriginalString();
        string += moAttTipoDeComprobante.getAttributeForOriginalString();
        string += moAttMetodoPago.getAttributeForOriginalString();
        string += moAttLugarExpedicion.getAttributeForOriginalString();
        string += moAttConfirmacion.getAttributeForOriginalString();

        if (moEltOpcCfdiRelacionados != null) {
            string += moEltOpcCfdiRelacionados.getElementForOriginalString();
        }
        
        string += moEltEmisor.getElementForOriginalString();
        string += moEltReceptor.getElementForOriginalString();
        string += moEltConceptos.getElementForOriginalString();
        string += moEltImpuestos.getElementForOriginalString();

        if (moEltOpcComplemento != null) {
            string += moEltOpcComplemento.getElementForOriginalString();
        }

        return string;
    }
}
