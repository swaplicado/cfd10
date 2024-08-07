/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp31;

import cfd.DAttributeDouble;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementCantidadTransporta extends cfd.DElement {
    
    private final DAttributeDouble moAttCantidad;
    private final DAttributeString moAttIDOrigen;
    private final DAttributeString moAttIDDestino;
    private final DAttributeString moAttCvesTransporte;

    public DElementCantidadTransporta() {
        super("cartaporte31:CantidadTransporta");
        
        moAttCantidad = new DAttributeDouble("Cantidad", true, 6);
        moAttIDOrigen = new DAttributeString("IDOrigen", true, 8);
        moAttIDDestino = new DAttributeString("IDDestino", true, 8);
        moAttCvesTransporte = new DAttributeString("CvesTransporte", false);
        
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttIDOrigen);
        mvAttributes.add(moAttIDDestino);
        mvAttributes.add(moAttCvesTransporte);
    }
    
    public DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public DAttributeString getAttIDOrigen() { return moAttIDOrigen; }
    public DAttributeString getAttIDDestino() { return moAttIDDestino; }
    public DAttributeString getAttCvesTransporte() { return moAttCvesTransporte; }
}
