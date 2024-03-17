/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp30;

import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementDocumentacionAduanera extends cfd.DElement {
    
    private final DAttributeString moAttTipoDocumento; 
    private final DAttributeString moAttNumPedimento; 
    private final DAttributeString moAttIdentDocAduanero; 
    private final DAttributeTypeRfc moAttRFCImpo; 

    public DElementDocumentacionAduanera() {
        super("cartaporte30:DocumentacionAduanera");
        
        moAttTipoDocumento = new DAttributeString("TipoDocumento", true);
        moAttNumPedimento = new DAttributeString("Pedimento", false, 21, 21);
        moAttNumPedimento.setTrimmable(false);
        moAttIdentDocAduanero = new DAttributeString("IdentDocAduanero", false);
        moAttRFCImpo = new DAttributeTypeRfc("RFCImpo", false);
        
        mvAttributes.add(moAttTipoDocumento);
        mvAttributes.add(moAttNumPedimento);
        mvAttributes.add(moAttIdentDocAduanero);
        mvAttributes.add(moAttRFCImpo);
    }
    
    public DAttributeString getAttTipoDocumento() { return moAttTipoDocumento; }
    public DAttributeString getAttPedimento() { return moAttNumPedimento; }
    public DAttributeString getAttIdentDocAduanero() { return moAttIdentDocAduanero; }
    public DAttributeTypeRfc getAttRFCImpo() { return moAttRFCImpo; }
}
