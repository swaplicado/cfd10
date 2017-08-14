package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.ver32.DElementTipoUbicacion;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementReceptor extends cfd.DElement {

    protected cfd.DAttributeString moAttNumRegIdTrib;

    protected cfd.ver32.DElementTipoUbicacion moEltDomicilio;

    public DElementReceptor() {
        super("cce11:Receptor");

        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false);

        mvAttributes.add(moAttNumRegIdTrib);

        moEltDomicilio = new DElementTipoUbicacion("cce11:Domicilio");
    }

    public cfd.DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }

    public cfd.ver32.DElementTipoUbicacion getEltDomicilio() { return moEltDomicilio; }
    
    public void clearEltDomicilio() {
        moEltDomicilio = null;
    }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        if (moEltDomicilio != null) {
            xml = moEltDomicilio.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes

        if (moEltDomicilio != null) {
            string += moEltDomicilio.getElementForOriginalString();
        }

        return string;
    }
}
