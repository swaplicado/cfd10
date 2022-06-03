/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementTrasladoDR extends cfd.DElement {

    private final DAttributeTypeImporte moAttBaseDR;
    private final DAttributeString moAttImpuestoDR;
    private final DAttributeString moAttTipoFactorDR;
    private final DAttributeTypeImporte moAttTasaOCuotaDR;
    private final DAttributeTypeImporte moAttImporteDR;
    
    public DElementTrasladoDR() {
        super("pagos20:TrasladoDR");
        
        moAttBaseDR = new DAttributeTypeImporte("BaseDR", true);
        moAttImpuestoDR = new DAttributeString("ImpuestoDR", true, 3, 3);
        moAttTipoFactorDR = new DAttributeString("TipoFactorDR", true);
        moAttTasaOCuotaDR = new DAttributeTypeImporte("TasaOCuotaDR", false);
        moAttImporteDR = new DAttributeTypeImporte("ImporteDR", true);
        
        mvAttributes.add(moAttBaseDR);
        mvAttributes.add(moAttImpuestoDR);
        mvAttributes.add(moAttTipoFactorDR);
        mvAttributes.add(moAttTasaOCuotaDR);
        mvAttributes.add(moAttImporteDR);
    }
    
    public DAttributeTypeImporte getAttBaseDR() { return moAttBaseDR; }
    public DAttributeString getAttImpuestoDR() { return moAttImpuestoDR; }
    public DAttributeString getAttTipoFactorDR() { return moAttTipoFactorDR; }
    public DAttributeTypeImporte getAttTasaOCuotaDR() { return moAttTasaOCuotaDR; }
    public DAttributeTypeImporte getAttImporteDR() { return moAttImporteDR; }
    
}
