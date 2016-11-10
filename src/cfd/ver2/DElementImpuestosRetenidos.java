/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import java.util.Vector;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosRetenidos extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver2.DElementImpuestoRetencion> mvEltHijosImpuestoRetenido;

    public DElementImpuestosRetenidos() {
        super("Retenciones");

        mvEltHijosImpuestoRetenido = new Vector<DElementImpuestoRetencion>();
    }

    public java.util.Vector<cfd.ver2.DElementImpuestoRetencion> getEltHijosImpuestoRetenido() { return mvEltHijosImpuestoRetenido; }

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

        if (mvEltHijosImpuestoRetenido.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementImpuestoRetencion retencion : mvEltHijosImpuestoRetenido) {
                xml = retencion.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
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
