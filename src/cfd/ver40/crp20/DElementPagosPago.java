package cfd.ver40.crp20;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.ArrayList;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementPagosPago extends cfd.DElement implements DIntPagosPago {

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
    
    private final ArrayList<DElementDoctoRelacionado> maEltDoctoRelacionados;
    private DElementImpuestosP moEltImpuestosP;
    
    /**
     * Creates a new instance of class DElementPagosPago.
     */
    public DElementPagosPago() {
        super("pago20:Pago");

        moAttFechaPago = new DAttributeDatetime("FechaPago", true);
        moAttFormaDePagoP = new DAttributeString("FormaDePagoP", true, 2, 2);   // c_FormaPago catalog codes of 2 fixed digits
        moAttMonedaP = new DAttributeString("MonedaP", true, 3, 3);     // c_Moneda catalog codes of 3 fixed digits
        moAttTipoCambioP = new DAttributeTipoCambio("TipoCambioP", false);
        moAttMonto = new DAttributeTypeImporte("Monto", true);
        moAttNumOperacion = new DAttributeString("NumOperacion", false, 1, 100);
        moAttRfcEmisorCtaOrd = new DAttributeString("RfcEmisorCtaOrd", false, 12, 13);
        moAttNomBancoOrdExt = new DAttributeString("NomBancoOrdExt", false, 1, 300);
        moAttCtaOrdenante = new DAttributeString("CtaOrdenante", false, 10, 50);
        moAttRfcEmisorCtaBen = new DAttributeString("RfcEmisorCtaBen", false, 12, 12);
        moAttCtaBeneficiario = new DAttributeString("CtaBeneficiario", false, 10, 50);
        moAttTipoCadPago = new DAttributeString("TipoCadPago", false, 2, 2);
        moAttCertPago = new DAttributeString("CertPago", false, 1);     // xs:base64Binary
        moAttCadPago = new DAttributeString("CadPago", false, 1, 8192);
        moAttSelloPago = new DAttributeString("SelloPago", false, 1);   // xs:base64Binary

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
        moEltImpuestosP = null;
    }
    
    /*
     * Private methods:
     */
    
    private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        if (moEltImpuestosP != null) {
            elements.add(moEltImpuestosP);
        }
        
        return elements;
     }
    
    /*
     * Public methods:
     */

    public void setEltImpuestosP(DElementImpuestosP o) { moEltImpuestosP = o; }
    
    @Override
    public DAttributeDatetime getAttFechaPago() { return moAttFechaPago; }
    @Override
    public DAttributeString getAttFormaDePagoP() { return moAttFormaDePagoP; }
    @Override
    public DAttributeString getAttMonedaP() { return moAttMonedaP; }
    @Override
    public DAttributeTipoCambio getAttTipoCambioP() { return moAttTipoCambioP; }
    @Override
    public DAttributeTypeImporte getAttMonto() { return moAttMonto; }
    @Override
    public DAttributeString getAttNumOperacion() { return moAttNumOperacion; }
    @Override
    public DAttributeString getAttRfcEmisorCtaOrd() { return moAttRfcEmisorCtaOrd; }
    @Override
    public DAttributeString getAttNomBancoOrdExt() { return moAttNomBancoOrdExt; }
    @Override
    public DAttributeString getAttCtaOrdenante() { return moAttCtaOrdenante; }
    @Override
    public DAttributeString getAttRfcEmisorCtaBen() { return moAttRfcEmisorCtaBen; }
    @Override
    public DAttributeString getAttCtaBeneficiario() { return moAttCtaBeneficiario; }
    @Override
    public DAttributeString getAttTipoCadPago() { return moAttTipoCadPago; }
    @Override
    public DAttributeString getAttCertPago() { return moAttCertPago; }
    @Override
    public DAttributeString getAttCadPago() { return moAttCadPago; }
    @Override
    public DAttributeString getAttSelloPago() { return moAttSelloPago; }

    public ArrayList<DElementDoctoRelacionado> getEltDoctoRelacionados() { return maEltDoctoRelacionados; }
    public DElementImpuestosP getEltImpuestosP() { return moEltImpuestosP; }
    
    public void computePago() {
        moEltImpuestosP = null;
        
        for (DElementDoctoRelacionado doctoRelacionado : maEltDoctoRelacionados) {
            if (doctoRelacionado.getEltImpuestosDR() != null) {
                double equivalenciaDR;
                
                if (doctoRelacionado.getAttMonedaDR().getString().equals(moAttMonedaP.getString())) {
                    equivalenciaDR = 1;
                }
                else {
                    equivalenciaDR = doctoRelacionado.getAttEquivalenciaDR().getDouble();
                }
                
                if (moEltImpuestosP == null) {
                    moEltImpuestosP = new DElementImpuestosP();
                }
                
                if (doctoRelacionado.getEltImpuestosDR().getEltTrasladosDR() != null) {
                    if (moEltImpuestosP.getEltTrasladosP() == null) {
                        moEltImpuestosP.setEltTrasladosP(new DElementTrasladosP());
                    }
                    
                    for (DElementTrasladoDR trasladoDR : doctoRelacionado.getEltImpuestosDR().getEltTrasladosDR().getEltTrasladoDRs()) {
                        trasladoDR.computeImporteDR();
                        
                        DElementTrasladoP trasladoP = moEltImpuestosP.getEltTrasladosP().getEltTrasladoP(
                                trasladoDR.getAttImpuestoDR().getString(), 
                                trasladoDR.getAttTipoFactorDR().getString(), 
                                trasladoDR.getAttTasaOCuotaDR().getDouble());
                        
                        if (trasladoP == null) {
                            trasladoP = new DElementTrasladoP();
                            trasladoP.getAttImpuestoP().setString(trasladoDR.getAttImpuestoDR().getString());
                            trasladoP.getAttTipoFactorP().setString(trasladoDR.getAttTipoFactorDR().getString());
                            trasladoP.getAttTasaOCuotaP().setDouble(trasladoDR.getAttTasaOCuotaDR().getDouble());
                            
                            moEltImpuestosP.getEltTrasladosP().getEltTrasladoPs().add(trasladoP);
                        }
                        
                        trasladoP.addBaseImporteP(SLibUtils.roundAmount(trasladoDR.getAttBaseDR().getDouble() / equivalenciaDR), SLibUtils.roundAmount(trasladoDR.getAttImporteDR().getDouble() / equivalenciaDR));
                    }
                }
                
                if (doctoRelacionado.getEltImpuestosDR().getEltRetencionesDR() != null) {
                    if (moEltImpuestosP.getEltRetencionesP() == null) {
                        moEltImpuestosP.setEltRetencionesP(new DElementRetencionesP());
                    }
                    
                    for (DElementRetencionDR retencionDR : doctoRelacionado.getEltImpuestosDR().getEltRetencionesDR().getEltRetencionDRs()) {
                        retencionDR.computeImporteDR();
                        
                        DElementRetencionP retencionP = moEltImpuestosP.getEltRetencionesP().getEltRetencionP(
                                retencionDR.getAttImpuestoDR().getString());
                        
                        if (retencionP == null) {
                            retencionP = new DElementRetencionP();
                            retencionP.getAttImpuestoP().setString(retencionDR.getAttImpuestoDR().getString());
                            
                            moEltImpuestosP.getEltRetencionesP().getEltRetencionPs().add(retencionP);
                        }
                        
                        retencionP.addImporteP(SLibUtils.roundAmount(retencionDR.getAttImporteDR().getDouble() / equivalenciaDR));
                    }
                }
            }
        }
    }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
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
        
        for (DElementDoctoRelacionado element : maEltDoctoRelacionados) {
            string += element.getElementForOriginalString();
        }
        
        for (DElement element : createElementsArray()) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
