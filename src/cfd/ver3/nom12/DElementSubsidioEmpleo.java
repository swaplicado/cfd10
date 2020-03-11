/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeTypeImporte;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
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
    
    @Override
    public String toString() {
        return moAttSubsidioCausado.getName() + ": " + SLibUtils.getDecimalFormatAmount().format(moAttSubsidioCausado.getDouble());
    }
}
