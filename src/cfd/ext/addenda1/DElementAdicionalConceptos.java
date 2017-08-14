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
public class DElementAdicionalConceptos extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.addenda1.DElementAdicionalConcepto> mvEltHijosAdicionalConcepto;

    public DElementAdicionalConceptos() {
        super("myadd:AdicionalConceptos");

        mvEltHijosAdicionalConcepto = new Vector<DElementAdicionalConcepto>();
    }

    public java.util.Vector<cfd.ext.addenda1.DElementAdicionalConcepto> getEltHijosAdicionalConcepto() { return mvEltHijosAdicionalConcepto; }

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

        if (mvEltHijosAdicionalConcepto.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.addenda1.DElementAdicionalConcepto().getName()) + "'.");
        }
        else {
            for (DElementAdicionalConcepto adicionalConcepto : mvEltHijosAdicionalConcepto) {
                xml = adicionalConcepto.getElementForXml();
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
