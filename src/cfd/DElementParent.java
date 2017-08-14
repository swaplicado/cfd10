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
public abstract class DElementParent extends cfd.DElement {

    protected java.util.Vector<cfd.DElement> mvElements;

    public DElementParent(java.lang.String name) {
        super(name);
        mvElements = new Vector<DElement>();
    }

    public java.util.Vector<cfd.DElement> getElements() { return mvElements; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        for (DElement element : mvElements) {
            xml = element.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
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
