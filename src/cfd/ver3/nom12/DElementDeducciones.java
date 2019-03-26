/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
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

        mvEltHijosDeduccion = new Vector<>();
    }

    public cfd.DAttributeTypeImporte getAttTotalOtrasDeducciones() { return moAttTotalOtrasDeducciones; }
    public cfd.DAttributeTypeImporte getAttTotalImpuestosRetenidos() { return moAttTotalImpuestosRetenidos; }

    public java.util.Vector<cfd.ver3.nom12.DElementDeduccion> getEltHijosDeduccion() { return mvEltHijosDeduccion; }

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

        if (mvEltHijosDeduccion.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom12.DElementDeduccion().getName()) + "'.");
        }
        else {
            for (DElementDeduccion deduccion : mvEltHijosDeduccion) {
                xml = deduccion.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes and element validation 
        
        for (DElementDeduccion deduccion : mvEltHijosDeduccion) {
            string += deduccion.getElementForOriginalString();
        }

        return string;
    }
}
