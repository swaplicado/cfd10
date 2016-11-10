/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.elektra;

import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;

/**
 *
 * @author Néstor Ávalos Balcázar
 */
public class DElementProducto extends cfd.DElementParent {

    protected cfd.DAttributeString moAttCodigoBarras;
    protected cfd.DAttributeInteger moAttCajasEntregadas;
    protected cfd.DAttributeDouble moAttPrecioUnitarioCaja;
    protected cfd.DAttributeInteger moAttPiezasEntregadas;
    protected cfd.DAttributeDouble moAttPrecioUnitarioPieza;

    protected cfd.ext.elektra.DElementImpuestos moEltImpuestos;

    public DElementProducto() {
        super("ap:Producto");

        moAttCodigoBarras = new DAttributeString("codigoBarras", true);
        moAttCajasEntregadas = new DAttributeInteger("cajasEntregadas", true);
        moAttPrecioUnitarioCaja = new DAttributeDouble("precioUnitarioCaja", true, 2);
        moAttPiezasEntregadas = new DAttributeInteger("piezasEntregadas", true);
        moAttPrecioUnitarioPieza = new DAttributeDouble("precioUnitarioPieza", true, 2);

        mvAttributes.add(moAttCodigoBarras);
        mvAttributes.add(moAttCajasEntregadas);
        mvAttributes.add(moAttPrecioUnitarioCaja);
        mvAttributes.add(moAttPiezasEntregadas);
        mvAttributes.add(moAttPrecioUnitarioPieza);

        moEltImpuestos = new DElementImpuestos();

        mvElements.add(moEltImpuestos);
    }

    public cfd.DAttributeString getAttCodigoBarras() { return moAttCodigoBarras; }
    public cfd.DAttributeInteger getAttCajasEntregadas() { return moAttCajasEntregadas; }
    public cfd.DAttributeDouble getAttPrecioUnitarioCaja() { return moAttPrecioUnitarioCaja; }
    public cfd.DAttributeInteger getAttPiezasEntregadas() { return moAttPiezasEntregadas; }
    public cfd.DAttributeDouble getAttPrecioUnitarioPieza() { return moAttPrecioUnitarioPieza; }

    public cfd.ext.elektra.DElementImpuestos getEltImpuestos() { return moEltImpuestos; }

    @Override
    public java.lang.String getElementForOriginalString() {
        return "";
    }
}
