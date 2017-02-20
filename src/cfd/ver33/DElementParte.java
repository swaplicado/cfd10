package cfd.ver33;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DAttributeTypeImporteUnitario;
import java.util.Vector;

/**
 *
 * @author Juan Barajas
 */
public class DElementParte extends cfd.DElement {

    protected cfd.DAttributeString moAttClaveProdServ;
    protected cfd.DAttributeString moAttNoIdentificacion;
    protected cfd.DAttributeDouble moAttCantidad;
    protected cfd.DAttributeString moAttUnidad;
    protected cfd.DAttributeString moAttDescripcion;
    protected cfd.DAttributeTypeImporteUnitario moAttValorUnitario;
    protected cfd.DAttributeTypeImporte moAttImporte;

    protected java.util.Vector<cfd.ver33.DElementInformacionAduanera> mvEltHijosInformacionAduanera;

    public DElementParte() {
        super("cfdi:Parte");

        moAttClaveProdServ = new DAttributeString("ClaveProdServ", true, 1);
        moAttNoIdentificacion = new DAttributeString("NoIdentificacion", false);
        moAttCantidad = new DAttributeDouble("Cantidad", true, 4);
        moAttUnidad = new DAttributeString("Unidad", false);
        moAttDescripcion = new DAttributeString("Descripcion", true, 1);
        moAttValorUnitario = new DAttributeTypeImporteUnitario("ValorUnitario", true);
        moAttValorUnitario.setCanBeZero(true);
        moAttImporte = new DAttributeTypeImporte("Importe", true);
        moAttImporte.setCanBeZero(true);

        mvAttributes.add(moAttClaveProdServ);
        mvAttributes.add(moAttNoIdentificacion);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttValorUnitario);
        mvAttributes.add(moAttImporte);

        mvEltHijosInformacionAduanera = new Vector<DElementInformacionAduanera>();
    }

    public cfd.DAttributeString getAttClaveProdServ() { return moAttClaveProdServ; }
    public cfd.DAttributeString getAttNoIdentificacion() { return moAttNoIdentificacion; }
    public cfd.DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public cfd.DAttributeString getAttUnidad() { return moAttUnidad; }
    public cfd.DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public cfd.DAttributeTypeImporteUnitario getAttValorUnitario() { return moAttValorUnitario; }
    public cfd.DAttributeTypeImporte getAttImporte() { return moAttImporte; }
    
    public java.util.Vector<cfd.ver33.DElementInformacionAduanera> getEltHijosInformacionAduanera() { return mvEltHijosInformacionAduanera; }

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
        
        for (DElementInformacionAduanera infoAduanera : mvEltHijosInformacionAduanera) {
            xml = infoAduanera.getElementForXml();
            string += xml.length() == 0 ? "" : "\n" + xml;
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = super.getElementForOriginalString();    // for element attributes

        for (DElementInformacionAduanera infoAduanera : mvEltHijosInformacionAduanera) {
            string += infoAduanera.getElementForOriginalString();
        }

        return string;
    }
}
