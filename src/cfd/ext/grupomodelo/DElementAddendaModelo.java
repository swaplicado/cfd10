/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.grupomodelo;

import cfd.DAttributeString;
import cfd.DElementExtAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAddendaModelo extends cfd.DElementExtAddenda {

   protected cfd.DAttributeString moAttXmlns;
   protected cfd.DAttributeString moAttSchemaLocation;
   protected cfd.ext.grupomodelo.DElementPayment moEltPayment;

    public DElementAddendaModelo() {
        super("modelo:AddendaModelo", DElementExtAddendaType.GrupoModelo);

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
