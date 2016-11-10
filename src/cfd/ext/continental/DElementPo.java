/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */
package cfd.ext.continental;

import cfd.DElement;

/**
 *
 * @author Sergio Flores
 */
public class DElementPo extends DElement {

    public static final String NAME = "PO";
    
    public DElementPo(DElementPoOptions option) {
        super(NAME, option.name());
    }
}
