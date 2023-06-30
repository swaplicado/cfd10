package cfd.ver40;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementImpuestoRetencion extends cfd.DElement {

    private final cfd.DAttributeString moAttImpuesto;
    private final cfd.DAttributeTypeImporte moAttImporte;

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
