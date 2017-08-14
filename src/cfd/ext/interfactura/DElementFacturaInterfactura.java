/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.interfactura;

import cfd.DAttributeString;
import cfd.DElementExtAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementFacturaInterfactura extends cfd.DElementExtAddenda {

    protected cfd.DAttributeString moAttxmlns;
    protected cfd.DAttributeString moAttTipoDocumento;
    protected cfd.DAttributeString moAttschemaLocation;
    protected cfd.ext.interfactura.DElementEmisor moEltEmisor;
    protected cfd.ext.interfactura.DElementReceptor moEltReceptor;
    protected cfd.ext.interfactura.DElementEncabezado moEltEncabezado;

    public DElementFacturaInterfactura() {
        super("if:FacturaInterfactura", DElementExtAddendaType.LOreal);

        moAttxmlns = new DAttributeString("xmlns:if", true);
        moAttTipoDocumento = new DAttributeString("TipoDocumento", true);
        moAttschemaLocation = new DAttributeString("schemaLocation", true);
        moEltEmisor = new DElementEmisor();
        moEltReceptor = new DElementReceptor();
        moEltEncabezado = new DElementEncabezado();

        mvAttributes.add(moAttxmlns);
        mvAttributes.add(moAttTipoDocumento);
        mvAttributes.add(moAttschemaLocation);
        mvElements.add(moEltEmisor);
        mvElements.add(moEltReceptor);
        mvElements.add(moEltEncabezado);
    }

    public void setEltEncabezado(cfd.ext.interfactura.DElementEncabezado o) {
        if (moEltEncabezado != null) {
            mvElements.remove(moEltEncabezado);
        }

        moEltEncabezado = o;
        mvElements.add(moEltEncabezado);
    }

    public cfd.DAttributeString getAttxmlns() { return moAttxmlns; }
    public cfd.DAttributeString getAttTipoDocumento() { return moAttTipoDocumento; }
    public cfd.DAttributeString getAttschemaLocation() { return moAttschemaLocation; }
    public cfd.ext.interfactura.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ext.interfactura.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ext.interfactura.DElementEncabezado getEltEncabezado() { return moEltEncabezado; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
