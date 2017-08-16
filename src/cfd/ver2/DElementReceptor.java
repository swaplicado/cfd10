/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

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

    protected cfd.ver2.DElementTipoUbicacion moEltDomicilio;

    public DElementReceptor() {
        super("Receptor");

        moAttRfc = new DAttributeTypeRfc("rfc", true);
        moAttNombre = new DAttributeString("nombre", false, 1);

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);

        moEltDomicilio = new DElementTipoUbicacion("Domicilio");
    }

    public cfd.DAttributeTypeRfc getAttRfc() { return moAttRfc; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }

    public cfd.ver2.DElementTipoUbicacion getEltDomicilio() { return moEltDomicilio; }

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
        String string = super.getElementForOriginalString();    // for element attributes and element validation 

        string += moEltDomicilio.getElementForOriginalString();

        return string;
    }
}
