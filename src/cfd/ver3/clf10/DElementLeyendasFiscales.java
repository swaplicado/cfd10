/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.clf10;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementLeyendasFiscales extends cfd.DElement {

    public static final String XSI = "http://www.sat.gob.mx/leyendasFiscales http://www.sat.gob.mx/sitio_internet/cfd/leyendasFiscales/leyendasFisc.xsd";
    public static final String XMLNS = "xmlns:leyendasFisc=\"http://www.sat.gob.mx/leyendasFiscales\"";
    
    private final DAttributeString moAttVersion;
    private ArrayList<DElementLeyenda> maEltLeyendas;
    
    public DElementLeyendasFiscales() {
        super("leyendasFisc:LeyendasFiscales");
        
        moAttVersion = new DAttributeString("version", true);
        moAttVersion.setString("1.0");
        
        mvAttributes.add(moAttVersion);
        
        maEltLeyendas = new ArrayList<>();
    }
    
    /*
     * Private methods:
     */

    /*
     * Public methods:
     */

    public DAttributeString getAttVersion() { return moAttVersion; }
    public ArrayList<DElementLeyenda> getEltLeyendas() { return maEltLeyendas; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltLeyendas.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + getName() + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementLeyenda().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        for (DElementLeyenda element : maEltLeyendas) {
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
        
        for (DElementLeyenda element : maEltLeyendas) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
