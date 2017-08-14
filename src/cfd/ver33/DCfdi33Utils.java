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
}
