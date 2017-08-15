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
public class DElementPropietario extends cfd.DElement {

    private final cfd.DAttributeString moAttNumRegIdTrib;
    private final cfd.DAttributeString moAttResidenciaFiscal;

    public DElementPropietario() {
        super("cfdi:Propietario");

        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", true, 6, 40);          // from 6 to 40 characters
        moAttResidenciaFiscal = new DAttributeString("ResidenciaFiscal", true, 3, 3);   // c_Pais catalog, of 3 fixed characters

        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttResidenciaFiscal);
    }

    public cfd.DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public cfd.DAttributeString getAttResidenciaFiscal() { return moAttResidenciaFiscal; }
}
