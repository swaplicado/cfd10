/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver33;

import java.util.HashMap;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCfdi33Catalogs {
    
    public static final int CAT_CFDI_TP = 1;        // tipo CFDI
    public static final int CAT_CFDI_USO = 2;       // uso CFDI
    public static final int CAT_REG_FISC = 3;       // régimen fiscal
    public static final int CAT_MDP = 4;            // método de pago
    public static final int CAT_FDP = 5;            // forma de pago
    public static final int CAT_MON = 6;            // moneda
    public static final int CAT_PAIS = 7;           // país
    public static final int CAT_IMP = 8;            // impuesto
    public static final int CAT_FAC_TP = 9;         // tipo factor
    public static final int CAT_REL_TP = 10;        // tipo relación
    public static final int CAT_CVE_UNID = 11;      // clave unidad
    public static final int CAT_CVE_PROD_SERV = 12; // clave producto o servicio
    
    public static final String XML_CFDI_USO = "c_UsoCFDI";
    public static final String XML_MDP = "c_MetodoPago";
    public static final String XML_FDP = "c_FormaPago";
    public static final String XML_MON = "c_Moneda";
    public static final String XML_REL_TP = "c_TipoRelacion";
    public static final String XML_CVE_UNID = "c_ClaveUnidad";
    public static final String XML_CVE_PROD_SERV = "c_ClaveProdServ";
    
    public static final String CFD_TP_I = "I";      // Ingreso
    public static final String CFD_TP_E = "E";      // Egreso
    public static final String CFD_TP_T = "T";      // Traslado
    public static final String CFD_TP_N = "N";      // Nómina
    public static final String CFD_TP_P = "P";      // Pago
    
    public static final String CFDI_USO_POR_DEF = "P01"; // Por definir
    
    public static final int MDP_PUE_ID = 1;         // ID pago en una sola exhibición
    public static final int MDP_PPD_ID = 2;         // ID pago en parcialidades o diferido
    
    public static final String MDP_PUE = "PUE";     // Pago en una sola exhibición
    public static final String MDP_PPD = "PPD";     // Pago en parcialidades o diferido
    
    public static final String FDP_EFECTIVO = "01";
    public static final String FDP_CHEQUE = "02";
    public static final String FDP_COMPENSACION = "17";
    public static final String FDP_POR_DEF = "99";      // Por definir
    
    public static final String IMP_ISR = "001";     // ISR
    public static final String IMP_IVA = "002";     // IVA
    public static final String IMP_IEPS = "003";    // IEPS
    
    public static final String FAC_TP_TASA = "Tasa";
    public static final String FAC_TP_CUOTA = "Cuota";
    public static final String FAC_TP_EXENTO = "Exento";
    
    public static final String TxtSí = "Sí";
    public static final String TxtNo = "No";
    
    public static final String ClaveMonedaMxn = "MXN";
    public static final String ClaveMonedaXxx = "XXX";
    
    public static final String ClaveProdServServsSueldosSalarios = "84111505";
    public static final String ClaveProdServServsFacturacion = "84111506";
    
    public static final String ClaveUnidadAct = "ACT";
    
    public static final String ClaveTipoRelaciónNotaCrédito = "01";
    public static final String ClaveTipoRelaciónNotaDébito = "02";
    public static final String ClaveTipoRelaciónDevolución = "03";
    public static final String ClaveTipoRelaciónSustitución = "04";

    public static final String ConceptoPago = "Pago";
    public static final String ConceptoSueldosSalarios = "Pago de nómina";
    
    public static final String DescripcionImpuestoTrasladado = "Trasladado";
    public static final String DescripcionImpuestoRetenido = "Retenido";
    
    public static final String ClaveNominaOrd = "O";
    public static final String ClaveNominaExt = "E";
    public static final String ClavePeriodicidadPagoSem = "02";
    public static final String ClavePeriodicidadPagoQna = "04";
    public static final String ClavePeriodicidadPagoOtra = "99";
    public static final String ClaveTipoContratoModalidadTrabajoComision = "08";
    public static final String ClaveTipoRegimenSueldos = "02";
    public static final String ClaveTipoRegimenJubilados = "03";
    public static final String ClaveTipoRegimenPensionados = "04";
    public static final String ClaveTipoRegimenJubiladosOPensionados = "12";
    public static final String ClaveTipoOtroPagoSubsidioEmpleo = "002";
    
    public static final String ClaveChofer = "01";
    public static final String ClavePropietario = "02";
    public static final String ClaveArrendador = "03";
    public static final String ClaveNotificado = "04";
    
    public static final String PrefijoClaveOrigen = "OR";
    public static final String PrefijoClaveDestino = "DE";
    
    public static final double DIAS_PAG_MIN = 0.001;
    
    public static final HashMap<String, String> TipoComprobante = new HashMap<>();
    public static final HashMap<String, String> Impuesto = new HashMap<>();
    
    static {
        TipoComprobante.put(CFD_TP_I, "Ingreso");
        TipoComprobante.put(CFD_TP_E, "Egreso");
        TipoComprobante.put(CFD_TP_T, "Traslado");
        TipoComprobante.put(CFD_TP_N, "Nómina");
        TipoComprobante.put(CFD_TP_P, "Pago");
        
        Impuesto.put(IMP_ISR, "ISR");
        Impuesto.put(IMP_IVA, "IVA");
        Impuesto.put(IMP_IEPS, "IEPS");
    }
}
