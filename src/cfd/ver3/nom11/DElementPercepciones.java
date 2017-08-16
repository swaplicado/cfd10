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
public class DElementPercepciones extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalGravado;
    protected cfd.DAttributeTypeImporte moAttTotalExento;

    protected java.util.Vector<cfd.ver3.nom11.DElementPercepcion> mvEltHijosPercepcion;

    public DElementPercepciones() {
        super("nomina:Percepciones");

        moAttTotalGravado = new DAttributeTypeImporte("TotalGravado", true);
        moAttTotalGravado.setCanBeZero(true);
        moAttTotalExento = new DAttributeTypeImporte("TotalExento", true);
        moAttTotalExento.setCanBeZero(true);

        mvAttributes.add(moAttTotalGravado);
        mvAttributes.add(moAttTotalExento);

        mvEltHijosPercepcion = new Vector<DElementPercepcion>();
    }

    public cfd.DAttributeTypeImporte getAttTotalGravado() { return moAttTotalGravado; }
    public cfd.DAttributeTypeImporte getAttTotalExento() { return moAttTotalExento; }

    public java.util.Vector<cfd.ver3.nom11.DElementPercepcion> getEltHijosPercepcion() { return mvEltHijosPercepcion; }

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

        if (mvEltHijosPercepcion.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom11.DElementPercepcion().getName()) + "'.");
        }
        else {
            for (DElementPercepcion percepcion : mvEltHijosPercepcion) {
                xml = percepcion.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes and element validation 
        
        for (DElementPercepcion percepcion : mvEltHijosPercepcion) {
            string += percepcion.getElementForOriginalString();
        }

        return string;
    }
}
