/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

/**
 *
 * @author Juan Barajas
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
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
