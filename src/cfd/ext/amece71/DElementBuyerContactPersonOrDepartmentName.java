/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementBuyerContactPersonOrDepartmentName extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementBuyerContactPersonOrDepartmentNameText moEltText;

    public DElementBuyerContactPersonOrDepartmentName() {
        super("personOrDepartmentName");

        moEltText =  new DElementBuyerContactPersonOrDepartmentNameText("");

        mvElements.add(moEltText);
    }

    public cfd.ext.amece71.DElementBuyerContactPersonOrDepartmentNameText getEltText() { return moEltText; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
