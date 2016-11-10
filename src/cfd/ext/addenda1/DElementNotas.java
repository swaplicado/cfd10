/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import java.util.Vector;

import cfd.DAttribute;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementNotas extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.addenda1.DElementNota> mvEltHijosNota;

    public DElementNotas() {
        super("myadd:Notas");

        mvEltHijosNota = new Vector<DElementNota>();
    }

    public java.util.Vector<cfd.ext.addenda1.DElementNota> getEltHijosNota() { return mvEltHijosNota; }

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

        if (mvEltHijosNota.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementNota nota : mvEltHijosNota) {
                xml = nota.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
