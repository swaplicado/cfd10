package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementConceptoImpuestoRetencion extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttBase;
    protected cfd.DAttributeString moAttImpuesto;
    protected cfd.DAttributeString moAttTipoFactor;
    protected cfd.DAttributeDouble moAttTasaOCuota;
    protected cfd.DAttributeTypeImporte moAttImporte;

    public DElementConceptoImpuestoRetencion() {
        super("cfdi:Retencion");

        moAttBase = new DAttributeTypeImporte("Base", true);
        moAttBase.setCanBeZero(true);
        moAttImpuesto = new DAttributeString("Impuesto", true);
        moAttTipoFactor = new DAttributeString("TipoFactor", false);
        moAttTasaOCuota = new DAttributeDouble("TasaOCuota", true, 6);
        moAttTasaOCuota.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttBase);
        mvAttributes.add(moAttImpuesto);
        mvAttributes.add(moAttTipoFactor);
        mvAttributes.add(moAttTasaOCuota);
        mvAttributes.add(moAttImporte);
    }

    public cfd.DAttributeTypeImporte getAttBase() { return moAttBase; }
    public cfd.DAttributeString getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeString getAttTipoFactor() { return moAttTipoFactor; }
    public cfd.DAttributeDouble getAttTasaOCuota() { return moAttTasaOCuota; }
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
