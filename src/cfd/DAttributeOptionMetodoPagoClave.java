/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionMetodoPagoClave extends DAttributeStringOption {

    public DAttributeOptionMetodoPagoClave(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(DAttributeOptionMetodoPago.CFD_NO_APLICA, "NA");
        moOptions.put(DAttributeOptionMetodoPago.CFD_EFECTIVO, "01");
        moOptions.put(DAttributeOptionMetodoPago.CFD_CHEQUE_NOMINATIVO, "02");
        moOptions.put(DAttributeOptionMetodoPago.CFD_TRANSFERENCIA_ELECTRONICA, "03");
        moOptions.put(DAttributeOptionMetodoPago.CFD_TARJETA_DEBITO, "28");
        moOptions.put(DAttributeOptionMetodoPago.CFD_TARJETA_CREDITO, "04");
        moOptions.put(DAttributeOptionMetodoPago.CFD_TARJETA_SERVICIO, "29");
        moOptions.put(DAttributeOptionMetodoPago.CFD_MONEDERO_ELECTRONICO, "05");
        moOptions.put(DAttributeOptionMetodoPago.CFD_DINERO_ELECTRONICO, "06");
        moOptions.put(DAttributeOptionMetodoPago.CFD_VALES_DESPENSA, "08");
        moOptions.put(DAttributeOptionMetodoPago.CFD_OTROS, "99");
        moOptions.put(DAttributeOptionMetodoPago.CFD_NO_IDENTIFICADO, "NO IDENTIFICADO");
    }
}
