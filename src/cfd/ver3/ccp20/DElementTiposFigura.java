/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementTiposFigura extends cfd.DElement {

    private final DAttributeString moAttTipoFigura;
    private final DAttributeTypeRfc moAttRFCFigura;
    private final DAttributeString moAttNumLicencia;
    private final DAttributeString moAttNombreFigura;
    private final DAttributeString moAttNumRegIdTribFigura;
    private final DAttributeString moAttResidenciaFiscalFigura;
    
    private final ArrayList<DElementPartesTransporte> maEltPartesTransporte;
    
    public DElementTiposFigura() {
        super("cartaporte20:Operadores");
        
        moAttTipoFigura = new DAttributeString("TipoFigura", true);
        moAttRFCFigura = new DAttributeTypeRfc("RFCFigura", false);
        moAttNumLicencia = new DAttributeString("NumLicencia", false, 6, 16);
        moAttNombreFigura = new DAttributeString("NombreFigura", false, 1, 254);
        moAttNumRegIdTribFigura = new DAttributeString("NumRegIdTribFigura", false, 6, 40);
        moAttResidenciaFiscalFigura = new DAttributeString("ResidenciaFiscalFigura", false);
        
        mvAttributes.add(moAttTipoFigura);
        mvAttributes.add(moAttRFCFigura);
        mvAttributes.add(moAttNumLicencia);
        mvAttributes.add(moAttNombreFigura);
        mvAttributes.add(moAttNumRegIdTribFigura);
        mvAttributes.add(moAttResidenciaFiscalFigura);
        
        maEltPartesTransporte = null;
    }
    
    public DAttributeString getAttTipoFigura() { return moAttTipoFigura; }
    public DAttributeTypeRfc getAttRFCFigura() { return moAttRFCFigura; }
    public DAttributeString getAttNumLicencia() { return moAttNumLicencia; }
    public DAttributeString getAttNombreFigura() { return moAttNombreFigura; }
    public DAttributeString getAttNumRegIdTribFigura() { return moAttNumRegIdTribFigura; }
    public DAttributeString getAttResidenciaFiscalFigura() { return moAttResidenciaFiscalFigura; }
    
    public ArrayList<DElementPartesTransporte> getEltPartesTransporte() { return maEltPartesTransporte; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any

        // validate child elements:
        
        if (maEltPartesTransporte.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementPartesTransporte().getName()) + "'.");
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

        for (DElementPartesTransporte element : maEltPartesTransporte) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementPartesTransporte element : maEltPartesTransporte) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
