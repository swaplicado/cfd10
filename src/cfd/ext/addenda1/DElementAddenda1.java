/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DElementExtAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAddenda1 extends cfd.DElementExtAddenda {

    public static final String ADDENDA_LOCATION = "http://www.tron.com.mx/addenda http://www.tron.com.mx/addenda/addenda1.xsd";
    public static final String ADDENDA_NAME_SPACE = "xmlns:myadd=\"http://www.tron.com.mx/addenda\"";

    protected cfd.ext.addenda1.DElementMoneda moEltMoneda;
    protected cfd.ext.addenda1.DElementAdicional moEltAdicional;
    protected cfd.ext.addenda1.DElementPagare moEltOpcPagare;

    public DElementAddenda1() {
        super("myadd:Addenda1", DElementExtAddendaType.SoftwareAplicado);

        moEltMoneda = new DElementMoneda();
        moEltAdicional = new DElementAdicional();
        moEltOpcPagare = null;

        mvElements.add(moEltMoneda);
        mvElements.add(moEltAdicional);
    }

    public void setEltOpcPagare(cfd.ext.addenda1.DElementPagare o) {
        if (moEltOpcPagare != null) {
            mvElements.remove(moEltOpcPagare);
        }

        moEltOpcPagare = o;
        mvElements.add(moEltOpcPagare);
    }

    public cfd.ext.addenda1.DElementMoneda getEltMoneda() { return moEltMoneda; }
    public cfd.ext.addenda1.DElementAdicional getEltAdicional() { return moEltAdicional; }
    public cfd.ext.addenda1.DElementPagare getEltOpcPagare() { return moEltOpcPagare; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }

    public static String[] createXmlLocationNs() {
        return new String[] { ADDENDA_LOCATION, ADDENDA_NAME_SPACE };
    }
}
