/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Néstor Ávalos Balcázar
 */
public class DElementDetailItems extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.elektra.DElementDetalle> mvEltDetalle;

    public DElementDetailItems() {
        super("");

        mvEltDetalle = new Vector<DElementDetalle>();
    }

    public java.util.Vector<cfd.ext.elektra.DElementDetalle> getEltDetalle() { return mvEltDetalle; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        if (mvEltDetalle.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementDetalle item : mvEltDetalle) {
                xml = item.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
