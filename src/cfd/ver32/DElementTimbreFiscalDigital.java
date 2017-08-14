/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver32;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTimbreFiscalDigital extends cfd.DElement {
    
    public static final String VER = "1.0";

    protected cfd.DAttributeString moAttVersion;
    protected cfd.DAttributeString moAttUuid;
    protected cfd.DAttributeString moAttFechaTimbrado;
    protected cfd.DAttributeString moAttSelloCFD;
    protected cfd.DAttributeString moAttNoCertificadoSAT;
    protected cfd.DAttributeString moAttSelloSAT;

    public DElementTimbreFiscalDigital() {
        super("tfd:TimbreFiscalDigital");

        moAttVersion = new DAttributeString("version", true);
        moAttVersion.setString(VER);
        moAttUuid = new DAttributeString("UUID", true);
        moAttFechaTimbrado = new DAttributeString("FechaTimbrado", true);
        moAttSelloCFD = new DAttributeString("selloCFD", true);
        moAttNoCertificadoSAT = new DAttributeString("noCertificadoSAT", true);
        moAttSelloSAT = new DAttributeString("selloSAT", true);


        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttUuid);
        mvAttributes.add(moAttFechaTimbrado);
        mvAttributes.add(moAttSelloCFD);
        mvAttributes.add(moAttNoCertificadoSAT);
        mvAttributes.add(moAttSelloSAT);
    }

    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttUuid() { return moAttUuid; }
    public cfd.DAttributeString getAttFechaTimbrado() { return moAttFechaTimbrado; }
    public cfd.DAttributeString getAttSelloCfd() { return moAttSelloCFD; }
    public cfd.DAttributeString getAttNoCertificadoSAT() { return moAttNoCertificadoSAT; }
    public cfd.DAttributeString getAttSelloSAT() { return moAttSelloSAT; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName + " " +
                "xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/TimbreFiscalDigital/TimbreFiscalDigital.xsd\" " +
                "xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" ";

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += "/>";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
