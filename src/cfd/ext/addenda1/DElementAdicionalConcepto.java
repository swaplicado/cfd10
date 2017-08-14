/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.addenda1;

import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DAttributeTypeImporteUnitario;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAdicionalConcepto extends cfd.DElementParent {

    protected cfd.DAttributeString moAttClaveConcepto;
    protected cfd.DAttributeString moAttPresentacion;
    protected cfd.DAttributeTypeImporteUnitario moAttDescuentoUnitario;
    protected cfd.DAttributeTypeImporte moAttDescuento;
    protected cfd.DAttributeDouble moAttPesoBruto;
    protected cfd.DAttributeDouble moAttPesoNeto;

    protected cfd.ext.addenda1.DElementNotas moEltOpcNotas;

    public DElementAdicionalConcepto() {
        super("myadd:AdicionalConcepto");

        moAttClaveConcepto = new DAttributeString("claveConcepto", true, 1);
        moAttPresentacion = new DAttributeString("presentacion", false, 1);
        moAttDescuentoUnitario = new DAttributeTypeImporteUnitario("descuentoUnitario", false);
        moAttDescuento = new DAttributeTypeImporte("descuento", false);
        moAttPesoBruto = new DAttributeDouble("pesoBruto", false, 8);
        moAttPesoNeto = new DAttributeDouble("pesoNeto", false, 8);

        mvAttributes.add(moAttClaveConcepto);
        mvAttributes.add(moAttPresentacion);
        mvAttributes.add(moAttDescuentoUnitario);
        mvAttributes.add(moAttDescuento);
        mvAttributes.add(moAttPesoBruto);
        mvAttributes.add(moAttPesoNeto);

        moEltOpcNotas = null;
    }

    public void setEltOpcNotas(cfd.ext.addenda1.DElementNotas o) {
        if (moEltOpcNotas != null) {
            mvElements.remove(moEltOpcNotas);
        }

        moEltOpcNotas = o;
        mvElements.add(moEltOpcNotas);
    }

    public cfd.DAttributeString getAttClaveConcepto() { return moAttClaveConcepto; }
    public cfd.DAttributeString getAttPresentacion() { return moAttPresentacion; }
    public cfd.DAttributeTypeImporteUnitario getAttDescuentoUnitario() { return moAttDescuentoUnitario; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }
    public cfd.DAttributeDouble getAttPesoBruto() { return moAttPesoBruto; }
    public cfd.DAttributeDouble getAttPesoNeto() { return moAttPesoNeto; }

    public cfd.ext.addenda1.DElementNotas getEltOpcNotas() { return moEltOpcNotas; }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
