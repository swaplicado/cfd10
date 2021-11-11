/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementRemolque extends cfd.DElement {

    private final DAttributeString moAttSubTipoRem;
    private final DAttributeString moAttPlaca;
    
    public DElementRemolque() {
        super("cartaporte20:Remolque");
        
        moAttSubTipoRem = new DAttributeString("SubTipoRem", true);
        moAttPlaca = new DAttributeString("Placa", true);
        
        mvAttributes.add(moAttSubTipoRem);
        mvAttributes.add(moAttPlaca);
    }
    
    public DAttributeString getAttSubTipoRem() { return moAttSubTipoRem; }
    public DAttributeString getAttPlaca() { return moAttPlaca; }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        return string;
    }
}
