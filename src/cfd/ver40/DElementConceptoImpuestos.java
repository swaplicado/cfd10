package cfd.ver40;

import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoImpuestos extends cfd.DElement {
    
    private cfd.ver40.DElementConceptoImpuestosTraslados moEltOpcConceptoImpuestosTraslados;
    private cfd.ver40.DElementConceptoImpuestosRetenciones moEltOpcConceptoImpuestosRetenciones;

    public DElementConceptoImpuestos() {
        super("cfdi:Impuestos");

        moEltOpcConceptoImpuestosTraslados = null;
        moEltOpcConceptoImpuestosRetenciones = null;
    }

    /*
     * Private methods
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();
        
        if (moEltOpcConceptoImpuestosTraslados != null) {
            elements.add(moEltOpcConceptoImpuestosTraslados);
        }
        
        if (moEltOpcConceptoImpuestosRetenciones != null) {
            elements.add(moEltOpcConceptoImpuestosRetenciones);
        }
        
        return elements;
    }
    
    /*
     * Public methods
     */

    public void setEltOpcImpuestosTrasladados(cfd.ver40.DElementConceptoImpuestosTraslados o) { moEltOpcConceptoImpuestosTraslados = o; }
    public void setEltOpcImpuestosRetenciones(cfd.ver40.DElementConceptoImpuestosRetenciones o) { moEltOpcConceptoImpuestosRetenciones = o; }

    public cfd.ver40.DElementConceptoImpuestosTraslados getEltOpcImpuestosTrasladados() { return moEltOpcConceptoImpuestosTraslados; }
    public cfd.ver40.DElementConceptoImpuestosRetenciones getEltOpcImpuestosRetenciones() { return moEltOpcConceptoImpuestosRetenciones; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (moEltOpcConceptoImpuestosTraslados == null && moEltOpcConceptoImpuestosRetenciones == null) {
            throw new IllegalStateException(DElement.ERR_MSG_NODES + "'" + (new cfd.ver40.DElementConceptoImpuestosTraslados().getName()) + "', '" + (new cfd.ver40.DElementConceptoImpuestosRetenciones().getName()) + "'" + DElement.ERR_MSG_NODES_NO_EXIST);
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName + ">";

        for (DElement element : createElementsArray()) {
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
        
        for (DElement element : createElementsArray()) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
