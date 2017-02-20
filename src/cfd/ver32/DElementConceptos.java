/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import java.util.Vector;

import cfd.DAttribute;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptos extends cfd.DElement {

    protected java.util.Vector<cfd.ver32.DElementConcepto> mvEltHijosConcepto;

    public DElementConceptos() {
        super("cfdi:Conceptos");

        mvEltHijosConcepto = new Vector<DElementConcepto>();
    }

    public java.util.Vector<cfd.ver32.DElementConcepto> getEltHijosConcepto() { return mvEltHijosConcepto; }

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

        if (mvEltHijosConcepto.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementConcepto concepto : mvEltHijosConcepto) {
                xml = concepto.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        for (DElementConcepto concepto : mvEltHijosConcepto) {
            string += concepto.getElementForOriginalString();
        }

        return string;
    }
}
