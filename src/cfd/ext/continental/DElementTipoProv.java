/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */
package cfd.ext.continental;

import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTipoProv extends DElement {

    public static final String NAME = "Tipo_Prov";
    
    public DElementTipoProv(DElementTipoProvOptions option) {
        super(NAME, option.name());
    }
}
