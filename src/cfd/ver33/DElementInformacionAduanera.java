package cfd.ver33;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementInformacionAduanera extends cfd.DElement {

    protected cfd.DAttributeString moAttNumeroPedimento;

    public DElementInformacionAduanera() {
        super("cfdi:InformacionAduanera");

        moAttNumeroPedimento = new DAttributeString("NumeroPedimento", true);

        mvAttributes.add(moAttNumeroPedimento);
    }

    public cfd.DAttributeString getAttNumeroPedimento() { return moAttNumeroPedimento; }
}
