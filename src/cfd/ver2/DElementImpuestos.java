/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestos extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalImpuestosRetenidos;
    protected cfd.DAttributeTypeImporte moAttTotalImpuestosTrasladados;

    protected cfd.ver2.DElementImpuestosRetenidos moEltOpcImpuestosRetenidos;
    protected cfd.ver2.DElementImpuestosTrasladados moEltOpcImpuestosTrasladados;

    public DElementImpuestos() {
        super("Impuestos");

        moAttTotalImpuestosRetenidos = new DAttributeTypeImporte("totalImpuestosRetenidos", false);
        moAttTotalImpuestosTrasladados = new DAttributeTypeImporte("totalImpuestosTrasladados", false);

        mvAttributes.add(moAttTotalImpuestosRetenidos);
        mvAttributes.add(moAttTotalImpuestosTrasladados);

        moEltOpcImpuestosRetenidos = null;
        moEltOpcImpuestosTrasladados = null;
    }

    public void setEltOpcImpuestosRetenidos(cfd.ver2.DElementImpuestosRetenidos o) { moEltOpcImpuestosRetenidos = o; }
    public void setEltOpcImpuestosTrasladados(cfd.ver2.DElementImpuestosTrasladados o) { moEltOpcImpuestosTrasladados = o; }

    public cfd.DAttributeTypeImporte getAttTotalImpuestosRetenidos() { return moAttTotalImpuestosRetenidos; }
    public cfd.DAttributeTypeImporte getAttTotalImpuestosTrasladados() { return moAttTotalImpuestosTrasladados; }

    public cfd.ver2.DElementImpuestosRetenidos getEltOpcImpuestosRetenidos() { return moEltOpcImpuestosRetenidos; }
    public cfd.ver2.DElementImpuestosTrasladados getEltOpcImpuestosTrasladados() { return moEltOpcImpuestosTrasladados; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        moAttTotalImpuestosRetenidos.setElementWithChildrenToCheck(moEltOpcImpuestosRetenidos);
        moAttTotalImpuestosTrasladados.setElementWithChildrenToCheck(moEltOpcImpuestosTrasladados);

        string = "<" + msName;

        //System.out.println(getClass().getName() + ".getElementForXml() Printing attributes...\n");

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;

            //System.out.println("Printing: " + attribute.getName() + "; [XML=" + xml + "]");
        }

        //System.out.println(getClass().getName() + ".getElementForXml() Printing attributes finished!!!\n");

        string += ">";

        if (moEltOpcImpuestosRetenidos != null) {
            xml = moEltOpcImpuestosRetenidos.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        if (moEltOpcImpuestosTrasladados != null) {
            xml = moEltOpcImpuestosTrasladados.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";

        moAttTotalImpuestosRetenidos.setElementWithChildrenToCheck(moEltOpcImpuestosRetenidos);
        moAttTotalImpuestosTrasladados.setElementWithChildrenToCheck(moEltOpcImpuestosTrasladados);

        if (moEltOpcImpuestosRetenidos != null) {
            string += moEltOpcImpuestosRetenidos.getElementForOriginalString();
            string += moAttTotalImpuestosRetenidos.getAttributeForOriginalString();
        }

        if (moEltOpcImpuestosTrasladados != null) {
            string += moEltOpcImpuestosTrasladados.getElementForOriginalString();
            string += moAttTotalImpuestosTrasladados.getAttributeForOriginalString();
        }

        return string;
    }
}
