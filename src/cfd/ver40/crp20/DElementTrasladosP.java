/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.ver4.DCfdVer4Utils;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementTrasladosP extends cfd.DElement {

    private final ArrayList<DElementTrasladoP> maEltTrasladoPs;
    
    public DElementTrasladosP() {
        super("pago20:TrasladosP");
        
        maEltTrasladoPs = new ArrayList<>();
    }
    
    /*
    * Public methods
    */
    
    public ArrayList<DElementTrasladoP> getEltTrasladoPs() { return maEltTrasladoPs; }
    
    public DElementTrasladoP getEltTrasladoP(final String impuesto, final String tipoFactor, final double tasaOCuota) {
        DElementTrasladoP trasladoP = null;
        
        for (DElementTrasladoP element : maEltTrasladoPs) {
            if (element.getAttImpuestoP().getString().equals(impuesto) && 
                    element.getAttTipoFactorP().getString().equals(tipoFactor) && 
                    DCfdVer4Utils.compareTasaOCuota(element.getAttTasaOCuotaP().getDouble(), tasaOCuota)) {
                trasladoP = element;
                break;
            }
        }
        
        return trasladoP;
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";
        
        for (DElementTrasladoP element : maEltTrasladoPs) {
            String aux = element.getElementForXml();
            if (!aux.isEmpty()) {
                xml += "\n" + aux;
            }
        }
        
        xml += "\n</" + msName + ">";

        return xml;
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        for (DElementTrasladoP element : maEltTrasladoPs) {
            string += element.getElementForOriginalString();
        }
        
        return string;
    }
}
