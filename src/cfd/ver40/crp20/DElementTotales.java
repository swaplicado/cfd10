/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeTypeImporte;
import sa.lib.SLibUtils;

/**
 *
 * @author Isabel Danae García Servín, Sergio Abraham Flores Gutiérrez
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
    
    public void clearTotales() {
        moAttTotalRetencionesIVA.setDouble(0);
        moAttTotalRetencionesISR.setDouble(0);
        moAttTotalRetencionesIEPS.setDouble(0);
        moAttTotalTrasladosBaseIVA16.setDouble(0);
        moAttTotalTrasladosImpuestoIVA16.setDouble(0);
        moAttTotalTrasladosBaseIVA8.setDouble(0);
        moAttTotalTrasladosImpuestoIVA8.setDouble(0);
        moAttTotalTrasladosBaseIVA0.setDouble(0);
        moAttTotalTrasladosImpuestoIVA0.setDouble(0);
        moAttTotalTrasladosBaseIVAExento.setDouble(0);
        moAttMontoTotalPagos.setDouble(0);
    }
    
    public void addAttTotalRetencionesIVA(final double retencion) {
        moAttTotalRetencionesIVA.setDouble(SLibUtils.roundAmount(moAttTotalRetencionesIVA.getDouble() + retencion));
    }
    
    public void addAttTotalRetencionesISR(final double retencion) { 
        moAttTotalRetencionesISR.setDouble(SLibUtils.roundAmount(moAttTotalRetencionesISR.getDouble() + retencion));
    }
    
    public void addAttTotalRetencionesIEPS(final double retencion) {
        moAttTotalRetencionesIEPS.setDouble(SLibUtils.roundAmount(moAttTotalRetencionesIEPS.getDouble() + retencion));
    }
    
    public void addAttTotalTrasladosBaseIVA16(final double base) {
        moAttTotalTrasladosBaseIVA16.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosBaseIVA16.getDouble() + base));
    }
    
    public void addAttTotalTrasladosImpuestoIVA16(final double impuesto) {
        moAttTotalTrasladosImpuestoIVA16.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosImpuestoIVA16.getDouble() + impuesto));
    }
    
    public void addAttTotalTrasladosBaseIVA8(final double base) {
        moAttTotalTrasladosBaseIVA8.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosBaseIVA8.getDouble() + base));
    }
    
    public void addAttTotalTrasladosImpuestoIVA8(final double impuesto) {
        moAttTotalTrasladosImpuestoIVA8.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosImpuestoIVA8.getDouble() + impuesto));
    }
    
    public void addAttTotalTrasladosBaseIVA0(final double base) {
        moAttTotalTrasladosBaseIVA0.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosBaseIVA0.getDouble() + base));
    }
    
    public void addAttTotalTrasladosImpuestoIVA0(final double impuesto) {
        moAttTotalTrasladosImpuestoIVA0.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosImpuestoIVA0.getDouble() + impuesto));
    }
    
    public void addAttTotalTrasladosBaseIVAExento(final double base) {
        moAttTotalTrasladosBaseIVAExento.setDouble(SLibUtils.roundAmount(moAttTotalTrasladosBaseIVAExento.getDouble() + base));
    }
    
    public void addAttMontoTotalPagos(final double monto) {
        moAttMontoTotalPagos.setDouble(SLibUtils.roundAmount(moAttMontoTotalPagos.getDouble() + monto));
    }
}
