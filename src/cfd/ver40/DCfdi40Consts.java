/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40;


/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCfdi40Consts {
    
    public static final String XSLT_3_3_URL = "http://www.sat.gob.mx/sitio_internet/cfd/3/cadenaoriginal_3_3/cadenaoriginal_3_3.xslt";
    //public static final String XSLT_3_3_URL = "http://omawww.sat.gob.mx/sitio_internet/cfd/3/cadenaoriginal_3_3/cadenaoriginal_3_3.xslt"; //URL obsoleta
    //public static final String XSLT_3_3_URL = "http://facturacion.finkok.com/static/cfdi/xslt/3.3/cadenaoriginal_3_3.xslt"; //URL obsoleta, lo correcto es usar la del SAT
    public static final String XSLT_3_3_FILE = "cfdi/xslt/3.3/cadenaoriginal_3_3.xslt";
    public static final String XSLT_4_0_FILE = "cfdi/xslt/4.0/cadenaoriginal_4_0.xslt";
    public static final String URL_VERIFIC = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx";
    
    //public static final String REGEX_DESCRIP = "([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'|´|-|:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü)"; //a fin de cuentas se permitieron todos los caracteres UTF-8
    public static final String REGEX_DESCRIP = "[^|]";
    public static final String REGEX_CONFIRM = "[0-9a-zA-Z]{5}";
    public static final String REGEX_UUID = "[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}";
    public static final String REGEX_NUM_PEDIMENTO = "[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}";
    public static final String REGEX_NUM_PREDIAL = "[0-9]{1,150}";
    
    public static final int STAMP_LAST_CHARS = 8;

    /*
    Constantes para la gestión de la cancelación de CFDI.
    El texto y caso mayúsculas y minúsculas están de acuerdo a los web services del SAT.
    */
    
    public static final String CANCELABLE_SIN_ACEPT = "Cancelable sin aceptación";
    public static final String CANCELABLE_CON_ACEPT = "Cancelable con aceptación";
    public static final String CANCELABLE_NO = "No cancelable";
    
    public static final String CFDI_ESTATUS_VIG = "Vigente";
    public static final String CFDI_ESTATUS_CAN = "Cancelado";
    public static final String CFDI_ESTATUS_NO_ENC = "No Encontrado";
    
    public static final String ESTATUS_CANCEL_PROC = "En proceso";
    public static final String ESTATUS_CANCEL_RECH = "Solicitud rechazada";
    public static final String ESTATUS_CANCEL_SIN_ACEPT = "Cancelado sin aceptación";
    public static final String ESTATUS_CANCEL_CON_ACEPT = "Cancelado con aceptación";
    public static final String ESTATUS_CANCEL_PLAZO_VENC = "Plazo vencido";
    public static final String ESTATUS_CANCEL_PLAZO_VENC_ALT = "Cancelado plazo vencido";
    public static final String ESTATUS_CANCEL_NINGUNO = "None";
    
    public static final String ESTATUS_CANCEL_PROC_CODE = "Prc";
    public static final String ESTATUS_CANCEL_RECH_CODE = "Rec";
    public static final String ESTATUS_CANCEL_SIN_ACEPT_CODE = "CSA";
    public static final String ESTATUS_CANCEL_CON_ACEPT_CODE = "CCA";
    public static final String ESTATUS_CANCEL_PLAZO_VENC_CODE = "CPV";
    public static final String ESTATUS_CANCEL_PEND_BUFF_CODE = "Buf"; // CFDI in pending buffer
    
    /** Unexpected message in a succesful cancelation. */
    public static final String RESPONSE_CANCEL = "Petición de cancelación realizada exitosamente";
}
