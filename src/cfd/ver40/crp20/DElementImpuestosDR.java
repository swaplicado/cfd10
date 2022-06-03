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
public class DElementImpuestosDR extends cfd.DElement {

    private final ArrayList<DElementRetencionesDR> maEltRetencionesDR;
    private final ArrayList<DElementTrasladosDR> maEltTrasladosDR;
    
    public DElementImpuestosDR() {
        super("pagos20:ImpuestosDR");
        
        maEltRetencionesDR = new ArrayList<>();
        maEltTrasladosDR = new ArrayList<>();
    }
    
    public ArrayList<DElementRetencionesDR> getEltRetencionesDR() { return maEltRetencionesDR; }
    public ArrayList<DElementTrasladosDR> getEltTrasladosDR() { return maEltTrasladosDR; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";

        for (DElementRetencionesDR element : maEltRetencionesDR) {
            String aux = element.getElementForXml();
            if (!aux.isEmpty()) {
                xml += "\n" + aux;
            }
        }
        
        for (DElementTrasladosDR element : maEltTrasladosDR) {
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
        
        for (DElementRetencionesDR element : maEltRetencionesDR) {
            string += element.getElementForOriginalString();
        }
        
        for (DElementTrasladosDR element : maEltTrasladosDR) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
    
}
