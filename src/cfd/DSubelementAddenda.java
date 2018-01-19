/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DSubelementAddenda extends cfd.DElementParent {

    protected DSubelementAddendaType meAddendaType;
    protected String msNamespace;
    protected String msXsdLocation;
    
    /**
     * Creates child node Addenda to be contained by a main node Addenda.
     * @param name Name of addenda.
     * @param addendaType Type of addenda.
     */
    public DSubelementAddenda(String name, DSubelementAddendaType addendaType) {
        this(name, addendaType, "", "");
    }

    /**
     * Creates child node Addenda to be contained by a main node Addenda.
     * @param name Name of addenda.
     * @param addendaType Type of addenda.
     * @param namespace Namespace of addenda, if needed, otherwise an empty <code>String</code> must be provided.
     * Namespace format: 'xmlns:{namespace_alias}="{namespace_identifier}"'
     * Namespace example: xmlns:miaddenda="http://www.acme.com/miaddendaid"
     * @param xsdLocation XML Schema Definition (XSD) file (*.xsd) location of addenda, if needed, otherwise an empty <code>String</code> must be provided.
     * XSD location format: '{namespace_identifier} {xsd_url}'
     * XSD location example: http://www.acme.com/miaddendaid http://www.acme.com/miaddendaid/miaddenda.xsd
     */
    public DSubelementAddenda(String name, DSubelementAddendaType addendaType, String namespace, String xsdLocation) {
        super(name);
        meAddendaType = addendaType;
        msNamespace = namespace;
        msXsdLocation = xsdLocation;
    }
    
    public DSubelementAddendaType getAddendaType() { return meAddendaType; }
    public String getNamespace() { return msNamespace; }
    public String getXsdLocation() { return msXsdLocation; }
}
