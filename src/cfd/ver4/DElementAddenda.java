/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver4;

import cfd.DSubelementAddenda;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAddenda extends cfd.DElementParent {

    public DElementAddenda() {
        super("cfdi:Addenda");
    }
    
    public String getNamespace() {
        String namespace = "";
        
        if (!mvElements.isEmpty()) {
            namespace = ((DSubelementAddenda) mvElements.get(0)).getNamespace();
        }
        
        return namespace;
    }
    
    public String getXsdLocation() {
        String xsdLocation = "";
        
        if (!mvElements.isEmpty()) {
            xsdLocation = ((DSubelementAddenda) mvElements.get(0)).getXsdLocation();
        }
        
        return xsdLocation;
    }
}
