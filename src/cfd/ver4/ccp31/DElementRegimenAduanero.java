/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp31;

import cfd.DAttributeString;

/**
 *
 * @author Isabel Servin
 */
public class DElementRegimenAduanero extends cfd.DElement {
    
    private final DAttributeString moAttRegimenAduanero;

    public DElementRegimenAduanero() {
        super("cartaporte31:RegimenAduanero");
        
        moAttRegimenAduanero = new DAttributeString("RegimenAduanero", true);
    }
    
    public DAttributeString getAttRegimenAduanero() { return moAttRegimenAduanero; }
}
