/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import java.util.Vector;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosTrasladados extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver3.DElementImpuestoTraslado> mvEltHijosImpuestoTrasladado;

    public DElementImpuestosTrasladados() {
        super("cfdi:Traslados");

        mvEltHijosImpuestoTrasladado = new Vector<DElementImpuestoTraslado>();
    }

    public java.util.Vector<cfd.ver3.DElementImpuestoTraslado> getEltHijosImpuestoTrasladado() { return mvEltHijosImpuestoTrasladado; }

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

        if (mvEltHijosImpuestoTrasladado.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {

            for (DElementImpuestoTraslado traslado : mvEltHijosImpuestoTrasladado) {
                xml = traslado.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
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
