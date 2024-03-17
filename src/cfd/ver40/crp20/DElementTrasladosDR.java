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
public class DElementTrasladosDR extends cfd.DElement {

    private final ArrayList<DElementTrasladoDR> maEltTrasladoDRs;
    
    public DElementTrasladosDR() {
        super("pago20:TrasladosDR");
        
        maEltTrasladoDRs = new ArrayList<>();
    }
    
    /*
    * Public methods
    */
    
    public ArrayList<DElementTrasladoDR> getEltTrasladoDRs() { return maEltTrasladoDRs; }
    
    public DElementTrasladoDR getEltTrasladoDR(final String impuesto, final String tipoFactor, final double tasaOCuota) {
        DElementTrasladoDR trasladoDR = null;
        
        for (DElementTrasladoDR element : maEltTrasladoDRs) {
            if (element.getAttImpuestoDR().getString().equals(impuesto) && 
                    element.getAttTipoFactorDR().getString().equals(tipoFactor) && 
                    DCfdVer4Utils.compareTasaOCuota(element.getAttTasaOCuotaDR().getDouble(), tasaOCuota)) {
                trasladoDR = element;
                break;
            }
        }
        
        return trasladoDR;
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";
        
        for (DElementTrasladoDR element : maEltTrasladoDRs) {
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
        
        for (DElementTrasladoDR element : maEltTrasladoDRs) {
            string += element.getElementForOriginalString();
        }
        
        return string;
    }
}
