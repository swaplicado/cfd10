package cfd.ver33;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementImpuestosRetenidos extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver33.DElementImpuestoRetencion> mvEltHijosImpuestoRetenido;

    public DElementImpuestosRetenidos() {
        super("cfdi:Retenciones");

        mvEltHijosImpuestoRetenido = new Vector<DElementImpuestoRetencion>();
    }

    public java.util.Vector<cfd.ver33.DElementImpuestoRetencion> getEltHijosImpuestoRetenido() { return mvEltHijosImpuestoRetenido; }

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

        if (mvEltHijosImpuestoRetenido.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementImpuestoRetencion retencion : mvEltHijosImpuestoRetenido) {
                xml = retencion.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        for (DElementImpuestoRetencion retencion : mvEltHijosImpuestoRetenido) {
            string += retencion.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return mvEltHijosImpuestoRetenido.size() > 0;
    }
}
