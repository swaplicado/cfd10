/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeDouble;
import cfd.DAttributeTypeRfc;

/**
 *
 * @author Juan Barajas
 */
public class DElementSubcontratacion extends cfd.DElement {

    protected cfd.DAttributeTypeRfc moAttRfcLabora;
    protected cfd.DAttributeDouble moAttPorcentajeTiempo;
    
    public DElementSubcontratacion() {
        super("nomina12:SubContratacion");

        moAttRfcLabora = new DAttributeTypeRfc("RfcLabora", true);
        moAttPorcentajeTiempo = new DAttributeDouble("PorcentajeTiempo", true, 3);

        mvAttributes.add(moAttRfcLabora);
        mvAttributes.add(moAttPorcentajeTiempo);
    }

    public cfd.DAttributeTypeRfc getAttRfcLabora() { return moAttRfcLabora; }
    public cfd.DAttributeDouble getAttPorcentajeTiempo() { return moAttPorcentajeTiempo; }
}
