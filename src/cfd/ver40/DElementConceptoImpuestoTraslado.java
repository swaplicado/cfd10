package cfd.ver40;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DCfdMath;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoImpuestoTraslado extends cfd.DElement {

    private final cfd.DAttributeTypeImporte moAttBase;
    private final cfd.DAttributeString moAttImpuesto;
    private final cfd.DAttributeString moAttTipoFactor;
    private final cfd.DAttributeDouble moAttTasaOCuota;
    private final cfd.DAttributeTypeImporte moAttImporte;

    public DElementConceptoImpuestoTraslado() {
        super("cfdi:Traslado");

        moAttBase = new DAttributeTypeImporte("Base", true);
        moAttBase.setCanBeZero(true);
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

    /*
     * Private methods
     */
    
    private boolean isNotRequiredBecauseTipoFactorIsExento(DAttribute attribute) {
        return moAttTipoFactor.getString().compareTo(DCfdi40Catalogs.FAC_TP_EXENTO) == 0 && (attribute == moAttTasaOCuota || attribute == moAttImporte);
    }

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
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            if (isNotRequiredBecauseTipoFactorIsExento(attribute)) {
                continue;
            }
            
            String aux = attribute.getAttributeForXml();
            if (!aux.isEmpty()) {
                xml += " " + aux;
            }
        }

        if (msValue.isEmpty()) {
            xml += "/>";
        }
        else {
            xml += ">" + msValue + "</" + msName + ">";
        }

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        for (DAttribute attribute : mvAttributes) {
            if (isNotRequiredBecauseTipoFactorIsExento(attribute)) {
                continue;
            }
            
            string += attribute.getAttributeForOriginalString();
        }

        return string;
    }
}
