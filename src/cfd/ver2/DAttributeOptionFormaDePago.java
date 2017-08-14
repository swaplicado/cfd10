/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttributeStringOption;

/**
 * This attribute should stand for 'método de pago' but, but was mistakenly taken as 'forma de pago' by SAT confusion in CFD 2.0, 2.2 and CFDI 3.2.
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionFormaDePago extends DAttributeStringOption {

    public static final int CFD_UNA_EXHIBICION = 1;
    public static final int CFD_PARCIALIDADES = 2;

    public DAttributeOptionFormaDePago(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_UNA_EXHIBICION, "PAGO EN UNA SOLA EXHIBICIÓN");
        moOptions.put(CFD_PARCIALIDADES, "PARCIALIDADES");
    }
}
