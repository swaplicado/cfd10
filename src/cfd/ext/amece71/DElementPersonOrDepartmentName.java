/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPersonOrDepartmentName extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementPersonOrText moEltText;

    public DElementPersonOrDepartmentName() {
        super("personOrDepartmentName");

        moEltText =  new DElementPersonOrText("");

        mvElements.add(moEltText);
    }

    public cfd.ext.amece71.DElementPersonOrText getEltText() { return moEltText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
