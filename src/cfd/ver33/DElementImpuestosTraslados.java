package cfd.ver33;

import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosTraslados extends cfd.DElement implements DElementWithChildren {

    private final ArrayList<cfd.ver33.DElementImpuestoTraslado> maEltImpuestoTrasladados;

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

    public ArrayList<cfd.ver33.DElementImpuestoTraslado> getEltImpuestoTrasladados() { return maEltImpuestoTrasladados; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        if (maEltImpuestoTrasladados.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver33.DElementImpuestoTraslado().getName()) + "'.");
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
        validateElement();
        
        String string = "";

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
