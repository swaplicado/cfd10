/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttribute;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementRetencionesDR extends cfd.DElement {

    private final DElementRetencionDR moEltRetencionDR;
    
    public DElementRetencionesDR() {
        super("pagos20:RetencionesDR");
        
        moEltRetencionDR = new DElementRetencionDR();
    }
    
    /*
     * Private methods:
     */
    
     private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltRetencionDR != null) {
            elements.add(moEltRetencionDR);
        }
        
        return elements;
     }
    
    /*
     * Public methods:
     */
    
     public DElementRetencionDR getEltRetencionDR() { return moEltRetencionDR; }
     
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
