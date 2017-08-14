/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DCfdMath;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementOtrosPagos extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.nom12.DElementOtroPago> mvEltHijosOtroPago;

    public DElementOtrosPagos() {
        super("nomina12:OtrosPagos");

        mvEltHijosOtroPago = new Vector<DElementOtroPago>();
    }

    public java.util.Vector<cfd.ver3.nom12.DElementOtroPago> getEltHijosOtroPago() { return mvEltHijosOtroPago; }

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

        if (mvEltHijosOtroPago.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom12.DElementOtroPago().getName()) + "'.");
        }
        else {
            for (DElementOtroPago otroPago : mvEltHijosOtroPago) {
                xml = otroPago.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();
        
        for (DElementOtroPago otroPago : mvEltHijosOtroPago) {
            string += otroPago.getElementForOriginalString();
        }

        return string;
    }
    
    public double getTotal() {
        double total = 0;
        
        for (DElementOtroPago otroPago : mvEltHijosOtroPago) {
            total = DCfdMath.round((total + otroPago.getAttImporte().getDouble()), otroPago.moAttImporte.getDecimals());
        }
        return total;
    }
}
