package cfd.ver33;

import cfd.DAttributeString;

/**
 *
 * @author Juan Barajas
 */
public class DElementCfdiRelacionado extends cfd.DElement {

    protected cfd.DAttributeString moAttUuid;
    
    public DElementCfdiRelacionado() {
        super("cfdi:CfdiRelacionado");

        moAttUuid = new DAttributeString("UUID", true);

        mvAttributes.add(moAttUuid);
    }

    public cfd.DAttributeString getAttUuid() { return moAttUuid; }
}
