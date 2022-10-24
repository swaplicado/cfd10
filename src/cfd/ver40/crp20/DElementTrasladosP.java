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
public class DElementTrasladosP extends cfd.DElement {

    private final ArrayList<DElementTrasladoP> maEltTrasladoP;
    
    public DElementTrasladosP() {
        super("pago20:TrasladosP");
        
        maEltTrasladoP = new ArrayList<>();
    }
    
    /*
    * Public methods
    */
    
    public ArrayList<DElementTrasladoP> getEltTrasladoP() { return maEltTrasladoP; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        xml += ">";
        
        for (DElementTrasladoP element : maEltTrasladoP) {
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
        
        for (DElementTrasladoP element : maEltTrasladoP) {
            string += element.getElementForOriginalString();
        }
        
        return string;
    }
}
