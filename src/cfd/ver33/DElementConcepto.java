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
public class DElementConcepto extends cfd.DElement {

    private final DAttributeString moAttClaveProdServ;
    private final DAttributeString moAttNoIdentificacion;
    private final DAttributeTypeImporteUnitario moAttCantidad;
    private final DAttributeString moAttClaveUnidad;
    private final DAttributeString moAttUnidad;
    private final DAttributeString moAttDescripcion;
    private final DAttributeTypeImporte moAttValorUnitario;
    private final DAttributeTypeImporte moAttImporte;
    private final DAttributeTypeImporte moAttDescuento;

    private cfd.ver33.DElementConceptoImpuestos moEltOpcConceptoImpuestos;
    private final ArrayList<cfd.ver33.DElementConceptoInformacionAduanera> maEltOpcConceptoInformacionAduaneras;
    private cfd.ver33.DElementConceptoCuentaPredial moEltOpcConceptoCuentaPredial;
    private final ArrayList<cfd.ver33.DElementConceptoParte> maEltOpcConceptoPartes;
    private cfd.ver33.DElementComplementoConcepto moEltOpcComplementoConcepto;

    public DElementConcepto() {
        super("cfdi:Concepto");

        moAttClaveProdServ = new DAttributeString("ClaveProdServ", true, 6, 8);     // c_ClaveProdServ catalog codes of 8 fixed digits, but can be used as well first 6 digits
        moAttNoIdentificacion = new DAttributeString("NoIdentificacion", false, 1, 100);    // from 1 to 100 characters
        moAttCantidad = new DAttributeTypeImporteUnitario("Cantidad", true);
        moAttClaveUnidad = new DAttributeString("ClaveUnidad", true, 2, 3);     // c_ClaveUnidad catalog codes from 2 to 3 characters
        moAttUnidad = new DAttributeString("Unidad", true, 1, 20);  // from 1 to 20 characters
        moAttDescripcion = new DAttributeString("Descripcion", true, 1, 1000);  // from 1 to 1000 characters
        moAttValorUnitario = new DAttributeTypeImporte("ValorUnitario", true);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);
        moAttDescuento = new DAttributeTypeImporte("Descuento", false);

        mvAttributes.add(moAttClaveProdServ);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttClaveUnidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);
        mvAttributes.add(moAttDescuento);

        moEltOpcConceptoImpuestos = null;
        maEltOpcConceptoInformacionAduaneras = new ArrayList<>();
        moEltOpcConceptoCuentaPredial = null;
        maEltOpcConceptoPartes = new ArrayList<>();
        moEltOpcComplementoConcepto = null;
    }
    
    /*
     * Private methods
     */

    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();
        
        if (moEltOpcConceptoImpuestos != null) {
            elements.add(moEltOpcConceptoImpuestos);
        }
        
        if (!maEltOpcConceptoInformacionAduaneras.isEmpty()) {
            elements.addAll(maEltOpcConceptoInformacionAduaneras);
        }
        
        if (moEltOpcConceptoCuentaPredial != null) {
            elements.add(moEltOpcConceptoCuentaPredial);
        }
        
        if (!maEltOpcConceptoPartes.isEmpty()) {
            elements.addAll(maEltOpcConceptoPartes);
        }
        
        if (moEltOpcComplementoConcepto != null) {
            elements.add(moEltOpcComplementoConcepto);
        }
        
        return elements;
    }

    /*
     * Public methods
     */

    public void setEltOpcConceptoImpuestos(cfd.ver33.DElementConceptoImpuestos o) { moEltOpcConceptoImpuestos = o; }
    public void setEltOpcConceptoCuentaPredial(cfd.ver33.DElementConceptoCuentaPredial o) { moEltOpcConceptoCuentaPredial = o; }
    public void setEltOpcComplementoConcepto(cfd.ver33.DElementComplementoConcepto o) { moEltOpcComplementoConcepto = o; }

    public DAttributeString getAttClaveProdServ() { return moAttClaveProdServ; }
    public DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public DAttributeString getAttClaveUnidad() { return moAttClaveUnidad; }
    public DAttributeString getAttUnidad() { return moAttUnidad; }
    public DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporte getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }

    public cfd.ver33.DElementConceptoImpuestos getEltOpcConceptoImpuestos() { return moEltOpcConceptoImpuestos; }
    public ArrayList<cfd.ver33.DElementConceptoInformacionAduanera> getEltOpcConceptoInformacionAduaneras() { return maEltOpcConceptoInformacionAduaneras; }
    public cfd.ver33.DElementConceptoCuentaPredial getEltOpcConceptoCuentaPredial() { return moEltOpcConceptoCuentaPredial; }
    public ArrayList<cfd.ver33.DElementConceptoParte> getEltOpcConceptoPartes() { return maEltOpcConceptoPartes; }
    public cfd.ver33.DElementComplementoConcepto getEltOpcComplementoConcepto() { return moEltOpcComplementoConcepto; }
    
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
                        (moAttValorUnitario.getDouble() + Math.pow(10d, -moAttValorUnitario.getDecimals()) / 2d - Math.pow(10d, -12d)),
                moAttImporte.getDecimals());
        
        if (moAttImporte.getDouble() > limitUpper) {
            throw new IllegalStateException("El valor del atributo '" + moAttImporte.getName() + "' <" + moAttImporte.getDouble() + "> no puede ser mayor que el límite superior permitido <" + limitUpper + ">.");
        }
        
        // validate attribute "Descuento":
        
        if (moAttDescuento.getDouble() > moAttImporte.getDouble()) {
            throw new IllegalStateException("El valor del atributo '" + (moAttDescuento.getName()) + "' <" + moAttDescuento.getDouble() + "> debe ser menor o igual valor del atributo '" + moAttImporte.getName() + "' <" + moAttImporte.getDouble() + ">.");
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
        String string = super.getElementForOriginalString();    // for element attributes and element validation 
        
        for (DElement element : createElementsArray()) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
