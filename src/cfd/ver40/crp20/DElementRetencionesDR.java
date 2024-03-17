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
public class DElementRetencionesDR extends cfd.DElement {

    private final ArrayList<DElementRetencionDR> maEltRetencionDRs;
    
    public DElementRetencionesDR() {
        super("pago20:RetencionesDR");
        
        maEltRetencionDRs = new ArrayList<>();
    }
    
    /*
     * Public methods:
     */
    
    public ArrayList<DElementRetencionDR> getEltRetencionDRs() { return maEltRetencionDRs; }
     
    public DElementRetencionDR getEltTrasladoDR(final String impuesto, final String tipoFactor, final double tasaOCuota) {
        DElementRetencionDR retencionDR = null;
        
        for (DElementRetencionDR element : maEltRetencionDRs) {
            if (element.getAttImpuestoDR().getString().equals(impuesto) && 
                    element.getAttTipoFactorDR().getString().equals(tipoFactor) && 
                    DCfdVer4Utils.compareTasaOCuota(element.getAttTasaOCuotaDR().getDouble(), tasaOCuota)) {
                retencionDR = element;
                break;
            }
        }
        
        return retencionDR;
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";
        
        for (DElementRetencionDR element : maEltRetencionDRs) {
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
        
        for (DElementRetencionDR element : maEltRetencionDRs) {
            string += element.getElementForOriginalString();
        }
        
        return string;
    }
}
