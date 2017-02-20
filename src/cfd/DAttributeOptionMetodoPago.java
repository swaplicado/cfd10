/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionMetodoPago extends DAttributeStringOption {

    public static final int CFD_UNA_EXHIBICION = 1;
    public static final int CFD_PARCIALIDADES = 2;

    public DAttributeOptionMetodoPago(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_UNA_EXHIBICION, "PAGO EN UNA SOLA EXHIBICIÓN");
        moOptions.put(CFD_PARCIALIDADES, "PARCIALIDADES");
    }
}
