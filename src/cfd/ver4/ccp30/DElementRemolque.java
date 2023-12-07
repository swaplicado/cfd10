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
public class DElementRemolque extends cfd.DElement {

    private final DAttributeString moAttSubTipoRem;
    private final DAttributeString moAttPlaca;
    
    public DElementRemolque() {
        super("cartaporte30:Remolque");
        
        moAttSubTipoRem = new DAttributeString("SubTipoRem", true);
        moAttPlaca = new DAttributeString("Placa", true, 5, 7);
        
        mvAttributes.add(moAttSubTipoRem);
        mvAttributes.add(moAttPlaca);
    }
    
    public DAttributeString getAttSubTipoRem() { return moAttSubTipoRem; }
    public DAttributeString getAttPlaca() { return moAttPlaca; }
}
