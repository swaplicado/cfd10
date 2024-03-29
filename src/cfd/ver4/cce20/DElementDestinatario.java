/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver4.cce20;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDestinatario extends cfd.DElement {

    private final DAttributeString moAttNumRegIdTrib;
    private final DAttributeString moAttNombre;

    private final DElementTipoDomicilioInt moEltDomicilio;  // required

    public DElementDestinatario() {
        super("cce20:Destinatario");

        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false, 6, 40); // from 6 to 40 characters
        moAttNombre = new DAttributeString("Nombre", false, 1, 300);            // from 1 to 300 characters

        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttNombre);

        moEltDomicilio = new DElementTipoDomicilioInt();
    }

    public DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public DAttributeString getAttNombre() { return moAttNombre; }

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
