package cfd.ver4.ccp30;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementCartaPorte extends cfd.DElement {

    public static final String XSI = "http://www.sat.gob.mx/CartaPorte30  http://www.sat.gob.mx/sitio_internet/cfd/CartaPorte/CartaPorte30.xsd";
    public static final String XMLNS = "xmlns:cartaporte30=\"http://www.sat.gob.mx/CartaPorte30\"";
    public static final String VERSION = "3.0";

    private final DAttributeString moAttVersion;
    private final DAttributeString moAttIdCCP;
    private final DAttributeString moAttTranspInternac;
    private final DAttributeString moAttRegimenAduanero;
    private final DAttributeString moAttEntradaSalidaMerc;
    private final DAttributeString moAttPaisOrigenDestino;
    private final DAttributeString moAttViaEntradaSalida;
    private final DAttributeDouble moAttTotalDistRec;
    private final DAttributeString moAttRegistroISTMO;
    private final DAttributeString moAttUbicacionPoloOrigen;
    private final DAttributeString moAttUbicacionPoloDestino;
    
    protected cfd.ver4.ccp30.DElementUbicaciones moEltUbicaciones;
    protected cfd.ver4.ccp30.DElementMercancias moEltMercancias;
    protected cfd.ver4.ccp30.DElementFiguraTransporte moEltFiguraTransporte;
    
    public DElementCartaPorte() {
        super("cartaporte30:CartaPorte");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString(VERSION);
        moAttIdCCP = new DAttributeString("IdCCP", true);
        moAttTranspInternac = new DAttributeString("TranspInternac", true, 2, 2);
        moAttRegimenAduanero = new DAttributeString("RegimenAduanero", false);
        moAttEntradaSalidaMerc = new DAttributeString("EntradaSalidaMerc", false);
        moAttPaisOrigenDestino = new DAttributeString("PaisOrigenDestino", false);
        moAttViaEntradaSalida = new DAttributeString("ViaEntradaSalida", false);
        moAttTotalDistRec = new DAttributeDouble("TotalDistRec", false, 3);
        moAttRegistroISTMO = new DAttributeString("RegistroISTMO", false, 2, 2);
        moAttUbicacionPoloOrigen = new DAttributeString("UbicacionPoloOrigen", false);
        moAttUbicacionPoloDestino = new DAttributeString("UbicacionPoloDestino", false);
        
        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttIdCCP);
        mvAttributes.add(moAttTranspInternac);
        mvAttributes.add(moAttRegimenAduanero);
        mvAttributes.add(moAttEntradaSalidaMerc);
        mvAttributes.add(moAttPaisOrigenDestino);
        mvAttributes.add(moAttViaEntradaSalida);
        mvAttributes.add(moAttTotalDistRec);
        mvAttributes.add(moAttRegistroISTMO);
        mvAttributes.add(moAttUbicacionPoloOrigen);
        mvAttributes.add(moAttUbicacionPoloDestino);
        
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

    public void setEltUbicaciones(cfd.ver4.ccp30.DElementUbicaciones o) { moEltUbicaciones = o; }
    public void setEltMercancias(cfd.ver4.ccp30.DElementMercancias o) { moEltMercancias = o; }
    public void setEltFiguraTransporte(cfd.ver4.ccp30.DElementFiguraTransporte o) { moEltFiguraTransporte = o; }
    
    public DAttributeString getAttVersion() { return moAttVersion; }
    public DAttributeString getAttIdCCP() { return moAttIdCCP; }
    public DAttributeString getAttTransInternac() { return moAttTranspInternac; }
    public DAttributeString getAttRegimenAduanero() { return moAttRegimenAduanero; }
    public DAttributeString getAttEntradaSalidaMerc() { return moAttEntradaSalidaMerc; }
    public DAttributeString getAttPaisOrigenDestino() { return moAttPaisOrigenDestino; }
    public DAttributeString getAttViaEntradaSalida() { return moAttViaEntradaSalida; }
    public DAttributeDouble getAttTotalDistRec() { return moAttTotalDistRec; }
    public DAttributeString getAttRegistroISTMO() { return moAttRegistroISTMO; }
    public DAttributeString getAttUbicacionPoloOrigen() { return moAttUbicacionPoloOrigen; }
    public DAttributeString getAttUbicacionPoloDestino() { return moAttUbicacionPoloDestino; }
    
    public cfd.ver4.ccp30.DElementUbicaciones getEltUbicaciones() { return moEltUbicaciones; }
    public cfd.ver4.ccp30.DElementMercancias getEltMercancias() { return moEltMercancias; }
    public cfd.ver4.ccp30.DElementFiguraTransporte getEltFiguraTransporte() { return moEltFiguraTransporte; }
    
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
