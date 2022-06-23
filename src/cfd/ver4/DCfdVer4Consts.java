/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4;

import java.util.HashMap;

/**
 *
 * @author Sergio Flores, Isabel Servín
 */
public abstract class DCfdVer4Consts {
    
    public static final int LEN_UUID = 36;
    
    public static final double VER_NOM_11 = 1.1;
    public static final double VER_NOM_12 = 1.2;
    
    public static final String CAN_MOTIVO_ERROR_CON_REL = "01"; // Comprobantes emitidos con errores con relación
    public static final String CAN_MOTIVO_ERROR_SIN_REL = "02"; // Comprobantes emitidos con errores sin relación
    public static final String CAN_MOTIVO_OPERACION_CAN = "03"; // No se llevó acabo la operación
    public static final String CAN_MOTIVO_FACTURA_GLOBAL = "04"; // Operación nominativa relacionada en una factura global
    
    public static final String CAT_OBJ_SIN_IMPUESTO = "01"; 
    public static final String CAT_OBJ_CON_IMPUESTO = "02";
    public static final String CAT_OBJ_CON_IMPUESTO_SIN_DES = "03";
    
    public static final String CAT_EXPORTACION_NA = "01";
    
    public static final String CAT_REG_FISCAL_RECEPTOR_NOM = "605";
    
    public static final HashMap<String, String> CancelaciónMotivos = new HashMap<>();
    
    static {
        CancelaciónMotivos.put(CAN_MOTIVO_ERROR_CON_REL, "Comprobantes emitidos con errores con relación");
        CancelaciónMotivos.put(CAN_MOTIVO_ERROR_SIN_REL, "Comprobantes emitidos con errores sin relación");
        CancelaciónMotivos.put(CAN_MOTIVO_OPERACION_CAN, "No se llevó acabo la operación");
        CancelaciónMotivos.put(CAN_MOTIVO_FACTURA_GLOBAL, "Operación nominativa relacionada en una factura global");
    }
}
