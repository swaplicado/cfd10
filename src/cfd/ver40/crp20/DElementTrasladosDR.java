/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementTrasladosDR extends cfd.DElement {

    private final ArrayList<DElementTrasladoDR> maEltTrasladoDR;
    
    public DElementTrasladosDR() {
        super("pago20:TrasladosDR");
        
        maEltTrasladoDR = new ArrayList<>();
    }
    
    /*
    * Public methods
    */
    
    public ArrayList<DElementTrasladoDR> getEltTrasladoDR() { return maEltTrasladoDR; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";
        
        for (DElementTrasladoDR element : maEltTrasladoDR) {
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
        
        for (DElementTrasladoDR element : maEltTrasladoDR) {
            string += element.getElementForOriginalString();
        }
        
        return string;
    }
}
