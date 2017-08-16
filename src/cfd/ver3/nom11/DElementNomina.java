/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom11;

import cfd.DAttribute;
import cfd.DAttributeDate;
import cfd.DAttributeDouble;
import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementNomina extends cfd.DElement {

    protected cfd.DAttributeString moAttVersion;
    protected cfd.DAttributeString moAttRegistroPatronal;
    protected cfd.DAttributeString moAttNumEmpleado;
    protected cfd.DAttributeString moAttCurp;
    protected cfd.DAttributeInteger moAttTipoRegimen;
    protected cfd.DAttributeString moAttNumSeguridadSocial;
    protected cfd.DAttributeDate moAttFechaPago;
    protected cfd.DAttributeDate moAttFechaInicialPago;
    protected cfd.DAttributeDate moAttFechaFinalPago;
    protected cfd.DAttributeDouble moAttNumDiasPagados;
    protected cfd.DAttributeString moAttDepartamento;
    protected cfd.DAttributeString moAttClabe;
    protected cfd.DAttributeInteger moAttBanco;
    protected cfd.DAttributeDate moAttFechaInicioRelLaboral;
    protected cfd.DAttributeInteger moAttAntiguedad;
    protected cfd.DAttributeString moAttPuesto;
    protected cfd.DAttributeString moAttTipoContrato;
    protected cfd.DAttributeString moAttTipoJornada;
    protected cfd.DAttributeString moAttPeriodicidadPago;
    protected cfd.DAttributeTypeImporte moAttSalarioBaseCotApor;
    protected cfd.DAttributeInteger moAttRiesgoPuesto;
    protected cfd.DAttributeTypeImporte moAttSalarioDiarioIntegrado;

    protected cfd.ver3.nom11.DElementPercepciones moEltPercepciones;
    protected cfd.ver3.nom11.DElementDeducciones moEltDeducciones;
    protected cfd.ver3.nom11.DElementIncapacidades moEltIncapacidades;
    protected cfd.ver3.nom11.DElementHorasExtras moEltHorasExtras;

    public DElementNomina() {
        super("nomina:Nomina");

        moAttVersion = new DAttributeString("Version", true);
        moAttVersion.setString("1.1");
        moAttRegistroPatronal = new DAttributeString("RegistroPatronal", false);
        moAttNumEmpleado = new DAttributeString("NumEmpleado", true);
        moAttCurp = new DAttributeString("CURP", true);
        moAttTipoRegimen = new DAttributeInteger("TipoRegimen", true);
        moAttNumSeguridadSocial = new DAttributeString("NumSeguridadSocial", false);
        moAttFechaPago = new DAttributeDate("FechaPago", true);
        moAttFechaInicialPago = new DAttributeDate("FechaInicialPago", true);
        moAttFechaFinalPago = new DAttributeDate("FechaFinalPago", true);
        moAttNumDiasPagados = new DAttributeDouble("NumDiasPagados", true, 6);
        moAttNumDiasPagados.setCanBeZero(true);
        moAttDepartamento = new DAttributeString("Departamento", false);
        moAttClabe = new DAttributeString("CLABE", false);
        moAttBanco = new DAttributeInteger("Banco", false, 1, 3, 3);
        moAttFechaInicioRelLaboral = new DAttributeDate("FechaInicioRelLaboral", false);
        moAttAntiguedad = new DAttributeInteger("Antiguedad", false);
        moAttPuesto = new DAttributeString("Puesto", false);
        moAttTipoContrato = new DAttributeString("TipoContrato", false);
        moAttTipoJornada = new DAttributeString("TipoJornada", false);
        moAttPeriodicidadPago = new DAttributeString("PeriodicidadPago", true);
        moAttSalarioBaseCotApor = new DAttributeTypeImporte("SalarioBaseCotApor", false);
        moAttRiesgoPuesto = new DAttributeInteger("RiesgoPuesto", false);
        moAttSalarioDiarioIntegrado = new DAttributeTypeImporte("SalarioDiarioIntegrado", false);

        mvAttributes.add(moAttVersion);
        mvAttributes.add(moAttRegistroPatronal);
        mvAttributes.add(moAttNumEmpleado);
        mvAttributes.add(moAttCurp);
        mvAttributes.add(moAttTipoRegimen);
        mvAttributes.add(moAttNumSeguridadSocial);
        mvAttributes.add(moAttFechaPago);
        mvAttributes.add(moAttFechaInicialPago);
        mvAttributes.add(moAttFechaFinalPago);
        mvAttributes.add(moAttNumDiasPagados);
        mvAttributes.add(moAttDepartamento);
        mvAttributes.add(moAttClabe);
        mvAttributes.add(moAttBanco);
        mvAttributes.add(moAttFechaInicioRelLaboral);
        mvAttributes.add(moAttAntiguedad);
        mvAttributes.add(moAttPuesto);
        mvAttributes.add(moAttTipoContrato);
        mvAttributes.add(moAttTipoJornada);
        mvAttributes.add(moAttPeriodicidadPago);
        mvAttributes.add(moAttSalarioBaseCotApor);
        mvAttributes.add(moAttRiesgoPuesto);
        mvAttributes.add(moAttSalarioDiarioIntegrado);

        moEltPercepciones = null;
        moEltDeducciones = null;
        moEltIncapacidades = null;
        moEltHorasExtras = null;
    }

    public void setEltPercepciones(cfd.ver3.nom11.DElementPercepciones o) { moEltPercepciones = o; }
    public void setEltDeducciones(cfd.ver3.nom11.DElementDeducciones o) { moEltDeducciones = o; }
    public void setEltIncapacidades(cfd.ver3.nom11.DElementIncapacidades o) { moEltIncapacidades = o; }
    public void setEltHorasExtras(cfd.ver3.nom11.DElementHorasExtras o) { moEltHorasExtras = o; }
    
    public cfd.DAttributeString getAttVersion() { return moAttVersion; }
    public cfd.DAttributeString getAttRegistroPatronal() { return moAttRegistroPatronal; }
    public cfd.DAttributeString getAttNumEmpleado() { return moAttNumEmpleado; }
    public cfd.DAttributeString getAttCurp() { return moAttCurp; }
    public cfd.DAttributeInteger getAttTipoRegimen() { return moAttTipoRegimen; }
    public cfd.DAttributeString getAttNumSeguridadSocial() { return moAttNumSeguridadSocial; }
    public cfd.DAttributeDate getAttFechaPago() { return moAttFechaPago; }
    public cfd.DAttributeDate getAttFechaInicialPago() { return moAttFechaInicialPago; }
    public cfd.DAttributeDate getAttFechaFinalPago() { return moAttFechaFinalPago; }
    public cfd.DAttributeDouble getAttNumDiasPagados() { return moAttNumDiasPagados; }
    public cfd.DAttributeString getAttDepartamento() { return moAttDepartamento; }
    public cfd.DAttributeString getAttClabe() { return moAttClabe; }
    public cfd.DAttributeInteger getAttBanco() { return moAttBanco; }
    public cfd.DAttributeDate getAttFechaInicioRelLaboral() { return moAttFechaInicioRelLaboral; }
    public cfd.DAttributeInteger getAttAntiguedad() { return moAttAntiguedad; }
    public cfd.DAttributeString getAttPuesto() { return moAttPuesto; }
    public cfd.DAttributeString getAttTipoContrato() { return moAttTipoContrato; }
    public cfd.DAttributeString getAttTipoJornada() { return moAttTipoJornada; }
    public cfd.DAttributeString getAttPeriodicidadPago() { return moAttPeriodicidadPago; }
    public cfd.DAttributeTypeImporte getAttSalarioBaseCotApor() { return moAttSalarioBaseCotApor; }
    public cfd.DAttributeInteger getAttRiesgoPuesto() { return moAttRiesgoPuesto; }
    public cfd.DAttributeTypeImporte getAttSalarioDiarioIntegrado() { return moAttSalarioDiarioIntegrado; }

    public cfd.ver3.nom11.DElementPercepciones getEltPercepciones() { return moEltPercepciones; }
    public cfd.ver3.nom11.DElementDeducciones getEltDeducciones() { return moEltDeducciones; }
    public cfd.ver3.nom11.DElementIncapacidades getEltIncapacidades() { return moEltIncapacidades; }
    public cfd.ver3.nom11.DElementHorasExtras getEltHorasExtras() { return moEltHorasExtras; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName + " " +
                "xsi:schemaLocation=\"http://www.sat.gob.mx/nomina  http://www.sat.gob.mx/sitio_internet/cfd/nomina/nomina11.xsd\" " +
                "xmlns:nomina=\"http://www.sat.gob.mx/nomina\"";

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        if (moEltPercepciones != null) {
            xml = moEltPercepciones.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltDeducciones != null) {
            xml = moEltDeducciones.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltIncapacidades != null) {
            xml = moEltIncapacidades.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }
        
        if (moEltHorasExtras != null) {
            xml = moEltHorasExtras.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = "";

        string += moAttVersion.getAttributeForOriginalString();
        string += moAttRegistroPatronal.getAttributeForOriginalString();
        string += moAttNumEmpleado.getAttributeForOriginalString();
        string += moAttCurp.getAttributeForOriginalString();
        string += moAttTipoRegimen.getAttributeForOriginalString();
        string += moAttNumSeguridadSocial.getAttributeForOriginalString();
        string += moAttFechaPago.getAttributeForOriginalString();
        string += moAttFechaInicialPago.getAttributeForOriginalString();
        string += moAttFechaFinalPago.getAttributeForOriginalString();
        string += moAttNumDiasPagados.getAttributeForOriginalString();
        string += moAttDepartamento.getAttributeForOriginalString();
        string += moAttClabe.getAttributeForOriginalString();
        string += moAttBanco.getAttributeForOriginalString();
        string += moAttFechaInicioRelLaboral.getAttributeForOriginalString();
        string += moAttAntiguedad.getAttributeForOriginalString();
        string += moAttPuesto.getAttributeForOriginalString();
        string += moAttTipoContrato.getAttributeForOriginalString();
        string += moAttTipoJornada.getAttributeForOriginalString();
        string += moAttPeriodicidadPago.getAttributeForOriginalString();
        string += moAttSalarioBaseCotApor.getAttributeForOriginalString();
        string += moAttRiesgoPuesto.getAttributeForOriginalString();
        string += moAttSalarioDiarioIntegrado.getAttributeForOriginalString();

        if (moEltPercepciones != null) {
            string += moEltPercepciones.getElementForOriginalString();
        }
        
        if (moEltDeducciones != null) {
            string += moEltDeducciones.getElementForOriginalString();
        }
        
        if (moEltIncapacidades != null) {
            string += moEltIncapacidades.getElementForOriginalString();
        }
        
        if (moEltHorasExtras != null) {
            string += moEltHorasExtras.getElementForOriginalString();
        }
        
        return string;
    }
}
