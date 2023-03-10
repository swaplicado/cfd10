/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40;

import java.util.regex.Pattern;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCfdi40Utils {
    
    public static boolean matches(final String text, final String regex) throws Exception{
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).matches();
    }
    
    /*
        "Formas de pago" SAT catalog since 2017-12-05:
        01 Efectivo
        02 Cheque nominativo
        03 Transferencia electrónica de fondos
        04 Tarjeta de crédito
        05 Monedero electrónico
        06 Dinero electrónico
        08 Vales de despensa
        12 Dación en pago
        13 Pago por subrogación
        14 Pago por consignación
        15 Condonación
        17 Compensación
        23 Novación
        24 Confusión
        25 Remisión de deuda
        26 Prescripción o caducidad
        27 A satisfacción del acreedor
        28 Tarjeta de débito
        29 Tarjeta de servicios
        30 Aplicación de anticipos
        31 Intermediario pagos
        99 Por definir
    */
    
    /**
     * Check SAT CFDI 3.3 Catalogs for reference.
     * @param formaPago Payment method SAT code.
     * @return <code>true</code> if account payer is not required.
     */
    public static boolean notRequiredAccountPayer(final String formaPago) {
        return
                formaPago.equals("01") || formaPago.equals("08") || formaPago.equals("12") || formaPago.equals("13") || formaPago.equals("14") || 
                formaPago.equals("15") || formaPago.equals("17") || formaPago.equals("23") || formaPago.equals("24") || formaPago.equals("25") || 
                formaPago.equals("26") || formaPago.equals("27") || formaPago.equals("30") || formaPago.equals("31") || formaPago.equals("99");
    }
    
    /**
     * Check SAT CFDI 3.3 Catalogs for reference.
     * @param formaPago Payment method SAT code.
     * @return <code>true</code> if account receipt is not required.
     */
    public static boolean notRequiredAccountReceipt(final String formaPago) {
        return notRequiredAccountPayer(formaPago) || formaPago.equals("06");
    }
    
    /**
     * Check SAT CFDI 3.3 Catalogs for reference.
     * @param formaPago Payment method SAT code.
     * @return <code>true</code> if bank payer is not required.
     */
    public static boolean notRequiredBankPayer(final String formaPago) {
        return notRequiredAccountPayer(formaPago) || formaPago.equals("05") || formaPago.equals("06");
    }
    
    /**
     * Return cancel-status description in format: CODE - DESCRIPTION.
     * @param cancelStatusCode cancel-status code required.
     * @return Composed cancel-status description.
     */
    public static String getEstatusCancelación(final String cancelStatusCode) {
        String description = DCfdi40Consts.EstatusCancelación.get(cancelStatusCode);
        return description == null ? "" : cancelStatusCode + " - " + description;
    }
}
