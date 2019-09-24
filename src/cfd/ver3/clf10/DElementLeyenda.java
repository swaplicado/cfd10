/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.clf10;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementLeyenda extends cfd.DElement {
    
    private DAttributeString moAttDisposicionFiscal;
    private DAttributeString moAttNorma;
    private DAttributeString moAttTextoLeyenda;
    
    public DElementLeyenda() {
        super("leyendasFisc:Leyenda");
        
        moAttDisposicionFiscal = new DAttributeString("disposicionFiscal", false, 1);
        moAttNorma = new DAttributeString("norma", false, 1);
        moAttTextoLeyenda = new DAttributeString("textoLeyenda", true);
        
        mvAttributes.add(moAttDisposicionFiscal);
        mvAttributes.add(moAttNorma);
        mvAttributes.add(moAttTextoLeyenda);
    }
    
    /*
     * Private methods:
     */

    /*
     * Public methods:
     */

    public DAttributeString getAttDisposicionFiscal() { return moAttDisposicionFiscal; }
    public DAttributeString getAttNorma() { return moAttNorma; }
    public DAttributeString getAttTextoLeyenda() { return moAttTextoLeyenda; }
}
