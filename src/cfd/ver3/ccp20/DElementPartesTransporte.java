/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementPartesTransporte extends cfd.DElement {
    
    private final DAttributeString moAttParteTransporte;

    public DElementPartesTransporte() {
        super("cartaporte20:PartesTransporte");
        
        moAttParteTransporte = new DAttributeString("ParteTransporte", true);
        
        mvAttributes.add(moAttParteTransporte);
    }
    
    public DAttributeString getAttParteTransporte() { return moAttParteTransporte; }
}
