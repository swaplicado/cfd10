/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosTrasladados extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.elektra.DElementTrasladado> mvEltTrasladado;

    public DElementImpuestosTrasladados() {
        super("ap:Traslados");

        mvEltTrasladado = new Vector<DElementTrasladado>();
    }

    public java.util.Vector<cfd.ext.elektra.DElementTrasladado> getEltTrasladado() { return mvEltTrasladado; }

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

        if (mvEltTrasladado.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.elektra.DElementTrasladado().getName()) + "'.");
        }
        else {
            for (DElementTrasladado item : mvEltTrasladado) {
                xml = item.getElementForXml();
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
