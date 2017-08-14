/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom11;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementHorasExtras extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.nom11.DElementHorasExtra> mvEltHijosHorasExtra;

    public DElementHorasExtras() {
        super("nomina:HorasExtras");

        mvEltHijosHorasExtra = new Vector<DElementHorasExtra>();
    }

    public java.util.Vector<cfd.ver3.nom11.DElementHorasExtra> getEltHijosHorasExtra() { return mvEltHijosHorasExtra; }

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

        if (mvEltHijosHorasExtra.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom11.DElementHorasExtra().getName()) + "'.");
        }
        else {
            for (DElementHorasExtra incapacidad : mvEltHijosHorasExtra) {
                xml = incapacidad.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";
        
        for (DElementHorasExtra horaExtra : mvEltHijosHorasExtra) {
            string += horaExtra.getElementForOriginalString();
        }

        return string;
    }
}
