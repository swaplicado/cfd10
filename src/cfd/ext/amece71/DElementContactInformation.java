/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.amece71;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementContactInformation extends cfd.DElementParent {

    protected cfd.ext.amece71.DElementPersonOrDepartmentName moEltPersonOrDepartmentName;

    public DElementContactInformation() {
        super("contactInformation");

        moEltPersonOrDepartmentName=  new DElementPersonOrDepartmentName();

        mvElements.add(moEltPersonOrDepartmentName);
    }

    public cfd.ext.amece71.DElementPersonOrDepartmentName getEltPersonOrDepartmentName() { return moEltPersonOrDepartmentName; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
