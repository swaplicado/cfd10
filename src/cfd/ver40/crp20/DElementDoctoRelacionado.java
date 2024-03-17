package cfd.ver40.crp20;

import cfd.DAttribute;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio6d;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import cfd.ver33.DCfdi33Consts;
import cfd.ver33.DCfdi33Utils;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementDoctoRelacionado extends cfd.DElement implements DIntDoctoRelacionado {

    /*
     * Attributes' declaration-order according to CRP 2.0 specification
     */
    
    private final DAttributeString moAttIdDocumento;
    private final DAttributeString moAttSerie;
    private final DAttributeString moAttFolio;
    private final DAttributeString moAttMonedaDR;
    private final DAttributeTipoCambio6d moAttEquivalenciaDR;
    private final DAttributeInteger moAttNumParcialidad;
    private final DAttributeTypeImporte moAttImpSaldoAnt;
    private final DAttributeTypeImporte moAttImpPagado;
    private final DAttributeTypeImporte moAttImpSaldoInsoluto;
    private final DAttributeString moAttObjetoImpDR;
    
    private DElementImpuestosDR moEltImpuestosDR;

    /**
     * Creates a new instance of class DElementDoctoRelacionado.
     */
    public DElementDoctoRelacionado() {
        super("pago20:DoctoRelacionado");

        moAttIdDocumento = new DAttributeString("IdDocumento", true, 16, 36);   // text from 16 to 36 characters
        moAttSerie = new DAttributeString("Serie", false, 1, 25);       // text from 1 to 25 characters
        moAttFolio = new DAttributeString("Folio", false, 1, 40);       // text from 1 to 40 characters
        moAttMonedaDR = new DAttributeString("MonedaDR", true, 3, 3);   // c_Moneda catalog codes of 3 fixed digits
        moAttEquivalenciaDR = new DAttributeTipoCambio6d("EquivalenciaDR", false);
        moAttNumParcialidad = new DAttributeInteger("NumParcialidad", true);
        moAttImpSaldoAnt = new DAttributeTypeImporte("ImpSaldoAnt", true);
        moAttImpPagado = new DAttributeTypeImporte("ImpPagado", true);
        moAttImpSaldoInsoluto = new DAttributeTypeImporte("ImpSaldoInsoluto", true);
        moAttImpSaldoInsoluto.setCanBeZero(true);
        moAttObjetoImpDR = new DAttributeString("ObjetoImpDR", true, 2, 2);   // c_ObjetoImp catalog codes of 2 fixed digits

        mvAttributes.add(moAttIdDocumento);
        mvAttributes.add(moAttSerie);
        mvAttributes.add(moAttFolio);
        mvAttributes.add(moAttMonedaDR);
        mvAttributes.add(moAttEquivalenciaDR);
        mvAttributes.add(moAttNumParcialidad);
        mvAttributes.add(moAttImpSaldoAnt);
        mvAttributes.add(moAttImpPagado);
        mvAttributes.add(moAttImpSaldoInsoluto);
        mvAttributes.add(moAttObjetoImpDR);
        
        moEltImpuestosDR = null;
    }
    
    /*
     * Private methods:
     */
    
     private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltImpuestosDR != null) {
            elements.add(moEltImpuestosDR);
        }
        
        return elements;
     }
    
    /*
     * Public methods:
     */

    public void setEltImpuestosDR(DElementImpuestosDR o) { moEltImpuestosDR = o; }
     
    @Override
    public DAttributeString getAttIdDocumento() { return moAttIdDocumento; }
    @Override
    public DAttributeString getAttSerie() { return moAttSerie; }
    @Override
    public DAttributeString getAttFolio() { return moAttFolio; }
    @Override
    public DAttributeString getAttMonedaDR() { return moAttMonedaDR; }
    @Override
    public DAttributeTipoCambio6d getAttEquivalenciaDR() { return moAttEquivalenciaDR; }
    @Override
    public DAttributeInteger getAttNumParcialidad() { return moAttNumParcialidad; }
    @Override
    public DAttributeTypeImporte getAttImpSaldoAnt() { return moAttImpSaldoAnt; }
    @Override
    public DAttributeTypeImporte getAttImpPagado() { return moAttImpPagado; }
    @Override
    public DAttributeTypeImporte getAttImpSaldoInsoluto() { return moAttImpSaldoInsoluto; }
    @Override
    public DAttributeString getAttObjetoImpDR() { return moAttObjetoImpDR; }
    
    public DElementImpuestosDR getEltImpuestosDR() { return moEltImpuestosDR; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate text conformity to requiered regular expressions:
        
        if (!moAttSerie.getString().isEmpty() && !DCfdi33Utils.matches(moAttSerie.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttSerie.getLengthMin() + "," + moAttSerie.getLengthMax()+ "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttSerie.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
        
        if (!moAttFolio.getString().isEmpty() && !DCfdi33Utils.matches(moAttFolio.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttFolio.getLengthMin() + "," + moAttFolio.getLengthMax() + "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttFolio.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
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
