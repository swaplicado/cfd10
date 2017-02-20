package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.ver32.DElementTipoUbicacionFiscal;

/**
 *
 * @author Juan Barajas
 */
public class DElementEmisor extends cfd.DElement {

    protected cfd.DAttributeString moAttCurp;

    protected cfd.ver32.DElementTipoUbicacionFiscal moEltDomicilio;
    
    public DElementEmisor() {
        super("cce11:Emisor");

        moAttCurp = new DAttributeString("Curp", false);

        mvAttributes.add(moAttCurp);
        
        moEltDomicilio = new DElementTipoUbicacionFiscal("cce11:Domicilio");
    }

    public cfd.DAttributeString getAttCurp() { return moAttCurp; }
    
    public cfd.ver32.DElementTipoUbicacionFiscal getEltDomicilio() { return moEltDomicilio; }
    
    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";
        
        if (moEltDomicilio != null) {
            xml = moEltDomicilio.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes
        
        if (moEltDomicilio != null) {
            string += moEltDomicilio.getElementForOriginalString();
        }
        
        return string;
    }
}
