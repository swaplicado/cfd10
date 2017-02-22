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
public abstract class DElementParent extends cfd.DElement {

    protected java.util.Vector<cfd.DElement> mvElements;

    public DElementParent(java.lang.String name) {
        super(name);
        mvElements = new Vector<DElement>();
    }

    public java.util.Vector<cfd.DElement> getElements() { return mvElements; }

    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        for (DElement element : mvElements) {
            xml = element.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        for (DAttribute attribute : mvAttributes) {
            string += attribute.getAttributeForOriginalString();
        }

        for (DElement element : mvElements) {
            string += element.getElementForOriginalString();
        }

        return string;
    }
    
    public cfd.DElement extractChildElements(final String name) throws Exception {
        cfd.DElement element = null;
        
        for (DElement elementRow : mvElements) {
            if (elementRow.getName().compareTo(name) == 0) {
                element = elementRow;
                break;
            }
        }
        
        return element;
    }
}
