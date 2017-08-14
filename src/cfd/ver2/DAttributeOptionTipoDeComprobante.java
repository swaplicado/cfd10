/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttributeStringOption;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionTipoDeComprobante extends DAttributeStringOption {

    public static final int CFD_INGRESO = 1;
    public static final int CFD_EGRESO = 2;
    public static final int CFD_TRASLADO = 3;
    public static final int CFD_NOMINA = 4;

    public DAttributeOptionTipoDeComprobante(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_INGRESO, "ingreso");
        moOptions.put(CFD_EGRESO, "egreso");
        moOptions.put(CFD_TRASLADO, "traslado");
        moOptions.put(CFD_NOMINA, "egreso");
    }
}
