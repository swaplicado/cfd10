/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.nom12;

import cfd.DAttribute;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Juan Barajas
 */
public class DElementOtroPago extends cfd.DElement {

    protected cfd.DAttributeString moAttTipoOtroPago;
    protected cfd.DAttributeString moAttClave;
    protected cfd.DAttributeString moAttConcepto;
    protected cfd.DAttributeTypeImporte moAttImporte;
    
    protected cfd.ver3.nom12.DElementSubsidioEmpleo moEltSubsidioEmpleo;
    protected cfd.ver3.nom12.DElementCompensacionSaldosFavor moEltCompensacionSaldosFavor;

    public DElementOtroPago() {
        super("nomina:OtroPago");

        moAttTipoOtroPago = new DAttributeString("TipoOtroPago", true);
        moAttClave = new DAttributeString("Clave", true, 3, 15);
        moAttConcepto = new DAttributeString("Concepto", true, 1);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttTipoOtroPago);
        mvAttributes.add(moAttClave);
        mvAttributes.add(moAttConcepto);
        mvAttributes.add(moAttImporte);
        
        moEltSubsidioEmpleo = null;
        moEltCompensacionSaldosFavor = null;
    }
    
    public cfd.DAttributeString getAttTipoOtroPago() { return moAttTipoOtroPago; }
    public cfd.DAttributeString getAttClave() { return moAttClave; }
    public cfd.DAttributeString getAttConcepto() { return moAttConcepto; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }

    public void setEltSubsidioEmpleo(cfd.ver3.nom12.DElementSubsidioEmpleo o) { moEltSubsidioEmpleo = o; }
    public void setEltCompensacionSaldosFavor(cfd.ver3.nom12.DElementCompensacionSaldosFavor o) { moEltCompensacionSaldosFavor = o; }
    
    public cfd.ver3.nom12.DElementSubsidioEmpleo getEltSubsidioEmpleo() { return moEltSubsidioEmpleo; }
    public cfd.ver3.nom12.DElementCompensacionSaldosFavor getEltCompensacionSaldosFavor() { return moEltCompensacionSaldosFavor; }
    
    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        if (moEltSubsidioEmpleo != null) {
            xml = moEltSubsidioEmpleo.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        if (moEltCompensacionSaldosFavor != null) {
            xml = moEltCompensacionSaldosFavor.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();
        
        if (moEltSubsidioEmpleo != null) {
            string += moEltSubsidioEmpleo.getElementForOriginalString();
        }
        
        if (moEltCompensacionSaldosFavor != null) {
            string += moEltCompensacionSaldosFavor.getElementForOriginalString();
        }

        return string;
    }
}
