package cfd.ver40;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DAttributeTypeImporteUnitario;
import cfd.DCfdMath;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementConcepto extends cfd.DElement {

    private final DAttributeString moAttClaveProdServ;
    private final DAttributeString moAttNoIdentificacion;
    private final DAttributeTypeImporteUnitario moAttCantidad;
    private final DAttributeString moAttClaveUnidad;
    private final DAttributeString moAttUnidad;
    private final DAttributeString moAttDescripcion;
    private final DAttributeTypeImporteUnitario moAttValorUnitario;
    private final DAttributeTypeImporte moAttImporte;
    private final DAttributeTypeImporte moAttDescuento;
    private final DAttributeString moAttObjetoImp;

    private cfd.ver40.DElementConceptoImpuestos moEltOpcConceptoImpuestos;
    private cfd.ver40.DElementConceptoACuentaTerceros moEltOpcConceptoACuentaTerceros;
    private final ArrayList<cfd.ver40.DElementConceptoInformacionAduanera> maEltOpcConceptoInformacionAduaneras;
    private ArrayList<cfd.ver40.DElementConceptoCuentaPredial> maEltOpcConceptoCuentaPredial;
    private cfd.ver40.DElementComplementoConcepto moEltOpcComplementoConcepto;
    private final ArrayList<cfd.ver40.DElementConceptoParte> maEltOpcConceptoPartes;

    public DElementConcepto() {
        super("cfdi:Concepto");

        moAttClaveProdServ = new DAttributeString("ClaveProdServ", true, 6, 8); // c_ClaveProdServ catalog codes of 8 fixed digits, but can be used as well first 6 digits
        moAttNoIdentificacion = new DAttributeString("NoIdentificacion", false, 1, 100); // from 1 to 100 characters
        moAttCantidad = new DAttributeTypeImporteUnitario("Cantidad", true);
        moAttClaveUnidad = new DAttributeString("ClaveUnidad", true, 2, 3); // c_ClaveUnidad catalog codes from 2 to 3 characters
        moAttUnidad = new DAttributeString("Unidad", false, 1, 20); // from 1 to 20 characters
        moAttDescripcion = new DAttributeString("Descripcion", true, 1, 1000); // from 1 to 1000 characters
        moAttValorUnitario = new DAttributeTypeImporteUnitario("ValorUnitario", true);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);
        moAttDescuento = new DAttributeTypeImporte("Descuento", false);
        //moAttDescuento.setCanBeZero(...); // due the attribute is not mandatory, setting that it can be zero is nonsense
        moAttObjetoImp = new DAttributeString("ObjetoImp", true, 2, 2);

        mvAttributes.add(moAttClaveProdServ);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttClaveUnidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);
        mvAttributes.add(moAttDescuento);
        mvAttributes.add(moAttObjetoImp);

        moEltOpcConceptoImpuestos = null;
        moEltOpcConceptoACuentaTerceros = null;
        maEltOpcConceptoInformacionAduaneras = new ArrayList<>();
        maEltOpcConceptoCuentaPredial = new ArrayList<>();
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
        
        if (moEltOpcConceptoACuentaTerceros != null) {
            elements.add(moEltOpcConceptoACuentaTerceros);
        }
        
        if (!maEltOpcConceptoInformacionAduaneras.isEmpty()) {
            elements.addAll(maEltOpcConceptoInformacionAduaneras);
        }
        
        if (maEltOpcConceptoCuentaPredial != null) {
            elements.addAll(maEltOpcConceptoCuentaPredial);
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

    public void setEltOpcConceptoImpuestos(cfd.ver40.DElementConceptoImpuestos o) { moEltOpcConceptoImpuestos = o; }
    public void setEltOpcConceptoACuentaTerceros(cfd.ver40.DElementConceptoACuentaTerceros o) { moEltOpcConceptoACuentaTerceros = o; }
    public void setEltOpcConceptoCuentaPredial(ArrayList<cfd.ver40.DElementConceptoCuentaPredial> o) { maEltOpcConceptoCuentaPredial = o; }
    public void setEltOpcComplementoConcepto(cfd.ver40.DElementComplementoConcepto o) { moEltOpcComplementoConcepto = o; }

    public cfd.DAttributeString getAttClaveProdServ() { return moAttClaveProdServ; }
    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttClaveUnidad() { return moAttClaveUnidad; }
    public cfd.DAttributeString getAttUnidad() { return moAttUnidad; }
    public cfd.DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporteUnitario getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }
    public cfd.DAttributeString getAttObjetoImp() { return moAttObjetoImp; }

    public cfd.ver40.DElementConceptoImpuestos getEltOpcConceptoImpuestos() { return moEltOpcConceptoImpuestos; }
    public cfd.ver40.DElementConceptoACuentaTerceros getEltOpcACuentaTerceros() { return moEltOpcConceptoACuentaTerceros; }
    public ArrayList<cfd.ver40.DElementConceptoInformacionAduanera> getEltOpcConceptoInformacionAduaneras() { return maEltOpcConceptoInformacionAduaneras; }
    public ArrayList<cfd.ver40.DElementConceptoCuentaPredial> getEltOpcConceptoCuentaPredial() { return maEltOpcConceptoCuentaPredial; }
    public ArrayList<cfd.ver40.DElementConceptoParte> getEltOpcConceptoPartes() { return maEltOpcConceptoPartes; }
    public cfd.ver40.DElementComplementoConcepto getEltOpcComplementoConcepto() { return moEltOpcComplementoConcepto; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
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
        
        if (!moAttNoIdentificacion.getString().isEmpty() && !DCfdi40Utils.matches(moAttNoIdentificacion.getString(), DCfdi40Consts.REGEX_DESCRIP + "{" + moAttNoIdentificacion.getLengthMin() + "," + moAttNoIdentificacion.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNoIdentificacion.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!moAttUnidad.getString().isEmpty() && !DCfdi40Utils.matches(moAttUnidad.getString(), DCfdi40Consts.REGEX_DESCRIP + "{" + moAttUnidad.getLengthMin() + "," + moAttUnidad.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttUnidad.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!DCfdi40Utils.matches(moAttDescripcion.getString(), DCfdi40Consts.REGEX_DESCRIP + "{" + moAttDescripcion.getLengthMin() + "," + moAttDescripcion.getLengthMax()+ "}")) {
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
        String string = super.getElementForOriginalString(); // for element attributes and element validation
        
        for (DElement element : createElementsArray()) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
