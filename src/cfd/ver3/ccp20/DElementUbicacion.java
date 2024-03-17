/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementUbicacion extends cfd.DElement {
    
    private final DAttributeString moAttTipoUbicacion;
    private final DAttributeString moAttIDUbicacion;
    private final DAttributeTypeRfc moAttRFCRemitenteDestinatario;
    private final DAttributeString moAttNombreRemitenteDestinatario;
    private final DAttributeString moAttNumRegIdTrib;
    private final DAttributeString moAttResidenciaFiscal;
    private final DAttributeDatetime moAttFechaHoraSalidaLlegada;
    private final DAttributeDouble moAttDistanciaRecorrida;
    
    private final DElementDomicilio moEltDomicilio;

    public DElementUbicacion() {
        super("cartaporte20:Ubicacion");
        
        moAttTipoUbicacion = new DAttributeString("TipoUbicacion", true);
        moAttIDUbicacion = new DAttributeString("IDUbicacion", false);
        moAttRFCRemitenteDestinatario = new DAttributeTypeRfc("RFCRemitenteDestinatario", true);
        moAttNombreRemitenteDestinatario = new DAttributeString("NombreRemitenteDestinatario", false);
        moAttNumRegIdTrib = new DAttributeString("NumRegTrib", false, 6, 40);
        moAttResidenciaFiscal = new DAttributeString("ResidenciaFiscal", false);
        moAttFechaHoraSalidaLlegada = new DAttributeDatetime("FechaHoraSalidaLlegada", true);
        moAttDistanciaRecorrida = new DAttributeDouble("DistanciaRecorrida", false, 2);
        
        mvAttributes.add(moAttTipoUbicacion);
        mvAttributes.add(moAttIDUbicacion);
        mvAttributes.add(moAttRFCRemitenteDestinatario);
        mvAttributes.add(moAttNombreRemitenteDestinatario);
        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttResidenciaFiscal);
        mvAttributes.add(moAttFechaHoraSalidaLlegada);
        mvAttributes.add(moAttDistanciaRecorrida);
        
        moEltDomicilio = new DElementDomicilio();
    }
    
    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltDomicilio != null) {
            elements.add(moEltDomicilio);
        }
        
        return elements;
    }
    
    public DAttributeString getAttTipoUbicacion() { return moAttTipoUbicacion; }
    public DAttributeString getAttIDUbicacion() { return moAttIDUbicacion; }
    public DAttributeTypeRfc getAttRFCRemitenteDestinatario() { return moAttRFCRemitenteDestinatario; }
    public DAttributeString getAttNombreRemitenteDestinatario() { return moAttNombreRemitenteDestinatario; }
    public DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public DAttributeString getAttResidenciaFiscal() { return moAttResidenciaFiscal; }
    public DAttributeDatetime getAttFechaHoraSalidaLlegada() { return moAttFechaHoraSalidaLlegada; }
    public DAttributeDouble getAttDistanciaRecorrida() { return moAttDistanciaRecorrida; }
    
    public DElementDomicilio getEltDomicilio() { return moEltDomicilio; }
    
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
            xml += aux.isEmpty() ? "" : "\n" + aux;
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
