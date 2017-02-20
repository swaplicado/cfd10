/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementRegimenFiscal extends cfd.DElement {

    protected cfd.DAttributeString moAttRegimen;

    public DElementRegimenFiscal() {
        super("cfdi:RegimenFiscal");

        moAttRegimen = new DAttributeString("Regimen", true);

        mvAttributes.add(moAttRegimen);
    }

    public cfd.DAttributeString getAttRegimen() { return moAttRegimen; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += "/>";

        return string;
    }
}
