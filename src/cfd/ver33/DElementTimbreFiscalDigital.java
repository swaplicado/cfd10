/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTimbreFiscalDigital extends cfd.DElement {
    
    public static final String VER = "1.1";

    protected DAttributeString moAttVersion;
    protected DAttributeString moAttUuid;
    protected DAttributeString moAttFechaTimbrado;
    protected DAttributeString moAttRfcProvCertif;
    protected DAttributeString moAttLeyenda;
    protected DAttributeString moAttSelloCFD;
    protected DAttributeString moAttNoCertificadoSAT;
    protected DAttributeString moAttSelloSAT;

    public DElementTimbreFiscalDigital() {
        super("tfd:TimbreFiscalDigital");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString(VER);
        moAttUuid = new DAttributeString("UUID", true);
        moAttFechaTimbrado = new DAttributeString("FechaTimbrado", true);
        moAttRfcProvCertif = new DAttributeString("RfcProvCertif", true);
        moAttLeyenda = new DAttributeString("Leyenda", false);
        moAttSelloCFD = new DAttributeString("SelloCFD", true);
        moAttNoCertificadoSAT = new DAttributeString("NoCertificadoSAT", true);
        moAttSelloSAT = new DAttributeString("SelloSAT", true);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttUuid);
        mvAttributes.add(moAttFechaTimbrado);
        mvAttributes.add(moAttRfcProvCertif);
        mvAttributes.add(moAttLeyenda);
        mvAttributes.add(moAttSelloCFD);
        mvAttributes.add(moAttNoCertificadoSAT);
        mvAttributes.add(moAttSelloSAT);
    }

    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttUUID() { return moAttUuid; }
    public cfd.DAttributeString getAttFechaTimbrado() { return moAttFechaTimbrado; }
    public cfd.DAttributeString getAttRfcProvCertif() { return moAttRfcProvCertif; }
    public cfd.DAttributeString getAttLeyenda() { return moAttLeyenda; }
    public cfd.DAttributeString getAttSelloCFD() { return moAttSelloCFD; }
    public cfd.DAttributeString getAttNoCertificadoSAT() { return moAttNoCertificadoSAT; }
    public cfd.DAttributeString getAttSelloSAT() { return moAttSelloSAT; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName + " "
                + "xmlns:tfd=\"http://www.sat.gob.mx/TimbreFiscalDigital\" xsi:schemaLocation=\"http://www.sat.gob.mx/TimbreFiscalDigital http://www.sat.gob.mx/sitio_internet/cfd/TimbreFiscalDigital/TimbreFiscalDigitalv11.xsd\" ";

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
