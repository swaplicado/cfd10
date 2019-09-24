/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementEmisor extends cfd.DElement {

    private final DAttributeString moAttCurp;       // required if person

    private DElementTipoDomicilioNac moEltDomicilio;    // required in CFDI 3.3
    
    public DElementEmisor() {
        super("cce11:Emisor");

        moAttCurp = new DAttributeString("Curp", false, 18, 18);    // text from 18 fixed characters

        mvAttributes.add(moAttCurp);
        
        moEltDomicilio = null;
    }

    public void setEltDomicilio(DElementTipoDomicilioNac o) { moEltDomicilio = o; }
    
    public DAttributeString getAttCurp() { return moAttCurp; }
    
    public DElementTipoDomicilioNac getEltDomicilio() { return moEltDomicilio; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";
        
        if (moEltDomicilio != null) {
            String aux = moEltDomicilio.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        if (moEltDomicilio != null) {
            string += moEltDomicilio.getElementForOriginalString();
        }
        
        return string;
    }
}
