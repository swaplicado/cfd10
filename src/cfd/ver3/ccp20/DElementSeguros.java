/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementSeguros extends cfd.DElement {
    
    private final DAttributeString moAttAseguraRespCivil;
    private final DAttributeString moAttPolizaRespCivil;
    private final DAttributeString moAttAseguraMedAmbiente;
    private final DAttributeString moAttPolizaMedAmbiente;
    private final DAttributeString moAttAseguraCarga;
    private final DAttributeString moAttPolizaCarga;
    private final DAttributeString moAttPrimaSeguro;

    public DElementSeguros() {
        super("cartaporte20:Seguros");
        
        moAttAseguraRespCivil = new DAttributeString("AseguraRespCivil", true, 3, 50);
        moAttPolizaRespCivil = new DAttributeString("PolizaRespCivil", true, 3, 30);
        moAttAseguraMedAmbiente = new DAttributeString("AseguraMedAmbiente", false, 3, 50);
        moAttPolizaMedAmbiente = new DAttributeString("PolizaMedAmbiente", false, 3, 30);
        moAttAseguraCarga = new DAttributeString("AseguraCarga", false, 3, 50);
        moAttPolizaCarga = new DAttributeString("PolizaCarga", false, 3, 30);
        moAttPrimaSeguro = new DAttributeString("PrimaSeguro", false);
        
        mvAttributes.add(moAttAseguraRespCivil);
        mvAttributes.add(moAttPolizaRespCivil);
        mvAttributes.add(moAttAseguraMedAmbiente);
        mvAttributes.add(moAttPolizaMedAmbiente);
        mvAttributes.add(moAttAseguraCarga);
        mvAttributes.add(moAttPolizaCarga);
        mvAttributes.add(moAttPrimaSeguro);
    }
    
    
    public DAttributeString getAttAseguraRespCivil() { return moAttAseguraRespCivil; }
    public DAttributeString getAttPolizaRespCivil() { return moAttPolizaRespCivil; }
    public DAttributeString getAttAseguraMedAmbiente() { return moAttAseguraMedAmbiente; }
    public DAttributeString getAttPolizaMedAmbiente() { return moAttPolizaMedAmbiente; }
    public DAttributeString getAttAseguraCarga() { return moAttAseguraCarga; }
    public DAttributeString getAttPolizaCarga() { return moAttPolizaCarga; }
    public DAttributeString getAttPrimaSeguro() { return moAttPrimaSeguro; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";
        
        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        return string;
    }
}
