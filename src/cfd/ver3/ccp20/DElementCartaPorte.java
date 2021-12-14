package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementCartaPorte extends cfd.DElement {

    public static final String XSI = "http://www.sat.gob.mx/CartaPorte20  http://www.sat.gob.mx/sitio_internet/cfd/CartaPorte/CartaPorte20.xsd";
    public static final String XMLNS = "xmlns:cartaporte20=\"http://www.sat.gob.mx/CartaPorte20\"";

    private final DAttributeString moAttVersion;
    private final DAttributeString moAttTranspInternac;
    private final DAttributeString moAttEntradaSalidaMerc;
    private final DAttributeString moAttViaEntradaSalida;
    private final DAttributeString moAttPaisOrigenDestino;
    private final DAttributeDouble moAttTotalDistRec;
    
    protected cfd.ver3.ccp20.DElementUbicaciones moEltUbicaciones;
    protected cfd.ver3.ccp20.DElementMercancias moEltMercancias;
    protected cfd.ver3.ccp20.DElementFiguraTransporte moEltFiguraTransporte;
    
    public DElementCartaPorte() {
        super("cartaporte20:CartaPorte");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString("2.0");
        moAttTranspInternac = new DAttributeString("TranspInternac", true, 2, 2);
        moAttEntradaSalidaMerc = new DAttributeString("EntradaSalidaMerc", false);
        moAttViaEntradaSalida = new DAttributeString("ViaEntradaSalida", false);
        moAttPaisOrigenDestino = new DAttributeString("PaisOrigenDestino", false);
        moAttTotalDistRec = new DAttributeDouble("TotalDistRec", true, 3);
        
        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttTranspInternac);
        mvAttributes.add(moAttEntradaSalidaMerc);
        mvAttributes.add(moAttViaEntradaSalida);
        mvAttributes.add(moAttPaisOrigenDestino);
        mvAttributes.add(moAttTotalDistRec);
        
        moEltUbicaciones = new DElementUbicaciones();
        moEltMercancias = new DElementMercancias();
        moEltFiguraTransporte = new DElementFiguraTransporte();
    }
    
    /*
     * Private methods:
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltUbicaciones != null) {
            elements.add(moEltUbicaciones);
        }
        
        if (moEltMercancias != null) {
            elements.add(moEltMercancias);
        }
        
        if (moEltFiguraTransporte != null) {
            elements.add(moEltFiguraTransporte);
        }
        
        return elements;
    }
    
    /*
     * Public methods:
     */

    public void setEltUbicaciones(cfd.ver3.ccp20.DElementUbicaciones o) { moEltUbicaciones = o; }
    public void setEltMercancias(cfd.ver3.ccp20.DElementMercancias o) { moEltMercancias = o; }
    public void setEltFiguraTransporte(cfd.ver3.ccp20.DElementFiguraTransporte o) { moEltFiguraTransporte = o; }
    
    public DAttributeString getAttVersion() { return moAttVersion; }
    public DAttributeString getAttTransInternac() { return moAttTranspInternac; }
    public DAttributeString getAttEntradaSalidaMerc() { return moAttEntradaSalidaMerc; }
    public DAttributeString getAttViaEntradaSalida() { return moAttViaEntradaSalida; }
    public DAttributeString getAttPaisOrigenDestino() { return moAttPaisOrigenDestino; }
    public DAttributeDouble getAttTotalDistRec() { return moAttTotalDistRec; }
    
    public cfd.ver3.ccp20.DElementUbicaciones getEltUbicaciones() { return moEltUbicaciones; }
    public cfd.ver3.ccp20.DElementMercancias getEltMercancias() { return moEltMercancias; }
    public cfd.ver3.ccp20.DElementFiguraTransporte getEltFiguraTransporte() { return moEltFiguraTransporte; }
    
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
