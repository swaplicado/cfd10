/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionImpuestoRetencion extends DAttributeStringOption {

    public static final int CFD_IVA = 1;
    public static final int CFD_ISR = 2;

    public DAttributeOptionImpuestoRetencion(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_IVA, "IVA");
        moOptions.put(CFD_ISR, "ISR");
    }
}
