package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementComercioExterior extends cfd.DElement {

    public static final String XSI = "http://www.sat.gob.mx/ComercioExterior11  http://www.sat.gob.mx/sitio_internet/cfd/ComercioExterior11/ComercioExterior11.xsd";
    public static final String XMLNS = "xmlns:cce11=\"http://www.sat.gob.mx/ComercioExterior11\"";

    private final DAttributeString moAttVersion;
    private final DAttributeString moAttMotivoTraslado;
    private final DAttributeString moAttTipoOperacion;
    private final DAttributeString moAttClaveDePedimento;
    private final DAttributeInteger moAttCertificadoOrigen;
    private final DAttributeString moAttNumCertificadoOrigen;
    private final DAttributeString moAttNumeroExportadorConfiable;
    private final DAttributeString moAttIncoterm;
    private final DAttributeInteger moAttSubdivision;
    private final DAttributeString moAttObservaciones;
    private final DAttributeTipoCambio moAttTipoCambioUSD;
    private final DAttributeTypeImporte moAttTotalUSD;

    protected cfd.ver3.cce11.DElementEmisor moEltEmisor;
    protected cfd.ver3.cce11.DElementPropietario moEltPropietario;
    protected cfd.ver3.cce11.DElementReceptor moEltReceptor;
    protected cfd.ver3.cce11.DElementDestinatario moEltDestinatario;
    protected cfd.ver3.cce11.DElementMercancias moEltMercancias;

    public DElementComercioExterior() {
        super("cce11:ComercioExterior");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString("1.1");
        moAttMotivoTraslado = new DAttributeString("MotivoTraslado", false, 2, 2);
        moAttTipoOperacion = new DAttributeString("TipoOperacion", true, 1, 1);
        moAttClaveDePedimento = new DAttributeString("ClaveDePedimento", true, 2, 2);
        moAttCertificadoOrigen = new DAttributeInteger("CertificadoOrigen", true, 1, 1);
        moAttCertificadoOrigen.setCanBeZero(true);
        moAttNumCertificadoOrigen = new DAttributeString("NumCertificadoOrigen", false, 6, 40);
        moAttNumeroExportadorConfiable = new DAttributeString("NumeroExportadorConfiable", false, 1, 50);
        moAttIncoterm = new DAttributeString("Incoterm", false, 3, 3);
        moAttSubdivision = new DAttributeInteger("Subdivision", false, 1, 1);
        moAttSubdivision.setCanBeZero(true);
        moAttObservaciones = new DAttributeString("Observaciones", false, 1, 300);
        moAttTipoCambioUSD = new DAttributeTipoCambio("TipoCambioUSD", false);
        moAttTotalUSD = new DAttributeTypeImporte("TotalUSD", false);

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
        mvAttributes.add(moAttTipoCambioUSD);
        mvAttributes.add(moAttTotalUSD);

        moEltEmisor = null;
        moEltPropietario = null;
        moEltReceptor = null;
        moEltDestinatario = null;
        moEltMercancias = null;
    }
    
    /*
     * Private methods:
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltEmisor != null) {
            elements.add(moEltEmisor);
        }
        
        if (moEltPropietario != null) {
            elements.add(moEltPropietario);
        }
        
        if (moEltReceptor != null) {
            elements.add(moEltReceptor);
        }
        
        if (moEltDestinatario != null) {
            elements.add(moEltDestinatario);
        }
        
        if (moEltMercancias != null) {
            elements.add(moEltMercancias);
        }
        
        return elements;
    }
    
    /*
     * Public methods:
     */

    public void setEltEmisor(cfd.ver3.cce11.DElementEmisor o) { moEltEmisor = o; }
    public void setEltPropietario(cfd.ver3.cce11.DElementPropietario o) { moEltPropietario = o; }
    public void setEltReceptor(cfd.ver3.cce11.DElementReceptor o) { moEltReceptor = o; }
    public void setEltDestinatario(cfd.ver3.cce11.DElementDestinatario o) { moEltDestinatario = o; }
    public void setEltMercancias(cfd.ver3.cce11.DElementMercancias o) { moEltMercancias = o; }
    
    public DAttributeString getAttVersion() { return moAttVersion; }
    public DAttributeString getAttMotivoTraslado() { return moAttMotivoTraslado; }
    public DAttributeString getAttTipoOperacion() { return moAttTipoOperacion; }
    public DAttributeString getAttClaveDePedimento() { return moAttClaveDePedimento; }
    public DAttributeInteger getAttCertificadoOrigen() { return moAttCertificadoOrigen; }
    public DAttributeString getAttNumCertificadoOrigen() { return moAttNumCertificadoOrigen; }
    public DAttributeString getAttNumeroExportadorConfiable() { return moAttNumeroExportadorConfiable; }
    public DAttributeString getAttIncoterm() { return moAttIncoterm; }
    public DAttributeInteger getAttSubdivision() { return moAttSubdivision; }
    public DAttributeString getAttObservaciones() { return moAttObservaciones; }
    public DAttributeTipoCambio getAttTipoCambioUSD() { return moAttTipoCambioUSD; }
    public DAttributeTypeImporte getAttTotalUSD() { return moAttTotalUSD; }

    public cfd.ver3.cce11.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ver3.cce11.DElementPropietario getEltPropietario() { return moEltPropietario; }
    public cfd.ver3.cce11.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ver3.cce11.DElementDestinatario getEltDestinatario() { return moEltDestinatario; }
    public cfd.ver3.cce11.DElementMercancias getEltMercancias() { return moEltMercancias; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
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

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        for (DElement element : createElementsArray()) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
