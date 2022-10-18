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
public class DElementTrasladoP extends cfd.DElement {
    
    private final DAttributeTypeImporte moAttBaseP;
    private final DAttributeString moAttImpuestoP;
    private final DAttributeString moAttTipoFactorP;
    private final DAttributeTypeImporte moAttTasaOCuotaP;
    private final DAttributeTypeImporte moAttImporteP;

    public DElementTrasladoP() {
        super("pago20:TrasladoP");
        
        moAttBaseP = new DAttributeTypeImporte("BaseP", true);
        moAttImpuestoP = new DAttributeString("ImpuestoP", true, 3, 3);
        moAttTipoFactorP = new DAttributeString("TipoFactorP", true);
        moAttTasaOCuotaP = new DAttributeTypeImporte("TasaOCuotaP", false);
        moAttTasaOCuotaP.setDecimals(6);
        moAttTasaOCuotaP.setCanBeZero(true);
        moAttImporteP = new DAttributeTypeImporte("ImporteP", false);
        moAttImporteP.setCanBeZero(true);
        
        mvAttributes.add(moAttBaseP);
        mvAttributes.add(moAttImpuestoP);
        mvAttributes.add(moAttTipoFactorP);
        mvAttributes.add(moAttTasaOCuotaP);
        mvAttributes.add(moAttImporteP);
    }
    
    public DAttributeTypeImporte getAttBaseP() { return moAttBaseP; }
    public DAttributeString getAttImpuestoP() { return moAttImpuestoP; }
    public DAttributeString getAttTipoFactorP() { return moAttTipoFactorP; }
    public DAttributeTypeImporte getAttTasaOCuotaP() { return moAttTasaOCuotaP; }
    public DAttributeTypeImporte getAttImporteP() { return moAttImporteP; }
}