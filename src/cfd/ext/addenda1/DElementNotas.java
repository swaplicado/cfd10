/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

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
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        if (mvEltHijosNota.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.addenda1.DElementNota().getName()) + "'.");
        }
        else {
            for (DElementNota nota : mvEltHijosNota) {
                xml = nota.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
