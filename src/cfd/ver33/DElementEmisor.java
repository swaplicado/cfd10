package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Juan Barajas
 */
public class DElementEmisor extends cfd.DElement {

    protected cfd.DAttributeTypeRfc moAttRfc;
    protected cfd.DAttributeString moAttNombre;
    protected cfd.DAttributeString moAttRegimenFiscal;

    public DElementEmisor() {
        super("cfdi:Emisor");

        moAttRfc = new DAttributeTypeRfc("Rfc", true);
        moAttNombre = new DAttributeString("Nombre", false);
        moAttRegimenFiscal = new DAttributeString("RegimenFiscal", true);

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);
        mvAttributes.add(moAttRegimenFiscal);
    }

    public cfd.DAttributeTypeRfc getAttRfc() { return moAttRfc; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }
    public cfd.DAttributeString getAttRegimenFiscal() { return moAttRegimenFiscal; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }
        
        string += ">\n</" + msName + ">";

        return string;
    }
}
