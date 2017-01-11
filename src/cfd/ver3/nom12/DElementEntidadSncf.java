/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementEntidadSncf extends cfd.DElement {

    protected cfd.DAttributeString moAttOrigenRecurso;
    protected cfd.DAttributeTypeImporte moAttMontoRecursoPropio;

    public DElementEntidadSncf() {
        super("nomina12:EntidadSNCF");

        moAttOrigenRecurso = new DAttributeString("OrigenRecurso", true);
        moAttMontoRecursoPropio = new DAttributeTypeImporte("MontoRecursoPropio", false);
        moAttMontoRecursoPropio.setCanBeZero(true);

        mvAttributes.add(moAttOrigenRecurso);
        mvAttributes.add(moAttMontoRecursoPropio);
    }

    public cfd.DAttributeString getAttOrigenRecurso() { return moAttOrigenRecurso; }
    public cfd.DAttributeTypeImporte getAttMontoRecursoPropio() { return moAttMontoRecursoPropio; }
}
