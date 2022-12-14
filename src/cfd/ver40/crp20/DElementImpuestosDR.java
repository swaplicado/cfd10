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
 * @author Isabel Danae García Servín, Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestosDR extends cfd.DElement {

    private DElementRetencionesDR moEltRetencionesDR;
    private DElementTrasladosDR moEltTrasladosDR;
    
    public DElementImpuestosDR() {
        super("pago20:ImpuestosDR");
        
        moEltRetencionesDR = null;
        moEltTrasladosDR = null;
    }
    
    /*
     * Private methods:
     */
    
    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltRetencionesDR != null) {
            elements.add(moEltRetencionesDR);
        }
        
        if (moEltTrasladosDR != null) {
            elements.add(moEltTrasladosDR);
        }
        
        return elements;
    }
     
     /*
     * Public methods:
     */
    
    public void setEltRetencionesDR(DElementRetencionesDR o) { moEltRetencionesDR = o; }
    public void setEltTrasladosDR(DElementTrasladosDR o) { moEltTrasladosDR = o; }
    
    public DElementRetencionesDR getEltRetencionesDR() { return moEltRetencionesDR; }
    public DElementTrasladosDR getEltTrasladosDR() { return moEltTrasladosDR; }
    
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
