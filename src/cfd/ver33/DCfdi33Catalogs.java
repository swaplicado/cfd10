/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver33;

import java.util.HashMap;

/**
 *
 * @author Sergio Flores
 */
public abstract class DCfdi33Catalogs {
    
    public static final int CAT_CFDI_TP = 1;
    public static final int CAT_CFDI_USO = 2;
    public static final int CAT_REG_FISC = 3;
    public static final int CAT_MDP = 4;
    public static final int CAT_FDP = 5;
    public static final int CAT_MON = 6;
    public static final int CAT_PAIS = 7;
    public static final int CAT_IMP = 8;
    public static final int CAT_FAC_TP = 9;
    public static final int CAT_REL_TP = 10;
    public static final int CAT_CVE_UNID = 11;
    public static final int CAT_CVE_PROD_SERV = 12;
    
    public static final String CFD_TP_I = "I";  // Ingreso
    public static final String CFD_TP_E = "E";  // Egreso
    public static final String CFD_TP_T = "T";  // Traslado
    public static final String CFD_TP_N = "N";  // Nómina
    public static final String CFD_TP_P = "P";  // Pago
    
    public static final String CFDI_USO_POR_DEF = "P01"; // Por definir
    
    public static final int MDP_PUE_ID = 1; // Pago en una sola exhibición
    public static final int MDP_PPD_ID = 2; // Pago en parcialidades o diferido
    
    public static final String IMP_ISR = "001";     // ISR
    public static final String IMP_IVA = "002";     // IVA
    public static final String IMP_IEPS = "003";    // IEPS
    
    public static final String FAC_TP_TASA = "Tasa";
    public static final String FAC_TP_CUOTA = "Cuota";
    public static final String FAC_TP_EXENTO = "Exento";

    public static final String XML_MDP = "c_MetodoPago";
    public static final String XML_REL_TP = "c_TipoRelacion";
    public static final String XML_CFDI_USO = "c_UsoCFDI";
    public static final String XML_CVE_UNID = "c_ClaveUnidad";
    public static final String XML_CVE_PROD_SERV = "c_ClaveProdServ";
    
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
