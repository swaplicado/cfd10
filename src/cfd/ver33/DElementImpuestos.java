package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementImpuestos extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalImpuestosRetenidos;
    protected cfd.DAttributeTypeImporte moAttTotalImpuestosTrasladados;

    protected cfd.ver33.DElementImpuestosRetenidos moEltOpcImpuestosRetenidos;
    protected cfd.ver33.DElementImpuestosTraslados moEltOpcImpuestosTraslados;

    public DElementImpuestos() {
        super("cfdi:Impuestos");

        moAttTotalImpuestosRetenidos = new DAttributeTypeImporte("TotalImpuestosRetenidos", false);
        moAttTotalImpuestosTrasladados = new DAttributeTypeImporte("TotalImpuestosTrasladados", false);

        mvAttributes.add(moAttTotalImpuestosRetenidos);
        mvAttributes.add(moAttTotalImpuestosTrasladados);

        moEltOpcImpuestosRetenidos = null;
        moEltOpcImpuestosTraslados = null;
    }

    public void setEltOpcImpuestosRetenidos(cfd.ver33.DElementImpuestosRetenidos o) { moEltOpcImpuestosRetenidos = o; }
    public void setEltOpcImpuestosTrasladados(cfd.ver33.DElementImpuestosTraslados o) { moEltOpcImpuestosTraslados = o; }

    public cfd.DAttributeTypeImporte getAttTotalImpuestosRetenidos() { return moAttTotalImpuestosRetenidos; }
    public cfd.DAttributeTypeImporte getAttTotalImpuestosTraslados() { return moAttTotalImpuestosTrasladados; }

    public cfd.ver33.DElementImpuestosRetenidos getEltOpcImpuestosRetenidos() { return moEltOpcImpuestosRetenidos; }
    public cfd.ver33.DElementImpuestosTraslados getEltOpcImpuestosTraslados() { return moEltOpcImpuestosTraslados; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        moAttTotalImpuestosRetenidos.setElementWithChildrenToCheck(moEltOpcImpuestosRetenidos);
        moAttTotalImpuestosTrasladados.setElementWithChildrenToCheck(moEltOpcImpuestosTraslados);

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        if (moEltOpcImpuestosRetenidos != null) {
            xml = moEltOpcImpuestosRetenidos.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcImpuestosTraslados != null) {
            xml = moEltOpcImpuestosTraslados.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        moAttTotalImpuestosRetenidos.setElementWithChildrenToCheck(moEltOpcImpuestosRetenidos);
        moAttTotalImpuestosTrasladados.setElementWithChildrenToCheck(moEltOpcImpuestosTraslados);

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
