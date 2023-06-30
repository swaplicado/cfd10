package cfd.ver40;

import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosTraslados extends cfd.DElement implements DElementWithChildren {

    private final ArrayList<cfd.ver40.DElementImpuestoTraslado> maEltImpuestoTrasladados;

    public DElementImpuestosTraslados() {
        super("cfdi:Traslados");

        maEltImpuestoTrasladados = new ArrayList<>();
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public ArrayList<cfd.ver40.DElementImpuestoTraslado> getEltImpuestoTrasladados() { return maEltImpuestoTrasladados; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltImpuestoTrasladados.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver40.DElementImpuestoTraslado().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName + ">";

        for (DElement element : maEltImpuestoTrasladados) {
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

        for (DElement element : maEltImpuestoTrasladados) {
            string += element.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return maEltImpuestoTrasladados.size() > 0;
    }
}
