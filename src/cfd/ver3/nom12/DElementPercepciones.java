/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPercepciones extends cfd.DElement {

    protected cfd.DAttributeTypeImporte moAttTotalSueldos;
    protected cfd.DAttributeTypeImporte moAttTotalSeparacionIndemnizacion;
    protected cfd.DAttributeTypeImporte moAttTotalJubilacionPensionRetiro;
    protected cfd.DAttributeTypeImporte moAttTotalGravado;
    protected cfd.DAttributeTypeImporte moAttTotalExento;

    protected java.util.Vector<cfd.ver3.nom12.DElementPercepcion> mvEltHijosPercepcion;
    protected cfd.ver3.nom12.DElementJubilacionPensionRetiro moEltJubilacionPensionRetiro;
    protected cfd.ver3.nom12.DElementSeparacionIndemnizacion moEltSeparacionIndemnizacion;

    public DElementPercepciones() {
        super("nomina12:Percepciones");

        moAttTotalSueldos = new DAttributeTypeImporte("TotalSueldos", false);
        moAttTotalSueldos.setCanBeZero(true);
        moAttTotalSeparacionIndemnizacion = new DAttributeTypeImporte("TotalSeparacionIndemnizacion", false);
        moAttTotalJubilacionPensionRetiro = new DAttributeTypeImporte("TotalJubilacionPensionRetiro", false);
        moAttTotalGravado = new DAttributeTypeImporte("TotalGravado", true);
        moAttTotalGravado.setCanBeZero(true);
        moAttTotalExento = new DAttributeTypeImporte("TotalExento", true);
        moAttTotalExento.setCanBeZero(true);

        mvAttributes.add(moAttTotalSueldos);
        mvAttributes.add(moAttTotalSeparacionIndemnizacion);
        mvAttributes.add(moAttTotalJubilacionPensionRetiro);
        mvAttributes.add(moAttTotalGravado);
        mvAttributes.add(moAttTotalExento);

        mvEltHijosPercepcion = new Vector<>();
        moEltJubilacionPensionRetiro = null;
        moEltSeparacionIndemnizacion = null;
    }

    public cfd.DAttributeTypeImporte getAttTotalSueldos() { return moAttTotalSueldos; }
    public cfd.DAttributeTypeImporte getAttTotalSeparacionIndemnizacion() { return moAttTotalSeparacionIndemnizacion; }
    public cfd.DAttributeTypeImporte getAttTotalJubilacionPensionRetiro() { return moAttTotalJubilacionPensionRetiro; }
    public cfd.DAttributeTypeImporte getAttTotalGravado() { return moAttTotalGravado; }
    public cfd.DAttributeTypeImporte getAttTotalExento() { return moAttTotalExento; }

    public void setEltJubilacionPensionRetiro(cfd.ver3.nom12.DElementJubilacionPensionRetiro o) { moEltJubilacionPensionRetiro = o; }
    public void setEltSeparacionIndemnizacion(cfd.ver3.nom12.DElementSeparacionIndemnizacion o) { moEltSeparacionIndemnizacion = o; }
    
    public cfd.ver3.nom12.DElementJubilacionPensionRetiro getEltJubilacionPensionRetiro() { return moEltJubilacionPensionRetiro; }
    public cfd.ver3.nom12.DElementSeparacionIndemnizacion getEltSeparacionIndemnizacion() { return moEltSeparacionIndemnizacion; }
    
    public java.util.Vector<cfd.ver3.nom12.DElementPercepcion> getEltHijosPercepcion() { return mvEltHijosPercepcion; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        if (mvEltHijosPercepcion.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ver3.nom12.DElementPercepcion().getName()) + "'.");
        }
        else {
            for (DElementPercepcion percepcion : mvEltHijosPercepcion) {
                xml = percepcion.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }
        
        if (moEltJubilacionPensionRetiro != null) {
            xml = moEltJubilacionPensionRetiro.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltSeparacionIndemnizacion != null) {
            xml = moEltSeparacionIndemnizacion.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes and element validation 
        
        for (DElementPercepcion percepcion : mvEltHijosPercepcion) {
            string += percepcion.getElementForOriginalString();
        }
        
        if (moEltJubilacionPensionRetiro != null) {
            string += moEltJubilacionPensionRetiro.getElementForOriginalString();
        }
        
        if (moEltSeparacionIndemnizacion != null) {
            string += moEltSeparacionIndemnizacion.getElementForOriginalString();
        }

        return string;
    }
}
