/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementSubsidioEmpleo extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttSubsidioCausado;

    public DElementSubsidioEmpleo() {
        super("nomina12:SubsidioAlEmpleo");

        moAttSubsidioCausado = new DAttributeTypeImporte("SubsidioCausado", true);
        moAttSubsidioCausado.setCanBeZero(true);

        mvAttributes.add(moAttSubsidioCausado);
    }

    public cfd.DAttributeTypeImporte getAttSubsidioCausado() { return moAttSubsidioCausado; }
}
