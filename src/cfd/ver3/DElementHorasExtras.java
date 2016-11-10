/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementHorasExtras extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.DElementHorasExtra> mvEltHijosHorasExtra;

    public DElementHorasExtras() {
        super("nomina:HorasExtras");

        mvEltHijosHorasExtra = new Vector<DElementHorasExtra>();
    }

    public java.util.Vector<cfd.ver3.DElementHorasExtra> getEltHijosHorasExtra() { return mvEltHijosHorasExtra; }

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

        if (mvEltHijosHorasExtra.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementHorasExtra incapacidad : mvEltHijosHorasExtra) {
                xml = incapacidad.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";
        
        for (DElementHorasExtra horaExtra : mvEltHijosHorasExtra) {
            string += horaExtra.getElementForOriginalString();
        }

        return string;
    }
}
