/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.util.DUtilUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DUtils {

    public static java.lang.String textForXml(final String text) {
        String textForXml = text;
        
        for(int i = 0; i < textForXml.length(); i++) { 
            if(!((textForXml.charAt(i) > 64 && textForXml.charAt(i) < 91) || 
                (textForXml.charAt(i) > 96 && textForXml.charAt(i) < 123))) {
                
            }
        }
        
        return DUtilUtils.textTrim(textForXml);
    }
}
