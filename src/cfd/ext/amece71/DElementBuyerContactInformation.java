/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementBuyerContactInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementBuyerContactPersonOrDepartmentName moEltPersonOrDepartmentName;

    public DElementBuyerContactInformation() {
        super("contactInformation");

        moEltPersonOrDepartmentName=  new DElementBuyerContactPersonOrDepartmentName();

        mvElements.add(moEltPersonOrDepartmentName);
    }

    public cfd.ext.amece71.DElementBuyerContactPersonOrDepartmentName getEltPersonOrDepartmentName() { return moEltPersonOrDepartmentName; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
