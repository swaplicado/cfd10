/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40;

import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementInformacionGlobal extends cfd.DElement {
    
    private final DAttributeString moAttPeriodicidad;
    private final DAttributeString moAttMeses;
    private final DAttributeInteger moAttAño;

    public DElementInformacionGlobal() {
        super("cfdi:InformacionGlobal");
        
        moAttPeriodicidad = new DAttributeString("Periodicidad", true, 2, 2);
        moAttMeses = new DAttributeString("Meses", true, 2, 2);
        moAttAño = new DAttributeInteger("Año", true, 4, 4);
        
        mvAttributes.add(moAttPeriodicidad);
        mvAttributes.add(moAttMeses);
        mvAttributes.add(moAttAño);
    }
    
    /*
     * Public methods:
     */

    public DAttributeString getAttPeriodicidad() { return moAttPeriodicidad; }
    public DAttributeString getAttMeses() { return moAttMeses; }
    public DAttributeInteger getAttAño() { return moAttAño; }
}
