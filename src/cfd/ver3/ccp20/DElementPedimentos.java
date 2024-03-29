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
public class DElementPedimentos extends cfd.DElement {
    
    private final DAttributeString moAttPedimento; 

    public DElementPedimentos() {
        super("cartaporte20:Pedimentos");
        
        moAttPedimento = new DAttributeString("Pedimento", true, 21, 21);
        moAttPedimento.setTrimmable(false);
        
        mvAttributes.add(moAttPedimento);
    }
    
    public DAttributeString getAttPedimento() { return moAttPedimento; }
}
