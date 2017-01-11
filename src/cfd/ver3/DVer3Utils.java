/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3;

import java.util.HashSet;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DVer3Utils {
    
    public static final HashSet<Character> ValidKeySet = new HashSet<>();  // SAT pattern for keys as XML attributes
    public static final HashSet<Character> ValidTextSet = new HashSet<>();  // SAT pattern for texts as XML attributes
    
    static {
        ValidKeySet.add('Ñ');
        ValidKeySet.add('ñ');
        ValidKeySet.add('!');
        ValidKeySet.add('\"');
        ValidKeySet.add('%');
        ValidKeySet.add('&');
        ValidKeySet.add('\'');
        ValidKeySet.add('´');
        ValidKeySet.add('-');
        ValidKeySet.add(':');
        ValidKeySet.add(';');
        ValidKeySet.add('>');
        ValidKeySet.add('=');
        ValidKeySet.add('<');
        ValidKeySet.add('@');
        ValidKeySet.add('_');
        ValidKeySet.add(',');
        ValidKeySet.add('{');
        ValidKeySet.add('}');
        ValidKeySet.add('`');
        ValidKeySet.add('~');
        ValidKeySet.add('á');
        ValidKeySet.add('é');
        ValidKeySet.add('í');
        ValidKeySet.add('ó');
        ValidKeySet.add('ú');
        ValidKeySet.add('Á');
        ValidKeySet.add('É');
        ValidKeySet.add('Í');
        ValidKeySet.add('Ó');
        ValidKeySet.add('Ú');
        ValidKeySet.add('ü');
        ValidKeySet.add('Ü');
        
        ValidTextSet.addAll(ValidKeySet);
        ValidTextSet.add(' ');
    }
    
    /**
     * Checks if provided character is a valid ASCII character, that is if it is [A-Z] or [a-z] or [0-9].
     * @param c Character to check if it is valid.
     * @return <code>true</code> if provided character is valid.
     */
    private static boolean isValidAsciiChar(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }
    
    /**
     * Replaces non valid characters with white space onto provided text for 
     * SAT defined pattern for keys as XML attributes "([A-Z]|[a-z]|[0-9]|Ñ|ñ|!|"|%|&|'|´|-|:|;|>|=|<|@|_|,|\{|\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü)".
     * @param text Text to format.
     * @return Formatted text.
     */
    public static String formatAttributeValueAsKey(final String text) {
        char[] array = text.toCharArray();
        String value = "";
        
        for (int i = 0; i < array.length; i++) {
            value += isValidAsciiChar(array[i]) || ValidKeySet.contains(array[i]) ? array[i] : ' ';
        }
        
        return value;
    }
    
    /**
     * Replaces non valid characters with white space onto provided text for 
     * SAT defined pattern for texts as XML attributes "([A-Z]|[a-z]|[0-9]| |Ñ|ñ|!|"|%|&|'|´|-|:|;|>|=|<|@|_|,|\{|\}|`|~|á|é|í|ó|ú|Á|É|Í|Ó|Ú|ü|Ü)".
     * @param text Text to format.
     * @return Formatted text.
     */
    public static String formatAttributeValueAsText(final String text) {
        char[] array = text.toCharArray();
        String value = "";
        
        for (int i = 0; i < array.length; i++) {
            value += isValidAsciiChar(array[i]) || ValidTextSet.contains(array[i]) ? array[i] : ' ';
        }
        
        return value;
    }
}
