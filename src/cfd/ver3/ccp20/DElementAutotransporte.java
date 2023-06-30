/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementAutotransporte extends cfd.DElement {

    private final DAttributeString moAttPermSCT;
    private final DAttributeString moAttNumPermisoSCT;
    
    private final DElementIdentificacionVehicular moEltIdentificacionVehicular;
    private final DElementSeguros moEltSeguros;
    private DElementRemolques moEltRemolques;
    
    public DElementAutotransporte() {
        super("cartaporte20:Autotransporte");
        
        moAttPermSCT = new DAttributeString("PermSCT", true);
        moAttNumPermisoSCT = new DAttributeString("NumPermisoSCT", true, 1, 50);
        
        mvAttributes.add(moAttPermSCT);
        mvAttributes.add(moAttNumPermisoSCT);
        
        moEltIdentificacionVehicular = new DElementIdentificacionVehicular();
        moEltSeguros = new DElementSeguros();
        moEltRemolques = null;
    }
    
    /*
     * Private methods:
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltIdentificacionVehicular != null) {
            elements.add(moEltIdentificacionVehicular);
        }
        
        if (moEltSeguros != null) {
            elements.add(moEltSeguros);
        }
        
        if (moEltRemolques != null) {
            elements.add(moEltRemolques);
        }
        
        return elements;
    }
    
    /*
     * Public methods:
     */
    
    public DAttributeString getAttPermSCT() { return moAttPermSCT; }
    public DAttributeString getAttNumPermisoSCT() { return moAttNumPermisoSCT; }
    
    public DElementIdentificacionVehicular getEltIdentificacionVehicular() { return moEltIdentificacionVehicular; }
    public DElementSeguros getEltSeguros() { return moEltSeguros; }
    public DElementRemolques getEltRemolques() { return moEltRemolques; }
    
    public void setEltRemolques(DElementRemolques o) { moEltRemolques = o; }  
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

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
