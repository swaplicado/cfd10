/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver33;

import java.util.regex.Pattern;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DCfdi33Utils {
    
    public static boolean matches(final String text, final String regex) throws Exception{
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(text).matches();
    }
    
    /**
     * Check SAT CFDI 3.3 Catalogs for reference.
     * @param formaPago
     * @return 
     */
    public static boolean notRequiredAccountPayer(final String formaPago) {
        return
                formaPago.equals("01") || formaPago.equals("08") || formaPago.equals("12") || formaPago.equals("13") || formaPago.equals("14") || 
                formaPago.equals("15") || formaPago.equals("17") || formaPago.equals("23") || formaPago.equals("24") || formaPago.equals("25") || 
                formaPago.equals("26") || formaPago.equals("27") || formaPago.equals("30") || formaPago.equals("31");
    }
    
    /**
     * Check SAT CFDI 3.3 Catalogs for reference.
     * @param formaPago
     * @return 
     */
    public static boolean notRequiredAccountReceipt(final String formaPago) {
        return notRequiredAccountPayer(formaPago) || formaPago.equals("06");
    }
    
    /**
     * Check SAT CFDI 3.3 Catalogs for reference.
     * @param formaPago
     * @return 
     */
    public static boolean notRequiredBankPayer(final String formaPago) {
        return notRequiredAccountPayer(formaPago) || formaPago.equals("05") || formaPago.equals("06");
    }
}
