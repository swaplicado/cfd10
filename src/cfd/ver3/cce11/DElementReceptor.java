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
public class DElementReceptor extends cfd.DElement {

    private final DAttributeString moAttNumRegIdTrib;

    private DElementTipoDomicilioInt moEltDomicilio;    // required in CFDI 3.3

    public DElementReceptor() {
        super("cce11:Receptor");

        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false, 6, 40); // from 6 to 40 characters

        mvAttributes.add(moAttNumRegIdTrib);

        moEltDomicilio = null;
    }

    public void setEltDomicilio(DElementTipoDomicilioInt o) { moEltDomicilio = o; }
    
    public DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }

    public DElementTipoDomicilioInt getEltDomicilio() { return moEltDomicilio; }
    
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
        String string = super.getElementForOriginalString();    // for element attributes and element validation 

        if (moEltDomicilio != null) {
            string += moEltDomicilio.getElementForOriginalString();
        }

        return string;
    }
}
