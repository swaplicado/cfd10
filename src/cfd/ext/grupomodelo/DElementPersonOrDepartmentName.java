/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPersonOrDepartmentName extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementPersonOrText moEltText;

    public DElementPersonOrDepartmentName() {
        super("modelo:personOrDepartmentName");

        moEltText =  new DElementPersonOrText("");

        mvElements.add(moEltText);
    }

    public cfd.ext.grupomodelo.DElementPersonOrText getEltText() { return moEltText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
