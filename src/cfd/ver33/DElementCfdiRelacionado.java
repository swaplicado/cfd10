package cfd.ver33;

import cfd.DAttributeString;
import cfd.DElement;
import cfd.ver3.DCfdVer3Consts;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementCfdiRelacionado extends cfd.DElement {

    private final DAttributeString moAttUuid;
    
    public DElementCfdiRelacionado() {
        super("cfdi:CfdiRelacionado");

        moAttUuid = new DAttributeString("UUID", true, DCfdVer3Consts.LEN_UUID, DCfdVer3Consts.LEN_UUID);   // identifiers of 36 fixed characters, e.g., "DC8CF736-5B2C-4A13-8A2B-DD689F0A45C3"

        mvAttributes.add(moAttUuid);
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */
    
    public DAttributeString getAttUuid() { return moAttUuid; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate text conformity to requiered regular expressions:
        
        if (!DCfdi33Utils.matches(moAttUuid.getString(), DCfdi33Consts.REGEX_UUID)) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttUuid.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
}
