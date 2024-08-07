/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp31;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementSeguros extends cfd.DElement {
    
    private final DAttributeString moAttAseguraRespCivil;
    private final DAttributeString moAttPolizaRespCivil;
    private final DAttributeString moAttAseguraMedAmbiente;
    private final DAttributeString moAttPolizaMedAmbiente;
    private final DAttributeString moAttAseguraCarga;
    private final DAttributeString moAttPolizaCarga;
    private final DAttributeTypeImporte moAttPrimaSeguro;

    public DElementSeguros() {
        super("cartaporte31:Seguros");
        
        moAttAseguraRespCivil = new DAttributeString("AseguraRespCivil", true, 3, 50);
        moAttPolizaRespCivil = new DAttributeString("PolizaRespCivil", true, 3, 30);
        moAttAseguraMedAmbiente = new DAttributeString("AseguraMedAmbiente", false, 3, 50);
        moAttPolizaMedAmbiente = new DAttributeString("PolizaMedAmbiente", false, 3, 30);
        moAttAseguraCarga = new DAttributeString("AseguraCarga", false, 3, 50);
        moAttPolizaCarga = new DAttributeString("PolizaCarga", false, 3, 30);
        moAttPrimaSeguro = new DAttributeTypeImporte("PrimaSeguro", false);
        
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
    public DAttributeTypeImporte getAttPrimaSeguro() { return moAttPrimaSeguro; }
}
