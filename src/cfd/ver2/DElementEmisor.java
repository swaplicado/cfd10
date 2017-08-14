/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;
import cfd.DCfdConsts;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementEmisor extends cfd.DElement {

    protected float mfVersion;

    protected cfd.DAttributeTypeRfc moAttRfc;
    protected cfd.DAttributeString moAttNombre;

    protected cfd.ver2.DElementTipoUbicacionFiscal moEltDomicilioFiscal;
    protected cfd.ver2.DElementTipoUbicacion moEltOpcExpedidoEn;
    protected java.util.Vector<cfd.ver2.DElementRegimenFiscal> mvEltHijosRegimenFiscal;

    public DElementEmisor(float version) {
        super("Emisor");

        mfVersion = version;

        moAttRfc = new DAttributeTypeRfc("rfc", true);
        moAttNombre = new DAttributeString("nombre", true, 1);

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);

        moEltDomicilioFiscal = new DElementTipoUbicacionFiscal("DomicilioFiscal");
        moEltOpcExpedidoEn = null;
        mvEltHijosRegimenFiscal = new Vector<DElementRegimenFiscal>();
    }

    public void setEltOpcExpedidoEn(cfd.ver2.DElementTipoUbicacion o) { moEltOpcExpedidoEn = o; }
    public java.util.Vector<cfd.ver2.DElementRegimenFiscal> getEltHijosRegimenFiscal() { return mvEltHijosRegimenFiscal; }

    public cfd.DAttributeTypeRfc getAttRfc() { return moAttRfc; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }

    public cfd.ver2.DElementTipoUbicacionFiscal getEltDomicilioFiscal() { return moEltDomicilioFiscal; }
    public cfd.ver2.DElementTipoUbicacion getEltOpcExpedidoEn() { return moEltOpcExpedidoEn; }

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

        xml = moEltDomicilioFiscal.getElementForXml();
        string += xml.isEmpty() ? "" : "\n" + xml;

        if (moEltOpcExpedidoEn != null) {
            xml = moEltOpcExpedidoEn.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        if (mfVersion == DCfdConsts.CFD_VER_22) {
            if (mvEltHijosRegimenFiscal.isEmpty()) {
                throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver2.DElementRegimenFiscal().getName()) + "'.");
            }
            else {
                for (DElementRegimenFiscal regimen : mvEltHijosRegimenFiscal) {
                    xml = regimen.getElementForXml();
                    string += xml.isEmpty() ? "" : "\n" + xml;
                }
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes

        string += moEltDomicilioFiscal.getElementForOriginalString();

        if (moEltOpcExpedidoEn != null) {
            string += moEltOpcExpedidoEn.getElementForOriginalString();
        }

        if (mfVersion == DCfdConsts.CFD_VER_22) {
            for (DElementRegimenFiscal regimen : mvEltHijosRegimenFiscal) {
                    string += regimen.getElementForOriginalString();
                }
        }

        return string;
    }
}
