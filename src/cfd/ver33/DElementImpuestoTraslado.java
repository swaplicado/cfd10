package cfd.ver33;

import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementImpuestoTraslado extends cfd.DElement {

    protected cfd.DAttributeString moAttImpuesto;
    protected cfd.DAttributeString moAttTipoFactor;
    protected cfd.DAttributeDouble moAttTasaOCuota;
    protected cfd.DAttributeTypeImporte moAttImporte;

    public DElementImpuestoTraslado() {
        super("cfdi:Traslado");

        moAttImpuesto = new DAttributeString("Impuesto", true);
        moAttTipoFactor = new DAttributeString("TipoFactor", false);
        moAttTasaOCuota = new DAttributeDouble("TasaOCuota", true, 6);
        moAttTasaOCuota.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);
        
        mvAttributes.add(moAttImpuesto);
        mvAttributes.add(moAttTipoFactor);
        mvAttributes.add(moAttTasaOCuota);
        mvAttributes.add(moAttImporte);
    }
    
    public cfd.DAttributeString getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeString getAttTipoFactor() { return moAttTipoFactor; }
    public cfd.DAttributeDouble getAttTasaOCuota() { return moAttTasaOCuota; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
}
