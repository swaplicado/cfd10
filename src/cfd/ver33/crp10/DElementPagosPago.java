package cfd.ver33.crp10;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPagosPago extends cfd.DElement {

    /*
     * Attributes' declaration-order according to CRP 1.0 specification
     */
    
    private final DAttributeDatetime moAttFechaPago;
    private final DAttributeString moAttFormaDePagoP;
    private final DAttributeString moAttMonedaP;
    private final DAttributeTipoCambio moAttTipoCambioP;
    private final DAttributeTypeImporte moAttMonto;
    private final DAttributeString moAttNumOperacion;
    private final DAttributeString moAttRfcEmisorCtaOrd;
    private final DAttributeString moAttNomBancoOrdExt;
    private final DAttributeString moAttCtaOrdenante;
    private final DAttributeString moAttRfcEmisorCtaBen;
    private final DAttributeString moAttCtaBeneficiario;
    private final DAttributeString moAttTipoCadPago;
    private final DAttributeString moAttCertPago;
    private final DAttributeString moAttCadPago;
    private final DAttributeString moAttSelloPago;
    
    private ArrayList<DElementDoctoRelacionado> maEltDoctoRelacionados;
    
    /**
     * Creates a new instance of class DElementPagosPago.
     */
    public DElementPagosPago() {
        super("pago10:Pago");

        moAttFechaPago = new DAttributeDatetime("FechaPago", true);
        moAttFormaDePagoP = new DAttributeString("FormaDePagoP", true, 2, 2);   // c_FormaPago catalog codes of 2 fixed digits
        moAttMonedaP = new DAttributeString("MonedaP", true, 3, 3);     // c_Moneda catalog codes of 3 fixed digits
        moAttTipoCambioP = new DAttributeTipoCambio("TipoCambioP", false);
        moAttMonto = new DAttributeTypeImporte("Monto", true);
        moAttNumOperacion = new DAttributeString("NumOperacion", false, 1);
        moAttRfcEmisorCtaOrd = new DAttributeString("RfcEmisorCtaOrd", false, 12, 13);
        moAttNomBancoOrdExt = new DAttributeString("NomBancoOrdExt", false, 1, 300);
        moAttCtaOrdenante = new DAttributeString("CtaOrdenante", false, 10, 50);
        moAttRfcEmisorCtaBen = new DAttributeString("RfcEmisorCtaBen", false, 13, 13);
        moAttCtaBeneficiario = new DAttributeString("CtaBeneficiario", false, 10, 50);
        moAttTipoCadPago = new DAttributeString("TipoCadPago", false, 2, 2);
        moAttCertPago = new DAttributeString("CertPago", false, 1);
        moAttCadPago = new DAttributeString("CadPago", false, 1);
        moAttSelloPago = new DAttributeString("SelloPago", false, 1);

        mvAttributes.add(moAttFechaPago);
        mvAttributes.add(moAttFormaDePagoP);
        mvAttributes.add(moAttMonedaP);
        mvAttributes.add(moAttTipoCambioP);
        mvAttributes.add(moAttMonto);
        mvAttributes.add(moAttNumOperacion);
        mvAttributes.add(moAttRfcEmisorCtaOrd);
        mvAttributes.add(moAttNomBancoOrdExt);
        mvAttributes.add(moAttCtaOrdenante);
        mvAttributes.add(moAttRfcEmisorCtaBen);
        mvAttributes.add(moAttCtaBeneficiario);
        mvAttributes.add(moAttTipoCadPago);
        mvAttributes.add(moAttCertPago);
        mvAttributes.add(moAttCadPago);
        mvAttributes.add(moAttSelloPago);
        
        maEltDoctoRelacionados = new ArrayList<>();
    }
    
    /*
     * Private methods:
     */
    
    /*
     * Public methods:
     */

    public DAttributeDatetime getAttFechaPago() { return moAttFechaPago; }
    public DAttributeString getAttFormaDePagoP() { return moAttFormaDePagoP; }
    public DAttributeString getAttMonedaP() { return moAttMonedaP; }
    public DAttributeTipoCambio getAttTipoCambioP() { return moAttTipoCambioP; }
    public DAttributeTypeImporte getAttMonto() { return moAttMonto; }
    public DAttributeString getAttNumOperacion() { return moAttNumOperacion; }
    public DAttributeString getAttRfcEmisorCtaOrd() { return moAttRfcEmisorCtaOrd; }
    public DAttributeString getAttNomBancoOrdExt() { return moAttNomBancoOrdExt; }
    public DAttributeString getAttCtaOrdenante() { return moAttCtaOrdenante; }
    public DAttributeString getAttRfcEmisorCtaBen() { return moAttRfcEmisorCtaBen; }
    public DAttributeString getAttCtaBeneficiario() { return moAttCtaBeneficiario; }
    public DAttributeString getAttTipoCadPago() { return moAttTipoCadPago; }
    public DAttributeString getAttCertPago() { return moAttCertPago; }
    public DAttributeString getAttCadPago() { return moAttCadPago; }
    public DAttributeString getAttSelloPago() { return moAttSelloPago; }

    public ArrayList<DElementDoctoRelacionado> getEltDoctoRelacionados() { return maEltDoctoRelacionados; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        // validate required elements:
        
        if (maEltDoctoRelacionados.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + (this.getName()) + "'" + DElement.ERR_MSG_NODE_NO_CHILD);
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

        for (DElementDoctoRelacionado element : maEltDoctoRelacionados) {
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
        
        for (DElementDoctoRelacionado element : maEltDoctoRelacionados) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
