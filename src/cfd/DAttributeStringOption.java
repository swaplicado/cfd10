/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import cfd.util.DUtilUtils;
import java.util.TreeMap;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DAttributeStringOption extends DAttribute {

    public static final int CFD_NO_DEFINIDO = 0;

    protected int mnKey;
    protected java.lang.String msOption;
    protected java.util.TreeMap<java.lang.Integer, java.lang.String> moOptions;

    public DAttributeStringOption(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions = new TreeMap<Integer, String>();
        moOptions.put(CFD_NO_DEFINIDO, "N/A");

        mnKey = CFD_NO_DEFINIDO;
        msOption = moOptions.get(mnKey);
    }

    public java.util.TreeMap<java.lang.Integer, java.lang.String> getOptions() { return moOptions; }

    public void setOption(int key) {
        setOption("", key, "");
    }

    public void setOption(int key, java.lang.String suffix) {
        setOption("", key, suffix);
    }

    public void setOption(java.lang.String prefix, int key) {
        setOption(prefix, key, "");
    }

    public void setOption(java.lang.String prefix, int key, java.lang.String suffix) {
        mnKey = key;
        msOption = moOptions.get(key);

        if (msOption != null) {
            if (prefix != null && prefix.length() > 0) {
                msOption = prefix + " " + msOption;
            }
            if (suffix != null && suffix.length() > 0) {
                msOption = msOption + " " + suffix;
            }
        }
    }

    public void setOption(java.lang.String s) { msOption = s; }
    public java.lang.String getOption() { return msOption; }

    @Override
    public void validateValue() {
        String option = "";

        if (msOption == null) {
            throw new IllegalStateException(DAttribute.MSG_ERR_VAL_UNDEF + "'" + msName + "'.");
        }
        if (msOption.contains("|")) {
            throw new IllegalStateException("La cadena de caracteres del atributo '" + msName + "' contiene el caracter 'pipe'.");
        }

        option = DUtilUtils.textTrim(msOption);

        if (mbIsRequired && option.length() == 0) {
            throw new IllegalStateException("La cadena de caracteres del atributo '" + msName + "' es requerida.");
        }
    }

    @Override
    public java.lang.String getAttributeForXml() {
        String value = "";
        validateValue();
        value = DUtilUtils.textForXml(msOption);
        return value.length() == 0 ? "" : msName + "=\"" + value + "\"";
    }

    @Override
    public java.lang.String getAttributeForOriginalString() {
        String value = "";
        validateValue();
        value = DUtilUtils.textForOriginalString(msOption);
        return value.length() == 0 ? "" : value + "|";
    }
}
