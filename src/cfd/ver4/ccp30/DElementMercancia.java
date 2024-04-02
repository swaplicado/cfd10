/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver4.ccp30;

import cfd.DAttribute;
import cfd.DAttributeDouble;
import cfd.DAttributeString;
import cfd.DAttributeTypeImporte;
import cfd.DElement;
import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez, Isabel García
 */
public class DElementMercancia extends cfd.DElement {

    private final DAttributeString moAttBienesTransp;
    private final DAttributeString moAttClaveSTCC;
    private final DAttributeString moAttDescripcion;
    private final DAttributeDouble moAttCantidad;
    private final DAttributeString moAttClaveUnidad;
    private final DAttributeString moAttUnidad;
    private final DAttributeString moAttDimensiones;
    private final DAttributeString moAttMaterialPeligroso;
    private final DAttributeString moAttCveMaterialPeligroso;
    private final DAttributeString moAttEmbalaje;
    private final DAttributeString moAttDescripEmbalaje;
    private final DAttributeString moAttSectorCOFEPRIS;
    private final DAttributeDouble moAttPesoEnKg;
    private final DAttributeTypeImporte moAttValorMercancia;
    private final DAttributeString moAttMoneda;
    private final DAttributeString moAttFraccionArancelaria;
    private final DAttributeString moAttUUIDComercioExt;
    
    private final ArrayList<DElementCantidadTransporta> maEltCantidadTransportas;
    private ArrayList<DElementDocumentacionAduanera> maEltDocumentacionAduaneras;
    
    public DElementMercancia() {
        super("cartaporte30:Mercancia");
        
        moAttBienesTransp = new DAttributeString("BienesTransp", true);
        moAttClaveSTCC = new DAttributeString("ClaveSTCC", false, 6, 7);
        moAttDescripcion = new DAttributeString("Descripcion", true, 1, 1000);
        moAttCantidad = new DAttributeDouble("Cantidad", true, 6);
        moAttClaveUnidad = new DAttributeString("ClaveUnidad", true);
        moAttUnidad = new DAttributeString("Unidad", false, 1, 20);
        moAttDimensiones = new DAttributeString("Dimensiones", false);
        moAttMaterialPeligroso = new DAttributeString("MaterialPeligroso", false);
        moAttCveMaterialPeligroso = new DAttributeString("CveMaterialPeligroso", false);
        moAttEmbalaje = new DAttributeString("Embalaje", false);
        moAttDescripEmbalaje = new DAttributeString("DescripEmbalaje", false, 1, 100);
        moAttSectorCOFEPRIS = new DAttributeString("SectorCOFEPRIS", false);
        moAttPesoEnKg = new DAttributeDouble("PesoEnKg", true, 3);
        moAttValorMercancia = new DAttributeTypeImporte("ValorMercancia", false);
        moAttMoneda = new DAttributeString("Moneda", false);
        moAttFraccionArancelaria = new DAttributeString("FraccionArancelaria", false);
        moAttUUIDComercioExt = new DAttributeString("UUIDComercioExt", false);
        
        mvAttributes.add(moAttBienesTransp);
        mvAttributes.add(moAttClaveSTCC);
        mvAttributes.add(moAttDescripcion);
        mvAttributes.add(moAttCantidad);
        mvAttributes.add(moAttClaveUnidad);
        mvAttributes.add(moAttUnidad);
        mvAttributes.add(moAttDimensiones);
        mvAttributes.add(moAttMaterialPeligroso);
        mvAttributes.add(moAttCveMaterialPeligroso);
        mvAttributes.add(moAttEmbalaje);
        mvAttributes.add(moAttDescripEmbalaje);
        mvAttributes.add(moAttSectorCOFEPRIS);
        mvAttributes.add(moAttPesoEnKg);
        mvAttributes.add(moAttValorMercancia);
        mvAttributes.add(moAttMoneda);
        mvAttributes.add(moAttFraccionArancelaria);
        mvAttributes.add(moAttUUIDComercioExt);
        
        maEltCantidadTransportas = new ArrayList<>();
        maEltDocumentacionAduaneras = null;
    }
    
    public void setEltDocumentacionAduaneras(ArrayList<DElementDocumentacionAduanera> array) { maEltDocumentacionAduaneras = array; }
    
    public DAttributeString getAttBienesTransp() { return moAttBienesTransp; }
    public DAttributeString getAttClaveSTCC() { return moAttClaveSTCC; }
    public DAttributeString getAttDescripcion() { return moAttDescripcion; }
    public DAttributeDouble getAttCantidad() { return moAttCantidad; }
    public DAttributeString getAttClaveUnidad() { return moAttClaveUnidad; }
    public DAttributeString getAttUnidad() { return moAttUnidad; }
    public DAttributeString getAttDimensiones() { return moAttDimensiones; }
    public DAttributeString getAttMaterialPeligroso() { return moAttMaterialPeligroso; }
    public DAttributeString getAttCveMaterialPeligroso() { return moAttCveMaterialPeligroso; }
    public DAttributeString getAttEmbalaje() { return moAttEmbalaje; }
    public DAttributeString getAttDescripEmbalaje() { return moAttDescripEmbalaje; }
    public DAttributeString getAttSectorCOFEPRIS() { return moAttSectorCOFEPRIS; }
    public DAttributeDouble getAttPesoEnKg() { return moAttPesoEnKg; }
    public DAttributeTypeImporte getAttValorMercancia() { return moAttValorMercancia; }
    public DAttributeString getAttMoneda() { return moAttMoneda; }
    public DAttributeString getAttFraccionArancelaria() { return moAttFraccionArancelaria; }
    public DAttributeString getAttUUIDComercioExt() { return moAttUUIDComercioExt; }
    
    public ArrayList<DElementCantidadTransporta> getEltCantidadTransportas() { return maEltCantidadTransportas; }
    public ArrayList<DElementDocumentacionAduanera> getEltDocumentacionAduaneras() { return maEltDocumentacionAduaneras; }
    
    @Override
    public void validateElement() throws IllegalStateException, Exception {
        super.validateElement(); // validates attributes, if any

        // validate child elements:
        
        if (maEltCantidadTransportas.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new DElementCantidadTransporta().getName()) + "'.");
        }
        
    }
    
    @Override
    public java.lang.String getElementForXml() throws Exception {
        validateElement();
        
        String xml = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            String aux = attribute.getAttributeForXml();
            xml += aux.isEmpty() ? "" : " " + aux;
        }

        xml += ">";
        
        for (DElementCantidadTransporta element : maEltCantidadTransportas) {
            String aux = element.getElementForXml();
            xml += aux.isEmpty() ? "" : "\n" + aux;
        }
        
        if (maEltDocumentacionAduaneras != null) {
            for (DElementDocumentacionAduanera element : maEltDocumentacionAduaneras) {
                String aux = element.getElementForXml();
                xml += aux.isEmpty() ? "" : "\n" + aux;
            }
        }
        
        xml += "\n</" + msName + ">";

        return xml;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        String string = super.getElementForOriginalString(); // for element attributes and element validation

        for (DElementCantidadTransporta element : maEltCantidadTransportas) {
            string += element.getElementForOriginalString();
        }

        if (maEltDocumentacionAduaneras != null) {
            for (DElementDocumentacionAduanera element : maEltDocumentacionAduaneras) {
                string += element.getElementForOriginalString();
            }
        }
        
        return string;
    }
}
