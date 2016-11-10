/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.bachoco;

/**
 *
 * @author Juan Barajas
 */
public class DElementContactInformation extends cfd.DElementParent {

    protected cfd.ext.bachoco.DElementPersonOrDepartmentName moEltPersonOrDepartmentName;

    public DElementContactInformation() {
        super("contactInformation");

        moEltPersonOrDepartmentName=  new DElementPersonOrDepartmentName();

        mvElements.add(moEltPersonOrDepartmentName);
    }

    public cfd.ext.bachoco.DElementPersonOrDepartmentName getEltPersonOrDepartmentName() { return moEltPersonOrDepartmentName; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
