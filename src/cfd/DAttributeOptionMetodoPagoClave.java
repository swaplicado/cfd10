package cfd;

/**
 *
 * @author Juan Barajas
 */
public class DAttributeOptionMetodoPagoClave extends DAttributeStringOption {

    public static final int CFD_UNA_EXHIBICION = 1;
    public static final int CFD_INICIAL_PARCIALIDADES = 2;
    public static final int CFD_PARCIALIDADES = 3;

    public DAttributeOptionMetodoPagoClave(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_UNA_EXHIBICION, "PUE");
        moOptions.put(CFD_INICIAL_PARCIALIDADES, "PIP");
        moOptions.put(CFD_PARCIALIDADES, "PPD");
    }
}
