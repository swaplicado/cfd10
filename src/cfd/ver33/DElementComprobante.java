package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;
import cfd.DCfdConsts;
import cfd.DElement;
import cfd.ver3.cce11.DElementComercioExterior;
import cfd.ver3.clf10.DElementLeyendasFiscales;
import cfd.ver3.nom12.DElementNomina;
import cfd.ver33.crp10.DElementPagos;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sa.lib.xml.SXmlUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementComprobante extends cfd.DElement {

    /*
     * Attributes' declaration-order according to CFDI 3.3 specification (a.k.a., "Anexo 20")
     */
    
    private final DAttributeString moAttVersion;
    private final DAttributeString moAttSerie;
    private final DAttributeString moAttFolio;
    private final DAttributeDatetime moAttFecha;
    private final DAttributeString moAttSello;
    private final DAttributeString moAttFormaPago;
    private final DAttributeString moAttNoCertificado;
    private final DAttributeString moAttCertificado;
    private final DAttributeString moAttCondicionesDePago;
    private final DAttributeTypeImporte moAttSubTotal;
    private final DAttributeTypeImporte moAttDescuento;
    private final DAttributeString moAttMoneda;
    private final DAttributeTipoCambio moAttTipoCambio;
    private final DAttributeTypeImporte moAttTotal;
    private final DAttributeString moAttTipoDeComprobante;
    private final DAttributeString moAttMetodoPago;
    private final DAttributeString moAttLugarExpedicion;
    private final DAttributeString moAttConfirmacion;

    private cfd.ver33.DElementCfdiRelacionados moEltOpcCfdiRelacionados;
    private cfd.ver33.DElementEmisor moEltEmisor;
    private cfd.ver33.DElementReceptor moEltReceptor;
    private final cfd.ver33.DElementConceptos moEltConceptos;
    private cfd.ver33.DElementImpuestos moEltOpcImpuestos;
    private cfd.ver33.DElementComplemento moEltOpcComplemento;
    private cfd.ver3.DElementAddenda moEltOpcAddenda;

    /**
     * 
     */
    public DElementComprobante() {
        this(false);
    }
    
    public DElementComprobante(boolean addAddenda1XmlLocationNs) {
        super("cfdi:Comprobante");

        moAttVersion = new DAttributeString("Version", true, 3, 3); // fixed text value "3.3"
        moAttVersion.setString("" + DCfdConsts.CFDI_VER_33);
        moAttSerie = new DAttributeString("Serie", false, 1, 25);   // text from 1 to 25 characters
        moAttFolio = new DAttributeString("Folio", false, 1, 40);   // text from 1 to 25 characters
        moAttFecha = new DAttributeDatetime("Fecha", true);
        moAttSello = new DAttributeString("Sello", false, 1);
        moAttFormaPago = new DAttributeString("FormaPago", false, 2, 2);            // c_FormaPago catalog codes of 2 fixed digits
        moAttNoCertificado = new DAttributeString("NoCertificado", true, 20, 20);   // certificate numbers of 20 fixed digits
        moAttCertificado = new DAttributeString("Certificado", true, 1);
        moAttCondicionesDePago = new DAttributeString("CondicionesDePago", false, 1, 1000); // text from 1 to 1,000 characters
        moAttSubTotal = new DAttributeTypeImporte("SubTotal", true);
        moAttSubTotal.setCanBeZero(true);
        moAttDescuento = new DAttributeTypeImporte("Descuento", false);
        moAttMoneda = new DAttributeString("Moneda", true, 3, 3);   // c_Moneda catalog codes of 3 fixed digits
        moAttTipoCambio = new DAttributeTipoCambio("TipoCambio", false);
        moAttTotal = new DAttributeTypeImporte("Total", true);
        moAttTotal.setCanBeZero(true);
        moAttTipoDeComprobante = new DAttributeString("TipoDeComprobante", true, 1, 1); // c_TipoDeComprobante catalog codes of 1 fixed digit
        moAttMetodoPago = new DAttributeString("MetodoPago", false, 3, 3);              // c_MetodoPago catalog codes of 3 fixed digits
        moAttLugarExpedicion = new DAttributeString("LugarExpedicion", true, 5, 5);     // c_CodigoPostal catalog codes of 5 fixed digits
        moAttConfirmacion = new DAttributeString("Confirmacion", false, 5, 5);          // confirmation codes of 5 fixed characters

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

        moEltOpcCfdiRelacionados = null;
        moEltEmisor = new DElementEmisor();         // can be reset
        moEltReceptor = new DElementReceptor();     // can be reset
        moEltConceptos = new DElementConceptos();   // cannot be reset, is final
        moEltOpcImpuestos = null;
        moEltOpcComplemento = null;
        moEltOpcAddenda = null;
    }
    
    /*
     * Private methods:
     */

    private boolean hasComplementCe11() {
        boolean has = false;
        
        if (moEltOpcComplemento != null) {
            for (DElement element : moEltOpcComplemento.getElements()) {
                if (element instanceof cfd.ver3.cce11.DElementComercioExterior) {
                    has = true;
                    break;
                }
            }
        }
        
        return has;
    }

    private boolean hasComplementLf10() {
        boolean has = false;
        
        if (moEltOpcComplemento != null) {
            for (DElement element : moEltOpcComplemento.getElements()) {
                if (element instanceof cfd.ver3.clf10.DElementLeyendasFiscales) {
                    has = true;
                    break;
                }
            }
        }
        
        return has;
    }

    private boolean hasComplementRp10() {
        boolean has = false;
        
        if (moEltOpcComplemento != null) {
            for (DElement element : moEltOpcComplemento.getElements()) {
                if (element instanceof cfd.ver33.crp10.DElementPagos) {
                    has = true;
                    break;
                }
            }
        }
        
        return has;
    }
    
    private boolean isCfdiPayroll() {
        return moAttTipoDeComprobante.getString().compareTo(DCfdi33Catalogs.CFD_TP_N) == 0;
    }

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltOpcCfdiRelacionados != null) {
            elements.add(moEltOpcCfdiRelacionados);
        }
        
        elements.add(moEltEmisor);
        elements.add(moEltReceptor);
        elements.add(moEltConceptos);
        
        if (moEltOpcImpuestos != null) {
            elements.add(moEltOpcImpuestos);
        }
        
        if (moEltOpcComplemento != null) {
            elements.add(moEltOpcComplemento);
        }
        
        if (moEltOpcAddenda != null) {
            elements.add(moEltOpcAddenda);
        }
        
        return elements;
    }
    
    /*
     * Public methods:
     */

    public float getVersion() { return DCfdConsts.CFDI_VER_33; }
    public void setEltOpcCfdiRelacionados(cfd.ver33.DElementCfdiRelacionados o) { moEltOpcCfdiRelacionados = o; }
    public void setEltEmisor(cfd.ver33.DElementEmisor o) { moEltEmisor = o; }
    public void setEltReceptor(cfd.ver33.DElementReceptor o) { moEltReceptor = o; }
    public void setEltOpcImpuestos(cfd.ver33.DElementImpuestos o) { moEltOpcImpuestos = o; }
    public void setEltOpcComplemento(cfd.ver33.DElementComplemento o) { moEltOpcComplemento = o; }
    public void setEltOpcAddenda(cfd.ver3.DElementAddenda o) { moEltOpcAddenda = o; }

    public DAttributeString getAttSerie() { return moAttSerie; }
    public DAttributeString getAttFolio() { return moAttFolio; }
    public DAttributeDatetime getAttFecha() { return moAttFecha; }
    public DAttributeString getAttSello() { return moAttSello; }
    public DAttributeString getAttFormaPago() { return moAttFormaPago; }
    public DAttributeString getAttNoCertificado() { return moAttNoCertificado; }
    public DAttributeString getAttCertificado() { return moAttCertificado; }
    public DAttributeString getAttCondicionesDePago() { return moAttCondicionesDePago; }
    public DAttributeTypeImporte getAttSubTotal() { return moAttSubTotal; }
    public DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }
    public DAttributeString getAttMoneda() { return moAttMoneda; }
    public DAttributeTipoCambio getAttTipoCambio() { return moAttTipoCambio; }
    public DAttributeTypeImporte getAttTotal() { return moAttTotal; }
    public DAttributeString getAttTipoDeComprobante() { return moAttTipoDeComprobante; }
    public DAttributeString getAttMetodoPago() { return moAttMetodoPago; }
    public DAttributeString getAttLugarExpedicion() { return moAttLugarExpedicion; }
    public DAttributeString getAttConfirmacion() { return moAttConfirmacion; }

    public cfd.ver33.DElementCfdiRelacionados getEltOpcCfdiRelacionados() { return moEltOpcCfdiRelacionados; }
    public cfd.ver33.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ver33.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ver33.DElementConceptos getEltConceptos() { return moEltConceptos; }
    public cfd.ver33.DElementImpuestos getEltOpcImpuestos() { return moEltOpcImpuestos; }
    public cfd.ver33.DElementComplemento getEltOpcComplemento() { return moEltOpcComplemento; }
    public cfd.ver3.DElementAddenda getEltOpcAddenda() { return moEltOpcAddenda; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (moEltEmisor == null) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + (new cfd.ver33.DElementEmisor().getName()) + "'" + DElement.ERR_MSG_NODE_NO_EXIST);
        }
        
        if (moEltReceptor == null) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + (new cfd.ver33.DElementReceptor().getName()) + "'" + DElement.ERR_MSG_NODE_NO_EXIST);
        }

        if (moEltConceptos == null) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + (new cfd.ver33.DElementConceptos().getName()) + "'" + DElement.ERR_MSG_NODE_NO_EXIST);
        }
        
        // validate text conformity to requiered regular expressions:
        
        if (!moAttSerie.getString().isEmpty() && !DCfdi33Utils.matches(moAttSerie.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttSerie.getLengthMin() + "," + moAttSerie.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttSerie.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!moAttFolio.getString().isEmpty() && !DCfdi33Utils.matches(moAttFolio.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttFolio.getLengthMin() + "," + moAttFolio.getLengthMax() + "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttFolio.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!moAttCondicionesDePago.getString().isEmpty() && !DCfdi33Utils.matches(moAttCondicionesDePago.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttCondicionesDePago.getLengthMin() + "," + moAttCondicionesDePago.getLengthMax() + "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttCondicionesDePago.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!moAttConfirmacion.getString().isEmpty() && !DCfdi33Utils.matches(moAttConfirmacion.getString(), DCfdi33Consts.REGEX_CONFIRM)) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttConfirmacion.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName + " "
                + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
                + "xmlns:cfdi=\"http://www.sat.gob.mx/cfd/3\" "
                + (!hasComplementCe11()? "" : DElementComercioExterior.XMLNS + " ")
                + (!hasComplementLf10()? "" : DElementLeyendasFiscales.XMLNS + " ")
                + (!hasComplementRp10()? "" : DElementPagos.XMLNS + " ")
                + (!isCfdiPayroll() ? "" : DElementNomina.XMLNS + " ")
                + (moEltOpcAddenda == null || moEltOpcAddenda.getNamespace().isEmpty() ? "" : moEltOpcAddenda.getNamespace() + " ")
                + "xsi:schemaLocation=\""
                + "http://www.sat.gob.mx/cfd/3 http://www.sat.gob.mx/sitio_internet/cfd/3/cfdv33.xsd"
                + (!hasComplementCe11()? "" : " " + DElementComercioExterior.XSI)
                + (!hasComplementLf10()? "" : " " + DElementLeyendasFiscales.XSI)
                + (!hasComplementRp10()? "" : " " + DElementPagos.XSI)
                + (!isCfdiPayroll() ? "" : " " + DElementNomina.XSI)
                + (moEltOpcAddenda == null || moEltOpcAddenda.getXsdLocation().isEmpty() ? "" : " " + moEltOpcAddenda.getXsdLocation()) + "\"";

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            if (!aux.isEmpty()) {
                xml += " " + aux;
            }
        }

        xml += ">";

        for (DElement element : createElementsArray()) {
            String aux = element.getElementForXml();
            if (!aux.isEmpty()) {
                xml += "\n" + aux;
            }
        }

        xml += "\n</" + msName + ">";

        return xml;
    }
    
    /**
     * Composes original string with XSLT file 'cadenaoriginal_3_3.xslt'.
     * @return
     * @throws Exception 
     */
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        try {
            //string = SXmlUtils.transformXmlFromUrl(getElementForXml(), DCfdi33Consts.XSLT_3_3_URL);
            string = SXmlUtils.transformXmlFromFile(getElementForXml(), DCfdi33Consts.XSLT_3_3_FILE);
        } 
        catch (Exception ex) {
            Logger.getLogger(DElementComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return string;
    }
}
