/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Isabel
 */
public class DElementPartesTransporte extends cfd.DElement {
    
    private final DAttributeString moAttParteTransporte;
    
    private final DElementDomicilio moEltDomicilio;

    public DElementPartesTransporte() {
        super("cartaporte20:PartesTransporte");
        
        moAttParteTransporte = new DAttributeString("ParteTransporte", true);
        
        mvAttributes.add(moAttParteTransporte);
        
        moEltDomicilio = null;
    }
    
    public DAttributeString getAttParteTransporte() { return moAttParteTransporte; }
    
    public DElementDomicilio getEltDomicilio() { return moEltDomicilio; }
    
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        String aux = moEltDomicilio.getElementForXml();
        xml += aux.isEmpty() ? "" : "\n" + aux;

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        string += moEltDomicilio.getElementForOriginalString();

        return string;
    }
    
}
