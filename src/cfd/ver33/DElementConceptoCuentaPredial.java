package cfd.ver33;

import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementConceptoCuentaPredial extends cfd.DElement {

    private final cfd.DAttributeString moAttNumero;

    public DElementConceptoCuentaPredial() {
        super("cfdi:CuentaPredial");

        moAttNumero = new DAttributeString("Numero", true, 1, 150); // from 1 to 150 characters

        mvAttributes.add(moAttNumero);
    }

    public cfd.DAttributeString getAttNumero() { return moAttNumero; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate text conformity to requiered regular expressions:
        
        if (!DCfdi33Utils.matches(moAttNumero.getString(), DCfdi33Consts.REGEX_NUM_PREDIAL)) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNumero.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
}
