package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.ArrayList;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestos extends cfd.DElement {

    private final cfd.DAttributeTypeImporte moAttTotalImpuestosRetenidos;
    private final cfd.DAttributeTypeImporte moAttTotalImpuestosTrasladados;

    private cfd.ver33.DElementImpuestosRetenciones moEltOpcImpuestosRetenidos;
    private cfd.ver33.DElementImpuestosTraslados moEltOpcImpuestosTraslados;
    
    private final cfd.ver33.DElementComprobante moEltParentComprobante;

    public DElementImpuestos(cfd.ver33.DElementComprobante parentComprobante) {
        super("cfdi:Impuestos");

        moAttTotalImpuestosRetenidos = new DAttributeTypeImporte("TotalImpuestosRetenidos", false);
        moAttTotalImpuestosTrasladados = new DAttributeTypeImporte("TotalImpuestosTrasladados", false);

        mvAttributes.add(moAttTotalImpuestosRetenidos);
        mvAttributes.add(moAttTotalImpuestosTrasladados);

        moEltOpcImpuestosRetenidos = null;
        moEltOpcImpuestosTraslados = null;
        
        moEltParentComprobante = parentComprobante;
    }

    /*
     * Private methods
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();
        
        if (moEltOpcImpuestosRetenidos != null) {
            elements.add(moEltOpcImpuestosRetenidos );
        }
        
        if (moEltOpcImpuestosTraslados != null) {
            elements.add(moEltOpcImpuestosTraslados);
        }
        
        return elements;
    }

    /*
     * Public methods
     */

    public void setEltOpcImpuestosRetenidos(cfd.ver33.DElementImpuestosRetenciones o) { moEltOpcImpuestosRetenidos = o; moAttTotalImpuestosRetenidos.setElementWithChildrenToCheck(moEltOpcImpuestosRetenidos); }
    public void setEltOpcImpuestosTrasladados(cfd.ver33.DElementImpuestosTraslados o) { moEltOpcImpuestosTraslados = o; moAttTotalImpuestosTrasladados.setElementWithChildrenToCheck(moEltOpcImpuestosTraslados); }

    public cfd.DAttributeTypeImporte getAttTotalImpuestosRetenidos() { return moAttTotalImpuestosRetenidos; }
    public cfd.DAttributeTypeImporte getAttTotalImpuestosTraslados() { return moAttTotalImpuestosTrasladados; }

    public cfd.ver33.DElementImpuestosRetenciones getEltOpcImpuestosRetenidos() { return moEltOpcImpuestosRetenidos; }
    public cfd.ver33.DElementImpuestosTraslados getEltOpcImpuestosTraslados() { return moEltOpcImpuestosTraslados; }

    public cfd.ver33.DElementComprobante getEltParentComprobante() { return moEltParentComprobante; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        // validate attributes 'TotalImpuestosRetenidos':
        
        double imptosRetenidos = 0;
        
        for (DElementConcepto concepto : moEltParentComprobante.getEltConceptos().getEltConceptos()) {
            if (concepto.getEltOpcConceptoImpuestos() != null) {
                if (concepto.getEltOpcConceptoImpuestos().getEltOpcImpuestosRetenciones() != null) {
                    for (DElementConceptoImpuestoRetencion impuestoRetencion : concepto.getEltOpcConceptoImpuestos().getEltOpcImpuestosRetenciones().getEltImpuestoRetenciones()) {
                        imptosRetenidos += impuestoRetencion.getAttImporte().getDouble();
                    }
                }
            }
        }
        
        if (SLibUtils.round(imptosRetenidos, moAttTotalImpuestosRetenidos.getDecimals()) != SLibUtils.round(moAttTotalImpuestosRetenidos.getDouble(), moAttTotalImpuestosRetenidos.getDecimals())) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttTotalImpuestosRetenidos.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (moEltOpcImpuestosRetenidos != null) {
            imptosRetenidos = 0;
            
            for (DElementImpuestoRetencion impuestoRetencion : moEltOpcImpuestosRetenidos.getEltImpuestoRetenciones()) {
                imptosRetenidos += impuestoRetencion.getAttImporte().getDouble();
            }
            
            if (SLibUtils.round(imptosRetenidos, moAttTotalImpuestosRetenidos.getDecimals()) != SLibUtils.round(moAttTotalImpuestosRetenidos.getDouble(), moAttTotalImpuestosRetenidos.getDecimals())) {
                throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttTotalImpuestosRetenidos.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
            }
        }
        
        // validate attributes 'TotalImpuestosTrasladados':
        
        double imptosTrasladados = 0;
        
        for (DElementConcepto concepto : moEltParentComprobante.getEltConceptos().getEltConceptos()) {
            if (concepto.getEltOpcConceptoImpuestos() != null) {
                if (concepto.getEltOpcConceptoImpuestos().getEltOpcImpuestosTrasladados() != null) {
                    for (DElementConceptoImpuestoTraslado impuestoTraslado : concepto.getEltOpcConceptoImpuestos().getEltOpcImpuestosTrasladados().getEltImpuestoTrasladados()) {
                        imptosTrasladados += impuestoTraslado.getAttImporte().getDouble();
                    }
                }
            }
        }
        
        if (SLibUtils.round(imptosTrasladados, moAttTotalImpuestosTrasladados.getDecimals()) != SLibUtils.round(moAttTotalImpuestosTrasladados.getDouble(), moAttTotalImpuestosTrasladados.getDecimals())) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttTotalImpuestosTrasladados.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (moEltOpcImpuestosTraslados != null) {
            imptosTrasladados = 0;
            
            for (DElementImpuestoTraslado impuestoTraslado : moEltOpcImpuestosTraslados.getEltImpuestoTrasladados()) {
                imptosTrasladados += impuestoTraslado.getAttImporte().getDouble();
            }
            
            if (SLibUtils.round(imptosTrasladados, moAttTotalImpuestosTrasladados.getDecimals()) != SLibUtils.round(moAttTotalImpuestosTrasladados.getDouble(), moAttTotalImpuestosTrasladados.getDecimals())) {
                throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttTotalImpuestosTrasladados.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
            }
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
        validateElement();
        
        String string = "";

        if (moEltOpcImpuestosRetenidos != null) {
            string += moEltOpcImpuestosRetenidos.getElementForOriginalString();
            string += moAttTotalImpuestosRetenidos.getAttributeForOriginalString();
        }

        if (moEltOpcImpuestosTraslados != null) {
            string += moEltOpcImpuestosTraslados.getElementForOriginalString();
            string += moAttTotalImpuestosTrasladados.getAttributeForOriginalString();
        }

        return string;
    }
}