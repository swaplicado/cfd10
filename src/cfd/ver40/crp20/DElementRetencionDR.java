/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.ver40.DCfdi40Catalogs;
import sa.lib.SLibUtils;

/**
 *
 * @author Isabel Danae García Servín, Sergio Abraham Flores Gutiérrez
 */
public class DElementRetencionDR extends cfd.DElement {

    private final DAttributeTypeImporte moAttBaseDR;
    private final DAttributeString moAttImpuestoDR;
    private final DAttributeString moAttTipoFactorDR;
    private final DAttributeTypeImporte moAttTasaOCuotaDR;
    private final DAttributeTypeImporte moAttImporteDR;
    
    public DElementRetencionDR() {
        super("pago20:RetencionDR");
        
        moAttBaseDR = new DAttributeTypeImporte("BaseDR", true);
        moAttImpuestoDR = new DAttributeString("ImpuestoDR", true, 3, 3);
        moAttTipoFactorDR = new DAttributeString("TipoFactorDR", true);
        moAttTasaOCuotaDR = new DAttributeTypeImporte("TasaOCuotaDR", true);
        moAttTasaOCuotaDR.setDecimals(6);
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
    
    public void clearBaseDR() {
        moAttBaseDR.setDouble(0);
    }
    
    public void addBaseDR(final double baseDR) {
        moAttBaseDR.setDouble(SLibUtils.roundAmount(moAttBaseDR.getDouble() + baseDR));
    }
    
    public void computeImporteDR() {
        if (moAttTipoFactorDR.getString().equals(DCfdi40Catalogs.FAC_TP_TASA)) {
            moAttImporteDR.setDouble(SLibUtils.roundAmount(moAttBaseDR.getDouble() * moAttTasaOCuotaDR.getDouble()));
        }
    }
}
