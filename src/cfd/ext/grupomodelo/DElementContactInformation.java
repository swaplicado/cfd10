/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementContactInformation extends cfd.DElementParent {

    protected cfd.ext.grupomodelo.DElementPersonOrDepartmentName moEltPersonOrDepartmentName;

    public DElementContactInformation() {
        super("modelo:contactInformation");

        moEltPersonOrDepartmentName=  new DElementPersonOrDepartmentName();

        mvElements.add(moEltPersonOrDepartmentName);
    }

    public cfd.ext.grupomodelo.DElementPersonOrDepartmentName getEltPersonOrDepartmentName() { return moEltPersonOrDepartmentName; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
