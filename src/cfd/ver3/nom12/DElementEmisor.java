/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementEmisor extends cfd.DElement {

    protected cfd.DAttributeString moAttCurp;
    protected cfd.DAttributeString moAttRegistroPatronal;
    protected cfd.DAttributeTypeRfc moAttRfcPatronOrigen;

    protected cfd.ver3.nom12.DElementEntidadSncf moEltEntidadSncf;
    
    public DElementEmisor() {
        super("nomina12:Emisor");

        moAttCurp = new DAttributeString("Curp", false);
        moAttRegistroPatronal = new DAttributeString("RegistroPatronal", false, 1, 20); // Existe un patron
        moAttRfcPatronOrigen = new DAttributeTypeRfc("RfcPatronOrigen", false);

        mvAttributes.add(moAttCurp);
        mvAttributes.add(moAttRegistroPatronal);
        mvAttributes.add(moAttRfcPatronOrigen);
        
        moEltEntidadSncf = null;
    }

    public cfd.DAttributeString getAttCurp() { return moAttCurp; }
    public cfd.DAttributeString getAttRegistroPatronal() { return moAttRegistroPatronal; }
    public cfd.DAttributeTypeRfc getAttRfcPatronOrigen() { return moAttRfcPatronOrigen; }

    public void setEltEntidadSncf(cfd.ver3.nom12.DElementEntidadSncf o) { moEltEntidadSncf = o; }
    
    public cfd.ver3.nom12.DElementEntidadSncf getEltEntidadSncf() { return moEltEntidadSncf; }
    
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
        
        if (moEltEntidadSncf != null) {
            xml = moEltEntidadSncf.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes
        
        if (moEltEntidadSncf != null) {
            string += moEltEntidadSncf.getElementForOriginalString();
        }
        
        return string;
    }
}
