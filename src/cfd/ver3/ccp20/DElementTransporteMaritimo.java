/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementTransporteMaritimo extends cfd.DElement {

    private final DAttributeString moAttValor;
    
    public DElementTransporteMaritimo() {
        super("cartaporte20:TransporteMaritimo");
        
        moAttValor = new DAttributeString("Valor", true);
        
        mvAttributes.add(moAttValor);
    }
    
    public DAttributeString getAttValor() { return moAttValor; }
}
