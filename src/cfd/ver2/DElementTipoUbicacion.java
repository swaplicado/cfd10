/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver2;

import cfd.DAttributeString;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementTipoUbicacion extends cfd.DElement {

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

    public DElementTipoUbicacion(java.lang.String name) {
        super(name);

        moAttCalle = new DAttributeString("calle", false, 1);
        moAttNoExterior = new DAttributeString("noExterior", false, 1);
        moAttNoInterior = new DAttributeString("noInterior", false, 1);
        moAttColonia = new DAttributeString("colonia", false, 1);
        moAttLocalidad = new DAttributeString("localidad", false, 1);
        moAttReferencia = new DAttributeString("referencia", false, 1);
        moAttMunicipio = new DAttributeString("municipio", false, 1);
        moAttEstado = new DAttributeString("estado", false, 1);
        moAttPais = new DAttributeString("pais", true, 1);
        moAttCodigoPostal = new DAttributeString("codigoPostal", false, 1);

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
