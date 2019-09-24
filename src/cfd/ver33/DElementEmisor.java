package cfd.ver33;

import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementEmisor extends cfd.DElement {

    private final DAttributeString moAttRfc;
    private final DAttributeString moAttNombre;
    private final DAttributeString moAttRegimenFiscal;

    public DElementEmisor() {
        super("cfdi:Emisor");

        moAttRfc = new DAttributeString("Rfc", true, 12, 13);           // from 12 to 13 characters
        moAttNombre = new DAttributeString("Nombre", false, 1, 254);    // from 1 to 254 characters
        moAttRegimenFiscal = new DAttributeString("RegimenFiscal", true, 3, 3);     // c_RegimenFiscal catalog codes of 3 fixed digits

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);
        mvAttributes.add(moAttRegimenFiscal);
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public DAttributeString getAttRfc() { return moAttRfc; }
    public DAttributeString getAttNombre() { return moAttNombre; }
    public DAttributeString getAttRegimenFiscal() { return moAttRegimenFiscal; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any
        
        // validate text conformity to requiered regular expressions:
        
        if (!moAttNombre.getString().isEmpty() && !DCfdi33Utils.matches(moAttNombre.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttNombre.getLengthMin() + "," + moAttNombre.getLengthMax() + "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNombre.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
}
