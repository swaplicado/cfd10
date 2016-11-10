/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementDeducciones extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalGravado;
    protected cfd.DAttributeTypeImporte moAttTotalExento;

    protected java.util.Vector<cfd.ver3.DElementDeduccion> mvEltHijosDeduccion;

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


    public java.util.Vector<cfd.ver3.DElementDeduccion> getEltHijosDeduccion() { return mvEltHijosDeduccion; }

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
