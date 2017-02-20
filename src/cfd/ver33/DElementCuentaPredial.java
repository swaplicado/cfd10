package cfd.ver33;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementCuentaPredial extends cfd.DElement {

    protected cfd.DAttributeString moAttNumero;

    public DElementCuentaPredial() {
        super("cfdi:CuentaPredial");

        moAttNumero = new DAttributeString("Numero", true, 1);

        mvAttributes.add(moAttNumero);
    }

    public cfd.DAttributeString getAttNumero() { return moAttNumero; }
}
