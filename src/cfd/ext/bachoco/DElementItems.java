/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementItems extends cfd.DElementParent {

    protected java.util.Vector<cfd.ext.bachoco.DElementLineItem> mvEltHijosLineItem;

    public DElementItems() {
        super("");
        mvEltHijosLineItem = new Vector<DElementLineItem>();
    }

    public java.util.Vector<cfd.ext.bachoco.DElementLineItem> getEltHijosLineItem() { return mvEltHijosLineItem; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        if (mvEltHijosLineItem.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.bachoco.DElementLineItem().getName()) + "'.");
        }
        else {
            for (DElementLineItem item : mvEltHijosLineItem) {
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
