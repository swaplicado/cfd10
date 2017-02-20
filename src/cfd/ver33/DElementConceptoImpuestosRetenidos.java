package cfd.ver33;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementConceptoImpuestosRetenidos extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver33.DElementConceptoImpuestoRetencion> mvEltHijosConceptoImpuestoRetenido;

    public DElementConceptoImpuestosRetenidos() {
        super("cfdi:Retenciones");

        mvEltHijosConceptoImpuestoRetenido = new Vector<DElementConceptoImpuestoRetencion>();
    }

    public java.util.Vector<cfd.ver33.DElementConceptoImpuestoRetencion> getEltHijosImpuestoRetenido() { return mvEltHijosConceptoImpuestoRetenido; }

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

        if (mvEltHijosConceptoImpuestoRetenido.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementConceptoImpuestoRetencion retencion : mvEltHijosConceptoImpuestoRetenido) {
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

        for (DElementConceptoImpuestoRetencion retencion : mvEltHijosConceptoImpuestoRetenido) {
            string += retencion.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return mvEltHijosConceptoImpuestoRetenido.size() > 0;
    }
}
