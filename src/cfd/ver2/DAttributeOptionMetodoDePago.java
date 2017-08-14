/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttributeStringOption;

/**
 * This attribute should stand for 'forma de pago' but, but was mistakenly taken as 'método de pago' by SAT confusion in CFD 2.0, 2.2 and CFDI 3.2.
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionMetodoDePago extends DAttributeStringOption {

    public static final int CFD_NO_APLICA = 1;
    public static final int CFD_EFECTIVO = 11;
    public static final int CFD_CHEQUE_NOMINATIVO = 12;
    public static final int CFD_TRANSFERENCIA_ELECTRONICA = 13;
    public static final int CFD_TARJETA_DEBITO = 21;
    public static final int CFD_TARJETA_CREDITO = 22;
    public static final int CFD_TARJETA_SERVICIO = 23;
    public static final int CFD_MONEDERO_ELECTRONICO = 31;
    public static final int CFD_DINERO_ELECTRONICO = 32;
    public static final int CFD_VALES_DESPENSA = 41;
    public static final int CFD_OTROS = 91;
    public static final int CFD_NO_IDENTIFICADO = 99;

    public DAttributeOptionMetodoDePago(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_NO_APLICA, "(N/A)");
        moOptions.put(CFD_EFECTIVO, "EFECTIVO");
        moOptions.put(CFD_CHEQUE_NOMINATIVO, "CHEQUE NOMINATIVO");
        moOptions.put(CFD_TRANSFERENCIA_ELECTRONICA, "TRANSFERENCIA ELECTRÓNICA DE FONDOS");
        moOptions.put(CFD_TARJETA_DEBITO, "TARJETA DE DÉBITO");
        moOptions.put(CFD_TARJETA_CREDITO, "TARJETA DE CRÉDITO");
        moOptions.put(CFD_TARJETA_SERVICIO, "TARJETA DE SERVICIO");
        moOptions.put(CFD_MONEDERO_ELECTRONICO, "MONEDERO ELECTRÓNICO");
        moOptions.put(CFD_DINERO_ELECTRONICO, "DINERO ELECTRÓNICO");
        moOptions.put(CFD_VALES_DESPENSA, "VALES DE DESPENSA");
        moOptions.put(CFD_OTROS, "OTROS");
        moOptions.put(CFD_NO_IDENTIFICADO, "NO IDENTIFICADO");
    }
}
