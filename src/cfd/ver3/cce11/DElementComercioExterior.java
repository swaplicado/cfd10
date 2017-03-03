package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementComercioExterior extends cfd.DElement {

    protected cfd.DAttributeString moAttVersion;
    protected cfd.DAttributeString moAttMotivoTraslado;
    protected cfd.DAttributeString moAttTipoOperacion;
    protected cfd.DAttributeString moAttClaveDePedimento;
    protected cfd.DAttributeInteger moAttCertificadoOrigen;
    protected cfd.DAttributeString moAttNumCertificadoOrigen;
    protected cfd.DAttributeString moAttNumeroExportadorConfiable;
    protected cfd.DAttributeString moAttIncoterm;
    protected cfd.DAttributeInteger moAttSubdivision;
    protected cfd.DAttributeString moAttObservaciones;
    protected cfd.DAttributeTypeImporte moAttTipoCambioUsd;
    protected cfd.DAttributeTypeImporte moAttTotalUsd;

    protected cfd.ver3.cce11.DElementEmisor moEltEmisor;
    protected cfd.ver3.cce11.DElementPropietario moEltPropietario;
    protected cfd.ver3.cce11.DElementReceptor moEltReceptor;
    protected cfd.ver3.cce11.DElementDestinatario moEltDestinatario;
    protected cfd.ver3.cce11.DElementMercancias moEltMercancias;

    public DElementComercioExterior() {
        super("cce11:ComercioExterior");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString("1.1");
        moAttMotivoTraslado = new DAttributeString("MotivoTraslado", false);
        moAttTipoOperacion = new DAttributeString("TipoOperacion", true);
        moAttClaveDePedimento = new DAttributeString("ClaveDePedimento", false);
        moAttCertificadoOrigen = new DAttributeInteger("CertificadoOrigen", false);
        moAttNumCertificadoOrigen = new DAttributeString("NumCertificadoOrigen", false);
        moAttNumeroExportadorConfiable = new DAttributeString("NumeroExportadorConfiable", false);
        moAttIncoterm = new DAttributeString("Incoterm", false);
        moAttSubdivision = new DAttributeInteger("Subdivision", false);
        moAttSubdivision.setCanBeZero(true);
        moAttObservaciones = new DAttributeString("Observaciones", false);
        moAttTipoCambioUsd = new DAttributeTypeImporte("TipoCambioUSD", false);
        moAttTotalUsd = new DAttributeTypeImporte("TotalUSD", false);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttMotivoTraslado);
        mvAttributes.add(moAttTipoOperacion);
        mvAttributes.add(moAttClaveDePedimento);
        mvAttributes.add(moAttCertificadoOrigen);
        mvAttributes.add(moAttNumCertificadoOrigen);
        mvAttributes.add(moAttNumeroExportadorConfiable);
        mvAttributes.add(moAttIncoterm);
        mvAttributes.add(moAttSubdivision);
        mvAttributes.add(moAttObservaciones);
        mvAttributes.add(moAttTipoCambioUsd);
        mvAttributes.add(moAttTotalUsd);

        moEltEmisor = null;
        moEltPropietario = null;
        moEltReceptor = null;
        moEltDestinatario = null;
        moEltMercancias = null;
    }

    public void setEltEmisor(cfd.ver3.cce11.DElementEmisor o) { moEltEmisor = o; }
    public void setEltPropietario(cfd.ver3.cce11.DElementPropietario o) { moEltPropietario = o; }
    public void setEltReceptor(cfd.ver3.cce11.DElementReceptor o) { moEltReceptor = o; }
    public void setEltDestinatario(cfd.ver3.cce11.DElementDestinatario o) { moEltDestinatario = o; }
    public void setEltMercancias(cfd.ver3.cce11.DElementMercancias o) { moEltMercancias = o; }
    
    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttMotivoTraslado() { return moAttMotivoTraslado; }
    public cfd.DAttributeString getAttTipoOperacion() { return moAttTipoOperacion; }
    public cfd.DAttributeString getAttClaveDePedimento() { return moAttClaveDePedimento; }
    public cfd.DAttributeInteger getAttCertificadoOrigen() { return moAttCertificadoOrigen; }
    public cfd.DAttributeString getAttNumCertificadoOrigen() { return moAttNumCertificadoOrigen; }
    public cfd.DAttributeString getAttNumeroExportadorConfiable() { return moAttNumeroExportadorConfiable; }
    public cfd.DAttributeString getAttIncoterm() { return moAttIncoterm; }
    public cfd.DAttributeInteger getAttSubdivision() { return moAttSubdivision; }
    public cfd.DAttributeString getAttObservaciones() { return moAttObservaciones; }
    public cfd.DAttributeTypeImporte getAttTipoCambioUsd() { return moAttTipoCambioUsd; }
    public cfd.DAttributeTypeImporte getAttTotalUsd() { return moAttTotalUsd; }

    public cfd.ver3.cce11.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ver3.cce11.DElementPropietario getEltPropietario() { return moEltPropietario; }
    public cfd.ver3.cce11.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ver3.cce11.DElementDestinatario getEltDestinatario() { return moEltDestinatario; }
    public cfd.ver3.cce11.DElementMercancias getEltMercancias() { return moEltMercancias; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName + " " +
                "xsi:schemaLocation=\"http://www.sat.gob.mx/ComercioExterior11  http://www.sat.gob.mx/sitio_internet/cfd/ComercioExterior11/ComercioExterior11.xsd\" " +
                "xmlns:cce11=\"http://www.sat.gob.mx/ComercioExterior11\" ";

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        if (moEltEmisor != null) {
            xml = moEltEmisor.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        if (moEltPropietario != null) {
            xml = moEltPropietario.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        if (moEltReceptor != null) {
            xml = moEltReceptor.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        if (moEltDestinatario != null) {
            xml = moEltDestinatario.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        if (moEltMercancias != null) {
            xml = moEltMercancias.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        string += moAttVersion.getAttributeForOriginalString();
        string += moAttMotivoTraslado.getAttributeForOriginalString();
        string += moAttTipoOperacion.getAttributeForOriginalString();
        string += moAttClaveDePedimento.getAttributeForOriginalString();
        string += moAttCertificadoOrigen.getAttributeForOriginalString();
        string += moAttNumCertificadoOrigen.getAttributeForOriginalString();
        string += moAttNumeroExportadorConfiable.getAttributeForOriginalString();
        string += moAttIncoterm.getAttributeForOriginalString();
        string += moAttSubdivision.getAttributeForOriginalString();
        string += moAttObservaciones.getAttributeForOriginalString();
        string += moAttTipoCambioUsd.getAttributeForOriginalString();
        string += moAttTotalUsd.getAttributeForOriginalString();

        if (moEltEmisor != null) {
            string += moEltEmisor.getElementForOriginalString();
        }
        
        if (moEltPropietario != null) {
            string += moEltPropietario.getElementForOriginalString();
        }
        
        if (moEltReceptor != null) {
            string += moEltReceptor.getElementForOriginalString();
        }
        
        if (moEltDestinatario != null) {
            string += moEltDestinatario.getElementForOriginalString();
        }
        
        if (moEltMercancias != null) {
            string += moEltMercancias.getElementForOriginalString();
        }
        
        return string;
    }
}
