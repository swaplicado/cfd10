package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DAttributeTypeImporteUnitario;
import cfd.DCfdMath;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoParte extends cfd.DElement {

    private final cfd.DAttributeString moAttClaveProdServ;
    private final cfd.DAttributeString moAttNoIdentificacion;
    private final cfd.DAttributeTypeImporteUnitario moAttCantidad;
    private final cfd.DAttributeString moAttUnidad;
    private final cfd.DAttributeString moAttDescripcion;
    private final cfd.DAttributeTypeImporteUnitario moAttValorUnitario;
    private final cfd.DAttributeTypeImporte moAttImporte;

    private final ArrayList<cfd.ver33.DElementConceptoInformacionAduanera> maEltOpcConceptoInformacionAduaneras;

    public DElementConceptoParte() {
        super("cfdi:Parte");

        moAttClaveProdServ = new DAttributeString("ClaveProdServ", true, 1);
        moAttNoIdentificacion = new DAttributeString("NoIdentificacion", false, 1, 100);    // from 1 to 100 characters
        moAttCantidad = new DAttributeTypeImporteUnitario("Cantidad", true);
        moAttUnidad = new DAttributeString("Unidad", true, 1, 20);  // from 1 to 20 characters
        moAttDescripcion = new DAttributeString("Descripcion", true, 1, 1000);  // from 1 to 1000 characters
        moAttValorUnitario = new DAttributeTypeImporteUnitario("ValorUnitario", true);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttClaveProdServ);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);

        maEltOpcConceptoInformacionAduaneras = new ArrayList<>();
    }

    /*
     * Private methods
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();
        
        if (!maEltOpcConceptoInformacionAduaneras.isEmpty()) {
            elements.addAll(maEltOpcConceptoInformacionAduaneras);
        }
        
        return elements;
    }

    /*
     * Public methods
     */

    public cfd.DAttributeString getAttClaveProdServ() { return moAttClaveProdServ; }
    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttUnidad() { return moAttUnidad; }
    public cfd.DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporteUnitario getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    
    public ArrayList<cfd.ver33.DElementConceptoInformacionAduanera> getEltOpcConceptoInformacionAduaneras() { return maEltOpcConceptoInformacionAduaneras; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        // validate attribute "Importe":
        
        // límite inferior: [(Cantidad - 10^(-NumDecimalesCantidad)/2) * (ValorUnitario - 10^(-NumDecimalesValorUnitario)/2)] truncado con el número de decimales de la moneda
        double limitLower = DCfdMath.trunck(
                (moAttCantidad.getDouble() - Math.pow(10d, -moAttCantidad.getDecimals()) / 2d) *
                        (moAttValorUnitario.getDouble() - Math.pow(10d, -moAttValorUnitario.getDecimals()) / 2d),
                moAttImporte.getDecimals());
        
        if (moAttImporte.getDouble() < limitLower) {
            throw new IllegalStateException("El valor del atributo '" + moAttImporte.getName() + "' <" + moAttImporte.getDouble() + "> no puede ser menor que el límite inferior permitido <" + limitLower + ">.");
        }
        
        // límite superior: [(Cantidad + 10^(-NumDecimalesCantidad)/2 - 10^(-12)) * (ValorUnitario + 10^(-NumDecimalesValorUnitario)/2 - 10^(-12))] redondeado hacia arriba con el número de decimales de la moneda
        double limitUpper = DCfdMath.roundUp(
                (moAttCantidad.getDouble() + Math.pow(10d, -moAttCantidad.getDecimals()) / 2d - Math.pow(10d, -12d)) *
                        (moAttValorUnitario.getDouble() - Math.pow(10d, -moAttValorUnitario.getDecimals()) / 2d - Math.pow(10d, -12d)),
                moAttImporte.getDecimals());
        
        if (moAttImporte.getDouble() > limitUpper) {
            throw new IllegalStateException("El valor del atributo '" + moAttImporte.getName() + "' <" + moAttImporte.getDouble() + "> no puede ser mayor que el límite superior permitido <" + limitUpper + ">.");
        }
        
        // validate text conformity to requiered regular expressions:
        
        if (!moAttNoIdentificacion.getString().isEmpty() && !DCfdi33Utils.matches(moAttNoIdentificacion.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttNoIdentificacion.getLengthMin() + "," + moAttNoIdentificacion.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNoIdentificacion.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!moAttUnidad.getString().isEmpty() && !DCfdi33Utils.matches(moAttUnidad.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttUnidad.getLengthMin() + "," + moAttUnidad.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttUnidad.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!DCfdi33Utils.matches(moAttDescripcion.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttDescripcion.getLengthMin() + "," + moAttDescripcion.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttDescripcion.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            if (!aux.isEmpty()) {
                xml += " " + aux;
            }
        }

        xml += ">";

        for (DElement element : createElementsArray()) {
            String aux = element.getElementForXml();
            if (!aux.isEmpty()) {
                xml += "\n" + aux;
            }
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes
        
        for (DElement element : maEltOpcConceptoInformacionAduaneras) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
