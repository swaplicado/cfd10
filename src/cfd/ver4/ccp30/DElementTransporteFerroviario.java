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
public class DElementTransporteFerroviario extends cfd.DElement {
    
    private final DAttributeString moAttValor;
    
    public DElementTransporteFerroviario() {
        super("cartaporte30:TransporteFerroviario");
        
        moAttValor = new DAttributeString("Valor", true);
        
        mvAttributes.add(moAttValor);
    }
    
    public DAttributeString getAttValor() { return moAttValor; }
}
