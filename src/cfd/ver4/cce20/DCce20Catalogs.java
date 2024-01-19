/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.cce20;

import java.util.HashMap;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCce20Catalogs {
    
    /** CertificadoOrigen. No funge como tal. */
    public static final String CO_NO_FUNGE = "0";
    /** CertificadoOrigen. Sí funge como tal. */
    public static final String CO_FUNGE = "1";
    
    /** UnidadAduana. Servicio. */
    public static final String UA_SERV = "99";
    
    /** CertificadoOrigen. Catálogo de opciones disponibles de este atributo. */
    public static final HashMap<String, String> CertificadoOrigen = new HashMap<>();
    
    static {
        CertificadoOrigen.put(CO_NO_FUNGE, "No Funge como certificado de origen.");
        CertificadoOrigen.put(CO_FUNGE, "Funge como certificado de origen.");
    }
}
