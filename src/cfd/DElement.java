/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DElement implements java.io.Serializable {

    public static final java.lang.String ERR_MSG_NODE = "El nodo ";
    public static final java.lang.String ERR_MSG_NODES = "Los nodos ";
    public static final java.lang.String ERR_MSG_NODE_NO_EXIST = " no existe.";
    public static final java.lang.String ERR_MSG_NODES_NO_EXIST = " no existen.";
    public static final java.lang.String ERR_MSG_NODE_NO_CHILD = " no tiene nodos hijo ";
    public static final java.lang.String ERR_MSG_ATTRIB = "El atributo ";
    public static final java.lang.String ERR_MSG_ATTRIB_INVALID = " es inválido.";

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
    
    public void validateElement() throws IllegalStateException, Exception {
        
    }

    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            if (!aux.isEmpty()) {
                xml += " " + aux;
            }
        }

        if (msValue.isEmpty()) {
            xml += "/>";
        }
        else {
            xml += ">" + msValue + "</" + msName + ">";
        }

        return xml;
    }

    public java.lang.String getElementForOriginalString() throws Exception {
        validateElement();
        
        String string = "";
        
        for (DAttribute attribute : mvAttributes) {
            string += attribute.getAttributeForOriginalString();
        }

        return string;
    }
}
