package cfd.ver33;

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
}
