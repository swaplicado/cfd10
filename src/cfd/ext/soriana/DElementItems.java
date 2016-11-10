/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.soriana;

import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementItems extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.soriana.DElementArticulos> mvEltHijosArticulos;

    public DElementItems() {
        super("");
        mvEltHijosArticulos = new Vector<DElementArticulos>();
    }

    public java.util.Vector<cfd.ext.soriana.DElementArticulos> getEltHijosArticulos() { return mvEltHijosArticulos; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        if (mvEltHijosArticulos.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementArticulos item : mvEltHijosArticulos) {
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
