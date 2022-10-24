/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40;

import java.util.HashMap;

/**
 *
 * @author Sergio Flores, Isabel Servín
 */
public abstract class DCfdi40Catalogs {
    
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
    public static final int CAT_EXP = 16;           // exportación
    public static final int CAT_GBL_PER = 17;       // global periodicidad
    public static final int CAT_GBL_MES = 18;       // global meses
    public static final int CAT_OBJ_IMP = 21;       // objeto impuesto
    
    public static final String XML_CFDI_USO = "c_UsoCFDI";
    public static final String XML_MDP = "c_MetodoPago";
    public static final String XML_FDP = "c_FormaPago";
    public static final String XML_MON = "c_Moneda";
    public static final String XML_REL_TP = "c_TipoRelacion";
    public static final String XML_CVE_UNID = "c_ClaveUnidad";
    public static final String XML_CVE_PROD_SERV = "c_ClaveProdServ";
    public static final String XML_EXP = "c_Exportacion";
    public static final String XML_GBL_PER = "c_Periodicidad";
    public static final String XML_GBL_MES = "c_Meses";
    public static final String XML_OBJ_IMP = "c_ObjetoImp";
    public static final String XML_CCP_MAT_PEL = "c_CartaPorte_MaterialPeligroso";
    public static final String XML_CCP_EMB_TP = "c_CartaPorte_TipoEmbalaje";
    public static final String XML_CCP_PERM_TP = "c_CartaPorte_TipoPermiso";
    public static final String XML_CCP_CFG_AUTO = "c_CartaPorte_ConfigAutotransporte";
    public static final String XML_CCP_REM_STP = "c_CartaPorte_SubTipoRem";
    public static final String XML_CCP_EDO_33 = "c_CFDI_Estado_33";
    public static final String XML_CCP_EDO_40 = "c_CFDI_Estado_44";
    public static final String XML_CCP_MUN = "c_CartaPorte_Municipio";
    public static final String XML_CCP_LOC = "c_CartaPorte_Localidad";
    public static final String XML_CCP_COL = "c_CartaPorte_Colonia";

    public static final String CFD_TP_I = "I";      // Ingreso
    public static final String CFD_TP_E = "E";      // Egreso
    public static final String CFD_TP_T = "T";      // Traslado
    public static final String CFD_TP_N = "N";      // Nómina
    public static final String CFD_TP_P = "P";      // Pago
    
    public static final String MDP_PUE = "PUE";     // Pago en una sola exhibición
    public static final String MDP_PPD = "PPD";     // Pago en parcialidades o diferido
    
    public static final String FDP_EFECTIVO = "01";
    public static final String FDP_CHEQUE = "02";
    public static final String FDP_COMPENSACION = "17";
    public static final String FDP_POR_DEF = "99";      // Por definir
    
    public static final String IMP_ISR = "001";     // ISR
    public static final String IMP_IVA = "002";     // IVA
    public static final String IMP_IEPS = "003";    // IEPS
    
    public static final String REL_TP_NOTA_CREDITO = "01";
    public static final String REL_TP_NOTA_DEBITO = "02";
    public static final String REL_TP_DEVOLUCIÓN = "03";
    public static final String REL_TP_SUSTITUCIÓN = "04";
    public static final String REL_TP_TRASLADO_MER = "05";
    public static final String REL_TP_TRASLADO_PRE = "06";
    public static final String REL_TP_ANTICIPO = "07";
    
    public static final String FAC_TP_TASA = "Tasa";
    public static final String FAC_TP_CUOTA = "Cuota";
    public static final String FAC_TP_EXENTO = "Exento";
    
    public static final String CAT_REG_FISCAL_RECEPTOR_NOM = "605";
    
    public static final String TRNS_CFD_CAT_TP_REL_CDT = "01";  // credit note
    public static final String TRNS_CFD_CAT_CTY_GRP_UE = "Unión Europea";   // European Union
    public static final String TRNS_CFD_CAT_CTY_GRP_TLCAN = "TLCAN";        // TLCAN
    
    public static final String TxtSí = "Sí";
    public static final String TxtNo = "No";
    
    public static final String ClaveUsoCfdiSinEfectosFiscales = "S01"; 
    public static final String ClaveUsoCfdiPagos = "CP01"; // Pagos
    public static final String ClaveUsoCfdiNómina = "CN01"; // Nómina
    public static final String ClaveUsoCfdiDevDescBon = "G02";    // Devoluciones, descuentos o bonificaciones
    
    public static final String ClavePaísMex = "MEX";
    public static final String ClavePaísUsa = "USA";
    public static final String ClavePaísCan = "CAN";
    
    public static final String ClaveMonedaMxn = "MXN";
    public static final String ClaveMonedaXxx = "XXX";
    
    public static final String ClaveExportacionNoAplica = "01";
    public static final String ClaveExportacionAplica = "02";
    
    public static final String ClaveObjetoImpNo = "01";
    public static final String ClaveObjetoImpSí = "02";
    public static final String ClaveObjetoImpSíSinDesglose = "03";
    
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
    
    public static final String ClaveOrigen = "Origen";
    public static final String ClaveDestino = "Destino";
    
    public static final String PrefijoClaveOrigen = "OR";
    public static final String PrefijoClaveDestino = "DE";
    
    public static final double DIAS_PAG_MIN = 0.001;
    
    public static final HashMap<String, String> TipoComprobante = new HashMap<>();
    public static final HashMap<String, String> Impuesto = new HashMap<>();
    public static final HashMap<String, String> TipoRelación = new HashMap<>();
    public static final HashMap<String, String> TipoFigura = new HashMap<>();
    
    static {
        TipoComprobante.put(CFD_TP_I, "Ingreso");
        TipoComprobante.put(CFD_TP_E, "Egreso");
        TipoComprobante.put(CFD_TP_T, "Traslado");
        TipoComprobante.put(CFD_TP_N, "Nómina");
        TipoComprobante.put(CFD_TP_P, "Pago");
        
        Impuesto.put(IMP_ISR, "ISR");
        Impuesto.put(IMP_IVA, "IVA");
        Impuesto.put(IMP_IEPS, "IEPS");
        
        TipoRelación.put(REL_TP_NOTA_CREDITO, "Nota de crédito de los documentos relacionados");
        TipoRelación.put(REL_TP_NOTA_DEBITO, "Nota de débito de los documentos relacionados"); 
        TipoRelación.put(REL_TP_DEVOLUCIÓN, "Devolución de mercancía sobre facturas o traslados previos");
        TipoRelación.put(REL_TP_SUSTITUCIÓN, "Sustitución de los CFDI previos");
        TipoRelación.put(REL_TP_TRASLADO_MER, "Traslados de mercancías facturados previamente");
        TipoRelación.put(REL_TP_TRASLADO_PRE, "Factura generada por los traslados previos"); 
        TipoRelación.put(REL_TP_ANTICIPO, "CFDI por aplicación de anticipo");
        
        TipoFigura.put(ClaveChofer, "Chofer");
        TipoFigura.put(ClavePropietario, "Propietario");
        TipoFigura.put(ClaveArrendador, "Arrendatario");
        TipoFigura.put(ClaveNotificado, "Notificado");
    }
}
