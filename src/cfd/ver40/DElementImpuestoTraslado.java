package cfd.ver40;

import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel Danae García Servín
 */
public class DElementImpuestoTraslado extends cfd.DElement {

    private final cfd.DAttributeTypeImporte moAttBase;
    private final cfd.DAttributeString moAttImpuesto;
    private final cfd.DAttributeString moAttTipoFactor;
    private final cfd.DAttributeDouble moAttTasaOCuota;
    private final cfd.DAttributeTypeImporte moAttImporte;

    public DElementImpuestoTraslado() {
        super("cfdi:Traslado");

        moAttBase = new DAttributeTypeImporte("Base", true);
        moAttImpuesto = new DAttributeString("Impuesto", true);
        moAttTipoFactor = new DAttributeString("TipoFactor", true);
        moAttTasaOCuota = new DAttributeDouble("TasaOCuota", false, 6);
        moAttTasaOCuota.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", false);
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
}
