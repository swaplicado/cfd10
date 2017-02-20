package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementImpuestoRetencion extends cfd.DElement {

    protected cfd.DAttributeString moAttImpuesto;
    protected cfd.DAttributeTypeImporte moAttImporte;

    public DElementImpuestoRetencion() {
        super("cfdi:Retencion");

        moAttImpuesto = new DAttributeString("Impuesto", true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttImpuesto);
        mvAttributes.add(moAttImporte);
    }
    
    public cfd.DAttributeString getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    
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
