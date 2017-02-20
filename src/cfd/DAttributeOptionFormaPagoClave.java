/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionFormaPagoClave extends DAttributeStringOption {

    public DAttributeOptionFormaPagoClave(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(DAttributeOptionFormaPago.CFD_NO_APLICA, "NA");
        moOptions.put(DAttributeOptionFormaPago.CFD_EFECTIVO, "01");
        moOptions.put(DAttributeOptionFormaPago.CFD_CHEQUE_NOMINATIVO, "02");
        moOptions.put(DAttributeOptionFormaPago.CFD_TRANSFERENCIA_ELECTRONICA, "03");
        moOptions.put(DAttributeOptionFormaPago.CFD_TARJETA_DEBITO, "28");
        moOptions.put(DAttributeOptionFormaPago.CFD_TARJETA_CREDITO, "04");
        moOptions.put(DAttributeOptionFormaPago.CFD_TARJETA_SERVICIO, "29");
        moOptions.put(DAttributeOptionFormaPago.CFD_MONEDERO_ELECTRONICO, "05");
        moOptions.put(DAttributeOptionFormaPago.CFD_DINERO_ELECTRONICO, "06");
        moOptions.put(DAttributeOptionFormaPago.CFD_VALES_DESPENSA, "08");
        moOptions.put(DAttributeOptionFormaPago.CFD_OTROS, "99");
        moOptions.put(DAttributeOptionFormaPago.CFD_NO_IDENTIFICADO, "NO IDENTIFICADO");
    }
}
