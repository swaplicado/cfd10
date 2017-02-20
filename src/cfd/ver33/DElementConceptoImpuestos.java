package cfd.ver33;

/**
 *
 * @author Juan Barajas
 */
public class DElementConceptoImpuestos extends cfd.DElement {
    
    protected cfd.ver33.DElementConceptoImpuestosTraslados moEltOpcConceptoImpuestosTraslados;
    protected cfd.ver33.DElementConceptoImpuestosRetenidos moEltOpcConceptoImpuestosRetenidos;

    public DElementConceptoImpuestos() {
        super("cfdi:Impuestos");

        moEltOpcConceptoImpuestosTraslados = null;
        moEltOpcConceptoImpuestosRetenidos = null;
    }

    public void setEltOpcImpuestosTrasladados(cfd.ver33.DElementConceptoImpuestosTraslados o) { moEltOpcConceptoImpuestosTraslados = o; }
    public void setEltOpcImpuestosRetenidos(cfd.ver33.DElementConceptoImpuestosRetenidos o) { moEltOpcConceptoImpuestosRetenidos = o; }

    public cfd.ver33.DElementConceptoImpuestosTraslados getEltOpcImpuestosTrasladados() { return moEltOpcConceptoImpuestosTraslados; }
    public cfd.ver33.DElementConceptoImpuestosRetenidos getEltOpcImpuestosRetenidos() { return moEltOpcConceptoImpuestosRetenidos; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";
        string = "<" + msName + ">";

        if (moEltOpcConceptoImpuestosTraslados != null) {
            xml = moEltOpcConceptoImpuestosTraslados.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcConceptoImpuestosRetenidos != null) {
            xml = moEltOpcConceptoImpuestosRetenidos.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        if (moEltOpcConceptoImpuestosTraslados != null) {
            string += moEltOpcConceptoImpuestosTraslados.getElementForOriginalString();
        }

        if (moEltOpcConceptoImpuestosRetenidos != null) {
            string += moEltOpcConceptoImpuestosRetenidos.getElementForOriginalString();
        }

        return string;
    }
}
