/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DCfdMath;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementMercancias extends cfd.DElement {

    private final ArrayList<DElementMercancia> maEltMercancias;

    public DElementMercancias() {
        super("cce11:Mercancias");

        maEltMercancias = new ArrayList<>();
    }

    public ArrayList<DElementMercancia> getEltMercancias() { return maEltMercancias; }

    /**
     * Add one element Element Mercancia type to vector, if does not exist.
     * @param elementMercancia element to add.
     */
    public void addMercancia(final DElementMercancia elementMercancia) {
        boolean exists = false;
        
        for (DElementMercancia mercancia : maEltMercancias) {
            if (mercancia.getAttNoIdentificacion().getString().compareTo(elementMercancia.getAttNoIdentificacion().getString()) == 0 &&
                    mercancia.getAttFraccionArancelaria().getString().compareTo(elementMercancia.getAttFraccionArancelaria().getString()) == 0) {
                mercancia.getAttCantidadAduana().setDouble(DCfdMath.round((mercancia.getAttCantidadAduana().getDouble() + elementMercancia.getAttCantidadAduana().getDouble()), elementMercancia.getAttCantidadAduana().getDecimals()));
                mercancia.getAttValorDolares().setDouble(DCfdMath.round((mercancia.getAttValorDolares().getDouble() + elementMercancia.getAttValorDolares().getDouble()), mercancia.getAttValorDolares().getDecimals()));
                exists = true;
                break;
            }
        }
        
        if (!exists) {
            maEltMercancias.add(elementMercancia);
        }
    }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        if (maEltMercancias.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementMercancia().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        for (DElementMercancia element : maEltMercancias) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        validateElement();
        
        String string = "";

        for (DElementMercancia element : maEltMercancias) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
