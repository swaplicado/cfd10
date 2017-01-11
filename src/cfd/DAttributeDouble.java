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
public class DAttributeDouble extends DAttribute {

    protected int mnDecimals;
    protected double mdDouble;
    protected boolean mbCanBeZero;
    protected cfd.DElementWithChildren miElementWithChildrenToCheck;
    protected java.text.DecimalFormat moDecimalFormat;

    public DAttributeDouble(java.lang.String name, boolean isRequired, int decimals) {
        super(name, isRequired);

        mdDouble = 0;
        mbCanBeZero = false;
        miElementWithChildrenToCheck = null;

        setDecimals(decimals);
    }

    public void setDecimals(int decimals) { mnDecimals = decimals; moDecimalFormat = new DecimalFormat((mnDecimals == 0 ? "0" : "0." + DUtilUtils.textRepeat("0", mnDecimals))); }
    public void setDouble(double value) { mdDouble = value; }
    public void setCanBeZero(boolean b) { mbCanBeZero = b; }
    public void setElementWithChildrenToCheck(cfd.DElementWithChildren i) { miElementWithChildrenToCheck = i; }

    public int getDecimals() { return mnDecimals; }
    public double getDouble() { return mdDouble; }
    public boolean getCanBeZero() { return mbCanBeZero; }
    public cfd.DElementWithChildren getElementWithChildrenToCheck() { return miElementWithChildrenToCheck; }

    @Override
    public void validateValue() {
        if (mbIsRequired && mdDouble == 0 && !mbCanBeZero) {
            throw new IllegalStateException(DAttribute.MSG_ERR_VAL_UNDEF + "'" + msName + "'.");
        }
    }

    @Override
    public java.lang.String getAttributeForXml() {
        //System.out.println(getClass().getName() + ".getAttributeForXml(): [name='" + msName + "'; mbIsRequired=" + mbIsRequired + "; mdDouble=" + mdDouble + "; mbCanBeZero=" + mbCanBeZero + "; miElementWithChildrenToCheck=" + (miElementWithChildrenToCheck == null ? "null" : miElementWithChildrenToCheck.hasChildren() ? "yes":"no") + "]\n");

        validateValue();
        return !mbIsRequired && mdDouble == 0 && !mbCanBeZero && (miElementWithChildrenToCheck == null || !miElementWithChildrenToCheck.hasChildren()) ?
            "" : msName + "=\"" + moDecimalFormat.format(mdDouble) + "\"";
    }

    @Override
    public java.lang.String getAttributeForOriginalString() {
        //System.out.println(getClass().getName() + ".getAttributeForOriginalString(): [name='" + msName + "'; mbIsRequired=" + mbIsRequired + "; mdDouble=" + mdDouble + "; mbCanBeZero=" + mbCanBeZero + "; miElementWithChildrenToCheck=" + (miElementWithChildrenToCheck == null ? "null" : miElementWithChildrenToCheck.hasChildren() ? "yes":"no") + "]\n");

        validateValue();
        return !mbIsRequired && mdDouble == 0 && !mbCanBeZero && (miElementWithChildrenToCheck == null || !miElementWithChildrenToCheck.hasChildren()) ?
            "" : moDecimalFormat.format(mdDouble) + "|";
    }
}
