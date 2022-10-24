/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementImpuestosP extends cfd.DElement {

    private DElementRetencionesP moEltRetencionesP;
    private DElementTrasladosP moEltTrasladosP;
    
    public DElementImpuestosP() {
        super("pago20:ImpuestosP");
        
        moEltRetencionesP = null;
        moEltTrasladosP = null;
    }
    
    /*
    * Private methods
    */
    
    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltRetencionesP != null) {
            elements.add(moEltRetencionesP);
        }
        
        if (moEltTrasladosP != null) {
            elements.add(moEltTrasladosP);
        }
        
        return elements;
    }
    
    /*
    * Public methods:
    */
    
    public void setEltRetencionesP(DElementRetencionesP o) { moEltRetencionesP = o; }
    public void setEltTrasladosP(DElementTrasladosP o) { moEltTrasladosP = o; }
    
    public DElementRetencionesP getEltRetencionesDR() { return moEltRetencionesP; }
    public DElementTrasladosP getEltTrasladosDR() { return moEltTrasladosP; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;
        
        xml += ">";
        
        for (DElement element : createElementsArray()) {
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
        
        for (DElement element : createElementsArray()) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
