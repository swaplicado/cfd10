package cfd.ver33.crp10;

import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio6d;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import cfd.ver33.DCfdi33Consts;
import cfd.ver33.DCfdi33Utils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementDoctoRelacionado extends cfd.DElement {

    /*
     * Attributes' declaration-order according to CRP 1.0 specification
     */
    
    private final DAttributeString moAttIdDocumento;
    private final DAttributeString moAttSerie;
    private final DAttributeString moAttFolio;
    private final DAttributeString moAttMonedaDR;
    private final DAttributeTipoCambio6d moAttTipoCambioDR;
    private final DAttributeString moAttMetodoDePagoDR;
    private final DAttributeInteger moAttNumParcialidad;
    private final DAttributeTypeImporte moAttImpSaldoAnt;
    private final DAttributeTypeImporte moAttImpPagado;
    private final DAttributeTypeImporte moAttImpSaldoInsoluto;

    /**
     * Creates a new instance of class DElementDoctoRelacionado.
     */
    public DElementDoctoRelacionado() {
        super("pago10:DoctoRelacionado");

        moAttIdDocumento = new DAttributeString("IdDocumento", true, 16, 36);   // text from 16 to 36 characters
        moAttSerie = new DAttributeString("Serie", false, 1, 25);       // text from 1 to 25 characters
        moAttFolio = new DAttributeString("Folio", false, 1, 40);       // text from 1 to 40 characters
        moAttMonedaDR = new DAttributeString("MonedaDR", true, 3, 3);   // c_Moneda catalog codes of 3 fixed digits
        moAttTipoCambioDR = new DAttributeTipoCambio6d("TipoCambioDR", false);
        moAttMetodoDePagoDR = new DAttributeString("MetodoDePagoDR", true, 3, 3);   // c_MetodoPago catalog codes of 3 fixed digits
        moAttNumParcialidad = new DAttributeInteger("NumParcialidad", true);
        moAttImpSaldoAnt = new DAttributeTypeImporte("ImpSaldoAnt", true);
        moAttImpPagado = new DAttributeTypeImporte("ImpPagado", false);
        moAttImpSaldoInsoluto = new DAttributeTypeImporte("ImpSaldoInsoluto", false);
        moAttImpSaldoInsoluto.setCanBeZero(true);

        mvAttributes.add(moAttIdDocumento);
        mvAttributes.add(moAttSerie);
        mvAttributes.add(moAttFolio);
        mvAttributes.add(moAttMonedaDR);
        mvAttributes.add(moAttTipoCambioDR);
        mvAttributes.add(moAttMetodoDePagoDR);
        mvAttributes.add(moAttNumParcialidad);
        mvAttributes.add(moAttImpSaldoAnt);
        mvAttributes.add(moAttImpPagado);
        mvAttributes.add(moAttImpSaldoInsoluto);
    }
    
    /*
     * Private methods:
     */
    
    /*
     * Public methods:
     */

    public DAttributeString getAttIdDocumento() { return moAttIdDocumento; }
    public DAttributeString getAttSerie() { return moAttSerie; }
    public DAttributeString getAttFolio() { return moAttFolio; }
    public DAttributeString getAttMonedaDR() { return moAttMonedaDR; }
    public DAttributeTipoCambio6d getAttTipoCambioDR() { return moAttTipoCambioDR; }
    public DAttributeString getAttMetodoDePagoDR() { return moAttMetodoDePagoDR; }
    public DAttributeInteger getAttNumParcialidad() { return moAttNumParcialidad; }
    public DAttributeTypeImporte getAttImpSaldoAnt() { return moAttImpSaldoAnt; }
    public DAttributeTypeImporte getAttImpPagado() { return moAttImpPagado; }
    public DAttributeTypeImporte getAttImpSaldoInsoluto() { return moAttImpSaldoInsoluto; }

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
}
