/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementIncapacidades extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.nom12.DElementIncapacidad> mvEltHijosIncapacidad;

    public DElementIncapacidades() {
        super("nomina12:Incapacidades");

        mvEltHijosIncapacidad = new Vector<DElementIncapacidad>();
    }

    public java.util.Vector<cfd.ver3.nom12.DElementIncapacidad> getEltHijosIncapacidad() { return mvEltHijosIncapacidad; }

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

        if (mvEltHijosIncapacidad.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementIncapacidad incapacidad : mvEltHijosIncapacidad) {
                xml = incapacidad.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();
        
        for (DElementIncapacidad incapacidad : mvEltHijosIncapacidad) {
            string += incapacidad.getElementForOriginalString();
        }

        return string;
    }
}
