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
    protected DAttributeString moAttSelloCFD;
    protected DAttributeString moAttNoCertificadoSAT;
    protected DAttributeString moAttSelloSAT;
    protected DAttributeString moAttRfcProvCertif;

    public DElementTimbreFiscalDigital() {
        super("tfd:TimbreFiscalDigital");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString(VER);
        moAttUuid = new DAttributeString("UUID", true);
        moAttFechaTimbrado = new DAttributeString("FechaTimbrado", true);
        moAttSelloCFD = new DAttributeString("SelloCFD", true);
        moAttNoCertificadoSAT = new DAttributeString("NoCertificadoSAT", true);
        moAttSelloSAT = new DAttributeString("SelloSAT", true);
        moAttRfcProvCertif = new DAttributeString("RfcProvCertif", true);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttUuid);
        mvAttributes.add(moAttFechaTimbrado);
        mvAttributes.add(moAttSelloCFD);
        mvAttributes.add(moAttNoCertificadoSAT);
        mvAttributes.add(moAttSelloSAT);
        mvAttributes.add(moAttRfcProvCertif);
    }

    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttUuid() { return moAttUuid; }
    public cfd.DAttributeString getAttFechaTimbrado() { return moAttFechaTimbrado; }
    public cfd.DAttributeString getAttSelloCfd() { return moAttSelloCFD; }
    public cfd.DAttributeString getAttNoCertificadoSAT() { return moAttNoCertificadoSAT; }
    public cfd.DAttributeString getAttSelloSAT() { return moAttSelloSAT; }
    public cfd.DAttributeString getAttRfcProvCertif() { return moAttRfcProvCertif; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName + " ";

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
