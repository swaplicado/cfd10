/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementUbicaciones extends cfd.DElement {
    
    private final ArrayList<DElementUbicacion> maEltUbicaciones;

    public DElementUbicaciones() {
        super("cartaporte20:Ubicaciones");
        
        maEltUbicaciones = new ArrayList<>();
    }
    
    public ArrayList<DElementUbicacion> getEltUbicaciones() { return maEltUbicaciones; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any

        // validate child elements:
        
        if (maEltUbicaciones.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementUbicacion().getName()) + "'.");
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
        
        for (DElementUbicacion element : maEltUbicaciones) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementUbicacion element : maEltUbicaciones) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
