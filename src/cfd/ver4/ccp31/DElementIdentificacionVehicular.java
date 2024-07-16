/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp31;

import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementIdentificacionVehicular extends cfd.DElement {

    private final DAttributeString moAttConfigVehicular;
    private final DAttributeDouble moAttPesoBrutoVehicular;
    private final DAttributeString moAttPlacaVM;
    private final DAttributeInteger moAttAnioModeloVM;
    
    public DElementIdentificacionVehicular() {
        super("cartaporte31:IdentificacionVehicular");
        
        moAttConfigVehicular = new DAttributeString("ConfigVehicular", true);
        moAttPesoBrutoVehicular = new DAttributeDouble("PesoBrutoVehicular", true, 2);
        moAttPlacaVM = new DAttributeString("PlacaVM", true, 5, 7);
        moAttAnioModeloVM = new DAttributeInteger("AnioModeloVM", true, 4, 4);
        
        mvAttributes.add(moAttConfigVehicular);
        mvAttributes.add(moAttPesoBrutoVehicular);
        mvAttributes.add(moAttPlacaVM);
        mvAttributes.add(moAttAnioModeloVM);
    }
    
    public DAttributeString getAttConfigVehicular() { return moAttConfigVehicular; }
    public DAttributeDouble getAttPesoBrutoVehicular() { return moAttPesoBrutoVehicular; }
    public DAttributeString getAttPlacaVM() { return moAttPlacaVM; }
    public DAttributeInteger getAttAnioModeloVM() { return moAttAnioModeloVM; }
}
