/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementIdentificacionVehicular extends cfd.DElement {

    private final DAttributeString moAttConfigVehicular;
    private final DAttributeString moAttPlacaVM;
    private final DAttributeInteger moAttAnioModeloVM;
    
    public DElementIdentificacionVehicular() {
        super("cartaporte20:IdentificacionVehicular");
        
        moAttConfigVehicular = new DAttributeString("ConfigVehicular", true);
        moAttPlacaVM = new DAttributeString("PlacaVM", true);
        moAttAnioModeloVM = new DAttributeInteger("AnioModeloVM", true, 4, 4);
        
        mvAttributes.add(moAttConfigVehicular);
        mvAttributes.add(moAttPlacaVM);
        mvAttributes.add(moAttAnioModeloVM);
    }
    
    public DAttributeString getAttConfigVehicular() { return moAttConfigVehicular; }
    public DAttributeString getAttPlacaVM() { return moAttPlacaVM; }
    public DAttributeInteger getAttAnioModeloVM() { return moAttAnioModeloVM; }
}
