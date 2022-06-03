package cfd.ver40;

import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DCfdMath;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoImpuestoRetencion extends cfd.DElement {

    private final cfd.DAttributeTypeImporte moAttBase;
    private final cfd.DAttributeString moAttImpuesto;
    private final cfd.DAttributeString moAttTipoFactor;
    private final cfd.DAttributeDouble moAttTasaOCuota;
    private final cfd.DAttributeTypeImporte moAttImporte;

    public DElementConceptoImpuestoRetencion() {
        super("cfdi:Retencion");

        moAttBase = new DAttributeTypeImporte("Base", true);
        moAttBase.setCanBeZero(true);
        moAttImpuesto = new DAttributeString("Impuesto", true);
        moAttTipoFactor = new DAttributeString("TipoFactor", true);
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

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public cfd.DAttributeTypeImporte getAttBase() { return moAttBase; }
    public cfd.DAttributeString getAttImpuesto() { return moAttImpuesto; }
    public cfd.DAttributeString getAttTipoFactor() { return moAttTipoFactor; }
    public cfd.DAttributeDouble getAttTasaOCuota() { return moAttTasaOCuota; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate attribute "Importe":
        
        // límite inferior: [(Base - 10^(-NumDecimalesBase)/2) * (TasaOCuota)] truncado con el número de decimales de la moneda
        double limitLower = DCfdMath.trunck(
                (moAttBase.getDouble() - Math.pow(10d, -moAttBase.getDecimals()) / 2d) * moAttTasaOCuota.getDouble(),
                moAttImporte.getDecimals());
        
        if (moAttImporte.getDouble() < limitLower) {
            throw new IllegalStateException("El valor del atributo '" + moAttImporte.getName() + "' <" + moAttImporte.getDouble() + "> no puede ser menor que el límite inferior permitido <" + limitLower + ">.");
        }
        
        // límite superior: [(Base + 10^(-NumDecimalesBase)/2 - 10^(-12)) * (TasaOCuota)] redondeado hacia arriba con el número de decimales de la moneda
        double limitUpper = DCfdMath.roundUp(
                (moAttBase.getDouble() + Math.pow(10d, -moAttBase.getDecimals()) / 2d - Math.pow(10d, -12d)) * moAttTasaOCuota.getDouble(),
                moAttImporte.getDecimals());
        
        if (moAttImporte.getDouble() > limitUpper) {
            throw new IllegalStateException("El valor del atributo '" + moAttImporte.getName() + "' <" + moAttImporte.getDouble() + "> no puede ser mayor que el límite superior permitido <" + limitUpper + ">.");
        }
    }
}
