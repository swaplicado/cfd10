/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementMercancia extends cfd.DElement {

    protected cfd.DAttributeString moAttNoIdentificacion;
    protected cfd.DAttributeString moAttFraccionArancelaria;
    protected cfd.DAttributeDouble moAttCantidadAduana;
    protected cfd.DAttributeString moAttUnidadAduana;
    protected cfd.DAttributeDouble moAttValorUnitarioAduana;
    protected cfd.DAttributeTypeImporte moAttValorDolares;

    protected java.util.Vector<cfd.ver3.cce11.DElementDescripcionesEspecificas> mvEltHijosDescripcionesEspecificas;

    public DElementMercancia() {
        super("cce11:Mercancia");

        moAttNoIdentificacion = new DAttributeString("NoIdentificacion", true);
        moAttFraccionArancelaria = new DAttributeString("FraccionArancelaria", false);
        moAttCantidadAduana = new DAttributeDouble("CantidadAduana", false, 3);
        moAttUnidadAduana = new DAttributeString("UnidadAduana", false);
        moAttValorUnitarioAduana = new DAttributeDouble("ValorUnitarioAduana", false, 2);
        moAttValorUnitarioAduana.setCanBeZero(true);
        moAttValorDolares = new DAttributeTypeImporte("ValorDolares", true);
        moAttValorDolares.setCanBeZero(true);

        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttFraccionArancelaria);
        mvAttributes.add(moAttCantidadAduana);
        mvAttributes.add(moAttUnidadAduana);
        mvAttributes.add(moAttValorUnitarioAduana);
        mvAttributes.add(moAttValorDolares);

        mvEltHijosDescripcionesEspecificas = new Vector<DElementDescripcionesEspecificas>();
    }

    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeString getAttFraccionArancelaria() { return moAttFraccionArancelaria; }
    public cfd.DAttributeDouble getAttCantidadAduana() { return moAttCantidadAduana; }
    public cfd.DAttributeString getAttUnidadAduana() { return moAttUnidadAduana; }
    public cfd.DAttributeDouble getAttValorUnitarioAduana() { return moAttValorUnitarioAduana; }
    public cfd.DAttributeTypeImporte getAttValorDolares() { return moAttValorDolares; }

    public java.util.Vector<cfd.ver3.cce11.DElementDescripcionesEspecificas> getEltHijosDescripcionesEspecificas() { return mvEltHijosDescripcionesEspecificas; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        for (DElementDescripcionesEspecificas infoAduanera : mvEltHijosDescripcionesEspecificas) {
            xml = infoAduanera.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes

        for (DElementDescripcionesEspecificas descripcionesEspecificas : mvEltHijosDescripcionesEspecificas) {
            string += descripcionesEspecificas.getElementForOriginalString();
        }

        return string;
    }
}
