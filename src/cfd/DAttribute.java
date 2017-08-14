/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutérrez
 */
public abstract class DAttribute implements java.io.Serializable {

    public static final java.lang.String MSG_ERR_VAL_UNDEF = "No se ha definido un valor para el atributo: ";

    protected java.lang.String msName;
    protected boolean mbIsRequired;

    public DAttribute(java.lang.String name, boolean isRequired) {
        msName = name;
        mbIsRequired = isRequired;
    }

    public void setName(java.lang.String name) { msName = name; }
    public void setIsRequired(boolean isRequired) { mbIsRequired = isRequired; }

    public java.lang.String getName() { return msName; }
    public boolean getIsRequired() { return mbIsRequired; }

    public abstract void validateValue();
    public abstract java.lang.String getAttributeForXml();
    public abstract java.lang.String getAttributeForOriginalString();
}
