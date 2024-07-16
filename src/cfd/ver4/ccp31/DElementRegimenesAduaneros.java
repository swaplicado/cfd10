/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp31;

import cfd.DAttribute;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Servín
 */
public class DElementRegimenesAduaneros extends cfd.DElement {
    
    private final ArrayList<DElementRegimenAduanero> maEltRegimenAduanero;

    public DElementRegimenesAduaneros() {
        super("cartaporte31:RegimenesAduaneros");
        
        maEltRegimenAduanero = new ArrayList<>();
    }
    
    public ArrayList<DElementRegimenAduanero> getEltRegimenAduanero() { return maEltRegimenAduanero; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any

        // validate child elements:
        
        if (maEltRegimenAduanero.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementRemolque().getName()) + "'.");
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

        for (DElementRegimenAduanero element : maEltRegimenAduanero) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementRegimenAduanero element : maEltRegimenAduanero) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
