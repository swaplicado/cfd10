/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementMercancias extends cfd.DElement {

    private final DAttributeDouble moAttPesoBrutoTotal;
    private final DAttributeString moAttUnidadPeso;
    private final DAttributeInteger moAttNumTotalMercancias;

    private final ArrayList<DElementMercancia> maEltMercancias;
    private final DElementAutotransporte moEltAutotransporte;
    private DElementTransporteMaritimo moEltTransporteMaritimo;
    private DElementTransporteFerroviario moEltTransporteFerroviario;
    private DElementTransporteAereo moEltTransporteAereo;
    
    public DElementMercancias() {
        super("cartaporte20:Mercancias");
        
        moAttPesoBrutoTotal = new DAttributeDouble("PesoBrutoTotal", true, 3);
        moAttUnidadPeso = new DAttributeString("UnidadPeso", true);
        moAttNumTotalMercancias = new DAttributeInteger("NumTotalMercancias", true);
        
        mvAttributes.add(moAttPesoBrutoTotal);
        mvAttributes.add(moAttUnidadPeso);
        mvAttributes.add(moAttNumTotalMercancias);

        maEltMercancias = new ArrayList<>();
        moEltAutotransporte = new DElementAutotransporte();
        moEltTransporteMaritimo = null;
        moEltTransporteFerroviario = null;
        moEltTransporteAereo = null;
    }
    
    public DAttributeDouble getAttPesoBrutoTotal() { return moAttPesoBrutoTotal; }
    public DAttributeString getAttUnidadPeso() { return moAttUnidadPeso; }
    public DAttributeInteger getAttNumTotalMercancias() { return moAttNumTotalMercancias; }

    public ArrayList<DElementMercancia> getEltMercancias() { return maEltMercancias; }
    public DElementAutotransporte getEltAutotransporte() { return moEltAutotransporte; }
    public DElementTransporteMaritimo getEltTransporteMaritimo() { return moEltTransporteMaritimo; }
    public DElementTransporteFerroviario getEltTransporteFerroviario() { return moEltTransporteFerroviario; }
    public DElementTransporteAereo getEltTransporteAereo() { return moEltTransporteAereo; }
    
    public void setEltTransporteMaritimo(DElementTransporteMaritimo o) { moEltTransporteMaritimo = o; }
    public void setEltTransporteFerroviario(DElementTransporteFerroviario o) { moEltTransporteFerroviario = o; }
    public void setEltTransporteAereo(DElementTransporteAereo o) { moEltTransporteAereo = o; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any

        // validate child elements:
        
        if (maEltMercancias.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementMercancia().getName()) + "'.");
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

        for (DElementMercancia element : maEltMercancias) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }
        
        String aux = moEltAutotransporte.getElementForXml();
        xml += aux.isEmpty() ? "" : "\n" + aux;


        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementMercancia element : maEltMercancias) {
            string += element.getElementForOriginalString();
        }

        string += moEltAutotransporte.getElementForOriginalString();
        
        return string;
    }
}
