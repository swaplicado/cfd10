package cfd.ver40;

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

        moAttNumeroPedimento = new DAttributeString("NumeroPedimento", true, 21, 21);   // 21 characters
        moAttNumeroPedimento.setTrimmable(false);       // prevent from removing double blank spaces
        moAttNumeroPedimento.setXmlAdaptable(false);    // prevent from removing double blank spaces

        mvAttributes.add(moAttNumeroPedimento);
    }

    public cfd.DAttributeString getAttNumeroPedimento() { return moAttNumeroPedimento; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate text conformity to requiered regular expressions:
        
        if (!DCfdi40Utils.matches(moAttNumeroPedimento.getString(), DCfdi40Consts.REGEX_NUM_PEDIMENTO)) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNumeroPedimento.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
}
