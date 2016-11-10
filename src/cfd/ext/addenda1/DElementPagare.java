/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DAttributeDate;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPagare extends cfd.DElement {

    protected cfd.DAttributeDate moAttFecha;
    protected cfd.DAttributeDate moAttFechaDeVencimiento;
    protected cfd.DAttributeTypeImporte moAttImporte;
    protected cfd.DAttributeString moAttClaveMoneda;
    protected cfd.DAttributeDouble moAttInteresMoratorio;

    public DElementPagare() {
        super("myadd:Pagare");

        moAttFecha = new DAttributeDate("fecha", true);
        moAttFechaDeVencimiento = new DAttributeDate("fechaDeVencimiento", true);
        moAttImporte = new DAttributeTypeImporte("importe", true);
        moAttImporte.setCanBeZero(true);
        moAttClaveMoneda = new DAttributeString("claveMoneda", false, 3, 3);
        moAttInteresMoratorio = new DAttributeDouble("interesMoratorio", true, 8);
        moAttInteresMoratorio.setCanBeZero(true);

        mvAttributes.add(moAttFecha);
        mvAttributes.add(moAttFechaDeVencimiento);
        mvAttributes.add(moAttImporte);
        mvAttributes.add(moAttClaveMoneda);
        mvAttributes.add(moAttInteresMoratorio);
    }

    public cfd.DAttributeDate getAttFecha() { return moAttFecha; }
    public cfd.DAttributeDate getAttFechaDeVencimiento() { return moAttFechaDeVencimiento; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    public cfd.DAttributeString getAttClaveMoneda() { return moAttClaveMoneda; }
    public cfd.DAttributeDouble getAttInteresMoratorio() { return moAttInteresMoratorio; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
