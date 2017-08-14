package cfd.ver33;

import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoInformacionAduanera extends cfd.DElement {

    private final cfd.DAttributeString moAttNumeroPedimento;

    public DElementConceptoInformacionAduanera() {
        super("cfdi:InformacionAduanera");

        moAttNumeroPedimento = new DAttributeString("NumeroPedimento", true, 1, 21);    // from 1 to 21 characters

        mvAttributes.add(moAttNumeroPedimento);
    }

    public cfd.DAttributeString getAttNumeroPedimento() { return moAttNumeroPedimento; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        // validate text conformity to requiered regular expressions:
        
        if (!DCfdi33Utils.matches(moAttNumeroPedimento.getString(), DCfdi33Consts.REGEX_NUM_PEDIMENTO)) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNumeroPedimento.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
}
