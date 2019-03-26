/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeDate;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementReceptor extends cfd.DElement {
    
    protected cfd.DAttributeString moAttCurp;
    protected cfd.DAttributeString moAttNumSeguridadSocial;
    protected cfd.DAttributeDate moAttFechaInicioRelLaboral;
    protected cfd.DAttributeString moAttAntiguedad;
    protected cfd.DAttributeString moAttTipoContrato;
    protected cfd.DAttributeString moAttSindicalizado;
    protected cfd.DAttributeString moAttTipoJornada;
    protected cfd.DAttributeString moAttTipoRegimen;
    protected cfd.DAttributeString moAttNumEmpleado;
    protected cfd.DAttributeString moAttDepartamento;
    protected cfd.DAttributeString moAttPuesto;
    protected cfd.DAttributeString moAttRiesgoPuesto;
    protected cfd.DAttributeString moAttPeriodicidadPago;
    protected cfd.DAttributeString moAttBanco;
    protected cfd.DAttributeString moAttCuentaBancaria;
    protected cfd.DAttributeTypeImporte moAttSalarioBaseCotApor;
    protected cfd.DAttributeTypeImporte moAttSalarioDiarioIntegrado;
    protected cfd.DAttributeString moAttClaveEntFed;

    protected java.util.Vector<cfd.ver3.nom12.DElementSubcontratacion> mvEltHijosSubcontratacion;

    public DElementReceptor() {
        super("nomina12:Receptor");

        moAttCurp = new DAttributeString("Curp", true);
        moAttNumSeguridadSocial = new DAttributeString("NumSeguridadSocial", false);
        moAttFechaInicioRelLaboral = new DAttributeDate("FechaInicioRelLaboral", false);
        moAttAntiguedad = new DAttributeString("Antigüedad", false);
        moAttTipoContrato = new DAttributeString("TipoContrato", true);
        moAttSindicalizado = new DAttributeString("Sindicalizado", false);
        moAttTipoJornada = new DAttributeString("TipoJornada", false);
        moAttTipoRegimen = new DAttributeString("TipoRegimen", true, 2, 2);
        moAttNumEmpleado = new DAttributeString("NumEmpleado", true, 1, 15);
        moAttDepartamento = new DAttributeString("Departamento", false);
        moAttPuesto = new DAttributeString("Puesto", false);
        moAttRiesgoPuesto = new DAttributeString("RiesgoPuesto", false);
        moAttPeriodicidadPago = new DAttributeString("PeriodicidadPago", true);
        moAttBanco = new DAttributeString("Banco", false, 3, 3);
        moAttCuentaBancaria = new DAttributeString("CuentaBancaria", false);
        moAttSalarioBaseCotApor = new DAttributeTypeImporte("SalarioBaseCotApor", false);
        moAttSalarioDiarioIntegrado = new DAttributeTypeImporte("SalarioDiarioIntegrado", false);
        moAttClaveEntFed = new DAttributeString("ClaveEntFed", true);
        
        mvAttributes.add(moAttCurp);
        mvAttributes.add(moAttNumSeguridadSocial);
        mvAttributes.add(moAttFechaInicioRelLaboral);
        mvAttributes.add(moAttAntiguedad);
        mvAttributes.add(moAttTipoContrato);
        mvAttributes.add(moAttSindicalizado);
        mvAttributes.add(moAttTipoJornada);
        mvAttributes.add(moAttTipoRegimen);
        mvAttributes.add(moAttNumEmpleado);
        mvAttributes.add(moAttDepartamento);
        mvAttributes.add(moAttPuesto);
        mvAttributes.add(moAttRiesgoPuesto);
        mvAttributes.add(moAttPeriodicidadPago);
        mvAttributes.add(moAttBanco);
        mvAttributes.add(moAttCuentaBancaria);
        mvAttributes.add(moAttSalarioBaseCotApor);
        mvAttributes.add(moAttSalarioDiarioIntegrado);
        mvAttributes.add(moAttClaveEntFed);

        mvEltHijosSubcontratacion = new Vector<>();
    }

    public cfd.DAttributeString getAttNumEmpleado() { return moAttNumEmpleado; }
    public cfd.DAttributeString getAttCurp() { return moAttCurp; }
    public cfd.DAttributeString getAttTipoRegimen() { return moAttTipoRegimen; }
    public cfd.DAttributeString getAttNumSeguridadSocial() { return moAttNumSeguridadSocial; }
    public cfd.DAttributeString getAttDepartamento() { return moAttDepartamento; }
    public cfd.DAttributeString getAttCuentaBancaria() { return moAttCuentaBancaria; }
    public cfd.DAttributeString getAttBanco() { return moAttBanco; }
    public cfd.DAttributeDate getAttFechaInicioRelLaboral() { return moAttFechaInicioRelLaboral; }
    public cfd.DAttributeString getAttAntiguedad() { return moAttAntiguedad; }
    public cfd.DAttributeString getAttPuesto() { return moAttPuesto; }
    public cfd.DAttributeString getAttTipoContrato() { return moAttTipoContrato; }
    public cfd.DAttributeString getAttTipoJornada() { return moAttTipoJornada; }
    public cfd.DAttributeString getAttPeriodicidadPago() { return moAttPeriodicidadPago; }
    public cfd.DAttributeTypeImporte getAttSalarioBaseCotApor() { return moAttSalarioBaseCotApor; }
    public cfd.DAttributeString getAttRiesgoPuesto() { return moAttRiesgoPuesto; }
    public cfd.DAttributeTypeImporte getAttSalarioDiarioIntegrado() { return moAttSalarioDiarioIntegrado; }
    public cfd.DAttributeString getAttSindicalizado() { return moAttSindicalizado; }
    public cfd.DAttributeString getAttClaveEntFed() { return moAttClaveEntFed; }

    public java.util.Vector<cfd.ver3.nom12.DElementSubcontratacion> getEltHijosSubcontratacion() { return mvEltHijosSubcontratacion; }

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

        for (DElementSubcontratacion subcontratacion : mvEltHijosSubcontratacion) {
            xml = subcontratacion.getElementForXml();
            string += xml.isEmpty() ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString();    // for element attributes and element validation 

        for (DElementSubcontratacion subcontratacion : mvEltHijosSubcontratacion) {
            string += subcontratacion.getElementForOriginalString();
        }

        return string;
    }
}
