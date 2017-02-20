package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Juan Barajas
 */
public class DElementCfdiRelacionados extends cfd.DElement {

    protected cfd.DAttributeString moAttTipoRelacion;

    protected java.util.Vector<cfd.ver33.DElementCfdiRelacionado> mvEltCfdiRelacionado;

    public DElementCfdiRelacionados() {
        super("cfdi:CfdiRelacionados");

        moAttTipoRelacion = new DAttributeString("TipoRelacion", true);
        
        mvEltCfdiRelacionado = new java.util.Vector<cfd.ver33.DElementCfdiRelacionado>();

        mvAttributes.add(moAttTipoRelacion);
    }

    public cfd.DAttributeString getAttTipoRelacion() { return moAttTipoRelacion; }
    
    public java.util.Vector<cfd.ver33.DElementCfdiRelacionado> getEltCfdiRelacionado() { return mvEltCfdiRelacionado; }
    
    
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
        
        if (mvEltCfdiRelacionado.isEmpty()) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementCfdiRelacionado cfdi : mvEltCfdiRelacionado) {
                xml = cfdi.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }
    
    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes

        for (DElementCfdiRelacionado cfdi : mvEltCfdiRelacionado) {
            string += cfdi.getElementForOriginalString();
        }

        return string;
    }
}
