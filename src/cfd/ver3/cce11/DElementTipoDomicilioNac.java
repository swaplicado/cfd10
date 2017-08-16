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
public class DElementTipoDomicilioNac extends cfd.DElement {

    private final DAttributeString moAttCalle;
    private final DAttributeString moAttNoExterior;
    private final DAttributeString moAttNoInterior;
    private final DAttributeString moAttColonia;
    private final DAttributeString moAttLocalidad;
    private final DAttributeString moAttReferencia;
    private final DAttributeString moAttMunicipio;
    private final DAttributeString moAttEstado;
    private final DAttributeString moAttPais;
    private final DAttributeString moAttCodigoPostal;

    public DElementTipoDomicilioNac() {
        super("cce11:Domicilio");

        moAttCalle = new DAttributeString("Calle", true, 1, 100);               // from 1 to 100 characters
        moAttNoExterior = new DAttributeString("NumeroExterior", false, 1, 55); // from 1 to 55 characters
        moAttNoInterior = new DAttributeString("NumeroInterior", false, 1, 55); // from 1 to 55 characters
        moAttColonia = new DAttributeString("Colonia", false, 4, 4);            // c_Colonia catalog, of 4 fixed digits
        moAttLocalidad = new DAttributeString("Localidad", false, 2, 2);        // c_Localidad catalog, of 2 fixed digits
        moAttReferencia = new DAttributeString("Referencia", false, 1, 250);    // from 1 to 250 characters
        moAttMunicipio = new DAttributeString("Municipio", false, 3, 3);        // c_Municipio catalog, of 3 fixed digits
        moAttEstado = new DAttributeString("Estado", true, 3, 3);               // c_Estado catalog, of 3 fixed characters
        moAttPais = new DAttributeString("Pais", true, 3, 3);                   // c_Pais catalog, of 3 fixed characters
        moAttCodigoPostal = new DAttributeString("CodigoPostal", true, 5, 5);   // c_CodigoPostal catalog, of 5 fixed characters

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

    public DAttributeString getAttCalle() { return moAttCalle; }
    public DAttributeString getAttNoExterior() { return moAttNoExterior; }
    public DAttributeString getAttNoInterior() { return moAttNoInterior; }
    public DAttributeString getAttColonia() { return moAttColonia; }
    public DAttributeString getAttLocalidad() { return moAttLocalidad; }
    public DAttributeString getAttReferencia() { return moAttReferencia; }
    public DAttributeString getAttMunicipio() { return moAttMunicipio; }
    public DAttributeString getAttEstado() { return moAttEstado; }
    public DAttributeString getAttPais() { return moAttPais; }
    public DAttributeString getAttCodigoPostal() { return moAttCodigoPostal; }
}
