/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosRetenidos extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver32.DElementImpuestoRetencion> mvEltHijosImpuestoRetenido;

    public DElementImpuestosRetenidos() {
        super("cfdi:Retenciones");

        mvEltHijosImpuestoRetenido = new Vector<DElementImpuestoRetencion>();
    }

    public java.util.Vector<cfd.ver32.DElementImpuestoRetencion> getEltHijosImpuestoRetenido() { return mvEltHijosImpuestoRetenido; }

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

        if (mvEltHijosImpuestoRetenido.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver32.DElementImpuestoRetencion().getName()) + "'.");
        }
        else {
            for (DElementImpuestoRetencion retencion : mvEltHijosImpuestoRetenido) {
                xml = retencion.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";

        for (DElementImpuestoRetencion retencion : mvEltHijosImpuestoRetenido) {
            string += retencion.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        //System.out.println(getClass().getName() + ".hasChildren(): [hijos=" + mvEltHijosImpuestoRetenido.size() + "]\n");

        return mvEltHijosImpuestoRetenido.size() > 0;
    }
}
