/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestos extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalImpuestosRetenidos;
    protected cfd.DAttributeTypeImporte moAttTotalImpuestosTrasladados;

    protected cfd.ver3.DElementImpuestosRetenidos moEltOpcImpuestosRetenidos;
    protected cfd.ver3.DElementImpuestosTrasladados moEltOpcImpuestosTrasladados;

    public DElementImpuestos() {
        super("cfdi:Impuestos");

        moAttTotalImpuestosRetenidos = new DAttributeTypeImporte("totalImpuestosRetenidos", false);
        moAttTotalImpuestosTrasladados = new DAttributeTypeImporte("totalImpuestosTrasladados", false);

        mvAttributes.add(moAttTotalImpuestosRetenidos);
        mvAttributes.add(moAttTotalImpuestosTrasladados);

        moEltOpcImpuestosRetenidos = null;
        moEltOpcImpuestosTrasladados = null;
    }

    public void setEltOpcImpuestosRetenidos(cfd.ver3.DElementImpuestosRetenidos o) { moEltOpcImpuestosRetenidos = o; }
    public void setEltOpcImpuestosTrasladados(cfd.ver3.DElementImpuestosTrasladados o) { moEltOpcImpuestosTrasladados = o; }

    public cfd.DAttributeTypeImporte getAttTotalImpuestosRetenidos() { return moAttTotalImpuestosRetenidos; }
    public cfd.DAttributeTypeImporte getAttTotalImpuestosTrasladados() { return moAttTotalImpuestosTrasladados; }

    public cfd.ver3.DElementImpuestosRetenidos getEltOpcImpuestosRetenidos() { return moEltOpcImpuestosRetenidos; }
    public cfd.ver3.DElementImpuestosTrasladados getEltOpcImpuestosTrasladados() { return moEltOpcImpuestosTrasladados; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        moAttTotalImpuestosRetenidos.setElementWithChildrenToCheck(moEltOpcImpuestosRetenidos);
        moAttTotalImpuestosTrasladados.setElementWithChildrenToCheck(moEltOpcImpuestosTrasladados);

        string = "<" + msName;

        //System.out.println(getClass().getName() + ".getElementForXml() Printing attributes...\n");

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;

            //System.out.println("Printing: " + attribute.getName() + "; [XML=" + xml + "]");
        }

        //System.out.println(getClass().getName() + ".getElementForXml() Printing attributes finished!!!\n");

        string += ">";

        if (moEltOpcImpuestosRetenidos != null) {
            xml = moEltOpcImpuestosRetenidos.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcImpuestosTrasladados != null) {
            xml = moEltOpcImpuestosTrasladados.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
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
