/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementPercepcion extends cfd.DElement {

    protected cfd.DAttributeString moAttTipoPercepcion;
    protected cfd.DAttributeString moAttClave;
    protected cfd.DAttributeString moAttConcepto;
    protected cfd.DAttributeTypeImporte moAttImporteGravado;
    protected cfd.DAttributeTypeImporte moAttImporteExento;
    
    protected cfd.ver3.nom12.DElementAccionesTitulos moEltAccionesTitulos;
    protected java.util.Vector<cfd.ver3.nom12.DElementHorasExtra> mvEltHijosHorasExtra;

    public DElementPercepcion() {
        super("nomina12:Percepcion");

        moAttTipoPercepcion = new DAttributeString("TipoPercepcion", true, 3, 3);
        moAttClave = new DAttributeString("Clave", true, 3, 15);// Existe un patron
        moAttConcepto = new DAttributeString("Concepto", true, 1);// Existe un patron
        moAttImporteGravado = new DAttributeTypeImporte("ImporteGravado", true);
        moAttImporteGravado.setCanBeZero(true);
        moAttImporteExento = new DAttributeTypeImporte("ImporteExento", true);
        moAttImporteExento.setCanBeZero(true);

        mvAttributes.add(moAttTipoPercepcion);
        mvAttributes.add(moAttClave);
        mvAttributes.add(moAttConcepto);
        mvAttributes.add(moAttImporteGravado);
        mvAttributes.add(moAttImporteExento);

        moEltAccionesTitulos = null;
        mvEltHijosHorasExtra = new Vector<DElementHorasExtra>();
    }

    public cfd.DAttributeString getAttTipoPercepcion() { return moAttTipoPercepcion; }
    public cfd.DAttributeString getAttClave() { return moAttClave; }
    public cfd.DAttributeString getAttConcepto() { return moAttConcepto; }
    public cfd.DAttributeTypeImporte getAttImporteGravado() { return moAttImporteGravado; }
    public cfd.DAttributeTypeImporte getAttImporteExento() { return moAttImporteExento; }
    
    public void setEltAccionesTitulos(cfd.ver3.nom12.DElementAccionesTitulos o) { moEltAccionesTitulos = o; }
    public cfd.ver3.nom12.DElementAccionesTitulos getEltAccionesTitulos() { return moEltAccionesTitulos; }
    
    public java.util.Vector<cfd.ver3.nom12.DElementHorasExtra> getEltHijosHorasExtra() { return mvEltHijosHorasExtra; }
    
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

        if (moEltAccionesTitulos != null) {
            xml = moEltAccionesTitulos.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        for (DElementHorasExtra horasExtra : mvEltHijosHorasExtra) {
            xml = horasExtra.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();
        
        if (moEltAccionesTitulos != null) {
            string += moEltAccionesTitulos.getElementForOriginalString();
        }
        
        for (DElementHorasExtra horaExtra : mvEltHijosHorasExtra) {
            string += horaExtra.getElementForOriginalString();
        }

        return string;
    }
}
