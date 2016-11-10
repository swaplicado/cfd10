/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementAlternateTradeItemIdentification extends cfd.DElement {

    protected cfd.DAttributeString moAttType;

    public DElementAlternateTradeItemIdentification(java.lang.String value) {
        super("modelo:alternateTradeItemIdentification", value);
        
        moAttType = new DAttributeString("type", true);

        mvAttributes.add(moAttType);
    }

    public cfd.DAttributeString getAttType() { return moAttType; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
