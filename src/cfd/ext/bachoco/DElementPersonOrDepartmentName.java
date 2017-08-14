/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPersonOrDepartmentName extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementPersonOrText moEltText;

    public DElementPersonOrDepartmentName() {
        super("personOrDepartmentName");

        moEltText =  new DElementPersonOrText("");

        mvElements.add(moEltText);
    }

    public cfd.ext.bachoco.DElementPersonOrText getEltText() { return moEltText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
