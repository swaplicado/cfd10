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
public class DAttributeDatetime extends DAttribute {

    protected java.util.Date mtDatetime;

    public DAttributeDatetime(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        mtDatetime = null;
    }

    public void setDatetime(java.util.Date datetime) { mtDatetime = datetime; }

    public java.util.Date getDatetime() { return mtDatetime; }

    @Override
    public void validateValue() {
        if (mbIsRequired && mtDatetime == null) {
            throw new IllegalStateException(DAttribute.MSG_ERR_VAL_UNDEF + "'" + msName + "'.");
        }
    }

    @Override
    public java.lang.String getAttributeForXml() {
        validateValue();
        return mtDatetime == null ? "" : msName + "=\"" + SLibUtils.IsoFormatDatetime.format(mtDatetime) + "\"";
    }

    @Override
    public java.lang.String getAttributeForOriginalString() {
        validateValue();
        return mtDatetime == null ? "" : SLibUtils.IsoFormatDatetime.format(mtDatetime) + "|";
    }
}
