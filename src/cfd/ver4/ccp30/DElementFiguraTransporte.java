/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp30;

import cfd.DAttribute;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementFiguraTransporte extends cfd.DElement{

    private final ArrayList<DElementTiposFigura> maEltTiposFigura;
    
    public DElementFiguraTransporte() {
        super("cartaporte30:FiguraTransporte");
        
        maEltTiposFigura = new ArrayList<>();
    }
    
    public ArrayList<DElementTiposFigura> getEltTiposFigura() { return maEltTiposFigura; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any

        // validate child elements:
        
        if (maEltTiposFigura.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementTiposFigura().getName()) + "'.");
        }
        
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        for (DElementTiposFigura element : maEltTiposFigura) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }
        
        xml += "\n</" + msName + ">";

        return xml;
    }
    
    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementTiposFigura element : maEltTiposFigura) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
