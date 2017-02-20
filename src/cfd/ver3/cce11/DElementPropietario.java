package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementPropietario extends cfd.DElement {

    protected cfd.DAttributeString moAttNumRegIdTrib;
    protected cfd.DAttributeString moAttResidenciaFiscal;

    public DElementPropietario() {
        super("cfdi:Propietario");

        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", true);
        moAttResidenciaFiscal = new DAttributeString("ResidenciaFiscal", true);

        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttResidenciaFiscal);
    }

    public cfd.DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public cfd.DAttributeString getAttResidenciaFiscal() { return moAttResidenciaFiscal; }

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

        string += "\n</" + msName + ">";

        return string;
    }
}
