/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementDeducciones extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalOtrasDeducciones;
    protected cfd.DAttributeTypeImporte moAttTotalImpuestosRetenidos;

    protected java.util.Vector<cfd.ver3.nom12.DElementDeduccion> mvEltHijosDeduccion;

    public DElementDeducciones() {
        super("nomina12:Deducciones");

        moAttTotalOtrasDeducciones = new DAttributeTypeImporte("TotalOtrasDeducciones", false);
        moAttTotalImpuestosRetenidos = new DAttributeTypeImporte("TotalImpuestosRetenidos", false);

        mvAttributes.add(moAttTotalOtrasDeducciones);
        mvAttributes.add(moAttTotalImpuestosRetenidos);

        mvEltHijosDeduccion = new Vector<DElementDeduccion>();
    }

    public cfd.DAttributeTypeImporte getAttTotalOtrasDeducciones() { return moAttTotalOtrasDeducciones; }
    public cfd.DAttributeTypeImporte getAttTotalImpuestosRetenidos() { return moAttTotalImpuestosRetenidos; }

    public java.util.Vector<cfd.ver3.nom12.DElementDeduccion> getEltHijosDeduccion() { return mvEltHijosDeduccion; }

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

        if (mvEltHijosDeduccion.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementDeduccion deduccion : mvEltHijosDeduccion) {
                xml = deduccion.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes
        
        for (DElementDeduccion deduccion : mvEltHijosDeduccion) {
            string += deduccion.getElementForOriginalString();
        }

        return string;
    }
}
