package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.ver32.DElementTipoUbicacion;

/**
 *
 * @author Juan Barajas
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

        xml = moEltDomicilio.getElementForXml();
        string += xml.length() == 0 ? "" : "\n" + xml;

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes

        string += moEltDomicilio.getElementForOriginalString();

        return string;
    }
}
