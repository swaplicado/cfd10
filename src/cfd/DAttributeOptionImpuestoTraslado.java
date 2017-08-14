/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionImpuestoTraslado extends DAttributeStringOption {

    public static final int CFD_IVA = 1;
    public static final int CFD_IEPS = 2;

    public DAttributeOptionImpuestoTraslado(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_IVA, "IVA");
        moOptions.put(CFD_IEPS, "IEPS");
    }
}
