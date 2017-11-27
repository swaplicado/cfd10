/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver33;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DCfdi33Consts {
    
    public static final String URL_XSLT = "http://www.sat.gob.mx/sitio_internet/cfd/3/cadenaoriginal_3_3/cadenaoriginal_3_3.xslt";
    public static final String URL_VERIFIC = "https://verificacfdi.facturaelectronica.sat.gob.mx/default.aspx";
    
    //public static final String REGEX_DESCRIP = "([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|\"|%|&|'|´|-|:|;|>|=|<|@|_|,|\\{|\\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü)";
    public static final String REGEX_DESCRIP = "[^|]";
    public static final String REGEX_CONFIRM = "[0-9a-zA-Z]{5}";
    public static final String REGEX_UUID = "[a-f0-9A-F]{8}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{4}-[a-f0-9A-F]{12}";
    public static final String REGEX_NUM_PEDIMENTO = "[0-9]{2}  [0-9]{2}  [0-9]{4}  [0-9]{7}";
    public static final String REGEX_NUM_PREDIAL = "[0-9]{1,150}";
}
