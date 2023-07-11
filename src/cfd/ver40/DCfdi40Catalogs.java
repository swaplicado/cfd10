/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40;

import java.util.HashMap;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
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
    
    public static final String XML_CFDI_TP = "c_TipoCFDI";              // not implemented as catalog
    public static final String XML_CFDI_USO = "c_UsoCFDI";              // XML catalog, can be a DB catalog
    public static final String XML_REG_FISC = "c_RegimenFiscal";        // should be a DB catalog
    public static final String XML_MDP = "c_MetodoPago";                // XML catalog, can be a DB catalog
    public static final String XML_FDP = "c_FormaPago";                 // XML catalog, can be a DB catalog
    public static final String XML_MON = "c_Moneda";                    // XML catalog, can be a DB catalog
    public static final String XML_PAIS = "c_Pais";                     // should be a DB catalog
    public static final String XML_IMP = "c_Impuesto";                  // this-class-fixed catalog
    public static final String XML_FAC_TP = "c_TipoFactor";             // not implemented as catalog
    public static final String XML_REL_TP = "c_TipoRelacion";           // both as XML & this-class-fixed catalog
    public static final String XML_CVE_UNID = "c_ClaveUnidad";          // should be a DB catalog
    public static final String XML_CVE_PROD_SERV = "c_ClaveProdServ";   // should be a DB catalog
    public static final String XML_EXP = "c_Exportacion";               // both as XML & this-class-fixed catalog
    public static final String XML_GBL_PER = "c_Periodicidad";          // XML catalog
    public static final String XML_GBL_MES = "c_Meses";                 // XML catalog
    public static final String XML_OBJ_IMP = "c_ObjetoImp";             // both as XML & this-class-fixed catalog
    
    public static final String XML_CCP_MAT_PEL = "c_CartaPorte_MaterialPeligroso";      // XML catalog
    public static final String XML_CCP_EMB_TP = "c_CartaPorte_TipoEmbalaje";            // XML catalog
    public static final String XML_CCP_PERM_TP = "c_CartaPorte_TipoPermiso";            // XML catalog
    public static final String XML_CCP_CFG_AUTO = "c_CartaPorte_ConfigAutotransporte";  // XML catalog
    public static final String XML_CCP_REM_STP = "c_CartaPorte_SubTipoRem";             // XML catalog
    public static final String XML_CCP_EDO_33 = "c_CFDI_Estado_33";                     // XML catalog
    public static final String XML_CCP_EDO_40 = "c_CFDI_Estado_40";                     // XML catalog
    public static final String XML_CCP_MUN = "c_CartaPorte_Municipio";                  // XML catalog
    public static final String XML_CCP_LOC = "c_CartaPorte_Localidad";                  // XML catalog
    public static final String XML_CCP_COL = "c_CartaPorte_Colonia";                    // XML catalog

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
    public static final String FDP_APLIC_ANTICIPOS = "30";
    public static final String FDP_POR_DEF = "99"; // Por definir
    
    public static final String IMP_ISR = "001";     // ISR
    public static final String IMP_IVA = "002";     // IVA
    public static final String IMP_IEPS = "003";    // IEPS
    
    public static final String FAC_TP_TASA = "Tasa";
    public static final String FAC_TP_CUOTA = "Cuota";
    public static final String FAC_TP_EXENTO = "Exento";
    
    public static final String ClaveTipoRelaciónNotaCrédito = "01";
    public static final String ClaveTipoRelaciónNotaDébito = "02";
    public static final String ClaveTipoRelaciónDevolución = "03";
    public static final String ClaveTipoRelaciónSustitución = "04";
    public static final String ClaveTipoRelaciónTrasladosFacturados = "05";
    public static final String ClaveTipoRelaciónFacturaTraslados = "06";
    public static final String ClaveTipoRelaciónAplicaciónAnticipo = "07";
    
    public static final String ClaveRégimenFiscalSueldosSalarios = "605";
    public static final String ClaveRégimenFiscalSinObligacionesFiscales = "616";
    
    public static final String ClaveUsoCfdiSinEfectosFiscales = "S01"; 
    public static final String ClaveUsoCfdiPagos = "CP01";  // Pagos
    public static final String ClaveUsoCfdiNómina = "CN01"; // Nómina
    public static final String ClaveUsoCfdiDevolucionesDescuentos = "G02";  // Devoluciones, descuentos o bonificaciones
    
    public static final String ClavePaísMex = "MEX";
    public static final String ClavePaísUsa = "USA";
    public static final String ClavePaísCan = "CAN";
    
    public static final String AgrupaciónPaísesUE = "Unión Europea";    // European Union
    public static final String AgrupaciónPaísesTLCAN = "TLCAN";         // TLCAN
    
    public static final String ClaveMonedaMxn = "MXN";
    public static final String ClaveMonedaXxx = "XXX";
    
    public static final String ClaveExportacionNoAplica = "01";
    public static final String ClaveExportacionDefinitivaA1 = "02";
    public static final String ClaveExportacionTemporal = "03";
    public static final String ClaveExportacionDefinitivaDistintaA1 = "04";
    
    public static final String ClaveObjetoImpNo = "01";
    public static final String ClaveObjetoImpSí = "02";
    public static final String ClaveObjetoImpSíDesgloseOpcional = "03";
    
    public static final String ClaveProdServServsSueldosSalarios = "84111505";
    public static final String ClaveProdServServsFacturacion = "84111506";
    
    public static final String ClaveUnidadAct = "ACT";
    
    public static final String ConceptoPago = "Pago";
    public static final String ConceptoSueldosSalarios = "Pago de nómina";
    public static final String ConceptoFacturaGlobal = "Venta";
    
    public static final String DescripciónPublicoGeneral = "PUBLICO EN GENERAL";    // just as is, "PUBLICO EN GENERAL"
    public static final String DescripciónImpuestoTrasladado = "Trasladado";
    public static final String DescripciónImpuestoRetenido = "Retenido";
    
    public static final String ClaveNóminaOrd = "O";
    public static final String ClaveNóminaExt = "E";
    public static final String ClavePeriodicidadPagoSem = "02";
    public static final String ClavePeriodicidadPagoQna = "04";
    public static final String ClavePeriodicidadPagoOtra = "99";
    public static final String ClaveTipoContratoModalidadTrabajoComisión = "08";
    public static final String ClaveTipoRégimenSueldos = "02";
    public static final String ClaveTipoRégimenJubilados = "03";
    public static final String ClaveTipoRégimenPensionados = "04";
    public static final String ClaveTipoRégimenJubiladosOPensionados = "12";
    public static final String ClaveTipoOtroPagoSubsidioEmpleo = "002";
    
    public static final String ClaveFiguraTransporteChofer = "01";
    public static final String ClaveFiguraTransportePropietario = "02";
    public static final String ClaveFiguraTransporteArrendador = "03";
    public static final String ClaveFiguraTransporteNotificado = "04";
    
    public static final String CcpMercancíasEntrada = "Entrada";
    public static final String CcpMercancíasSalida = "Salida";
    
    public static final String CcpUbicaciónOrigen = "Origen";
    public static final String CcpUbicaciónOrigenPrefijoId = "OR";
    public static final String CcpUbicaciónDestino = "Destino";
    public static final String CcpUbicaciónDestinoPrefijoId = "DE";
    
    public static final String CcpDimensiónCm = "cm";
    public static final String CcpDimensiónPlg = "plg";
    
    public static final String TextoSí = "Sí";
    public static final String TextoNo = "No";
    
    public static final double PAY_RCP_PAYED_DAYS_MIN = 0.001;
    
    public static final HashMap<String, String> TipoComprobante = new HashMap<>();
    public static final HashMap<String, String> Impuesto = new HashMap<>();
    public static final HashMap<String, String> TipoRelación = new HashMap<>();
    public static final HashMap<String, String> Exportación = new HashMap<>();
    public static final HashMap<String, String> ObjetoImp = new HashMap<>();
    public static final HashMap<String, String> FiguraTransporte = new HashMap<>();
    
    static {
        TipoComprobante.put(CFD_TP_I, "Ingreso");
        TipoComprobante.put(CFD_TP_E, "Egreso");
        TipoComprobante.put(CFD_TP_T, "Traslado");
        TipoComprobante.put(CFD_TP_N, "Nómina");
        TipoComprobante.put(CFD_TP_P, "Pago");
        
        Impuesto.put(IMP_ISR, "ISR");
        Impuesto.put(IMP_IVA, "IVA");
        Impuesto.put(IMP_IEPS, "IEPS");
        
        TipoRelación.put(ClaveTipoRelaciónNotaCrédito, "Nota de crédito de los documentos relacionados");
        TipoRelación.put(ClaveTipoRelaciónNotaDébito, "Nota de débito de los documentos relacionados"); 
        TipoRelación.put(ClaveTipoRelaciónDevolución, "Devolución de mercancía sobre facturas o traslados previos");
        TipoRelación.put(ClaveTipoRelaciónSustitución, "Sustitución de los CFDI previos");
        TipoRelación.put(ClaveTipoRelaciónTrasladosFacturados, "Traslados de mercancías facturados previamente");
        TipoRelación.put(ClaveTipoRelaciónFacturaTraslados, "Factura generada por los traslados previos"); 
        TipoRelación.put(ClaveTipoRelaciónAplicaciónAnticipo, "CFDI por aplicación de anticipo");
        
        Exportación.put(ClaveExportacionNoAplica, "No aplica");
        Exportación.put(ClaveExportacionDefinitivaA1, "Definitiva con clave A1");
        Exportación.put(ClaveExportacionTemporal, "Temporal");
        Exportación.put(ClaveExportacionDefinitivaDistintaA1, "Definitiva con clave distinta a A1 o cuando no existe enajenación en términos del CFF");
        
        ObjetoImp.put(ClaveObjetoImpNo, "No objeto de impuesto.");
        ObjetoImp.put(ClaveObjetoImpSí, "Sí objeto de impuesto.");
        ObjetoImp.put(ClaveObjetoImpSíDesgloseOpcional, "Sí objeto del impuesto y no obligado al desglose.");
        
        FiguraTransporte.put(ClaveFiguraTransporteChofer, "Chofer");
        FiguraTransporte.put(ClaveFiguraTransportePropietario, "Propietario");
        FiguraTransporte.put(ClaveFiguraTransporteArrendador, "Arrendatario");
        FiguraTransporte.put(ClaveFiguraTransporteNotificado, "Notificado");
    }
    
    public static String[] createClavesPaísesNorteamérica() {
        return new String[] { ClavePaísMex, ClavePaísUsa, ClavePaísCan };
    }
}
