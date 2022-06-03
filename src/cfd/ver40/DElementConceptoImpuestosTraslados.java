package cfd.ver40;

import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoImpuestosTraslados extends cfd.DElement implements cfd.DElementWithChildren {

    private final ArrayList<cfd.ver40.DElementConceptoImpuestoTraslado> maEltConceptoImpuestoTrasladados;

    public DElementConceptoImpuestosTraslados() {
        super("cfdi:Traslados");

        maEltConceptoImpuestoTrasladados = new ArrayList<>();
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public ArrayList<cfd.ver40.DElementConceptoImpuestoTraslado> getEltImpuestoTrasladados() { return maEltConceptoImpuestoTrasladados; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltConceptoImpuestoTrasladados.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver33.DElementConceptoImpuestoTraslado().getName()) + "'.");
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName + ">";

        for (DElement element : maEltConceptoImpuestoTrasladados) {
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

        for (DElement element : maEltConceptoImpuestoTrasladados) {
            string += element.getElementForOriginalString();
        }

        return string;
    }

    @Override
    public boolean hasChildren() {
        return !maEltConceptoImpuestoTrasladados.isEmpty();
    }
}
