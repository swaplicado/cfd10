/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.ver32.DElementTipoUbicacion;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDestinatario extends cfd.DElement {

    protected cfd.DAttributeString moAttNumRegIdTrib;
    protected cfd.DAttributeString moAttNombre;

    protected cfd.ver32.DElementTipoUbicacion moEltDomicilio;

    public DElementDestinatario() {
        super("cce11:Destinatario");

        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false);
        moAttNombre = new DAttributeString("Nombre", false);

        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttNombre);

        moEltDomicilio = new DElementTipoUbicacion("cce11:Domicilio");
    }

    public cfd.DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }

    public cfd.ver32.DElementTipoUbicacion getEltDomicilio() { return moEltDomicilio; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        xml = moEltDomicilio.getElementForXml();
        string += xml.isEmpty() ? "" : "\n" + xml;

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes

        string += moEltDomicilio.getElementForOriginalString();

        return string;
    }
}
