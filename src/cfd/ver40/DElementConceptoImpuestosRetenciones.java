package cfd.ver40;

import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoImpuestosRetenciones extends cfd.DElement implements cfd.DElementWithChildren {

    private final ArrayList<cfd.ver40.DElementConceptoImpuestoRetencion> maEltConceptoImpuestoRetenciones;

    public DElementConceptoImpuestosRetenciones() {
        super("cfdi:Retenciones");

        maEltConceptoImpuestoRetenciones = new ArrayList<>();
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public ArrayList<cfd.ver40.DElementConceptoImpuestoRetencion> getEltImpuestoRetenciones() { return maEltConceptoImpuestoRetenciones; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltConceptoImpuestoRetenciones.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver33.DElementConceptoImpuestoRetencion().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName + ">";

        for (DElement element : maEltConceptoImpuestoRetenciones) {
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

        for (DElement element : maEltConceptoImpuestoRetenciones) {
            string += element.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return !maEltConceptoImpuestoRetenciones.isEmpty();
    }
}
