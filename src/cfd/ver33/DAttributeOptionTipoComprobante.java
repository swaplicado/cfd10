/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver33;

import cfd.DAttributeStringOption;

/**
 *
 * @author Juan Barajas
 */
public class DAttributeOptionTipoComprobante extends DAttributeStringOption {

    public static final int CFD_INGRESO = 1;
    public static final int CFD_EGRESO = 2;
    public static final int CFD_TRASLADO = 3;
    public static final int CFD_NOMINA = 4;

    public DAttributeOptionTipoComprobante(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_INGRESO, "I");
        moOptions.put(CFD_EGRESO, "E");
        moOptions.put(CFD_TRASLADO, "T");
        moOptions.put(CFD_NOMINA, "N");
    }
}
