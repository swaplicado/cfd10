/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttribute;
import cfd.DAttributeInteger;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Néstor Ávalos Balcázar
 */
public class DElementImpuestosTrasladados extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.elektra.DElementTrasladado> mvEltTrasladado;

    public DElementImpuestosTrasladados() {
        super("ap:Traslados");

        mvEltTrasladado = new Vector<DElementTrasladado>();
    }

    public java.util.Vector<cfd.ext.elektra.DElementTrasladado> getEltTrasladado() { return mvEltTrasladado; }

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

        if (mvEltTrasladado.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementTrasladado item : mvEltTrasladado) {
                xml = item.getElementForXml();
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
