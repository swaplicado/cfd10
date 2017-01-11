/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;
import sa.lib.SLibUtils;

/**
 *
 * @author Juan Barajas
 */
public class DElementOtrosPagos extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.nom12.DElementOtroPago> mvEltHijosOtroPago;

    public DElementOtrosPagos() {
        super("nomina12:OtrosPagos");

        mvEltHijosOtroPago = new Vector<DElementOtroPago>();
    }

    public java.util.Vector<cfd.ver3.nom12.DElementOtroPago> getEltHijosOtroPago() { return mvEltHijosOtroPago; }

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

        if (mvEltHijosOtroPago.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementOtroPago otroPago : mvEltHijosOtroPago) {
                xml = otroPago.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();
        
        for (DElementOtroPago otroPago : mvEltHijosOtroPago) {
            string += otroPago.getElementForOriginalString();
        }

        return string;
    }
    
    public double getTotal() {
        double total = 0;
        
        for (DElementOtroPago otroPago : mvEltHijosOtroPago) {
            total = SLibUtils.round((total + otroPago.getAttImporte().getDouble()), SLibUtils.DecimalFormatValue2D.getMaximumFractionDigits());
        }
        return total;
    }
}
