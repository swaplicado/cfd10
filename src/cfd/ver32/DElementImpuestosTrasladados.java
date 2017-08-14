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
public class DElementImpuestosTrasladados extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver32.DElementImpuestoTraslado> mvEltHijosImpuestoTrasladado;

    public DElementImpuestosTrasladados() {
        super("cfdi:Traslados");

        mvEltHijosImpuestoTrasladado = new Vector<DElementImpuestoTraslado>();
    }

    public java.util.Vector<cfd.ver32.DElementImpuestoTraslado> getEltHijosImpuestoTrasladado() { return mvEltHijosImpuestoTrasladado; }

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

        if (mvEltHijosImpuestoTrasladado.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver32.DElementImpuestoTraslado().getName()) + "'.");
        }
        else {

            for (DElementImpuestoTraslado traslado : mvEltHijosImpuestoTrasladado) {
                xml = traslado.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";

        for (DElementImpuestoTraslado traslado : mvEltHijosImpuestoTrasladado) {
            string += traslado.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        //System.out.println(getClass().getName() + ".hasChildren(): [hijos=" + mvEltHijosImpuestoTrasladado.size() + "]\n");

        return mvEltHijosImpuestoTrasladado.size() > 0;
    }
}
