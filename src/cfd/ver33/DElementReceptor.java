package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Juan Barajas
 */
public class DElementReceptor extends cfd.DElement {

    protected cfd.DAttributeTypeRfc moAttRfc;
    protected cfd.DAttributeString moAttNombre;
    protected cfd.DAttributeString moAttResidenciaFiscal;
    protected cfd.DAttributeString moAttNumRegIdTrib;
    protected cfd.DAttributeString moAttUsoCfdi;

    public DElementReceptor() {
        super("cfdi:Receptor");

        moAttRfc = new DAttributeTypeRfc("Rfc", true);
        moAttNombre = new DAttributeString("Nombre", false);
        moAttResidenciaFiscal = new DAttributeString("ResidenciaFiscal", false);
        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false);
        moAttUsoCfdi = new DAttributeString("UsoCFDI", true);

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);
        mvAttributes.add(moAttResidenciaFiscal);
        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttUsoCfdi);
    }

    public cfd.DAttributeTypeRfc getAttRfc() { return moAttRfc; }
    public cfd.DAttributeString getAttNombre() { return moAttNombre; }
    public cfd.DAttributeString getAttResidenciaFiscal() { return moAttResidenciaFiscal; }
    public cfd.DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public cfd.DAttributeString getAttUsoCFDI() { return moAttUsoCfdi; }
    
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
