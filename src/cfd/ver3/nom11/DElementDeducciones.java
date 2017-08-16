/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom11;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDeducciones extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalGravado;
    protected cfd.DAttributeTypeImporte moAttTotalExento;

    protected java.util.Vector<cfd.ver3.nom11.DElementDeduccion> mvEltHijosDeduccion;

    public DElementDeducciones() {
        super("nomina:Deducciones");

        moAttTotalGravado = new DAttributeTypeImporte("TotalGravado", true);
        moAttTotalGravado.setCanBeZero(true);
        moAttTotalExento = new DAttributeTypeImporte("TotalExento", true);
        moAttTotalExento.setCanBeZero(true);

        mvAttributes.add(moAttTotalGravado);
        mvAttributes.add(moAttTotalExento);

        mvEltHijosDeduccion = new Vector<DElementDeduccion>();
    }

    public cfd.DAttributeTypeImporte getAttTotalGravado() { return moAttTotalGravado; }
    public cfd.DAttributeTypeImporte getAttTotalExento() { return moAttTotalExento; }


    public java.util.Vector<cfd.ver3.nom11.DElementDeduccion> getEltHijosDeduccion() { return mvEltHijosDeduccion; }

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
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom11.DElementDeduccion().getName()) + "'.");
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
