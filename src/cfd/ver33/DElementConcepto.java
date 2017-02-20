package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementConcepto extends cfd.DElement {

    protected cfd.DAttributeString moAttClaveProdServ;
    protected cfd.DAttributeString moAttNoIdentificacion;
    protected cfd.DAttributeDouble moAttCantidad;
    protected cfd.DAttributeString moAttClaveUnidad;
    protected cfd.DAttributeString moAttUnidad;
    protected cfd.DAttributeString moAttDescripcion;
    protected cfd.DAttributeTypeImporte moAttValorUnitario;
    protected cfd.DAttributeTypeImporte moAttImporte;
    protected cfd.DAttributeTypeImporte moAttDescuento;

    protected cfd.ver33.DElementConceptoImpuestos moEltOpcConceptoImpuestos;
    protected java.util.Vector<cfd.ver33.DElementInformacionAduanera> mvEltHijosInformacionAduanera;
    protected cfd.ver33.DElementCuentaPredial moEltOpcCuentaPredial;
    protected cfd.ver33.DElementComplementoConcepto moEltOpcComplementoConcepto;
    protected java.util.Vector<cfd.ver33.DElementParte> mvEltHijosParte;

    public DElementConcepto() {
        super("cfdi:Concepto");

        moAttClaveProdServ = new DAttributeString("ClaveProdServ", true, 1);
        moAttNoIdentificacion = new DAttributeString("NoIdentificacion", false);
        moAttCantidad = new DAttributeDouble("Cantidad", true, 6);
        moAttClaveUnidad = new DAttributeString("ClaveUnidad", true, 1);
        moAttUnidad = new DAttributeString("Unidad", true, 1);
        moAttDescripcion = new DAttributeString("Descripcion", true, 1);
        moAttValorUnitario = new DAttributeTypeImporte("ValorUnitario", true);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);
        moAttDescuento = new DAttributeTypeImporte("Descuento", true);
        moAttDescuento.setCanBeZero(true);

        mvAttributes.add(moAttClaveProdServ);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttClaveUnidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);
        mvAttributes.add(moAttDescuento);

        moEltOpcConceptoImpuestos = null;
        mvEltHijosInformacionAduanera = new Vector<DElementInformacionAduanera>();
        moEltOpcCuentaPredial = null;
        moEltOpcComplementoConcepto = null;
        mvEltHijosParte = new Vector<DElementParte>();
    }

    public void setEltOpcConceptoImpuestos(cfd.ver33.DElementConceptoImpuestos o) { moEltOpcConceptoImpuestos = o; }
    public void setEltOpcCuentaPredial(cfd.ver33.DElementCuentaPredial o) { moEltOpcCuentaPredial = o; }
    public void setEltOpcComplementoConcepto(cfd.ver33.DElementComplementoConcepto o) { moEltOpcComplementoConcepto = o; }

    public cfd.DAttributeString getAttClaveProdServ() { return moAttClaveProdServ; }
    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttClaveUnidad() { return moAttClaveUnidad; }
    public cfd.DAttributeString getAttUnidad() { return moAttUnidad; }
    public cfd.DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporte getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    public cfd.DAttributeTypeImporte getAttDescuento() { return moAttDescuento; }

    public cfd.ver33.DElementConceptoImpuestos getEltImpuestos() { return moEltOpcConceptoImpuestos; }
    public java.util.Vector<cfd.ver33.DElementInformacionAduanera> getEltHijosInformacionAduanera() { return mvEltHijosInformacionAduanera; }
    public cfd.ver33.DElementCuentaPredial getEltOpcCuentaPredial() { return moEltOpcCuentaPredial; }
    public cfd.ver33.DElementComplementoConcepto getEltOpcComplementoConcepto() { return moEltOpcComplementoConcepto; }
    public java.util.Vector<cfd.ver33.DElementParte> getEltHijosParte() { return mvEltHijosParte; }

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

        if (moEltOpcConceptoImpuestos != null) {
            xml = moEltOpcConceptoImpuestos.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }
        
        for (DElementInformacionAduanera infoAduanera : mvEltHijosInformacionAduanera) {
            xml = infoAduanera.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcCuentaPredial != null) {
            xml = moEltOpcCuentaPredial.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        if (moEltOpcComplementoConcepto != null) {
            xml = moEltOpcComplementoConcepto.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        for (DElementParte parte : mvEltHijosParte) {
            xml = parte.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes
        
        if (moEltOpcConceptoImpuestos != null) {
            string += moEltOpcConceptoImpuestos.getElementForOriginalString();
        }
        
        for (DElementInformacionAduanera infoAduanera : mvEltHijosInformacionAduanera) {
            string += infoAduanera.getElementForOriginalString();
        }
        
        if (moEltOpcCuentaPredial != null) {
            string += moEltOpcCuentaPredial.getElementForOriginalString();
        }

        if (moEltOpcComplementoConcepto != null) {
            string += moEltOpcComplementoConcepto.getElementForOriginalString();
        }

        for (DElementParte parte : mvEltHijosParte) {
            string += parte.getElementForOriginalString();
        }

        return string;
    }
}
