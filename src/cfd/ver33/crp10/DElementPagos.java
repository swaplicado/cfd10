package cfd.ver33.crp10;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPagos extends cfd.DElement {

    public static final String VERSION = "1.0";
    public static final String NAME = "pago10:Pagos";
    public static final String XSI = "http://www.sat.gob.mx/Pagos http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos10.xsd";
    public static final String XMLNS = "xmlns:pago10=\"http://www.sat.gob.mx/Pagos\"";
    
    /*
     * Attributes' declaration-order according to CRP 1.0 specification
     */
    
    private final DAttributeString moAttVersion;
    
    private final ArrayList<DElementPagosPago> maEltPagos;

    /**
     * Creates a new instance of class DElementPagos.
     */
    public DElementPagos() {
        super(NAME);

        moAttVersion = new DAttributeString("Version", true, 3, 3); // fixed text value "1.0"
        moAttVersion.setString(VERSION);

        mvAttributes.add(moAttVersion);

        maEltPagos = new ArrayList<>();
    }
    
    /*
     * Private methods:
     */
    
    /*
     * Public methods:
     */

    public float getVersion() { return SLibUtils.parseFloat(VERSION); }

    public DAttributeString getAttVersion() { return moAttVersion; }
    
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
        
        for (DElementPagosPago element : maEltPagos) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
