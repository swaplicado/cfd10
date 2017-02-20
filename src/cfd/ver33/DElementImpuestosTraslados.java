package cfd.ver33;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementImpuestosTraslados extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver33.DElementImpuestoTraslado> mvEltHijosImpuestoTrasladado;

    public DElementImpuestosTraslados() {
        super("cfdi:Traslados");

        mvEltHijosImpuestoTrasladado = new Vector<DElementImpuestoTraslado>();
    }

    public java.util.Vector<cfd.ver33.DElementImpuestoTraslado> getEltHijosImpuestoTrasladado() { return mvEltHijosImpuestoTrasladado; }

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

        if (mvEltHijosImpuestoTrasladado.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {

            for (DElementImpuestoTraslado traslado : mvEltHijosImpuestoTrasladado) {
                xml = traslado.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        for (DElementImpuestoTraslado traslado : mvEltHijosImpuestoTrasladado) {
            string += traslado.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return mvEltHijosImpuestoTrasladado.size() > 0;
    }
}
