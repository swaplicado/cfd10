/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDetailItems extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.elektra.DElementDetalle> mvEltDetalle;

    public DElementDetailItems() {
        super("");

        mvEltDetalle = new Vector<DElementDetalle>();
    }

    public java.util.Vector<cfd.ext.elektra.DElementDetalle> getEltDetalle() { return mvEltDetalle; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        if (mvEltDetalle.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.elektra.DElementDetalle().getName()) + "'.");
        }
        else {
            for (DElementDetalle item : mvEltDetalle) {
                xml = item.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
