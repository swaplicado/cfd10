package cfd.ver40.crp20;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DCfdConsts;
import cfd.DElement;
import cfd.ver40.DCfdi40Catalogs;
import cfd.ver40.DCfdi40Consts;
import java.util.ArrayList;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel Danae García Servín
 */
public class DElementPagos extends cfd.DElement {

    public static final String XSI = "http://www.sat.gob.mx/Pagos20 http://www.sat.gob.mx/sitio_internet/cfd/Pagos/Pagos20.xsd";
    public static final String XMLNS = "xmlns:pago20=\"http://www.sat.gob.mx/Pagos20\"";
    
    /*
     * Attributes' declaration-order according to CRP 2.0 specification
     */
    
    private final DAttributeString moAttVersion;
    
    private final DElementTotales moEltTotales;
    private final ArrayList<DElementPagosPago> maEltPagos;

    /**
     * Creates a new instance of class DElementPagos.
     */
    public DElementPagos() {
        super("pago20:Pagos");

        moAttVersion = new DAttributeString("Version", true, 3, 3); // fixed text value "1.0"
        moAttVersion.setString("" + DCfdConsts.COMP_RP_20);

        mvAttributes.add(moAttVersion);

        moEltTotales = new DElementTotales();
        maEltPagos = new ArrayList<>();
    }
    
    /*
     * Private methods:
     */
    
     private ArrayList<DElement> createElementsArray() {
        ArrayList<DElement> elements = new ArrayList<>();

        elements.add(moEltTotales);
        
        return elements;
     }
    
    /*
     * Public methods:
     */

    public float getVersion() { return DCfdConsts.COMP_RP_20; }

    public DAttributeString getAttVersion() { return moAttVersion; }
    
    public DElementTotales getEltTotales() { return moEltTotales; }
    public ArrayList<DElementPagosPago> getEltPagos() { return maEltPagos; }
    
    public void computePagos() {
        moEltTotales.clearTotales();
        
        for (DElementPagosPago pago : maEltPagos) {
            pago.computePago();
            
            if (pago.getAttMonedaP().getString().equals(DCfdi40Catalogs.ClaveMonedaMxn)) {
                pago.getAttTipoCambioP().setDouble(1);
                pago.getAttTipoCambioP().setDecimals(0);
            }
            else {
                pago.getAttTipoCambioP().setDecimals(cfd.DAttributeTipoCambio.DECS);
            }
            
            double tipoCambio = pago.getAttTipoCambioP().getDouble();
            
            for (DElementDoctoRelacionado doctoRelacionado : pago.getEltDoctoRelacionados()) {
                if (doctoRelacionado.getAttMonedaDR().getString().equals(pago.getAttMonedaP().getString())) {
                    doctoRelacionado.getAttEquivalenciaDR().setDouble(1);
                    doctoRelacionado.getAttEquivalenciaDR().setDecimals(0);
                }
                else {
                    doctoRelacionado.getAttEquivalenciaDR().setDecimals(cfd.DAttributeTipoCambio.DECS);
                }
            }
            
            double monto = SLibUtils.roundAmount(pago.getAttMonto().getDouble() * tipoCambio);
            
            moEltTotales.addAttMontoTotalPagos(monto);
            
            if (pago.getEltImpuestosP() != null) {
                if (pago.getEltImpuestosP().getEltTrasladosP() != null) {
                    for (DElementTrasladoP trasladoP : pago.getEltImpuestosP().getEltTrasladosP().getEltTrasladoPs()) {
                        if (trasladoP.getAttImpuestoP().getString().equals(DCfdi40Catalogs.IMP_IVA)) {
                            double base = SLibUtils.roundAmount(trasladoP.getAttBaseP().getDouble() * tipoCambio);
                            double importe = SLibUtils.roundAmount(trasladoP.getAttImporteP().getDouble() * tipoCambio);
                            
                            switch (trasladoP.getAttTipoFactorP().getString()) {
                                case DCfdi40Catalogs.FAC_TP_TASA:
                                    if ((int) (trasladoP.getAttTasaOCuotaP().getDouble() * 100) == (int) (DCfdi40Consts.IVA_16 * 100)) {
                                        moEltTotales.addAttTotalTrasladosBaseIVA16(base);
                                        moEltTotales.addAttTotalTrasladosImpuestoIVA16(importe);
                                    }
                                    else if ((int) (trasladoP.getAttTasaOCuotaP().getDouble() * 100) == (int) (DCfdi40Consts.IVA_08 * 100)) {
                                        moEltTotales.addAttTotalTrasladosBaseIVA8(base);
                                        moEltTotales.addAttTotalTrasladosImpuestoIVA8(importe);
                                    }
                                    else if ((int) (trasladoP.getAttTasaOCuotaP().getDouble() * 100) == (int) (DCfdi40Consts.IVA_00 * 100)) {
                                        moEltTotales.addAttTotalTrasladosBaseIVA0(base);
                                        moEltTotales.addAttTotalTrasladosImpuestoIVA0(importe);
                                        moEltTotales.getAttTotalTrasladosImpuestoIVA0().setCanBeZero(true);
                                    }
                                    break;
                                    
                                case DCfdi40Catalogs.FAC_TP_CUOTA:
                                    // nothing
                                    break;
                                    
                                case DCfdi40Catalogs.FAC_TP_EXENTO:
                                    moEltTotales.addAttTotalTrasladosBaseIVAExento(base);
                                    break;
                                    
                                default:
                                    // nothing
                            }
                        }
                    }
                }
                
                if (pago.getEltImpuestosP().getEltRetencionesP() != null) {
                    for (DElementRetencionP retencionP : pago.getEltImpuestosP().getEltRetencionesP().getEltRetencionPs()) {
                        double retencion = SLibUtils.roundAmount(retencionP.getAttImporteP().getDouble() * tipoCambio);
                        
                        switch (retencionP.getAttImpuestoP().getString()) {
                            case DCfdi40Catalogs.IMP_IVA:
                                moEltTotales.addAttTotalRetencionesIVA(retencion);
                                break;
                                
                            case DCfdi40Catalogs.IMP_ISR:
                                moEltTotales.addAttTotalRetencionesISR(retencion);
                                break;
                                
                            case DCfdi40Catalogs.IMP_IEPS:
                                moEltTotales.addAttTotalRetencionesIEPS(retencion);
                                break;
                                
                            default:
                                // nothing
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate child elements:
        
        if (maEltPagos.isEmpty()) {
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
        
        for (DElement element : createElementsArray()) {
            String aux = element.getElementForXml();
            if (!aux.isEmpty()) {
                xml += "\n" + aux;
            }
        }

        for (DElementPagosPago element : maEltPagos) {
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
        
        for (DElementPagosPago element : maEltPagos) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
