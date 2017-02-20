package cfd.ver33;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementConceptos extends cfd.DElement {

    protected java.util.Vector<cfd.ver33.DElementConcepto> mvEltHijosConcepto;

    public DElementConceptos() {
        super("cfdi:Conceptos");

        mvEltHijosConcepto = new Vector<DElementConcepto>();
    }

    public java.util.Vector<cfd.ver33.DElementConcepto> getEltHijosConcepto() { return mvEltHijosConcepto; }

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

        if (mvEltHijosConcepto.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementConcepto concepto : mvEltHijosConcepto) {
                xml = concepto.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        for (DElementConcepto concepto : mvEltHijosConcepto) {
            string += concepto.getElementForOriginalString();
        }

        return string;
    }
}
