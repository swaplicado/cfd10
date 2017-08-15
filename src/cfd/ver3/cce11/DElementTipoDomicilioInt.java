/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTipoDomicilioInt extends cfd.DElement {

    protected cfd.DAttributeString moAttCalle;
    protected cfd.DAttributeString moAttNoExterior;
    protected cfd.DAttributeString moAttNoInterior;
    protected cfd.DAttributeString moAttColonia;
    protected cfd.DAttributeString moAttLocalidad;
    protected cfd.DAttributeString moAttReferencia;
    protected cfd.DAttributeString moAttMunicipio;
    protected cfd.DAttributeString moAttEstado;
    protected cfd.DAttributeString moAttPais;
    protected cfd.DAttributeString moAttCodigoPostal;

    public DElementTipoDomicilioInt() {
        super("cce11:Domicilio");

        moAttCalle = new DAttributeString("Calle", true, 1, 100);               // from 1 to 100 characters
        moAttNoExterior = new DAttributeString("NumeroExterior", false, 1, 55); // from 1 to 55 characters
        moAttNoInterior = new DAttributeString("NumeroInterior", false, 1, 55); // from 1 to 55 characters
        moAttColonia = new DAttributeString("Colonia", false, 1, 120);          // from 1 to 120 characters
        moAttLocalidad = new DAttributeString("Localidad", false, 1, 120);      // from 1 to 120 characters
        moAttReferencia = new DAttributeString("Referencia", false, 1, 250);    // from 1 to 250 characters
        moAttMunicipio = new DAttributeString("Municipio", false, 1, 120);      // from 1 to 120 characters
        moAttEstado = new DAttributeString("Estado", true, 1, 30);              // "c_Estado" catalog, from 2 to 3 fixed characters, but countries different from MEX, USA and CAN do not have entries in this catalog!
        moAttPais = new DAttributeString("Pais", true, 3, 3);                   // c_Pais catalog, of 3 fixed characters
        moAttCodigoPostal = new DAttributeString("CodigoPostal", true, 1, 12);  // from 1 to 120 characters

        mvAttributes.add(moAttCalle);
        mvAttributes.add(moAttNoExterior);
        mvAttributes.add(moAttNoInterior);
        mvAttributes.add(moAttColonia);
        mvAttributes.add(moAttLocalidad);
        mvAttributes.add(moAttReferencia);
        mvAttributes.add(moAttMunicipio);
        mvAttributes.add(moAttEstado);
        mvAttributes.add(moAttPais);
        mvAttributes.add(moAttCodigoPostal);
    }

    public cfd.DAttributeString getAttCalle() { return moAttCalle; }
    public cfd.DAttributeString getAttNoExterior() { return moAttNoExterior; }
    public cfd.DAttributeString getAttNoInterior() { return moAttNoInterior; }
    public cfd.DAttributeString getAttColonia() { return moAttColonia; }
    public cfd.DAttributeString getAttLocalidad() { return moAttLocalidad; }
    public cfd.DAttributeString getAttReferencia() { return moAttReferencia; }
    public cfd.DAttributeString getAttMunicipio() { return moAttMunicipio; }
    public cfd.DAttributeString getAttEstado() { return moAttEstado; }
    public cfd.DAttributeString getAttPais() { return moAttPais; }
    public cfd.DAttributeString getAttCodigoPostal() { return moAttCodigoPostal; }
}
