/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import cfd.util.DUtilUtils;
import java.text.DecimalFormat;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeInteger extends DAttribute {

    protected int mnInteger;
    protected int mnLengthMin;
    protected int mnLengthMax;
    protected int mnLengthFixed;
    protected boolean mbCanBeZero;
    protected cfd.DElementWithChildren miElementWithChildrenToCheck;
    protected DecimalFormat moFixedFormat;

    public DAttributeInteger(java.lang.String name, boolean isRequired) {
        this(name, isRequired, -1, -1, -1);
    }

    public DAttributeInteger(java.lang.String name, boolean isRequired, int lengthMin) {
        this(name, isRequired, lengthMin, -1, -1);
    }

    public DAttributeInteger(java.lang.String name, boolean isRequired, int lengthMin, int lengthMax) {
        this(name, isRequired, lengthMin, lengthMax, -1);
    }

    public DAttributeInteger(java.lang.String name, boolean isRequired, int lengthMin, int lengthMax, int lengthFixed) {
        super(name, isRequired);

        mnInteger = 0;
        mnLengthMin = lengthMin;
        mnLengthMax = lengthMax;
        mnLengthFixed = lengthFixed;
        mbCanBeZero = false;
        miElementWithChildrenToCheck = null;
        
        if (mnLengthFixed > 0) {
            moFixedFormat = new DecimalFormat(DUtilUtils.textRepeat("0", mnLengthFixed));
        }
    }
    
    private String composeInteger() {
        return moFixedFormat == null ? ("" + mnInteger) : moFixedFormat.format(mnInteger);
    }

    public void setInteger(int value) { mnInteger = value; }
    public void setLengthMin(int length) { mnLengthMin = length; }
    public void setLengthMax(int length) { mnLengthMax = length; }
    public void setCanBeZero(boolean b) { mbCanBeZero = b; }
    public void setElementWithChildrenToCheck(cfd.DElementWithChildren i) { miElementWithChildrenToCheck = i; }

    public int getInteger() { return mnInteger; }
    public int getLengthMin() { return mnLengthMin; }
    public int getLengthMax() { return mnLengthMax; }
    public boolean getCanBeZero() { return mbCanBeZero; }
    public cfd.DElementWithChildren getElementWithChildrenToCheck() { return miElementWithChildrenToCheck; }

    @Override
    public void validateValue() {
        String integer = composeInteger();

        if (mbIsRequired && mnInteger == 0 && !mbCanBeZero) {
            throw new IllegalStateException(DAttribute.MSG_ERR_VAL_UNDEF + "'" + msName + "'.");
        }
        if (mnLengthMin != -1 && integer.length() < mnLengthMin) {
            throw new IllegalStateException("El valor del atributo '" + msName + "' no cumple el número mínimo de dígitos (" + mnLengthMin + ").");
        }
        if (mnLengthMax != -1 && integer.length() > mnLengthMax) {
            throw new IllegalStateException("El valor del atributo '" + msName + "' no cumple el número máximo de dígitos (" + mnLengthMax + ").");
        }
    }

    @Override
    public java.lang.String getAttributeForXml() {
        validateValue();
        return !mbIsRequired && mnInteger == 0 && !mbCanBeZero && (miElementWithChildrenToCheck == null || !miElementWithChildrenToCheck.hasChildren()) ?
            "" : msName + "=\"" + composeInteger() + "\"";
    }

    @Override
    public java.lang.String getAttributeForOriginalString() {
        validateValue();
        return !mbIsRequired && mnInteger == 0 && !mbCanBeZero && (miElementWithChildrenToCheck == null || !miElementWithChildrenToCheck.hasChildren()) ?
            "" : composeInteger() + "|";
    }
}
