/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp30;

import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementTransporteAereo extends cfd.DElement {
    
    private final DAttributeString moAttValor;
    
    public DElementTransporteAereo() {
        super("cartaporte30:TransporteAereo");
        
        moAttValor = new DAttributeString("Valor", true);
        
        mvAttributes.add(moAttValor);
    }
    
    public DAttributeString getAttValor() { return moAttValor; }
}
