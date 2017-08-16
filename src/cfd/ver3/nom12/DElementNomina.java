/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeDate;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementNomina extends cfd.DElement {
    
    public static final String XSI = "http://www.sat.gob.mx/nomina  http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina12.xsd";
    public static final String XMLNS = "xmlns:nomina12=\"http://www.sat.gob.mx/nomina12\"";

    protected cfd.DAttributeString moAttVersion;
    protected cfd.DAttributeString moAttTipoNomina;
    protected cfd.DAttributeDate moAttFechaPago;
    protected cfd.DAttributeDate moAttFechaInicialPago;
    protected cfd.DAttributeDate moAttFechaFinalPago;
    protected cfd.DAttributeDouble moAttNumDiasPagados;
    protected cfd.DAttributeTypeImporte moAttTotalPercepciones;
    protected cfd.DAttributeTypeImporte moAttTotalDeducciones;
    protected cfd.DAttributeTypeImporte moAttTotalOtrosPagos;

    protected cfd.ver3.nom12.DElementEmisor moEltEmisor;
    protected cfd.ver3.nom12.DElementReceptor moEltReceptor;
    protected cfd.ver3.nom12.DElementPercepciones moEltPercepciones;
    protected cfd.ver3.nom12.DElementDeducciones moEltDeducciones;
    protected cfd.ver3.nom12.DElementOtrosPagos moEltOtrosPagos;
    protected cfd.ver3.nom12.DElementIncapacidades moEltIncapacidades;

    public DElementNomina() {
        super("nomina12:Nomina");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString("1.2");
        moAttTipoNomina = new DAttributeString("TipoNomina", true);
        moAttFechaPago = new DAttributeDate("FechaPago", true);
        moAttFechaInicialPago = new DAttributeDate("FechaInicialPago", true);
        moAttFechaFinalPago = new DAttributeDate("FechaFinalPago", true);
        moAttNumDiasPagados = new DAttributeDouble("NumDiasPagados", true, 3);
        moAttTotalPercepciones = new DAttributeTypeImporte("TotalPercepciones", false);
        moAttTotalDeducciones = new DAttributeTypeImporte("TotalDeducciones", false);
        moAttTotalOtrosPagos = new DAttributeTypeImporte("TotalOtrosPagos", false);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttTipoNomina);
        mvAttributes.add(moAttFechaPago);
        mvAttributes.add(moAttFechaInicialPago);
        mvAttributes.add(moAttFechaFinalPago);
        mvAttributes.add(moAttNumDiasPagados);
        mvAttributes.add(moAttTotalPercepciones);
        mvAttributes.add(moAttTotalDeducciones);
        mvAttributes.add(moAttTotalOtrosPagos);

        moEltEmisor = null;
        moEltReceptor = new DElementReceptor();
        moEltPercepciones = null;
        moEltDeducciones = null;
        moEltOtrosPagos = null;
        moEltIncapacidades = null;
    }
    
    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttTipoNomina() { return moAttTipoNomina; }
    public cfd.DAttributeDate getAttFechaPago() { return moAttFechaPago; }
    public cfd.DAttributeDate getAttFechaInicialPago() { return moAttFechaInicialPago; }
    public cfd.DAttributeDate getAttFechaFinalPago() { return moAttFechaFinalPago; }
    public cfd.DAttributeDouble getAttNumDiasPagados() { return moAttNumDiasPagados; }
    public cfd.DAttributeTypeImporte getAttTotalPercepciones() { return moAttTotalPercepciones; }
    public cfd.DAttributeTypeImporte getAttTotalDeducciones() { return moAttTotalDeducciones; }
    public cfd.DAttributeTypeImporte getAttTotalOtrosPagos() { return moAttTotalOtrosPagos; }
    
    public void setEltEmisor(cfd.ver3.nom12.DElementEmisor o) { moEltEmisor = o; }
    public void setEltReceptor(cfd.ver3.nom12.DElementReceptor o) { moEltReceptor = o; }
    public void setEltPercepciones(cfd.ver3.nom12.DElementPercepciones o) { moEltPercepciones = o; }
    public void setEltDeducciones(cfd.ver3.nom12.DElementDeducciones o) { moEltDeducciones = o; }
    public void setEltOtrosPagos(cfd.ver3.nom12.DElementOtrosPagos o) { moEltOtrosPagos = o; }
    public void setEltIncapacidades(cfd.ver3.nom12.DElementIncapacidades o) { moEltIncapacidades = o; }

    public cfd.ver3.nom12.DElementEmisor getEltEmisor() { return moEltEmisor; }
    public cfd.ver3.nom12.DElementReceptor getEltReceptor() { return moEltReceptor; }
    public cfd.ver3.nom12.DElementPercepciones getEltPercepciones() { return moEltPercepciones; }
    public cfd.ver3.nom12.DElementDeducciones getEltDeducciones() { return moEltDeducciones; }
    public cfd.ver3.nom12.DElementOtrosPagos getEltOtrosPagos() { return moEltOtrosPagos; }
    public cfd.ver3.nom12.DElementIncapacidades getEltIncapacidades() { return moEltIncapacidades; }

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

        if (moEltEmisor != null) {
            xml = moEltEmisor.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        xml = moEltReceptor.getElementForXml();
        string += xml.isEmpty() ? "" : "\n" + xml;
        
        if (moEltPercepciones != null) {
            xml = moEltPercepciones.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltDeducciones != null) {
            xml = moEltDeducciones.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltOtrosPagos != null) {
            xml = moEltOtrosPagos.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltIncapacidades != null) {
            xml = moEltIncapacidades.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes and element validation 

        if (moEltEmisor != null) {
            string += moEltEmisor.getElementForOriginalString();
        }
        
        string += moEltReceptor.getElementForOriginalString();
        
        if (moEltPercepciones != null) {
            string += moEltPercepciones.getElementForOriginalString();
        }
        
        if (moEltDeducciones != null) {
            string += moEltDeducciones.getElementForOriginalString();
        }
        
        if (moEltOtrosPagos != null) {
            string += moEltOtrosPagos.getElementForOriginalString();
        }
        
        if (moEltIncapacidades != null) {
            string += moEltIncapacidades.getElementForOriginalString();
        }
        
        return string;
    }
}
