/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;
import cfd.DSubelementAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAddendaModelo extends cfd.DSubelementAddenda {

   protected cfd.DAttributeString moAttXmlns;
   protected cfd.DAttributeString moAttSchemaLocation;
   protected cfd.ext.grupomodelo.DElementPayment moEltPayment;

    public DElementAddendaModelo() {
        super("modelo:AddendaModelo", DSubelementAddendaType.GrupoModelo);

        moAttXmlns = new DAttributeString("xmlns:modelo", true);
        moAttSchemaLocation = new DAttributeString("xsi:schemaLocation", true);
        moEltPayment = new DElementPayment();

        mvAttributes.add(moAttXmlns);
        mvAttributes.add(moAttSchemaLocation);
        mvElements.add(moEltPayment);
    }

    public cfd.DAttributeString getAttXmlns() { return moAttXmlns; }
    public cfd.DAttributeString getAttSchemaLocation() { return moAttSchemaLocation; }
    public cfd.ext.grupomodelo.DElementPayment getEltPayment() { return moEltPayment; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
