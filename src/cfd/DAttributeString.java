/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import cfd.util.DUtilUtils;

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
    public void setString(java.lang.String string) { msString = DUtilUtils.textTrim(string); }

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

        string = DUtilUtils.textTrim(msString);

        if (mbIsRequired && string.length() == 0 && mnLengthMin > 0) {
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
        value = DUtilUtils.textForXml(msString);
        return !mbIsRequired && value.length() == 0 ? "" : msName + "=\"" + value + "\"";
    }

    @Override
    public java.lang.String getAttributeForOriginalString() {
        String value = "";
        validateValue();
        value = DUtilUtils.textForOriginalString(msString);
        return value.length() == 0 ? "" : value + "|";
    }
}
