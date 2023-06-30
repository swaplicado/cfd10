/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import sa.lib.SLibUtils;

/**
 *
 * @author Isabel Danae García Servín, Sergio Abraham Flores Gutiérrez
 */
public class DElementRetencionP extends cfd.DElement {

    private final DAttributeString moAttImpuestoP;
    private final DAttributeTypeImporte moAttImporteP;
    
    public DElementRetencionP() {
        super("pago20:RetencionP");
        
        moAttImpuestoP = new DAttributeString("ImpuestoP", true, 3, 3);
        moAttImporteP = new DAttributeTypeImporte("ImporteP", true);
        
        mvAttributes.add(moAttImpuestoP);
        mvAttributes.add(moAttImporteP);
    }
    
    public DAttributeString getAttImpuestoP() { return moAttImpuestoP; }
    public DAttributeTypeImporte getAttImporteP() { return moAttImporteP; }
    
    public void clearImporteP() {
        moAttImporteP.setDouble(0);
    }
    
    public void addImporteP(final double importeP) {
        moAttImporteP.setDouble(SLibUtils.roundAmount(moAttImporteP.getDouble() + importeP));
    }
}
