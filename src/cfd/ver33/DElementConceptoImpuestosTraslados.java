package cfd.ver33;

import cfd.DAttribute;
import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementConceptoImpuestosTraslados extends cfd.DElement implements DElementWithChildren {

    protected java.util.Vector<cfd.ver33.DElementConceptoImpuestoTraslado> mvEltHijosConceptoImpuestoTrasladado;

    public DElementConceptoImpuestosTraslados() {
        super("cfdi:Traslados");

        mvEltHijosConceptoImpuestoTrasladado = new Vector<DElementConceptoImpuestoTraslado>();
    }

    public java.util.Vector<cfd.ver33.DElementConceptoImpuestoTraslado> getEltHijosImpuestoTrasladado() { return mvEltHijosConceptoImpuestoTrasladado; }

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

        if (mvEltHijosConceptoImpuestoTrasladado.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {

            for (DElementConceptoImpuestoTraslado traslado : mvEltHijosConceptoImpuestoTrasladado) {
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

        for (DElementConceptoImpuestoTraslado traslado : mvEltHijosConceptoImpuestoTrasladado) {
            string += traslado.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return mvEltHijosConceptoImpuestoTrasladado.size() > 0;
    }
}
