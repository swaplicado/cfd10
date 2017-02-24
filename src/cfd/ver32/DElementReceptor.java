/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementReceptor extends cfd.DElement {

    protected cfd.DAttributeTypeRfc moAttRfc;
    protected cfd.DAttributeString moAttNombre;
    protected cfd.DAttributeString moAttNumRegIdTrib;

    protected cfd.ver32.DElementTipoUbicacion moEltDomicilio;

    public DElementReceptor() {
        super("cfdi:Receptor");

        moAttRfc = new DAttributeTypeRfc("rfc", true);
        moAttNombre = new DAttributeString("nombre", false, 1);
        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false);

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);
        mvAttributes.add(moAttNumRegIdTrib);

        moEltDomicilio = new DElementTipoUbicacion("cfdi:Domicilio");
    }

    public cfd.DAttributeTypeRfc getAttRfc() { return moAttRfc; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }
    public cfd.DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }

    public cfd.ver32.DElementTipoUbicacion getEltDomicilio() { return moEltDomicilio; }

    public void clearEltDomicilio() {
        moEltDomicilio = null;
    }
    
    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        if (moEltDomicilio != null) {
            xml = moEltDomicilio.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes

        if (moEltDomicilio != null) {
            string += moEltDomicilio.getElementForOriginalString();
        }

        return string;
    }
}
