/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40;

import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementConceptoACuentaTerceros extends cfd.DElement {

    public final DAttributeTypeRfc moAttRfcACuentaTerceros;
    public final DAttributeString moAttNombreACuentaTerceros;
    public final DAttributeString moAttRegimenFiscalACuentaTerceros;
    public final DAttributeString moAttDomicilioFiscalACuentaTerceros;
    
    public DElementConceptoACuentaTerceros() {
        super("cfdi:ACuentaTerceros");
        
        moAttRfcACuentaTerceros = new DAttributeTypeRfc("RfcACuentaTerceros", true);
        moAttNombreACuentaTerceros = new DAttributeString("NombreACuentaTerceros", true, 1, 254);
        moAttRegimenFiscalACuentaTerceros = new DAttributeString("RegimenFiscalACuentaTerceros", true, 3, 3);
        moAttDomicilioFiscalACuentaTerceros = new DAttributeString("DomicilioFiscalACuentaTerceros", true, 5, 5);
        
        mvAttributes.add(moAttRfcACuentaTerceros);
        mvAttributes.add(moAttNombreACuentaTerceros);
        mvAttributes.add(moAttRegimenFiscalACuentaTerceros);
        mvAttributes.add(moAttDomicilioFiscalACuentaTerceros);
    }
    
    public DAttributeTypeRfc getAttRfcACuentaTerceros() { return moAttRfcACuentaTerceros; }
    public DAttributeString getAttNombreACuentaTerceros() { return moAttNombreACuentaTerceros; }
    public DAttributeString getAttRegimenFiscalACuentaTerceros() { return moAttRegimenFiscalACuentaTerceros; }
    public DAttributeString getAttDomicilioFiscalACuentaTerceros() { return moAttDomicilioFiscalACuentaTerceros; }
    
}
