/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementIncapacidades extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.nom12.DElementIncapacidad> mvEltHijosIncapacidad;

    public DElementIncapacidades() {
        super("nomina12:Incapacidades");

        mvEltHijosIncapacidad = new Vector<>();
    }

    public java.util.Vector<cfd.ver3.nom12.DElementIncapacidad> getEltHijosIncapacidad() { return mvEltHijosIncapacidad; }

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

        if (mvEltHijosIncapacidad.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom12.DElementIncapacidad().getName()) + "'.");
        }
        else {
            for (DElementIncapacidad incapacidad : mvEltHijosIncapacidad) {
                xml = incapacidad.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();
        
        for (DElementIncapacidad incapacidad : mvEltHijosIncapacidad) {
            string += incapacidad.getElementForOriginalString();
        }

        return string;
    }
}
