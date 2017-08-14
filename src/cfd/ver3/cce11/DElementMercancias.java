/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DCfdMath;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementMercancias extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.cce11.DElementMercancia> mvEltHijosMercancia;

    public DElementMercancias() {
        super("cce11:Mercancias");

        mvEltHijosMercancia = new Vector<DElementMercancia>();
    }

    public java.util.Vector<cfd.ver3.cce11.DElementMercancia> getEltHijosMercancia() { return mvEltHijosMercancia; }

    /**
     * Add one element Element Mercancia type to vector, if not exists.
     * @param elementMercancia element to add.
     */
    public void addMercancia(cfd.ver3.cce11.DElementMercancia elementMercancia) {
        boolean exists = false;
        
        for (cfd.ver3.cce11.DElementMercancia mercancia : mvEltHijosMercancia) {
            if (mercancia.getAttNoIdentificacion().getString().compareTo(elementMercancia.getAttNoIdentificacion().getString()) == 0 &&
                    mercancia.getAttFraccionArancelaria().getString().compareTo(elementMercancia.getAttFraccionArancelaria().getString()) == 0) {
                mercancia.getAttCantidadAduana().setDouble(DCfdMath.round((mercancia.getAttCantidadAduana().getDouble() + elementMercancia.getAttCantidadAduana().getDouble()), elementMercancia.getAttCantidadAduana().getDecimals()));
                mercancia.getAttValorDolares().setDouble(DCfdMath.round((mercancia.getAttValorDolares().getDouble() + elementMercancia.getAttValorDolares().getDouble()), mercancia.getAttValorDolares().getDecimals()));
                exists = true;
                break;
            }
        }
        
        if (!exists) {
            mvEltHijosMercancia.add(elementMercancia);
        }
    }
    
    
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

        if (mvEltHijosMercancia.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.cce11.DElementMercancia().getName()) + "'.");
        }
        else {
            for (DElementMercancia concepto : mvEltHijosMercancia) {
                xml = concepto.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";

        for (DElementMercancia concepto : mvEltHijosMercancia) {
            string += concepto.getElementForOriginalString();
        }

        return string;
    }
}
