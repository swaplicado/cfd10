package cfd.ver40.crp20;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DCfdConsts;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel Danae García Servín
 */
public class DElementPagos extends cfd.DElement {

    public static final String XSI = "http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd";
    public static final String XMLNS = "xmlns:pago10=\"http://www.sat.gob.mx/Pagos\"";
    
    /*
     * Attributes' declaration-order according to CRP 2.0 specification
     */
    
    private final DAttributeString moAttVersion;
    
    private final DElementTotales moEltTotales;
    private final ArrayList<DElementPagosPago> maEltPagos;

    /**
     * Creates a new instance of class DElementPagos.
     */
    public DElementPagos() {
        super("pago20:Pagos");

        moAttVersion = new DAttributeString("Version", true, 3, 3); // fixed text value "1.0"
        moAttVersion.setString("" + DCfdConsts.COMP_RP_20);

        mvAttributes.add(moAttVersion);

        moEltTotales = new DElementTotales();
        maEltPagos = new ArrayList<>();
    }
    
    /*
     * Private methods:
     */
    
     private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltTotales != null) {
            elements.add(moEltTotales);
        }
        
        return elements;
     }
    
    /*
     * Public methods:
     */

    public float getVersion() { return DCfdConsts.COMP_RP_10; }

    public DAttributeString getAttVersion() { return moAttVersion; }
    
    public DElementTotales getEltTotales() { return moEltTotales; }
    public ArrayList<DElementPagosPago> getEltPagos() { return maEltPagos; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltPagos.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + (this.getName()) + "'" + DElement.ERR_MSG_NODE_NO_CHILD);
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

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

        for (DElementPagosPago element : maEltPagos) {
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
        
        for (DElementPagosPago element : maEltPagos) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
