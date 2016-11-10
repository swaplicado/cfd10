/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionCondicionesPago extends DAttributeStringOption {

    public static final int CFD_CONTADO = 1;
    public static final int CFD_CREDITO = 2;

    public DAttributeOptionCondicionesPago(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_CONTADO, "CONTADO");
        moOptions.put(CFD_CREDITO, "CRÉDITO");
    }
}
