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
public class DElementRetencionesP extends cfd.DElement {
    
    private final ArrayList<DElementRetencionP> maEltRetencionP;

    public DElementRetencionesP() {
        super("pago20:RetencionesP");
        
        maEltRetencionP = new ArrayList<>();
    }
    
    /*
    * Public methods:
    */
    
    public ArrayList<DElementRetencionP> getEltRetencionP() { return maEltRetencionP; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";
        
        for (DElementRetencionP element : maEltRetencionP) {
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
        
        for (DElementRetencionP element : maEltRetencionP) {
            string += element.getElementForOriginalString();
        }
        
        return string;
    }
}
