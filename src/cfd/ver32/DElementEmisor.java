/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementEmisor extends cfd.DElement {

    protected cfd.DAttributeTypeRfc moAttRfc;
    protected cfd.DAttributeString moAttNombre;

    protected cfd.ver32.DElementTipoUbicacionFiscal moEltDomicilioFiscal;
    protected cfd.ver32.DElementTipoUbicacion moEltOpcExpedidoEn;
    java.util.Vector<cfd.ver32.DElementRegimenFiscal> mvEltHijosRegimenFiscal;

    public DElementEmisor() {
        super("cfdi:Emisor");

        moAttRfc = new DAttributeTypeRfc("rfc", true);
        moAttNombre = new DAttributeString("nombre", true, 1);

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);

        moEltDomicilioFiscal = new DElementTipoUbicacionFiscal("cfdi:DomicilioFiscal");
        moEltOpcExpedidoEn = null;
        mvEltHijosRegimenFiscal = new Vector<DElementRegimenFiscal>();
    }

    public void setEltOpcExpedidoEn(cfd.ver32.DElementTipoUbicacion o) { moEltOpcExpedidoEn = o; }
    public java.util.Vector<cfd.ver32.DElementRegimenFiscal> getEltHijosRegimenFiscal() { return mvEltHijosRegimenFiscal; }

    public cfd.DAttributeTypeRfc getAttRfc() { return moAttRfc; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }

    public cfd.ver32.DElementTipoUbicacionFiscal getEltDomicilioFiscal() { return moEltDomicilioFiscal; }
    public cfd.ver32.DElementTipoUbicacion getEltOpcExpedidoEn() { return moEltOpcExpedidoEn; }
    
    public void clearEltDomicilioFiscal() {
        moEltDomicilioFiscal = null;
    }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        if (moEltDomicilioFiscal != null) {
            xml = moEltDomicilioFiscal.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcExpedidoEn != null) {
            xml = moEltOpcExpedidoEn.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        if (mvEltHijosRegimenFiscal.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementRegimenFiscal regimen : mvEltHijosRegimenFiscal) {
                xml = regimen.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes

        if (moEltDomicilioFiscal != null) {
            string += moEltDomicilioFiscal.getElementForOriginalString();
        }

        if (moEltOpcExpedidoEn != null) {
            string += moEltOpcExpedidoEn.getElementForOriginalString();
        }

        for (DElementRegimenFiscal regimen : mvEltHijosRegimenFiscal) {
                string += regimen.getElementForOriginalString();
            }

        return string;
    }
}
