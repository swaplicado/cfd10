/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementExtAddenda extends cfd.DElementParent {

    protected DElementExtAddendaType meAddendaType;
    
    public DElementExtAddenda(String name, DElementExtAddendaType addendaType) {
        super(name);
        meAddendaType = addendaType;
    }
    
    public DElementExtAddendaType getAddendaType() { return meAddendaType; }
}
