package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCfdiRelacionados extends cfd.DElement {

    private final DAttributeString moAttTipoRelacion;

    private final ArrayList<cfd.ver33.DElementCfdiRelacionado> maEltCfdiRelacionados;

    public DElementCfdiRelacionados() {
        super("cfdi:CfdiRelacionados");

        moAttTipoRelacion = new DAttributeString("TipoRelacion", true, 2, 2);   // c_TipoRelacion catalog codes of 2 fixed digits
        
        mvAttributes.add(moAttTipoRelacion);
        
        maEltCfdiRelacionados = new ArrayList<>();
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public DAttributeString getAttTipoRelacion() { return moAttTipoRelacion; }
    
    public ArrayList<cfd.ver33.DElementCfdiRelacionado> getEltCfdiRelacionados() { return maEltCfdiRelacionados; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        if (maEltCfdiRelacionados.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver33.DElementCfdiRelacionado().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            if (!aux.isEmpty()) {
                xml += " " + aux;
            }
        }

        xml += ">";
        
        for (DElement element : maEltCfdiRelacionados) {
            String aux = element.getElementForXml();
            if (!aux.isEmpty()) {
                xml += "\n" + aux;
            }
        }

        xml += "\n</" + msName + ">";

        return xml;
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes

        for (DElement element : maEltCfdiRelacionados) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
