/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DElement implements java.io.Serializable {

    public static final java.lang.String MSG_ERR_NO_ELEMENTS = "No hay elementos para el atributo: ";

    protected java.lang.String msName;
    protected java.lang.String msValue;
    protected java.util.Vector<cfd.DAttribute> mvAttributes;

    public DElement(java.lang.String name) {
        this(name, "");
    }

    public DElement(java.lang.String name, java.lang.String value) {
        msName = name;
        msValue = value;
        mvAttributes = new Vector<cfd.DAttribute>();
    }

    public void setName(java.lang.String name) { msName = name; }
    public void setValue(java.lang.String value) { msValue = value; }

    public java.lang.String getName() { return msName; }
    public java.lang.String getValue() { return msValue; }

    public java.util.Vector<DAttribute> getAttributes() { return mvAttributes; }

    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        if (msValue.length() == 0) {
            string += "/>";
        }
        else {
            string += ">" + msValue + "</" + msName + ">";
        }

        return string;
    }

    public java.lang.String getElementForOriginalString() {
        String string = "";
        
        for (DAttribute attribute : mvAttributes) {
            string += attribute.getAttributeForOriginalString();
        }

        return string;
    }
}
