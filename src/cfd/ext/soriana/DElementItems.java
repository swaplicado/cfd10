/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementItems extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.soriana.DElementArticulos> mvEltHijosArticulos;

    public DElementItems() {
        super("");
        mvEltHijosArticulos = new Vector<DElementArticulos>();
    }

    public java.util.Vector<cfd.ext.soriana.DElementArticulos> getEltHijosArticulos() { return mvEltHijosArticulos; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        if (mvEltHijosArticulos.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.soriana.DElementArticulos().getName()) + "'.");
        }
        else {
            for (DElementArticulos item : mvEltHijosArticulos) {
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
