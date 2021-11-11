/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementCantidadTransporta extends cfd.DElement {
    
    private final DAttributeDouble moAttCantidad;
    private final DAttributeString moAttIDOrigen;
    private final DAttributeString moAttIDDestino;
    private final DAttributeString moAttCvesTransporte;

    public DElementCantidadTransporta() {
        super("cartaporte20:CantidadTransporta");
        
        moAttCantidad = new DAttributeDouble("Cantidad", true, 6);
        moAttIDOrigen = new DAttributeString("IDOrigen", true, 8);
        moAttIDDestino = new DAttributeString("IDDestino", true, 8);
        moAttCvesTransporte = new DAttributeString("CvesTransporte", false);
        
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttIDOrigen);
        mvAttributes.add(moAttIDDestino);
        mvAttributes.add(moAttCvesTransporte);
    }
    
    public DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public DAttributeString getAttIDOrigen() { return moAttIDOrigen; }
    public DAttributeString getAttIDDestino() { return moAttIDDestino; }
    public DAttributeString getAttCvesTransporte() { return moAttCvesTransporte; }
    
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
