/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionTipoComprobante extends DAttributeStringOption {

    public static final int CFD_INGRESO = 1;
    public static final int CFD_EGRESO = 2;
    public static final int CFD_TRASLADO = 3;

    public DAttributeOptionTipoComprobante(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_INGRESO, "ingreso");
        moOptions.put(CFD_EGRESO, "egreso");
        moOptions.put(CFD_TRASLADO, "traslado");
    }
}
