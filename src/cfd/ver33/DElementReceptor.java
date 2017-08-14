package cfd.ver33;

import cfd.DAttributeString;
import cfd.DElement;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementReceptor extends cfd.DElement {

    private final DAttributeString moAttRfc;
    private final DAttributeString moAttNombre;
    private final DAttributeString moAttResidenciaFiscal;
    private final DAttributeString moAttNumRegIdTrib;
    private final DAttributeString moAttUsoCfdi;

    public DElementReceptor() {
        super("cfdi:Receptor");

        moAttRfc = new DAttributeString("Rfc", true, 12, 13);           // from 12 to 13 characters
        moAttNombre = new DAttributeString("Nombre", false, 1, 254);    // from 1 to 254 characters
        moAttResidenciaFiscal = new DAttributeString("ResidenciaFiscal", false, 3, 3);      // c_Pais catalog codes of 3 fixed characters
        moAttNumRegIdTrib = new DAttributeString("NumRegIdTrib", false, 1, 40);     // from 1 to 40 characters
        moAttUsoCfdi = new DAttributeString("UsoCFDI", true, 3, 3);     // c_UsoCFDI catalog codes of 3 fixed characters

        mvAttributes.add(moAttRfc);
        mvAttributes.add(moAttNombre);
        mvAttributes.add(moAttResidenciaFiscal);
        mvAttributes.add(moAttNumRegIdTrib);
        mvAttributes.add(moAttUsoCfdi);
    }

    /*
     * Private methods
     */

    /*
     * Public methods
     */

    public DAttributeString getAttRfc() { return moAttRfc; }
    public DAttributeString getAttNombre() { return moAttNombre; }
    public DAttributeString getAttResidenciaFiscal() { return moAttResidenciaFiscal; }
    public DAttributeString getAttNumRegIdTrib() { return moAttNumRegIdTrib; }
    public DAttributeString getAttUsoCFDI() { return moAttUsoCfdi; }

    @Override
    public void validateElement() throws IllegalStateException, Exception {
        // validate text conformity to requiered regular expressions:
        
        if (!moAttNombre.getString().isEmpty() && !DCfdi33Utils.matches(moAttNombre.getString(), DCfdi33Consts.REGEX_DESCRIP + "{" + moAttNombre.getLengthMin() + "," + moAttNombre.getLengthMax() + "}")) {
            throw new Exception(DElement.ERR_MSG_ATTRIB + "'" + moAttNombre.getName() + "'" + DElement.ERR_MSG_ATTRIB_INVALID);
        }
    }
}
