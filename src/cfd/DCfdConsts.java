/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */
package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCfdConsts {
    
    /** Longitud de número de Comprobante Fiscal Digital. */
    public static final int LEN_CFD_NUM = 10;
    /** Longitud de clave de Registro Federal de Contribuyentes, persona física. */
    public static final int LEN_RFC_PER = 13;
    /** Longitud de clave de Registro Federal de Contribuyentes, persona moral. */
    public static final int LEN_RFC_ORG = 12;
    /** Longitud de Clave Única de Registro Poblacional. */
    public static final int LEN_CURP = 18;
    /** Longitud de número de seguridad social. */
    public static final int LEN_SS_NUM = 11;
    
    public static final float CFD_VER_20 = 2.0f;
    public static final float CFD_VER_22 = 2.2f;
    
    public static final float CFDI_VER_32 = 3.2f;
    public static final float CFDI_VER_33 = 3.3f;
    public static final float CFDI_VER_40 = 4.0f;
    
    public static final float COMP_RP_10 = 1.0f;
    public static final float COMP_RP_20 = 2.0f;

    public static final String RFC_GEN_NAC = "XAXX010101000";
    public static final String RFC_GEN_INT = "XEXX010101000";
    
    public static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n";
}
