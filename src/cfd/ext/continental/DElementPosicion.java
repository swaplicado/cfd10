/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */
package cfd.ext.continental;

import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPosicion extends DElement {
    
    public static final String NAME = "Posicion";
    
    protected DAttributeInteger moAttNumPosicionPo;     // attribute placed first due to Continental verbal request, even though addenda's XSD indicates it goes in second place
    protected DAttributeString moAttDescripcion;
    protected DAttributeDouble moAttTasaRetencionIva;
    protected DAttributeDouble moAttTasaRetencionIsr;
    
    public DElementPosicion() {
        super(NAME);
        
        moAttNumPosicionPo = new DAttributeInteger("Num_PosicionPO", true, 1, 3, 3);
        moAttDescripcion = new DAttributeString("Descripcion", true, 1, 50);
        moAttTasaRetencionIva = new DAttributeDouble("Tasa_Retencion_IVA", false, 2);
        moAttTasaRetencionIsr = new DAttributeDouble("Tasa_Retencion_ISR", false, 2);
        
        mvAttributes.add(moAttNumPosicionPo);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttTasaRetencionIva);
        mvAttributes.add(moAttTasaRetencionIsr);
    }

    public DAttributeInteger getAttNumPosicionPo() { return moAttNumPosicionPo; }
    public DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public DAttributeDouble getAttTasaRetencionIva() { return moAttTasaRetencionIva; }
    public DAttributeDouble getAttTasaRetencionIsr() { return moAttTasaRetencionIsr; }
}
