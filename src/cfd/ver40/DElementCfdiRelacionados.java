package cfd.ver40;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel Danae García Servín
 */
public class DElementCfdiRelacionados extends cfd.DElement {

    private final DAttributeString moAttTipoRelacion;
    
    private final DAttributeString moAttUuidRelacionado;

    private final ArrayList<cfd.ver40.DElementCfdiRelacionado> maEltCfdiRelacionados;

    public DElementCfdiRelacionados() {
        super("cfdi:CfdiRelacionados");

        moAttTipoRelacion = new DAttributeString("TipoRelacion", true, 2, 2);   // c_TipoRelacion catalog codes of 2 fixed digits
        
        moAttUuidRelacionado = new DAttributeString("UuidRelacionado", false);   
        
        mvAttributes.add(moAttTipoRelacion);
        
        maEltCfdiRelacionados = new ArrayList<>();
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */
    
    public void getAllUuidRelatedString() {
        String msAllUuidRelated = "";
        for (cfd.ver40.DElementCfdiRelacionado relacionado : maEltCfdiRelacionados) {
            msAllUuidRelated += (msAllUuidRelated.isEmpty() ? "" : ", ") + relacionado.getAttUuid().getString().toUpperCase();
        }
        moAttUuidRelacionado.setString(msAllUuidRelated);
    }

    public DAttributeString getAttTipoRelacion() { return moAttTipoRelacion; }
    
    public DAttributeString getAttUuidRelacionado() { return moAttUuidRelacionado; }
    
    public ArrayList<cfd.ver40.DElementCfdiRelacionado> getEltCfdiRelacionados() { return maEltCfdiRelacionados; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltCfdiRelacionados.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver40.DElementCfdiRelacionado().getName()) + "'.");
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
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElement element : maEltCfdiRelacionados) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
