/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeString extends DAttribute {

    protected int mnLengthMin;
    protected int mnLengthMax;
    protected java.lang.String msString;

    public DAttributeString(java.lang.String name, boolean isRequired) {
        this(name, isRequired, -1, -1);
    }

    public DAttributeString(java.lang.String name, boolean isRequired, int lengthMin) {
        this(name, isRequired, lengthMin, -1);
    }

    public DAttributeString(java.lang.String name, boolean isRequired, int lengthMin, int lengthMax) {
        super(name, isRequired);

        mnLengthMin = lengthMin;
        mnLengthMax = lengthMax;
        msString = "";
    }

    public void setLengthMin(int length) { mnLengthMin = length; }
    public void setLengthMax(int length) { mnLengthMax = length; }
    public void setString(java.lang.String string) { msString = SLibUtils.textTrim(string); }

    public int getLengthMin() { return mnLengthMin; }
    public int getLengthMax() { return mnLengthMax; }
    public java.lang.String getString() { return msString; }

    @Override
    public void validateValue() {
        String string = "";

        if (msString == null) {
            throw new IllegalStateException(DAttribute.MSG_ERR_VAL_UNDEF + "'" + msName + "'.");
        }
        if (msString.contains("|")) {
            throw new IllegalStateException("La cadena de caracteres del atributo '" + msName + "' contiene el caracter 'pipe'.");
        }

        string = SLibUtils.textTrim(msString);

        if (mbIsRequired && string.isEmpty() && mnLengthMin > 0) {
            throw new IllegalStateException("La cadena de caracteres del atributo '" + msName + "' es requerida.");
        }
        if (mbIsRequired || (!mbIsRequired && string.length() > 0)) {
            if (mnLengthMin != -1 && string.length() < mnLengthMin) {
                throw new IllegalStateException("La cadena de caracteres del atributo '" + msName + "' no cumple con la longitud mínima (" + mnLengthMin + ").");
            }
            if (mnLengthMax != -1 && string.length() > mnLengthMax) {
                throw new IllegalStateException("La cadena de caracteres del atributo '" + msName + "' no cumple con la longitud máxima (" + mnLengthMax + ").");
            }
        }
    }

    @Override
    public java.lang.String getAttributeForXml() {
        String value = "";
        validateValue();
        value = SLibUtils.textToXml(msString);
        return !mbIsRequired && value.isEmpty() ? "" : msName + "=\"" + value + "\"";
    }

    @Override
    public java.lang.String getAttributeForOriginalString() {
        String value = "";
        validateValue();
        value = DCfdUtils.textForOriginalString(msString);
        return value.isEmpty() ? "" : value + "|";
    }
}
