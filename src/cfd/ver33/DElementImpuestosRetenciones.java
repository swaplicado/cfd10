package cfd.ver33;

import cfd.DElement;
import cfd.DElementWithChildren;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosRetenciones extends cfd.DElement implements DElementWithChildren {

    private final ArrayList<cfd.ver33.DElementImpuestoRetencion> maEltImpuestoRetenciones;

    public DElementImpuestosRetenciones() {
        super("cfdi:Retenciones");

        maEltImpuestoRetenciones = new ArrayList<>();
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public ArrayList<cfd.ver33.DElementImpuestoRetencion> getEltImpuestoRetenciones() { return maEltImpuestoRetenciones; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        if (maEltImpuestoRetenciones.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver33.DElementImpuestoRetencion().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName + ">";

        for (DElement element : maEltImpuestoRetenciones) {
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

        for (DElement element : maEltImpuestoRetenciones) {
            string += element.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return !maEltImpuestoRetenciones.isEmpty();
    }
}
