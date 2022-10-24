/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeTypeImporte;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementTotales extends cfd.DElement {

    private final DAttributeTypeImporte moAttTotalRetencionesIVA;
    private final DAttributeTypeImporte moAttTotalRetencionesISR;
    private final DAttributeTypeImporte moAttTotalRetencionesIEPS;
    private final DAttributeTypeImporte moAttTotalTrasladosBaseIVA16;
    private final DAttributeTypeImporte moAttTotalTrasladosImpuestoIVA16;
    private final DAttributeTypeImporte moAttTotalTrasladosBaseIVA8;
    private final DAttributeTypeImporte moAttTotalTrasladosImpuestoIVA8;
    private final DAttributeTypeImporte moAttTotalTrasladosBaseIVA0;
    private final DAttributeTypeImporte moAttTotalTrasladosImpuestoIVA0;
    private final DAttributeTypeImporte moAttTotalTrasladosBaseIVAExento;
    private final DAttributeTypeImporte moAttMontoTotalPagos;
    
    public DElementTotales() {
        super("pago20:Totales");
        
        moAttTotalRetencionesIVA = new DAttributeTypeImporte("TotalRetencionesIVA", false);
        moAttTotalRetencionesISR = new DAttributeTypeImporte("TotalRetencionesISR", false);
        moAttTotalRetencionesIEPS = new DAttributeTypeImporte("TotalRetencionesIEPS", false);
        moAttTotalTrasladosBaseIVA16 = new DAttributeTypeImporte("TotalTrasladosBaseIVA16", false);
        moAttTotalTrasladosImpuestoIVA16 = new DAttributeTypeImporte("TotalTrasladosImpuestoIVA16", false);
        moAttTotalTrasladosBaseIVA8 = new DAttributeTypeImporte("TotalTrasladosBaseIVA8", false);
        moAttTotalTrasladosImpuestoIVA8 = new DAttributeTypeImporte("TotalTrasladosImpuestoIVA8", false);
        moAttTotalTrasladosBaseIVA0 = new DAttributeTypeImporte("TotalTrasladosBaseIVA0", false);
        moAttTotalTrasladosImpuestoIVA0 = new DAttributeTypeImporte("TotalTrasladosImpuestoIVA0", false);
        moAttTotalTrasladosBaseIVAExento = new DAttributeTypeImporte("TotalTrasladosBaseIVAExento", false);
        moAttMontoTotalPagos = new DAttributeTypeImporte("MontoTotalPagos", true);
        
        mvAttributes.add(moAttTotalRetencionesIVA);
        mvAttributes.add(moAttTotalRetencionesISR);
        mvAttributes.add(moAttTotalRetencionesIEPS);
        mvAttributes.add(moAttTotalTrasladosBaseIVA16);
        mvAttributes.add(moAttTotalTrasladosImpuestoIVA16);
        mvAttributes.add(moAttTotalTrasladosBaseIVA8);
        mvAttributes.add(moAttTotalTrasladosImpuestoIVA8);
        mvAttributes.add(moAttTotalTrasladosBaseIVA0);
        mvAttributes.add(moAttTotalTrasladosImpuestoIVA0);
        mvAttributes.add(moAttTotalTrasladosBaseIVAExento);
        mvAttributes.add(moAttMontoTotalPagos);
    }
    
    public DAttributeTypeImporte getAttTotalRetencionesIVA() { return moAttTotalRetencionesIVA; }
    public DAttributeTypeImporte getAttTotalRetencionesISR() { return moAttTotalRetencionesISR; }
    public DAttributeTypeImporte getAttTotalRetencionesIEPS() { return moAttTotalRetencionesIEPS; }
    public DAttributeTypeImporte getAttTotalTrasladosBaseIVA16() { return moAttTotalTrasladosBaseIVA16; }
    public DAttributeTypeImporte getAttTotalTrasladosImpuestoIVA16() { return moAttTotalTrasladosImpuestoIVA16; }
    public DAttributeTypeImporte getAttTotalTrasladosBaseIVA8() { return moAttTotalTrasladosBaseIVA8; }
    public DAttributeTypeImporte getAttTotalTrasladosImpuestoIVA8() { return moAttTotalTrasladosImpuestoIVA8; }
    public DAttributeTypeImporte getAttTotalTrasladosBaseIVA0() { return moAttTotalTrasladosBaseIVA0; }
    public DAttributeTypeImporte getAttTotalTrasladosImpuestoIVA0() { return moAttTotalTrasladosImpuestoIVA0; }
    public DAttributeTypeImporte getAttTotalTrasladosBaseIVAExento() { return moAttTotalTrasladosBaseIVAExento; }
    public DAttributeTypeImporte getAttMontoTotalPagos() { return moAttMontoTotalPagos; }
    
}
