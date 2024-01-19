/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver4.cce20;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementMercancia extends cfd.DElement {

    private final DAttributeString moAttNoIdentificacion;
    private final DAttributeString moAttFraccionArancelaria;
    private final DAttributeDouble moAttCantidadAduana;
    private final DAttributeString moAttUnidadAduana;
    private final DAttributeDouble moAttValorUnitarioAduana;
    private final DAttributeTypeImporte moAttValorDolares;

    private final ArrayList<DElementDescripcionesEspecificas> maEltDescripcionesEspecificas;

    public DElementMercancia() {
        super("cce20:Mercancia");

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

        maEltDescripcionesEspecificas = new ArrayList<>();
    }

    public DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public DAttributeString getAttFraccionArancelaria() { return moAttFraccionArancelaria; }
    public DAttributeDouble getAttCantidadAduana() { return moAttCantidadAduana; }
    public DAttributeString getAttUnidadAduana() { return moAttUnidadAduana; }
    public DAttributeDouble getAttValorUnitarioAduana() { return moAttValorUnitarioAduana; }
    public DAttributeTypeImporte getAttValorDolares() { return moAttValorDolares; }

    public ArrayList<DElementDescripcionesEspecificas> getEltDescripcionesEspecificas() { return maEltDescripcionesEspecificas; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";

        for (DElementDescripcionesEspecificas element : maEltDescripcionesEspecificas) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }

        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementDescripcionesEspecificas element : maEltDescripcionesEspecificas) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
}
