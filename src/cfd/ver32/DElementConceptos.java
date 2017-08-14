/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

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
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        if (mvEltHijosConcepto.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver33.DElementConcepto().getName()) + "'.");
        }
        else {
            for (DElementConcepto concepto : mvEltHijosConcepto) {
                xml = concepto.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";

        for (DElementConcepto concepto : mvEltHijosConcepto) {
            string += concepto.getElementForOriginalString();
        }

        return string;
    }
}
